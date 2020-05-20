package com.cnlaunch.p120d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.util.LinkedList;

/* renamed from: com.cnlaunch.d.c */
/* loaded from: classes.dex */
public final class DeferredHandler {

    /* renamed from: d */
    private static DeferredHandler f7028d;

    /* renamed from: a */
    private LinkedList<Runnable> f7029a = new LinkedList<>();

    /* renamed from: b */
    private MessageQueue f7030b = Looper.myQueue();

    /* renamed from: c */
    private HandlerC1420b f7031c = new HandlerC1420b(this, (byte) 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeferredHandler.java */
    /* renamed from: com.cnlaunch.d.c$b */
    /* loaded from: classes.dex */
    public class HandlerC1420b extends Handler implements MessageQueue.IdleHandler {
        private HandlerC1420b() {
        }

        /* synthetic */ HandlerC1420b(DeferredHandler deferredHandler, byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            synchronized (DeferredHandler.this.f7029a) {
                if (DeferredHandler.this.f7029a.size() == 0) {
                    return;
                }
                ((Runnable) DeferredHandler.this.f7029a.removeFirst()).run();
                synchronized (DeferredHandler.this.f7029a) {
                    DeferredHandler.this.m9578b();
                }
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            handleMessage(null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeferredHandler.java */
    /* renamed from: com.cnlaunch.d.c$a */
    /* loaded from: classes.dex */
    public class RunnableC1419a implements Runnable {

        /* renamed from: a */
        Runnable f7032a;

        RunnableC1419a(Runnable runnable) {
            this.f7032a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f7032a.run();
        }
    }

    /* renamed from: a */
    public static DeferredHandler m9581a() {
        if (f7028d == null) {
            f7028d = new DeferredHandler();
        }
        return f7028d;
    }

    /* renamed from: a */
    public final void m9579a(Runnable runnable) {
        RunnableC1419a runnableC1419a = new RunnableC1419a(runnable);
        synchronized (this.f7029a) {
            this.f7029a.add(runnableC1419a);
            if (this.f7029a.size() == 1) {
                m9578b();
            }
        }
    }

    /* renamed from: b */
    final void m9578b() {
        if (this.f7029a.size() > 0) {
            if (this.f7029a.getFirst() instanceof RunnableC1419a) {
                this.f7030b.addIdleHandler(this.f7031c);
            } else {
                this.f7031c.sendEmptyMessage(1);
            }
        }
    }
}
