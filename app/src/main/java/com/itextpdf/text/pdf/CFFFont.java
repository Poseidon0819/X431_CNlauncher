package com.itextpdf.text.pdf;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.html.HtmlTags;
import com.p297e.p298a.p306b.ImageLoader;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.http.conn.ssl.TokenParser;
import org.jivesoftware.smackx.GroupChatInvitation;

/* loaded from: classes.dex */
public class CFFFont {
    static final String[] operatorNames = {"version", "Notice", "FullName", "FamilyName", "Weight", "FontBBox", "BlueValues", "OtherBlues", "FamilyBlues", "FamilyOtherBlues", "StdHW", "StdVW", "UNKNOWN_12", "UniqueID", "XUID", "charset", "Encoding", "CharStrings", "Private", "Subrs", "defaultWidthX", "nominalWidthX", "UNKNOWN_22", "UNKNOWN_23", "UNKNOWN_24", "UNKNOWN_25", "UNKNOWN_26", "UNKNOWN_27", "UNKNOWN_28", "UNKNOWN_29", "UNKNOWN_30", "UNKNOWN_31", "Copyright", "isFixedPitch", "ItalicAngle", "UnderlinePosition", "UnderlineThickness", "PaintType", "CharstringType", "FontMatrix", "StrokeWidth", "BlueScale", "BlueShift", "BlueFuzz", "StemSnapH", "StemSnapV", "ForceBold", "UNKNOWN_12_15", "UNKNOWN_12_16", "LanguageGroup", "ExpansionFactor", "initialRandomSeed", "SyntheticBase", "PostScript", "BaseFontName", "BaseFontBlend", "UNKNOWN_12_24", "UNKNOWN_12_25", "UNKNOWN_12_26", "UNKNOWN_12_27", "UNKNOWN_12_28", "UNKNOWN_12_29", "ROS", "CIDFontVersion", "CIDFontRevision", "CIDFontType", "CIDCount", "UIDBase", "FDArray", "FDSelect", "FontName"};
    static final String[] standardStrings = {BaseFont.notdef, "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "quoteleft", HtmlTags.f19618A, HtmlTags.f19619B, "c", ImageLoader.f17144a, "e", "f", "g", "h", HtmlTags.f19629I, "j", "k", PAD3DHCPForDoIP.f10141a, "m", "n", "o", HtmlTags.f19632P, "q", "r", HtmlTags.f19633S, "t", HtmlTags.f19637U, "v", "w", GroupChatInvitation.ELEMENT_NAME, "y", "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent", "sterling", "fraction", "yen", "florin", "section", "currency", "quotesingle", "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl", "endash", "dagger", "daggerdbl", "periodcentered", "paragraph", "bullet", "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright", "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex", "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash", "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe", "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf", "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn", "threequarters", "twosuperior", "registered", "minus", "eth", "multiply", "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave", "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute", "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute", "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron", "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla", "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex", "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis", "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave", "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall", "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall", "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader", "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle", "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle", "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall", "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior", "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior", "ssuperior", "tsuperior", DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, "ffi", "ffl", "parenleftinferior", "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall", "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall", "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall", "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall", "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary", "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle", "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall", "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior", "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth", "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds", "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior", "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior", "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior", "eightinferior", "nineinferior", "centinferior", "dollarinferior", "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall", "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall", "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall", "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall", "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall", "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall", "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall", "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light", "Medium", "Regular", "Roman", "Semibold"};
    protected RandomAccessFileOrArray buf;
    protected Font[] fonts;
    protected int gsubrIndexOffset;
    protected int[] gsubrOffsets;
    protected String key;
    protected int nameIndexOffset;
    protected int[] nameOffsets;
    int nextIndexOffset;
    private int offSize;
    protected int stringIndexOffset;
    protected int[] stringOffsets;
    protected int topdictIndexOffset;
    protected int[] topdictOffsets;
    protected Object[] args = new Object[48];
    protected int arg_count = 0;

    /* loaded from: classes.dex */
    protected static final class IndexBaseItem extends Item {
    }

    public String getString(char c) {
        String[] strArr = standardStrings;
        if (c < strArr.length) {
            return strArr[c];
        }
        if (c >= (strArr.length + this.stringOffsets.length) - 1) {
            return null;
        }
        int length = c - strArr.length;
        int position = getPosition();
        seek(this.stringOffsets[length]);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = this.stringOffsets[length]; i < this.stringOffsets[length + 1]; i++) {
            stringBuffer.append(getCard8());
        }
        seek(position);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getCard8() {
        try {
            return (char) (this.buf.readByte() & 255);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char getCard16() {
        try {
            return this.buf.readChar();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOffset(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 256) + getCard8();
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void seek(int i) {
        try {
            this.buf.seek(i);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    short getShort() {
        try {
            return this.buf.readShort();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    int getInt() {
        try {
            return this.buf.readInt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition() {
        try {
            return (int) this.buf.getFilePointer();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getIndex(int i) {
        seek(i);
        char card16 = getCard16();
        int i2 = card16 + 1;
        int[] iArr = new int[i2];
        if (card16 == 0) {
            iArr[0] = -1;
            return iArr;
        }
        char card8 = getCard8();
        for (int i3 = 0; i3 <= card16; i3++) {
            iArr[i3] = ((((i + 2) + 1) + (i2 * card8)) - 1) + getOffset(card8);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getDictItem() {
        for (int i = 0; i < this.arg_count; i++) {
            this.args[i] = null;
        }
        this.arg_count = 0;
        this.key = null;
        boolean z = false;
        while (!z) {
            char card8 = getCard8();
            if (card8 == 29) {
                this.args[this.arg_count] = Integer.valueOf(getInt());
                this.arg_count++;
            } else if (card8 == 28) {
                this.args[this.arg_count] = Integer.valueOf(getShort());
                this.arg_count++;
            } else if (card8 >= ' ' && card8 <= 246) {
                this.args[this.arg_count] = Integer.valueOf((byte) (card8 - 139));
                this.arg_count++;
            } else if (card8 >= 247 && card8 <= 250) {
                this.args[this.arg_count] = Integer.valueOf((short) (((card8 - 247) * 256) + getCard8() + 108));
                this.arg_count++;
            } else if (card8 >= 251 && card8 <= 254) {
                this.args[this.arg_count] = Integer.valueOf((short) ((((-(card8 - 251)) * 256) - getCard8()) - 108));
                this.arg_count++;
            } else if (card8 == 30) {
                StringBuilder sb = new StringBuilder("");
                boolean z2 = false;
                byte b = 0;
                char c = 0;
                int i2 = 0;
                while (!z2) {
                    if (b == 0) {
                        c = getCard8();
                        b = 2;
                    }
                    if (b == 1) {
                        i2 = c / 16;
                        b = (byte) (b - 1);
                    }
                    if (b == 2) {
                        i2 = c % 16;
                        b = (byte) (b - 1);
                    }
                    switch (i2) {
                        case 10:
                            sb.append(".");
                            break;
                        case 11:
                            sb.append("E");
                            break;
                        case 12:
                            sb.append("E-");
                            break;
                        case 13:
                        default:
                            if (i2 >= 0 && i2 <= 9) {
                                sb.append(String.valueOf(i2));
                                break;
                            } else {
                                sb.append("<NIBBLE ERROR: ");
                                sb.append(i2);
                                sb.append('>');
                                z2 = true;
                                break;
                            }
                            break;
                        case 14:
                            sb.append("-");
                            break;
                        case 15:
                            z2 = true;
                            break;
                    }
                }
                this.args[this.arg_count] = sb.toString();
                this.arg_count++;
            } else if (card8 <= 21) {
                if (card8 != '\f') {
                    this.key = operatorNames[card8];
                } else {
                    this.key = operatorNames[getCard8() + TokenParser.f24154SP];
                }
                z = true;
            }
        }
    }

    /* loaded from: classes.dex */
    protected static abstract class Item {
        protected int myOffset = -1;

        public void emit(byte[] bArr) {
        }

        public void xref() {
        }

        protected Item() {
        }

        public void increment(int[] iArr) {
            this.myOffset = iArr[0];
        }
    }

    /* loaded from: classes.dex */
    protected static abstract class OffsetItem extends Item {
        public int value;

        protected OffsetItem() {
        }

        public void set(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class RangeItem extends Item {
        private RandomAccessFileOrArray buf;
        public int length;
        public int offset;

        public RangeItem(RandomAccessFileOrArray randomAccessFileOrArray, int i, int i2) {
            this.offset = i;
            this.length = i2;
            this.buf = randomAccessFileOrArray;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.length;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            try {
                this.buf.seek(this.offset);
                for (int i = this.myOffset; i < this.myOffset + this.length; i++) {
                    bArr[i] = this.buf.readByte();
                }
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* loaded from: classes.dex */
    protected static final class IndexOffsetItem extends OffsetItem {
        public final int size;

        public IndexOffsetItem(int i, int i2) {
            this.size = i;
            this.value = i2;
        }

        public IndexOffsetItem(int i) {
            this.size = i;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            int i;
            int i2;
            int i3;
            switch (this.size) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i2 = 0;
                    bArr[this.myOffset + i2] = (byte) ((this.value >>> 8) & 255);
                    i = i2 + 1;
                    break;
                case 3:
                    i3 = 0;
                    bArr[this.myOffset + i3] = (byte) ((this.value >>> 16) & 255);
                    i2 = i3 + 1;
                    bArr[this.myOffset + i2] = (byte) ((this.value >>> 8) & 255);
                    i = i2 + 1;
                    break;
                case 4:
                    bArr[this.myOffset + 0] = (byte) ((this.value >>> 24) & 255);
                    i3 = 1;
                    bArr[this.myOffset + i3] = (byte) ((this.value >>> 16) & 255);
                    i2 = i3 + 1;
                    bArr[this.myOffset + i2] = (byte) ((this.value >>> 8) & 255);
                    i = i2 + 1;
                    break;
                default:
                    return;
            }
            bArr[this.myOffset + i] = (byte) ((this.value >>> 0) & 255);
        }
    }

    /* loaded from: classes.dex */
    protected static final class IndexMarkerItem extends Item {
        private IndexBaseItem indexBase;
        private OffsetItem offItem;

        public IndexMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.offItem = offsetItem;
            this.indexBase = indexBaseItem;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void xref() {
            this.offItem.set((this.myOffset - this.indexBase.myOffset) + 1);
        }
    }

    /* loaded from: classes.dex */
    protected static final class SubrMarkerItem extends Item {
        private IndexBaseItem indexBase;
        private OffsetItem offItem;

        public SubrMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.offItem = offsetItem;
            this.indexBase = indexBaseItem;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void xref() {
            this.offItem.set(this.myOffset - this.indexBase.myOffset);
        }
    }

    /* loaded from: classes.dex */
    protected static final class DictOffsetItem extends OffsetItem {
        public final int size = 5;

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            if (this.size == 5) {
                bArr[this.myOffset] = 29;
                bArr[this.myOffset + 1] = (byte) ((this.value >>> 24) & 255);
                bArr[this.myOffset + 2] = (byte) ((this.value >>> 16) & 255);
                bArr[this.myOffset + 3] = (byte) ((this.value >>> 8) & 255);
                bArr[this.myOffset + 4] = (byte) ((this.value >>> 0) & 255);
            }
        }
    }

    /* loaded from: classes.dex */
    protected static final class UInt24Item extends Item {
        public int value;

        public UInt24Item(int i) {
            this.value = i;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 3;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 16) & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 8) & 255);
            bArr[this.myOffset + 2] = (byte) ((this.value >>> 0) & 255);
        }
    }

    /* loaded from: classes.dex */
    protected static final class UInt32Item extends Item {
        public int value;

        public UInt32Item(int i) {
            this.value = i;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 4;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 24) & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 16) & 255);
            bArr[this.myOffset + 2] = (byte) ((this.value >>> 8) & 255);
            bArr[this.myOffset + 3] = (byte) ((this.value >>> 0) & 255);
        }
    }

    /* loaded from: classes.dex */
    protected static final class UInt16Item extends Item {
        public char value;

        public UInt16Item(char c) {
            this.value = c;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 2;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> '\b') & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 0) & 255);
        }
    }

    /* loaded from: classes.dex */
    protected static final class UInt8Item extends Item {
        public char value;

        public UInt8Item(char c) {
            this.value = c;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 1;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 0) & 255);
        }
    }

    /* loaded from: classes.dex */
    protected static final class StringItem extends Item {

        /* renamed from: s */
        public String f19671s;

        public StringItem(String str) {
            this.f19671s = str;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.f19671s.length();
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            for (int i = 0; i < this.f19671s.length(); i++) {
                bArr[this.myOffset + i] = (byte) (this.f19671s.charAt(i) & 255);
            }
        }
    }

    /* loaded from: classes.dex */
    protected static final class DictNumberItem extends Item {
        public int size = 5;
        public final int value;

        public DictNumberItem(int i) {
            this.value = i;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void emit(byte[] bArr) {
            if (this.size == 5) {
                bArr[this.myOffset] = 29;
                bArr[this.myOffset + 1] = (byte) ((this.value >>> 24) & 255);
                bArr[this.myOffset + 2] = (byte) ((this.value >>> 16) & 255);
                bArr[this.myOffset + 3] = (byte) ((this.value >>> 8) & 255);
                bArr[this.myOffset + 4] = (byte) ((this.value >>> 0) & 255);
            }
        }
    }

    /* loaded from: classes.dex */
    protected static final class MarkerItem extends Item {

        /* renamed from: p */
        OffsetItem f19670p;

        public MarkerItem(OffsetItem offsetItem) {
            this.f19670p = offsetItem;
        }

        @Override // com.itextpdf.text.pdf.CFFFont.Item
        public final void xref() {
            this.f19670p.set(this.myOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RangeItem getEntireIndexRange(int i) {
        seek(i);
        char card16 = getCard16();
        if (card16 == 0) {
            return new RangeItem(this.buf, i, 2);
        }
        char card8 = getCard8();
        seek(i + 2 + 1 + (card16 * card8));
        return new RangeItem(this.buf, i, ((card16 + 1) * card8) + 3 + (getOffset(card8) - 1));
    }

    public byte[] getCID(String str) {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i3 >= fontArr.length || str.equals(fontArr[i3].name)) {
                break;
            }
            i3++;
        }
        if (i3 == this.fonts.length) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        seek(0);
        getCard8();
        getCard8();
        char card8 = getCard8();
        getCard8();
        this.nextIndexOffset = card8;
        linkedList.addLast(new RangeItem(this.buf, 0, card8));
        char c = 65535;
        if (this.fonts[i3].isCID) {
            i = -1;
        } else {
            seek(this.fonts[i3].charstringsOffset);
            c = getCard16();
            seek(this.stringIndexOffset);
            i = getCard16() + standardStrings.length;
        }
        linkedList.addLast(new UInt16Item((char) 1));
        linkedList.addLast(new UInt8Item((char) 1));
        linkedList.addLast(new UInt8Item((char) 1));
        linkedList.addLast(new UInt8Item((char) (this.fonts[i3].name.length() + 1)));
        linkedList.addLast(new StringItem(this.fonts[i3].name));
        linkedList.addLast(new UInt16Item((char) 1));
        linkedList.addLast(new UInt8Item((char) 2));
        linkedList.addLast(new UInt16Item((char) 1));
        IndexOffsetItem indexOffsetItem = new IndexOffsetItem(2);
        linkedList.addLast(indexOffsetItem);
        IndexBaseItem indexBaseItem = new IndexBaseItem();
        linkedList.addLast(indexBaseItem);
        DictOffsetItem dictOffsetItem = new DictOffsetItem();
        DictOffsetItem dictOffsetItem2 = new DictOffsetItem();
        DictOffsetItem dictOffsetItem3 = new DictOffsetItem();
        DictOffsetItem dictOffsetItem4 = new DictOffsetItem();
        if (!this.fonts[i3].isCID) {
            linkedList.addLast(new DictNumberItem(i));
            linkedList.addLast(new DictNumberItem(i + 1));
            linkedList.addLast(new DictNumberItem(0));
            linkedList.addLast(new UInt8Item('\f'));
            linkedList.addLast(new UInt8Item((char) 30));
            linkedList.addLast(new DictNumberItem(c));
            linkedList.addLast(new UInt8Item('\f'));
            linkedList.addLast(new UInt8Item(TokenParser.DQUOTE));
        }
        linkedList.addLast(dictOffsetItem3);
        linkedList.addLast(new UInt8Item('\f'));
        linkedList.addLast(new UInt8Item('$'));
        linkedList.addLast(dictOffsetItem4);
        linkedList.addLast(new UInt8Item('\f'));
        linkedList.addLast(new UInt8Item('%'));
        linkedList.addLast(dictOffsetItem);
        linkedList.addLast(new UInt8Item((char) 15));
        linkedList.addLast(dictOffsetItem2);
        linkedList.addLast(new UInt8Item((char) 17));
        seek(this.topdictOffsets[i3]);
        while (getPosition() < this.topdictOffsets[i3 + 1]) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            String str2 = this.key;
            if (str2 != "Encoding" && str2 != "Private" && str2 != "FDSelect" && str2 != "FDArray" && str2 != "charset" && str2 != "CharStrings") {
                linkedList.add(new RangeItem(this.buf, position, position2 - position));
            }
        }
        linkedList.addLast(new IndexMarkerItem(indexOffsetItem, indexBaseItem));
        if (this.fonts[i3].isCID) {
            linkedList.addLast(getEntireIndexRange(this.stringIndexOffset));
        } else {
            String str3 = this.fonts[i3].name + "-OneRange";
            if (str3.length() > 127) {
                str3 = str3.substring(0, 127);
            }
            String concat = "AdobeIdentity".concat(String.valueOf(str3));
            int[] iArr = this.stringOffsets;
            int i4 = iArr[iArr.length - 1] - iArr[0];
            int i5 = iArr[0] - 1;
            if (concat.length() + i4 <= 255) {
                i2 = 1;
            } else if (concat.length() + i4 <= 65535) {
                i2 = 2;
            } else {
                i2 = concat.length() + i4 <= 16777215 ? 3 : 4;
            }
            linkedList.addLast(new UInt16Item((char) ((this.stringOffsets.length - 1) + 3)));
            linkedList.addLast(new UInt8Item((char) i2));
            int[] iArr2 = this.stringOffsets;
            int i6 = 0;
            for (int length = iArr2.length; i6 < length; length = length) {
                linkedList.addLast(new IndexOffsetItem(i2, iArr2[i6] - i5));
                i6++;
                iArr2 = iArr2;
            }
            int[] iArr3 = this.stringOffsets;
            int i7 = (iArr3[iArr3.length - 1] - i5) + 5;
            linkedList.addLast(new IndexOffsetItem(i2, i7));
            int i8 = i7 + 8;
            linkedList.addLast(new IndexOffsetItem(i2, i8));
            linkedList.addLast(new IndexOffsetItem(i2, i8 + str3.length()));
            linkedList.addLast(new RangeItem(this.buf, this.stringOffsets[0], i4));
            linkedList.addLast(new StringItem(concat));
        }
        linkedList.addLast(getEntireIndexRange(this.gsubrIndexOffset));
        if (!this.fonts[i3].isCID) {
            linkedList.addLast(new MarkerItem(dictOffsetItem4));
            linkedList.addLast(new UInt8Item((char) 3));
            linkedList.addLast(new UInt16Item((char) 1));
            linkedList.addLast(new UInt16Item((char) 0));
            linkedList.addLast(new UInt8Item((char) 0));
            linkedList.addLast(new UInt16Item(c));
            linkedList.addLast(new MarkerItem(dictOffsetItem));
            linkedList.addLast(new UInt8Item((char) 2));
            linkedList.addLast(new UInt16Item((char) 1));
            linkedList.addLast(new UInt16Item((char) (c - 1)));
            linkedList.addLast(new MarkerItem(dictOffsetItem3));
            linkedList.addLast(new UInt16Item((char) 1));
            linkedList.addLast(new UInt8Item((char) 1));
            linkedList.addLast(new UInt8Item((char) 1));
            IndexOffsetItem indexOffsetItem2 = new IndexOffsetItem(1);
            linkedList.addLast(indexOffsetItem2);
            IndexBaseItem indexBaseItem2 = new IndexBaseItem();
            linkedList.addLast(indexBaseItem2);
            linkedList.addLast(new DictNumberItem(this.fonts[i3].privateLength));
            DictOffsetItem dictOffsetItem5 = new DictOffsetItem();
            linkedList.addLast(dictOffsetItem5);
            linkedList.addLast(new UInt8Item((char) 18));
            linkedList.addLast(new IndexMarkerItem(indexOffsetItem2, indexBaseItem2));
            linkedList.addLast(new MarkerItem(dictOffsetItem5));
            linkedList.addLast(new RangeItem(this.buf, this.fonts[i3].privateOffset, this.fonts[i3].privateLength));
            if (this.fonts[i3].privateSubrs >= 0) {
                linkedList.addLast(getEntireIndexRange(this.fonts[i3].privateSubrs));
            }
        }
        linkedList.addLast(new MarkerItem(dictOffsetItem2));
        linkedList.addLast(getEntireIndexRange(this.fonts[i3].charstringsOffset));
        int[] iArr4 = {0};
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Item) it.next()).increment(iArr4);
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            ((Item) it2.next()).xref();
        }
        byte[] bArr = new byte[iArr4[0]];
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            ((Item) it3.next()).emit(bArr);
        }
        return bArr;
    }

    public boolean isCID(String str) {
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i].name)) {
                return this.fonts[i].isCID;
            }
            i++;
        }
    }

