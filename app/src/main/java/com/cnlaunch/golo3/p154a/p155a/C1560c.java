package com.cnlaunch.golo3.p154a.p155a;

import java.lang.reflect.Array;

/* compiled from: Arrays.java */
/* renamed from: com.cnlaunch.golo3.a.a.c */
/* loaded from: classes.dex */
public class C1560c {

    /* renamed from: a */
    static final /* synthetic */ boolean f7702a = !C1560c.class.desiredAssertionStatus();

    private C1560c() {
    }

    /* renamed from: a */
    public static <T> T[] m9244a(T[] tArr, int i) {
        if (tArr != null) {
            if (i < 0) {
                throw new NegativeArraySizeException();
            }
            int length = tArr.length;
            if (i >= 0) {
                if (length < 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i2 = i - 0;
                int min = Math.min(i2, length - 0);
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
                System.arraycopy(tArr, 0, tArr2, 0, min);
                return tArr2;
            }
            throw new IllegalArgumentException();
        }
        throw new NullPointerException();
    }
}
