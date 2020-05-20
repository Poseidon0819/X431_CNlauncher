package com.cnlaunch.diagnosemodule.bean.SDefDSData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicDefDataStreamInfoBean extends BasicBean {
    private int allDsAttr;
    private ArrayList<BasicDefDataStreamBean> arrDs = new ArrayList<>();
    private int maxDiagSupCount;

    public int getAllDsAttr() {
        return this.allDsAttr;
    }

    public void setAllDsAttr(int i) {
        this.allDsAttr = i;
    }

    public int getMaxDiagSupCount() {
        return this.maxDiagSupCount;
    }

    public void setMaxDiagSupCount(int i) {
        this.maxDiagSupCount = i;
    }

    public ArrayList<BasicDefDataStreamBean> getArrDs() {
        return this.arrDs;
    }
}
