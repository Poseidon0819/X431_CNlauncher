package me.zhanghai.android.materialprogressbar;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class BaseDrawable extends Drawable implements TintableDrawable {
    protected ColorFilter mColorFilter;
    protected PorterDuffColorFilter mTintFilter;
    protected ColorStateList mTintList;
    protected int mAlpha = 255;
    protected PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
    private DummyConstantState mConstantState = new DummyConstantState();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    protected abstract void onDraw(Canvas canvas, int i, int i2);

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        if (updateTintFilter()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        if (updateTintFilter()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mTintList;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return updateTintFilter();
    }

    private boolean updateTintFilter() {
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList == null || this.mTintMode == null) {
            boolean z = this.mTintFilter != null;
            this.mTintFilter = null;
            return z;
        }
        this.mTintFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), this.mTintMode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        onDraw(canvas, bounds.width(), bounds.height());
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ColorFilter getColorFilterForDrawing() {
        ColorFilter colorFilter = this.mColorFilter;
        return colorFilter != null ? colorFilter : this.mTintFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mConstantState;
    }

    /* loaded from: classes2.dex */
    class DummyConstantState extends Drawable.ConstantState {
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        private DummyConstantState() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return BaseDrawable.this;
        }
    }
}
