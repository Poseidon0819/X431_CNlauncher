package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ap */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2817ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputDialog f16152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2817ap(InputDialog inputDialog) {
        this.f16152a = inputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        InputDialog inputDialog = this.f16152a;
        editText = inputDialog.f16145a;
        editText.getText();
        inputDialog.mo4701e_();
    }
}
