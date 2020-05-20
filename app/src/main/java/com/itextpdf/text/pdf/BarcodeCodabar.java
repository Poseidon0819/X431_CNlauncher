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
public class BarcodeCodabar extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 0}, new byte[]{1, 0, 0, 0, 1, 0, 1}, new byte[]{1, 0, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 0, 1, 0, 0}, new byte[]{0, 0, 1, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0, 1, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1}, new byte[]{0, 0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 0, 1, 1, 1, 0}};
    private static final String CHARS = "0123456789-$:/.+ABCD";
    private static final int START_STOP_IDX = 16;

    public BarcodeCodabar() {
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
            this.startStopText = false;
            this.codeType = 12;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCodabar(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        if (length < 2) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("codabar.must.have.at.least.a.start.and.stop.character", new Object[0]));
        }
        if (CHARS.indexOf(upperCase.charAt(0)) >= 16) {
            int i = length - 1;
            if (CHARS.indexOf(upperCase.charAt(i)) >= 16) {
                byte[] bArr = new byte[(upperCase.length() * 8) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int indexOf = CHARS.indexOf(upperCase.charAt(i2));
                    if (indexOf >= 16 && i2 > 0 && i2 < i) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("in.codabar.start.stop.characters.are.only.allowed.at.the.extremes", new Object[0]));
                    }
                    if (indexOf < 0) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.codabar", upperCase.charAt(i2)));
                    }
                    System.arraycopy(BARS[indexOf], 0, bArr, i2 * 8, 7);
                }
                return bArr;
            }
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("codabar.must.have.one.of.abcd.as.start.stop.character", new Object[0]));
    }

    public static String calculateChecksum(String str) {
        if (str.length() < 2) {
            return str;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += CHARS.indexOf(upperCase.charAt(i2));
        }
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(str.substring(0, i3));
        sb.append(CHARS.charAt((((i + 15) / 16) * 16) - i));
        sb.append(str.substring(i3));
        return sb.toString();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        byte[] barsCodabar;
        String str = this.code;
        if (this.generateChecksum && this.checksumText) {
            str = calculateChecksum(this.code);
        }
        if (!this.startStopText) {
            str = str.substring(1, str.length() - 1);
        }
        BaseFont baseFont = this.font;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.baseline > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont2.getWidthPoint(str, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        String str2 = this.code;
        if (this.generateChecksum) {
            str2 = calculateChecksum(this.code);
        }
        int i = 0;
        for (byte b : getBarsCodabar(str2)) {
            i += b;
        }
        return new Rectangle(Math.max(this.f19648x * ((barsCodabar.length - i) + (i * this.f19647n)), f), this.barHeight + f2);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float f;
        float f2;
        float f3;
        float f4;
        String str = this.code;
        if (this.generateChecksum && this.checksumText) {
            str = calculateChecksum(this.code);
        }
        boolean z = true;
        if (!this.startStopText) {
            str = str.substring(1, str.length() - 1);
        }
        BaseFont baseFont = this.font;
        float f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont2.getWidthPoint(str, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        byte[] barsCodabar = getBarsCodabar(this.generateChecksum ? calculateChecksum(this.code) : this.code);
        int i = 0;
        for (byte b : barsCodabar) {
            i += b;
        }
        float length = this.f19648x * ((barsCodabar.length - i) + (i * this.f19647n));
        int i2 = this.textAlignment;
        if (i2 == 0) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (i2 != 2) {
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
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        for (byte b2 : barsCodabar) {
            float f7 = b2 == 0 ? this.f19648x : this.f19648x * this.f19647n;
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
        String str = this.code;
        if (this.generateChecksum && this.checksumText) {
            str = calculateChecksum(this.code);
        }
        if (!this.startStopText) {
            str.substring(1, str.length() - 1);
        }
        byte[] barsCodabar = getBarsCodabar(this.generateChecksum ? calculateChecksum(this.code) : this.code);
        int i = 0;
        for (int i2 : barsCodabar) {
            i += i2;
        }
        int length = (barsCodabar.length - i) + (i * ((int) this.f19647n));
        int i3 = (int) this.barHeight;
        int[] iArr = new int[length * i3];
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        while (i4 < barsCodabar.length) {
            int i6 = barsCodabar[i4] == 0 ? 1 : (int) this.f19647n;
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
        for (int i10 = length; i10 < iArr.length; i10 += length) {
            System.arraycopy(iArr, 0, iArr, i10, length);
        }
        return canvas.createImage(new MemoryImageSource(length, i3, iArr, 0, length));
    }
}
