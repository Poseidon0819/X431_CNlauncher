package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.az */
/* loaded from: classes.dex */
final class C2327az implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13434a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2327az(RegistActivity_ja registActivity_ja) {
        this.f13434a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        String str2;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        CheckBox checkBox3;
        CheckBox checkBox4;
        RegistActivity_ja registActivity_ja = this.f13434a;
        editText = registActivity_ja.f13255af;
        registActivity_ja.f13240aG = editText.getText().toString();
        str = this.f13434a.f13240aG;
        if (str.length() <= 0) {
            checkBox3 = this.f13434a.f13270au;
            if (checkBox3.getVisibility() == 0) {
                checkBox4 = this.f13434a.f13270au;
                RegistActivity_ja.m6675b(checkBox4, 4, false);
                button = this.f13434a.f13260ak;
                button.setEnabled(this.f13434a.m6659h());
            }
        }
        str2 = this.f13434a.f13240aG;
        if (RegistActivity_ja.m6667d(str2)) {
            checkBox2 = this.f13434a.f13270au;
            RegistActivity_ja.m6675b(checkBox2, 0, true);
        } else {
            checkBox = this.f13434a.f13270au;
            RegistActivity_ja.m6675b(checkBox, 0, false);
        }
        button = this.f13434a.f13260ak;
        button.setEnabled(this.f13434a.m6659h());
    }
}
