package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bd */
/* loaded from: classes.dex */
final class C2332bd implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13439a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2332bd(RegistActivity_ja registActivity_ja) {
        this.f13439a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        String str;
        String str2;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        CheckBox checkBox3;
        String str3;
        String str4;
        String str5;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        RegistActivity_ja registActivity_ja = this.f13439a;
        editText = registActivity_ja.f13231X;
        registActivity_ja.f13274ay = editText.getText().toString();
        RegistActivity_ja registActivity_ja2 = this.f13439a;
        editText2 = registActivity_ja2.f13232Y;
        registActivity_ja2.f13275az = editText2.getText().toString();
        str = this.f13439a.f13275az;
        int length = str.length();
        str2 = this.f13439a.f13274ay;
        if (length >= str2.length()) {
            checkBox3 = this.f13439a.f13264ao;
            if (checkBox3.getVisibility() == 0) {
                str3 = this.f13439a.f13275az;
                str4 = this.f13439a.f13274ay;
                if (!str3.equals(str4)) {
                    checkBox6 = this.f13439a.f13265ap;
                    RegistActivity_ja.m6675b(checkBox6, 0, false);
                } else {
                    str5 = this.f13439a.f13275az;
                    if (!C2787z.m4812g(str5)) {
                        checkBox5 = this.f13439a.f13265ap;
                        RegistActivity_ja.m6675b(checkBox5, 0, false);
                    } else {
                        checkBox4 = this.f13439a.f13265ap;
                        RegistActivity_ja.m6675b(checkBox4, 0, true);
                    }
                }
            }
        } else {
            checkBox = this.f13439a.f13265ap;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13439a.f13265ap;
                RegistActivity_ja.m6675b(checkBox2, 4, false);
            }
        }
        button = this.f13439a.f13260ak;
        button.setEnabled(this.f13439a.m6659h());
    }
}
