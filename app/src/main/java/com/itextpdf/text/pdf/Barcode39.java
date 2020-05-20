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
public class Barcode39 extends Barcode {
    private static final byte[][] BARS = {new byte[]{0, 0, 0, 1, 1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0, 0, 0, 0, 1}, new byte[]{0, 0, 1, 1, 0, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 1, 1, 1, 0, 0, 0, 0}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 1}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0, 0, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 0, 1, 0, 0, 1}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 1}, new byte[]{1, 0, 0, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 0, 0, 1, 1, 0, 1}, new byte[]{1, 0, 0, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0}, new byte[]{0, 0, 0, 0, 1, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 0, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 0, 1, 1}, new byte[]{1, 0, 0, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 1, 0, 1, 0, 0, 1, 0}, new byte[]{0, 0, 0, 0, 0, 0, 1, 1, 1}, new byte[]{1, 0, 0, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 0, 1, 0, 1, 1, 0}, new byte[]{1, 1, 0, 0, 0, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0, 0, 0, 0, 1}, new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 1, 0, 0, 0, 1}, new byte[]{1, 1, 0, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 1, 0, 1, 0, 0, 0, 0}, new byte[]{0, 1, 0, 0, 0, 0, 1, 0, 1}, new byte[]{1, 1, 0, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 1, 0, 0, 0, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1, 0, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 0, 1, 0}, new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0}, new byte[]{0, 0, 0, 1, 0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 0}};
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%*";
    private static final String EXTENDED = "%U$A$B$C$D$E$F$G$H$I$J$K$L$M$N$O$P$Q$R$S$T$U$V$W$X$Y$Z%A%B%C%D%E  /A/B/C/D/E/F/G/H/I/J/K/L - ./O 0 1 2 3 4 5 6 7 8 9/Z%F%G%H%I%J%V A B C D E F G H I J K L M N O P Q R S T U V W X Y Z%K%L%M%N%O%W+A+B+C+D+E+F+G+H+I+J+K+L+M+N+O+P+Q+R+S+T+U+V+W+X+Y+Z%P%Q%R%S%T";

    public Barcode39() {
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
            this.startStopText = true;
            this.extended = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCode39(String str) {
        String str2 = "*" + str + "*";
        byte[] bArr = new byte[(str2.length() * 10) - 1];
        for (int i = 0; i < str2.length(); i++) {
            int indexOf = CHARS.indexOf(str2.charAt(i));
            if (indexOf < 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39", str2.charAt(i)));
            }
            System.arraycopy(BARS[indexOf], 0, bArr, i * 10, 9);
        }
        return bArr;
    }

    public static String getCode39Ex(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > 127) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39.extended", charAt));
            }
            int i2 = charAt * 2;
            char charAt2 = EXTENDED.charAt(i2);
            char charAt3 = EXTENDED.charAt(i2 + 1);
            if (charAt2 != ' ') {
                sb.append(charAt2);
            }
            sb.append(charAt3);
        }
        return sb.toString();
    }

    static char getChecksum(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int indexOf = CHARS.indexOf(str.charAt(i2));
            if (indexOf < 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.character.1.is.illegal.in.code.39", str.charAt(i2)));
            }
            i += indexOf;
        }
        return CHARS.charAt(i % 43);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String str = this.code;
        if (this.extended) {
            str = getCode39Ex(this.code);
        }
        BaseFont baseFont = this.font;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.baseline > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            String str2 = this.code;
            if (this.generateChecksum && this.checksumText) {
                str2 = str2 + getChecksum(str);
            }
            if (this.startStopText) {
                str2 = "*" + str2 + "*";
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str2 = this.altText;
            }
            f = baseFont2.getWidthPoint(str2, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        int length = str.length() + 2;
        if (this.generateChecksum) {
            length++;
        }
        return new Rectangle(Math.max((length * ((this.f19648x * 6.0f) + (this.f19648x * 3.0f * this.f19647n))) + ((length - 1) * this.f19648x), f), this.barHeight + f2);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        float f;
        int length;
        float f2;
        float f3;
        float f4;
        String str = this.code;
        String str2 = this.code;
        if (this.extended) {
            str2 = getCode39Ex(this.code);
        }
        BaseFont baseFont = this.font;
        float f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (baseFont != null) {
            if (this.generateChecksum && this.checksumText) {
                str = str + getChecksum(str2);
            }
            if (this.startStopText) {
                str = "*" + str + "*";
            }
            BaseFont baseFont2 = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont2.getWidthPoint(str, this.size);
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.generateChecksum) {
            str2 = str2 + getChecksum(str2);
        }
        boolean z = true;
        float length2 = ((str2.length() + 2) * ((this.f19648x * 6.0f) + (this.f19648x * 3.0f * this.f19647n))) + ((length - 1) * this.f19648x);
        int i = this.textAlignment;
        if (i == 0) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else if (i != 2) {
            if (f > length2) {
                f2 = (f - length2) / 2.0f;
                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                f3 = (length2 - f) / 2.0f;
                f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
        } else if (f > length2) {
            f2 = f - length2;
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        } else {
            f3 = length2 - f;
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
        byte[] barsCode39 = getBarsCode39(str2);
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        for (byte b : barsCode39) {
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
        String str = this.code;
        if (this.extended) {
            str = getCode39Ex(this.code);
        }
        if (this.generateChecksum) {
            str = str + getChecksum(str);
        }
        int length = str.length() + 2;
        int i = (int) this.f19647n;
        int i2 = (((i * 3) + 6) * length) + (length - 1);
        byte[] barsCode39 = getBarsCode39(str);
        int i3 = (int) this.barHeight;
        int[] iArr = new int[i2 * i3];
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        while (i4 < barsCode39.length) {
            int i6 = barsCode39[i4] == 0 ? 1 : i;
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
