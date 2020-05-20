package com.baidu.mapapi.search.route;

/* loaded from: classes.dex */
public class TransitRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public String mCityName = null;
    public TransitPolicy mPolicy = TransitPolicy.EBUS_TIME_FIRST;

    /* loaded from: classes.dex */
    public enum TransitPolicy {
        EBUS_TIME_FIRST(0),
        EBUS_TRANSFER_FIRST(2),
        EBUS_WALK_FIRST(3),
        EBUS_NO_SUBWAY(4);
        

        /* renamed from: a */
        private int f5637a;

        TransitPolicy(int i) {
            this.f5637a = 0;
            this.f5637a = i;
        }

        public final int getInt() {
            return this.f5637a;
        }
    }

    public TransitRoutePlanOption city(String str) {
        this.mCityName = str;
        return this;
    }

    public TransitRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public TransitRoutePlanOption policy(TransitPolicy transitPolicy) {
        this.mPolicy = transitPolicy;
        return this;
    }

    /* renamed from: to */
    public TransitRoutePlanOption m10963to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
