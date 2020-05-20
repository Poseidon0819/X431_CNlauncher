package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class CircularProgressDrawable extends BaseProgressLayerDrawable<SingleCircularProgressDrawable, CircularProgressBackgroundDrawable> {
    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public /* bridge */ /* synthetic */ boolean getShowBackground() {
        return super.getShowBackground();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ boolean getUseIntrinsicPadding() {
        return super.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public /* bridge */ /* synthetic */ void setShowBackground(boolean z) {
        super.setShowBackground(z);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ void setTint(int i) {
        super.setTint(i);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseProgressLayerDrawable, me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public /* bridge */ /* synthetic */ void setUseIntrinsicPadding(boolean z) {
        super.setUseIntrinsicPadding(z);
    }

    public CircularProgressDrawable(int i, Context context) {
        super(new Drawable[]{new CircularProgressBackgroundDrawable(), new SingleCircularProgressDrawable(i), new SingleCircularProgressDrawable(i)}, context);
    }
}
