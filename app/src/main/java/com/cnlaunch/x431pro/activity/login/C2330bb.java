package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bb */
/* loaded from: classes.dex */
final class C2330bb implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13437a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2330bb(RegistActivity_ja registActivity_ja) {
        this.f13437a = registActivity_ja;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        CheckBox checkBox;
        CheckBox checkBox2;
        Button button;
        CheckBox checkBox3;
        CheckBox checkBox4;
        editText = this.f13437a.f13230W;
        String obj = editText.getText().toString();
        if (obj.length() <= 5) {
            checkBox = this.f13437a.f13263an;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13437a.f13263an;
                RegistActivity_ja.m6675b(checkBox2, 4, false);
            }
        } else if (!C2787z.m4809j(obj).booleanValue()) {
            checkBox4 = this.f13437a.f13263an;
            RegistActivity_ja.m6675b(checkBox4, 0, false);
        } else {
            checkBox3 = this.f13437a.f13263an;
            RegistActivity_ja.m6675b(checkBox3, 0, true);
        }
        button = this.f13437a.f13260ak;
        button.setEnabled(this.f13437a.m6659h());
    }
}
