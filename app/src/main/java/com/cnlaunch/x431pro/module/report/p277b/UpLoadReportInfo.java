package com.cnlaunch.x431pro.module.report.p277b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.report.b.d */
/* loaded from: classes.dex */
public class UpLoadReportInfo extends AbstractC2709c {
    private static final long serialVersionUID = -8170535817773288765L;
    private String car_lat;
    private String car_lon;
    private String cars;
    private String conclusion;
    private String data_flow;
    private String diagnosis_start_time;
    private String diagnosis_time;
    private String diagnosis_time_long;
    private String fault_codes;
    private String goloId;

    /* renamed from: id */
    private Long f15663id;
    private String language;
    private String make;
    private String messagelist;
    private String model;
    private String odo;
    private String operationlist;
    private String plate_num;
    private String pro_serial_no;
    private String report_key;
    private String serial_no;
    private String technician_lat;
    private String technician_lon;
    private String theme;
    private String type;
    private String version;
    private String vin;
    private String year;

    public String toString() {
        return "UpLoadReportInfo [diagnosis_start_time=" + this.diagnosis_start_time + ",report_key=" + this.report_key + ",theme=" + this.theme + " ,fault_codes = " + this.fault_codes + ", data_flow = " + this.data_flow + ", conclusion = " + this.conclusion + ", diagnosis_time = " + this.diagnosis_time + ", serial_no = " + this.serial_no + ", goloId=" + this.goloId + ", type=" + this.type + ", cars=" + this.cars + ", language=" + this.language + ", diagnosis_time_long=" + this.diagnosis_time_long + ", technician_lon=" + this.technician_lon + ", technician_lat=" + this.technician_lat + ", car_lon=" + this.car_lon + ", car_lat=" + this.car_lat + ",messagelist=" + this.messagelist + "]";
    }

    public UpLoadReportInfo() {
    }

    public UpLoadReportInfo(Long l) {
        this.f15663id = l;
    }

    public UpLoadReportInfo(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24) {
        this.f15663id = l;
        this.report_key = str;
        this.theme = str2;
        this.fault_codes = str3;
        this.data_flow = str4;
        this.conclusion = str5;
        this.diagnosis_start_time = str6;
        this.diagnosis_time = str7;
        this.serial_no = str8;
        this.goloId = str9;
        this.type = str10;
        this.cars = str11;
        this.language = str12;
        this.diagnosis_time_long = str13;
        this.technician_lon = str14;
        this.technician_lat = str15;
        this.car_lon = str16;
        this.car_lat = str17;
        this.messagelist = str18;
        this.vin = str19;
        this.pro_serial_no = str20;
        this.odo = str21;
        this.plate_num = str22;
        this.version = str23;
        this.operationlist = str24;
    }

    public Long getId() {
        return this.f15663id;
    }

    public void setId(Long l) {
        this.f15663id = l;
    }

    public String getReport_key() {
        return this.report_key;
    }

    public void setReport_key(String str) {
        this.report_key = str;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String str) {
        this.theme = str;
    }

    public String getFault_codes() {
        return this.fault_codes;
    }

    public void setFault_codes(String str) {
        this.fault_codes = str;
    }

    public String getData_flow() {
        return this.data_flow;
    }

    public void setData_flow(String str) {
        this.data_flow = str;
    }

    public String getConclusion() {
        return this.conclusion;
    }

    public void setConclusion(String str) {
        this.conclusion = str;
    }

    public String getDiagnosis_start_time() {
        return this.diagnosis_start_time;
    }

    public void setDiagnosis_start_time(String str) {
        this.diagnosis_start_time = str;
    }

    public String getDiagnosis_time() {
        return this.diagnosis_time;
    }

    public void setDiagnosis_time(String str) {
        this.diagnosis_time = str;
    }

    public String getSerial_no() {
        return this.serial_no;
    }

    public void setSerial_no(String str) {
        this.serial_no = str;
    }

    public String getGoloId() {
        return this.goloId;
    }

    public void setGoloId(String str) {
        this.goloId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getCars() {
        return this.cars;
    }

    public void setCars(String str) {
        this.cars = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getDiagnosis_time_long() {
        return this.diagnosis_time_long;
    }

    public void setDiagnosis_time_long(String str) {
        this.diagnosis_time_long = str;
    }

    public String getTechnician_lon() {
        return this.technician_lon;
    }

    public void setTechnician_lon(String str) {
        this.technician_lon = str;
    }

    public String getTechnician_lat() {
        return this.technician_lat;
    }

    public void setTechnician_lat(String str) {
        this.technician_lat = str;
    }

    public String getCar_lon() {
        return this.car_lon;
    }

    public void setCar_lon(String str) {
        this.car_lon = str;
    }

    public String getCar_lat() {
        return this.car_lat;
    }

    public void setCar_lat(String str) {
        this.car_lat = str;
    }

    public String getMessagelist() {
        return this.messagelist;
    }

    public void setMessagelist(String str) {
        this.messagelist = str;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String str) {
        this.vin = str;
    }

    public String getPro_serial_no() {
        return this.pro_serial_no;
    }

    public void setPro_serial_no(String str) {
        this.pro_serial_no = str;
    }

    public String getOdo() {
        return this.odo;
    }

    public void setOdo(String str) {
        this.odo = str;
    }

    public String getPlate_num() {
        return this.plate_num;
    }

    public void setPlate_num(String str) {
        this.plate_num = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getOperationlist() {
        return this.operationlist;
    }

    public void setOperationlist(String str) {
        this.operationlist = str;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String str) {
        this.make = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String str) {
        this.year = str;
    }
}
