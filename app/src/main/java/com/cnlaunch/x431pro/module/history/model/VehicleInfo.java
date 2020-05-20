package com.cnlaunch.x431pro.module.history.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.cnlaunch.x431pro.module.cloud.model.CloudSystemInfo;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.List;

/* loaded from: classes.dex */
public class VehicleInfo extends AbstractC2709c implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new C2733e();
    private static final long serialVersionUID = -8403852296727092594L;
    private int Language;

    /* renamed from: SN */
    private String f15572SN;
    private String VIN;
    private String availableAction;
    private String availableDatastream;
    private int bQuickTest;
    private int bSelect;
    private int bSystemScan;
    private String car_name;
    private String charset;
    private String color;
    private String diagSoftVersion;
    private String engine;
    private int flag;
    private String licenseNumber;
    private String license_url;
    private String mark;
    private String menuPath;
    private int mileage;
    private String model;
    private String numDTC;
    private String numbActionTest;
    private int owerID;
    private String path;
    private String product_url;
    private String remark;
    private String staffIDString;
    private String subModel;
    private List<CloudSystemInfo> sysInfo;
    private int sys_number;
    private String timeStamp;
    private int uploadFlag;
    private int vehicleId;
    private String vehicleInfomation;
    private String vehicleSoftVersion;
    private String vehicleUID;
    private String vehicle_icon_id;
    private String year;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getSys_number() {
        return this.sys_number;
    }

    public void setSys_number(int i) {
        this.sys_number = i;
    }

    public String getVehicle_icon_id() {
        return this.vehicle_icon_id;
    }

    public void setVehicle_icon_id(String str) {
        this.vehicle_icon_id = str;
    }

    public String getCar_name() {
        return this.car_name;
    }

    public void setCar_name(String str) {
        this.car_name = str;
    }

    public String getProduct_url() {
        return this.product_url;
    }

    public void setProduct_url(String str) {
        this.product_url = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public int getbQuickTest() {
        return this.bQuickTest;
    }

    public void setbQuickTest(int i) {
        this.bQuickTest = i;
    }

    public int getbSystemScan() {
        return this.bSystemScan;
    }

    public void setbSystemScan(int i) {
        this.bSystemScan = i;
    }

    public int getUploadFlag() {
        return this.uploadFlag;
    }

    public void setUploadFlag(int i) {
        this.uploadFlag = i;
    }

    public String getLicense_url() {
        return this.license_url;
    }

    public void setLicense_url(String str) {
        this.license_url = str;
    }

    public List<CloudSystemInfo> getSysInfo() {
        return this.sysInfo;
    }

    public void setSysInfo(List<CloudSystemInfo> list) {
        this.sysInfo = list;
    }

    public int getSelectState() {
        return this.bSelect;
    }

    public void setSelectState(int i) {
        this.bSelect = i;
    }

    public String getMenuPath() {
        return this.menuPath;
    }

    public void setMenuPath(String str) {
        this.menuPath = str;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setNumbDTC(String str) {
        this.numDTC = str;
    }

    public String getNumDTC() {
        return this.numDTC;
    }

    public void setNumbActionTest(String str) {
        this.numbActionTest = str;
    }

    public String getNumbActionTest() {
        return this.numbActionTest;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getOwerID() {
        return this.owerID;
    }

    public void setOwerID(int i) {
        this.owerID = i;
    }

    public String getStaffIDString() {
        return this.staffIDString;
    }

    public void setStaffIDString(String str) {
        this.staffIDString = str;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getAvailableDatastream() {
        return this.availableDatastream;
    }

    public void setAvailableDatastream(String str) {
        this.availableDatastream = str;
    }

    public String getAvailableAction() {
        return this.availableAction;
    }

    public void setAvailableAction(String str) {
        this.availableAction = str;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int i) {
        this.mileage = i;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int i) {
        this.vehicleId = i;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String str) {
        this.engine = str;
    }

    public String getSubModel() {
        return this.subModel;
    }

    public void setSubModel(String str) {
        this.subModel = str;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String str) {
        this.mark = str;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String str) {
        this.licenseNumber = str;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public String getVehicleUID() {
        return this.vehicleUID;
    }

    public void setVehicleUID(String str) {
        this.vehicleUID = str;
    }

    public String getVehicleInfomation() {
        return this.vehicleInfomation;
    }

    public void setVehicleInfomation(String str) {
        this.vehicleInfomation = str;
    }

    public String getVIN() {
        return this.VIN;
    }

    public void setVIN(String str) {
        this.VIN = str;
    }

    public String getDiagSoftVersion() {
        return this.diagSoftVersion;
    }

    public void setDiagSoftVersion(String str) {
        this.diagSoftVersion = str;
    }

    public String getVehicleSoftVersion() {
        return this.vehicleSoftVersion;
    }

    public void setVehicleSoftVersion(String str) {
        this.vehicleSoftVersion = str;
    }

    public void setSN(String str) {
        this.f15572SN = str;
    }

    public String getSN() {
        return this.f15572SN;
    }

    public void setCharSet(String str) {
        if (str != null) {
            this.charset = str;
        }
    }

    public String getCharSet() {
        return this.charset;
    }

    public void setLanguage(int i) {
        this.Language = i;
    }

    public int getLanguage() {
        return this.Language;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.vehicleId);
        parcel.writeString(this.mark);
        parcel.writeString(this.model);
        parcel.writeString(this.subModel);
        parcel.writeString(this.engine);
        parcel.writeString(this.year);
        parcel.writeString(this.licenseNumber);
        parcel.writeInt(this.mileage);
        parcel.writeString(this.color);
        parcel.writeString(this.VIN);
        parcel.writeString(this.diagSoftVersion);
        parcel.writeString(this.vehicleSoftVersion);
        parcel.writeString(this.vehicleUID);
        parcel.writeString(this.vehicleInfomation);
        parcel.writeString(this.staffIDString);
        parcel.writeString(this.timeStamp);
        parcel.writeString(this.availableDatastream);
        parcel.writeString(this.availableAction);
        parcel.writeString(this.remark);
        parcel.writeInt(this.owerID);
        parcel.writeString(this.path);
        parcel.writeString(this.numDTC);
        parcel.writeString(this.numbActionTest);
        parcel.writeString(this.f15572SN);
        parcel.writeString(this.menuPath);
        parcel.writeInt(this.bSelect);
        parcel.writeString(this.charset);
        parcel.writeInt(this.Language);
    }

    public VehicleInfo(Parcel parcel) {
        this.numbActionTest = "0";
        this.bSelect = 0;
        this.charset = "GB2312";
        this.Language = 0;
        this.flag = -1;
        this.uploadFlag = -1;
        this.vehicleId = parcel.readInt();
        this.mark = parcel.readString();
        this.model = parcel.readString();
        this.subModel = parcel.readString();
        this.engine = parcel.readString();
        this.year = parcel.readString();
        this.licenseNumber = parcel.readString();
        this.mileage = parcel.readInt();
        this.color = parcel.readString();
        this.VIN = parcel.readString();
        this.diagSoftVersion = parcel.readString();
        this.vehicleSoftVersion = parcel.readString();
        this.vehicleUID = parcel.readString();
        this.vehicleInfomation = parcel.readString();
        this.staffIDString = parcel.readString();
        this.timeStamp = parcel.readString();
        this.availableDatastream = parcel.readString();
        this.availableAction = parcel.readString();
        this.remark = parcel.readString();
        this.owerID = parcel.readInt();
        this.path = parcel.readString();
        this.numDTC = parcel.readString();
        this.numbActionTest = parcel.readString();
        this.f15572SN = parcel.readString();
        this.menuPath = parcel.readString();
        this.bSelect = parcel.readInt();
        this.charset = parcel.readString();
        this.Language = parcel.readInt();
    }

    public VehicleInfo() {
        this.numbActionTest = "0";
        this.bSelect = 0;
        this.charset = "GB2312";
        this.Language = 0;
        this.flag = -1;
        this.uploadFlag = -1;
    }
}
