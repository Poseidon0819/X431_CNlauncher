package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.al */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2813al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputDialog f16148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2813al(InputDialog inputDialog) {
        this.f16148a = inputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        InputDialog inputDialog = this.f16148a;
        editText = inputDialog.f16145a;
        editText.getText();
        inputDialog.mo4701e_();
        editText2 = this.f16148a.f16145a;
        ((InputMethodManager) this.f16148a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText2.getWindowToken(), 0);
    }
}
