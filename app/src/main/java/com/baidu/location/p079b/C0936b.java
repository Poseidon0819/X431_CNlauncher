package com.baidu.location.p079b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p078a.C0919j;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p084g.C1016g;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.baidu.location.b.b */
/* loaded from: classes.dex */
public class C0936b {

    /* renamed from: a */
    private static C0936b f4139a;

    /* renamed from: b */
    private boolean f4140b = false;

    /* renamed from: c */
    private Handler f4141c = null;

    /* renamed from: d */
    private AlarmManager f4142d = null;

    /* renamed from: e */
    private C0938a f4143e = null;

    /* renamed from: f */
    private PendingIntent f4144f = null;

    /* renamed from: g */
    private long f4145g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.b$a */
    /* loaded from: classes.dex */
    public class C0938a extends BroadcastReceiver {
        private C0938a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (C0936b.this.f4140b && intent.getAction().equals("com.baidu.location.autonotifyloc_7.5.1") && C0936b.this.f4141c != null) {
                C0936b.this.f4144f = null;
                C0936b.this.f4141c.sendEmptyMessage(1);
            }
        }
    }

    private C0936b() {
    }

    /* renamed from: a */
    public static synchronized C0936b m12017a() {
        C0936b c0936b;
        synchronized (C0936b.class) {
            if (f4139a == null) {
                f4139a = new C0936b();
            }
            c0936b = f4139a;
        }
        return c0936b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12007f() {
        if (System.currentTimeMillis() - this.f4145g < 1000) {
            return;
        }
        PendingIntent pendingIntent = this.f4144f;
        if (pendingIntent != null) {
            this.f4142d.cancel(pendingIntent);
            this.f4144f = null;
        }
        if (this.f4144f == null) {
            this.f4144f = PendingIntent.getBroadcast(ServiceC1002f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.5.1"), NTLMConstants.FLAG_UNIDENTIFIED_10);
            this.f4142d.set(0, System.currentTimeMillis() + C1016g.f4558V, this.f4144f);
        }
        Message message2 = new Message();
        message2.what = 22;
        if (System.currentTimeMillis() - this.f4145g < C1016g.f4559W) {
            return;
        }
        this.f4145g = System.currentTimeMillis();
        if (C0991d.m11704a().m11666j()) {
            return;
        }
        C0919j.m12105c().m12110b(message2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12006g() {
        if (this.f4140b) {
            try {
                if (this.f4144f != null) {
                    this.f4142d.cancel(this.f4144f);
                    this.f4144f = null;
                }
                ServiceC1002f.getServiceContext().unregisterReceiver(this.f4143e);
            } catch (Exception unused) {
            }
            this.f4142d = null;
            this.f4143e = null;
            this.f4141c = null;
            this.f4140b = false;
        }
    }

    /* renamed from: b */
    public void m12014b() {
        if (!this.f4140b && C1016g.f4558V >= 10000) {
            if (this.f4141c == null) {
                this.f4141c = new Handler() { // from class: com.baidu.location.b.b.1
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // android.os.Handler
                    public void handleMessage(Message message2) {
                        try {
                            switch (message2.what) {
                                case 1:
                                    C0936b.this.m12007f();
                                    return;
                                case 2:
                                    C0936b.this.m12006g();
                                    return;
                                default:
                                    return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                };
            }
            this.f4142d = (AlarmManager) ServiceC1002f.getServiceContext().getSystemService("alarm");
            this.f4143e = new C0938a();
            ServiceC1002f.getServiceContext().registerReceiver(this.f4143e, new IntentFilter("com.baidu.location.autonotifyloc_7.5.1"), "android.permission.ACCESS_FINE_LOCATION", null);
            this.f4144f = PendingIntent.getBroadcast(ServiceC1002f.getServiceContext(), 0, new Intent("com.baidu.location.autonotifyloc_7.5.1"), NTLMConstants.FLAG_UNIDENTIFIED_10);
            this.f4142d.set(0, System.currentTimeMillis() + C1016g.f4558V, this.f4144f);
            this.f4140b = true;
            this.f4145g = System.currentTimeMillis();
        }
    }

    /* renamed from: c */
    public void m12012c() {
        Handler handler;
        if (this.f4140b && (handler = this.f4141c) != null) {
            handler.sendEmptyMessage(2);
        }
    }

    /* renamed from: d */
    public void m12010d() {
        Handler handler;
        if (this.f4140b && (handler = this.f4141c) != null) {
            handler.sendEmptyMessage(1);
        }
    }

    /* renamed from: e */
    public void m12008e() {
        Handler handler;
        if (this.f4140b && (handler = this.f4141c) != null) {
            handler.sendEmptyMessage(1);
        }
    }
}
