package com.mopub.mobileads;

import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial;
import java.util.Map;

/* loaded from: classes.dex */
public class HtmlInterstitial extends ResponseBodyInterstitial {

    /* renamed from: d */
    private String f20331d;

    /* renamed from: e */
    private boolean f20332e;

    /* renamed from: f */
    private String f20333f;

    /* renamed from: g */
    private String f20334g;

    /* renamed from: h */
    private CreativeOrientation f20335h;

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    protected final void extractExtras(Map<String, String> map) {
        this.f20331d = map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.f20332e = Boolean.valueOf(map.get(DataKeys.SCROLLABLE_KEY)).booleanValue();
        this.f20333f = map.get(DataKeys.REDIRECT_URL_KEY);
        this.f20334g = map.get(DataKeys.CLICKTHROUGH_URL_KEY);
        this.f20335h = CreativeOrientation.fromHeader(map.get(DataKeys.CREATIVE_ORIENTATION_KEY));
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial
    protected final void preRenderHtml(CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubActivity.m2440a(this.f20389a, this.f20390b, customEventInterstitialListener, this.f20331d);
    }

    @Override // com.mopub.mobileads.ResponseBodyInterstitial, com.mopub.mobileads.CustomEventInterstitial
    public void showInterstitial() {
        MoPubActivity.start(this.f20389a, this.f20331d, this.f20390b, this.f20332e, this.f20333f, this.f20334g, this.f20335h, this.f20391c);
    }
}
