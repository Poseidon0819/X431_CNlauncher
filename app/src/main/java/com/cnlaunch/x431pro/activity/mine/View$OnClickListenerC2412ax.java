package com.cnlaunch.x431pro.activity.mine;

import android.view.View;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;

/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ax */
/* loaded from: classes.dex */
final class View$OnClickListenerC2412ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageDialog f13711a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2411aw f13712b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2412ax(View$OnClickListenerC2411aw view$OnClickListenerC2411aw, MessageDialog messageDialog) {
        this.f13712b = view$OnClickListenerC2411aw;
        this.f13711a = messageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MyOrderFragment.m6436a(this.f13712b.f13710b, this.f13712b.f13709a.getOrderid());
        this.f13711a.dismiss();
    }
}
