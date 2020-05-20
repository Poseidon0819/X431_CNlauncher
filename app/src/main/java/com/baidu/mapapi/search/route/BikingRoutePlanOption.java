package com.baidu.mapapi.search.route;

/* loaded from: classes.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i) {
        this.mRidingType = i;
        return this;
    }

    /* renamed from: to */
    public BikingRoutePlanOption m10997to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
