package com.cnlaunch.gmap.p138a.p139a;

import com.cnlaunch.gmap.p138a.p139a.AsyncTask;

/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.gmap.a.a.i */
/* loaded from: classes.dex */
final class RunnableC1498i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f7383a;

    /* renamed from: b */
    final /* synthetic */ AsyncTask.ExecutorC1491c f7384b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1498i(AsyncTask.ExecutorC1491c executorC1491c, Runnable runnable) {
        this.f7384b = executorC1491c;
        this.f7383a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f7383a.run();
        } finally {
            this.f7384b.m9390a();
        }
    }
}
