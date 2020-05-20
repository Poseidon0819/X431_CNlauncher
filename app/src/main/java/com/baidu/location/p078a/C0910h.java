package com.baidu.location.p078a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.p084g.C1005a;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.h */
/* loaded from: classes.dex */
public class C0910h implements LBSAuthManagerListener {

    /* renamed from: a */
    private static Object f3992a = new Object();

    /* renamed from: b */
    private static C0910h f3993b = null;

    /* renamed from: c */
    private int f3994c = 0;

    /* renamed from: d */
    private Context f3995d = null;

    /* renamed from: e */
    private long f3996e = 0;

    /* renamed from: f */
    private String f3997f = null;

    /* renamed from: a */
    public static C0910h m12149a() {
        C0910h c0910h;
        synchronized (f3992a) {
            if (f3993b == null) {
                f3993b = new C0910h();
            }
            c0910h = f3993b;
        }
        return c0910h;
    }

    /* renamed from: b */
    public static String m12146b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m12145c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m12148a(Context context) {
        this.f3995d = context;
        LBSAuthManager.getInstance(this.f3995d).authenticate(false, "lbs_locsdk", null, this);
        this.f3996e = System.currentTimeMillis();
    }

    /* renamed from: b */
    public boolean m12147b() {
        int i = this.f3994c;
        boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
        if (this.f3995d != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f3996e;
            if (!z ? currentTimeMillis < 0 || currentTimeMillis > 10000 : currentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.f3995d).authenticate(false, "lbs_locsdk", null, this);
                this.f3996e = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        this.f3994c = i;
        if (this.f3994c == 0) {
            Log.i(C1005a.f4481a, "LocationAuthManager Authentication AUTHENTICATE_SUCC");
        } else {
            String str2 = C1005a.f4481a;
            Log.i(str2, "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str);
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("token") != null) {
                    this.f3997f = jSONObject.getString("token");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
