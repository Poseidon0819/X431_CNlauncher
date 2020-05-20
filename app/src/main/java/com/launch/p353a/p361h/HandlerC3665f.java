package com.launch.p353a.p361h;

import android.os.Handler;
import android.os.Message;
import com.launch.p353a.p362i.IHttpFinishedListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoader.java */
/* renamed from: com.launch.a.h.f */
/* loaded from: classes.dex */
public final class HandlerC3665f extends Handler {

    /* renamed from: a */
    final /* synthetic */ RunnableC3664e f19965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC3665f(RunnableC3664e runnableC3664e) {
        this.f19965a = runnableC3664e;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IHttpFinishedListener iHttpFinishedListener;
        IHttpFinishedListener iHttpFinishedListener2;
        if (message2.what != 0) {
            return;
        }
        iHttpFinishedListener = this.f19965a.f19961f;
        if (iHttpFinishedListener != null) {
            iHttpFinishedListener2 = this.f19965a.f19961f;
            iHttpFinishedListener2.mo2650a(this.f19965a.f19962g);
        }
    }
}
