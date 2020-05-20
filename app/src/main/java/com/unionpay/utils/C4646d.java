package com.unionpay.utils;

/* renamed from: com.unionpay.utils.d */
/* loaded from: classes2.dex */
public final class C4646d {
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] m452a(int r7, byte[] r8, byte[] r9) {
        /*
            if (r8 == 0) goto L63
            int r0 = r8.length
            r1 = 24
            r2 = 16
            r3 = 8
            if (r0 == r3) goto L11
            int r0 = r8.length
            if (r0 == r2) goto L11
            int r0 = r8.length
            if (r0 != r1) goto L63
        L11:
            if (r9 == 0) goto L5d
            java.lang.String r0 = "DESede/ECB/NoPadding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            byte[] r4 = new byte[r1]
            int r5 = r8.length
            r6 = 0
            if (r5 != r3) goto L29
            java.lang.System.arraycopy(r8, r6, r4, r6, r3)
            java.lang.System.arraycopy(r8, r6, r4, r3, r3)
        L25:
            java.lang.System.arraycopy(r8, r6, r4, r2, r3)
            goto L33
        L29:
            int r5 = r8.length
            if (r5 != r2) goto L30
            java.lang.System.arraycopy(r8, r6, r4, r6, r2)
            goto L25
        L30:
            java.lang.System.arraycopy(r8, r6, r4, r6, r1)
        L33:
            int r8 = r9.length
            int r8 = r8 % r3
            r1 = 1
            if (r8 == 0) goto L49
            int r8 = r9.length
            int r8 = r8 / r3
            int r8 = r8 + r1
            int r8 = r8 * 8
            byte[] r8 = new byte[r8]
            int r2 = r9.length
            java.lang.System.arraycopy(r9, r6, r8, r6, r2)
            int r9 = r9.length
            int r2 = r8.length
            java.util.Arrays.fill(r8, r9, r2, r6)
            goto L4a
        L49:
            r8 = r9
        L4a:
            if (r7 == 0) goto L4d
            goto L4e
        L4d:
            r1 = 2
        L4e:
            javax.crypto.spec.SecretKeySpec r7 = new javax.crypto.spec.SecretKeySpec
            java.lang.String r9 = "DESede"
            r7.<init>(r4, r9)
            r0.init(r1, r7)
            byte[] r7 = r0.doFinal(r8)
            return r7
        L5d:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
        L63:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.utils.C4646d.m452a(int, byte[], byte[]):byte[]");
    }

    /* renamed from: a */
    public static byte[] m451a(byte[] bArr, byte[] bArr2) {
        return m452a(1, bArr, bArr2);
    }

    /* renamed from: b */
    public static byte[] m450b(byte[] bArr, byte[] bArr2) {
        return m452a(0, bArr, bArr2);
    }
}
