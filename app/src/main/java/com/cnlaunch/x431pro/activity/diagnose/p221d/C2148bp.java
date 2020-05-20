package com.cnlaunch.x431pro.activity.diagnose.p221d;

/* compiled from: SpecMemuListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bp */
/* loaded from: classes.dex */
final class C2148bp extends Thread {

    /* renamed from: a */
    final /* synthetic */ SpecMemuListFragment f12151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2148bp(SpecMemuListFragment specMemuListFragment) {
        this.f12151a = specMemuListFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SpecMemuListFragment.m7192a(this.f12151a);
    }
}
