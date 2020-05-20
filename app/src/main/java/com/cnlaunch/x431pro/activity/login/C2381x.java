package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.widget.DropdownEditText;

/* compiled from: LoginActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.x */
/* loaded from: classes.dex */
final class C2381x implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f13537a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2381x(LoginActivity loginActivity) {
        this.f13537a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        DropdownEditText dropdownEditText;
        DropdownEditText dropdownEditText2;
        EditText editText;
        EditText editText2;
        dropdownEditText = this.f13537a.f13089f;
        String obj = dropdownEditText.getText().toString();
        dropdownEditText2 = this.f13537a.f13089f;
        if (dropdownEditText2.getText().toString().length() == 0) {
            editText2 = this.f13537a.f13090g;
            editText2.setText("");
        }
        if ((LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) && this.f13537a.f13086c.containsKey(obj)) {
            editText = this.f13537a.f13090g;
            editText.setText(this.f13537a.f13086c.get(obj));
        }
    }
}
