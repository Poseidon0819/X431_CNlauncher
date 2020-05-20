package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.ifoer.expedition.pro.R;

/* compiled from: ModifyPasswordFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ar */
/* loaded from: classes.dex */
final class C2406ar implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ModifyPasswordFragment f13691a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2406ar(ModifyPasswordFragment modifyPasswordFragment) {
        this.f13691a = modifyPasswordFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f13691a.f13678e;
        button.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ClearEditText clearEditText;
        ClearEditText clearEditText2;
        CheckBox checkBox;
        CheckBox checkBox2;
        boolean m6457a;
        Button button;
        CheckBox checkBox3;
        CheckBox checkBox4;
        Context context;
        CheckBox checkBox5;
        Context context2;
        CheckBox checkBox6;
        clearEditText = this.f13691a.f13677d;
        String obj = clearEditText.getText().toString();
        clearEditText2 = this.f13691a.f13676c;
        String obj2 = clearEditText2.getText().toString();
        if (obj.length() >= obj2.length()) {
            checkBox3 = this.f13691a.f13680g;
            if (checkBox3.getVisibility() == 0) {
                if (!obj.equals(obj2)) {
                    context2 = this.f13691a.mContext;
                    NToast.m9450a(context2, (int) R.string.register_password_not_match);
                    checkBox6 = this.f13691a.f13681h;
                    ModifyPasswordFragment.m6456a(checkBox6, 0, false);
                } else if (!C2787z.m4812g(obj)) {
                    context = this.f13691a.mContext;
                    NToast.m9450a(context, (int) R.string.mine_pwd_wrong);
                    checkBox5 = this.f13691a.f13681h;
                    ModifyPasswordFragment.m6456a(checkBox5, 0, false);
                } else {
                    checkBox4 = this.f13691a.f13681h;
                    ModifyPasswordFragment.m6456a(checkBox4, 0, true);
                }
            }
        } else {
            checkBox = this.f13691a.f13681h;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13691a.f13681h;
                ModifyPasswordFragment.m6456a(checkBox2, 4, false);
            }
        }
        m6457a = this.f13691a.m6457a();
        if (m6457a) {
            button = this.f13691a.f13678e;
            button.setEnabled(true);
        }
    }
}
