package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: PayTypeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bs */
/* loaded from: classes.dex */
final class View$OnClickListenerC2445bs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2444br f13952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2445bs(HandlerC2444br handlerC2444br) {
        this.f13952a = handlerC2444br;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f13952a.f13951a.mContext;
        new LoginFunction(context).m6572d();
    }
}
