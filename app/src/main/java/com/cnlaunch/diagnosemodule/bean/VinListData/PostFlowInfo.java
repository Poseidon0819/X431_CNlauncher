package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class PostFlowInfo extends PostVinListBase {
    private List<FlowInfoListBean> flow_info_list;
    private String sub_menu_id;
    private String system_uid;

    public String getSystem_uid() {
        return this.system_uid;
    }

    public void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public String getSub_menu_id() {
        return this.sub_menu_id;
    }

    public void setSub_menu_id(String str) {
        this.sub_menu_id = str;
    }

    public List<FlowInfoListBean> getFlow_info_list() {
        return this.flow_info_list;
    }

    public void setFlow_info_list(List<FlowInfoListBean> list) {
        this.flow_info_list = list;
    }

    /* loaded from: classes.dex */
    public static class FlowInfoListBean implements Serializable {
        private String calc;
        private List<PostCmdBean> cmd;

        /* renamed from: id */
        private String f7285id;
        private String name;
        private String unit;
        private String value;

        public String getId() {
            return this.f7285id;
        }

        public void setId(String str) {
            this.f7285id = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getUnit() {
            return this.unit;
        }

        public void setUnit(String str) {
            this.unit = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }

        public String getCalc() {
            return this.calc;
        }

        public void setCalc(String str) {
            this.calc = str;
        }

        public List<PostCmdBean> getCmd() {
            return this.cmd;
        }

        public void setCmd(List<PostCmdBean> list) {
            this.cmd = list;
        }
    }
}
