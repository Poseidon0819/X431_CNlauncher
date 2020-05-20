package com.cnlaunch.p169im.p173d;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p169im.p176f.ChatManager;
import java.io.IOException;
import java.util.ArrayList;
import message.model.ChatMessage;

/* renamed from: com.cnlaunch.im.d.a */
/* loaded from: classes.dex */
public class AutoVoiceHandler extends Handler {

    /* renamed from: c */
    public static boolean f9188c = false;

    /* renamed from: f */
    private static AutoVoiceHandler f9189f;

    /* renamed from: e */
    private Context f9193e;

    /* renamed from: a */
    public MediaPlayer f9190a = new MediaPlayer();

    /* renamed from: b */
    public ArrayList<ChatMessage> f9191b = new ArrayList<>();

    /* renamed from: g */
    private MediaPlayer.OnCompletionListener f9194g = new C1731b(this);

    /* renamed from: d */
    public GoloHandler f9192d = null;

    private AutoVoiceHandler(Context context) {
        this.f9193e = context;
    }

    /* renamed from: a */
    public static AutoVoiceHandler m8789a(Context context) {
        AutoVoiceHandler autoVoiceHandler;
        synchronized (AutoVoiceHandler.class) {
            if (f9189f == null) {
                f9189f = new AutoVoiceHandler(context);
            }
            autoVoiceHandler = f9189f;
        }
        return autoVoiceHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        if (message2.what == 102) {
            if (this.f9190a.isPlaying()) {
                return;
            }
            try {
                this.f9190a.reset();
                this.f9190a.setDataSource(this.f9191b.get(0).m197k());
                this.f9190a.setOnCompletionListener(this.f9194g);
                this.f9190a.prepare();
                this.f9190a.start();
                this.f9191b.get(0).m193o();
                ChatManager.m8741a(this.f9193e).m8736b(this.f9191b.get(0));
                this.f9191b.remove(0);
                if (this.f9192d != null) {
                    this.f9192d.obtainMessage(10000).sendToTarget();
                    return;
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        super.handleMessage(message2);
    }
}
