package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;

/* compiled from: RegisterInstructionActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ce */
/* loaded from: classes.dex */
final class View$OnClickListenerC2359ce implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegisterInstructionActivity f13471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2359ce(RegisterInstructionActivity registerInstructionActivity) {
        this.f13471a = registerInstructionActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13471a.startActivity(new Intent(this.f13471a, RegistActivity_ja.class));
        this.f13471a.finish();
    }
}
