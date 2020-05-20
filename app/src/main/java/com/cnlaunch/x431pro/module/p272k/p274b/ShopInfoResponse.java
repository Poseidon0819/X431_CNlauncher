package com.cnlaunch.x431pro.module.p272k.p274b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.k.b.p */
/* loaded from: classes.dex */
public class ShopInfoResponse extends BaseResponse {
    private ShopInfo data;
    private String msg;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public ShopInfo getData() {
        return this.data;
    }

    public void setData(ShopInfo shopInfo) {
        this.data = shopInfo;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BaseResponse
    public String toString() {
        return "ShopInfoResponse{msg='" + this.msg + "', data=" + this.data + '}';
    }
}
