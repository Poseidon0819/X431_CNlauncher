package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.support.p012v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class MyViewPager extends ViewPager {

    /* renamed from: g */
    private boolean f16012g;

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16012g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16012g) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setScrollable(boolean z) {
        this.f16012g = z;
    }
}
