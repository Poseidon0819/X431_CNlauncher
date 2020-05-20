package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.b */
/* loaded from: classes.dex */
public class AddFriendResponse extends BaseResponse {
    private static final long serialVersionUID = -2662074580281654164L;
    private AddFriendInfo data;

    public AddFriendInfo getData() {
        return this.data;
    }

    public void setData(AddFriendInfo addFriendInfo) {
        this.data = addFriendInfo;
    }
}
