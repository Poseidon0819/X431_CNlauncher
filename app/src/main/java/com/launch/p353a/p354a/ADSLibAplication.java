package com.launch.p353a.p354a;

import android.app.Application;
import android.content.Context;
import java.io.InputStream;

/* renamed from: com.launch.a.a.a */
/* loaded from: classes.dex */
public final class ADSLibAplication extends Application {

    /* renamed from: a */
    private static Context f19875a;

    /* renamed from: b */
    private static InputStream f19876b;

    /* renamed from: c */
    private static int f19877c;

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        f19875a = getApplicationContext();
    }

    /* renamed from: a */
    public static void m2705a(InputStream inputStream) {
        f19876b = inputStream;
    }

    /* renamed from: a */
    public static InputStream m2706a() {
        return f19876b;
    }

    /* renamed from: b */
    public static int m2704b() {
        return f19877c;
    }
}
