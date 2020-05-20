package com.cnlaunch.golo3.p161c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.golo3.c.f */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1607f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BaseActivity f8428a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1607f(BaseActivity baseActivity) {
        this.f8428a = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8428a.mo9064c(((Integer) view.getTag()).intValue());
    }
}
