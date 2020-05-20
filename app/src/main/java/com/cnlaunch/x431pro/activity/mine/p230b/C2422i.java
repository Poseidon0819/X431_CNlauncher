package com.cnlaunch.x431pro.activity.mine.p230b;

import android.os.Handler;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import java.util.ArrayList;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.i */
/* loaded from: classes.dex */
public final class C2422i extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DataStreamReplayFragment f13789a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2422i(DataStreamReplayFragment dataStreamReplayFragment) {
        this.f13789a = dataStreamReplayFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Handler handler;
        int i5;
        Handler handler2;
        int i6;
        ArrayList arrayList;
        int i7;
        ArrayList arrayList2;
        int i8;
        ReplayDataStreamManager replayDataStreamManager;
        Handler handler3;
        z = this.f13789a.f13733E;
        if (z) {
            i = this.f13789a.f13735G;
            i2 = this.f13789a.f13730B;
            if (i < i2 - 1) {
                i5 = this.f13789a.f13735G;
                if (i5 == 0) {
                    if (1 == this.f13789a.f13740L) {
                        handler3 = this.f13789a.f13754Z;
                        handler3.obtainMessage(2).sendToTarget();
                    } else {
                        replayDataStreamManager = this.f13789a.f13770p;
                        replayDataStreamManager.m7347d();
                    }
                }
                handler2 = this.f13789a.f13754Z;
                i6 = this.f13789a.f13735G;
                handler2.obtainMessage(1, Integer.valueOf(i6 + 1)).sendToTarget();
                arrayList = this.f13789a.f13773s;
                int size = arrayList.size();
                i7 = this.f13789a.f13735G;
                if (size >= i7) {
                    DataStreamReplayFragment dataStreamReplayFragment = this.f13789a;
                    arrayList2 = dataStreamReplayFragment.f13773s;
                    i8 = this.f13789a.f13735G;
                    DataStreamReplayFragment.m6401a(dataStreamReplayFragment, (ArrayList) arrayList2.get(i8));
                }
                DataStreamReplayFragment.m6382l(this.f13789a);
                return;
            }
            i3 = this.f13789a.f13735G;
            i4 = this.f13789a.f13730B;
            if (i3 == i4 - 1) {
                handler = this.f13789a.f13754Z;
                handler.obtainMessage(0).sendToTarget();
                this.f13789a.f13735G = 0;
                this.f13789a.m6392c();
            }
        }
    }
}
