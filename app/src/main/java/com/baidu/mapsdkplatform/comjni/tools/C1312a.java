package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.mapapi.model.inner.C1097a;
import com.baidu.mapapi.model.inner.Point;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;

/* renamed from: com.baidu.mapsdkplatform.comjni.tools.a */
/* loaded from: classes.dex */
public class C1312a {
    /* renamed from: a */
    public static double m9963a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x1", point.f5413x);
        bundle.putDouble("y1", point.f5414y);
        bundle.putDouble("x2", point2.f5413x);
        bundle.putDouble("y2", point2.f5414y);
        JNITools.GetDistanceByMC(bundle);
        return bundle.getDouble("distance");
    }

    /* renamed from: a */
    public static C1097a m9962a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2ComplexPt(bundle);
        C1097a c1097a = new C1097a();
        Bundle bundle2 = bundle.getBundle("map_bound");
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("ll");
            if (bundle3 != null) {
                c1097a.f5416b = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
            }
            Bundle bundle4 = bundle2.getBundle("ru");
            if (bundle4 != null) {
                c1097a.f5417c = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
            }
        }
        for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
            if (c1097a.f5418d == null) {
                c1097a.f5418d = new ArrayList<>();
            }
            Bundle bundle5 = parcelItem.getBundle();
            if (bundle5 != null) {
                ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                ArrayList<Point> arrayList = new ArrayList<>();
                for (ParcelItem parcelItem2 : parcelItemArr) {
                    Bundle bundle6 = parcelItem2.getBundle();
                    if (bundle6 != null) {
                        arrayList.add(new Point((int) bundle6.getDouble("ptx"), (int) bundle6.getDouble("pty")));
                    }
                }
                arrayList.trimToSize();
                c1097a.f5418d.add(arrayList);
            }
        }
        c1097a.f5418d.trimToSize();
        c1097a.f5415a = (int) bundle.getDouble(VastExtensionXmlManager.TYPE);
        return c1097a;
    }

    /* renamed from: a */
    public static String m9964a() {
        return JNITools.GetToken();
    }

    /* renamed from: a */
    public static void m9961a(boolean z, int i) {
        JNITools.openLogEnable(z, i);
    }

    /* renamed from: b */
    public static void m9960b() {
        JNITools.initClass(new Bundle(), 0);
    }
}
