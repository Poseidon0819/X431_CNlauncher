package com.cnlaunch.gmap.map.logic.control;

import android.view.View;

/* compiled from: BasicActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.d */
/* loaded from: classes.dex */
final class View$OnClickListenerC1544d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BasicActivity f7640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1544d(BasicActivity basicActivity) {
        this.f7640a = basicActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7640a.mo9270c(((Integer) view.getTag()).intValue());
    }
}
