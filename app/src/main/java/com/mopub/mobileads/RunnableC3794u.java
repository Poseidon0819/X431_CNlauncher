package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.u */
/* loaded from: classes.dex */
public final class RunnableC3794u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventRewardedVideo f20638a;

    /* renamed from: b */
    final /* synthetic */ MoPubRewardedVideoManager f20639b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3794u(MoPubRewardedVideoManager moPubRewardedVideoManager, CustomEventRewardedVideo customEventRewardedVideo) {
        this.f20639b = moPubRewardedVideoManager;
        this.f20638a = customEventRewardedVideo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubLog.m2498d("Custom Event failed to load rewarded video in a timely fashion.");
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(this.f20638a.getClass(), this.f20638a.mo2425a(), MoPubErrorCode.NETWORK_TIMEOUT);
        this.f20638a.mo2423b();
    }
}
