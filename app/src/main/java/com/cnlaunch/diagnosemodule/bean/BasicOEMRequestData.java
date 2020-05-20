package com.cnlaunch.diagnosemodule.bean;

import java.util.HashMap;

/* loaded from: classes.dex */
public class BasicOEMRequestData extends BasicBean {
    private int dataType;
    private String jsonData;
    private HashMap<String, String> mapType2Key = new HashMap<>();
    private int reqMode;
    private String url;

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public int getReqMode() {
        return this.reqMode;
    }

    public void setReqMode(int i) {
        this.reqMode = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getJsonData() {
        return this.jsonData;
    }

    public void setJsonData(String str) {
        this.jsonData = str;
    }

    public HashMap<String, String> getMapType2Key() {
        return this.mapType2Key;
    }
}
