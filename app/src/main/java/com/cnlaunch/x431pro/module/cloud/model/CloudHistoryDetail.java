package com.cnlaunch.x431pro.module.cloud.model;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.h */
/* loaded from: classes.dex */
public final class CloudHistoryDetail extends AbstractC2709c {
    private int is_full_scan;

    /* renamed from: sn */
    private String f15510sn;
    private List<CloudDiagSystemInfo> system_list;
    private String car_series = "";
    private String softpackageid = "";
    private String car_producing_year = "";
    private String vin = "";
    private String diagnose_soft_ver = "";
    private String language = "";

    public final List<CloudDiagSystemInfo> getSystem_list() {
        return this.system_list;
    }

    public final void setSystem_list(List<CloudDiagSystemInfo> list) {
        this.system_list = list;
    }

    public final String getCar_series() {
        return this.car_series;
    }

    public final void setCar_series(String str) {
        this.car_series = str;
    }

    public final String getSoftpackageid() {
        return this.softpackageid;
    }

    public final void setSoftpackageid(String str) {
        this.softpackageid = str;
    }

    public final int getIs_full_scan() {
        return this.is_full_scan;
    }

    public final void setIs_full_scan(int i) {
        this.is_full_scan = i;
    }

    public final String getCar_producing_year() {
        return this.car_producing_year;
    }

    public final void setCar_producing_year(String str) {
        this.car_producing_year = str;
    }

    public final String getVin() {
        return this.vin;
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getDiagnose_soft_ver() {
        return this.diagnose_soft_ver;
    }

    public final void setDiagnose_soft_ver(String str) {
        this.diagnose_soft_ver = str;
    }

    public final String getSn() {
        return this.f15510sn;
    }

    public final void setSn(String str) {
        this.f15510sn = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String toString() {
        return "CloudHistoryDetail{system_list=" + this.system_list + ", car_series='" + this.car_series + "', softpackageid='" + this.softpackageid + "', is_full_scan=" + this.is_full_scan + ", car_producing_year='" + this.car_producing_year + "', vin='" + this.vin + "', diagnose_soft_ver='" + this.diagnose_soft_ver + "', language='" + this.language + "', sn='" + this.f15510sn + "'}";
    }
}
