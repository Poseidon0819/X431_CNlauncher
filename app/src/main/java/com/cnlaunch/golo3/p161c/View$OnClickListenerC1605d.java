package com.cnlaunch.golo3.p161c;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.golo3.c.d */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1605d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BaseActivity f8426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1605d(BaseActivity baseActivity) {
        this.f8426a = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8426a.mo9064c(((Integer) view.getTag()).intValue());
    }
}
