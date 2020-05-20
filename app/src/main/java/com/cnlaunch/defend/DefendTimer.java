package com.cnlaunch.defend;

import android.content.Context;
import java.util.Timer;

/* renamed from: com.cnlaunch.defend.c */
/* loaded from: classes.dex */
public final class DefendTimer extends Timer {

    /* renamed from: a */
    private DefendTask f7263a;

    public DefendTimer(Context context, String str, String str2, int i) {
        this.f7263a = null;
        this.f7263a = new DefendTask(context, str, str2, i);
    }

    /* renamed from: a */
    public final void m9428a() {
        DefendTask defendTask = this.f7263a;
        if (defendTask != null) {
            schedule(defendTask, 2000L, 10000L);
        }
    }

    /* renamed from: b */
    public final void m9427b() {
        try {
            cancel();
            if (this.f7263a != null) {
                this.f7263a.cancel();
                this.f7263a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
