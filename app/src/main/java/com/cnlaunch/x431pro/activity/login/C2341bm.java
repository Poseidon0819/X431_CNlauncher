package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import com.cnlaunch.x431pro.activity.login.RegistMerchantClass;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bm */
/* loaded from: classes.dex */
final class C2341bm implements RegistMerchantClass.InterfaceC2349a {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2341bm(RegistMerchantActivity registMerchantActivity) {
        this.f13448a = registMerchantActivity;
    }

    @Override // com.cnlaunch.x431pro.activity.login.RegistMerchantClass.InterfaceC2349a
    /* renamed from: a */
    public final void mo6547a() {
        boolean z;
        Context context;
        z = this.f13448a.f13295U;
        if (z) {
            context = this.f13448a.f10981q;
            this.f13448a.startActivity(new Intent(context, RegisterFinishActivity.class));
        }
        this.f13448a.finish();
    }
}
