package com.cnlaunch.x431pro.activity.mine.p230b;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import com.cnlaunch.x431pro.widget.progress.Slider;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.j */
/* loaded from: classes.dex */
final class HandlerC2423j extends Handler {

    /* renamed from: a */
    final /* synthetic */ DataStreamReplayFragment f13790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2423j(DataStreamReplayFragment dataStreamReplayFragment) {
        this.f13790a = dataStreamReplayFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Button button;
        TextView textView;
        int i;
        Slider slider;
        int i2;
        int i3;
        ReplayDataStreamManager replayDataStreamManager;
        ArrayList arrayList;
        int i4;
        ArrayList arrayList2;
        int i5;
        switch (message2.what) {
            case 0:
                DataStreamReplayFragment.m6368z(this.f13790a);
                button = this.f13790a.f13760f;
                button.setBackgroundResource(R.drawable.btn_replay_play);
                return;
            case 1:
                textView = this.f13790a.f13763i;
                StringBuilder sb = new StringBuilder();
                sb.append(message2.obj.toString());
                sb.append("/");
                i = this.f13790a.f13730B;
                sb.append(i - 1);
                textView.setText(sb.toString());
                slider = this.f13790a.f13765k;
                i2 = this.f13790a.f13735G;
                slider.setValue(i2);
                i3 = this.f13790a.f13735G;
                if (i3 == 0) {
                    replayDataStreamManager = this.f13790a.f13770p;
                    replayDataStreamManager.m7347d();
                    arrayList = this.f13790a.f13773s;
                    int size = arrayList.size();
                    i4 = this.f13790a.f13735G;
                    if (size >= i4) {
                        DataStreamReplayFragment dataStreamReplayFragment = this.f13790a;
                        arrayList2 = dataStreamReplayFragment.f13773s;
                        i5 = this.f13790a.f13735G;
                        DataStreamReplayFragment.m6401a(dataStreamReplayFragment, (ArrayList) arrayList2.get(i5));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (1 == this.f13790a.f13740L) {
                    this.f13790a.f13755a.mo6305a();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
