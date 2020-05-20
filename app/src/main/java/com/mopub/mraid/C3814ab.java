package com.mopub.mraid;

import android.media.MediaPlayer;
import android.widget.ImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidVideoViewController.java */
/* renamed from: com.mopub.mraid.ab */
/* loaded from: classes.dex */
public final class C3814ab implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ MraidVideoViewController f20708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3814ab(MraidVideoViewController mraidVideoViewController) {
        this.f20708a = mraidVideoViewController;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        ImageButton imageButton;
        imageButton = this.f20708a.f20701b;
        imageButton.setVisibility(0);
        this.f20708a.videoError(false);
        return false;
    }
}
