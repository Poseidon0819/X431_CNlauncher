package com.baidu.location;

import com.baidu.mapsdkplatform.comapi.location.CoordinateType;

/* loaded from: classes.dex */
public class Jni {

    /* renamed from: a */
    private static int f3804a = 0;

    /* renamed from: b */
    private static int f3805b = 1;

    /* renamed from: c */
    private static int f3806c = 2;

    /* renamed from: d */
    private static int f3807d = 11;

    /* renamed from: e */
    private static int f3808e = 12;

    /* renamed from: f */
    private static int f3809f = 13;

    /* renamed from: g */
    private static int f3810g = 14;

    /* renamed from: h */
    private static int f3811h = 15;

    /* renamed from: i */
    private static int f3812i = 1024;

    /* renamed from: j */
    private static boolean f3813j = false;

    static {
        try {
            System.loadLibrary("locSDK7b");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            f3813j = true;
        }
    }

    /* renamed from: a */
    private static native String m12330a(byte[] bArr, int i);

    /* renamed from: b */
    private static native String m12329b(double d, double d2, int i, int i2);

    /* renamed from: c */
    private static native String m12328c(byte[] bArr, int i);

    public static double[] coorEncrypt(double d, double d2, String str) {
        double[] dArr = {0.0d, 0.0d};
        if (f3813j) {
            return dArr;
        }
        int i = -1;
        if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            i = f3804a;
        } else if (str.equals("bd09ll")) {
            i = f3805b;
        } else if (str.equals(CoordinateType.GCJ02)) {
            i = f3806c;
        } else if (str.equals(BDLocation.BDLOCATION_WGS84_TO_GCJ02)) {
            i = f3807d;
        } else if (str.equals(BDLocation.BDLOCATION_BD09_TO_GCJ02)) {
            i = f3808e;
        } else if (str.equals(BDLocation.BDLOCATION_BD09LL_TO_GCJ02)) {
            i = f3809f;
        } else if (str.equals("wgs842mc")) {
            i = f3811h;
        }
        try {
            String[] split = m12329b(d, d2, str.equals("gcj2wgs") ? 16 : i, 132456).split(":");
            dArr[0] = Double.parseDouble(split[0]);
            dArr[1] = Double.parseDouble(split[1]);
        } catch (UnsatisfiedLinkError unused) {
        }
        return dArr;
    }

    /* renamed from: ee */
    private static native String m12327ee(String str, int i);

    public static String en1(String str) {
        if (f3813j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f3812i];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (bytes[i2] != 0) {
                bArr[i] = bytes[i2];
                i++;
            }
        }
        try {
            return m12330a(bArr, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static String encode(String str) {
        if (f3813j) {
            return "err!";
        }
        return en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        if (f3813j) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        try {
            return m12328c(str.getBytes(), 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "err!";
        }
    }

    public static Long encode3(String str) {
        if (f3813j) {
            return null;
        }
        String str2 = "";
        try {
            str2 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
        }
        try {
            return Long.valueOf(murmur(str2));
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    private static native String encodeNotLimit(String str, int i);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        if (f3813j) {
            return "err!";
        }
        String str3 = "";
        try {
            str3 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
        }
        try {
            str2 = encodeNotLimit(str3, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            str2 = "err!";
        }
        return str2 + "|tp=3";
    }

    public static String encodeTp4(String str) {
        String str2;
        if (f3813j) {
            return "err!";
        }
        String str3 = "";
        try {
            str3 = new String(str.getBytes(), "UTF-8");
        } catch (Exception unused) {
        }
        try {
            str2 = m12327ee(str3, 132456);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            str2 = "err!";
        }
        return str2 + "|tp=4";
    }

    public static double getGpsSwiftRadius(float f, double d, double d2) {
        if (f3813j) {
            return 0.0d;
        }
        try {
            return gsr(f, d, d2);
        } catch (UnsatisfiedLinkError unused) {
            return 0.0d;
        }
    }

    private static native double gsr(float f, double d, double d2);

    private static native long murmur(String str);
}
