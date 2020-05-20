package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class BasicVinListCmdBean extends BasicBean {
    private String arithID;
    private String cmdAtt;
    private String cmdData;
    private String cmdType;

    public String getCmdAtt() {
        return this.cmdAtt;
    }

    public void setCmdAtt(String str) {
        this.cmdAtt = str;
    }

    public String getCmdType() {
        return this.cmdType;
    }

    public void setCmdType(String str) {
        this.cmdType = str;
    }

    public String getArithID() {
        return this.arithID;
    }

    public void setArithID(String str) {
        this.arithID = str;
    }

    public String getCmdData() {
        return this.cmdData;
    }

    public void setCmdData(String str) {
        this.cmdData = str;
    }
}
