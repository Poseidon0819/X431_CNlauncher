package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;

/* loaded from: classes.dex */
public class StandardDecryption {
    private static final int AES_128 = 4;
    private static final int AES_256 = 5;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean initiated;

    /* renamed from: iv */
    private byte[] f19809iv = new byte[16];
    private int ivptr;
    private byte[] key;

    public StandardDecryption(byte[] bArr, int i, int i2, int i3) {
        this.aes = i3 == 4 || i3 == 5;
        if (this.aes) {
            this.key = new byte[i2];
            System.arraycopy(bArr, i, this.key, 0, i2);
            return;
        }
        this.arcfour = new ARCFOUREncryption();
        this.arcfour.prepareARCFOURKey(bArr, i, i2);
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        if (this.aes) {
            if (this.initiated) {
                return this.cipher.update(bArr, i, i2);
            }
            int min = Math.min(this.f19809iv.length - this.ivptr, i2);
            System.arraycopy(bArr, i, this.f19809iv, this.ivptr, min);
            int i3 = i + min;
            int i4 = i2 - min;
            this.ivptr += min;
            int i5 = this.ivptr;
            byte[] bArr2 = this.f19809iv;
            if (i5 == bArr2.length) {
                this.cipher = new AESCipher(false, this.key, bArr2);
                this.initiated = true;
                if (i4 > 0) {
                    return this.cipher.update(bArr, i3, i4);
                }
                return null;
            }
            return null;
        }
        byte[] bArr3 = new byte[i2];
        this.arcfour.encryptARCFOUR(bArr, i, i2, bArr3, 0);
        return bArr3;
    }

    public byte[] finish() {
        if (this.aes) {
            return this.cipher.doFinal();
        }
        return null;
    }
}
