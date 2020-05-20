package com.mopub.nativeads;

import android.view.View;
import com.mopub.nativeads.NativeVideoViewController;

/* compiled from: NativeVideoViewController.java */
/* renamed from: com.mopub.nativeads.aq */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3872aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f21080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3872aq(NativeVideoViewController nativeVideoViewController) {
        this.f21080a = nativeVideoViewController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        NativeFullScreenVideoView nativeFullScreenVideoView;
        NativeVideoController nativeVideoController;
        z = this.f21080a.f20992f;
        if (z) {
            NativeVideoViewController.m2110b(this.f21080a);
            nativeFullScreenVideoView = this.f21080a.f20989c;
            nativeFullScreenVideoView.resetProgress();
            nativeVideoController = this.f21080a.f20990d;
            nativeVideoController.seekTo(0L);
        }
        this.f21080a.m2113a(NativeVideoViewController.EnumC3856a.PLAYING, false);
    }
}
