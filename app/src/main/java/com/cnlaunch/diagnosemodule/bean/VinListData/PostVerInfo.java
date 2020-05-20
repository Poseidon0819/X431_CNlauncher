package com.cnlaunch.diagnosemodule.bean.VinListData;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class PostVerInfo extends PostVinListBase {
    private String system_uid;
    private List<VersionInfoListBean> version_info_list;

    public String getSystem_uid() {
        return this.system_uid;
    }

    public void setSystem_uid(String str) {
        this.system_uid = str;
    }

    public List<VersionInfoListBean> getVersion_info_list() {
        return this.version_info_list;
    }

    public void setVersion_info_list(List<VersionInfoListBean> list) {
        this.version_info_list = list;
    }

    /* loaded from: classes.dex */
    public static class VersionInfoListBean implements Serializable {
        private String calc;
        private List<PostCmdBean> cmd;

        /* renamed from: id */
        private String f7287id;
        private String name;
        private String type;
        private String value;

        public String getId() {
            return this.f7287id;
        }

        public void setId(String str) {
            this.f7287id = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
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
