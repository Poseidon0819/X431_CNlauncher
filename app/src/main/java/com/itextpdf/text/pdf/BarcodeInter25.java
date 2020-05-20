package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

/* loaded from: classes.dex */
public class BarcodeInter25 extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0}};

    public BarcodeInter25() {
        try {
            this.f19648x = 0.8f;
            this.f19647n = 2.0f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.textAlignment = 1;
            this.generateChecksum = false;
            this.checksumText = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String keepNumbers(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static char getChecksum(String str) {
        int i = 3;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (char) (((10 - (i2 % 10)) % 10) + 48);
    }

    public static byte[] getBarsInter25(String str) {
        String keepNumbers = keepNumbers(str);
        if ((keepNumbers.length() & 1) != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.text.length.must.be.even", new Object[0]));
        }
        byte[] bArr = new byte[(keepNumbers.length() * 5) + 7];
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i = 4;
        bArr[3] = 0;
        int length = keepNumbers.length() / 2;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 2;
            byte[][] bArr2 = BARS;
            byte[] bArr3 = bArr2[keepNumbers.charAt(i3) - '0'];
            byte[] bArr4 = bArr2[keepNumbers.charAt(i3 + 1) - '0'];
            int i4 = i;
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = i4 + 1;
                bArr[i4] = bArr3[i5];
                i4 = i6 + 1;
                bArr[i6] = bArr4[i5];
            }
            i2++;
            i = i4;
        }
        int i7 = i + 1;
        bArr[i] = 1;
        bArr[i7] = 0;
        bArr[i7 + 1] = 0;
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        BaseFont baseFont = this.font;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.baseline > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            String str = this.code;
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(str);
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont2.getWidthPoint(str, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        int length = keepNumbers(this.code).length();
        if (this.generateChecksum) {
            length++;
        }
        return new Rectangle(Math.max((length * ((this.f19648x * 3.0f) + (this.f19648x * 2.0f * this.f19647n))) + ((this.f19647n + 6.0f) * this.f19648x), f), this.barHeight + f2);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float f;
        float f2;
        float f3;
        float f4;
        String str = this.code;
        BaseFont baseFont = this.font;
        float f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(str);
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont2.getWidthPoint(str, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        String keepNumbers = keepNumbers(this.code);
        if (this.generateChecksum) {
            keepNumbers = keepNumbers + getChecksum(keepNumbers);
        }
        float length = (keepNumbers.length() * ((this.f19648x * 3.0f) + (this.f19648x * 2.0f * this.f19647n))) + ((this.f19647n + 6.0f) * this.f19648x);
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
            f4 = f6;
            f5 = this.baseline + f6;
        }
        byte[] barsInter25 = getBarsInter25(keepNumbers);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        boolean z = true;
        for (byte b : barsInter25) {
            float f7 = b == 0 ? this.f19648x : this.f19648x * this.f19647n;
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
            pdfContentByte.showText(str);
            pdfContentByte.endText();
        }
        return getBarcodeSize();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Image createAwtImage(Color color, Color color2) {
        int rgb = color.getRGB();
        int rgb2 = color2.getRGB();
        Canvas canvas = new Canvas();
        String keepNumbers = keepNumbers(this.code);
        if (this.generateChecksum) {
            keepNumbers = keepNumbers + getChecksum(keepNumbers);
        }
        int length = keepNumbers.length();
        int i = (int) this.f19647n;
        int i2 = (length * ((i * 2) + 3)) + i + 6;
        byte[] barsInter25 = getBarsInter25(keepNumbers);
        int i3 = (int) this.barHeight;
        int[] iArr = new int[i2 * i3];
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        while (i4 < barsInter25.length) {
            int i6 = barsInter25[i4] == 0 ? 1 : i;
            int i7 = z ? rgb : rgb2;
            z = !z;
            int i8 = i5;
            int i9 = 0;
            while (i9 < i6) {
                iArr[i8] = i7;
                i9++;
                i8++;
            }
            i4++;
            i5 = i8;
        }
        for (int i10 = i2; i10 < iArr.length; i10 += i2) {
            System.arraycopy(iArr, 0, iArr, i10, i2);
        }
        return canvas.createImage(new MemoryImageSource(i2, i3, iArr, 0, i2));
    }
}
