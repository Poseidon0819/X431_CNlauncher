package com.unionpay.p372b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.UPSEInfoResp;
import com.unionpay.utils.C4652j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.b.f */
/* loaded from: classes2.dex */
public final class C4132f implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4131e f22078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4132f(C4131e c4131e) {
        this.f22078a = c4131e;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Handler handler;
        Handler handler2;
        int i = message2.what;
        if (i == 1) {
            handler = this.f22078a.f22076i;
            handler.removeMessages(4);
            C4652j.m432b("uppay", "msg error");
            C4131e.m1622a(this.f22078a, message2.arg1, (String) message2.obj);
            return false;
        } else if (i == 4) {
            C4652j.m432b("uppay", "timeout");
            C4131e.m1622a(this.f22078a, message2.arg1, UPSEInfoResp.ERROR_TIMEOUT);
            C4131e.m1616b(this.f22078a);
            return false;
        } else if (i != 4000) {
            return false;
        } else {
            handler2 = this.f22078a.f22076i;
            handler2.removeMessages(4);
            C4131e.m1621a(this.f22078a, (Bundle) message2.obj);
            return false;
        }
    }
}
