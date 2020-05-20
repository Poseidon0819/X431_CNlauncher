package com.cnlaunch.x431pro.widget.pulltorefresh;

/* compiled from: PullToRefreshBase.java */
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.i */
/* loaded from: classes.dex */
final class RunnableC2943i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PullToRefreshBase f16730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2943i(PullToRefreshBase pullToRefreshBase) {
        this.f16730a = pullToRefreshBase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16730a.requestLayout();
    }
}
