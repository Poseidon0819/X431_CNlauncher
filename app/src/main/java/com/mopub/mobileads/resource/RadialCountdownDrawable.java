package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.resource.DrawableConstants;

/* loaded from: classes.dex */
public class RadialCountdownDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f20626a;

    /* renamed from: b */
    private final Paint f20627b;

    /* renamed from: c */
    private final Paint f20628c;

    /* renamed from: d */
    private Rect f20629d;

    /* renamed from: e */
    private int f20630e;

    /* renamed from: f */
    private int f20631f;

    /* renamed from: g */
    private float f20632g;

    public RadialCountdownDrawable(Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(18.0f, context);
        this.f20626a = new Paint();
        this.f20626a.setColor(-1);
        this.f20626a.setAlpha(128);
        this.f20626a.setStyle(DrawableConstants.RadialCountdown.BACKGROUND_STYLE);
        float f = dipsToIntPixels;
        this.f20626a.setStrokeWidth(f);
        this.f20626a.setAntiAlias(true);
        this.f20627b = new Paint();
        this.f20627b.setColor(-1);
        this.f20627b.setAlpha(255);
        this.f20627b.setStyle(DrawableConstants.RadialCountdown.PROGRESS_STYLE);
        this.f20627b.setStrokeWidth(f);
        this.f20627b.setAntiAlias(true);
        this.f20628c = new Paint();
        this.f20628c.setColor(-1);
        this.f20628c.setTextAlign(DrawableConstants.RadialCountdown.TEXT_ALIGN);
        this.f20628c.setTextSize(dipsToFloatPixels);
        this.f20628c.setAntiAlias(true);
        this.f20629d = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int centerX = getBounds().centerX();
        int centerY = getBounds().centerY();
        canvas.drawCircle(centerX, centerY, Math.min(centerX, centerY), this.f20626a);
        m2278a(canvas, this.f20628c, this.f20629d, String.valueOf(this.f20631f));
        canvas.drawArc(new RectF(getBounds()), -90.0f, this.f20632g, false, this.f20627b);
    }

    public void setInitialCountdown(int i) {
        this.f20630e = i;
    }

    public void updateCountdownProgress(int i) {
        this.f20631f = (int) Numbers.convertMillisecondsToSecondsRoundedUp(this.f20630e - i);
        this.f20632g = (i * 360.0f) / this.f20630e;
        invalidateSelf();
    }

    @VisibleForTesting
    @Deprecated
    public int getInitialCountdownMilliseconds() {
        return this.f20630e;
    }
}
