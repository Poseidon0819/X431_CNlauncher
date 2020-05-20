package com.cnlaunch.p169im.p172c;

import android.app.Activity;
import android.view.View;
import com.cnlaunch.x431pro.activity.golo.others.OrderDialog;

/* compiled from: UserDetailFragment.java */
/* renamed from: com.cnlaunch.im.c.ab */
/* loaded from: classes.dex */
final class View$OnClickListenerC1700ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserDetailFragment f9069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1700ab(UserDetailFragment userDetailFragment) {
        this.f9069a = userDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Activity activity = this.f9069a.getActivity();
        str = this.f9069a.f9057f;
        new OrderDialog(activity, str).show();
    }
}
