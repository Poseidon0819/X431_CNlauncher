package com.cnlaunch.diagnosemodule.bean.MultiPageCompData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BasicPageBean extends BasicBean {
    public static int STDD_MCS_DOTL = 4;
    public static int STDD_MCS_FULL = 8;
    public static int STDD_MCS_HORL = 2;
    public static int STDD_MCS_VERL = 1;
    private ArrayList<PageModule> arrPageModule = new ArrayList<>();
    private HashMap<Integer, BasicPageCompBean> mapCompSn2Comp = new HashMap<>();
    private HashMap<Integer, Integer> mapTreeSn2CompSn = new HashMap<>();
    private int pageSn;
    private String title;

    public int getPageSn() {
        return this.pageSn;
    }

    public void setPageSn(int i) {
        this.pageSn = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public ArrayList<PageModule> getArrPageModule() {
        return this.arrPageModule;
    }

    public HashMap<Integer, BasicPageCompBean> getMapCompSn2Comp() {
        return this.mapCompSn2Comp;
    }

    public HashMap<Integer, Integer> getMapTreeSn2CompSn() {
        return this.mapTreeSn2CompSn;
    }

    /* loaded from: classes.dex */
    public static class PageModule extends BasicBean {
        ArrayList<Integer> arrPageCompSn = new ArrayList<>();
        private int horizontalRadios;
        private int moduleAtt;
        private int moduleSn;
        private int verticalRadios;

        public int getModuleSn() {
            return this.moduleSn;
        }

        public void setModuleSn(int i) {
            this.moduleSn = i;
        }

        public int getModuleAtt() {
            return this.moduleAtt;
        }

        public void setModuleAtt(int i) {
            this.moduleAtt = i;
        }

        public int getHorizontalRadios() {
            return this.horizontalRadios;
        }

        public void setHorizontalRadios(int i) {
            this.horizontalRadios = i;
        }

        public int getVerticalRadios() {
            return this.verticalRadios;
        }

        public void setVerticalRadios(int i) {
            this.verticalRadios = i;
        }

        public ArrayList<Integer> getArrPageCompSn() {
            return this.arrPageCompSn;
        }

        public void setArrPageCompSn(ArrayList<Integer> arrayList) {
            this.arrPageCompSn = arrayList;
        }
    }
}
