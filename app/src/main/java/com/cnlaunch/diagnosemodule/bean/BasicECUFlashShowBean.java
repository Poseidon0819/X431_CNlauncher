package com.cnlaunch.diagnosemodule.bean;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicECUFlashShowBean extends BasicBean {
    private ArrayList<ECUFlashInfo> arrEcuInfo = new ArrayList<>();
    private String context;
    private int dataType;
    private boolean enableChilck;
    private int flashSN;
    private String popContext;
    private int processValue;

    /* loaded from: classes.dex */
    public static class ECUFlshFileInfo {
        public String downloadData;
        public int downloadType;
        public String fileContent;
        public String fileDate;
        public String fileLength;
        public String fileName;
        public String fileVersion;
    }

    public int getFlashSN() {
        return this.flashSN;
    }

    public void setFlashSN(int i) {
        this.flashSN = i;
    }

    public int getProcessValue() {
        return this.processValue;
    }

    public void setProcessValue(int i) {
        this.processValue = i;
    }

    /* loaded from: classes.dex */
    public static class ECUFlashInfo extends BasicBean {
        private String EcuName;
        ArrayList<ECUFlshFileInfo> arrEcuFile = new ArrayList<>();
        private boolean bChilck;
        private String version;

        public boolean isbChilck() {
            return this.bChilck;
        }

        public void setbChilck(boolean z) {
            this.bChilck = z;
        }

        public String getEcuName() {
            return this.EcuName;
        }

        public void setEcuName(String str) {
            this.EcuName = str;
        }

        @Override // com.cnlaunch.diagnosemodule.bean.BasicBean
        public String getVersion() {
            return this.version;
        }

        @Override // com.cnlaunch.diagnosemodule.bean.BasicBean
        public void setVersion(String str) {
            this.version = str;
        }

        public ArrayList<ECUFlshFileInfo> getArrEcuFile() {
            return this.arrEcuFile;
        }
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public boolean isEnableChilck() {
        return this.enableChilck;
    }

    public void setEnableChilck(boolean z) {
        this.enableChilck = z;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String str) {
        this.context = str;
    }

    public String getPopContext() {
        return this.popContext;
    }

    public void setPopContext(String str) {
        this.popContext = str;
    }

    public ArrayList<ECUFlashInfo> getArrEcuInfo() {
        return this.arrEcuInfo;
    }
}
