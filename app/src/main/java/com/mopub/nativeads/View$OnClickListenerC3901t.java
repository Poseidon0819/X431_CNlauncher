package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.nativeads.MoPubCustomEventVideoNative;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.t */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3901t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3901t(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21167a = moPubVideoNativeAd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NativeVideoController nativeVideoController;
        NativeVideoController nativeVideoController2;
        Context context;
        MoPubCustomEventVideoNative.MoPubVideoNativeAd.m2150l(this.f21167a);
        nativeVideoController = this.f21167a.f20841l;
        nativeVideoController.m2121a();
        nativeVideoController2 = this.f21167a.f20841l;
        context = this.f21167a.f20832c;
        nativeVideoController2.handleCtaClick(context);
    }
}
