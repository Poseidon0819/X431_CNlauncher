package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.hce.j */
/* loaded from: classes2.dex */
public final class RunnableC4160j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4156f f22212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4160j(C4156f c4156f) {
        this.f22212a = c4156f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle m1573d;
        Handler handler;
        Handler handler2;
        Handler handler3;
        int unused;
        int unused2;
        C4156f c4156f = this.f22212a;
        str = c4156f.f22192l;
        unused = this.f22212a.f22186f;
        unused2 = this.f22212a.f22188h;
        m1573d = c4156f.m1573d(str);
        C4156f.m1566k(this.f22212a);
        handler = this.f22212a.f22204y;
        if (handler != null) {
            handler2 = this.f22212a.f22204y;
            handler3 = this.f22212a.f22204y;
            if (m1573d == null) {
                m1573d = null;
            }
            handler2.sendMessage(handler3.obtainMessage(2001, m1573d));
        }
    }
}
