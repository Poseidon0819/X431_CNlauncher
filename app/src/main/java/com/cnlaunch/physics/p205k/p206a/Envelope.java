package com.cnlaunch.physics.p205k.p206a;

/* renamed from: com.cnlaunch.physics.k.a.a */
/* loaded from: classes.dex */
public final class Envelope {

    /* renamed from: a */
    private final int f10043a;

    /* renamed from: b */
    private ILetter f10044b;

    /* renamed from: c */
    private int f10045c;

    /* renamed from: d */
    private int f10046d;

    public Envelope() {
        this.f10043a = 4;
        this.f10045c = -1;
        this.f10046d = -1;
        this.f10044b = null;
        this.f10045c = -1;
        this.f10046d = -1;
    }

    public Envelope(int i, ILetter iLetter) {
        this.f10043a = 4;
        this.f10045c = -1;
        this.f10046d = -1;
        this.f10046d = 1;
        this.f10045c = i;
        this.f10044b = iLetter;
    }

    /* renamed from: a */
    public final byte[] m8212a() {
        if (this.f10044b != null) {
            byte[] m8203b = RemoteMessage.m8203b((this.f10046d << 24) | this.f10045c);
            byte[] bytes = this.f10044b.mo8211a().getBytes();
            byte[] bArr = new byte[bytes.length + 4];
            System.arraycopy(m8203b, 0, bArr, 0, 4);
            System.arraycopy(bytes, 0, bArr, 4, bytes.length);
            return bArr;
        }
        throw new RuntimeException("无效的消息");
    }
}
