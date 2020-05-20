package com.baidu.mapapi.search.route;

import java.util.List;

/* loaded from: classes.dex */
public class DrivingRoutePlanOption {
    public String mCityName;
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public DrivingPolicy mPolicy = DrivingPolicy.ECAR_TIME_FIRST;
    public List<PlanNode> mWayPoints = null;
    public DrivingTrafficPolicy mtrafficPolicy = DrivingTrafficPolicy.ROUTE_PATH;

    /* loaded from: classes.dex */
    public enum DrivingPolicy {
        ECAR_AVOID_JAM(3),
        ECAR_TIME_FIRST(0),
        ECAR_DIS_FIRST(1),
        ECAR_FEE_FIRST(2);
        

        /* renamed from: a */
        private int f5568a;

        DrivingPolicy(int i) {
            this.f5568a = i;
        }

        public final int getInt() {
            return this.f5568a;
        }
    }

    /* loaded from: classes.dex */
    public enum DrivingTrafficPolicy {
        ROUTE_PATH(0),
        ROUTE_PATH_AND_TRAFFIC(1);
        

        /* renamed from: a */
        private int f5570a;

        DrivingTrafficPolicy(int i) {
            this.f5570a = i;
        }

        public final int getInt() {
            return this.f5570a;
        }
    }

    public DrivingRoutePlanOption currentCity(String str) {
        this.mCityName = str;
        return this;
    }

    public DrivingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public DrivingRoutePlanOption passBy(List<PlanNode> list) {
        this.mWayPoints = list;
        return this;
    }

    public DrivingRoutePlanOption policy(DrivingPolicy drivingPolicy) {
        this.mPolicy = drivingPolicy;
        return this;
    }

    /* renamed from: to */
    public DrivingRoutePlanOption m10990to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }

    public DrivingRoutePlanOption trafficPolicy(DrivingTrafficPolicy drivingTrafficPolicy) {
        this.mtrafficPolicy = drivingTrafficPolicy;
        return this;
    }
}
