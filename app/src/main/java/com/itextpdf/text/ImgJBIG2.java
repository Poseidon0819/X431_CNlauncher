package com.itextpdf.text;

import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class ImgJBIG2 extends Image {
    private byte[] global;
    private byte[] globalHash;

    ImgJBIG2(Image image) {
        super(image);
    }

    public ImgJBIG2() {
        super((Image) null);
    }

    public ImgJBIG2(int i, int i2, byte[] bArr, byte[] bArr2) {
        super((URL) null);
        this.type = 36;
        this.originalType = 9;
        this.scaledHeight = i2;
        setTop(this.scaledHeight);
        this.scaledWidth = i;
        setRight(this.scaledWidth);
        this.bpc = 1;
        this.colorspace = 1;
        this.rawData = bArr;
        this.plainWidth = getWidth();
        this.plainHeight = getHeight();
        if (bArr2 != null) {
            this.global = bArr2;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(this.global);
                this.globalHash = messageDigest.digest();
            } catch (Exception unused) {
            }
        }
    }

    public byte[] getGlobalBytes() {
        return this.global;
    }

    public byte[] getGlobalHash() {
        return this.globalHash;
    }
}
