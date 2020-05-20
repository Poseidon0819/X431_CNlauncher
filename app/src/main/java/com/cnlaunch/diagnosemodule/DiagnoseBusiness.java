package com.cnlaunch.diagnosemodule;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseJsonListener;
import com.cnlaunch.diagnosemodule.listener.OnRemoteDiagStatusListener;
import com.cnlaunch.diagnosemodule.newinterface.NewFrameUtil;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.diagnosemodule.utils.PublicCircleAsy;
import com.cnlaunch.diagnosemodule.utils.PublicCircleAsyNewFrame;
import com.cnlaunch.diagnosemodule.utils.PublicCircleAsyVIN;
import com.cnlaunch.p181j.DiagSocketController;
import com.cnlaunch.physics.p205k.C1856n;
import com.ifoer.expedition.ndk.DynamicEvent;
import com.ifoer.expedition.ndk.TPMSInfoEvent;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseBusiness {
    private static boolean IsDiagGetSwitch = false;
    private static DynamicEvent dynamicEvent;
    private static DiagnoseBusiness instance;
    private static Context mContext;
    private static DiagnoseLogicBusiness mDiagnoseLogicBusiness;
    private static TPMSInfoEvent tpmsInfoEvent;
    private byte[] diagSwitchData;
    private boolean mClickClearDCT = false;
    private boolean isNewFrame = false;
    private Handler handler = new Handler() { // from class: com.cnlaunch.diagnosemodule.DiagnoseBusiness.1
        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            Log.e("dcw", "UI: " + message2.obj.toString());
            if (message2.what == 0) {
                DiagnoseBusiness.mDiagnoseLogicBusiness.dealUIData(message2.obj.toString());
            } else {
                DiagnoseBusiness.mDiagnoseLogicBusiness.dealUIData((JSONObject) message2.obj);
            }
        }
    };

    public native byte[] analysisDiagnoseData(byte[] bArr);

    public native void diagFinish(boolean z);

    public native void feedbackCommand(byte[] bArr);

    public native void feedbackDiagDeviceData(byte[] bArr);

    public native int feedbackUICommand(String str);

    public native void forwardOldUIData(byte[] bArr);

    public native void getDiagInfo(String str);

    public native void getJavaFunction();

    public native void loadSoList(String str);

    public native void nativeInit(int i, String str);

    public native void recordLog(int i);

    public native void setDataFromUI2So(int i, String str);

    public boolean isNewFrame() {
        return this.isNewFrame;
    }

    public void setNewFrame(boolean z) {
        this.isNewFrame = z;
    }

    public byte[] getDiagSwitchData() {
        return this.diagSwitchData;
    }

    public void setDiagSwitchData(byte[] bArr) {
        this.diagSwitchData = bArr;
    }

    public static boolean isIsDiagGetSwitch() {
        return IsDiagGetSwitch;
    }

    public static void setIsDiagGetSwitch(boolean z) {
        IsDiagGetSwitch = z;
    }

    private DiagnoseBusiness(Context context) {
        mContext = context;
        if (!this.isNewFrame) {
            System.loadLibrary("SEARCHID");
            System.loadLibrary("x431file");
        }
        System.loadLibrary("StdBusiness");
    }

    public void setDynamicEvent(DynamicEvent dynamicEvent2) {
        dynamicEvent = dynamicEvent2;
    }

    public void sendEventData(int i, byte[] bArr) {
        try {
            if (dynamicEvent != null) {
                dynamicEvent.sendDynamicEventData(i, bArr);
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public void setTpmsInfoEvent(TPMSInfoEvent tPMSInfoEvent) {
        tpmsInfoEvent = tPMSInfoEvent;
    }

    public TPMSInfoEvent getTpmsInfoEvent() {
        return tpmsInfoEvent;
    }

    public void sendTpmsgunEventData(byte[] bArr) {
        try {
            if (tpmsInfoEvent != null) {
                tpmsInfoEvent.sendTPMSInfoEventData(bArr);
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static DiagnoseBusiness getInstance(Context context) {
        if (instance == null) {
            DiagnoseBusiness diagnoseBusiness = new DiagnoseBusiness(context);
            instance = diagnoseBusiness;
            mDiagnoseLogicBusiness = DiagnoseLogicBusiness.getInstance(diagnoseBusiness, context);
        }
        return instance;
    }

    public static DiagnoseBusiness getInstance(Context context, boolean z) {
        DiagnoseBusiness diagnoseBusiness = instance;
        if (diagnoseBusiness == null || diagnoseBusiness.isNewFrame != z) {
            DiagnoseBusiness diagnoseBusiness2 = new DiagnoseBusiness(context);
            instance = diagnoseBusiness2;
            mDiagnoseLogicBusiness = DiagnoseLogicBusiness.getInstance(diagnoseBusiness2, context);
        }
        return instance;
    }

    public int getLocalLanguage() {
        if (TextUtils.isEmpty(DiagnoseConstants.DIAGNOSE_LANGUAGE)) {
            DiagnoseConstants.DIAGNOSE_LANGUAGE = getMatchedLanguage();
        }
        return AndroidToLan.languages(DiagnoseConstants.DIAGNOSE_LANGUAGE);
    }

    public void LoadLocalSO() {
        getJavaFunction();
        nativeInit(3, DiagnoseConstants.CURRENT_DIAG_CAR);
    }

    public void LoadDynLib(String str, String str2) {
        if (str == null || str.equals("")) {
            return;
        }
        if (!str2.contains("#")) {
            DiagnoseConstants.DIAGNOSE_LANGUAGE = str2;
        } else {
            String[] split = str2.split("#");
            DiagnoseConstants.DIAGNOSE_LANGUAGE = "EN";
            String matchedLanguage = getMatchedLanguage();
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str3 = split[i];
                if (str3.equals(matchedLanguage)) {
                    DiagnoseConstants.DIAGNOSE_LANGUAGE = str3;
                    break;
                }
                i++;
            }
            mContext.sendBroadcast(new Intent("DIAGNOSE_LANGUAGE_CHANGE").putExtra("languege", DiagnoseConstants.DIAGNOSE_LANGUAGE));
        }
        LoadLocalSO();
        if (DiagnoseConstants.CURRENT_DIAG_CAR.equalsIgnoreCase("AUTOSEARCH")) {
            PublicCircleAsyVIN publicCircleAsyVIN = new PublicCircleAsyVIN(str, mContext);
            if (DiagnoseConstants.DIAG_INPUT_TYPE.equals(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL) || DiagnoseConstants.DIAG_INPUT_TYPE.equals(DiagnoseConstants.FEEDBACK_SET_VIN) || DiagnoseConstants.DIAG_INPUT_TYPE.equals("8") || DiagnoseConstants.DIAG_INPUT_TYPE.equals(DiagnoseConstants.FEEDBACK_FREEZEFRAME)) {
                publicCircleAsyVIN.setType(1);
            }
            publicCircleAsyVIN.execute(new String[0]);
        } else if (!this.isNewFrame) {
            new PublicCircleAsy(str, mContext).execute(new String[0]);
        } else {
            new PublicCircleAsyNewFrame(str, mContext).execute(new String[0]);
        }
    }

    public static String getMatchedLanguage() {
        String lan;
        String upperCase = DiagnoseConstants.LOCAL_LANGUAGE.getCountry().toUpperCase();
        String upperCase2 = DiagnoseConstants.LOCAL_LANGUAGE.getLanguage().toUpperCase();
        if (upperCase2.equals("ZH")) {
            lan = AndroidToLan.toLan(upperCase);
        } else {
            lan = AndroidToLan.toLan(upperCase2);
        }
        C1856n.m8130a("yhx", "matchedLanguage=".concat(String.valueOf(lan)));
        return lan;
    }

    public int sendFeedbackCommand(String str) {
        if (!DiagnoseConstants.DIAG_LIB_OLD) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(VastExtensionXmlManager.TYPE);
                String string2 = jSONObject.getString("cmd");
                if (string.equals(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION)) {
                    DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION_REFRESH = string2;
                    return 0;
                } else if (string.equals("9")) {
                    DiagnoseConstants.FEEDBACK_ACTIVE_TEST_NORMAL = string2;
                    return 0;
                } else if (string.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW)) {
                    DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH = string2;
                    return 0;
                } else {
                    feedbackPotting(str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void setDataStreamPageMask(String str) {
        mDiagnoseLogicBusiness.setPageMask(str);
    }

    public void setDataStreamPageMask(ArrayList<String> arrayList) {
        mDiagnoseLogicBusiness.setPageMask(arrayList);
    }

    public void setDiagnoseJsonCallback(OnDiagnoseJsonListener onDiagnoseJsonListener) {
        mDiagnoseLogicBusiness.setOnDiagnoseJsonListener(onDiagnoseJsonListener);
    }

    public void setRemoteDiagnoseStatueCallback(OnRemoteDiagStatusListener onRemoteDiagStatusListener) {
        mDiagnoseLogicBusiness.setRemoteDiagStatusListener(onRemoteDiagStatusListener);
    }

    public void sendUIData(String str) {
        Message message2 = new Message();
        message2.what = 0;
        message2.obj = str;
        this.handler.sendMessage(message2);
    }

    public void sendUIData(JSONObject jSONObject) {
        Message message2 = new Message();
        message2.what = 1;
        message2.obj = jSONObject;
        this.handler.sendMessage(message2);
    }

    public void sendUIByteData(byte[] bArr, int i) {
        DiagnoseLogUtil.getInstance().writeBytes(bArr, i == 0 ? (byte) 1 : (byte) 2);
    }

    public void sendUIDataRemote(String str) {
        Message message2 = new Message();
        message2.what = 0;
        message2.obj = str;
        this.handler.sendMessage(message2);
    }

    public void feekbackDataRemote(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(VastExtensionXmlManager.TYPE);
            String string2 = jSONObject.getString("cmd");
            if (string.equalsIgnoreCase("dataselect_count")) {
                DiagSocketController m8651a = DiagSocketController.m8651a();
                try {
                    int parseInt = Integer.parseInt(string2);
                    if (m8651a.f9476j != null) {
                        m8651a.f9476j.setDataStreamCount(parseInt);
                    }
                } catch (Exception unused) {
                }
            } else if (string.equalsIgnoreCase("remote_message")) {
                DiagSocketController.m8651a().m8646c(str);
            } else {
                if (jSONObject.has("remote_data_type")) {
                    if (jSONObject.has("bytedata") && jSONObject.getString("bytedata").equals("1")) {
                        getInstance(mContext).feedbackCommand(ByteHexHelper.hexStringToBytes(string2));
                        return;
                    }
                    String string3 = jSONObject.getString("remote_data_type");
                    if (string3.equalsIgnoreCase("feedback_normal")) {
                        sendFeedbackCommand(JsonUtils.cmdToJson(string, string2));
                        return;
                    } else if (string3.equalsIgnoreCase("dynamic_event")) {
                        sendEventData(jSONObject.getInt(VastExtensionXmlManager.TYPE), ByteHexHelper.hexStringToBytes(jSONObject.getString("cmd")));
                    }
                }
                if (string.equalsIgnoreCase("special_cmd")) {
                    if (jSONObject.has("page_switch")) {
                        switchPage(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, jSONObject.getString("page_switch"), jSONObject.getInt("position"));
                        return;
                    }
                    DiagSocketController.m8651a().m8648a(string2, jSONObject);
                    return;
                }
                feedbackPotting(JsonUtils.cmdToJson(string, string2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("haizhi", "feekbackDataRemote error:" + e.toString());
        }
    }

    public void sendRemoteDiagStatus(int i) {
        mDiagnoseLogicBusiness.sendRemoteDiagStatue(i);
    }

    public void sendByteUIData(byte[] bArr) {
        ByteHexHelper.bytesToHexString(bArr);
    }

    public void backToPreviousLevel() {
        if (!this.isNewFrame) {
            mDiagnoseLogicBusiness.backToPreviousLevel();
        } else {
            NewFrameUtil.getInstance().returnDiagData(-1, new byte[0]);
        }
    }

    public void switchPage(String str, String str2, int i) {
        mDiagnoseLogicBusiness.switchPage(str, str2, i);
    }

    public String pageStreamFeedbackMask(String str, String str2, int i) {
        return mDiagnoseLogicBusiness.pageStreamFeedbackMask(str, str2, i);
    }

    public static boolean isDiagAutoRefresh() {
        return mDiagnoseLogicBusiness.isDiagAutoRefresh();
    }

    public static void setDiagAutoRefresh(boolean z) {
        mDiagnoseLogicBusiness.setDiagAutoRefresh(z);
    }

    public static void sendCustomDialog(String str, String str2, String str3, String str4) {
        mDiagnoseLogicBusiness.dealUIData(JsonUtils.sendWaitDialog(str, str2, str3, str4));
    }

    public void feedbackPotting(String str) {
        if (DiagnoseService.diagnoseStatue == 1) {
            return;
        }
        feedbackUICommand(str);
    }

    public void feedbackBytesCommand(byte[] bArr) {
        if (DiagnoseService.diagnoseStatue == 1) {
            return;
        }
        feedbackCommand(bArr);
    }

    public void setAutoCleanDCT(boolean z) {
        this.mClickClearDCT = z;
    }

    public boolean isClickClearDCT() {
        return this.mClickClearDCT;
    }
}
