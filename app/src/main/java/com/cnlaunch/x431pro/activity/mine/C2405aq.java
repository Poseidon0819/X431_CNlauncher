package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.ifoer.expedition.pro.R;

/* compiled from: ModifyPasswordFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.aq */
/* loaded from: classes.dex */
final class C2405aq implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ModifyPasswordFragment f13690a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2405aq(ModifyPasswordFragment modifyPasswordFragment) {
        this.f13690a = modifyPasswordFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f13690a.f13678e;
        button.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ClearEditText clearEditText;
        ClearEditText clearEditText2;
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        boolean m6457a;
        Button button;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        Context context;
        CheckBox checkBox7;
        clearEditText = this.f13690a.f13676c;
        String obj = clearEditText.getText().toString();
        clearEditText2 = this.f13690a.f13677d;
        String obj2 = clearEditText2.getText().toString();
        if (obj.length() <= 5) {
            checkBox = this.f13690a.f13680g;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13690a.f13680g;
                ModifyPasswordFragment.m6456a(checkBox2, 4, false);
                checkBox3 = this.f13690a.f13681h;
                ModifyPasswordFragment.m6456a(checkBox3, 4, false);
            }
        } else if (!C2787z.m4812g(obj)) {
            context = this.f13690a.mContext;
            NToast.m9450a(context, (int) R.string.mine_pwd_wrong);
            checkBox7 = this.f13690a.f13680g;
            ModifyPasswordFragment.m6456a(checkBox7, 0, false);
        } else {
            checkBox4 = this.f13690a.f13680g;
            ModifyPasswordFragment.m6456a(checkBox4, 0, true);
            if (!TextUtils.isEmpty(obj2)) {
                if (obj2.equals(obj)) {
                    checkBox6 = this.f13690a.f13681h;
                    ModifyPasswordFragment.m6456a(checkBox6, 0, true);
                } else {
                    checkBox5 = this.f13690a.f13681h;
                    ModifyPasswordFragment.m6456a(checkBox5, 0, false);
                }
            }
        }
        m6457a = this.f13690a.m6457a();
        if (m6457a) {
            button = this.f13690a.f13678e;
            button.setEnabled(true);
        }
    }
}
