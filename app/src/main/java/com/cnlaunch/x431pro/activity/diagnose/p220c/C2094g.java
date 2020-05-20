package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.p112a.DataStreamGraphicalView;
import java.util.TimerTask;

/* compiled from: CustomCombinedGrapPage.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.g */
/* loaded from: classes.dex */
public final class C2094g extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ CustomCombinedGrapPage f11737a;

    public C2094g(CustomCombinedGrapPage customCombinedGrapPage) {
        this.f11737a = customCombinedGrapPage;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        DataStreamGraphicalView dataStreamGraphicalView;
        dataStreamGraphicalView = this.f11737a.f11734h;
        dataStreamGraphicalView.m9673a();
    }
}
