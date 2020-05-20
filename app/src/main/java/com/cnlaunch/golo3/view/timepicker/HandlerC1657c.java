package com.cnlaunch.golo3.view.timepicker;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

/* compiled from: WheelView.java */
/* renamed from: com.cnlaunch.golo3.view.timepicker.c */
/* loaded from: classes.dex */
final class HandlerC1657c extends Handler {

    /* renamed from: a */
    final /* synthetic */ WheelView f8777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1657c(WheelView wheelView) {
        this.f8777a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Scroller scroller;
        Scroller scroller2;
        int i;
        Scroller scroller3;
        Scroller scroller4;
        Handler handler;
        Scroller scroller5;
        Scroller scroller6;
        scroller = this.f8777a.f8745D;
        scroller.computeScrollOffset();
        scroller2 = this.f8777a.f8745D;
        int currY = scroller2.getCurrY();
        i = this.f8777a.f8746E;
        int i2 = i - currY;
        this.f8777a.f8746E = currY;
        if (i2 != 0) {
            WheelView.m9007a(this.f8777a, i2);
        }
        scroller3 = this.f8777a.f8745D;
        if (Math.abs(currY - scroller3.getFinalY()) <= 0) {
            scroller5 = this.f8777a.f8745D;
            scroller5.getFinalY();
            scroller6 = this.f8777a.f8745D;
            scroller6.forceFinished(true);
        }
        scroller4 = this.f8777a.f8745D;
        if (!scroller4.isFinished()) {
            handler = this.f8777a.f8752K;
            handler.sendEmptyMessage(message2.what);
        } else if (message2.what == 0) {
            this.f8777a.m8997e();
        } else {
            this.f8777a.m9010a();
        }
    }
}
