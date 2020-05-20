package com.mopub.mobileads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.t */
/* loaded from: classes.dex */
public final class RunnableC3793t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f20637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3793t(String str) {
        this.f20637a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = MoPubRewardedVideoManager.f20360a.f20363d;
        RewardedVideoCompletionRequestHandler.makeRewardedVideoCompletionRequest(context, this.f20637a, MoPubRewardedVideoManager.f20360a.f20365f.f20516g);
    }
}
