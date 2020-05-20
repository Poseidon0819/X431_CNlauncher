package com.cnlaunch.x431pro.activity.pdf;

import android.text.Html;
import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.activity.pdf.a */
/* loaded from: classes.dex */
public class PDFBaseInfo implements Serializable {
    public static final int DATASTREAM_REPORT = 2;
    public static final int FAULTCODE_REPORT = 1;
    private static final long serialVersionUID = 1;
    public String diagnose_report_platenumber;
    public String pdfFileName;
    public int pdf_type;
    public String report_logo_path;
    public String strAddr;
    public String strAddrLine1;
    public String strAddrLine2;
    public String strApkVer;
    public String strCarMode;
    public String strCarUserName;
    public String strCarVer;
    public String strCarVin;
    public String strCarYear;
    public String strCity;
    public String strEmail;
    public String strEngineSize;
    public String strFax;
    public String strODO;
    public String strPath;
    public String strPhone;
    public String strProvince;
    public String strRemark;
    public String strRepairType;
    public String strSelectImagePath;
    public String strShopName;
    public String strSymptoms;
    public String strTester;
    public String strTime;
    public String strVoltage;
    public String strZipCode;
    public String strcarType;
    public String title;

    public void changeHtmlStr() {
        String str = this.title;
        this.title = str == null ? "" : Html.fromHtml(str).toString();
        String str2 = this.strShopName;
        this.strShopName = str2 == null ? "" : Html.fromHtml(str2).toString();
        String str3 = this.strAddr;
        this.strAddr = str3 == null ? "" : Html.fromHtml(str3).toString();
        String str4 = this.strAddrLine1;
        this.strAddrLine1 = str4 == null ? "" : Html.fromHtml(str4).toString();
        String str5 = this.strAddrLine2;
        this.strAddrLine2 = str5 == null ? "" : Html.fromHtml(str5).toString();
        String str6 = this.strCity;
        this.strCity = str6 == null ? "" : Html.fromHtml(str6).toString();
        String str7 = this.strProvince;
        this.strProvince = str7 == null ? "" : Html.fromHtml(str7).toString();
        String str8 = this.strZipCode;
        this.strZipCode = str8 == null ? "" : Html.fromHtml(str8).toString();
        String str9 = this.strPhone;
        this.strPhone = str9 == null ? "" : Html.fromHtml(str9).toString();
        String str10 = this.strEmail;
        this.strEmail = str10 == null ? "" : Html.fromHtml(str10).toString();
        String str11 = this.strFax;
        this.strFax = str11 == null ? "" : Html.fromHtml(str11).toString();
        String str12 = this.strCarUserName;
        this.strCarUserName = str12 == null ? "" : Html.fromHtml(str12).toString();
        String str13 = this.diagnose_report_platenumber;
        this.diagnose_report_platenumber = str13 == null ? "" : Html.fromHtml(str13).toString();
        String str14 = this.strcarType;
        this.strcarType = str14 == null ? "" : Html.fromHtml(str14).toString();
        String str15 = this.strCarMode;
        this.strCarMode = str15 == null ? "" : Html.fromHtml(str15).toString();
        String str16 = this.strCarYear;
        this.strCarYear = str16 == null ? "" : Html.fromHtml(str16).toString();
        String str17 = this.strCarVin;
        this.strCarVin = str17 == null ? "" : Html.fromHtml(str17).toString();
        String str18 = this.strODO;
        this.strODO = str18 == null ? "" : Html.fromHtml(str18).toString();
        String str19 = this.strCarVer;
        this.strCarVer = str19 == null ? "" : Html.fromHtml(str19).toString();
        String str20 = this.strApkVer;
        this.strApkVer = str20 == null ? "" : Html.fromHtml(str20).toString();
        String str21 = this.strTime;
        this.strTime = str21 == null ? "" : Html.fromHtml(str21).toString();
        String str22 = this.strTester;
        this.strTester = str22 == null ? "" : Html.fromHtml(str22).toString();
        String str23 = this.strPath;
        this.strPath = str23 == null ? "" : Html.fromHtml(str23).toString();
        String str24 = this.strRemark;
        this.strRemark = str24 == null ? "" : Html.fromHtml(str24).toString();
        String str25 = this.strRepairType;
        this.strRepairType = str25 == null ? "" : Html.fromHtml(str25).toString();
        String str26 = this.strEngineSize;
        this.strEngineSize = str26 == null ? "" : Html.fromHtml(str26).toString();
        String str27 = this.strVoltage;
        this.strVoltage = str27 == null ? "" : Html.fromHtml(str27).toString();
    }

    public String toString() {
        return "PDFBaseInfo{pdf_type=" + this.pdf_type + ", title='" + this.title + "', pdfFileName='" + this.pdfFileName + "', strShopName='" + this.strShopName + "', strAddr='" + this.strAddr + "', strPhone='" + this.strPhone + "', strEmail='" + this.strEmail + "', strFax='" + this.strFax + "', strZipCode='" + this.strZipCode + "', strCarUserName='" + this.strCarUserName + "', diagnose_report_platenumber='" + this.diagnose_report_platenumber + "', strcarType='" + this.strcarType + "', strCarMode='" + this.strCarMode + "', strCarYear='" + this.strCarYear + "', strCarVin='" + this.strCarVin + "', strODO='" + this.strODO + "', strCarVer='" + this.strCarVer + "', strApkVer='" + this.strApkVer + "', strTime='" + this.strTime + "', strTester='" + this.strTester + "', strPath='" + this.strPath + "', strRemark='" + this.strRemark + "', report_logo_path='" + this.report_logo_path + "', strRepairType='" + this.strRepairType + "', strVoltage='" + this.strVoltage + "', strEngineSize='" + this.strEngineSize + "', strSensing='" + this.strSymptoms + "', strSelectImagePath='" + this.strSelectImagePath + "'}";
    }
}
