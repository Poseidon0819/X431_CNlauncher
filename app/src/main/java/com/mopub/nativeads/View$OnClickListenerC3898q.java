package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.MoPubCustomEventVideoNative;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.q */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3898q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3898q(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21164a = moPubVideoNativeAd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MediaLayout mediaLayout;
        NativeVideoController nativeVideoController;
        mediaLayout = this.f21164a.f20843n;
        mediaLayout.resetProgress();
        nativeVideoController = this.f21164a.f20841l;
        nativeVideoController.seekTo(0L);
        this.f21164a.f20855z = false;
        this.f21164a.f20847r = false;
    }
}
