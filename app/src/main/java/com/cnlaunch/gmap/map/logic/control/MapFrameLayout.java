package com.cnlaunch.gmap.map.logic.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class MapFrameLayout extends FrameLayout {

    /* renamed from: a */
    private boolean f7621a;

    public MapFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7621a = false;
    }

    public void setInterceptTouchEventEnable(boolean z) {
        this.f7621a = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = this.f7621a;
        return z ? z : super.onInterceptTouchEvent(motionEvent);
    }
}
