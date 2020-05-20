package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicVinListDSBean extends BasicBean {
    private String arithID;
    private ArrayList<String> arrCMD = new ArrayList<>();
    private String dsID;
    private String dsName;
    private String dsUnit;
    private String dsValue;

    public ArrayList<String> getArrCMD() {
        return this.arrCMD;
    }

    public String getDsID() {
        return this.dsID;
    }

    public void setDsID(String str) {
        this.dsID = str;
    }

    public String getDsName() {
        return this.dsName;
    }

    public void setDsName(String str) {
        this.dsName = str;
    }

    public String getDsUnit() {
        return this.dsUnit;
    }

    public void setDsUnit(String str) {
        this.dsUnit = str;
    }

    public String getDsValue() {
        return this.dsValue;
    }

    public void setDsValue(String str) {
        this.dsValue = str;
    }

    public String getArithID() {
        return this.arithID;
    }

    public void setArithID(String str) {
        this.arithID = str;
    }
}
