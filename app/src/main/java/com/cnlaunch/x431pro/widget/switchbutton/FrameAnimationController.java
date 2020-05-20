package com.cnlaunch.x431pro.widget.switchbutton;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.cnlaunch.x431pro.widget.switchbutton.a */
/* loaded from: classes.dex */
public final class FrameAnimationController {

    /* renamed from: a */
    private static final Handler f16956a = new HandlerC2979a((byte) 0);

    /* renamed from: a */
    public static void m4285a(Runnable runnable) {
        Message message2 = new Message();
        message2.what = 1000;
        message2.obj = runnable;
        f16956a.sendMessageDelayed(message2, 16L);
    }

    /* compiled from: FrameAnimationController.java */
    /* renamed from: com.cnlaunch.x431pro.widget.switchbutton.a$a */
    /* loaded from: classes.dex */
    static class HandlerC2979a extends Handler {
        private HandlerC2979a() {
        }

        /* synthetic */ HandlerC2979a(byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message2) {
            if (message2.what == 1000 && message2.obj != null) {
                ((Runnable) message2.obj).run();
            }
        }
    }
}
