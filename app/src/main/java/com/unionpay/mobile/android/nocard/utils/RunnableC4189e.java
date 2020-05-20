package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import com.unionpay.mobile.android.net.C4180c;
import com.unionpay.mobile.android.net.C4181d;

/* renamed from: com.unionpay.mobile.android.nocard.utils.e */
/* loaded from: classes2.dex */
final class RunnableC4189e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f22522a;

    /* renamed from: b */
    final /* synthetic */ String f22523b;

    /* renamed from: c */
    final /* synthetic */ Context f22524c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4189e(String str, String str2, Context context) {
        this.f22522a = str;
        this.f22523b = str2;
        this.f22524c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new C4180c(new C4181d(1, this.f22522a, this.f22523b.getBytes()), this.f22524c).m1529a();
    }
}
