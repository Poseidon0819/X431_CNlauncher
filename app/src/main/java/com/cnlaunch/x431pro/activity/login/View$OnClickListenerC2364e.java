package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.os.Handler;
import android.view.View;

/* compiled from: BindMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.e */
/* loaded from: classes.dex */
final class View$OnClickListenerC2364e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BindMerchantActivity f13482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2364e(BindMerchantActivity bindMerchantActivity) {
        this.f13482a = bindMerchantActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Handler handler;
        String str;
        String str2;
        BindMerchantActivity.m6800g(this.f13482a);
        context = this.f13482a.f10981q;
        BindMerchantClass bindMerchantClass = new BindMerchantClass(context);
        handler = this.f13482a.f13015I;
        bindMerchantClass.f13484a = handler;
        str = this.f13482a.f13013G;
        str2 = this.f13482a.f13014H;
        bindMerchantClass.m6538a(str, str2);
    }
}
