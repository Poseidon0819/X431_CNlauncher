package com.itextpdf.text.pdf;

import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.util.ArrayList;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class BidiLine {
    protected static final IntHashtable mirrorChars;
    protected int arabicOptions;
    protected ArrayList<PdfChunk> chunks;
    protected int currentChar;
    protected PdfChunk[] detailChunks;
    protected int[] indexChars;
    protected int indexChunk;
    protected int indexChunkChar;
    protected byte[] orderLevels;
    protected int pieceSize;
    protected int runDirection;
    protected boolean shortStore;
    protected int storedCurrentChar;
    protected PdfChunk[] storedDetailChunks;
    protected int[] storedIndexChars;
    protected int storedIndexChunk;
    protected int storedIndexChunkChar;
    protected byte[] storedOrderLevels;
    protected int storedRunDirection;
    protected char[] storedText;
    protected int storedTotalTextLength;
    protected char[] text;
    protected int totalTextLength;

    public static boolean isWS(char c) {
        return c <= ' ';
    }

    static {
        IntHashtable intHashtable = new IntHashtable();
        mirrorChars = intHashtable;
        intHashtable.put(40, 41);
        mirrorChars.put(41, 40);
        mirrorChars.put(60, 62);
        mirrorChars.put(62, 60);
        mirrorChars.put(91, 93);
        mirrorChars.put(93, 91);
        mirrorChars.put(123, 125);
        mirrorChars.put(125, 123);
        mirrorChars.put(Opcodes.LOOKUPSWITCH, Opcodes.NEW);
        mirrorChars.put(Opcodes.NEW, Opcodes.LOOKUPSWITCH);
        mirrorChars.put(8249, 8250);
        mirrorChars.put(8250, 8249);
        mirrorChars.put(8261, 8262);
        mirrorChars.put(8262, 8261);
        mirrorChars.put(8317, 8318);
        mirrorChars.put(8318, 8317);
        mirrorChars.put(8333, 8334);
        mirrorChars.put(8334, 8333);
        mirrorChars.put(8712, 8715);
        mirrorChars.put(8713, 8716);
        mirrorChars.put(8714, 8717);
        mirrorChars.put(8715, 8712);
        mirrorChars.put(8716, 8713);
        mirrorChars.put(8717, 8714);
        mirrorChars.put(8725, 10741);
        mirrorChars.put(8764, 8765);
        mirrorChars.put(8765, 8764);
        mirrorChars.put(8771, 8909);
        mirrorChars.put(8786, 8787);
        mirrorChars.put(8787, 8786);
        mirrorChars.put(8788, 8789);
        mirrorChars.put(8789, 8788);
        mirrorChars.put(8804, 8805);
        mirrorChars.put(8805, 8804);
        mirrorChars.put(8806, 8807);
        mirrorChars.put(8807, 8806);
        mirrorChars.put(8808, 8809);
        mirrorChars.put(8809, 8808);
        mirrorChars.put(8810, 8811);
        mirrorChars.put(8811, 8810);
        mirrorChars.put(8814, 8815);
        mirrorChars.put(8815, 8814);
        mirrorChars.put(8816, 8817);
        mirrorChars.put(8817, 8816);
        mirrorChars.put(8818, 8819);
        mirrorChars.put(8819, 8818);
        mirrorChars.put(8820, 8821);
        mirrorChars.put(8821, 8820);
        mirrorChars.put(8822, 8823);
        mirrorChars.put(8823, 8822);
        mirrorChars.put(8824, 8825);
        mirrorChars.put(8825, 8824);
        mirrorChars.put(8826, 8827);
        mirrorChars.put(8827, 8826);
        mirrorChars.put(8828, 8829);
        mirrorChars.put(8829, 8828);
        mirrorChars.put(8830, 8831);
        mirrorChars.put(8831, 8830);
        mirrorChars.put(8832, 8833);
        mirrorChars.put(8833, 8832);
        mirrorChars.put(8834, 8835);
        mirrorChars.put(8835, 8834);
        mirrorChars.put(8836, 8837);
        mirrorChars.put(8837, 8836);
        mirrorChars.put(8838, 8839);
        mirrorChars.put(8839, 8838);
        mirrorChars.put(8840, 8841);
        mirrorChars.put(8841, 8840);
        mirrorChars.put(8842, 8843);
        mirrorChars.put(8843, 8842);
        mirrorChars.put(8847, 8848);
        mirrorChars.put(8848, 8847);
        mirrorChars.put(8849, 8850);
        mirrorChars.put(8850, 8849);
        mirrorChars.put(8856, 10680);
        mirrorChars.put(8866, 8867);
        mirrorChars.put(8867, 8866);
        mirrorChars.put(8870, 10974);
        mirrorChars.put(8872, 10980);
        mirrorChars.put(8873, 10979);
        mirrorChars.put(8875, 10981);
        mirrorChars.put(8880, 8881);
        mirrorChars.put(8881, 8880);
        mirrorChars.put(8882, 8883);
        mirrorChars.put(8883, 8882);
        mirrorChars.put(8884, 8885);
        mirrorChars.put(8885, 8884);
        mirrorChars.put(8886, 8887);
        mirrorChars.put(8887, 8886);
        mirrorChars.put(8905, 8906);
        mirrorChars.put(8906, 8905);
        mirrorChars.put(8907, 8908);
        mirrorChars.put(8908, 8907);
        mirrorChars.put(8909, 8771);
        mirrorChars.put(8912, 8913);
        mirrorChars.put(8913, 8912);
        mirrorChars.put(8918, 8919);
        mirrorChars.put(8919, 8918);
        mirrorChars.put(8920, 8921);
        mirrorChars.put(8921, 8920);
        mirrorChars.put(8922, 8923);
        mirrorChars.put(8923, 8922);
        mirrorChars.put(8924, 8925);
        mirrorChars.put(8925, 8924);
        mirrorChars.put(8926, 8927);
        mirrorChars.put(8927, 8926);
        mirrorChars.put(8928, 8929);
        mirrorChars.put(8929, 8928);
        mirrorChars.put(8930, 8931);
        mirrorChars.put(8931, 8930);
        mirrorChars.put(8932, 8933);
        mirrorChars.put(8933, 8932);
        mirrorChars.put(8934, 8935);
        mirrorChars.put(8935, 8934);
        mirrorChars.put(8936, 8937);
        mirrorChars.put(8937, 8936);
        mirrorChars.put(8938, 8939);
        mirrorChars.put(8939, 8938);
        mirrorChars.put(8940, 8941);
        mirrorChars.put(8941, 8940);
        mirrorChars.put(8944, 8945);
        mirrorChars.put(8945, 8944);
        mirrorChars.put(8946, 8954);
        mirrorChars.put(8947, 8955);
        mirrorChars.put(8948, 8956);
        mirrorChars.put(8950, 8957);
        mirrorChars.put(8951, 8958);
        mirrorChars.put(8954, 8946);
        mirrorChars.put(8955, 8947);
        mirrorChars.put(8956, 8948);
        mirrorChars.put(8957, 8950);
        mirrorChars.put(8958, 8951);
        mirrorChars.put(8968, 8969);
        mirrorChars.put(8969, 8968);
        mirrorChars.put(8970, 8971);
        mirrorChars.put(8971, 8970);
        mirrorChars.put(UIMsg.m_AppUI.MSG_CLICK_ITEM, 9002);
        mirrorChars.put(9002, UIMsg.m_AppUI.MSG_CLICK_ITEM);
        mirrorChars.put(10088, 10089);
        mirrorChars.put(10089, 10088);
        mirrorChars.put(10090, 10091);
        mirrorChars.put(10091, 10090);
        mirrorChars.put(10092, 10093);
        mirrorChars.put(10093, 10092);
        mirrorChars.put(10094, 10095);
        mirrorChars.put(10095, 10094);
        mirrorChars.put(10096, 10097);
        mirrorChars.put(10097, 10096);
        mirrorChars.put(10098, 10099);
        mirrorChars.put(10099, 10098);
        mirrorChars.put(10100, 10101);
        mirrorChars.put(10101, 10100);
        mirrorChars.put(10197, 10198);
        mirrorChars.put(10198, 10197);
        mirrorChars.put(10205, 10206);
        mirrorChars.put(10206, 10205);
        mirrorChars.put(10210, 10211);
        mirrorChars.put(10211, 10210);
        mirrorChars.put(10212, 10213);
        mirrorChars.put(10213, 10212);
        mirrorChars.put(10214, 10215);
        mirrorChars.put(10215, 10214);
        mirrorChars.put(10216, 10217);
        mirrorChars.put(10217, 10216);
        mirrorChars.put(10218, 10219);
        mirrorChars.put(10219, 10218);
        mirrorChars.put(10627, 10628);
        mirrorChars.put(10628, 10627);
        mirrorChars.put(10629, 10630);
        mirrorChars.put(10630, 10629);
        mirrorChars.put(10631, 10632);
        mirrorChars.put(10632, 10631);
        mirrorChars.put(10633, 10634);
        mirrorChars.put(10634, 10633);
        mirrorChars.put(10635, 10636);
        mirrorChars.put(10636, 10635);
        mirrorChars.put(10637, 10640);
        mirrorChars.put(10638, 10639);
        mirrorChars.put(10639, 10638);
        mirrorChars.put(10640, 10637);
        mirrorChars.put(10641, 10642);
        mirrorChars.put(10642, 10641);
        mirrorChars.put(10643, 10644);
        mirrorChars.put(10644, 10643);
        mirrorChars.put(10645, 10646);
        mirrorChars.put(10646, 10645);
        mirrorChars.put(10647, 10648);
        mirrorChars.put(10648, 10647);
        mirrorChars.put(10680, 8856);
        mirrorChars.put(10688, 10689);
        mirrorChars.put(10689, 10688);
        mirrorChars.put(10692, 10693);
        mirrorChars.put(10693, 10692);
        mirrorChars.put(10703, 10704);
        mirrorChars.put(10704, 10703);
        mirrorChars.put(10705, 10706);
        mirrorChars.put(10706, 10705);
        mirrorChars.put(10708, 10709);
        mirrorChars.put(10709, 10708);
        mirrorChars.put(10712, 10713);
        mirrorChars.put(10713, 10712);
        mirrorChars.put(10714, 10715);
        mirrorChars.put(10715, 10714);
        mirrorChars.put(10741, 8725);
        mirrorChars.put(10744, 10745);
        mirrorChars.put(10745, 10744);
        mirrorChars.put(10748, 10749);
        mirrorChars.put(10749, 10748);
        mirrorChars.put(10795, 10796);
        mirrorChars.put(10796, 10795);
        mirrorChars.put(10797, 10796);
        mirrorChars.put(10798, 10797);
        mirrorChars.put(10804, 10805);
        mirrorChars.put(10805, 10804);
        mirrorChars.put(10812, 10813);
        mirrorChars.put(10813, 10812);
        mirrorChars.put(10852, 10853);
        mirrorChars.put(10853, 10852);
        mirrorChars.put(10873, 10874);
        mirrorChars.put(10874, 10873);
        mirrorChars.put(10877, 10878);
        mirrorChars.put(10878, 10877);
        mirrorChars.put(10879, 10880);
        mirrorChars.put(10880, 10879);
        mirrorChars.put(10881, 10882);
        mirrorChars.put(10882, 10881);
        mirrorChars.put(10883, 10884);
        mirrorChars.put(10884, 10883);
        mirrorChars.put(10891, 10892);
        mirrorChars.put(10892, 10891);
        mirrorChars.put(10897, 10898);
        mirrorChars.put(10898, 10897);
        mirrorChars.put(10899, 10900);
        mirrorChars.put(10900, 10899);
        mirrorChars.put(10901, 10902);
        mirrorChars.put(10902, 10901);
        mirrorChars.put(10903, 10904);
        mirrorChars.put(10904, 10903);
        mirrorChars.put(10905, 10906);
        mirrorChars.put(10906, 10905);
        mirrorChars.put(10907, 10908);
        mirrorChars.put(10908, 10907);
        mirrorChars.put(10913, 10914);
        mirrorChars.put(10914, 10913);
        mirrorChars.put(10918, 10919);
        mirrorChars.put(10919, 10918);
        mirrorChars.put(10920, 10921);
        mirrorChars.put(10921, 10920);
        mirrorChars.put(10922, 10923);
        mirrorChars.put(10923, 10922);
        mirrorChars.put(10924, 10925);
        mirrorChars.put(10925, 10924);
        mirrorChars.put(10927, 10928);
        mirrorChars.put(10928, 10927);
        mirrorChars.put(10931, 10932);
        mirrorChars.put(10932, 10931);
        mirrorChars.put(10939, 10940);
        mirrorChars.put(10940, 10939);
        mirrorChars.put(10941, 10942);
        mirrorChars.put(10942, 10941);
        mirrorChars.put(10943, 10944);
        mirrorChars.put(10944, 10943);
        mirrorChars.put(10945, 10946);
        mirrorChars.put(10946, 10945);
        mirrorChars.put(10947, 10948);
        mirrorChars.put(10948, 10947);
        mirrorChars.put(10949, 10950);
        mirrorChars.put(10950, 10949);
        mirrorChars.put(10957, 10958);
        mirrorChars.put(10958, 10957);
        mirrorChars.put(10959, 10960);
        mirrorChars.put(10960, 10959);
        mirrorChars.put(10961, 10962);
        mirrorChars.put(10962, 10961);
        mirrorChars.put(10963, 10964);
        mirrorChars.put(10964, 10963);
        mirrorChars.put(10965, 10966);
        mirrorChars.put(10966, 10965);
        mirrorChars.put(10974, 8870);
        mirrorChars.put(10979, 8873);
        mirrorChars.put(10980, 8872);
        mirrorChars.put(10981, 8875);
        mirrorChars.put(10988, 10989);
        mirrorChars.put(10989, 10988);
        mirrorChars.put(10999, 11000);
        mirrorChars.put(11000, 10999);
        mirrorChars.put(11001, 11002);
        mirrorChars.put(11002, 11001);
        mirrorChars.put(12296, 12297);
        mirrorChars.put(12297, 12296);
        mirrorChars.put(12298, 12299);
        mirrorChars.put(12299, 12298);
        mirrorChars.put(12300, 12301);
        mirrorChars.put(12301, 12300);
        mirrorChars.put(12302, 12303);
        mirrorChars.put(12303, 12302);
        mirrorChars.put(12304, 12305);
        mirrorChars.put(12305, 12304);
        mirrorChars.put(12308, 12309);
        mirrorChars.put(12309, 12308);
        mirrorChars.put(12310, 12311);
        mirrorChars.put(12311, 12310);
        mirrorChars.put(12312, 12313);
        mirrorChars.put(12313, 12312);
        mirrorChars.put(12314, 12315);
        mirrorChars.put(12315, 12314);
        mirrorChars.put(UIMsg.m_AppUI.V_WM_HOTKEY, UIMsg.m_AppUI.V_WM_VDATAENGINE);
        mirrorChars.put(UIMsg.m_AppUI.V_WM_VDATAENGINE, UIMsg.m_AppUI.V_WM_HOTKEY);
        mirrorChars.put(65308, 65310);
        mirrorChars.put(65310, 65308);
        mirrorChars.put(65339, 65341);
        mirrorChars.put(65341, 65339);
        mirrorChars.put(65371, 65373);
        mirrorChars.put(65373, 65371);
        mirrorChars.put(65375, 65376);
        mirrorChars.put(65376, 65375);
        mirrorChars.put(65378, 65379);
        mirrorChars.put(65379, 65378);
    }

    public BidiLine() {
        this.pieceSize = 256;
        int i = this.pieceSize;
        this.text = new char[i];
        this.detailChunks = new PdfChunk[i];
        this.totalTextLength = 0;
        this.orderLevels = new byte[i];
        this.indexChars = new int[i];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
    }

    public BidiLine(BidiLine bidiLine) {
        this.pieceSize = 256;
        int i = this.pieceSize;
        this.text = new char[i];
        this.detailChunks = new PdfChunk[i];
        this.totalTextLength = 0;
        this.orderLevels = new byte[i];
        this.indexChars = new int[i];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
        this.runDirection = bidiLine.runDirection;
        this.pieceSize = bidiLine.pieceSize;
        this.text = (char[]) bidiLine.text.clone();
        this.detailChunks = (PdfChunk[]) bidiLine.detailChunks.clone();
        this.totalTextLength = bidiLine.totalTextLength;
        this.orderLevels = (byte[]) bidiLine.orderLevels.clone();
        this.indexChars = (int[]) bidiLine.indexChars.clone();
        this.chunks = new ArrayList<>(bidiLine.chunks);
        this.indexChunk = bidiLine.indexChunk;
        this.indexChunkChar = bidiLine.indexChunkChar;
        this.currentChar = bidiLine.currentChar;
        this.storedRunDirection = bidiLine.storedRunDirection;
        this.storedText = (char[]) bidiLine.storedText.clone();
        this.storedDetailChunks = (PdfChunk[]) bidiLine.storedDetailChunks.clone();
        this.storedTotalTextLength = bidiLine.storedTotalTextLength;
        this.storedOrderLevels = (byte[]) bidiLine.storedOrderLevels.clone();
        this.storedIndexChars = (int[]) bidiLine.storedIndexChars.clone();
        this.storedIndexChunk = bidiLine.storedIndexChunk;
        this.storedIndexChunkChar = bidiLine.storedIndexChunkChar;
        this.storedCurrentChar = bidiLine.storedCurrentChar;
        this.shortStore = bidiLine.shortStore;
        this.arabicOptions = bidiLine.arabicOptions;
    }

    public boolean isEmpty() {
        return this.currentChar >= this.totalTextLength && this.indexChunk >= this.chunks.size();
    }

    public void clearChunks() {
        this.chunks.clear();
        this.totalTextLength = 0;
        this.currentChar = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (r8 != '\r') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        r1 = r11.indexChunkChar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        if ((r1 + 1) >= r6) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
        if (r5.charAt(r1 + 1) != '\n') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        r11.indexChunkChar++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        r11.indexChunkChar++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r11.indexChunkChar < r6) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        r11.indexChunkChar = 0;
        r11.indexChunk++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r11.totalTextLength != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        r11.detailChunks[0] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getParagraph(int r12) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.getParagraph(int):boolean");
    }

    public void addChunk(PdfChunk pdfChunk) {
        this.chunks.add(pdfChunk);
    }

    public void addChunks(ArrayList<PdfChunk> arrayList) {
        this.chunks.addAll(arrayList);
    }

    public void addPiece(char c, PdfChunk pdfChunk) {
        int i = this.totalTextLength;
        int i2 = this.pieceSize;
        if (i >= i2) {
            char[] cArr = this.text;
            PdfChunk[] pdfChunkArr = this.detailChunks;
            this.pieceSize = i2 * 2;
            int i3 = this.pieceSize;
            this.text = new char[i3];
            this.detailChunks = new PdfChunk[i3];
            System.arraycopy(cArr, 0, this.text, 0, i);
            System.arraycopy(pdfChunkArr, 0, this.detailChunks, 0, this.totalTextLength);
        }
        char[] cArr2 = this.text;
        int i4 = this.totalTextLength;
        cArr2[i4] = c;
        PdfChunk[] pdfChunkArr2 = this.detailChunks;
        this.totalTextLength = i4 + 1;
        pdfChunkArr2[i4] = pdfChunk;
    }

    public void save() {
        int i = this.indexChunk;
        if (i > 0) {
            if (i < this.chunks.size()) {
                while (true) {
                    this.indexChunk--;
                    int i2 = this.indexChunk;
                    if (i2 < 0) {
                        break;
                    }
                    this.chunks.remove(i2);
                }
            } else {
                this.chunks.clear();
            }
            this.indexChunk = 0;
        }
        this.storedRunDirection = this.runDirection;
        int i3 = this.totalTextLength;
        this.storedTotalTextLength = i3;
        this.storedIndexChunk = this.indexChunk;
        this.storedIndexChunkChar = this.indexChunkChar;
        int i4 = this.currentChar;
        this.storedCurrentChar = i4;
        this.shortStore = i4 < i3;
        if (!this.shortStore) {
            int length = this.storedText.length;
            int i5 = this.totalTextLength;
            if (length < i5) {
                this.storedText = new char[i5];
                this.storedDetailChunks = new PdfChunk[i5];
            }
            System.arraycopy(this.text, 0, this.storedText, 0, this.totalTextLength);
            System.arraycopy(this.detailChunks, 0, this.storedDetailChunks, 0, this.totalTextLength);
        }
        int i6 = this.runDirection;
        if (i6 == 2 || i6 == 3) {
            int length2 = this.storedOrderLevels.length;
            int i7 = this.totalTextLength;
            if (length2 < i7) {
                this.storedOrderLevels = new byte[i7];
                this.storedIndexChars = new int[i7];
            }
            byte[] bArr = this.orderLevels;
            int i8 = this.currentChar;
            System.arraycopy(bArr, i8, this.storedOrderLevels, i8, this.totalTextLength - i8);
            int[] iArr = this.indexChars;
            int i9 = this.currentChar;
            System.arraycopy(iArr, i9, this.storedIndexChars, i9, this.totalTextLength - i9);
        }
    }

    public void restore() {
        this.runDirection = this.storedRunDirection;
        this.totalTextLength = this.storedTotalTextLength;
        this.indexChunk = this.storedIndexChunk;
        this.indexChunkChar = this.storedIndexChunkChar;
        this.currentChar = this.storedCurrentChar;
        if (!this.shortStore) {
            System.arraycopy(this.storedText, 0, this.text, 0, this.totalTextLength);
            System.arraycopy(this.storedDetailChunks, 0, this.detailChunks, 0, this.totalTextLength);
        }
        int i = this.runDirection;
        if (i == 2 || i == 3) {
            byte[] bArr = this.storedOrderLevels;
            int i2 = this.currentChar;
            System.arraycopy(bArr, i2, this.orderLevels, i2, this.totalTextLength - i2);
            int[] iArr = this.storedIndexChars;
            int i3 = this.currentChar;
            System.arraycopy(iArr, i3, this.indexChars, i3, this.totalTextLength - i3);
        }
    }

    public void mirrorGlyphs() {
        int i;
        for (int i2 = 0; i2 < this.totalTextLength; i2++) {
            if ((this.orderLevels[i2] & 1) == 1 && (i = mirrorChars.get(this.text[i2])) != 0) {
                this.text[i2] = (char) i;
            }
        }
    }

    public void doArabicShapping() {
        char c;
        char c2;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i < this.totalTextLength && ((c2 = this.text[i]) < 1536 || c2 > 1791)) {
                if (i != i2) {
                    char[] cArr = this.text;
                    cArr[i2] = cArr[i];
                    PdfChunk[] pdfChunkArr = this.detailChunks;
                    pdfChunkArr[i2] = pdfChunkArr[i];
                    byte[] bArr = this.orderLevels;
                    bArr[i2] = bArr[i];
                }
                i++;
                i2++;
            } else if (i >= this.totalTextLength) {
                this.totalTextLength = i2;
                return;
            } else {
                int i3 = i + 1;
                while (i3 < this.totalTextLength && (c = this.text[i3]) >= 1536 && c <= 1791) {
                    i3++;
                }
                int i4 = i3 - i;
                char[] cArr2 = this.text;
                int arabic_shape = ArabicLigaturizer.arabic_shape(cArr2, i, i4, cArr2, i2, i4, this.arabicOptions);
                if (i != i2) {
                    int i5 = 0;
                    while (i5 < arabic_shape) {
                        PdfChunk[] pdfChunkArr2 = this.detailChunks;
                        pdfChunkArr2[i2] = pdfChunkArr2[i];
                        byte[] bArr2 = this.orderLevels;
                        bArr2[i2] = bArr2[i];
                        i5++;
                        i2++;
                        i++;
                    }
                    i = i3;
                } else {
                    i2 += arabic_shape;
                    i = i3;
                }
            }
        }
    }

    public PdfLine processLine(float f, float f2, int i, int i2, int i3, float f3, float f4, float f5) {
        int i4;
        int unicodeEquivalent;
        float charWidth;
        this.arabicOptions = i3;
        save();
        boolean z = i2 == 3;
        PdfChunk pdfChunk = null;
        if (this.currentChar >= this.totalTextLength) {
            if (!getParagraph(i2)) {
                return null;
            }
            if (this.totalTextLength == 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new PdfChunk("", this.detailChunks[0]));
                return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, i, true, arrayList, z);
            }
        }
        int i5 = this.currentChar;
        if (i5 != 0) {
            this.currentChar = trimLeftEx(i5, this.totalTextLength - 1);
        }
        int i6 = this.currentChar;
        float f6 = f2;
        boolean z2 = false;
        int i7 = -1;
        while (true) {
            int i8 = this.currentChar;
            if (i8 >= this.totalTextLength) {
                break;
            }
            PdfChunk pdfChunk2 = this.detailChunks[i8];
            if (pdfChunk2.isImage() && f3 < f4) {
                Image image = pdfChunk2.getImage();
                if (image.isScaleToFitLineWhenOverflow()) {
                    float f7 = f4 + (2.0f * f5);
                    if (((f7 - image.getScaledHeight()) - pdfChunk2.getImageOffsetY()) - image.getSpacingBefore() < f3) {
                        image.scalePercent(((((f7 - pdfChunk2.getImageOffsetY()) - image.getSpacingBefore()) - f3) / image.getHeight()) * 100.0f);
                    }
                }
            }
            boolean isSurrogatePair = Utilities.isSurrogatePair(this.text, this.currentChar);
            if (isSurrogatePair) {
                unicodeEquivalent = pdfChunk2.getUnicodeEquivalent(Utilities.convertToUtf32(this.text, this.currentChar));
            } else {
                unicodeEquivalent = pdfChunk2.getUnicodeEquivalent(this.text[this.currentChar]);
            }
            if (!PdfChunk.noPrint(unicodeEquivalent)) {
                if (isSurrogatePair) {
                    charWidth = pdfChunk2.getCharWidth(unicodeEquivalent);
                } else {
                    charWidth = pdfChunk2.getCharWidth(this.text[this.currentChar]);
                }
                boolean isExtSplitCharacter = pdfChunk2.isExtSplitCharacter(i6, this.currentChar, this.totalTextLength, this.text, this.detailChunks);
                if (isExtSplitCharacter && Character.isWhitespace((char) unicodeEquivalent)) {
                    i7 = this.currentChar;
                }
                float f8 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                if (f6 - charWidth < ColumnText.GLOBAL_SPACE_CHAR_RATIO && pdfChunk == null && pdfChunk2.isImage()) {
                    Image image2 = pdfChunk2.getImage();
                    if (image2.isScaleToFitLineWhenOverflow()) {
                        image2.scalePercent((f6 / image2.getWidth()) * 100.0f);
                        charWidth = f6;
                    }
                }
                float f9 = f6 - charWidth;
                if (f9 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    z2 = isSurrogatePair;
                    break;
                }
                if (isExtSplitCharacter) {
                    i7 = this.currentChar;
                }
                if (pdfChunk2.isTab()) {
                    Object[] objArr = (Object[]) pdfChunk2.getAttribute(Chunk.TAB);
                    float floatValue = ((Float) objArr[1]).floatValue();
                    if (((Boolean) objArr[2]).booleanValue() && floatValue < f2 - f9) {
                        return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, f9, i, true, createArrayOfPdfChunks(i6, this.currentChar - 1), z);
                    }
                    this.detailChunks[this.currentChar].adjustLeft(f);
                    f8 = f2 - floatValue;
                } else {
                    if (pdfChunk2.isSeparator()) {
                        Object[] objArr2 = (Object[]) pdfChunk2.getAttribute(Chunk.SEPARATOR);
                        DrawInterface drawInterface = (DrawInterface) objArr2[0];
                        if (((Boolean) objArr2[1]).booleanValue() && (drawInterface instanceof LineSeparator)) {
                            float percentage = f9 - ((((LineSeparator) drawInterface).getPercentage() * f2) / 100.0f);
                            if (percentage >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                                f8 = percentage;
                            }
                        }
                    }
                    f8 = f9;
                }
                if (isSurrogatePair) {
                    this.currentChar++;
                }
                pdfChunk = pdfChunk2;
                f6 = f8;
            }
            this.currentChar++;
            z2 = isSurrogatePair;
        }
        if (pdfChunk == null) {
            this.currentChar++;
            if (z2) {
                this.currentChar++;
            }
            int i9 = this.currentChar;
            return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, i, false, createArrayOfPdfChunks(i9 - 1, i9 - 1), z);
        }
        int i10 = this.currentChar;
        int i11 = this.totalTextLength;
        if (i10 >= i11) {
            return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, f6, i, true, createArrayOfPdfChunks(i6, i11 - 1), z);
        }
        int trimRightEx = trimRightEx(i6, i10 - 1);
        if (trimRightEx < i6) {
            return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, f6, i, false, createArrayOfPdfChunks(i6, this.currentChar - 1), z);
        }
        if (trimRightEx == this.currentChar - 1) {
            HyphenationEvent hyphenationEvent = (HyphenationEvent) pdfChunk.getAttribute(Chunk.HYPHENATION);
            if (hyphenationEvent != null) {
                int[] word = getWord(i6, trimRightEx);
                if (word != null) {
                    float width = getWidth(word[0], this.currentChar - 1) + f6;
                    String hyphenatedWordPre = hyphenationEvent.getHyphenatedWordPre(new String(this.text, word[0], word[1] - word[0]), pdfChunk.font().getFont(), pdfChunk.font().size(), width);
                    String hyphenatedWordPost = hyphenationEvent.getHyphenatedWordPost();
                    if (hyphenatedWordPre.length() > 0) {
                        PdfChunk pdfChunk3 = new PdfChunk(hyphenatedWordPre, pdfChunk);
                        this.currentChar = word[1] - hyphenatedWordPost.length();
                        return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, width - pdfChunk.font().width(hyphenatedWordPre), i, false, createArrayOfPdfChunks(i6, word[0] - 1, pdfChunk3), z);
                    }
                    i4 = -1;
                } else {
                    i4 = -1;
                }
            } else {
                i4 = -1;
            }
        } else {
            i4 = -1;
        }
        if (i7 == i4 || i7 >= trimRightEx) {
            return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, f6 + getWidth(trimRightEx + 1, this.currentChar - 1), i, false, createArrayOfPdfChunks(i6, trimRightEx), z);
        }
        this.currentChar = i7 + 1;
        int trimRightEx2 = trimRightEx(i6, i7);
        if (trimRightEx2 < i6) {
            trimRightEx2 = this.currentChar - 1;
        }
        return new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2, f2 - getWidth(i6, trimRightEx2), i, false, createArrayOfPdfChunks(i6, trimRightEx2), z);
    }

    public float getWidth(int i, int i2) {
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        while (i <= i2) {
            if (Utilities.isSurrogatePair(this.text, i)) {
                f += this.detailChunks[i].getCharWidth(Utilities.convertToUtf32(this.text, i));
                i++;
            } else {
                char c = this.text[i];
                if (!PdfChunk.noPrint(this.detailChunks[i].getUnicodeEquivalent(c))) {
                    f += this.detailChunks[i].getCharWidth(c);
                }
            }
            i++;
        }
        return f;
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2) {
        return createArrayOfPdfChunks(i, i2, null);
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2, PdfChunk pdfChunk) {
        int i3 = this.runDirection;
        boolean z = i3 == 2 || i3 == 3;
        if (z) {
            reorder(i, i2);
        }
        ArrayList<PdfChunk> arrayList = new ArrayList<>();
        PdfChunk pdfChunk2 = this.detailChunks[i];
        StringBuffer stringBuffer = new StringBuffer();
        while (i <= i2) {
            int i4 = z ? this.indexChars[i] : i;
            char c = this.text[i4];
            PdfChunk pdfChunk3 = this.detailChunks[i4];
            if (!PdfChunk.noPrint(pdfChunk3.getUnicodeEquivalent(c))) {
                if (pdfChunk3.isImage() || pdfChunk3.isSeparator() || pdfChunk3.isTab()) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    arrayList.add(pdfChunk3);
                } else if (pdfChunk3 == pdfChunk2) {
                    stringBuffer.append(c);
                } else {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    if (!pdfChunk3.isImage() && !pdfChunk3.isSeparator() && !pdfChunk3.isTab()) {
                        stringBuffer.append(c);
                    }
                    pdfChunk2 = pdfChunk3;
                }
            }
            i++;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
        }
        if (pdfChunk != null) {
            arrayList.add(pdfChunk);
        }
        return arrayList;
    }

    public int[] getWord(int i, int i2) {
        int i3 = i2;
        while (i3 < this.totalTextLength && Character.isLetter(this.text[i3])) {
            i3++;
        }
        if (i3 == i2) {
            return null;
        }
        while (i2 >= i && Character.isLetter(this.text[i2])) {
            i2--;
        }
        return new int[]{i2 + 1, i3};
    }

    public int trimRight(int i, int i2) {
        while (i2 >= i && isWS((char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]))) {
            i2--;
        }
        return i2;
    }

    public int trimLeft(int i, int i2) {
        while (i <= i2 && isWS((char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]))) {
            i++;
        }
        return i;
    }

    public int trimRightEx(int i, int i2) {
        while (i2 >= i) {
            char unicodeEquivalent = (char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent)) {
                break;
            }
            i2--;
        }
        return i2;
    }

    public int trimLeftEx(int i, int i2) {
        while (i <= i2) {
            char unicodeEquivalent = (char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent)) {
                break;
            }
            i++;
        }
        return i;
    }

    public void reorder(int i, int i2) {
        byte b = this.orderLevels[i];
        byte b2 = b;
        byte b3 = b2;
        byte b4 = b3;
        for (int i3 = i + 1; i3 <= i2; i3++) {
            byte b5 = this.orderLevels[i3];
            if (b5 > b2) {
                b2 = b5;
            } else if (b5 < b4) {
                b4 = b5;
            }
            b3 = (byte) (b3 & b5);
            b = (byte) (b | b5);
        }
        if ((b & 1) == 0) {
            return;
        }
        if ((b3 & 1) == 1) {
            flip(i, i2 + 1);
            return;
        }
        byte b6 = (byte) (b4 | 1);
        while (b2 >= b6) {
            int i4 = i;
            while (true) {
                if (i4 <= i2 && this.orderLevels[i4] < b2) {
                    i4++;
                } else if (i4 <= i2) {
                    int i5 = i4 + 1;
                    while (i5 <= i2 && this.orderLevels[i5] >= b2) {
                        i5++;
                    }
                    flip(i4, i5);
                    i4 = i5 + 1;
                }
            }
            b2 = (byte) (b2 - 1);
        }
    }

    public void flip(int i, int i2) {
        int i3 = (i + i2) / 2;
        int i4 = i2 - 1;
        while (i < i3) {
            int[] iArr = this.indexChars;
            int i5 = iArr[i];
            iArr[i] = iArr[i4];
            iArr[i4] = i5;
            i++;
            i4--;
        }
    }
}
