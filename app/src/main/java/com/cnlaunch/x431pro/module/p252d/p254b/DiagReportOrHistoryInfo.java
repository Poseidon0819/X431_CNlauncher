package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.x431pro.utils.C2787z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.d.b.c */
/* loaded from: classes.dex */
public class DiagReportOrHistoryInfo implements Serializable {
    public static final int DIAGNOSTIC = 0;
    public static final int POST_REPAIR = 2;
    public static final int PRE_REPAIR = 1;
    public static final int TYPE_DATESTREAM = 2;
    public static final int TYPE_DIAGNOSE_HISTORY = 4;
    public static final int TYPE_FAULT_CODE = 0;
    public static final int TYPE_IM_READINESS = 3;
    public static final int TYPE_LOACL_FILE = 5;
    public static final int TYPE_SYSTEM_STATE = 1;
    private boolean check;
    private String dataStrJson;
    private ArrayList<BasicDataStreamBean> dataStreamBeenList;
    private String diagnoseReportPlatenumber;
    private ArrayList<BasicFaultCodeBean> faultCodeBeanList;

    /* renamed from: id */
    private Long f15533id;
    private boolean isRemoteReport;
    private HashMap<HashMap<String, Integer>, Integer> mapDataStreamID2ChoiceUnit;
    private String pdfFileName;
    private int repairType;
    private String reportLogoPath;
    private String strAddr;
    private String strApkVer;
    private String strCarMode;
    private String strCarVin;
    private String strCarYear;
    private String strCustomer;
    private String strEmail;
    private String strEngineSize;
    private String strFax;
    private String strODO;
    private String strPath;
    private String strPhone;
    private String strRemark;
    private String strSelectImagePath;
    private String strSensing;
    private String strSerialNo;
    private String strShopName;
    private String strSoftVer;
    private String strTester;
    private String strTime;
    private String strVoltage;
    private String strZipCode;
    private String strcarType;
    private ArrayList<BasicSystemStatusBean> systemStateBeanList;
    private String title;
    private int type;

    public Long getId() {
        return this.f15533id;
    }

