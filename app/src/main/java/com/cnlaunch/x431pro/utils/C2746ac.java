package com.cnlaunch.x431pro.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p241a.PresenterCallback;

/* compiled from: Tools.java */
/* renamed from: com.cnlaunch.x431pro.utils.ac */
/* loaded from: classes.dex */
final class C2746ac implements PresenterCallback {

    /* renamed from: a */
    final /* synthetic */ Handler f15714a = null;

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5115a(Bundle bundle) {
        Handler handler = this.f15714a;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(37121);
            obtainMessage.setData(bundle);
            this.f15714a.sendMessage(obtainMessage);
        }
    }

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5116a(int i) {
        NLog.m9451c("XEE", "autoCode err:".concat(String.valueOf(i)));
        Handler handler = this.f15714a;
        if (handler != null) {
            handler.obtainMessage(37122).sendToTarget();
        }
    }
}
