package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.C4173b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.s */
/* loaded from: classes2.dex */
public final class RunnableC4332s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22982a;

    /* renamed from: b */
    final /* synthetic */ HashMap f22983b;

    /* renamed from: c */
    final /* synthetic */ C4324k f22984c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4332s(C4324k c4324k, String str, HashMap hashMap) {
        this.f22984c = c4324k;
        this.f22982a = str;
        this.f22983b = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        C4173b unused;
        C4324k c4324k = this.f22984c;
        String str = this.f22982a;
        unused = c4324k.f22590a;
        Bundle m1139a = c4324k.m1139a(str, this.f22983b);
        handler = this.f22984c.f22973z;
        handler2 = this.f22984c.f22973z;
        if (m1139a == null) {
            m1139a = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, m1139a));
    }
}
