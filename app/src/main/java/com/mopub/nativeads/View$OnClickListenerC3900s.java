package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.nativeads.MoPubCustomEventVideoNative;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.s */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3900s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3900s(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21166a = moPubVideoNativeAd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NativeVideoController nativeVideoController;
        Context context;
        long j;
        MoPubCustomEventVideoNative.MoPubVideoNativeAd.m2150l(this.f21166a);
        nativeVideoController = this.f21166a.f20841l;
        nativeVideoController.m2121a();
        context = this.f21166a.f20832c;
        j = this.f21166a.f20846q;
        MraidVideoPlayerActivity.startNativeVideo(context, j, this.f21166a.f20834e);
    }
}
