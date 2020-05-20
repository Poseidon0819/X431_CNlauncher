package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery.java */
/* renamed from: com.mopub.volley.b */
/* loaded from: classes2.dex */
final class ExecutorC3922b implements Executor {

    /* renamed from: a */
    final /* synthetic */ Handler f21292a;

    /* renamed from: b */
    final /* synthetic */ ExecutorDelivery f21293b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorC3922b(ExecutorDelivery executorDelivery, Handler handler) {
        this.f21293b = executorDelivery;
        this.f21292a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f21292a.post(runnable);
    }
}
