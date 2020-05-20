package com.cnlaunch.p112a;

/* compiled from: DataStreamGraphicalView.java */
/* renamed from: com.cnlaunch.a.b */
/* loaded from: classes.dex */
final class RunnableC1406b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DataStreamGraphicalView f6720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1406b(DataStreamGraphicalView dataStreamGraphicalView) {
        this.f6720a = dataStreamGraphicalView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6720a.invalidate();
    }
}
