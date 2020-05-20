package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ao */
/* loaded from: classes.dex */
final class C2316ao implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13423a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2316ao(RegistActivity registActivity) {
        this.f13423a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        boolean m6712h;
        CheckBox checkBox3;
        CheckBox checkBox4;
        editText = this.f13423a.f13159ac;
        String obj = editText.getText().toString();
        if (obj.length() <= 5) {
            checkBox = this.f13423a.f13138aH;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13423a.f13138aH;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        } else if (!C2787z.m4809j(obj).booleanValue()) {
            checkBox4 = this.f13423a.f13138aH;
            RegistActivity.m6728b(checkBox4, 0, false);
        } else {
            checkBox3 = this.f13423a.f13138aH;
            RegistActivity.m6728b(checkBox3, 0, true);
        }
        button = this.f13423a.f13168al;
        m6712h = this.f13423a.m6712h();
        button.setEnabled(m6712h);
    }
}
