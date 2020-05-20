package com.cnlaunch.x431pro.activity.mine;

import android.widget.ScrollView;

/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bz */
/* loaded from: classes.dex */
final class RunnableC2450bz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View$OnTouchListenerC2449by f14016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2450bz(View$OnTouchListenerC2449by view$OnTouchListenerC2449by) {
        this.f14016a = view$OnTouchListenerC2449by;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView;
        scrollView = this.f14016a.f14015a.f14013d;
        scrollView.fullScroll(130);
    }
}
