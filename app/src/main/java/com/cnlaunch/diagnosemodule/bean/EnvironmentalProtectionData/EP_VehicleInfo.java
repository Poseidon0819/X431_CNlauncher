package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EP_VehicleInfo extends BasicBean {
    private String ODO;
    private ArrayList<EP_ECUInfoBean> arrECU = new ArrayList<>();
    private String clearDTCODO;
    private int faultCodeLampStatus;
    private int ignition_Type;
    private String obd_req;

    public ArrayList<EP_ECUInfoBean> getArrECU() {
        return this.arrECU;
    }

    public String getODO() {
        return this.ODO;
    }

    public void setODO(String str) {
        this.ODO = str;
    }

    public String getClearDTCODO() {
        return this.clearDTCODO;
    }

    public void setClearDTCODO(String str) {
        this.clearDTCODO = str;
    }

    public String getObd_req() {
        return this.obd_req;
    }

    public void setObd_req(String str) {
        this.obd_req = str;
    }

    public int getIgnition_Type() {
        return this.ignition_Type;
    }

    public void setIgnition_Type(int i) {
        this.ignition_Type = i;
    }

    public int getFaultCodeLampStatus() {
        return this.faultCodeLampStatus;
    }

    public void setFaultCodeLampStatus(int i) {
        this.faultCodeLampStatus = i;
    }

    public void setArrECU(ArrayList<EP_ECUInfoBean> arrayList) {
        this.arrECU = arrayList;
    }
}
