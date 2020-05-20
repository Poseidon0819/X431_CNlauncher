package com.mopub.mobileads;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VastVideoViewController.java */
/* renamed from: com.mopub.mobileads.bb */
/* loaded from: classes.dex */
public final class C3765bb implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ VastVideoView f20559a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f20560b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3765bb(VastVideoViewController vastVideoViewController, VastVideoView vastVideoView) {
        this.f20560b = vastVideoViewController;
        this.f20559a = vastVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        VastVideoConfig vastVideoConfig;
        VastVideoConfig vastVideoConfig2;
        VastVideoView vastVideoView = this.f20559a;
        vastVideoConfig = this.f20560b.f20466j;
        if (vastVideoView.m2368a(mediaPlayer, i, i2, vastVideoConfig.getDiskMediaFileUrl())) {
            return true;
        }
        this.f20560b.m2357c();
        this.f20560b.m2367a();
        this.f20560b.videoError(false);
        VastVideoViewController.m2335x(this.f20560b);
        vastVideoConfig2 = this.f20560b.f20466j;
        vastVideoConfig2.handleError(this.f20560b.mContext, VastErrorCode.GENERAL_LINEAR_AD_ERROR, this.f20560b.f20457a.getCurrentPosition());
        return false;
    }
}
