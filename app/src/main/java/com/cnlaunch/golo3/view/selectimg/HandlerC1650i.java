package com.cnlaunch.golo3.view.selectimg;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/* compiled from: CropImageActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.i */
/* loaded from: classes.dex */
final class HandlerC1650i extends Handler {

    /* renamed from: a */
    final /* synthetic */ CropImageActivity f8688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1650i(CropImageActivity cropImageActivity) {
        this.f8688a = cropImageActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBar progressBar;
        Handler handler;
        ProgressBar progressBar2;
        switch (message2.what) {
            case 2000:
                progressBar = this.f8688a.f8529K;
                progressBar.setVisibility(0);
                return;
            case 2001:
                handler = this.f8688a.f8536R;
                handler.removeMessages(2000);
                progressBar2 = this.f8688a.f8529K;
                progressBar2.setVisibility(4);
                return;
            default:
                return;
        }
    }
}
