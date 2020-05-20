package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: PersonInformationFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bv */
/* loaded from: classes.dex */
final class C2447bv extends LoginFunction {

    /* renamed from: e */
    final /* synthetic */ PersonInformationFragment f14007e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2447bv(PersonInformationFragment personInformationFragment, Context context) {
        super(context);
        this.f14007e = personInformationFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction, com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        this.f14007e.onResume();
    }
}
