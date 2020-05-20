package com.cnlaunch.golo3.p154a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FinalBitmap.java */
/* renamed from: com.cnlaunch.golo3.a.b */
/* loaded from: classes.dex */
public final class ThreadFactoryC1574b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C1551a f7727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC1574b(C1551a c1551a) {
        this.f7727a = c1551a;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(4);
        return thread;
    }
}
