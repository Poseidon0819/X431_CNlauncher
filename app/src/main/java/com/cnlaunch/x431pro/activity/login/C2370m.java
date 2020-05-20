package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompleteUserInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.m */
/* loaded from: classes.dex */
public final class C2370m implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CompleteUserInfoDialog f13526a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2370m(CompleteUserInfoDialog completeUserInfoDialog) {
        this.f13526a = completeUserInfoDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        Button button;
        boolean m6530b;
        CompleteUserInfoDialog completeUserInfoDialog = this.f13526a;
        editText = completeUserInfoDialog.f13512p;
        completeUserInfoDialog.f13521y = editText.getText().toString();
        str = this.f13526a.f13521y;
        if (C2787z.m4816c(str)) {
            button = this.f13526a.f13515s;
            m6530b = this.f13526a.m6530b();
            button.setEnabled(m6530b);
        }
    }
}
