package com.cnlaunch.p112a.p116d;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.a.d.b */
/* loaded from: classes.dex */
public final class MathHelper {

    /* renamed from: a */
    private static final NumberFormat f6729a = NumberFormat.getNumberInstance();

    /* renamed from: a */
    public static List<Double> m9647a(double d, double d2, int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        f6729a.setMaximumFractionDigits(5);
        double[] m9646a = m9646a(d, d2, i, false);
        int i2 = ((int) ((m9646a[1] - m9646a[0]) / m9646a[2])) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            double d3 = m9646a[0];
            double d4 = i3;
            double d5 = m9646a[2];
            Double.isNaN(d4);
            double d6 = d3 + (d4 * d5);
            try {
                NumberFormat numberFormat = f6729a;
                d6 = numberFormat.parse(numberFormat.format(d6)).doubleValue();
            } catch (ParseException unused) {
            }
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<Double> m9645b(double d, double d2, int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        f6729a.setMaximumFractionDigits(5);
        double[] m9646a = m9646a(d, d2, i, Math.abs(d - d2) >= 6.0d);
        int abs = ((int) (Math.abs(m9646a[1] - m9646a[0]) / m9646a[2])) + 1;
        for (int i2 = 0; i2 < abs; i2++) {
            double d3 = m9646a[0];
            double d4 = i2;
            double d5 = m9646a[2];
            Double.isNaN(d4);
            double d6 = d3 + (d4 * d5);
            try {
                NumberFormat numberFormat = f6729a;
                d6 = numberFormat.parse(numberFormat.format(d6)).doubleValue();
            } catch (ParseException unused) {
            }
            arrayList.add(Double.valueOf(d6));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static double[] m9646a(double d, double d2, int i, boolean z) {
        boolean z2;
        double d3;
        double d4;
        if (Math.abs(d - d2) < 1.0000000116860974E-7d) {
            return new double[]{d, d, 0.0d};
        }
        if (d > d2) {
            d4 = d;
            d3 = d2;
            z2 = true;
        } else {
            z2 = false;
            d3 = d;
            d4 = d2;
        }
        double abs = Math.abs(d3 - d4);
        double d5 = i;
        Double.isNaN(d5);
        double d6 = abs / d5;
        if (z) {
            d3 = Math.ceil(d3 / d6) * d6;
        }
        if (z) {
            d4 = Math.floor(d4 / d6) * d6;
        }
        return z2 ? new double[]{d4, d3, d6 * (-1.0d)} : new double[]{d3, d4, d6};
    }
}
