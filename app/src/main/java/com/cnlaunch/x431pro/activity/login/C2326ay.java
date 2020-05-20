package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ay */
/* loaded from: classes.dex */
final class C2326ay implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13433a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2326ay(RegistActivity_ja registActivity_ja) {
        this.f13433a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        String str2;
        CheckBox checkBox;
        EditText editText2;
        Button button;
        CheckBox checkBox2;
        CheckBox checkBox3;
        RegistActivity_ja registActivity_ja = this.f13433a;
        editText = registActivity_ja.f13258ai;
        registActivity_ja.f13244aK = editText.getText().toString();
        str = this.f13433a.f13244aK;
        if (str.length() == 0) {
            checkBox2 = this.f13433a.f13271av;
            if (checkBox2.getVisibility() == 0) {
                checkBox3 = this.f13433a.f13271av;
                RegistActivity_ja.m6675b(checkBox3, 4, false);
                button = this.f13433a.f13260ak;
                button.setEnabled(this.f13433a.m6659h());
            }
        }
        str2 = this.f13433a.f13244aK;
        if (str2.length() != 4) {
            checkBox = this.f13433a.f13271av;
            RegistActivity_ja.m6675b(checkBox, 0, false);
        } else {
            LoadDialog.m4685a(this.f13433a, (int) R.string.register_check_identify_code);
            RegistActivity_ja registActivity_ja2 = this.f13433a;
            editText2 = registActivity_ja2.f13230W;
            registActivity_ja2.f13273ax = editText2.getText().toString();
            this.f13433a.m7739c(203);
        }
        button = this.f13433a.f13260ak;
        button.setEnabled(this.f13433a.m6659h());
    }
}
