package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.x431pro.activity.setting.FeedbackActivity;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.s */
/* loaded from: classes.dex */
final class View$OnClickListenerC2514s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f14453a;

    /* renamed from: b */
    final /* synthetic */ MainActivity f14454b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2514s(MainActivity mainActivity, int i) {
        this.f14454b = mainActivity;
        this.f14453a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f14454b.f10751r = MainActivity.m7871h();
        MainActivity.m7885c(this.f14453a);
        this.f14454b.m7898a(FeedbackActivity.class, (Intent) null);
    }
}
