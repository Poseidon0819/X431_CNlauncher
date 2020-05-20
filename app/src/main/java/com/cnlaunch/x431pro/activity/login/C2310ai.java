package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ai */
/* loaded from: classes.dex */
final class C2310ai implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13417a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2310ai(RegistActivity registActivity) {
        this.f13417a = registActivity;
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
        RegistActivity registActivity = this.f13417a;
        editText = registActivity.f13173aq;
        registActivity.f13185bc = editText.getText().toString();
        if (LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) {
            str = this.f13417a.f13185bc;
            if (str != null) {
                str2 = this.f13417a.f13185bc;
                if (!str2.equals("")) {
                    str3 = this.f13417a.f13185bc;
                    if (!C2787z.m4810i(str3)) {
                        checkBox4 = this.f13417a.f13147aQ;
                        RegistActivity.m6728b(checkBox4, 0, false);
                    } else {
                        checkBox3 = this.f13417a.f13147aQ;
                        RegistActivity.m6728b(checkBox3, 0, true);
                    }
                }
            }
            checkBox = this.f13417a.f13147aQ;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13417a.f13147aQ;
                RegistActivity.m6728b(checkBox2, 4, false);
            }
        }
        button = this.f13417a.f13168al;
        m6712h = this.f13417a.m6712h();
        button.setEnabled(m6712h);
    }
}
