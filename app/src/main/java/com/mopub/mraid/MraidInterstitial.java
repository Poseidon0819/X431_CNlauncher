package com.mopub.mraid;

import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

/* loaded from: classes.dex */
class MraidInterstitial extends ResponseBodyInterstitial {

    /* renamed from: d */
    private String f20692d;

    MraidInterstitial() {
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    public final void extractExtras(Map<String, String> map) {
        this.f20692d = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    public final void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        MraidActivity.preRenderHtml(this.f20389a, customEventInterstitialListener, this.f20692d);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MraidActivity.start(this.f20389a, this.f20390b, this.f20692d, this.f20391c);
    }
}
