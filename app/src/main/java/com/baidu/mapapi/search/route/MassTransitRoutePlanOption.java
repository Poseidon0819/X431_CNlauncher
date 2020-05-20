package com.baidu.mapapi.search.route;

/* loaded from: classes.dex */
public class MassTransitRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public String mCoordType = "bd09ll";
    public TacticsIncity mTacticsIncity = TacticsIncity.ETRANS_SUGGEST;
    public TacticsIntercity mTacticsIntercity = TacticsIntercity.ETRANS_LEAST_TIME;
    public TransTypeIntercity mTransTypeIntercity = TransTypeIntercity.ETRANS_TRAIN_FIRST;
    public int mPageSize = 10;
    public int mPageIndex = 1;

    /* loaded from: classes.dex */
    public enum TacticsIncity {
        ETRANS_SUGGEST(0),
        ETRANS_LEAST_TRANSFER(1),
        ETRANS_LEAST_WALK(2),
        ETRANS_NO_SUBWAY(3),
        ETRANS_LEAST_TIME(4),
        ETRANS_SUBWAY_FIRST(5);
        

        /* renamed from: a */
        private int f5607a;

        TacticsIncity(int i) {
            this.f5607a = 0;
            this.f5607a = i;
        }

        public final int getInt() {
            return this.f5607a;
        }
    }

    /* loaded from: classes.dex */
    public enum TacticsIntercity {
        ETRANS_LEAST_TIME(0),
        ETRANS_START_EARLY(1),
        ETRANS_LEAST_PRICE(2);
        

        /* renamed from: a */
        private int f5609a;

        TacticsIntercity(int i) {
            this.f5609a = 0;
            this.f5609a = i;
        }

        public final int getInt() {
            return this.f5609a;
        }
    }

    /* loaded from: classes.dex */
    public enum TransTypeIntercity {
        ETRANS_TRAIN_FIRST(0),
        ETRANS_PLANE_FIRST(1),
        ETRANS_COACH_FIRST(2);
        

        /* renamed from: a */
        private int f5611a;

        TransTypeIntercity(int i) {
            this.f5611a = 0;
            this.f5611a = i;
        }

        public final int getInt() {
            return this.f5611a;
        }
    }

    @Deprecated
    public MassTransitRoutePlanOption coordType(String str) {
        this.mCoordType = str;
        return this;
    }

    public MassTransitRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public MassTransitRoutePlanOption pageIndex(int i) {
        if (i >= 0 && i <= 2147483646) {
            this.mPageIndex = i + 1;
        }
        return this;
    }

    public MassTransitRoutePlanOption pageSize(int i) {
        if (i > 0 && i <= 10) {
            this.mPageSize = i;
        }
        return this;
    }

    public MassTransitRoutePlanOption tacticsIncity(TacticsIncity tacticsIncity) {
        this.mTacticsIncity = tacticsIncity;
        return this;
    }

    public MassTransitRoutePlanOption tacticsIntercity(TacticsIntercity tacticsIntercity) {
        this.mTacticsIntercity = tacticsIntercity;
        return this;
    }

    /* renamed from: to */
    public MassTransitRoutePlanOption m10974to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }

    public MassTransitRoutePlanOption transtypeintercity(TransTypeIntercity transTypeIntercity) {
        this.mTransTypeIntercity = transTypeIntercity;
        return this;
    }
}
