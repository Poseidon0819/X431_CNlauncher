package com.unionpay.mobile.android.widgets;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ar */
/* loaded from: classes2.dex */
public final class C4442ar extends Thread {

    /* renamed from: a */
    final /* synthetic */ int f23373a;

    /* renamed from: b */
    final /* synthetic */ C4439ap f23374b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4442ar(C4439ap c4439ap, int i) {
        this.f23374b = c4439ap;
        this.f23373a = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        int i;
        Handler handler3;
        Handler handler4;
        handler = this.f23374b.f23370p;
        if (handler != null) {
            long currentTimeMillis = System.currentTimeMillis() + (this.f23373a * 1000);
            while (true) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 > currentTimeMillis || (i = (int) (((currentTimeMillis - currentTimeMillis2) + this.f23373a) / 1000)) <= 0) {
                    break;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.arg1 = i;
                handler3 = this.f23374b.f23370p;
                handler3.sendMessage(obtain);
                try {
                    sleep(1000L);
                } catch (InterruptedException unused) {
                    handler4 = this.f23374b.f23370p;
                    handler4.sendEmptyMessage(1);
                    return;
                }
            }
            handler2 = this.f23374b.f23370p;
            handler2.sendEmptyMessage(1);
        }
    }
}
