package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.view.View;
import com.cnlaunch.p120d.p130d.NLog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteDiagHandler.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.o */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2197o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f12470a;

    /* renamed from: b */
    final /* synthetic */ RemoteDiagHandler f12471b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2197o(RemoteDiagHandler remoteDiagHandler, boolean z) {
        this.f12471b = remoteDiagHandler;
        this.f12470a = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NLog.m9451c("Sanda", "------->isWait=" + this.f12470a);
        if (this.f12470a) {
            this.f12471b.m7042d(R.string.remotediag_wait_for_other);
        }
    }
}
