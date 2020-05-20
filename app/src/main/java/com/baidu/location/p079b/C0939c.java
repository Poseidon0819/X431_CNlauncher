package com.baidu.location.p079b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.location.ServiceC1002f;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;

/* renamed from: com.baidu.location.b.c */
/* loaded from: classes.dex */
public class C0939c {

    /* renamed from: d */
    private static C0939c f4148d;

    /* renamed from: a */
    private boolean f4149a = false;

    /* renamed from: b */
    private String f4150b = null;

    /* renamed from: c */
    private C0940a f4151c = null;

    /* renamed from: e */
    private int f4152e = -1;

    /* renamed from: com.baidu.location.b.c$a */
    /* loaded from: classes.dex */
    public class C0940a extends BroadcastReceiver {
        public C0940a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C0939c c0939c;
            String str;
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    C0939c.this.f4149a = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        C0939c.this.f4152e = -1;
                    } else {
                        C0939c.this.f4152e = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            c0939c = C0939c.this;
                            str = "4";
                            c0939c.f4150b = str;
                            break;
                        case 3:
                        case 4:
                            c0939c = C0939c.this;
                            str = "3";
                            c0939c.f4150b = str;
                            break;
                        default:
                            C0939c.this.f4150b = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            C0939c.this.f4150b = "6";
                            C0939c.this.f4149a = true;
                            return;
                        case 2:
                            C0939c.this.f4150b = DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL;
                            C0939c.this.f4149a = true;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception unused) {
                C0939c.this.f4150b = null;
            }
        }
    }

    private C0939c() {
    }

    /* renamed from: a */
    public static synchronized C0939c m12005a() {
        C0939c c0939c;
        synchronized (C0939c.class) {
            if (f4148d == null) {
                f4148d = new C0939c();
            }
            c0939c = f4148d;
        }
        return c0939c;
    }

    /* renamed from: b */
    public void m12001b() {
        this.f4151c = new C0940a();
        try {
            ServiceC1002f.getServiceContext().registerReceiver(this.f4151c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public void m12000c() {
        if (this.f4151c != null) {
            try {
                ServiceC1002f.getServiceContext().unregisterReceiver(this.f4151c);
            } catch (Exception unused) {
            }
        }
        this.f4151c = null;
    }

    /* renamed from: d */
    public String m11999d() {
        return this.f4150b;
    }

    /* renamed from: e */
    public boolean m11998e() {
        return this.f4149a;
    }

    /* renamed from: f */
    public int m11997f() {
        return this.f4152e;
    }
}
