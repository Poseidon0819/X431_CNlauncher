package com.cnlaunch.x431pro.activity;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.activity.p213b.p215b.LatestVersionInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.u */
/* loaded from: classes.dex */
public final class RunnableC2600u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MainActivity f14976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2600u(MainActivity mainActivity) {
        this.f14976a = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        try {
            LatestVersionInfo m7809a = new SellerAction(this.f14976a.f10736a).m7809a("0");
            if (m7809a != null && m7809a.getData() != null) {
                String url = m7809a.getData().getUrl();
                Message message2 = new Message();
                message2.obj = url;
                message2.what = 110;
                handler = this.f14976a.f10728R;
                handler.sendMessage(message2);
                return;
            }
            MainActivity.m7891b(this.f14976a, 111);
        } catch (C1425f e) {
            NLog.m9455a(e);
            MainActivity.m7891b(this.f14976a, 111);
        }
    }
}
