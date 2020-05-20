package com.cnlaunch.x431pro.widget.button;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.widget.TextView;

/* loaded from: classes.dex */
public class MequeeTextView extends TextView {
    @Override // android.view.View
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        return true;
    }

    public MequeeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }
}
