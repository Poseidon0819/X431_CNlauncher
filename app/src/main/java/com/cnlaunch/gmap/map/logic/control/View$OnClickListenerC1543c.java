package com.cnlaunch.gmap.map.logic.control;

import android.view.View;

/* compiled from: BasicActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.c */
/* loaded from: classes.dex */
final class View$OnClickListenerC1543c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BasicActivity f7639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1543c(BasicActivity basicActivity) {
        this.f7639a = basicActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7639a.mo9270c(((Integer) view.getTag()).intValue());
    }
}
