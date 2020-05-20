package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicVWCodeWindowBean extends BasicBean {
    private ArrayList<ArrayList<BasicBitData>> arrBitData = new ArrayList<>();
    private ArrayList<Integer> arrCodeData = new ArrayList<>();
    private String content;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public ArrayList<ArrayList<BasicBitData>> getArrBitData() {
        return this.arrBitData;
    }

    public ArrayList<Integer> getArrCodeData() {
        return this.arrCodeData;
    }

    /* loaded from: classes.dex */
    public static class BasicBitData extends BasicBean {
        private int bitAtt;
        private int bitSn;
        private ArrayList<String> arrFunctionTitle = new ArrayList<>();
        private ArrayList<Integer> arrFunctionData = new ArrayList<>();

        public int getBitAtt() {
            return this.bitAtt;
        }

        public void setBitAtt(int i) {
            this.bitAtt = i;
        }

        public int getBitSn() {
            return this.bitSn;
        }

        public void setBitSn(int i) {
            this.bitSn = i;
        }

        public ArrayList<String> getArrFunctionTitle() {
            return this.arrFunctionTitle;
        }

        public ArrayList<Integer> getArrFunctionData() {
            return this.arrFunctionData;
        }
    }
}
