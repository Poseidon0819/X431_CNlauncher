package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;

/* compiled from: FindPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.r */
/* loaded from: classes.dex */
final class C2375r implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FindPasswordActivity f13531a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2375r(FindPasswordActivity findPasswordActivity) {
        this.f13531a = findPasswordActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        String str;
        Button button;
        Context context;
        FindPasswordActivity findPasswordActivity = this.f13531a;
        editText = findPasswordActivity.f13068Y;
        findPasswordActivity.f13077ah = editText.getText().toString();
        FindPasswordActivity findPasswordActivity2 = this.f13531a;
        editText2 = findPasswordActivity2.f13067X;
        findPasswordActivity2.f13076ag = editText2.getText().toString();
        str = this.f13531a.f13077ah;
        if (4 != str.length()) {
            button = this.f13531a.f13072ac;
            button.setEnabled(false);
            return;
        }
        this.f13531a.f13050G = System.currentTimeMillis();
        context = this.f13531a.f10981q;
        LoadDialog.m4686a(context);
        this.f13531a.m7739c(203);
    }
}
