package com.launch.p353a.p360g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.itextpdf.text.pdf.ColumnText;
import com.launch.p353a.p364k.DisplayUtils;

/* renamed from: com.launch.a.g.b */
/* loaded from: classes.dex */
public final class NavCloseView extends View {

    /* renamed from: a */
    private Paint f19956a;

    /* renamed from: b */
    private Context f19957b;

    public NavCloseView(Context context) {
        this(context, (byte) 0);
        this.f19956a.setColor(Color.parseColor("#000000"));
    }

    private NavCloseView(Context context, byte b) {
        super(context, null);
        this.f19956a = new Paint();
        this.f19957b = context;
        this.f19956a.setColor(Color.parseColor("#000000"));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float m2645a = DisplayUtils.m2645a(this.f19957b, 13.0f);
        canvas.drawLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, m2645a, m2645a, this.f19956a);
        canvas.drawLine(m2645a, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, m2645a, this.f19956a);
    }
}
