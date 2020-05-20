package com.baidu.mapapi.search.route;

/* loaded from: classes.dex */
public class WalkingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;

    public WalkingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    /* renamed from: to */
    public WalkingRoutePlanOption m10956to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
