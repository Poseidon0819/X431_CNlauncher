package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.w */
/* loaded from: classes.dex */
public final class X431ReplayDataStreamManager extends ReplayDataStreamManager {

    /* renamed from: h */
    private Handler f11827h;

    /* compiled from: X431ReplayDataStreamManager.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.w$a */
    /* loaded from: classes.dex */
    static class HandlerC2102a extends Handler {

        /* renamed from: a */
        private WeakReference<ReplayDataStreamManager> f11828a;

        HandlerC2102a(ReplayDataStreamManager replayDataStreamManager) {
            this.f11828a = new WeakReference<>(replayDataStreamManager);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            ReplayDataStreamManager replayDataStreamManager = this.f11828a.get();
            if (replayDataStreamManager == null || message2.what != 1) {
                return;
            }
            replayDataStreamManager.m7352b();
        }
    }

    public X431ReplayDataStreamManager(List<ArrayList<BasicDataStreamBean>> list) {
        super(list);
        this.f11827h = new HandlerC2102a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager
    /* renamed from: a */
    final void mo7329a() {
        this.f11827h.sendMessageDelayed(this.f11827h.obtainMessage(1), 0L);
    }
}
