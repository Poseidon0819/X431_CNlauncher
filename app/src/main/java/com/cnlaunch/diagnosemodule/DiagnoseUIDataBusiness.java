package com.cnlaunch.diagnosemodule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import com.cnlaunch.diagnosemodule.BasicFCADataBean;
import com.cnlaunch.diagnosemodule.bean.BasicAITHDIMData;
import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicCentralGateWayNetWorkLayoutBean;
import com.cnlaunch.diagnosemodule.bean.BasicChangChengECUCfgBean;
import com.cnlaunch.diagnosemodule.bean.BasicChannelSelectBean;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicDeviceBindBean;
import com.cnlaunch.diagnosemodule.bean.BasicDiagDownloadFileBean;
import com.cnlaunch.diagnosemodule.bean.BasicDialogScanBarcodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicDualHighSpeedLayoutBean;
import com.cnlaunch.diagnosemodule.bean.BasicECUFlashShowBean;
import com.cnlaunch.diagnosemodule.bean.BasicECUInfoBean;
import com.cnlaunch.diagnosemodule.bean.BasicEcuNetWorkLayoutBean;
import com.cnlaunch.diagnosemodule.bean.BasicEmissionDetectBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicFlowChartBean;
import com.cnlaunch.diagnosemodule.bean.BasicFlowChartData;
import com.cnlaunch.diagnosemodule.bean.BasicGetFTSysCfg;
import com.cnlaunch.diagnosemodule.bean.BasicHTMLDialogBean;
import com.cnlaunch.diagnosemodule.bean.BasicInputBean;
import com.cnlaunch.diagnosemodule.bean.BasicInputDataBean;
import com.cnlaunch.diagnosemodule.bean.BasicJLDatastreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicListFrmData;
import com.cnlaunch.diagnosemodule.bean.BasicOEMRequestData;
import com.cnlaunch.diagnosemodule.bean.BasicOemReqSWBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineArithBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineCodeLib;
import com.cnlaunch.diagnosemodule.bean.BasicQueryArgToWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicQueryWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicRealTimeDataBean;
import com.cnlaunch.diagnosemodule.bean.BasicSaveAndQueryWithConditionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSoftIDBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpecFunDynamicEvent;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.bean.BasicTMPSActiveInfo;
import com.cnlaunch.diagnosemodule.bean.BasicTMPSItemBean;
import com.cnlaunch.diagnosemodule.bean.BasicTMPSLearningBean;
import com.cnlaunch.diagnosemodule.bean.BasicTMPSProgrammingBeam;
import com.cnlaunch.diagnosemodule.bean.BasicTMPSTestBean;
import com.cnlaunch.diagnosemodule.bean.BasicVWCodeWindowBean;
import com.cnlaunch.diagnosemodule.bean.BasicVoltagePinBean;
import com.cnlaunch.diagnosemodule.bean.DropDownBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.AbbreviationBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.DataForGolo365;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_CommonData;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_DataStreamBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_DiagnoseResult;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_ECUInfoBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_FreezeBean;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_IUPRData;
import com.cnlaunch.diagnosemodule.bean.EnvironmentalProtectionData.EP_VehicleInfo;
import com.cnlaunch.diagnosemodule.bean.HealthDiagData.BasicHealthDiagConditionData;
import com.cnlaunch.diagnosemodule.bean.HealthDiagData.BasicHealthDiagConditionDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.HealthDiagData.BasicHealthDiagProcessData;
import com.cnlaunch.diagnosemodule.bean.HealthDiagData.BasicHealthDiagTextBean;
import com.cnlaunch.diagnosemodule.bean.MultiPageCompData.MultiPageCompUtils;
import com.cnlaunch.diagnosemodule.bean.SysListTopViewData.SysListTopViewUtils;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicReadDSInfoBean;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicReadDTCInfoBean;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicSoftEnterBean;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicSystemInfo;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicTotelLineBean;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicVerInfo;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicVinListCmdBean;
import com.cnlaunch.diagnosemodule.bean.VinListData.BasicVinListDSBean;
import com.cnlaunch.diagnosemodule.bean.VoltageBpsBean;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.utils.BitmapUtils;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseProcessInfoUtil;
import com.cnlaunch.diagnosemodule.wiget.DiagnoseAlertDialog;
import com.cnlaunch.diagnosemodule.wiget.LoadDialog;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.p206a.Envelope;
import com.cnlaunch.physics.p205k.p206a.Letter;
import com.cnlaunch.physics.p205k.p206a.RemoteMessage;
import com.itextpdf.text.html.HtmlTags;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseUIDataBusiness implements DialogInterface.OnClickListener {
    private boolean isDiagnoseFlagAfterMenuIsDisplay;
    private boolean isHtt80Wanguo;
    private DiagnoseAlertDialog.Builder mAlertDialog;
    private DiagnoseAlertDialog.DiagnoseAlertDialogCallback mAlertDialogCallBack;
    private Context mContext;
    private OnDiagnoseDataListener mIDiagnoseDataCallback;
    private Messenger mService;
    private String mUIType;
    private boolean mInputAfterMask = false;
    private boolean mNotAllowShowDiaglog = false;
    List<DataForGolo365.ReadyStateInfoBean> drdfg365ReadyStateBean = new ArrayList();
    List<DataForGolo365.FaultCodeInfoBean> dfg365FaultCodeInfoBean = new ArrayList();
    List<DataForGolo365.IuprDataBean> dfg365IuprDataBean = new ArrayList();
    List<DataForGolo365.FreezeFrameDataBean> dataForGolo365FreezeFrameBeanArray = new ArrayList();
    List<DataForGolo365.FreezeFrameDataBean.ArrFreezeBean> data4Golo365ArrFreezeBeanArray = new ArrayList();
    private boolean mbCanShowDialog = true;
    private int currentVer = 0;
    private boolean bFromMenuOrSeletDataStream = false;
    private boolean alertDialogWithHTMLData = false;
    private InputFilter[] mMyFilter = {new MyInputFilter()};

    private void jsonUIParallelMenu(String str, JSONObject jSONObject) {
    }

    public boolean getbCanShowDialog() {
        return this.mbCanShowDialog;
    }

    public void setbCanShowDialog(boolean z) {
        this.mbCanShowDialog = z;
    }

    public int getCurrentVer() {
        return this.currentVer;
    }

    public void setCurrentVer(int i) {
        this.currentVer = i;
    }

    public void setCallbackListener(OnDiagnoseDataListener onDiagnoseDataListener) {
        this.mIDiagnoseDataCallback = onDiagnoseDataListener;
        MultiPageCompUtils.getInstance().setCallbackListener(this.mIDiagnoseDataCallback);
        SysListTopViewUtils.getInstance().setCallbackListener(this.mIDiagnoseDataCallback);
    }

    public DiagnoseUIDataBusiness(Context context, Messenger messenger) {
        this.mContext = null;
        this.isHtt80Wanguo = false;
        this.mContext = context;
        this.mService = messenger;
        MultiPageCompUtils.getInstance().setmService(messenger);
        SysListTopViewUtils.getInstance().setmService(messenger);
        closeRemoteDialog();
        this.mAlertDialog = new DiagnoseAlertDialog.Builder(context, C1444R.style.DiagnoseMessageDialogTheme);
        this.isHtt80Wanguo = PreferencesManager.m9595a(context).m9583b("is_htt80_wanguo", false);
    }

    private boolean isFilterDialog(String str, String str2) {
        if (DiagnoseConstants.getDiagIdentity() == 0 && (str2.equals(DiagnoseConstants.UI_TYPE_MESSAGEBOX_TEXT_CUSTOMBUTTON) || str.equals("200"))) {
            return true;
        }
        return (DiagnoseConstants.isAutoDiagnose && str.equals(DiagnoseConstants.UI_TYPE_DIALOG)) || str.equals(DiagnoseConstants.UI_TYPE_REMOVE_DIAGLOG);
    }

    public void stdJsonToUI(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(JsonConstText.Const_Text_Type);
            if (jSONObject.has(JsonConstText.Const_Text_Ver)) {
                DiagnoseConstants.SO_DIAG_VERSION = Integer.parseInt(jSONObject.getString(JsonConstText.Const_Text_Ver));
            } else {
                DiagnoseConstants.SO_DIAG_VERSION = -1;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(JsonConstText.Const_Text_Data));
            this.mUIType = jSONObject2.getString(JsonConstText.Const_Text_Ui_type);
            if (!this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG) && !this.mUIType.equals("90")) {
                setIsDiagnoseFlagAfterMenuIsDisplay(true);
            }
            if (this.mNotAllowShowDiaglog && DiagnoseConstants.UI_TYPE_DIALOG.equals(this.mUIType) && DiagnoseConstants.UI_TYPE_DIALOG.equals(string)) {
                return;
            }
            if (isFilterDialog(string, this.mUIType)) {
                closeAlertDialog(this.mUIType, false);
                dismissMessageBox(this.mUIType);
                return;
            }
            if (this.mUIType.equals(DiagnoseConstants.UI_Type_ShowTransDiagInfo)) {
                String string2 = jSONObject2.has(JsonConstText.Const_Text_Type) ? jSONObject2.getString(JsonConstText.Const_Text_Type) : "";
                if (!string2.equals(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU) && !string2.equals(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG) && !string2.equals(DiagnoseConstants.FEEDBACK_CURRENT_MENU_PATH) && !string2.equals(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM)) {
                    closeAlertDialog(this.mUIType, false);
                }
            } else if (!string.equals(DiagnoseConstants.UI_TYPE_DIAG_CALL_SERVICE) && !string.equals(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE)) {
                closeAlertDialog(this.mUIType, false);
            }
            if (string.equals(DiagnoseConstants.UI_TYPE_DIALOG)) {
                if (DiagnoseConstants.SHOW_EXIT_DIALOG) {
                    return;
                }
                jsonUIAlertDialog(this.mUIType, jSONObject2);
            } else if (string.equals("200")) {
                if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING_CUSTEOM)) {
                    jsonUICustom(this.mUIType, jSONObject2);
                } else {
                    jsonUIInputDialog(this.mUIType, jSONObject2);
                }
            } else if (string.equals("300")) {
                jsonUIMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_SELECT)) {
                jsonUISelectMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_ACTIVE_TEST)) {
                jsonUIActiveTest(this.mUIType, jSONObject2, jSONObject.has(JsonConstText.Const_Text_Title) ? jSONObject.getString(JsonConstText.Const_Text_Title) : null);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_FAULTCODE)) {
                jsonUIFaultCode(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM)) {
                jsonUIDataStream(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
                jsonUIDataStream(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION)) {
                jsonUISpecialFunction(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_COMBINE_MENU)) {
                jsonUICombineMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SHOW_DIALOG_INFO)) {
                jsonUIShowDialog(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_ARGING_WINDOW)) {
                jsonUIAgringWindow(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_PARALLEL_MENU)) {
                jsonUIParallelMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_PARALLEL_SUB_MENU)) {
                jsonUIParallelMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SUB_FAULTCODE)) {
                jsonUIFaultCode(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SUB_PAGE_DATASTREAM)) {
                jsonUIDataStream(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_NO_UI_CMD)) {
                jsonUIFeedback(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_CURRENT_MENU_PATH)) {
                jsonUICurrentMenuPath(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_GET_DIAGNOSE_RECORD)) {
                jsonUIDiagnoseRecord(this.mUIType, jSONObject2);
            } else if (string.equals("1900")) {
                jsonUIDiagnoseCarInfo(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DIAG_FUN_INFO)) {
                jsonUIDiagnoseDiagFunInfo(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_DATASTREAM)) {
                jsonUIDiagnoseSpecialDatastream(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_RESET_CARICON_MENU)) {
                jsonUIDiagnoseResetCarIconMenu(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SELECT_FILEDIALOG)) {
                jsonUISelectFileDialog(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
                jsonUIDataStream(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_MESSAGEBOX_TEXT_CUSTOMBUTTON)) {
                jsonUIMsgBoxWithCustomBtnDialog(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DIAG_CALL_SERVICE)) {
                jsonUIDiagCallService(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_ShowDTC_HELP)) {
                jsonUIShowDTCAndFunctionHelp(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_ShowFunction_HELP)) {
                jsonUIShowDTCAndFunctionHelp(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_DownloadFile)) {
                jsonUIDownloadFile(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE)) {
                jsonUIQueryWebSite(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_WINDON)) {
                jsonUIMulitInputWindow(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_ShowTransDiagInfo)) {
                jsonUIShowTransDiagInfo(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_VERIFY_MAINTENANCE_QUALIFICATIONS)) {
                jsonUIVerifyMaintenance(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect)) {
                jsonUISpecialMultiSelect(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_CUSTOM_USE_ID)) {
                jsonUICustomUseID(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_GET_NEW_VEHICLE_DATA)) {
                jsonUIGetNewVehicle(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_GET_CURRENT_UNIT_TYPE)) {
                jsonGetCurrentUnitType(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_EXT1_DOWNLOAD_ECU_FILES)) {
                jsonUIDownloadMultFile(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_UPLOAD_ECU_FILE_ID)) {
                jsonUIUploadEcuFile(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_Type_STD_EXT1)) {
                jsonUIShowSTD_EX1(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_CHANEL_SELECT)) {
                jsonUIChanelSelect(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_LEFT_VIEW)) {
                jsonUILeftView(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_ADDRESS)) {
                jsonUIAddresPath(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SUB_LABEL)) {
                jsonUISubLabel(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_INFORMATION_SHOW)) {
                jsonUIInformationShow(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_VERSION_INFORMATION)) {
                jsonUIVersionInfos(this.mUIType, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_CUSTOM_ROW_COL)) {
                jsonUICustomListFunction(this.mUIType, jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseEmissionDetctData(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        int i;
        BasicEmissionDetectBean basicEmissionDetectBean = new BasicEmissionDetectBean();
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Model)) {
                i = jSONObject.getInt(JsonConstText.Const_Text_Model);
                basicEmissionDetectBean.setDataTye(i);
            } else {
                i = -1;
            }
            if (jSONObject.has(JsonConstText.Const_Text_Ratio)) {
                basicEmissionDetectBean.setRatio(jSONObject.getInt(JsonConstText.Const_Text_Ratio));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Label)) {
                basicEmissionDetectBean.setContext(jSONObject.getString(JsonConstText.Const_Text_Label));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Status)) {
                basicEmissionDetectBean.setState(jSONObject.getInt(JsonConstText.Const_Text_Status));
            }
            if (!jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                arrayList.add(basicEmissionDetectBean);
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            int i2 = 0;
            if (i == 3) {
                basicEmissionDetectBean.getArrayListFaultCode().clear();
                while (i2 < jSONArray.length()) {
                    BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                        basicFaultCodeBean.setId(jSONObject2.getString(JsonConstText.Const_Text_Id));
                    }
                    if (jSONObject2.has(JsonConstText.Const_Text_Title)) {
                        basicFaultCodeBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    }
                    if (jSONObject2.has(JsonConstText.Const_Text_Context)) {
                        basicFaultCodeBean.setContext(jSONObject2.getString(JsonConstText.Const_Text_Context));
                    }
                    if (jSONObject2.has(JsonConstText.Const_Text_Status)) {
                        basicFaultCodeBean.setStatus(jSONObject2.getString(JsonConstText.Const_Text_Status));
                    }
                    basicEmissionDetectBean.setFaultCodeToArrayList(basicFaultCodeBean);
                    i2++;
                }
            } else if (i == 4 || i == 5 || 6 == i) {
                basicEmissionDetectBean.getArrayListDataStream().clear();
                while (i2 < jSONArray.length()) {
                    BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean();
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    if (jSONObject3.has(JsonConstText.Const_Text_Title)) {
                        basicDataStreamBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Id)) {
                        basicDataStreamBean.setId(jSONObject3.getString(JsonConstText.Const_Text_Id));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Unit)) {
                        basicDataStreamBean.setUnit(jSONObject3.getString(JsonConstText.Const_Text_Unit));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Value)) {
                        basicDataStreamBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                    }
                    basicEmissionDetectBean.setDataStreamToArrayList(basicDataStreamBean);
                    i2++;
                }
            }
            arrayList.add(basicEmissionDetectBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseReadVin(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has(JsonConstText.Const_Text_SystemName)) {
                    basicSystemStatusBean.setSystemName(jSONObject2.getString(JsonConstText.Const_Text_SystemName));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                    basicSystemStatusBean.setSystemID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Type)) {
                    basicSystemStatusBean.setSystemType(jSONObject2.getString(JsonConstText.Const_Text_Type));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_OLD_VIN)) {
                    basicSystemStatusBean.setOldVIN(jSONObject2.getString(JsonConstText.Const_Text_OLD_VIN));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_VIN)) {
                    basicSystemStatusBean.setCurrVIN(jSONObject2.getString(JsonConstText.Const_Text_VIN));
                }
                arrayList.add(basicSystemStatusBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseFTSysCFG(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicGetFTSysCfg basicGetFTSysCfg = new BasicGetFTSysCfg();
            if (jSONObject.has(JsonConstText.Const_Text_Model)) {
                basicGetFTSysCfg.setMode(jSONObject.getInt(JsonConstText.Const_Text_Model));
            }
            if (jSONObject.has(JsonConstText.Const_Text_CurrNum)) {
                basicGetFTSysCfg.setRomNum(jSONObject.getInt(JsonConstText.Const_Text_CurrNum));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Value)) {
                basicGetFTSysCfg.setStrHexValue(jSONObject.getString(JsonConstText.Const_Text_Value));
            }
            arrayList.add(basicGetFTSysCfg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseFTHTML(String str, JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicHTMLDialogBean basicHTMLDialogBean = new BasicHTMLDialogBean();
            int i = 0;
            if (str.equals(DiagnoseConstants.FEEDBACK_SPT_CUSTOM_USE_ID)) {
                basicHTMLDialogBean.setStrTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (basicHTMLDialogBean.getBtnType() == -1) {
                        basicHTMLDialogBean.setBtnType(jSONObject2.getInt(JsonConstText.Const_Text_Label));
                    }
                    basicHTMLDialogBean.getArrayListContext().add(jSONObject2.getString(JsonConstText.Const_Text_Context));
                    i++;
                }
                arrayList.add(basicHTMLDialogBean);
                return;
            }
            basicHTMLDialogBean.setBtnType(str.equals(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX) ? jSONObject.getInt(JsonConstText.Const_Text_Label) : -1);
            basicHTMLDialogBean.setStrTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            while (i < jSONArray2.length()) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                if (jSONObject3.has(JsonConstText.Const_Text_Title)) {
                    basicHTMLDialogBean.getArrayListContext().add(jSONObject3.getString(JsonConstText.Const_Text_Title));
                }
                i++;
            }
            if (str.equals(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX)) {
                UIAlertDialogWithHTMLData(basicHTMLDialogBean);
            } else {
                arrayList.add(basicHTMLDialogBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseFTOnLineCodeLib(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Label);
            String string2 = jSONObject.has(JsonConstText.Const_Text_Id) ? jSONObject.getString(JsonConstText.Const_Text_Id) : "";
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                BasicOnlineCodeLib basicOnlineCodeLib = new BasicOnlineCodeLib();
                basicOnlineCodeLib.setSoftID(string);
                basicOnlineCodeLib.setSystemID(string2);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                    basicOnlineCodeLib.setCodeID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Label)) {
                    basicOnlineCodeLib.setSmallCode(jSONObject2.getString(JsonConstText.Const_Text_Label));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Status)) {
                    basicOnlineCodeLib.setCodeStatusID(jSONObject2.getString(JsonConstText.Const_Text_Status));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Help)) {
                    basicOnlineCodeLib.setHelpID(jSONObject2.getString(JsonConstText.Const_Text_Help));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Normal)) {
                    basicOnlineCodeLib.setHelpType(jSONObject2.getInt(JsonConstText.Const_Text_Normal));
                }
                arrayList.add(basicOnlineCodeLib);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseFTOnLineCodeLibHelp(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Label);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_Id);
            BasicOnlineCodeLib basicOnlineCodeLib = new BasicOnlineCodeLib();
            basicOnlineCodeLib.setSoftID(string);
            basicOnlineCodeLib.setHelpID(string2);
            arrayList.add(basicOnlineCodeLib);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseFTOnLineArith(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicOnlineArithBean basicOnlineArithBean = new BasicOnlineArithBean();
            basicOnlineArithBean.setSoftID(jSONObject.getString(JsonConstText.Const_Text_Label));
            basicOnlineArithBean.setAriType(jSONObject.getInt(JsonConstText.Const_Text_Normal));
            basicOnlineArithBean.setHexData(jSONObject.getString(JsonConstText.Const_Text_Arguments));
            arrayList.add(basicOnlineArithBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseReadECU(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has(JsonConstText.Const_Text_SystemName)) {
                    basicSystemStatusBean.setSystemName(jSONObject2.getString(JsonConstText.Const_Text_SystemName));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                    basicSystemStatusBean.setSystemID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                }
                JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    if (jSONObject3.has(JsonConstText.Const_Text_Value)) {
                        basicECUInfoBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Context)) {
                        basicECUInfoBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Context));
                    }
                    basicSystemStatusBean.getSystemECUInfoBean().add(basicECUInfoBean);
                }
                arrayList.add(basicSystemStatusBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    private void getCTHeadDiagData(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        ArrayList<BasicBean> arrayList2;
        try {
            String str = "";
            BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
            if (jSONObject.has(JsonConstText.Const_Text_Id)) {
                basicSystemStatusBean.setSystemID(jSONObject.getString(JsonConstText.Const_Text_Id));
            }
            if (jSONObject.has(JsonConstText.Const_Text_CurrNum)) {
                basicSystemStatusBean.setCurrentNum(jSONObject.getInt(JsonConstText.Const_Text_CurrNum));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Count)) {
                basicSystemStatusBean.setTotleCount(jSONObject.getInt(JsonConstText.Const_Text_Count));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Check)) {
                basicSystemStatusBean.setIsNew(jSONObject.getInt(JsonConstText.Const_Text_Check));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Context)) {
                str = jSONObject.getString(JsonConstText.Const_Text_Context);
                basicSystemStatusBean.setSystemName(str);
            }
            if (jSONObject.has(JsonConstText.Const_Text_SystemType)) {
                basicSystemStatusBean.setSystemType(jSONObject.getString(JsonConstText.Const_Text_SystemType));
            }
            if (jSONObject.has(JsonConstText.Const_Text_SystemData)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_SystemData);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has(JsonConstText.Const_Text_Value)) {
                        basicSystemStatusBean.getSystemInfoList().add(jSONObject2.getString(JsonConstText.Const_Text_Value));
                    }
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    BasicECUInfoBean basicECUInfoBean = new BasicECUInfoBean();
                    if (jSONObject3.has(JsonConstText.Const_Text_Id)) {
                        basicECUInfoBean.setId(jSONObject3.getString(JsonConstText.Const_Text_Id));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Value)) {
                        basicECUInfoBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                    }
                    if (jSONObject3.has(JsonConstText.Const_Text_Title)) {
                        basicECUInfoBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    }
                    basicSystemStatusBean.getSystemECUInfoBean().add(basicECUInfoBean);
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                    BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                    if (jSONObject4.has(JsonConstText.Const_Text_Id)) {
                        basicFaultCodeBean.setId(jSONObject4.getString(JsonConstText.Const_Text_Id));
                    }
                    basicFaultCodeBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                    basicFaultCodeBean.setContext(jSONObject4.getString(JsonConstText.Const_Text_Context));
                    basicFaultCodeBean.setStatus(jSONObject4.getString(JsonConstText.Const_Text_Status));
                    if (jSONObject4.has(JsonConstText.Const_Text_Help)) {
                        basicFaultCodeBean.setHelp(jSONObject4.getString(JsonConstText.Const_Text_Help));
                    }
                    basicFaultCodeBean.setSys(str);
                    if (jSONObject4.has(JsonConstText.Const_Text_Data)) {
                        JSONArray jSONArray4 = jSONObject4.getJSONArray(JsonConstText.Const_Text_Data);
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            JSONObject jSONObject5 = jSONArray4.getJSONObject(i4);
                            String str2 = "";
                            String string = jSONObject5.has(JsonConstText.Const_Text_Id) ? jSONObject5.getString(JsonConstText.Const_Text_Id) : "";
                            String string2 = jSONObject5.has(JsonConstText.Const_Text_Title) ? jSONObject5.getString(JsonConstText.Const_Text_Title) : "";
                            String string3 = jSONObject5.has(JsonConstText.Const_Text_Unit) ? jSONObject5.getString(JsonConstText.Const_Text_Unit) : "";
                            if (jSONObject5.has(JsonConstText.Const_Text_Value)) {
                                str2 = jSONObject5.getString(JsonConstText.Const_Text_Value);
                            }
                            BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean();
                            basicDataStreamBean.setId(string);
                            basicDataStreamBean.setTitle(string2);
                            basicDataStreamBean.setUnit(string3);
                            basicDataStreamBean.setValue(str2);
                            basicFaultCodeBean.getDataStreamInfoList().add(basicDataStreamBean);
                        }
                    }
                    basicSystemStatusBean.getSystemFaultCodeBean().add(basicFaultCodeBean);
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_Accdata)) {
                JSONArray jSONArray5 = jSONObject.getJSONArray(JsonConstText.Const_Text_Accdata);
                for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                    JSONObject jSONObject6 = jSONArray5.getJSONObject(i5);
                    String str3 = "";
                    String string4 = jSONObject6.has(JsonConstText.Const_Text_Id) ? jSONObject6.getString(JsonConstText.Const_Text_Id) : "";
                    String string5 = jSONObject6.has(JsonConstText.Const_Text_Title) ? jSONObject6.getString(JsonConstText.Const_Text_Title) : "";
                    if (jSONObject6.has(JsonConstText.Const_Text_Unit)) {
                        str3 = jSONObject6.getString(JsonConstText.Const_Text_Unit);
                    }
                    BasicDataStreamBean basicDataStreamBean2 = new BasicDataStreamBean();
                    basicDataStreamBean2.setId(string4);
                    basicDataStreamBean2.setTitle(string5);
                    basicDataStreamBean2.setUnit(str3);
                    basicSystemStatusBean.getDataStreamInfoList().add(basicDataStreamBean2);
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_DSData)) {
                JSONArray jSONArray6 = jSONObject.getJSONArray(JsonConstText.Const_Text_DSData);
                for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                    JSONObject jSONObject7 = jSONArray6.getJSONObject(i6);
                    String string6 = jSONObject7.has(JsonConstText.Const_Text_Time) ? jSONObject7.getString(JsonConstText.Const_Text_Time) : "";
                    JSONArray jSONArray7 = jSONObject7.getJSONArray(JsonConstText.Const_Text_Data);
                    for (int i7 = 0; i7 < jSONArray7.length(); i7++) {
                        JSONObject jSONObject8 = jSONArray7.getJSONObject(i7);
                        BasicDataStreamBean basicDataStreamBean3 = basicSystemStatusBean.getDataStreamInfoList().get(i7);
                        if (i6 == 0) {
                            basicDataStreamBean3.setValue(jSONObject8.getString(JsonConstText.Const_Text_Value));
                            basicDataStreamBean3.SetTime(string6);
                        } else {
                            basicDataStreamBean3.setValue(basicDataStreamBean3.getSrcValue() + "\"" + jSONObject8.getString(JsonConstText.Const_Text_Value));
                            basicDataStreamBean3.SetTime(basicDataStreamBean3.getTime() + "\"" + string6);
                        }
                    }
                }
                arrayList2 = arrayList;
            } else {
                arrayList2 = arrayList;
            }
            arrayList2.add(basicSystemStatusBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListSoftEnterData(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            BasicSoftEnterBean basicSoftEnterBean = new BasicSoftEnterBean();
            basicSoftEnterBean.setType(str);
            basicSoftEnterBean.setSoftId(jSONObject.getString(JsonConstText.Const_Text_Softid));
            basicSoftEnterBean.setVersionNo(jSONObject.getString(JsonConstText.Const_Text_Fileversion));
            basicSoftEnterBean.setLanguage(jSONObject.getString(JsonConstText.Const_Text_Langcode));
            basicSoftEnterBean.setGGPName1(jSONObject.getString(JsonConstText.Const_Text_GGPName));
            basicSoftEnterBean.setGGPName2(jSONObject.getString(JsonConstText.Const_Text_GGPNameEx));
            basicSoftEnterBean.setReserve(jSONObject.getString(JsonConstText.Const_Text_default));
            arrayList.add(basicSoftEnterBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListCanTotelLineData(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    BasicTotelLineBean basicTotelLineBean = new BasicTotelLineBean();
                    basicTotelLineBean.setType(str);
                    basicTotelLineBean.setBaud_rate(jSONObject2.getString(JsonConstText.Const_Text_BTType));
                    basicTotelLineBean.setCommunicatePin(jSONObject2.getString(JsonConstText.Const_Text_ComPin));
                    basicTotelLineBean.setProtocolType(jSONObject2.getString(JsonConstText.Const_Text_PLType));
                    basicTotelLineBean.setId(jSONObject2.getString(JsonConstText.Const_Text_Id));
                    basicTotelLineBean.setDataDiamonLength(jSONObject2.getString(JsonConstText.Const_Text_Datalen));
                    basicTotelLineBean.setData(jSONObject2.getString(JsonConstText.Const_Text_Data));
                    basicTotelLineBean.setReshTime(jSONObject2.getString(JsonConstText.Const_Text_Time));
                    arrayList.add(basicTotelLineBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListSystemDataStreamData(JSONObject jSONObject, BasicSystemInfo basicSystemInfo) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_DSData)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_DSData);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    BasicReadDSInfoBean basicReadDSInfoBean = new BasicReadDSInfoBean();
                    basicReadDSInfoBean.setMenuName(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicReadDSInfoBean.setMenuId(jSONObject2.getString(JsonConstText.Const_Text_Id));
                    if (jSONObject2.has(JsonConstText.Const_Text_IniCmd)) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_IniCmd);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            BasicVinListCmdBean basicVinListCmdBean = new BasicVinListCmdBean();
                            basicVinListCmdBean.setCmdType(jSONObject3.getString(JsonConstText.Const_Text_CMDType));
                            basicVinListCmdBean.setArithID(jSONObject3.getString(JsonConstText.Const_Text_Id));
                            basicVinListCmdBean.setCmdData(jSONObject3.getString(JsonConstText.Const_Text_Data));
                            basicReadDSInfoBean.getArrIniCmd().add(basicVinListCmdBean);
                        }
                    }
                    if (jSONObject2.has(JsonConstText.Const_Text_Data)) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Data);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                            BasicVinListDSBean basicVinListDSBean = new BasicVinListDSBean();
                            basicVinListDSBean.setDsID(jSONObject4.getString(JsonConstText.Const_Text_Id));
                            basicVinListDSBean.setDsName(jSONObject4.getString(JsonConstText.Const_Text_Title));
                            basicVinListDSBean.setDsUnit(jSONObject4.getString(JsonConstText.Const_Text_Unit));
                            basicVinListDSBean.setDsValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                            basicVinListDSBean.setArithID(jSONObject4.getString(JsonConstText.Const_Text_ArithInfo));
                            if (jSONObject4.has(JsonConstText.Const_Text_Cmd)) {
                                JSONArray jSONArray4 = jSONObject4.getJSONArray(JsonConstText.Const_Text_Cmd);
                                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                                    basicVinListDSBean.getArrCMD().add(jSONArray4.getJSONObject(i4).getString(JsonConstText.Const_Text_Data));
                                }
                            }
                            basicReadDSInfoBean.getArrDsData().add(basicVinListDSBean);
                        }
                    }
                    basicSystemInfo.getArrReadDSInfo().add(basicReadDSInfoBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListSystemReadDTCData(JSONObject jSONObject, BasicSystemInfo basicSystemInfo) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    BasicReadDTCInfoBean basicReadDTCInfoBean = new BasicReadDTCInfoBean();
                    basicReadDTCInfoBean.setDataType(jSONObject2.getString(JsonConstText.Const_Text_Type));
                    basicReadDTCInfoBean.setMenuName(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicReadDTCInfoBean.setMenuID(jSONObject2.getString(JsonConstText.Const_Text_Dataid));
                    basicReadDTCInfoBean.setArithID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                    if (jSONObject2.has(JsonConstText.Const_Text_Cmd)) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Cmd);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            basicReadDTCInfoBean.getArrCmd().add(jSONArray2.getJSONObject(i2).getString(JsonConstText.Const_Text_Data));
                        }
                    }
                    basicSystemInfo.getArrReadDTCInfo().add(basicReadDTCInfoBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListSystemVersionInfoData(JSONObject jSONObject, BasicSystemInfo basicSystemInfo) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Tabdata)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Tabdata);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    BasicVerInfo basicVerInfo = new BasicVerInfo();
                    basicVerInfo.setId(jSONObject2.getString(JsonConstText.Const_Text_Id));
                    basicVerInfo.setName(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicVerInfo.setCurrentValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                    basicVerInfo.setVerInfotype(jSONObject2.getString(JsonConstText.Const_Text_Type));
                    basicVerInfo.setArithInfo(jSONObject2.getString(JsonConstText.Const_Text_ArithInfo));
                    if (jSONObject2.has(JsonConstText.Const_Text_Cmd)) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Cmd);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            basicVerInfo.getArrCmd().add(jSONArray2.getJSONObject(i2).getString(JsonConstText.Const_Text_Data));
                        }
                    }
                    basicSystemInfo.getArrVersonInfo().add(basicVerInfo);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListSystemBasicInfoData(JSONObject jSONObject, BasicSystemInfo basicSystemInfo) {
        try {
            basicSystemInfo.setType("");
            if (jSONObject.has(JsonConstText.Const_Text_GGPType)) {
                basicSystemInfo.setGGPType(jSONObject.getInt(JsonConstText.Const_Text_GGPType));
            }
            if (jSONObject.has(JsonConstText.Const_Text_VerGGPType)) {
                basicSystemInfo.setVerInfoGGPType(jSONObject.getInt(JsonConstText.Const_Text_VerGGPType));
            }
            if (jSONObject.has(JsonConstText.Const_Text_DTCGGPType)) {
                basicSystemInfo.setReadDTCGGPType(jSONObject.getInt(JsonConstText.Const_Text_DTCGGPType));
            }
            if (jSONObject.has(JsonConstText.Const_Text_DSGGPType)) {
                basicSystemInfo.setReadDSGGPType(jSONObject.getInt(JsonConstText.Const_Text_DSGGPType));
            }
            if (jSONObject.has(JsonConstText.Const_Text_ClearArithId)) {
                basicSystemInfo.setClearDTCArithID(jSONObject.getString(JsonConstText.Const_Text_ClearArithId));
            }
            if (jSONObject.has(JsonConstText.Const_Text_Count)) {
                basicSystemInfo.setCountDataStream(jSONObject.getInt(JsonConstText.Const_Text_Count));
            }
            basicSystemInfo.setSystemID(jSONObject.getString(JsonConstText.Const_Text_Id));
            basicSystemInfo.setSystemName(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicSystemInfo.setSystemUUID(jSONObject.getString(JsonConstText.Const_Text_Data));
            basicSystemInfo.setSysType(jSONObject.getString(JsonConstText.Const_Text_SystemType));
            basicSystemInfo.setProtocolType(jSONObject.getString(JsonConstText.Const_Text_PLType));
            basicSystemInfo.setConnecterType(jSONObject.getString(JsonConstText.Const_Text_ConnecterType));
            basicSystemInfo.setCommunicatePin(jSONObject.getString(JsonConstText.Const_Text_ComPin));
            basicSystemInfo.setBiteType(jSONObject.getString(JsonConstText.Const_Text_BTType));
            basicSystemInfo.setReserve(jSONObject.getString(JsonConstText.Const_Text_default));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getVINListDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            String string = jSONObject.has(JsonConstText.Const_Text_Dataid) ? jSONObject.getString(JsonConstText.Const_Text_Dataid) : "";
            if (string.equals("1")) {
                getVINListSoftEnterData(jSONObject, string, arrayList);
            } else if (string.equals(DiagnoseConstants.FEEDBACK_INPUT_NUMBER)) {
                getVINListCanTotelLineData(jSONObject, string, arrayList);
            } else {
                BasicSystemInfo basicSystemInfo = new BasicSystemInfo();
                getVINListSystemBasicInfoData(jSONObject, basicSystemInfo);
                if (jSONObject.has(JsonConstText.Const_Text_Cmd)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Cmd);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        BasicVinListCmdBean basicVinListCmdBean = new BasicVinListCmdBean();
                        basicVinListCmdBean.setCmdAtt(jSONObject2.getString(JsonConstText.Const_Text_CMDAtt));
                        basicVinListCmdBean.setCmdType(jSONObject2.getString(JsonConstText.Const_Text_CMDType));
                        basicVinListCmdBean.setArithID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                        basicVinListCmdBean.setCmdData(jSONObject2.getString(JsonConstText.Const_Text_Data));
                        basicSystemInfo.getArCMDEnterSys().add(basicVinListCmdBean);
                    }
                }
                if (jSONObject.has(JsonConstText.Const_Text_ExitCmd)) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_ExitCmd);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        BasicVinListCmdBean basicVinListCmdBean2 = new BasicVinListCmdBean();
                        basicVinListCmdBean2.setCmdType(jSONObject3.getString(JsonConstText.Const_Text_CMDType));
                        basicVinListCmdBean2.setArithID(jSONObject3.getString(JsonConstText.Const_Text_Id));
                        basicVinListCmdBean2.setCmdData(jSONObject3.getString(JsonConstText.Const_Text_Data));
                        basicSystemInfo.getArCMDExitSys().add(basicVinListCmdBean2);
                    }
                }
                if (jSONObject.has(JsonConstText.Const_Text_IniVerInfoCmd)) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_IniVerInfoCmd);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                        BasicVinListCmdBean basicVinListCmdBean3 = new BasicVinListCmdBean();
                        basicVinListCmdBean3.setCmdType(jSONObject4.getString(JsonConstText.Const_Text_CMDType));
                        basicVinListCmdBean3.setArithID(jSONObject4.getString(JsonConstText.Const_Text_Id));
                        basicVinListCmdBean3.setCmdData(jSONObject4.getString(JsonConstText.Const_Text_Data));
                        basicSystemInfo.getArIniVerInfo().add(basicVinListCmdBean3);
                    }
                }
                if (jSONObject.has(JsonConstText.Const_Text_ClearDtcCmd)) {
                    JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_ClearDtcCmd);
                    for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                        basicSystemInfo.getArCMDClearDTC().add(jSONArray4.getJSONObject(i4).getString(JsonConstText.Const_Text_Data));
                    }
                }
                getVINListSystemVersionInfoData(jSONObject, basicSystemInfo);
                getVINListSystemReadDTCData(jSONObject, basicSystemInfo);
                getVINListSystemDataStreamData(jSONObject, basicSystemInfo);
                arrayList.add(basicSystemInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    private void getDetectVehInfoData(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        ArrayList<BasicBean> arrayList2;
        try {
            EP_VehicleInfo eP_VehicleInfo = new EP_VehicleInfo();
            DataForGolo365.VehicleInfoBean vehicleInfoBean = new DataForGolo365.VehicleInfoBean();
            ArrayList arrayList3 = new ArrayList();
            eP_VehicleInfo.setType(str);
            eP_VehicleInfo.setODO(jSONObject.getString(JsonConstText.Const_Text_ODO));
            vehicleInfoBean.setOdo(jSONObject.getString(JsonConstText.Const_Text_ODO));
            eP_VehicleInfo.setClearDTCODO(jSONObject.getString(JsonConstText.Const_Text_Value));
            vehicleInfoBean.setMil_odo(jSONObject.getString(JsonConstText.Const_Text_Value));
            eP_VehicleInfo.setIgnition_Type(jSONObject.getInt(JsonConstText.Const_Text_BTType));
            vehicleInfoBean.setIgnition_type(jSONObject.getInt(JsonConstText.Const_Text_BTType));
            eP_VehicleInfo.setFaultCodeLampStatus(jSONObject.getInt(JsonConstText.Const_Text_Status));
            vehicleInfoBean.setMil_status(jSONObject.getInt(JsonConstText.Const_Text_Status));
            eP_VehicleInfo.setObd_req(jSONObject.getString(JsonConstText.Const_Text_Content));
            vehicleInfoBean.setObd(jSONObject.getString(JsonConstText.Const_Text_Content));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                EP_ECUInfoBean eP_ECUInfoBean = new EP_ECUInfoBean();
                DataForGolo365.VehicleInfoBean.ArrECUBean arrECUBean = new DataForGolo365.VehicleInfoBean.ArrECUBean();
                eP_ECUInfoBean.setName(jSONObject2.getString(JsonConstText.Const_Text_Title));
                arrECUBean.setName(jSONObject2.getString(JsonConstText.Const_Text_Title));
                eP_ECUInfoBean.setVIN(jSONObject2.getString(JsonConstText.Const_Text_VIN));
                arrECUBean.setVin(jSONObject2.getString(JsonConstText.Const_Text_VIN));
                if (jSONObject2.has(JsonConstText.Const_Text_Data)) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Data);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        try {
                            if (this.isHtt80Wanguo) {
                                eP_ECUInfoBean.getArrCalID().add((jSONObject3.getString(JsonConstText.Const_Text_Title)).replaceAll("\"", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replaceAll("'", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                            } else {
                                eP_ECUInfoBean.getArrCalID().add(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            arrECUBean.setArrCalID(arrayList4);
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Tabdata)) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Tabdata);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                        eP_ECUInfoBean.getArrCVN().add(jSONObject4.getString(JsonConstText.Const_Text_Title));
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(jSONObject4.getString(JsonConstText.Const_Text_Title));
                        arrECUBean.setArrCVN(arrayList5);
                    }
                }
                eP_VehicleInfo.getArrECU().add(eP_ECUInfoBean);
                arrayList3.add(arrECUBean);
            }
            if (DiagnoseProcessInfoUtil.getInstance().isColloct_EP_Data()) {
                DiagnoseProcessInfoUtil.getInstance().setEp_VehicleInfo(eP_VehicleInfo);
                arrayList2 = arrayList;
            } else {
                arrayList2 = arrayList;
            }
            arrayList2.add(eP_VehicleInfo);
            vehicleInfoBean.setArrECU(arrayList3);
            DiagnoseProcessInfoUtil.getInstance().getDataForGolo365().setVehicleInfo(vehicleInfoBean);
        } catch (JSONException e2) {
            e = e2;
        }
    }

    private void getDetectFreeceData(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                NLog.m9456a("yhx", "getDetectFreeceData has data dataid=".concat(String.valueOf(str)));
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                NLog.m9456a("yhx", "getDetectFreeceData.jsonArray.length=" + jSONArray.length());
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        EP_FreezeBean eP_FreezeBean = new EP_FreezeBean();
                        DataForGolo365.FreezeFrameDataBean freezeFrameDataBean = new DataForGolo365.FreezeFrameDataBean();
                        eP_FreezeBean.setType(str);
                        eP_FreezeBean.setSysID("$" + Integer.toHexString(jSONObject2.getInt(JsonConstText.Const_Text_default)));
                        freezeFrameDataBean.setSysID(Integer.toHexString(jSONObject2.getInt(JsonConstText.Const_Text_default)));
                        eP_FreezeBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                        freezeFrameDataBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                        eP_FreezeBean.setContext(jSONObject2.getString(JsonConstText.Const_Text_Context));
                        freezeFrameDataBean.setContext(jSONObject2.getString(JsonConstText.Const_Text_Context));
                        eP_FreezeBean.setStatus(jSONObject2.getString(JsonConstText.Const_Text_Status));
                        freezeFrameDataBean.setStatus(jSONObject2.getString(JsonConstText.Const_Text_Status));
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Menudata);
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            EP_DataStreamBean eP_DataStreamBean = new EP_DataStreamBean();
                            DataForGolo365.FreezeFrameDataBean.ArrFreezeBean arrFreezeBean = new DataForGolo365.FreezeFrameDataBean.ArrFreezeBean();
                            eP_DataStreamBean.setDsName(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            arrFreezeBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            eP_DataStreamBean.setDsUnit(jSONObject3.getString(JsonConstText.Const_Text_Unit));
                            arrFreezeBean.setUnit(jSONObject3.getString(JsonConstText.Const_Text_Unit));
                            eP_DataStreamBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                            arrFreezeBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                            eP_FreezeBean.getArrFreeze().add(eP_DataStreamBean);
                            this.data4Golo365ArrFreezeBeanArray.add(arrFreezeBean);
                        }
                        if (DiagnoseProcessInfoUtil.getInstance().isColloct_EP_Data()) {
                            DiagnoseProcessInfoUtil.getInstance().getArEP_Freeze().add(eP_FreezeBean);
                        }
                        arrayList.add(eP_FreezeBean);
                        freezeFrameDataBean.setArrFreeze(this.data4Golo365ArrFreezeBeanArray);
                        this.dataForGolo365FreezeFrameBeanArray.add(freezeFrameDataBean);
                    }
                    DiagnoseProcessInfoUtil.getInstance().getDataForGolo365().setFreeze_frame_data(this.dataForGolo365FreezeFrameBeanArray);
                    return;
                }
                BasicBean basicBean = new BasicBean();
                basicBean.setType(str);
                arrayList.add(basicBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getHealthDiagProcessDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            BasicHealthDiagProcessData basicHealthDiagProcessData = new BasicHealthDiagProcessData();
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            basicHealthDiagProcessData.setFunType(i);
            if (i == 1 || i == 3) {
                basicHealthDiagProcessData.setTimeHexData(jSONObject.getString(JsonConstText.Const_Text_Time));
            }
            int i2 = 0;
            if (i == 1) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_DSData);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    BasicHealthDiagConditionDataStreamBean basicHealthDiagConditionDataStreamBean = new BasicHealthDiagConditionDataStreamBean();
                    basicHealthDiagConditionDataStreamBean.setDsAtt(jSONObject2.getString(JsonConstText.Const_Text_Label));
                    basicHealthDiagConditionDataStreamBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicHealthDiagConditionDataStreamBean.setUnit(jSONObject2.getString(JsonConstText.Const_Text_Unit));
                    basicHealthDiagConditionDataStreamBean.setMaxValue(jSONObject2.getString(JsonConstText.Const_Text_Maxdata));
                    basicHealthDiagConditionDataStreamBean.setMinValue(jSONObject2.getString(JsonConstText.Const_Text_Mindata));
                    basicHealthDiagConditionDataStreamBean.setGoalMin(jSONObject2.getString(JsonConstText.Const_Text_Minvalue));
                    basicHealthDiagConditionDataStreamBean.setGoalMax(jSONObject2.getString(JsonConstText.Const_Text_Maxvalue));
                    basicHealthDiagProcessData.getArrDataStreamData().add(basicHealthDiagConditionDataStreamBean);
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                while (i2 < jSONArray2.length()) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    BasicHealthDiagTextBean basicHealthDiagTextBean = new BasicHealthDiagTextBean();
                    basicHealthDiagTextBean.setTxtAtt(jSONObject3.getString(JsonConstText.Const_Text_Label));
                    basicHealthDiagTextBean.setTxtValue(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    basicHealthDiagProcessData.getArrTxtData().add(basicHealthDiagTextBean);
                    i2++;
                }
            } else if (i == 2) {
                JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_DSData);
                while (i2 < jSONArray3.length()) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                    BasicHealthDiagConditionDataStreamBean basicHealthDiagConditionDataStreamBean2 = new BasicHealthDiagConditionDataStreamBean();
                    basicHealthDiagConditionDataStreamBean2.setValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                    basicHealthDiagProcessData.getArrDataStreamData().add(basicHealthDiagConditionDataStreamBean2);
                    i2++;
                }
            }
            arrayList.add(basicHealthDiagProcessData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getListFrmDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            BasicListFrmData basicListFrmData = new BasicListFrmData();
            basicListFrmData.setListDataAtt(jSONObject.getInt(JsonConstText.Const_Text_Label));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicListFrmData.BasicListDataBean basicListDataBean = new BasicListFrmData.BasicListDataBean();
                basicListDataBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicListDataBean.setTitleNumber(i);
                basicListDataBean.setScale(jSONObject2.getInt(JsonConstText.Const_Text_Model));
                basicListDataBean.setTitleAtt(jSONObject2.getInt(JsonConstText.Const_Text_Type));
                JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    BasicListFrmData.BasicListItemBean basicListItemBean = new BasicListFrmData.BasicListItemBean();
                    basicListItemBean.setItemNumber(i2);
                    if (jSONObject3.has(JsonConstText.Const_Text_default)) {
                        basicListItemBean.setDefaultItem(jSONObject3.getInt(JsonConstText.Const_Text_default));
                    }
                    basicListItemBean.setItemAtt(jSONObject3.getInt(JsonConstText.Const_Text_Label));
                    basicListItemBean.setTitleItem(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    if (jSONObject3.has(JsonConstText.Const_Text_Tabdata)) {
                        JSONArray jSONArray3 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Tabdata);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            basicListItemBean.getListItemData().add(jSONArray3.getJSONObject(i3).getString(JsonConstText.Const_Text_Title));
                        }
                    }
                    basicListDataBean.getListItemData().add(basicListItemBean);
                }
                basicListFrmData.getListListData().add(basicListDataBean);
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Tabdata);
            for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                JSONObject jSONObject4 = jSONArray4.getJSONObject(i4);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                basicButtonBean.setCommand(String.valueOf(i4));
                basicButtonBean.setBtnAtt(jSONObject4.getInt(JsonConstText.Const_Text_Label));
                basicListFrmData.getListBtnData().add(basicButtonBean);
            }
            arrayList.add(basicListFrmData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getHealthDiagConditionDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            BasicHealthDiagConditionData basicHealthDiagConditionData = new BasicHealthDiagConditionData();
            basicHealthDiagConditionData.setDataSN(jSONObject.getString(JsonConstText.Const_Text_Count));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicHealthDiagConditionDataStreamBean basicHealthDiagConditionDataStreamBean = new BasicHealthDiagConditionDataStreamBean();
                basicHealthDiagConditionDataStreamBean.setPID(jSONObject2.getString(JsonConstText.Const_Text_Id));
                basicHealthDiagConditionDataStreamBean.setValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                basicHealthDiagConditionDataStreamBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicHealthDiagConditionDataStreamBean.setUnit(jSONObject2.getString(JsonConstText.Const_Text_Unit));
                basicHealthDiagConditionData.getArrDs().add(basicHealthDiagConditionDataStreamBean);
            }
            arrayList.add(basicHealthDiagConditionData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getRealTimeDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Label)) {
                BasicRealTimeDataBean basicRealTimeDataBean = new BasicRealTimeDataBean();
                basicRealTimeDataBean.setAsk(true);
                arrayList.add(basicRealTimeDataBean);
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicRealTimeDataBean basicRealTimeDataBean2 = new BasicRealTimeDataBean();
                basicRealTimeDataBean2.setPid(jSONObject2.getInt(JsonConstText.Const_Text_Id));
                if (jSONObject2.has(JsonConstText.Const_Text_Value)) {
                    basicRealTimeDataBean2.setData(jSONObject2.getString(JsonConstText.Const_Text_Value));
                }
                arrayList.add(basicRealTimeDataBean2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getEnvironmentalProtectionDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            String string = jSONObject.has(JsonConstText.Const_Text_Dataid) ? jSONObject.getString(JsonConstText.Const_Text_Dataid) : "";
            int i = 0;
            NLog.m9456a("yhx", "dataId=".concat(String.valueOf(string)));
            if (string.equals("1")) {
                getDetectVehInfoData(jSONObject, string, arrayList);
            } else if (string.equals("255")) {
                EP_CommonData eP_CommonData = new EP_CommonData();
                eP_CommonData.setType(string);
                eP_CommonData.setHexData(jSONObject.getString(JsonConstText.Const_Text_Value));
                arrayList.add(eP_CommonData);
            } else if (string.equals(DiagnoseConstants.FEEDBACK_INPUT_NUMBER)) {
                EP_DiagnoseResult eP_DiagnoseResult = new EP_DiagnoseResult();
                eP_DiagnoseResult.setType(string);
                eP_DiagnoseResult.setResult(jSONObject.getString(JsonConstText.Const_Text_Value));
                arrayList.add(eP_DiagnoseResult);
            } else if (string.equals("16")) {
                EP_IUPRData eP_IUPRData = new EP_IUPRData();
                eP_IUPRData.setType(string);
                eP_IUPRData.setObd_Count(jSONObject.getInt(JsonConstText.Const_Text_Count));
                eP_IUPRData.setFireCount(jSONObject.getInt(JsonConstText.Const_Text_Check));
                if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        EP_IUPRData.EP_IUPR ep_iupr = new EP_IUPRData.EP_IUPR();
                        ep_iupr.setAbbreviation(jSONObject2.getString(JsonConstText.Const_Text_Content));
                        ep_iupr.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                        ep_iupr.setCount(jSONObject2.getInt(JsonConstText.Const_Text_Count));
                        ep_iupr.setSuccessCount(jSONObject2.getInt(JsonConstText.Const_Text_Check));
                        ep_iupr.setIuprRate(jSONObject2.getString(JsonConstText.Const_Text_Status));
                        eP_IUPRData.getListIUPR().add(ep_iupr);
                        i++;
                    }
                }
                arrayList.add(eP_IUPRData);
            } else {
                if (!string.equals("2") && !string.equals("3") && !string.equals("4") && !string.equals("17")) {
                    if (string.equals(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL)) {
                        getDetectFreeceData(jSONObject, string, arrayList);
                        return;
                    }
                    String string2 = jSONObject.getString(JsonConstText.Const_Text_Time);
                    if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                        DiagnoseProcessInfoUtil.getInstance().getArEP_DataStream().clear();
                        JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                        while (i < jSONArray2.length()) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                            EP_DataStreamBean eP_DataStreamBean = new EP_DataStreamBean();
                            eP_DataStreamBean.setType(string);
                            eP_DataStreamBean.setTime(string2);
                            eP_DataStreamBean.setPID(jSONObject3.getString(JsonConstText.Const_Text_Id));
                            eP_DataStreamBean.setDsName(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            eP_DataStreamBean.setAbbreviation(jSONObject3.getString(JsonConstText.Const_Text_Content));
                            eP_DataStreamBean.setDsUnit(jSONObject3.getString(JsonConstText.Const_Text_Unit));
                            eP_DataStreamBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                            if (DiagnoseProcessInfoUtil.getInstance().isColloct_EP_Data()) {
                                DiagnoseProcessInfoUtil.getInstance().getArEP_DataStream().add(eP_DataStreamBean);
                            }
                            arrayList.add(eP_DataStreamBean);
                            i++;
                        }
                        return;
                    }
                    return;
                }
                if (string.equals("3")) {
                    DiagnoseProcessInfoUtil.getInstance().getArEP_DTC().clear();
                }
                if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                    NLog.m9456a("yhx", "has data dataid=".concat(String.valueOf(string)));
                    JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                    NLog.m9456a("yhx", "jsonArray.length=" + jSONArray3.length());
                    if (jSONArray3 != null && jSONArray3.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            if (!string.equals("2") && !string.equals("4") && !string.equals("17")) {
                                if (string.equals("3")) {
                                    BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                                    basicFaultCodeBean.setType(string);
                                    DataForGolo365.FaultCodeInfoBean faultCodeInfoBean = new DataForGolo365.FaultCodeInfoBean();
                                    basicFaultCodeBean.setSysIDForEP("$" + Integer.toHexString(jSONObject4.getInt(JsonConstText.Const_Text_default)));
                                    faultCodeInfoBean.setSysIDForEP("$" + Integer.toHexString(jSONObject4.getInt(JsonConstText.Const_Text_default)));
                                    basicFaultCodeBean.setContext(jSONObject4.getString(JsonConstText.Const_Text_Content));
                                    faultCodeInfoBean.setContext(jSONObject4.getString(JsonConstText.Const_Text_Content));
                                    basicFaultCodeBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                                    faultCodeInfoBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                                    basicFaultCodeBean.setStatus(jSONObject4.getString(JsonConstText.Const_Text_Value));
                                    faultCodeInfoBean.setStatus(jSONObject4.getString(JsonConstText.Const_Text_Value));
                                    NLog.m9456a("yhx", "bean=".concat(String.valueOf(basicFaultCodeBean)));
                                    if (DiagnoseProcessInfoUtil.getInstance().isColloct_EP_Data()) {
                                        DiagnoseProcessInfoUtil.getInstance().getArEP_DTC().add(basicFaultCodeBean);
                                    }
                                    arrayList.add(basicFaultCodeBean);
                                    this.dfg365FaultCodeInfoBean.add(faultCodeInfoBean);
                                }
                            }
                            AbbreviationBean abbreviationBean = new AbbreviationBean();
                            DataForGolo365.ReadyStateInfoBean readyStateInfoBean = new DataForGolo365.ReadyStateInfoBean();
                            DataForGolo365.IuprDataBean iuprDataBean = new DataForGolo365.IuprDataBean();
                            abbreviationBean.setType(string);
                            abbreviationBean.setAbbreviation(jSONObject4.getString(JsonConstText.Const_Text_Content));
                            if (string.equals("2")) {
                                readyStateInfoBean.setAbbreviation(jSONObject4.getString(JsonConstText.Const_Text_Content));
                                readyStateInfoBean.setName(jSONObject4.getString(JsonConstText.Const_Text_Title));
                                readyStateInfoBean.setValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                                this.drdfg365ReadyStateBean.add(readyStateInfoBean);
                            } else if (string.equals("4")) {
                                iuprDataBean.setAbbreviation(jSONObject4.getString(JsonConstText.Const_Text_Content));
                                iuprDataBean.setName(jSONObject4.getString(JsonConstText.Const_Text_Title));
                                iuprDataBean.setValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                                this.dfg365IuprDataBean.add(iuprDataBean);
                            }
                            abbreviationBean.setName(jSONObject4.getString(JsonConstText.Const_Text_Title));
                            abbreviationBean.setValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                            if (jSONObject4.has(JsonConstText.Const_Text_Status)) {
                                abbreviationBean.setStatus(jSONObject4.getString(JsonConstText.Const_Text_Status));
                            }
                            if (DiagnoseProcessInfoUtil.getInstance().isColloct_EP_Data()) {
                                if (string.equals("2")) {
                                    DiagnoseProcessInfoUtil.getInstance().getArEP_ReadyData().add(abbreviationBean);
                                } else if (string.equals("4")) {
                                    DiagnoseProcessInfoUtil.getInstance().getArEP_IUPR().add(abbreviationBean);
                                }
                            }
                            arrayList.add(abbreviationBean);
                        }
                        DiagnoseProcessInfoUtil.getInstance().getDataForGolo365().setReadyStateInfo(this.drdfg365ReadyStateBean);
                        DiagnoseProcessInfoUtil.getInstance().getDataForGolo365().setFaultCodeInfo(this.dfg365FaultCodeInfoBean);
                        DiagnoseProcessInfoUtil.getInstance().getDataForGolo365().setIupr_data(this.dfg365IuprDataBean);
                        return;
                    }
                    BasicBean basicBean = new BasicBean();
                    basicBean.setType(string);
                    arrayList.add(basicBean);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getDiagInfoFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            if (str.equalsIgnoreCase("128")) {
                getCTHeadDiagData(jSONObject, arrayList);
                return;
            }
            int i = 0;
            if (!str.equals("133") && !str.equals("134")) {
                if (str.equals(DiagnoseConstants.FEEDBACK_SPT_SET_DIAG_FUN_INFO)) {
                    if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                        while (i < jSONArray.length()) {
                            arrayList.add(new BasicDataStreamBean(jSONArray.getJSONObject(i)));
                            i++;
                        }
                        return;
                    }
                    return;
                } else if (str.equalsIgnoreCase("32")) {
                    parseEmissionDetctData(jSONObject, arrayList);
                    return;
                } else if (str.equalsIgnoreCase(DiagnoseConstants.UI_Type_EXT1_SHOW_INPUTSRING_BY_SCAN_BARCODE)) {
                    parseReadVin(jSONObject, arrayList);
                    return;
                } else if (str.equalsIgnoreCase(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
                    parseReadECU(jSONObject, arrayList);
                    return;
                } else {
                    if (!str.equalsIgnoreCase(DiagnoseConstants.EXT1_GET_DEVICE_ADAPTER_LICENSE) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1)) {
                        if (!str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_CUSTOM_USE_ID)) {
                            if (!str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX)) {
                                if (str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox)) {
                                    parseFTOnLineCodeLibHelp(jSONObject, arrayList);
                                    return;
                                } else if (str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE)) {
                                    parseFTOnLineArith(jSONObject, arrayList);
                                    return;
                                } else {
                                    if (!str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_FAULTCODES) && !str.equalsIgnoreCase("96")) {
                                        if (!str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG)) {
                                            if (!str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_CURRENT_MENU_PATH) && !str.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM)) {
                                                if (str.equals(DiagnoseConstants.FEEDBACK_SPT_MENU2HD_ID)) {
                                                    if (DiagnoseConstants.getDiagIdentity() != 1) {
                                                        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, ByteHexHelper.intToHexByte(Integer.valueOf(DiagnoseConstants.CurrentDEVICE_DISTRICT).intValue())});
                                                        return;
                                                    }
                                                    return;
                                                } else if (str.equals(DiagnoseConstants.FEEDBACK_HIS_RECORD)) {
                                                    BasicFCADataBean basicFCADataBean = new BasicFCADataBean();
                                                    int i2 = jSONObject.getInt(JsonConstText.Const_Text_Label);
                                                    basicFCADataBean.setFunType(i2);
                                                    if (i2 != 3 && i2 != 6 && i2 != 7) {
                                                        if (i2 == 4) {
                                                            basicFCADataBean.setVin(jSONObject.getString(JsonConstText.Const_Text_VIN));
                                                        } else if (i2 == 2) {
                                                            basicFCADataBean.setHexUUID(jSONObject.getString(JsonConstText.Const_Text_Id));
                                                            basicFCADataBean.setSgwSn(jSONObject.getString(JsonConstText.Const_Text_SN));
                                                            basicFCADataBean.setPolicyType(jSONObject.getString(JsonConstText.Const_Text_PLType));
                                                            basicFCADataBean.setVin(jSONObject.getString(JsonConstText.Const_Text_VIN));
                                                        } else if (i2 == 5) {
                                                            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                                            while (i < jSONArray2.length()) {
                                                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                                                                BasicFCADataBean.FCACMDData fCACMDData = new BasicFCADataBean.FCACMDData();
                                                                fCACMDData.setSn(jSONObject2.getInt(JsonConstText.Const_Text_SN));
                                                                fCACMDData.setCmd(jSONObject2.getString(JsonConstText.Const_Text_Id));
                                                                basicFCADataBean.getArrCmdData().add(fCACMDData);
                                                                i++;
                                                            }
                                                        }
                                                        arrayList.add(basicFCADataBean);
                                                        return;
                                                    }
                                                    basicFCADataBean.setHexCertificate(jSONObject.getString(JsonConstText.Const_Text_Id));
                                                    arrayList.add(basicFCADataBean);
                                                    return;
                                                } else if (str.equals("255") && jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                                                    JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                                                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                                                        BasicJLDatastreamBean basicJLDatastreamBean = new BasicJLDatastreamBean();
                                                        basicJLDatastreamBean.setDsID(jSONObject3.getInt(JsonConstText.Const_Text_CurrNum));
                                                        basicJLDatastreamBean.setDataStreamValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                                                        basicJLDatastreamBean.setiHasRefresh(jSONObject3.getInt(JsonConstText.Const_Text_Cmd));
                                                        basicJLDatastreamBean.setTotalNumber(jSONObject3.getInt(JsonConstText.Const_Text_Status));
                                                        basicJLDatastreamBean.setHasRefresh(jSONObject3.getInt(JsonConstText.Const_Text_Cmd) == 1);
                                                        basicJLDatastreamBean.setVolWarning(jSONObject3.getInt(JsonConstText.Const_Text_Check) == 1);
                                                        arrayList.add(basicJLDatastreamBean);
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            BasicQueryArgToWebSiteBean basicQueryArgToWebSiteBean = new BasicQueryArgToWebSiteBean();
                                            JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                                            for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                                                JSONObject jSONObject4 = jSONArray4.getJSONObject(i4);
                                                if (jSONObject4.has(JsonConstText.Const_Text_Data)) {
                                                    basicQueryArgToWebSiteBean.getFileList().add(jSONObject4.getString(JsonConstText.Const_Text_Data));
                                                }
                                            }
                                            if (jSONObject.has(JsonConstText.Const_Text_DBKeyTag)) {
                                                basicQueryArgToWebSiteBean.setKeyTag(jSONObject.getInt(JsonConstText.Const_Text_DBKeyTag));
                                            }
                                            if (jSONObject.has(JsonConstText.Const_Text_Funtype)) {
                                                basicQueryArgToWebSiteBean.setfunType(jSONObject.getString(JsonConstText.Const_Text_Funtype));
                                            }
                                            if (jSONObject.has(JsonConstText.Const_Text_DBKey)) {
                                                basicQueryArgToWebSiteBean.setKey(jSONObject.getString(JsonConstText.Const_Text_DBKey));
                                            }
                                            JSONArray jSONArray5 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                            while (i < jSONArray5.length()) {
                                                JSONObject jSONObject5 = jSONArray5.getJSONObject(i);
                                                BasicQueryWebSiteBean basicQueryWebSiteBean = new BasicQueryWebSiteBean();
                                                if (jSONObject5.has(JsonConstText.Const_Text_Type)) {
                                                    basicQueryWebSiteBean.setTitle(jSONObject5.getString(JsonConstText.Const_Text_Type));
                                                }
                                                if (jSONObject5.has(JsonConstText.Const_Text_Arguments)) {
                                                    basicQueryWebSiteBean.setValue(jSONObject5.getString(JsonConstText.Const_Text_Arguments));
                                                }
                                                basicQueryArgToWebSiteBean.getQueryWebSiteBean().add(basicQueryWebSiteBean);
                                                i++;
                                            }
                                            arrayList.add(basicQueryArgToWebSiteBean);
                                            return;
                                        }
                                        String string = jSONObject.has(JsonConstText.Const_Text_DBKey) ? jSONObject.getString(JsonConstText.Const_Text_DBKey) : "";
                                        BasicQueryWebSiteBean basicQueryWebSiteBean2 = new BasicQueryWebSiteBean();
                                        basicQueryWebSiteBean2.setTitle(string);
                                        if (jSONObject.has(JsonConstText.Const_Text_Label)) {
                                            basicQueryWebSiteBean2.setValue(jSONObject.getString(JsonConstText.Const_Text_Label));
                                        } else {
                                            basicQueryWebSiteBean2.setValue("");
                                        }
                                        arrayList.add(basicQueryWebSiteBean2);
                                        return;
                                    }
                                    if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                                        JSONArray jSONArray6 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                                        while (i < jSONArray6.length()) {
                                            JSONObject jSONObject6 = jSONArray6.getJSONObject(i);
                                            BasicSoftIDBean basicSoftIDBean = new BasicSoftIDBean();
                                            basicSoftIDBean.setSoftID(jSONObject6.getString(JsonConstText.Const_Text_Softid));
                                            if (jSONObject6.has(JsonConstText.Const_Text_Langcode)) {
                                                basicSoftIDBean.setSoftLan(jSONObject6.getString(JsonConstText.Const_Text_Langcode));
                                            }
                                            arrayList.add(basicSoftIDBean);
                                            i++;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            parseFTOnLineCodeLib(jSONObject, arrayList);
                            return;
                        }
                        parseFTHTML(str, jSONObject, arrayList);
                        return;
                    }
                    parseFTSysCFG(jSONObject, arrayList);
                    return;
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                JSONArray jSONArray7 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                while (i < jSONArray7.length()) {
                    JSONObject jSONObject7 = jSONArray7.getJSONObject(i);
                    BasicAITHDIMData basicAITHDIMData = new BasicAITHDIMData();
                    basicAITHDIMData.setTitle(jSONObject7.getString(JsonConstText.Const_Text_Title));
                    basicAITHDIMData.setCurrNo(jSONObject7.getString(JsonConstText.Const_Text_CurrNum));
                    basicAITHDIMData.setValue(jSONObject7.getString(JsonConstText.Const_Text_Value));
                    arrayList.add(basicAITHDIMData);
                    i++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIVerifyMaintenance(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_VIN);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_ODO);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onVerifyMaintenance(str, string, string2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getSystemDTCDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        boolean z;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            String str2 = "";
            String str3 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has(JsonConstText.Const_Text_Context)) {
                    str3 = jSONObject2.getString(JsonConstText.Const_Text_Context);
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                    str2 = jSONObject2.getString(JsonConstText.Const_Text_Id);
                }
                BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                basicSystemStatusBean.setSystemName(str3);
                basicSystemStatusBean.setCurrentNum(i);
                if (jSONObject2.has(JsonConstText.Const_Text_Type)) {
                    z = jSONObject2.getInt(JsonConstText.Const_Text_Type) == 5;
                } else {
                    z = false;
                }
                if (i == 0) {
                    if (jSONObject2.has(JsonConstText.Const_Text_Help)) {
                        basicSystemStatusBean.setHelpEnable(jSONObject2.getBoolean(JsonConstText.Const_Text_Help));
                    }
                    if (jSONObject2.has(JsonConstText.Const_Text_ClearDtcCmd)) {
                        basicSystemStatusBean.setClearEnable(jSONObject2.getBoolean(JsonConstText.Const_Text_ClearDtcCmd));
                    }
                }
                basicSystemStatusBean.setSystemID(str2);
                basicSystemStatusBean.setFaultCodeOnline(z);
                if (jSONObject2.has(JsonConstText.Const_Text_Data)) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Data);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        if (!z) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                            if (jSONObject3.has(JsonConstText.Const_Text_Id)) {
                                basicFaultCodeBean.setId(jSONObject3.getString(JsonConstText.Const_Text_Id));
                            }
                            basicFaultCodeBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                            basicFaultCodeBean.setContext(jSONObject3.getString(JsonConstText.Const_Text_Context));
                            basicFaultCodeBean.setStatus(jSONObject3.getString(JsonConstText.Const_Text_Status));
                            if (jSONObject3.has(JsonConstText.Const_Text_Help)) {
                                basicFaultCodeBean.setHelp(jSONObject3.getString(JsonConstText.Const_Text_Help));
                            }
                            basicFaultCodeBean.setSys(str3);
                            basicSystemStatusBean.getSystemFaultCodeBean().add(basicFaultCodeBean);
                        } else {
                            BasicOnlineCodeLib basicOnlineCodeLib = new BasicOnlineCodeLib();
                            JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                            basicOnlineCodeLib.setSystemID(str2);
                            if (jSONObject4.has(JsonConstText.Const_Text_Id)) {
                                basicOnlineCodeLib.setCodeID(jSONObject4.getString(JsonConstText.Const_Text_Id));
                            }
                            if (jSONObject4.has(JsonConstText.Const_Text_Label)) {
                                basicOnlineCodeLib.setSmallCode(jSONObject4.getString(JsonConstText.Const_Text_Label));
                            }
                            if (jSONObject4.has(JsonConstText.Const_Text_Status)) {
                                basicOnlineCodeLib.setCodeStatusID(jSONObject4.getString(JsonConstText.Const_Text_Status));
                            }
                            if (jSONObject4.has(JsonConstText.Const_Text_Help)) {
                                basicOnlineCodeLib.setHelpID(jSONObject4.getString(JsonConstText.Const_Text_Help));
                            }
                            if (jSONObject4.has(JsonConstText.Const_Text_Normal)) {
                                basicOnlineCodeLib.setHelpType(jSONObject4.getInt(JsonConstText.Const_Text_Normal));
                            }
                            basicSystemStatusBean.getOnlineFaultCodeList().add(basicOnlineCodeLib);
                        }
                    }
                    if (!z) {
                        DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanBySystemName(basicSystemStatusBean.getSystemFaultCodeBean(), str3);
                    }
                }
                arrayList.add(basicSystemStatusBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void checkAndSetDSSelected(BasicSelectMenuBean basicSelectMenuBean) {
        ArrayList<Integer> arrDefaultSelected = DiagnoseProcessInfoUtil.getInstance().getArrDefaultSelected();
        if (arrDefaultSelected.size() == 0) {
            return;
        }
        if (arrDefaultSelected.size() == 1 && arrDefaultSelected.get(0).intValue() == -1) {
            basicSelectMenuBean.setCheck(true);
        } else if (arrDefaultSelected.contains(Integer.valueOf(basicSelectMenuBean.getDiagSn()))) {
            basicSelectMenuBean.setCheck(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x011a, code lost:
        com.cnlaunch.diagnosemodule.utils.DiagnoseConstants.DATASTREAM_HAVE_ID = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getDefDataStreamDatraFromJson(org.json.JSONObject r10, java.lang.String r11, java.util.ArrayList<com.cnlaunch.diagnosemodule.bean.BasicBean> r12) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.getDefDataStreamDatraFromJson(org.json.JSONObject, java.lang.String, java.util.ArrayList):void");
    }

    private void dealWithInputKeyDataFromJson(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Title);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_Content);
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicInputDataBean basicInputDataBean = new BasicInputDataBean();
                basicInputDataBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicInputDataBean.setStyle(jSONObject2.getInt(JsonConstText.Const_Text_Type));
                basicInputDataBean.setCtrLength(jSONObject2.getInt(JsonConstText.Const_Text_CtrolLength));
                basicInputDataBean.setSplitLength(jSONObject2.getInt(JsonConstText.Const_Text_Split));
                basicInputDataBean.setDislodge(jSONObject2.getString(JsonConstText.Const_Text_Check));
                JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    basicInputDataBean.getArrStrChoice().add(jSONArray2.getJSONObject(i2).getString(JsonConstText.Const_Text_Title));
                }
                arrayList.add(basicInputDataBean);
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseInputKeyWindows(str, string, string2, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void dealWithVoltagePinDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            BasicVoltagePinBean basicVoltagePinBean = new BasicVoltagePinBean();
            basicVoltagePinBean.setDataType(i);
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                VoltageBpsBean voltageBpsBean = new VoltageBpsBean();
                if (i == 1) {
                    voltageBpsBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                } else {
                    voltageBpsBean.setPinIndex(jSONObject2.getInt(JsonConstText.Const_Text_Title));
                }
                voltageBpsBean.setValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                basicVoltagePinBean.getVoltageBpsBeanArrayList().add(voltageBpsBean);
            }
            arrayList.add(basicVoltagePinBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealWithECU_FlashShowDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            BasicECUFlashShowBean basicECUFlashShowBean = new BasicECUFlashShowBean();
            basicECUFlashShowBean.setDataType(i);
            if (i == 1) {
                basicECUFlashShowBean.setEnableChilck(jSONObject.getInt(JsonConstText.Const_Text_Check) == 1);
                basicECUFlashShowBean.setContext(jSONObject.getString(JsonConstText.Const_Text_default));
                basicECUFlashShowBean.setPopContext(jSONObject.getString(JsonConstText.Const_Text_Data));
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    BasicECUFlashShowBean.ECUFlashInfo eCUFlashInfo = new BasicECUFlashShowBean.ECUFlashInfo();
                    eCUFlashInfo.setbChilck(jSONObject2.getInt(JsonConstText.Const_Text_Check) == 1);
                    eCUFlashInfo.setEcuName(jSONObject2.getString(JsonConstText.Const_Text_Context));
                    eCUFlashInfo.setVersion(jSONObject2.getString(JsonConstText.Const_Text_Ver));
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Data);
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        BasicECUFlashShowBean.ECUFlshFileInfo eCUFlshFileInfo = new BasicECUFlashShowBean.ECUFlshFileInfo();
                        eCUFlshFileInfo.fileName = jSONObject3.getString(JsonConstText.Const_Text_Title);
                        eCUFlshFileInfo.fileVersion = jSONObject3.getString(JsonConstText.Const_Text_Ver);
                        eCUFlshFileInfo.fileDate = jSONObject3.getString(JsonConstText.Const_Text_Time);
                        eCUFlshFileInfo.fileLength = jSONObject3.getString(JsonConstText.Const_Text_CurrNum);
                        eCUFlshFileInfo.fileContent = jSONObject3.getString(JsonConstText.Const_Text_Context);
                        eCUFlshFileInfo.downloadType = jSONObject3.getInt(JsonConstText.Const_Text_Type);
                        eCUFlshFileInfo.downloadData = jSONObject3.getString(JsonConstText.Const_Text_default);
                        eCUFlashInfo.getArrEcuFile().add(eCUFlshFileInfo);
                    }
                    basicECUFlashShowBean.getArrEcuInfo().add(eCUFlashInfo);
                }
            } else if (2 == i) {
                basicECUFlashShowBean.setFlashSN(jSONObject.getInt(JsonConstText.Const_Text_SN));
                basicECUFlashShowBean.setProcessValue(jSONObject.getInt(JsonConstText.Const_Text_Status));
            }
            arrayList.add(basicECUFlashShowBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealWithOEMReqSWDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            BasicOemReqSWBean basicOemReqSWBean = new BasicOemReqSWBean();
            basicOemReqSWBean.setDataType(i);
            if (i == 1) {
                basicOemReqSWBean.setReqMode(jSONObject.getInt(JsonConstText.Const_Text_CMDType));
                basicOemReqSWBean.setUrl(jSONObject.getString(JsonConstText.Const_Text_default));
                basicOemReqSWBean.setRefreshUrl(jSONObject.getString(JsonConstText.Const_Text_Data));
                basicOemReqSWBean.setTokeValidTime(jSONObject.getInt(JsonConstText.Const_Text_Time));
                basicOemReqSWBean.setServiceProviderType(jSONObject.getInt(JsonConstText.Const_Text_BTType));
            } else if (2 == i) {
                basicOemReqSWBean.setReqMode(jSONObject.getInt(JsonConstText.Const_Text_CMDType));
                basicOemReqSWBean.setTokePos(jSONObject.getInt(JsonConstText.Const_Text_Model));
                basicOemReqSWBean.setUrl(jSONObject.getString(JsonConstText.Const_Text_default));
                basicOemReqSWBean.setJsonData(jSONObject.getString(JsonConstText.Const_Text_Data));
            } else if (3 == i) {
                basicOemReqSWBean.setJsonData(jSONObject.getString(JsonConstText.Const_Text_Data));
            }
            arrayList.add(basicOemReqSWBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealWithOEMRequestDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            BasicOEMRequestData basicOEMRequestData = new BasicOEMRequestData();
            basicOEMRequestData.setDataType(i);
            basicOEMRequestData.setReqMode(jSONObject.getInt(JsonConstText.Const_Text_CMDType));
            basicOEMRequestData.setUrl(jSONObject.getString(JsonConstText.Const_Text_default));
            basicOEMRequestData.setJsonData(jSONObject.getString(JsonConstText.Const_Text_Data));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                basicOEMRequestData.getMapType2Key().put(jSONObject2.getString(JsonConstText.Const_Text_DBKey), jSONObject2.getString(JsonConstText.Const_Text_Value));
            }
            arrayList.add(basicOEMRequestData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void dealWithSaveQueryWithConditionDataFromJson(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            BasicSaveAndQueryWithConditionBean basicSaveAndQueryWithConditionBean = new BasicSaveAndQueryWithConditionBean();
            basicSaveAndQueryWithConditionBean.setSubType(i);
            basicSaveAndQueryWithConditionBean.setbShowUI(jSONObject.getInt(JsonConstText.Const_Text_Check) == 1);
            basicSaveAndQueryWithConditionBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicSaveAndQueryWithConditionBean.setFunctionType(jSONObject.getInt(JsonConstText.Const_Text_Funtype));
            if (i == 1) {
                basicSaveAndQueryWithConditionBean.setDataType(jSONObject.getInt(JsonConstText.Const_Text_CMDType));
                basicSaveAndQueryWithConditionBean.setDataInfo(jSONObject.getString(JsonConstText.Const_Text_Cmd));
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    BasicSaveAndQueryWithConditionBean.BasicConditionBean basicConditionBean = new BasicSaveAndQueryWithConditionBean.BasicConditionBean();
                    basicConditionBean.setConditionAtt(jSONObject2.getInt(JsonConstText.Const_Text_Label));
                    basicConditionBean.setSn(jSONObject2.getInt(JsonConstText.Const_Text_SN));
                    basicConditionBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicConditionBean.setStrDefault(jSONObject2.getString(JsonConstText.Const_Text_default));
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Menudata);
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        basicConditionBean.getArrItem().add(jSONArray2.getJSONObject(i3).getString(JsonConstText.Const_Text_Title));
                    }
                    basicSaveAndQueryWithConditionBean.getArrCondition().add(basicConditionBean);
                }
            } else if (2 == i) {
                basicSaveAndQueryWithConditionBean.setHelp(jSONObject.getString(JsonConstText.Const_Text_Help));
                basicSaveAndQueryWithConditionBean.setSoftID(jSONObject.getString(JsonConstText.Const_Text_Softid));
                JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                    BasicSaveAndQueryWithConditionBean.BasicConditionBean basicConditionBean2 = new BasicSaveAndQueryWithConditionBean.BasicConditionBean();
                    basicConditionBean2.setConditionAtt(jSONObject3.getInt(JsonConstText.Const_Text_Label));
                    basicConditionBean2.setSn(jSONObject3.getInt(JsonConstText.Const_Text_SN));
                    basicConditionBean2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    basicConditionBean2.setStrDefault(jSONObject3.getString(JsonConstText.Const_Text_default));
                    basicSaveAndQueryWithConditionBean.getArrCondition().add(basicConditionBean2);
                }
                JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                    JSONObject jSONObject4 = jSONArray4.getJSONObject(i5);
                    BasicSaveAndQueryWithConditionBean.BasicConditionBean basicConditionBean3 = new BasicSaveAndQueryWithConditionBean.BasicConditionBean();
                    basicConditionBean3.setConditionAtt(jSONObject4.getInt(JsonConstText.Const_Text_Label));
                    basicConditionBean3.setSn(jSONObject4.getInt(JsonConstText.Const_Text_SN));
                    basicConditionBean3.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                    basicConditionBean3.setStrDefault(jSONObject4.getString(JsonConstText.Const_Text_default));
                    basicSaveAndQueryWithConditionBean.getArrOnlineCondition().add(basicConditionBean3);
                }
            }
            arrayList.add(basicSaveAndQueryWithConditionBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void dealVWCodeWindowDataFromJson(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Title);
            BasicVWCodeWindowBean basicVWCodeWindowBean = new BasicVWCodeWindowBean();
            basicVWCodeWindowBean.setTitle(string);
            basicVWCodeWindowBean.setContent(jSONObject.getString(JsonConstText.Const_Text_Content));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i = 0; i < jSONArray.length(); i++) {
                basicVWCodeWindowBean.getArrCodeData().add(Integer.valueOf(jSONArray.getJSONObject(i).getInt(JsonConstText.Const_Text_Value)));
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                ArrayList<BasicVWCodeWindowBean.BasicBitData> arrayList = new ArrayList<>();
                JSONArray jSONArray3 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    BasicVWCodeWindowBean.BasicBitData basicBitData = new BasicVWCodeWindowBean.BasicBitData();
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                    basicBitData.setBitAtt(jSONObject3.getInt(JsonConstText.Const_Text_BTType));
                    basicBitData.setBitSn(jSONObject3.getInt(JsonConstText.Const_Text_SN));
                    JSONArray jSONArray4 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Menudata);
                    for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                        JSONObject jSONObject4 = jSONArray4.getJSONObject(i4);
                        basicBitData.getArrFunctionData().add(Integer.valueOf(jSONObject4.getInt(JsonConstText.Const_Text_Value)));
                        basicBitData.getArrFunctionTitle().add(jSONObject4.getString(JsonConstText.Const_Text_Title));
                    }
                    arrayList.add(basicBitData);
                }
                basicVWCodeWindowBean.getArrBitData().add(arrayList);
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseVWCodeWindows(str, string, basicVWCodeWindowBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0194 A[Catch: JSONException -> 0x019a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x019a, blocks: (B:2:0x0000, B:4:0x000a, B:5:0x0010, B:7:0x0018, B:9:0x001c, B:11:0x0024, B:13:0x0028, B:15:0x0030, B:17:0x0038, B:19:0x0040, B:21:0x0048, B:23:0x0055, B:26:0x005f, B:28:0x0067, B:91:0x0190, B:93:0x0194, B:29:0x006c, B:31:0x0074, B:32:0x0079, B:34:0x0081, B:35:0x0086, B:37:0x008e, B:40:0x0098, B:42:0x00a0, B:43:0x00a5, B:45:0x00ad, B:46:0x00b2, B:48:0x00ba, B:49:0x00bf, B:51:0x00c7, B:54:0x00d1, B:56:0x00d9, B:57:0x00de, B:59:0x00e6, B:60:0x00eb, B:62:0x00f3, B:63:0x00f8, B:65:0x0100, B:66:0x0105, B:68:0x010d, B:70:0x0116, B:71:0x0131, B:73:0x0139, B:74:0x014b, B:76:0x0153, B:77:0x0157, B:78:0x015b, B:79:0x0162, B:80:0x0166, B:82:0x016e, B:84:0x0176, B:88:0x0183, B:89:0x0188, B:90:0x018d), top: B:98:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIShowTransDiagInfo(java.lang.String r5, org.json.JSONObject r6) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIShowTransDiagInfo(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUICustom(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Title);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_Content);
            int i = jSONObject.getInt(JsonConstText.Const_Text_CtrolLength);
            int i2 = jSONObject.getInt(JsonConstText.Const_Text_ChangeChar);
            int i3 = jSONObject.getInt(JsonConstText.Const_Text_AddSplitLength);
            String string3 = jSONObject.getString(JsonConstText.Const_Text_Split);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onWithCustomInputDialog(str, string, string2, i, i2, i3, string3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIMulitInputWindow(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Title);
            ArrayList<BasicInputBean> arrayList = new ArrayList<>();
            ArrayList<BasicButtonBean> arrayList2 = new ArrayList<>();
            if (str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN) || str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    if (jSONObject2.has(JsonConstText.Const_Text_Buttoncontext)) {
                        basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Buttoncontext));
                    }
                    basicButtonBean.setId(String.valueOf(i));
                    arrayList2.add(basicButtonBean);
                }
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicInputBean basicInputBean = new BasicInputBean();
                if (jSONObject3.has(JsonConstText.Const_Text_Title)) {
                    basicInputBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                }
                if (jSONObject3.has(JsonConstText.Const_Text_default)) {
                    basicInputBean.setPrefix(jSONObject3.getString(JsonConstText.Const_Text_default));
                }
                if (jSONObject3.has(JsonConstText.Const_Text_Check)) {
                    basicInputBean.setCanEdit(jSONObject3.getBoolean(JsonConstText.Const_Text_Check));
                }
                if (jSONObject3.has(JsonConstText.Const_Text_Type)) {
                    String string2 = jSONObject3.getString(JsonConstText.Const_Text_Type);
                    basicInputBean.setInputType(string2);
                    if (string2.equals("1")) {
                        JSONArray jSONArray3 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Data);
                        basicInputBean.getChoiceData().clear();
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                            if (jSONObject4.has(JsonConstText.Const_Text_Title)) {
                                basicInputBean.getChoiceData().add(jSONObject4.getString(JsonConstText.Const_Text_Title));
                            }
                        }
                    }
                } else {
                    basicInputBean.setInputType("0");
                }
                arrayList.add(basicInputBean);
            }
            if (this.mIDiagnoseDataCallback != null) {
                if (!str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN) && !str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
                    this.mIDiagnoseDataCallback.onMulitInputWindow(str, string, arrayList);
                    return;
                }
                this.mIDiagnoseDataCallback.onMulitInputWindowWithBtn(str, string, arrayList, arrayList2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIQueryWebSite(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_DbName);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_TabName);
            ArrayList<BasicQueryWebSiteBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicQueryWebSiteBean basicQueryWebSiteBean = new BasicQueryWebSiteBean();
                if (jSONObject2.has(JsonConstText.Const_Text_Title)) {
                    basicQueryWebSiteBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Value)) {
                    basicQueryWebSiteBean.setValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                }
                arrayList.add(basicQueryWebSiteBean);
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onQueryWebsite(str, string, string2, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIDownloadFileEx(String str, JSONObject jSONObject) {
        try {
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDownloadDiagFileEx(str, jSONObject.getString(JsonConstText.Const_Text_Type), jSONObject.getString(JsonConstText.Const_Text_Data));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIUploadEcuFile(String str, JSONObject jSONObject) {
        try {
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onUploadEcuFile(str, jSONObject.getString(JsonConstText.Const_Text_Localpath), jSONObject.getString(JsonConstText.Const_Text_Carname));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIShowSTD_EX1(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.has(JsonConstText.Const_Text_Type) ? jSONObject.getString(JsonConstText.Const_Text_Type) : "";
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            getDataFromJson_STD_EX1(jSONObject, string, arrayList);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onSTD_EX1Data(string, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUISubLabel(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            boolean z = jSONObject.getBoolean(JsonConstText.Const_Text_Status);
            int i = jSONObject.getInt(JsonConstText.Const_Text_Type);
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    basicButtonBean.setTitle(jSONArray.getJSONObject(i2).getString(JsonConstText.Const_Text_Value));
                    basicButtonBean.setEnable(z);
                    arrayList.add(basicButtonBean);
                }
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseSubLabel(i, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIVersionInfos(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Label));
                    basicButtonBean.setCommand(jSONObject2.getString(JsonConstText.Const_Text_Content));
                    arrayList.add(basicButtonBean);
                }
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseInformationShow(0, "", arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUICustomListFunction(java.lang.String r17, org.json.JSONObject r18) {
        /*
            r16 = this;
            r0 = r18
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r1 = ""
            r5 = -1
            r6 = 0
            java.lang.String r7 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Model     // Catch: java.lang.Exception -> Lc5
            int r7 = r0.getInt(r7)     // Catch: java.lang.Exception -> Lc5
            java.lang.String r8 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Status     // Catch: java.lang.Exception -> Lc3
            int r5 = r0.getInt(r8)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r8 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: java.lang.Exception -> Lc3
            java.lang.String r1 = r0.getString(r8)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r8 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Colums     // Catch: java.lang.Exception -> Lc3
            java.lang.String r8 = r0.getString(r8)     // Catch: java.lang.Exception -> Lc3
            int r8 = java.lang.Integer.parseInt(r8)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r9 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Buttondata     // Catch: java.lang.Exception -> Lc1
            org.json.JSONArray r9 = r0.getJSONArray(r9)     // Catch: java.lang.Exception -> Lc1
            r10 = 0
        L38:
            int r11 = r9.length()     // Catch: java.lang.Exception -> Lc1
            if (r10 >= r11) goto L56
            org.json.JSONObject r11 = r9.getJSONObject(r10)     // Catch: java.lang.Exception -> Lc1
            com.cnlaunch.diagnosemodule.bean.BasicButtonBean r12 = new com.cnlaunch.diagnosemodule.bean.BasicButtonBean     // Catch: java.lang.Exception -> Lc1
            r12.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r13 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: java.lang.Exception -> Lc1
            java.lang.String r11 = r11.getString(r13)     // Catch: java.lang.Exception -> Lc1
            r12.setTitle(r11)     // Catch: java.lang.Exception -> Lc1
            r4.add(r12)     // Catch: java.lang.Exception -> Lc1
            int r10 = r10 + 1
            goto L38
        L56:
            java.lang.String r9 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menutitle     // Catch: java.lang.Exception -> Lc1
            org.json.JSONArray r9 = r0.getJSONArray(r9)     // Catch: java.lang.Exception -> Lc1
            r10 = 0
        L5d:
            int r11 = r9.length()     // Catch: java.lang.Exception -> Lc1
            if (r10 >= r11) goto L84
            org.json.JSONObject r11 = r9.getJSONObject(r10)     // Catch: java.lang.Exception -> Lc1
            com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean r12 = new com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean     // Catch: java.lang.Exception -> Lc1
            r12.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r13 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: java.lang.Exception -> Lc1
            java.lang.String r13 = r11.getString(r13)     // Catch: java.lang.Exception -> Lc1
            r12.setTitle(r13)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r13 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Scale     // Catch: java.lang.Exception -> Lc1
            java.lang.String r11 = r11.getString(r13)     // Catch: java.lang.Exception -> Lc1
            r12.setScale(r11)     // Catch: java.lang.Exception -> Lc1
            r2.add(r12)     // Catch: java.lang.Exception -> Lc1
            int r10 = r10 + 1
            goto L5d
        L84:
            java.lang.String r9 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menudata     // Catch: java.lang.Exception -> Lc1
            org.json.JSONArray r0 = r0.getJSONArray(r9)     // Catch: java.lang.Exception -> Lc1
            r9 = 0
            r10 = 0
        L8c:
            int r11 = r0.length()     // Catch: java.lang.Exception -> Lc1
            if (r9 >= r11) goto Lbb
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lc1
            r11.<init>()     // Catch: java.lang.Exception -> Lc1
            r12 = r10
            r10 = 0
        L99:
            if (r10 >= r8) goto Lb5
            org.json.JSONObject r13 = r0.getJSONObject(r12)     // Catch: java.lang.Exception -> Lc1
            com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean r14 = new com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean     // Catch: java.lang.Exception -> Lc1
            r14.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r15 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Value     // Catch: java.lang.Exception -> Lc1
            java.lang.String r13 = r13.getString(r15)     // Catch: java.lang.Exception -> Lc1
            r14.setTitle(r13)     // Catch: java.lang.Exception -> Lc1
            r11.add(r14)     // Catch: java.lang.Exception -> Lc1
            int r12 = r12 + 1
            int r10 = r10 + 1
            goto L99
        Lb5:
            r3.add(r11)     // Catch: java.lang.Exception -> Lc1
            int r9 = r9 + r8
            r10 = r12
            goto L8c
        Lbb:
            r9 = r16
            r6 = r8
            r8 = r5
            r5 = r1
            goto Ld0
        Lc1:
            r0 = move-exception
            goto Lc8
        Lc3:
            r0 = move-exception
            goto Lc7
        Lc5:
            r0 = move-exception
            r7 = -1
        Lc7:
            r8 = 0
        Lc8:
            r0.printStackTrace()
            r9 = r16
            r6 = r8
            r8 = r5
            r5 = r1
        Ld0:
            com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener r0 = r9.mIDiagnoseDataCallback
            if (r0 == 0) goto Ld9
            r1 = r17
            r0.onDiagnoseCustomListFunction(r1, r2, r3, r4, r5, r6, r7, r8)
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUICustomListFunction(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUIInformationShow(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            String string = jSONObject.getString(JsonConstText.Const_Text_Content);
            boolean z = jSONObject.getBoolean(JsonConstText.Const_Text_Label);
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    basicButtonBean.setTitle(jSONArray.getJSONObject(i).getString(JsonConstText.Const_Text_Value));
                    arrayList.add(basicButtonBean);
                }
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseInformationShow(z ? 1 : 2, string, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIAddresPath(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Value));
                    basicButtonBean.setEnable(jSONObject2.getBoolean(JsonConstText.Const_Text_Status));
                    arrayList.add(basicButtonBean);
                }
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseAddressPath(arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUILeftView(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            boolean z = jSONObject.getBoolean(JsonConstText.Const_Text_Status);
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    basicSystemStatusBean.setSystemName(jSONObject2.getString(JsonConstText.Const_Text_Value));
                    arrayList.add(basicSystemStatusBean);
                    basicSystemStatusBean.setCurrentNum(jSONObject2.getInt(JsonConstText.Const_Text_CurrNum));
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Buttondata);
                    if (jSONArray2 != null) {
                        ArrayList<BasicFaultCodeBean> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            basicFaultCodeBean.setContext(jSONObject3.getString(JsonConstText.Const_Text_Value));
                            basicFaultCodeBean.setStatus(jSONObject3.getString(JsonConstText.Const_Text_Status));
                            basicFaultCodeBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Content));
                            arrayList2.add(basicFaultCodeBean);
                        }
                        basicSystemStatusBean.setSystemFaultCodeBean(arrayList2);
                    }
                }
            }
            int i3 = jSONObject.getInt(JsonConstText.Const_Text_Type);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseLeftSystemListWindows(z, i3, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIChanelSelect(String str, JSONObject jSONObject) {
        try {
            BasicChannelSelectBean basicChannelSelectBean = new BasicChannelSelectBean();
            basicChannelSelectBean.setScanEnable(jSONObject.getBoolean(JsonConstText.Const_Text_Status));
            basicChannelSelectBean.setVin(jSONObject.getString(JsonConstText.Const_Text_Value));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            if (jSONArray != null) {
                ArrayList<DropDownBean> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    DropDownBean dropDownBean = new DropDownBean();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    dropDownBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Label));
                    arrayList.add(dropDownBean);
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(JsonConstText.Const_Text_Buttondata);
                    if (jSONArray2 != null) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            arrayList2.add(jSONArray2.getJSONObject(i2).getString(JsonConstText.Const_Text_Value));
                        }
                        dropDownBean.setLists(arrayList2);
                        dropDownBean.setSelectIndex(jSONObject2.getInt(JsonConstText.Const_Text_Item));
                    }
                }
                basicChannelSelectBean.setStrChoice(arrayList);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            if (jSONArray3 != null) {
                ArrayList<BasicButtonBean> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    basicButtonBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Value));
                    basicButtonBean.setEnable(jSONObject3.getBoolean(JsonConstText.Const_Text_Status));
                    arrayList3.add(basicButtonBean);
                }
                basicChannelSelectBean.setArrButton(arrayList3);
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDiagnoseChannelWindows("", basicChannelSelectBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getDataFromJson_STD_EX1(JSONObject jSONObject, String str, ArrayList<BasicBean> arrayList) {
        if (str.equals(DiagnoseConstants.FEEDBACK_DATASTREAM)) {
            parseDataFromJsonForTMPTest(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW)) {
            parseDataFromJsonForTMPSProgramming(jSONObject, arrayList);
        } else if (str.equals("20")) {
            parseDataFromJsonForTMPSLearning(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.UI_Type_EXT1_SHOW_INPUTSRING_BY_SCAN_BARCODE)) {
            try {
                BasicDialogScanBarcodeBean basicDialogScanBarcodeBean = new BasicDialogScanBarcodeBean();
                basicDialogScanBarcodeBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Content));
                basicDialogScanBarcodeBean.setContext(jSONObject.getString(JsonConstText.Const_Text_Context));
                arrayList.add(basicDialogScanBarcodeBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            jsonEX1SpecialFunction(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.EXT1_CENTRAL_GATEWAY_ARCHITECTURE_NETWORK_LAYOUT)) {
            parseDataFromJsonForCentralGateWayNetWorkLayout(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
            parseDataFromJsonForDualHighSpeedLayout(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.EXT1_GET_DEVICE_ADAPTER_LICENSE)) {
            parseDataFromJsonForEX1_GET_DEVICE_ADAPTER_LICENSE(jSONObject, arrayList);
        } else if (str.equals(DiagnoseConstants.EXT1_EXECUTION_FLOW_CHART)) {
            parseDataFromJsonForEXT1_EXECUTION_FLOW_CHART(jSONObject, arrayList);
        }
    }

    private void jsonEX1SpecialFunction(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        BasicSpecFunDynamicEvent basicSpecFunDynamicEvent = new BasicSpecFunDynamicEvent();
        ArrayList<BasicButtonBean> buttonList = basicSpecFunDynamicEvent.getButtonList();
        ArrayList<BasicSpeciaFunctionBean> titleList = basicSpecFunDynamicEvent.getTitleList();
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> valueList = basicSpecFunDynamicEvent.getValueList();
        try {
            basicSpecFunDynamicEvent.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            if (jSONObject.has(JsonConstText.Const_Text_Normal)) {
                basicSpecFunDynamicEvent.setAddInfo(jSONObject.getString(JsonConstText.Const_Text_Normal));
            }
            int parseInt = Integer.parseInt(jSONObject.getString(JsonConstText.Const_Text_Colums));
            basicSpecFunDynamicEvent.setColumsNumber(parseInt);
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicButtonBean.setCommand(jSONObject2.getString(JsonConstText.Const_Text_Cmd));
                boolean z = true;
                if (jSONObject2.getInt(JsonConstText.Const_Text_Status) != 1) {
                    z = false;
                }
                basicButtonBean.setEnable(z);
                buttonList.add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menutitle);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicSpeciaFunctionBean basicSpeciaFunctionBean = new BasicSpeciaFunctionBean();
                basicSpeciaFunctionBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicSpeciaFunctionBean.setModel(jSONObject3.getString(JsonConstText.Const_Text_Model));
                basicSpeciaFunctionBean.setScale(jSONObject3.getString(JsonConstText.Const_Text_Scale));
                titleList.add(basicSpeciaFunctionBean);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            int i3 = 0;
            int i4 = 0;
            while (i3 < jSONArray3.length()) {
                ArrayList<BasicSpeciaFunctionBean> arrayList2 = new ArrayList<>();
                int i5 = i4;
                for (int i6 = 0; i6 < parseInt; i6++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i5);
                    BasicSpeciaFunctionBean basicSpeciaFunctionBean2 = new BasicSpeciaFunctionBean();
                    basicSpeciaFunctionBean2.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Value));
                    arrayList2.add(basicSpeciaFunctionBean2);
                    i5++;
                }
                valueList.add(arrayList2);
                i3 += parseInt;
                i4 = i5;
            }
            arrayList.add(basicSpecFunDynamicEvent);
            if (DiagnoseConstants.IS_Need_RECORD) {
                if (DiagnoseConstants.SF_IS_SHOW_REPORT) {
                    DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanInfoFromSpecilFunction(valueList, DiagnoseInfo.getInstance().getSysNameId());
                } else if (DiagnoseConstants.IS_RECORD_DATASTREAM) {
                    DiagnoseProcessInfoUtil.getInstance().addSysDataStreamInfoFromSpecilFunction(valueList, DiagnoseInfo.getInstance().getSysNameId());
                } else if (DiagnoseConstants.IS_RECORD_VERINFO) {
                    DiagnoseProcessInfoUtil.getInstance().addSysECUInfoFromSpecilFunction(valueList, DiagnoseInfo.getInstance().getSysNameId());
                }
                DiagnoseConstants.IS_Need_RECORD = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForTMPTest(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicTMPSTestBean basicTMPSTestBean = new BasicTMPSTestBean();
            basicTMPSTestBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicTMPSTestBean.getTMPSBtn().add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicTMPSItemBean basicTMPSItemBean = new BasicTMPSItemBean();
                basicTMPSItemBean.setPos(jSONObject3.getInt(JsonConstText.Const_Text_Type));
                basicTMPSItemBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicTMPSItemBean.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                basicTMPSTestBean.getTMPSItem().add(basicTMPSItemBean);
            }
            arrayList.add(basicTMPSTestBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForTMPSProgramming(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicTMPSProgrammingBeam basicTMPSProgrammingBeam = new BasicTMPSProgrammingBeam();
            basicTMPSProgrammingBeam.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicTMPSProgrammingBeam.setStrTopShow(jSONObject.getString(JsonConstText.Const_Text_Label));
            basicTMPSProgrammingBeam.setDefultTab(jSONObject.getInt(JsonConstText.Const_Text_default));
            basicTMPSProgrammingBeam.setDefultPos(jSONObject.getInt(JsonConstText.Const_Text_Check));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicTMPSProgrammingBeam.getTMPSBtn().add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Tabdata);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicButtonBean basicButtonBean2 = new BasicButtonBean();
                basicButtonBean2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicTMPSProgrammingBeam.getTMPSTab().add(basicButtonBean2);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                BasicButtonBean basicButtonBean3 = new BasicButtonBean();
                basicButtonBean3.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Title));
                basicTMPSProgrammingBeam.getTMPSMenu().add(basicButtonBean3);
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                JSONObject jSONObject5 = jSONArray4.getJSONObject(i4);
                BasicTMPSItemBean basicTMPSItemBean = new BasicTMPSItemBean();
                basicTMPSItemBean.setPos(jSONObject5.getInt(JsonConstText.Const_Text_Type));
                basicTMPSItemBean.setValue(jSONObject5.getString(JsonConstText.Const_Text_Value));
                JSONArray jSONArray5 = jSONObject5.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                    JSONObject jSONObject6 = jSONArray5.getJSONObject(i5);
                    BasicTMPSActiveInfo basicTMPSActiveInfo = new BasicTMPSActiveInfo();
                    basicTMPSActiveInfo.setId(jSONObject6.getInt(JsonConstText.Const_Text_Type));
                    basicTMPSActiveInfo.setTitle(jSONObject6.getString(JsonConstText.Const_Text_Value));
                    basicTMPSItemBean.getArrTMPSActiveInfo().add(basicTMPSActiveInfo);
                }
                basicTMPSProgrammingBeam.getTMPSItem().add(basicTMPSItemBean);
            }
            arrayList.add(basicTMPSProgrammingBeam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForTMPSLearning(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicTMPSLearningBean basicTMPSLearningBean = new BasicTMPSLearningBean();
            basicTMPSLearningBean.setDefultTab(jSONObject.getInt(JsonConstText.Const_Text_default));
            basicTMPSLearningBean.setDefultPos(jSONObject.getInt(JsonConstText.Const_Text_Check));
            basicTMPSLearningBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicTMPSLearningBean.setStrTopShow(jSONObject.getString(JsonConstText.Const_Text_Content));
            basicTMPSLearningBean.setStrBottomShow(jSONObject.getString(JsonConstText.Const_Text_Context));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicTMPSLearningBean.getTMPSBtn().add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Tabdata);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicButtonBean basicButtonBean2 = new BasicButtonBean();
                basicButtonBean2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicTMPSLearningBean.getTMPSTab().add(basicButtonBean2);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                BasicTMPSItemBean basicTMPSItemBean = new BasicTMPSItemBean();
                basicTMPSItemBean.setPos(jSONObject4.getInt(JsonConstText.Const_Text_Type));
                basicTMPSItemBean.setValue(jSONObject4.getString(JsonConstText.Const_Text_Value));
                basicTMPSLearningBean.getTMPSItem().add(basicTMPSItemBean);
            }
            arrayList.add(basicTMPSLearningBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForCentralGateWayNetWorkLayout(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicCentralGateWayNetWorkLayoutBean basicCentralGateWayNetWorkLayoutBean = new BasicCentralGateWayNetWorkLayoutBean();
            basicCentralGateWayNetWorkLayoutBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicCentralGateWayNetWorkLayoutBean.setHelp(jSONObject.getString(JsonConstText.Const_Text_Help));
            BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean = new BasicEcuNetWorkLayoutBean();
            basicEcuNetWorkLayoutBean.setRetOpType(0);
            basicEcuNetWorkLayoutBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Context));
            basicEcuNetWorkLayoutBean.setTextColor(Color.rgb(jSONObject.getInt(JsonConstText.Const_Text_RGB_R), jSONObject.getInt(JsonConstText.Const_Text_RGB_G), jSONObject.getInt(JsonConstText.Const_Text_RGB_B)));
            basicEcuNetWorkLayoutBean.setBgColor(Color.rgb(jSONObject.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject.getInt(JsonConstText.Const_Text_bg_RGB_B)));
            basicEcuNetWorkLayoutBean.setShowGrid(jSONObject.getInt(JsonConstText.Const_Text_Check) == 1);
            basicEcuNetWorkLayoutBean.setHelp(jSONObject.getString(JsonConstText.Const_Text_Label));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Btn_Rows);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicButtonBean.setEnable(jSONObject2.getInt(JsonConstText.Const_Text_Check) == 1);
                basicButtonBean.setCommand(String.valueOf(i));
                basicCentralGateWayNetWorkLayoutBean.getArBtn().add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Colordata);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                basicEcuNetWorkLayoutBean.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject3.getInt(JsonConstText.Const_Text_RGB_R), jSONObject3.getInt(JsonConstText.Const_Text_RGB_G), jSONObject3.getInt(JsonConstText.Const_Text_RGB_B))));
            }
            basicCentralGateWayNetWorkLayoutBean.setCentralGateWayeEcu(basicEcuNetWorkLayoutBean);
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                basicCentralGateWayNetWorkLayoutBean.getArLayoutLineColor().add(Integer.valueOf(Color.rgb(jSONObject4.getInt(JsonConstText.Const_Text_RGB_R), jSONObject4.getInt(JsonConstText.Const_Text_RGB_G), jSONObject4.getInt(JsonConstText.Const_Text_RGB_B))));
                JSONArray jSONArray4 = jSONObject4.getJSONArray(JsonConstText.Const_Text_Menudata);
                ArrayList<BasicEcuNetWorkLayoutBean> arrayList2 = new ArrayList<>();
                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                    JSONObject jSONObject5 = jSONArray4.getJSONObject(i4);
                    BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean2 = new BasicEcuNetWorkLayoutBean();
                    basicEcuNetWorkLayoutBean2.setPos(i4);
                    basicEcuNetWorkLayoutBean2.setRetOpType(i3 + 1);
                    basicEcuNetWorkLayoutBean2.setTitle(jSONObject5.getString(JsonConstText.Const_Text_Context));
                    basicEcuNetWorkLayoutBean2.setTextColor(Color.rgb(jSONObject5.getInt(JsonConstText.Const_Text_RGB_R), jSONObject5.getInt(JsonConstText.Const_Text_RGB_G), jSONObject5.getInt(JsonConstText.Const_Text_RGB_B)));
                    basicEcuNetWorkLayoutBean2.setBgColor(Color.rgb(jSONObject5.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject5.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject5.getInt(JsonConstText.Const_Text_bg_RGB_B)));
                    basicEcuNetWorkLayoutBean2.setShowGrid(jSONObject5.getInt(JsonConstText.Const_Text_Check) == 1);
                    basicEcuNetWorkLayoutBean2.setHelp(jSONObject5.getString(JsonConstText.Const_Text_Label));
                    JSONArray jSONArray5 = jSONObject5.getJSONArray(JsonConstText.Const_Text_Colordata);
                    for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                        JSONObject jSONObject6 = jSONArray5.getJSONObject(i5);
                        basicEcuNetWorkLayoutBean2.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject6.getInt(JsonConstText.Const_Text_RGB_R), jSONObject6.getInt(JsonConstText.Const_Text_RGB_G), jSONObject6.getInt(JsonConstText.Const_Text_RGB_B))));
                    }
                    arrayList2.add(basicEcuNetWorkLayoutBean2);
                }
                basicCentralGateWayNetWorkLayoutBean.getArrEcuData().add(arrayList2);
            }
            JSONArray jSONArray6 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                JSONObject jSONObject7 = jSONArray6.getJSONObject(i6);
                BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean3 = new BasicEcuNetWorkLayoutBean();
                basicEcuNetWorkLayoutBean3.setPos(i6);
                basicEcuNetWorkLayoutBean3.setRetOpType(255);
                basicEcuNetWorkLayoutBean3.setTitle(jSONObject7.getString(JsonConstText.Const_Text_Context));
                basicEcuNetWorkLayoutBean3.setTextColor(Color.rgb(jSONObject7.getInt(JsonConstText.Const_Text_RGB_R), jSONObject7.getInt(JsonConstText.Const_Text_RGB_G), jSONObject7.getInt(JsonConstText.Const_Text_RGB_B)));
                basicEcuNetWorkLayoutBean3.setBgColor(Color.rgb(jSONObject7.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject7.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject7.getInt(JsonConstText.Const_Text_bg_RGB_B)));
                basicEcuNetWorkLayoutBean3.setShowGrid(jSONObject7.getInt(JsonConstText.Const_Text_Check) == 1);
                JSONArray jSONArray7 = jSONObject7.getJSONArray(JsonConstText.Const_Text_Colordata);
                for (int i7 = 0; i7 < jSONArray7.length(); i7++) {
                    JSONObject jSONObject8 = jSONArray7.getJSONObject(i7);
                    basicEcuNetWorkLayoutBean3.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject8.getInt(JsonConstText.Const_Text_RGB_R), jSONObject8.getInt(JsonConstText.Const_Text_RGB_G), jSONObject8.getInt(JsonConstText.Const_Text_RGB_B))));
                }
                basicEcuNetWorkLayoutBean3.setHelp(jSONObject7.getString(JsonConstText.Const_Text_Label));
                basicCentralGateWayNetWorkLayoutBean.getArEXEcudata().add(basicEcuNetWorkLayoutBean3);
            }
            arrayList.add(basicCentralGateWayNetWorkLayoutBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForDualHighSpeedLayout(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        boolean z;
        try {
            BasicDualHighSpeedLayoutBean basicDualHighSpeedLayoutBean = new BasicDualHighSpeedLayoutBean();
            basicDualHighSpeedLayoutBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            basicDualHighSpeedLayoutBean.setHelp(jSONObject.getString(JsonConstText.Const_Text_Help));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Btn_Rows);
            int i = 0;
            while (true) {
                z = true;
                if (i >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                if (jSONObject2.getInt(JsonConstText.Const_Text_Check) != 1) {
                    z = false;
                }
                basicButtonBean.setEnable(z);
                basicButtonBean.setCommand(String.valueOf(i));
                basicDualHighSpeedLayoutBean.getArBtn().add(basicButtonBean);
                i++;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            int i2 = 0;
            while (i2 < jSONArray2.length()) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                basicDualHighSpeedLayoutBean.getArLayoutLineTitle().add(jSONObject3.getString(JsonConstText.Const_Text_Context));
                basicDualHighSpeedLayoutBean.getArLayoutLineColor().add(Integer.valueOf(Color.rgb(jSONObject3.getInt(JsonConstText.Const_Text_RGB_R), jSONObject3.getInt(JsonConstText.Const_Text_RGB_G), jSONObject3.getInt(JsonConstText.Const_Text_RGB_B))));
                JSONArray jSONArray3 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Menudata);
                ArrayList<BasicEcuNetWorkLayoutBean> arrayList2 = new ArrayList<>();
                int i3 = 0;
                while (i3 < jSONArray3.length()) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i3);
                    BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean = new BasicEcuNetWorkLayoutBean();
                    basicEcuNetWorkLayoutBean.setPos(i3);
                    basicEcuNetWorkLayoutBean.setRetOpType(i2 + 1);
                    basicEcuNetWorkLayoutBean.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Context));
                    basicEcuNetWorkLayoutBean.setTextColor(Color.rgb(jSONObject4.getInt(JsonConstText.Const_Text_RGB_R), jSONObject4.getInt(JsonConstText.Const_Text_RGB_G), jSONObject4.getInt(JsonConstText.Const_Text_RGB_B)));
                    basicEcuNetWorkLayoutBean.setBgColor(Color.rgb(jSONObject4.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject4.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject4.getInt(JsonConstText.Const_Text_bg_RGB_B)));
                    basicEcuNetWorkLayoutBean.setShowGrid(jSONObject4.getInt(JsonConstText.Const_Text_Check) == z);
                    JSONArray jSONArray4 = jSONObject4.getJSONArray(JsonConstText.Const_Text_Colordata);
                    for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i4);
                        basicEcuNetWorkLayoutBean.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject5.getInt(JsonConstText.Const_Text_RGB_R), jSONObject5.getInt(JsonConstText.Const_Text_RGB_G), jSONObject5.getInt(JsonConstText.Const_Text_RGB_B))));
                    }
                    basicEcuNetWorkLayoutBean.setHelp(jSONObject4.getString(JsonConstText.Const_Text_Label));
                    arrayList2.add(basicEcuNetWorkLayoutBean);
                    i3++;
                    z = true;
                }
                basicDualHighSpeedLayoutBean.getArLayoutLineECUs().add(arrayList2);
                i2++;
                z = true;
            }
            JSONArray jSONArray5 = jSONObject.getJSONArray(JsonConstText.Const_Text_Tabdata);
            for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                JSONObject jSONObject6 = jSONArray5.getJSONObject(i5);
                BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean2 = new BasicEcuNetWorkLayoutBean();
                basicEcuNetWorkLayoutBean2.setPos(i5);
                basicEcuNetWorkLayoutBean2.setRetOpType(0);
                basicEcuNetWorkLayoutBean2.setTitle(jSONObject6.getString(JsonConstText.Const_Text_Context));
                basicEcuNetWorkLayoutBean2.setTextColor(Color.rgb(jSONObject6.getInt(JsonConstText.Const_Text_RGB_R), jSONObject6.getInt(JsonConstText.Const_Text_RGB_G), jSONObject6.getInt(JsonConstText.Const_Text_RGB_B)));
                basicEcuNetWorkLayoutBean2.setBgColor(Color.rgb(jSONObject6.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject6.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject6.getInt(JsonConstText.Const_Text_bg_RGB_B)));
                basicEcuNetWorkLayoutBean2.setShowGrid(jSONObject6.getInt(JsonConstText.Const_Text_Check) == 1);
                JSONArray jSONArray6 = jSONObject6.getJSONArray(JsonConstText.Const_Text_Colordata);
                for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                    JSONObject jSONObject7 = jSONArray6.getJSONObject(i6);
                    basicEcuNetWorkLayoutBean2.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject7.getInt(JsonConstText.Const_Text_RGB_R), jSONObject7.getInt(JsonConstText.Const_Text_RGB_G), jSONObject7.getInt(JsonConstText.Const_Text_RGB_B))));
                }
                basicEcuNetWorkLayoutBean2.setHelp(jSONObject6.getString(JsonConstText.Const_Text_Label));
                basicDualHighSpeedLayoutBean.getArPublicECUs().add(basicEcuNetWorkLayoutBean2);
            }
            JSONArray jSONArray7 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i7 = 0; i7 < jSONArray7.length(); i7++) {
                JSONObject jSONObject8 = jSONArray7.getJSONObject(i7);
                BasicEcuNetWorkLayoutBean basicEcuNetWorkLayoutBean3 = new BasicEcuNetWorkLayoutBean();
                basicEcuNetWorkLayoutBean3.setPos(i7);
                basicEcuNetWorkLayoutBean3.setRetOpType(255);
                basicEcuNetWorkLayoutBean3.setTitle(jSONObject8.getString(JsonConstText.Const_Text_Context));
                basicEcuNetWorkLayoutBean3.setTextColor(Color.rgb(jSONObject8.getInt(JsonConstText.Const_Text_RGB_R), jSONObject8.getInt(JsonConstText.Const_Text_RGB_G), jSONObject8.getInt(JsonConstText.Const_Text_RGB_B)));
                basicEcuNetWorkLayoutBean3.setBgColor(Color.rgb(jSONObject8.getInt(JsonConstText.Const_Text_bg_RGB_R), jSONObject8.getInt(JsonConstText.Const_Text_bg_RGB_G), jSONObject8.getInt(JsonConstText.Const_Text_bg_RGB_B)));
                basicEcuNetWorkLayoutBean3.setShowGrid(jSONObject8.getInt(JsonConstText.Const_Text_Check) == 1);
                JSONArray jSONArray8 = jSONObject8.getJSONArray(JsonConstText.Const_Text_Colordata);
                for (int i8 = 0; i8 < jSONArray8.length(); i8++) {
                    JSONObject jSONObject9 = jSONArray8.getJSONObject(i8);
                    basicEcuNetWorkLayoutBean3.getArSubColor().add(Integer.valueOf(Color.rgb(jSONObject9.getInt(JsonConstText.Const_Text_RGB_R), jSONObject9.getInt(JsonConstText.Const_Text_RGB_G), jSONObject9.getInt(JsonConstText.Const_Text_RGB_B))));
                }
                basicEcuNetWorkLayoutBean3.setHelp(jSONObject8.getString(JsonConstText.Const_Text_Label));
                basicDualHighSpeedLayoutBean.getArEXECUs().add(basicEcuNetWorkLayoutBean3);
            }
            arrayList.add(basicDualHighSpeedLayoutBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForEX1_GET_DEVICE_ADAPTER_LICENSE(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicDeviceBindBean basicDeviceBindBean = new BasicDeviceBindBean();
            basicDeviceBindBean.setDeviceSN(jSONObject.getString(JsonConstText.Const_Text_SN));
            basicDeviceBindBean.setAdpterSN(jSONObject.getString(JsonConstText.Const_Text_ADAPTER_SN));
            basicDeviceBindBean.setRandomIndex(jSONObject.getInt(JsonConstText.Const_Text_Normal));
            arrayList.add(basicDeviceBindBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForEXT1_EXECUTION_FLOW_CHART(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicFlowChartBean basicFlowChartBean = new BasicFlowChartBean();
            basicFlowChartBean.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicFlowChartData basicFlowChartData = new BasicFlowChartData();
                basicFlowChartData.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicFlowChartData.setStatus(jSONObject2.getInt(JsonConstText.Const_Text_Status));
                basicFlowChartData.setPos(i);
                basicFlowChartBean.getArrBtn().add(basicFlowChartData);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                BasicFlowChartData basicFlowChartData2 = new BasicFlowChartData();
                basicFlowChartData2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicFlowChartData2.setStatus(jSONObject3.getInt(JsonConstText.Const_Text_Status));
                basicFlowChartBean.getArrFlowPoint().add(basicFlowChartData2);
            }
            arrayList.add(basicFlowChartBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDataFromJsonForEX1_DEVICE_BIND_ADAPTER(JSONObject jSONObject, ArrayList<BasicBean> arrayList) {
        try {
            BasicDeviceBindBean basicDeviceBindBean = new BasicDeviceBindBean();
            basicDeviceBindBean.setDeviceSN(jSONObject.getString(JsonConstText.Const_Text_SN));
            basicDeviceBindBean.setAdpterSN(jSONObject.getString(JsonConstText.Const_Text_ADAPTER_SN));
            basicDeviceBindBean.setRandomCode(jSONObject.getString(JsonConstText.Const_Text_default));
            basicDeviceBindBean.setRandomIndex(jSONObject.getInt(JsonConstText.Const_Text_Normal));
            arrayList.add(basicDeviceBindBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jsonUIDownloadMultFile(String str, JSONObject jSONObject) {
        try {
            ArrayList<BasicBean> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicDiagDownloadFileBean basicDiagDownloadFileBean = new BasicDiagDownloadFileBean();
                basicDiagDownloadFileBean.setFileVersion(jSONObject2.getString(JsonConstText.Const_Text_Fileversion));
                basicDiagDownloadFileBean.setSoftID(jSONObject2.getString(JsonConstText.Const_Text_Softid));
                basicDiagDownloadFileBean.setLocalpath(jSONObject2.getString(JsonConstText.Const_Text_Localpath));
                arrayList.add(basicDiagDownloadFileBean);
            }
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDownloadDiagMultFile(str, arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIDownloadFile(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_Type_DownloadFileEx) || str.equals(DiagnoseConstants.UI_Type_Upload2Web)) {
            jsonUIDownloadFileEx(str, jSONObject);
            return;
        }
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Fileversion);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_Softid);
            String string3 = jSONObject.getString(JsonConstText.Const_Text_Localpath);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onDownloadDiagFile(str, string, string2, string3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIShowDTCAndFunctionHelp(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(JsonConstText.Const_Text_Dataid);
            String string2 = jSONObject.getString(JsonConstText.Const_Text_Dataversion);
            String string3 = jSONObject.getString(JsonConstText.Const_Text_Softid);
            String string4 = jSONObject.getString(JsonConstText.Const_Text_Langcode);
            if (this.mIDiagnoseDataCallback != null) {
                this.mIDiagnoseDataCallback.onShowDTCOrFunctionHelp(str, string, string2, string3, string4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIMsgBoxWithCustomBtnDialog(java.lang.String r8, org.json.JSONObject r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L5a
            boolean r2 = r9.has(r2)     // Catch: org.json.JSONException -> L5a
            if (r2 == 0) goto L15
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L5a
            java.lang.String r2 = r9.getString(r2)     // Catch: org.json.JSONException -> L5a
            goto L16
        L15:
            r2 = r1
        L16:
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Context     // Catch: org.json.JSONException -> L58
            boolean r3 = r9.has(r3)     // Catch: org.json.JSONException -> L58
            if (r3 == 0) goto L24
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Context     // Catch: org.json.JSONException -> L58
            java.lang.String r1 = r9.getString(r3)     // Catch: org.json.JSONException -> L58
        L24:
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menudata     // Catch: org.json.JSONException -> L58
            org.json.JSONArray r9 = r9.getJSONArray(r3)     // Catch: org.json.JSONException -> L58
            r3 = 0
        L2b:
            int r4 = r9.length()     // Catch: org.json.JSONException -> L58
            if (r3 >= r4) goto L5f
            org.json.JSONObject r4 = r9.getJSONObject(r3)     // Catch: org.json.JSONException -> L58
            com.cnlaunch.diagnosemodule.bean.BasicButtonBean r5 = new com.cnlaunch.diagnosemodule.bean.BasicButtonBean     // Catch: org.json.JSONException -> L58
            r5.<init>()     // Catch: org.json.JSONException -> L58
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Buttoncontext     // Catch: org.json.JSONException -> L58
            boolean r6 = r4.has(r6)     // Catch: org.json.JSONException -> L58
            if (r6 == 0) goto L4b
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Buttoncontext     // Catch: org.json.JSONException -> L58
            java.lang.String r4 = r4.getString(r6)     // Catch: org.json.JSONException -> L58
            r5.setTitle(r4)     // Catch: org.json.JSONException -> L58
        L4b:
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch: org.json.JSONException -> L58
            r5.setId(r4)     // Catch: org.json.JSONException -> L58
            r0.add(r5)     // Catch: org.json.JSONException -> L58
            int r3 = r3 + 1
            goto L2b
        L58:
            r9 = move-exception
            goto L5c
        L5a:
            r9 = move-exception
            r2 = r1
        L5c:
            r9.printStackTrace()
        L5f:
            com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener r9 = r7.mIDiagnoseDataCallback
            if (r9 == 0) goto L66
            r9.onWithCustomBtnDialog(r8, r2, r1, r0)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIMsgBoxWithCustomBtnDialog(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUISelectFileDialog(String str, JSONObject jSONObject) {
        String str2;
        if (this.mIDiagnoseDataCallback != null) {
            str2 = "";
            try {
                str2 = jSONObject.has(JsonConstText.Const_Text_Context) ? jSONObject.getString(JsonConstText.Const_Text_Context) : "";
                if (jSONObject.has(JsonConstText.Const_Text_Label)) {
                    this.mIDiagnoseDataCallback.onSelectFilePathDialog(str, jSONObject.getString(JsonConstText.Const_Text_Label), str2, jSONObject.getString(JsonConstText.Const_Text_default));
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mIDiagnoseDataCallback.onSelectFileDialog(str, str2);
        }
    }

    private void jsonUIDiagCallService(String str, JSONObject jSONObject) {
        if (this.mIDiagnoseDataCallback != null) {
            this.mIDiagnoseDataCallback.onDiagCallService(str, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0085 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIDiagnoseResetCarIconMenu(java.lang.String r9, org.json.JSONObject r10) {
        /*
            r8 = this;
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r0 = 0
            r1 = 0
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L79
            boolean r2 = r10.has(r2)     // Catch: org.json.JSONException -> L79
            if (r2 == 0) goto L16
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L79
            java.lang.String r2 = r10.getString(r2)     // Catch: org.json.JSONException -> L79
            goto L17
        L16:
            r2 = r0
        L17:
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Help     // Catch: org.json.JSONException -> L77
            boolean r3 = r10.has(r3)     // Catch: org.json.JSONException -> L77
            if (r3 == 0) goto L25
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Help     // Catch: org.json.JSONException -> L77
            java.lang.String r0 = r10.getString(r3)     // Catch: org.json.JSONException -> L77
        L25:
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Item     // Catch: org.json.JSONException -> L77
            boolean r3 = r10.has(r3)     // Catch: org.json.JSONException -> L77
            if (r3 == 0) goto L34
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Item     // Catch: org.json.JSONException -> L77
            int r3 = r10.getInt(r3)     // Catch: org.json.JSONException -> L77
            goto L35
        L34:
            r3 = 0
        L35:
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menudata     // Catch: org.json.JSONException -> L75
            org.json.JSONArray r10 = r10.getJSONArray(r4)     // Catch: org.json.JSONException -> L75
        L3b:
            int r4 = r10.length()     // Catch: org.json.JSONException -> L75
            if (r1 >= r4) goto L72
            org.json.JSONObject r4 = r10.getJSONObject(r1)     // Catch: org.json.JSONException -> L75
            com.cnlaunch.diagnosemodule.bean.BasicMenuBean r6 = new com.cnlaunch.diagnosemodule.bean.BasicMenuBean     // Catch: org.json.JSONException -> L75
            r6.<init>()     // Catch: org.json.JSONException -> L75
            java.lang.String r7 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Id     // Catch: org.json.JSONException -> L75
            boolean r7 = r4.has(r7)     // Catch: org.json.JSONException -> L75
            if (r7 == 0) goto L5b
            java.lang.String r7 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Id     // Catch: org.json.JSONException -> L75
            java.lang.String r7 = r4.getString(r7)     // Catch: org.json.JSONException -> L75
            r6.setId(r7)     // Catch: org.json.JSONException -> L75
        L5b:
            java.lang.String r7 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L75
            boolean r7 = r4.has(r7)     // Catch: org.json.JSONException -> L75
            if (r7 == 0) goto L6c
            java.lang.String r7 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L75
            java.lang.String r4 = r4.getString(r7)     // Catch: org.json.JSONException -> L75
            r6.setTitle(r4)     // Catch: org.json.JSONException -> L75
        L6c:
            r5.add(r6)     // Catch: org.json.JSONException -> L75
            int r1 = r1 + 1
            goto L3b
        L72:
            r4 = r3
            r3 = r0
            goto L81
        L75:
            r10 = move-exception
            goto L7c
        L77:
            r10 = move-exception
            goto L7b
        L79:
            r10 = move-exception
            r2 = r0
        L7b:
            r3 = 0
        L7c:
            r10.printStackTrace()
            r4 = r3
            r3 = r0
        L81:
            com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener r0 = r8.mIDiagnoseDataCallback
            if (r0 == 0) goto L8b
            if (r0 == 0) goto L8b
            r1 = r9
            r0.onDiagnoseResetCarIconMenuCallback(r1, r2, r3, r4, r5)
        L8b:
            java.lang.String r9 = "0"
            com.cnlaunch.diagnosemodule.utils.DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIDiagnoseResetCarIconMenu(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUIDiagnoseSpecialDatastream(String str, JSONObject jSONObject) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        String str2;
        String str3 = "";
        ArrayList<BasicDataStreamBean> arrayList = new ArrayList<>();
        ArrayList<BasicDataStreamBean> arrayList2 = new ArrayList<>();
        try {
            i = jSONObject.getInt(JsonConstText.Const_Text_Maindatacount);
            try {
                i2 = jSONObject.getInt(JsonConstText.Const_Text_Accdatacount);
                try {
                    i3 = jSONObject.getInt(JsonConstText.Const_Text_Mindata);
                } catch (Exception e) {
                    e = e;
                    i3 = 0;
                    i4 = 0;
                    z = false;
                    e.printStackTrace();
                    i5 = i4;
                    i6 = i2;
                    z2 = z;
                    i7 = i3;
                    i8 = i;
                    str2 = str3;
                    this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                z = false;
                e.printStackTrace();
                i5 = i4;
                i6 = i2;
                z2 = z;
                i7 = i3;
                i8 = i;
                str2 = str3;
                this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        try {
            i4 = jSONObject.getInt(JsonConstText.Const_Text_Maxdata);
            try {
                str3 = jSONObject.getString(JsonConstText.Const_Text_Title);
                z = jSONObject.getBoolean(JsonConstText.Const_Text_Limit);
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                    JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Accdata);
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i9);
                        BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean();
                        basicDataStreamBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                        basicDataStreamBean.setValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                        basicDataStreamBean.setUnit(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        arrayList.add(basicDataStreamBean);
                    }
                    for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i10);
                        BasicDataStreamBean basicDataStreamBean2 = new BasicDataStreamBean();
                        basicDataStreamBean2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                        basicDataStreamBean2.setValue(jSONObject3.getString(JsonConstText.Const_Text_Value));
                        basicDataStreamBean2.setUnit(jSONObject3.getInt(JsonConstText.Const_Text_Minvalue) + "|" + jSONObject3.getInt(JsonConstText.Const_Text_Maxvalue));
                        arrayList2.add(basicDataStreamBean2);
                    }
                    i5 = i4;
                    i6 = i2;
                    z2 = z;
                    i7 = i3;
                    i8 = i;
                    str2 = str3;
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    i5 = i4;
                    i6 = i2;
                    z2 = z;
                    i7 = i3;
                    i8 = i;
                    str2 = str3;
                    this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
                }
            } catch (Exception e5) {
                e = e5;
                z = false;
                e.printStackTrace();
                i5 = i4;
                i6 = i2;
                z2 = z;
                i7 = i3;
                i8 = i;
                str2 = str3;
                this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
            }
        } catch (Exception e6) {
            e = e6;
            i4 = 0;
            z = false;
            e.printStackTrace();
            i5 = i4;
            i6 = i2;
            z2 = z;
            i7 = i3;
            i8 = i;
            str2 = str3;
            this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
        }
        this.mIDiagnoseDataCallback.onDiagnoseSpeciaDatastream(str2, z2, i8, i6, i7, i5, arrayList, arrayList2);
    }

    private void jsonUIDiagnoseDiagFunInfo(String str, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("funnameid");
            int i = jSONObject.getInt("funtype");
            if (!this.mIDiagnoseDataCallback.onSetDiagnoseInfo(i, string, jSONObject.getInt("funstatus"))) {
                DiagnoseInfo.getInstance().setFunInfo(this.mContext, str, jSONObject);
                if (i == 47) {
                    SendFeedbackMessage("0", "0");
                }
            }
            if (i != 47) {
                SendFeedbackMessage("0", "0");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SendFeedbackMessage("0", "0");
        }
    }

    private boolean jsonUICTHeadInfo(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_YEAR_ID)) {
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, DiagnoseConstants.RECORD_YEAR);
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_DISPLACEMENT_ID)) {
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, DiagnoseConstants.RECORD_DISPLACEMENT);
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_MODEL_ID)) {
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, DiagnoseConstants.RECORD_MODEL);
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_TRANS_ID)) {
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, DiagnoseConstants.RECORD_TRANS);
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_ENGINESPEED_ID)) {
            String str2 = DiagnoseConstants.RECORD_ENGINESPEED;
            if (str2.isEmpty()) {
                SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, "1");
                return true;
            }
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, "0".concat(String.valueOf(str2)));
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_AUTOENTRANCE_ID)) {
            String str3 = DiagnoseConstants.RECORD_AutoEntranceID;
            if (str3.isEmpty()) {
                SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, "1");
                return true;
            }
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_GET_DATA_ID, "0".concat(String.valueOf(str3)));
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_DISPLACEMENT_ID)) {
            try {
                DiagnoseConstants.RECORD_DISPLACEMENT = jSONObject.getString(JsonConstText.Const_Text_Value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_SET_DATA_ID, "0");
            return true;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_SET_TRANS_ID)) {
            try {
                DiagnoseConstants.RECORD_TRANS = jSONObject.getString(JsonConstText.Const_Text_Value);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_RECORD_SET_DATA_ID, "0");
            return true;
        } else {
            return false;
        }
    }

    private boolean getDiagnoseData(String str, JSONObject jSONObject) {
        if ((str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_SYSTEMNAME_ID) || str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_SYSTEMID_ID)) && this.mIDiagnoseDataCallback != null) {
            String str2 = "";
            try {
                str2 = jSONObject.getString(JsonConstText.Const_Text_Value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mIDiagnoseDataCallback.onDiagnoseGetData(str, str2);
            return true;
        }
        return false;
    }

    private void jsonUIDiagnoseCarInfo(String str, JSONObject jSONObject) {
        if (getDiagnoseData(str, jSONObject) || jsonUICTHeadInfo(str, jSONObject)) {
            return;
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_DEVICE_GET_DIAG_PROCESS_WAY_ID)) {
            this.mIDiagnoseDataCallback.onGetDiagProcessWay(str);
            return;
        }
        try {
            DiagnoseInfo.getInstance().setInfo(this.mContext, str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SendFeedbackMessage("0", "0");
    }

    private void jsonUIDiagnoseRecord(String str, JSONObject jSONObject) {
        try {
            jSONObject.getString(JsonConstText.Const_Text_Interfacetype);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUICurrentMenuPath(String str, JSONObject jSONObject) {
        try {
            DiagnoseConstants.DIAGNOSE_CURRENT_PATH = jSONObject.getString(JsonConstText.Const_Text_Value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void jsonUIFeedback(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_TYPE_GET_VIN)) {
            byte[] bArr = DiagnoseConstants.VIN_CODE_ISSUED_BY_USER;
            String str2 = DiagnoseConstants.isStudyDiag ? DiagnoseConstants.VIN_CODE_For_STUDY_DIAG : DiagnoseConstants.VIN_CODE;
            if (bArr != null) {
                SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_GET_VIN, bArr);
            } else {
                SendFeedbackMessage(DiagnoseConstants.FEEDBACK_GET_VIN, str2);
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_SET_VIN)) {
            try {
                DiagnoseConstants.VIN_CODE = jSONObject.getString(JsonConstText.Const_Text_Value).toUpperCase();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SET_VIN, "0");
        } else if (str.equals(DiagnoseConstants.UI_HIS_RECORD)) {
            SendFeedbackMessage(DiagnoseConstants.FEEDBACK_HIS_GET_DIAG_PROCESS_WAY, DiagnoseConstants.DIAG_INPUT_TYPE);
        } else {
            str.equals(DiagnoseConstants.UI_TYPE_NO_UI_CMD);
        }
    }

    public void closeAlertDialog(String str, boolean z) {
        if (!str.equals(DiagnoseConstants.UI_TYPE_DIALOG) && !str.equals(DiagnoseConstants.UI_TYPE_GGP_NAME)) {
            LoadDialog.dismiss(this.mContext);
            return;
        }
        DiagnoseAlertDialog.Builder builder = this.mAlertDialog;
        if (builder != null) {
            if (builder != null || builder.isShowing()) {
                this.mAlertDialog.hide();
            }
            if (z) {
                try {
                    this.mAlertDialog.hide();
                    LoadDialog.dismiss(this.mContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void jsonUICombineMenu(String str, JSONObject jSONObject) {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        String str3;
        str2 = "";
        ArrayList<BasicCombineMenuBean> arrayList = new ArrayList<>();
        try {
            str2 = jSONObject.has(JsonConstText.Const_Text_Title) ? jSONObject.getString(JsonConstText.Const_Text_Title) : "";
            i = jSONObject.has(JsonConstText.Const_Text_Item) ? jSONObject.getInt(JsonConstText.Const_Text_Item) : 0;
            try {
                i2 = jSONObject.has(JsonConstText.Const_Text_ConfirmBtnState) ? jSONObject.getInt(JsonConstText.Const_Text_ConfirmBtnState) : 0;
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                        BasicCombineMenuBean basicCombineMenuBean = new BasicCombineMenuBean();
                        basicCombineMenuBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                        basicCombineMenuBean.setValue(jSONObject2.getString(JsonConstText.Const_Text_Value));
                        arrayList.add(basicCombineMenuBean);
                    }
                    i3 = i;
                    i4 = i2;
                    str3 = str2;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    i3 = i;
                    i4 = i2;
                    str3 = str2;
                    this.mIDiagnoseDataCallback.onDiagnoseCombineMenu(str, str3, i3, arrayList, i4);
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                e.printStackTrace();
                i3 = i;
                i4 = i2;
                str3 = str2;
                this.mIDiagnoseDataCallback.onDiagnoseCombineMenu(str, str3, i3, arrayList, i4);
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        this.mIDiagnoseDataCallback.onDiagnoseCombineMenu(str, str3, i3, arrayList, i4);
    }

    private void closeRemoteDialog() {
        DiagnoseAlertDialog.Builder builder;
        if ((DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) && (builder = this.mAlertDialog) != null) {
            builder.hide();
        }
    }

    private void jsonUIShowDialog(final String str, JSONObject jSONObject) {
        ImageView imageView = new ImageView(this.mContext);
        closeRemoteDialog();
        this.mAlertDialog = new DiagnoseAlertDialog.Builder(this.mContext, C1444R.style.DiagnoseMessageDialogTheme);
        this.mAlertDialog.setDiagnoseAlertDialogCallback(this.mAlertDialogCallBack);
        if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
            this.mAlertDialog.setCancelable(true);
        } else {
            this.mAlertDialog.setCancelable(false);
        }
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Title)) {
                this.mAlertDialog.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            } else {
                this.mAlertDialog.setTitle(17039380);
            }
            if (str.equals(DiagnoseConstants.UI_TYPE_SHOW_PICTURE)) {
                ImageView imageView2 = (ImageView) BitmapUtils.getShowBitmap(this.mContext, jSONObject.getString(JsonConstText.Const_Text_Context));
                if (imageView2 != null) {
                    this.mAlertDialog.setView(imageView2);
                } else {
                    this.mAlertDialog.setMessage(this.mContext.getString(C1444R.string.dialog_no_picture));
                }
            } else if (str.equals(DiagnoseConstants.UI_TYPE_SHOW_DIAG_PICTURE)) {
                imageView.setImageURI(Uri.parse(jSONObject.getString(JsonConstText.Const_Text_Context)));
                this.mAlertDialog.setView(imageView);
            } else {
                this.mAlertDialog.setMessage(jSONObject.getString(JsonConstText.Const_Text_Context));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mAlertDialog.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DiagnoseUIDataBusiness.this.SendFeedbackMessage(str, "00");
            }
        });
        this.mAlertDialog.show();
    }

    private void dismissMessageBox(String str) {
        LoadDialog.dismiss(this.mContext);
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDismissMessageBox(str);
        }
    }

    private void jsonUICustomUseID(String str, JSONObject jSONObject) {
        String str2 = "-1";
        ArrayList<BasicBean> arrayList = new ArrayList<>();
        try {
            str2 = jSONObject.getString(JsonConstText.Const_Text_Type);
            if (str2.equalsIgnoreCase("2") || str2.equalsIgnoreCase("3") || str2.equalsIgnoreCase("4")) {
                BasicChangChengECUCfgBean basicChangChengECUCfgBean = new BasicChangChengECUCfgBean();
                basicChangChengECUCfgBean.setVin(jSONObject.getString(JsonConstText.Const_Text_VIN));
                if (jSONObject.has(JsonConstText.Const_Text_Value)) {
                    basicChangChengECUCfgBean.setECUCode(jSONObject.getString(JsonConstText.Const_Text_Value));
                }
                if (jSONObject.has(JsonConstText.Const_Text_Status)) {
                    basicChangChengECUCfgBean.setStatus(jSONObject.getString(JsonConstText.Const_Text_Status));
                }
                if (jSONObject.has(JsonConstText.Const_Text_Label)) {
                    basicChangChengECUCfgBean.setSecondECUCode(jSONObject.getString(JsonConstText.Const_Text_Label));
                }
                if (jSONObject.has(JsonConstText.Const_Text_Arguments)) {
                    basicChangChengECUCfgBean.setCfgArgument(jSONObject.getString(JsonConstText.Const_Text_Arguments));
                }
                arrayList.add(basicChangChengECUCfgBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.mIDiagnoseDataCallback != null) {
            if (str2.equalsIgnoreCase("0") || str2.equalsIgnoreCase("1")) {
                this.mIDiagnoseDataCallback.onDiagnoseGetData(str, str2);
            } else if (str2.equalsIgnoreCase("2") || str2.equalsIgnoreCase("3") || str2.equalsIgnoreCase("4")) {
                this.mIDiagnoseDataCallback.onSTD_CustomUseIDData(str2, arrayList);
            }
        }
    }

    private void jsonGetCurrentUnitType(String str, JSONObject jSONObject) {
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseGetData(str, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIGetNewVehicle(java.lang.String r8, org.json.JSONObject r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Check     // Catch: org.json.JSONException -> L55
            boolean r2 = r9.getBoolean(r2)     // Catch: org.json.JSONException -> L55
            java.lang.String r3 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Count     // Catch: org.json.JSONException -> L53
            int r3 = r9.getInt(r3)     // Catch: org.json.JSONException -> L53
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menudata     // Catch: org.json.JSONException -> L51
            org.json.JSONArray r9 = r9.getJSONArray(r4)     // Catch: org.json.JSONException -> L51
        L18:
            int r4 = r9.length()     // Catch: org.json.JSONException -> L51
            if (r1 >= r4) goto L5b
            org.json.JSONObject r4 = r9.getJSONObject(r1)     // Catch: org.json.JSONException -> L51
            com.cnlaunch.diagnosemodule.bean.BasicVehicleData r5 = new com.cnlaunch.diagnosemodule.bean.BasicVehicleData     // Catch: org.json.JSONException -> L51
            r5.<init>()     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L51
            r5.setTitle(r6)     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Type     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L51
            r5.setEcuType(r6)     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Status     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L51
            r5.setStatus(r6)     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Count     // Catch: org.json.JSONException -> L51
            int r4 = r4.getInt(r6)     // Catch: org.json.JSONException -> L51
            r5.setDtcCount(r4)     // Catch: org.json.JSONException -> L51
            r0.add(r5)     // Catch: org.json.JSONException -> L51
            int r1 = r1 + 1
            goto L18
        L51:
            r9 = move-exception
            goto L58
        L53:
            r9 = move-exception
            goto L57
        L55:
            r9 = move-exception
            r2 = 0
        L57:
            r3 = 0
        L58:
            r9.printStackTrace()
        L5b:
            com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener r9 = r7.mIDiagnoseDataCallback
            if (r9 == 0) goto L62
            r9.onDiagnoseGetNewVehicleData(r8, r2, r3, r0)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIGetNewVehicle(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUIMessageBox(String str, JSONObject jSONObject) {
        String str2 = "";
        String str3 = "";
        int i = -1;
        try {
            str2 = jSONObject.getString(JsonConstText.Const_Text_Title);
            str3 = jSONObject.getString(JsonConstText.Const_Text_Content);
            if (str.equals(DiagnoseConstants.UI_TYPE_PROGRESSBAR)) {
                i = Integer.parseInt(jSONObject.getString(JsonConstText.Const_Text_Ratio));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseMessageBox(str, str2, str3, i);
        }
    }

    private void jsonUISpecialMultiSelect(String str, JSONObject jSONObject) {
        String str2;
        int i;
        String str3;
        ArrayList<BasicSpeciaFunctionBean> arrayList = new ArrayList<>();
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2 = new ArrayList<>();
        String str4 = "";
        String str5 = "";
        int i2 = 2;
        try {
            str4 = jSONObject.getString(JsonConstText.Const_Text_Title);
            str5 = jSONObject.has(JsonConstText.Const_Text_Cmd) ? jSONObject.getString(JsonConstText.Const_Text_Cmd) : "";
            i2 = Integer.parseInt(jSONObject.getString(JsonConstText.Const_Text_Colums));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menutitle);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                BasicSpeciaFunctionBean basicSpeciaFunctionBean = new BasicSpeciaFunctionBean();
                basicSpeciaFunctionBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicSpeciaFunctionBean.setModel(jSONObject2.getString(JsonConstText.Const_Text_Model));
                basicSpeciaFunctionBean.setScale(jSONObject2.getString(JsonConstText.Const_Text_Scale));
                arrayList.add(basicSpeciaFunctionBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            int i4 = 0;
            int i5 = 0;
            while (i4 < jSONArray2.length()) {
                ArrayList<BasicSpeciaFunctionBean> arrayList3 = new ArrayList<>();
                int i6 = i5;
                for (int i7 = 0; i7 < i2; i7++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i6);
                    BasicSpeciaFunctionBean basicSpeciaFunctionBean2 = new BasicSpeciaFunctionBean();
                    basicSpeciaFunctionBean2.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Value));
                    arrayList3.add(basicSpeciaFunctionBean2);
                    i6++;
                }
                arrayList2.add(arrayList3);
                i4 += i2;
                i5 = i6;
            }
            str2 = str4;
            i = i2;
            str3 = str5;
        } catch (Exception e) {
            e.printStackTrace();
            str2 = str4;
            i = i2;
            str3 = str5;
        }
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseSpeciaMulti_selectCallback(str, arrayList, arrayList2, str3, str2, i);
        }
    }

    private void jsonUISpecialFunction(String str, JSONObject jSONObject) {
        String str2;
        int i;
        ArrayList<BasicButtonBean> arrayList = new ArrayList<>();
        ArrayList<BasicSpeciaFunctionBean> arrayList2 = new ArrayList<>();
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList3 = new ArrayList<>();
        String str3 = "";
        int i2 = 2;
        try {
            if (jSONObject.has(JsonConstText.Const_Text_Funtype)) {
                DiagnoseConstants.IS_SYS_QUICKTEST_SHOW_PROCESS = jSONObject.getBoolean(JsonConstText.Const_Text_Funtype);
            }
            str3 = jSONObject.getString(JsonConstText.Const_Text_Title);
            i2 = Integer.parseInt(jSONObject.getString(JsonConstText.Const_Text_Colums));
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicButtonBean.setCommand(jSONObject2.getString(JsonConstText.Const_Text_Cmd));
                arrayList.add(basicButtonBean);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menutitle);
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                BasicSpeciaFunctionBean basicSpeciaFunctionBean = new BasicSpeciaFunctionBean();
                basicSpeciaFunctionBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicSpeciaFunctionBean.setModel(jSONObject3.getString(JsonConstText.Const_Text_Model));
                basicSpeciaFunctionBean.setScale(jSONObject3.getString(JsonConstText.Const_Text_Scale));
                arrayList2.add(basicSpeciaFunctionBean);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            int i5 = 0;
            int i6 = 0;
            while (i5 < jSONArray3.length()) {
                ArrayList<BasicSpeciaFunctionBean> arrayList4 = new ArrayList<>();
                int i7 = i6;
                for (int i8 = 0; i8 < i2; i8++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i7);
                    BasicSpeciaFunctionBean basicSpeciaFunctionBean2 = new BasicSpeciaFunctionBean();
                    basicSpeciaFunctionBean2.setTitle(jSONObject4.getString(JsonConstText.Const_Text_Value));
                    arrayList4.add(basicSpeciaFunctionBean2);
                    i7++;
                }
                arrayList3.add(arrayList4);
                i5 += i2;
                i6 = i7;
            }
            if (DiagnoseConstants.IS_Need_RECORD) {
                if (DiagnoseConstants.SF_IS_SHOW_REPORT) {
                    DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanInfoFromSpecilFunction(arrayList3, DiagnoseInfo.getInstance().getSysNameId());
                } else if (DiagnoseConstants.IS_RECORD_DATASTREAM) {
                    DiagnoseProcessInfoUtil.getInstance().addSysDataStreamInfoFromSpecilFunction(arrayList3, DiagnoseInfo.getInstance().getSysNameId());
                } else if (DiagnoseConstants.IS_RECORD_VERINFO) {
                    DiagnoseProcessInfoUtil.getInstance().addSysECUInfoFromSpecilFunction(arrayList3, DiagnoseInfo.getInstance().getSysNameId());
                }
                DiagnoseConstants.IS_Need_RECORD = false;
            }
            str2 = str3;
            i = i2;
        } catch (Exception e) {
            e.printStackTrace();
            str2 = str3;
            i = i2;
        }
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseSpeciaFunctionCallback(str, arrayList2, arrayList3, arrayList, str2, i);
        }
    }

    private void jsonUIActiveTest(String str, JSONObject jSONObject, String str2) {
        int i;
        ArrayList<BasicDataStreamBean> arrayList = new ArrayList<>();
        ArrayList<BasicButtonBean> arrayList2 = new ArrayList<>();
        int i2 = -1;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                BasicDataStreamBean basicDataStreamBean = new BasicDataStreamBean(jSONObject2);
                if (!basicDataStreamBean.getTitle().equals(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                    arrayList.add(basicDataStreamBean);
                }
                if (jSONObject2.has(JsonConstText.Const_Text_Item)) {
                    basicDataStreamBean.setSn(jSONObject2.getInt(JsonConstText.Const_Text_Item));
                }
            }
            if (DiagnoseConstants.IS_Need_RECORD) {
                if (DiagnoseConstants.IS_RECORD_DATASTREAM) {
                    DiagnoseProcessInfoUtil.getInstance().addDataStreamBeanInfo(arrayList, DiagnoseInfo.getInstance().getSysNameId(), true);
                } else if (DiagnoseConstants.IS_RECORD_VERINFO) {
                    DiagnoseProcessInfoUtil.getInstance().addECUInfoFromDataStreamBean(arrayList, DiagnoseInfo.getInstance().getSysNameId());
                }
                DiagnoseConstants.IS_Need_RECORD = false;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                BasicButtonBean basicButtonBean = new BasicButtonBean();
                basicButtonBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                basicButtonBean.setCommand(jSONObject3.getString(JsonConstText.Const_Text_Cmd));
                arrayList2.add(basicButtonBean);
            }
            if (jSONObject.has(JsonConstText.Const_Text_Arguments) && jSONObject.getBoolean(JsonConstText.Const_Text_Arguments) && jSONObject.has(JsonConstText.Const_Text_Status)) {
                i2 = jSONObject.getInt(JsonConstText.Const_Text_Status);
            }
            i = i2;
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
        }
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseActiveTestDataCallback(str, str2, arrayList, arrayList2, i);
        }
    }

    private void jsonUIFaultCode(String str, JSONObject jSONObject) {
        ArrayList<BasicFaultCodeBean> arrayList = new ArrayList<>();
        ArrayList<BasicButtonBean> arrayList2 = new ArrayList<>();
        boolean z = !str.equals(DiagnoseConstants.UI_TYPE_FREEZE);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                if (jSONObject2.has(JsonConstText.Const_Text_Id)) {
                    basicFaultCodeBean.setId(jSONObject2.getString(JsonConstText.Const_Text_Id));
                }
                basicFaultCodeBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                basicFaultCodeBean.setContext(jSONObject2.getString(JsonConstText.Const_Text_Context));
                basicFaultCodeBean.setStatus(jSONObject2.getString(JsonConstText.Const_Text_Status));
                basicFaultCodeBean.setHelp(jSONObject2.getString(JsonConstText.Const_Text_Help));
                basicFaultCodeBean.setFaultCode(z);
                if (jSONObject2.has(JsonConstText.Const_Text_IsExitFreeze)) {
                    basicFaultCodeBean.setHasFreeze(jSONObject2.getBoolean(JsonConstText.Const_Text_IsExitFreeze));
                }
                arrayList.add(basicFaultCodeBean);
            }
            if (jSONObject.has(JsonConstText.Const_Text_Buttondata)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Buttondata);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    BasicButtonBean basicButtonBean = new BasicButtonBean();
                    basicButtonBean.setTitle(jSONObject3.getString(JsonConstText.Const_Text_Title));
                    arrayList2.add(basicButtonBean);
                }
            }
            if (!DiagnoseConstants.IS_SET_NO_DTC) {
                DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanInfo(arrayList, DiagnoseInfo.getInstance().getSysNameId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.mIDiagnoseDataCallback == null || str.equals(DiagnoseConstants.UI_TYPE_SUB_FAULTCODE)) {
            return;
        }
        this.mIDiagnoseDataCallback.onDiagnoseFaultCodeDataCallback(str, arrayList, arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[Catch: JSONException -> 0x00d9, LOOP:0: B:15:0x0055->B:17:0x005b, LOOP_END, TryCatch #0 {JSONException -> 0x00d9, blocks: (B:7:0x001f, B:9:0x002d, B:12:0x0036, B:15:0x0055, B:17:0x005b, B:18:0x006a, B:20:0x006e, B:22:0x0072, B:24:0x0076, B:25:0x0085, B:27:0x0098, B:26:0x0088, B:28:0x009b, B:30:0x00a3, B:33:0x00ac, B:35:0x00b4, B:36:0x00c6, B:13:0x0040), top: B:49:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: JSONException -> 0x00d9, TryCatch #0 {JSONException -> 0x00d9, blocks: (B:7:0x001f, B:9:0x002d, B:12:0x0036, B:15:0x0055, B:17:0x005b, B:18:0x006a, B:20:0x006e, B:22:0x0072, B:24:0x0076, B:25:0x0085, B:27:0x0098, B:26:0x0088, B:28:0x009b, B:30:0x00a3, B:33:0x00ac, B:35:0x00b4, B:36:0x00c6, B:13:0x0040), top: B:49:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[Catch: JSONException -> 0x00d9, TryCatch #0 {JSONException -> 0x00d9, blocks: (B:7:0x001f, B:9:0x002d, B:12:0x0036, B:15:0x0055, B:17:0x005b, B:18:0x006a, B:20:0x006e, B:22:0x0072, B:24:0x0076, B:25:0x0085, B:27:0x0098, B:26:0x0088, B:28:0x009b, B:30:0x00a3, B:33:0x00ac, B:35:0x00b4, B:36:0x00c6, B:13:0x0040), top: B:49:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIDataStream(java.lang.String r9, org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIDataStream(java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUISelectMenu(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            r6 = 1
            r5.bFromMenuOrSeletDataStream = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0 = 0
            java.lang.String r1 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Menudata     // Catch: org.json.JSONException -> L68
            org.json.JSONArray r1 = r7.getJSONArray(r1)     // Catch: org.json.JSONException -> L68
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Check     // Catch: org.json.JSONException -> L68
            boolean r2 = r7.has(r2)     // Catch: org.json.JSONException -> L68
            if (r2 == 0) goto L1e
            java.lang.String r2 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Check     // Catch: org.json.JSONException -> L68
            boolean r7 = r7.getBoolean(r2)     // Catch: org.json.JSONException -> L68
            goto L1f
        L1e:
            r7 = 0
        L1f:
            int r2 = r1.length()     // Catch: org.json.JSONException -> L66
            if (r0 >= r2) goto L6e
            org.json.JSONObject r2 = r1.getJSONObject(r0)     // Catch: org.json.JSONException -> L66
            com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean r3 = new com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean     // Catch: org.json.JSONException -> L66
            r3.<init>()     // Catch: org.json.JSONException -> L66
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Id     // Catch: org.json.JSONException -> L66
            boolean r4 = r2.has(r4)     // Catch: org.json.JSONException -> L66
            if (r4 == 0) goto L3f
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Id     // Catch: org.json.JSONException -> L66
            java.lang.String r4 = r2.getString(r4)     // Catch: org.json.JSONException -> L66
            r3.setId(r4)     // Catch: org.json.JSONException -> L66
        L3f:
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Title     // Catch: org.json.JSONException -> L66
            java.lang.String r4 = r2.getString(r4)     // Catch: org.json.JSONException -> L66
            r3.setTitle(r4)     // Catch: org.json.JSONException -> L66
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Check     // Catch: org.json.JSONException -> L66
            boolean r4 = r2.has(r4)     // Catch: org.json.JSONException -> L66
            if (r4 == 0) goto L5a
            java.lang.String r4 = com.cnlaunch.diagnosemodule.JsonConstText.Const_Text_Check     // Catch: org.json.JSONException -> L66
            boolean r2 = r2.getBoolean(r4)     // Catch: org.json.JSONException -> L66
            r3.setCheck(r2)     // Catch: org.json.JSONException -> L66
            goto L5d
        L5a:
            r3.setCheck(r7)     // Catch: org.json.JSONException -> L66
        L5d:
            r3.setNum(r0)     // Catch: org.json.JSONException -> L66
            r6.add(r3)     // Catch: org.json.JSONException -> L66
            int r0 = r0 + 1
            goto L1f
        L66:
            r0 = move-exception
            goto L6b
        L68:
            r7 = move-exception
            r0 = r7
            r7 = 0
        L6b:
            r0.printStackTrace()
        L6e:
            com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener r0 = r5.mIDiagnoseDataCallback
            if (r0 == 0) goto L77
            java.lang.String r1 = "17"
            r0.onDiagnoseDatastreamSelectMenuDataCallback(r1, r6, r7)
        L77:
            java.lang.String r6 = "0"
            com.cnlaunch.diagnosemodule.utils.DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUISelectMenu(java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void jsonUIHDMenu(java.lang.String r13, org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIHDMenu(java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void jsonUITopOrGraphMenu(java.lang.String r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUITopOrGraphMenu(java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:9|10|11|(17:16|17|18|(1:20)(1:70)|21|22|23|24|(9:27|(1:29)|30|(1:32)|33|(1:35)|36|37|25)|38|39|40|(2:42|(1:44))(2:56|(1:62))|45|(2:(1:52)(1:50)|51)|53|54)|73|74|75|76|17|18|(0)(0)|21|22|23|24|(1:25)|38|39|40|(0)(0)|45|(0)|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c2, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c8, code lost:
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
        r4 = 0;
        r5 = 0;
        r3 = null;
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d1, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d3, code lost:
        r14.printStackTrace();
        r6 = r4;
        r7 = r5;
        r5 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[Catch: JSONException -> 0x00c6, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00c6, blocks: (B:22:0x0050, B:24:0x0058), top: B:87:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073 A[Catch: JSONException -> 0x00c2, TryCatch #0 {JSONException -> 0x00c2, blocks: (B:28:0x0066, B:29:0x006d, B:31:0x0073, B:33:0x0084, B:34:0x008d, B:36:0x009e, B:37:0x00a7, B:39:0x00af, B:40:0x00b8), top: B:83:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void jsonUIMenu(java.lang.String r13, org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIMenu(java.lang.String, org.json.JSONObject):void");
    }

    private void jsonUIAgringWindow(String str, JSONObject jSONObject) {
        String str2 = "";
        try {
            Log.d("Sanda", String.valueOf(jSONObject));
            str2 = jSONObject.getString(JsonConstText.Const_Text_Title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
        if (onDiagnoseDataListener != null) {
            onDiagnoseDataListener.onDiagnoseArgingWindowCallback(str, str2);
        }
    }

    public void setDiagnoseAlertDialogCallback(DiagnoseAlertDialog.DiagnoseAlertDialogCallback diagnoseAlertDialogCallback) {
        this.mAlertDialogCallBack = diagnoseAlertDialogCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5 A[Catch: JSONException -> 0x02ac, TryCatch #1 {JSONException -> 0x02ac, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x0013, B:8:0x001b, B:10:0x0020, B:12:0x0029, B:15:0x0033, B:17:0x003b, B:20:0x0045, B:22:0x004d, B:24:0x0051, B:25:0x006e, B:27:0x0075, B:29:0x0085, B:31:0x008b, B:33:0x0093, B:35:0x009b, B:36:0x00a0, B:38:0x00bc, B:43:0x00c4, B:45:0x00d5, B:46:0x00e0, B:48:0x00ee, B:50:0x00fc, B:51:0x0118, B:52:0x0123, B:54:0x012e, B:86:0x022f, B:88:0x0235, B:55:0x013b, B:57:0x0145, B:58:0x015d, B:60:0x0165, B:61:0x0181, B:63:0x0189, B:64:0x01a3, B:66:0x01ab, B:68:0x01c1, B:69:0x01c6, B:70:0x01cc, B:75:0x01dc, B:77:0x01e9, B:79:0x01f5, B:80:0x0204, B:82:0x020a, B:83:0x0219, B:85:0x0220, B:90:0x023b, B:92:0x0241, B:94:0x0247, B:97:0x024c, B:99:0x025a, B:101:0x025e, B:103:0x026c, B:105:0x0272, B:107:0x0278, B:109:0x0282, B:111:0x028b, B:113:0x028f, B:115:0x0295, B:117:0x029f, B:119:0x02a8), top: B:126:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ee A[Catch: JSONException -> 0x02ac, TryCatch #1 {JSONException -> 0x02ac, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x0013, B:8:0x001b, B:10:0x0020, B:12:0x0029, B:15:0x0033, B:17:0x003b, B:20:0x0045, B:22:0x004d, B:24:0x0051, B:25:0x006e, B:27:0x0075, B:29:0x0085, B:31:0x008b, B:33:0x0093, B:35:0x009b, B:36:0x00a0, B:38:0x00bc, B:43:0x00c4, B:45:0x00d5, B:46:0x00e0, B:48:0x00ee, B:50:0x00fc, B:51:0x0118, B:52:0x0123, B:54:0x012e, B:86:0x022f, B:88:0x0235, B:55:0x013b, B:57:0x0145, B:58:0x015d, B:60:0x0165, B:61:0x0181, B:63:0x0189, B:64:0x01a3, B:66:0x01ab, B:68:0x01c1, B:69:0x01c6, B:70:0x01cc, B:75:0x01dc, B:77:0x01e9, B:79:0x01f5, B:80:0x0204, B:82:0x020a, B:83:0x0219, B:85:0x0220, B:90:0x023b, B:92:0x0241, B:94:0x0247, B:97:0x024c, B:99:0x025a, B:101:0x025e, B:103:0x026c, B:105:0x0272, B:107:0x0278, B:109:0x0282, B:111:0x028b, B:113:0x028f, B:115:0x0295, B:117:0x029f, B:119:0x02a8), top: B:126:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012e A[Catch: JSONException -> 0x02ac, TryCatch #1 {JSONException -> 0x02ac, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x0013, B:8:0x001b, B:10:0x0020, B:12:0x0029, B:15:0x0033, B:17:0x003b, B:20:0x0045, B:22:0x004d, B:24:0x0051, B:25:0x006e, B:27:0x0075, B:29:0x0085, B:31:0x008b, B:33:0x0093, B:35:0x009b, B:36:0x00a0, B:38:0x00bc, B:43:0x00c4, B:45:0x00d5, B:46:0x00e0, B:48:0x00ee, B:50:0x00fc, B:51:0x0118, B:52:0x0123, B:54:0x012e, B:86:0x022f, B:88:0x0235, B:55:0x013b, B:57:0x0145, B:58:0x015d, B:60:0x0165, B:61:0x0181, B:63:0x0189, B:64:0x01a3, B:66:0x01ab, B:68:0x01c1, B:69:0x01c6, B:70:0x01cc, B:75:0x01dc, B:77:0x01e9, B:79:0x01f5, B:80:0x0204, B:82:0x020a, B:83:0x0219, B:85:0x0220, B:90:0x023b, B:92:0x0241, B:94:0x0247, B:97:0x024c, B:99:0x025a, B:101:0x025e, B:103:0x026c, B:105:0x0272, B:107:0x0278, B:109:0x0282, B:111:0x028b, B:113:0x028f, B:115:0x0295, B:117:0x029f, B:119:0x02a8), top: B:126:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013b A[Catch: JSONException -> 0x02ac, TryCatch #1 {JSONException -> 0x02ac, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x0013, B:8:0x001b, B:10:0x0020, B:12:0x0029, B:15:0x0033, B:17:0x003b, B:20:0x0045, B:22:0x004d, B:24:0x0051, B:25:0x006e, B:27:0x0075, B:29:0x0085, B:31:0x008b, B:33:0x0093, B:35:0x009b, B:36:0x00a0, B:38:0x00bc, B:43:0x00c4, B:45:0x00d5, B:46:0x00e0, B:48:0x00ee, B:50:0x00fc, B:51:0x0118, B:52:0x0123, B:54:0x012e, B:86:0x022f, B:88:0x0235, B:55:0x013b, B:57:0x0145, B:58:0x015d, B:60:0x0165, B:61:0x0181, B:63:0x0189, B:64:0x01a3, B:66:0x01ab, B:68:0x01c1, B:69:0x01c6, B:70:0x01cc, B:75:0x01dc, B:77:0x01e9, B:79:0x01f5, B:80:0x0204, B:82:0x020a, B:83:0x0219, B:85:0x0220, B:90:0x023b, B:92:0x0241, B:94:0x0247, B:97:0x024c, B:99:0x025a, B:101:0x025e, B:103:0x026c, B:105:0x0272, B:107:0x0278, B:109:0x0282, B:111:0x028b, B:113:0x028f, B:115:0x0295, B:117:0x029f, B:119:0x02a8), top: B:126:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0235 A[Catch: JSONException -> 0x02ac, TryCatch #1 {JSONException -> 0x02ac, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x0013, B:8:0x001b, B:10:0x0020, B:12:0x0029, B:15:0x0033, B:17:0x003b, B:20:0x0045, B:22:0x004d, B:24:0x0051, B:25:0x006e, B:27:0x0075, B:29:0x0085, B:31:0x008b, B:33:0x0093, B:35:0x009b, B:36:0x00a0, B:38:0x00bc, B:43:0x00c4, B:45:0x00d5, B:46:0x00e0, B:48:0x00ee, B:50:0x00fc, B:51:0x0118, B:52:0x0123, B:54:0x012e, B:86:0x022f, B:88:0x0235, B:55:0x013b, B:57:0x0145, B:58:0x015d, B:60:0x0165, B:61:0x0181, B:63:0x0189, B:64:0x01a3, B:66:0x01ab, B:68:0x01c1, B:69:0x01c6, B:70:0x01cc, B:75:0x01dc, B:77:0x01e9, B:79:0x01f5, B:80:0x0204, B:82:0x020a, B:83:0x0219, B:85:0x0220, B:90:0x023b, B:92:0x0241, B:94:0x0247, B:97:0x024c, B:99:0x025a, B:101:0x025e, B:103:0x026c, B:105:0x0272, B:107:0x0278, B:109:0x0282, B:111:0x028b, B:113:0x028f, B:115:0x0295, B:117:0x029f, B:119:0x02a8), top: B:126:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void jsonUIAlertDialog(java.lang.String r7, org.json.JSONObject r8) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.jsonUIAlertDialog(java.lang.String, org.json.JSONObject):void");
    }

    private void UIAlertDialogWithHTMLData(BasicHTMLDialogBean basicHTMLDialogBean) {
        String strTitle = basicHTMLDialogBean.getStrTitle();
        String str = "";
        for (int i = 0; i < basicHTMLDialogBean.getArrayListContext().size(); i++) {
            str = str + basicHTMLDialogBean.getArrayListContext().get(i);
        }
        int btnType = basicHTMLDialogBean.getBtnType();
        dismissMessageBox("");
        closeRemoteDialog();
        this.mAlertDialog = new DiagnoseAlertDialog.Builder(this.mContext, C1444R.style.DiagnoseMessageDialogTheme);
        this.alertDialogWithHTMLData = true;
        this.mAlertDialog.setHTMLdata(true);
        this.mAlertDialog.setDiagnoseAlertDialogCallback(this.mAlertDialogCallBack);
        if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
            this.mAlertDialog.setCancelable(true);
        } else {
            this.mAlertDialog.setCancelable(false);
        }
        if (!strTitle.equals("")) {
            this.mAlertDialog.setTitle(strTitle);
        }
        if (!str.equals("")) {
            this.mAlertDialog.setMessage(str);
        }
        if (btnType == 1) {
            this.mUIType = DiagnoseConstants.UI_TYPE_DIALOG_ENTER;
            this.mAlertDialog.setPositiveButton(this.mContext.getString(17039370), this);
        } else if (btnType == 2) {
            this.mUIType = DiagnoseConstants.UI_TYPE_DIALOG_ENTER_CANCEL;
            String string = this.mContext.getString(17039370);
            String string2 = this.mContext.getString(17039360);
            this.mAlertDialog.setPositiveButton(string, this);
            this.mAlertDialog.setNegativeButton(string2, this);
        } else if (btnType == 3) {
            this.mUIType = DiagnoseConstants.UI_TYPE_DIALOG_YES_NO;
            String string3 = this.mContext.getString(C1444R.string.yes);
            String string4 = this.mContext.getString(C1444R.string.f7265no);
            this.mAlertDialog.setPositiveButton(string3, this);
            this.mAlertDialog.setNegativeButton(string4, this);
        } else if (btnType == 4) {
            this.mUIType = DiagnoseConstants.UI_TYPE_DIALOG_RETRY_CANCEL;
            String string5 = this.mContext.getString(C1444R.string.retry);
            String string6 = this.mContext.getString(17039360);
            this.mAlertDialog.setPositiveButton(string5, this);
            this.mAlertDialog.setNegativeButton(string6, this);
        } else if (btnType == 7) {
            this.mUIType = DiagnoseConstants.UI_TYPE_DIALOG_FEEDBACK;
            String string7 = this.mContext.getString(C1444R.string.yes);
            String string8 = this.mContext.getString(C1444R.string.feedback);
            if (DiagnoseConstants.getDiagIdentity() != 0) {
                this.mAlertDialog.setPositiveButton(string8, this);
            }
            this.mAlertDialog.setNegativeButton(string7, this);
        }
        if (getbCanShowDialog()) {
            this.mAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyInputFilter implements InputFilter {
        public String strRegSet = "";

        MyInputFilter() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            StringBuilder sb = new StringBuilder(spanned);
            sb.insert(i3, charSequence);
            return sb.toString().matches(this.strRegSet) ? charSequence : "";
        }
    }

    private void jsonUIInputDialog(final String str, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        int i2 = 0;
        if (DiagnoseConstants.isDiagInputDiaglog2UI) {
            String str6 = "";
            String str7 = "";
            str2 = "";
            try {
                str6 = jSONObject.getString(JsonConstText.Const_Text_Title);
                str7 = jSONObject.getString(JsonConstText.Const_Text_Content);
                if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC)) {
                    str2 = jSONObject.has(JsonConstText.Const_Text_default) ? jSONObject.getString(JsonConstText.Const_Text_default) : "";
                    if (jSONObject.has(JsonConstText.Const_Text_CtrolLength)) {
                        i2 = jSONObject.getInt(JsonConstText.Const_Text_CtrolLength);
                    }
                }
                str3 = str6;
                i = i2;
                str4 = str7;
                str5 = str2;
            } catch (JSONException e) {
                e.printStackTrace();
                str3 = str6;
                str4 = str7;
                str5 = str2;
                i = 0;
            }
            if (this.mIDiagnoseDataCallback != null) {
                if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC)) {
                    this.mIDiagnoseDataCallback.onDiagnoseInputNumberDialog(str, str3, str4, str5, i);
                    return;
                } else {
                    this.mIDiagnoseDataCallback.onDiagnoseInputDialog(str, str3, str4, str5, i);
                    return;
                }
            }
            return;
        }
        this.mInputAfterMask = false;
        final String str8 = "";
        final EditText editText = new EditText(this.mContext);
        editText.setBackgroundResource(C1444R.drawable.dialog_edit_background);
        if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTBOX_TEXT)) {
            editText.setInputType(2);
            str8 = "7";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING)) {
            str8 = "8";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC)) {
            this.mInputAfterMask = true;
            editText.setInputType(12290);
            String str9 = "";
            try {
                r0 = jSONObject.has(JsonConstText.Const_Text_CtrolLength) ? jSONObject.getInt(JsonConstText.Const_Text_CtrolLength) : 4;
                if (jSONObject.has(JsonConstText.Const_Text_default)) {
                    str9 = jSONObject.getString(JsonConstText.Const_Text_default);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str10 = "^([0-9]\\d{0,15}|(-|-[0-9]\\d{0,15})|-?0)(\\.|\\.\\d{0," + r0 + "})?$";
            InputFilter[] inputFilterArr = this.mMyFilter;
            if (inputFilterArr[0] instanceof MyInputFilter) {
                ((MyInputFilter) inputFilterArr[0]).strRegSet = str10;
            }
            editText.setHint(str9);
            editText.setFilters(this.mMyFilter);
            str8 = DiagnoseConstants.FEEDBACK_INPUT_NUMBER;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING_EX)) {
            this.mInputAfterMask = true;
            str8 = "16";
        }
        closeRemoteDialog();
        this.mAlertDialog = new DiagnoseAlertDialog.Builder(this.mContext, C1444R.style.DiagnoseMessageDialogTheme);
        this.mAlertDialog.setDiagnoseAlertDialogCallback(this.mAlertDialogCallBack);
        if (DiagnoseConstants.getDiagIdentity() == 0 || DiagnoseConstants.isWebRemote) {
            this.mAlertDialog.setCancelable(true);
        } else {
            this.mAlertDialog.setCancelable(false);
        }
        try {
            if (!jSONObject.getString(JsonConstText.Const_Text_Title).equals("")) {
                this.mAlertDialog.setTitle(jSONObject.getString(JsonConstText.Const_Text_Title));
            }
            this.mAlertDialog.setIcon(17301659);
            this.mAlertDialog.setMessage(jSONObject.getString(JsonConstText.Const_Text_Content));
            this.mAlertDialog.setView(editText);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        this.mAlertDialog.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                String obj = editText.getText().toString();
                if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC) && obj.equals("")) {
                    obj = editText.getHint().toString();
                }
                try {
                    Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                    if (DiagnoseUIDataBusiness.this.mInputAfterMask) {
                        obj = "1".concat(String.valueOf(obj));
                    }
                    DiagnoseUIDataBusiness.this.SendFeedbackMessage(str8, obj);
                    declaredField.setAccessible(true);
                    declaredField.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUT_NUMERIC) || str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING_EX)) {
            this.mAlertDialog.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    try {
                        String concat = DiagnoseUIDataBusiness.this.mInputAfterMask ? "0".concat(String.valueOf("0")) : "0";
                        if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_INPUTSTRING)) {
                            concat = "-1";
                        }
                        DiagnoseUIDataBusiness.this.SendFeedbackMessage(str8, concat);
                        Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                        declaredField.setAccessible(true);
                        declaredField.set(dialogInterface, Boolean.TRUE);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
        if (DiagnoseConstants.getDiagIdentity() > 0) {
            this.mAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void SendFeedbackMessage(String str, String str2) {
        if (DeviceFactoryManager.m8305a().f9911k) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Type, str);
                jSONObject.put(JsonConstText.Const_Text_Cmd, str2);
                jSONObject.put(HtmlTags.SIZE, 3);
                DeviceFactoryManager.m8305a().m8295a(new RemoteMessage(new Envelope(1, new Letter(jSONObject.toString())).m8212a()).m8205b());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Message obtain = Message.obtain((Handler) null, 3);
            Bundle bundle = new Bundle();
            bundle.putString(JsonConstText.Const_Text_Type, str);
            bundle.putString(JsonConstText.Const_Text_Cmd, str2);
            obtain.setData(bundle);
            this.mService.send(obtain);
            if (this.mContext != null) {
                Intent intent = new Intent("BUSINESS_FEEDBACK");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("what", 3);
                bundle2.putString(JsonConstText.Const_Text_Type, str);
                bundle2.putString(JsonConstText.Const_Text_Cmd, str2);
                intent.putExtra("bmsg", bundle2);
                this.mContext.sendBroadcast(intent);
            }
            return;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return;
        }
    }

    private synchronized void SendByteDataFeedbackMessage(String str, byte[] bArr) {
        if (DeviceFactoryManager.m8305a().f9911k) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JsonConstText.Const_Text_Type, str);
                jSONObject.put(JsonConstText.Const_Text_Cmd, Base64.encodeToString(bArr, 0));
                jSONObject.put(HtmlTags.SIZE, 24);
                DeviceFactoryManager.m8305a().m8295a(new RemoteMessage(new Envelope(7, new Letter(jSONObject.toString())).m8212a()).m8205b());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Message obtain = Message.obtain((Handler) null, 24);
            Bundle bundle = new Bundle();
            bundle.putString(JsonConstText.Const_Text_Type, str);
            bundle.putByteArray(JsonConstText.Const_Text_Cmd, bArr);
            obtain.setData(bundle);
            this.mService.send(obtain);
            if (this.mContext != null) {
                Intent intent = new Intent("BYTE_DATA_BUSINESS_FEEDBACK");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("what", 3);
                bundle2.putString(JsonConstText.Const_Text_Type, str);
                bundle2.putByteArray(JsonConstText.Const_Text_Cmd, bArr);
                intent.putExtra("bmsg", bundle2);
                this.mContext.sendBroadcast(intent);
            }
            return;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return;
        }
    }

    private synchronized void SendByteDataFeedbackMessage(String str, int[] iArr) {
        try {
            Message obtain = Message.obtain((Handler) null, 27);
            Bundle bundle = new Bundle();
            bundle.putString(JsonConstText.Const_Text_Type, str);
            bundle.putIntArray(JsonConstText.Const_Text_Cmd, iArr);
            obtain.setData(bundle);
            this.mService.send(obtain);
            if (this.mContext != null) {
                Intent intent = new Intent("BYTE_DATA_BUSINESS_FEEDBACK");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("what", 27);
                bundle2.putString(JsonConstText.Const_Text_Type, str);
                bundle2.putIntArray(JsonConstText.Const_Text_Cmd, iArr);
                intent.putExtra("bmsg", bundle2);
                this.mContext.sendBroadcast(intent);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendFeedbackMessageHome(Context context) throws RemoteException {
        context.sendBroadcast(new Intent("ExitDiagnoseWithHomeBtn"));
    }

    public boolean onSpeakDialogBtn(int i) {
        DiagnoseAlertDialog.Builder builder = this.mAlertDialog;
        if (builder == null || !builder.isShowing()) {
            return false;
        }
        return this.mAlertDialog.onSpeakDialogBtn(i);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (DiagnoseConstants.getDiagIdentity() == 0) {
            return;
        }
        if (i == -1) {
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_FEEDBACK)) {
                try {
                    Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                    declaredField.setAccessible(true);
                    declaredField.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OnDiagnoseDataListener onDiagnoseDataListener = this.mIDiagnoseDataCallback;
                if (onDiagnoseDataListener != null) {
                    onDiagnoseDataListener.onDiagnoseFeedback();
                }
                SendFeedbackMessage("6", "00");
                return;
            }
            try {
                Field declaredField2 = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                declaredField2.setAccessible(true);
                declaredField2.set(dialogInterface, Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_ENTER) || this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_ENTER_CANCEL)) {
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "00");
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100");
                }
            }
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_YES_NO)) {
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "02");
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000102");
                }
            }
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_RETRY_CANCEL)) {
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "04");
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000104");
                }
            }
        } else if (i == -2) {
            Field field = null;
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_FEEDBACK)) {
                try {
                    Field declaredField3 = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                    declaredField3.setAccessible(true);
                    declaredField3.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "00");
                    return;
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100");
                    return;
                }
            }
            try {
                field = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                field.setAccessible(true);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_YES_NO)) {
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "03");
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000103");
                }
                try {
                    field.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else if (this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_ENTER_CANCEL) || this.mUIType.equals(DiagnoseConstants.UI_TYPE_DIALOG_RETRY_CANCEL)) {
                if (!this.alertDialogWithHTMLData) {
                    SendFeedbackMessage("6", "01");
                } else {
                    SendFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000101");
                }
                try {
                    field.set(dialogInterface, Boolean.TRUE);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public void setIsDiagnoseFlagAfterMenuIsDisplay(boolean z) {
        if (this.isDiagnoseFlagAfterMenuIsDisplay != z) {
            this.isDiagnoseFlagAfterMenuIsDisplay = z;
        }
    }

    public boolean getIsDiagnoseFlagAfterMenuIsDisplay() {
        return this.isDiagnoseFlagAfterMenuIsDisplay;
    }

    public void setNotAllowShowReconnectDialog(boolean z) {
        this.mNotAllowShowDiaglog = z;
    }
}
