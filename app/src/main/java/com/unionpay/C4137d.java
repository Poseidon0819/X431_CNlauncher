package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.p371a.C4120c;
import com.unionpay.p371a.C4121d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.d */
/* loaded from: classes2.dex */
public final class C4137d extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        C4121d c4121d;
        Context context;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        handler = UPPayAssistEx.f21997R;
        handler.sendEmptyMessageDelayed(1001, 800L);
        c4121d = UPPayAssistEx.f21996Q;
        context = UPPayAssistEx.f21986G;
        C4120c c4120c = new C4120c(c4121d, context);
        c4120c.m1643a();
        String m1642b = c4120c.m1642b();
        handler2 = UPPayAssistEx.f21997R;
        if (handler2 != null) {
            handler3 = UPPayAssistEx.f21997R;
            Message obtainMessage = handler3.obtainMessage();
            obtainMessage.what = 1002;
            obtainMessage.obj = m1642b;
            handler4 = UPPayAssistEx.f21997R;
            handler4.removeMessages(1001);
            handler5 = UPPayAssistEx.f21997R;
            handler5.sendMessage(obtainMessage);
        }
    }
}
