package com.cnlaunch.x431pro.widget.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* renamed from: com.cnlaunch.x431pro.widget.progress.a */
/* loaded from: classes.dex */
public class CustomView extends RelativeLayout {

    /* renamed from: a */
    final int f16640a;

    /* renamed from: b */
    int f16641b;

    /* renamed from: c */
    public boolean f16642c;

    /* renamed from: d */
    boolean f16643d;

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16640a = Color.parseColor("#E2E2E2");
        this.f16642c = false;
        this.f16643d = false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setBackgroundColor(this.f16641b);
        } else {
            setBackgroundColor(this.f16640a);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onAnimationStart() {
        super.onAnimationStart();
        this.f16643d = true;
    }

    @Override // android.view.View
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.f16643d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16643d) {
            invalidate();
        }
    }
}
