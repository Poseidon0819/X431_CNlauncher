package com.cnlaunch.p182k;

/* renamed from: com.cnlaunch.k.h */
/* loaded from: classes.dex */
public final class UDPController {

    /* renamed from: c */
    public static String f9506c;

    /* renamed from: d */
    public static int f9507d;

    /* renamed from: b */
    byte[] f9509b;

    /* renamed from: e */
    private Thread f9510e = null;

    /* renamed from: a */
    boolean f9508a = false;

    /* renamed from: a */
    public final byte[] m8634a(int i, int i2, byte[] bArr, String str) {
        this.f9510e = new Thread(new RunnableC1794i(this, str, i2, bArr, i));
        this.f9510e.start();
        try {
            this.f9510e.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f9509b;
    }

    /* renamed from: a */
    public final byte[] m8635a(int i, int i2) {
        this.f9510e = new Thread(new RunnableC1795j(this, i2, i));
        this.f9510e.start();
        try {
            this.f9510e.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f9509b;
    }
}
