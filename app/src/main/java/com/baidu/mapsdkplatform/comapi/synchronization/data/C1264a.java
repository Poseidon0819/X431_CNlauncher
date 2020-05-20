package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import java.lang.Thread;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.a */
/* loaded from: classes.dex */
public class C1264a {

    /* renamed from: a */
    private static final String f6233a = "a";

    /* renamed from: b */
    private static int f6234b = 0;

    /* renamed from: c */
    private static C1272c f6235c = null;

    /* renamed from: d */
    private static Thread f6236d = null;

    /* renamed from: e */
    private static volatile boolean f6237e = true;

    /* renamed from: g */
    private static volatile long f6238g = 5000;

    /* renamed from: h */
    private static long f6239h = 5000;

    /* renamed from: i */
    private static volatile boolean f6240i = false;

    /* renamed from: j */
    private static int f6241j = 1000;

    /* renamed from: f */
    private HandlerC1268c f6242f;

    /* renamed from: k */
    private boolean f6243k;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.a$a */
    /* loaded from: classes.dex */
    static class C1266a {

        /* renamed from: a */
        private static final C1264a f6244a = new C1264a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.a$b */
    /* loaded from: classes.dex */
    public static class RunnableC1267b implements Runnable {

        /* renamed from: a */
        private String f6245a;

        RunnableC1267b(String str) {
            this.f6245a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!C1264a.f6237e) {
                if (C1264a.f6235c != null) {
                    C1264a.f6235c.m10361a(C1264a.f6234b, C1264a.f6240i);
                    boolean unused = C1264a.f6240i = false;
                }
                try {
                    Thread.sleep(C1264a.f6238g);
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
                int m10332d = C1264a.f6235c != null ? C1264a.f6235c.m10332d() : 0;
                if (m10332d >= 3) {
                    long j = (m10332d / 3) + 1;
                    long unused3 = C1264a.f6238g = C1264a.f6239h * j < 60000 ? C1264a.f6239h * j : 60000L;
                } else {
                    long unused4 = C1264a.f6238g = C1264a.f6239h;
                }
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.a$c */
    /* loaded from: classes.dex */
    static class HandlerC1268c extends Handler {
        HandlerC1268c() {
        }

        /* renamed from: a */
        private void m10380a(int i) {
            if (C1264a.f6241j == i) {
                boolean unused = C1264a.f6240i = false;
                return;
            }
            boolean unused2 = C1264a.f6240i = true;
            int unused3 = C1264a.f6241j = i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            String str = C1264a.f6233a;
            C1255a.m10457a(str, "The order state is: " + message2.what);
            m10380a(message2.what);
            switch (message2.what) {
                case 0:
                case 5:
                    C1264a.m10383p();
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                    C1264a.m10382q();
                    return;
                default:
                    C1255a.m10453b(C1264a.f6233a, "The order state is undefined");
                    return;
            }
        }
    }

    private C1264a() {
        this.f6243k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C1264a m10410a() {
        return C1266a.f6244a;
    }

    /* renamed from: o */
    private void m10384o() {
        f6237e = true;
        Thread thread = f6236d;
        if (thread != null) {
            thread.interrupt();
            f6236d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static synchronized void m10383p() {
        synchronized (C1264a.class) {
            f6237e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static synchronized void m10382q() {
        synchronized (C1264a.class) {
            if (f6236d == null) {
                return;
            }
            f6237e = false;
            if (Thread.State.NEW == f6236d.getState()) {
                f6236d.start();
            }
            if (Thread.State.TERMINATED == f6236d.getState()) {
                f6236d = null;
                Thread thread = new Thread(new RunnableC1267b(Thread.currentThread().getName()));
                f6236d = thread;
                thread.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m10409a(int i) {
        C1255a.m10452c(f6233a, "The order state = ".concat(String.valueOf(i)));
        f6234b = i;
        if (this.f6242f == null) {
            C1255a.m10453b(f6233a, "SyncDataRequestHandler is null");
            return;
        }
        Message obtainMessage = this.f6242f.obtainMessage();
        obtainMessage.what = i;
        this.f6242f.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10407a(View view) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10360a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10406a(DisplayOptions displayOptions) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10359a(displayOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10405a(RoleOptions roleOptions) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10358a(roleOptions);
        }
    }

    /* renamed from: a */
    public void m10404a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        C1272c m10363a = C1272c.m10363a();
        f6235c = m10363a;
        if (m10363a != null) {
            f6235c.m10345b();
            f6235c.m10358a(roleOptions);
            f6235c.m10359a(displayOptions);
        }
        f6236d = new Thread(new RunnableC1267b(Thread.currentThread().getName()));
        this.f6242f = new HandlerC1268c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10403a(InterfaceC1277e interfaceC1277e) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10351a(interfaceC1277e);
        }
    }

    /* renamed from: b */
    public void m10401b() {
        if (this.f6243k) {
            this.f6243k = false;
        } else {
            m10382q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10400b(int i) {
        long j = i * 1000;
        f6239h = j;
        f6238g = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10399b(View view) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10344b(view);
        }
    }

    /* renamed from: c */
    public void m10398c() {
        m10383p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m10396c(View view) {
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10336c(view);
        }
    }

    /* renamed from: d */
    public void m10395d() {
        m10384o();
        this.f6242f.removeCallbacksAndMessages(null);
        f6234b = 0;
        f6239h = 5000L;
        f6240i = false;
        f6241j = 1000;
        this.f6243k = true;
        C1272c c1272c = f6235c;
        if (c1272c != null) {
            c1272c.m10326h();
        }
    }
}
