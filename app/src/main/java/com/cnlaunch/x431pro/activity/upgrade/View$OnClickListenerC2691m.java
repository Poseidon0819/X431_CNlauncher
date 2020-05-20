package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.m */
/* loaded from: classes.dex */
final class View$OnClickListenerC2691m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2687i f15418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2691m(HandlerC2687i handlerC2687i) {
        this.f15418a = handlerC2687i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f15418a.f15414a.f15403x.sendMessage(this.f15418a.f15414a.f15403x.obtainMessage(5, 0, 0));
    }
}
