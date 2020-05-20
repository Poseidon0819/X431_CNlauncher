package com.mopub.mobileads;

import com.mopub.mobileads.MoPubRewardedVideoManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.w */
/* loaded from: classes.dex */
public final class C3800w extends MoPubRewardedVideoManager.AbstractRunnableC3731a {

    /* renamed from: a */
    final /* synthetic */ MoPubErrorCode f20640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3800w(Class cls, String str, MoPubErrorCode moPubErrorCode) {
        super(cls, str);
        this.f20640a = moPubErrorCode;
    }

    @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC3731a
    /* renamed from: a */
    protected final void mo2277a(String str) {
        MoPubRewardedVideoManager.m2412a(MoPubRewardedVideoManager.f20360a, str);
        MoPubRewardedVideoManager.f20360a.m2403b(str, this.f20640a);
    }
}
