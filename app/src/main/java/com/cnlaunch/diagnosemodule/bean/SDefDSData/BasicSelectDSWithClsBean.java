package com.cnlaunch.diagnosemodule.bean.SDefDSData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicSelectDSWithClsBean extends BasicBean {
    private ArrayList<BasicSelectMenuBean> arrayListSelect = new ArrayList<>();
    private String clsName;
    int dsPos;

    public int getDsPos() {
        return this.dsPos;
    }

    public void setDsPos(int i) {
        this.dsPos = i;
    }

    public String getClsName() {
        return this.clsName;
    }

    public void setClsName(String str) {
        this.clsName = str;
    }

    public ArrayList<BasicSelectMenuBean> getArrayListSelect() {
        return this.arrayListSelect;
    }
}
