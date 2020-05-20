package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.a */
/* loaded from: classes.dex */
public final class AutoCode extends AbstractC2709c {
    private String autoCode;
    private String carModel;
    private String carVender;
    private int code;
    private String diagCarModel;
    private String displacement;
    private String entranceId;
    private String error;
    private String gearBox;
    private String year;

    public final String getEntranceId() {
        return this.entranceId;
    }

    public final void setEntranceId(String str) {
        this.entranceId = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getAutoCode() {
        return this.autoCode;
    }

    public final void setAutoCode(String str) {
        this.autoCode = str;
    }

    public final String getDiagCarModel() {
        return this.diagCarModel;
    }

    public final void setDiagCarModel(String str) {
        this.diagCarModel = str;
    }

    public final String getCarModel() {
        return this.carModel;
    }

    public final void setCarModel(String str) {
        this.carModel = str;
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

    public final String getGearBox() {
        return this.gearBox;
    }

    public final void setGearBox(String str) {
        this.gearBox = str;
    }

    public final String getCarVender() {
        return this.carVender;
    }

    public final void setCarVender(String str) {
        this.carVender = str;
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final String toString() {
        return "AutoCode{code=" + this.code + ", autoCode='" + this.autoCode + "', diagCarModel='" + this.diagCarModel + "', carModel='" + this.carModel + "', year='" + this.year + "', displacement='" + this.displacement + "', gearBox='" + this.gearBox + "', carVender='" + this.carVender + "', error='" + this.error + "', entranceId='" + this.entranceId + "'}";
    }
}
