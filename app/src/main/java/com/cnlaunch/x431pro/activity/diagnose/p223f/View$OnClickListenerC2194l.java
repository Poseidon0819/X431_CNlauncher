package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteDiagHandler.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.l */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2194l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RemoteDiagHandler f12467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2194l(RemoteDiagHandler remoteDiagHandler) {
        this.f12467a = remoteDiagHandler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RemoteDiagHandler.m7049a(this.f12467a);
        this.f12467a.mo7050a(100);
    }
}
