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
/* renamed from: com.cnlaunch.x431pro.activity.login.at */
/* loaded from: classes.dex */
final class C2321at implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13428a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2321at(RegistActivity registActivity) {
        this.f13428a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        String str2;
        CheckBox checkBox;
        EditText editText2;
        CheckBox checkBox2;
        EditText editText3;
        Context context;
        Context context2;
        Button button;
        boolean m6712h;
        CheckBox checkBox3;
        CheckBox checkBox4;
        RegistActivity registActivity = this.f13428a;
        editText = registActivity.f13165ai;
        registActivity.f13189bg = editText.getText().toString();
        str = this.f13428a.f13189bg;
        if (str.length() == 0) {
            checkBox3 = this.f13428a.f13143aM;
            if (checkBox3.getVisibility() == 0) {
                checkBox4 = this.f13428a.f13143aM;
                RegistActivity.m6728b(checkBox4, 4, false);
                button = this.f13428a.f13168al;
                m6712h = this.f13428a.m6712h();
                button.setEnabled(m6712h);
            }
        }
        str2 = this.f13428a.f13189bg;
        if (str2.length() != 4) {
            checkBox = this.f13428a.f13143aM;
            RegistActivity.m6728b(checkBox, 0, false);
        } else {
            RegistActivity registActivity2 = this.f13428a;
            editText2 = registActivity2.f13159ac;
            registActivity2.f13151aU = editText2.getText().toString();
            checkBox2 = this.f13428a.f13138aH;
            if (checkBox2.isChecked()) {
                context2 = this.f13428a.f10981q;
                LoadDialog.m4685a(context2, (int) R.string.register_check_identify_code);
                this.f13428a.m7739c(203);
            } else {
                int[] iArr = new int[2];
                editText3 = this.f13428a.f13159ac;
                editText3.getLocationOnScreen(iArr);
                RegistActivity registActivity3 = this.f13428a;
                context = registActivity3.f10981q;
                registActivity3.m6734a(context, R.string.register_username_format, iArr[0], iArr[1] + 40);
            }
        }
        button = this.f13428a.f13168al;
        m6712h = this.f13428a.m6712h();
        button.setEnabled(m6712h);
    }
}
