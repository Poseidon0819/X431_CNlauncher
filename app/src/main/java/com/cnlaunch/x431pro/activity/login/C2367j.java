package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompleteUserInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.j */
/* loaded from: classes.dex */
public final class C2367j implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CompleteUserInfoDialog f13523a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2367j(CompleteUserInfoDialog completeUserInfoDialog) {
        this.f13523a = completeUserInfoDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        Button button;
        boolean m6530b;
        CompleteUserInfoDialog completeUserInfoDialog = this.f13523a;
        editText = completeUserInfoDialog.f13509m;
        completeUserInfoDialog.f13519w = editText.getText().toString();
        str = this.f13523a.f13519w;
        if (C2787z.m4815d(str)) {
            button = this.f13523a.f13515s;
            m6530b = this.f13523a.m6530b();
            button.setEnabled(m6530b);
        }
    }
}
