package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicQueryArgToWebSiteBean extends BasicBean {
    private static final long serialVersionUID = 1;
    private String key = "";
    private String funType = "";
    private int keyTag = 0;
    private ArrayList<String> fileNameList = new ArrayList<>();
    private ArrayList<BasicQueryWebSiteBean> argList = new ArrayList<>();

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getfunType() {
        return this.funType;
    }

    public void setfunType(String str) {
        this.funType = str;
    }

    public int getKeyTag() {
        return this.keyTag;
    }

    public void setKeyTag(int i) {
        this.keyTag = i;
    }

    public ArrayList<String> getFileList() {
        return this.fileNameList;
    }

    public ArrayList<BasicQueryWebSiteBean> getQueryWebSiteBean() {
        return this.argList;
    }

    public void setQueryWebSiteBean(ArrayList<BasicQueryWebSiteBean> arrayList) {
        this.argList.clear();
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            this.argList.add(arrayList.get(i));
        }
    }
}
