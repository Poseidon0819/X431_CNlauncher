package com.cnlaunch.physics.p205k;

/* renamed from: com.cnlaunch.physics.k.h */
/* loaded from: classes.dex */
public final class DPU_String {

    /* renamed from: a */
    public static String f10102a = "DPU_String";

    /* renamed from: e */
    public static int f10103e = 9;

    /* renamed from: f */
    public static int f10104f = 2;

    /* renamed from: g */
    public static int f10105g = 32;

    /* renamed from: b */
    int f10106b;

    /* renamed from: c */
    public int f10107c;

    /* renamed from: d */
    public String f10108d;

    public DPU_String(String str) {
        this.f10108d = str;
        this.f10107c = str.length() + 1;
        this.f10106b = str.length() + 3;
    }

    /* renamed from: a */
    public static byte[] m8161a(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 0 && bArr2.length > 0) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        throw new IllegalArgumentException("byte arguments error");
    }

    public final String toString() {
        return "DPU_String [len=" + this.f10106b + ", str=" + this.f10108d + "]";
    }
}
