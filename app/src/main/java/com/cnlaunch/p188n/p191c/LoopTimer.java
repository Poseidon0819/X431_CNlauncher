package com.cnlaunch.p188n.p191c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.cnlaunch.n.c.d */
/* loaded from: classes.dex */
public final class LoopTimer {

    /* renamed from: a */
    public final ScheduledExecutorService f9641a = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC1805a((byte) 0));

    /* renamed from: b */
    private ScheduledFuture<?> f9642b = null;

    /* renamed from: c */
    private Runnable f9643c;

    /* renamed from: d */
    private int f9644d;

    public LoopTimer(int i, Runnable runnable) {
        this.f9643c = runnable;
        this.f9644d = i;
    }

    /* renamed from: a */
    public final void m8524a() {
        m8523b();
        ScheduledExecutorService scheduledExecutorService = this.f9641a;
        Runnable runnable = this.f9643c;
        int i = this.f9644d;
        this.f9642b = scheduledExecutorService.scheduleAtFixedRate(runnable, i, i, TimeUnit.SECONDS);
    }

    /* renamed from: b */
    public final void m8523b() {
        ScheduledFuture<?> scheduledFuture = this.f9642b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f9642b = null;
        }
    }

    /* compiled from: LoopTimer.java */
    /* renamed from: com.cnlaunch.n.c.d$a */
    /* loaded from: classes.dex */
    static final class ThreadFactoryC1805a implements ThreadFactory {
        private ThreadFactoryC1805a() {
        }

        /* synthetic */ ThreadFactoryC1805a(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }
}
