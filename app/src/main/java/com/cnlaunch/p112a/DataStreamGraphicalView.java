package com.cnlaunch.p112a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.cnlaunch.p112a.p113a.AbstractChart;
import com.cnlaunch.p112a.p115c.DefaultRenderer;

/* renamed from: com.cnlaunch.a.a */
/* loaded from: classes.dex */
public final class DataStreamGraphicalView extends View {

    /* renamed from: a */
    private AbstractChart f6712a;

    /* renamed from: b */
    private DefaultRenderer f6713b;

    /* renamed from: c */
    private Rect f6714c;

    /* renamed from: d */
    private Handler f6715d;

    /* renamed from: e */
    private Paint f6716e;

    /* renamed from: f */
    private boolean f6717f;

    /* renamed from: g */
    private Bitmap f6718g;

    private DataStreamGraphicalView(Context context) {
        super(context);
        this.f6714c = new Rect();
        this.f6716e = new Paint();
        this.f6718g = null;
    }

    public DataStreamGraphicalView(Context context, AbstractChart abstractChart) {
        this(context);
        this.f6712a = abstractChart;
        this.f6715d = new Handler();
        this.f6713b = this.f6712a.getRenderer();
    }

    public final AbstractChart getChart() {
        return this.f6712a;
    }

    /* renamed from: a */
    public final void m9673a() {
        this.f6715d.post(new RunnableC1406b(this));
    }

    public final void setBitmap(Bitmap bitmap) {
        synchronized (this.f6712a) {
            this.f6718g = bitmap;
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        super.onDraw(canvas);
        canvas.getClipBounds(this.f6714c);
        int i5 = this.f6714c.top;
        int i6 = this.f6714c.left;
        int width = this.f6714c.width();
        int height = this.f6714c.height();
        if (this.f6713b.isInScroll()) {
            i3 = getMeasuredWidth();
            i4 = getMeasuredHeight();
            i2 = 0;
            i = 0;
        } else {
            i = i5;
            i2 = i6;
            i3 = width;
            i4 = height;
        }
        if (this.f6713b.getIsSpecialDataStreamChart()) {
            synchronized (this.f6712a) {
                this.f6713b.setParentViewBitmap(this.f6718g);
            }
        }
        this.f6712a.draw(canvas, i2, i, i3, i4, this.f6716e);
        this.f6717f = true;
    }
}
