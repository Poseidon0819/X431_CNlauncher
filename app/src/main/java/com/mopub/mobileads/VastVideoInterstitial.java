package com.mopub.mobileads;

import com.mopub.common.CacheService;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.Map;

/* loaded from: classes.dex */
class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManager.VastManagerListener {

    /* renamed from: d */
    private CustomEventInterstitial.CustomEventInterstitialListener f20442d;

    /* renamed from: e */
    private String f20443e;

    /* renamed from: f */
    private VastManager f20444f;

    /* renamed from: g */
    private VastVideoConfig f20445g;

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    protected final void extractExtras(Map<String, String> map) {
        this.f20443e = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    protected final void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        this.f20442d = customEventInterstitialListener;
        if (!CacheService.initializeDiskCache(this.f20389a)) {
            this.f20442d.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
            return;
        }
        this.f20444f = VastManagerFactory.create(this.f20389a);
        this.f20444f.prepareVastVideoConfiguration(this.f20443e, this, this.f20390b.getDspCreativeId(), this.f20389a);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MraidVideoPlayerActivity.m2451a(this.f20389a, this.f20445g, this.f20391c);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void onInvalidate() {
        VastManager vastManager = this.f20444f;
        if (vastManager != null) {
            vastManager.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig == null) {
            this.f20442d.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.f20445g = vastVideoConfig;
        this.f20442d.onInterstitialLoaded();
    }
}
