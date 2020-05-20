package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.an */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2815an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ InputDialog f16150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2815an(InputDialog inputDialog) {
        this.f16150a = inputDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        InputDialog inputDialog = this.f16150a;
        editText = inputDialog.f16145a;
        editText.getText();
        inputDialog.mo4701e_();
    }
}
