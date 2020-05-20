package com.cnlaunch.x431pro.module.p269j;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* renamed from: com.cnlaunch.x431pro.module.j.a */
/* loaded from: classes.dex */
public class SoftMaxVersionResponse extends BaseResponse {
    private X431PadDtoSoft softMaxVersionByName;

    public X431PadDtoSoft getSoftMaxVersionByName() {
        return this.softMaxVersionByName;
    }

    public void setSoftMaxVersionByName(X431PadDtoSoft x431PadDtoSoft) {
        this.softMaxVersionByName = x431PadDtoSoft;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "SoftMaxVersionResponse{SoftMaxVersionByName=" + this.softMaxVersionByName + '}';
    }
}
