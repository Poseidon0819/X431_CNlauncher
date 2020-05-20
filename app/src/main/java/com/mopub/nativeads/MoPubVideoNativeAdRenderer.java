package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class MoPubVideoNativeAdRenderer implements MoPubAdRenderer<VideoNativeAd> {
    @VisibleForTesting

    /* renamed from: a */
    final WeakHashMap<View, MediaViewHolder> f20908a = new WeakHashMap<>();

    /* renamed from: b */
    private final MediaViewBinder f20909b;

    public MoPubVideoNativeAdRenderer(MediaViewBinder mediaViewBinder) {
        this.f20909b = mediaViewBinder;
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public View createAdView(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(this.f20909b.f20802a, viewGroup, false);
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public void renderAdView(View view, VideoNativeAd videoNativeAd) {
        MediaViewHolder mediaViewHolder = this.f20908a.get(view);
        if (mediaViewHolder == null) {
            mediaViewHolder = MediaViewHolder.m2055a(view, this.f20909b);
            this.f20908a.put(view, mediaViewHolder);
        }
        NativeRendererHelper.addTextView(mediaViewHolder.f21145c, videoNativeAd.getTitle());
        NativeRendererHelper.addTextView(mediaViewHolder.f21146d, videoNativeAd.getText());
        NativeRendererHelper.addCtaButton(mediaViewHolder.f21148f, mediaViewHolder.f21143a, videoNativeAd.getCallToAction());
        if (mediaViewHolder.f21144b != null) {
            NativeImageHelper.loadImageView(videoNativeAd.getMainImageUrl(), mediaViewHolder.f21144b.getMainImageView());
        }
        NativeImageHelper.loadImageView(videoNativeAd.getIconImageUrl(), mediaViewHolder.f21147e);
        NativeRendererHelper.addPrivacyInformationIcon(mediaViewHolder.f21149g, videoNativeAd.getPrivacyInformationIconImageUrl(), videoNativeAd.getPrivacyInformationIconClickThroughUrl());
        NativeRendererHelper.updateExtras(mediaViewHolder.f21143a, this.f20909b.f20809h, videoNativeAd.getExtras());
        if (mediaViewHolder.f21143a != null) {
            mediaViewHolder.f21143a.setVisibility(0);
        }
        videoNativeAd.render((MediaLayout) view.findViewById(this.f20909b.f20803b));
    }

    @Override // com.mopub.nativeads.MoPubAdRenderer
    public boolean supports(BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof VideoNativeAd;
    }
}
