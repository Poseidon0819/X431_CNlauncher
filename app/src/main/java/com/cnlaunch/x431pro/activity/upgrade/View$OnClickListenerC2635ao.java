package com.cnlaunch.x431pro.activity.upgrade;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ao */
/* loaded from: classes.dex */
final class View$OnClickListenerC2635ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2633am f15132a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2635ao(HandlerC2633am handlerC2633am) {
        this.f15132a = handlerC2633am;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler;
        Handler handler2;
        handler = this.f15132a.f15130a.f15109o;
        Message obtainMessage = handler.obtainMessage(6, 0, 0);
        handler2 = this.f15132a.f15130a.f15109o;
        handler2.sendMessage(obtainMessage);
    }
}
