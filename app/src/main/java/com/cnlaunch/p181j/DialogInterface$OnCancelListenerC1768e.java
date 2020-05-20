package com.cnlaunch.p181j;

import android.content.DialogInterface;
import android.content.Intent;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.module.p252d.p254b.SellerRemoteDiagInfo;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DealDiagMessageHandler.java */
/* renamed from: com.cnlaunch.j.e */
/* loaded from: classes.dex */
public final class DialogInterface$OnCancelListenerC1768e implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ExplainResult f9440a;

    /* renamed from: b */
    final /* synthetic */ DealDiagMessageHandler f9441b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC1768e(DealDiagMessageHandler dealDiagMessageHandler, ExplainResult explainResult) {
        this.f9441b = dealDiagMessageHandler;
        this.f9440a = explainResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f9441b.f9434j.removeMessages(11);
        this.f9441b.m8669a(this.f9440a.f9478id, R.string.canlce_remotediag, this.f9440a.toJsonString(ExplainResult.STOP));
        this.f9441b.f9430f.m8681c();
        if (MainActivity.m7875f()) {
            MainActivity.m7873g();
            SellerRemoteDiagInfo.getInstance().clear();
            this.f9441b.f9429e.sendBroadcast(new Intent("SellerRequest_remotediag_end"));
        }
    }
}
