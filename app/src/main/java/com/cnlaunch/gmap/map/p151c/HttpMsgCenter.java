package com.cnlaunch.gmap.map.p151c;

import android.content.Context;
import android.text.TextUtils;
import com.p099c.p100a.HttpUtils;

/* renamed from: com.cnlaunch.gmap.map.c.c */
/* loaded from: classes.dex */
public final class HttpMsgCenter {

    /* renamed from: b */
    private static HttpMsgCenter f7598b;

    /* renamed from: a */
    public HttpUtils f7599a = new HttpUtils();

    /* renamed from: c */
    private Context f7600c;

    private HttpMsgCenter(Context context) {
        this.f7600c = context;
    }

    /* renamed from: a */
    public static HttpMsgCenter m9287a(Context context) {
        HttpMsgCenter httpMsgCenter = new HttpMsgCenter(context);
        f7598b = httpMsgCenter;
        httpMsgCenter.f7600c = context;
        return f7598b;
    }

    /* renamed from: b */
    public static void m9286b(Context context) {
        HttpMsgCenter httpMsgCenter = f7598b;
        if (httpMsgCenter == null || httpMsgCenter.f7599a == null) {
            return;
        }
        if (context == null || !TextUtils.equals(context.getClass().getSimpleName(), "GoloApplication")) {
            httpMsgCenter.f7599a.m9766a(context);
            f7598b = null;
        }
    }
}
