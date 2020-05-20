package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.utils.C2744aa;

/* compiled from: ActivateJointActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.a */
/* loaded from: classes.dex */
final class View$OnClickListenerC2300a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivateJointActivity f13355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2300a(ActivateJointActivity activateJointActivity) {
        this.f13355a = activateJointActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f13355a.f10981q;
        if (!C2744aa.m5144h(context)) {
            C2744aa.m5129p();
        }
        this.f13355a.finish();
    }
}
