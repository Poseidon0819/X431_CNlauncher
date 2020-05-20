package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.p112a.DataStreamGraphicalView;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CombinedGraphPage.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.d */
/* loaded from: classes.dex */
public final class C2092d extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ CombinedGraphPage f11723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2092d(CombinedGraphPage combinedGraphPage) {
        this.f11723a = combinedGraphPage;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        DataStreamGraphicalView dataStreamGraphicalView;
        dataStreamGraphicalView = this.f11723a.f11721m;
        dataStreamGraphicalView.m9673a();
    }
}
