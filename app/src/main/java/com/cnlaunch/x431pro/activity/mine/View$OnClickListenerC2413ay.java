package com.cnlaunch.x431pro.activity.mine;

import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ay */
/* loaded from: classes.dex */
final class View$OnClickListenerC2413ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageDialog f13713a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2411aw f13714b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2413ay(View$OnClickListenerC2411aw view$OnClickListenerC2411aw, MessageDialog messageDialog) {
        this.f13714b = view$OnClickListenerC2411aw;
        this.f13713a = messageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MyOrderFragment.m6435a(this.f13714b.f13710b, this.f13714b.f13709a.getOrdersn());
        this.f13713a.dismiss();
    }
}
