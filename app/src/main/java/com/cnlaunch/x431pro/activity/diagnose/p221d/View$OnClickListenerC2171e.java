package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.e */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2171e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActiveTestFragment f12326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2171e(ActiveTestFragment activeTestFragment) {
        this.f12326a = activeTestFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f12326a.f11857I;
        if (z) {
            return;
        }
        this.f12326a.f12357d.mo7082j();
        this.f12326a.f11852D = view.getId();
        this.f12326a.f12357d.mo7093a("9", ActiveTestFragment.m7324c(view.getId()), 3);
        ActiveTestFragment.m7314i(this.f12326a);
        ActiveTestFragment.m7313j(this.f12326a);
    }
}
