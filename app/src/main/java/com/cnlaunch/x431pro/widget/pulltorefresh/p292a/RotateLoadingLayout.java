package com.cnlaunch.x431pro.widget.pulltorefresh.p292a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.a.h */
/* loaded from: classes.dex */
public final class RotateLoadingLayout extends LoadingLayout {

    /* renamed from: f */
    private final Animation f16676f;

    /* renamed from: g */
    private final Matrix f16677g;

    /* renamed from: h */
    private float f16678h;

    /* renamed from: i */
    private float f16679i;

    /* renamed from: j */
    private final boolean f16680j;

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    protected final void mo4459a() {
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: c */
    protected final void mo4455c() {
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    protected final int getDefaultDrawableResId() {
        return R.drawable.pulltorefresh_default_flip;
    }

    public RotateLoadingLayout(Context context, PullToRefreshBase.EnumC2933b enumC2933b, PullToRefreshBase.EnumC2939h enumC2939h, TypedArray typedArray) {
        super(context, enumC2933b, enumC2939h, typedArray);
        this.f16680j = typedArray.getBoolean(15, true);
        this.f16663b.setScaleType(ImageView.ScaleType.MATRIX);
        this.f16677g = new Matrix();
        this.f16663b.setImageMatrix(this.f16677g);
        this.f16676f = new RotateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 720.0f, 1, 0.5f, 1, 0.5f);
        this.f16676f.setInterpolator(f16662a);
        this.f16676f.setDuration(1200L);
        this.f16676f.setRepeatCount(-1);
        this.f16676f.setRepeatMode(1);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    public final void mo4457a(Drawable drawable) {
        if (drawable != null) {
            this.f16678h = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.f16679i = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    protected final void mo4458a(float f) {
        this.f16677g.setRotate(this.f16680j ? f * 90.0f : Math.max((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, Math.min(180.0f, (f * 360.0f) - 180.0f)), this.f16678h, this.f16679i);
        this.f16663b.setImageMatrix(this.f16677g);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: b */
    protected final void mo4456b() {
        this.f16663b.startAnimation(this.f16676f);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: d */
    protected final void mo4454d() {
        this.f16663b.clearAnimation();
        Matrix matrix = this.f16677g;
        if (matrix != null) {
            matrix.reset();
            this.f16663b.setImageMatrix(this.f16677g);
        }
    }
}
