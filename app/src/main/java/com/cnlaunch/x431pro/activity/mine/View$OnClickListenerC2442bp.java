package com.cnlaunch.x431pro.activity.mine;

import android.view.View;

/* compiled from: PayTypeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bp */
/* loaded from: classes.dex */
final class View$OnClickListenerC2442bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PayTypeFragment f13949a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2442bp(PayTypeFragment payTypeFragment) {
        this.f13949a = payTypeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13949a.addFragment(PinCardPayFragment.class.getName(), this.f13949a.getBundle());
    }
}
