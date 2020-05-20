package com.cnlaunch.x431pro.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p252d.p254b.C2725h;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.x431pro.utils.r */
/* loaded from: classes.dex */
public final class LocationUtils {
    /* renamed from: a */
    public static C2725h m4873a(Context context) {
        C2725h c2725h;
        C2785s c2785s;
        Location location;
        try {
            c2725h = new C2725h();
            c2785s = new C2785s();
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (!locationManager.isProviderEnabled("gps")) {
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
                intent.addCategory("android.intent.category.ALTERNATIVE");
                intent.setData(Uri.parse("custom:3"));
                try {
                    PendingIntent.getBroadcast(context, 0, intent, 0).send();
                    NLog.m9456a("weizewei", "toggleGPS");
                } catch (PendingIntent.CanceledException e) {
                    NLog.m9456a("weizewei", "CanceledException");
                    e.printStackTrace();
                }
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                locationManager.requestLocationUpdates(bestProvider, 60000L, 1.0f, c2785s);
                location = locationManager.getLastKnownLocation("gps");
            } else {
                location = null;
            }
        } catch (Exception e2) {
            NLog.m9451c("Sanda", "LocationUtils[" + e2.getMessage() + "]");
        }
        if (location != null) {
            c2725h.setLat(location.getLatitude());
            c2725h.setLon(location.getLongitude());
            return c2725h;
        }
        Location m4872a = m4872a(context, c2785s);
        if (m4872a != null) {
            c2725h.setLat(m4872a.getLatitude());
            c2725h.setLon(m4872a.getLongitude());
            return c2725h;
        }
        return null;
    }

    /* renamed from: a */
    private static Location m4872a(Context context, LocationListener locationListener) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Location location = null;
        if (locationManager.isProviderEnabled("network")) {
            for (int i = 0; location == null && i < 10; i++) {
                locationManager.requestLocationUpdates("network", 1000L, ColumnText.GLOBAL_SPACE_CHAR_RATIO, locationListener);
                location = locationManager.getLastKnownLocation("network");
            }
            return location;
        }
        return null;
    }
}
