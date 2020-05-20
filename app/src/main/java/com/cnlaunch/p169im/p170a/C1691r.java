package com.cnlaunch.p169im.p170a;

import android.media.MediaPlayer;
import android.os.Handler;
import message.model.ChatMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayoutAdapter.java */
/* renamed from: com.cnlaunch.im.a.r */
/* loaded from: classes.dex */
public final class C1691r implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ LayoutAdapter f9017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1691r(LayoutAdapter layoutAdapter) {
        this.f9017a = layoutAdapter;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        ChatMessage chatMessage;
        Handler handler;
        chatMessage = this.f9017a.f8995h;
        chatMessage.f24068m = false;
        handler = this.f9017a.f8991c;
        handler.sendEmptyMessage(10000);
    }
}
