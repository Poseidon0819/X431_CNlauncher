package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.q */
/* loaded from: classes.dex */
final class C2875q extends LoginFunction {

    /* renamed from: e */
    final /* synthetic */ HandlerC2870l f16461e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2875q(HandlerC2870l handlerC2870l, Context context) {
        super(context);
        this.f16461e = handlerC2870l;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction, com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i == 502 && obj != null) {
            this.f16461e.f16456a.f16419I.sendMessage(this.f16461e.f16456a.f16419I.obtainMessage(6, 0, 0));
        }
    }
}
