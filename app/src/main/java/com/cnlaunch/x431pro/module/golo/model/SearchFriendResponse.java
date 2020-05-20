package com.cnlaunch.x431pro.module.golo.model;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.golo.model.s */
/* loaded from: classes.dex */
public class SearchFriendResponse extends BaseResponse {
    private static final long serialVersionUID = -2662074580281654164L;
    private List<SearchFriednInfo> data;

    public List<SearchFriednInfo> getData() {
        return this.data;
    }

    public void setData(List<SearchFriednInfo> list) {
        this.data = list;
    }
}
