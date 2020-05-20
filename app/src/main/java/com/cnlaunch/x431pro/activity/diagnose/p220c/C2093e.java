package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.p112a.DataStreamGraphicalView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CombinedGraphPage.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.e */
/* loaded from: classes.dex */
public final class C2093e extends Thread {

    /* renamed from: a */
    final /* synthetic */ CombinedGraphPage f11724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2093e(CombinedGraphPage combinedGraphPage) {
        this.f11724a = combinedGraphPage;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        DataStreamGraphicalView dataStreamGraphicalView;
        try {
            sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataStreamGraphicalView = this.f11724a.f11721m;
        dataStreamGraphicalView.m9673a();
    }
}
