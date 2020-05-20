package com.cnlaunch.x431pro.activity.setting;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.aj */
/* loaded from: classes.dex */
final class View$OnClickListenerC2525aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2524ai f14574a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2525aj(HandlerC2524ai handlerC2524ai) {
        this.f14574a = handlerC2524ai;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Handler handler;
        Handler handler2;
        handler = this.f14574a.f14573a.f14557e;
        Message obtainMessage = handler.obtainMessage(3, 0, 0);
        handler2 = this.f14574a.f14573a.f14557e;
        handler2.sendMessage(obtainMessage);
    }
}
