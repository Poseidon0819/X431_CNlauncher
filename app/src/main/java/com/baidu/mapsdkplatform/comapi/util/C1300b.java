package com.baidu.mapsdkplatform.comapi.util;

import android.os.Bundle;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.C1097a;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comjni.tools.C1312a;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smackx.GroupChatInvitation;

/* renamed from: com.baidu.mapsdkplatform.comapi.util.b */
/* loaded from: classes.dex */
public class C1300b {

    /* renamed from: a */
    static double[] f6381a = {1.289059486E7d, 8362377.87d, 5591021.0d, 3481989.83d, 1678043.12d, 0.0d};

    /* renamed from: b */
    static double[] f6382b = {7.5E7d, 6.0E7d, 4.5E7d, 3.0E7d, 1.5E7d, 0.0d};

    /* renamed from: c */
    static double[][] f6383c = {new double[]{1.410526172116255E-8d, 8.98305509648872E-6d, -1.9939833816331d, 200.9824383106796d, -187.2403703815547d, 91.6087516669843d, -23.38765649603339d, 2.57121317296198d, -0.03801003308653d, 1.73379812E7d}, new double[]{-7.435856389565537E-9d, 8.983055097726239E-6d, -0.78625201886289d, 96.32687599759846d, -1.85204757529826d, -59.36935905485877d, 47.40033549296737d, -16.50741931063887d, 2.28786674699375d, 1.026014486E7d}, new double[]{-3.030883460898826E-8d, 8.98305509983578E-6d, 0.30071316287616d, 59.74293618442277d, 7.357984074871d, -25.38371002664745d, 13.45380521110908d, -3.29883767235584d, 0.32710905363475d, 6856817.37d}, new double[]{-1.981981304930552E-8d, 8.983055099779535E-6d, 0.03278182852591d, 40.31678527705744d, 0.65659298677277d, -4.44255534477492d, 0.85341911805263d, 0.12923347998204d, -0.04625736007561d, 4482777.06d}, new double[]{3.09191371068437E-9d, 8.983055096812155E-6d, 6.995724062E-5d, 23.10934304144901d, -2.3663490511E-4d, -0.6321817810242d, -0.00663494467273d, 0.03430082397953d, -0.00466043876332d, 2555164.4d}, new double[]{2.890871144776878E-9d, 8.983055095805407E-6d, -3.068298E-8d, 7.47137025468032d, -3.53937994E-6d, -0.02145144861037d, -1.234426596E-5d, 1.0322952773E-4d, -3.23890364E-6d, 826088.5d}};

    /* renamed from: d */
    static double[][] f6384d = {new double[]{-0.0015702102444d, 111320.7020616939d, 1.704480524535203E15d, -1.033898737604234E16d, 2.611266785660388E16d, -3.51496691766537E16d, 2.659570071840392E16d, -1.072501245418824E16d, 1.800819912950474E15d, 82.5d}, new double[]{8.277824516172526E-4d, 111320.7020463578d, 6.477955746671607E8d, -4.082003173641316E9d, 1.077490566351142E10d, -1.517187553151559E10d, 1.205306533862167E10d, -5.124939663577472E9d, 9.133119359512032E8d, 67.5d}, new double[]{0.00337398766765d, 111320.7020202162d, 4481351.045890365d, -2.339375119931662E7d, 7.968221547186455E7d, -1.159649932797253E8d, 9.723671115602145E7d, -4.366194633752821E7d, 8477230.501135234d, 52.5d}, new double[]{0.00220636496208d, 111320.7020209128d, 51751.86112841131d, 3796837.749470245d, 992013.7397791013d, -1221952.21711287d, 1340652.697009075d, -620943.6990984312d, 144416.9293806241d, 37.5d}, new double[]{-3.441963504368392E-4d, 111320.7020576856d, 278.2353980772752d, 2485758.690035394d, 6070.750963243378d, 54821.18345352118d, 9540.606633304236d, -2710.55326746645d, 1405.483844121726d, 22.5d}, new double[]{-3.218135878613132E-4d, 111320.7020701615d, 0.00369383431289d, 823725.6402795718d, 0.46104986909093d, 2351.343141331292d, 1.58060784298199d, 8.77738589078284d, 0.37238884252424d, 7.45d}};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.util.b$a */
    /* loaded from: classes.dex */
    public static class C1301a {

        /* renamed from: a */
        double f6385a;

