package com.cnlaunch.x431pro.activity.golousa;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.activity.p213b.p215b.LatestVersionInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoloUSAFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golousa.e */
/* loaded from: classes.dex */
public final class RunnableC2249e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GoloUSAFragment f12713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2249e(GoloUSAFragment goloUSAFragment) {
        this.f12713a = goloUSAFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Handler handler;
        try {
            context = this.f12713a.mContext;
            LatestVersionInfo m7809a = new SellerAction(context).m7809a("0");
            if (m7809a != null && m7809a.getData() != null) {
                String url = m7809a.getData().getUrl();
                Message message2 = new Message();
                message2.obj = url;
                message2.what = 110;
                handler = this.f12713a.f12709o;
                handler.sendMessage(message2);
                return;
            }
            GoloUSAFragment.m6952a(this.f12713a, 111);
        } catch (C1425f e) {
            NLog.m9455a(e);
            GoloUSAFragment.m6952a(this.f12713a, 111);
        }
    }
}
