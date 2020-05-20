package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;

/* compiled from: SpeciaFunctionListViewAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.v */
/* loaded from: classes.dex */
final class View$OnClickListenerC2034v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11439a;

    /* renamed from: b */
    final /* synthetic */ SpeciaFunctionListViewAdapter f11440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2034v(SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter, int i) {
        this.f11440b = speciaFunctionListViewAdapter;
        this.f11439a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f11440b.m7482a(this.f11439a);
    }
}
