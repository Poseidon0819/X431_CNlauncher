package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.m */
/* loaded from: classes.dex */
public final class CloudVINInfo extends AbstractC2709c {
    private String diagnose_model;
    private String displacement;
    private String model;
    private String package_id;
    private String plate;
    private String remark_json;
    private String trans;
    private String vender;
    private String vin;
    private String year;

    public final String getVin() {
        return this.vin;
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getPlate() {
        return this.plate;
    }

    public final void setPlate(String str) {
        this.plate = str;
    }

    public final String getPackage_id() {
        return this.package_id;
    }

    public final void setPackage_id(String str) {
        this.package_id = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getDiagnose_model() {
        return this.diagnose_model;
    }

    public final void setDiagnose_model(String str) {
        this.diagnose_model = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        this.year = str;
    }

    public final String getDisplacement() {
        return this.displacement;
    }

    public final void setDisplacement(String str) {
        this.displacement = str;
    }

    public final String getTrans() {
        return this.trans;
    }

    public final void setTrans(String str) {
        this.trans = str;
    }

    public final String getVender() {
        return this.vender;
    }

    public final void setVender(String str) {
        this.vender = str;
    }

    public final String getRemark_json() {
        return this.remark_json;
    }

    public final void setRemark_json(String str) {
        this.remark_json = str;
    }

    public final String toString() {
        return "CloudVINInfo{vin='" + this.vin + "', plate='" + this.plate + "', package_id='" + this.package_id + "', model='" + this.model + "', diagnose_model='" + this.diagnose_model + "', year='" + this.year + "', displacement='" + this.displacement + "', trans='" + this.trans + "', vender='" + this.vender + "', remark_json='" + this.remark_json + "'}";
    }
}
