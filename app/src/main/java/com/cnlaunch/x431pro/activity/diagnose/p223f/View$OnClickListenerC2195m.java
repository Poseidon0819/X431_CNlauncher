package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteDiagHandler.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.m */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2195m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RemoteDiagHandler f12468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2195m(RemoteDiagHandler remoteDiagHandler) {
        this.f12468a = remoteDiagHandler;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RemoteDiagHandler.m7049a(this.f12468a);
        this.f12468a.mo7050a(100);
    }
}
