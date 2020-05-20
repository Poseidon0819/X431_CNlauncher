package com.unionpay.mobile.android.hce;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* renamed from: com.unionpay.mobile.android.hce.a */
/* loaded from: classes2.dex */
public final class C4151a {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:3:0x0001, B:5:0x000a, B:8:0x0013, B:10:0x0025, B:12:0x0045, B:14:0x0063), top: B:20:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1607a(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            java.lang.String r1 = "UTF-8"
            byte[] r9 = r9.getBytes(r1)     // Catch: java.lang.Exception -> L6e
            r1 = 2
            if (r8 == 0) goto L44
            java.lang.String r2 = ""
            boolean r2 = r8.equals(r2)     // Catch: java.lang.Exception -> L6e
            if (r2 == 0) goto L13
            goto L44
        L13:
            java.lang.String r8 = r8.toUpperCase()     // Catch: java.lang.Exception -> L6e
            int r2 = r8.length()     // Catch: java.lang.Exception -> L6e
            int r2 = r2 / r1
            char[] r8 = r8.toCharArray()     // Catch: java.lang.Exception -> L6e
            byte[] r3 = new byte[r2]     // Catch: java.lang.Exception -> L6e
            r4 = 0
        L23:
            if (r4 >= r2) goto L45
            int r5 = r4 * 2
            char r6 = r8[r5]     // Catch: java.lang.Exception -> L6e
            java.lang.String r7 = "0123456789ABCDEF"
            int r6 = r7.indexOf(r6)     // Catch: java.lang.Exception -> L6e
            byte r6 = (byte) r6     // Catch: java.lang.Exception -> L6e
            int r6 = r6 << 4
            int r5 = r5 + 1
            char r5 = r8[r5]     // Catch: java.lang.Exception -> L6e
            java.lang.String r7 = "0123456789ABCDEF"
            int r5 = r7.indexOf(r5)     // Catch: java.lang.Exception -> L6e
            byte r5 = (byte) r5     // Catch: java.lang.Exception -> L6e
            r5 = r5 | r6
            byte r5 = (byte) r5     // Catch: java.lang.Exception -> L6e
            r3[r4] = r5     // Catch: java.lang.Exception -> L6e
            int r4 = r4 + 1
            goto L23
        L44:
            r3 = r0
        L45:
            javax.crypto.spec.DESedeKeySpec r8 = new javax.crypto.spec.DESedeKeySpec     // Catch: java.lang.Exception -> L6e
            r8.<init>(r9)     // Catch: java.lang.Exception -> L6e
            java.lang.String r9 = "desede"
            javax.crypto.SecretKeyFactory r9 = javax.crypto.SecretKeyFactory.getInstance(r9)     // Catch: java.lang.Exception -> L6e
            javax.crypto.SecretKey r8 = r9.generateSecret(r8)     // Catch: java.lang.Exception -> L6e
            java.lang.String r9 = "DESEDE/ECB/PKCS5Padding"
            javax.crypto.Cipher r9 = javax.crypto.Cipher.getInstance(r9)     // Catch: java.lang.Exception -> L6e
            r9.init(r1, r8)     // Catch: java.lang.Exception -> L6e
            byte[] r8 = r9.doFinal(r3)     // Catch: java.lang.Exception -> L6e
            if (r8 == 0) goto L6b
            java.lang.String r9 = new java.lang.String     // Catch: java.lang.Exception -> L6e
            java.lang.String r1 = "UTF-8"
            r9.<init>(r8, r1)     // Catch: java.lang.Exception -> L6e
            goto L73
        L6b:
            java.lang.String r8 = ""
            return r8
        L6e:
            r8 = move-exception
            r8.printStackTrace()
            r9 = r0
        L73:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.hce.C4151a.m1607a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m1606a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m1605b(String str, String str2) {
        byte[] bArr;
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            byte[] bytes2 = str.getBytes();
            SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(bytes));
            Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
            cipher.init(1, generateSecret);
            bArr = cipher.doFinal(bytes2);
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        return m1606a(bArr);
    }
}
