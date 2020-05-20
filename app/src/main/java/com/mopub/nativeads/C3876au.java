package com.mopub.nativeads;

import com.mopub.nativeads.NativeVideoController;

/* compiled from: NativeVideoViewController.java */
/* renamed from: com.mopub.nativeads.au */
/* loaded from: classes2.dex */
final class C3876au implements NativeVideoController.NativeVideoProgressRunnable.ProgressListener {

    /* renamed from: a */
    final /* synthetic */ NativeVideoViewController f21084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3876au(NativeVideoViewController nativeVideoViewController) {
        this.f21084a = nativeVideoViewController;
    }

    @Override // com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener
    public final void updateProgress(int i) {
        NativeFullScreenVideoView nativeFullScreenVideoView;
        nativeFullScreenVideoView = this.f21084a.f20989c;
        nativeFullScreenVideoView.updateProgress(i);
    }
}
