package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class MoPubStaticNativeAdRenderer implements MoPubAdRenderer<StaticNativeAd> {
    @VisibleForTesting

    /* renamed from: a */
    final WeakHashMap<View, StaticNativeViewHolder> f20887a = new WeakHashMap<>();

    /* renamed from: b */
    private final ViewBinder f20888b;

    public MoPubStaticNativeAdRenderer(ViewBinder viewBinder) {
        this.f20888b = viewBinder;
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public View createAdView(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f20888b.f21026a, viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(View view, StaticNativeAd staticNativeAd) {
        StaticNativeViewHolder staticNativeViewHolder = this.f20887a.get(view);
        if (staticNativeViewHolder == null) {
            staticNativeViewHolder = StaticNativeViewHolder.m2065a(view, this.f20888b);
            this.f20887a.put(view, staticNativeViewHolder);
        }
        NativeRendererHelper.addTextView(staticNativeViewHolder.f21113b, staticNativeAd.getTitle());
        NativeRendererHelper.addTextView(staticNativeViewHolder.f21114c, staticNativeAd.getText());
        NativeRendererHelper.addTextView(staticNativeViewHolder.f21115d, staticNativeAd.getCallToAction());
        NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), staticNativeViewHolder.f21116e);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), staticNativeViewHolder.f21117f);
        NativeRendererHelper.addPrivacyInformationIcon(staticNativeViewHolder.f21118g, staticNativeAd.getPrivacyInformationIconImageUrl(), staticNativeAd.getPrivacyInformationIconClickThroughUrl());
        NativeRendererHelper.updateExtras(staticNativeViewHolder.f21112a, this.f20888b.f21033h, staticNativeAd.getExtras());
        if (staticNativeViewHolder.f21112a != null) {
            staticNativeViewHolder.f21112a.setVisibility(0);
        }
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof StaticNativeAd;
    }
}
