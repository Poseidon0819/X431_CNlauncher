package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.pro.pboc.engine.C4298b;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.ad */
/* loaded from: classes2.dex */
public final class RunnableC4311ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4298b f22919a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC4174c f22920b;

    /* renamed from: c */
    final /* synthetic */ String f22921c;

    /* renamed from: d */
    final /* synthetic */ HashMap f22922d;

    /* renamed from: e */
    final /* synthetic */ C4338y f22923e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4311ad(C4338y c4338y, C4298b c4298b, InterfaceC4174c interfaceC4174c, String str, HashMap hashMap) {
        this.f22923e = c4338y;
        this.f22919a = c4298b;
        this.f22920b = interfaceC4174c;
        this.f22921c = str;
        this.f22922d = hashMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4173b c4173b;
        C4173b c4173b2;
        Handler handler;
        Handler handler2;
        C4298b c4298b = this.f22919a;
        InterfaceC4174c interfaceC4174c = this.f22920b;
        String str = this.f22921c;
        c4173b = this.f22923e.f22590a;
        HashMap<String, String> hashMap = c4173b.f22480p;
        HashMap<String, String> hashMap2 = this.f22922d;
        c4173b2 = this.f22923e.f22590a;
        Bundle m1220a = c4298b.m1220a(interfaceC4174c, str, hashMap, hashMap2, c4173b2.f22477m);
        handler = this.f22923e.f22991D;
        handler2 = this.f22923e.f22991D;
        if (m1220a == null) {
            m1220a = null;
        }
        handler.sendMessage(handler2.obtainMessage(0, m1220a));
    }
}
