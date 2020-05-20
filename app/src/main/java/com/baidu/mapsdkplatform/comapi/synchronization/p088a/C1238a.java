package com.baidu.mapsdkplatform.comapi.synchronization.p088a;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapapi.synchronization.SynchronizationDisplayListener;
import com.baidu.mapsdkplatform.comapi.synchronization.data.C1278f;
import com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1277e;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.baidu.mapsdkplatform.comapi.synchronization.render.C1289c;
import com.baidu.mapsdkplatform.comapi.synchronization.render.InterfaceC1288b;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.a.a */
/* loaded from: classes.dex */
public class C1238a implements InterfaceC1277e, InterfaceC1288b {

    /* renamed from: a */
    private static final String f6142a = "a";

    /* renamed from: b */
    private C1278f f6143b;

    /* renamed from: c */
    private C1289c f6144c;

    /* renamed from: d */
    private SynchronizationDisplayListener f6145d;

    public C1238a(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f6143b = null;
        this.f6144c = null;
        if (context == null) {
            throw new IllegalArgumentException("Context invalid, please check!");
        }
        if (baiduMap == null || !(baiduMap instanceof BaiduMap)) {
            throw new IllegalArgumentException("BaiduMap is null or invalid, please check!");
        }
        if (!m10545b(roleOptions)) {
            throw new IllegalArgumentException("RoleOptions is invalid, please check!");
        }
        this.f6143b = new C1278f(roleOptions, displayOptions);
        this.f6143b.m10311a(this);
        this.f6144c = new C1289c(context, baiduMap);
        this.f6144c.m10143a(this);
    }

