package com.cnlaunch.golo3.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cnlaunch.golo3.p165g.GoloLog;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class MenuHScrollView extends HorizontalScrollView {

    /* renamed from: a */
    private ImageView f8505a;

    /* renamed from: b */
    private ImageView f8506b;

    /* renamed from: c */
    private LinearLayout f8507c;

    /* renamed from: d */
    private int f8508d;

    /* renamed from: e */
    private int f8509e;

    /* renamed from: f */
    private float f8510f;

    /* renamed from: g */
    private int f8511g;

    /* renamed from: h */
    private int f8512h;

    private MenuHScrollView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f8505a = null;
        this.f8506b = null;
        this.f8507c = null;
        this.f8508d = 0;
        this.f8509e = 0;
        this.f8510f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f8511g = -1;
        this.f8512h = 0;
    }

    public MenuHScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        GoloLog.m9132a("MenuHScrollView", "do onScrollChanged  l:" + i + " t:" + i2);
        if (this.f8506b == null || this.f8505a == null) {
            return;
        }
        if (this.f8507c.getWidth() <= this.f8508d) {
            this.f8505a.setVisibility(8);
            this.f8506b.setVisibility(8);
        } else if (i == 0) {
            this.f8505a.setVisibility(8);
            this.f8506b.setVisibility(0);
        } else if (this.f8507c.getWidth() - i == this.f8508d) {
            this.f8505a.setVisibility(0);
            this.f8506b.setVisibility(8);
        } else {
            this.f8505a.setVisibility(0);
            this.f8506b.setVisibility(0);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"NewApi"})
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        GoloLog.m9132a("MenuHScrollView", "do onOverScrolled  scrollX:" + i + "scrollY:" + i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GoloLog.m9132a("MenuHScrollView", "do onTouchEvent ev.getAction():" + motionEvent.getAction());
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.f8512h > 4) {
            int action = motionEvent.getAction() & 255;
            if (action != 3) {
                switch (action) {
                }
            }
            int scrollX = getScrollX();
            int i = scrollX % this.f8509e;
            float x = motionEvent.getX() - this.f8510f;
            GoloLog.m9132a("MenuHScrollView", "scrollx : " + scrollX + " dx: " + i + " mItemWidth:" + this.f8509e + "deltaX:" + x);
            int i2 = this.f8509e;
            if (i >= i2 / 2 && x <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                smoothScrollBy(i2 - i, 0);
                return true;
            }
            smoothScrollBy(-i, 0);
            return true;
        }
        return onTouchEvent;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8512h > 4 && (motionEvent.getAction() & 255) == 0) {
            this.f8510f = motionEvent.getX();
            GoloLog.m9132a("MenuHScrollView", " div mLastMotionX : " + this.f8510f);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
