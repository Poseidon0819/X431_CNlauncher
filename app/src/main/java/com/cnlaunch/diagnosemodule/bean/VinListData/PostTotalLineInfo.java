package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class PostTotalLineInfo extends PostVinListBase {
    private List<CanDataListBean> can_data_list;
    private String vin;

    public String getVin() {
        return this.vin;
    }

    public void setVin(String str) {
        this.vin = str;
    }

    public List<CanDataListBean> getCan_data_list() {
        return this.can_data_list;
    }

    public void setCan_data_list(List<CanDataListBean> list) {
        this.can_data_list = list;
    }

    /* loaded from: classes.dex */
    public static class CanDataListBean implements Serializable {
        private String baud_rate;
        private String communicate_pin;
        private String data;
        private String data_length;

        /* renamed from: id */
        private String f7286id;
        private String protocol_type;

        public String getProtocol_type() {
            return this.protocol_type;
        }

        public void setProtocol_type(String str) {
            this.protocol_type = str;
        }

        public String getCommunicate_pin() {
            return this.communicate_pin;
        }

        public void setCommunicate_pin(String str) {
            this.communicate_pin = str;
        }

        public String getBaud_rate() {
            return this.baud_rate;
        }

        public void setBaud_rate(String str) {
            this.baud_rate = str;
        }

        public String getId() {
            return this.f7286id;
        }

        public void setId(String str) {
            this.f7286id = str;
        }

        public String getData_length() {
            return this.data_length;
        }

        public void setData_length(String str) {
            this.data_length = str;
        }

        public String getData() {
            return this.data;
        }

        public void setData(String str) {
            this.data = str;
        }
    }
}
