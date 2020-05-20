package com.cnlaunch.golo3.p165g;

import android.content.Context;
import android.content.SharedPreferences;
import com.cnlaunch.golo3.p160b.ApplicationConfig;

/* renamed from: com.cnlaunch.golo3.g.s */
/* loaded from: classes.dex */
public final class SharePreferenceUtils {

    /* renamed from: a */
    SharedPreferences f8486a;

    public SharePreferenceUtils() {
        this.f8486a = null;
        this.f8486a = ApplicationConfig.f7802a.getSharedPreferences(ApplicationConfig.m9181a(), 0);
    }

    public SharePreferenceUtils(Context context) {
        this.f8486a = null;
        this.f8486a = context.getSharedPreferences("user_info", 0);
    }
}
