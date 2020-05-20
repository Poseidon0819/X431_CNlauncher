package com.baidu.mapapi.map;

import android.graphics.Color;
import com.itextpdf.text.pdf.ColumnText;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Gradient {

    /* renamed from: a */
    private final int f5006a;

    /* renamed from: b */
    private final int[] f5007b;

    /* renamed from: c */
    private final float[] f5008c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapapi.map.Gradient$a */
    /* loaded from: classes.dex */
    public class C1070a {

        /* renamed from: b */
        private final int f5010b;

        /* renamed from: c */
        private final int f5011c;

        /* renamed from: d */
        private final float f5012d;

        private C1070a(int i, int i2, float f) {
            this.f5010b = i;
            this.f5011c = i2;
            this.f5012d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr == null || fArr == null) {
            throw new IllegalArgumentException("colors and startPoints should not be null");
        }
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (fArr[i2] <= fArr[i2 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.f5006a = i;
        this.f5007b = new int[iArr.length];
        this.f5008c = new float[fArr.length];
        System.arraycopy(iArr, 0, this.f5007b, 0, iArr.length);
        System.arraycopy(fArr, 0, this.f5008c, 0, fArr.length);
    }

    /* renamed from: a */
    private static int m11214a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    /* renamed from: a */
    private HashMap<Integer, C1070a> m11216a() {
        HashMap<Integer, C1070a> hashMap = new HashMap<>();
        if (this.f5008c[0] != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            hashMap.put(0, new C1070a(Color.argb(0, Color.red(this.f5007b[0]), Color.green(this.f5007b[0]), Color.blue(this.f5007b[0])), this.f5007b[0], this.f5006a * this.f5008c[0]));
        }
        for (int i = 1; i < this.f5007b.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (this.f5006a * this.f5008c[i2]));
            int[] iArr = this.f5007b;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.f5008c;
            hashMap.put(valueOf, new C1070a(i3, i4, (fArr[i] - fArr[i2]) * this.f5006a));
        }
        float[] fArr2 = this.f5008c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.f5006a * fArr2[length]));
            int[] iArr2 = this.f5007b;
            hashMap.put(valueOf2, new C1070a(iArr2[length], iArr2[length], this.f5006a * (1.0f - this.f5008c[length])));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] m11215a(double d) {
        HashMap<Integer, C1070a> m11216a = m11216a();
        int[] iArr = new int[this.f5006a];
        C1070a c1070a = m11216a.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.f5006a; i2++) {
            if (m11216a.containsKey(Integer.valueOf(i2))) {
                c1070a = m11216a.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = m11214a(c1070a.f5010b, c1070a.f5011c, (i2 - i) / c1070a.f5012d);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.f5006a; i3++) {
                int i4 = iArr[i3];
                double alpha = Color.alpha(i4);
                Double.isNaN(alpha);
                iArr[i3] = Color.argb((int) (alpha * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }
}
