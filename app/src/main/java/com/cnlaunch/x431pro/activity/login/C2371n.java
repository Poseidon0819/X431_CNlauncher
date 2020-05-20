package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompleteUserInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.n */
/* loaded from: classes.dex */
public final class C2371n implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CompleteUserInfoDialog f13527a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2371n(CompleteUserInfoDialog completeUserInfoDialog) {
        this.f13527a = completeUserInfoDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Context context;
        Context context2;
        editText = this.f13527a.f13513q;
        String obj = editText.getText().toString();
        editText2 = this.f13527a.f13511o;
        if (editText2.getVisibility() == 8) {
            editText3 = this.f13527a.f13512p;
            if (editText3.getVisibility() != 8 && C2787z.m4818b(obj) && obj.length() == 4) {
                context = this.f13527a.f13507k;
                LoadDialog.m4685a(context, (int) R.string.register_check_identify_code);
                this.f13527a.m6534a(2021);
            }
        } else if (C2787z.m4818b(obj) && obj.length() == 4) {
            context2 = this.f13527a.f13507k;
            LoadDialog.m4685a(context2, (int) R.string.register_check_identify_code);
            this.f13527a.m6534a(2011);
        }
    }
}
