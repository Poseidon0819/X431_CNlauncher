package com.cnlaunch.x431pro.module.p242ad;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/* compiled from: ADShowActivity.java */
/* renamed from: com.cnlaunch.x431pro.module.ad.c */
/* loaded from: classes.dex */
final class HandlerC2713c extends Handler {

    /* renamed from: a */
    final /* synthetic */ ADShowActivity f15474a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2713c(ADShowActivity aDShowActivity) {
        this.f15474a = aDShowActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        switch (message2.what) {
            case 0:
                progressBar = this.f15474a.f15469g;
                progressBar.setVisibility(0);
                return;
            case 1:
                progressBar2 = this.f15474a.f15469g;
                progressBar2.setVisibility(8);
                return;
            case 2:
                progressBar3 = this.f15474a.f15469g;
                progressBar3.setProgress(((Integer) message2.obj).intValue());
                return;
            default:
                super.handleMessage(message2);
                return;
        }
    }
}
