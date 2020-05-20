package com.cnlaunch.x431pro.module.config.p250b;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;

/* renamed from: com.cnlaunch.x431pro.module.config.b.b */
/* loaded from: classes.dex */
public class ConfigRespose extends BaseResponse {
    private static final long serialVersionUID = 1661977668398668824L;
    private ConfigData data;

    public ConfigData getData() {
        return this.data;
    }

    public void setData(ConfigData configData) {
        this.data = configData;
    }
}
