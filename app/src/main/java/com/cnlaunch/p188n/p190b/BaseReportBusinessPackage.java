package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p191c.CRC16;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.SocketTools;

/* renamed from: com.cnlaunch.n.b.b */
/* loaded from: classes.dex */
public class BaseReportBusinessPackage {

    /* renamed from: f */
    protected int f9571f;

    /* renamed from: g */
    protected int f9572g;

    /* renamed from: i */
    protected byte[] f9574i;

    /* renamed from: j */
    protected long f9575j;

    /* renamed from: k */
    protected int f9576k;

    /* renamed from: l */
    protected int f9577l;

    /* renamed from: m */
    protected String f9578m;

    /* renamed from: a */
    public final int f9566a = 3;

    /* renamed from: b */
    public final int f9567b = 4;

    /* renamed from: c */
    public final int f9568c = 5;

    /* renamed from: d */
    public final int f9569d = 6;

    /* renamed from: e */
    public final int f9570e = 7;

    /* renamed from: h */
    protected byte f9573h = 1;

    /* renamed from: a */
    public final void m8580a(int i) {
        this.f9572g = i;
    }

    /* renamed from: a */
    public static BaseReportBusinessPackage m8579a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BaseReportBusinessPackage baseReportBusinessPackage = new BaseReportBusinessPackage();
        baseReportBusinessPackage.f9571f = (int) SocketTools.m8515b(bArr, 0);
        if (baseReportBusinessPackage.f9571f != bArr.length) {
            MLog.m8522a("XMM", "Receive bad wlan Message!");
            return null;
        }
        baseReportBusinessPackage.f9572g = SocketTools.m8517a(bArr, 4);
        baseReportBusinessPackage.f9573h = bArr[6];
        baseReportBusinessPackage.f9577l = (short) (baseReportBusinessPackage.f9571f - 13);
        int i = baseReportBusinessPackage.f9577l;
        baseReportBusinessPackage.f9574i = new byte[i];
        System.arraycopy(bArr, 7, baseReportBusinessPackage.f9574i, 0, i);
        int i2 = baseReportBusinessPackage.f9577l + 7;
        baseReportBusinessPackage.f9575j = SocketTools.m8515b(bArr, i2);
        baseReportBusinessPackage.f9576k = SocketTools.m8517a(bArr, i2 + 4);
        return baseReportBusinessPackage;
    }

    /* renamed from: a */
    public final int m8581a() {
        return this.f9572g;
    }

    /* renamed from: b */
    public final byte[] m8578b() {
        return this.f9574i;
    }

    /* renamed from: c */
    public final byte[] m8577c() {
        this.f9575j = System.currentTimeMillis() / 1000;
        byte[] bArr = this.f9574i;
        this.f9577l = bArr.length;
        this.f9571f = bArr.length + 13;
        int i = this.f9571f;
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        bArr2[0] = (byte) (i & 255);
        bArr2[1] = (byte) ((i >> 8) & 255);
        bArr2[2] = (byte) ((i >> 16) & 255);
        bArr2[3] = (byte) ((i >> 24) & 255);
        int i3 = this.f9572g;
        bArr2[4] = (byte) (i3 & 255);
        bArr2[5] = (byte) ((i3 >> 8) & 255);
        bArr2[6] = this.f9573h;
        System.arraycopy(bArr, 0, bArr2, 7, this.f9577l);
        int i4 = this.f9577l + 7;
        int i5 = i4 + 1;
        long j = this.f9575j;
        bArr2[i4] = (byte) (j & 255);
        int i6 = i5 + 1;
        bArr2[i5] = (byte) ((j >> 8) & 255);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) ((j >> 16) & 255);
        int i8 = i7 + 1;
        bArr2[i7] = (byte) ((j >> 24) & 255);
        try {
            byte[] bArr3 = new byte[(this.f9571f - 2) + 32];
            System.arraycopy(bArr2, 0, bArr3, 0, this.f9571f - 2);
            System.arraycopy(this.f9578m.getBytes(), 0, bArr3, (this.f9571f - 2) + 0, 32);
            CRC16 m8528a = CRC16.m8528a();
            byte b = 255;
            int i9 = 255;
            while (i2 < bArr3.length) {
                int i10 = (b ^ bArr3[i2]) & 255;
                int i11 = i9 ^ m8528a.f9639a[i10];
                i2++;
                i9 = m8528a.f9640b[i10];
                b = i11;
            }
            this.f9576k = (b << 8) | i9;
            bArr2[i8] = (byte) (this.f9576k & 255);
            bArr2[i8 + 1] = (byte) ((this.f9576k >> 8) & 255);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr2;
    }

    public String toString() {
        return "business id:" + this.f9572g + "length:" + this.f9571f;
    }
}
