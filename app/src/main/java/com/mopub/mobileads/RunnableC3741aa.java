package com.mopub.mobileads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.aa */
/* loaded from: classes.dex */
public final class RunnableC3741aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f20503a;

    /* renamed from: b */
    final /* synthetic */ MoPubErrorCode f20504b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3741aa(String str, MoPubErrorCode moPubErrorCode) {
        this.f20503a = str;
        this.f20504b = moPubErrorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubRewardedVideoManager.m2407a(this.f20503a, this.f20504b);
    }
}
