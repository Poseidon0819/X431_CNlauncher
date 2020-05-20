package com.cnlaunch.x431pro.widget.pulltorefresh.p292a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.a.d */
/* loaded from: classes.dex */
public final class IndicatorLayout extends FrameLayout implements Animation.AnimationListener {

    /* renamed from: a */
    private Animation f16656a;

    /* renamed from: b */
    private Animation f16657b;

    /* renamed from: c */
    private ImageView f16658c;

    /* renamed from: d */
    private final Animation f16659d;

    /* renamed from: e */
    private final Animation f16660e;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    public IndicatorLayout(Context context, PullToRefreshBase.EnumC2933b enumC2933b) {
        super(context);
        int i;
        int i2;
        this.f16658c = new ImageView(context);
        Drawable drawable = getResources().getDrawable(R.drawable.pulltorefresh_indicator_arrow);
        this.f16658c.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.indicator_internal_padding);
        this.f16658c.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.f16658c);
        if (C2927e.f16661a[enumC2933b.ordinal()] == 1) {
            i = R.anim.slide_in_from_bottom;
            setBackgroundResource(R.drawable.pulltorefresh_bg_bottom);
            this.f16658c.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, drawable.getIntrinsicWidth() / 2.0f, drawable.getIntrinsicHeight() / 2.0f);
            this.f16658c.setImageMatrix(matrix);
            i2 = R.anim.slide_out_to_bottom;
        } else {
            i = R.anim.slide_in_from_top;
            i2 = R.anim.slide_out_to_top;
            setBackgroundResource(R.drawable.pulltorefresh_bg_top);
        }
        this.f16656a = AnimationUtils.loadAnimation(context, i);
        this.f16656a.setAnimationListener(this);
        this.f16657b = AnimationUtils.loadAnimation(context, i2);
        this.f16657b.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f16659d = new RotateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f16659d.setInterpolator(linearInterpolator);
        this.f16659d.setDuration(150L);
        this.f16659d.setFillAfter(true);
        this.f16660e = new RotateAnimation(-180.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1, 0.5f, 1, 0.5f);
        this.f16660e.setInterpolator(linearInterpolator);
        this.f16660e.setDuration(150L);
        this.f16660e.setFillAfter(true);
    }

    /* renamed from: a */
    public final boolean m4471a() {
        Animation animation = getAnimation();
        return animation != null ? this.f16656a == animation : getVisibility() == 0;
    }

    /* renamed from: b */
    public final void m4470b() {
        startAnimation(this.f16657b);
    }

    /* renamed from: c */
    public final void m4469c() {
        this.f16658c.clearAnimation();
        startAnimation(this.f16656a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        if (animation == this.f16657b) {
            this.f16658c.clearAnimation();
            setVisibility(8);
        } else if (animation == this.f16656a) {
            setVisibility(0);
        }
        clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    /* renamed from: d */
    public final void m4468d() {
        this.f16658c.startAnimation(this.f16659d);
    }

    /* renamed from: e */
    public final void m4467e() {
        this.f16658c.startAnimation(this.f16660e);
    }
}
