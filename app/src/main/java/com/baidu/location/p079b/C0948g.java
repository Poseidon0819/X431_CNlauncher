package com.baidu.location.p079b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p078a.C0905f;
import com.baidu.location.p081d.C0969d;
import com.baidu.location.p084g.C1016g;

/* renamed from: com.baidu.location.b.g */
/* loaded from: classes.dex */
public class C0948g {

    /* renamed from: b */
    private static C0948g f4190b;

    /* renamed from: c */
    private C0950a f4192c = null;

    /* renamed from: d */
    private boolean f4193d = false;

    /* renamed from: e */
    private boolean f4194e = false;

    /* renamed from: f */
    private boolean f4195f = false;

    /* renamed from: g */
    private boolean f4196g = true;

    /* renamed from: h */
    private boolean f4197h = false;

    /* renamed from: a */
    final Handler f4191a = new Handler();

    /* renamed from: i */
    private RunnableC0951b f4198i = new RunnableC0951b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.g$a */
    /* loaded from: classes.dex */
    public class C0950a extends BroadcastReceiver {
        private C0950a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || C0948g.this.f4191a == null) {
                return;
            }
            C0948g.this.m11951f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.g$b */
    /* loaded from: classes.dex */
    public class RunnableC0951b implements Runnable {
        private RunnableC0951b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int m12158d = C0905f.m12169a().m12158d();
            if (C0948g.this.f4193d && C0939c.m12005a().m11998e() && C0969d.m11810a().m11799d() && m12158d != 1) {
                C0948g.this.m11950g();
            }
            if (C0948g.this.f4193d) {
                C0944f.m11971a().m11964c();
            }
            if (!C0948g.this.f4193d || !C0948g.this.f4196g) {
                C0948g.this.f4195f = false;
                return;
            }
            C0948g.this.f4191a.postDelayed(this, C1016g.f4552P);
            C0948g.this.f4195f = true;
        }
    }

    private C0948g() {
    }

    /* renamed from: a */
    public static synchronized C0948g m11961a() {
        C0948g c0948g;
        synchronized (C0948g.class) {
            if (f4190b == null) {
                f4190b = new C0948g();
            }
            c0948g = f4190b;
        }
        return c0948g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m11951f() {
        NetworkInfo.State state = NetworkInfo.State.UNKNOWN;
        try {
            state = ((ConnectivityManager) ServiceC1002f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception unused) {
        }
        if (NetworkInfo.State.CONNECTED != state) {
            this.f4193d = false;
        } else if (this.f4193d) {
        } else {
            this.f4193d = true;
            this.f4191a.postDelayed(this.f4198i, C1016g.f4552P);
            this.f4195f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11950g() {
        C0969d.m11810a().m11790m();
        C0969d.m11810a().m11794i();
    }

    /* renamed from: b */
    public synchronized void m11958b() {
        if (ServiceC1002f.isServing) {
            if (this.f4197h) {
                return;
            }
            try {
                this.f4192c = new C0950a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                ServiceC1002f.getServiceContext().registerReceiver(this.f4192c, intentFilter);
                this.f4194e = true;
                m11951f();
            } catch (Exception unused) {
            }
            this.f4196g = true;
            this.f4197h = true;
        }
    }

    /* renamed from: c */
    public synchronized void m11956c() {
        if (this.f4197h) {
            try {
                ServiceC1002f.getServiceContext().unregisterReceiver(this.f4192c);
            } catch (Exception unused) {
            }
            this.f4196g = false;
            this.f4197h = false;
            this.f4195f = false;
            this.f4192c = null;
        }
    }

    /* renamed from: d */
    public void m11954d() {
        if (this.f4197h) {
            this.f4196g = true;
            if (!this.f4195f && this.f4196g) {
                this.f4191a.postDelayed(this.f4198i, C1016g.f4552P);
                this.f4195f = true;
            }
        }
    }

    /* renamed from: e */
    public void m11952e() {
        this.f4196g = false;
    }
}
