package com.cnlaunch.x431pro.module.history.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.history.model.d */
/* loaded from: classes.dex */
public final class HistoryVehicleModel extends AbstractC2709c {
    private static final long serialVersionUID = -848504988178491309L;
    private int VID = 0;
    private String VehicleUID = "";
    private String Make = "";
    private String Model = "";
    private String SubModel = "";
    private String Engine = "";
    private String Year = "";
    private String LicenseNumber = "";
    private int Mileage = 0;
    private String Color = "";
    private String VIN = "";
    private String DiagSoftVersion = "";
    private String VehicleSoftVersion = "";
    private String VehicleInformation = "";
    private String StaffIDString = "";
    private String TimeStamp = "";
    private String Remark = "";
    private int OwnerID = 0;
    private String Path = "";
    private String VehiclePath = "";
    private String TimeStampYearMonth = "";

    /* renamed from: SN */
    private String f15573SN = "";
    private String CharSet = "GBK";
    private int Language = 0;
    private int bQuickTest = 0;
    private int bSystemScan = 0;
    private int bUploadFlag = 0;

    public final int getbQuickTest() {
        return this.bQuickTest;
    }

    public final void setbQuickTest(int i) {
        this.bQuickTest = i;
    }

    public final int getbSystemScan() {
        return this.bSystemScan;
    }

    public final void setbSystemScan(int i) {
        this.bSystemScan = i;
    }

    public final int getbUploadFlag() {
        return this.bUploadFlag;
    }

    public final void setbUploadFlag(int i) {
        this.bUploadFlag = i;
    }

    public final void setVID(int i) {
        this.VID = i;
    }

    public final int getVID() {
        return this.VID;
    }

    public final void setUID(String str) {
        if (str == null) {
            return;
        }
        this.VehicleUID = str;
    }

    public final String getUID() {
        return this.VehicleUID;
    }

    public final void setMake(String str) {
        if (str == null) {
            return;
        }
        this.Make = str;
    }

    public final String getMake() {
        return this.Make;
    }

    public final void setModel(String str) {
        if (str == null) {
            return;
        }
        this.Model = str;
    }

    public final String getModel() {
        return this.Model;
    }

    public final void setSubmodel(String str) {
        if (str == null) {
            return;
        }
        this.SubModel = str;
    }

    public final String getSubmodel() {
        return this.SubModel;
    }

    public final void setEngine(String str) {
        if (str == null) {
            return;
        }
        this.Engine = str;
    }

    public final String getEngine() {
        return this.Engine;
    }

    public final void setYear(String str) {
        if (str == null) {
            return;
        }
        this.Year = str;
    }

    public final String getYear() {
        return this.Year;
    }

    public final void setLicenseNumber(String str) {
        if (str == null) {
            return;
        }
        this.LicenseNumber = str;
    }

    public final String getLicenseNumber() {
        return this.LicenseNumber;
    }

    public final void setMileage(int i) {
        this.Mileage = i;
    }

    public final int getMileage() {
        return this.Mileage;
    }

    public final void setColor(String str) {
        if (str == null) {
            return;
        }
        this.Color = str;
    }

    public final String getColor() {
        return this.Color;
    }

    public final void setVIN(String str) {
        if (str == null) {
            return;
        }
        this.VIN = str;
    }

    public final String getVIN() {
        return this.VIN;
    }

    public final void setDiagVersion(String str) {
        if (str == null) {
            return;
        }
        this.DiagSoftVersion = str;
    }

    public final String getDiagVersion() {
        return this.DiagSoftVersion;
    }

    public final void setVehicleVersion(String str) {
        if (str == null) {
            return;
        }
        this.VehicleSoftVersion = str;
    }

    public final String getVehicleVersion() {
        return this.VehicleSoftVersion;
    }

    public final void setVehicleInformation(String str) {
        if (str == null) {
            return;
        }
        this.VehicleInformation = str;
    }

    public final String getVehicleInformation() {
        return this.VehicleInformation;
    }

    public final void setStaffID(String str) {
        if (str == null) {
            return;
        }
        this.StaffIDString = str;
    }

    public final String getStaffID() {
        return this.StaffIDString;
    }

    public final void setTimeStamp(String str) {
        if (str == null) {
            return;
        }
        this.TimeStamp = str;
    }

    public final String getTimeStamp() {
        return this.TimeStamp;
    }

    public final void setRemark(String str) {
        if (str == null) {
            return;
        }
        this.Remark = str;
    }

    public final String getRemark() {
        return this.Remark;
    }

    public final void setOwnerID(int i) {
        this.OwnerID = i;
    }

    public final int getOwnerID() {
        return this.OwnerID;
    }

    public final void setPath(String str) {
        if (str == null) {
            return;
        }
        this.Path = str;
    }

    public final String getPath() {
        return this.Path;
    }

    public final void setVehiclePath(String str) {
        if (str == null) {
            return;
        }
        this.VehiclePath = str;
    }

    public final String getVehiclePath() {
        return this.VehiclePath;
    }

    public final void setTimeStampYearMonth(String str) {
        if (str == null) {
            return;
        }
        this.TimeStampYearMonth = str;
    }

    public final String getTimeStampYearMonth() {
        return this.TimeStampYearMonth;
    }

    public final void setSN(String str) {
        if (str == null) {
            return;
        }
        this.f15573SN = str;
    }

    public final String getSN() {
        return this.f15573SN;
    }

    public final void setCharSet(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.CharSet = str;
    }

    public final String getCharSet() {
        return this.CharSet;
    }

    public final void setLanguage(int i) {
        this.Language = i;
    }

    public final int getLanguage() {
        return this.Language;
    }

    public final String toString() {
        return "HistoryVehicleModel [VID=" + this.VID + ", VehicleUID=" + this.VehicleUID + ", Make=" + this.Make + ", Model=" + this.Model + ", SubModel=" + this.SubModel + ", Engine=" + this.Engine + ", Year=" + this.Year + ", LicenseNumber=" + this.LicenseNumber + ", Mileage=" + this.Mileage + ", Color=" + this.Color + ", VIN=" + this.VIN + ", DiagSoftVersion=" + this.DiagSoftVersion + ", VehicleSoftVersion=" + this.VehicleSoftVersion + ", VehicleInformation=" + this.VehicleInformation + ", StaffIDString=" + this.StaffIDString + ", TimeStamp=" + this.TimeStamp + ", Remark=" + this.Remark + ", OwnerID=" + this.OwnerID + ", Path=" + this.Path + ", VehiclePath=" + this.VehiclePath + ", TimeStampYearMonth=" + this.TimeStampYearMonth + ", SN=" + this.f15573SN + ", CharSet=" + this.CharSet + ", Language=" + this.Language + "]";
    }
}
