package com.cnlaunch.p188n.p190b;

import com.cnlaunch.p188n.p191c.CRC16;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.SocketTools;

/* renamed from: com.cnlaunch.n.b.a */
/* loaded from: classes.dex */
public class BaseRemoteBusinessPackage {

    /* renamed from: a */
    protected int f9551a;

    /* renamed from: b */
    protected int f9552b;

    /* renamed from: c */
    protected int f9553c;

    /* renamed from: e */
    protected byte[] f9555e;

    /* renamed from: f */
    protected long f9556f;

    /* renamed from: g */
    protected int f9557g;

    /* renamed from: h */
    protected int f9558h;

    /* renamed from: j */
    protected String f9560j;

    /* renamed from: k */
    protected String f9561k;

    /* renamed from: m */
    protected byte f9563m;

    /* renamed from: n */
    protected byte f9564n;

    /* renamed from: o */
    int f9565o;

    /* renamed from: d */
    protected int f9554d = 128;

    /* renamed from: i */
    protected String f9559i = "123456789";

    /* renamed from: l */
    protected int f9562l = 0;

    /* renamed from: a */
    public static int m8588a(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        System.arraycopy(bArr, 0, bArr2, i, length);
        return length;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8590a(int r2) {
        /*
            r1 = this;
            r1.f9553c = r2
            int r2 = r1.f9553c
            r0 = 12
            if (r2 == r0) goto L17
            r0 = 140(0x8c, float:1.96E-43)
            if (r2 == r0) goto L17
            switch(r2) {
                case 0: goto L13;
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L13;
                case 4: goto L17;
                case 5: goto L17;
                case 6: goto L13;
                case 7: goto L17;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 128: goto L13;
                case 129: goto L13;
                case 130: goto L13;
                case 131: goto L13;
                case 132: goto L17;
                case 133: goto L17;
                case 134: goto L13;
                case 135: goto L17;
                default: goto L12;
            }
        L12:
            goto L1a
        L13:
            r2 = 0
            r1.f9563m = r2
            return
        L17:
            r2 = 2
            r1.f9563m = r2
        L1a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p188n.p190b.BaseRemoteBusinessPackage.m8590a(int):void");
    }

    /* renamed from: a */
    public static BaseRemoteBusinessPackage m8589a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BaseRemoteBusinessPackage baseRemoteBusinessPackage = new BaseRemoteBusinessPackage();
        baseRemoteBusinessPackage.f9554d = SocketTools.m8519a(bArr[0]);
        baseRemoteBusinessPackage.f9551a = SocketTools.m8517a(bArr, 1);
        if (baseRemoteBusinessPackage.f9551a != bArr.length - 3) {
            MLog.m8522a("XRR", "Receive bad wlan Message!");
            return null;
        }
        baseRemoteBusinessPackage.f9563m = bArr[3];
        baseRemoteBusinessPackage.f9564n = bArr[4];
        baseRemoteBusinessPackage.f9562l = SocketTools.m8517a(bArr, 5);
        baseRemoteBusinessPackage.f9553c = SocketTools.m8519a(bArr[7]);
        int length = ((bArr.length - 4) - 1) - 8;
        if (length == 1) {
            baseRemoteBusinessPackage.f9565o = SocketTools.m8519a(bArr[8]);
        } else if (length == 2) {
            baseRemoteBusinessPackage.f9565o = SocketTools.m8519a(bArr[9]);
        }
        baseRemoteBusinessPackage.f9555e = new byte[length];
        System.arraycopy(bArr, 8, baseRemoteBusinessPackage.f9555e, 0, length);
        int i = length + 8;
        baseRemoteBusinessPackage.f9556f = SocketTools.m8515b(bArr, i);
        baseRemoteBusinessPackage.f9557g = SocketTools.m8519a(bArr[i + 4]);
        return baseRemoteBusinessPackage;
    }

    /* renamed from: a */
    public final int m8591a() {
        return this.f9557g;
    }

    /* renamed from: b */
    public final int m8587b() {
        return this.f9553c;
    }

    /* renamed from: c */
    public final int m8585c() {
        return this.f9562l;
    }

    /* renamed from: d */
    public final byte[] m8584d() {
        return this.f9555e;
    }

    /* renamed from: e */
    public final synchronized void m8583e() {
        this.f9562l++;
        if (this.f9562l > 65535) {
            this.f9562l = 1;
        }
    }

    /* renamed from: f */
    public final byte[] m8582f() {
        return m8586b(this.f9562l);
    }

    /* renamed from: b */
    public final byte[] m8586b(int i) {
        this.f9556f = System.currentTimeMillis() / 1000;
        byte[] bArr = this.f9555e;
        this.f9558h = bArr.length;
        this.f9551a = bArr.length + 13;
        int i2 = this.f9551a;
        this.f9552b = i2 - 3;
        byte[] bArr2 = new byte[i2];
        bArr2[0] = (byte) (this.f9554d & 255);
        int i3 = this.f9552b;
        bArr2[1] = (byte) (i3 & 255);
        bArr2[2] = (byte) ((i3 >> 8) & 255);
        bArr2[3] = this.f9563m;
        bArr2[4] = this.f9564n;
        bArr2[5] = (byte) (i & 255);
        bArr2[6] = (byte) ((i >> 8) & 255);
        bArr2[7] = (byte) (this.f9553c & 255);
        System.arraycopy(bArr, 0, bArr2, 8, this.f9558h);
        int i4 = this.f9558h + 8;
        int i5 = i4 + 1;
        long j = this.f9556f;
        bArr2[i4] = (byte) (j & 255);
        int i6 = i5 + 1;
        bArr2[i5] = (byte) ((j >> 8) & 255);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) ((j >> 16) & 255);
        bArr2[i7] = (byte) ((j >> 24) & 255);
        this.f9557g = CRC16.m8526a(bArr2, this.f9551a - 1);
        bArr2[i7 + 1] = (byte) (this.f9557g & 255);
        return bArr2;
    }

    public String toString() {
        return "business id:" + this.f9553c + "length:" + this.f9551a;
    }
}
