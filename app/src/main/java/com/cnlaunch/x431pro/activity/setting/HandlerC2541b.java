package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;

/* compiled from: AboutFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.b */
/* loaded from: classes.dex */
final class HandlerC2541b extends Handler {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f14635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2541b(AboutFragment aboutFragment) {
        this.f14635a = aboutFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        context = this.f14635a.mContext;
        ApkUpgradeUtils.m5110a(context, message2.what);
    }
}