    /* renamed from: a */
    private boolean m10553a(LatLng latLng, RoleOptions roleOptions) {
        double d;
        if (latLng == null) {
            return false;
        }
        double d2 = 90.0d;
        double d3 = -90.0d;
        double d4 = 180.0d;
        double d5 = -180.0d;
        double d6 = 0.0d;
        if (SyncCoordinateConverter.CoordType.COMMON == roleOptions.getCoordType()) {
            SyncCoordinateConverter syncCoordinateConverter = new SyncCoordinateConverter();
            LatLng convert = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(-90.0d, -180.0d)).convert();
            d5 = convert.longitude;
            d3 = convert.latitude;
            LatLng convert2 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(90.0d, 180.0d)).convert();
            d4 = convert2.longitude;
            d2 = convert2.latitude;
            LatLng convert3 = syncCoordinateConverter.from(roleOptions.getCoordType()).coord(new LatLng(0.0d, 0.0d)).convert();
            d6 = convert3.longitude;
            d = convert3.latitude;
        } else {
            d = 0.0d;
        }
        return !(Double.valueOf(d6).compareTo(Double.valueOf(latLng.longitude)) == 0 && Double.valueOf(d).compareTo(Double.valueOf(latLng.latitude)) == 0) && latLng.longitude >= d5 && latLng.longitude <= d4 && latLng.latitude >= d3 && latLng.latitude <= d2;
    }

    /* renamed from: a */
    private boolean m10550a(SyncCoordinateConverter.CoordType coordType) {
        return SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType;
    }

    /* renamed from: b */
    private boolean m10545b(RoleOptions roleOptions) {
        if (roleOptions == null || roleOptions.getOrderId() == null || roleOptions.getOrderId().equals("") || roleOptions.getRoleType() != 0 || roleOptions.getDriverId() == null || roleOptions.getDriverId().equals("") || roleOptions.getUserId() == null || roleOptions.getUserId().equals("") || !m10550a(roleOptions.getCoordType()) || !m10553a(roleOptions.getStartPosition(), roleOptions)) {
            if (roleOptions == null) {
                C1255a.m10453b(f6142a, "The roleOptions is null");
                return false;
            }
            String str = f6142a;
            C1255a.m10453b(str, "The roleOptions content is: OrderId = " + roleOptions.getOrderId() + "; DriverId = " + roleOptions.getDriverId() + "; UserId = " + roleOptions.getUserId() + "; StartPosition = " + roleOptions.getStartPosition() + "; EndPosition = " + roleOptions.getEndPosition() + "; DriverPosition = " + roleOptions.getDriverPosition() + "; CoordType = " + roleOptions.getCoordType());
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private boolean m10537e(int i) {
        return i >= 0 && i <= 5;
    }

    /* renamed from: a */
    public void m10556a() {
        C1255a.m10457a(f6142a, "onResume");
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10316a();
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10145a();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1277e
    /* renamed from: a */
    public void mo10319a(float f, long j) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onRoutePlanInfoFreshFinished(f, j);
        }
    }

    /* renamed from: a */
    public void m10555a(int i) {
        C1255a.m10452c(f6142a, "The order state = ".concat(String.valueOf(i)));
        if (!m10537e(i)) {
            SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
            if (synchronizationDisplayListener != null) {
                synchronizationDisplayListener.onSynchronizationProcessResult(1002, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_STATE_INVALID);
            }
            i = 0;
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10144a(i);
        }
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10315a(i);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.render.InterfaceC1288b
    /* renamed from: a */
    public void mo10146a(int i, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i, str);
        }
    }

    /* renamed from: a */
    public void m10554a(View view) {
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10314a(view);
        }
    }

    /* renamed from: a */
    public void m10552a(DisplayOptions displayOptions) {
        C1278f c1278f = this.f6143b;
        if (c1278f == null || displayOptions == null) {
            return;
        }
        c1278f.m10313a(displayOptions);
    }

    /* renamed from: a */
    public void m10551a(RoleOptions roleOptions) {
        if (roleOptions == null || !m10545b(roleOptions)) {
            SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
            if (synchronizationDisplayListener != null) {
                synchronizationDisplayListener.onSynchronizationProcessResult(1003, SynchronizationConstants.LBS_STATUS_MESSAGE_ORDER_PARAM_INVALID);
                return;
            }
            return;
        }
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10312a(roleOptions);
        }
    }

    /* renamed from: a */
    public void m10549a(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (synchronizationDisplayListener != null) {
            this.f6145d = synchronizationDisplayListener;
        } else {
            C1255a.m10453b(f6142a, "SynchronizationDisplayListener is null, must be applied.");
            throw new IllegalArgumentException("synchronizationDisplayListener is null");
        }
    }

    /* renamed from: b */
    public void m10548b() {
        C1255a.m10457a(f6142a, "onPause");
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10310b();
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10142b();
        }
    }

    /* renamed from: b */
    public void m10547b(int i) {
        if (i < 5) {
            i = 5;
        }
        if (i > 30) {
            i = 30;
        }
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10309b(i);
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10141b(i);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1277e
    /* renamed from: b */
    public void mo10318b(int i, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i, str);
        }
    }

    /* renamed from: b */
    public void m10546b(View view) {
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10308b(view);
        }
    }

    /* renamed from: b */
    public void m10544b(SynchronizationDisplayListener synchronizationDisplayListener) {
        if (this.f6145d != null) {
            this.f6145d = null;
        }
    }

    /* renamed from: c */
    public void m10543c() {
        C1255a.m10457a(f6142a, "release");
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10307c();
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10135f();
        }
        if (this.f6145d != null) {
            this.f6145d = null;
        }
    }

    /* renamed from: c */
    public void m10542c(int i) {
        if (i < 10) {
            i = 10;
        }
        if (i > 30) {
            i = 30;
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10139c(i);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1277e
    /* renamed from: c */
    public void mo10317c(int i, String str) {
        SynchronizationDisplayListener synchronizationDisplayListener = this.f6145d;
        if (synchronizationDisplayListener != null) {
            synchronizationDisplayListener.onSynchronizationProcessResult(i, str);
        }
    }

    /* renamed from: c */
    public void m10541c(View view) {
        C1278f c1278f = this.f6143b;
        if (c1278f != null) {
            c1278f.m10306c(view);
        }
    }

    /* renamed from: d */
    public Marker m10540d() {
        C1289c c1289c = this.f6144c;
        if (c1289c == null) {
            C1255a.m10453b(f6142a, "Data manager instance is null");
            return null;
        }
        return c1289c.m10140c();
    }

    /* renamed from: d */
    public void m10539d(int i) {
        if (i < 5) {
            i = 5;
        }
        if (i > 30) {
            i = 30;
        }
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10137d(i);
        }
    }

    /* renamed from: e */
    public Marker m10538e() {
        C1289c c1289c = this.f6144c;
        if (c1289c == null) {
            C1255a.m10453b(f6142a, "Data manager instance is null");
            return null;
        }
        return c1289c.m10138d();
    }

    /* renamed from: f */
    public Marker m10536f() {
        C1289c c1289c = this.f6144c;
        if (c1289c == null) {
            C1255a.m10453b(f6142a, "Data manager instance is null");
            return null;
        }
        return c1289c.m10136e();
    }

    /* renamed from: g */
    public void m10535g() {
        C1289c c1289c = this.f6144c;
        if (c1289c != null) {
            c1289c.m10134g();
        }
    }
}
