package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

/* loaded from: classes.dex */
public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable {

    /* renamed from: c */
    private final VastVideoViewController f20484c;

    public VastVideoViewCountdownRunnable(VastVideoViewController vastVideoViewController, Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        this.f20484c = vastVideoViewController;
    }

    @Override // com.mopub.mobileads.RepeatingHandlerRunnable
    public void doWork() {
        VastVideoViewController vastVideoViewController = this.f20484c;
        if (vastVideoViewController.f20465i) {
            VastVideoRadialCountdownWidget vastVideoRadialCountdownWidget = vastVideoViewController.f20459c;
            int i = vastVideoViewController.f20463g;
            int currentPosition = vastVideoViewController.f20457a.getCurrentPosition();
            if (currentPosition >= vastVideoRadialCountdownWidget.f20449b) {
                if (i - currentPosition < 0) {
                    vastVideoRadialCountdownWidget.setVisibility(8);
                } else {
                    vastVideoRadialCountdownWidget.f20448a.updateCountdownProgress(currentPosition);
                    vastVideoRadialCountdownWidget.f20449b = currentPosition;
                }
            }
        }
        VastVideoViewController vastVideoViewController2 = this.f20484c;
        if (!vastVideoViewController2.f20464h && vastVideoViewController2.f20457a.getCurrentPosition() >= vastVideoViewController2.f20463g) {
            this.f20484c.m2367a();
        }
    }
}
