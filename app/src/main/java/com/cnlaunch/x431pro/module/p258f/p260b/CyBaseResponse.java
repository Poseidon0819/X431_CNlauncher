package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import org.codehaus.jackson.annotate.JsonProperty;

/* renamed from: com.cnlaunch.x431pro.module.f.b.c */
/* loaded from: classes.dex */
public class CyBaseResponse extends AbstractC2709c {
    @JsonProperty("cyResult")
    CyResultBase cyresult;

    public CyResultBase getCyresult() {
        return this.cyresult;
    }

    public void setCyresult(CyResultBase cyResultBase) {
        this.cyresult = cyResultBase;
    }

    public String toString() {
        return "CyBaseResponse{cyresult=" + this.cyresult + '}';
    }
}
