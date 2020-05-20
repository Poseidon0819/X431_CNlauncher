package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.utils.C4390k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.c */
/* loaded from: classes2.dex */
public final class C4299c implements InterfaceC4261b {

    /* renamed from: a */
    final /* synthetic */ C4298b f22882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4299c(C4298b c4298b) {
        this.f22882a = c4298b;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: a */
    public final void mo1206a() {
        this.f22882a.m1212b(1);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: b */
    public final void mo1205b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f22882a.f22863h;
        if (handler != null) {
            C4390k.m836c("UPCardEngine", "mSDInitCallback.initFailed!!!!");
            handler2 = this.f22882a.f22863h;
            Message obtainMessage = handler2.obtainMessage(1, null);
            handler3 = this.f22882a.f22863h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
