package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: RegistMerchantHomePageActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bv */
/* loaded from: classes.dex */
final class View$OnClickListenerC2350bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantHomePageActivity f13459a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2350bv(RegistMerchantHomePageActivity registMerchantHomePageActivity) {
        this.f13459a = registMerchantHomePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        boolean z;
        context = this.f13459a.f10981q;
        Intent intent = new Intent(context, BindMerchantActivity.class);
        intent.setFlags(67108864);
        z = this.f13459a.f13315F;
        intent.putExtra("FromRegister", z);
        this.f13459a.startActivity(intent);
        this.f13459a.finish();
    }
}
