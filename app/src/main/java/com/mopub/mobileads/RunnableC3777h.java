package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomEventInterstitialAdapter.java */
/* renamed from: com.mopub.mobileads.h */
/* loaded from: classes.dex */
public final class RunnableC3777h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventInterstitialAdapter f20594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3777h(CustomEventInterstitialAdapter customEventInterstitialAdapter) {
        this.f20594a = customEventInterstitialAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubLog.m2498d("Third-party network timed out.");
        this.f20594a.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f20594a.m2443c();
    }
}
