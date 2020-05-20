package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ce */
/* loaded from: classes.dex */
final class View$OnClickListenerC2456ce implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2454cc f14031a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2456ce(HandlerC2454cc handlerC2454cc) {
        this.f14031a = handlerC2454cc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f14031a.f14029a.mContext;
        new LoginFunction(context).m6572d();
    }
}
