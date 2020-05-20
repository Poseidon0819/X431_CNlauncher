package com.baidu.location.indoor.mapversion;

import android.os.Build;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.location.indoor.mapversion.a */
/* loaded from: classes.dex */
public class C1050a {

    /* renamed from: a */
    private static Lock f4831a = new ReentrantLock();

    /* renamed from: a */
    public static void m11313a() {
        try {
            IndoorJni.stopPdr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static synchronized void m11312a(int i, float[] fArr, long j) {
        synchronized (C1050a.class) {
            f4831a.lock();
            try {
                if (m11311b() && fArr != null && fArr.length >= 3) {
                    IndoorJni.phs(i, fArr[0], fArr[1], fArr[2], j);
                }
                f4831a.unlock();
            } catch (Exception e) {
                e.printStackTrace();
                f4831a.unlock();
            }
        }
    }

    /* renamed from: b */
    public static boolean m11311b() {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        return IndoorJni.f4830a;
    }

    /* renamed from: c */
    public static float[] m11310c() {
        f4831a.lock();
        try {
            try {
                return IndoorJni.pgo();
            } catch (Exception e) {
                e.printStackTrace();
                f4831a.unlock();
                return null;
            }
        } finally {
            f4831a.unlock();
        }
    }
}
