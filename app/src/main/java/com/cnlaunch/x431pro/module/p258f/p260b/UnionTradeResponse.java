package com.cnlaunch.x431pro.module.p258f.p260b;

import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.t */
/* loaded from: classes.dex */
public class UnionTradeResponse extends CyBaseResponse {
    private static final long serialVersionUID = 7928711858736656421L;
    @JsonProperty("WSResult")
    private UnionTradeResult wsresult;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UnionTradeResult getWsresult() {
        return this.wsresult;
    }

    public void setWsresult(UnionTradeResult unionTradeResult) {
        this.wsresult = unionTradeResult;
    }
}
