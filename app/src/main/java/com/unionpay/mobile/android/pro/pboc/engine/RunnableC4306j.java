package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pboctransaction.C4263d;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.pboc.engine.j */
/* loaded from: classes2.dex */
public final class RunnableC4306j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4298b f22889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4306j(C4298b c4298b) {
        this.f22889a = c4298b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4263d c4263d;
        C4263d c4263d2;
        boolean m1215a;
        Handler handler;
        Handler handler2;
        Message obtainMessage;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        synchronized (this.f22889a) {
            C4390k.m836c("UPCardEngine", " se_return : 8");
            if (C4173b.f22372bm) {
                handler4 = this.f22889a.f22863h;
                if (handler4 != null) {
                    handler5 = this.f22889a.f22863h;
                    obtainMessage = handler5.obtainMessage(8, new ArrayList());
                    handler3 = this.f22889a.f22863h;
                    handler3.sendMessage(obtainMessage);
                }
            } else {
                c4263d = this.f22889a.f22878w;
                if (c4263d != null) {
                    c4263d2 = this.f22889a.f22878w;
                    ArrayList<InterfaceC4174c> m1320b = c4263d2.m1320b();
                    m1215a = this.f22889a.m1215a("com.unionpay.tsmservice", 18);
                    if (!m1215a) {
                        handler = this.f22889a.f22863h;
                        if (handler != null) {
                            handler2 = this.f22889a.f22863h;
                            obtainMessage = handler2.obtainMessage(8, m1320b);
                            handler3 = this.f22889a.f22863h;
                            handler3.sendMessage(obtainMessage);
                        }
                    }
                }
            }
        }
    }
}
