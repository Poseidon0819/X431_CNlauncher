package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.support.p012v4.p019d.LongSparseArray;
import android.util.SparseIntArray;
import com.baidu.mapapi.model.LatLng;
import com.itextpdf.text.pdf.PdfContentParser;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* renamed from: b */
    private static final String f5034b = "HeatMap";

    /* renamed from: c */
    private static final SparseIntArray f5035c;

    /* renamed from: d */
    private static final int[] f5036d;

    /* renamed from: e */
    private static final float[] f5037e;

    /* renamed from: r */
    private static int f5038r;

    /* renamed from: a */
    BaiduMap f5039a;

    /* renamed from: f */
    private C1091b<WeightedLatLng> f5040f;

    /* renamed from: g */
    private Collection<WeightedLatLng> f5041g;

    /* renamed from: h */
    private int f5042h;

    /* renamed from: i */
    private Gradient f5043i;

    /* renamed from: j */
    private double f5044j;

    /* renamed from: k */
    private C1090a f5045k;

    /* renamed from: l */
    private int[] f5046l;

    /* renamed from: m */
    private double[] f5047m;

    /* renamed from: n */
    private double[] f5048n;

    /* renamed from: o */
    private HashMap<String, Tile> f5049o;

    /* renamed from: p */
    private ExecutorService f5050p;

    /* renamed from: q */
    private HashSet<String> f5051q;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private Collection<WeightedLatLng> f5056a;

        /* renamed from: b */
        private int f5057b = 12;

        /* renamed from: c */
        private Gradient f5058c = HeatMap.DEFAULT_GRADIENT;

        /* renamed from: d */
        private double f5059d = 0.6d;

        public HeatMap build() {
            if (this.f5056a != null) {
                return new HeatMap(this);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("input points can not contain null.");
            }
            return weightedData(HeatMap.m11191c(collection));
        }

        public Builder gradient(Gradient gradient) {
            if (gradient != null) {
                this.f5058c = gradient;
                return this;
            }
            throw new IllegalArgumentException("gradient can not be null");
        }

        public Builder opacity(double d) {
            this.f5059d = d;
            double d2 = this.f5059d;
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
            return this;
        }

        public Builder radius(int i) {
            this.f5057b = i;
            int i2 = this.f5057b;
            if (i2 < 10 || i2 > 50) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("input points can not contain null.");
            }
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                LatLng latLng = weightedLatLng.latLng;
                if (latLng.latitude < 0.37532d || latLng.latitude > 54.562495d || latLng.longitude < 72.508319d || latLng.longitude > 135.942198d) {
                    arrayList.add(weightedLatLng);
                }
            }
            collection.removeAll(arrayList);
            this.f5056a = collection;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5035c = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        f5035c.put(4, 4194304);
        f5035c.put(5, 2097152);
        f5035c.put(6, 1048576);
        f5035c.put(7, 524288);
        f5035c.put(8, 262144);
        f5035c.put(9, 131072);
        f5035c.put(10, 65536);
        f5035c.put(11, 32768);
        f5035c.put(12, 16384);
        f5035c.put(13, 8192);
        f5035c.put(14, 4096);
        f5035c.put(15, 2048);
        f5035c.put(16, 1024);
        f5035c.put(17, 512);
        f5035c.put(18, 256);
        f5035c.put(19, 128);
        f5035c.put(20, 64);
        f5036d = new int[]{Color.rgb(0, 0, (int) PdfContentParser.COMMAND_TYPE), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f5037e = new float[]{0.08f, 0.4f, 1.0f};
        DEFAULT_GRADIENT = new Gradient(f5036d, f5037e);
        f5038r = 0;
    }

    private HeatMap(Builder builder) {
        this.f5049o = new HashMap<>();
        this.f5050p = Executors.newFixedThreadPool(1);
        this.f5051q = new HashSet<>();
        this.f5041g = builder.f5056a;
        this.f5042h = builder.f5057b;
        this.f5043i = builder.f5058c;
        this.f5044j = builder.f5059d;
        int i = this.f5042h;
        double d = i;
        Double.isNaN(d);
        this.f5047m = m11208a(i, d / 3.0d);
        m11205a(this.f5043i);
        m11194b(this.f5041g);
    }

    /* renamed from: a */
    private static double m11200a(Collection<WeightedLatLng> collection, C1090a c1090a, int i, int i2) {
        double d = c1090a.f5390a;
        double d2 = c1090a.f5392c;
        double d3 = c1090a.f5391b;
        double d4 = d2 - d;
        double d5 = c1090a.f5393d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = i2 / (i * 2);
        Double.isNaN(d6);
        double d7 = (int) (d6 + 0.5d);
        Double.isNaN(d7);
        double d8 = d7 / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d9 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d10 = weightedLatLng.mo11072a().x;
            double d11 = weightedLatLng.mo11072a().y;
            Double.isNaN(d10);
            Double.isNaN(d11);
            int i3 = (int) ((d11 - d3) * d8);
            long j = (int) ((d10 - d) * d8);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.m14876a(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.m14875a(j, longSparseArray2);
            }
            long j2 = i3;
            Double d12 = (Double) longSparseArray2.m14876a(j2);
            if (d12 == null) {
                d12 = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d13 = d;
            Double valueOf = Double.valueOf(d12.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.m14875a(j2, valueOf);
            if (valueOf.doubleValue() > d9) {
                d9 = valueOf.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d = d13;
        }
        return d9;
    }

    /* renamed from: a */
    private static Bitmap m11198a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = iArr.length - 1;
        Double.isNaN(length);
        double d2 = length / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d3 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d3 * d2);
                if (d3 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    /* renamed from: a */
    private static Tile m11206a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        return new Tile(256, 256, allocate.array());
    }

    /* renamed from: a */
    private void m11205a(Gradient gradient) {
        this.f5043i = gradient;
        this.f5046l = gradient.m11215a(this.f5044j);
    }

    /* renamed from: a */
    private synchronized void m11202a(String str, Tile tile) {
        this.f5049o.put(str, tile);
    }

    /* renamed from: a */
    private synchronized boolean m11203a(String str) {
        return this.f5051q.contains(str);
    }

    /* renamed from: a */
    private double[] m11209a(int i) {
        int i2;
        double[] dArr = new double[20];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = m11200a(this.f5041g, this.f5045k, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 20; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    /* renamed from: a */
    private static double[] m11208a(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            double d2 = (-i2) * i2;
            Double.isNaN(d2);
            dArr[i2 + i] = Math.exp(d2 / ((2.0d * d) * d));
        }
        return dArr;
    }

    /* renamed from: a */
    private static double[][] m11199a(double[][] dArr, double[] dArr2) {
        double length = dArr2.length;
        Double.isNaN(length);
        int floor = (int) Math.floor(length / 2.0d);
        int length2 = dArr.length;
        int i = length2 - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, length2, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    int i5 = i3 + floor;
                    if (i2 < i5) {
                        i5 = i2;
                    }
                    int i6 = i5 + 1;
                    int i7 = i3 - floor;
                    for (int i8 = floor > i7 ? floor : i7; i8 < i6; i8++) {
                        double[] dArr4 = dArr3[i8];
                        dArr4[i4] = dArr4[i4] + (dArr2[i8 - i7] * d);
                    }
                }
            }
        }
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, i, i);
        for (int i9 = floor; i9 < i2 + 1; i9++) {
            for (int i10 = 0; i10 < length2; i10++) {
                double d2 = dArr3[i9][i10];
                if (d2 != 0.0d) {
                    int i11 = i10 + floor;
                    if (i2 < i11) {
                        i11 = i2;
                    }
                    int i12 = i11 + 1;
                    int i13 = i10 - floor;
                    for (int i14 = floor > i13 ? floor : i13; i14 < i12; i14++) {
                        double[] dArr6 = dArr5[i9 - floor];
                        int i15 = i14 - floor;
                        dArr6[i15] = dArr6[i15] + (dArr2[i14 - i13] * d2);
                    }
                }
            }
        }
        return dArr5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11196b(int i, int i2, int i3) {
        double d = f5035c.get(i3);
        int i4 = this.f5042h;
        double d2 = i4;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (d2 * d) / 256.0d;
        Double.isNaN(d);
        double d4 = (i4 * 2) + 256;
        Double.isNaN(d4);
        double d5 = ((2.0d * d3) + d) / d4;
        if (i < 0 || i2 < 0) {
            return;
        }
        double d6 = i;
        Double.isNaN(d6);
        Double.isNaN(d);
        double d7 = (d6 * d) - d3;
        double d8 = i + 1;
        Double.isNaN(d8);
        Double.isNaN(d);
        double d9 = (d8 * d) + d3;
        double d10 = i2;
        Double.isNaN(d10);
        Double.isNaN(d);
        double d11 = (d10 * d) - d3;
        double d12 = i2 + 1;
        Double.isNaN(d12);
        Double.isNaN(d);
        double d13 = (d12 * d) + d3;
        C1090a c1090a = new C1090a(d7, d9, d11, d13);
        if (c1090a.m11079a(new C1090a(this.f5045k.f5390a - d3, this.f5045k.f5392c + d3, this.f5045k.f5391b - d3, this.f5045k.f5393d + d3))) {
            Collection<WeightedLatLng> m11075a = this.f5040f.m11075a(c1090a);
            if (m11075a.isEmpty()) {
                return;
            }
            int i5 = this.f5042h;
            double[][] dArr = (double[][]) Array.newInstance(double.class, (i5 * 2) + 256, (i5 * 2) + 256);
            for (WeightedLatLng weightedLatLng : m11075a) {
                Point mo11072a = weightedLatLng.mo11072a();
                double d14 = mo11072a.x;
                Double.isNaN(d14);
                int i6 = (int) ((d14 - d7) / d5);
                double d15 = d7;
                double d16 = mo11072a.y;
                Double.isNaN(d16);
                int i7 = (int) ((d13 - d16) / d5);
                int i8 = this.f5042h;
                if (i6 >= (i8 * 2) + 256) {
                    i6 = ((i8 * 2) + 256) - 1;
                }
                int i9 = this.f5042h;
                if (i7 >= (i9 * 2) + 256) {
                    i7 = ((i9 * 2) + 256) - 1;
                }
                double[] dArr2 = dArr[i6];
                dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
                d7 = d15;
                d13 = d13;
            }
            Bitmap m11198a = m11198a(m11199a(dArr, this.f5047m), this.f5046l, this.f5048n[i3 - 1]);
            Tile m11206a = m11206a(m11198a);
            m11198a.recycle();
            m11202a(i + "_" + i2 + "_" + i3, m11206a);
            if (this.f5049o.size() > f5038r) {
                m11210a();
            }
            BaiduMap baiduMap = this.f5039a;
            if (baiduMap != null) {
                baiduMap.m11259a();
            }
        }
    }

    /* renamed from: b */
    private synchronized void m11195b(String str) {
        this.f5051q.add(str);
    }

    /* renamed from: b */
    private void m11194b(Collection<WeightedLatLng> collection) {
        this.f5041g = collection;
        if (this.f5041g.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        this.f5045k = m11189d(this.f5041g);
        this.f5040f = new C1091b<>(this.f5045k);
        for (WeightedLatLng weightedLatLng : this.f5041g) {
            this.f5040f.m11073a((C1091b<WeightedLatLng>) weightedLatLng);
        }
        this.f5048n = m11209a(this.f5042h);
    }

    /* renamed from: c */
    private synchronized Tile m11192c(String str) {
        if (this.f5049o.containsKey(str)) {
            Tile tile = this.f5049o.get(str);
            this.f5049o.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static Collection<WeightedLatLng> m11191c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static C1090a m11189d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.mo11072a().x;
        double d2 = next.mo11072a().x;
        double d3 = next.mo11072a().y;
        double d4 = next.mo11072a().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d5 = next2.mo11072a().x;
            double d6 = next2.mo11072a().y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new C1090a(d, d2, d3, d4);
    }

    /* renamed from: d */
    private synchronized void m11190d() {
        this.f5049o.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Tile m11207a(final int i, final int i2, final int i3) {
        String str = i + "_" + i2 + "_" + i3;
        Tile m11192c = m11192c(str);
        if (m11192c != null) {
            return m11192c;
        }
        if (m11203a(str)) {
            return null;
        }
        BaiduMap baiduMap = this.f5039a;
        if (baiduMap != null && f5038r == 0) {
            MapStatus mapStatus = baiduMap.getMapStatus();
            f5038r = (((mapStatus.f5079a.f6123j.right - mapStatus.f5079a.f6123j.left) / 256) + 2) * (((mapStatus.f5079a.f6123j.bottom - mapStatus.f5079a.f6123j.top) / 256) + 2) * 4;
        }
        if (this.f5049o.size() > f5038r) {
            m11210a();
        }
        if (this.f5050p.isShutdown()) {
            return null;
        }
        try {
            this.f5050p.execute(new Runnable() { // from class: com.baidu.mapapi.map.HeatMap.1
                @Override // java.lang.Runnable
                public void run() {
                    HeatMap.this.m11196b(i, i2, i3);
                }
            });
            m11195b(str);
            return null;
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m11210a() {
        this.f5051q.clear();
        this.f5049o.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m11197b() {
        m11190d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m11193c() {
        this.f5050p.shutdownNow();
    }

    public void removeHeatMap() {
        BaiduMap baiduMap = this.f5039a;
        if (baiduMap != null) {
            baiduMap.m11254a(this);
        }
    }
}
