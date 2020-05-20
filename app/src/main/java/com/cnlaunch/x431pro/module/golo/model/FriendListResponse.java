package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.g */
/* loaded from: classes.dex */
public class FriendListResponse extends BaseResponse {
    private static final long serialVersionUID = -2662074580281654164L;
    private List<FriendInfo> data;

    public List<FriendInfo> getData() {
        return this.data;
    }

    public void setData(List<FriendInfo> list) {
        this.data = list;
    }
}
