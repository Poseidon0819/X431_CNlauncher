package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseProcessInfoUtil;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SystemStatusCodeListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.module.p261g.C2730b;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.InputReportInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.InputSensingDialog;
import com.cnlaunch.x431pro.widget.p290a.InputVehicleInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ce */
/* loaded from: classes.dex */
public class SystemStatusCodeFragment extends BaseDiagnoseFragment {

    /* renamed from: A */
    private IconButton f12237A;

    /* renamed from: B */
    private String f12238B;

    /* renamed from: C */
    private String f12239C;

    /* renamed from: E */
    private WaitDialog f12241E;

    /* renamed from: F */
    private ProgressBar f12242F;

    /* renamed from: G */
    private Handler f12243G;

    /* renamed from: H */
    private SerializableMap f12244H;

    /* renamed from: M */
    private InputReportInfoDialog f12249M;

    /* renamed from: N */
    private LinearLayout f12250N;

    /* renamed from: O */
    private LinearLayout f12251O;

    /* renamed from: P */
    private LinearLayout f12252P;

    /* renamed from: S */
    private TextView f12255S;

    /* renamed from: T */
    private TextView f12256T;

    /* renamed from: U */
    private String f12257U;

    /* renamed from: Z */
    private InputVehicleInfoDialog f12262Z;

    /* renamed from: aa */
    private InputSensingDialog f12264aa;

    /* renamed from: ab */
    private boolean f12265ab;

    /* renamed from: m */
    private ExpandableListView f12271m;

    /* renamed from: n */
    private ExpandableListView f12272n;

    /* renamed from: o */
    private SystemStatusCodeListAdapter f12273o;

    /* renamed from: p */
    private SystemStatusCodeListAdapter f12274p;

    /* renamed from: q */
    private String f12275q;

    /* renamed from: r */
    private String f12276r;

    /* renamed from: s */
    private IconRadioButton f12277s;

    /* renamed from: t */
    private IconRadioButton f12278t;

    /* renamed from: u */
    private IconButton f12279u;

    /* renamed from: v */
    private IconButton f12280v;

    /* renamed from: w */
    private IconButton f12281w;

    /* renamed from: x */
    private IconButton f12282x;

    /* renamed from: y */
    private IconButton f12283y;

    /* renamed from: z */
    private IconButton f12284z;

    /* renamed from: k */
    private ArrayList<BasicSystemStatusBean> f12269k = null;

    /* renamed from: a */
    public ArrayList<BasicSystemStatusBean> f12263a = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<BasicSystemStatusBean> f12270l = new ArrayList<>();

    /* renamed from: D */
    private boolean f12240D = true;

    /* renamed from: I */
    private final int f12245I = 121212;

    /* renamed from: J */
    private final int f12246J = 10086;

    /* renamed from: K */
    private final int f12247K = 131313;

    /* renamed from: L */
    private boolean f12248L = false;

    /* renamed from: Q */
    private boolean f12253Q = true;

    /* renamed from: R */
    private boolean f12254R = true;

    /* renamed from: V */
    private int[] f12258V = {-1, -1};

    /* renamed from: b */
    public ArrayList<Integer> f12267b = new ArrayList<>();

    /* renamed from: W */
    private boolean f12259W = false;

    /* renamed from: X */
    private boolean f12260X = false;

    /* renamed from: Y */
    private boolean f12261Y = false;

    /* renamed from: ac */
    private ExpandableListView.OnChildClickListener f12266ac = new C2163cf(this);

