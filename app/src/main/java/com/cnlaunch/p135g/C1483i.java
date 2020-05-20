package com.cnlaunch.p135g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: PreferencesManager.java */
@SuppressLint({"SdCardPath", "DefaultLocale"})
/* renamed from: com.cnlaunch.g.i */
/* loaded from: classes.dex */
class C1483i {

    /* renamed from: f */
    private static String f7316f = "LOCATION_DATA";

    /* renamed from: g */
    private static C1483i f7317g;

    /* renamed from: a */
    SharedPreferences f7318a;

    /* renamed from: c */
    private Context f7320c;

    /* renamed from: b */
    private final String f7319b = C1483i.class.getSimpleName();

    /* renamed from: d */
    private String f7321d = "/data/data/";

    /* renamed from: e */
    private String f7322e = "/shared_prefs";

    private C1483i(Context context, String str) {
        this.f7320c = context;
        this.f7318a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static C1483i m9416a(Context context) {
        return m9415a(context, f7316f);
    }

    /* renamed from: a */
    private static C1483i m9415a(Context context, String str) {
        if (f7317g == null) {
            synchronized (C1483i.class) {
                if (f7317g == null) {
                    f7317g = new C1483i(context, str);
                }
            }
        }
        return f7317g;
    }

    /* renamed from: a */
    public final void m9412a(String str, String str2) {
        SharedPreferences.Editor edit = this.f7318a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putString(str, str2);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final void m9413a(String str, double d) {
        SharedPreferences.Editor edit = this.f7318a.edit();
        if (edit != null) {
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            edit.putString(str, String.valueOf(d));
            edit.commit();
        }
    }

    /* renamed from: b */
    public final String m9411b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        return this.f7318a.getString(str, str2);
    }

    /* renamed from: a */
    public final double m9414a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        try {
            return Double.parseDouble(this.f7318a.getString(str, "0"));
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}
