package com.cnlaunch.x431pro.activity.CloudDiagnose;

import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;

/* compiled from: CloudHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.p */
/* loaded from: classes.dex */
final class RunnableC1964p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CloudHistoryFragment f10677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1964p(CloudHistoryFragment cloudHistoryFragment) {
        this.f10677a = cloudHistoryFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PullToRefreshListView pullToRefreshListView;
        try {
            Thread.sleep(1000L);
            pullToRefreshListView = this.f10677a.f10658l;
            pullToRefreshListView.m4428i();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
