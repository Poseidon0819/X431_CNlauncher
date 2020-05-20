package com.cnlaunch.x431pro.activity.mine;

/* compiled from: ReadReportFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cl */
/* loaded from: classes.dex */
final class RunnableC2461cl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ReadReportFragment f14065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2461cl(ReadReportFragment readReportFragment) {
        this.f14065a = readReportFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14065a.f14049a.onDetach();
        this.f14065a.f14049a.onDestroy();
        this.f14065a.f14049a = null;
        System.gc();
    }
}
