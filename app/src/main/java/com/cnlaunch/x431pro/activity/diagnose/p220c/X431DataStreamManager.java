package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.v */
/* loaded from: classes.dex */
public final class X431DataStreamManager extends DataStreamManager {

    /* renamed from: m */
    private Handler f11825m;

    /* compiled from: X431DataStreamManager.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.v$a */
    /* loaded from: classes.dex */
    static class HandlerC2101a extends Handler {

        /* renamed from: a */
        private WeakReference<DataStreamManager> f11826a;

        HandlerC2101a(DataStreamManager dataStreamManager) {
            this.f11826a = new WeakReference<>(dataStreamManager);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            DataStreamManager dataStreamManager = this.f11826a.get();
            if (dataStreamManager == null || message2.what != 1) {
                return;
            }
            dataStreamManager.m7385b();
        }
    }

    public X431DataStreamManager(List<ArrayList<BasicDataStreamBean>> list) {
        super(list);
        this.f11825m = new HandlerC2101a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager
    /* renamed from: a */
    final void mo7330a() {
        this.f11825m.sendMessageDelayed(this.f11825m.obtainMessage(1), 0L);
    }
}
