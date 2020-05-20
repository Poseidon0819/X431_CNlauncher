package com.cnlaunch.gmap.p138a.p139a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.gmap.a.a.e */
/* loaded from: classes.dex */
final class ThreadFactoryC1494e implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f7379a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AsyncTask #" + this.f7379a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
