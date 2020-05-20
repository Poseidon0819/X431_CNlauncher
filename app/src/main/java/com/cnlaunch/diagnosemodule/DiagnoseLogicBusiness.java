package com.cnlaunch.diagnosemodule;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseJsonListener;
import com.cnlaunch.diagnosemodule.listener.OnRemoteDiagStatusListener;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.thread.MemoryThread;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.CopyFile;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseLogUtil;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.PhysicsCommonUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiagnoseLogicBusiness {
    private static DiagnoseLogicBusiness instance = null;
    public static String mSelectMask = "";
    private Context mContext;
    private DiagnoseBusiness mDiagnoseBusiness;
    private OnDiagnoseJsonListener mDiagnoseJsonListener = null;
    private MemoryThread mMemoryThread = null;
    private String mDatastreamCount = "0";
    private String mDatastreamPageCount = "0";
    private boolean mDiagAutoRefresh = true;
    private OnRemoteDiagStatusListener mDiagStatusListener = null;
    private ArrayList<String> mMaskList = new ArrayList<>();
    private int mCurrentPage = 0;
    private String mPageControl = "0";
    private boolean mClearDctDialog = false;
    long dataStreamStartTime = 0;
    private boolean uiPageMask = false;
    private StringBuilder mMaskStr = new StringBuilder();
    private int mMaskCount = 0;

    public void setRemoteDiagStatusListener(OnRemoteDiagStatusListener onRemoteDiagStatusListener) {
        this.mDiagStatusListener = onRemoteDiagStatusListener;
    }

    public void sendRemoteDiagStatue(int i) {
        this.mDiagStatusListener.OnRemoteDiagStatusCallback(i);
    }

    public DiagnoseLogicBusiness(DiagnoseBusiness diagnoseBusiness, Context context) {
        this.mDiagnoseBusiness = diagnoseBusiness;
        this.mContext = context;
    }

    public static DiagnoseLogicBusiness getInstance(DiagnoseBusiness diagnoseBusiness, Context context) {
        if (instance == null) {
            instance = new DiagnoseLogicBusiness(diagnoseBusiness, context);
        }
        return instance;
    }

    public void setOnDiagnoseJsonListener(OnDiagnoseJsonListener onDiagnoseJsonListener) {
        if (this.mDiagnoseJsonListener != onDiagnoseJsonListener) {
            this.mDiagnoseJsonListener = onDiagnoseJsonListener;
        }
    }

    public void backToPreviousLevel() {
        if (DiagnoseConstants.getDiagIdentity() != 0) {
            dealUIData(JsonUtils.sendWaitDialog(DiagnoseConstants.UI_TYPE_DIALOG, "90", this.mContext.getString(C1444R.string.dialog_wait_title), this.mContext.getString(C1444R.string.dialog_wait_content)));
        }
        if (DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_DATASTREAM) || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW) || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_MESSAGEBOX) || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_ARGING_WINDOW) || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM)) {
            DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH = "-1";
        } else if (DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_LOOPMODE)) {
            DiagnoseConstants.FEEDBACK_FAULTCODE_REFRESH = "-1";
        } else if (DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE) || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_ID_EX_STANDARDVALUE)) {
            DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_REFRESH = "7";
        } else {
            DiagnoseConstants.OLD_DIAG_FEEDBACK = ByteHexHelper.hexStringToBytes(DiagnoseConstants.FEEDBACK_PUBLIC_BACK);
            if (DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals("1") || DiagnoseConstants.FEEDBACK_PUBLIC_TYPE.equals("3")) {
                DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
            }
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_PUBLIC_TYPE, DiagnoseConstants.FEEDBACK_PUBLIC_BACK));
        }
    }

    public void switchPage(String str, String str2, int i) {
        this.mPageControl = str2;
        this.mCurrentPage = i;
    }

    public String pageStreamFeedbackMask(String str, String str2, int i) {
        int parseInt = Integer.parseInt(this.mDatastreamCount);
        String datastreamMask = getDatastreamMask(str2, (parseInt % DiagnoseConstants.DATASTREAM_PAGE == 0 ? 0 : 1) + (parseInt / DiagnoseConstants.DATASTREAM_PAGE), i);
        int dataStreamCount = getDataStreamCount(datastreamMask);
        String binaryString2hexString = ByteHexHelper.binaryString2hexString(datastreamMask);
        if (DiagnoseConstants.datastreamRecord && DiagnoseConstants.IS_START_RECORD_DATASTREAM) {
            str2 = "8";
            DiagnoseConstants.IS_START_RECORD_DATASTREAM = false;
        }
        return JsonUtils.cmdToJson(str, "0000" + ByteHexHelper.intToTwoHexBytes(String.valueOf(dataStreamCount)) + ByteHexHelper.intToHexBytes(str2) + ByteHexHelper.intToHexBytes(String.valueOf(binaryString2hexString.length() / 2)) + binaryString2hexString);
    }

    private String getDatastreamMask(String str, int i, int i2) {
        String str2;
        if (i2 < this.mMaskList.size()) {
            str2 = this.mMaskList.get(i2);
        } else {
            ArrayList<String> arrayList = this.mMaskList;
            str2 = arrayList.get(arrayList.size() - 1);
        }
        return (DiagnoseConstants.datastreamRecord || DiagnoseConstants.diagDataGather || DiagnoseConstants.isStudyDiag) ? DiagnoseConstants.DATASTREAM_MASK : str2;
    }

    private int getDataStreamCount(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '1') {
                i++;
            }
        }
        return i;
    }

    public void dealUIData(String str) {
        try {
            dealUIData(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dealUIData(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(VastExtensionXmlManager.TYPE);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(DataPacketExtension.ELEMENT_NAME));
            String string2 = jSONObject2.getString("ui_type");
            if (string2.equals(DiagnoseConstants.UI_TYPE_SET_VIN)) {
                try {
                    String upperCase = jSONObject2.getString("value").toUpperCase();
                    DiagnoseConstants.VIN_CODE = upperCase;
                    Intent intent = new Intent("SPT_SET_VIN");
                    intent.putExtra("SPT_SET_VIN", upperCase);
                    this.mContext.sendBroadcast(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.mDiagnoseJsonListener.onDiagnoseJsonCallback(string, jSONObject.toString());
            if (jSONObject.has("ver")) {
                DiagnoseConstants.SO_DIAG_VERSION = Integer.parseInt(jSONObject.getString("ver"));
            } else {
                DiagnoseConstants.SO_DIAG_VERSION = -1;
            }
            if (string.equals(DiagnoseConstants.UI_TYPE_DIALOG)) {
                dealAlertDialog(string2, jSONObject2);
            }
            if (this.mDiagnoseBusiness.isNewFrame()) {
                return;
            }
            if (string.equals("200")) {
                dealInputDialog(string2, jSONObject2);
            } else if (string.equals("300")) {
                dealMenu(string2, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_SELECT)) {
                dealSelectMenu(string2, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_ACTIVE_TEST)) {
                dealActiveTest(string2, jSONObject2);
            } else if (string.equals(DiagnoseConstants.UI_TYPE_FAULTCODE)) {
                dealFaultCode(string2, jSONObject2);
            } else {
                if (!string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM) && !string.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) && !string.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
                    if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION)) {
                        dealSpecialFunction(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_COMBINE_MENU)) {
                        dealCombineMenu(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_NO_UI_CMD)) {
                        dealNoUIFeedback(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_ARGING_WINDOW)) {
                        dealAgringWindow(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_GET_DIAGNOSE_RECORD)) {
                        dealDiagnoseRecord(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_PARALLEL_MENU)) {
                        dealParallelMenu(string2, jSONObject2);
                        return;
                    } else if (string.equals(DiagnoseConstants.UI_TYPE_PARALLEL_SUB_MENU)) {
                        return;
                    } else {
                        if (string.equals(DiagnoseConstants.UI_TYPE_SUB_FAULTCODE)) {
                            dealFaultCode(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_SUB_PAGE_DATASTREAM)) {
                            this.uiPageMask = false;
                            DiagnoseService.isRemoteUiPageMask = false;
                            dealDataStream(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_CURRENT_MENU_PATH)) {
                            dealCurrentMenuPath(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_DIAG_FUN_INFO)) {
                            if (string2.equals(DiagnoseConstants.UI_TYPE_DIAG_FUN_INFO)) {
                                String string3 = jSONObject2.getString("funnameid");
                                int i = jSONObject2.getInt("funtype");
                                int i2 = jSONObject2.getInt("funstatus");
                                if (i == 53 && DiagnoseConstants.VOLTAGE.equals(string3) && i2 == 0) {
                                    NLog.m9452b("DiagnoseLoagicBussiness", " DiagnoseConstants.isVoltageShow = true");
                                    DiagnoseConstants.isVoltageShow = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_SPECIAL_DATASTREAM)) {
                            dealSpecialDatastream(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_RESET_CARICON_MENU)) {
                            dealResetCarIconMenu(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_SELECT_FILEDIALOG)) {
                            dealSelectFileDialog(string2, jSONObject2);
                            return;
                        } else if (string.equals(DiagnoseConstants.UI_TYPE_MESSAGEBOX_TEXT_CUSTOMBUTTON)) {
                            dealMsgBoxWithCustomBtn(string2, jSONObject2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.uiPageMask = false;
                DiagnoseService.isRemoteUiPageMask = false;
                dealDataStream(string2, jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void dealSpecialDatastream(String str, JSONObject jSONObject) {
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPECIADATASTREAM;
        MemoryThread memoryThread = this.mMemoryThread;
        if (memoryThread == null) {
            this.mMemoryThread = new MemoryThread(this.mContext);
            this.mMemoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
            this.mMemoryThread.start();
        } else {
            memoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
        }
        resetReferencesCmd();
    }

    private void dealResetCarIconMenu(String str, JSONObject jSONObject) {
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
        MemoryThread memoryThread = this.mMemoryThread;
        if (memoryThread != null) {
            memoryThread.stopThread();
            this.mMemoryThread.clearCommandList();
            this.mMemoryThread = null;
        }
        int i = 0;
        try {
            i = jSONObject.getInt("item");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_RESET_CARICON_MENU;
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1" + String.valueOf(i);
        resetReferencesCmd();
    }

    private void dealCurrentMenuPath(String str, JSONObject jSONObject) {
        this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_CURRENT_MENU_PATH, "0"));
    }

    private void dealParallelMenu(String str, JSONObject jSONObject) {
        int i;
        try {
            i = jSONObject.getInt("item");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        String format = String.format("%1$s%2$s%3$s%4$s", -1, Integer.valueOf(i), 0, 0);
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_PARALLEL_MENU;
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = format;
        resetReferencesCmd();
    }

    private void dealDiagnoseRecord(String str, JSONObject jSONObject) {
        Log.e("bcf", "data: " + jSONObject.toString());
        this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson("63", "0"));
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.cnlaunch.diagnosemodule.DiagnoseLogicBusiness$1] */
    private void dealAlertDialog(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG_EXIT)) {
            DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = null;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = null;
            this.mDiagnoseBusiness.loadSoList(DiagnoseConstants.LOAD_SO_LIST);
            this.mContext.sendBroadcast(new Intent(DiagnoseConstants.DIAG_EXIT_BROADCAST));
            this.mDiagnoseBusiness.diagFinish(true);
            this.mDiagnoseBusiness.setDynamicEvent(null);
            this.mDiagnoseBusiness.setTpmsInfoEvent(null);
            deleteTempSo();
            DiagnoseLogUtil.getInstance().stopRecord();
        } else if (str.equals(DiagnoseConstants.UI_TYPE_GGP_NAME)) {
            DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_MESSAGEBOX, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DIALOG)) {
            if (DiagnoseConstants.getDiagIdentity() == 0) {
                new Thread() { // from class: com.cnlaunch.diagnosemodule.DiagnoseLogicBusiness.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            sleep(DiagnoseConstants.PROGRESS_DIALOG_DELAY);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DiagnoseLogicBusiness.this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson("0", "0"));
                    }
                }.start();
            } else if (DiagnoseConstants.getDiagIdentity() != 1) {
                this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson("0", "0"));
            }
        } else if (str.equals(DiagnoseConstants.UI_TYPE_NOWAITMESSAGEBOX) || str.equals(DiagnoseConstants.UI_TYPE_PROGRESSBAR)) {
            DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
            dealMessageBox(str, jSONObject);
        } else if (this.mClearDctDialog && str.equals(DiagnoseConstants.UI_TYPE_DIALOG_YES_NO)) {
            this.mClearDctDialog = false;
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson("6", "02"));
        }
    }

    private void dealSelectFileDialog(String str, JSONObject jSONObject) {
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
    }

    private void dealInputDialog(String str, JSONObject jSONObject) {
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
    }

    public void dealMenu(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_TYPE_MENU_AND_HELP_BTN_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_MENU_AND_HELP_BTN_ID;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_FILE_MENU_AND_HELP_BTN)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_FILE_MENU_AND_HELP_BTN;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_MENU2HD_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_MENU2HD_ID;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_MENU2HD_ID_EX)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = "90";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_GRAPH_MENU_AND_HELP_BTN_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_GRAPH_MENU_AND_HELP_BTN_ID;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_TOPOLOGY_MENU_AND_HELP_BTN_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_TOPOLOGY_MENU_AND_HELP_BTN_ID;
        } else {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = "1";
        }
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
        MemoryThread memoryThread = this.mMemoryThread;
        if (memoryThread != null) {
            memoryThread.stopThread();
            this.mMemoryThread.clearCommandList();
            this.mMemoryThread = null;
        }
        int i = 0;
        try {
            i = jSONObject.getInt("item");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_MENU_AND_HELP_BTN_ID) || str.equals(DiagnoseConstants.UI_TYPE_FILE_MENU_AND_HELP_BTN)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1" + ByteHexHelper.intToTwoHexString(i);
        } else if (str.equals(DiagnoseConstants.UI_TYPE_MENU2HD_ID) || str.equals(DiagnoseConstants.UI_TYPE_MENU2HD_ID_EX)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "00FFFF" + ByteHexHelper.intToTwoHexString(i) + "FFFF";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_GRAPH_MENU_AND_HELP_BTN_ID) || str.equals(DiagnoseConstants.UI_TYPE_TOPOLOGY_MENU_AND_HELP_BTN_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "00FFFF" + ByteHexHelper.intToTwoHexString(i);
        } else {
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1" + String.valueOf(i);
        }
        resetReferencesCmd();
        SystemClock.sleep(1000L);
        setDiagAutoRefresh(true);
    }

    private void dealSelectMenu(String str, JSONObject jSONObject) {
        MemoryThread memoryThread = this.mMemoryThread;
        if (memoryThread != null) {
            memoryThread.stopThread();
            this.mMemoryThread.clearCommandList();
            this.mMemoryThread = null;
        }
        setDiagAutoRefresh(true);
        String str2 = "";
        try {
            for (int i = 0; i < jSONObject.getJSONArray("menudata").length(); i++) {
                str2 = str2 + "0";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = "3";
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = str2;
        resetReferencesCmd();
    }

    private void dealActiveTest(String str, JSONObject jSONObject) {
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = "9";
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "00";
        if (isDiagAutoRefresh()) {
            MemoryThread memoryThread = this.mMemoryThread;
            if (memoryThread == null) {
                this.mMemoryThread = new MemoryThread(this.mContext);
                this.mMemoryThread.addDataInArrary(JsonUtils.cmdToJson("9", DiagnoseConstants.FEEDBACK_ACTIVE_TEST_NORMAL));
                this.mMemoryThread.start();
            } else {
                memoryThread.addDataInArrary(JsonUtils.cmdToJson("9", DiagnoseConstants.FEEDBACK_ACTIVE_TEST_NORMAL));
            }
        }
        resetReferencesCmd();
    }

    private void dealFaultCode(String str, JSONObject jSONObject) {
        String str2 = DiagnoseConstants.FEEDBACK_FAULTCODES;
        int i = 0;
        if (str.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_ACTIVE)) {
            str2 = DiagnoseConstants.FEEDBACK_FAULTCODES_ACTIVE;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_RETURN_VALUE)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_TROUBLE_CODE_ID_EX_RETURN_VALUE;
            try {
                i = jSONObject.getInt("item");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1" + String.valueOf(i);
            resetReferencesCmd();
            return;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_EXT1_TROUBLE_CODE_ID)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPT_STD_EXT1;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "00";
            resetReferencesCmd();
            return;
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_LOOPMODE) && isDiagAutoRefresh()) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.UI_TYPE_FAULTCODE_LOOPMODE;
            MemoryThread memoryThread = this.mMemoryThread;
            if (memoryThread == null) {
                this.mMemoryThread = new MemoryThread(this.mContext);
                this.mMemoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_FAULTCODES, DiagnoseConstants.FEEDBACK_FAULTCODE_REFRESH));
                this.mMemoryThread.start();
                return;
            }
            memoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_FAULTCODES, DiagnoseConstants.FEEDBACK_FAULTCODE_REFRESH));
        } else if (str.equals(DiagnoseConstants.UI_TYPE_SUB_FAULTCODE)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = "60";
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = String.format("%1$s%2$s%3$s", -1, 0, 1);
            resetReferencesCmd();
        } else {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = str2;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = DiagnoseConstants.FEEDBACK_FAULTCODE_BACK;
            resetReferencesCmd();
        }
    }

    private void dealDataStream(String str, JSONObject jSONObject) {
        if (str.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) || str.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
            try {
                this.mDatastreamPageCount = jSONObject.getString("pagecount");
                this.mDatastreamCount = jSONObject.getString("count");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_SUB_PAGE_DATASTREAM)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_PARALLEL_DATASTREAM;
        } else if (str.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_DATASTREAM_VW;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "7";
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_DATASTREAM_ID_EX_STANDARDVALUE;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "7";
        } else {
            DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_DATASTREAM;
            DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "-1";
        }
        boolean z = false;
        if (this.mMemoryThread == null) {
            this.mMemoryThread = new MemoryThread(this.mContext);
            z = true;
        }
        if (this.mMemoryThread != null) {
            if (str.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
                if (this.mPageControl.equals("7") || this.mPageControl.equals("9") || this.mPageControl.equals("8")) {
                    this.mMemoryThread.addDataInArrary(pageStreamFeedbackMask(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, this.mPageControl, this.mCurrentPage));
                    this.mPageControl = "0";
                } else {
                    this.mMemoryThread.addDataInArrary(pageStreamFeedbackMask(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_REFRESH, this.mCurrentPage));
                }
            } else if (str.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
                if (this.mPageControl.equals("7") || this.mPageControl.equals("9") || this.mPageControl.equals("8")) {
                    this.mMemoryThread.addDataInArrary(pageStreamFeedbackMask(DiagnoseConstants.FEEDBACK_DATASTREAM_ID_EX_STANDARDVALUE, this.mPageControl, this.mCurrentPage));
                    this.mPageControl = "0";
                } else {
                    this.mMemoryThread.addDataInArrary(pageStreamFeedbackMask(DiagnoseConstants.FEEDBACK_DATASTREAM_ID_EX_STANDARDVALUE, DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_REFRESH, this.mCurrentPage));
                }
            } else if (str.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.mDiagnoseBusiness.feedbackPotting(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_DATASTREAM, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
            } else {
                this.mMemoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_DATASTREAM, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
            }
            if (z) {
                if (DiagnoseConstants.isStudyDiag) {
                    this.mMemoryThread.setSleepTime(100);
                }
                this.mMemoryThread.start();
            } else if (DiagnoseConstants.isStudyDiag && this.mMemoryThread.getSleepTime() != 1) {
                this.mMemoryThread.setSleepTime(1);
            }
        }
        resetReferencesCmd();
    }

    private void printDatastreamTime() {
        if (this.dataStreamStartTime == 0) {
            this.dataStreamStartTime = System.currentTimeMillis();
        }
        this.dataStreamStartTime = System.currentTimeMillis() - this.dataStreamStartTime;
        C1856n.m8127b("bcf", "与上帧数据流相差: [" + this.dataStreamStartTime + "]毫秒");
        this.dataStreamStartTime = System.currentTimeMillis();
    }

    private void dealMsgBoxWithCustomBtn(String str, JSONObject jSONObject) {
        DiagnoseConstants.OLD_DIAG_FEEDBACK = null;
    }

    private void dealSpecialFunction(String str, JSONObject jSONObject) {
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION;
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "0000";
        if (this.mDiagnoseBusiness.isClickClearDCT()) {
            C1856n.m8130a("golox", "点击清码按钮");
            this.mDiagnoseBusiness.feedbackPotting(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION, "0001"));
            this.mDiagnoseBusiness.setAutoCleanDCT(false);
            this.mClearDctDialog = true;
        } else {
            this.mDiagnoseBusiness.feedbackPotting(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION, DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION_REFRESH));
        }
        resetReferencesCmd();
    }

    private void dealCombineMenu(String str, JSONObject jSONObject) {
        resetReferencesCmd();
    }

    private void dealNoUIFeedback(String str, JSONObject jSONObject) {
        String str2 = "";
        try {
            if (jSONObject.has("cmd")) {
                str2 = jSONObject.getString("cmd");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_NO_UI_CMD)) {
            dealUIData(JsonUtils.sendWaitDialog(DiagnoseConstants.UI_TYPE_DIALOG, "90", this.mContext.getString(C1444R.string.dialog_wait_title), this.mContext.getString(C1444R.string.dialog_wait_content)));
            SystemClock.sleep(500L);
            String binaryString2hexString = ((DiagnoseService.diagnoseStatue == 0 || DiagnoseConstants.isWebRemote) && !DiagnoseService.isRemoteUiPageMask) ? ByteHexHelper.binaryString2hexString(setRemotePageMask(ByteHexHelper.hexString2binaryString(str2))) : str2;
            if (this.uiPageMask) {
                binaryString2hexString = ByteHexHelper.binaryString2hexString(setPageMask(ByteHexHelper.hexString2binaryString(str2)));
            }
            if (DiagnoseConstants.isStudyDiag) {
                binaryString2hexString = str2;
            }
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_MASK, binaryString2hexString));
        } else if (str.equals(DiagnoseConstants.UI_TYPE_DISPLAY_VERSION)) {
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_DISPLAY_VERSION, ByteHexHelper.bin2hex(PhysicsCommonUtils.m8116a(this.mContext))));
        } else if (str.equals(DiagnoseConstants.UI_TYPE_GET_DEVICE_DISTRICT)) {
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.UI_TYPE_GET_DEVICE_DISTRICT, String.valueOf(AndroidToLan.getDeviceAreaID(DiagnoseConstants.LOCAL_LANGUAGE.getCountry()))));
        } else if (!str.equals(DiagnoseConstants.UI_TYPE_GET_VIN) && !str.equals(DiagnoseConstants.UI_TYPE_SET_VIN) && !str.equals(DiagnoseConstants.UI_HIS_RECORD)) {
            this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson("0", str2));
        }
        resetReferencesCmd();
    }

    private void dealAgringWindow(String str, JSONObject jSONObject) {
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_ARGING_WINDOW;
        DiagnoseConstants.FEEDBACK_PUBLIC_BACK = "1";
        this.mDiagnoseBusiness.sendFeedbackCommand(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_ARGING_WINDOW, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
        resetReferencesCmd();
    }

    private void dealMessageBox(String str, JSONObject jSONObject) {
        DiagnoseConstants.FEEDBACK_PUBLIC_TYPE = DiagnoseConstants.FEEDBACK_MESSAGEBOX;
        if (isDiagAutoRefresh()) {
            MemoryThread memoryThread = this.mMemoryThread;
            if (memoryThread == null) {
                this.mMemoryThread = new MemoryThread(this.mContext);
                this.mMemoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_MESSAGEBOX, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
                this.mMemoryThread.start();
                return;
            }
            memoryThread.addDataInArrary(JsonUtils.cmdToJson(DiagnoseConstants.FEEDBACK_MESSAGEBOX, DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH));
        }
    }

    public boolean isDiagAutoRefresh() {
        return this.mDiagAutoRefresh;
    }

    public void setDiagAutoRefresh(boolean z) {
        this.mDiagAutoRefresh = z;
    }

    public MemoryThread getMemoryThread() {
        return this.mMemoryThread;
    }

    private void resetReferencesCmd() {
        DiagnoseConstants.FEEDBACK_DATASTREAM_REFRESH = "0";
        DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE_REFRESH = "0";
        DiagnoseConstants.FEEDBACK_FAULTCODE_REFRESH = "0";
        DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION_REFRESH = "-1";
        DiagnoseConstants.FEEDBACK_ACTIVE_TEST_NORMAL = "-1";
    }

    public String setPageMask(ArrayList<String> arrayList) {
        this.uiPageMask = true;
        dealUIData(JsonUtils.sendWaitDialog(DiagnoseConstants.UI_TYPE_DIALOG, "90", this.mContext.getString(C1444R.string.dialog_wait_title), this.mContext.getString(C1444R.string.dialog_wait_content)));
        this.mCurrentPage = 0;
        this.mMaskList.clear();
        this.mMaskList = arrayList;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mMaskList.get(0).toString());
        for (int i = 0; i < this.mMaskList.size(); i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mMaskList.get(i));
            for (int i2 = 0; i2 < sb2.length(); i2++) {
                if (sb2.charAt(i2) == '1') {
                    sb.setCharAt(i2, '1');
                }
            }
        }
        DiagnoseConstants.DATASTREAM_MASK = sb.toString();
        return this.mMaskList.get(0);
    }

    public String setPageMask(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '1') {
                i++;
            }
        }
        DiagnoseConstants.DATASTREAM_MASK = str;
        Intent intent = new Intent("UpdateDatastreamCount");
        intent.putExtra("count", i);
        this.mContext.sendBroadcast(intent);
        return this.mMaskList.get(0);
    }

    public String setRemotePageMask(String str) {
        DiagnoseService.isRemoteUiPageMask = true;
        dealUIData(JsonUtils.sendWaitDialog(DiagnoseConstants.UI_TYPE_DIALOG, "90", this.mContext.getString(C1444R.string.dialog_wait_title), this.mContext.getString(C1444R.string.dialog_wait_content)));
        this.mCurrentPage = 0;
        this.mMaskList.clear();
        int length = str.length();
        initMaskBuilder(length);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '1') {
                setInitMask(length, i2, i2, true);
            } else {
                setInitMask(length, i2, i2, false);
            }
            if (str.charAt(i2) == '1') {
                i++;
            }
        }
        for (int i3 = 0; i3 < this.mMaskList.size(); i3++) {
        }
        DiagnoseConstants.DATASTREAM_MASK = str;
        Intent intent = new Intent("UpdateDatastreamCount");
        intent.putExtra("count", i);
        this.mContext.sendBroadcast(intent);
        return this.mMaskList.get(0);
    }

    private void setInitMask(int i, int i2, int i3, boolean z) {
        if (z) {
            this.mMaskCount++;
            this.mMaskStr.setCharAt(i2, '1');
        }
        if (i3 < i && this.mMaskCount == DiagnoseConstants.DATASTREAM_PAGE) {
            this.mMaskList.add(this.mMaskStr.toString());
        } else if (i3 < i - 1) {
            return;
        } else {
            if (this.mMaskStr.toString().contains("1")) {
                this.mMaskList.add(this.mMaskStr.toString());
            }
        }
        this.mMaskCount = 0;
        initMaskBuilder(i);
    }

    private void initMaskBuilder(int i) {
        StringBuilder sb = this.mMaskStr;
        sb.delete(0, sb.length());
        for (int i2 = 0; i2 < i; i2++) {
            this.mMaskStr.append("0");
        }
    }

    private String getZeroMask(int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + 0;
        }
        return str;
    }

    public void deleteTempSo() {
        String str;
        try {
            str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null) {
            CopyFile.delectFile(str + "/libs/cnlaunch/");
        }
    }
}
