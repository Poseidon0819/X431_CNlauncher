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
/* renamed from: com.cnlaunch.x431pro.activity.mine.ap */
/* loaded from: classes.dex */
final class C2404ap implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ModifyPasswordFragment f13689a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2404ap(ModifyPasswordFragment modifyPasswordFragment) {
        this.f13689a = modifyPasswordFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f13689a.f13678e;
        button.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ClearEditText clearEditText;
        CheckBox checkBox;
        CheckBox checkBox2;
        boolean m6457a;
        Button button;
        CheckBox checkBox3;
        Context context;
        CheckBox checkBox4;
        clearEditText = this.f13689a.f13675b;
        String obj = clearEditText.getText().toString();
        if (obj.length() <= 5) {
            checkBox = this.f13689a.f13679f;
            if (checkBox.getVisibility() == 0) {
                checkBox2 = this.f13689a.f13679f;
                ModifyPasswordFragment.m6456a(checkBox2, 4, false);
            }
        } else if (!C2787z.m4812g(obj)) {
            context = this.f13689a.mContext;
            NToast.m9450a(context, (int) R.string.mine_pwd_wrong);
            checkBox4 = this.f13689a.f13679f;
            ModifyPasswordFragment.m6456a(checkBox4, 0, false);
        } else {
            checkBox3 = this.f13689a.f13679f;
            ModifyPasswordFragment.m6456a(checkBox3, 0, true);
        }
        m6457a = this.f13689a.m6457a();
        if (m6457a) {
            button = this.f13689a.f13678e;
            button.setEnabled(true);
        }
    }
}
