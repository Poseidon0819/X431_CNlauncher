package com.baidu.location.indoor;

import java.util.List;

/* renamed from: com.baidu.location.indoor.f */
/* loaded from: classes.dex */
public class C1041f {

    /* renamed from: a */
    private static double f4765a = 6378137.0d;

    /* renamed from: a */
    public static double m11379a(double d, double d2) {
        double d3 = d * d2;
        if (d3 == -1.0d) {
            return 90.0d;
        }
        return Math.toDegrees(Math.atan(d2 - (d / (d3 + 1.0d))));
    }

    /* renamed from: a */
    public static double m11378a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double radians = Math.toRadians(d);
        Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        double radians3 = Math.toRadians(d5);
        double radians4 = Math.toRadians(d6) / 2.0d;
        double d7 = radians3 / 2.0d;
        double sin = (Math.sin(radians4) * Math.sin(radians4)) + (Math.cos(radians) * Math.cos(radians2) * Math.sin(d7) * Math.sin(d7));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * f4765a;
    }

    /* renamed from: a */
    public static double m11377a(List<Float> list) {
        double floatValue = list.get(0).floatValue();
        double d = floatValue;
        for (int i = 1; i < list.size(); i++) {
            double floatValue2 = list.get(i).floatValue();
            Double.isNaN(floatValue2);
            double d2 = floatValue2 - d;
            d = d2 < -180.0d ? d + d2 + 360.0d : d2 < 180.0d ? d + d2 : (d + d2) - 360.0d;
            floatValue += d;
        }
        double size = list.size();
        Double.isNaN(size);
        return floatValue / size;
    }

    /* renamed from: b */
    public static double m11376b(double d, double d2) {
        double d3 = d2 - d;
        return d3 > 180.0d ? d3 - 360.0d : d3 < -180.0d ? d3 + 360.0d : d3;
    }

    /* renamed from: b */
    public static double m11375b(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(d);
        double radians3 = Math.toRadians(d3);
        double radians4 = Math.toRadians(d4) - radians;
        return (Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians2) * Math.sin(radians3)) - ((Math.sin(radians2) * Math.cos(radians3)) * Math.cos(radians4)))) + 360.0d) % 360.0d;
    }
}
