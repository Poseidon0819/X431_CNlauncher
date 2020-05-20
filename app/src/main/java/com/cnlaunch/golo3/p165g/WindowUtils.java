package com.cnlaunch.golo3.p165g;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.cnlaunch.golo3.p160b.ApplicationConfig;

/* renamed from: com.cnlaunch.golo3.g.z */
/* loaded from: classes.dex */
public final class WindowUtils {

    /* renamed from: a */
    public static DisplayMetrics f8499a = new DisplayMetrics();

    /* renamed from: b */
    public static WindowManager f8500b = (WindowManager) ApplicationConfig.f7802a.getSystemService("window");

    /* renamed from: c */
    public static float f8501c = ApplicationConfig.f7803b.getDisplayMetrics().density;

    /* renamed from: d */
    public static float f8502d = ApplicationConfig.f7803b.getDisplayMetrics().scaledDensity;

    static {
        f8500b.getDefaultDisplay().getMetrics(f8499a);
    }

    /* renamed from: a */
    public static int[] m9110a() {
        return new int[]{f8499a.widthPixels, f8499a.heightPixels};
    }

    /* renamed from: a */
    public static int m9109a(float f) {
        return (int) ((f * f8501c) + 0.5f);
    }
}