        /* renamed from: b */
        double f6386b;

        C1301a() {
        }
    }

    /* renamed from: a */
    public static int m10095a(LatLng latLng, int i) {
        double d = latLng.latitude;
        double d2 = i;
        Double.isNaN(d2);
        LatLng latLng2 = new LatLng(d + (d2 / 111000.0d), latLng.longitude);
        GeoPoint m10096a = m10096a(latLng);
        GeoPoint m10096a2 = m10096a(latLng2);
        return (int) Math.sqrt(Math.pow(m10096a.getLatitudeE6() - m10096a2.getLatitudeE6(), 2.0d) + Math.pow(m10096a.getLongitudeE6() - m10096a2.getLongitudeE6(), 2.0d));
    }

    /* renamed from: a */
    public static LatLng m10097a(float f, float f2, String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("") || str.equals("bd09ll")) {
            return new LatLng(f, f2);
        }
        if (str.equals("bd09ll") || str.equals(CoordinateType.BD09MC) || str.equals(CoordinateType.GCJ02) || str.equals(CoordinateType.WGS84)) {
            Bundle bundle = new Bundle();
            JNITools.CoordinateEncryptEx(f, f2, str, bundle);
            if (bundle.isEmpty()) {
                return null;
            }
            return new LatLng(bundle.getDouble("y"), bundle.getDouble(GroupChatInvitation.ELEMENT_NAME));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b A[EDGE_INSN: B:35:0x009b->B:32:0x009b ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mapapi.model.LatLng m10094a(com.baidu.mapapi.model.inner.GeoPoint r11) {
        /*
            com.baidu.mapsdkplatform.comapi.util.b$a r0 = new com.baidu.mapsdkplatform.comapi.util.b$a
            r0.<init>()
            double r1 = r11.getLongitudeE6()
            r0.f6385a = r1
            double r1 = r11.getLatitudeE6()
            r0.f6386b = r1
            com.baidu.mapsdkplatform.comapi.util.b$a r11 = new com.baidu.mapsdkplatform.comapi.util.b$a
            r11.<init>()
            double r1 = r0.f6385a
            r11.f6385a = r1
            double r1 = r11.f6385a
            r3 = -4507228048936348418(0xc1731bf84578d4fe, double:-2.0037508342E7)
            r5 = 4716143987918427390(0x41731bf84578d4fe, double:2.0037508342E7)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L31
            double r1 = r11.f6385a
            double r1 = r1 - r5
            double r1 = r1 + r3
        L2e:
            r11.f6385a = r1
            goto L3e
        L31:
            double r1 = r11.f6385a
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L3e
            double r1 = r11.f6385a
            double r1 = r3 - r1
            double r1 = r5 - r1
            goto L2e
        L3e:
            double r0 = r0.f6386b
            r11.f6386b = r0
            double r0 = r11.f6386b
            r7 = 0
            r9 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 >= 0) goto L58
            double r0 = r11.f6386b
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 < 0) goto L58
            r11.f6386b = r9
            goto L7d
        L58:
            double r0 = r11.f6386b
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L6c
            double r0 = r11.f6386b
            r7 = -4706042843746669171(0xbeb0c6f7a0b5ed8d, double:-1.0E-6)
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L6c
            r11.f6386b = r7
            goto L7d
        L6c:
            double r0 = r11.f6386b
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L75
            r11.f6386b = r5
            goto L7d
        L75:
            double r0 = r11.f6386b
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L7d
            r11.f6386b = r3
        L7d:
            r0 = 10
            double[] r0 = new double[r0]
            r1 = 0
        L82:
            r2 = 6
            if (r1 >= r2) goto L9b
            double r2 = r11.f6386b
            double r2 = java.lang.Math.abs(r2)
            double[] r4 = com.baidu.mapsdkplatform.comapi.util.C1300b.f6381a
            r5 = r4[r1]
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L98
            double[][] r0 = com.baidu.mapsdkplatform.comapi.util.C1300b.f6383c
            r0 = r0[r1]
            goto L9b
        L98:
            int r1 = r1 + 1
            goto L82
        L9b:
            com.baidu.mapsdkplatform.comapi.util.b$a r11 = m10093a(r11, r0)
            com.baidu.mapapi.model.LatLng r0 = new com.baidu.mapapi.model.LatLng
            double r1 = r11.f6386b
            double r3 = r11.f6385a
            r0.<init>(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.util.C1300b.m10094a(com.baidu.mapapi.model.inner.GeoPoint):com.baidu.mapapi.model.LatLng");
    }

    /* renamed from: a */
    public static LatLng m10092a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2Pt(bundle);
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        geoPoint.setLongitudeE6(bundle.getInt("ptx"));
        geoPoint.setLatitudeE6(bundle.getInt("pty"));
        return m10094a(geoPoint);
    }

    /* renamed from: a */
    public static GeoPoint m10096a(LatLng latLng) {
        C1301a c1301a = new C1301a();
        double[] dArr = new double[10];
        c1301a.f6386b = Math.abs(latLng.latitude * 1000000.0d);
        if (c1301a.f6386b < 0.1d) {
            c1301a.f6386b = 0.1d;
        }
        int i = 0;
        while (true) {
            if (i >= f6382b.length) {
                break;
            } else if (c1301a.f6386b > f6382b[i]) {
                dArr = f6384d[i];
                break;
            } else {
                i++;
            }
        }
        c1301a.f6385a = latLng.longitude;
        c1301a.f6386b = latLng.latitude;
        C1301a m10093a = m10093a(c1301a, dArr);
        return new GeoPoint(m10093a.f6386b, m10093a.f6385a);
    }

    /* renamed from: a */
    static C1301a m10093a(C1301a c1301a, double[] dArr) {
        C1301a c1301a2 = new C1301a();
        c1301a2.f6385a = dArr[0] + (dArr[1] * Math.abs(c1301a.f6385a));
        double abs = Math.abs(c1301a.f6386b) / dArr[9];
        c1301a2.f6386b = dArr[2] + (dArr[3] * abs) + (dArr[4] * abs * abs) + (dArr[5] * abs * abs * abs) + (dArr[6] * abs * abs * abs * abs) + (dArr[7] * abs * abs * abs * abs * abs) + (dArr[8] * abs * abs * abs * abs * abs * abs);
        double d = c1301a2.f6385a;
        double d2 = c1301a.f6385a < 0.0d ? -1 : 1;
        Double.isNaN(d2);
        c1301a2.f6385a = d * d2;
        double d3 = c1301a2.f6386b;
        double d4 = c1301a.f6386b >= 0.0d ? 1 : -1;
        Double.isNaN(d4);
        c1301a2.f6386b = d3 * d4;
        return c1301a2;
    }

    /* renamed from: b */
    public static LatLng m10090b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransNodeStr2Pt(bundle);
        return m10094a(new GeoPoint(bundle.getDouble("pty"), bundle.getDouble("ptx")));
    }

    /* renamed from: b */
    public static Point m10091b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        JNITools.CoordinateEncryptMc((float) latLng.longitude, (float) latLng.latitude, bundle);
        Point point = new Point(0, 0);
        point.setmPtx((int) bundle.getDouble(GroupChatInvitation.ELEMENT_NAME));
        point.setmPty((int) bundle.getDouble("y"));
        return point;
    }

