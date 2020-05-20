package com.cnlaunch.x431pro.activity.p211a;

/* compiled from: HistoricalRecordsFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.b */
/* loaded from: classes.dex */
final class C1976b extends Thread {

    /* renamed from: a */
    final /* synthetic */ HistoricalRecordsFragment f10838a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1976b(HistoricalRecordsFragment historicalRecordsFragment) {
        this.f10838a = historicalRecordsFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f10838a.request(10010, false);
    }
}
