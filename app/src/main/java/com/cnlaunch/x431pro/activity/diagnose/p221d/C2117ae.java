package com.cnlaunch.x431pro.activity.diagnose.p221d;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ae */
/* loaded from: classes.dex */
final class C2117ae extends Thread {

    /* renamed from: a */
    final /* synthetic */ DataStreamShowFragment f11972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2117ae(DataStreamShowFragment dataStreamShowFragment) {
        this.f11972a = dataStreamShowFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataStreamShowFragment.m7281g(this.f11972a);
    }
}
