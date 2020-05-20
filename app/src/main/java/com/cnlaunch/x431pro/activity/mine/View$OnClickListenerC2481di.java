package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;

/* compiled from: VerificationCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.di */
/* loaded from: classes.dex */
final class View$OnClickListenerC2481di implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VerificationCodeFragment f14214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2481di(VerificationCodeFragment verificationCodeFragment) {
        this.f14214a = verificationCodeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f14214a.mContext;
        LoadDialog.m4686a(context);
        this.f14214a.request(2110);
    }
}
