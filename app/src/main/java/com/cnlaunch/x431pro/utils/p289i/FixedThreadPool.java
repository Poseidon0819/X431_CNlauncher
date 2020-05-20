package com.cnlaunch.x431pro.utils.p289i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.cnlaunch.x431pro.utils.i.a */
/* loaded from: classes.dex */
public class FixedThreadPool {

    /* renamed from: b */
    private static FixedThreadPool f15903b;

    /* renamed from: a */
    public ScheduledExecutorService f15904a;

    /* renamed from: c */
    private ExecutorService f15905c;

    /* renamed from: a */
    public static FixedThreadPool m4928a() {
        if (f15903b == null) {
            synchronized (FixedThreadPool.class) {
                if (f15903b == null) {
                    f15903b = new FixedThreadPool();
                }
            }
        }
        return f15903b;
    }

    private FixedThreadPool() {
        this.f15905c = null;
        this.f15904a = null;
        this.f15905c = Executors.newFixedThreadPool(5);
        this.f15904a = Executors.newScheduledThreadPool(5);
    }

    /* renamed from: a */
    public final void m4927a(Runnable runnable) {
        this.f15905c.execute(runnable);
    }
}