    /* renamed from: j */
    int f12268j = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: f */
    public final boolean mo7118f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ boolean m7141i(SystemStatusCodeFragment systemStatusCodeFragment) {
        systemStatusCodeFragment.f12265ab = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ boolean m7140j(SystemStatusCodeFragment systemStatusCodeFragment) {
        systemStatusCodeFragment.f12248L = false;
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void onSelectReportFormatBack(String str) {
        DiagnoseConstants.FAULTCODE_REFRESH = false;
        ReportShowFragment reportShowFragment = new ReportShowFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SystemStatus", this.f12269k);
        bundle.putBoolean("CommonFaultCode", this.f12240D);
        bundle.putString("Flag", "SystemStatus");
        bundle.putString("fileName", str);
        bundle.putString("date", this.f12257U);
        reportShowFragment.setArguments(bundle);
        this.f12357d.mo7098a((Fragment) reportShowFragment, SystemStatusCodeFragment.class.getName(), true);
    }

    /* renamed from: a */
    private static String m7154a(BasicFaultCodeBean basicFaultCodeBean, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("faultTitle", basicFaultCodeBean.getTitle());
            jSONObject.put("faultContext", basicFaultCodeBean.getContext());
            jSONObject.put("faultStatus", basicFaultCodeBean.getStatus());
            jSONObject.put("systemID", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        this.f12261Y = PathUtils.m4853d(DiagnoseConstants.DIAGNOSE_LIB_PATH);
        if (arguments != null) {
            this.f12269k = (ArrayList) arguments.getSerializable("SystemStatus");
            ArrayList<BasicSystemStatusBean> arrayList = this.f12269k;
            if (arrayList != null) {
                this.f12263a = SystemStatusCodeListAdapter.m7476a(arrayList, SystemStatusCodeListAdapter.f11449b);
                this.f12270l = SystemStatusCodeListAdapter.m7476a(this.f12269k, SystemStatusCodeListAdapter.f11450c);
            }
            this.f12275q = arguments.getString("Code_Type");
            this.f12276r = arguments.getString("DataType");
            this.f12259W = !this.f12276r.equals(DiagnoseConstants.FEEDBACK_DATASTREAM_VW);
            this.f12260X = arguments.getString("HasContinue", "0").equalsIgnoreCase("1");
            if (this.f12259W) {
                for (int i = 0; i < this.f12263a.size(); i++) {
                    if (this.f12263a.get(i).isFaultCodeOnline()) {
                        ArrayList<BasicFaultCodeBean> systemFaultCodeBean = this.f12263a.get(i).getSystemFaultCodeBean();
                        DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanBySystemName(this.f12263a.get(i).getSystemFaultCodeBean(), this.f12263a.get(i).getSystemName());
                        for (int i2 = 0; i2 < systemFaultCodeBean.size(); i2++) {
                            this.f12357d.mo7093a("2", m7154a(systemFaultCodeBean.get(i2), this.f12263a.get(i).getSystemID()), 28);
                        }
                    }
                }
            }
        }
        this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_faultcodeshow));
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<BasicSystemStatusBean> arrayList;
        super.onActivityCreated(bundle);
        this.f12271m = (ExpandableListView) getActivity().findViewById(R.id.expand_listview_faultcode_err);
        this.f12272n = (ExpandableListView) getActivity().findViewById(R.id.expand_listview_faultcode_ok);
        this.f12272n.setGroupIndicator(null);
        this.f12272n.setClickable(false);
        this.f12272n.setCacheColorHint(Color.parseColor("#00000000"));
        this.f12273o = new SystemStatusCodeListAdapter(getActivity(), this.f12263a, SystemStatusCodeListAdapter.f11449b);
        this.f12273o.f11451a = this;
        this.f12274p = new SystemStatusCodeListAdapter(getActivity(), this.f12270l, SystemStatusCodeListAdapter.f11450c);
        SystemStatusCodeListAdapter systemStatusCodeListAdapter = this.f12274p;
        systemStatusCodeListAdapter.f11451a = this;
        SystemStatusCodeListAdapter systemStatusCodeListAdapter2 = this.f12273o;
        boolean z = this.f12259W;
        systemStatusCodeListAdapter2.f11452d = z;
        systemStatusCodeListAdapter.f11452d = z;
        if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            this.f12273o.f11453e = false;
            this.f12274p.f11453e = false;
        }
        this.f12271m.setAdapter(this.f12273o);
        this.f12267b.clear();
        for (int i = 0; i < this.f12263a.size(); i++) {
            this.f12267b.add(Integer.valueOf(i));
        }
        this.f12272n.setAdapter(this.f12274p);
        ArrayList<BasicSystemStatusBean> arrayList2 = this.f12263a;
        if (arrayList2 == null || arrayList2.size() == 0) {
            this.f12271m.setVisibility(8);
        }
        ArrayList<BasicSystemStatusBean> arrayList3 = this.f12270l;
        if (arrayList3 == null || arrayList3.size() == 0) {
            this.f12272n.setVisibility(8);
        }
        this.f12250N = (LinearLayout) getActivity().findViewById(R.id.ly_help);
        this.f12251O = (LinearLayout) getActivity().findViewById(R.id.normal_code);
        this.f12252P = (LinearLayout) getActivity().findViewById(R.id.err_code);
        this.f12251O.setOnClickListener(this);
        this.f12252P.setOnClickListener(this);
        this.f12255S = (TextView) getActivity().findViewById(R.id.err_code_num);
        this.f12256T = (TextView) getActivity().findViewById(R.id.normal_code_num);
        int groupCount = this.f12273o.getGroupCount();
        TextView textView = this.f12255S;
        textView.setText("( " + groupCount + " )");
        int groupCount2 = this.f12274p.getGroupCount();
        TextView textView2 = this.f12256T;
        textView2.setText("( " + groupCount2 + " )");
        if (groupCount2 == 0) {
            this.f12254R = false;
            this.f12272n.setVisibility(8);
        }
        this.f12279u = (IconButton) getActivity().findViewById(R.id.btn_search);
        this.f12280v = (IconButton) getActivity().findViewById(R.id.btn_report);
        this.f12282x = (IconButton) getActivity().findViewById(R.id.btn_help);
        this.f12277s = (IconRadioButton) getActivity().findViewById(R.id.btn_translation);
        this.f12278t = (IconRadioButton) getActivity().findViewById(R.id.btn_print);
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12280v.setEnabled(false);
        }
        if (!PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_search", true)) {
            this.f12279u.setVisibility(8);
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() > 1 && PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_translation", false)) {
            String m9469a = LangManager.m9469a();
            LangManager.m9466b();
            if (m9469a.equalsIgnoreCase("ZH") || m9469a.equalsIgnoreCase("TW") || m9469a.equalsIgnoreCase("HK") || m9469a.equalsIgnoreCase("EN") || m9469a.equalsIgnoreCase("CN")) {
                this.f12277s.setVisibility(8);
            } else {
                this.f12277s.setVisibility(0);
            }
        } else {
            this.f12277s.setVisibility(8);
        }
        this.f12281w = (IconButton) getActivity().findViewById(R.id.btn_freeze);
        this.f12281w.setVisibility(8);
        this.f12283y = (IconButton) getActivity().findViewById(R.id.btn_system_scan_continue);
        this.f12284z = (IconButton) getActivity().findViewById(R.id.btn_clear_code);
        this.f12237A = (IconButton) getActivity().findViewById(R.id.btn_rescan);
        String m9469a2 = LangManager.m9469a();
        if (!m9469a2.equalsIgnoreCase("ZH") && !m9469a2.equalsIgnoreCase("TW") && !m9469a2.equalsIgnoreCase("HK")) {
            m9469a2.equalsIgnoreCase("CN");
        }
        if (this.f12356c) {
            this.f12271m.setOnChildClickListener(this.f12266ac);
            this.f12279u.setOnClickListener(this);
            this.f12277s.setOnClickListener(this);
            this.f12280v.setOnClickListener(this);
            this.f12281w.setOnClickListener(this);
            this.f12283y.setOnClickListener(this);
            this.f12284z.setOnClickListener(this);
            this.f12237A.setOnClickListener(this);
        } else {
            this.f12279u.setEnabled(false);
            this.f12277s.setEnabled(false);
            this.f12281w.setEnabled(false);
            this.f12283y.setEnabled(false);
            this.f12284z.setEnabled(false);
            this.f12237A.setEnabled(false);
        }
        if (!this.f12259W) {
            this.f12283y.setVisibility(8);
            this.f12284z.setVisibility(8);
        } else {
            this.f12283y.setVisibility(this.f12260X ? 0 : 8);
            this.f12284z.setVisibility(0);
            if (this.f12261Y) {
                this.f12237A.setVisibility(this.f12260X ? 8 : 0);
                if (this.f12258V[0] != -1 || !this.f12356c) {
                    this.f12282x.setEnabled(false);
                } else {
                    this.f12282x.setEnabled(true);
                }
                this.f12282x.setOnClickListener(new View$OnClickListenerC2164cg(this));
                this.f12241E = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
                this.f12241E.setCanceledOnTouchOutside(false);
                this.f12242F = this.f12241E.f16396b;
                this.f12243G = new HandlerC2165ch(this);
                this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
                this.f12238B = DiagnoseInfo.getInstance().getModel();
                this.f12239C = DiagnoseInfo.getInstance().getYear();
                if (DiagnoseInfo.getInstance().getFunctionType() == 19 && DiagnoseInfo.getInstance().getFunctionStatus() == 7) {
                    this.f12240D = false;
                }
                getActivity().getPackageName();
                if (m7117g() || (arrayList = this.f12269k) == null || arrayList.size() <= 0) {
                    return;
                }
                DiagnoseUtils.m5086a().m5083a(m7147d());
                return;
            }
        }
        this.f12237A.setVisibility(8);
        if (this.f12258V[0] != -1) {
        }
        this.f12282x.setEnabled(false);
        this.f12282x.setOnClickListener(new View$OnClickListenerC2164cg(this));
        this.f12241E = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
        this.f12241E.setCanceledOnTouchOutside(false);
        this.f12242F = this.f12241E.f16396b;
        this.f12243G = new HandlerC2165ch(this);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        this.f12238B = DiagnoseInfo.getInstance().getModel();
        this.f12239C = DiagnoseInfo.getInstance().getYear();
        if (DiagnoseInfo.getInstance().getFunctionType() == 19) {
            this.f12240D = false;
        }
        getActivity().getPackageName();
        if (m7117g()) {
        }
    }

    /* renamed from: d */
    private String m7147d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "3");
            jSONObject.put(VastExtensionXmlManager.TYPE, DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ui_type", DiagnoseConstants.UI_Type_ShowTransDiagInfo);
            jSONObject2.put(VastExtensionXmlManager.TYPE, this.f12276r);
            JSONArray jSONArray = new JSONArray();
            Iterator<BasicSystemStatusBean> it = this.f12269k.iterator();
            while (it.hasNext()) {
                BasicSystemStatusBean next = it.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", next.getSystemID());
                jSONObject3.put("context", next.getSystemName());
                jSONObject3.put(VastExtensionXmlManager.TYPE, next.getSystemType());
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean = next.getSystemFaultCodeBean();
                JSONArray jSONArray2 = new JSONArray();
                if (systemFaultCodeBean != null && systemFaultCodeBean.size() > 0) {
                    Iterator<BasicFaultCodeBean> it2 = next.getSystemFaultCodeBean().iterator();
                    while (it2.hasNext()) {
                        BasicFaultCodeBean next2 = it2.next();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("title", next2.getTitle());
                        jSONObject4.put("context", next2.getContext());
                        jSONObject4.put("status", next2.getStatus());
                        jSONObject4.put("help", next2.getHelp());
                        jSONArray2.put(jSONObject4);
                    }
                    jSONObject3.put(DataPacketExtension.ELEMENT_NAME, jSONArray2);
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject2.put("menudata", jSONArray);
            jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: a */
    public final void mo7075a(ArrayList<BasicSystemStatusBean> arrayList, boolean z) {
        this.f12263a = SystemStatusCodeListAdapter.m7476a(arrayList, SystemStatusCodeListAdapter.f11449b);
        this.f12270l = SystemStatusCodeListAdapter.m7476a(arrayList, SystemStatusCodeListAdapter.f11450c);
        if (!this.f12259W) {
            this.f12273o.m7475b(arrayList, 1);
            this.f12274p.m7475b(arrayList, 2);
            return;
        }
        this.f12283y.setVisibility(z ? 0 : 8);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_systemstatuscode, viewGroup, false);
    }

    /* renamed from: b */
    public final int m7149b(String str) {
        for (int i = 0; i < this.f12269k.size(); i++) {
            if (str.equals(this.f12269k.get(i).getSystemName())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static String m7151b(int i) {
        String hexString = Integer.toHexString(i);
        int length = hexString.length();
        while (length < 2) {
            hexString = "0".concat(String.valueOf(hexString));
            length = hexString.length();
        }
        return hexString;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f12271m.requestFocus();
        DiagnoseConstants.FAULTCODE_REFRESH = true;
        int i = 0;
        if (this.f12248L) {
            this.f12277s.setChecked(true);
            this.f12273o.f11454f = this.f12244H;
        } else {
            this.f12273o.f11454f = null;
            this.f12277s.setChecked(false);
        }
        SystemStatusCodeListAdapter systemStatusCodeListAdapter = this.f12273o;
        int[] iArr = this.f12258V;
        systemStatusCodeListAdapter.m7478a(iArr[0], iArr[1]);
        for (int i2 = 0; i2 < this.f12267b.size(); i2++) {
            this.f12271m.expandGroup(this.f12267b.get(i2).intValue());
        }
        this.f12273o.notifyDataSetChanged();
        this.f12274p.notifyDataSetChanged();
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            for (int i3 = 0; i3 < this.f12270l.size(); i3++) {
                String str = (C2787z.m4821a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle() + this.f12270l.get(i3).getSystemName();
                String systemName = this.f12270l.get(i3).getSystemName();
                BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                basicFaultCodeBean.setId("无故障码");
                basicFaultCodeBean.setTitle("无故障码");
                basicFaultCodeBean.setStatus("无故障码");
                basicFaultCodeBean.setContext("无故障码");
                ArrayList<BasicFaultCodeBean> arrayList = new ArrayList<>();
                arrayList.add(basicFaultCodeBean);
                ReportProduceTool m5233a = ReportProduceTool.m5233a();
                if (TextUtils.isEmpty(systemName)) {
                    systemName = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.report_null_diangnose_name);
                }
                m5233a.m5228a(arrayList, systemName, str);
            }
            while (i < this.f12263a.size()) {
                String str2 = (C2787z.m4821a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle() + " > " + this.f12263a.get(i).getSystemName();
                String systemName2 = this.f12263a.get(i).getSystemName();
                ReportProduceTool m5233a2 = ReportProduceTool.m5233a();
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean = this.f12263a.get(i).getSystemFaultCodeBean();
                if (TextUtils.isEmpty(systemName2)) {
                    systemName2 = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.report_null_diangnose_name);
                }
                m5233a2.m5228a(systemFaultCodeBean, systemName2, str2);
                i++;
            }
        } else if (PreferencesManager.m9595a(this.mContext).m9583b("is_upload_report", false)) {
            for (int i4 = 0; i4 < this.f12270l.size(); i4++) {
                String str3 = (C2787z.m4821a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle() + this.f12270l.get(i4).getSystemName();
                String systemName3 = this.f12270l.get(i4).getSystemName();
                BasicFaultCodeBean basicFaultCodeBean2 = new BasicFaultCodeBean();
                basicFaultCodeBean2.setId("无故障码");
                basicFaultCodeBean2.setTitle("无故障码");
                basicFaultCodeBean2.setStatus("无故障码");
                basicFaultCodeBean2.setContext("无故障码");
                ArrayList<BasicFaultCodeBean> arrayList2 = new ArrayList<>();
                arrayList2.add(basicFaultCodeBean2);
                ReportProduceTool m5233a3 = ReportProduceTool.m5233a();
                if (TextUtils.isEmpty(systemName3)) {
                    systemName3 = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = getString(R.string.report_null_diangnose_name);
                }
                m5233a3.m5228a(arrayList2, systemName3, str3);
            }
            while (i < this.f12263a.size()) {
                String str4 = (C2787z.m4821a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle() + " > " + this.f12263a.get(i).getSystemName();
                String systemName4 = this.f12263a.get(i).getSystemName();
                ReportProduceTool m5233a4 = ReportProduceTool.m5233a();
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean2 = this.f12263a.get(i).getSystemFaultCodeBean();
                if (TextUtils.isEmpty(systemName4)) {
                    systemName4 = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = getString(R.string.report_null_diangnose_name);
                }
                m5233a4.m5228a(systemFaultCodeBean2, systemName4, str4);
                i++;
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.btn_report) {
            if (C2778n.m4905b()) {
                return;
            }
            String m5094a = DateUtils.m5094a(DateStyle.f15729g);
            if (C2744aa.m5128p(this.mContext)) {
                this.f12257U = DateUtils.m5092a(m5094a, DateStyle.f15731i);
            } else {
                this.f12257U = m5094a;
            }
            this.f12360g = m7124a(1, m5094a);
            if (C2744aa.m5128p(this.mContext)) {
                showInputReportDialog(0);
                return;
            }
            this.f12249M = new InputReportInfoDialog(getActivity(), this.f12360g);
            this.f12249M.setCanceledOnTouchOutside(false);
            InputReportInfoDialog inputReportInfoDialog = this.f12249M;
            inputReportInfoDialog.f16171b = this;
            inputReportInfoDialog.show();
        } else if (id != R.id.btn_freeze) {
            if (id == R.id.btn_search) {
                SystemStatusCodeListAdapter systemStatusCodeListAdapter = this.f12273o;
                ArrayList<BasicSystemStatusBean> arrayList = this.f12263a;
                C2730b c2730b = new C2730b(this);
                Activity activity = getActivity();
                if (activity == null || systemStatusCodeListAdapter == null || arrayList == null || !(systemStatusCodeListAdapter instanceof SystemStatusCodeListAdapter)) {
                    return;
                }
                int[] m7479a = systemStatusCodeListAdapter.m7479a();
                String title = m7479a[0] >= 0 ? arrayList.get(m7479a[0]).getSystemFaultCodeBean().get(m7479a[1]).getTitle() : null;
                if (title != null) {
                    StringBuilder sb = new StringBuilder();
                    String carSoftName = this.f12357d.mo7083i().getCarSoftName();
                    if (carSoftName.equalsIgnoreCase("DEMO") || carSoftName.equalsIgnoreCase("演示程序") || carSoftName.equalsIgnoreCase("演示程式")) {
                        sb.append(title);
                    } else {
                        sb.append(carSoftName);
                        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb.append(title);
                    }
                    c2730b.mo5330a(sb.toString());
                    return;
                }
                new MessageDialog(activity).m4669a(activity.getString(R.string.dialog_title_default), activity.getString(R.string.toast_need_select_before));
            } else if (id == R.id.btn_translation) {
                if (!this.f12277s.isChecked()) {
                    SystemStatusCodeListAdapter systemStatusCodeListAdapter2 = this.f12273o;
                    systemStatusCodeListAdapter2.f11454f = null;
                    systemStatusCodeListAdapter2.notifyDataSetChanged();
                    this.f12277s.setEnabled(true);
                    this.f12248L = false;
                    return;
                }
                this.f12248L = true;
                SerializableMap serializableMap = this.f12244H;
                if (serializableMap == null) {
                    this.f12265ab = false;
                    this.f12242F.setProgress(0);
                    this.f12241E.show();
                    request(10086);
                    this.f12277s.setEnabled(false);
                    return;
                }
                SystemStatusCodeListAdapter systemStatusCodeListAdapter3 = this.f12273o;
                systemStatusCodeListAdapter3.f11454f = serializableMap;
                systemStatusCodeListAdapter3.notifyDataSetChanged();
                this.f12277s.setEnabled(true);
            } else if (id == R.id.normal_code) {
                if (this.f12254R) {
                    this.f12254R = false;
                    this.f12272n.setVisibility(8);
                    return;
                }
                this.f12254R = true;
                this.f12272n.setVisibility(0);
            } else if (id == R.id.err_code) {
                if (this.f12253Q) {
                    this.f12253Q = false;
                    this.f12271m.setVisibility(8);
                    return;
                }
                this.f12253Q = true;
                this.f12271m.setVisibility(0);
            } else if (id == R.id.btn_system_scan_continue) {
                this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000102", 3);
            } else if (id == R.id.btn_clear_code) {
                this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000103", 3);
            } else if (id == R.id.btn_rescan) {
                this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000106", 3);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 10086) {
            this.f12241E.dismiss();
            SystemStatusCodeListAdapter systemStatusCodeListAdapter = this.f12273o;
            systemStatusCodeListAdapter.f11454f = this.f12244H;
            systemStatusCodeListAdapter.notifyDataSetChanged();
            this.f12277s.setEnabled(true);
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 10086) {
            this.f12241E.dismiss();
            this.f12277s.setChecked(false);
            this.f12277s.setEnabled(true);
        }
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_faultcodeshow);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        ArrayList<BasicSystemStatusBean> arrayList = this.f12263a;
        if (arrayList == null || arrayList.size() == 0) {
            z = false;
        } else {
            sb.append(PrintDataUtils.m4933a(getActivity(), this.f12263a));
            z = true;
        }
        if (!this.f12259W) {
            ArrayList<BasicSystemStatusBean> arrayList2 = this.f12270l;
            if (arrayList2 == null || arrayList2.size() == 0) {
                if (z) {
                    return sb.toString();
                }
                return super.mo7100c();
            }
            sb.append(PrintDataUtils.m4933a(getActivity(), this.f12270l));
        }
        return sb.toString();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: e */
    public final String mo7119e() {
        int[] m7479a = this.f12273o.m7479a();
        if (m7479a[0] >= 0) {
            String help = this.f12263a.get(m7479a[0]).getSystemFaultCodeBean().get(m7479a[1]).getHelp();
            return TextUtils.isEmpty(help.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "")) ? super.mo7119e() : help;
        }
        return getString(R.string.toast_need_select_before);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onDestroyView() {
        InputReportInfoDialog inputReportInfoDialog = this.f12249M;
        if (inputReportInfoDialog != null) {
            inputReportInfoDialog.dismiss();
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f12249M != null) {
            if (getResources().getConfiguration().orientation == 2) {
                if (C2778n.m4900c(this.mContext) < 650) {
                    this.f12249M.f16172c.setVisibility(0);
                }
            } else {
                this.f12249M.f16172c.setVisibility(8);
            }
            this.f12249M.m4695b();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void showInputReportDialog(int i) {
        switch (i) {
            case 0:
                String m5094a = DateUtils.m5094a(DateStyle.f15729g);
                if (C2744aa.m5128p(this.mContext)) {
                    this.f12257U = DateUtils.m5092a(m5094a, DateStyle.f15731i);
                } else {
                    this.f12257U = m5094a;
                }
                this.f12262Z = new InputVehicleInfoDialog(getActivity(), 1);
                this.f12262Z.m4689a(this, m5094a);
                this.f12262Z.setCanceledOnTouchOutside(false);
                this.f12262Z.show();
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
                if (this.f12264aa == null) {
                    this.f12264aa = new InputSensingDialog(this.mContext);
                }
                InputSensingDialog inputSensingDialog = this.f12264aa;
                inputSensingDialog.f16199a = this.f12262Z;
                inputSensingDialog.show();
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        TranslationUtil translationUtil;
        if (i == 10086) {
            NLog.m9452b("yuandong", "local lang： ".concat(String.valueOf(LangManager.m9469a())));
            Map<String, String> hashMap = new HashMap<>();
            this.f12268j = 0;
            int i2 = 0;
            loop0: while (true) {
                if (i2 >= this.f12263a.size()) {
                    break;
                }
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean = this.f12263a.get(i2).getSystemFaultCodeBean();
                for (int i3 = 0; i3 < systemFaultCodeBean.size(); i3++) {
                    if (this.f12265ab) {
                        hashMap = null;
                        break loop0;
                    }
                    String context = systemFaultCodeBean.get(i3).getContext();
                    NLog.m9452b("yuandong", "translate text： ".concat(String.valueOf(context)));
                    if (!"".equals(context) && !hashMap.containsKey(context)) {
                        translationUtil = TranslationUtil.C2754a.f15766a;
                        translationUtil.m5067a(context.trim(), new C2166ci(this, hashMap, context, i3, systemFaultCodeBean));
                    } else {
                        this.f12268j = ((i3 + 1) * 100) / systemFaultCodeBean.size();
                        this.f12243G.sendMessage(this.f12243G.obtainMessage(121212, this.f12268j, 0));
                    }
                }
                i2++;
            }
            if (!this.f12265ab) {
                this.f12244H = new SerializableMap();
                this.f12244H.setMap(hashMap);
            }
        }
        return 0;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100", 3);
            return true;
        }
        return false;
    }
}
