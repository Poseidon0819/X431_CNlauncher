package com.cnlaunch.diagnosemodule.bean.HealthDiagData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicHealthDiagConditionData extends BasicBean {
    private ArrayList<BasicHealthDiagConditionDataStreamBean> arrDs = new ArrayList<>();
    private String dataSN;

    public String getDataSN() {
        return this.dataSN;
    }

    public void setDataSN(String str) {
        this.dataSN = str;
    }

    public ArrayList<BasicHealthDiagConditionDataStreamBean> getArrDs() {
        return this.arrDs;
    }
}
