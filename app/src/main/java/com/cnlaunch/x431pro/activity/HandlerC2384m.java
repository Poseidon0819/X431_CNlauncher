package com.cnlaunch.x431pro.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseWebFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.m */
/* loaded from: classes.dex */
public final class HandlerC2384m extends Handler {

    /* renamed from: a */
    final /* synthetic */ BaseWebFragment f13540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2384m(BaseWebFragment baseWebFragment) {
        this.f13540a = baseWebFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        switch (message2.what) {
            case 0:
                progressBar = this.f13540a.f12973e;
                progressBar.setVisibility(0);
                return;
            case 1:
                progressBar2 = this.f13540a.f12973e;
                progressBar2.setVisibility(8);
                return;
            case 2:
                progressBar3 = this.f13540a.f12973e;
                progressBar3.setProgress(((Integer) message2.obj).intValue());
                return;
            default:
                super.handleMessage(message2);
                return;
        }
    }
}
