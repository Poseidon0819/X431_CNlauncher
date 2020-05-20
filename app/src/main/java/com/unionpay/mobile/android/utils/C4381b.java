package com.unionpay.mobile.android.utils;

/* renamed from: com.unionpay.mobile.android.utils.b */
/* loaded from: classes2.dex */
public final class C4381b {
    /* renamed from: a */
    public static String m889a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            sb.append("0123456789abcdef".charAt(i >> 4));
            sb.append("0123456789abcdef".charAt(i & 15));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m890a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }
}
