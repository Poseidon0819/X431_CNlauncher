package com.cnlaunch.x431pro.widget.slidingmenu;

import android.view.animation.Interpolator;

/* compiled from: CustomViewAbove.java */
/* renamed from: com.cnlaunch.x431pro.widget.slidingmenu.b  reason: invalid class name */
/* loaded from: classes.dex */
final class animationInterpolatorC2956b implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
