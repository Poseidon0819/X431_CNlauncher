package com.cnlaunch.p169im.p173d;

import android.os.Handler;
import message.model.ChatMessage;

/* compiled from: NoticeMessageHandler.java */
/* renamed from: com.cnlaunch.im.d.f */
/* loaded from: classes.dex */
public final class RunnableC1732f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f9204a;

    /* renamed from: b */
    final /* synthetic */ ChatMessage f9205b;

    /* renamed from: c */
    final /* synthetic */ NoticeMessageHandler f9206c;

    public RunnableC1732f(NoticeMessageHandler noticeMessageHandler, int i, ChatMessage chatMessage) {
        this.f9206c = noticeMessageHandler;
        this.f9204a = i;
        this.f9205b = chatMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        if ((this.f9204a & 1) == 1) {
            NoticeMessageHandler.m8780a(this.f9206c, this.f9205b);
        }
        if (this.f9204a == 2) {
            handler3 = this.f9206c.f9203h;
            handler3.obtainMessage(2).sendToTarget();
        }
        if ((this.f9204a & 4) == 4) {
            handler = this.f9206c.f9203h;
            handler.removeMessages(4);
            handler2 = this.f9206c.f9203h;
            handler2.sendEmptyMessageDelayed(4, 50L);
        }
    }
}
