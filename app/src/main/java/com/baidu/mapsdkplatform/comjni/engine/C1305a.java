package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.mapsdkplatform.comjni.engine.a */
/* loaded from: classes.dex */
public class C1305a {

    /* renamed from: a */
    private static final String f6431a = "a";

    /* renamed from: b */
    private static SparseArray<List<Handler>> f6432b = new SparseArray<>();

    /* renamed from: a */
    public static void m10052a(int i, int i2, int i3, long j) {
        synchronized (f6432b) {
            List<Handler> list = f6432b.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10051a(int i, Handler handler) {
        synchronized (f6432b) {
            if (handler == null) {
                return;
            }
            List<Handler> list = f6432b.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f6432b.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    /* renamed from: b */
    public static void m10050b(int i, Handler handler) {
        synchronized (f6432b) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                List<Handler> list = f6432b.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
