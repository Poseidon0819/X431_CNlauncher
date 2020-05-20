package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ar */
/* loaded from: classes.dex */
final class C2319ar implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13426a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2319ar(RegistActivity registActivity) {
        this.f13426a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        boolean m6712h;
        String str2;
        String str3;
        CheckBox checkBox3;
        CheckBox checkBox4;
        RegistActivity registActivity = this.f13426a;
        editText = registActivity.f13162af;
        registActivity.f13154aX = editText.getText().toString();
        str = this.f13426a.f13154aX;
        if (str != null) {
            str2 = this.f13426a.f13154aX;
            if (!str2.equals("")) {
                str3 = this.f13426a.f13154aX;
                if (!C2787z.m4816c(str3)) {
                    checkBox4 = this.f13426a.f13141aK;
                    RegistActivity.m6728b(checkBox4, 0, false);
                } else {
                    checkBox3 = this.f13426a.f13141aK;
                    RegistActivity.m6728b(checkBox3, 0, true);
                }
                button = this.f13426a.f13168al;
                m6712h = this.f13426a.m6712h();
                button.setEnabled(m6712h);
            }
        }
        checkBox = this.f13426a.f13141aK;
        if (checkBox.getVisibility() == 0) {
            checkBox2 = this.f13426a.f13141aK;
            RegistActivity.m6728b(checkBox2, 4, false);
        }
        button = this.f13426a.f13168al;
        m6712h = this.f13426a.m6712h();
        button.setEnabled(m6712h);
    }
}
