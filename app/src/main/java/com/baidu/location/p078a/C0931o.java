package com.baidu.location.p078a;

import android.os.HandlerThread;

/* renamed from: com.baidu.location.a.o */
/* loaded from: classes.dex */
public class C0931o {

    /* renamed from: a */
    private static HandlerThread f4089a;

    /* renamed from: a */
    public static synchronized HandlerThread m12049a() {
        HandlerThread handlerThread;
        synchronized (C0931o.class) {
            if (f4089a == null) {
                HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                f4089a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f4089a;
        }
        return handlerThread;
    }
}
