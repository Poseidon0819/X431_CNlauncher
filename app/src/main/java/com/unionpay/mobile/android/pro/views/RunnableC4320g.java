package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.C4173b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.g */
/* loaded from: classes2.dex */
public final class RunnableC4320g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22932a;

    /* renamed from: b */
    final /* synthetic */ HashMap f22933b;

    /* renamed from: c */
    final /* synthetic */ C4307a f22934c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4320g(C4307a c4307a, String str, HashMap hashMap) {
        this.f22934c = c4307a;
        this.f22932a = str;
        this.f22933b = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        C4173b unused;
        C4307a c4307a = this.f22934c;
        String str = this.f22932a;
        unused = c4307a.f22590a;
        Bundle m1199a = c4307a.m1199a(str, this.f22933b);
        handler = this.f22934c.f22915z;
        handler2 = this.f22934c.f22915z;
        if (m1199a == null) {
            m1199a = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, m1199a));
    }
}
