package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class MarqueeScrollView extends TextView {
    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
    }

    public MarqueeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
