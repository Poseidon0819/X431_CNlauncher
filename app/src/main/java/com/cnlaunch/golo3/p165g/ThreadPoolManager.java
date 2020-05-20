package com.cnlaunch.golo3.p165g;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.cnlaunch.golo3.g.w */
/* loaded from: classes.dex */
public class ThreadPoolManager {

    /* renamed from: d */
    private static ThreadPoolManager f8495d;

    /* renamed from: a */
    private ThreadPoolExecutor f8496a;

    /* renamed from: b */
    private Map<String, List<WeakReference<Future<?>>>> f8497b;

    /* renamed from: c */
    private String f8498c;

    private ThreadPoolManager(String str) {
        this.f8498c = str;
        this.f8496a = (ThreadPoolExecutor) NewThreadExecutors.m9127a();
        this.f8497b = new WeakHashMap();
    }

    private ThreadPoolManager(String str, byte b) {
        this.f8498c = str;
        this.f8496a = new ThreadPoolExecutor(0, 5, 60L, TimeUnit.SECONDS, new SynchronousQueue());
        this.f8497b = new WeakHashMap();
    }

    /* renamed from: a */
    public static ThreadPoolManager m9119a(String str) {
        if (f8495d == null) {
            synchronized (ThreadPoolManager.class) {
                if (f8495d == null) {
                    f8495d = new ThreadPoolManager(str);
                }
            }
        }
        ThreadPoolManager threadPoolManager = f8495d;
        threadPoolManager.f8498c = str;
        return threadPoolManager;
    }

    /* renamed from: b */
    public static ThreadPoolManager m9117b(String str) {
        if (f8495d == null) {
            synchronized (ThreadPoolManager.class) {
                if (f8495d == null) {
                    f8495d = new ThreadPoolManager(str, (byte) 0);
                }
            }
        }
        ThreadPoolManager threadPoolManager = f8495d;
        threadPoolManager.f8498c = str;
        return threadPoolManager;
    }

    /* renamed from: a */
    public final void m9120a(Runnable runnable) {
        m9118a(this.f8496a.submit(runnable));
    }

    /* renamed from: a */
    private void m9118a(Future<?> future) {
        synchronized (ThreadPoolManager.class) {
            if (this.f8498c != null) {
                List<WeakReference<Future<?>>> list = this.f8497b.get(this.f8498c);
                if (list == null) {
                    list = new LinkedList<>();
                    this.f8497b.put(this.f8498c, list);
                }
                list.add(new WeakReference<>(future));
            }
        }
    }
}
