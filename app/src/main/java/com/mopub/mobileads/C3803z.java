package com.mopub.mobileads;

import com.mopub.mobileads.MoPubRewardedVideoManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.z */
/* loaded from: classes.dex */
public final class C3803z extends MoPubRewardedVideoManager.AbstractRunnableC3731a {

    /* renamed from: a */
    final /* synthetic */ MoPubErrorCode f20642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3803z(Class cls, String str, MoPubErrorCode moPubErrorCode) {
        super(cls, str);
        this.f20642a = moPubErrorCode;
    }

    @Override // com.mopub.mobileads.MoPubRewardedVideoManager.AbstractRunnableC3731a
    /* renamed from: a */
    protected final void mo2277a(String str) {
        MoPubRewardedVideoManager.m2407a(str, this.f20642a);
    }
}
