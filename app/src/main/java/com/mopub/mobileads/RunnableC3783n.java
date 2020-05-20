package com.mopub.mobileads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.n */
/* loaded from: classes.dex */
public final class RunnableC3783n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f20606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3783n(String str) {
        this.f20606a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubRewardedVideoListener moPubRewardedVideoListener;
        MoPubRewardedVideoListener moPubRewardedVideoListener2;
        moPubRewardedVideoListener = MoPubRewardedVideoManager.f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener2 = MoPubRewardedVideoManager.f20360a.f20366g;
            moPubRewardedVideoListener2.onRewardedVideoLoadSuccess(this.f20606a);
        }
    }
}
