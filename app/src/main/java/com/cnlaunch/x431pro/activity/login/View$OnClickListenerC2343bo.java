package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.view.View;
import java.util.HashMap;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bo */
/* loaded from: classes.dex */
final class View$OnClickListenerC2343bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2343bo(RegistMerchantActivity registMerchantActivity) {
        this.f13450a = registMerchantActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        HashMap<String, String> hashMap;
        if (RegistMerchantActivity.m6627g(this.f13450a)) {
            context = this.f13450a.f10981q;
            RegistMerchantClass registMerchantClass = new RegistMerchantClass(context);
            hashMap = this.f13450a.f13304ad;
            registMerchantClass.f13457a = hashMap;
            registMerchantClass.m6553a(2110);
        }
    }
}
