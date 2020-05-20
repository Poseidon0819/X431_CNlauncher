package com.mopub.mobileads.resource;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants;

/* loaded from: classes.dex */
public class CtaButtonDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f20611a;

    /* renamed from: b */
    private final Paint f20612b;

    /* renamed from: c */
    private final Paint f20613c;

    /* renamed from: d */
    private final RectF f20614d;

    /* renamed from: e */
    private final Rect f20615e;

    /* renamed from: f */
    private final int f20616f;

    /* renamed from: g */
    private String f20617g;

    public CtaButtonDrawable(Context context) {
        int dipsToIntPixels = Dips.dipsToIntPixels(2.0f, context);
        float dipsToFloatPixels = Dips.dipsToFloatPixels(15.0f, context);
        this.f20611a = new Paint();
        this.f20611a.setColor(-16777216);
        this.f20611a.setAlpha(51);
        this.f20611a.setStyle(DrawableConstants.CtaButton.BACKGROUND_STYLE);
        this.f20611a.setAntiAlias(true);
        this.f20612b = new Paint();
        this.f20612b.setColor(-1);
        this.f20612b.setAlpha(51);
        this.f20612b.setStyle(DrawableConstants.CtaButton.OUTLINE_STYLE);
        this.f20612b.setStrokeWidth(dipsToIntPixels);
        this.f20612b.setAntiAlias(true);
        this.f20613c = new Paint();
        this.f20613c.setColor(-1);
        this.f20613c.setTextAlign(DrawableConstants.CtaButton.TEXT_ALIGN);
        this.f20613c.setTypeface(DrawableConstants.CtaButton.TEXT_TYPEFACE);
        this.f20613c.setTextSize(dipsToFloatPixels);
        this.f20613c.setAntiAlias(true);
        this.f20615e = new Rect();
        this.f20617g = DrawableConstants.CtaButton.DEFAULT_CTA_TEXT;
        this.f20614d = new RectF();
        this.f20616f = Dips.dipsToIntPixels(6.0f, context);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f20614d.set(getBounds());
        RectF rectF = this.f20614d;
        int i = this.f20616f;
        canvas.drawRoundRect(rectF, i, i, this.f20611a);
        RectF rectF2 = this.f20614d;
        int i2 = this.f20616f;
        canvas.drawRoundRect(rectF2, i2, i2, this.f20612b);
        m2278a(canvas, this.f20613c, this.f20615e, this.f20617g);
    }

    public void setCtaText(String str) {
        this.f20617g = str;
        invalidateSelf();
    }

    @VisibleForTesting
    @Deprecated
    public String getCtaText() {
        return this.f20617g;
    }
}
