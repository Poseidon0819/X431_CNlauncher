package com.cnlaunch.x431pro.activity.login;

import android.os.Handler;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bi */
/* loaded from: classes.dex */
final class C2337bi extends Thread {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2337bi(RegistMerchantActivity registMerchantActivity) {
        this.f13444a = registMerchantActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        try {
            Thread.sleep(3000L);
            handler = this.f13444a.f13310aj;
            handler.sendEmptyMessage(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
