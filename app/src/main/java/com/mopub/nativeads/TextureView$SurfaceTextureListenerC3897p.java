package com.mopub.nativeads;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.mopub.nativeads.MoPubCustomEventVideoNative;

/* compiled from: MoPubCustomEventVideoNative.java */
/* renamed from: com.mopub.nativeads.p */
/* loaded from: classes2.dex */
final class TextureView$SurfaceTextureListenerC3897p implements TextureView.SurfaceTextureListener {

    /* renamed from: a */
    final /* synthetic */ MoPubCustomEventVideoNative.MoPubVideoNativeAd f21163a;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureView$SurfaceTextureListenerC3897p(MoPubCustomEventVideoNative.MoPubVideoNativeAd moPubVideoNativeAd) {
        this.f21163a = moPubVideoNativeAd;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        NativeVideoController nativeVideoController;
        NativeVideoController nativeVideoController2;
        NativeVideoController nativeVideoController3;
        NativeVideoController nativeVideoController4;
        MediaLayout mediaLayout;
        MediaLayout mediaLayout2;
        NativeVideoController nativeVideoController5;
        NativeVideoController nativeVideoController6;
        int i3;
        boolean z;
        NativeVideoController nativeVideoController7;
        nativeVideoController = this.f21163a.f20841l;
        nativeVideoController.setListener(this.f21163a);
        nativeVideoController2 = this.f21163a.f20841l;
        nativeVideoController2.setOnAudioFocusChangeListener(this.f21163a);
        nativeVideoController3 = this.f21163a.f20841l;
        nativeVideoController3.setProgressListener(this.f21163a);
        nativeVideoController4 = this.f21163a.f20841l;
        mediaLayout = this.f21163a.f20843n;
        nativeVideoController4.setTextureView(mediaLayout.getTextureView());
        mediaLayout2 = this.f21163a.f20843n;
        mediaLayout2.resetProgress();
        nativeVideoController5 = this.f21163a.f20841l;
        long duration = nativeVideoController5.getDuration();
        nativeVideoController6 = this.f21163a.f20841l;
        long currentPosition = nativeVideoController6.getCurrentPosition();
        i3 = this.f21163a.f20851v;
        if (i3 == 5 || (duration > 0 && duration - currentPosition < 750)) {
            this.f21163a.f20855z = true;
        }
        z = this.f21163a.f20848s;
        if (z) {
            this.f21163a.f20848s = false;
            nativeVideoController7 = this.f21163a.f20841l;
            nativeVideoController7.prepare(this.f21163a);
        }
        this.f21163a.f20847r = true;
        this.f21163a.m2159e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        NativeVideoController nativeVideoController;
        this.f21163a.f20848s = true;
        nativeVideoController = this.f21163a.f20841l;
        nativeVideoController.release(this.f21163a);
        this.f21163a.m2172a(MoPubCustomEventVideoNative.MoPubVideoNativeAd.VideoState.PAUSED, false);
        return true;
    }
}
