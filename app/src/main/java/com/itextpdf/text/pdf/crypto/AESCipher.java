package com.itextpdf.text.pdf.crypto;

import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class AESCipher {

    /* renamed from: bp */
    private PaddedBufferedBlockCipher f19842bp = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()));

    public AESCipher(boolean z, byte[] bArr, byte[] bArr2) {
        this.f19842bp.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.f19842bp.getUpdateOutputSize(i2);
        byte[] bArr2 = updateOutputSize > 0 ? new byte[updateOutputSize] : null;
        this.f19842bp.processBytes(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    public byte[] doFinal() {
        int outputSize = this.f19842bp.getOutputSize(0);
        byte[] bArr = new byte[outputSize];
        try {
            int doFinal = this.f19842bp.doFinal(bArr, 0);
            if (doFinal != outputSize) {
                byte[] bArr2 = new byte[doFinal];
                System.arraycopy(bArr, 0, bArr2, 0, doFinal);
                return bArr2;
            }
            return bArr;
        } catch (Exception unused) {
            return bArr;
        }
    }
}
