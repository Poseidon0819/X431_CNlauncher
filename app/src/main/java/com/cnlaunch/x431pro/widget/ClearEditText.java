package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class ClearEditText extends EditText implements TextWatcher, View.OnFocusChangeListener {

    /* renamed from: a */
    private Drawable f15957a;

    /* renamed from: b */
    private boolean f15958b;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private ClearEditText(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 16842862);
        this.f15958b = false;
        this.f15957a = getCompoundDrawables()[2];
        if (this.f15957a == null) {
            this.f15957a = getResources().getDrawable(R.drawable.search_clear_pressed);
        }
        Drawable drawable = this.f15957a;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f15957a.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null) {
            boolean z = true;
            if (motionEvent.getAction() == 1) {
                if ((motionEvent.getX() <= ((float) (((getWidth() - getPaddingRight()) - this.f15957a.getIntrinsicWidth()) + (-20))) || motionEvent.getX() >= ((float) getWidth())) ? false : false) {
                    setText("");
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    public void setClearIconVisible(boolean z) {
        if (this.f15958b && z) {
            return;
        }
        this.f15958b = z;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f15957a : null, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setClearIconVisible(charSequence.length() > 0);
    }
}
