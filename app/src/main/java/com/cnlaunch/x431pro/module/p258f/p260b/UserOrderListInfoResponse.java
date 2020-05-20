package com.cnlaunch.x431pro.module.p258f.p260b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.f.b.w */
/* loaded from: classes.dex */
public class UserOrderListInfoResponse extends BaseResponse {
    private List<UserOrderDTO> orderList;

    public List<UserOrderDTO> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<UserOrderDTO> list) {
        this.orderList = list;
    }
}
