package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.p131a.LangManager;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ak */
/* loaded from: classes.dex */
final class C2312ak implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13419a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2312ak(RegistActivity registActivity) {
        this.f13419a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        CheckBox checkBox2;
        String str2;
        CheckBox checkBox3;
        Button button;
        boolean m6712h;
        RegistActivity registActivity = this.f13419a;
        editText = registActivity.f13175as;
        registActivity.f13187be = editText.getText().toString();
        if (LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) {
            str = this.f13419a.f13187be;
            if (str != null) {
                str2 = this.f13419a.f13187be;
                if (!str2.equals("")) {
                    checkBox3 = this.f13419a.f13149aS;
                    RegistActivity.m6728b(checkBox3, 0, true);
                }
            }
            checkBox = this.f13419a.f13149aS;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13419a.f13149aS;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        }
        button = this.f13419a.f13168al;
        m6712h = this.f13419a.m6712h();
        button.setEnabled(m6712h);
    }
}
