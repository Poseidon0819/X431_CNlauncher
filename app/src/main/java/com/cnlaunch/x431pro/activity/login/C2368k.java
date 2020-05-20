package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompleteUserInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.k */
/* loaded from: classes.dex */
public final class C2368k implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CompleteUserInfoDialog f13524a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2368k(CompleteUserInfoDialog completeUserInfoDialog) {
        this.f13524a = completeUserInfoDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        Button button;
        boolean m6530b;
        CompleteUserInfoDialog completeUserInfoDialog = this.f13524a;
        editText = completeUserInfoDialog.f13510n;
        completeUserInfoDialog.f13520x = editText.getText().toString();
        str = this.f13524a.f13520x;
        if (str.length() > 0) {
            button = this.f13524a.f13515s;
            m6530b = this.f13524a.m6530b();
            button.setEnabled(m6530b);
        }
    }
}
