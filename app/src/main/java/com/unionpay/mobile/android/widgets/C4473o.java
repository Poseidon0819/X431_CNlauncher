package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.unionpay.mobile.android.widgets.o */
/* loaded from: classes2.dex */
public final class C4473o extends View {

    /* renamed from: a */
    private Paint f23477a;

    /* renamed from: b */
    private int f23478b;

    public C4473o(Context context) {
        this(context, -7829368, 0);
    }

    public C4473o(Context context, int i, int i2) {
        super(context);
        this.f23477a = new Paint();
        this.f23477a.setStyle(Paint.Style.STROKE);
        this.f23477a.setStrokeWidth(4.0f);
        this.f23477a.setColor(i);
        this.f23477a.setPathEffect(null);
        this.f23478b = i2;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f23478b;
        if (i == 0) {
            float height = getHeight() >> 1;
            canvas.drawLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, height, getWidth(), height, this.f23477a);
        } else if (1 == i) {
            float width = getWidth() >> 1;
            canvas.drawLine(width, ColumnText.GLOBAL_SPACE_CHAR_RATIO, width, getHeight(), this.f23477a);
        }
    }
}
