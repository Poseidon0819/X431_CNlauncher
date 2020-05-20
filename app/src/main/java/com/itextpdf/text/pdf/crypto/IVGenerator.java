package com.itextpdf.text.pdf.crypto;

/* loaded from: classes.dex */
public final class IVGenerator {
    private static ARCFOUREncryption arcfour = new ARCFOUREncryption();

    static {
        arcfour.prepareARCFOURKey((System.currentTimeMillis() + "+" + Runtime.getRuntime().freeMemory()).getBytes());
    }

    private IVGenerator() {
    }

    public static byte[] getIV() {
        return getIV(16);
    }

    public static byte[] getIV(int i) {
        byte[] bArr = new byte[i];
        synchronized (arcfour) {
            arcfour.encryptARCFOUR(bArr);
        }
        return bArr;
    }
}
