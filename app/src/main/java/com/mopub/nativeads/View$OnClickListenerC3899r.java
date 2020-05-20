package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.MoPubCustomEventVideoNative;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.r */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3899r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3899r(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21165a = moPubVideoNativeAd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd = this.f21165a;
        z = moPubVideoNativeAd.f20854y;
        moPubVideoNativeAd.f20854y = !z;
        this.f21165a.m2159e();
    }
}
