package com.cnlaunch.p135g;

import android.content.Context;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.cnlaunch.p135g.MyLocationLogic;
import java.util.Timer;

/* renamed from: com.cnlaunch.g.a */
/* loaded from: classes.dex */
public final class BLocationLogic {

    /* renamed from: a */
    static BLocationLogic f7288a;

    /* renamed from: b */
    MyLocationLogic.InterfaceC1482a f7289b;

    /* renamed from: c */
    Context f7290c;

    /* renamed from: e */
    LocationSuccessIndicator f7292e;

    /* renamed from: f */
    private LocationClient f7293f;

    /* renamed from: g */
    private Timer f7294g;

    /* renamed from: d */
    int f7291d = 0;

    /* renamed from: h */
    private long f7295h = 180000;

    /* renamed from: i */
    private BDAbstractLocationListener f7296i = new C1479c(this);

    /* renamed from: a */
    public final synchronized void m9425a(Context context, MyLocationLogic.InterfaceC1482a interfaceC1482a, LocationSuccessIndicator locationSuccessIndicator) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        m9426a();
        this.f7291d = 0;
        this.f7289b = interfaceC1482a;
        this.f7292e = locationSuccessIndicator;
        this.f7290c = context;
        Context context2 = this.f7290c;
        if (this.f7293f == null) {
            this.f7293f = new LocationClient(context2.getApplicationContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            locationClientOption.setScanSpan(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
            locationClientOption.setIsNeedAddress(true);
            locationClientOption.setIsNeedLocationDescribe(false);
            locationClientOption.setNeedDeviceDirect(false);
            locationClientOption.setLocationNotify(false);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedLocationDescribe(false);
            locationClientOption.setIsNeedLocationPoiList(false);
            locationClientOption.SetIgnoreCacheException(false);
            locationClientOption.setIsNeedAltitude(false);
            locationClientOption.setCoorType("bd09ll");
            this.f7293f.setLocOption(locationClientOption);
            this.f7293f.registerLocationListener(this.f7296i);
            this.f7293f.start();
        } else {
            this.f7293f.requestLocation();
        }
        this.f7294g = new Timer();
        this.f7294g.schedule(new C1478b(this), this.f7295h);
    }

    /* renamed from: a */
    public final synchronized void m9426a() {
        try {
            if (this.f7293f != null) {
                this.f7293f.stop();
                this.f7293f = null;
                this.f7289b = null;
            }
            if (this.f7289b != null) {
                this.f7289b = null;
            }
            if (this.f7294g != null) {
                this.f7294g.cancel();
                this.f7294g = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
