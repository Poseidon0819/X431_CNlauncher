package com.baidu.mapapi.synchronization.histroytrace;

/* loaded from: classes.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a */
    private String f5750a = null;

    /* renamed from: b */
    private int f5751b = 0;

    /* renamed from: c */
    private String f5752c = null;

    /* renamed from: d */
    private String f5753d = null;

    /* renamed from: e */
    private int f5754e = 4;

    /* renamed from: f */
    private int f5755f = 5;

    public int getCurrentOrderState() {
        return this.f5755f;
    }

    public String getDriverId() {
        return this.f5753d;
    }

    public String getOrderId() {
        return this.f5750a;
    }

    public int getQueryOrderState() {
        return this.f5754e;
    }

    public int getRoleType() {
        return this.f5751b;
    }

    public String getUserId() {
        return this.f5752c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f5755f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f5753d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f5750a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.f5754e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.f5751b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f5752c = str;
        return this;
    }
}
