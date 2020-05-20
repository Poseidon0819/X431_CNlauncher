package com.alipay.sdk.p073c;

import android.app.Activity;

/* renamed from: com.alipay.sdk.c.d */
/* loaded from: classes.dex */
final class RunnableC0751d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f3546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0751d(Activity activity) {
        this.f3546a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3546a.finish();
    }
}
