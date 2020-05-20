package com.cnlaunch.x431pro.widget.pulltorefresh.p292a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.a.b */
/* loaded from: classes.dex */
public final class FlipLoadingLayout extends LoadingLayout {

    /* renamed from: f */
    private final Animation f16653f;

    /* renamed from: g */
    private final Animation f16654g;

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    protected final void mo4458a(float f) {
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    protected final int getDefaultDrawableResId() {
        return R.drawable.pulltorefresh_default_flip;
    }

    public FlipLoadingLayout(Context context, PullToRefreshBase.EnumC2933b enumC2933b, PullToRefreshBase.EnumC2939h enumC2939h, TypedArray typedArray) {
        super(context, enumC2933b, enumC2939h, typedArray);
        float f = enumC2933b == PullToRefreshBase.EnumC2933b.PULL_FROM_START ? -180 : Opcodes.GETFIELD;
        this.f16653f = new RotateAnimation(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, 1, 0.5f, 1, 0.5f);
        this.f16653f.setInterpolator(f16662a);
        this.f16653f.setDuration(150L);
        this.f16653f.setFillAfter(true);
        this.f16654g = new RotateAnimation(f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1, 0.5f, 1, 0.5f);
        this.f16654g.setInterpolator(f16662a);
        this.f16654g.setDuration(150L);
        this.f16654g.setFillAfter(true);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    protected final void mo4457a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            ViewGroup.LayoutParams layoutParams = this.f16663b.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.f16663b.requestLayout();
            this.f16663b.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate((layoutParams.width - intrinsicWidth) / 2.0f, (layoutParams.height - intrinsicHeight) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), layoutParams.width / 2.0f, layoutParams.height / 2.0f);
            this.f16663b.setImageMatrix(matrix);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: a */
    protected final void mo4459a() {
        if (this.f16653f == this.f16663b.getAnimation()) {
            this.f16663b.startAnimation(this.f16654g);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: b */
    protected final void mo4456b() {
        this.f16663b.clearAnimation();
        this.f16663b.setVisibility(4);
        this.f16664c.setVisibility(0);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: c */
    protected final void mo4455c() {
        this.f16663b.startAnimation(this.f16653f);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.p292a.LoadingLayout
    /* renamed from: d */
    protected final void mo4454d() {
        this.f16663b.clearAnimation();
        this.f16664c.setVisibility(8);
        this.f16663b.setVisibility(0);
    }

    private float getDrawableRotationAngle() {
        switch (C2926c.f16655a[this.f16665d.ordinal()]) {
            case 1:
                return this.f16666e == PullToRefreshBase.EnumC2939h.HORIZONTAL ? 90.0f : 180.0f;
            case 2:
                if (this.f16666e == PullToRefreshBase.EnumC2939h.HORIZONTAL) {
                    return 270.0f;
                }
                break;
        }
        return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }
}
