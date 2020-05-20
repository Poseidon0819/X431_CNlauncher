package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* compiled from: CustomEventBannerAdapter.java */
/* renamed from: com.mopub.mobileads.g */
/* loaded from: classes.dex */
final class RunnableC3776g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventBannerAdapter f20593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3776g(CustomEventBannerAdapter customEventBannerAdapter) {
        this.f20593a = customEventBannerAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubLog.m2498d("Third-party network timed out.");
        this.f20593a.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f20593a.m2447a();
    }
}
