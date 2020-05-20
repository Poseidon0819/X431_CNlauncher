package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class AutoLinefeedLayout extends ViewGroup {
    private AutoLinefeedLayout(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
    }

    public AutoLinefeedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
            }
        }
        if (mode != Integer.MIN_VALUE && mode != 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int i4 = size;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                int measuredWidth = childAt2.getMeasuredWidth();
                int measuredHeight = childAt2.getMeasuredHeight();
                if (i4 < measuredWidth) {
                    paddingTop += i5;
                    i4 = size;
                    i5 = 0;
                }
                i4 -= measuredWidth;
                i5 = Math.max(measuredHeight, i5);
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(paddingTop + i5, NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i5 = 0;
        int i6 = measuredWidth;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i6 < measuredWidth2) {
                    paddingTop += i5;
                    paddingLeft = getPaddingLeft();
                    i6 = measuredWidth;
                    i5 = 0;
                }
                int i8 = paddingLeft + measuredWidth2;
                childAt.layout(paddingLeft, paddingTop, i8, paddingTop + measuredHeight);
                i6 -= measuredWidth2;
                i5 = Math.max(i5, measuredHeight);
                paddingLeft = i8;
            }
        }
    }
}
