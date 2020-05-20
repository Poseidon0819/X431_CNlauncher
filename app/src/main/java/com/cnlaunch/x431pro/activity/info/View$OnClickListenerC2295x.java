package com.cnlaunch.x431pro.activity.info;

import android.view.View;

/* compiled from: RepairInfoActivityEuroFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.x */
/* loaded from: classes.dex */
final class View$OnClickListenerC2295x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RepairInfoActivityEuroFragment f12956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2295x(RepairInfoActivityEuroFragment repairInfoActivityEuroFragment) {
        this.f12956a = repairInfoActivityEuroFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f12956a.replaceFragment(InfoEuroFragment.class.getName(), 1);
    }
}
