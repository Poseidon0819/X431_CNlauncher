package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicBean;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicCombineMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicInputBean;
import com.cnlaunch.diagnosemodule.bean.BasicMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicQueryWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicSelectMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpecFunDynamicEvent;
import com.cnlaunch.diagnosemodule.bean.BasicSpecMenuBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.bean.BasicVehicleData;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p221d.ActiveTestFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.AgingWindowFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.ChooseFileFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.CombineMenuFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.DataStreamSelectFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.DataStreamShowFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.FaultCodeFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.MenuListFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.MulitInputFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.ResetCarIconMenuFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SpecMemuListFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SpeciaDatastreamFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SpeciaFunctionFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p223f.DialogInterface$OnClickListenerC2191h;
import com.cnlaunch.x431pro.activity.diagnose.p223f.MessageBoxDialog;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p282d.FragmentBundleUtils;
import com.cnlaunch.x431pro.widget.p290a.CustomBtnDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.OnLineProgrammingDialog;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2826bh;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2827bi;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2864g;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2865h;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ByteBuffer;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.be */
/* loaded from: classes.dex */
public final class C2071be implements OnDiagnoseDataListener {

    /* renamed from: a */
    String f11535a = "";

    /* renamed from: b */
    ArrayList<BasicSpeciaFunctionBean> f11536b = new ArrayList<>();

    /* renamed from: c */
    String f11537c = "";

