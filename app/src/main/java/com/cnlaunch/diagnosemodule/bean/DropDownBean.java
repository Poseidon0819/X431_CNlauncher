package com.cnlaunch.diagnosemodule.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DropDownBean implements Serializable {
    private static final long serialVersionUID = 3884573840591577260L;
    private ArrayList<String> lists;
    private int selectIndex = 0;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public ArrayList<String> getLists() {
        return this.lists;
    }

    public void setLists(ArrayList<String> arrayList) {
        this.lists = arrayList;
    }

    public int getSelectIndex() {
        return this.selectIndex;
    }

    public void setSelectIndex(int i) {
        this.selectIndex = i;
    }
}
