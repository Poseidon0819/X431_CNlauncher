package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;

/* compiled from: ActivateJointActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC2328b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivateJointActivity f13435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2328b(ActivateJointActivity activateJointActivity) {
        this.f13435a = activateJointActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13435a.startActivity(new Intent(this.f13435a, HowToGetJointVerifyCodeActivity.class));
    }
}
