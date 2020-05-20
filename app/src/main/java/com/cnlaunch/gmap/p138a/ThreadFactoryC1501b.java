package com.cnlaunch.gmap.p138a;

import java.util.concurrent.ThreadFactory;

/* compiled from: FinalBitmap.java */
/* renamed from: com.cnlaunch.gmap.a.b */
/* loaded from: classes.dex */
final class ThreadFactoryC1501b implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ FinalBitmap f7385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC1501b(FinalBitmap finalBitmap) {
        this.f7385a = finalBitmap;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(4);
        return thread;
    }
}
