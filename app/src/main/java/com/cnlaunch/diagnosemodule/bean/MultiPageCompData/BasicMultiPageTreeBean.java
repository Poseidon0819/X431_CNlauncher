package com.cnlaunch.diagnosemodule.bean.MultiPageCompData;

import com.cnlaunch.diagnosemodule.bean.BasicBean;

/* loaded from: classes.dex */
public class BasicMultiPageTreeBean extends BasicBean {
    public static int STDD_CTREE_CHLD = 8;
    public static int STDD_CTREE_DISAB = 1;
    public static int STDD_CTREE_DYNM = 2;
    public static int STDD_CTREE_HELP = 4;
    private int nodeAttribute;
    private int nodeSn;
    private int nodeType;
    private String text;
    private int textAttribute;
    private int statusRetDiag = 0;
    private boolean ifExpand = true;

    public int getNodeSn() {
        return this.nodeSn;
    }

    public void setNodeSn(int i) {
        this.nodeSn = i;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public void setNodeType(int i) {
        this.nodeType = i;
    }

    public int getNodeAttribute() {
        return this.nodeAttribute;
    }

    public void setNodeAttribute(int i) {
        this.nodeAttribute = i;
    }

    public int getTextAttribute() {
        return this.textAttribute;
    }

    public void setTextAttribute(int i) {
        this.textAttribute = i;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public int getStatusRetDiag() {
        return this.statusRetDiag;
    }

    public void setStatusRetDiag(int i) {
        this.statusRetDiag = i;
    }

    public boolean isIfExpand() {
        return this.ifExpand;
    }

    public void setIfExpand(boolean z) {
        this.ifExpand = z;
    }
}
