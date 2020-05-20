package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicSystemStatusBean extends BasicBean {
    private static final long serialVersionUID = 1;
    private String systemId = "";
    private String systemName = "";
    private String systemUUID = "";
    private ArrayList<BasicFaultCodeBean> faultCodesList = new ArrayList<>();
    private String systemType = "";
    private String currVIN = "";
    private String oldVIN = "";
    private ArrayList<BasicECUInfoBean> ECUInfoList = new ArrayList<>();
    private ArrayList<String> systemInfoList = new ArrayList<>();
    private int totleCount = -1;
    private int currentNum = -1;
    private int isNew = -1;
    private boolean isAdd = false;
    private String infoForMIL = "";
    private boolean helpEnable = false;
    private boolean clearEnable = false;
    private boolean isFaultCodeOnline = false;
    private ArrayList<BasicOnlineCodeLib> OnlineFaultCodeList = new ArrayList<>();
    private ArrayList<BasicDataStreamBean> DataStreamInfoList = new ArrayList<>();

    public ArrayList<BasicOnlineCodeLib> getOnlineFaultCodeList() {
        return this.OnlineFaultCodeList;
    }

    public boolean isFaultCodeOnline() {
        return this.isFaultCodeOnline;
    }

    public String getInfoForMIL() {
        return this.infoForMIL;
    }

    public void setInfoForMIL(String str) {
        this.infoForMIL = str;
    }

    public void setFaultCodeOnline(boolean z) {
        this.isFaultCodeOnline = z;
    }

    public ArrayList<String> getSystemInfoList() {
        return this.systemInfoList;
    }

    public ArrayList<BasicDataStreamBean> getDataStreamInfoList() {
        return this.DataStreamInfoList;
    }

    public void setDataStreamInfoList(ArrayList<BasicDataStreamBean> arrayList) {
        this.DataStreamInfoList.clear();
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            this.DataStreamInfoList.add(arrayList.get(i));
        }
    }

    public void setSystemID(String str) {
        this.systemId = str;
    }

    public String getSystemID() {
        return this.systemId;
    }

    public void setSystemUUID(String str) {
        this.systemUUID = str;
    }

    public String getSystemUUID() {
        return this.systemUUID;
    }

    public void setSystemName(String str) {
        this.systemName = str;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setIsAdd(boolean z) {
        this.isAdd = z;
    }

    public boolean getIsAdd() {
        return this.isAdd;
    }

    public void setIsNew(int i) {
        this.isNew = i;
    }

    public int getIsNew() {
        return this.isNew;
    }

    public void setCurrentNum(int i) {
        this.currentNum = i;
    }

    public int getCurrentNum() {
        return this.currentNum;
    }

    public void setTotleCount(int i) {
        this.totleCount = i;
    }

    public int getTotleCount() {
        return this.totleCount;
    }

    public void setCurrVIN(String str) {
        this.currVIN = str;
    }

    public String getCurrVIN() {
        return this.currVIN;
    }

    public void setOldVIN(String str) {
        this.oldVIN = str;
    }

    public String getOldVIN() {
        return this.oldVIN;
    }

    public void setSystemType(String str) {
        this.systemType = str;
    }

    public String getSystemType() {
        return this.systemType;
    }

    public ArrayList<BasicFaultCodeBean> getSystemFaultCodeBean() {
        return this.faultCodesList;
    }

    public void setSystemFaultCodeBean(ArrayList<BasicFaultCodeBean> arrayList) {
        this.faultCodesList.clear();
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            this.faultCodesList.add(arrayList.get(i));
        }
    }

    public ArrayList<BasicECUInfoBean> getSystemECUInfoBean() {
        return this.ECUInfoList;
    }

    public void setSystemECUInfoBean(ArrayList<BasicECUInfoBean> arrayList) {
        this.ECUInfoList.clear();
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            this.ECUInfoList.add(arrayList.get(i));
        }
    }

    public void setClearEnable(boolean z) {
        this.clearEnable = z;
    }

    public boolean getClearEnable() {
        return this.clearEnable;
    }

    public void setHelpEnable(boolean z) {
        this.helpEnable = z;
    }

    public boolean getHelpEnable() {
        return this.helpEnable;
    }

    public String SystemBeanToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nname : " + this.systemName);
        sb.append(" sysid:" + this.systemId);
        sb.append(" uuID:" + this.systemUUID);
        sb.append(" systemType:" + this.systemType);
        sb.append("\n ECUs:\n ");
        for (int i = 0; i < getSystemECUInfoBean().size(); i++) {
            BasicECUInfoBean basicECUInfoBean = getSystemECUInfoBean().get(i);
            sb.append("title:" + basicECUInfoBean.getTitle());
            sb.append(" value:" + basicECUInfoBean.getValue() + "\n");
        }
        sb.append("\n FaultCodes:\n ");
        for (int i2 = 0; i2 < getSystemFaultCodeBean().size(); i2++) {
            BasicFaultCodeBean basicFaultCodeBean = getSystemFaultCodeBean().get(i2);
            sb.append("title:" + basicFaultCodeBean.getTitle());
            sb.append(" context:" + basicFaultCodeBean.getContext());
            sb.append(" status:" + basicFaultCodeBean.getStatus() + "\n");
            if (basicFaultCodeBean.getDataStreamInfoList().size() > 0) {
                sb.append(" Freedom DataStreams:\n ");
                for (int i3 = 0; i3 < basicFaultCodeBean.getDataStreamInfoList().size(); i3++) {
                    BasicDataStreamBean basicDataStreamBean = basicFaultCodeBean.getDataStreamInfoList().get(i3);
                    sb.append("title:" + basicDataStreamBean.getTitle());
                    sb.append(" Value:" + basicDataStreamBean.getSrcValue());
                    sb.append(" unit:" + basicDataStreamBean.getSrcUnit() + "\n");
                }
            }
        }
        sb.append("\n DataStreams:\n ");
        for (int i4 = 0; i4 < getDataStreamInfoList().size(); i4++) {
            BasicDataStreamBean basicDataStreamBean2 = getDataStreamInfoList().get(i4);
            sb.append("title:" + basicDataStreamBean2.getTitle());
            sb.append(" Value:" + basicDataStreamBean2.getSrcValue());
            sb.append(" unit:" + basicDataStreamBean2.getSrcUnit() + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
