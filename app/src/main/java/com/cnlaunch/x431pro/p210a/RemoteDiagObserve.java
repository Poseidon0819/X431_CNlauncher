package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.x431pro.activity.golo.others.RemoteDiagCMDListener;
import com.cnlaunch.x431pro.activity.golo.others.RunnableC2245l;

/* renamed from: com.cnlaunch.x431pro.a.p */
/* loaded from: classes.dex */
public final class RemoteDiagObserve {

    /* renamed from: a */
    public static Context f10592a = null;

    /* renamed from: b */
    public static String f10593b = null;

    /* renamed from: c */
    public static boolean f10594c = false;

    /* renamed from: d */
    private static int f10595d = 0;

    /* renamed from: e */
    private static boolean f10596e = false;

    /* renamed from: f */
    private static RemoteDiagCMDListener f10597f;

    /* renamed from: g */
    private static int f10598g;

    /* renamed from: a */
    public static void m7938a(Context context, String str) {
        f10592a = context;
        f10593b = str;
        f10596e = false;
        f10594c = true;
        f10595d = 0;
        f10597f = new C1952q(context);
    }

    /* renamed from: a */
    public static void m7939a(int i) {
        Log.i("Sanda", "request_id=" + f10593b);
        if (TextUtils.isEmpty(f10593b) || "null".equalsIgnoreCase(f10593b)) {
            return;
        }
        f10595d = i;
        RemoteDiagCMDListener remoteDiagCMDListener = f10597f;
        String str = f10593b;
        boolean z = f10594c;
        Log.i("Sanda", "sendDiagnoseStatus request_id :" + str + ", status:" + i);
        if (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
            Log.i("Sanda", "TextUtils.isEmpty(request_id) || null.equalsIgnoreCase(request_id)");
            return;
        }
        if (z) {
            if (i != 5 && i != 3) {
                return;
            }
            i = 5;
        }
        remoteDiagCMDListener.f12689b.execute(new RunnableC2245l(remoteDiagCMDListener, i, str));
    }

    /* renamed from: a */
    public static void m7940a() {
        if (f10595d == 1) {
            m7939a(4);
        }
    }

    /* renamed from: b */
    public static boolean m7937b() {
        return f10596e;
    }

    /* renamed from: c */
    public static void m7936c() {
        f10596e = true;
    }
}
