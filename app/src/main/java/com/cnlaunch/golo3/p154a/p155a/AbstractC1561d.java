package com.cnlaunch.golo3.p154a.p155a;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask.java */
/* renamed from: com.cnlaunch.golo3.a.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC1561d<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f7703a = new ThreadFactoryC1567e();

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f7708g = new LinkedBlockingQueue(10);

    /* renamed from: b */
    public static final Executor f7704b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f7708g, f7703a, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: c */
    public static final Executor f7705c = new ExecutorC1564c((byte) 0);

    /* renamed from: d */
    public static final Executor f7706d = Executors.newFixedThreadPool(3, f7703a);

    /* renamed from: h */
    private static final HandlerC1563b f7709h = new HandlerC1563b((byte) 0);

    /* renamed from: e */
    public static volatile Executor f7707e = f7705c;

    /* renamed from: k */
    private volatile int f7713k = EnumC1565d.PENDING$4f841217;

    /* renamed from: f */
    protected final AtomicBoolean f7710f = new AtomicBoolean();

    /* renamed from: l */
    private final AtomicBoolean f7714l = new AtomicBoolean();

    /* renamed from: i */
    private final AbstractCallableC1566e<Params, Result> f7711i = new C1568f(this);

    /* renamed from: j */
    private final FutureTask<Result> f7712j = new C1569g(this, this.f7711i);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo9238a(Params... paramsArr);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9240a(Result result) {
    }

    /* renamed from: b */
    protected void mo9236b(Result result) {
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.golo3.a.a.d$c */
    /* loaded from: classes.dex */
    static class ExecutorC1564c implements Executor {

        /* renamed from: a */
        final C1557b<Runnable> f7717a;

        /* renamed from: b */
        Runnable f7718b;

        private ExecutorC1564c() {
            this.f7717a = new C1557b<>();
        }

        /* synthetic */ ExecutorC1564c(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final synchronized void execute(Runnable runnable) {
            this.f7717a.offer(new RunnableC1571i(this, runnable));
            if (this.f7718b == null) {
                m9233a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final synchronized void m9233a() {
            Runnable poll = this.f7717a.poll();
            this.f7718b = poll;
            if (poll != null) {
                AbstractC1561d.f7704b.execute(this.f7718b);
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.golo3.a.a.d$d */
    /* loaded from: classes.dex */
    public static final class EnumC1565d {
        public static final int PENDING$4f841217 = 1;
        public static final int RUNNING$4f841217 = 2;
        public static final int FINISHED$4f841217 = 3;

        /* renamed from: a */
        private static final /* synthetic */ int[] f7719a = {PENDING$4f841217, RUNNING$4f841217, FINISHED$4f841217};

        public static int[] values$452be4ef() {
            return (int[]) f7719a.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Result m9234c(Result result) {
        f7709h.obtainMessage(1, new C1562a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: a */
    public final boolean m9243a() {
        this.f7710f.set(true);
        return this.f7712j.cancel(true);
    }

    /* renamed from: a */
    public final AbstractC1561d<Params, Progress, Result> m9239a(Executor executor, Params... paramsArr) {
        if (this.f7713k != EnumC1565d.PENDING$4f841217) {
            switch (C1570h.f7724a[this.f7713k - 1]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f7713k = EnumC1565d.RUNNING$4f841217;
        this.f7711i.f7720b = paramsArr;
        executor.execute(this.f7712j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.golo3.a.a.d$b */
    /* loaded from: classes.dex */
    public static class HandlerC1563b extends Handler {
        private HandlerC1563b() {
        }

        /* synthetic */ HandlerC1563b(byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            C1562a c1562a = (C1562a) message2.obj;
            if (message2.what != 1) {
                return;
            }
            AbstractC1561d.m9235c(c1562a.f7715a, c1562a.f7716b[0]);
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.golo3.a.a.d$e */
    /* loaded from: classes.dex */
    static abstract class AbstractCallableC1566e<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f7720b;

        private AbstractCallableC1566e() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractCallableC1566e(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.golo3.a.a.d$a */
    /* loaded from: classes.dex */
    public static class C1562a<Data> {

        /* renamed from: a */
        final AbstractC1561d f7715a;

        /* renamed from: b */
        final Data[] f7716b;

        C1562a(AbstractC1561d abstractC1561d, Data... dataArr) {
            this.f7715a = abstractC1561d;
            this.f7716b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m9237b(AbstractC1561d abstractC1561d, Object obj) {
        if (abstractC1561d.f7714l.get()) {
            return;
        }
        abstractC1561d.m9234c(obj);
    }

    /* renamed from: c */
    static /* synthetic */ void m9235c(AbstractC1561d abstractC1561d, Object obj) {
        if (abstractC1561d.f7710f.get()) {
            abstractC1561d.mo9240a((AbstractC1561d) obj);
        } else {
            abstractC1561d.mo9236b(obj);
        }
        abstractC1561d.f7713k = EnumC1565d.FINISHED$4f841217;
    }
}
