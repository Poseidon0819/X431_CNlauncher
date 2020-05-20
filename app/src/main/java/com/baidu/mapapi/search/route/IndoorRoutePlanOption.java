package com.baidu.mapapi.search.route;

/* loaded from: classes.dex */
public class IndoorRoutePlanOption {
    public IndoorPlanNode mFrom = null;
    public IndoorPlanNode mTo = null;

    public IndoorRoutePlanOption from(IndoorPlanNode indoorPlanNode) {
        this.mFrom = indoorPlanNode;
        return this;
    }

    /* renamed from: to */
    public IndoorRoutePlanOption m10984to(IndoorPlanNode indoorPlanNode) {
        this.mTo = indoorPlanNode;
        return this;
    }
}
