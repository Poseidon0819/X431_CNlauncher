package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.pdf.PDFBaseInfo;
import com.cnlaunch.x431pro.activity.pdf.PDFDataStreamInfo;
import com.cnlaunch.x431pro.activity.pdf.PDFFaultCodeReportInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.PrintInfoProperties;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Locale;
import message.p383f.SharePreferenceMsgUtils;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.n */
/* loaded from: classes.dex */
public abstract class BaseDiagnoseFragment extends BaseFragment implements View.OnClickListener, OnDiagnoseDataUpdateListenter, OnKeyDownListenter {

    /* renamed from: a */
    private IconButton f12354a;

    /* renamed from: b */
    private IconButton f12355b;

    /* renamed from: e */
    public IconButton f12358e;

    /* renamed from: f */
    public IconButton f12359f;

    /* renamed from: g */
    public String f12360g;

    /* renamed from: j */
    private IconRadioButton f12363j;

    /* renamed from: k */
    private MessageDialog f12364k;

    /* renamed from: c */
    public boolean f12356c = true;

    /* renamed from: d */
    public IFragmentCallback f12357d = null;

    /* renamed from: h */
    public final int f12361h = 1;

    /* renamed from: i */
    public final int f12362i = 2;

    /* renamed from: a */
    public void mo7125a(int i) {
    }

    /* renamed from: a */
    public void mo7078a(ArrayList<BasicDataStreamBean> arrayList) {
    }

    /* renamed from: a */
    public void mo7077a(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicButtonBean> arrayList2) {
    }

    /* renamed from: a */
    public void mo7076a(ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3) {
    }

    /* renamed from: a */
    public void mo7075a(ArrayList<BasicSystemStatusBean> arrayList, boolean z) {
    }

    /* renamed from: a_ */
    public void mo7074a_(String str) {
    }

    /* renamed from: b */
    public String mo7102b() {
        return null;
    }

    /* renamed from: b */
    public void mo7073b(ArrayList<BasicFaultCodeBean> arrayList) {
    }

    /* renamed from: b */
    public void mo7072b(ArrayList<BasicDataStreamBean> arrayList, ArrayList<BasicDataStreamBean> arrayList2) {
    }

