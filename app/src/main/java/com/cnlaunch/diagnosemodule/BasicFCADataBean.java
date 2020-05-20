package com.cnlaunch.diagnosemodule;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicFCADataBean extends BasicBean {
    private String Vin;
    private String hexCertificate;
    private String hexUUID;
    private String policyType;
    private String sgwSn;
    private int funType = 0;
    private ArrayList<FCACMDData> arrCmdData = new ArrayList<>();

    public ArrayList<FCACMDData> getArrCmdData() {
        return this.arrCmdData;
    }

    public int getFunType() {
        return this.funType;
    }

    public void setFunType(int i) {
        this.funType = i;
    }

    public String getHexUUID() {
        return this.hexUUID;
    }

    public void setHexUUID(String str) {
        this.hexUUID = str;
    }

    public String getSgwSn() {
        return this.sgwSn;
    }

    public void setSgwSn(String str) {
        this.sgwSn = str;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public void setPolicyType(String str) {
        this.policyType = str;
    }

    public String getVin() {
        return this.Vin;
    }

    public void setVin(String str) {
        this.Vin = str;
    }

    public String getHexCertificate() {
        return this.hexCertificate;
    }

    public void setHexCertificate(String str) {
        this.hexCertificate = str;
    }

    /* loaded from: classes.dex */
    public static class FCACMDData extends BasicBean {
        private String cmd;

        /* renamed from: sn */
        private int f7264sn;

        public int getSn() {
            return this.f7264sn;
        }

        public void setSn(int i) {
            this.f7264sn = i;
        }

        public String getCmd() {
            return this.cmd;
        }

        public void setCmd(String str) {
            this.cmd = str;
        }
    }
}
