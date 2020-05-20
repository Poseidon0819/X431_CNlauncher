package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;

/* loaded from: classes.dex */
public class ProgressBarDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f20618a = new Paint();

    /* renamed from: b */
    private final Paint f20619b;

    /* renamed from: c */
    private int f20620c;

    /* renamed from: d */
    private int f20621d;

    /* renamed from: e */
    private int f20622e;

    /* renamed from: f */
    private int f20623f;

    /* renamed from: g */
    private float f20624g;

    /* renamed from: h */
    private final int f20625h;

    public ProgressBarDrawable(Context context) {
        this.f20618a.setColor(-1);
        this.f20618a.setAlpha(128);
        this.f20618a.setStyle(DrawableConstants.ProgressBar.BACKGROUND_STYLE);
        this.f20618a.setAntiAlias(true);
        this.f20619b = new Paint();
        this.f20619b.setColor(DrawableConstants.ProgressBar.PROGRESS_COLOR);
        this.f20619b.setAlpha(255);
        this.f20619b.setStyle(DrawableConstants.ProgressBar.PROGRESS_STYLE);
        this.f20619b.setAntiAlias(true);
        this.f20625h = Dips.dipsToIntPixels(4.0f, context);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f20618a);
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * (this.f20622e / this.f20620c), getBounds().bottom, this.f20619b);
        int i = this.f20621d;
        if (i <= 0 || i >= this.f20620c) {
            return;
        }
        float f = getBounds().right * this.f20624g;
        canvas.drawRect(f, getBounds().top, f + this.f20625h, getBounds().bottom, this.f20619b);
    }

    public void reset() {
        this.f20623f = 0;
    }

    public void setDurationAndSkipOffset(int i, int i2) {
        this.f20620c = i;
        this.f20621d = i2;
        this.f20624g = this.f20621d / this.f20620c;
    }

    public void setProgress(int i) {
        int i2 = this.f20623f;
        if (i >= i2) {
            this.f20622e = i;
            this.f20623f = i;
        } else if (i != 0) {
            MoPubLog.m2498d(String.format("Progress not monotonically increasing: last = %d, current = %d", Integer.valueOf(i2), Integer.valueOf(i)));
            forceCompletion();
        }
        invalidateSelf();
    }

    @VisibleForTesting
    public void forceCompletion() {
        this.f20622e = this.f20620c;
    }

    @VisibleForTesting
    @Deprecated
    public float getSkipRatio() {
        return this.f20624g;
    }

    @VisibleForTesting
    @Deprecated
    public int getCurrentProgress() {
        return this.f20622e;
    }
}
