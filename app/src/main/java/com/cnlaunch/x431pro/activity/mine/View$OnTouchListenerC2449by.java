package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PinCardPayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.by */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC2449by implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ PinCardPayFragment f14015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2449by(PinCardPayFragment pinCardPayFragment) {
        this.f14015a = pinCardPayFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Handler handler;
        handler = this.f14015a.f14012c;
        handler.postDelayed(new RunnableC2450bz(this), 300L);
        return false;
    }
}
