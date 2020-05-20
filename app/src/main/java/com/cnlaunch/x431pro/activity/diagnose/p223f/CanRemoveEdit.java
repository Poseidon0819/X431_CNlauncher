package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.EditText;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.a */
/* loaded from: classes.dex */
public final class CanRemoveEdit extends EditText {

    /* renamed from: a */
    public Handler f12437a;

    /* renamed from: b */
    private Drawable f12438b;

    /* renamed from: c */
    private Rect f12439c;

    /* renamed from: d */
    private final int f12440d;

    /* renamed from: e */
    private Paint f12441e;

    public CanRemoveEdit(Context context) {
        super(context);
        this.f12440d = 123123;
        m7065a();
        addTextChangedListener(new C2187b(this));
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.textsize_small_S));
        this.f12441e = new Paint();
        this.f12441e.setStrokeWidth(2.0f);
        this.f12441e.setStyle(Paint.Style.STROKE);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(getResources().getDimension(R.dimen.dp_6), getHeight() - getResources().getDimension(R.dimen.dp_5), getWidth() - getResources().getDimension(R.dimen.dp_6), getHeight() - getResources().getDimension(R.dimen.dp_5), this.f12441e);
    }

    /* renamed from: a */
    public final void m7065a() {
        if (getText().toString().length() == 0) {
            setCompoundDrawables(null, null, null, null);
        } else {
            setCompoundDrawables(null, null, this.f12438b, null);
        }
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12438b = null;
        this.f12439c = null;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12438b != null && motionEvent.getAction() == 1) {
            this.f12439c = this.f12438b.getBounds();
            if (((int) motionEvent.getRawX()) > getRight() - (this.f12439c.width() * 3)) {
                Handler handler = this.f12437a;
                if (handler != null) {
                    this.f12437a.sendMessage(handler.obtainMessage(123123, getTag()));
                }
                motionEvent.setAction(3);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable3 != null) {
            this.f12438b = drawable3;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }
}
