package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class JNIInitializer {

    /* renamed from: a */
    private static Context f4862a;

    public static Context getCachedContext() {
        return f4862a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f4862a == null) {
            f4862a = application;
        }
    }
}
