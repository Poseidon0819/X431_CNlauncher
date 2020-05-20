package com.cnlaunch.golo3.p154a.p155a;

import com.cnlaunch.golo3.p154a.p155a.AbstractC1561d;

/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.golo3.a.a.i */
/* loaded from: classes.dex */
final class RunnableC1571i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f7725a;

    /* renamed from: b */
    final /* synthetic */ AbstractC1561d.ExecutorC1564c f7726b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1571i(AbstractC1561d.ExecutorC1564c executorC1564c, Runnable runnable) {
        this.f7726b = executorC1564c;
        this.f7725a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f7725a.run();
        } finally {
            this.f7726b.m9233a();
        }
    }
}
