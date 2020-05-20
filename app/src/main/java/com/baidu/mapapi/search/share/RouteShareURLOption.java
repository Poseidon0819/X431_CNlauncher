package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.route.PlanNode;

/* loaded from: classes.dex */
public class RouteShareURLOption {
    public RouteShareMode mMode;
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mPn = 0;
    public int mCityCode = -1;

    /* loaded from: classes.dex */
    public enum RouteShareMode {
        CAR_ROUTE_SHARE_MODE(0),
        FOOT_ROUTE_SHARE_MODE(1),
        CYCLE_ROUTE_SHARE_MODE(2),
        BUS_ROUTE_SHARE_MODE(3);
        

        /* renamed from: a */
        private int f5652a;

        RouteShareMode(int i) {
            this.f5652a = -1;
            this.f5652a = i;
        }

        public final int getRouteShareMode() {
            return this.f5652a;
        }
    }

    public RouteShareURLOption cityCode(int i) {
        this.mCityCode = i;
        return this;
    }

    public RouteShareURLOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public RouteShareMode getmMode() {
        return this.mMode;
    }

    /* renamed from: pn */
    public RouteShareURLOption m10953pn(int i) {
        this.mPn = i;
        return this;
    }

    public RouteShareURLOption routMode(RouteShareMode routeShareMode) {
        this.mMode = routeShareMode;
        return this;
    }

    /* renamed from: to */
    public RouteShareURLOption m10952to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
