package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.be */
/* loaded from: classes.dex */
final class C2333be implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13440a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2333be(RegistActivity_ja registActivity_ja) {
        this.f13440a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        String str2;
        String str3;
        CheckBox checkBox3;
        CheckBox checkBox4;
        RegistActivity_ja registActivity_ja = this.f13440a;
        editText = registActivity_ja.f13233Z;
        registActivity_ja.f13234aA = editText.getText().toString();
        str = this.f13440a.f13234aA;
        if (str != null) {
            str2 = this.f13440a.f13234aA;
            if (!str2.equals("")) {
                str3 = this.f13440a.f13234aA;
                if (!C2787z.m4816c(str3)) {
                    checkBox4 = this.f13440a.f13266aq;
                    RegistActivity_ja.m6675b(checkBox4, 0, false);
                } else {
                    checkBox3 = this.f13440a.f13266aq;
                    RegistActivity_ja.m6675b(checkBox3, 0, true);
                }
                button = this.f13440a.f13260ak;
                button.setEnabled(this.f13440a.m6659h());
            }
        }
        checkBox = this.f13440a.f13266aq;
        if (checkBox.getVisibility() == 0) {
            checkBox2 = this.f13440a.f13266aq;
            RegistActivity_ja.m6675b(checkBox2, 4, false);
        }
        button = this.f13440a.f13260ak;
        button.setEnabled(this.f13440a.m6659h());
    }
}
