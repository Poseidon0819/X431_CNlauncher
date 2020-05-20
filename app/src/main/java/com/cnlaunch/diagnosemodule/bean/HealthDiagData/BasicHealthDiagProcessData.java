package com.cnlaunch.diagnosemodule.bean.HealthDiagData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicHealthDiagProcessData extends BasicBean {
    private String timeHexData;
    private int funType = -1;
    private ArrayList<BasicHealthDiagTextBean> arrTxtData = new ArrayList<>();
    private ArrayList<BasicHealthDiagConditionDataStreamBean> arrDataStreamData = new ArrayList<>();

    public int getFunType() {
        return this.funType;
    }

    public void setFunType(int i) {
        this.funType = i;
    }

    public String getTimeHexData() {
        return this.timeHexData;
    }

    public void setTimeHexData(String str) {
        this.timeHexData = str;
    }

    public ArrayList<BasicHealthDiagTextBean> getArrTxtData() {
        return this.arrTxtData;
    }

    public ArrayList<BasicHealthDiagConditionDataStreamBean> getArrDataStreamData() {
        return this.arrDataStreamData;
    }
}
