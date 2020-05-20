package com.itextpdf.text.pdf;

import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.p297e.p298a.p306b.ImageLoader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public final class Pfm2afm {
    private short ascender;
    private short ascent;
    private short avgwidth;
    private int bitoff;
    private int bits;
    private byte brkchar;
    private short capheight;
    private byte charset;
    private int chartab;
    private String copyright;
    private byte defchar;
    private short descender;
    private int device;
    private short extleading;
    private short extlen;
    private int face;
    private int firstchar;
    private int fontname;
    private int h_len;
    private short horres;

    /* renamed from: in */
    private RandomAccessFileOrArray f19805in;
    private short intleading;
    private boolean isMono;
    private byte italic;
    private int kernpairs;
    private byte kind;
    private int lastchar;
    private short maxwidth;
    private PrintWriter out;
    private byte overs;
    private short pixheight;
    private short pixwidth;
    private short points;
    private int psext;
    private int res1;
    private int res2;
    private short type;
    private byte uline;
    private short verres;
    private short vers;
    private short weight;
    private short widthby;
    private short xheight;
    private int[] Win2PSStd = {0, 0, 0, 0, Opcodes.MULTIANEWARRAY, Opcodes.IFNULL, Opcodes.IFNONNULL, 0, 202, 0, 205, 206, 207, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, Opcodes.RET, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, Opcodes.INSTANCEOF, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, Opcodes.INEG, 117, Opcodes.FNEG, 119, Opcodes.ISHL, 121, Opcodes.ISHR, 123, Opcodes.IUSHR, 125, Opcodes.IAND, 127, 128, 0, Opcodes.INVOKESTATIC, Opcodes.IF_ACMPNE, Opcodes.INVOKEINTERFACE, Opcodes.NEWARRAY, Opcodes.GETSTATIC, Opcodes.PUTSTATIC, Opcodes.MONITOREXIT, Opcodes.ANEWARRAY, 0, Opcodes.IRETURN, 234, 0, 0, 0, 0, 96, 0, Opcodes.TABLESWITCH, Opcodes.INVOKEDYNAMIC, Opcodes.INVOKESPECIAL, Opcodes.RETURN, 208, SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING, 0, 0, Opcodes.LRETURN, Type.TSIG, 0, 0, 0, 0, 161, 162, Opcodes.IF_ICMPGT, Opcodes.JSR, Opcodes.IF_ACMPEQ, 0, 167, PdfContentParser.COMMAND_TYPE, 0, 227, Opcodes.LOOKUPSWITCH, 0, 0, 0, Opcodes.MULTIANEWARRAY, 0, 0, 0, 0, Opcodes.MONITORENTER, 0, Opcodes.INVOKEVIRTUAL, Opcodes.GETFIELD, 203, 0, 235, Opcodes.NEW, 0, 0, 0, Opcodes.ATHROW, 0, 0, 0, 0, 0, 0, 225, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 233, 0, 0, 0, 0, 0, 0, Type.IXFR, 0, 0, 0, 0, 0, 0, 241, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Type.TKEY, 0, 0, 0, 0, 0, 0, 0};
    private int[] WinClass = {0, 0, 0, 0, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private String[] WinChars = {"W00", "W01", "W02", "W03", "macron", "breve", "dotaccent", "W07", "ring", "W09", "W0a", "W0b", "W0c", "W0d", "W0e", "W0f", "hungarumlaut", "ogonek", "caron", "W13", "W14", "W15", "W16", "W17", "W18", "W19", "W1a", "W1b", "W1c", "W1d", "W1e", "W1f", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", HtmlTags.f19618A, HtmlTags.f19619B, "c", ImageLoader.f17144a, "e", "f", "g", "h", HtmlTags.f19629I, "j", "k", PAD3DHCPForDoIP.f10141a, "m", "n", "o", HtmlTags.f19632P, "q", "r", HtmlTags.f19633S, "t", HtmlTags.f19637U, "v", "w", GroupChatInvitation.ELEMENT_NAME, "y", "z", "braceleft", "bar", "braceright", "asciitilde", "W7f", "euro", "W81", "quotesinglbase", "florin", "quotedblbase", "ellipsis", "dagger", "daggerdbl", "circumflex", "perthousand", "Scaron", "guilsinglleft", "OE", "W8d", "Zcaron", "W8f", "W90", "quoteleft", "quoteright", "quotedblleft", "quotedblright", "bullet", "endash", "emdash", "tilde", "trademark", "scaron", "guilsinglright", "oe", "W9d", "zcaron", "Ydieresis", "reqspace", "exclamdown", "cent", "sterling", "currency", "yen", "brokenbar", "section", "dieresis", "copyright", "ordfeminine", "guillemotleft", "logicalnot", "syllable", "registered", "macron", "degree", "plusminus", "twosuperior", "threesuperior", "acute", "mu", "paragraph", "periodcentered", "cedilla", "onesuperior", "ordmasculine", "guillemotright", "onequarter", "onehalf", "threequarters", "questiondown", "Agrave", "Aacute", "Acircumflex", "Atilde", "Adieresis", "Aring", "AE", "Ccedilla", "Egrave", "Eacute", "Ecircumflex", "Edieresis", "Igrave", "Iacute", "Icircumflex", "Idieresis", "Eth", "Ntilde", "Ograve", "Oacute", "Ocircumflex", "Otilde", "Odieresis", "multiply", "Oslash", "Ugrave", "Uacute", "Ucircumflex", "Udieresis", "Yacute", "Thorn", "germandbls", "agrave", "aacute", "acircumflex", "atilde", "adieresis", "aring", "ae", "ccedilla", "egrave", "eacute", "ecircumflex", "edieresis", "igrave", "iacute", "icircumflex", "idieresis", "eth", "ntilde", "ograve", "oacute", "ocircumflex", "otilde", "odieresis", "divide", "oslash", "ugrave", "uacute", "ucircumflex", "udieresis", "yacute", "thorn", "ydieresis"};

    private Pfm2afm(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        this.f19805in = randomAccessFileOrArray;
        this.out = new PrintWriter(new OutputStreamWriter(outputStream, "ISO-8859-1"));
    }

    public static void convert(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        Pfm2afm pfm2afm = new Pfm2afm(randomAccessFileOrArray, outputStream);
        pfm2afm.openpfm();
        pfm2afm.putheader();
        pfm2afm.putchartab();
        pfm2afm.putkerntab();
        pfm2afm.puttrailer();
        pfm2afm.out.flush();
    }

    private String readString(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.f19805in.readFully(bArr);
        int i2 = 0;
        while (i2 < i && bArr[i2] != 0) {
            i2++;
        }
        return new String(bArr, 0, i2, "ISO-8859-1");
    }

    private String readString() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = this.f19805in.read();
            if (read > 0) {
                stringBuffer.append((char) read);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    private void outval(int i) {
        this.out.print(TokenParser.f24154SP);
        this.out.print(i);
    }

    private void outchar(int i, int i2, String str) {
        this.out.print("C ");
        outval(i);
        this.out.print(" ; WX ");
        outval(i2);
        if (str != null) {
            this.out.print(" ; N ");
            this.out.print(str);
        }
        this.out.print(" ;\n");
    }

    private void openpfm() throws IOException {
        int i;
        this.f19805in.seek(0L);
        this.vers = this.f19805in.readShortLE();
        this.h_len = this.f19805in.readIntLE();
        this.copyright = readString(60);
        this.type = this.f19805in.readShortLE();
        this.points = this.f19805in.readShortLE();
        this.verres = this.f19805in.readShortLE();
        this.horres = this.f19805in.readShortLE();
        this.ascent = this.f19805in.readShortLE();
        this.intleading = this.f19805in.readShortLE();
        this.extleading = this.f19805in.readShortLE();
        this.italic = (byte) this.f19805in.read();
        this.uline = (byte) this.f19805in.read();
        this.overs = (byte) this.f19805in.read();
        this.weight = this.f19805in.readShortLE();
        this.charset = (byte) this.f19805in.read();
        this.pixwidth = this.f19805in.readShortLE();
        this.pixheight = this.f19805in.readShortLE();
        this.kind = (byte) this.f19805in.read();
        this.avgwidth = this.f19805in.readShortLE();
        this.maxwidth = this.f19805in.readShortLE();
        this.firstchar = this.f19805in.read();
        this.lastchar = this.f19805in.read();
        this.defchar = (byte) this.f19805in.read();
        this.brkchar = (byte) this.f19805in.read();
        this.widthby = this.f19805in.readShortLE();
        this.device = this.f19805in.readIntLE();
        this.face = this.f19805in.readIntLE();
        this.bits = this.f19805in.readIntLE();
        this.bitoff = this.f19805in.readIntLE();
        this.extlen = this.f19805in.readShortLE();
        this.psext = this.f19805in.readIntLE();
        this.chartab = this.f19805in.readIntLE();
        this.res1 = this.f19805in.readIntLE();
        this.kernpairs = this.f19805in.readIntLE();
        this.res2 = this.f19805in.readIntLE();
        this.fontname = this.f19805in.readIntLE();
        if (this.h_len != this.f19805in.length() || this.extlen != 30 || (i = this.fontname) < 75 || i > 512) {
            throw new IOException(MessageLocalization.getComposedMessage("not.a.valid.pfm.file", new Object[0]));
        }
        this.f19805in.seek(this.psext + 14);
        this.capheight = this.f19805in.readShortLE();
        this.xheight = this.f19805in.readShortLE();
        this.ascender = this.f19805in.readShortLE();
        this.descender = this.f19805in.readShortLE();
    }

    private void putheader() throws IOException {
        this.out.print("StartFontMetrics 2.0\n");
        if (this.copyright.length() > 0) {
            PrintWriter printWriter = this.out;
            printWriter.print("Comment " + this.copyright + '\n');
        }
        this.out.print("FontName ");
        this.f19805in.seek(this.fontname);
        String readString = readString();
        this.out.print(readString);
        this.out.print("\nEncodingScheme ");
        if (this.charset != 0) {
            this.out.print("FontSpecific\n");
        } else {
            this.out.print("AdobeStandardEncoding\n");
        }
        PrintWriter printWriter2 = this.out;
        printWriter2.print("FullName " + readString.replace(SignatureVisitor.SUPER, TokenParser.f24154SP));
        int i = this.face;
        if (i != 0) {
            this.f19805in.seek(i);
            PrintWriter printWriter3 = this.out;
            printWriter3.print("\nFamilyName " + readString());
        }
        this.out.print("\nWeight ");
        if (this.weight > 475 || readString.toLowerCase().indexOf(HtmlTags.BOLD) >= 0) {
            this.out.print("Bold");
        } else {
            short s = this.weight;
            if ((s < 325 && s != 0) || readString.toLowerCase().indexOf("light") >= 0) {
                this.out.print("Light");
            } else if (readString.toLowerCase().indexOf("black") >= 0) {
                this.out.print("Black");
            } else {
                this.out.print("Medium");
            }
        }
        this.out.print("\nItalicAngle ");
        if (this.italic != 0 || readString.toLowerCase().indexOf(HtmlTags.ITALIC) >= 0) {
            this.out.print("-12.00");
        } else {
            this.out.print("0");
        }
        this.out.print("\nIsFixedPitch ");
        if ((this.kind & 1) == 0 || this.avgwidth == this.maxwidth) {
            this.out.print(PdfBoolean.TRUE);
            this.isMono = true;
        } else {
            this.out.print(PdfBoolean.FALSE);
            this.isMono = false;
        }
        this.out.print("\nFontBBox");
        if (this.isMono) {
            outval(-20);
        } else {
            outval(-100);
        }
        outval(-(this.descender + 5));
        outval(this.maxwidth + 10);
        outval(this.ascent + 5);
        this.out.print("\nCapHeight");
        outval(this.capheight);
        this.out.print("\nXHeight");
        outval(this.xheight);
        this.out.print("\nDescender");
        outval(-this.descender);
        this.out.print("\nAscender");
        outval(this.ascender);
        this.out.print('\n');
    }

    private void putchartab() throws IOException {
        int i = (this.lastchar - this.firstchar) + 1;
        int[] iArr = new int[i];
        this.f19805in.seek(this.chartab);
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.f19805in.readUnsignedShortLE();
        }
        int[] iArr2 = new int[256];
        if (this.charset == 0) {
            for (int i3 = this.firstchar; i3 <= this.lastchar; i3++) {
                int[] iArr3 = this.Win2PSStd;
                if (iArr3[i3] != 0) {
                    iArr2[iArr3[i3]] = i3;
                }
            }
        }
        this.out.print("StartCharMetrics");
        outval(i);
        this.out.print('\n');
        if (this.charset != 0) {
            for (int i4 = this.firstchar; i4 <= this.lastchar; i4++) {
                int i5 = this.firstchar;
                if (iArr[i4 - i5] != 0) {
                    outchar(i4, iArr[i4 - i5], null);
                }
            }
        } else {
            for (int i6 = 0; i6 < 256; i6++) {
                int i7 = iArr2[i6];
                if (i7 != 0) {
                    outchar(i6, iArr[i7 - this.firstchar], this.WinChars[i7]);
                    iArr[i7 - this.firstchar] = 0;
                }
            }
            for (int i8 = this.firstchar; i8 <= this.lastchar; i8++) {
                int i9 = this.firstchar;
                if (iArr[i8 - i9] != 0) {
                    outchar(-1, iArr[i8 - i9], this.WinChars[i8]);
                }
            }
        }
        this.out.print("EndCharMetrics\n");
    }

    private void putkerntab() throws IOException {
        int i = this.kernpairs;
        if (i == 0) {
            return;
        }
        this.f19805in.seek(i);
        int[] iArr = new int[this.f19805in.readUnsignedShortLE() * 3];
        int i2 = 0;
        int i3 = 0;
        while (i2 < iArr.length) {
            int i4 = i2 + 1;
            iArr[i2] = this.f19805in.read();
            int i5 = i4 + 1;
            iArr[i4] = this.f19805in.read();
            int i6 = i5 + 1;
            short readShortLE = this.f19805in.readShortLE();
            iArr[i5] = readShortLE;
            if (readShortLE != 0) {
                i3++;
                i2 = i6;
            } else {
                i2 = i6;
            }
        }
        if (i3 == 0) {
            return;
        }
        this.out.print("StartKernData\nStartKernPairs");
        outval(i3);
        this.out.print('\n');
        for (int i7 = 0; i7 < iArr.length; i7 += 3) {
            int i8 = i7 + 2;
            if (iArr[i8] != 0) {
                this.out.print("KPX ");
                this.out.print(this.WinChars[iArr[i7]]);
                this.out.print(TokenParser.f24154SP);
                this.out.print(this.WinChars[iArr[i7 + 1]]);
                outval(iArr[i8]);
                this.out.print('\n');
            }
        }
        this.out.print("EndKernPairs\nEndKernData\n");
    }

    private void puttrailer() {
        this.out.print("EndFontMetrics\n");
    }
}
