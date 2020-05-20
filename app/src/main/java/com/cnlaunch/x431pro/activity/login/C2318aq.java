package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.aq */
/* loaded from: classes.dex */
final class C2318aq implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13425a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2318aq(RegistActivity registActivity) {
        this.f13425a = registActivity;
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
        boolean m6712h;
        CheckBox checkBox3;
        String str3;
        String str4;
        String str5;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        RegistActivity registActivity = this.f13425a;
        editText = registActivity.f13160ad;
        registActivity.f13152aV = editText.getText().toString();
        RegistActivity registActivity2 = this.f13425a;
        editText2 = registActivity2.f13161ae;
        registActivity2.f13153aW = editText2.getText().toString();
        str = this.f13425a.f13153aW;
        int length = str.length();
        str2 = this.f13425a.f13152aV;
        if (length >= str2.length()) {
            checkBox3 = this.f13425a.f13139aI;
            if (checkBox3.getVisibility() == 0) {
                str3 = this.f13425a.f13153aW;
                str4 = this.f13425a.f13152aV;
                if (!str3.equals(str4)) {
                    checkBox6 = this.f13425a.f13140aJ;
                    RegistActivity.m6728b(checkBox6, 0, false);
                } else {
                    str5 = this.f13425a.f13153aW;
                    if (!C2787z.m4812g(str5)) {
                        checkBox5 = this.f13425a.f13140aJ;
                        RegistActivity.m6728b(checkBox5, 0, false);
                    } else {
                        checkBox4 = this.f13425a.f13140aJ;
                        RegistActivity.m6728b(checkBox4, 0, true);
                    }
                }
            }
        } else {
            checkBox = this.f13425a.f13140aJ;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13425a.f13140aJ;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        }
        button = this.f13425a.f13168al;
        m6712h = this.f13425a.m6712h();
        button.setEnabled(m6712h);
    }
}
