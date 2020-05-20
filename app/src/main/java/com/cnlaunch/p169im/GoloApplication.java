package com.cnlaunch.p169im;

import android.content.Context;
import com.cnlaunch.golo3.p154a.C1551a;
import com.cnlaunch.golo3.p154a.p156b.C1580e;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p165g.C1622y;
import com.ifoer.expedition.pro.R;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.im.a */
/* loaded from: classes.dex */
public final class GoloApplication {

    /* renamed from: a */
    public static int f8908a;

    /* renamed from: b */
    public static Context f8909b;

    /* renamed from: c */
    private static C1551a f8910c;

    /* renamed from: d */
    private static C1580e f8911d;

    /* renamed from: e */
    private static C1580e f8912e;

    /* renamed from: a */
    public static void m8924a(Context context) {
        f8909b = context;
        try {
            ApplicationConfig.m9180a(context, C1622y.m9111a(context.getAssets().open("app.properties")));
            f8910c = new C1551a(context);
            C1580e c1580e = new C1580e();
            f8912e = c1580e;
            c1580e.f7745f = f8909b.getResources().getDrawable(R.drawable.ic_golo_logo_default);
            f8912e.f7744e = f8909b.getResources().getDrawable(R.drawable.ic_golo_logo_fail);
            C1580e c1580e2 = new C1580e();
            f8911d = c1580e2;
            c1580e2.f7745f = f8909b.getResources().getDrawable(R.drawable.square_default_head);
            f8911d.f7744e = f8909b.getResources().getDrawable(R.drawable.square_default_head);
            if ("141".equals(ApplicationConfig.f7814m)) {
                MessageParameters.f23940e = "1242746";
            } else if ("721".equals(ApplicationConfig.f7814m)) {
                MessageParameters.f23940e = "600000";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C1551a m8925a() {
        return f8910c;
    }

    /* renamed from: b */
    public static C1580e m8923b() {
        return f8911d;
    }

    /* renamed from: c */
    public static C1580e m8922c() {
        return f8912e;
    }
}
