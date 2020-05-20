package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.l */
/* loaded from: classes.dex */
public class GoloRemoteOrderResponse extends BaseResponse {
    private static final long serialVersionUID = 2864289568863676056L;
    private List<GoloRemoteOrderInfo> data;
    private String msg = "";

    public List<GoloRemoteOrderInfo> getData() {
        return this.data;
    }

    public void setData(List<GoloRemoteOrderInfo> list) {
        this.data = list;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
