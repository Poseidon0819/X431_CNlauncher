package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ChangePhoneFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.n */
/* loaded from: classes.dex */
final class View$OnClickListenerC2490n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChangePhoneFragment f14262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2490n(ChangePhoneFragment changePhoneFragment) {
        this.f14262a = changePhoneFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        Context context;
        Context context2;
        EditText editText2;
        editText = this.f14262a.f14257k;
        if (C2787z.m4811h(editText.getText().toString())) {
            context2 = this.f14262a.mContext;
            LoadDialog.m4686a(context2);
            ChangePhoneFragment changePhoneFragment = this.f14262a;
            editText2 = changePhoneFragment.f14257k;
            changePhoneFragment.f14254h = editText2.getText().toString();
            this.f14262a.request(2108);
            return;
        }
        context = this.f14262a.mContext;
        NToast.m9446b(context, this.f14262a.getResources().getString(R.string.mine_bind_phone_error));
    }
}
