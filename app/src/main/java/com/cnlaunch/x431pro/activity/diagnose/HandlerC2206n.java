package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.n */
/* loaded from: classes.dex */
final class HandlerC2206n extends Handler {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12480a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2206n(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12480a = carIconFragmentForAll;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        context = this.f12480a.mContext;
        ApkUpgradeUtils.m5110a(context, message2.what);
    }
}
