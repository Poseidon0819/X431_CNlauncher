package com.cnlaunch.x431pro.module.p255e.p257b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.e.b.c */
/* loaded from: classes.dex */
public final class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String pdtCategory;
    protected Integer pdtState;
    protected String productConfigName;
    protected String serialNo;
    protected String venderName;

    public final Integer getPdtState() {
        return this.pdtState;
    }

    public final void setPdtState(Integer num) {
        this.pdtState = num;
    }

    public final String getProductConfigName() {
        return this.productConfigName;
    }

    public final void setProductConfigName(String str) {
        this.productConfigName = str;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final void setSerialNo(String str) {
        this.serialNo = str;
    }

    public final String getVenderName() {
        return this.venderName;
    }

    public final void setVenderName(String str) {
        this.venderName = str;
    }

    public final String getPdtCategory() {
        return this.pdtCategory;
    }

    public final void setPdtCategory(String str) {
        this.pdtCategory = str;
    }

    public final String toString() {
        return "ProductDTO{pdtState=" + this.pdtState + ", productConfigName='" + this.productConfigName + "', serialNo='" + this.serialNo + "', venderName='" + this.venderName + "', pdtCategory='" + this.pdtCategory + "'}";
    }
}
