package com.cnlaunch.golo3.p165g;

import android.app.Activity;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.cnlaunch.golo3.g.k */
/* loaded from: classes.dex */
public final class GoloActivityManager {

    /* renamed from: a */
    public static Stack<Activity> f8472a = new Stack<>();

    /* synthetic */ GoloActivityManager(byte b) {
        this();
    }

    private GoloActivityManager() {
    }

    /* compiled from: GoloActivityManager.java */
    /* renamed from: com.cnlaunch.golo3.g.k$a */
    /* loaded from: classes.dex */
    static class C1616a {

        /* renamed from: a */
        private static final GoloActivityManager f8473a = new GoloActivityManager((byte) 0);
    }

    /* renamed from: a */
    public static GoloActivityManager m9138a() {
        return C1616a.f8473a;
    }

    /* renamed from: a */
    public static void m9137a(Activity activity) {
        f8472a.add(activity);
    }

    /* renamed from: b */
    public static void m9135b(Activity activity) {
        if (activity != null) {
            f8472a.remove(activity);
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m9136b() {
        try {
            if (f8472a != null) {
                Iterator<Activity> it = f8472a.iterator();
                while (it.hasNext()) {
                    Activity next = it.next();
                    if (next != null) {
                        next.finish();
                    }
                }
                f8472a.clear();
            }
            Runtime.getRuntime().exit(0);
        } catch (Exception unused) {
            Runtime.getRuntime().exit(-1);
        }
    }
}
