package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.n */
/* loaded from: classes.dex */
final class C2692n extends LoginFunction {

    /* renamed from: e */
    final /* synthetic */ HandlerC2687i f15419e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2692n(HandlerC2687i handlerC2687i, Context context) {
        super(context);
        this.f15419e = handlerC2687i;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction, com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i == 502 && obj != null) {
            this.f15419e.f15414a.f15403x.sendMessage(this.f15419e.f15414a.f15403x.obtainMessage(6, 0, 0));
        }
    }
}
