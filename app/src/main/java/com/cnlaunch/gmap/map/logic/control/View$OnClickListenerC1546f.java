package com.cnlaunch.gmap.map.logic.control;

import android.view.View;

/* compiled from: BasicActivity.java */
/* renamed from: com.cnlaunch.gmap.map.logic.control.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC1546f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BasicActivity f7642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1546f(BasicActivity basicActivity) {
        this.f7642a = basicActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7642a.mo9270c(((Integer) view.getTag()).intValue());
    }
}
