package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ChangePhoneFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.m */
/* loaded from: classes.dex */
final class View$OnClickListenerC2489m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChangePhoneFragment f14261a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2489m(ChangePhoneFragment changePhoneFragment) {
        this.f14261a = changePhoneFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        Context context;
        Context context2;
        Context context3;
        editText = this.f14261a.f14257k;
        if (C2787z.m4821a(editText.getText().toString())) {
            context3 = this.f14261a.mContext;
            NToast.m9446b(context3, this.f14261a.getResources().getString(R.string.mine_et_mobile_phone_Prompt));
            return;
        }
        editText2 = this.f14261a.f14257k;
        if (C2787z.m4811h(editText2.getText().toString())) {
            context2 = this.f14261a.mContext;
            LoadDialog.m4686a(context2);
            this.f14261a.request(2109);
            return;
        }
        context = this.f14261a.mContext;
        NToast.m9446b(context, this.f14261a.getResources().getString(R.string.mine_bind_phone_error));
    }
}
