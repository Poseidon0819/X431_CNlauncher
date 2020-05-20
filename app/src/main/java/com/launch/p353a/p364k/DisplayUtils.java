package com.launch.p353a.p364k;

import android.content.Context;
import android.view.WindowManager;

/* renamed from: com.launch.a.k.b */
/* loaded from: classes.dex */
public final class DisplayUtils {
    /* renamed from: a */
    public static int m2645a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static int m2646a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: b */
    public static int m2644b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }
}
