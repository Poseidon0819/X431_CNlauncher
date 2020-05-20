package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes2.dex */
class SingleHorizontalProgressDrawable extends BaseSingleHorizontalProgressDrawable implements ShowBackgroundDrawable {
    private static final int LEVEL_MAX = 10000;
    private boolean mShowBackground;

    public SingleHorizontalProgressDrawable(Context context) {
        super(context);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.zhanghai.android.materialprogressbar.BaseSingleHorizontalProgressDrawable
    public void onDrawRect(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }
        int save = canvas.save();
        canvas.scale(level / 10000.0f, 1.0f, RECT_BOUND.left, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        super.onDrawRect(canvas, paint);
        if (this.mShowBackground) {
            super.onDrawRect(canvas, paint);
        }
        canvas.restoreToCount(save);
    }
}
