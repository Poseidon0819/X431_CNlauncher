package com.cnlaunch.gmap.map.logic.control;

import android.view.View;

/* compiled from: BasicActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.e */
/* loaded from: classes.dex */
final class View$OnClickListenerC1545e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BasicActivity f7641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1545e(BasicActivity basicActivity) {
        this.f7641a = basicActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7641a.mo9270c(((Integer) view.getTag()).intValue());
    }
}
