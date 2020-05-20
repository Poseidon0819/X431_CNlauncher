package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bp */
/* loaded from: classes.dex */
final class View$OnClickListenerC2344bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2344bp(RegistMerchantActivity registMerchantActivity) {
        this.f13451a = registMerchantActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Intent intent = new Intent();
        context = this.f13451a.f10981q;
        intent.setClass(context, RegistMerchantTermsAndPoliciesActivity.class);
        context2 = this.f13451a.f10981q;
        context2.startActivity(intent);
    }
}
