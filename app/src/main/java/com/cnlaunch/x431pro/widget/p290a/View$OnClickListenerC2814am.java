package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.am */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2814am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputDialog f16149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2814am(InputDialog inputDialog) {
        this.f16149a = inputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        InputDialog inputDialog = this.f16149a;
        editText = inputDialog.f16145a;
        inputDialog.mo4705a(editText.getText().toString());
    }
}
