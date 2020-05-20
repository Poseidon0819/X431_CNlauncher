package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: RegistMerchantHomePageActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bx */
/* loaded from: classes.dex */
final class View$OnClickListenerC2352bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantHomePageActivity f13461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2352bx(RegistMerchantHomePageActivity registMerchantHomePageActivity) {
        this.f13461a = registMerchantHomePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        Context context;
        z = this.f13461a.f13315F;
        if (z) {
            context = this.f13461a.f10981q;
            Intent intent = new Intent(context, RegisterFinishActivity.class);
            intent.setFlags(67108864);
            this.f13461a.startActivity(intent);
        }
        this.f13461a.finish();
    }
}
