package me.zhanghai.android.materialprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes2.dex */
class SingleCircularProgressDrawable extends BaseSingleCircularProgressDrawable implements ShowBackgroundDrawable {
    private static final int LEVEL_MAX = 10000;
    private static final float START_ANGLE_MAX_DYNAMIC = 360.0f;
    private static final float START_ANGLE_MAX_NORMAL = 0.0f;
    private static final float SWEEP_ANGLE_MAX = 360.0f;
    private boolean mShowBackground;
    private final float mStartAngleMax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleCircularProgressDrawable(int i) {
        switch (i) {
            case 0:
                this.mStartAngleMax = 0.0f;
                return;
            case 1:
                this.mStartAngleMax = 360.0f;
                return;
            default:
                throw new IllegalArgumentException("Invalid value for style");
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        invalidateSelf();
        return true;
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public boolean getShowBackground() {
        return this.mShowBackground;
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public void setShowBackground(boolean z) {
        if (this.mShowBackground != z) {
            this.mShowBackground = z;
            invalidateSelf();
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseSingleCircularProgressDrawable
    protected void onDrawRing(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }
        float f = level / 10000.0f;
        float f2 = this.mStartAngleMax * f;
        float f3 = f * 360.0f;
        drawRing(canvas, paint, f2, f3);
        if (this.mShowBackground) {
            drawRing(canvas, paint, f2, f3);
        }
    }
}
