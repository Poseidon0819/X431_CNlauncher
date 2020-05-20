package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicEmissionDetectBean extends BasicBean {
    private static final long serialVersionUID = 1;
    ArrayList<BasicDataStreamBean> arDataStream = new ArrayList<>();
    ArrayList<BasicFaultCodeBean> arFaultCode = new ArrayList<>();
    String context;
    int dataTye;
    int ratio;
    int state;

    public void setContext(String str) {
        this.context = str;
    }

    public String getContext() {
        return this.context;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public void setRatio(int i) {
        this.ratio = i;
    }

    public int getRatio() {
        return this.ratio;
    }

    public void setDataTye(int i) {
        this.dataTye = i;
    }

    public int getDataTye() {
        return this.dataTye;
    }

    public ArrayList<BasicDataStreamBean> getArrayListDataStream() {
        return this.arDataStream;
    }

    public void setDataStreamToArrayList(BasicDataStreamBean basicDataStreamBean) {
        this.arDataStream.add(basicDataStreamBean);
    }

    public ArrayList<BasicFaultCodeBean> getArrayListFaultCode() {
        return this.arFaultCode;
    }

    public void setFaultCodeToArrayList(BasicFaultCodeBean basicFaultCodeBean) {
        this.arFaultCode.add(basicFaultCodeBean);
    }
}
