package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.bc */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC3766bc implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoViewController f20561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC3766bc(VastVideoViewController vastVideoViewController) {
        this.f20561a = vastVideoViewController;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int currentPosition;
        VastVideoConfig vastVideoConfig;
        z = this.f20561a.f20481y;
        if (z) {
            currentPosition = this.f20561a.f20455C;
        } else {
            currentPosition = this.f20561a.f20457a.getCurrentPosition();
        }
        if (motionEvent.getAction() == 1) {
            VastVideoViewController.m2358b(this.f20561a);
            vastVideoConfig = this.f20561a.f20466j;
            vastVideoConfig.handleClose(this.f20561a.mContext, currentPosition);
            this.f20561a.mBaseVideoViewControllerListener.onFinish();
        }
        return true;
    }
}
