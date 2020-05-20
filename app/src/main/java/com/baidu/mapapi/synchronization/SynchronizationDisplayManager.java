package com.baidu.mapapi.synchronization;

import android.content.Context;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapsdkplatform.comapi.synchronization.p088a.C1238a;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;

/* loaded from: classes.dex */
public class SynchronizationDisplayManager {

    /* renamed from: a */
    private static final String f5721a = "SynchronizationDisplayManager";

    /* renamed from: b */
    private C1238a f5722b;

    public SynchronizationDisplayManager(Context context, BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f5722b = new C1238a(context, baiduMap, roleOptions, displayOptions);
    }

    public void adjustVisibleSpanByUser() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10535g();
        }
    }

    public Marker getCarMarker() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
            return null;
        }
        return c1238a.m10536f();
    }

    public Marker getEndPositionMarker() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
            return null;
        }
        return c1238a.m10538e();
    }

    public Marker getStartPositionMarker() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
            return null;
        }
        return c1238a.m10540d();
    }

    public void onPause() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10548b();
        }
    }

    public void onResume() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10556a();
        }
    }

    public void registerSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10549a(synchronizationDisplayListener);
        }
    }

    public void release() {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10543c();
        }
    }

    public void setDriverPositionFreshFrequency(int i) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10547b(i);
        }
    }

    public void setOperatedMapFrozenInterval(int i) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10542c(i);
        }
    }

    public void setUnOperatedMapFrozenInterval(int i) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10539d(i);
        }
    }

    public void unRegisterSynchronizationDisplayListener(SynchronizationDisplayListener synchronizationDisplayListener) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10544b(synchronizationDisplayListener);
        }
    }

    public void updateCarPositionInfoWindowView(View view) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10541c(view);
        }
    }

    public void updateDisplayOptions(DisplayOptions displayOptions) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10552a(displayOptions);
        }
    }

    public void updateEndPositionInfoWindowView(View view) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10546b(view);
        }
    }

    public void updateOrderState(int i) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10555a(i);
        }
    }

    public void updateRoleOptions(RoleOptions roleOptions) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10551a(roleOptions);
        }
    }

    public void updateStartPositionInfoWindowView(View view) {
        C1238a c1238a = this.f5722b;
        if (c1238a == null) {
            C1255a.m10453b(f5721a, "The implement instance is null");
        } else {
            c1238a.m10554a(view);
        }
    }
}
