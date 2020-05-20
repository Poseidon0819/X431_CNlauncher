package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.e */
/* loaded from: classes2.dex */
public final class C4301e implements InterfaceC4261b {

    /* renamed from: a */
    final /* synthetic */ C4298b f22884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4301e(C4298b c4298b) {
        this.f22884a = c4298b;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: a */
    public final void mo1206a() {
        this.f22884a.m1212b(4);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: b */
    public final void mo1205b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f22884a.f22863h;
        if (handler != null) {
            handler2 = this.f22884a.f22863h;
            Message obtainMessage = handler2.obtainMessage(4, null);
            handler3 = this.f22884a.f22863h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
