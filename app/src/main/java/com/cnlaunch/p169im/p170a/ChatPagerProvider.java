package com.cnlaunch.p169im.p170a;

import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;

/* renamed from: com.cnlaunch.im.a.k */
/* loaded from: classes.dex */
public final class ChatPagerProvider {
    /* renamed from: a */
    public static double m8907a(int i) {
        try {
            return Double.parseDouble(ApplicationConfig.f7802a.getResources().getString(i));
        } catch (Exception e) {
            Log.e("Sanda", "getDoubleXML:" + e.getMessage());
            return 10.0d;
        }
    }

    /* renamed from: b */
    public static int m8906b(int i) {
        try {
            return ApplicationConfig.f7802a.getResources().getInteger(i);
        } catch (Exception e) {
            Log.e("Sanda", "getDoubleXML:" + e.getMessage());
            return 5;
        }
    }
}
