package com.mopub.mobileads;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.IntentActions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.aw */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC3757aw implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Activity f20546a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f20547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC3757aw(VastVideoViewController vastVideoViewController, Activity activity) {
        this.f20547b = vastVideoViewController;
        this.f20546a = activity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        VastVideoConfig vastVideoConfig;
        boolean z2;
        int currentPosition;
        if (motionEvent.getAction() == 1) {
            z = this.f20547b.f20464h;
            if (z) {
                VastVideoViewController.m2358b(this.f20547b);
                this.f20547b.m2450a(IntentActions.ACTION_INTERSTITIAL_CLICK);
                vastVideoConfig = this.f20547b.f20466j;
                Activity activity = this.f20546a;
                z2 = this.f20547b.f20481y;
                if (z2) {
                    currentPosition = this.f20547b.f20455C;
                } else {
                    currentPosition = this.f20547b.f20457a.getCurrentPosition();
                }
                vastVideoConfig.handleClickForResult(activity, currentPosition, 1);
            }
        }
        return true;
    }
}
