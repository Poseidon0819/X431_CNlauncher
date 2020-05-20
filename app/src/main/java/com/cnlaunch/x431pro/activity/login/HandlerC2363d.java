package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p121a.PreferencesManager;

/* compiled from: BindMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.d */
/* loaded from: classes.dex */
final class HandlerC2363d extends Handler {

    /* renamed from: a */
    final /* synthetic */ BindMerchantActivity f13481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2363d(BindMerchantActivity bindMerchantActivity) {
        this.f13481a = bindMerchantActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z;
        Context context;
        Context context2;
        Context context3;
        boolean z2;
        boolean z3;
        Context context4;
        switch (message2.what) {
            case -1:
                if (2 == message2.arg1) {
                    z = this.f13481a.f13012F;
                    if (z) {
                        return;
                    }
                    context = this.f13481a.f10981q;
                    Intent intent = new Intent(context, ActivateJointActivity.class);
                    context2 = this.f13481a.f10981q;
                    String m9591a = PreferencesManager.m9595a(context2).m9591a("login_username");
                    context3 = this.f13481a.f10981q;
                    String m9591a2 = PreferencesManager.m9595a(context3).m9591a("login_password");
                    intent.putExtra("UserName", m9591a);
                    intent.putExtra("PassWord", m9591a2);
                    z2 = this.f13481a.f13012F;
                    intent.putExtra("FromRegister", z2);
                    this.f13481a.startActivity(intent);
                    return;
                }
                return;
            case 0:
                z3 = this.f13481a.f13012F;
                if (z3) {
                    context4 = this.f13481a.f10981q;
                    this.f13481a.startActivity(new Intent(context4, RegisterFinishActivity.class));
                }
                this.f13481a.finish();
                return;
            default:
                return;
        }
    }
}
