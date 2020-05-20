package com.mopub.common.util;

import android.content.Context;
import android.util.TypedValue;
import com.mopub.common.Preconditions;

/* loaded from: classes.dex */
public class Dips {
    public static float pixelsToFloatDips(float f, Context context) {
        return f / m2487a(context);
    }

    public static int pixelsToIntDips(float f, Context context) {
        return (int) (pixelsToFloatDips(f, context) + 0.5f);
    }

    public static float dipsToFloatPixels(float f, Context context) {
        return f * m2487a(context);
    }

    public static int dipsToIntPixels(float f, Context context) {
        return (int) (dipsToFloatPixels(f, context) + 0.5f);
    }

    /* renamed from: a */
    private static float m2487a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float asFloatPixels(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float f, Context context) {
        return (int) (asFloatPixels(f, context) + 0.5f);
    }

    public static int screenWidthAsIntDips(Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips(context.getResources().getDisplayMetrics().widthPixels, context);
    }

    public static int screenHeightAsIntDips(Context context) {
        Preconditions.checkNotNull(context);
        return pixelsToIntDips(context.getResources().getDisplayMetrics().heightPixels, context);
    }
}
