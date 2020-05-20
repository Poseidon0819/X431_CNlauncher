package com.unionpay.mobile.android.hce;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.hce.h */
/* loaded from: classes2.dex */
public final class C4158h extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f22206a;

    /* renamed from: b */
    final /* synthetic */ String f22207b;

    /* renamed from: c */
    final /* synthetic */ C4156f f22208c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4158h(C4156f c4156f, String str, String str2) {
        this.f22208c = c4156f;
        this.f22206a = str;
        this.f22207b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean m1584a;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        int i;
        m1584a = this.f22208c.m1584a(this.f22206a, this.f22207b);
        if (!m1584a) {
            handler = this.f22208c.f22204y;
            if (handler != null) {
                handler2 = this.f22208c.f22204y;
                Message obtainMessage = handler2.obtainMessage(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE, this.f22206a);
                handler3 = this.f22208c.f22204y;
                handler3.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        handler4 = this.f22208c.f22204y;
        if (handler4 != null) {
            handler5 = this.f22208c.f22204y;
            Message obtainMessage2 = handler5.obtainMessage(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, this.f22206a);
            handler6 = this.f22208c.f22204y;
            i = this.f22208c.f22189i;
            handler6.sendMessageDelayed(obtainMessage2, i);
        }
    }
}
