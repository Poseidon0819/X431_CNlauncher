package com.itextpdf.text.pdf;

import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import org.apache.http.conn.ssl.TokenParser;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public class Barcode128 extends Barcode {
    private static final byte[][] BARS = {new byte[]{2, 1, 2, 2, 2, 2}, new byte[]{2, 2, 2, 1, 2, 2}, new byte[]{2, 2, 2, 2, 2, 1}, new byte[]{1, 2, 1, 2, 2, 3}, new byte[]{1, 2, 1, 3, 2, 2}, new byte[]{1, 3, 1, 2, 2, 2}, new byte[]{1, 2, 2, 2, 1, 3}, new byte[]{1, 2, 2, 3, 1, 2}, new byte[]{1, 3, 2, 2, 1, 2}, new byte[]{2, 2, 1, 2, 1, 3}, new byte[]{2, 2, 1, 3, 1, 2}, new byte[]{2, 3, 1, 2, 1, 2}, new byte[]{1, 1, 2, 2, 3, 2}, new byte[]{1, 2, 2, 1, 3, 2}, new byte[]{1, 2, 2, 2, 3, 1}, new byte[]{1, 1, 3, 2, 2, 2}, new byte[]{1, 2, 3, 1, 2, 2}, new byte[]{1, 2, 3, 2, 2, 1}, new byte[]{2, 2, 3, 2, 1, 1}, new byte[]{2, 2, 1, 1, 3, 2}, new byte[]{2, 2, 1, 2, 3, 1}, new byte[]{2, 1, 3, 2, 1, 2}, new byte[]{2, 2, 3, 1, 1, 2}, new byte[]{3, 1, 2, 1, 3, 1}, new byte[]{3, 1, 1, 2, 2, 2}, new byte[]{3, 2, 1, 1, 2, 2}, new byte[]{3, 2, 1, 2, 2, 1}, new byte[]{3, 1, 2, 2, 1, 2}, new byte[]{3, 2, 2, 1, 1, 2}, new byte[]{3, 2, 2, 2, 1, 1}, new byte[]{2, 1, 2, 1, 2, 3}, new byte[]{2, 1, 2, 3, 2, 1}, new byte[]{2, 3, 2, 1, 2, 1}, new byte[]{1, 1, 1, 3, 2, 3}, new byte[]{1, 3, 1, 1, 2, 3}, new byte[]{1, 3, 1, 3, 2, 1}, new byte[]{1, 1, 2, 3, 1, 3}, new byte[]{1, 3, 2, 1, 1, 3}, new byte[]{1, 3, 2, 3, 1, 1}, new byte[]{2, 1, 1, 3, 1, 3}, new byte[]{2, 3, 1, 1, 1, 3}, new byte[]{2, 3, 1, 3, 1, 1}, new byte[]{1, 1, 2, 1, 3, 3}, new byte[]{1, 1, 2, 3, 3, 1}, new byte[]{1, 3, 2, 1, 3, 1}, new byte[]{1, 1, 3, 1, 2, 3}, new byte[]{1, 1, 3, 3, 2, 1}, new byte[]{1, 3, 3, 1, 2, 1}, new byte[]{3, 1, 3, 1, 2, 1}, new byte[]{2, 1, 1, 3, 3, 1}, new byte[]{2, 3, 1, 1, 3, 1}, new byte[]{2, 1, 3, 1, 1, 3}, new byte[]{2, 1, 3, 3, 1, 1}, new byte[]{2, 1, 3, 1, 3, 1}, new byte[]{3, 1, 1, 1, 2, 3}, new byte[]{3, 1, 1, 3, 2, 1}, new byte[]{3, 3, 1, 1, 2, 1}, new byte[]{3, 1, 2, 1, 1, 3}, new byte[]{3, 1, 2, 3, 1, 1}, new byte[]{3, 3, 2, 1, 1, 1}, new byte[]{3, 1, 4, 1, 1, 1}, new byte[]{2, 2, 1, 4, 1, 1}, new byte[]{4, 3, 1, 1, 1, 1}, new byte[]{1, 1, 1, 2, 2, 4}, new byte[]{1, 1, 1, 4, 2, 2}, new byte[]{1, 2, 1, 1, 2, 4}, new byte[]{1, 2, 1, 4, 2, 1}, new byte[]{1, 4, 1, 1, 2, 2}, new byte[]{1, 4, 1, 2, 2, 1}, new byte[]{1, 1, 2, 2, 1, 4}, new byte[]{1, 1, 2, 4, 1, 2}, new byte[]{1, 2, 2, 1, 1, 4}, new byte[]{1, 2, 2, 4, 1, 1}, new byte[]{1, 4, 2, 1, 1, 2}, new byte[]{1, 4, 2, 2, 1, 1}, new byte[]{2, 4, 1, 2, 1, 1}, new byte[]{2, 2, 1, 1, 1, 4}, new byte[]{4, 1, 3, 1, 1, 1}, new byte[]{2, 4, 1, 1, 1, 2}, new byte[]{1, 3, 4, 1, 1, 1}, new byte[]{1, 1, 1, 2, 4, 2}, new byte[]{1, 2, 1, 1, 4, 2}, new byte[]{1, 2, 1, 2, 4, 1}, new byte[]{1, 1, 4, 2, 1, 2}, new byte[]{1, 2, 4, 1, 1, 2}, new byte[]{1, 2, 4, 2, 1, 1}, new byte[]{4, 1, 1, 2, 1, 2}, new byte[]{4, 2, 1, 1, 1, 2}, new byte[]{4, 2, 1, 2, 1, 1}, new byte[]{2, 1, 2, 1, 4, 1}, new byte[]{2, 1, 4, 1, 2, 1}, new byte[]{4, 1, 2, 1, 2, 1}, new byte[]{1, 1, 1, 1, 4, 3}, new byte[]{1, 1, 1, 3, 4, 1}, new byte[]{1, 3, 1, 1, 4, 1}, new byte[]{1, 1, 4, 1, 1, 3}, new byte[]{1, 1, 4, 3, 1, 1}, new byte[]{4, 1, 1, 1, 1, 3}, new byte[]{4, 1, 1, 3, 1, 1}, new byte[]{1, 1, 3, 1, 4, 1}, new byte[]{1, 1, 4, 1, 3, 1}, new byte[]{3, 1, 1, 1, 4, 1}, new byte[]{4, 1, 1, 1, 3, 1}, new byte[]{2, 1, 1, 4, 1, 2}, new byte[]{2, 1, 1, 2, 1, 4}, new byte[]{2, 1, 1, 2, 3, 2}};
    private static final byte[] BARS_STOP = {2, 3, 3, 1, 1, 1, 2};
    public static final char CODE_A = 200;
    public static final char CODE_AB_TO_C = 'c';
    public static final char CODE_AC_TO_B = 'd';
    public static final char CODE_BC_TO_A = 'e';
    public static final char CODE_C = 199;
    public static final char DEL = 195;
    public static final char FNC1 = 202;
    public static final char FNC1_INDEX = 'f';
    public static final char FNC2 = 197;
    public static final char FNC3 = 196;
    public static final char FNC4 = 200;
    public static final char SHIFT = 198;
    public static final char STARTA = 203;
    public static final char STARTB = 204;
    public static final char STARTC = 205;
    public static final char START_A = 'g';
    public static final char START_B = 'h';
    public static final char START_C = 'i';
    private static final IntHashtable ais;

    static {
        IntHashtable intHashtable = new IntHashtable();
        ais = intHashtable;
        intHashtable.put(0, 20);
        ais.put(1, 16);
        ais.put(2, 16);
        ais.put(10, -1);
        ais.put(11, 9);
        ais.put(12, 8);
        ais.put(13, 8);
        ais.put(15, 8);
        ais.put(17, 8);
        ais.put(20, 4);
        ais.put(21, -1);
        ais.put(22, -1);
        ais.put(23, -1);
        ais.put(240, -1);
        ais.put(241, -1);
        ais.put(Type.TSIG, -1);
        ais.put(Type.IXFR, -1);
        ais.put(252, -1);
        ais.put(30, -1);
        for (int i = 3100; i < 3700; i++) {
            ais.put(i, 10);
        }
        ais.put(37, -1);
        for (int i2 = 3900; i2 < 3940; i2++) {
            ais.put(i2, -1);
        }
        ais.put(400, -1);
        ais.put(401, -1);
        ais.put(402, 20);
        ais.put(403, -1);
        for (int i3 = 410; i3 < 416; i3++) {
            ais.put(i3, 16);
        }
        ais.put(420, -1);
        ais.put(421, -1);
        ais.put(422, 6);
        ais.put(423, -1);
        ais.put(424, 6);
        ais.put(425, 6);
        ais.put(426, 6);
        ais.put(7001, 17);
        ais.put(7002, -1);
        for (int i4 = 7030; i4 < 7040; i4++) {
            ais.put(i4, -1);
        }
        ais.put(8001, 18);
        ais.put(8002, -1);
        ais.put(8003, -1);
        ais.put(8004, -1);
        ais.put(8005, 10);
        ais.put(8006, 22);
        ais.put(8007, -1);
        ais.put(8008, -1);
        ais.put(UIMsg.m_AppUI.MSG_SUG_TEXTCHAGNE, 22);
        ais.put(8020, -1);
        ais.put(8100, 10);
        ais.put(8101, 14);
        ais.put(8102, 6);
        for (int i5 = 90; i5 < 100; i5++) {
            ais.put(i5, -1);
        }
    }

    public Barcode128() {
        try {
            this.f19648x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.textAlignment = 1;
            this.codeType = 9;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String removeFNC1(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= ' ' && charAt <= '~') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String getHumanReadableUCCEAN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                if (str.startsWith("Ê")) {
                    str = str.substring(1);
                } else {
                    int i = 2;
                    int i2 = 0;
                    while (i < 5 && str.length() >= i) {
                        i2 = ais.get(Integer.parseInt(str.substring(0, i)));
                        if (i2 != 0) {
                            break;
                        }
                        i++;
                    }
                    i = 0;
                    if (i == 0) {
                        break;
                    }
                    stringBuffer.append('(');
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(')');
                    str = str.substring(i);
                    if (i2 > 0) {
                        int i3 = i2 - i;
                        if (str.length() <= i3) {
                            break;
                        }
                        stringBuffer.append(removeFNC1(str.substring(0, i3)));
                        str = str.substring(i3);
                    } else {
                        int indexOf = str.indexOf(202);
                        if (indexOf < 0) {
                            break;
                        }
                        stringBuffer.append(str.substring(0, indexOf));
                        str = str.substring(indexOf + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        stringBuffer.append(removeFNC1(str));
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0004, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean isNextDigits(java.lang.String r5, int r6, int r7) {
        /*
            int r0 = r5.length()
        L4:
            r1 = 0
            if (r6 >= r0) goto L37
            if (r7 <= 0) goto L37
            char r2 = r5.charAt(r6)
            r3 = 202(0xca, float:2.83E-43)
            if (r2 != r3) goto L14
            int r6 = r6 + 1
            goto L4
        L14:
            r2 = 2
            int r2 = java.lang.Math.min(r2, r7)
            int r3 = r6 + r2
            if (r3 <= r0) goto L1e
            return r1
        L1e:
            int r3 = r2 + (-1)
            if (r2 <= 0) goto L4
            int r2 = r6 + 1
            char r6 = r5.charAt(r6)
            r4 = 48
            if (r6 < r4) goto L36
            r4 = 57
            if (r6 <= r4) goto L31
            goto L36
        L31:
            int r7 = r7 + (-1)
            r6 = r2
            r2 = r3
            goto L1e
        L36:
            return r1
        L37:
            if (r7 != 0) goto L3b
            r5 = 1
            return r5
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.isNextDigits(java.lang.String, int, int):boolean");
    }

    static String getPackedRawDigits(String str, int i, int i2) {
        int i3;
        StringBuilder sb = new StringBuilder("");
        int i4 = i;
        while (i2 > 0) {
            if (str.charAt(i4) == 202) {
                sb.append(FNC1_INDEX);
                i4++;
            } else {
                i2 -= 2;
                sb.append((char) (((str.charAt(i4) - '0') * 10) + (str.charAt(i3) - '0')));
                i4 = i4 + 1 + 1;
            }
        }
        return ((char) (i4 - i)) + sb.toString();
    }

    public static String getRawText(String str, boolean z) {
        String str2;
        char c;
        int i;
        String packedRawDigits;
        String packedRawDigits2;
        String packedRawDigits3;
        String packedRawDigits4;
        int length = str.length();
        if (length == 0) {
            String str3 = "" + START_B;
            if (z) {
                return str3 + FNC1_INDEX;
            }
            return str3;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt > 127 && charAt != 202) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
            }
        }
        char charAt2 = str.charAt(0);
        if (isNextDigits(str, 0, 2)) {
            String str4 = "" + START_C;
            if (z) {
                str4 = str4 + FNC1_INDEX;
            }
            i = getPackedRawDigits(str, 0, 2).charAt(0) + 0;
            str2 = str4 + packedRawDigits4.substring(1);
            c = START_C;
        } else {
            if (charAt2 < ' ') {
                String str5 = "" + START_A;
                if (z) {
                    str5 = str5 + FNC1_INDEX;
                }
                str2 = str5 + ((char) (charAt2 + '@'));
                c = START_A;
            } else {
                String str6 = "" + START_B;
                if (z) {
                    str6 = str6 + FNC1_INDEX;
                }
                if (charAt2 == 202) {
                    str2 = str6 + FNC1_INDEX;
                    c = START_B;
                } else {
                    str2 = str6 + ((char) (charAt2 - TokenParser.f24154SP));
                    c = START_B;
                }
            }
            i = 1;
        }
        while (i < length) {
            switch (c) {
                case 'g':
                    if (isNextDigits(str, i, 4)) {
                        i += getPackedRawDigits(str, i, 4).charAt(0);
                        str2 = (str2 + CODE_AB_TO_C) + packedRawDigits2.substring(1);
                        c = START_C;
                    } else {
                        int i3 = i + 1;
                        char charAt3 = str.charAt(i);
                        if (charAt3 == 202) {
                            str2 = str2 + FNC1_INDEX;
                            i = i3;
                        } else if (charAt3 > '_') {
                            str2 = (str2 + CODE_AC_TO_B) + ((char) (charAt3 - ' '));
                            i = i3;
                            c = START_B;
                        } else if (charAt3 < ' ') {
                            str2 = str2 + ((char) (charAt3 + '@'));
                            i = i3;
                        } else {
                            str2 = str2 + ((char) (charAt3 - ' '));
                            i = i3;
                            continue;
                        }
                    }
                case 'h':
                    if (isNextDigits(str, i, 4)) {
                        i += getPackedRawDigits(str, i, 4).charAt(0);
                        str2 = (str2 + CODE_AB_TO_C) + packedRawDigits3.substring(1);
                        c = START_C;
                    } else {
                        int i4 = i + 1;
                        char charAt4 = str.charAt(i);
                        if (charAt4 == 202) {
                            str2 = str2 + FNC1_INDEX;
                            i = i4;
                        } else if (charAt4 < ' ') {
                            str2 = (str2 + CODE_BC_TO_A) + ((char) (charAt4 + '@'));
                            i = i4;
                            c = START_A;
                        } else {
                            str2 = str2 + ((char) (charAt4 - ' '));
                            i = i4;
                            continue;
                        }
                    }
                case 'i':
                    if (isNextDigits(str, i, 2)) {
                        i += getPackedRawDigits(str, i, 2).charAt(0);
                        str2 = str2 + packedRawDigits.substring(1);
                    } else {
                        int i5 = i + 1;
                        char charAt5 = str.charAt(i);
                        if (charAt5 == 202) {
                            str2 = str2 + FNC1_INDEX;
                            i = i5;
                        } else if (charAt5 >= ' ') {
                            str2 = (str2 + CODE_AC_TO_B) + ((char) (charAt5 - ' '));
                            i = i5;
                            c = START_B;
                            break;
                        } else {
                            str2 = (str2 + CODE_BC_TO_A) + ((char) (charAt5 + '@'));
                            i = i5;
                            c = START_A;
                            continue;
                        }
                    }
            }
        }
        return str2;
    }

    public static byte[] getBarsCode128Raw(String str) {
        int indexOf = str.indexOf(65535);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        int charAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            charAt += str.charAt(i) * i;
        }
        String str2 = str + ((char) (charAt % 103));
        byte[] bArr = new byte[((str2.length() + 1) * 6) + 7];
        int i2 = 0;
        while (i2 < str2.length()) {
            System.arraycopy(BARS[str2.charAt(i2)], 0, bArr, i2 * 6, 6);
            i2++;
        }
        System.arraycopy(BARS_STOP, 0, bArr, i2 * 6, 7);
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String rawText;
        String removeFNC1;
        BaseFont baseFont = this.font;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.baseline > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            if (this.codeType == 11) {
                int indexOf = this.code.indexOf(65535);
                removeFNC1 = indexOf < 0 ? "" : this.code.substring(indexOf + 1);
            } else if (this.codeType == 10) {
                removeFNC1 = getHumanReadableUCCEAN(this.code);
            } else {
                removeFNC1 = removeFNC1(this.code);
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                removeFNC1 = this.altText;
            }
            f = baseFont2.getWidthPoint(removeFNC1, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.codeType == 11) {
            int indexOf2 = this.code.indexOf(65535);
            if (indexOf2 >= 0) {
                rawText = this.code.substring(0, indexOf2);
            } else {
                rawText = this.code;
            }
        } else {
            rawText = getRawText(this.code, this.codeType == 10);
        }
        return new Rectangle(Math.max(((rawText.length() + 2) * 11 * this.f19648x) + (this.f19648x * 2.0f), f), this.barHeight + f2);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        String removeFNC1;
        float f;
        String rawText;
        float f2;
        float f3;
        float f4;
        boolean z = true;
        if (this.codeType == 11) {
            int indexOf = this.code.indexOf(65535);
            removeFNC1 = indexOf < 0 ? "" : this.code.substring(indexOf + 1);
        } else if (this.codeType == 10) {
            removeFNC1 = getHumanReadableUCCEAN(this.code);
        } else {
            removeFNC1 = removeFNC1(this.code);
        }
        BaseFont baseFont = this.font;
        float f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                removeFNC1 = this.altText;
            }
            f = baseFont2.getWidthPoint(removeFNC1, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.codeType == 11) {
            int indexOf2 = this.code.indexOf(65535);
            if (indexOf2 >= 0) {
                rawText = this.code.substring(0, indexOf2);
            } else {
                rawText = this.code;
            }
        } else {
            rawText = getRawText(this.code, this.codeType == 10);
        }
        float length = ((rawText.length() + 2) * 11 * this.f19648x) + (this.f19648x * 2.0f);
        int i = this.textAlignment;
        if (i == 0) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (i != 2) {
            if (f > length) {
                f2 = (f - length) / 2.0f;
                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                f3 = (length - f) / 2.0f;
                f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
        } else if (f > length) {
            f2 = f - length;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            f3 = length - f;
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.font == null) {
            f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (this.baseline <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f4 = this.barHeight - this.baseline;
        } else {
            float f6 = -this.font.getFontDescriptor(3, this.size);
            f5 = this.baseline + f6;
            f4 = f6;
        }
        byte[] barsCode128Raw = getBarsCode128Raw(rawText);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        for (byte b : barsCode128Raw) {
            float f7 = b * this.f19648x;
            if (z) {
                pdfContentByte.rectangle(f2, f5, f7 - this.inkSpreading, this.barHeight);
            }
            z = !z;
            f2 += f7;
        }
        pdfContentByte.fill();
        if (this.font != null) {
            if (baseColor2 != null) {
                pdfContentByte.setColorFill(baseColor2);
            }
            pdfContentByte.beginText();
            pdfContentByte.setFontAndSize(this.font, this.size);
            pdfContentByte.setTextMatrix(f3, f4);
            pdfContentByte.showText(removeFNC1);
            pdfContentByte.endText();
        }
        return getBarcodeSize();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public void setCode(String str) {
        if (getCodeType() == 10 && str.startsWith("(")) {
            StringBuilder sb = new StringBuilder("");
            int i = 0;
            while (i >= 0) {
                int indexOf = str.indexOf(41, i);
                if (indexOf < 0) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("badly.formed.ucc.string.1", str));
                }
                String substring = str.substring(i + 1, indexOf);
                if (substring.length() < 2) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.too.short.1", substring));
                }
                int parseInt = Integer.parseInt(substring);
                int i2 = ais.get(parseInt);
                if (i2 == 0) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.not.found.1", substring));
                }
                String valueOf = String.valueOf(parseInt);
                if (valueOf.length() == 1) {
                    valueOf = "0".concat(String.valueOf(valueOf));
                }
                int indexOf2 = str.indexOf(40, indexOf);
                int length = indexOf2 < 0 ? str.length() : indexOf2;
                sb.append(valueOf);
                sb.append(str.substring(indexOf + 1, length));
                if (i2 < 0) {
                    if (indexOf2 >= 0) {
                        sb.append(FNC1);
                    }
                } else if (((length - indexOf) - 1) + valueOf.length() != i2) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.ai.length.1", valueOf));
                }
                i = indexOf2;
            }
            super.setCode(sb.toString());
            return;
        }
        super.setCode(str);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Image createAwtImage(Color color, Color color2) {
        String rawText;
        int rgb = color.getRGB();
        int rgb2 = color2.getRGB();
        Canvas canvas = new Canvas();
        boolean z = true;
        if (this.codeType == 11) {
            int indexOf = this.code.indexOf(65535);
            if (indexOf >= 0) {
                rawText = this.code.substring(0, indexOf);
            } else {
                rawText = this.code;
            }
        } else {
            rawText = getRawText(this.code, this.codeType == 10);
        }
        int length = ((rawText.length() + 2) * 11) + 2;
        byte[] barsCode128Raw = getBarsCode128Raw(rawText);
        int i = (int) this.barHeight;
        int[] iArr = new int[length * i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < barsCode128Raw.length) {
            byte b = barsCode128Raw[i2];
            int i4 = z ? rgb : rgb2;
            z = !z;
            int i5 = i3;
            int i6 = 0;
            while (i6 < b) {
                iArr[i5] = i4;
                i6++;
                i5++;
            }
            i2++;
            i3 = i5;
        }
        for (int i7 = length; i7 < iArr.length; i7 += length) {
            System.arraycopy(iArr, 0, iArr, i7, length);
        }
        return canvas.createImage(new MemoryImageSource(length, i, iArr, 0, length));
    }
}
