package com.cnlaunch.p188n.p191c;

/* renamed from: com.cnlaunch.n.c.i */
/* loaded from: classes.dex */
public final class SocketTools {

    /* renamed from: a */
    private static String[] f9653a = new String[256];

    /* renamed from: b */
    private static byte[] f9654b = new byte[127];

    /* renamed from: a */
    public static int m8519a(byte b) {
        return b & 255;
    }

    static {
        for (int i = 0; i < 256; i++) {
            String hexString = Integer.toHexString(i);
            if (hexString.length() < 2) {
                f9653a[i] = "0".concat(String.valueOf(hexString));
            } else {
                f9653a[i] = hexString;
            }
            if (i < 127) {
                f9654b[i] = (byte) "0123456789ABCDEF".indexOf(i);
            }
        }
    }

    /* renamed from: a */
    public static int m8516a(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        System.arraycopy(bArr, 0, bArr2, i, length);
        return length;
    }

    /* renamed from: a */
    public static int m8517a(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: b */
    public static long m8515b(byte[] bArr, int i) {
        long j = bArr[i] & 255;
        for (int i2 = 1; i2 < 4; i2++) {
            j |= (bArr[i + i2] & 255) << (i2 * 8);
        }
        return j;
    }

    /* renamed from: a */
    public static String m8518a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        int i = length + 0;
        if (i > bArr.length) {
            return "";
        }
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(f9653a[bArr[i2] & 255]);
        }
        return sb.toString();
    }
}
