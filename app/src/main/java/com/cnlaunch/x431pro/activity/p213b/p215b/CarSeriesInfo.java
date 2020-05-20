package com.cnlaunch.x431pro.activity.p213b.p215b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.b.b.a */
/* loaded from: classes.dex */
public final class CarSeriesInfo extends AbstractC2709c {
    private int areaId;
    private String autoCode;
    private String carSeriesId;
    private String carSeriesName;
    private String configId;
    private String detailId;
    private String isHot;
    private String parentId;
    private List<CarSeriesInfo> subList;

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }

    public final String getCarSeriesId() {
        return this.carSeriesId;
    }

    public final void setCarSeriesId(String str) {
        this.carSeriesId = str;
    }

    public final String getCarSeriesName() {
        return this.carSeriesName;
    }

    public final void setCarSeriesName(String str) {
        this.carSeriesName = str;
    }

    public final String getDetailId() {
        return this.detailId;
    }

    public final void setDetailId(String str) {
        this.detailId = str;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final void setConfigId(String str) {
        this.configId = str;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final void setAreaId(int i) {
        this.areaId = i;
    }

    public final List<CarSeriesInfo> getSubList() {
        return this.subList;
    }

    public final void setSubList(List<CarSeriesInfo> list) {
        this.subList = list;
    }

    public final String getAutoCode() {
        return this.autoCode;
    }

    public final void setAutoCode(String str) {
        this.autoCode = str;
    }

    public final String getIsHot() {
        return this.isHot;
    }

    public final void setIsHot(String str) {
        this.isHot = str;
    }

    public final String toString() {
        return "CarSeriesInfo{parentId='" + this.parentId + "', carSeriesId='" + this.carSeriesId + "', carSeriesName='" + this.carSeriesName + "', isHot='" + this.isHot + "', autoCode='" + this.autoCode + "', subList=" + this.subList + ", areaId=" + this.areaId + ", configId='" + this.configId + "', detailId='" + this.detailId + "'}";
    }
}
