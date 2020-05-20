package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bc */
/* loaded from: classes.dex */
final class C2331bc implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13438a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2331bc(RegistActivity_ja registActivity_ja) {
        this.f13438a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        String str;
        CheckBox checkBox;
        CheckBox checkBox2;
        String str2;
        CheckBox checkBox3;
        Button button;
        String str3;
        String str4;
        String str5;
        CheckBox checkBox4;
        CheckBox checkBox5;
        String str6;
        CheckBox checkBox6;
        CheckBox checkBox7;
        RegistActivity_ja registActivity_ja = this.f13438a;
        editText = registActivity_ja.f13231X;
        registActivity_ja.f13274ay = editText.getText().toString();
        RegistActivity_ja registActivity_ja2 = this.f13438a;
        editText2 = registActivity_ja2.f13232Y;
        registActivity_ja2.f13275az = editText2.getText().toString();
        str = this.f13438a.f13274ay;
        if (str.length() > 5) {
            str6 = this.f13438a.f13274ay;
            if (!C2787z.m4814e(str6)) {
                checkBox7 = this.f13438a.f13264ao;
                RegistActivity_ja.m6675b(checkBox7, 0, false);
            } else {
                checkBox6 = this.f13438a.f13264ao;
                RegistActivity_ja.m6675b(checkBox6, 0, true);
            }
        } else {
            checkBox = this.f13438a.f13264ao;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13438a.f13264ao;
                RegistActivity_ja.m6675b(checkBox2, 4, false);
            }
        }
        str2 = this.f13438a.f13275az;
        if (str2 != null) {
            str3 = this.f13438a.f13275az;
            if (!str3.equals("")) {
                str4 = this.f13438a.f13275az;
                str5 = this.f13438a.f13274ay;
                if (!str4.equals(str5)) {
                    checkBox5 = this.f13438a.f13265ap;
                    RegistActivity_ja.m6675b(checkBox5, 0, false);
                } else {
                    checkBox4 = this.f13438a.f13265ap;
                    RegistActivity_ja.m6675b(checkBox4, 0, true);
                }
                button = this.f13438a.f13260ak;
                button.setEnabled(this.f13438a.m6659h());
            }
        }
        checkBox3 = this.f13438a.f13265ap;
        RegistActivity_ja.m6675b(checkBox3, 4, false);
        button = this.f13438a.f13260ak;
        button.setEnabled(this.f13438a.m6659h());
    }
}
