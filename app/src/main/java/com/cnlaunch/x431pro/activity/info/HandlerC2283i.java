package com.cnlaunch.x431pro.activity.info;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* compiled from: P_DFScanActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.i */
/* loaded from: classes.dex */
final class HandlerC2283i extends Handler {

    /* renamed from: a */
    final /* synthetic */ P_DFScanActivity f12908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2283i(P_DFScanActivity p_DFScanActivity) {
        this.f12908a = p_DFScanActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        if (message2.what != 0) {
            return;
        }
        NToast.m9450a(this.f12908a.f12851a, (int) R.string.sd_no_storage_space);
        this.f12908a.f12856f.dismiss();
        this.f12908a.finish();
    }
}