    /* renamed from: c */
    public static List<LatLng> m10089c(String str) {
        C1097a m9962a = C1312a.m9962a(str);
        ArrayList arrayList = new ArrayList();
        if (m9962a == null || m9962a.f5418d == null) {
            return null;
        }
        ArrayList<ArrayList<Point>> arrayList2 = m9962a.f5418d;
        if (arrayList2.size() > 0) {
            ArrayList<Point> arrayList3 = arrayList2.get(0);
            for (int i = 0; i < arrayList3.size(); i++) {
                Point point = arrayList3.get(i);
                arrayList.add(SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(m10094a(new GeoPoint(point.f5414y / 100, point.f5413x / 100))) : m10094a(new GeoPoint(point.f5414y / 100, point.f5413x / 100)));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public static List<List<LatLng>> m10088d(String str) {
        C1097a m9962a = C1312a.m9962a(str);
        if (m9962a == null || m9962a.f5418d == null) {
            return null;
        }
        ArrayList<ArrayList<Point>> arrayList = m9962a.f5418d;
        ArrayList arrayList2 = new ArrayList();
        Iterator<ArrayList<Point>> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<Point> it2 = it.next().iterator();
            while (it2.hasNext()) {
                Point next = it2.next();
                arrayList3.add(SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(m10094a(new GeoPoint(next.f5414y / 100, next.f5413x / 100))) : m10094a(new GeoPoint(next.f5414y / 100, next.f5413x / 100)));
            }
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }
}
