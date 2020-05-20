package com.mopub.mobileads;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.az */
/* loaded from: classes.dex */
public final class C3760az implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoView f20553a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f20554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3760az(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView) {
        this.f20554b = vastVideoViewController;
        this.f20553a = vastVideoView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r3 != false) goto L8;
     */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPrepared(android.media.MediaPlayer r3) {
        /*
            r2 = this;
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastVideoView r0 = com.mopub.mobileads.VastVideoViewController.m2352g(r3)
            int r0 = r0.getDuration()
            com.mopub.mobileads.VastVideoViewController.m2362a(r3, r0)
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastVideoViewController.m2351h(r3)
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastCompanionAdConfig r3 = com.mopub.mobileads.VastVideoViewController.m2350i(r3)
            if (r3 == 0) goto L22
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            boolean r3 = com.mopub.mobileads.VastVideoViewController.m2349j(r3)
            if (r3 == 0) goto L37
        L22:
            com.mopub.mobileads.VastVideoView r3 = r2.f20553a
            com.mopub.mobileads.VastVideoViewController r0 = r2.f20554b
            android.widget.ImageView r0 = com.mopub.mobileads.VastVideoViewController.m2348k(r0)
            com.mopub.mobileads.VastVideoViewController r1 = r2.f20554b
            com.mopub.mobileads.VastVideoConfig r1 = com.mopub.mobileads.VastVideoViewController.m2354e(r1)
            java.lang.String r1 = r1.getDiskMediaFileUrl()
            r3.prepareBlurredLastVideoFrame(r0, r1)
        L37:
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastVideoProgressBarWidget r3 = com.mopub.mobileads.VastVideoViewController.m2346m(r3)
            com.mopub.mobileads.VastVideoViewController r0 = r2.f20554b
            com.mopub.mobileads.VastVideoView r0 = r0.f20457a
            int r0 = r0.getDuration()
            com.mopub.mobileads.VastVideoViewController r1 = r2.f20554b
            int r1 = com.mopub.mobileads.VastVideoViewController.m2347l(r1)
            r3.calibrateAndMakeVisible(r0, r1)
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastVideoRadialCountdownWidget r3 = com.mopub.mobileads.VastVideoViewController.m2345n(r3)
            com.mopub.mobileads.VastVideoViewController r0 = r2.f20554b
            int r0 = com.mopub.mobileads.VastVideoViewController.m2347l(r0)
            com.mopub.mobileads.resource.RadialCountdownDrawable r1 = r3.f20448a
            r1.setInitialCountdown(r0)
            r0 = 0
            r3.setVisibility(r0)
            com.mopub.mobileads.VastVideoViewController r3 = r2.f20554b
            com.mopub.mobileads.VastVideoViewController.m2344o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.C3760az.onPrepared(android.media.MediaPlayer):void");
    }
}
