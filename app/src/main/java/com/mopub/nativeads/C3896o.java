package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.event.EventDetails;
import com.mopub.mobileads.VastManager;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventVideoNative;
import com.mopub.nativeads.NativeImageHelper;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.o */
/* loaded from: classes2.dex */
final class C3896o implements NativeImageHelper.ImageListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3896o(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21162a = moPubVideoNativeAd;
    }

    @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
    public final void onImagesCached() {
        VastManager vastManager;
        EventDetails eventDetails;
        EventDetails eventDetails2;
        String dspCreativeId;
        Context context;
        vastManager = this.f21162a.f20842m;
        String vastVideo = this.f21162a.getVastVideo();
        MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd = this.f21162a;
        eventDetails = moPubVideoNativeAd.f20845p;
        if (eventDetails == null) {
            dspCreativeId = null;
        } else {
            eventDetails2 = this.f21162a.f20845p;
            dspCreativeId = eventDetails2.getDspCreativeId();
        }
        context = this.f21162a.f20832c;
        vastManager.prepareVastVideoConfiguration(vastVideo, moPubVideoNativeAd, dspCreativeId, context);
    }

    @Override // com.mopub.nativeads.NativeImageHelper.ImageListener
    public final void onImagesFailedToCache(NativeErrorCode nativeErrorCode) {
        CustomEventNative.CustomEventNativeListener customEventNativeListener;
        customEventNativeListener = this.f21162a.f20838i;
        customEventNativeListener.onNativeAdFailed(nativeErrorCode);
    }
}
