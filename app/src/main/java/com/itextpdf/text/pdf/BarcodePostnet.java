package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

/* loaded from: classes.dex */
public class BarcodePostnet extends Barcode {
    private static final byte[][] BARS = {new byte[]{1, 1, 0, 0, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 0, 1, 0, 1}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0}};

    public BarcodePostnet() {
        this.f19647n = 3.2727273f;
        this.f19648x = 1.4399999f;
        this.barHeight = 9.0f;
        this.size = 3.6000001f;
        this.codeType = 7;
    }

    public static byte[] getBarsPostnet(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i += str.charAt(length) - '0';
        }
        String str2 = str + ((char) (((10 - (i % 10)) % 10) + 48));
        byte[] bArr = new byte[(str2.length() * 5) + 2];
        bArr[0] = 1;
        bArr[bArr.length - 1] = 1;
        for (int i2 = 0; i2 < str2.length(); i2++) {
            System.arraycopy(BARS[str2.charAt(i2) - '0'], 0, bArr, (i2 * 5) + 1, 5);
        }
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        return new Rectangle(((((this.code.length() + 1) * 5) + 1) * this.f19647n) + this.f19648x, this.barHeight);
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor != null) {
            pdfContentByte.setColorFill(baseColor);
        }
        byte[] barsPostnet = getBarsPostnet(this.code);
        byte b = 1;
        if (this.codeType == 8) {
            barsPostnet[0] = 0;
            barsPostnet[barsPostnet.length - 1] = 0;
            b = 0;
        }
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (byte b2 : barsPostnet) {
            pdfContentByte.rectangle(f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f19648x - this.inkSpreading, b2 == b ? this.barHeight : this.size);
            f += this.f19647n;
        }
        pdfContentByte.fill();
        return getBarcodeSize();
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Image createAwtImage(Color color, Color color2) {
        byte b;
        int rgb = color.getRGB();
        int rgb2 = color2.getRGB();
        Canvas canvas = new Canvas();
        int i = (int) this.f19648x;
        if (i <= 0) {
            i = 1;
        }
        int i2 = (int) this.f19647n;
        if (i2 <= i) {
            i2 = i + 1;
        }
        int i3 = (int) this.size;
        if (i3 <= 0) {
            i3 = 1;
        }
        int i4 = (int) this.barHeight;
        int i5 = i4 <= i3 ? i3 + 1 : i4;
        int length = ((((this.code.length() + 1) * 5) + 1) * i2) + i;
        int[] iArr = new int[length * i5];
        byte[] barsPostnet = getBarsPostnet(this.code);
        int i6 = 0;
        if (this.codeType == 8) {
            barsPostnet[0] = 0;
            barsPostnet[barsPostnet.length - 1] = 0;
            b = 0;
        } else {
            b = 1;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < barsPostnet.length) {
            boolean z = barsPostnet[i7] == b;
            while (i6 < i2) {
                iArr[i8 + i6] = (!z || i6 >= i) ? rgb2 : rgb;
                i6++;
            }
            i8 += i2;
            i7++;
            i6 = 0;
        }
        int i9 = (i5 - i3) * length;
        for (int i10 = length; i10 < i9; i10 += length) {
            System.arraycopy(iArr, 0, iArr, i10, length);
        }
        int i11 = i9;
        for (int i12 = 0; i12 < barsPostnet.length; i12++) {
            int i13 = 0;
            while (i13 < i2) {
                iArr[i11 + i13] = i13 < i ? rgb : rgb2;
                i13++;
            }
            i11 += i2;
        }
        for (int i14 = i9 + length; i14 < iArr.length; i14 += length) {
            System.arraycopy(iArr, i9, iArr, i14, length);
        }
        return canvas.createImage(new MemoryImageSource(length, i5, iArr, 0, length));
    }
}
