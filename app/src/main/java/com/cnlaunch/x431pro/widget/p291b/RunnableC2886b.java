package com.cnlaunch.x431pro.widget.p291b;

import android.util.Log;

/* compiled from: TimerView.java */
/* renamed from: com.cnlaunch.x431pro.widget.b.b */
/* loaded from: classes.dex */
public final class RunnableC2886b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TimerView f16493a;

    public RunnableC2886b(TimerView timerView) {
        this.f16493a = timerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.f16493a.f16491a.isCancelled()) {
                this.f16493a.f16491a.cancel(true);
            }
        } catch (Exception e) {
            Log.e("TimeView", e.toString());
        }
        this.f16493a.f16492b.sendEmptyMessage(2);
    }
}
