package com.cnlaunch.p169im.p173d;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.newgolo.manager.LightDownTimer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NoticeMessageHandler.java */
/* renamed from: com.cnlaunch.im.d.g */
/* loaded from: classes.dex */
public final class HandlerC1733g extends Handler {

    /* renamed from: a */
    final /* synthetic */ NoticeMessageHandler f9207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1733g(NoticeMessageHandler noticeMessageHandler) {
        this.f9207a = noticeMessageHandler;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        LightDownTimer lightDownTimer;
        LightDownTimer lightDownTimer2;
        LightDownTimer lightDownTimer3;
        LightDownTimer lightDownTimer4;
        LightDownTimer lightDownTimer5;
        int i = message2.what;
        if (i == 2) {
            try {
                Uri defaultUri = RingtoneManager.getDefaultUri(2);
                context = NoticeMessageHandler.f9197e;
                RingtoneManager.getRingtone(context, defaultUri).play();
            } catch (Exception e) {
                Log.e("Sanda", "notification NOTICE_SOUND..............." + e.toString());
                e.printStackTrace();
            }
        } else if (i == 4) {
            lightDownTimer = this.f9207a.f9202g;
            if (lightDownTimer != null) {
                lightDownTimer4 = this.f9207a.f9202g;
                GoloLightManager.m8495c();
                Log.i(lightDownTimer4.f9690a, "GoloLightManager close()");
                lightDownTimer5 = this.f9207a.f9202g;
                lightDownTimer5.cancel();
                this.f9207a.f9202g = null;
            }
            this.f9207a.f9202g = new LightDownTimer();
            lightDownTimer2 = this.f9207a.f9202g;
            GoloLightManager.m8496b();
            Log.i(lightDownTimer2.f9690a, "GoloLightManager.open()");
            lightDownTimer3 = this.f9207a.f9202g;
            lightDownTimer3.start();
            return;
        }
        super.handleMessage(message2);
    }
}
