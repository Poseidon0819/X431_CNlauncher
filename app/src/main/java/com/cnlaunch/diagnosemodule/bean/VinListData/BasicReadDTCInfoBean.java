package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicReadDTCInfoBean extends BasicBean {
    private String arithID;
    private ArrayList<String> arrCmd = new ArrayList<>();
    private String dataType;
    private String menuID;
    private String menuName;

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String str) {
        this.dataType = str;
    }

    public String getMenuID() {
        return this.menuID;
    }

    public void setMenuID(String str) {
        this.menuID = str;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public String getArithID() {
        return this.arithID;
    }

    public void setArithID(String str) {
        this.arithID = str;
    }

    public ArrayList<String> getArrCmd() {
        return this.arrCmd;
    }
}
