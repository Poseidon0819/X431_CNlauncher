package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class PostDataFlowSubInfo extends PostVinListBase {
    private List<FlowSubMenuListBean> flow_sub_menu_list;
    private String system_uid;

    public String getSystem_uid() {
        return this.system_uid;
    }

    public void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public List<FlowSubMenuListBean> getFlow_sub_menu_list() {
        return this.flow_sub_menu_list;
    }

    public void setFlow_sub_menu_list(List<FlowSubMenuListBean> list) {
        this.flow_sub_menu_list = list;
    }

    /* loaded from: classes.dex */
    public static class FlowSubMenuListBean implements Serializable {
        private List<PostCmdBean> flow_enter_cmd;
        private String flow_num;
        private String sub_menu_id;
        private String sub_menu_name;

        public String getSub_menu_id() {
            return this.sub_menu_id;
        }

        public void setSub_menu_id(String str) {
            this.sub_menu_id = str;
        }

        public String getSub_menu_name() {
            return this.sub_menu_name;
        }

        public void setSub_menu_name(String str) {
            this.sub_menu_name = str;
        }

        public String getFlow_num() {
            return this.flow_num;
        }

        public void setFlow_num(String str) {
            this.flow_num = str;
        }

        public List<PostCmdBean> getFlow_enter_cmd() {
            return this.flow_enter_cmd;
        }

        public void setFlow_enter_cmd(List<PostCmdBean> list) {
            this.flow_enter_cmd = list;
        }
    }
}
