package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.j */
/* loaded from: classes.dex */
public final class CloudReportListInfo extends AbstractC2709c {
    private int dtcnumber;
    private int is_full_scan;
    private String vin = "";
    private String diagnose_record_id = "";
    private String is_pay = "";
    private String is_owner_reads = "";
    private String is_bussiness_reads = "";
    private String plate_number = "";
    private String serial_number = "";
    private String technician_lon = "";
    private String technician_lat = "";
    private String rec_date = "";
    private String language = "";
    private String rlanguage = "";
    private String vehicle_series = "";
    private String model_years = "";
    private String report_type = "";
    private String upload_address = "";
    private String report_url = "";

    public final String getReport_type() {
        return this.report_type;
    }

    public final void setReport_type(String str) {
        this.report_type = str;
    }

    public final String getIs_bussiness_reads() {
        return this.is_bussiness_reads;
    }

    public final void setIs_bussiness_reads(String str) {
        this.is_bussiness_reads = str;
    }

    public final String getRec_date() {
        return this.rec_date;
    }

    public final void setRec_date(String str) {
        this.rec_date = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getRlanguage() {
        return this.rlanguage;
    }

    public final void setRlanguage(String str) {
        this.rlanguage = str;
    }

    public final int getDtcnumber() {
        return this.dtcnumber;
    }

    public final void setDtcnumber(int i) {
        this.dtcnumber = i;
    }

    public final String getVin() {
        return this.vin;
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getDiagnose_record_id() {
        return this.diagnose_record_id;
    }

    public final void setDiagnose_record_id(String str) {
        this.diagnose_record_id = str;
    }

    public final String getIs_pay() {
        return this.is_pay;
    }

    public final void setIs_pay(String str) {
        this.is_pay = str;
    }

    public final String getIs_owner_reads() {
        return this.is_owner_reads;
    }

    public final void setIs_owner_reads(String str) {
        this.is_owner_reads = str;
    }

    public final String getPlate_number() {
        return this.plate_number;
    }

    public final void setPlate_number(String str) {
        this.plate_number = str;
    }

    public final int getIs_full_scan() {
        return this.is_full_scan;
    }

    public final void setIs_full_scan(int i) {
        this.is_full_scan = i;
    }

    public final String getVehicle_series() {
        return this.vehicle_series;
    }

    public final void setVehicle_series(String str) {
        this.vehicle_series = str;
    }

    public final String getTechnician_lon() {
        return this.technician_lon;
    }

    public final void setTechnician_lon(String str) {
        this.technician_lon = str;
    }

    public final String getTechnician_lat() {
        return this.technician_lat;
    }

    public final void setTechnician_lat(String str) {
        this.technician_lat = str;
    }

    public final String getUpload_address() {
        return this.upload_address;
    }

    public final void setUpload_address(String str) {
        this.upload_address = str;
    }

    public final String getModel_years() {
        return this.model_years;
    }

    public final void setModel_years(String str) {
        this.model_years = str;
    }

    public final String getSerial_number() {
        return this.serial_number;
    }

    public final void setSerial_number(String str) {
        this.serial_number = str;
    }

    public final String getReport_url() {
        return this.report_url;
    }

    public final void setReport_url(String str) {
        this.report_url = str;
    }
}
