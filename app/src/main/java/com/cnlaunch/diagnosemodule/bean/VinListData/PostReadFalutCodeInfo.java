package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class PostReadFalutCodeInfo extends PostVinListBase {
    private List<ReadDtcInfoListBean> read_dtc_info_list;
    private String system_uid;

    public String getSystem_uid() {
        return this.system_uid;
    }

    public void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public List<ReadDtcInfoListBean> getRead_dtc_info_list() {
        return this.read_dtc_info_list;
    }

    public void setRead_dtc_info_list(List<ReadDtcInfoListBean> list) {
        this.read_dtc_info_list = list;
    }

    /* loaded from: classes.dex */
    public static class ReadDtcInfoListBean implements Serializable {
        private String calc_id;
        private String menu_id;
        private String menu_name;
        private List<PostCmdBean> read_dtc_cmd;
        private String read_dtc_type;

        public String getRead_dtc_type() {
            return this.read_dtc_type;
        }

        public void setRead_dtc_type(String str) {
            this.read_dtc_type = str;
        }

        public String getMenu_id() {
            return this.menu_id;
        }

        public void setMenu_id(String str) {
            this.menu_id = str;
        }

        public String getMenu_name() {
            return this.menu_name;
        }

        public void setMenu_name(String str) {
            this.menu_name = str;
        }

        public String getCalc_id() {
            return this.calc_id;
        }

        public void setCalc_id(String str) {
            this.calc_id = str;
        }

        public List<PostCmdBean> getRead_dtc_cmd() {
            return this.read_dtc_cmd;
        }

        public void setRead_dtc_cmd(List<PostCmdBean> list) {
            this.read_dtc_cmd = list;
        }
    }
}
