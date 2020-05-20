package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicSaveAndQueryWithConditionBean extends BasicBean {
    private ArrayList<BasicConditionBean> arrCondition = new ArrayList<>();
    private ArrayList<BasicConditionBean> arrOnlineCondition = new ArrayList<>();
    private boolean bShowUI;
    private String dataInfo;
    private int dataType;
    private int functionType;
    private String help;
    private String softID;
    private int subType;
    private String title;

    public int getSubType() {
        return this.subType;
    }

    public void setSubType(int i) {
        this.subType = i;
    }

    public String getSoftID() {
        return this.softID;
    }

    public void setSoftID(String str) {
        this.softID = str;
    }

    public String getHelp() {
        return this.help;
    }

    public void setHelp(String str) {
        this.help = str;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public boolean isbShowUI() {
        return this.bShowUI;
    }

    public void setbShowUI(boolean z) {
        this.bShowUI = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public String getDataInfo() {
        return this.dataInfo;
    }

    public void setDataInfo(String str) {
        this.dataInfo = str;
    }

    public ArrayList<BasicConditionBean> getArrCondition() {
        return this.arrCondition;
    }

    public ArrayList<BasicConditionBean> getArrOnlineCondition() {
        return this.arrOnlineCondition;
    }

    /* loaded from: classes.dex */
    public static class BasicConditionBean extends BasicBean {
        ArrayList<String> arrItem = new ArrayList<>();
        private int conditionAtt;

        /* renamed from: sn */
        private int f7275sn;
        private String strDefault;
        private String title;

        public int getConditionAtt() {
            return this.conditionAtt;
        }

        public void setConditionAtt(int i) {
            this.conditionAtt = i;
        }

        public int getSn() {
            return this.f7275sn;
        }

        public void setSn(int i) {
            this.f7275sn = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getStrDefault() {
            return this.strDefault;
        }

        public void setStrDefault(String str) {
            this.strDefault = str;
        }

        public ArrayList<String> getArrItem() {
            return this.arrItem;
        }
    }
}
