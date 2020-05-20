package com.cnlaunch.diagnosemodule.listener;

import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicInputBean;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicQueryWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpecMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicVehicleData;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface OnDiagnoseDataListener {
    void ShowMultiPageData();

    void ShowTopViewData(int i);

    void onDiagCallService(String str, String str2);

    void onDiagnoseActiveTestDataCallback(String str, String str2, ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicButtonBean> arrayList2, int i);

    void onDiagnoseAddressPath(ArrayList<BasicBean> arrayList);

    void onDiagnoseAlertDialog(String str, String str2, String str3);

    void onDiagnoseArgingWindowCallback(String str, String str2);

    void onDiagnoseChannelWindows(String str, BasicBean basicBean);

    void onDiagnoseCombineMenu(String str, String str2, int i, ArrayList<BasicCombineMenuBean> arrayList, int i2);

    void onDiagnoseCustomListFunction(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3, String str2, int i, int i2, int i3);

    void onDiagnoseDatastreamCallback(String str, ArrayList<BasicDataStreamBean> arrayList, String str2, String str3, String str4);

    void onDiagnoseDatastreamSelectMenuDataCallback(String str, ArrayList<BasicSelectMenuBean> arrayList, boolean z);

    void onDiagnoseFaultCodeDataCallback(String str, ArrayList<BasicFaultCodeBean> arrayList, ArrayList<BasicButtonBean> arrayList2);

    void onDiagnoseFeedback();

    void onDiagnoseGetData(String str, String str2);

    void onDiagnoseGetNewVehicleData(String str, boolean z, int i, ArrayList<BasicVehicleData> arrayList);

    void onDiagnoseHDMenuDataCallback(String str, String str2, int i, int i2, int i3, ArrayList<BasicMenuBean> arrayList, ArrayList<BasicSpecMenuBean> arrayList2);

    void onDiagnoseInformationShow(int i, String str, ArrayList<BasicBean> arrayList);

    void onDiagnoseInputDialog(String str, String str2, String str3, String str4, int i);

    void onDiagnoseInputKeyWindows(String str, String str2, String str3, ArrayList<BasicBean> arrayList);

    void onDiagnoseInputNumberDialog(String str, String str2, String str3, String str4, int i);

    void onDiagnoseLeftSystemListWindows(boolean z, int i, ArrayList<BasicBean> arrayList);

    void onDiagnoseMenuDataCallback(String str, String str2, String str3, int i, int i2, ArrayList<BasicMenuBean> arrayList, boolean z);

    void onDiagnoseMessageBox(String str, String str2, String str3, int i);

    void onDiagnoseNoUICMDSetStreamCount(String str, int i);

    void onDiagnoseResetCarIconMenuCallback(String str, String str2, String str3, int i, ArrayList<BasicMenuBean> arrayList);

    void onDiagnoseSpeciaDatastream(String str, boolean z, int i, int i2, int i3, int i4, ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicDataStreamBean> arrayList2);

    void onDiagnoseSpeciaFunctionCallback(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3, String str2, int i);

    void onDiagnoseSpeciaMulti_selectCallback(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, String str2, String str3, int i);

    void onDiagnoseSubLabel(int i, ArrayList<BasicBean> arrayList);

    void onDiagnoseTransDiagInfoCallback(String str, String str2, ArrayList<BasicBean> arrayList);

    void onDiagnoseVWCodeWindows(String str, String str2, BasicBean basicBean);

    void onDismissMessageBox(String str);

    void onDownloadDiagFile(String str, String str2, String str3, String str4);

    void onDownloadDiagFileEx(String str, String str2, String str3);

    void onDownloadDiagMultFile(String str, ArrayList<BasicBean> arrayList);

    void onGetDiagProcessWay(String str);

    void onMulitInputWindow(String str, String str2, ArrayList<BasicInputBean> arrayList);

    void onMulitInputWindowWithBtn(String str, String str2, ArrayList<BasicInputBean> arrayList, ArrayList<BasicButtonBean> arrayList2);

    void onQueryWebsite(String str, String str2, String str3, ArrayList<BasicQueryWebSiteBean> arrayList);

    void onSTD_CustomUseIDData(String str, ArrayList<BasicBean> arrayList);

    void onSTD_EX1Data(String str, ArrayList<BasicBean> arrayList);

    void onSelectFileDialog(String str, String str2);

    void onSelectFilePathDialog(String str, String str2, String str3, String str4);

    boolean onSetDiagnoseInfo(int i, String str, int i2);

    void onShowDTCOrFunctionHelp(String str, String str2, String str3, String str4, String str5);

    void onUploadEcuFile(String str, String str2, String str3);

    void onVerifyMaintenance(String str, String str2, String str3);

    void onWithCustomBtnDialog(String str, String str2, String str3, ArrayList<BasicButtonBean> arrayList);

    void onWithCustomInputDialog(String str, String str2, String str3, int i, int i2, int i3, String str4);
}
