package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: com.cnlaunch.im.widget.GoloProgress */
/* loaded from: classes.dex */
public class GoloProgress extends ImageView {

    /* renamed from: a */
    protected Paint f9350a;

    /* renamed from: b */
    protected long f9351b;

    /* renamed from: c */
    protected int f9352c;

    public GoloProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9351b = 0L;
        this.f9352c = 0;
        this.f9350a = new Paint(1);
        this.f9350a.setAntiAlias(true);
        this.f9350a.setFilterBitmap(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (System.currentTimeMillis() - this.f9351b > 40) {
                this.f9351b = System.currentTimeMillis();
                this.f9352c = (this.f9352c + 5) % 360;
            }
            canvas.rotate(this.f9352c, getWidth() / 2.0f, getHeight() / 2.0f);
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas);
            invalidate();
        }
    }
}
