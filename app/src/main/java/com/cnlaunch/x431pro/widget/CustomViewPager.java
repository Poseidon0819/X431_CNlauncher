package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.support.p012v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: g */
    public boolean f15961g;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15961g = true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.f15961g) {
            super.scrollTo(i, i2);
        }
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f15961g && super.onTouchEvent(motionEvent);
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f15961g && super.onInterceptTouchEvent(motionEvent);
    }
}
