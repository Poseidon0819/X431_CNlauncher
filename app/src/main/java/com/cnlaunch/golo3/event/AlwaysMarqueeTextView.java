package com.cnlaunch.golo3.event;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AlwaysMarqueeTextView extends TextView {
    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