    /* renamed from: d */
    final /* synthetic */ DiagnoseActivity f11538d;

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void ShowMultiPageData() {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void ShowTopViewData(int i) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseAddressPath(ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseAlertDialog(String str, String str2, String str3) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseChannelWindows(String str, BasicBean basicBean) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseCustomListFunction(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3, String str2, int i, int i2, int i3) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseGetNewVehicleData(String str, boolean z, int i, ArrayList<BasicVehicleData> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseInformationShow(int i, String str, ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseInputDialog(String str, String str2, String str3, String str4, int i) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseInputKeyWindows(String str, String str2, String str3, ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseInputNumberDialog(String str, String str2, String str3, String str4, int i) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseLeftSystemListWindows(boolean z, int i, ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseSubLabel(int i, ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseVWCodeWindows(String str, String str2, BasicBean basicBean) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDownloadDiagFileEx(String str, String str2, String str3) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onGetDiagProcessWay(String str) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onSTD_CustomUseIDData(String str, ArrayList<BasicBean> arrayList) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onSelectFilePathDialog(String str, String str2, String str3, String str4) {
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onVerifyMaintenance(String str, String str2, String str3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2071be(DiagnoseActivity diagnoseActivity) {
        this.f11538d = diagnoseActivity;
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onMulitInputWindowWithBtn(String str, String str2, ArrayList<BasicInputBean> arrayList, ArrayList<BasicButtonBean> arrayList2) {
        if (str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
            MulitInputFragment mulitInputFragment = new MulitInputFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Title", str2);
            bundle.putString(VastExtensionXmlManager.TYPE, str);
            bundle.putSerializable("BtnData", arrayList2);
            bundle.putSerializable("InputData", arrayList);
            mulitInputFragment.setArguments(bundle);
            this.f11538d.mo7098a((Fragment) mulitInputFragment, (String) null, false);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onSTD_EX1Data(String str, ArrayList<BasicBean> arrayList) {
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        String str2;
        String str3;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        if (str.equals("16") || str.equals("17") || !str.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            return;
        }
        BasicSpecFunDynamicEvent basicSpecFunDynamicEvent = (BasicSpecFunDynamicEvent) arrayList.get(0);
        ArrayList<BasicButtonBean> buttonList = basicSpecFunDynamicEvent.getButtonList();
        ArrayList<BasicSpeciaFunctionBean> titleList = basicSpecFunDynamicEvent.getTitleList();
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> valueList = basicSpecFunDynamicEvent.getValueList();
        String title = basicSpecFunDynamicEvent.getTitle();
        String addInfo = basicSpecFunDynamicEvent.getAddInfo();
        int columsNumber = basicSpecFunDynamicEvent.getColumsNumber();
        if (DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH) {
            onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
            if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isSpeciaFunction() && this.f11536b.size() == titleList.size() && (((str2 = this.f11537c) == null || str2.equals(title)) && ((this.f11537c != null || TextUtils.isEmpty(title)) && ((str3 = this.f11535a) == null || str3.equals(addInfo))))) {
                onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
                onDiagnoseDataUpdateListenter2.mo7076a(titleList, valueList, buttonList);
            } else {
                this.f11535a = addInfo;
                this.f11536b = titleList;
                this.f11537c = title;
                this.f11538d.mo7083i().setSpeciaFunction(true);
                SpeciaFunctionFragment speciaFunctionFragment = new SpeciaFunctionFragment();
                Bundle m5074a = FragmentBundleUtils.m5074a(str, titleList, valueList, buttonList, title, columsNumber);
                m5074a.putString("Specia_AddInfo", addInfo);
                speciaFunctionFragment.setArguments(m5074a);
                this.f11538d.mo7098a((Fragment) speciaFunctionFragment, (String) null, false);
            }
            DiagnoseActivity.m7625j(this.f11538d);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final boolean onSetDiagnoseInfo(int i, String str, int i2) {
        if (i == 47) {
            this.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_SET_DIAG_FUN_INFO, new byte[]{0});
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDownloadDiagMultFile(String str, ArrayList<BasicBean> arrayList) {
        Context context;
        Context context2;
        Context context3;
        context = this.f11538d.f11019H;
        if (CommonTools.m7966b(context)) {
            context2 = this.f11538d.f11019H;
            if (!PreferencesManager.m9595a(context2).m9591a("login_state").equalsIgnoreCase("1")) {
                DiagnoseActivity diagnoseActivity = this.f11538d;
                context3 = diagnoseActivity.f11019H;
                diagnoseActivity.m7695a(context3, new C2072bf(this, arrayList));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, arrayList);
            bundle.putInt("RequestCode", 60009);
            this.f11538d.m7693a(bundle);
            return;
        }
        this.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{-1});
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onUploadEcuFile(String str, String str2, String str3) {
        Context context;
        context = this.f11538d.f11019H;
        if (!CommonTools.m7966b(context)) {
            this.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{1});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 60008);
        bundle.putString("localPath", str2);
        bundle.putString("carName", str3);
        this.f11538d.m7693a(bundle);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseMenuDataCallback(String str, String str2, String str3, int i, int i2, ArrayList<BasicMenuBean> arrayList, boolean z) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        this.f11538d.mo7083i().setDataStreamSelectJumpType("menu");
        this.f11538d.mo7083i().setSubTitle(str2);
        this.f11538d.mo7083i().setDatastreamSelectIndex(0);
        MenuListFragment menuListFragment = new MenuListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("MenuList", arrayList);
        bundle.putString("MenuType", str);
        bundle.putInt("FirstItem", i);
        bundle.putInt("FirstItemForDiag", i2);
        bundle.putString("MenuTitle", str2);
        bundle.putString("MenuHelp", str3);
        bundle.putBoolean("isSubMenu", z);
        menuListFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) menuListFragment, (String) null, false);
        ReportProduceTool m5233a = ReportProduceTool.m5233a();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        m5233a.f15647j = sb.toString();
        DiagnoseActivity.m7625j(this.f11538d);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseDatastreamSelectMenuDataCallback(String str, ArrayList<BasicSelectMenuBean> arrayList, boolean z) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        DataStreamSelectFragment dataStreamSelectFragment = new DataStreamSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DataStreamSelect", arrayList);
        bundle.putBoolean("CheckAll", z);
        dataStreamSelectFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) dataStreamSelectFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseDatastreamCallback(String str, ArrayList<BasicDataStreamBean> arrayList, String str2, String str3, String str4) {
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        this.f11538d.mo7083i().setDataStreamSelectJumpType("datastream");
        if (DiagnoseConstants.DATASTREAM_REFRESH_CONTROL) {
            Iterator<BasicDataStreamBean> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().doConversion();
            }
            onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
            if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isDataStream()) {
                onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
                onDiagnoseDataUpdateListenter2.mo7078a(arrayList);
                return;
            }
            this.f11538d.mo7083i().setDataStream(true);
            DataStreamShowFragment dataStreamShowFragment = new DataStreamShowFragment();
            if (str.equals(DiagnoseConstants.UI_TYPE_DATASTREAM_ID_EX_STANDARDVALUE)) {
                str = DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM;
            }
            Bundle bundle = new Bundle();
            if (arrayList.size() > 0 && !arrayList.get(0).getValuestatus().isEmpty()) {
                bundle.putString("DataStreamShow_HaveValueStatus", "1");
            } else {
                bundle.putString("DataStreamShow_HaveValueStatus", "0");
            }
            bundle.putSerializable("DataStreamShow", arrayList);
            bundle.putString("DataStreamShow_Type", str);
            bundle.putString("DataStreamShow_Title", str2);
            bundle.putString("DataStreamShow_PageCount", str3);
            bundle.putString("DataStreamShow_Count", str4);
            dataStreamShowFragment.setArguments(bundle);
            this.f11538d.mo7098a((Fragment) dataStreamShowFragment, (String) null, false);
            DiagnoseActivity.m7618o();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseFaultCodeDataCallback(String str, ArrayList<BasicFaultCodeBean> arrayList, ArrayList<BasicButtonBean> arrayList2) {
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        if (DiagnoseConstants.FAULTCODE_REFRESH) {
            onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
            if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isFaultCode()) {
                onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
                onDiagnoseDataUpdateListenter2.mo7073b(arrayList);
                return;
            }
            this.f11538d.mo7083i().setFaultCode(true);
            FaultCodeFragment faultCodeFragment = new FaultCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("FaultCode", arrayList);
            bundle.putSerializable("FaultCode_button", arrayList2);
            bundle.putString("FaultCode_Type", str);
            faultCodeFragment.setArguments(bundle);
            this.f11538d.mo7098a((Fragment) faultCodeFragment, (String) null, false);
            DiagnoseActivity.m7618o();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseActiveTestDataCallback(String str, String str2, ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicButtonBean> arrayList2, int i) {
        MessageBoxDialog messageBoxDialog;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        if (DiagnoseConstants.ACTIVE_TEST_REFRESH) {
            this.f11538d.mo7083i().setDataStreamSelectJumpType("active");
            Iterator<BasicDataStreamBean> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().doConversion();
            }
            onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
            if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isActiveTest()) {
                onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
                onDiagnoseDataUpdateListenter2.mo7077a(arrayList, arrayList2);
                return;
            }
            this.f11538d.mo7083i().setActiveTest(true);
            ActiveTestFragment activeTestFragment = new ActiveTestFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ActiveTestType", str);
            bundle.putString("ActiveTitle", str2);
            bundle.putSerializable("ActiveTestList", arrayList);
            bundle.putSerializable("ActiveTestButton", arrayList2);
            activeTestFragment.setArguments(bundle);
            this.f11538d.mo7098a((Fragment) activeTestFragment, (String) null, false);
            DiagnoseActivity.m7618o();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseSpeciaFunctionCallback(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3, String str2, int i) {
        MessageBoxDialog messageBoxDialog;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        String str3;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        if (DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH) {
            onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
            if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isSpeciaFunction() && this.f11536b.size() == arrayList.size() && (((str3 = this.f11537c) == null || str3.equals(str2)) && (this.f11537c != null || TextUtils.isEmpty(str2)))) {
                onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
                onDiagnoseDataUpdateListenter2.mo7076a(arrayList, arrayList2, arrayList3);
            } else {
                this.f11536b = arrayList;
                this.f11537c = str2;
                this.f11538d.mo7083i().setSpeciaFunction(true);
                SpeciaFunctionFragment speciaFunctionFragment = new SpeciaFunctionFragment();
                speciaFunctionFragment.setArguments(FragmentBundleUtils.m5074a(str, arrayList, arrayList2, arrayList3, str2, i));
                this.f11538d.mo7098a((Fragment) speciaFunctionFragment, (String) null, false);
                DiagnoseActivity.m7618o();
            }
            DiagnoseActivity.m7625j(this.f11538d);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDismissMessageBox(String str) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onWithCustomBtnDialog(String str, String str2, String str3, ArrayList<BasicButtonBean> arrayList) {
        CustomBtnDialog customBtnDialog = new CustomBtnDialog(this.f11538d, str2, str3, arrayList);
        DiagnoseActivity diagnoseActivity = this.f11538d;
        customBtnDialog.f16347a = diagnoseActivity;
        diagnoseActivity.f11106bc = customBtnDialog;
        customBtnDialog.show();
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseCombineMenu(String str, String str2, int i, ArrayList<BasicCombineMenuBean> arrayList, int i2) {
        this.f11538d.mo7083i().setSubTitle(str2);
        CombineMenuFragment combineMenuFragment = new CombineMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CombineMenuList", arrayList);
        bundle.putString("CombineMenuTitle", str2);
        bundle.putInt("FirstItem", i);
        bundle.putInt("ConfirmBtnState", i2);
        combineMenuFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) combineMenuFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseArgingWindowCallback(String str, String str2) {
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
        if (onDiagnoseDataUpdateListenter != null) {
            onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
            onDiagnoseDataUpdateListenter2.mo7074a_(str2);
            return;
        }
        AgingWindowFragment agingWindowFragment = new AgingWindowFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ArgingContent", str2);
        agingWindowFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) agingWindowFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseFeedback() {
        Context context;
        try {
            if (this.f11538d.mo7083i().getDiagnoseStatue() >= 2) {
                context = this.f11538d.f11019H;
                if (!C2778n.m4917a(context)) {
                    NToast.m9450a(this.f11538d, (int) R.string.common_network_unavailable);
                    return;
                }
                Message obtain = Message.obtain((Handler) null, 16);
                Bundle bundle = new Bundle();
                bundle.putInt(VastExtensionXmlManager.TYPE, 1);
                obtain.setData(bundle);
                this.f11538d.m7692a(obtain);
                LoadDialog.m4686a(this.f11538d);
                DiagnoseActivity.m7621m(this.f11538d);
                return;
            }
            NToast.m9450a(this.f11538d, (int) R.string.no_suport_in_remote);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("feekback", "send server CLIENT_DIAGNOSE_LOG_DATA failed!");
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onSelectFileDialog(String str, String str2) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        ChooseFileFragment chooseFileFragment = new ChooseFileFragment();
        Bundle bundle = new Bundle();
        bundle.putString("defPath", str2);
        chooseFileFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) chooseFileFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseSpeciaDatastream(String str, boolean z, int i, int i2, int i3, int i4, ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicDataStreamBean> arrayList2) {
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter;
        OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter2;
        onDiagnoseDataUpdateListenter = this.f11538d.f11073ak;
        if (onDiagnoseDataUpdateListenter != null && this.f11538d.mo7083i().isSpeciaDatastream()) {
            onDiagnoseDataUpdateListenter2 = this.f11538d.f11073ak;
            onDiagnoseDataUpdateListenter2.mo7072b(arrayList, arrayList2);
            return;
        }
        this.f11538d.mo7083i().setSpeciaDatastream(true);
        SpeciaDatastreamFragment speciaDatastreamFragment = new SpeciaDatastreamFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", str);
        bundle.putBoolean("Limit", z);
        bundle.putInt("FirstCount", i);
        bundle.putInt("SecondCount", i2);
        bundle.putInt("FirstMin", i3);
        bundle.putInt("FirstMax", i4);
        bundle.putSerializable("FirstList", arrayList);
        bundle.putSerializable("SecondList", arrayList2);
        speciaDatastreamFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) speciaDatastreamFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseNoUICMDSetStreamCount(String str, int i) {
        if (str.equals(DiagnoseConstants.UI_TYPE_NO_UI_CMD)) {
            this.f11538d.mo7083i().setDataStreamCount(i);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x002c */
    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDiagCallService(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r6 = r5.f11538d
            com.cnlaunch.l.a.a r6 = com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.m7619n(r6)
            if (r6 == 0) goto L7c
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r6 = r5.f11538d
            com.cnlaunch.l.a.a r6 = com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.m7619n(r6)
            boolean r6 = r6.f9521c
            r0 = 3
            r1 = 0
            if (r6 != 0) goto L48
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r6 = r5.f11538d
            com.cnlaunch.l.a.a r6 = com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.m7619n(r6)
            java.lang.String r2 = "com.cnlaunch.Service.DIAGBASESERVICE"
            java.lang.String r3 = "com.cnlaunch.DiagBaseService"
            java.lang.String r4 = "com.cnlaunch.DiagBaseService.DiagBaseService"
            r6.m8633a(r2, r3, r4)
            r6 = 0
        L24:
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r2 = r5.f11538d
            com.cnlaunch.l.a.a r2 = com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.m7619n(r2)
            com.cnlaunch.l.b.a r2 = r2.f9522d
            if (r2 != 0) goto L48
            r2 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r2)     // Catch: java.lang.InterruptedException -> L34
            goto L38
        L34:
            r2 = move-exception
            r2.printStackTrace()
        L38:
            int r6 = r6 + 1
            r2 = 50
            if (r6 <= r2) goto L24
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r6 = r5.f11538d
            java.lang.String r7 = "72"
            java.lang.String r1 = "01"
            r6.mo7093a(r7, r1, r0)
            return
        L48:
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r2 = r5.f11538d     // Catch: android.os.RemoteException -> L58
            com.cnlaunch.l.a.a r2 = com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.m7619n(r2)     // Catch: android.os.RemoteException -> L58
            com.cnlaunch.l.b.a r2 = r2.f9522d     // Catch: android.os.RemoteException -> L58
            boolean r7 = r2.mo8631a(r7, r6)     // Catch: android.os.RemoteException -> L58
            goto L5d
        L58:
            r7 = move-exception
            r7.printStackTrace()
            r7 = 0
        L5d:
            if (r7 == 0) goto L73
            r6 = r6[r1]
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r7 = r5.f11538d
            java.lang.String r1 = "72"
            java.lang.String r2 = "00"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r2.concat(r6)
            r7.mo7093a(r1, r6, r0)
            return
        L73:
            com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity r6 = r5.f11538d
            java.lang.String r7 = "72"
            java.lang.String r1 = "01"
            r6.mo7093a(r7, r1, r0)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.C2071be.onDiagCallService(java.lang.String, java.lang.String):void");
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseResetCarIconMenuCallback(String str, String str2, String str3, int i, ArrayList<BasicMenuBean> arrayList) {
        ResetCarIconMenuFragment resetCarIconMenuFragment = new ResetCarIconMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title", str2);
        bundle.putString("Help", str3);
        bundle.putInt("FirstItem", i);
        bundle.putSerializable("CarIconList", arrayList);
        resetCarIconMenuFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) resetCarIconMenuFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onWithCustomInputDialog(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        DialogC2073bg dialogC2073bg = new DialogC2073bg(this, this.f11538d, str2, str3, i, i2, i3, str4);
        this.f11538d.f11106bc = dialogC2073bg;
        dialogC2073bg.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2864g(dialogC2073bg));
        dialogC2073bg.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2865h(dialogC2073bg));
        dialogC2073bg.show();
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onShowDTCOrFunctionHelp(String str, String str2, String str3, String str4, String str5) {
        Context context;
        Context context2;
        context = this.f11538d.f11019H;
        if (CommonTools.m7966b(context)) {
            if (this.f11538d.mo7083i().getDiagnoseStatue() == 0) {
                return;
            }
            DiagnoseActivity diagnoseActivity = this.f11538d;
            String concat = "0".concat(String.valueOf(str2));
            diagnoseActivity.f11027Q = str;
            diagnoseActivity.f11028R = concat;
            diagnoseActivity.f11029S = str3;
            diagnoseActivity.f11030T = str4;
            diagnoseActivity.f11031U = str5;
            Context context3 = diagnoseActivity.f11019H;
            diagnoseActivity.getResources().getString(R.string.common_title_tips);
            diagnoseActivity.f11032V = new WaitDialog(context3, true, diagnoseActivity.getResources().getString(R.string.common_loading_tips));
            diagnoseActivity.f11032V.setCanceledOnTouchOutside(false);
            diagnoseActivity.f11033W = diagnoseActivity.f11032V.f16396b;
            diagnoseActivity.f11032V.show();
            diagnoseActivity.f11032V.setOnCancelListener(new DialogInterface$OnCancelListenerC2217y(diagnoseActivity));
            diagnoseActivity.f11034X = false;
            diagnoseActivity.m7739c(60001);
        } else {
            this.f11538d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
            context2 = this.f11538d.f11019H;
            NToast.m9447b(context2, (int) R.string.common_network_unavailable);
        }
        NLog.m9452b("test", "onShowDTCOrFunctionHelp(type=" + str + "  dataid=" + str2 + "  dataversion=" + str3 + "  softID= " + str4 + "  language=" + str5);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDownloadDiagFile(String str, String str2, String str3, String str4) {
        Context context;
        Context context2;
        OnLineProgrammingDialog onLineProgrammingDialog;
        OnLineProgrammingDialog onLineProgrammingDialog2;
        Context context3;
        OnLineProgrammingDialog onLineProgrammingDialog3;
        HashMap hashMap = new HashMap();
        hashMap.put("softId", str3);
        hashMap.put("versionNo", str2);
        hashMap.put("filePath", str4);
        hashMap.put("SerialNum", this.f11538d.mo7083i().getSerialNum());
        context = this.f11538d.f11019H;
        String m9591a = PreferencesManager.m9595a(context).m9591a("login_state");
        boolean z = (MainActivity.m7895b() || MainActivity.m7881d()) && (this.f11538d.mo7083i().getDiagnoseStatue() == 0 || MainActivity.m7881d());
        if (!"0".equals(m9591a)) {
            DiagnoseActivity diagnoseActivity = this.f11538d;
            context3 = diagnoseActivity.f11019H;
            diagnoseActivity.f11112bi = new OnLineProgrammingDialog(context3, 2, hashMap, z, this.f11538d);
            onLineProgrammingDialog3 = this.f11538d.f11112bi;
            onLineProgrammingDialog3.show();
        } else {
            DiagnoseActivity diagnoseActivity2 = this.f11538d;
            context2 = diagnoseActivity2.f11019H;
            diagnoseActivity2.f11112bi = new OnLineProgrammingDialog(context2, 1, hashMap, z, this.f11538d);
            onLineProgrammingDialog = this.f11538d.f11112bi;
            onLineProgrammingDialog.show();
        }
        if (MainActivity.m7895b() || MainActivity.m7881d()) {
            DiagnoseActivity diagnoseActivity3 = this.f11538d;
            onLineProgrammingDialog2 = diagnoseActivity3.f11112bi;
            diagnoseActivity3.f11023M = onLineProgrammingDialog2;
        }
        NLog.m9452b("test", "onDownloadDiagFile(type=" + str + " fileVersion= " + str2 + "  softID=" + str3 + "  path=" + str4);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onQueryWebsite(String str, String str2, String str3, ArrayList<BasicQueryWebSiteBean> arrayList) {
        Context context;
        String str4;
        Context context2;
        context = this.f11538d.f11019H;
        if (!CommonTools.m7966b(context)) {
            context2 = this.f11538d.f11019H;
            NToast.m9447b(context2, (int) R.string.common_network_unavailable);
            this.f11538d.mo7089a(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE, new byte[]{-1, ByteBuffer.ZERO, 0});
            return;
        }
        Log.i("anqi", "onQueryWebsite type=" + str + ", dbName=" + str2 + ", tabName=" + str3);
        this.f11538d.f11119bp = str2;
        this.f11538d.f11120bq = str3;
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i).getTitle());
            sb.append(":");
            sb.append(arrayList.get(i).getValue().replace("=", ""));
        }
        sb.append("}");
        this.f11538d.f11121br = sb.toString();
        StringBuilder sb2 = new StringBuilder("onQueryWebsite condition =");
        str4 = this.f11538d.f11121br;
        sb2.append(str4);
        Log.i("anqi", sb2.toString());
        this.f11538d.f11107bd = "";
        AsyncTaskManager.m9576a(60003);
        this.f11538d.m7739c(60003);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onMulitInputWindow(String str, String str2, ArrayList<BasicInputBean> arrayList) {
        Context context;
        if (str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMB_WINDON)) {
            MulitInputFragment mulitInputFragment = new MulitInputFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Title", str2);
            bundle.putString(VastExtensionXmlManager.TYPE, str);
            bundle.putSerializable("InputData", arrayList);
            mulitInputFragment.setArguments(bundle);
            this.f11538d.mo7098a((Fragment) mulitInputFragment, (String) null, false);
        } else if (this.f11538d.mo7083i().getDiagnoseStatue() == 0) {
        } else {
            context = this.f11538d.f11019H;
            DialogC2074bh dialogC2074bh = new DialogC2074bh(this, context, str2, arrayList);
            this.f11538d.f11106bc = dialogC2074bh;
            dialogC2074bh.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2826bh(dialogC2074bh));
            dialogC2074bh.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2827bi(dialogC2074bh));
            dialogC2074bh.show();
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseTransDiagInfoCallback(String str, String str2, ArrayList<BasicBean> arrayList) {
        Context context;
        if (str2.equals("128")) {
            arrayList.get(0);
            this.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
        } else if (str2.equals(DiagnoseConstants.UI_Type_EXT1_SHOW_INPUTSRING_BY_SCAN_BARCODE) || str2.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            ArrayList arrayList2 = new ArrayList();
            String str3 = "";
            for (int i = 0; i < arrayList.size(); i++) {
                BasicSystemStatusBean basicSystemStatusBean = (BasicSystemStatusBean) arrayList.get(i);
                if (str2.equals(DiagnoseConstants.UI_Type_EXT1_SHOW_INPUTSRING_BY_SCAN_BARCODE)) {
                    str3 = str3 + "System:" + basicSystemStatusBean.getSystemName() + "  Old VIN: " + basicSystemStatusBean.getOldVIN() + " VIN : " + basicSystemStatusBean.getCurrVIN() + "\n";
                } else {
                    String str4 = str3 + "System : " + basicSystemStatusBean.getSystemName() + " ECU info: \n";
                    for (int i2 = 0; i2 < basicSystemStatusBean.getSystemECUInfoBean().size(); i2++) {
                        str4 = str4 + " Title = " + basicSystemStatusBean.getSystemECUInfoBean().get(i2).getTitle() + " Value = " + basicSystemStatusBean.getSystemECUInfoBean().get(i2).getValue() + "\n";
                    }
                    str3 = str4;
                }
                arrayList2.add(basicSystemStatusBean);
            }
            context = this.f11538d.f11019H;
            NToast.m9449a(context, "dataType = " + str2 + ", data come,Data :" + str3);
            this.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW) || str2.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
            DiagnoseActivity.m7676a(this.f11538d, str, str2, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU) || str2.equals(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG)) {
            DiagnoseActivity.m7675a(this.f11538d, str2, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_CURRENT_MENU_PATH) || str2.equals(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM)) {
            DiagnoseActivity.m7657b(this.f11538d, str2, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_FAULTCODES) || str2.equals("96")) {
            DiagnoseActivity.m7650c(this.f11538d, str2, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE) || str2.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX) || str2.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox)) {
            DiagnoseActivity.m7642d(this.f11538d, str2, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_SPT_VERYDY_MAINTENANCE)) {
            DiagnoseActivity.m7674a(this.f11538d, arrayList);
        } else if (str2.equals(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW)) {
            DiagnoseActivity.m7656b(this.f11538d, arrayList);
        } else {
            str2.equals(DiagnoseConstants.FEEDBACK_MESSAGEBOX_TEXT_CUSTOMBUTTON);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseSpeciaMulti_selectCallback(String str, ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, String str2, String str3, int i) {
        SpeciaFunctionFragment speciaFunctionFragment = new SpeciaFunctionFragment();
        ArrayList arrayList3 = new ArrayList();
        String hexString2binaryString = ByteHexHelper.hexString2binaryString(str2);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            if (hexString2binaryString.substring(i2, i3).equals("1")) {
                arrayList2.get(i2).get(0).setCheck(true);
            }
            i2 = i3;
        }
        speciaFunctionFragment.setArguments(FragmentBundleUtils.m5074a(str, arrayList, arrayList2, arrayList3, str3, i));
        this.f11538d.mo7098a((Fragment) speciaFunctionFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseGetData(String str, String str2) {
        Context context;
        if (str.equals(DiagnoseConstants.UI_Type_GET_CURRENT_UNIT_TYPE)) {
            context = this.f11538d.f11019H;
            this.f11538d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, ByteHexHelper.intToHexBytes(String.valueOf(C2744aa.m5158d(context))), 3);
        }
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseHDMenuDataCallback(String str, String str2, int i, int i2, int i3, ArrayList<BasicMenuBean> arrayList, ArrayList<BasicSpecMenuBean> arrayList2) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog2 = this.f11538d.f11074al;
            messageBoxDialog2.m7052a();
        }
        this.f11538d.mo7083i().setDataStreamSelectJumpType("menu");
        this.f11538d.mo7083i().setSubTitle(str2);
        this.f11538d.mo7083i().setDatastreamSelectIndex(0);
        SpecMemuListFragment specMemuListFragment = new SpecMemuListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("MenuList", arrayList);
        bundle.putSerializable("HistoryMenuList", arrayList2);
        bundle.putString("MenuType", str);
        bundle.putInt("FirstItem", i2);
        bundle.putInt("FirstItemForDiag", i3);
        bundle.putString("MenuTitle", str2);
        bundle.putInt("Level", i);
        specMemuListFragment.setArguments(bundle);
        this.f11538d.mo7098a((Fragment) specMemuListFragment, (String) null, false);
    }

    @Override // com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener
    public final void onDiagnoseMessageBox(String str, String str2, String str3, int i) {
        MessageBoxDialog messageBoxDialog;
        MessageBoxDialog messageBoxDialog2;
        Messenger messenger;
        MessageBoxDialog messageBoxDialog3;
        MessageBoxDialog messageBoxDialog4;
        Messenger messenger2;
        Bundle bundle = new Bundle();
        bundle.putString("MessageTitle", str2);
        bundle.putString("MessageContent", str3);
        bundle.putInt("MessageRatio", i);
        messageBoxDialog = this.f11538d.f11074al;
        if (messageBoxDialog == null) {
            this.f11538d.f11074al = new MessageBoxDialog();
        }
        if (str.equals(DiagnoseConstants.UI_TYPE_PROGRESSBAR)) {
            messageBoxDialog4 = this.f11538d.f11074al;
            DiagnoseActivity diagnoseActivity = this.f11538d;
            messenger2 = diagnoseActivity.f11067ae;
            if (messageBoxDialog4.f12453a != null && messageBoxDialog4.f12453a.isShowing()) {
                messageBoxDialog4.f12456d.obtainMessage(0, bundle).sendToTarget();
            } else {
                messageBoxDialog4.f12455c = messenger2;
                if (messageBoxDialog4.f12453a == null) {
                    messageBoxDialog4.f12453a = new ProgressDialog(diagnoseActivity, R.style.DiagnoseProgressDialogTheme);
                    View inflate = ((LayoutInflater) diagnoseActivity.getSystemService("layout_inflater")).inflate(R.layout.progress_dialog_title, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.title)).setText(bundle.getString("MessageTitle", ""));
                    messageBoxDialog4.f12453a.setCustomTitle(inflate);
                    messageBoxDialog4.f12453a.setProgressStyle(1);
                    messageBoxDialog4.f12453a.setCancelable(false);
                    messageBoxDialog4.f12453a.setMax(100);
                    messageBoxDialog4.f12453a.setProgress(0);
                }
                messageBoxDialog4.f12453a.setMessage(bundle.getString("MessageContent", ""));
                messageBoxDialog4.f12453a.setTitle(bundle.getString("MessageTitle", ""));
                messageBoxDialog4.f12453a.setProgress(bundle.getInt("MessageRatio", 0));
                messageBoxDialog4.f12453a = messageBoxDialog4.f12453a;
                messageBoxDialog4.f12453a.show();
            }
        } else {
            messageBoxDialog2 = this.f11538d.f11074al;
            DiagnoseActivity diagnoseActivity2 = this.f11538d;
            messenger = diagnoseActivity2.f11067ae;
            if (messageBoxDialog2.f12454b != null && messageBoxDialog2.f12454b.isShowing()) {
                messageBoxDialog2.f12456d.obtainMessage(1, bundle).sendToTarget();
            } else {
                messageBoxDialog2.f12455c = messenger;
                if (messageBoxDialog2.f12454b == null) {
                    messageBoxDialog2.f12454b = new ProgressDialog(diagnoseActivity2, R.style.DiagnoseProgressDialogTheme);
                    View inflate2 = ((LayoutInflater) diagnoseActivity2.getSystemService("layout_inflater")).inflate(R.layout.progress_dialog_title, (ViewGroup) null);
                    ((TextView) inflate2.findViewById(R.id.title)).setText(bundle.getString("MessageTitle", ""));
                    messageBoxDialog2.f12454b.setCustomTitle(inflate2);
                    messageBoxDialog2.f12454b.setCancelable(false);
                    messageBoxDialog2.f12454b.setButton(diagnoseActivity2.getString(17039360), new DialogInterface$OnClickListenerC2191h(messageBoxDialog2));
                    messageBoxDialog2.f12454b.setMessage(bundle.getString("MessageContent", ""));
                    messageBoxDialog2.f12454b.setTitle(bundle.getString("MessageTitle", ""));
                }
                messageBoxDialog2.f12454b = messageBoxDialog2.f12454b;
                messageBoxDialog2.f12454b.show();
            }
        }
        if (i >= 100) {
            messageBoxDialog3 = this.f11538d.f11074al;
            messageBoxDialog3.m7052a();
        }
    }
}
