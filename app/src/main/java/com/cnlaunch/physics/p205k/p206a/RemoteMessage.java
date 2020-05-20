package com.cnlaunch.physics.p205k.p206a;

/* renamed from: com.cnlaunch.physics.k.a.e */
/* loaded from: classes.dex */
public final class RemoteMessage {

    /* renamed from: a */
    private byte f10050a;

    /* renamed from: b */
    private byte f10051b;

    /* renamed from: c */
    private int f10052c;

    /* renamed from: d */
    private byte[] f10053d;

    /* renamed from: a */
    public final synchronized void m8208a(byte b) {
        this.f10050a = b;
    }

    /* renamed from: b */
    public final synchronized void m8204b(byte b) {
        this.f10051b = b;
    }

    /* renamed from: a */
    public final synchronized int m8209a() {
        return this.f10052c;
    }

    /* renamed from: a */
    public final synchronized void m8207a(int i) {
        this.f10052c = i;
    }

    /* renamed from: a */
    public final synchronized void m8206a(byte[] bArr) {
        this.f10053d = bArr;
    }

    protected final void finalize() {
        this.f10053d = null;
    }

    /* renamed from: b */
    public static byte[] m8203b(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public RemoteMessage() {
        this.f10050a = (byte) 1;
        this.f10051b = (byte) 2;
        this.f10052c = 0;
        this.f10053d = null;
    }

    public RemoteMessage(byte[] bArr) {
        this();
        this.f10052c = bArr.length;
        this.f10053d = bArr;
    }

    /* renamed from: b */
    public final byte[] m8205b() {
        byte[] bArr = new byte[this.f10053d.length + 6];
        bArr[0] = this.f10050a;
        bArr[1] = this.f10051b;
        System.arraycopy(m8203b(this.f10052c), 0, bArr, 2, 4);
        byte[] bArr2 = this.f10053d;
        System.arraycopy(bArr2, 0, bArr, 6, bArr2.length);
        return bArr;
    }
}
