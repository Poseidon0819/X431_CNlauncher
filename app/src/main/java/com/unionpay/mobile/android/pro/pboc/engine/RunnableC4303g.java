package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.g */
/* loaded from: classes2.dex */
public final class RunnableC4303g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4298b f22886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4303g(C4298b c4298b) {
        this.f22886a = c4298b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4263d c4263d;
        Handler handler;
        Handler handler2;
        Handler handler3;
        C4390k.m836c("UPCardEngine", " sd_return : 1");
        c4263d = this.f22886a.f22869n;
        ArrayList<InterfaceC4174c> m1320b = c4263d.m1320b();
        handler = this.f22886a.f22863h;
        if (handler != null) {
            handler2 = this.f22886a.f22863h;
            Message obtainMessage = handler2.obtainMessage(1, m1320b);
            handler3 = this.f22886a.f22863h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
