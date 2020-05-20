package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.codec.TIFFFaxDecoder;
import java.net.URL;

/* loaded from: classes.dex */
public class ImgCCITT extends Image {
    ImgCCITT(Image image) {
        super(image);
    }

    public ImgCCITT(int i, int i2, boolean z, int i3, int i4, byte[] bArr) throws BadElementException {
        super((URL) null);
        if (i3 != 256 && i3 != 257 && i3 != 258) {
            throw new BadElementException(MessageLocalization.getComposedMessage("the.ccitt.compression.type.must.be.ccittg4.ccittg3.1d.or.ccittg3.2d", new Object[0]));
        }
        if (z) {
            TIFFFaxDecoder.reverseBits(bArr);
        }
        this.type = 34;
        this.scaledHeight = i2;
        setTop(this.scaledHeight);
        this.scaledWidth = i;
        setRight(this.scaledWidth);
        this.colorspace = i4;
        this.bpc = i3;
        this.rawData = bArr;
        this.plainWidth = getWidth();
        this.plainHeight = getHeight();
    }
}
