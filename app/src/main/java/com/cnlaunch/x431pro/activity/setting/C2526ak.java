package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ak */
/* loaded from: classes.dex */
final class C2526ak extends LoginFunction {

    /* renamed from: e */
    final /* synthetic */ HandlerC2524ai f14575e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2526ak(HandlerC2524ai handlerC2524ai, Context context) {
        super(context);
        this.f14575e = handlerC2524ai;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction, com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i != 502) {
            return;
        }
        super.onSuccess(i, obj);
        if (obj != null) {
            this.f14575e.f14573a.onResume();
        }
    }
}
