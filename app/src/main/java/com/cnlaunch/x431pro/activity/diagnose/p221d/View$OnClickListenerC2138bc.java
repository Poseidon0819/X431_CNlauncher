package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bc */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2138bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12083a;

    /* renamed from: b */
    final /* synthetic */ MulitInputFragment f12084b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2138bc(MulitInputFragment mulitInputFragment, int i) {
        this.f12084b = mulitInputFragment;
        this.f12083a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MulitInputFragment.m7209a(this.f12084b, this.f12083a);
    }
}
