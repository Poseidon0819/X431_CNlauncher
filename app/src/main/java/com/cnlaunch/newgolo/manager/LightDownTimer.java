package com.cnlaunch.newgolo.manager;

import android.os.CountDownTimer;
import android.util.Log;

/* renamed from: com.cnlaunch.newgolo.manager.a */
/* loaded from: classes.dex */
public final class LightDownTimer extends CountDownTimer {

    /* renamed from: a */
    public String f9690a;

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
    }

    public LightDownTimer() {
        super(30000L, 1000L);
        this.f9690a = "LightDownTimer";
        GoloLightManager.m8498a();
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        GoloLightManager.m8495c();
        Log.i(this.f9690a, "GoloLightManager.close() onFinish");
    }
}
