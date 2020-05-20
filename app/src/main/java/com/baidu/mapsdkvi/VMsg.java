package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public class VMsg {

    /* renamed from: a */
    private static final String f6448a = "VMsg";

    /* renamed from: b */
    private static Handler f6449b;

    /* renamed from: c */
    private static HandlerThread f6450c;

    /* renamed from: d */
    private static VMsg f6451d = new VMsg();

    /* renamed from: com.baidu.mapsdkvi.VMsg$a */
    /* loaded from: classes.dex */
    static class HandlerC1315a extends Handler {
        public HandlerC1315a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            VMsg.OnUserCommand1(message2.what, message2.arg1, message2.arg2, message2.obj == null ? 0L : ((Long) message2.obj).longValue());
        }
    }

    public static native void InitClass(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void OnUserCommand1(int i, int i2, int i3, long j);

    public static void destroy() {
        f6450c.quit();
        f6450c = null;
        f6449b.removeCallbacksAndMessages(null);
        f6449b = null;
    }

    public static VMsg getInstance() {
        return f6451d;
    }

    public static void init() {
        HandlerThread handlerThread = new HandlerThread("VIMsgThread");
        f6450c = handlerThread;
        handlerThread.start();
        f6449b = new HandlerC1315a(f6450c.getLooper());
    }

    private static void postMessage(int i, int i2, int i3, long j) {
        Handler handler = f6449b;
        if (handler == null) {
            return;
        }
        Message.obtain(handler, i, i2, i3, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
