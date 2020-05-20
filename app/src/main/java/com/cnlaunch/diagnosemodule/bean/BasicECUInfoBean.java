package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class BasicECUInfoBean extends BasicBean {
    private int ecuType = 0;

    /* renamed from: id */
    private String f7271id;
    String title;
    String value;

    public int getEcuType() {
        return this.ecuType;
    }

    public void setEcuType(int i) {
        this.ecuType = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getId() {
        return this.f7271id;
    }

    public void setId(String str) {
        this.f7271id = str;
    }

    public boolean equals(Object obj) {
        try {
            if ((obj instanceof BasicECUInfoBean) && ((BasicECUInfoBean) obj).getTitle().equals(this.title)) {
                return ((BasicECUInfoBean) obj).getValue().equals(this.value);
            }
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
