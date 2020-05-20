package com.cnlaunch.p188n.p190b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.n.b.h */
/* loaded from: classes.dex */
public final class PackageWorker implements Serializable {
    private static final long serialVersionUID = 4024442268976559374L;
    private PackageData data;
    private int resendTime = 0;

    public PackageWorker(PackageData packageData) {
        setData(packageData);
        setResendTime(0);
    }

    public final PackageData getData() {
        return this.data;
    }

    public final void setData(PackageData packageData) {
        this.data = packageData;
    }

    public final int getResendTime() {
        return this.resendTime;
    }

    public final void setResendTime(int i) {
        this.resendTime = i;
    }

    public final void resetResendTime() {
        setResendTime(0);
    }

    public final void increaseResendTime() {
        this.resendTime++;
    }

    public final boolean isCutPackage() {
        return this.data.isCutPackage();
    }

    public final int getCutPackageTotalNumber() {
        return this.data.getCutPackage_Total_number();
    }

    public final int getCutPackageCurrentNumber() {
        return this.data.getCurPackage_Current_number();
    }
}
