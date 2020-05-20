package com.cnlaunch.diagnosemodule.bean.SDefDSData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicDefDataStreamValueBean extends BasicBean {

    /* renamed from: sn */
    int f7281sn;
    ArrayList<Boolean> ArrValueStatus = new ArrayList<>();
    ArrayList<String> ArrValue = new ArrayList<>();

    public int getSn() {
        return this.f7281sn;
    }

    public void setSn(int i) {
        this.f7281sn = i;
    }

    public ArrayList<Boolean> getArrValueStatus() {
        return this.ArrValueStatus;
    }

    public ArrayList<String> getArrValue() {
        return this.ArrValue;
    }
}
