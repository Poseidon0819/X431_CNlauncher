package com.cnlaunch.x431pro.activity.golo.others;

import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.golo.others.a */
/* loaded from: classes.dex */
public final class AsyLock {

    /* renamed from: a */
    private static ArrayList<Integer> f12676a = new ArrayList<>();

    /* renamed from: a */
    public static boolean m6968a(int i) {
        return f12676a.contains(Integer.valueOf(i));
    }

    /* renamed from: b */
    public static void m6967b(int i) {
        f12676a.add(Integer.valueOf(i));
    }

    /* renamed from: c */
    public static void m6966c(int i) {
        if (m6968a(i)) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= f12676a.size()) {
                    break;
                } else if (i == f12676a.get(i3).intValue()) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            f12676a.remove(i2);
        }
    }
}
