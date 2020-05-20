package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ChangePhoneFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.o */
/* loaded from: classes.dex */
final class C2491o implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChangePhoneFragment f14263a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2491o(ChangePhoneFragment changePhoneFragment) {
        this.f14263a = changePhoneFragment;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        Context context;
        editText = this.f14263a.f14259m;
        if (editText.getText().toString().length() == 4) {
            context = this.f14263a.mContext;
            LoadDialog.m4685a(context, (int) R.string.register_check_identify_code);
            this.f14263a.request(2110);
        }
    }
}
