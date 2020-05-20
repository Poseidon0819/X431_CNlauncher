package com.cnlaunch.golo3.p154a.p155a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.golo3.a.a.e */
/* loaded from: classes.dex */
final class ThreadFactoryC1567e implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f7721a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AsyncTask #" + this.f7721a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
