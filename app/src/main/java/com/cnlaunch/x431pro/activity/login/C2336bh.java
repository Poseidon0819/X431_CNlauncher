package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bh */
/* loaded from: classes.dex */
final class C2336bh implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13443a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2336bh(RegistActivity_ja registActivity_ja) {
        this.f13443a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        Button button;
        CheckBox checkBox2;
        CheckBox checkBox3;
        RegistActivity_ja registActivity_ja = this.f13443a;
        editText = registActivity_ja.f13252ac;
        registActivity_ja.f13237aD = editText.getText().toString();
        str = this.f13443a.f13237aD;
        if (str.length() <= 0) {
            checkBox2 = this.f13443a.f13269at;
            if (checkBox2.getVisibility() == 0) {
                checkBox3 = this.f13443a.f13269at;
                RegistActivity_ja.m6675b(checkBox3, 4, false);
                button = this.f13443a.f13260ak;
                button.setEnabled(this.f13443a.m6659h());
            }
        }
        checkBox = this.f13443a.f13269at;
        RegistActivity_ja.m6675b(checkBox, 0, true);
        button = this.f13443a.f13260ak;
        button.setEnabled(this.f13443a.m6659h());
    }
}
