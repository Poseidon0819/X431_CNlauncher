package com.cnlaunch.x431pro.activity.p211a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.i */
/* loaded from: classes.dex */
public final class C1983i extends Thread {

    /* renamed from: a */
    final /* synthetic */ HistoryFragment f10878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1983i(HistoryFragment historyFragment) {
        this.f10878a = historyFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f10878a.request(10010, false);
    }
}
