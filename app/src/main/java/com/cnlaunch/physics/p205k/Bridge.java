package com.cnlaunch.physics.p205k;

/* renamed from: com.cnlaunch.physics.k.b */
/* loaded from: classes.dex */
public final class Bridge {

    /* renamed from: a */
    Boolean f10054a = Boolean.FALSE;

    /* renamed from: a */
    public final synchronized void m8202a() {
        while (!this.f10054a.booleanValue()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m8201b() {
        this.f10054a = Boolean.TRUE;
        notify();
    }
}
