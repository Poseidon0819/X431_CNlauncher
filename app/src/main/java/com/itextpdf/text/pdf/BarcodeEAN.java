package com.itextpdf.text.pdf;

import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.unionpay.tsmservice.data.Constant;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

/* loaded from: classes.dex */
public class BarcodeEAN extends Barcode {
    private static final int EVEN = 1;
    private static final int ODD = 0;
    private static final int TOTALBARS_EAN13 = 59;
    private static final int TOTALBARS_EAN8 = 43;
    private static final int TOTALBARS_SUPP2 = 13;
    private static final int TOTALBARS_SUPP5 = 31;
    private static final int TOTALBARS_UPCE = 33;
    private static final int[] GUARD_EMPTY = new int[0];
    private static final int[] GUARD_UPCA = {0, 2, 4, 6, 28, 30, 52, 54, 56, 58};
    private static final int[] GUARD_EAN13 = {0, 2, 28, 30, 56, 58};
    private static final int[] GUARD_EAN8 = {0, 2, 20, 22, 40, 42};
    private static final int[] GUARD_UPCE = {0, 2, 28, 30, 32};
    private static final float[] TEXTPOS_EAN13 = {6.5f, 13.5f, 20.5f, 27.5f, 34.5f, 41.5f, 53.5f, 60.5f, 67.5f, 74.5f, 81.5f, 88.5f};
    private static final float[] TEXTPOS_EAN8 = {6.5f, 13.5f, 20.5f, 27.5f, 39.5f, 46.5f, 53.5f, 60.5f};
    private static final byte[][] BARS = {new byte[]{3, 2, 1, 1}, new byte[]{2, 2, 2, 1}, new byte[]{2, 1, 2, 2}, new byte[]{1, 4, 1, 1}, new byte[]{1, 1, 3, 2}, new byte[]{1, 2, 3, 1}, new byte[]{1, 1, 1, 4}, new byte[]{1, 3, 1, 2}, new byte[]{1, 2, 1, 3}, new byte[]{3, 1, 1, 2}};
    private static final byte[][] PARITY13 = {new byte[]{0, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 1, 1, 0, 1}, new byte[]{0, 0, 1, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1, 1}, new byte[]{0, 1, 1, 0, 0, 1}, new byte[]{0, 1, 1, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1}, new byte[]{0, 1, 0, 1, 1, 0}, new byte[]{0, 1, 1, 0, 1, 0}};
    private static final byte[][] PARITY2 = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{1, 0}, new byte[]{1, 1}};
    private static final byte[][] PARITY5 = {new byte[]{1, 1, 0, 0, 0}, new byte[]{1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 1}};
    private static final byte[][] PARITYE = {new byte[]{1, 1, 1, 0, 0, 0}, new byte[]{1, 1, 0, 1, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0}, new byte[]{1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0, 1}};

    public BarcodeEAN() {
        try {
            this.f19648x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.guardBars = true;
            this.codeType = 1;
            this.code = "";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static int calculateEANParity(String str) {
        int i = 3;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (10 - (i2 % 10)) % 10;
    }

    public static String convertUPCAtoUPCE(String str) {
        if (str.length() == 12 && (str.startsWith("0") || str.startsWith("1"))) {
            if (str.substring(3, 6).equals(Constant.DEFAULT_CVN2) || str.substring(3, 6).equals(DiagnoseConstants.UI_TYPE_DIALOG) || str.substring(3, 6).equals("200")) {
                if (str.substring(6, 8).equals("00")) {
                    return str.substring(0, 1) + str.substring(1, 3) + str.substring(8, 11) + str.substring(3, 4) + str.substring(11);
                }
            } else if (str.substring(4, 6).equals("00")) {
                if (str.substring(6, 9).equals(Constant.DEFAULT_CVN2)) {
                    return str.substring(0, 1) + str.substring(1, 4) + str.substring(9, 11) + "3" + str.substring(11);
                }
            } else if (str.substring(5, 6).equals("0")) {
                if (str.substring(6, 10).equals("0000")) {
                    return str.substring(0, 1) + str.substring(1, 5) + str.substring(10, 11) + "4" + str.substring(11);
                }
            } else if (str.charAt(10) >= '5' && str.substring(6, 10).equals("0000")) {
                return str.substring(0, 1) + str.substring(1, 6) + str.substring(10, 11) + str.substring(11);
            }
            return null;
        }
        return null;
    }

    public static byte[] getBarsEAN13(String str) {
        int[] iArr = new int[str.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[59];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITY13[iArr[0]];
        int i2 = 0;
        int i3 = 3;
        while (i2 < bArr2.length) {
            int i4 = i2 + 1;
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i2] == 0) {
                int i5 = i3 + 1;
                bArr[i3] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i3 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i3 + 1;
                bArr[i3] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i3 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
            i2 = i4;
        }
        int i11 = i3 + 1;
        bArr[i3] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        int i14 = i13 + 1;
        bArr[i13] = 1;
        int i15 = i14 + 1;
        bArr[i14] = 1;
        for (int i16 = 7; i16 < 13; i16++) {
            byte[] bArr4 = BARS[iArr[i16]];
            int i17 = i15 + 1;
            bArr[i15] = bArr4[0];
            int i18 = i17 + 1;
            bArr[i17] = bArr4[1];
            int i19 = i18 + 1;
            bArr[i18] = bArr4[2];
            i15 = i19 + 1;
            bArr[i19] = bArr4[3];
        }
        int i20 = i15 + 1;
        bArr[i15] = 1;
        bArr[i20] = 1;
        bArr[i20 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsEAN8(String str) {
        int i;
        int[] iArr = new int[str.length()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[43];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i3 = 0;
        int i4 = 3;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            byte[] bArr2 = BARS[iArr[i3]];
            int i5 = i4 + 1;
            bArr[i4] = bArr2[0];
            int i6 = i5 + 1;
            bArr[i5] = bArr2[1];
            int i7 = i6 + 1;
            bArr[i6] = bArr2[2];
            i4 = i7 + 1;
            bArr[i7] = bArr2[3];
            i3++;
        }
        int i8 = i4 + 1;
        bArr[i4] = 1;
        int i9 = i8 + 1;
        bArr[i8] = 1;
        int i10 = i9 + 1;
        bArr[i9] = 1;
        int i11 = i10 + 1;
        bArr[i10] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        for (i = 4; i < 8; i++) {
            byte[] bArr3 = BARS[iArr[i]];
            int i13 = i12 + 1;
            bArr[i12] = bArr3[0];
            int i14 = i13 + 1;
            bArr[i13] = bArr3[1];
            int i15 = i14 + 1;
            bArr[i14] = bArr3[2];
            i12 = i15 + 1;
            bArr[i15] = bArr3[3];
        }
        int i16 = i12 + 1;
        bArr[i12] = 1;
        bArr[i16] = 1;
        bArr[i16 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsUPCE(String str) {
        int[] iArr = new int[str.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[33];
        byte b = iArr[0] != 0 ? (byte) 1 : (byte) 0;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITYE[iArr[iArr.length - 1]];
        int i2 = 3;
        for (int i3 = 1; i3 < iArr.length - 1; i3++) {
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3 - 1] == b) {
                int i4 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i5 = i4 + 1;
                bArr[i4] = bArr3[1];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[2];
                i2 = i6 + 1;
                bArr[i6] = bArr3[3];
            } else {
                int i7 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i8 = i7 + 1;
                bArr[i7] = bArr3[2];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[1];
                i2 = i9 + 1;
                bArr[i9] = bArr3[0];
            }
        }
        int i10 = i2 + 1;
        bArr[i2] = 1;
        int i11 = i10 + 1;
        bArr[i10] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        bArr[i13] = 1;
        bArr[i13 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsSupplemental2(String str) {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[13];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY2[((iArr[0] * 10) + iArr[1]) % 4];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 == 1) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] getBarsSupplemental5(String str) {
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[31];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY5[((((iArr[0] + iArr[2]) + iArr[4]) * 3) + ((iArr[1] + iArr[3]) * 9)) % 10];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 != 0) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        float f2 = this.barHeight;
        if (this.font != null) {
            if (this.baseline <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f2 += (-this.baseline) + this.size;
            } else {
                f2 += this.baseline - this.font.getFontDescriptor(3, this.size);
            }
        }
        switch (this.codeType) {
            case 1:
                f = this.f19648x * 95.0f;
                if (this.font != null) {
                    f += this.font.getWidthPoint(this.code.charAt(0), this.size);
                    break;
                }
                break;
            case 2:
                f = this.f19648x * 67.0f;
                break;
            case 3:
                f = this.f19648x * 95.0f;
                if (this.font != null) {
                    f += this.font.getWidthPoint(this.code.charAt(0), this.size) + this.font.getWidthPoint(this.code.charAt(11), this.size);
                    break;
                }
                break;
            case 4:
                f = this.f19648x * 51.0f;
                if (this.font != null) {
                    f += this.font.getWidthPoint(this.code.charAt(0), this.size) + this.font.getWidthPoint(this.code.charAt(7), this.size);
                    break;
                }
                break;
            case 5:
                f = this.f19648x * 20.0f;
                break;
            case 6:
                f = this.f19648x * 47.0f;
                break;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.type", new Object[0]));
        }
        return new Rectangle(f, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    @Override // com.itextpdf.text.pdf.Barcode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.itextpdf.text.Rectangle placeBarcode(com.itextpdf.text.pdf.PdfContentByte r18, com.itextpdf.text.BaseColor r19, com.itextpdf.text.BaseColor r20) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeEAN.placeBarcode(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Image createAwtImage(Color color, Color color2) {
        byte[] barsEAN13;
        int i;
        int rgb = color.getRGB();
        int rgb2 = color2.getRGB();
        Canvas canvas = new Canvas();
        switch (this.codeType) {
            case 1:
                barsEAN13 = getBarsEAN13(this.code);
                i = 95;
                break;
            case 2:
                barsEAN13 = getBarsEAN8(this.code);
                i = 67;
                break;
            case 3:
                barsEAN13 = getBarsEAN13("0" + this.code);
                i = 95;
                break;
            case 4:
                barsEAN13 = getBarsUPCE(this.code);
                i = 51;
                break;
            case 5:
                barsEAN13 = getBarsSupplemental2(this.code);
                i = 20;
                break;
            case 6:
                barsEAN13 = getBarsSupplemental5(this.code);
                i = 47;
                break;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.type", new Object[0]));
        }
        int i2 = (int) this.barHeight;
        int[] iArr = new int[i * i2];
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        while (i3 < barsEAN13.length) {
            byte b = barsEAN13[i3];
            int i5 = z ? rgb : rgb2;
            z = !z;
            int i6 = i4;
            int i7 = 0;
            while (i7 < b) {
                iArr[i6] = i5;
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        for (int i8 = i; i8 < iArr.length; i8 += i) {
            System.arraycopy(iArr, 0, iArr, i8, i);
        }
        return canvas.createImage(new MemoryImageSource(i, i2, iArr, 0, i));
    }
}
