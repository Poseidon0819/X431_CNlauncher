package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.pboctransaction.InterfaceC4261b;
import com.unionpay.mobile.android.pboctransaction.samsung.C4283f;
import com.unionpay.mobile.android.utils.C4390k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.f */
/* loaded from: classes2.dex */
public final class C4302f implements InterfaceC4261b {

    /* renamed from: a */
    final /* synthetic */ C4298b f22885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4302f(C4298b c4298b) {
        this.f22885a = c4298b;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: a */
    public final void mo1206a() {
        C4283f c4283f;
        C4283f c4283f2;
        C4390k.m836c("uppay-spay", "tsmservice  init success");
        C4173b.f22373bn = false;
        c4283f = this.f22885a.f22880y;
        if (c4283f == null) {
            this.f22885a.m1212b(8);
            return;
        }
        c4283f2 = this.f22885a.f22880y;
        if (c4283f2.m1252e()) {
            return;
        }
        C4173b.f22368aB = false;
        this.f22885a.m1212b(8);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.InterfaceC4261b
    /* renamed from: b */
    public final void mo1205b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        C4390k.m836c("UPCardEngine", "mSE init failed");
        C4390k.m836c("uppay-spay", "tsmservice  init fail");
        handler = this.f22885a.f22863h;
        if (handler != null) {
            handler2 = this.f22885a.f22863h;
            Message obtainMessage = handler2.obtainMessage(8, null);
            handler3 = this.f22885a.f22863h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
