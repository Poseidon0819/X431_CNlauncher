package com.cnlaunch.x431pro.activity.mine.p230b;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: DataStreamReplayFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.d */
/* loaded from: classes.dex */
final class View$OnTouchListenerC2417d implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DataStreamReplayFragment f13784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2417d(DataStreamReplayFragment dataStreamReplayFragment) {
        this.f13784a = dataStreamReplayFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13784a.f13733E = false;
        } else if (motionEvent.getAction() == 1) {
            this.f13784a.f13733E = true;
        }
        return false;
    }
}
