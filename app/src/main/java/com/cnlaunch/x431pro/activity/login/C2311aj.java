package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.aj */
/* loaded from: classes.dex */
final class C2311aj implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13418a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2311aj(RegistActivity registActivity) {
        this.f13418a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        CheckBox checkBox2;
        String str2;
        String str3;
        CheckBox checkBox3;
        CheckBox checkBox4;
        Button button;
        boolean m6712h;
        RegistActivity registActivity = this.f13418a;
        editText = registActivity.f13174ar;
        registActivity.f13186bd = editText.getText().toString();
        if (LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) {
            str = this.f13418a.f13186bd;
            if (str != null) {
                str2 = this.f13418a.f13186bd;
                if (!str2.equals("")) {
                    str3 = this.f13418a.f13186bd;
                    if (!C2787z.m4815d(str3)) {
                        checkBox4 = this.f13418a.f13148aR;
                        RegistActivity.m6728b(checkBox4, 0, false);
                    } else {
                        checkBox3 = this.f13418a.f13148aR;
                        RegistActivity.m6728b(checkBox3, 0, true);
                    }
                }
            }
            checkBox = this.f13418a.f13148aR;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13418a.f13148aR;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        }
        button = this.f13418a.f13168al;
        m6712h = this.f13418a.m6712h();
        button.setEnabled(m6712h);
    }
}
