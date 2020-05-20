package com.cnlaunch.x431pro.activity.diagnose.p221d;

/* compiled from: SpecMemuListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bo */
/* loaded from: classes.dex */
final class C2147bo extends Thread {

    /* renamed from: a */
    final /* synthetic */ SpecMemuListFragment f12150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2147bo(SpecMemuListFragment specMemuListFragment) {
        this.f12150a = specMemuListFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SpecMemuListFragment.m7192a(this.f12150a);
    }
}
