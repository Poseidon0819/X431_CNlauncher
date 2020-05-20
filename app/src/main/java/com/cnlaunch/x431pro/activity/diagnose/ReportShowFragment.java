package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.activity.diagnose.p218a.FaultCodeShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SystemContentsTableAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SystemStatusCodeListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.activity.pdf.PDFFaultCodeReportInfo;
import com.cnlaunch.x431pro.activity.pdf.ReportIntentService;
import com.cnlaunch.x431pro.activity.share.ShareActivity;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.ExpandableListViewForScorllView;
import com.cnlaunch.x431pro.widget.NoScrollerListView;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.PrinterFailrueDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bu */
/* loaded from: classes.dex */
public final class ReportShowFragment extends BaseDiagnoseFragment {

    /* renamed from: a */
    public static String f11588a = "Arabic";

    /* renamed from: A */
    private TextView f11589A;

    /* renamed from: B */
    private TextView f11590B;

    /* renamed from: C */
    private TextView f11591C;

    /* renamed from: D */
    private TextView f11592D;

    /* renamed from: E */
    private TextView f11593E;

    /* renamed from: F */
    private TextView f11594F;

    /* renamed from: G */
    private TextView f11595G;

    /* renamed from: H */
    private TextView f11596H;

    /* renamed from: I */
    private TextView f11597I;

    /* renamed from: J */
    private TextView f11598J;

    /* renamed from: O */
    private ExpandableListViewForScorllView f11603O;

    /* renamed from: P */
    private ExpandableListViewForScorllView f11604P;

    /* renamed from: Q */
    private SystemStatusCodeListAdapter f11605Q;

    /* renamed from: R */
    private SystemStatusCodeListAdapter f11606R;

    /* renamed from: S */
    private LinearLayout f11607S;

    /* renamed from: T */
    private LinearLayout f11608T;

    /* renamed from: U */
    private LinearLayout f11609U;

    /* renamed from: V */
    private LinearLayout f11610V;

    /* renamed from: W */
    private LinearLayout f11611W;

    /* renamed from: aA */
    private View f11615aA;

    /* renamed from: aB */
    private View f11616aB;

    /* renamed from: aC */
    private View f11617aC;

    /* renamed from: aD */
    private LinearLayout f11618aD;

    /* renamed from: aE */
    private TextView f11619aE;

    /* renamed from: aF */
    private TextView f11620aF;

    /* renamed from: aG */
    private TextView f11621aG;

    /* renamed from: aH */
    private final BroadcastReceiver f11622aH;

    /* renamed from: aI */
    private Handler f11623aI;

    /* renamed from: aa */
    private TextView f11624aa;

    /* renamed from: ab */
    private TextView f11625ab;

    /* renamed from: ac */
    private ScrollView f11626ac;

    /* renamed from: ae */
    private IconButton f11628ae;

    /* renamed from: af */
    private IconButton f11629af;

    /* renamed from: ag */
    private IconRadioButton f11630ag;

    /* renamed from: ai */
    private FaultCodeShowListAdapter f11632ai;

    /* renamed from: aj */
    private SystemContentsTableAdapter f11633aj;

    /* renamed from: aq */
    private ImageView f11640aq;

    /* renamed from: ar */
    private ImageView f11641ar;

    /* renamed from: au */
    private PDFFaultCodeReportInfo f11644au;

    /* renamed from: aw */
    private DiagReportOrHistoryInfo f11646aw;

    /* renamed from: ay */
    private String f11648ay;

    /* renamed from: az */
    private LinearLayout f11649az;

    /* renamed from: b */
    DisplayImageOptions f11650b;

    /* renamed from: j */
    private TextView f11651j;

    /* renamed from: k */
    private TextView f11652k;

    /* renamed from: l */
    private TextView f11653l;

    /* renamed from: m */
    private TextView f11654m;

    /* renamed from: n */
    private TextView f11655n;

    /* renamed from: o */
    private TextView f11656o;

    /* renamed from: p */
    private TextView f11657p;

    /* renamed from: q */
    private TextView f11658q;

    /* renamed from: r */
    private TextView f11659r;

    /* renamed from: s */
    private TextView f11660s;

    /* renamed from: t */
    private TextView f11661t;

    /* renamed from: u */
    private TextView f11662u;

    /* renamed from: v */
    private TextView f11663v;

    /* renamed from: w */
    private TextView f11664w;

    /* renamed from: x */
    private TextView f11665x;

    /* renamed from: y */
    private TextView f11666y;

    /* renamed from: z */
    private TextView f11667z;

    /* renamed from: K */
    private ArrayList<BasicFaultCodeBean> f11599K = null;

    /* renamed from: L */
    private ArrayList<BasicSystemStatusBean> f11600L = null;

    /* renamed from: M */
    private ArrayList<BasicSystemStatusBean> f11601M = null;

    /* renamed from: N */
    private ArrayList<BasicSystemStatusBean> f11602N = null;

