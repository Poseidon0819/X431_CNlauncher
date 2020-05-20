package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ak */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2812ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputDialog f16147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2812ak(InputDialog inputDialog) {
        this.f16147a = inputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        InputDialog inputDialog = this.f16147a;
        editText = inputDialog.f16145a;
        inputDialog.mo4705a(editText.getText().toString());
        editText2 = this.f16147a.f16145a;
        ((InputMethodManager) this.f16147a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
    }
}
