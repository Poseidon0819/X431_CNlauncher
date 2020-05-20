package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.VideoView;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.nativeads.NativeFullScreenVideoView;
import com.mopub.nativeads.NativeVideoController;

@TargetApi(16)
/* loaded from: classes2.dex */
public class NativeVideoViewController extends BaseVideoViewController implements AudioManager.OnAudioFocusChangeListener, TextureView.SurfaceTextureListener, NativeVideoController.Listener {

    /* renamed from: a */
    private EnumC3856a f20987a;

    /* renamed from: b */
    private VastVideoConfig f20988b;

    /* renamed from: c */
    private final NativeFullScreenVideoView f20989c;

    /* renamed from: d */
    private final NativeVideoController f20990d;

    /* renamed from: e */
    private Bitmap f20991e;

    /* renamed from: f */
    private boolean f20992f;

    /* renamed from: g */
    private boolean f20993g;

    /* renamed from: h */
    private int f20994h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.nativeads.NativeVideoViewController$a */
    /* loaded from: classes2.dex */
    public enum EnumC3856a {
        NONE,
        LOADING,
        BUFFERING,
        PAUSED,
        PLAYING,
        ENDED,
        FAILED_LOAD
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final VideoView getVideoView() {
        return null;
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onDestroy() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onPause() {
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m2110b(NativeVideoViewController nativeVideoViewController) {
        nativeVideoViewController.f20992f = false;
        return false;
    }

    public NativeVideoViewController(Context context, Bundle bundle, Bundle bundle2, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this(context, bundle, baseVideoViewControllerListener, new NativeFullScreenVideoView(context, context.getResources().getConfiguration().orientation, ((VastVideoConfig) bundle.get(Constants.NATIVE_VAST_VIDEO_CONFIG)).getCustomCtaText()));
    }

    @VisibleForTesting
    private NativeVideoViewController(Context context, Bundle bundle, BaseVideoViewController.BaseVideoViewControllerListener baseVideoViewControllerListener, NativeFullScreenVideoView nativeFullScreenVideoView) {
        super(context, null, baseVideoViewControllerListener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        Preconditions.checkNotNull(nativeFullScreenVideoView);
        this.f20987a = EnumC3856a.NONE;
        this.f20988b = (VastVideoConfig) bundle.get(Constants.NATIVE_VAST_VIDEO_CONFIG);
        this.f20989c = nativeFullScreenVideoView;
        this.f20990d = NativeVideoController.getForId(((Long) bundle.get(Constants.NATIVE_VIDEO_ID)).longValue());
        Preconditions.checkNotNull(this.f20988b);
        Preconditions.checkNotNull(this.f20990d);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onCreate() {
        this.f20989c.setSurfaceTextureListener(this);
        this.f20989c.setMode(NativeFullScreenVideoView.Mode.LOADING);
        this.f20989c.setPlayControlClickListener(new View$OnClickListenerC3872aq(this));
        this.f20989c.setCloseControlListener(new View$OnClickListenerC3873ar(this));
        this.f20989c.setCtaClickListener(new View$OnClickListenerC3874as(this));
        this.f20989c.setPrivacyInformationClickListener(new View$OnClickListenerC3875at(this));
        this.f20989c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mBaseVideoViewControllerListener.onSetContentView(this.f20989c);
        this.f20990d.setProgressListener(new C3876au(this));
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onResume() {
        Bitmap bitmap = this.f20991e;
        if (bitmap != null) {
            this.f20989c.setCachedVideoFrame(bitmap);
        }
        this.f20990d.prepare(this);
        this.f20990d.setListener(this);
        this.f20990d.setOnAudioFocusChangeListener(this);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onConfigurationChanged(Configuration configuration) {
        this.f20989c.setOrientation(configuration.orientation);
    }

    @Override // com.mopub.mobileads.BaseVideoViewController
    public final void onBackPressed() {
        m2113a(EnumC3856a.PAUSED, true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f20990d.setTextureView(this.f20989c.getTextureView());
        if (!this.f20992f) {
            NativeVideoController nativeVideoController = this.f20990d;
            nativeVideoController.seekTo(nativeVideoController.getCurrentPosition());
        }
        this.f20990d.setPlayWhenReady(!this.f20992f);
        if (this.f20990d.getDuration() - this.f20990d.getCurrentPosition() < 750) {
            this.f20992f = true;
            m2114a();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f20990d.release(this);
        m2113a(EnumC3856a.PAUSED, false);
        return true;
    }

    @Override // com.mopub.nativeads.NativeVideoController.Listener
    public void onStateChanged(boolean z, int i) {
        this.f20994h = i;
        m2114a();
    }

    @Override // com.mopub.nativeads.NativeVideoController.Listener
    public void onError(Exception exc) {
        MoPubLog.m2489w("Error playing back video.", exc);
        this.f20993g = true;
        m2114a();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i == -1 || i == -2) {
            m2113a(EnumC3856a.PAUSED, false);
        } else if (i == -3) {
            this.f20990d.setAudioVolume(0.3f);
        } else if (i == 1) {
            this.f20990d.setAudioVolume(1.0f);
            m2114a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0026, code lost:
        if (r1 != 6) goto L4;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2114a() {
        /*
            r3 = this;
            com.mopub.nativeads.NativeVideoViewController$a r0 = r3.f20987a
            boolean r1 = r3.f20993g
            if (r1 == 0) goto L9
            com.mopub.nativeads.NativeVideoViewController$a r0 = com.mopub.nativeads.NativeVideoViewController.EnumC3856a.FAILED_LOAD
            goto L2e
        L9:
            boolean r1 = r3.f20992f
            if (r1 != 0) goto L2c
            int r1 = r3.f20994h
            r2 = 2
            if (r1 == r2) goto L29
            r2 = 1
            if (r1 != r2) goto L16
            goto L29
        L16:
            r2 = 3
            if (r1 != r2) goto L1c
            com.mopub.nativeads.NativeVideoViewController$a r0 = com.mopub.nativeads.NativeVideoViewController.EnumC3856a.BUFFERING
            goto L2e
        L1c:
            r2 = 4
            if (r1 != r2) goto L22
            com.mopub.nativeads.NativeVideoViewController$a r0 = com.mopub.nativeads.NativeVideoViewController.EnumC3856a.PLAYING
            goto L2e
        L22:
            r2 = 5
            if (r1 == r2) goto L2c
            r2 = 6
            if (r1 != r2) goto L2e
            goto L2c
        L29:
            com.mopub.nativeads.NativeVideoViewController$a r0 = com.mopub.nativeads.NativeVideoViewController.EnumC3856a.LOADING
            goto L2e
        L2c:
            com.mopub.nativeads.NativeVideoViewController$a r0 = com.mopub.nativeads.NativeVideoViewController.EnumC3856a.ENDED
        L2e:
            r1 = 0
            r3.m2113a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.NativeVideoViewController.m2114a():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2113a(EnumC3856a enumC3856a, boolean z) {
        Preconditions.checkNotNull(enumC3856a);
        if (this.f20987a == enumC3856a) {
            return;
        }
        switch (enumC3856a) {
            case FAILED_LOAD:
                this.f20990d.setPlayWhenReady(false);
                this.f20990d.setAudioEnabled(false);
                this.f20990d.setAppAudioEnabled(false);
                this.f20989c.setMode(NativeFullScreenVideoView.Mode.LOADING);
                this.f20988b.handleError(this.mContext, null, 0);
                break;
            case LOADING:
            case BUFFERING:
                this.f20990d.setPlayWhenReady(true);
                this.f20989c.setMode(NativeFullScreenVideoView.Mode.LOADING);
                break;
            case PLAYING:
                this.f20990d.setPlayWhenReady(true);
                this.f20990d.setAudioEnabled(true);
                this.f20990d.setAppAudioEnabled(true);
                this.f20989c.setMode(NativeFullScreenVideoView.Mode.PLAYING);
                break;
            case PAUSED:
                if (!z) {
                    this.f20990d.setAppAudioEnabled(false);
                }
                this.f20990d.setPlayWhenReady(false);
                this.f20989c.setMode(NativeFullScreenVideoView.Mode.PAUSED);
                break;
            case ENDED:
                this.f20992f = true;
                this.f20990d.setAppAudioEnabled(false);
                this.f20989c.updateProgress(1000);
                this.f20989c.setMode(NativeFullScreenVideoView.Mode.FINISHED);
                this.f20988b.handleComplete(this.mContext, 0);
                break;
        }
        this.f20987a = enumC3856a;
    }
}
