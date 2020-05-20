package com.cnlaunch.diagnosemodule.bean.SysListTopViewData;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.cnlaunch.diagnosemodule.JsonConstText;
import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicECUInfoBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineCodeLib;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SysListTopViewUtils {
    public static int Ret_IN_SCANNING_BACKUP = 0;
    public static int Ret_IN_SCANNING_NEXT = 3;
    public static int Ret_IN_SCANNING_PAUSE = 2;
    public static int SLTOP_CONT = 8;
    public static int SLTOP_EDC = 1;
    public static int SLTOP_IPF = 4;
    public static int SLTOP_OCD = 2;
    public static int SS_SCAN_ALL = 16;
    public static int SS_SCAN_GWSYS = 8;
    public static int SS_SCAN_SELECT = 2;
    public static int SS_SCAN_SMART = 1;
    public static int SS_SCAN_SYSTEM = 4;
    public static int SS_TCODE_CDTC = 16;
    public static int SS_TCODE_FRZ = 2;
    public static int SS_TCODE_ISOSAE = 8;
    public static int SS_TCODE_RDS = 4;
    public static int UIShowType_CurrScanning = 1;
    public static int UIShowType_GetDTC_DS = 4;
    public static int UIShowType_NO_DTC = 5;
    public static int UIShowType_ScannDTCEND = 3;
    public static int UIShowType_ScannEnd = 2;
    public static int UIShowType_SelectItem;
    private static SysListTopViewUtils instance;
    private int currScanSn;
    private BasicFaultCodeBean dtcForDataStream;
    private BasicFaultCodeBean dtcShowDataStreamShow;
    private OnDiagnoseDataListener mIDiagnoseDataCallback;
    private Messenger mService;
    private int sumScanSystemNumber;
    private ArrayList<String> arrTitle = new ArrayList<>();
    private ArrayList<Integer> arrSystemType = new ArrayList<>();
    private int scanModuleButtonType = 0;
    private int btnClickedInScanning = Ret_IN_SCANNING_NEXT;
    private int btnTypeInSystemDTC = 0;
    private boolean IsOnLineDTCInSystemScanning = false;
    private boolean dtcFromType115 = false;
    private int scanedBtnType = 0;
    private Boolean isShowDTCInDataStreamShow = Boolean.FALSE;
    private String softID_DTC_DS = "";
    private boolean bGetDTC_DS_With_Langue = false;
    private String strAddInfo_DTC_DS = "";
    private ArrayList<BasicSysListTopSystemInfoBean> arrSysListTopSystemInfo = new ArrayList<>();
    private String currScanSysId = "";
    private ArrayList<String> arrADASSysType = new ArrayList<String>() { // from class: com.cnlaunch.diagnosemodule.bean.SysListTopViewData.SysListTopViewUtils.1
        {
            add("17");
            add(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT);
            add(DiagnoseConstants.EXT1_GET_DEVICE_ADAPTER_LICENSE);
            add(DiagnoseConstants.EXT1_EXECUTION_FLOW_CHART);
            add(DiagnoseConstants.FEEDBACK_ARGING_WINDOW);
            add("31");
            add("32");
        }
    };

    public boolean isDtcFromType115() {
        return this.dtcFromType115;
    }

    public void setDtcFromType115(boolean z) {
        this.dtcFromType115 = z;
    }

    public boolean isOnLineDTCInSystemScanning() {
        return this.IsOnLineDTCInSystemScanning;
    }

    public int getBtnTypeInSystemDTC() {
        return this.btnTypeInSystemDTC;
    }

    public void setBtnClickedInScanning(int i) {
        this.btnClickedInScanning = i;
    }

    public int getScanModuleButtonType() {
        return this.scanModuleButtonType;
    }

    public int getScanedBtnType() {
        return this.scanedBtnType;
    }

    public void setDTCsAfterQueryOnline(ArrayList<BasicFaultCodeBean> arrayList) {
        BasicSysListTopSystemInfoBean systemBySysID = getSystemBySysID(getCurrScanSysId());
        if (systemBySysID != null) {
            systemBySysID.getSystemFaultCodeBean().clear();
            Iterator<BasicFaultCodeBean> it = arrayList.iterator();
            while (it.hasNext()) {
                systemBySysID.getSystemFaultCodeBean().add(it.next());
            }
        }
        retDiagInScanningDTC();
    }

    private void retDiagInScanningDTC() {
        this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_ScannDTCEND);
        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, (byte) (this.btnClickedInScanning & 255)});
        this.btnClickedInScanning = Ret_IN_SCANNING_NEXT;
        this.IsOnLineDTCInSystemScanning = false;
    }

    public Boolean getShowDTCInDataStreamShow() {
        return this.isShowDTCInDataStreamShow;
    }

    public void setShowDTCInDataStreamShow(Boolean bool) {
        this.isShowDTCInDataStreamShow = bool;
    }

    public BasicFaultCodeBean getDtcShowDataStreamShow() {
        return this.dtcShowDataStreamShow;
    }

    public void setDtcShowDataStreamShow(BasicFaultCodeBean basicFaultCodeBean) {
        this.dtcShowDataStreamShow = basicFaultCodeBean;
    }

    public BasicFaultCodeBean getDtcForDataStream() {
        return this.dtcForDataStream;
    }

    public void setDtcForDataStream(BasicFaultCodeBean basicFaultCodeBean) {
        this.dtcForDataStream = basicFaultCodeBean;
    }

    public String getSoftID_DTC_DS() {
        return this.softID_DTC_DS;
    }

    public boolean isbGetDTC_DS_With_Langue() {
        return this.bGetDTC_DS_With_Langue;
    }

    public String getStrAddInfo_DTC_DS() {
        return this.strAddInfo_DTC_DS;
    }

    public static SysListTopViewUtils getInstance() {
        if (instance == null) {
            instance = new SysListTopViewUtils();
        }
        return instance;
    }

    public void setmService(Messenger messenger) {
        this.mService = messenger;
    }

    public void setCallbackListener(OnDiagnoseDataListener onDiagnoseDataListener) {
        this.mIDiagnoseDataCallback = onDiagnoseDataListener;
    }

    public ArrayList<String> getArrTitle() {
        return this.arrTitle;
    }

    public ArrayList<Integer> getArrSystemType() {
        return this.arrSystemType;
    }

    private synchronized void SendByteDataFeedbackMessage(String str, byte[] bArr) {
        try {
            Message obtain = Message.obtain((Handler) null, 24);
            Bundle bundle = new Bundle();
            bundle.putString(JsonConstText.Const_Text_Type, str);
            bundle.putByteArray(JsonConstText.Const_Text_Cmd, bArr);
            obtain.setData(bundle);
            this.mService.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void retDefaultDataToDiagnose() {
        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
    }

    public void clearSysListTopViewData() {
        this.arrTitle.clear();
        this.arrSystemType.clear();
        this.arrSysListTopSystemInfo.clear();
        setShowDTCInDataStreamShow(Boolean.FALSE);
        this.IsOnLineDTCInSystemScanning = false;
        this.dtcFromType115 = false;
    }

    public ArrayList<BasicSysListTopSystemInfoBean> getArrSysListTopSystemInfo() {
        return this.arrSysListTopSystemInfo;
    }

    public String getCurrScanSysId() {
        return this.currScanSysId;
    }

    public void setCurrScanSysId(String str) {
        this.currScanSysId = str;
    }

    public int getCurrScanSn() {
        return this.currScanSn;
    }

    public void setCurrScanSn(int i) {
        this.currScanSn = i;
    }

    public int getSumScanSystemNumber() {
        return this.sumScanSystemNumber;
    }

    public void setSumScanSystemNumber(int i) {
        this.sumScanSystemNumber = i;
    }

    private BasicSysListTopSystemInfoBean getSystemBySysID(String str) {
        Iterator<BasicSysListTopSystemInfoBean> it = this.arrSysListTopSystemInfo.iterator();
        while (it.hasNext()) {
            BasicSysListTopSystemInfoBean next = it.next();
            if (next.getSystemID().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private boolean isADASSystem(boolean z, String str) {
        if (z && str.equals("7")) {
            return true;
        }
        if (z || !str.equals(DiagnoseConstants.UI_Type_EXT1_SHOW_INPUTSRING_BY_SCAN_BARCODE)) {
            return this.arrADASSysType.contains(str);
        }
        return true;
    }

    public void dealWithSysListTopViewData(JSONObject jSONObject) {
        try {
            switch (jSONObject.getInt(JsonConstText.Const_Text_Label)) {
                case 0:
                    clearSysListTopViewData();
                    this.scanModuleButtonType = jSONObject.getInt(JsonConstText.Const_Text_BTType);
                    if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            getArrTitle().add(jSONObject2.getString(JsonConstText.Const_Text_Title));
                            getArrSystemType().add(Integer.valueOf(jSONObject2.getInt(JsonConstText.Const_Text_SystemType)));
                        }
                        break;
                    }
                    break;
                case 1:
                    if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                        this.arrSysListTopSystemInfo.clear();
                        JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            BasicSysListTopSystemInfoBean basicSysListTopSystemInfoBean = new BasicSysListTopSystemInfoBean();
                            basicSysListTopSystemInfoBean.setSystemID(jSONObject3.getString(JsonConstText.Const_Text_Id));
                            basicSysListTopSystemInfoBean.setSystemName(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            basicSysListTopSystemInfoBean.setAbbrSystem(jSONObject3.getString(JsonConstText.Const_Text_Label));
                            String string = jSONObject3.getString(JsonConstText.Const_Text_Model);
                            basicSysListTopSystemInfoBean.setSystemType(string);
                            basicSysListTopSystemInfoBean.setADASSytem(isADASSystem(true, string));
                            basicSysListTopSystemInfoBean.setRoot(jSONObject3.getInt(JsonConstText.Const_Text_Status) == 1);
                            basicSysListTopSystemInfoBean.setTopLineName(jSONObject3.getString(JsonConstText.Const_Text_Tabdata));
                            basicSysListTopSystemInfoBean.setColorType(jSONObject3.getInt(JsonConstText.Const_Text_Funtype));
                            this.arrSysListTopSystemInfo.add(basicSysListTopSystemInfoBean);
                        }
                    }
                    this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_SelectItem);
                    return;
                case 2:
                    setCurrScanSysId(jSONObject.getString(JsonConstText.Const_Text_Id));
                    setCurrScanSn(jSONObject.getInt(JsonConstText.Const_Text_Item));
                    setSumScanSystemNumber(jSONObject.getInt(JsonConstText.Const_Text_Count));
                    BasicSysListTopSystemInfoBean systemBySysID = getSystemBySysID(getCurrScanSysId());
                    if (systemBySysID != null) {
                        systemBySysID.setScanStatus(BasicSysListTopSystemInfoBean.STATUS_SCANNING);
                        this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_CurrScanning);
                        break;
                    }
                    break;
                case 3:
                    int i3 = jSONObject.getInt(JsonConstText.Const_Text_CMDType);
                    if (jSONObject.has(JsonConstText.Const_Text_BTType)) {
                        this.btnTypeInSystemDTC = jSONObject.getInt(JsonConstText.Const_Text_BTType);
                    } else {
                        this.btnTypeInSystemDTC = 0;
                    }
                    String string2 = jSONObject.getString(JsonConstText.Const_Text_Id);
                    BasicSysListTopSystemInfoBean systemBySysID2 = getSystemBySysID(string2);
                    ArrayList<BasicFaultCodeBean> arrayList = new ArrayList<>();
                    ArrayList<BasicBean> arrayList2 = new ArrayList<>();
                    if (i3 == 0) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                        for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i4);
                            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                            basicFaultCodeBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                            basicFaultCodeBean.setContext(jSONObject4.getString(JsonConstText.Const_Text_Context));
                            basicFaultCodeBean.setStatus(jSONObject4.getString(JsonConstText.Const_Text_Status));
                            if (jSONObject4.has(JsonConstText.Const_Text_Normal)) {
                                basicFaultCodeBean.setCanChangeISO(true);
                                basicFaultCodeBean.setTitleISO(jSONObject4.getString(JsonConstText.Const_Text_Normal));
                                basicFaultCodeBean.setContextISO(jSONObject4.getString(JsonConstText.Const_Text_Label));
                            }
                            if (jSONObject4.has(JsonConstText.Const_Text_Help)) {
                                basicFaultCodeBean.setHelp(jSONObject4.getString(JsonConstText.Const_Text_Help));
                                basicFaultCodeBean.setHelpIsPath(jSONObject4.getInt(JsonConstText.Const_Text_HelpType) == 3);
                                basicFaultCodeBean.setOnlineArgs(jSONObject4.getString(JsonConstText.Const_Text_CMDAtt));
                            }
                            arrayList.add(basicFaultCodeBean);
                        }
                        if (systemBySysID2 != null) {
                            systemBySysID2.getSystemFaultCodeBean().clear();
                            Iterator<BasicFaultCodeBean> it = arrayList.iterator();
                            while (it.hasNext()) {
                                systemBySysID2.getSystemFaultCodeBean().add(it.next());
                            }
                        }
                    } else if (5 == i3) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                        for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                            BasicOnlineCodeLib basicOnlineCodeLib = new BasicOnlineCodeLib();
                            JSONObject jSONObject5 = jSONArray4.getJSONObject(i5);
                            basicOnlineCodeLib.setSystemID(string2);
                            if (jSONObject5.has(JsonConstText.Const_Text_Id)) {
                                basicOnlineCodeLib.setCodeID(jSONObject5.getString(JsonConstText.Const_Text_Id));
                            }
                            if (jSONObject5.has(JsonConstText.Const_Text_Label)) {
                                basicOnlineCodeLib.setSmallCode(jSONObject5.getString(JsonConstText.Const_Text_Label));
                            }
                            if (jSONObject5.has(JsonConstText.Const_Text_Status)) {
                                basicOnlineCodeLib.setCodeStatusID(jSONObject5.getString(JsonConstText.Const_Text_Status));
                            }
                            if (jSONObject5.has(JsonConstText.Const_Text_Help)) {
                                basicOnlineCodeLib.setHelpID(jSONObject5.getString(JsonConstText.Const_Text_Help));
                            }
                            if (jSONObject5.has(JsonConstText.Const_Text_Normal)) {
                                basicOnlineCodeLib.setHelpType(jSONObject5.getInt(JsonConstText.Const_Text_Normal));
                            }
                            arrayList2.add(basicOnlineCodeLib);
                        }
                        if (systemBySysID2 != null) {
                            systemBySysID2.getSystemFaultCodeBean().clear();
                            Iterator<BasicBean> it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                systemBySysID2.getOnlineFaultCodeList().add((BasicOnlineCodeLib) it2.next());
                            }
                        }
                    }
                    if (i3 == 255) {
                        systemBySysID2.setScanStatus(BasicSysListTopSystemInfoBean.STATUS_NOT_EQUIP);
                    } else if (systemBySysID2.getSystemFaultCodeBean().size() > 0) {
                        systemBySysID2.setScanStatus(BasicSysListTopSystemInfoBean.STATUS_FINISH_ABNORMAL);
                    } else {
                        systemBySysID2.setScanStatus(BasicSysListTopSystemInfoBean.STATUS_FINISH_NORMAL);
                    }
                    if (this.btnTypeInSystemDTC == 0) {
                        if (i3 == 5) {
                            this.IsOnLineDTCInSystemScanning = true;
                            this.mIDiagnoseDataCallback.onDiagnoseTransDiagInfoCallback("", DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX, arrayList2);
                        }
                        retDiagInScanningDTC();
                        return;
                    }
                    this.dtcFromType115 = true;
                    if (i3 == 0) {
                        if (arrayList.size() == 0) {
                            this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_NO_DTC);
                            return;
                        } else {
                            this.mIDiagnoseDataCallback.onDiagnoseFaultCodeDataCallback(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE, arrayList, null);
                            return;
                        }
                    } else if (arrayList2.size() == 0) {
                        this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_NO_DTC);
                        return;
                    } else {
                        this.mIDiagnoseDataCallback.onDiagnoseTransDiagInfoCallback("", DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX, arrayList2);
                        return;
                    }
                case 4:
                    this.scanedBtnType = jSONObject.getInt(JsonConstText.Const_Text_BTType);
                    this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_ScannEnd);
                    return;
                case 5:
                    BasicSysListTopSystemInfoBean systemBySysID3 = getSystemBySysID(DiagnoseInfo.getInstance().getSysNameId());
                    if (systemBySysID3 != null) {
                        ArrayList<BasicECUInfoBean> arrayList3 = new ArrayList<>();
                        JSONArray jSONArray5 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                        for (int i6 = 0; i6 < jSONArray5.length(); i6++) {
                            JSONObject jSONObject6 = jSONArray5.getJSONObject(i6);
                            BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
                            basicECUInfoBean.setEcuType(jSONObject6.getInt(JsonConstText.Const_Text_Type));
                            basicECUInfoBean.setTitle(jSONObject6.getString(JsonConstText.Const_Text_Title));
                            basicECUInfoBean.setValue(jSONObject6.getString(JsonConstText.Const_Text_Value));
                            arrayList3.add(basicECUInfoBean);
                        }
                        systemBySysID3.setSystemECUInfoBean(arrayList3);
                        break;
                    }
                    break;
                case 6:
                    this.softID_DTC_DS = jSONObject.getString(JsonConstText.Const_Text_Softid);
                    this.bGetDTC_DS_With_Langue = jSONObject.getInt(JsonConstText.Const_Text_Langcode) == 1;
                    this.strAddInfo_DTC_DS = jSONObject.getString(JsonConstText.Const_Text_Context);
                    this.mIDiagnoseDataCallback.ShowTopViewData(UIShowType_GetDTC_DS);
                    return;
                case 7:
                    if (jSONObject.getInt(JsonConstText.Const_Text_Value) == 0) {
                        setShowDTCInDataStreamShow(Boolean.TRUE);
                        BasicFaultCodeBean basicFaultCodeBean2 = new BasicFaultCodeBean();
                        basicFaultCodeBean2.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
                        basicFaultCodeBean2.setContext(jSONObject.getString(JsonConstText.Const_Text_Context));
                        basicFaultCodeBean2.setStatus(jSONObject.getString(JsonConstText.Const_Text_Status));
                        setDtcShowDataStreamShow(basicFaultCodeBean2);
                        break;
                    } else {
                        setShowDTCInDataStreamShow(Boolean.FALSE);
                        setDtcShowDataStreamShow(null);
                        break;
                    }
            }
            retDefaultDataToDiagnose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
