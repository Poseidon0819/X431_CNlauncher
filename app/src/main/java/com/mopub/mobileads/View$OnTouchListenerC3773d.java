package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseHtmlWebView.java */
/* renamed from: com.mopub.mobileads.d */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC3773d implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ boolean f20576a;

    /* renamed from: b */
    final /* synthetic */ BaseHtmlWebView f20577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC3773d(BaseHtmlWebView baseHtmlWebView, boolean z) {
        this.f20577b = baseHtmlWebView;
        this.f20576a = z;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ViewGestureDetector viewGestureDetector;
        viewGestureDetector = this.f20577b.f20303b;
        viewGestureDetector.sendTouchEvent(motionEvent);
        return motionEvent.getAction() == 2 && !this.f20576a;
    }
}
