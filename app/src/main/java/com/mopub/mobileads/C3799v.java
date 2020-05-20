package com.mopub.mobileads;

import com.mopub.mobileads.MoPubRewardedVideoManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.v */
/* loaded from: classes.dex */
public final class C3799v extends MoPubRewardedVideoManager.AbstractRunnableC3731a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C3799v(Class cls, String str) {
        super(cls, str);
    }

    @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC3731a
    /* renamed from: a */
    protected final void mo2277a(String str) {
        MoPubRewardedVideoListener moPubRewardedVideoListener;
        MoPubRewardedVideoListener moPubRewardedVideoListener2;
        MoPubRewardedVideoManager.m2412a(MoPubRewardedVideoManager.f20360a, str);
        moPubRewardedVideoListener = MoPubRewardedVideoManager.f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener2 = MoPubRewardedVideoManager.f20360a.f20366g;
            moPubRewardedVideoListener2.onRewardedVideoLoadSuccess(str);
        }
    }
}
