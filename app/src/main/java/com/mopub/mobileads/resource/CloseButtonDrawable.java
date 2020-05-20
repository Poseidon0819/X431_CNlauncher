package com.mopub.mobileads.resource;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.resource.DrawableConstants;

/* loaded from: classes.dex */
public class CloseButtonDrawable extends BaseWidgetDrawable {

    /* renamed from: a */
    private final Paint f20609a;

    /* renamed from: b */
    private final float f20610b;

    public CloseButtonDrawable() {
        this(8.0f);
    }

    public CloseButtonDrawable(float f) {
        this.f20610b = f / 2.0f;
        this.f20609a = new Paint();
        this.f20609a.setColor(-1);
        this.f20609a.setStrokeWidth(f);
        this.f20609a.setStrokeCap(DrawableConstants.CloseButton.STROKE_CAP);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        float f = this.f20610b;
        float f2 = height;
        float f3 = width;
        canvas.drawLine(f + ColumnText.GLOBAL_SPACE_CHAR_RATIO, f2 - f, f3 - f, f + ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f20609a);
        float f4 = this.f20610b;
        canvas.drawLine(f4 + ColumnText.GLOBAL_SPACE_CHAR_RATIO, f4 + ColumnText.GLOBAL_SPACE_CHAR_RATIO, f3 - f4, f2 - f4, this.f20609a);
    }
}
