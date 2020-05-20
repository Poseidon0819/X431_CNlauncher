package com.cnlaunch.x431pro.widget.progress;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

/* compiled from: Utils.java */
/* renamed from: com.cnlaunch.x431pro.widget.progress.c */
/* loaded from: classes.dex */
public final class C2923c {
    /* renamed from: a */
    public static int m4475a(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m4474a(View view) {
        if (view.getId() == 16908290) {
            return view.getTop();
        }
        return view.getTop() + m4474a((View) view.getParent());
    }

    /* renamed from: b */
    public static int m4473b(View view) {
        if (view.getId() == 16908290) {
            return view.getLeft();
        }
        return view.getLeft() + m4473b((View) view.getParent());
    }
}
