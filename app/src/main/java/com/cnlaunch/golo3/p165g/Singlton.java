package com.cnlaunch.golo3.p165g;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cnlaunch.golo3.g.u */
/* loaded from: classes.dex */
public class Singlton {

    /* renamed from: a */
    static final /* synthetic */ boolean f8487a = !Singlton.class.desiredAssertionStatus();

    /* renamed from: b */
    private static Map<Object, Object> f8488b = new ConcurrentHashMap(32);

    /* renamed from: a */
    public static <T> T m9123a(Class<T> cls) {
        return (T) m9122a(cls, cls);
    }

    /* renamed from: a */
    private static <T> T m9122a(Class<T> cls, Class<? extends T> cls2) {
        T t = (T) f8488b.get(cls);
        if (t == null) {
            synchronized (cls) {
                if (t == null) {
                    try {
                        t = cls2.newInstance();
                        f8488b.put(cls, t);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("Singlton", e.toString());
                    }
                }
            }
        }
        return t;
    }
}
