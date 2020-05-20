package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comjni.map.basemap.C1306a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comapi.map.C */
/* loaded from: classes.dex */
public class C1199C {

    /* renamed from: a */
    private C1306a f5923a;

    public C1199C(C1306a c1306a) {
        this.f5923a = c1306a;
    }

    /* renamed from: a */
    public Point m10777a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        Point point = new Point(0, 0);
        String m10026b = this.f5923a.m10026b((int) geoPoint.getLongitudeE6(), (int) geoPoint.getLatitudeE6());
        if (m10026b != null) {
            try {
                JSONObject jSONObject = new JSONObject(m10026b);
                point.x = jSONObject.getInt("scrx");
                point.y = jSONObject.getInt("scry");
                return point;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return point;
    }

    /* renamed from: a */
    public GeoPoint m10778a(int i, int i2) {
        String m10047a = this.f5923a.m10047a(i, i2);
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        if (m10047a != null) {
            try {
                JSONObject jSONObject = new JSONObject(m10047a);
                geoPoint.setLongitudeE6(jSONObject.getInt("geox"));
                geoPoint.setLatitudeE6(jSONObject.getInt("geoy"));
                return geoPoint;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
