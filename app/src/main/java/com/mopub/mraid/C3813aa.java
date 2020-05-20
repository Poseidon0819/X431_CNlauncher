package com.mopub.mraid;

import android.media.MediaPlayer;
import android.widget.ImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MraidVideoViewController.java */
/* renamed from: com.mopub.mraid.aa */
/* loaded from: classes.dex */
public final class C3813aa implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ MraidVideoViewController f20707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3813aa(MraidVideoViewController mraidVideoViewController) {
        this.f20707a = mraidVideoViewController;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        ImageButton imageButton;
        imageButton = this.f20707a.f20701b;
        imageButton.setVisibility(0);
        this.f20707a.videoCompleted(true);
    }
}
