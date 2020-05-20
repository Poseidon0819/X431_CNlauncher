package com.cnlaunch.x431pro.module.p255e.p257b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.e.b.k */
/* loaded from: classes.dex */
public class SysCardInfoResult extends BaseResponse {
    private static final long serialVersionUID = 4826340581939675927L;
    private SysCardInfoDTO sysCardInfo;

    public SysCardInfoDTO getSysCardInfo() {
        return this.sysCardInfo;
    }

    public void setSysCardInfo(SysCardInfoDTO sysCardInfoDTO) {
        this.sysCardInfo = sysCardInfoDTO;
    }
}
