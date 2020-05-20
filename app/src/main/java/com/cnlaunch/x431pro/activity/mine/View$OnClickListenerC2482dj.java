package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: VerificationCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.dj */
/* loaded from: classes.dex */
final class View$OnClickListenerC2482dj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VerificationCodeFragment f14215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2482dj(VerificationCodeFragment verificationCodeFragment) {
        this.f14215a = verificationCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        Context context;
        Context context2;
        textView = this.f14215a.f14212j;
        if (TextUtils.isEmpty(textView.getText().toString())) {
            context2 = this.f14215a.mContext;
            NToast.m9449a(context2, this.f14215a.getResources().getString(R.string.set_verify_notnull));
            return;
        }
        context = this.f14215a.mContext;
        LoadDialog.m4686a(context);
        this.f14215a.request(2111);
    }
}
