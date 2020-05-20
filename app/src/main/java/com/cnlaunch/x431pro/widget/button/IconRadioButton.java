package com.cnlaunch.x431pro.widget.button;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class IconRadioButton extends IconButton implements Checkable {

    /* renamed from: d */
    private boolean f16540d;

    /* renamed from: e */
    private CompoundButton.OnCheckedChangeListener f16541e;

    public IconRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16540d = false;
        this.f16541e = null;
        setChecked(false);
        setOnClickListener(new View$OnClickListenerC2898f(this));
    }

    @Override // com.cnlaunch.x431pro.widget.button.IconButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f16540d != z) {
            this.f16540d = z;
            super.setChecked(this.f16540d);
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f16541e;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(null, z);
            }
        }
    }

    public void setCheckedInvalidate(boolean z) {
        if (this.f16540d != z) {
            this.f16540d = z;
            super.setChecked(this.f16540d);
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f16541e = onCheckedChangeListener;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f16540d;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.view.View
    public boolean performClick() {
        Log.i("Sanda", "performClick()");
        toggle();
        return super.performClick();
    }
}
