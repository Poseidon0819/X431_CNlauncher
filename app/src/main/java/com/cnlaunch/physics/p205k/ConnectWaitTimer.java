package com.cnlaunch.physics.p205k;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.cnlaunch.physics.k.e */
/* loaded from: classes.dex */
public final class ConnectWaitTimer {

    /* renamed from: a */
    public final ScheduledExecutorService f10098a = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC1854a((byte) 0));

    /* renamed from: b */
    public ScheduledFuture<?> f10099b = null;

    /* renamed from: a */
    public final void m8164a() {
        ScheduledFuture<?> scheduledFuture = this.f10099b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f10099b = null;
        }
    }

    /* compiled from: ConnectWaitTimer.java */
    /* renamed from: com.cnlaunch.physics.k.e$a */
    /* loaded from: classes.dex */
    static final class ThreadFactoryC1854a implements ThreadFactory {
        private ThreadFactoryC1854a() {
        }

        /* synthetic */ ThreadFactoryC1854a(byte b) {
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
