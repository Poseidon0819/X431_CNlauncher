package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicFaultCodeBean extends BasicBean {
    public static int FAULTCODE_BOTH_HAVE = 2;
    public static int FAULTCODE_CLEAR = 1;
    public static int FAULTCODE_NEW = 0;
    private static final long serialVersionUID = 7578100084590187975L;
    String samllCode;
    String sys;

    /* renamed from: id */
    String f7272id = "";
    String title = "";
    String context = "";
    String status = "";
    String help = "";
    boolean helpIsPath = false;
    boolean helpIsHtml = false;
    int staus_forCompare = -1;
    boolean isFaultCode = true;
    boolean hasFreeze = false;
    boolean canChangeISO = false;
    boolean isShowISO = false;
    String titleISO = "";
    String contextISO = "";
    String onlineArgs = "";
    String sysIDForEP = "";
    private ArrayList<BasicDataStreamBean> DataStreamInfoList = new ArrayList<>();

    public String getSamllCode() {
        return this.samllCode;
    }

    public void setSamllCode(String str) {
        this.samllCode = str;
    }

    public String getOnlineArgs() {
        return this.onlineArgs;
    }

    public void setOnlineArgs(String str) {
        this.onlineArgs = str;
    }

    public boolean isHelpIsPath() {
        return this.helpIsPath;
    }

    public void setHelpIsPath(boolean z) {
        this.helpIsPath = z;
    }

    public boolean isHelpIsHtml() {
        return this.helpIsHtml;
    }

    public void setHelpIsHtml(boolean z) {
        this.helpIsHtml = z;
    }

    public boolean isShowISO() {
        return this.isShowISO;
    }

    public void setShowISO(boolean z) {
        this.isShowISO = z;
    }

    public boolean isCanChangeISO() {
        return this.canChangeISO;
    }

    public void setCanChangeISO(boolean z) {
        this.canChangeISO = z;
    }

    public String getTitleISO() {
        return this.titleISO;
    }

    public void setTitleISO(String str) {
        this.titleISO = str;
    }

    public String getContextISO() {
        return this.contextISO;
    }

    public void setContextISO(String str) {
        this.contextISO = str;
    }

    public String getSysIDForEP() {
        return this.sysIDForEP;
    }

    public void setSysIDForEP(String str) {
        this.sysIDForEP = str;
    }

    public int getstaus_forCompare() {
        return this.staus_forCompare;
    }

    public void setstaus_forCompare(int i) {
        this.staus_forCompare = i;
    }

    public ArrayList<BasicDataStreamBean> getDataStreamInfoList() {
        return this.DataStreamInfoList;
    }

    public String getId() {
        return this.f7272id;
    }

    public void setId(String str) {
        this.f7272id = str;
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

    public boolean isFaultCode() {
        return this.isFaultCode;
    }

    public void setFaultCode(boolean z) {
        this.isFaultCode = z;
    }

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String str) {
        this.help = str;
    }

    public String getSys() {
        return this.sys;
    }

    public void setSys(String str) {
        this.sys = str;
    }

    public boolean hasFreeze() {
        return this.hasFreeze;
    }

    public void setHasFreeze(boolean z) {
        this.hasFreeze = z;
    }

    public boolean equals(Object obj) {
        try {
            if ((obj instanceof BasicFaultCodeBean) && ((BasicFaultCodeBean) obj).getTitle().equals(this.title) && ((BasicFaultCodeBean) obj).getContext().equals(this.context)) {
                return ((BasicFaultCodeBean) obj).getStatus().equals(this.status);
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String toString() {
        return "BasicFaultCodeBean{samllCode='" + this.samllCode + "', id='" + this.f7272id + "', title='" + this.title + "', context='" + this.context + "', status='" + this.status + "', help='" + this.help + "', staus_forCompare=" + this.staus_forCompare + ", sys='" + this.sys + "', isFaultCode=" + this.isFaultCode + ", hasFreeze=" + this.hasFreeze + ", sysIDForEP='" + this.sysIDForEP + "', DataStreamInfoList=" + this.DataStreamInfoList + '}';
    }
}