    public boolean exists(String str) {
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i].name)) {
                return true;
            }
            i++;
        }
    }

    public String[] getNames() {
        String[] strArr = new String[this.fonts.length];
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return strArr;
            }
            strArr[i] = fontArr[i].name;
            i++;
        }
    }

    /* loaded from: classes.dex */
    protected final class Font {
        public int CharsetLength;
        public int FDArrayCount;
        public int[] FDArrayOffsets;
        public int FDArrayOffsize;
        public int[] FDSelect;
        public int FDSelectFormat;
        public int FDSelectLength;
        public int[] PrivateSubrsOffset;
        public int[][] PrivateSubrsOffsetsArray;
        public int[] SubrsOffsets;
        public int[] charset;
        public int[] charstringsOffsets;
        public int[] fdprivateLengths;
        public int[] fdprivateOffsets;
        public int[] fdprivateSubrs;
        public String fullName;
        public String name;
        public int nglyphs;
        public int nstrings;
        public boolean isCID = false;
        public int privateOffset = -1;
        public int privateLength = -1;
        public int privateSubrs = -1;
        public int charstringsOffset = -1;
        public int encodingOffset = -1;
        public int charsetOffset = -1;
        public int fdarrayOffset = -1;
        public int fdselectOffset = -1;
        public int CharstringType = 2;

        protected Font() {
        }
    }

    public CFFFont(RandomAccessFileOrArray randomAccessFileOrArray) {
        int i;
        int i2;
        int i3;
        this.buf = randomAccessFileOrArray;
        seek(0);
        getCard8();
        getCard8();
        char card8 = getCard8();
        this.offSize = getCard8();
        this.nameIndexOffset = card8;
        this.nameOffsets = getIndex(this.nameIndexOffset);
        int[] iArr = this.nameOffsets;
        this.topdictIndexOffset = iArr[iArr.length - 1];
        this.topdictOffsets = getIndex(this.topdictIndexOffset);
        int[] iArr2 = this.topdictOffsets;
        this.stringIndexOffset = iArr2[iArr2.length - 1];
        this.stringOffsets = getIndex(this.stringIndexOffset);
        int[] iArr3 = this.stringOffsets;
        this.gsubrIndexOffset = iArr3[iArr3.length - 1];
        this.gsubrOffsets = getIndex(this.gsubrIndexOffset);
        this.fonts = new Font[this.nameOffsets.length - 1];
        int i4 = 0;
        while (i4 < this.nameOffsets.length - 1) {
            this.fonts[i4] = new Font();
            seek(this.nameOffsets[i4]);
            this.fonts[i4].name = "";
            int i5 = this.nameOffsets[i4];
            while (true) {
                i3 = i4 + 1;
                if (i5 < this.nameOffsets[i3]) {
                    StringBuilder sb = new StringBuilder();
                    Font font = this.fonts[i4];
                    sb.append(font.name);
                    sb.append(getCard8());
                    font.name = sb.toString();
                    i5++;
                }
            }
            i4 = i3;
        }
        int i6 = 0;
        while (true) {
            int[] iArr4 = this.topdictOffsets;
            if (i6 >= iArr4.length - 1) {
                return;
            }
            seek(iArr4[i6]);
            while (true) {
                i = i6 + 1;
                if (getPosition() >= this.topdictOffsets[i]) {
                    break;
                }
                getDictItem();
                String str = this.key;
                if (str == "FullName") {
                    this.fonts[i6].fullName = getString((char) ((Integer) this.args[0]).intValue());
                } else if (str == "ROS") {
                    this.fonts[i6].isCID = true;
                } else if (str == "Private") {
                    this.fonts[i6].privateLength = ((Integer) this.args[0]).intValue();
                    this.fonts[i6].privateOffset = ((Integer) this.args[1]).intValue();
                } else if (str == "charset") {
                    this.fonts[i6].charsetOffset = ((Integer) this.args[0]).intValue();
                } else if (str == "CharStrings") {
                    this.fonts[i6].charstringsOffset = ((Integer) this.args[0]).intValue();
                    int position = getPosition();
                    Font[] fontArr = this.fonts;
                    fontArr[i6].charstringsOffsets = getIndex(fontArr[i6].charstringsOffset);
                    seek(position);
                } else if (str == "FDArray") {
                    this.fonts[i6].fdarrayOffset = ((Integer) this.args[0]).intValue();
                } else if (str == "FDSelect") {
                    this.fonts[i6].fdselectOffset = ((Integer) this.args[0]).intValue();
                } else if (str == "CharstringType") {
                    this.fonts[i6].CharstringType = ((Integer) this.args[0]).intValue();
                }
            }
            if (this.fonts[i6].privateOffset >= 0) {
                seek(this.fonts[i6].privateOffset);
                while (getPosition() < this.fonts[i6].privateOffset + this.fonts[i6].privateLength) {
                    getDictItem();
                    if (this.key == "Subrs") {
                        this.fonts[i6].privateSubrs = ((Integer) this.args[0]).intValue() + this.fonts[i6].privateOffset;
                    }
                }
            }
            if (this.fonts[i6].fdarrayOffset >= 0) {
                int[] index = getIndex(this.fonts[i6].fdarrayOffset);
                Font[] fontArr2 = this.fonts;
                fontArr2[i6].fdprivateOffsets = new int[index.length - 1];
                fontArr2[i6].fdprivateLengths = new int[index.length - 1];
                int i7 = 0;
                while (i7 < index.length - 1) {
                    seek(index[i7]);
                    while (true) {
                        i2 = i7 + 1;
                        if (getPosition() < index[i2]) {
                            getDictItem();
                            if (this.key == "Private") {
                                this.fonts[i6].fdprivateLengths[i7] = ((Integer) this.args[0]).intValue();
                                this.fonts[i6].fdprivateOffsets[i7] = ((Integer) this.args[1]).intValue();
                            }
                        }
                    }
                    i7 = i2;
                }
            }
            i6 = i;
        }
    }

    void ReadEncoding(int i) {
        seek(i);
        getCard8();
    }
}
