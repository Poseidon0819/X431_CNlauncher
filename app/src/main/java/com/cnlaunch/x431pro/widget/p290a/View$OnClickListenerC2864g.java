package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.EditText;

/* compiled from: CustomInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.g */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2864g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CustomInputDialog f16408a;

    public View$OnClickListenerC2864g(CustomInputDialog customInputDialog) {
        this.f16408a = customInputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        CustomInputDialog customInputDialog = this.f16408a;
        editText = customInputDialog.f16398a;
        customInputDialog.mo4574a(editText.getText().toString());
    }
}
