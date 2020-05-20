package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicVoltagePinBean extends BasicBean {
    private int dataType;
    private ArrayList<VoltageBpsBean> voltageBpsBeanArrayList = new ArrayList<>();

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public ArrayList<VoltageBpsBean> getVoltageBpsBeanArrayList() {
        return this.voltageBpsBeanArrayList;
    }

    public void setVoltageBpsBeanArrayList(ArrayList<VoltageBpsBean> arrayList) {
        this.voltageBpsBeanArrayList = arrayList;
    }
}
