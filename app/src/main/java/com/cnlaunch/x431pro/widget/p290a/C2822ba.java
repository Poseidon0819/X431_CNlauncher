package com.cnlaunch.x431pro.widget.p290a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.widget.DropdownEditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ba */
/* loaded from: classes.dex */
public final class C2822ba implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ LoginDialog f16272a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2822ba(LoginDialog loginDialog) {
        this.f16272a = loginDialog;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        DropdownEditText dropdownEditText;
        DropdownEditText dropdownEditText2;
        EditText editText;
        EditText editText2;
        dropdownEditText = this.f16272a.f16257j;
        String obj = dropdownEditText.getText().toString();
        dropdownEditText2 = this.f16272a.f16257j;
        if (dropdownEditText2.getText().toString().length() == 0) {
            editText2 = this.f16272a.f16258k;
            editText2.setText("");
        }
        if ((LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) && this.f16272a.f16254g.containsKey(obj)) {
            editText = this.f16272a.f16258k;
            editText.setText(this.f16272a.f16254g.get(obj));
        }
    }
}
