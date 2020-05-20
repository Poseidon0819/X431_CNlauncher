package com.cnlaunch.x431pro.activity.info;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.info.b */
/* loaded from: classes.dex */
public final class CyUtil {
    /* renamed from: a */
    public static boolean m6851a() {
        return LanguageUtils.m9284a() && C2744aa.m5142i(GDApplication.m7909b());
    }

    /* compiled from: CyUtil.java */
    /* renamed from: com.cnlaunch.x431pro.activity.info.b$a */
    /* loaded from: classes.dex */
    public static class C2276a {

        /* renamed from: a */
        private static Map<String, String> f12888a = new HashMap();

        /* renamed from: a */
        public static String m6849a() {
            String m5117v = C2744aa.m5117v();
            String str = f12888a.get(m5117v);
            return TextUtils.isEmpty(str) ? m5117v : str;
        }

        /* renamed from: a */
        public static String m6848a(String str, String str2) {
            return f12888a.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m6850a(Activity activity, String str, String str2) {
        if (activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String deviceId = ((TelephonyManager) activity.getSystemService("phone")).getDeviceId();
        if (deviceId == null) {
            deviceId = Settings.Secure.getString(activity.getContentResolver(), "android_id");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(C2778n.C2783c.m4886a(C2778n.C2783c.m4889a(C1947h.C1948a.f10570a), "ma", deviceId, "serialNo", str, "launchToken", str2)));
        activity.startActivity(intent);
    }
}
