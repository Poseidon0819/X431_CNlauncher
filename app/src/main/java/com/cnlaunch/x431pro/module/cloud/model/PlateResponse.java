package com.cnlaunch.x431pro.module.cloud.model;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.o */
/* loaded from: classes.dex */
public class PlateResponse extends CloudBaseResponse {
    private static final long serialVersionUID = -4142226499009203348L;
    private PlateInfo data;

    public PlateInfo getData() {
        return this.data;
    }

    public void setData(PlateInfo plateInfo) {
        this.data = plateInfo;
    }
}
