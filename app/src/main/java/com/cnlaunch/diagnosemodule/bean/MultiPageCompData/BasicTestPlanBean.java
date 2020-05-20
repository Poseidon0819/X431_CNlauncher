package com.cnlaunch.diagnosemodule.bean.MultiPageCompData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicTestPlanBean extends BasicBean {
    private ArrayList<String> arrTitle = new ArrayList<>();
    private ArrayList<Integer> arrTitleScale = new ArrayList<>();
    private ArrayList<ArrayList<String>> arrItem = new ArrayList<>();
    private ArrayList<ArrayList<BasicSystemStatusBean>> arrItemSys = new ArrayList<>();
    private ArrayList<ArrayList<BasicButtonBean>> arrItemBtn = new ArrayList<>();
    private int currentTestPlanSelectItem = -1;

    public ArrayList<String> getArrTitle() {
        return this.arrTitle;
    }

    public ArrayList<Integer> getArrTitleScale() {
        return this.arrTitleScale;
    }

    public ArrayList<ArrayList<String>> getArrItem() {
        return this.arrItem;
    }

    public ArrayList<ArrayList<BasicSystemStatusBean>> getArrItemSys() {
        return this.arrItemSys;
    }

    public ArrayList<ArrayList<BasicButtonBean>> getArrItemBtn() {
        return this.arrItemBtn;
    }

    public int getCurrentTestPlanSelectItem() {
        return this.currentTestPlanSelectItem;
    }

    public void setCurrentTestPlanSelectItem(int i) {
        this.currentTestPlanSelectItem = i;
    }
}
