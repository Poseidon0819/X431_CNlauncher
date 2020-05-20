package com.mopub.nativeads;

import android.os.Handler;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.NativeAdSource;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NativeAdSource.java */
/* renamed from: com.mopub.nativeads.ah */
/* loaded from: classes2.dex */
public final class C3864ah implements MoPubNative.MoPubNativeNetworkListener {

    /* renamed from: a */
    final /* synthetic */ NativeAdSource f21062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3864ah(NativeAdSource nativeAdSource) {
        this.f21062a = nativeAdSource;
    }

    @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
    public final void onNativeLoad(NativeAd nativeAd) {
        MoPubNative moPubNative;
        List list;
        List list2;
        NativeAdSource.InterfaceC3862a interfaceC3862a;
        NativeAdSource.InterfaceC3862a interfaceC3862a2;
        moPubNative = this.f21062a.f21056i;
        if (moPubNative == null) {
            return;
        }
        NativeAdSource nativeAdSource = this.f21062a;
        nativeAdSource.f21050c = false;
        nativeAdSource.f21052e++;
        NativeAdSource nativeAdSource2 = this.f21062a;
        nativeAdSource2.f21053f = 0;
        list = nativeAdSource2.f21058k;
        list.add(new TimestampWrapper(nativeAd));
        list2 = this.f21062a.f21058k;
        if (list2.size() == 1) {
            interfaceC3862a = this.f21062a.f21054g;
            if (interfaceC3862a != null) {
                interfaceC3862a2 = this.f21062a.f21054g;
                interfaceC3862a2.onAdsAvailable();
            }
        }
        this.f21062a.m2088c();
    }

    @Override // com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener
    public final void onNativeFail(NativeErrorCode nativeErrorCode) {
        Handler handler;
        Runnable runnable;
        NativeAdSource nativeAdSource = this.f21062a;
        nativeAdSource.f21050c = false;
        if (nativeAdSource.f21053f < NativeAdSource.f21048a.length - 1) {
            NativeAdSource nativeAdSource2 = this.f21062a;
            if (nativeAdSource2.f21053f < NativeAdSource.f21048a.length - 1) {
                nativeAdSource2.f21053f++;
            }
            NativeAdSource nativeAdSource3 = this.f21062a;
            nativeAdSource3.f21051d = true;
            handler = nativeAdSource3.f21059l;
            runnable = this.f21062a.f21060m;
            NativeAdSource nativeAdSource4 = this.f21062a;
            if (nativeAdSource4.f21053f >= NativeAdSource.f21048a.length) {
                nativeAdSource4.f21053f = NativeAdSource.f21048a.length - 1;
            }
            handler.postDelayed(runnable, NativeAdSource.f21048a[nativeAdSource4.f21053f]);
            return;
        }
        this.f21062a.f21053f = 0;
    }
}
