package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.d */
/* loaded from: classes2.dex */
public final class C4300d implements InterfaceC4261b {

    /* renamed from: a */
    final /* synthetic */ C4298b f22883a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4300d(C4298b c4298b) {
        this.f22883a = c4298b;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: a */
    public final void mo1206a() {
        this.f22883a.m1212b(2);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: b */
    public final void mo1205b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f22883a.f22863h;
        if (handler != null) {
            handler2 = this.f22883a.f22863h;
            Message obtainMessage = handler2.obtainMessage(2, null);
            handler3 = this.f22883a.f22863h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