    /* renamed from: f */
    public boolean mo7118f() {
        return false;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        View findViewById = getActivity().findViewById(R.id.head_title);
        if (findViewById != null) {
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2 && this.f12357d.mo7081k().getOtherVer() < 3) {
                findViewById.setVisibility(8);
            } else {
                TextView textView = (TextView) getActivity().findViewById(R.id.tv_head_title);
                String allTitle = this.f12357d.mo7083i().getAllTitle();
                if (this.f12357d.mo7083i().getDiagnoseStatue() == 1) {
                    DiagCarInfo m5077e = DiagnoseUtils.m5086a().m5077e();
                    String str = "";
                    String str2 = "";
                    if (m5077e != null) {
                        str2 = m5077e.getSoftVersion();
                        str = m5077e.getCar_series();
                    }
                    if (!MyTools.m9636a(str2)) {
                        allTitle = str2 + allTitle;
                    }
                    if (!MyTools.m9636a(str)) {
                        allTitle = str + allTitle;
                    } else {
                        String string = SharePreferenceMsgUtils.m248a().f24032a.getString("carName", "");
                        if (!TextUtils.isEmpty(string)) {
                            allTitle = string + allTitle;
                        } else {
                            allTitle = getString(R.string.remote_dialog_title) + allTitle;
                        }
                    }
                } else if (allTitle == null || allTitle.equals("")) {
                    allTitle = this.f12357d.mo7083i().getCarSoftName();
                }
                textView.setText(allTitle);
            }
        }
        String mo7102b = mo7102b();
        if (mo7102b != null) {
            setTitle(mo7102b);
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12357d = (IFragmentCallback) activity;
            IFragmentCallback iFragmentCallback = this.f12357d;
            if (iFragmentCallback != null) {
                this.f12356c = iFragmentCallback.mo7083i().getDiagnoseStatue() != 0;
            }
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IFragmentCallback iFragmentCallback = this.f12357d;
        if (iFragmentCallback != null) {
            iFragmentCallback.mo7096a((OnKeyDownListenter) null);
            this.f12357d = null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12354a = (IconButton) getActivity().findViewById(R.id.btn_home);
        this.f12355b = (IconButton) getActivity().findViewById(R.id.btn_help);
        this.f12363j = (IconRadioButton) getActivity().findViewById(R.id.btn_print);
        this.f12358e = (IconButton) getActivity().findViewById(R.id.btn_save);
        IconButton iconButton = this.f12358e;
        if (iconButton != null) {
            iconButton.setOnClickListener(this);
        }
        this.f12359f = (IconButton) getActivity().findViewById(R.id.btn_save_txt);
        IconButton iconButton2 = this.f12359f;
        if (iconButton2 != null) {
            iconButton2.setOnClickListener(this);
            if (LanguageUtils.m9283b().equalsIgnoreCase("es")) {
                this.f12359f.setVisibility(0);
            } else {
                this.f12359f.setVisibility(8);
            }
        }
        IconButton iconButton3 = this.f12354a;
        if (iconButton3 != null) {
            iconButton3.setOnClickListener(this);
        }
        IconButton iconButton4 = this.f12355b;
        if (iconButton4 != null) {
            if (this.f12356c) {
                iconButton4.setEnabled(mo7118f());
                this.f12355b.setOnClickListener(this);
            } else {
                iconButton4.setEnabled(false);
            }
        }
        if (this.f12363j != null) {
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                this.f12363j.setEnabled(false);
            } else if (this.f12356c) {
                this.f12363j.setChecked(this.f12357d.mo7083i().isPrinting());
                this.f12363j.setOnCheckedChangeListener(new C2177o(this));
            }
        }
        this.f12357d.mo7096a((OnKeyDownListenter) this);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        setTitle("");
        this.f12357d.mo7084h();
        MessageDialog messageDialog = this.f12364k;
        if (messageDialog != null) {
            messageDialog.dismiss();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_home) {
            IFragmentCallback iFragmentCallback = this.f12357d;
            if (iFragmentCallback == null || iFragmentCallback.mo7083i().isDatastreamRecord()) {
                return;
            }
            this.f12357d.mo7085f(0);
        } else if (id == R.id.btn_help) {
            this.f12364k = new MessageDialog(getActivity());
            this.f12364k.m4669a(getString(R.string.dialog_title_help), mo7119e());
        } else if (id == R.id.btn_save) {
            mo7125a(1);
        } else if (id == R.id.btn_save_txt) {
            mo7125a(2);
        }
    }

    /* renamed from: c */
    public String mo7100c() {
        return getString(R.string.print_null_data);
    }

    /* renamed from: e */
    public String mo7119e() {
        return getString(R.string.help_null_data);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
        IconRadioButton iconRadioButton = this.f12363j;
        if (iconRadioButton != null) {
            iconRadioButton.setChecked(false);
        }
    }

    /* renamed from: b */
    private String m7122b(String str) {
        if (!C2744aa.m5128p(this.mContext) || C2787z.m4821a(str)) {
            return str;
        }
        if (str.length() == 7) {
            return str.substring(0, 3) + "-" + str.substring(3, 7);
        } else if (str.length() == 10) {
            return "(" + str.substring(0, 3) + ") " + str.substring(3, 6) + "-" + str.substring(6);
        } else if (str.length() == 11) {
            return str.substring(0, 3) + "-" + str.substring(3, 7) + "-" + str.substring(7);
        } else {
            return str;
        }
    }

