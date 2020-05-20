package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.p096d.C1361j;
import com.baidu.platform.core.p096d.InterfaceC1356e;

/* loaded from: classes.dex */
public class RoutePlanSearch extends C1115a {

    /* renamed from: b */
    private boolean f5622b = false;

    /* renamed from: a */
    private InterfaceC1356e f5621a = new C1361j();

    RoutePlanSearch() {
    }

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        if (this.f5621a != null) {
            if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || bikingRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option , origin or destination can not be null");
            }
            if (bikingRoutePlanOption.mFrom.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName() == "")) {
                throw new IllegalArgumentException("route plan option , origin is illegal");
            }
            if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName() == "")) {
                throw new IllegalArgumentException("route plan option , destination is illegal");
            }
            return this.f5621a.mo9834a(bikingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public void destroy() {
        if (this.f5622b) {
            return;
        }
        this.f5622b = true;
        this.f5621a.mo9835a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        if (this.f5621a != null) {
            if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option , origin or destination can not be null");
            }
            return this.f5621a.mo9833a(drivingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        if (this.f5621a != null) {
            if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || massTransitRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option,origin or destination can not be null");
            }
            if (massTransitRoutePlanOption.mFrom.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
                throw new IllegalArgumentException("route plan option,origin is illegal");
            }
            if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
                throw new IllegalArgumentException("route plan option,destination is illegal");
            }
            return this.f5621a.mo9831a(massTransitRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        InterfaceC1356e interfaceC1356e = this.f5621a;
        if (interfaceC1356e == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (onGetRoutePlanResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1356e.mo9830a(onGetRoutePlanResultListener);
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        if (this.f5621a != null) {
            if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option,origin or destination or city can not be null");
            }
            return this.f5621a.mo9829a(transitRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        if (this.f5621a != null) {
            if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("option , origin or destination can not be null");
            }
            return this.f5621a.mo9832a(indoorRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        if (this.f5621a != null) {
            if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("option , origin or destination can not be null");
            }
            return this.f5621a.mo9828a(walkingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }
}
