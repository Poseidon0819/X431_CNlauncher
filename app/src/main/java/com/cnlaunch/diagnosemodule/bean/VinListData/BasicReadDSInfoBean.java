package com.cnlaunch.diagnosemodule.bean.VinListData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicReadDSInfoBean extends BasicBean {
    private ArrayList<BasicVinListDSBean> arrDsData = new ArrayList<>();
    private ArrayList<BasicVinListCmdBean> arrIniCmd = new ArrayList<>();
    private String curMenuDSCount;
    private String menuId;
    private String menuName;

    public ArrayList<BasicVinListDSBean> getArrDsData() {
        return this.arrDsData;
    }

    public String getCurMenuDSCount() {
        return this.curMenuDSCount;
    }

    public void setCurMenuDSCount(String str) {
        this.curMenuDSCount = str;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String str) {
        this.menuName = str;
    }

    public ArrayList<BasicVinListCmdBean> getArrIniCmd() {
        return this.arrIniCmd;
    }
}
