package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes2.dex */
class BaseSingleHorizontalProgressDrawable extends BaseProgressDrawable {
    private static final int PADDED_INTRINSIC_HEIGHT_DP = 16;
    private static final int PROGRESS_INTRINSIC_HEIGHT_DP = 4;
    protected static final RectF RECT_BOUND = new RectF(-180.0f, -1.0f, 180.0f, 1.0f);
    private static final RectF RECT_PADDED_BOUND = new RectF(-180.0f, -4.0f, 180.0f, 4.0f);
    private int mPaddedIntrinsicHeight;
    private int mProgressIntrinsicHeight;

    public BaseSingleHorizontalProgressDrawable(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.mProgressIntrinsicHeight = Math.round(4.0f * f);
        this.mPaddedIntrinsicHeight = Math.round(f * 16.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mUseIntrinsicPadding ? this.mPaddedIntrinsicHeight : this.mProgressIntrinsicHeight;
    }

    @Override // me.zhanghai.android.materialprogressbar.BasePaintDrawable
    protected void onPreparePaint(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // me.zhanghai.android.materialprogressbar.BasePaintDrawable
    protected void onDraw(Canvas canvas, int i, int i2, Paint paint) {
        if (this.mUseIntrinsicPadding) {
            canvas.scale(i / RECT_PADDED_BOUND.width(), i2 / RECT_PADDED_BOUND.height());
            canvas.translate(RECT_PADDED_BOUND.width() / 2.0f, RECT_PADDED_BOUND.height() / 2.0f);
        } else {
            canvas.scale(i / RECT_BOUND.width(), i2 / RECT_BOUND.height());
            canvas.translate(RECT_BOUND.width() / 2.0f, RECT_BOUND.height() / 2.0f);
        }
        onDrawRect(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawRect(Canvas canvas, Paint paint) {
        canvas.drawRect(RECT_BOUND, paint);
    }
}
