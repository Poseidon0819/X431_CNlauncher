package com.cnlaunch.x431pro.activity.golo.p224a;

import android.view.View;
import com.cnlaunch.x431pro.activity.golo.p224a.VerificationListAdapter;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;

/* compiled from: VerificationListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.i */
/* loaded from: classes.dex */
final class View$OnClickListenerC2235i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VerificationInfo f12568a;

    /* renamed from: b */
    final /* synthetic */ VerificationListAdapter f12569b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2235i(VerificationListAdapter verificationListAdapter, VerificationInfo verificationInfo) {
        this.f12569b = verificationListAdapter;
        this.f12568a = verificationInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VerificationListAdapter.InterfaceC2232a interfaceC2232a;
        interfaceC2232a = this.f12569b.f12560e;
        interfaceC2232a.mo7022b(this.f12568a);
    }
}
