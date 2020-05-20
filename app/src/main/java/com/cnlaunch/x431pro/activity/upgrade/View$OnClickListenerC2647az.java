package com.cnlaunch.x431pro.activity.upgrade;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.az */
/* loaded from: classes.dex */
final class View$OnClickListenerC2647az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2645ax f15232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2647az(HandlerC2645ax handlerC2645ax) {
        this.f15232a = handlerC2645ax;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler;
        Handler handler2;
        handler = this.f15232a.f15230a.f15140C;
        Message obtainMessage = handler.obtainMessage(6, 0, 0);
        handler2 = this.f15232a.f15230a.f15140C;
        handler2.sendMessage(obtainMessage);
    }
}
