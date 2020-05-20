package com.cnlaunch.golo3.p161c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.golo3.c.e */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1606e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BaseActivity f8427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1606e(BaseActivity baseActivity) {
        this.f8427a = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8427a.mo9064c(((Integer) view.getTag()).intValue());
    }
}
