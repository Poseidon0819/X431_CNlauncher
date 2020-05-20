package com.cnlaunch.gmap.p138a.p139a;

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

/* renamed from: com.cnlaunch.gmap.a.a.d */
/* loaded from: classes.dex */
public abstract class AsyncTask<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f7361a = new ThreadFactoryC1494e();

    /* renamed from: i */
    private static final BlockingQueue<Runnable> f7365i = new LinkedBlockingQueue(10);

    /* renamed from: b */
    public static final Executor f7362b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f7365i, f7361a, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: c */
    public static final Executor f7363c = new ExecutorC1491c((byte) 0);

    /* renamed from: d */
    public static final Executor f7364d = Executors.newFixedThreadPool(3, f7361a);

    /* renamed from: j */
    private static final HandlerC1490b f7366j = new HandlerC1490b((byte) 0);

    /* renamed from: k */
    private static volatile Executor f7367k = f7363c;

    /* renamed from: g */
    public volatile int f7370g = EnumC1492d.PENDING$446eb244;

    /* renamed from: h */
    public final AtomicBoolean f7371h = new AtomicBoolean();

    /* renamed from: l */
    private final AtomicBoolean f7372l = new AtomicBoolean();

    /* renamed from: e */
    public final AbstractCallableC1493e<Params, Result> f7368e = new C1495f(this);

    /* renamed from: f */
    public final FutureTask<Result> f7369f = new C1496g(this, this.f7368e);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo9395a(Params... paramsArr);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9396a(Result result) {
    }

    /* renamed from: b */
    protected void mo9393b(Result result) {
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.gmap.a.a.d$c */
    /* loaded from: classes.dex */
    static class ExecutorC1491c implements Executor {

        /* renamed from: a */
        final ArrayDeque<Runnable> f7375a;

        /* renamed from: b */
        Runnable f7376b;

        private ExecutorC1491c() {
            this.f7375a = new ArrayDeque<>();
        }

        /* synthetic */ ExecutorC1491c(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final synchronized void execute(Runnable runnable) {
            this.f7375a.offer(new RunnableC1498i(this, runnable));
            if (this.f7376b == null) {
                m9390a();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final synchronized void m9390a() {
            Runnable poll = this.f7375a.poll();
            this.f7376b = poll;
            if (poll != null) {
                AsyncTask.f7362b.execute(this.f7376b);
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.gmap.a.a.d$d */
    /* loaded from: classes.dex */
    public static final class EnumC1492d {
        public static final int PENDING$446eb244 = 1;
        public static final int RUNNING$446eb244 = 2;
        public static final int FINISHED$446eb244 = 3;

        /* renamed from: a */
        private static final /* synthetic */ int[] f7377a = {PENDING$446eb244, RUNNING$446eb244, FINISHED$446eb244};

        public static int[] values$6200c27e() {
            return (int[]) f7377a.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Result m9391c(Result result) {
        f7366j.obtainMessage(1, new C1489a(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.gmap.a.a.d$b */
    /* loaded from: classes.dex */
    public static class HandlerC1490b extends Handler {
        private HandlerC1490b() {
        }

        /* synthetic */ HandlerC1490b(byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            C1489a c1489a = (C1489a) message2.obj;
            if (message2.what != 1) {
                return;
            }
            AsyncTask.m9392c(c1489a.f7373a, c1489a.f7374b[0]);
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.gmap.a.a.d$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC1493e<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        public Params[] f7378b;

        private AbstractCallableC1493e() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractCallableC1493e(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTask.java */
    /* renamed from: com.cnlaunch.gmap.a.a.d$a */
    /* loaded from: classes.dex */
    public static class C1489a<Data> {

        /* renamed from: a */
        final AsyncTask f7373a;

        /* renamed from: b */
        final Data[] f7374b;

        C1489a(AsyncTask asyncTask, Data... dataArr) {
            this.f7373a = asyncTask;
            this.f7374b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m9394b(AsyncTask asyncTask, Object obj) {
        if (asyncTask.f7372l.get()) {
            return;
        }
        asyncTask.m9391c(obj);
    }

    /* renamed from: c */
    static /* synthetic */ void m9392c(AsyncTask asyncTask, Object obj) {
        if (asyncTask.f7371h.get()) {
            asyncTask.mo9396a((AsyncTask) obj);
        } else {
            asyncTask.mo9393b(obj);
        }
        asyncTask.f7370g = EnumC1492d.FINISHED$446eb244;
    }
}
