package com.mopub.mraid;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.ViewGestureDetector;

/* compiled from: MraidBridge.java */
/* renamed from: com.mopub.mraid.c */
/* loaded from: classes.dex */
final class View$OnTouchListenerC3817c implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ViewGestureDetector f20711a;

    /* renamed from: b */
    final /* synthetic */ MraidBridge f20712b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC3817c(MraidBridge mraidBridge, ViewGestureDetector viewGestureDetector) {
        this.f20712b = mraidBridge;
        this.f20711a = viewGestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f20711a.sendTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            default:
                return false;
        }
    }
}
