package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: CardStatusFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC2485f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2484e f14220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2485f(HandlerC2484e handlerC2484e) {
        this.f14220a = handlerC2484e;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f14220a.f14219a.mContext;
        new LoginFunction(context).m6572d();
    }
}
