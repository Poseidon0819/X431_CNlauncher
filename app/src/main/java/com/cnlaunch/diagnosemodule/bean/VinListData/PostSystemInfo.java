package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.util.List;

/* loaded from: classes.dex */
public class PostSystemInfo extends PostVinListBase {
    private String baud_rate;
    private String clean_dtc_calc_id;
    private List<PostCmdBean> clean_dtc_cmd;
    private String communicae_pin;
    private String dtc_ggp_type;
    private String flow_ggp_type;
    private String ggp_type;
    private String obd_type;
    private String protocol_type;
    private List<PostCmdBean> sys_enter_cmd;
    private List<PostCmdBean> sys_out_cmd;
    private String system_info_reserve;
    private String system_name;
    private String system_text_id;
    private String system_type;
    private String system_uid;
    private List<PostCmdBean> ver_enter_cmd;
    private String version_ggp_type;
    private String version_total;
    private String vin_list_base_id;

    public String getVin_list_base_id() {
        return this.vin_list_base_id;
    }

    public void setVin_list_base_id(String str) {
        this.vin_list_base_id = str;
    }

    public String getGgp_type() {
        return this.ggp_type;
    }

    public void setGgp_type(String str) {
        this.ggp_type = str;
    }

    public String getSystem_text_id() {
        return this.system_text_id;
    }

    public void setSystem_text_id(String str) {
        this.system_text_id = str;
    }

    public String getSystem_name() {
        return this.system_name;
    }

    public void setSystem_name(String str) {
        this.system_name = str;
    }

    public String getSystem_uid() {
        return this.system_uid;
    }

    public void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public String getSystem_type() {
        return this.system_type;
    }

    public void setSystem_type(String str) {
        this.system_type = str;
    }

    public String getObd_type() {
        return this.obd_type;
    }

    public void setObd_type(String str) {
        this.obd_type = str;
    }

    public String getProtocol_type() {
        return this.protocol_type;
    }

    public void setProtocol_type(String str) {
        this.protocol_type = str;
    }

    public String getCommunicae_pin() {
        return this.communicae_pin;
    }

    public void setCommunicae_pin(String str) {
        this.communicae_pin = str;
    }

    public String getBaud_rate() {
        return this.baud_rate;
    }

    public void setBaud_rate(String str) {
        this.baud_rate = str;
    }

    public String getSystem_info_reserve() {
        return this.system_info_reserve;
    }

    public void setSystem_info_reserve(String str) {
        this.system_info_reserve = str;
    }

    public String getVersion_total() {
        return this.version_total;
    }

    public void setVersion_total(String str) {
        this.version_total = str;
    }

    public String getVersion_ggp_type() {
        return this.version_ggp_type;
    }

    public void setVersion_ggp_type(String str) {
        this.version_ggp_type = str;
    }

    public String getFlow_ggp_type() {
        return this.flow_ggp_type;
    }

    public void setFlow_ggp_type(String str) {
        this.flow_ggp_type = str;
    }

    public List<PostCmdBean> getSys_enter_cmd() {
        return this.sys_enter_cmd;
    }

    public void setSys_enter_cmd(List<PostCmdBean> list) {
        this.sys_enter_cmd = list;
    }

    public List<PostCmdBean> getSys_out_cmd() {
        return this.sys_out_cmd;
    }

    public void setSys_out_cmd(List<PostCmdBean> list) {
        this.sys_out_cmd = list;
    }

    public List<PostCmdBean> getVer_enter_cmd() {
        return this.ver_enter_cmd;
    }

    public void setVer_enter_cmd(List<PostCmdBean> list) {
        this.ver_enter_cmd = list;
    }

    public List<PostCmdBean> getClean_dtc_cmd() {
        return this.clean_dtc_cmd;
    }

    public void setClean_dtc_cmd(List<PostCmdBean> list) {
        this.clean_dtc_cmd = list;
    }

    public String getDtc_ggp_type() {
        return this.dtc_ggp_type;
    }

    public void setDtc_ggp_type(String str) {
        this.dtc_ggp_type = str;
    }

    public String getClean_dtc_calc_id() {
        return this.clean_dtc_calc_id;
    }

    public void setClean_dtc_calc_id(String str) {
        this.clean_dtc_calc_id = str;
    }
}
