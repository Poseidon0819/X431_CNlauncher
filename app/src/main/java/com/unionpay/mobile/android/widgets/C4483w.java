package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.w */
/* loaded from: classes2.dex */
public final class C4483w implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC4479u f23512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4483w(View$OnClickListenerC4479u view$OnClickListenerC4479u) {
        this.f23512a = view$OnClickListenerC4479u;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ImageView imageView;
        ImageView imageView2;
        int i4;
        EditText editText;
        imageView = this.f23512a.f23500c;
        if (imageView == null) {
            return;
        }
        if (View$OnClickListenerC4479u.m598b(this.f23512a)) {
            editText = this.f23512a.f23499b;
            if (editText.isFocused()) {
                imageView2 = this.f23512a.f23500c;
                i4 = 0;
                imageView2.setVisibility(i4);
            }
        }
        imageView2 = this.f23512a.f23500c;
        i4 = 8;
        imageView2.setVisibility(i4);
    }
}
