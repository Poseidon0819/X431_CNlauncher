package com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class EP_ECUInfoBean extends BasicBean {
    private String VIN;
    private String name;
    private ArrayList<String> arrCalID = new ArrayList<>();
    private ArrayList<String> arrCVN = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVIN() {
        return this.VIN;
    }

    public void setVIN(String str) {
        this.VIN = str;
    }

    public ArrayList<String> getArrCalID() {
        return this.arrCalID;
    }

    public ArrayList<String> getArrCVN() {
        return this.arrCVN;
    }

    public void setArrCalID(ArrayList<String> arrayList) {
        this.arrCalID = arrayList;
    }

    public void setArrCVN(ArrayList<String> arrayList) {
        this.arrCVN = arrayList;
    }
}
