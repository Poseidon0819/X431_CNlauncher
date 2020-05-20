package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.mapsdkplatform.comjni.engine.C1305a;

/* loaded from: classes.dex */
public class MessageCenter {
    public static void registMessage(int i, Handler handler) {
        C1305a.m10051a(i, handler);
    }

    public static void unregistMessage(int i, Handler handler) {
        C1305a.m10050b(i, handler);
    }
}
