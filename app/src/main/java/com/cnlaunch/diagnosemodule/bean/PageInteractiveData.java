package com.cnlaunch.diagnosemodule.bean;

/* loaded from: classes.dex */
public class PageInteractiveData {
    private byte[] data;
    private byte packageId;
    private int packageType;

    public byte getPackageId() {
        return this.packageId;
    }

    public void setPackageId(byte b) {
        this.packageId = b;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public void setPackageType(int i) {
        this.packageType = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
