package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.view.View;

/* compiled from: SelectCarVerAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.s */
/* loaded from: classes.dex */
final class View$OnClickListenerC2031s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11425a;

    /* renamed from: b */
    final /* synthetic */ SelectCarVerAdapter f11426b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2031s(SelectCarVerAdapter selectCarVerAdapter, int i) {
        this.f11426b = selectCarVerAdapter;
        this.f11425a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f11426b.f11415b.mo7079b(this.f11425a);
    }
}
