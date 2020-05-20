package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.p112a.DataStreamGraphicalView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomCombinedGrapPage.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.h */
/* loaded from: classes.dex */
public final class C2095h extends Thread {

    /* renamed from: a */
    final /* synthetic */ CustomCombinedGrapPage f11738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2095h(CustomCombinedGrapPage customCombinedGrapPage) {
        this.f11738a = customCombinedGrapPage;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        DataStreamGraphicalView dataStreamGraphicalView;
        try {
            sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataStreamGraphicalView = this.f11738a.f11734h;
        dataStreamGraphicalView.m9673a();
    }
}
