package com.cnlaunch.x431pro.widget.cycleviewpager;

import android.content.Context;
import android.support.p012v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager {

    /* renamed from: g */
    private boolean f16550g;

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16550g = true;
    }

    public void setScrollable(boolean z) {
        this.f16550g = z;
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16550g) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
