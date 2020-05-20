package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;

/* compiled from: RegisterInstructionActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.cf */
/* loaded from: classes.dex */
final class View$OnClickListenerC2360cf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegisterInstructionActivity f13472a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2360cf(RegisterInstructionActivity registerInstructionActivity) {
        this.f13472a = registerInstructionActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f13472a, LoginActivity.class);
        intent.setFlags(67108864);
        this.f13472a.startActivity(intent);
        this.f13472a.finish();
    }
}
