package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.i */
/* loaded from: classes2.dex */
public final class RunnableC4305i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4298b f22888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4305i(C4298b c4298b) {
        this.f22888a = c4298b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4263d c4263d;
        Handler handler;
        Handler handler2;
        Handler handler3;
        synchronized (this.f22888a) {
            C4390k.m836c("UPCardEngine", " ic_return : 4");
            c4263d = this.f22888a.f22875t;
            ArrayList<InterfaceC4174c> m1320b = c4263d.m1320b();
            handler = this.f22888a.f22863h;
            if (handler != null) {
                handler2 = this.f22888a.f22863h;
                Message obtainMessage = handler2.obtainMessage(4, m1320b);
                handler3 = this.f22888a.f22863h;
                handler3.sendMessage(obtainMessage);
            }
        }
    }
}
