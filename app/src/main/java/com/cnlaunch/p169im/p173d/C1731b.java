package com.cnlaunch.p169im.p173d;

import android.content.Context;
import android.media.MediaPlayer;
import com.cnlaunch.p169im.p176f.ChatManager;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoVoiceHandler.java */
/* renamed from: com.cnlaunch.im.d.b */
/* loaded from: classes.dex */
public final class C1731b implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ AutoVoiceHandler f9195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1731b(AutoVoiceHandler autoVoiceHandler) {
        this.f9195a = autoVoiceHandler;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer.OnCompletionListener onCompletionListener;
        Context context;
        GoloHandler goloHandler;
        GoloHandler goloHandler2;
        if (this.f9195a.f9191b.size() > 0) {
            try {
                this.f9195a.f9190a.reset();
                this.f9195a.f9190a.setDataSource(this.f9195a.f9191b.get(0).m197k());
                MediaPlayer mediaPlayer2 = this.f9195a.f9190a;
                onCompletionListener = this.f9195a.f9194g;
                mediaPlayer2.setOnCompletionListener(onCompletionListener);
                this.f9195a.f9190a.prepare();
                this.f9195a.f9190a.start();
                this.f9195a.f9191b.get(0).m193o();
                context = this.f9195a.f9193e;
                ChatManager.m8741a(context).m8736b(this.f9195a.f9191b.get(0));
                this.f9195a.f9191b.remove(0);
                goloHandler = this.f9195a.f9192d;
                if (goloHandler != null) {
                    goloHandler2 = this.f9195a.f9192d;
                    goloHandler2.obtainMessage(10000).sendToTarget();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
