package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.x431pro.activity.login.LoginActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.e */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2219e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityC2004c f12495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2219e(ActivityC2004c activityC2004c) {
        this.f12495a = activityC2004c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f12495a.f10981q, LoginActivity.class);
        intent.setFlags(67108864);
        this.f12495a.startActivity(intent);
    }
}
