package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ExpandableListView;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class ExpandableListViewForScorllView extends ExpandableListView {

    /* renamed from: a */
    private ScrollView f16011a;

    public ExpandableListViewForScorllView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                ScrollView scrollView = this.f16011a;
                if (scrollView != null) {
                    scrollView.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ScrollView scrollView2 = this.f16011a;
                if (scrollView2 != null) {
                    scrollView2.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public ScrollView getScrollView() {
        return this.f16011a;
    }

    public void setScrollView(ScrollView scrollView) {
        this.f16011a = scrollView;
    }
}
