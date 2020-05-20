package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bf */
/* loaded from: classes.dex */
final class C2334bf implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13441a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2334bf(RegistActivity_ja registActivity_ja) {
        this.f13441a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        Button button;
        CheckBox checkBox2;
        CheckBox checkBox3;
        RegistActivity_ja registActivity_ja = this.f13441a;
        editText = registActivity_ja.f13250aa;
        registActivity_ja.f13236aC = editText.getText().toString();
        str = this.f13441a.f13236aC;
        if (str.length() <= 0) {
            checkBox2 = this.f13441a.f13267ar;
            if (checkBox2.getVisibility() == 0) {
                checkBox3 = this.f13441a.f13267ar;
                RegistActivity_ja.m6675b(checkBox3, 4, false);
                button = this.f13441a.f13260ak;
                button.setEnabled(this.f13441a.m6659h());
            }
        }
        checkBox = this.f13441a.f13267ar;
        RegistActivity_ja.m6675b(checkBox, 0, true);
        button = this.f13441a.f13260ak;
        button.setEnabled(this.f13441a.m6659h());
    }
}
