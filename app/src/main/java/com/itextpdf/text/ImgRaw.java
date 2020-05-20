package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.net.URL;

/* loaded from: classes.dex */
public class ImgRaw extends Image {
    ImgRaw(Image image) {
        super(image);
    }

    public ImgRaw(int i, int i2, int i3, int i4, byte[] bArr) throws BadElementException {
        super((URL) null);
        this.type = 34;
        this.scaledHeight = i2;
        setTop(this.scaledHeight);
        this.scaledWidth = i;
        setRight(this.scaledWidth);
        if (i3 != 1 && i3 != 3 && i3 != 4) {
            throw new BadElementException(MessageLocalization.getComposedMessage("components.must.be.1.3.or.4", new Object[0]));
        }
        if (i4 != 1 && i4 != 2 && i4 != 4 && i4 != 8) {
            throw new BadElementException(MessageLocalization.getComposedMessage("bits.per.component.must.be.1.2.4.or.8", new Object[0]));
        }
        this.colorspace = i3;
        this.bpc = i4;
        this.rawData = bArr;
        this.plainWidth = getWidth();
        this.plainHeight = getHeight();
    }
}
