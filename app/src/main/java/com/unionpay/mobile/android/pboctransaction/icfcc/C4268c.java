package com.unionpay.mobile.android.pboctransaction.icfcc;

import com.unionpay.mobile.android.pboctransaction.C4264e;

/* renamed from: com.unionpay.mobile.android.pboctransaction.icfcc.c */
/* loaded from: classes2.dex */
public final class C4268c {
    /* renamed from: a */
    public static String m1292a(String str, String str2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (str == null) {
            return null;
        }
        byte[] m1305a = C4264e.m1305a(str);
        int i11 = 0;
        while (i11 < m1305a.length) {
            int i12 = 1;
            int i13 = ((byte) (m1305a[i11] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i13];
            System.arraycopy(m1305a, i11, bArr, 0, i13);
            if (C4264e.m1301a(bArr, i13).compareToIgnoreCase(str2) == 0) {
                int i14 = i11 + i13;
                if (((byte) (m1305a[i14] & 128)) != Byte.MIN_VALUE) {
                    i4 = m1305a[i14];
                } else {
                    i12 = 1 + (m1305a[i14] & 127);
                    if (i12 != 2) {
                        if (i12 == 3) {
                            i2 = (m1305a[i14 + 1] & 255) << 8;
                            i3 = m1305a[i14 + 2];
                        } else if (i12 != 4) {
                            i = 0;
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(m1305a, i14 + i12, bArr2, 0, i);
                            return C4264e.m1301a(bArr2, i);
                        } else {
                            i2 = ((m1305a[i14 + 1] & 255) << 16) | ((m1305a[i14 + 2] & 255) << 8);
                            i3 = m1305a[i14 + 3];
                        }
                        i = i2 | (i3 & 255);
                        byte[] bArr22 = new byte[i];
                        System.arraycopy(m1305a, i14 + i12, bArr22, 0, i);
                        return C4264e.m1301a(bArr22, i);
                    }
                    i4 = m1305a[i14 + 1];
                }
                i = i4 & 255;
                byte[] bArr222 = new byte[i];
                System.arraycopy(m1305a, i14 + i12, bArr222, 0, i);
                return C4264e.m1301a(bArr222, i);
            }
            if ((m1305a[i11] & 32) == 32) {
                i5 = i11 + i13;
                if (i5 < m1305a.length && ((byte) (m1305a[i5] & 128)) == Byte.MIN_VALUE) {
                    i12 = 1 + (m1305a[i5] & 127);
                }
            } else {
                i5 = i11 + i13;
                if (i5 >= m1305a.length || ((byte) (m1305a[i5] & 128)) != 0) {
                    i12 = i5 < m1305a.length ? (m1305a[i5] & 127) + 1 : 0;
                    if (i12 != 2 || (i9 = i5 + 1) >= m1305a.length) {
                        i6 = (i12 != 3 || (i8 = i5 + 2) >= m1305a.length) ? (i12 != 4 || (i7 = i5 + 2) >= m1305a.length) ? 0 : ((m1305a[i7] & 255) << 8) | ((m1305a[i5 + 1] & 255) << 16) | (m1305a[i5 + 3] & 255) : (m1305a[i8] & 255) | ((m1305a[i5 + 1] & 255) << 8);
                        i12 += i6;
                    } else {
                        i10 = m1305a[i9];
                    }
                } else {
                    i10 = m1305a[i5];
                }
                i6 = i10 & 255;
                i12 += i6;
            }
            i11 = i5 + i12;
        }
        return null;
    }
}
