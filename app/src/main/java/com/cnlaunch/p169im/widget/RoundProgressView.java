package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ifoer.expedition.p348a.C3592a;

/* renamed from: com.cnlaunch.im.widget.RoundProgressView */
/* loaded from: classes.dex */
public class RoundProgressView extends View {

    /* renamed from: a */
    private Paint f9404a;

    /* renamed from: b */
    private int f9405b;

    /* renamed from: c */
    private int f9406c;

    /* renamed from: d */
    private float f9407d;

    /* renamed from: e */
    private float f9408e;

    /* renamed from: f */
    private float f9409f;

    /* renamed from: g */
    private int f9410g;

    /* renamed from: h */
    private int f9411h;

    /* renamed from: i */
    private int f9412i;

    /* renamed from: j */
    private int f9413j;

    public RoundProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9412i = 100;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3592a.C3593a.roundedimageview, 0, 0);
        this.f9407d = obtainStyledAttributes.getDimension(3, 30.0f);
        this.f9409f = obtainStyledAttributes.getDimension(5, 10.0f);
        this.f9405b = obtainStyledAttributes.getColor(2, -1);
        this.f9406c = obtainStyledAttributes.getColor(4, -1);
        this.f9409f = 10.0f;
        this.f9408e = this.f9407d + (this.f9409f / 2.0f);
        this.f9408e = 30.0f;
        this.f9404a = new Paint();
        this.f9404a.setAntiAlias(true);
        this.f9404a.setColor(this.f9406c);
        this.f9404a.setStyle(Paint.Style.STROKE);
        this.f9404a.setStrokeWidth(this.f9409f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f9410g = getWidth() / 2;
        this.f9411h = getHeight() / 2;
        if (this.f9413j > 0) {
            RectF rectF = new RectF();
            int i = this.f9410g;
            float f = this.f9408e;
            rectF.left = i - f;
            int i2 = this.f9411h;
            rectF.top = i2 - f;
            rectF.right = (f * 2.0f) + (i - f);
            rectF.bottom = (2.0f * f) + (i2 - f);
            canvas.drawArc(rectF, -90.0f, (this.f9413j / this.f9412i) * 360.0f, false, this.f9404a);
        }
    }

    public void setProgress(int i) {
        this.f9413j = i;
        postInvalidate();
    }
}
