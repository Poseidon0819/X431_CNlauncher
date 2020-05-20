package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;

/* loaded from: classes.dex */
class RewardedVastVideoInterstitial extends VastVideoInterstitial {

    /* renamed from: d */
    private RewardedVideoBroadcastReceiver f20393d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.RewardedVastVideoInterstitial$a */
    /* loaded from: classes.dex */
    public interface InterfaceC3734a extends CustomEventInterstitial.CustomEventInterstitialListener {
        void onVideoComplete();
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        super.loadInterstitial(context, customEventInterstitialListener, map, map2);
        if (customEventInterstitialListener instanceof InterfaceC3734a) {
            this.f20393d = new RewardedVideoBroadcastReceiver((InterfaceC3734a) customEventInterstitialListener, this.f20391c);
            RewardedVideoBroadcastReceiver rewardedVideoBroadcastReceiver = this.f20393d;
            rewardedVideoBroadcastReceiver.register(rewardedVideoBroadcastReceiver, context);
        }
    }

    @Override // com.mopub.mobileads.VastVideoInterstitial, com.mopub.mobileads.VastManager.VastManagerListener
    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig != null) {
            vastVideoConfig.setIsRewardedVideo(true);
        }
        super.onVastVideoConfigurationPrepared(vastVideoConfig);
    }

    @Override // com.mopub.mobileads.VastVideoInterstitial, com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        super.onInvalidate();
        RewardedVideoBroadcastReceiver rewardedVideoBroadcastReceiver = this.f20393d;
        if (rewardedVideoBroadcastReceiver != null) {
            rewardedVideoBroadcastReceiver.unregister(rewardedVideoBroadcastReceiver);
        }
    }
}
