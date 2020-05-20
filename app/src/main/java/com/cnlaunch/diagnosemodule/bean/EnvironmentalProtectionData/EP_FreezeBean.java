package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EP_FreezeBean extends BasicBean {
    String title = "";
    String context = "";
    String status = "";
    String sysID = "";
    ArrayList<EP_DataStreamBean> arrFreeze = new ArrayList<>();

    public String getSysID() {
        return this.sysID;
    }

    public void setSysID(String str) {
        this.sysID = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public ArrayList<EP_DataStreamBean> getArrFreeze() {
        return this.arrFreeze;
    }

    public String toString() {
        return "EP_FreezeBean{title='" + this.title + "', context='" + this.context + "', status='" + this.status + "', arrFreeze=" + this.arrFreeze + '}';
    }
}
