package com.cnlaunch.x431pro.activity.info;

import android.view.View;

/* compiled from: RepairInfoActivityEuroFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.y */
/* loaded from: classes.dex */
final class View$OnClickListenerC2296y implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RepairInfoActivityEuroFragment f12957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2296y(RepairInfoActivityEuroFragment repairInfoActivityEuroFragment) {
        this.f12957a = repairInfoActivityEuroFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f12957a.replaceFragment(InfoFragment.class.getName(), 1);
    }
}