    public void setId(Long l) {
        this.f15533id = l;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getRepairType() {
        return this.repairType;
    }

    public void setRepairType(int i) {
        this.repairType = i;
    }

    public String getStrTester() {
        return this.strTester;
    }

    public void setStrTester(String str) {
        this.strTester = str;
    }

    public String getStrCustomer() {
        return this.strCustomer;
    }

    public void setStrCustomer(String str) {
        this.strCustomer = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPdfFileName() {
        return this.pdfFileName;
    }

    public void setPdfFileName(String str) {
        this.pdfFileName = str;
    }

    public String getReportLogoPath() {
        return this.reportLogoPath;
    }

    public void setReportLogoPath(String str) {
        this.reportLogoPath = str;
    }

    public String getStrShopName() {
        return this.strShopName;
    }

    public void setStrShopName(String str) {
        this.strShopName = str;
    }

    public String getStrAddr() {
        return this.strAddr;
    }

    public void setStrAddr(String str) {
        this.strAddr = str;
    }

    public String getStrPhone() {
        return this.strPhone;
    }

    public void setStrPhone(String str) {
        this.strPhone = str;
    }

    public String getStrEmail() {
        return this.strEmail;
    }

    public void setStrEmail(String str) {
        this.strEmail = str;
    }

    public String getStrFax() {
        return this.strFax;
    }

    public void setStrFax(String str) {
        this.strFax = str;
    }

    public String getStrZipCode() {
        return this.strZipCode;
    }

    public void setStrZipCode(String str) {
        this.strZipCode = str;
    }

    public String getDiagnoseReportPlatenumber() {
        return this.diagnoseReportPlatenumber;
    }

    public void setDiagnoseReportPlatenumber(String str) {
        this.diagnoseReportPlatenumber = str;
    }

    public String getStrcarType() {
        return this.strcarType;
    }

    public void setStrcarType(String str) {
        this.strcarType = str;
    }

    public String getStrCarMode() {
        return this.strCarMode;
    }

    public void setStrCarMode(String str) {
        this.strCarMode = str;
    }

    public String getStrCarYear() {
        return this.strCarYear;
    }

    public void setStrCarYear(String str) {
        this.strCarYear = str;
    }

    public String getStrCarVin() {
        return this.strCarVin;
    }

    public void setStrCarVin(String str) {
        this.strCarVin = str;
    }

    public String getStrODO() {
        return this.strODO;
    }

    public void setStrODO(String str) {
        this.strODO = str;
    }

    public String getStrSoftVer() {
        return this.strSoftVer;
    }

    public void setStrSoftVer(String str) {
        this.strSoftVer = str;
    }

    public String getStrApkVer() {
        return this.strApkVer;
    }

    public void setStrApkVer(String str) {
        this.strApkVer = str;
    }

    public String getStrTime() {
        return this.strTime;
    }

    public void setStrTime(String str) {
        this.strTime = str;
    }

    public String getStrPath() {
        return this.strPath;
    }

    public void setStrPath(String str) {
        this.strPath = str;
    }

    public String getStrRemark() {
        return this.strRemark;
    }

    public void setStrRemark(String str) {
        this.strRemark = str;
    }

    public String getStrSerialNo() {
        return this.strSerialNo;
    }

    public void setStrSerialNo(String str) {
        this.strSerialNo = str;
    }

    public String getStrVoltage() {
        return this.strVoltage;
    }

    public void setStrVoltage(String str) {
        this.strVoltage = str;
    }

    public HashMap<HashMap<String, Integer>, Integer> getMapDataStreamID2ChoiceUnit() {
        return this.mapDataStreamID2ChoiceUnit;
    }

    public void setMapDataStreamID2ChoiceUnit(HashMap<HashMap<String, Integer>, Integer> hashMap) {
        this.mapDataStreamID2ChoiceUnit = hashMap;
    }

    public String toString() {
        return "DiagReportOrHistoryInfo{id=" + this.f15533id + ", type=" + this.type + ", repairType=" + this.repairType + ", strTester='" + this.strTester + "', strCustomer='" + this.strCustomer + "', title='" + this.title + "', pdfFileName='" + this.pdfFileName + "', reportLogoPath='" + this.reportLogoPath + "', strShopName='" + this.strShopName + "', strAddr='" + this.strAddr + "', strPhone='" + this.strPhone + "', strEmail='" + this.strEmail + "', strFax='" + this.strFax + "', strZipCode='" + this.strZipCode + "', diagnoseReportPlatenumber='" + this.diagnoseReportPlatenumber + "', strcarType='" + this.strcarType + "', strCarMode='" + this.strCarMode + "', strCarYear='" + this.strCarYear + "', strCarVin='" + this.strCarVin + "', strODO='" + this.strODO + "', strSoftVer='" + this.strSoftVer + "', strApkVer='" + this.strApkVer + "', strTime='" + this.strTime + "', strPath='" + this.strPath + "', strRemark='" + this.strRemark + "', strSerialNo='" + this.strSerialNo + "', dataStrJson='" + this.dataStrJson + "', isRemoteReport=" + this.isRemoteReport + ", check=" + this.check + ", strEngineSize='" + this.strEngineSize + "', strVoltage='" + this.strVoltage + "', strSensing='" + this.strSensing + "', strSelectImagePath='" + this.strSelectImagePath + "'}";
    }

    public String getStrEngineSize() {
        return this.strEngineSize;
    }

    public void setStrEngineSize(String str) {
        this.strEngineSize = str;
    }

    public String getStrSensing() {
        return this.strSensing;
    }

    public void setStrSensing(String str) {
        this.strSensing = str;
    }

    public String getStrSelectImagePath() {
        return this.strSelectImagePath;
    }

    public void setStrSelectImagePath(String str) {
        this.strSelectImagePath = str;
    }

    public String getDataStrJson() {
        return this.dataStrJson;
    }

    public void setDataStrJson(String str) {
        this.dataStrJson = str;
        if (C2787z.m4821a(str)) {
            return;
        }
        int i = 0;
        if (str.contains("BaseicSystemStateBeanList")) {
            this.systemStateBeanList = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("BaseicSystemStateBeanList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                    basicSystemStatusBean.setSystemID(jSONObject.getString("systemId"));
                    basicSystemStatusBean.setSystemName(jSONObject.getString("systemName"));
                    basicSystemStatusBean.setSystemUUID(jSONObject.getString("systemUUID"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("faultCodesList");
                    ArrayList<BasicFaultCodeBean> arrayList = new ArrayList<>();
                    if (jSONArray2 != null) {
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                            basicFaultCodeBean.setTitle(jSONObject2.getString("title"));
                            basicFaultCodeBean.setContext(jSONObject2.getString("context"));
                            basicFaultCodeBean.setStatus(jSONObject2.getString("status"));
                            arrayList.add(basicFaultCodeBean);
                        }
                        basicSystemStatusBean.setSystemFaultCodeBean(arrayList);
                    }
                    this.systemStateBeanList.add(basicSystemStatusBean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (str.contains("BasicFaultCodeBeanList")) {
            this.faultCodeBeanList = new ArrayList<>();
            try {
                JSONArray jSONArray3 = new JSONObject(str).getJSONArray("BasicFaultCodeBeanList");
                if (jSONArray3 != null) {
                    while (i < jSONArray3.length()) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i);
                        BasicFaultCodeBean basicFaultCodeBean2 = new BasicFaultCodeBean();
                        basicFaultCodeBean2.setTitle(jSONObject3.getString("title"));
                        basicFaultCodeBean2.setContext(jSONObject3.getString("context"));
                        basicFaultCodeBean2.setStatus(jSONObject3.getString("status"));
                        this.faultCodeBeanList.add(basicFaultCodeBean2);
                        i++;
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (str.contains("BasicDataStreamBeanList")) {
            this.dataStreamBeenList = new ArrayList<>();
            try {
                JSONArray jSONArray4 = new JSONObject(str).getJSONArray("BasicDataStreamBeanList");
                if (jSONArray4 != null) {
                    while (i < jSONArray4.length()) {
                        this.dataStreamBeenList.add(new BasicDataStreamBean(jSONArray4.getJSONObject(i)));
                        i++;
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public ArrayList<BasicSystemStatusBean> getSystemStateBeanList() {
        return this.systemStateBeanList;
    }

    public void setSystemStateBeanList(ArrayList<BasicSystemStatusBean> arrayList) {
        this.systemStateBeanList = arrayList;
        this.dataStrJson = "";
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                BasicSystemStatusBean basicSystemStatusBean = arrayList.get(i);
                jSONObject2.put("systemId", basicSystemStatusBean.getSystemID());
                jSONObject2.put("systemName", basicSystemStatusBean.getSystemName());
                jSONObject2.put("systemUUID", basicSystemStatusBean.getSystemUUID());
                JSONArray jSONArray2 = new JSONArray();
                if (basicSystemStatusBean.getSystemFaultCodeBean() != null) {
                    for (int i2 = 0; i2 < basicSystemStatusBean.getSystemFaultCodeBean().size(); i2++) {
                        BasicFaultCodeBean basicFaultCodeBean = basicSystemStatusBean.getSystemFaultCodeBean().get(i2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("title", basicFaultCodeBean.getTitle());
                        jSONObject3.put("context", basicFaultCodeBean.getContext());
                        jSONObject3.put("status", basicFaultCodeBean.getStatus());
                        jSONArray2.put(jSONObject3);
                    }
                }
                jSONObject2.put("faultCodesList", jSONArray2);
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("BaseicSystemStateBeanList", jSONArray);
        this.dataStrJson = jSONObject.toString();
    }

    public ArrayList<BasicFaultCodeBean> getFaultCodeBeanList() {
        return this.faultCodeBeanList;
    }

    public void setFaultCodeBeanList(ArrayList<BasicFaultCodeBean> arrayList) {
        this.faultCodeBeanList = arrayList;
        this.dataStrJson = "";
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                BasicFaultCodeBean basicFaultCodeBean = arrayList.get(i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", basicFaultCodeBean.getTitle());
                jSONObject2.put("context", basicFaultCodeBean.getContext());
                jSONObject2.put("status", basicFaultCodeBean.getStatus());
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("BasicFaultCodeBeanList", jSONArray);
        this.dataStrJson = jSONObject.toString();
    }

    public ArrayList<BasicDataStreamBean> getDataStreamBeenList() {
        return this.dataStreamBeenList;
    }

    public void setDataStreamBeenList(ArrayList<BasicDataStreamBean> arrayList) {
        this.dataStreamBeenList = arrayList;
        this.dataStrJson = "";
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                BasicDataStreamBean basicDataStreamBean = arrayList.get(i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", basicDataStreamBean.getId());
                jSONObject2.put("title", basicDataStreamBean.getTitle());
                jSONObject2.put("value", basicDataStreamBean.getValue());
                jSONObject2.put("unit", basicDataStreamBean.getUnit());
                jSONObject2.put("help", basicDataStreamBean.getHelp());
                jSONObject2.put("standardvalue", basicDataStreamBean.getStandardvalue());
                jSONObject2.put("valuestatus", basicDataStreamBean.getValuestatus());
                jSONObject2.put("time", basicDataStreamBean.getTime());
                jSONObject2.put("translation_title", basicDataStreamBean.getTranslation_title());
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("BasicDataStreamBeanList", jSONArray);
        this.dataStrJson = jSONObject.toString();
    }

    public boolean isRemoteReport() {
        return this.isRemoteReport;
    }

    public void setRemoteReport(boolean z) {
        this.isRemoteReport = z;
    }

    public boolean isCheck() {
        return this.check;
    }

    public void setCheck(boolean z) {
        this.check = z;
    }

    public int getDataSize() {
        switch (this.type) {
            case 0:
            case 1:
                ArrayList<BasicSystemStatusBean> arrayList = this.systemStateBeanList;
                if (arrayList == null || arrayList.isEmpty()) {
                    return 0;
                }
                int i = 0;
                for (int i2 = 0; i2 < this.systemStateBeanList.size(); i2++) {
                    ArrayList<BasicFaultCodeBean> systemFaultCodeBean = this.systemStateBeanList.get(i2).getSystemFaultCodeBean();
                    if (systemFaultCodeBean != null) {
                        i += systemFaultCodeBean.size();
                    }
                }
                return i;
            case 2:
                return this.dataStreamBeenList.size();
            case 3:
                return this.systemStateBeanList.size();
            default:
                return 0;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiagReportOrHistoryInfo diagReportOrHistoryInfo = (DiagReportOrHistoryInfo) obj;
        Long l = this.f15533id;
        if (l == null || !l.equals(diagReportOrHistoryInfo.f15533id)) {
            return this.pdfFileName.equals(diagReportOrHistoryInfo.pdfFileName);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.f15533id;
        return ((l != null ? l.hashCode() : 0) * 31) + this.pdfFileName.hashCode();
    }
}