    /* renamed from: a */
    public final PDFBaseInfo m7123a(String str, int i) {
        String string;
        PreferencesManager preferencesManager;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        PDFBaseInfo pDFFaultCodeReportInfo;
        String str10;
        String str11;
        String str12;
        String str13 = this.mContext.getResources().getString(R.string.diagnose_report_repairplant) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str14 = this.mContext.getResources().getString(R.string.diagnose_report_address) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str15 = this.mContext.getResources().getString(R.string.diagnose_report_tel) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str16 = this.mContext.getResources().getString(R.string.diagnose_report_email) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str17 = this.mContext.getResources().getString(R.string.diagnose_report_telmail) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str18 = this.mContext.getResources().getString(R.string.diagnose_report_caruser) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str19 = this.mContext.getResources().getString(R.string.diagnose_report_plate_number) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str20 = this.mContext.getResources().getString(R.string.my_customer_car_brand) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str21 = this.mContext.getResources().getString(R.string.my_customer_car_year) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str22 = this.mContext.getResources().getString(R.string.diagnose_report_carname) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str23 = this.mContext.getResources().getString(R.string.report_car_vin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str24 = this.mContext.getResources().getString(R.string.diagnose_report_odo) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str25 = this.mContext.getResources().getString(R.string.Historical_records_car_model_software_version_txt) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str26 = this.mContext.getResources().getString(R.string.Historical_records_diagnostic_software_version_txt) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str27 = this.mContext.getResources().getString(R.string.report_diagnose_time) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str28 = this.mContext.getResources().getString(R.string.diagnose_report_tester) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str29 = this.mContext.getResources().getString(R.string.diagnose_report_testpath) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str30 = this.mContext.getResources().getString(R.string.diagloghistorydetail_remark) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str31 = this.mContext.getResources().getString(R.string.report_engine_size) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str32 = this.mContext.getString(R.string.diagnose_report_repair_type) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        String str33 = this.mContext.getString(R.string.diagnose_report_zipcode) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mContext.getResources().getString(R.string.diagnose_report_voltage));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        PreferencesManager m9595a = PreferencesManager.m9595a((Context) getActivity());
        String m4837a = PrintInfoProperties.m4838a().m4837a("companyName");
        String m4837a2 = PrintInfoProperties.m4838a().m4837a("companyAddress");
        String m4837a3 = PrintInfoProperties.m4838a().m4837a("address_line1");
        String m4837a4 = PrintInfoProperties.m4838a().m4837a("address_line2");
        String m4837a5 = PrintInfoProperties.m4838a().m4837a("address_city");
        String m4837a6 = PrintInfoProperties.m4838a().m4837a("address_province");
        String m4837a7 = PrintInfoProperties.m4838a().m4837a("company_zipcode");
        String m4837a8 = PrintInfoProperties.m4838a().m4837a("companyPhoneNumber");
        String m4837a9 = PrintInfoProperties.m4838a().m4837a("companyEmail");
        String m4837a10 = PrintInfoProperties.m4838a().m4837a("companyFax");
        if (TextUtils.isEmpty(m4837a9)) {
            m4837a9 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        String m9591a = m9595a.m9591a("licensePlateNumberDiagnew");
        String str34 = C2787z.m4821a(m9591a) ? DiagnoseConstants.LICENSEPLATE : m9591a;
        String m9591a2 = m9595a.m9591a("report_logo_path");
        String m9591a3 = m9595a.m9591a("car_owner_name");
        String m9591a4 = m9595a.m9591a("last_tester");
        String m9591a5 = m9595a.m9591a("car_remark");
        String string2 = this.mContext.getString(R.string.pre_repair);
        switch (m9595a.m9585b("repair_type", 0)) {
            case 0:
                string = this.mContext.getString(R.string.diagnostic);
                break;
            case 1:
                string = this.mContext.getString(R.string.pre_repair);
                break;
            case 2:
                string = this.mContext.getString(R.string.post_repair);
                break;
            default:
                string = string2;
                break;
        }
        String vin = DiagnoseInfo.getInstance().getVin();
        if (TextUtils.isEmpty(vin)) {
            vin = m9595a.m9591a("car_vin");
            preferencesManager = m9595a;
        } else {
            preferencesManager = m9595a;
        }
        String str35 = string;
        String str36 = vin;
        String m5184a = C2744aa.m5184a(this.mContext, DiagnoseConstants.DIAG_ODO_DATA, Boolean.FALSE);
        String softVersion = this.f12357d.mo7083i().getSoftVersion();
        String appVersion = this.f12357d.mo7083i().getAppVersion();
        if (TextUtils.isEmpty(DiagnoseConstants.CAR_VENDER)) {
            str2 = DiagnoseUtils.m5086a().m5077e() == null ? "" : DiagnoseUtils.m5086a().m5077e().getCar_series();
        } else {
            str2 = DiagnoseConstants.CAR_VENDER;
        }
        String str37 = str2;
        String str38 = DiagnoseConstants.MARKET_CAR_MODEL;
        if (C2787z.m4821a(str38)) {
            str3 = softVersion;
            str4 = TextUtils.isEmpty(DiagnoseInfo.getInstance().getModel()) ? "" : DiagnoseInfo.getInstance().getModel().trim();
        } else {
            str3 = softVersion;
            str4 = str38;
        }
        String str39 = DiagnoseConstants.RECORD_YEAR;
        if (C2787z.m4821a(str39)) {
            str5 = m5184a;
            str6 = TextUtils.isEmpty(DiagnoseInfo.getInstance().getYear()) ? "" : DiagnoseInfo.getInstance().getYear().trim();
        } else {
            str5 = m5184a;
            str6 = str39;
        }
        String str40 = DiagnoseConstants.DIAGNOSE_CURRENT_PATH;
        String str41 = str40 == null ? "" : str40;
        switch (i) {
            case 1:
                str7 = str6;
                str8 = str4;
                str9 = str37;
                pDFFaultCodeReportInfo = new PDFFaultCodeReportInfo();
                pDFFaultCodeReportInfo.title = getResources().getString(R.string.print_automobile_fault_diagnosis_test_report);
                break;
            case 2:
                str8 = str4;
                PDFBaseInfo pDFDataStreamInfo = new PDFDataStreamInfo();
                str7 = str6;
                str9 = str37;
                pDFDataStreamInfo.title = getResources().getString(R.string.data_stream_diagnosis_report);
                pDFFaultCodeReportInfo = pDFDataStreamInfo;
                break;
            default:
                str7 = str6;
                str8 = str4;
                str9 = str37;
                pDFFaultCodeReportInfo = null;
                break;
        }
        String engine = DiagnoseInfo.getInstance().getEngine();
        if (!C2744aa.m5128p(this.mContext)) {
            pDFFaultCodeReportInfo.strShopName = str13 + m4837a;
            pDFFaultCodeReportInfo.strAddr = str14 + m4837a2;
            pDFFaultCodeReportInfo.strZipCode = str33 + m4837a7;
        } else {
            pDFFaultCodeReportInfo.strShopName = m4837a;
            pDFFaultCodeReportInfo.strAddr = m4837a2;
            pDFFaultCodeReportInfo.strAddrLine1 = m4837a3;
            pDFFaultCodeReportInfo.strAddrLine2 = m4837a4;
            pDFFaultCodeReportInfo.strCity = m4837a5;
            pDFFaultCodeReportInfo.strProvince = m4837a6;
            pDFFaultCodeReportInfo.strZipCode = m4837a7;
        }
        pDFFaultCodeReportInfo.strPhone = str15 + m7122b(m4837a8);
        pDFFaultCodeReportInfo.strEmail = str16 + m4837a9;
        pDFFaultCodeReportInfo.strFax = str17 + m7122b(m4837a10);
        if (!TextUtils.isEmpty(m9591a3)) {
            pDFFaultCodeReportInfo.strCarUserName = str18 + m9591a3;
        }
        if (!TextUtils.isEmpty(str34)) {
            pDFFaultCodeReportInfo.diagnose_report_platenumber = str19 + str34;
        }
        if (!TextUtils.isEmpty(m9591a4)) {
            pDFFaultCodeReportInfo.strTester = str28 + m9591a4;
        }
        if (C2744aa.m5128p(this.mContext)) {
            pDFFaultCodeReportInfo.strcarType = str9;
            String str42 = str7;
            if (str42.equals("")) {
                str11 = "";
            } else {
                str11 = str42 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            pDFFaultCodeReportInfo.strCarYear = str11;
            String str43 = str8;
            if (str43.equals("")) {
                str12 = "";
            } else {
                str12 = str43 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            pDFFaultCodeReportInfo.strCarMode = str12;
        } else {
            pDFFaultCodeReportInfo.strcarType = str20 + str9;
            pDFFaultCodeReportInfo.strCarYear = str21 + str7;
            pDFFaultCodeReportInfo.strCarMode = str22 + str8;
        }
        pDFFaultCodeReportInfo.strCarVin = str23 + str36;
        pDFFaultCodeReportInfo.strODO = str24 + str5;
        pDFFaultCodeReportInfo.strCarVer = str25 + str3;
        pDFFaultCodeReportInfo.strApkVer = str26 + appVersion;
        if (TextUtils.isEmpty(str)) {
            if (C2744aa.m5128p(this.mContext)) {
                pDFFaultCodeReportInfo.strTime = str27 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + DateUtils.m5092a(DateUtils.m5094a(DateStyle.f15729g), DateStyle.f15731i);
            } else {
                pDFFaultCodeReportInfo.strTime = str27 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + DateUtils.m5094a(DateStyle.f15729g);
            }
        } else {
            pDFFaultCodeReportInfo.strTime = str27 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
        }
        pDFFaultCodeReportInfo.strPath = str29 + str41;
        if (TextUtils.isEmpty(m9591a5)) {
            str10 = m9591a2;
        } else {
            pDFFaultCodeReportInfo.strRemark = str30 + m9591a5;
            str10 = m9591a2;
        }
        pDFFaultCodeReportInfo.report_logo_path = str10;
        if (C2744aa.m5128p(this.mContext)) {
            pDFFaultCodeReportInfo.strRepairType = str32 + str35;
        } else {
            pDFFaultCodeReportInfo.strRepairType = str35;
        }
        pDFFaultCodeReportInfo.strEngineSize = str31 + engine;
        PreferencesManager preferencesManager2 = preferencesManager;
        pDFFaultCodeReportInfo.strSelectImagePath = preferencesManager2.m9591a("report_select_image_path");
        pDFFaultCodeReportInfo.strSymptoms = Html.fromHtml(preferencesManager2.m9591a("report_sensing_html")).toString();
        NLog.m9456a("msp", "info: " + pDFFaultCodeReportInfo.toString());
        return pDFFaultCodeReportInfo;
    }

    /* renamed from: b */
    public final String m7121b(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4855d());
        sb.append("/");
        sb.append(this.f12357d.mo7083i().getCarSoftName().toUpperCase(Locale.getDefault()).replaceAll("/", "&"));
        switch (i) {
            case 1:
                sb.append("(" + getString(R.string.tv_fault_title) + ")");
                break;
            case 2:
                sb.append("(" + getString(R.string.data_stream) + ")");
                break;
        }
        sb.append("_");
        sb.append(this.f12357d.mo7083i().getSerialNum());
        sb.append("_");
        sb.append(str.replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").trim());
        sb.append(".pdf");
        return sb.toString();
    }

    /* renamed from: a */
    public final String m7124a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12357d.mo7083i().getCarSoftName().toUpperCase(Locale.getDefault()).replaceAll("/", "&"));
        switch (i) {
            case 1:
                sb.append("(" + getString(R.string.tv_fault_title) + ")");
                break;
            case 2:
                sb.append("(" + getString(R.string.data_stream) + ")");
                break;
        }
        sb.append("_");
        sb.append(this.f12357d.mo7083i().getSerialNum());
        sb.append("_");
        DateUtils.m5094a(DateStyle.f15725c);
        DateUtils.m5094a(DateStyle.f15748z);
        sb.append(str.replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").trim());
        NLog.m9456a("yhx", "reportType=" + i + ",fileNameNoSuffix=" + sb.toString());
        return sb.toString();
    }

    /* renamed from: c */
    public final DiagReportOrHistoryInfo m7120c(String str, int i) {
        String vin;
        PreferencesManager m9595a = PreferencesManager.m9595a(this.mContext);
        PrintInfoProperties m4838a = PrintInfoProperties.m4838a();
        DiagReportOrHistoryInfo diagReportOrHistoryInfo = new DiagReportOrHistoryInfo();
        diagReportOrHistoryInfo.setType(i);
        diagReportOrHistoryInfo.setRepairType(m9595a.m9585b("repair_type", 0));
        diagReportOrHistoryInfo.setStrTester(m9595a.m9591a("last_tester"));
        diagReportOrHistoryInfo.setStrCustomer(m9595a.m9591a("report_customer_name"));
        switch (i) {
            case 0:
                diagReportOrHistoryInfo.setTitle(getResources().getString(R.string.print_automobile_fault_diagnosis_test_report));
                break;
            case 1:
                diagReportOrHistoryInfo.setTitle(getResources().getString(R.string.print_automobile_fault_diagnosis_test_report));
                break;
            case 2:
                diagReportOrHistoryInfo.setTitle(getResources().getString(R.string.data_stream_diagnosis_report));
                break;
            case 3:
                diagReportOrHistoryInfo.setTitle(getResources().getString(R.string.report_full_inspection));
                break;
            default:
                diagReportOrHistoryInfo.setTitle(getResources().getString(R.string.print_automobile_fault_diagnosis_test_report));
                break;
        }
        diagReportOrHistoryInfo.setReportLogoPath(m4838a.m4837a("report_logo_path"));
        diagReportOrHistoryInfo.setStrShopName(m4838a.m4837a("companyName"));
        diagReportOrHistoryInfo.setStrAddr(m4838a.m4837a("companyAddress"));
        diagReportOrHistoryInfo.setStrZipCode(m4838a.m4837a("company_zipcode"));
        diagReportOrHistoryInfo.setStrEmail(m4838a.m4837a("companyEmail"));
        diagReportOrHistoryInfo.setStrFax(m4838a.m4837a("companyFax"));
        diagReportOrHistoryInfo.setStrPhone(m4838a.m4837a("companyPhoneNumber"));
        diagReportOrHistoryInfo.setStrTester(m9595a.m9591a("last_tester"));
        diagReportOrHistoryInfo.setStrCustomer(m9595a.m9591a("report_customer_name"));
        diagReportOrHistoryInfo.setStrRemark(m9595a.m9591a("car_remark"));
        if (C2787z.m4821a(str)) {
            if (C2744aa.m5128p(this.mContext)) {
                str = DateUtils.m5092a(DateUtils.m5094a(DateStyle.f15729g), DateStyle.f15731i);
            } else {
                str = DateUtils.m5094a(DateStyle.f15729g);
            }
        }
        diagReportOrHistoryInfo.setStrTime(str);
        DiagCarInfo m5077e = DiagnoseUtils.m5086a().m5077e();
        String serialNo = m5077e != null ? m5077e.getSerialNo() : "";
        if (C2787z.m4821a(serialNo)) {
            serialNo = m9595a.m9591a("serialNo");
        }
        diagReportOrHistoryInfo.setStrSerialNo(serialNo);
        String plate = m5077e != null ? m5077e.getPlate() : "";
        if (C2787z.m4821a(plate)) {
            plate = DiagnoseConstants.LICENSEPLATE;
        }
        diagReportOrHistoryInfo.setDiagnoseReportPlatenumber(plate);
        if (m5077e != null) {
            vin = TextUtils.isEmpty(m5077e.getVin()) ? DiagnoseInfo.getInstance().getVin() : m5077e.getVin();
        } else {
            vin = DiagnoseInfo.getInstance().getVin();
        }
        if (TextUtils.isEmpty(vin)) {
            vin = m9595a.m9591a("car_vin");
        }
        diagReportOrHistoryInfo.setStrCarVin(vin);
        diagReportOrHistoryInfo.setStrODO(C2744aa.m5184a(this.mContext, DiagnoseConstants.DIAG_ODO_DATA, Boolean.FALSE));
        diagReportOrHistoryInfo.setStrSoftVer(m5077e != null ? m5077e.getSoftVersion() : "");
        diagReportOrHistoryInfo.setStrApkVer(m5077e != null ? m5077e.getApkVersion() : "");
        String car_series = m5077e != null ? m5077e.getCar_series() : "";
        if (C2787z.m4821a(car_series)) {
            car_series = DiagnoseInfo.getInstance().getMake();
        }
        diagReportOrHistoryInfo.setStrcarType(car_series);
        String model = m5077e != null ? m5077e.getModel() : "";
        if (C2787z.m4821a(model)) {
            model = DiagnoseInfo.getInstance().getModel();
        }
        diagReportOrHistoryInfo.setStrCarMode(model);
        String year = m5077e != null ? m5077e.getYear() : "";
        if (C2787z.m4821a(year)) {
            year = DiagnoseInfo.getInstance().getYear();
        }
        diagReportOrHistoryInfo.setStrCarYear(year);
        String str2 = DiagnoseConstants.DIAGNOSE_CURRENT_PATH;
        if (str2 == null) {
            str2 = "";
        }
        diagReportOrHistoryInfo.setStrPath(str2);
        diagReportOrHistoryInfo.setStrEngineSize(DiagnoseInfo.getInstance().getEngine());
        diagReportOrHistoryInfo.setStrSensing(Html.fromHtml(m9595a.m9591a("report_sensing_html")).toString());
        diagReportOrHistoryInfo.setStrSelectImagePath(m9595a.m9591a("report_select_image_path"));
        return diagReportOrHistoryInfo;
    }

    /* renamed from: g */
    public static boolean m7117g() {
        return DiagnoseUtils.m5086a().m5075g() != null && DiagnoseUtils.m5086a().m5075g().getDiagnoseStatue() == 0;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12357d.mo7083i().getDiagnoseStatue() != 0) {
                this.f12357d.mo7082j();
                this.f12357d.mo7093a((String) null, (String) null, 5);
                return true;
            } else if (this.f12357d.mo7083i().isDatastreamRecord()) {
                return true;
            } else {
                this.f12357d.mo7085f(0);
                return true;
            }
        }
        return false;
    }
}
