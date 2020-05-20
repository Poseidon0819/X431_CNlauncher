package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicSystemInfo extends BasicBean {
    private String biteType;
    private String clearDTCArithID;
    private String communicatePin;
    private String connecterType;
    private String protocolType;
    private String reserve;
    private String sysType;
    private String systemID;
    private String systemName;
    private String systemUUID;
    private int GGPType = -1;
    private int verInfoGGPType = -1;
    private int readDTCGGPType = -1;
    private int readDSGGPType = -1;
    private int countDataStream = -1;
    private ArrayList<BasicVinListCmdBean> arCMDEnterSys = new ArrayList<>();
    private ArrayList<BasicVinListCmdBean> arCMDExitSys = new ArrayList<>();
    private ArrayList<BasicVinListCmdBean> arIniVerInfo = new ArrayList<>();
    private ArrayList<BasicVerInfo> arrVersonInfo = new ArrayList<>();
    private ArrayList<BasicReadDTCInfoBean> arrReadDTCInfo = new ArrayList<>();
    private ArrayList<String> arCMDClearDTC = new ArrayList<>();
    private ArrayList<BasicReadDSInfoBean> arrReadDSInfo = new ArrayList<>();

    public String getConnecterType() {
        return this.connecterType;
    }

    public void setConnecterType(String str) {
        this.connecterType = str;
    }

    public int getCountDataStream() {
        return this.countDataStream;
    }

    public void setCountDataStream(int i) {
        this.countDataStream = i;
    }

    public ArrayList<BasicVinListCmdBean> getArIniVerInfo() {
        return this.arIniVerInfo;
    }

    public ArrayList<BasicVerInfo> getArrVersonInfo() {
        return this.arrVersonInfo;
    }

    public ArrayList<BasicReadDTCInfoBean> getArrReadDTCInfo() {
        return this.arrReadDTCInfo;
    }

    public ArrayList<String> getArCMDClearDTC() {
        return this.arCMDClearDTC;
    }

    public ArrayList<BasicReadDSInfoBean> getArrReadDSInfo() {
        return this.arrReadDSInfo;
    }

    public int getGGPType() {
        return this.GGPType;
    }

    public void setGGPType(int i) {
        this.GGPType = i;
    }

    public int getVerInfoGGPType() {
        return this.verInfoGGPType;
    }

    public void setVerInfoGGPType(int i) {
        this.verInfoGGPType = i;
    }

    public int getReadDTCGGPType() {
        return this.readDTCGGPType;
    }

    public void setReadDTCGGPType(int i) {
        this.readDTCGGPType = i;
    }

    public int getReadDSGGPType() {
        return this.readDSGGPType;
    }

    public void setReadDSGGPType(int i) {
        this.readDSGGPType = i;
    }

    public String getSystemID() {
        return this.systemID;
    }

    public void setSystemID(String str) {
        this.systemID = str;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(String str) {
        this.systemName = str;
    }

    public String getSystemUUID() {
        return this.systemUUID;
    }

    public void setSystemUUID(String str) {
        this.systemUUID = str;
    }

    public String getSysType() {
        return this.sysType;
    }

    public void setSysType(String str) {
        this.sysType = str;
    }

    public String getProtocolType() {
        return this.protocolType;
    }

    public void setProtocolType(String str) {
        this.protocolType = str;
    }

    public String getCommunicatePin() {
        return this.communicatePin;
    }

    public void setCommunicatePin(String str) {
        this.communicatePin = str;
    }

    public String getBiteType() {
        return this.biteType;
    }

    public void setBiteType(String str) {
        this.biteType = str;
    }

    public String getReserve() {
        return this.reserve;
    }

    public void setReserve(String str) {
        this.reserve = str;
    }

    public String getClearDTCArithID() {
        return this.clearDTCArithID;
    }

    public void setClearDTCArithID(String str) {
        this.clearDTCArithID = str;
    }

    public ArrayList<BasicVinListCmdBean> getArCMDEnterSys() {
        return this.arCMDEnterSys;
    }

    public ArrayList<BasicVinListCmdBean> getArCMDExitSys() {
        return this.arCMDExitSys;
    }
}
