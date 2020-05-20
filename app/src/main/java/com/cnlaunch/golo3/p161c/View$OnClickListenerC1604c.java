package com.cnlaunch.golo3.p161c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.golo3.c.c */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1604c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BaseActivity f8425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1604c(BaseActivity baseActivity) {
        this.f8425a = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8425a.mo9064c(((Integer) view.getTag()).intValue());
    }
}
