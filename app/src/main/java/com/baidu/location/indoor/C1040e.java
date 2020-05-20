package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.indoor.e */
/* loaded from: classes.dex */
public class C1040e {

    /* renamed from: a */
    private List<Location> f4762a;

    /* renamed from: b */
    private String f4763b;

    /* renamed from: c */
    private Location f4764c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1040e(String str, Location[] locationArr) {
        if (locationArr == null || locationArr.length <= 0) {
            return;
        }
        m11380a(locationArr);
        this.f4763b = str;
    }

    /* renamed from: a */
    private void m11380a(Location[] locationArr) {
        if (locationArr == null || locationArr.length <= 0) {
            return;
        }
        if (this.f4762a == null) {
            this.f4762a = new ArrayList();
        }
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i = 0; i < locationArr.length; i++) {
            d += locationArr[i].getLatitude();
            d2 += locationArr[i].getLongitude();
            this.f4762a.add(locationArr[i]);
        }
        if (this.f4764c == null) {
            this.f4764c = new Location("gps");
            Location location = this.f4764c;
            double length = locationArr.length;
            Double.isNaN(length);
            location.setLatitude(d / length);
            Location location2 = this.f4764c;
            double length2 = locationArr.length;
            Double.isNaN(length2);
            location2.setLongitude(d2 / length2);
        }
    }

    /* renamed from: a */
    public String m11382a() {
        return this.f4763b;
    }

    /* renamed from: a */
    public boolean m11381a(double d, double d2) {
        List<Location> list = this.f4762a;
        boolean z = false;
        if (list != null) {
            int size = list.size();
            int i = (int) (d2 * 1000000.0d);
            int i2 = (int) (d * 1000000.0d);
            int i3 = size - 1;
            for (int i4 = 0; i4 < size; i4++) {
                int longitude = (int) (this.f4762a.get(i4).getLongitude() * 1000000.0d);
                int latitude = (int) (this.f4762a.get(i4).getLatitude() * 1000000.0d);
                int longitude2 = (int) (this.f4762a.get(i3).getLongitude() * 1000000.0d);
                int latitude2 = (int) (this.f4762a.get(i3).getLatitude() * 1000000.0d);
                if ((i == longitude && i2 == latitude) || (i == longitude2 && i2 == latitude2)) {
                    return true;
                }
                if ((latitude < i2 && latitude2 >= i2) || (latitude >= i2 && latitude2 < i2)) {
                    int i5 = longitude + (((i2 - latitude) * (longitude2 - longitude)) / (latitude2 - latitude));
                    if (i5 == i) {
                        return true;
                    }
                    if (i5 > i) {
                        z = !z;
                    }
                }
                i3 = i4;
            }
        }
        return z;
    }
}
