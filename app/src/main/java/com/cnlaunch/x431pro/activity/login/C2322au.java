package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.au */
/* loaded from: classes.dex */
final class C2322au implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13429a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2322au(RegistActivity registActivity) {
        this.f13429a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        String str;
        String str2;
        CheckBox checkBox;
        EditText editText3;
        CheckBox checkBox2;
        Context context;
        Button button;
        boolean m6712h;
        CheckBox checkBox3;
        CheckBox checkBox4;
        RegistActivity registActivity = this.f13429a;
        editText = registActivity.f13176at;
        registActivity.f13191bi = editText.getText().toString();
        RegistActivity registActivity2 = this.f13429a;
        editText2 = registActivity2.f13173aq;
        registActivity2.f13185bc = editText2.getText().toString();
        str = this.f13429a.f13191bi;
        if (str.length() == 0) {
            checkBox3 = this.f13429a.f13150aT;
            if (checkBox3.getVisibility() == 0) {
                checkBox4 = this.f13429a.f13150aT;
                RegistActivity.m6728b(checkBox4, 4, false);
                button = this.f13429a.f13168al;
                m6712h = this.f13429a.m6712h();
                button.setEnabled(m6712h);
            }
        }
        str2 = this.f13429a.f13191bi;
        if (str2.length() != 4) {
            checkBox = this.f13429a.f13150aT;
            RegistActivity.m6728b(checkBox, 0, false);
        } else {
            RegistActivity registActivity3 = this.f13429a;
            editText3 = registActivity3.f13159ac;
            registActivity3.f13151aU = editText3.getText().toString();
            checkBox2 = this.f13429a.f13147aQ;
            if (checkBox2.isChecked()) {
                context = this.f13429a.f10981q;
                LoadDialog.m4685a(context, (int) R.string.register_check_identify_code);
                this.f13429a.m7739c(2031);
            }
        }
        button = this.f13429a.f13168al;
        m6712h = this.f13429a.m6712h();
        button.setEnabled(m6712h);
    }
}
