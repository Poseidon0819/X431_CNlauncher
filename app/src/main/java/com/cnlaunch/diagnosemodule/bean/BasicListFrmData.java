package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicListFrmData extends BasicBean {
    private int listDataAtt;
    private ArrayList<BasicListDataBean> listListData = new ArrayList<>();
    private ArrayList<BasicButtonBean> listBtnData = new ArrayList<>();

    public void setListDataAtt(int i) {
        this.listDataAtt = i;
    }

    public int getListDataAtt() {
        return this.listDataAtt;
    }

    public ArrayList<BasicListDataBean> getListListData() {
        return this.listListData;
    }

    public ArrayList<BasicButtonBean> getListBtnData() {
        return this.listBtnData;
    }

    /* loaded from: classes.dex */
    public static class BasicListDataBean extends BasicBean {
        private ArrayList<BasicListItemBean> listItemData = new ArrayList<>();
        private int scale;
        private String title;
        private int titleAtt;
        private int titleNumber;

        public int getTitleNumber() {
            return this.titleNumber;
        }

        public void setTitleNumber(int i) {
            this.titleNumber = i;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public int getTitleAtt() {
            return this.titleAtt;
        }

        public void setTitleAtt(int i) {
            this.titleAtt = i;
        }

        public int getScale() {
            return this.scale;
        }

        public void setScale(int i) {
            this.scale = i;
        }

        public ArrayList<BasicListItemBean> getListItemData() {
            return this.listItemData;
        }
    }

    /* loaded from: classes.dex */
    public static class BasicListItemBean extends BasicBean {
        private int defaultItem;
        private int itemAtt;
        private int itemNumber;
        private ArrayList<String> listItemData = new ArrayList<>();
        private String titleItem;

        public int getItemNumber() {
            return this.itemNumber;
        }

        public void setItemNumber(int i) {
            this.itemNumber = i;
        }

        public String getTitleItem() {
            return this.titleItem;
        }

        public void setTitleItem(String str) {
            this.titleItem = str;
        }

        public int getItemAtt() {
            return this.itemAtt;
        }

        public void setItemAtt(int i) {
            this.itemAtt = i;
        }

        public int getDefaultItem() {
            return this.defaultItem;
        }

        public void setDefaultItem(int i) {
            this.defaultItem = i;
        }

        public ArrayList<String> getListItemData() {
            return this.listItemData;
        }
    }
}
