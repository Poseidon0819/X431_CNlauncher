package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* compiled from: FindPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.q */
/* loaded from: classes.dex */
final class C2374q implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FindPasswordActivity f13530a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2374q(FindPasswordActivity findPasswordActivity) {
        this.f13530a = findPasswordActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        FindPasswordActivity findPasswordActivity = this.f13530a;
        editText = findPasswordActivity.f13065V;
        findPasswordActivity.f13074ae = editText.getText().toString();
        str = this.f13530a.f13074ae;
        if (str.length() == 12) {
            this.f13530a.m7739c(201);
        }
    }
}
