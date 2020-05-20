package com.cnlaunch.x431pro.activity.CloudDiagnose;

/* compiled from: CloudHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.l */
/* loaded from: classes.dex */
final class RunnableC1960l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1959k f10673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1960l(C1959k c1959k) {
        this.f10673a = c1959k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(3000L);
            this.f10673a.f10672a.request(774, true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
