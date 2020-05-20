package com.cnlaunch.x431pro.activity.golo.function;

import android.media.MediaPlayer;

/* compiled from: VideoPlayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.h */
/* loaded from: classes.dex */
final class C2241h implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ VideoPlayFragment f12674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2241h(VideoPlayFragment videoPlayFragment) {
        this.f12674a = videoPlayFragment;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
    }
}
