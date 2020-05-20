package com.baidu.mapsdkplatform.comjni.engine;

import android.content.Context;

/* loaded from: classes.dex */
public class JNIEngine {
    public static native boolean InitEngine(Context context);

    public static native void SetProxyInfo(String str, int i);

    public static native boolean StartSocketProc();

    public static native boolean UnInitEngine();

    public static native int initClass(Object obj, int i);
}
