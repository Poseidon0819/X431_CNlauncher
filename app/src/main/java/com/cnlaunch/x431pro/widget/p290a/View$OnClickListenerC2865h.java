package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.EditText;

/* compiled from: CustomInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.h */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2865h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CustomInputDialog f16409a;

    public View$OnClickListenerC2865h(CustomInputDialog customInputDialog) {
        this.f16409a = customInputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        CustomInputDialog customInputDialog = this.f16409a;
        editText = customInputDialog.f16398a;
        editText.getText();
        customInputDialog.mo4567g_();
    }
}
