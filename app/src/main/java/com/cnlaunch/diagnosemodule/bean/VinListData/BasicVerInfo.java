package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicVerInfo extends BasicBean {
    private String arithInfo;
    private ArrayList<String> arrCmd = new ArrayList<>();
    private String currentValue;

    /* renamed from: id */
    private String f7284id;
    private String name;
    private String verInfotype;

    public String getVerInfotype() {
        return this.verInfotype;
    }

    public void setVerInfotype(String str) {
        this.verInfotype = str;
    }

    public String getId() {
        return this.f7284id;
    }

    public void setId(String str) {
        this.f7284id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(String str) {
        this.currentValue = str;
    }

    public String getArithInfo() {
        return this.arithInfo;
    }

    public void setArithInfo(String str) {
        this.arithInfo = str;
    }

    public ArrayList<String> getArrCmd() {
        return this.arrCmd;
    }
}
