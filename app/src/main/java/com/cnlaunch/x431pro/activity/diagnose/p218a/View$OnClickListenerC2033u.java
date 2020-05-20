package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;

/* compiled from: SpeciaFunctionListViewAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.u */
/* loaded from: classes.dex */
final class View$OnClickListenerC2033u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11437a;

    /* renamed from: b */
    final /* synthetic */ SpeciaFunctionListViewAdapter f11438b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2033u(SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter, int i) {
        this.f11438b = speciaFunctionListViewAdapter;
        this.f11437a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f11438b.m7482a(this.f11437a);
    }
}
