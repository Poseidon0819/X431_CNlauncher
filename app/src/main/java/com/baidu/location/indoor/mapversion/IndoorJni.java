package com.baidu.location.indoor.mapversion;

/* loaded from: classes.dex */
public class IndoorJni {

    /* renamed from: a */
    public static boolean f4830a = false;

    static {
        try {
            System.loadLibrary("indoor");
            initPf();
            f4830a = true;
        } catch (Throwable th) {
            System.err.println("Cannot load indoor lib");
            th.printStackTrace();
        }
    }

    public static native double[] getPfFr(double d, double d2);

    public static native void initPf();

    public static native float[] pgo();

    public static native void phs(int i, float f, float f2, float f3, long j);

    public static native void resetPf();

    public static native double[] setPfWf(double d, double d2);

    public static native void setRdnt(String str, short[][] sArr, double d, double d2, int i, int i2);

    public static native void stopPdr();
}
