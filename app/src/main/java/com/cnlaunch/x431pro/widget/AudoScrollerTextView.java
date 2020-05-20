package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AudoScrollerTextView extends TextView {
    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public AudoScrollerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
