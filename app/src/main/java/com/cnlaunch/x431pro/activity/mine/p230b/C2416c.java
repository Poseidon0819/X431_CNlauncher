package com.cnlaunch.x431pro.activity.mine.p230b;

import android.os.Handler;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import com.cnlaunch.x431pro.widget.progress.Slider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.c */
/* loaded from: classes.dex */
final class C2416c implements Slider.InterfaceC2921d {

    /* renamed from: a */
    final /* synthetic */ DataStreamReplayFragment f13783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2416c(DataStreamReplayFragment dataStreamReplayFragment) {
        this.f13783a = dataStreamReplayFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.progress.Slider.InterfaceC2921d
    /* renamed from: a */
    public final void mo4476a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        Handler handler;
        int i6;
        int i7;
        Handler handler2;
        int i8;
        ReplayDataStreamManager replayDataStreamManager;
        ArrayList arrayList;
        int i9;
        int i10;
        this.f13783a.f13735G = i;
        i2 = this.f13783a.f13735G;
        i3 = this.f13783a.f13730B;
        if (i2 < i3 - 1) {
            i7 = this.f13783a.f13735G;
            if (i7 > 0) {
                replayDataStreamManager = this.f13783a.f13770p;
                arrayList = this.f13783a.f13773s;
                i9 = this.f13783a.f13735G;
                List<ArrayList<BasicDataStreamBean>> subList = arrayList.subList(0, i9);
                i10 = this.f13783a.f13735G;
                replayDataStreamManager.m7354a(subList, i10);
            }
            handler2 = this.f13783a.f13754Z;
            i8 = this.f13783a.f13735G;
            handler2.obtainMessage(1, Integer.valueOf(i8)).sendToTarget();
            return;
        }
        i4 = this.f13783a.f13735G;
        i5 = this.f13783a.f13730B;
        if (i4 == i5 - 1) {
            this.f13783a.f13735G = 0;
            handler = this.f13783a.f13754Z;
            i6 = this.f13783a.f13735G;
            handler.obtainMessage(1, Integer.valueOf(i6)).sendToTarget();
        }
    }
}