    /* renamed from: X */
    private boolean f11612X = true;

    /* renamed from: Y */
    private boolean f11613Y = true;

    /* renamed from: Z */
    private boolean f11614Z = false;

    /* renamed from: ad */
    private NoScrollerListView f11627ad = null;

    /* renamed from: ah */
    private boolean f11631ah = false;

    /* renamed from: ak */
    private HashMap<String, Integer> f11634ak = new HashMap<>();

    /* renamed from: al */
    private String f11635al = "";

    /* renamed from: am */
    private String f11636am = "";

    /* renamed from: an */
    private int f11637an = 1;

    /* renamed from: ao */
    private String f11638ao = "";

    /* renamed from: ap */
    private String f11639ap = "";

    /* renamed from: as */
    private boolean f11642as = false;

    /* renamed from: at */
    private boolean f11643at = false;

    /* renamed from: av */
    private boolean f11645av = false;

    /* renamed from: ax */
    private int f11647ax = 0;

    public ReportShowFragment() {
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17119c = R.drawable.u2_normal;
        c3010a.f17118b = R.drawable.u2_normal;
        this.f11650b = c3010a.m4193a();
        this.f11622aH = new C2085bw(this);
        this.f11623aI = new HandlerC2086bx(this);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("date")) {
                this.f11648ay = arguments.getString("date");
            }
            if (arguments.containsKey("isRemote")) {
                this.f11645av = arguments.getBoolean("isRemote");
            }
            String string = arguments.getString("Flag");
            if (string != null && string.equalsIgnoreCase("SystemStatus")) {
                this.f11647ax = 1;
                this.f11600L = (ArrayList) arguments.getSerializable("SystemStatus");
                ArrayList<BasicSystemStatusBean> arrayList = this.f11600L;
                if (arrayList != null) {
                    this.f11601M = SystemStatusCodeListAdapter.m7476a(arrayList, SystemStatusCodeListAdapter.f11449b);
                    this.f11602N = SystemStatusCodeListAdapter.m7476a(this.f11600L, SystemStatusCodeListAdapter.f11450c);
                } else {
                    this.f11601M = new ArrayList<>();
                    this.f11602N = new ArrayList<>();
                }
                this.f11614Z = true;
            } else {
                this.f11647ax = 0;
                this.f11599K = (ArrayList) arguments.getSerializable("FaultCode");
                String sysId = DiagnoseInfo.getInstance().getSysId();
                BasicSystemStatusBean basicSystemStatusBean = new BasicSystemStatusBean();
                basicSystemStatusBean.setSystemName(sysId);
                basicSystemStatusBean.setSystemFaultCodeBean(this.f11599K);
                if (DiagnoseConstants.IS_SET_NO_DTC) {
                    this.f11602N = new ArrayList<>();
                    basicSystemStatusBean.getSystemFaultCodeBean().clear();
                    this.f11602N.add(basicSystemStatusBean);
                    this.f11600L = this.f11602N;
                } else {
                    this.f11601M = new ArrayList<>();
                    this.f11601M.add(basicSystemStatusBean);
                    this.f11600L = this.f11601M;
                }
            }
            this.f12360g = arguments.getString("fileName");
            this.f11631ah = !arguments.getBoolean("CommonFaultCode");
            if (this.f11599K == null || !this.f11631ah) {
                return;
            }
            m7450d();
        }
    }

    /* renamed from: a */
    private static String m7458a(Context context, String str) {
        try {
            Properties properties = new Properties();
            InputStream open = context.getAssets().open("config.properties");
            if (open != null) {
                properties.load(open);
                return properties.getProperty(str);
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onDestroyView() {
        DiagnoseConstants.FAULTCODE_REFRESH = true;
        DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = true;
        try {
            getActivity().unregisterReceiver(this.f11622aH);
        } catch (Exception unused) {
        }
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11639ap = DateUtils.m5094a(DateStyle.f15725c);
        this.f11638ao = DateUtils.m5094a(DateStyle.f15748z);
        this.f11644au = (PDFFaultCodeReportInfo) m7123a(this.f11648ay, 1);
        this.f11646aw = m7120c(this.f11648ay, this.f11647ax);
        this.f11642as = Boolean.valueOf(m7458a(getActivity(), "is_show_odo")).booleanValue();
        this.f11643at = C2744aa.m5166c();
        this.f11649az = (LinearLayout) this.mContentView.findViewById(R.id.ll_top);
        this.f11610V = (LinearLayout) getActivity().findViewById(R.id.ll_report_remark);
        if (C2744aa.m5128p(this.mContext)) {
            this.f11615aA = LayoutInflater.from(this.mContext).inflate(R.layout.view_factory_info_matco, (ViewGroup) null);
            this.f11616aB = LayoutInflater.from(this.mContext).inflate(R.layout.view_car_info_matco, (ViewGroup) null);
            this.f11617aC = LayoutInflater.from(this.mContext).inflate(R.layout.view_report_title_macto, (ViewGroup) null);
            this.f11608T = (LinearLayout) getActivity().findViewById(R.id.ll_report_symptoms);
            this.f11609U = (LinearLayout) getActivity().findViewById(R.id.ll_symptoms_item_container);
            this.f11649az.addView(this.f11615aA);
            this.f11649az.addView(this.f11617aC);
            this.f11649az.addView(this.f11616aB);
            this.f11608T.setVisibility(0);
            this.f11610V.setVisibility(0);
        } else {
            this.f11615aA = LayoutInflater.from(this.mContext).inflate(R.layout.view_factory_info, (ViewGroup) null);
            this.f11616aB = LayoutInflater.from(this.mContext).inflate(R.layout.view_car_info, (ViewGroup) null);
            this.f11617aC = LayoutInflater.from(this.mContext).inflate(R.layout.view_report_title, (ViewGroup) null);
            this.f11649az.addView(this.f11617aC);
            this.f11649az.addView(this.f11615aA);
            this.f11649az.addView(this.f11616aB);
            this.f11610V.setVisibility(0);
        }
        this.f11651j = (TextView) this.f11615aA.findViewById(R.id.tv_report_shopname);
        this.f11652k = (TextView) this.f11615aA.findViewById(R.id.tv_report_address);
        this.f11653l = (TextView) this.f11615aA.findViewById(R.id.tv_report_telephone);
        this.f11655n = (TextView) this.f11615aA.findViewById(R.id.tv_report_email);
        this.f11656o = (TextView) this.f11615aA.findViewById(R.id.tv_report_fax);
        this.f11657p = (TextView) this.f11615aA.findViewById(R.id.tv_report_zipcode);
        this.f11640aq = (ImageView) getActivity().findViewById(R.id.iv_factory_photo);
        ImageLoader.m4191a().m4188a("file://" + this.f11644au.report_logo_path, this.f11640aq, this.f11650b);
        this.f11667z = (TextView) this.f11616aB.findViewById(R.id.tv_report_carusername);
        this.f11654m = (TextView) this.f11616aB.findViewById(R.id.tv_report_carnumber);
        this.f11590B = (TextView) this.f11616aB.findViewById(R.id.tv_report_carbrand);
        this.f11659r = (TextView) this.f11616aB.findViewById(R.id.tv_report_caryear);
        this.f11591C = (TextView) this.f11616aB.findViewById(R.id.tv_report_cartype);
        this.f11660s = (TextView) this.f11616aB.findViewById(R.id.tv_report_carvin);
        this.f11661t = (TextView) this.f11616aB.findViewById(R.id.tv_report_odo);
        this.f11662u = (TextView) this.f11616aB.findViewById(R.id.tv_report_vehicle_ver);
        this.f11663v = (TextView) this.f11616aB.findViewById(R.id.tv_report_apk_ver);
        this.f11658q = (TextView) this.f11616aB.findViewById(R.id.tv_report_date);
        this.f11589A = (TextView) this.f11616aB.findViewById(R.id.tv_report_tester);
        this.f11666y = (TextView) this.f11616aB.findViewById(R.id.tv_report_testpath);
        this.f11592D = (TextView) this.f11616aB.findViewById(R.id.tv_report_voltage);
        this.f11593E = (TextView) this.f11616aB.findViewById(R.id.tv_report_system_numbers);
        this.f11594F = (TextView) this.f11616aB.findViewById(R.id.tv_report_repair_type);
        this.f11595G = (TextView) this.f11616aB.findViewById(R.id.tv_report_engine_size);
        this.f11593E = (TextView) this.f11616aB.findViewById(R.id.tv_report_system_numbers);
        this.f11641ar = (ImageView) this.f11616aB.findViewById(R.id.iv_car_photo);
        this.f11598J = (TextView) this.mContentView.findViewById(R.id.tv_report_symptoms_title);
        this.f11597I = (TextView) this.mContentView.findViewById(R.id.tv_report_remark);
        this.f11664w = (TextView) getActivity().findViewById(R.id.tv_report_carLeft);
        this.f11665x = (TextView) getActivity().findViewById(R.id.tv_report_carright);
        this.f11596H = (TextView) getActivity().findViewById(R.id.tv_report_repair_type);
        this.f11618aD = (LinearLayout) this.mContentView.findViewById(R.id.ll_report_table_title);
        this.f11619aE = (TextView) this.mContentView.findViewById(R.id.tv_report_table_name);
        this.f11620aF = (TextView) this.mContentView.findViewById(R.id.tv_report_table_state);
        this.f11621aG = (TextView) this.mContentView.findViewById(R.id.tv_report_table_description);
        m7457a(this.f11596H, this.f11644au.strRepairType);
        this.f11651j.setText(this.f11644au.strShopName);
        this.f11653l.setText(this.f11644au.strPhone);
        this.f11655n.setText(this.f11644au.strEmail);
        this.f11656o.setText(this.f11644au.strFax);
        m7457a(this.f11667z, this.f11644au.strCarUserName);
        m7457a(this.f11654m, this.f11644au.diagnose_report_platenumber);
        m7457a(this.f11589A, this.f11644au.strTester);
        m7457a(this.f11597I, this.f11644au.strRemark);
        String str = this.f11644au.strCarYear + this.f11644au.strCarMode + this.f11644au.strcarType;
        if (C2744aa.m5128p(this.mContext)) {
            this.f11590B.setText(str);
            m7457a(this.f11652k, this.f11644au.strAddrLine1 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11644au.strAddrLine2);
            m7457a(this.f11657p, this.f11644au.strCity + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11644au.strProvince + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11644au.strZipCode);
        } else {
            this.f11590B.setText(this.f11644au.strcarType);
            this.f11652k.setText(this.f11644au.strAddr);
            this.f11657p.setText(this.f11644au.strZipCode);
            this.f11659r.setText(this.f11644au.strCarYear);
        }
        this.f11660s.setText(this.f11644au.strCarVin);
        if (this.f11642as) {
            this.f11661t.setText(this.f11644au.strODO);
        } else {
            this.f11661t.setVisibility(8);
        }
        if (!this.f11643at) {
            this.f11662u.setText(this.f11644au.strCarVer);
            this.f11663v.setText(this.f11644au.strApkVer);
        } else {
            this.f11662u.setVisibility(8);
            this.f11663v.setVisibility(8);
        }
        this.f11666y.setText(this.f11644au.strPath);
        this.f11591C.setText(this.f11644au.strCarMode);
        this.f11658q.setText(this.f11644au.strTime);
        Iterator<BasicSystemStatusBean> it = this.f11600L.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getSystemFaultCodeBean().size() != 0) {
                i++;
            }
        }
        if (C2744aa.m5128p(this.mContext)) {
            this.f11595G.setText(this.f11644au.strEngineSize);
            m7457a(this.f11594F, this.f11644au.strRepairType);
            m7457a(this.f11593E, "Found Codes in " + i + " of " + this.f11600L.size() + " systems");
            this.f11596H.setVisibility(8);
            m7452b(this.f11644au.strSymptoms);
            ImageLoader.m4191a().m4188a("file://" + this.f11644au.strSelectImagePath, this.f11641ar, this.f11650b);
        }
        m7455a(this.f11631ah);
        this.f11627ad = (NoScrollerListView) getActivity().findViewById(R.id.lv_report);
        if (C2744aa.m5128p(this.mContext)) {
            this.f11633aj = new SystemContentsTableAdapter(getActivity(), this.f11600L);
            this.f11627ad.setAdapter((ListAdapter) this.f11633aj);
            this.mContentView.findViewById(R.id.tv_report_fault_found).setVisibility(8);
            this.mContentView.findViewById(R.id.tv_report_result).setVisibility(8);
            this.f11618aD.setVisibility(0);
            this.f11656o.setVisibility(0);
            if (C2787z.m4821a(this.f11644au.strZipCode)) {
                this.f11657p.setVisibility(8);
            } else {
                this.f11657p.setVisibility(0);
            }
        } else {
            this.f11656o.setVisibility(8);
            this.f11632ai = new FaultCodeShowListAdapter(this.f11599K, getActivity(), (byte) 0);
            this.f11627ad.setAdapter((ListAdapter) this.f11632ai);
            this.f11627ad.setDivider(null);
        }
        this.f11626ac = (ScrollView) getActivity().findViewById(R.id.sv_report);
        this.f11603O = (ExpandableListViewForScorllView) getActivity().findViewById(R.id.expand_listview_faultcode_err);
        this.f11603O.setDivider(null);
        this.f11603O.setScrollView(this.f11626ac);
        ArrayList<BasicSystemStatusBean> arrayList = this.f11601M;
        if (arrayList == null || arrayList.size() == 0) {
            this.f11603O.setVisibility(8);
        }
        this.f11604P = (ExpandableListViewForScorllView) getActivity().findViewById(R.id.expand_listview_faultcode_ok);
        this.f11604P.setGroupIndicator(null);
        this.f11604P.setDivider(null);
        this.f11604P.setScrollView(this.f11626ac);
        ArrayList<BasicSystemStatusBean> arrayList2 = this.f11602N;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.f11604P.setVisibility(8);
        }
        this.f11607S = (LinearLayout) getActivity().findViewById(R.id.normal_code);
        this.f11611W = (LinearLayout) getActivity().findViewById(R.id.err_code);
        this.f11607S.setOnClickListener(this);
        this.f11611W.setOnClickListener(this);
        this.f11624aa = (TextView) getActivity().findViewById(R.id.err_code_num);
        this.f11625ab = (TextView) getActivity().findViewById(R.id.normal_code_num);
        if (!C2744aa.m5128p(this.mContext) && this.f11614Z) {
            this.f11627ad.setVisibility(8);
            this.f11605Q = new SystemStatusCodeListAdapter(getActivity(), this.f11601M, SystemStatusCodeListAdapter.f11449b);
            this.f11606R = new SystemStatusCodeListAdapter(getActivity(), this.f11602N, SystemStatusCodeListAdapter.f11450c);
            this.f11603O.setAdapter(this.f11605Q);
            this.f11604P.setAdapter(this.f11606R);
            int count = this.f11603O.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.f11603O.expandGroup(i2);
            }
            int groupCount = this.f11605Q.getGroupCount();
            this.f11624aa.setText("( " + groupCount + " )");
            int groupCount2 = this.f11606R.getGroupCount();
            this.f11625ab.setText("( " + groupCount2 + " )");
            if (groupCount2 == 0) {
                this.f11613Y = false;
                this.f11604P.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11603O.getLayoutParams();
                layoutParams.height = (int) TypedValue.applyDimension(1, 600.0f, getResources().getDisplayMetrics());
                this.f11603O.setLayoutParams(layoutParams);
            }
        } else {
            getActivity().findViewById(R.id.list_codes).setVisibility(8);
        }
        this.f11628ae = (IconButton) getActivity().findViewById(R.id.btn_share);
        this.f11628ae.setOnClickListener(this);
        this.f11628ae.setEnabled(false);
        this.f11629af = (IconButton) getActivity().findViewById(R.id.btn_del);
        this.f11629af.setOnClickListener(this);
        this.f11630ag = (IconRadioButton) getActivity().findViewById(R.id.btn_report_print);
        this.f11630ag.setOnClickListener(this);
        if (C2787z.m4821a(this.f12360g)) {
            this.f11635al = m7121b(this.f11639ap + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11638ao, 1);
        } else {
            this.f11635al = PathUtils.m4855d() + "/" + this.f12360g + ".pdf";
        }
        this.f11636am = m7444h();
        this.btn_left.setVisibility(4);
        this.menuUpdateTip.setVisibility(8);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.cnlaunch.report.action_result");
        this.mContext.registerReceiver(this.f11622aH, intentFilter);
        if (C2744aa.m5166c()) {
            this.f12358e.setVisibility(8);
            this.f12359f.setVisibility(8);
            m7454b(1);
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.menuUpdateTip.setVisibility(8);
        PDFFaultCodeReportInfo pDFFaultCodeReportInfo = this.f11644au;
        if (pDFFaultCodeReportInfo != null) {
            pDFFaultCodeReportInfo.strODO = this.mContext.getResources().getString(R.string.diagnose_report_odo) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + C2744aa.m5184a(this.mContext, DiagnoseConstants.DIAG_ODO_DATA, Boolean.FALSE);
            this.f11661t.setText(this.f11644au.strODO);
        }
    }

    /* renamed from: d */
    private void m7450d() {
        for (int i = 0; i < this.f11599K.size(); i++) {
            String status = this.f11599K.get(i).getStatus();
            if (!TextUtils.isEmpty(status)) {
                if (status.contains("|")) {
                    String[] split = status.split("\\|");
                    if (split.length > 1) {
                        status = split[1];
                    }
                } else {
                    status = this.f11599K.get(i).getSys();
                }
                if (this.f11634ak.containsKey(status)) {
                    HashMap<String, Integer> hashMap = this.f11634ak;
                    hashMap.put(status, Integer.valueOf(hashMap.get(status).intValue() + 1));
                } else {
                    this.f11634ak.put(status, 1);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m7457a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    /* renamed from: b */
    private void m7452b(String str) {
        for (String str2 : str.split(Html.fromHtml("<br>").toString())) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.report_symptoms_item, (ViewGroup) null);
            textView.setLayoutParams(layoutParams);
            textView.setText(str2);
            this.f11609U.addView(textView);
        }
    }

    /* renamed from: d */
    private void m7448d(String str, int i) {
        if (i == 2) {
            str = str.replace(".pdf", ".txt");
        }
        if (new File(str).exists()) {
            this.f11628ae.setEnabled(true);
            NToast.m9450a(this.mContext, (int) R.string.diagnose_report_saved_success);
            this.f12358e.setEnabled(true);
            this.f12359f.setEnabled(true);
            return;
        }
        this.f12358e.setEnabled(false);
        this.f12359f.setEnabled(false);
        if (i == 2) {
            Intent intent = new Intent(getActivity(), ReportIntentService.class);
            intent.setAction("com.cnlaunch.report.action_save");
            intent.putExtra("txt_content", this.f11636am);
            intent.putExtra("reprot_type", "txt");
            intent.putExtra("filepath", str);
            getActivity().startService(intent);
        } else if (i == 1) {
            LoadDialog.m4685a(this.mContext, (int) R.string.save_pdf_report);
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo = this.f11644au;
            pDFFaultCodeReportInfo.strErrorCode = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(R.string.tv_fault_errcode);
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo2 = this.f11644au;
            pDFFaultCodeReportInfo2.strErrorCodeNum = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11624aa.getText().toString();
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo3 = this.f11644au;
            pDFFaultCodeReportInfo3.strErrorStatus = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getResources().getString(R.string.tv_status_abnormal);
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo4 = this.f11644au;
            pDFFaultCodeReportInfo4.strNormalCode = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(R.string.tv_fault_normalcode);
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo5 = this.f11644au;
            pDFFaultCodeReportInfo5.strNormalCodeNum = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f11625ab.getText().toString();
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo6 = this.f11644au;
            pDFFaultCodeReportInfo6.strNormalStatus = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(R.string.tv_status_normal);
            this.f11646aw.setRemoteReport(this.f11645av);
            this.f11644au.strCarLeft = this.f11664w.getText().toString();
            this.f11644au.strCarRight = this.f11665x.getText().toString();
            PDFFaultCodeReportInfo pDFFaultCodeReportInfo7 = this.f11644au;
            pDFFaultCodeReportInfo7.pdfFileName = str;
            pDFFaultCodeReportInfo7.mIsSystemStatusCode = this.f11614Z;
            pDFFaultCodeReportInfo7.bNeedSumSys = this.f11631ah;
            pDFFaultCodeReportInfo7.faultCodeList = this.f11599K;
            pDFFaultCodeReportInfo7.systemStatusList = this.f11600L;
            pDFFaultCodeReportInfo7.systemStatusList_err = this.f11601M;
            pDFFaultCodeReportInfo7.systemStatusList_normal = this.f11602N;
            pDFFaultCodeReportInfo7.pdf_type = 1;
            this.f11646aw.setPdfFileName(str);
            this.f11646aw.setType(this.f11647ax);
            this.f11646aw.setSystemStateBeanList(this.f11600L);
            if (this.f11644au != null) {
                Intent intent2 = new Intent(getActivity(), ReportIntentService.class);
                intent2.setAction("com.cnlaunch.report.action_save");
                intent2.putExtra("fault_code_report_content", this.f11644au);
                intent2.putExtra("reprot_type", PdfSchema.DEFAULT_XPATH_ID);
                getActivity().startService(intent2);
            }
        }
    }

    /* renamed from: b */
    private void m7454b(int i) {
        if (FileUtils.m5027a() > 5) {
            m7448d(this.f11635al, i);
            return;
        }
        this.f12358e.setEnabled(true);
        this.f12359f.setEnabled(true);
        NToast.m9450a(this.mContext, (int) R.string.sd_no_storage_space);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: a */
    public final void mo7125a(int i) {
        super.mo7125a(i);
        m7454b(i);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.btn_report_print) {
            LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
            request(20013);
        } else if (id == R.id.btn_share) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("FilePath", this.f11635al);
            intent.putExtras(bundle);
            intent.setClass(getActivity(), ShareActivity.class);
            getActivity().startActivity(intent);
        } else if (id == R.id.btn_del) {
            new C2084bv(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.mine_dialog_content_delreport, true);
        } else if (id == R.id.normal_code) {
            if (this.f11613Y) {
                this.f11613Y = false;
                this.f11604P.setVisibility(8);
                return;
            }
            this.f11613Y = true;
            this.f11604P.setVisibility(0);
        } else if (id == R.id.err_code) {
            if (this.f11612X) {
                this.f11612X = false;
                this.f11603O.setVisibility(8);
                return;
            }
            this.f11612X = true;
            this.f11603O.setVisibility(0);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            this.btn_left.setVisibility(0);
            m7442i();
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_reprotshow);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_reportshow, viewGroup, false);
    }

    /* renamed from: h */
    private String m7444h() {
        StringBuilder sb = new StringBuilder();
        if (!C2744aa.m5128p(this.mContext)) {
            sb.append(this.f11596H.getText());
            sb.append(HttpProxyConstants.CRLF);
            sb.append(this.f11644au.title + HttpProxyConstants.CRLF);
        }
        sb.append(((Object) this.f11651j.getText()) + HttpProxyConstants.CRLF);
        sb.append(((Object) this.f11652k.getText()) + HttpProxyConstants.CRLF);
        sb.append(((Object) this.f11653l.getText()) + HttpProxyConstants.CRLF);
        sb.append(((Object) this.f11655n.getText()) + HttpProxyConstants.CRLF);
        if (C2744aa.m5128p(this.mContext)) {
            sb.append(this.f11644au.title + HttpProxyConstants.CRLF);
        }
        if (C2744aa.m5128p(this.mContext)) {
            if (!TextUtils.isEmpty(this.f11644au.strCarUserName)) {
                sb.append(((Object) this.f11667z.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(((Object) this.f11590B.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11660s.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11595G.getText()) + HttpProxyConstants.CRLF);
            if (this.f11642as) {
                sb.append(((Object) this.f11661t.getText()) + HttpProxyConstants.CRLF);
            }
            if (!TextUtils.isEmpty(this.f11644au.diagnose_report_platenumber)) {
                sb.append(((Object) this.f11654m.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(this.f11594F.getText());
            sb.append(HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11658q.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11593E.getText()) + HttpProxyConstants.CRLF);
            if (this.f11592D.isShown()) {
                sb.append(((Object) this.f11592D.getText()) + HttpProxyConstants.CRLF);
            }
            if (!TextUtils.isEmpty(this.f11644au.strTester)) {
                sb.append(((Object) this.f11589A.getText()) + HttpProxyConstants.CRLF);
            }
            if (this.f11591C.isShown()) {
                sb.append(((Object) this.f11591C.getText()) + HttpProxyConstants.CRLF);
            }
            if (this.f11659r.isShown()) {
                sb.append(((Object) this.f11659r.getText()) + HttpProxyConstants.CRLF);
            }
            if (this.f11662u.isShown()) {
                sb.append(((Object) this.f11662u.getText()) + HttpProxyConstants.CRLF);
            }
            if (this.f11663v.isShown()) {
                sb.append(((Object) this.f11663v.getText()) + HttpProxyConstants.CRLF);
            }
            if (this.f11666y.isShown()) {
                sb.append(((Object) this.f11666y.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(getString(R.string.report_test_result) + HttpProxyConstants.CRLF);
            ArrayList<BasicSystemStatusBean> arrayList = this.f11600L;
            if (arrayList != null) {
                Iterator<BasicSystemStatusBean> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicSystemStatusBean next = it.next();
                    sb.append(next.getSystemName() + " \t " + next.getSystemFaultCodeBean().size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.mContext.getString(R.string.report_codes) + " \r\n");
                    ArrayList<BasicFaultCodeBean> systemFaultCodeBean = next.getSystemFaultCodeBean();
                    if (systemFaultCodeBean != null) {
                        int i = 0;
                        while (i < systemFaultCodeBean.size()) {
                            BasicFaultCodeBean basicFaultCodeBean = systemFaultCodeBean.get(i);
                            i++;
                            sb.append(i);
                            sb.append(".");
                            sb.append(basicFaultCodeBean.getTitle());
                            sb.append(":");
                            sb.append(basicFaultCodeBean.getContext());
                            sb.append(HttpProxyConstants.CRLF);
                        }
                    }
                }
            }
        } else {
            if (!TextUtils.isEmpty(this.f11644au.strCarUserName)) {
                sb.append(((Object) this.f11667z.getText()) + HttpProxyConstants.CRLF);
            }
            if (!TextUtils.isEmpty(this.f11644au.diagnose_report_platenumber)) {
                sb.append(((Object) this.f11654m.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(((Object) this.f11660s.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11659r.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11590B.getText()) + HttpProxyConstants.CRLF);
            sb.append(((Object) this.f11591C.getText()) + HttpProxyConstants.CRLF);
            if (this.f11642as) {
                sb.append(((Object) this.f11661t.getText()) + HttpProxyConstants.CRLF);
            }
            if (!this.f11643at) {
                sb.append(((Object) this.f11662u.getText()) + HttpProxyConstants.CRLF);
                sb.append(((Object) this.f11663v.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(((Object) this.f11658q.getText()) + HttpProxyConstants.CRLF);
            if (!TextUtils.isEmpty(this.f11644au.strTester)) {
                sb.append(((Object) this.f11589A.getText()) + HttpProxyConstants.CRLF);
            }
            sb.append(((Object) this.f11666y.getText()) + HttpProxyConstants.CRLF);
            if (this.f11631ah) {
                sb.append(((Object) this.f11664w.getText()) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((Object) this.f11665x.getText()));
            }
            sb.append(getString(R.string.report_diangnose_result) + HttpProxyConstants.CRLF);
            if (this.f11614Z) {
                sb.append(this.mContext.getString(R.string.tv_fault_errcode) + this.f11624aa.getText().toString() + HttpProxyConstants.CRLF);
                ArrayList<BasicSystemStatusBean> arrayList2 = this.f11601M;
                if (arrayList2 != null) {
                    Iterator<BasicSystemStatusBean> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        BasicSystemStatusBean next2 = it2.next();
                        sb.append(next2.getSystemName() + " \t (" + next2.getSystemFaultCodeBean().size() + " ) " + this.mContext.getString(R.string.tv_status_abnormal) + HttpProxyConstants.CRLF);
                        ArrayList<BasicFaultCodeBean> systemFaultCodeBean2 = next2.getSystemFaultCodeBean();
                        if (systemFaultCodeBean2 != null) {
                            Iterator<BasicFaultCodeBean> it3 = systemFaultCodeBean2.iterator();
                            while (it3.hasNext()) {
                                BasicFaultCodeBean next3 = it3.next();
                                if (next3.getContext().equals("CONSULT HANDBOOK")) {
                                    next3.setContext(this.mContext.getString(R.string.diagnose_consult_handbook));
                                }
                                sb.append(next3.getTitle() + "\t" + next3.getContext() + "\t" + next3.getStatus() + HttpProxyConstants.CRLF);
                            }
                        }
                    }
                }
                sb.append(this.mContext.getString(R.string.tv_fault_normalcode) + this.f11625ab.getText().toString() + HttpProxyConstants.CRLF);
                ArrayList<BasicSystemStatusBean> arrayList3 = this.f11602N;
                if (arrayList3 != null) {
                    Iterator<BasicSystemStatusBean> it4 = arrayList3.iterator();
                    while (it4.hasNext()) {
                        sb.append(it4.next().getSystemName() + " \t " + this.mContext.getString(R.string.tv_status_normal) + " \t\r\n");
                    }
                }
            } else {
                Iterator<BasicFaultCodeBean> it5 = this.f11599K.iterator();
                while (it5.hasNext()) {
                    BasicFaultCodeBean next4 = it5.next();
                    if (next4.getContext().equals("CONSULT HANDBOOK")) {
                        next4.setContext(this.mContext.getString(R.string.diagnose_consult_handbook));
                    }
                    String sys = next4.getSys();
                    if (TextUtils.isEmpty(sys)) {
                        sb.append(next4.getTitle() + "\t" + next4.getContext() + "\t" + next4.getStatus() + HttpProxyConstants.CRLF);
                    } else {
                        sb.append(next4.getTitle() + "\t" + next4.getContext() + "\t" + next4.getStatus() + "\t" + sys + HttpProxyConstants.CRLF);
                    }
                }
            }
        }
        if (C2744aa.m5128p(this.mContext) && this.f11608T.isShown()) {
            sb.append(((Object) this.f11598J.getText()) + HttpProxyConstants.CRLF);
            String[] split = this.f11644au.strSymptoms.split(Html.fromHtml("<br>").toString());
            for (int i2 = 0; i2 < split.length; i2++) {
                sb.append(split[i2] + "\t\r\n");
            }
        }
        if (!TextUtils.isEmpty(this.f11644au.strRemark)) {
            sb.append(((Object) this.f11597I.getText()) + HttpProxyConstants.CRLF);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m7455a(boolean z) {
        if (!z || C2744aa.m5128p(this.mContext)) {
            return;
        }
        int i = 0;
        getActivity().findViewById(R.id.layout_report_showCarLog).setVisibility(0);
        String str = "";
        String str2 = "";
        Set<String> keySet = this.f11634ak.keySet();
        if (keySet != null) {
            for (String str3 : keySet) {
                if (!TextUtils.isEmpty(str3) && str3.compareToIgnoreCase("null") != 0) {
                    if (i % 2 == 0) {
                        str = str + str3 + " (" + this.f11634ak.get(str3) + ")\n";
                    } else {
                        str2 = str2 + str3 + " (" + this.f11634ak.get(str3) + ")\n";
                    }
                    i++;
                }
            }
        }
        this.f11664w.setText(str);
        this.f11665x.setText(str2);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 20013) {
            return Integer.valueOf(PrintDataUtils.m4935a(this.mContext, this.f11636am));
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 20013) {
            this.f11623aI.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            Integer num = (Integer) obj;
            NetPOSPrinterUtil.m9439a(getActivity(), num.intValue());
            if (num.intValue() == 4095) {
                if (PreferencesManager.m9595a(this.mContext).m9583b(C1947h.f10555g, false)) {
                    new PrinterFailrueDialog(this.mContext).show();
                    return;
                } else {
                    NToast.m9447b(this.mContext, (int) R.string.print_connect_printer);
                    return;
                }
            }
            return;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 20013) {
            this.f11623aI.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            NToast.m9450a(getActivity(), (int) R.string.print_error_fail);
            return;
        }
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (new File(this.f11635al).exists()) {
            this.f11628ae.setEnabled(true);
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.btn_left.setVisibility(0);
        m7442i();
    }

    /* renamed from: i */
    private void m7442i() {
        if (PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNumForHeavyduty", 0) > 0) {
            this.menuUpdateTip.setVisibility(0);
        } else {
            this.menuUpdateTip.setVisibility(8);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        StringBuilder sb = new StringBuilder();
        Iterator<BasicFaultCodeBean> it = this.f11599K.iterator();
        while (it.hasNext()) {
            BasicFaultCodeBean next = it.next();
            if (next.getContext().equals("CONSULT HANDBOOK")) {
                next.setContext(this.mContext.getString(R.string.diagnose_consult_handbook));
            }
            String sys = next.getSys();
            if (!TextUtils.isEmpty(sys)) {
                sb.append(next.getTitle() + "\t" + next.getContext() + "\t" + next.getStatus() + "\t" + sys + "\n");
            } else {
                sb.append(next.getTitle() + "\t" + next.getContext() + "\t" + next.getStatus() + "\n");
            }
        }
        return sb.toString();
    }
}
