package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: RegistMerchantHomePageActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bw */
/* loaded from: classes.dex */
final class View$OnClickListenerC2351bw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantHomePageActivity f13460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2351bw(RegistMerchantHomePageActivity registMerchantHomePageActivity) {
        this.f13460a = registMerchantHomePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        boolean z;
        context = this.f13460a.f10981q;
        Intent intent = new Intent(context, RegistMerchantActivity.class);
        intent.setFlags(67108864);
        z = this.f13460a.f13315F;
        intent.putExtra("FromRegister", z);
        this.f13460a.startActivity(intent);
        this.f13460a.finish();
    }
}
