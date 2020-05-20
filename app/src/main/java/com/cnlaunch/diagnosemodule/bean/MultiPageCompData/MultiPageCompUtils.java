package com.cnlaunch.diagnosemodule.bean.MultiPageCompData;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.cnlaunch.diagnosemodule.JsonConstText;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.bean.MultiPageCompData.BasicPageBean;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class MultiPageCompUtils {
    private static MultiPageCompUtils instance;
    private byte[] htmlJsRet;
    private OnDiagnoseDataListener mIDiagnoseDataCallback;
    private Messenger mService;
    private HashMap<Integer, BasicPageBean> arrPageBean = new HashMap<>();
    private int currPageSn = 0;
    private int currUIPageSn = 0;
    private boolean bKeyCode_BackOnclick = false;

    public static MultiPageCompUtils getInstance() {
        if (instance == null) {
            instance = new MultiPageCompUtils();
        }
        return instance;
    }

    public byte[] getHtmlJsRet() {
        return this.htmlJsRet;
    }

    public void setHtmlJsRet(byte[] bArr) {
        this.htmlJsRet = bArr;
    }

    public void setCallbackListener(OnDiagnoseDataListener onDiagnoseDataListener) {
        this.mIDiagnoseDataCallback = onDiagnoseDataListener;
    }

    public void setmService(Messenger messenger) {
        this.mService = messenger;
    }

    public void setbKeyCode_BackOnclick(boolean z) {
        this.bKeyCode_BackOnclick = z;
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

    public HashMap<Integer, BasicPageBean> getArrPageBean() {
        return this.arrPageBean;
    }

    public int getCurrPageSn() {
        return this.currPageSn;
    }

    public void setCurrUIPageSn(int i) {
        this.currUIPageSn = i;
    }

    public int getCurrUIPageSn() {
        return this.currUIPageSn;
    }

    public void setCurrPageSn(int i) {
        this.currPageSn = i;
    }

    public void dealWithMultiPageCompData(JSONObject jSONObject) {
        BasicPageBean.PageModule pageModule;
        try {
            int i = jSONObject.getInt(JsonConstText.Const_Text_Label);
            int i2 = 0;
            if (i != 63) {
                switch (i) {
                    case 1:
                        if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                            JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                            while (i2 < jSONArray.length()) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                BasicPageBean basicPageBean = new BasicPageBean();
                                basicPageBean.setPageSn(i2);
                                basicPageBean.setTitle(jSONObject2.getString(JsonConstText.Const_Text_Title));
                                this.arrPageBean.put(Integer.valueOf(i2), basicPageBean);
                                i2++;
                            }
                            break;
                        }
                        break;
                    case 2:
                        setCurrPageSn(jSONObject.getInt(JsonConstText.Const_Text_SN));
                        if (getCurrUIPageSn() == 0) {
                            setCurrUIPageSn(jSONObject.getInt(JsonConstText.Const_Text_SN));
                            break;
                        }
                        break;
                    case 3:
                        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, (byte) (255 & getCurrUIPageSn())});
                        return;
                    default:
                        switch (i) {
                            case 17:
                                if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                                    JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                    ArrayList<BasicPageBean.PageModule> arrPageModule = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getArrPageModule();
                                    while (i2 < jSONArray2.length()) {
                                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                                        BasicPageBean.PageModule pageModule2 = new BasicPageBean.PageModule();
                                        pageModule2.setModuleSn(jSONObject3.getInt(JsonConstText.Const_Text_SN));
                                        pageModule2.setModuleAtt(jSONObject3.getInt(JsonConstText.Const_Text_Label));
                                        pageModule2.setHorizontalRadios(jSONObject3.getInt(JsonConstText.Const_Text_Rows));
                                        pageModule2.setVerticalRadios(jSONObject3.getInt(JsonConstText.Const_Text_Colums));
                                        arrPageModule.add(pageModule2);
                                        i2++;
                                    }
                                    break;
                                }
                                break;
                            case 18:
                                int i3 = jSONObject.getInt(JsonConstText.Const_Text_SN);
                                Iterator<BasicPageBean.PageModule> it = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getArrPageModule().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        BasicPageBean.PageModule next = it.next();
                                        pageModule = next.getModuleSn() == i3 ? next : null;
                                    }
                                }
                                if (pageModule != null) {
                                    BasicPageCompBean basicPageCompBean = new BasicPageCompBean();
                                    int i4 = jSONObject.getInt(JsonConstText.Const_Text_ComPin);
                                    if (!pageModule.getArrPageCompSn().contains(Integer.valueOf(i4))) {
                                        pageModule.getArrPageCompSn().add(Integer.valueOf(i4));
                                    }
                                    basicPageCompBean.setSn(i4);
                                    basicPageCompBean.setCompType(jSONObject.getInt(JsonConstText.Const_Text_CMDType));
                                    basicPageCompBean.setHorizontalRadios(jSONObject.getInt(JsonConstText.Const_Text_Rows));
                                    basicPageCompBean.setVerticalRadios(jSONObject.getInt(JsonConstText.Const_Text_Colums));
                                    basicPageCompBean.setHorizontalSplitRadios(jSONObject.getInt(JsonConstText.Const_Text_Split));
                                    basicPageCompBean.setVerticalSplitRadios(jSONObject.getInt(JsonConstText.Const_Text_Scale));
                                    this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().put(Integer.valueOf(i4), basicPageCompBean);
                                    break;
                                }
                                break;
                            default:
                                switch (i) {
                                    case 33:
                                        this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN))).setCompAttributes(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt));
                                        break;
                                    case 34:
                                        BasicPageCompBean basicPageCompBean2 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        basicPageCompBean2.setKeyAttributes(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt));
                                        basicPageCompBean2.setTitle(jSONObject.getString(JsonConstText.Const_Text_Content));
                                        break;
                                    case 35:
                                        BasicPageCompBean basicPageCompBean3 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        basicPageCompBean3.setTextAttributes(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt));
                                        basicPageCompBean3.setTitle(jSONObject.getString(JsonConstText.Const_Text_Content));
                                        break;
                                    case 36:
                                        BasicPageCompBean basicPageCompBean4 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        basicPageCompBean4.setContent(jSONObject.getString(JsonConstText.Const_Text_default));
                                        if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                                            JSONArray jSONArray3 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                            while (i2 < jSONArray3.length()) {
                                                basicPageCompBean4.getArrCombInput().add(jSONArray3.getJSONObject(i2).getString(JsonConstText.Const_Text_Content));
                                                i2++;
                                            }
                                            break;
                                        }
                                        break;
                                    case 37:
                                        BasicPageCompBean basicPageCompBean5 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        int i5 = jSONObject.getInt(JsonConstText.Const_Text_Rows);
                                        int i6 = jSONObject.getInt(JsonConstText.Const_Text_Colums);
                                        basicPageCompBean5.setRowsForList(i5);
                                        basicPageCompBean5.setColumsForList(i6);
                                        if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                                            JSONArray jSONArray4 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                            for (int i7 = 0; i7 < jSONArray4.length(); i7++) {
                                                JSONObject jSONObject4 = jSONArray4.getJSONObject(i7);
                                                basicPageCompBean5.getArrTitleScaleForList().add(Integer.valueOf(jSONObject4.getInt(JsonConstText.Const_Text_Scale)));
                                                basicPageCompBean5.getArrTitleForList().add(jSONObject4.getString(JsonConstText.Const_Text_Content));
                                            }
                                        }
                                        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
                                        for (int i8 = 0; i8 < i5; i8++) {
                                            ArrayList<Integer> arrayList2 = new ArrayList<>();
                                            for (int i9 = 0; i9 < i6; i9++) {
                                                arrayList2.add(0);
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                        basicPageCompBean5.setItemTextAtt(arrayList);
                                        ArrayList<ArrayList<String>> arrayList3 = new ArrayList<>();
                                        for (int i10 = 0; i10 < i5; i10++) {
                                            ArrayList<String> arrayList4 = new ArrayList<>();
                                            for (int i11 = 0; i11 < i6; i11++) {
                                                arrayList4.add("");
                                            }
                                            arrayList3.add(arrayList4);
                                        }
                                        basicPageCompBean5.setItemContent(arrayList3);
                                        break;
                                    case 38:
                                        BasicPageCompBean basicPageCompBean6 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        basicPageCompBean6.getItemContent().get(jSONObject.getInt(JsonConstText.Const_Text_Rows)).set(jSONObject.getInt(JsonConstText.Const_Text_Colums), jSONObject.getString(JsonConstText.Const_Text_Content));
                                        basicPageCompBean6.getItemTextAtt().get(jSONObject.getInt(JsonConstText.Const_Text_Rows)).set(jSONObject.getInt(JsonConstText.Const_Text_Colums), Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt)));
                                        break;
                                    case 39:
                                        BasicPageCompBean basicPageCompBean7 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        basicPageCompBean7.setSliderValue(jSONObject.getInt(JsonConstText.Const_Text_Value));
                                        basicPageCompBean7.setSliderMax(jSONObject.getInt(JsonConstText.Const_Text_Maxdata));
                                        basicPageCompBean7.setSliderMin(jSONObject.getInt(JsonConstText.Const_Text_Mindata));
                                        basicPageCompBean7.setSliderStep(jSONObject.getInt(JsonConstText.Const_Text_Model));
                                        basicPageCompBean7.setSliderTimes(jSONObject.getInt(JsonConstText.Const_Text_Scale));
                                        break;
                                    case 40:
                                        BasicPageCompBean basicPageCompBean8 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                        int i12 = jSONObject.getInt(JsonConstText.Const_Text_Value);
                                        int i13 = jSONObject.getInt(JsonConstText.Const_Text_Mindata);
                                        if (!basicPageCompBean8.getMapNodeSn2treeBean().containsKey(Integer.valueOf(i12))) {
                                            BasicMultiPageTreeBean basicMultiPageTreeBean = new BasicMultiPageTreeBean();
                                            basicMultiPageTreeBean.setNodeSn(i12);
                                            basicPageCompBean8.getMapNodeSn2treeBean().put(Integer.valueOf(i12), basicMultiPageTreeBean);
                                        }
                                        if (!basicPageCompBean8.getMapNodeSn2treeBean().containsKey(Integer.valueOf(i13))) {
                                            BasicMultiPageTreeBean basicMultiPageTreeBean2 = new BasicMultiPageTreeBean();
                                            basicMultiPageTreeBean2.setNodeSn(i13);
                                            basicPageCompBean8.getMapNodeSn2treeBean().put(Integer.valueOf(i13), basicMultiPageTreeBean2);
                                        }
                                        ArrayList<Integer> arrayList5 = basicPageCompBean8.getMapFather2Child().get(Integer.valueOf(i12));
                                        if (arrayList5 == null) {
                                            ArrayList<Integer> arrayList6 = new ArrayList<>();
                                            arrayList6.add(Integer.valueOf(i13));
                                            basicPageCompBean8.getMapFather2Child().put(Integer.valueOf(i12), arrayList6);
                                            break;
                                        } else if (!arrayList5.contains(Integer.valueOf(i13))) {
                                            arrayList5.add(Integer.valueOf(i13));
                                            break;
                                        }
                                        break;
                                    case 41:
                                        BasicMultiPageTreeBean basicMultiPageTreeBean3 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN))).getMapNodeSn2treeBean().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_Item)));
                                        if (basicMultiPageTreeBean3 != null) {
                                            basicMultiPageTreeBean3.setNodeType(jSONObject.getInt(JsonConstText.Const_Text_Funtype));
                                            basicMultiPageTreeBean3.setNodeAttribute(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt));
                                            basicMultiPageTreeBean3.setTextAttribute(jSONObject.getInt(JsonConstText.Const_Text_Level));
                                            basicMultiPageTreeBean3.setText(jSONObject.getString(JsonConstText.Const_Text_Content));
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 43:
                                                this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN))).setValueProgressBar(jSONObject.getInt(JsonConstText.Const_Text_CMDAtt));
                                                break;
                                            case 44:
                                                parType0x2cDataForgForMultiPage(jSONObject);
                                                break;
                                            default:
                                                switch (i) {
                                                    case 48:
                                                        if (this.mIDiagnoseDataCallback != null) {
                                                            this.mIDiagnoseDataCallback.ShowMultiPageData();
                                                            break;
                                                        }
                                                        break;
                                                    case 49:
                                                    case 50:
                                                    case 51:
                                                    case 52:
                                                        if (this.bKeyCode_BackOnclick) {
                                                            retDefaultDataToDiagnose();
                                                            this.bKeyCode_BackOnclick = false;
                                                            return;
                                                        }
                                                        ArrayList<Integer> arrayList7 = new ArrayList<>();
                                                        if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                                                            JSONArray jSONArray5 = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                                                            while (i2 < jSONArray5.length()) {
                                                                arrayList7.add(Integer.valueOf(jSONArray5.getJSONObject(i2).getInt(JsonConstText.Const_Text_SN)));
                                                                i2++;
                                                            }
                                                        }
                                                        returnData2DiagForMultiPage(i, arrayList7);
                                                        return;
                                                    case 53:
                                                        if (this.bKeyCode_BackOnclick) {
                                                            retDefaultDataToDiagnose();
                                                            this.bKeyCode_BackOnclick = false;
                                                            return;
                                                        }
                                                        BasicPageCompBean basicPageCompBean9 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                                        int currNodeSNStatus = basicPageCompBean9.getCurrNodeSNStatus();
                                                        int currNodeSn = basicPageCompBean9.getCurrNodeSn();
                                                        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 4, (byte) (jSONObject.getInt(JsonConstText.Const_Text_SN) & 255), (byte) ((currNodeSn >> 8) & 255), (byte) (currNodeSn & 255), (byte) (currNodeSNStatus & 255)});
                                                        basicPageCompBean9.setCurrNodeSn(0);
                                                        basicPageCompBean9.setCurrNodeSNStatus(0);
                                                        return;
                                                    case 54:
                                                        if (this.bKeyCode_BackOnclick) {
                                                            retDefaultDataToDiagnose();
                                                            this.bKeyCode_BackOnclick = false;
                                                            return;
                                                        }
                                                        int testPlanRetDiagBtnSN = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN))).getTestPlanRetDiagBtnSN();
                                                        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, (byte) (jSONObject.getInt(JsonConstText.Const_Text_SN) & 255), (byte) ((testPlanRetDiagBtnSN >> 8) & 255), (byte) (testPlanRetDiagBtnSN & 255)});
                                                        this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN))).setTestPlanRetDiagBtnSN(0);
                                                        return;
                                                    case 55:
                                                        if (this.bKeyCode_BackOnclick) {
                                                            retDefaultDataToDiagnose();
                                                            this.bKeyCode_BackOnclick = false;
                                                            return;
                                                        } else if (getHtmlJsRet() != null) {
                                                            SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, getHtmlJsRet());
                                                            return;
                                                        } else {
                                                            SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 3});
                                                            return;
                                                        }
                                                    default:
                                                        switch (i) {
                                                            case 241:
                                                                int i14 = jSONObject.getInt(JsonConstText.Const_Text_SN);
                                                                if (i14 == 255) {
                                                                    this.arrPageBean.clear();
                                                                } else {
                                                                    this.arrPageBean.remove(Integer.valueOf(i14));
                                                                }
                                                                setCurrUIPageSn(0);
                                                                break;
                                                            case 242:
                                                                int i15 = jSONObject.getInt(JsonConstText.Const_Text_SN);
                                                                ArrayList<BasicPageBean.PageModule> arrPageModule2 = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getArrPageModule();
                                                                int i16 = 0;
                                                                while (true) {
                                                                    if (i16 >= arrPageModule2.size()) {
                                                                        break;
                                                                    } else {
                                                                        BasicPageBean.PageModule pageModule3 = arrPageModule2.get(i16);
                                                                        if (pageModule3.getModuleSn() == i15) {
                                                                            while (i2 < pageModule3.getArrPageCompSn().size()) {
                                                                                this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().remove(pageModule3.getArrPageCompSn().get(i2));
                                                                                i2++;
                                                                            }
                                                                            arrPageModule2.remove(pageModule3);
                                                                            break;
                                                                        } else {
                                                                            i16++;
                                                                        }
                                                                    }
                                                                }
                                                            case WKSRecord.Service.SUR_MEAS /* 243 */:
                                                                this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().remove(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
                                                                break;
                                                        }
                                                        break;
                                                }
                                        }
                                }
                        }
                }
                retDefaultDataToDiagnose();
            } else if (!this.bKeyCode_BackOnclick) {
                SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
            } else {
                retDefaultDataToDiagnose();
                this.bKeyCode_BackOnclick = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parType0x2cDataForgForMultiPage(JSONObject jSONObject) {
        try {
            BasicPageCompBean basicPageCompBean = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp().get(Integer.valueOf(jSONObject.getInt(JsonConstText.Const_Text_SN)));
            BasicTestPlanBean basicTestPlanBean = new BasicTestPlanBean();
            if (jSONObject.has(JsonConstText.Const_Text_Data)) {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonConstText.Const_Text_Data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    basicTestPlanBean.getArrTitle().add(jSONObject2.getString(JsonConstText.Const_Text_Title));
                    basicTestPlanBean.getArrTitleScale().add(Integer.valueOf(jSONObject2.getInt(JsonConstText.Const_Text_Scale)));
                }
            }
            if (jSONObject.has(JsonConstText.Const_Text_Menudata)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(JsonConstText.Const_Text_Menudata);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                    JSONArray jSONArray3 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Data);
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        arrayList.add(jSONArray3.getJSONObject(i3).getString(JsonConstText.Const_Text_Content));
                    }
                    basicTestPlanBean.getArrItem().add(arrayList);
                    JSONArray jSONArray4 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Accdata);
                    ArrayList<BasicSystemStatusBean> arrayList2 = new ArrayList<>();
                    for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                        JSONObject jSONObject4 = jSONArray4.getJSONObject(i4);
                        BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                        basicSystemStatusBean.setSystemName(jSONObject4.getString(JsonConstText.Const_Text_Title));
                        JSONArray jSONArray5 = jSONObject4.getJSONArray(JsonConstText.Const_Text_Data);
                        for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                            JSONObject jSONObject5 = jSONArray5.getJSONObject(i5);
                            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                            basicFaultCodeBean.setTitle(jSONObject5.getString(JsonConstText.Const_Text_Title));
                            basicFaultCodeBean.setContext(jSONObject5.getString(JsonConstText.Const_Text_Content));
                            basicFaultCodeBean.setStatus(jSONObject5.getString(JsonConstText.Const_Text_Status));
                            basicSystemStatusBean.getSystemFaultCodeBean().add(basicFaultCodeBean);
                        }
                        arrayList2.add(basicSystemStatusBean);
                    }
                    basicTestPlanBean.getArrItemSys().add(arrayList2);
                    JSONArray jSONArray6 = jSONObject3.getJSONArray(JsonConstText.Const_Text_Buttondata);
                    ArrayList<BasicButtonBean> arrayList3 = new ArrayList<>();
                    for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                        JSONObject jSONObject6 = jSONArray6.getJSONObject(i6);
                        BasicButtonBean basicButtonBean = new BasicButtonBean();
                        StringBuilder sb = new StringBuilder();
                        sb.append(jSONObject6.getInt(JsonConstText.Const_Text_SN));
                        basicButtonBean.setCommand(sb.toString());
                        basicButtonBean.setTitle(jSONObject6.getString(JsonConstText.Const_Text_Title));
                        arrayList3.add(basicButtonBean);
                    }
                    basicTestPlanBean.getArrItemBtn().add(arrayList3);
                }
            }
            basicPageCompBean.setTestPlanBean(basicTestPlanBean);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean returnData2DiagForMultiPage(int i, ArrayList<Integer> arrayList) {
        HashMap<Integer, BasicPageCompBean> mapCompSn2Comp = this.arrPageBean.get(Integer.valueOf(this.currPageSn)).getMapCompSn2Comp();
        if (49 == i) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int i3 = 0;
                if (mapCompSn2Comp.get(arrayList.get(i2)) != null) {
                    i3 = Integer.valueOf(mapCompSn2Comp.get(arrayList.get(i2)).getBtnClickStatus());
                    if (((mapCompSn2Comp.get(arrayList.get(i2)).getCompAttributes() & BasicPageCompBean.STDD_COMPBUTT_PUSH) >> 3) != 1) {
                        mapCompSn2Comp.get(arrayList.get(i2)).setBtnClickStatus(0);
                    }
                }
                arrayList2.add(i3);
            }
            returnArrIntegerToDiagnose(arrayList, arrayList2, true);
            return true;
        } else if (i == 50) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                String str = "";
                if (mapCompSn2Comp.get(arrayList.get(i4)) != null) {
                    str = mapCompSn2Comp.get(arrayList.get(i4)).getContent();
                }
                arrayList3.add(str);
            }
            returnArrStringToDiagnose(arrayList, arrayList3);
            return true;
        } else if (51 == i) {
            ArrayList<Integer> arrayList4 = new ArrayList<>();
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                Integer valueOf = Integer.valueOf((int) NTLMConstants.FLAG_NEGOTIATE_56_BIT_ENCRYPTION);
                if (mapCompSn2Comp.get(arrayList.get(i5)) != null) {
                    valueOf = Integer.valueOf(mapCompSn2Comp.get(arrayList.get(i5)).getSliderValue());
                }
                arrayList4.add(valueOf);
            }
            returnArrIntegerToDiagnose(arrayList, arrayList4, false);
            return true;
        } else if (52 == i) {
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                int i7 = 0;
                if (mapCompSn2Comp.get(arrayList.get(i6)) != null) {
                    i7 = Integer.valueOf(mapCompSn2Comp.get(arrayList.get(i6)).isCombChecked() ? 1 : 0);
                }
                arrayList5.add(i7);
            }
            returnArrIntegerToDiagnose(arrayList, arrayList5, true);
            return true;
        } else {
            return false;
        }
    }

    private void returnArrStringToDiagnose(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        int i;
        int size = arrayList2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                i2 += arrayList2.get(i3).getBytes().length + 1;
            } catch (Exception e) {
                e.printStackTrace();
                i2++;
            }
        }
        int i4 = i2 + size + 1;
        byte[] bArr = new byte[i4 + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i4 >> 8) & 255);
        bArr[2] = (byte) (i4 & 255);
        bArr[3] = (byte) (size & 255);
        int i5 = 4;
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = i5 + 1;
            bArr[i5] = (byte) (arrayList.get(i6).intValue() & 255);
            if (arrayList2.get(i6) != null) {
                try {
                    byte[] bytes = arrayList2.get(i6).getBytes();
                    i = bytes.length;
                    System.arraycopy(bytes, 0, bArr, i7, i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i = 0;
                }
            } else {
                i = 0;
            }
            bArr[i7 + i] = 0;
            i5 = i7 + i + 1;
        }
        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, bArr);
    }

    private void returnArrIntegerToDiagnose(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, boolean z) {
        int size = arrayList2.size();
        int i = (z ? size : size * 2) + size + 1;
        byte[] bArr = new byte[i + 3];
        bArr[0] = 0;
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[2] = (byte) (i & 255);
        int i2 = 4;
        bArr[3] = (byte) (size & 255);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) (arrayList.get(i3).intValue() & 255);
            if (z) {
                i2 = i4 + 1;
                bArr[i4] = (byte) (arrayList2.get(i3).intValue() & 255);
            } else {
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((arrayList2.get(i3).intValue() >> 24) & 255);
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((arrayList2.get(i3).intValue() >> 16) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((arrayList2.get(i3).intValue() >> 8) & 255);
                bArr[i7] = (byte) (arrayList2.get(i3).intValue() & 255);
                i2 = i7 + 1;
            }
        }
        SendByteDataFeedbackMessage(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, bArr);
    }
}
