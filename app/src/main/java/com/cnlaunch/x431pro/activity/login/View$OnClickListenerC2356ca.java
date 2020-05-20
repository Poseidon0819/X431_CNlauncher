package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;

/* compiled from: RegisterFinishActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ca */
/* loaded from: classes.dex */
final class View$OnClickListenerC2356ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegisterFinishActivity f13465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2356ca(RegisterFinishActivity registerFinishActivity) {
        this.f13465a = registerFinishActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13465a.sendBroadcast(new Intent("show_update"));
        this.f13465a.finish();
    }
}
