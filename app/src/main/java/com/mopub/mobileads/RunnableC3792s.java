package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.MoPubReward;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoPubRewardedVideoManager.java */
/* renamed from: com.mopub.mobileads.s */
/* loaded from: classes.dex */
public final class RunnableC3792s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Class f20633a;

    /* renamed from: b */
    final /* synthetic */ MoPubReward f20634b;

    /* renamed from: c */
    final /* synthetic */ String f20635c;

    /* renamed from: d */
    final /* synthetic */ String f20636d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3792s(Class cls, MoPubReward moPubReward, String str, String str2) {
        this.f20633a = cls;
        this.f20634b = moPubReward;
        this.f20635c = str;
        this.f20636d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoPubRewardedVideoListener moPubRewardedVideoListener;
        MoPubRewardedVideoListener moPubRewardedVideoListener2;
        RewardedVideoData rewardedVideoData = MoPubRewardedVideoManager.f20360a.f20365f;
        MoPubReward m2416a = MoPubRewardedVideoManager.m2416a(rewardedVideoData.f20513d.get(this.f20633a), this.f20634b);
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(this.f20635c)) {
            hashSet.addAll(MoPubRewardedVideoManager.f20360a.f20365f.m2315a(this.f20633a, this.f20636d));
        } else {
            hashSet.add(this.f20635c);
        }
        moPubRewardedVideoListener = MoPubRewardedVideoManager.f20360a.f20366g;
        if (moPubRewardedVideoListener != null) {
            moPubRewardedVideoListener2 = MoPubRewardedVideoManager.f20360a.f20366g;
            moPubRewardedVideoListener2.onRewardedVideoCompleted(hashSet, m2416a);
        }
    }
}
