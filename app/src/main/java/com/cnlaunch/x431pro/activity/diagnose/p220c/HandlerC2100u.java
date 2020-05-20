package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.p112a.DataStreamGraphicalView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleLargeGraph.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.u */
/* loaded from: classes.dex */
public final class HandlerC2100u extends Handler {

    /* renamed from: a */
    final /* synthetic */ SingleLargeGraph f11824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2100u(SingleLargeGraph singleLargeGraph) {
        this.f11824a = singleLargeGraph;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        DataStreamGraphicalView dataStreamGraphicalView;
        Handler handler;
        DataStreamGraphicalView dataStreamGraphicalView2;
        if (message2.what == 0) {
            dataStreamGraphicalView = this.f11824a.f11810m;
            if (dataStreamGraphicalView != null) {
                dataStreamGraphicalView2 = this.f11824a.f11810m;
                dataStreamGraphicalView2.invalidate();
            }
            handler = this.f11824a.f11796F;
            handler.sendEmptyMessageDelayed(0, 100L);
            return;
        }
        super.handleMessage(message2);
    }
}
