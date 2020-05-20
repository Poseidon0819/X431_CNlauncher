package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ap */
/* loaded from: classes.dex */
final class C2317ap implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13424a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2317ap(RegistActivity registActivity) {
        this.f13424a = registActivity;
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
        boolean m6712h;
        String str3;
        String str4;
        String str5;
        CheckBox checkBox4;
        CheckBox checkBox5;
        String str6;
        CheckBox checkBox6;
        CheckBox checkBox7;
        RegistActivity registActivity = this.f13424a;
        editText = registActivity.f13160ad;
        registActivity.f13152aV = editText.getText().toString();
        RegistActivity registActivity2 = this.f13424a;
        editText2 = registActivity2.f13161ae;
        registActivity2.f13153aW = editText2.getText().toString();
        str = this.f13424a.f13152aV;
        if (str.length() > 5) {
            str6 = this.f13424a.f13152aV;
            if (!C2787z.m4814e(str6)) {
                checkBox7 = this.f13424a.f13139aI;
                RegistActivity.m6728b(checkBox7, 0, false);
            } else {
                checkBox6 = this.f13424a.f13139aI;
                RegistActivity.m6728b(checkBox6, 0, true);
            }
        } else {
            checkBox = this.f13424a.f13139aI;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13424a.f13139aI;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        }
        str2 = this.f13424a.f13153aW;
        if (str2 != null) {
            str3 = this.f13424a.f13153aW;
            if (!str3.equals("")) {
                str4 = this.f13424a.f13153aW;
                str5 = this.f13424a.f13152aV;
                if (!str4.equals(str5)) {
                    checkBox5 = this.f13424a.f13140aJ;
                    RegistActivity.m6728b(checkBox5, 0, false);
                } else {
                    checkBox4 = this.f13424a.f13140aJ;
                    RegistActivity.m6728b(checkBox4, 0, true);
                }
                button = this.f13424a.f13168al;
                m6712h = this.f13424a.m6712h();
                button.setEnabled(m6712h);
            }
        }
        checkBox3 = this.f13424a.f13140aJ;
        RegistActivity.m6728b(checkBox3, 4, false);
        button = this.f13424a.f13168al;
        m6712h = this.f13424a.m6712h();
        button.setEnabled(m6712h);
    }
}
