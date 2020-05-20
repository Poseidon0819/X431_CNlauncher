package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.ArrayList;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.module.d.b.d */
/* loaded from: classes.dex */
public final class DiagnoseRunningInfo extends AbstractC2709c {
    public static final int KeepStatues = -1;
    private static final long serialVersionUID = -5024075850605142854L;
    private int VID;
    private ArrayList<BasicSelectMenuBean> mSelectList;
    private int diagnoseStatue = 3;
    private boolean isBinding = false;
    private String subTitle = "";
    private String carSoftName = "";
    private String softPackageid = "";
    private String appVersion = "";
    private String binVersion = "";
    private String softVersion = "";
    private String serialNum = "";
    private String softLan = "";
    private boolean isPrinting = false;
    private int dataStreamJumpType = 0;
    private int dataStreamCount = 0;
    private String dataStreamSelectJumpType = "";
    private boolean isDataStream = false;
    private boolean isSpeciaFunction = false;
    private boolean isFaultCode = false;
    private boolean isActiveTest = false;
    private boolean isSpeciaDatastream = false;
    private boolean isDatastreamRecord = false;
    private int datastreamSelectIndex = 0;
    private int menuSelectIndex = 0;
    private boolean isUploadSaveReport = false;
    private String vin = "";
    private String areaID = "";

    public final void setVID(int i) {
        this.VID = i;
    }

    public final int getVID() {
        return this.VID;
    }

    public final String getVin() {
        return this.vin;
    }

    public final void setVin(String str) {
        this.vin = str;
    }

    public final String getSoftLan() {
        return this.softLan;
    }

    public final void setSoftLan(String str) {
        this.softLan = str;
    }

    public final String getSoftPackageid() {
        return this.softPackageid;
    }

    public final void setSoftPackageid(String str) {
        this.softPackageid = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final String getBinVersion() {
        return this.binVersion;
    }

    public final void setBinVersion(String str) {
        this.binVersion = str;
    }

    public final String getSoftVersion() {
        return this.softVersion;
    }

    public final void setSoftVersion(String str) {
        this.softVersion = str;
        DiagnoseConstants.DIAGNOSE_VERSION = str;
    }

    public final String getSerialNum() {
        return this.serialNum;
    }

    public final void setSerialNum(String str) {
        this.serialNum = str;
    }

    public final int getDiagnoseStatue() {
        return this.diagnoseStatue;
    }

    public final void setDiagnoseStatue(int i) {
        this.diagnoseStatue = i;
    }

    public final boolean isBinding() {
        return this.isBinding;
    }

    public final void setBinding(boolean z) {
        this.isBinding = z;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        if (str == null) {
            return;
        }
        this.subTitle = str;
    }

    public final String getCarSoftName() {
        return this.carSoftName;
    }

    public final void setCarSoftName(String str) {
        if (str == null) {
            return;
        }
        this.carSoftName = str;
    }

    public final String getAllTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.carSoftName.toUpperCase(Locale.getDefault()));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.softVersion);
        if (DiagnoseConstants.DIAGNOSE_CURRENT_PATH != null && DiagnoseConstants.DIAGNOSE_CURRENT_PATH.length() > 1) {
            sb.append(" > ");
            sb.append(DiagnoseConstants.DIAGNOSE_CURRENT_PATH);
        } else if (!this.subTitle.equals("")) {
            sb.append(" > ");
            sb.append(this.subTitle);
        }
        return sb.toString();
    }

    public final boolean isPrinting() {
        return this.isPrinting;
    }

    public final void setPrinting(boolean z) {
        this.isPrinting = z;
    }

    public final String toString() {
        return "DiagnoseRunningInfo [diagnoseStatue=" + this.diagnoseStatue + ", isBinding=" + this.isBinding + ", subTitle=" + this.subTitle + ", carSoftName=" + this.carSoftName + ", softPackageid=" + this.softPackageid + ", appVersion=" + this.appVersion + ", binVersion=" + this.binVersion + ", softVersion=" + this.softVersion + ", serialNum=" + this.serialNum + ", softLan=" + this.softLan + ", isPrinting=" + this.isPrinting + "]";
    }

    public final int getDataStreamJumpType() {
        return this.dataStreamJumpType;
    }

    public final void setDataStreamJumpType(int i) {
        this.dataStreamJumpType = i;
    }

    public final int getDataStreamCount() {
        return this.dataStreamCount;
    }

    public final void setDataStreamCount(int i) {
        this.dataStreamCount = i;
    }

    public final String getDataStreamSelectJumpType() {
        return this.dataStreamSelectJumpType;
    }

    public final void setDataStreamSelectJumpType(String str) {
        this.dataStreamSelectJumpType = str;
    }

    public final boolean isSpeciaFunction() {
        return this.isSpeciaFunction;
    }

    public final void setSpeciaFunction(boolean z) {
        this.isSpeciaFunction = z;
        this.isDataStream = false;
        this.isFaultCode = false;
        this.isActiveTest = false;
        this.isSpeciaDatastream = false;
    }

    public final boolean isFaultCode() {
        return this.isFaultCode;
    }

    public final void setFaultCode(boolean z) {
        this.isFaultCode = z;
        this.isDataStream = false;
        this.isActiveTest = false;
        this.isSpeciaDatastream = false;
        this.isSpeciaFunction = false;
    }

    public final boolean isActiveTest() {
        return this.isActiveTest;
    }

    public final void setActiveTest(boolean z) {
        this.isActiveTest = z;
        this.isDataStream = false;
        this.isFaultCode = false;
        this.isSpeciaDatastream = false;
        this.isSpeciaFunction = false;
    }

    public final boolean isDataStream() {
        return this.isDataStream;
    }

    public final void setDataStream(boolean z) {
        this.isDataStream = z;
        this.isActiveTest = false;
        this.isFaultCode = false;
        this.isSpeciaDatastream = false;
        this.isSpeciaFunction = false;
    }

    public final boolean isSpeciaDatastream() {
        return this.isSpeciaDatastream;
    }

    public final void setSpeciaDatastream(boolean z) {
        this.isSpeciaDatastream = z;
        this.isActiveTest = false;
        this.isFaultCode = false;
        this.isDataStream = false;
        this.isSpeciaFunction = false;
    }

    public final boolean isDatastreamRecord() {
        return this.isDatastreamRecord;
    }

    public final void setDatastreamRecord(boolean z) {
        this.isDatastreamRecord = z;
    }

    public final int getDatastreamSelectIndex() {
        return this.datastreamSelectIndex;
    }

    public final void setDatastreamSelectIndex(int i) {
        this.datastreamSelectIndex = i;
    }

    public final int getMenuSelectIndex() {
        return this.menuSelectIndex;
    }

    public final void setMenuSelectIndex(int i) {
        this.menuSelectIndex = i;
    }

    public final boolean isUploadSaveReport() {
        return this.isUploadSaveReport;
    }

    public final void setUploadSaveReport(boolean z) {
        this.isUploadSaveReport = z;
    }

    public final String getAreaID() {
        return this.areaID;
    }

    public final void setAreaID(String str) {
        this.areaID = str;
    }
}
