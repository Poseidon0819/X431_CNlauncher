package com.cnlaunch.golo3.p163e;

import android.content.Context;
import android.text.TextUtils;
import com.p099c.p100a.HttpUtils;

/* compiled from: HttpMsgCenter.java */
/* renamed from: com.cnlaunch.golo3.e.a */
/* loaded from: classes.dex */
public class C1609a {

    /* renamed from: b */
    private static C1609a f8434b;

    /* renamed from: a */
    public HttpUtils f8435a = new HttpUtils();

    /* renamed from: c */
    private Context f8436c;

    private C1609a(Context context) {
        this.f8436c = context;
    }

    /* renamed from: a */
    public static C1609a m9164a(Context context) {
        if (f8434b == null) {
            synchronized (C1609a.class) {
                if (f8434b == null) {
                    f8434b = new C1609a(context);
                }
            }
        }
        C1609a c1609a = f8434b;
        c1609a.f8436c = context;
        return c1609a;
    }

    /* renamed from: b */
    public static void m9163b(Context context) {
        C1609a c1609a = f8434b;
        if (c1609a == null || c1609a.f8435a == null) {
            return;
        }
        if (context == null || !TextUtils.equals(context.getClass().getSimpleName(), "GoloApplication")) {
            c1609a.f8435a.m9766a(context);
        }
    }
}
