package com.cnlaunch.gmap.map.p150b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocationLogic.java */
/* renamed from: com.cnlaunch.gmap.map.b.l */
/* loaded from: classes.dex */
public final class RunnableC1532l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LocationLogic f7573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1532l(LocationLogic locationLogic) {
        this.f7573a = locationLogic;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(2000L);
            this.f7573a.f7568g = this.f7573a.f7567f.f19218a.m3178d();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
