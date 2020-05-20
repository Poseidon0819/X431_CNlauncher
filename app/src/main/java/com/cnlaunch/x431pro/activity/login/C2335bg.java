package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bg */
/* loaded from: classes.dex */
final class C2335bg implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13442a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2335bg(RegistActivity_ja registActivity_ja) {
        this.f13442a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        String str2;
        CheckBox checkBox;
        String str3;
        CheckBox checkBox2;
        Button button;
        CheckBox checkBox3;
        RegistActivity_ja registActivity_ja = this.f13442a;
        editText = registActivity_ja.f13251ab;
        registActivity_ja.f13235aB = editText.getText().toString();
        str = this.f13442a.f13235aB;
        if (str.length() < 7) {
            checkBox3 = this.f13442a.f13268as;
            RegistActivity_ja.m6675b(checkBox3, 4, false);
        } else {
            str2 = this.f13442a.f13235aB;
            if (str2.length() >= 7) {
                str3 = this.f13442a.f13235aB;
                if (RegistActivity_ja.m6670c(str3)) {
                    checkBox2 = this.f13442a.f13268as;
                    RegistActivity_ja.m6675b(checkBox2, 0, true);
                }
            }
            checkBox = this.f13442a.f13268as;
            RegistActivity_ja.m6675b(checkBox, 0, false);
        }
        button = this.f13442a.f13260ak;
        button.setEnabled(this.f13442a.m6659h());
    }
}
