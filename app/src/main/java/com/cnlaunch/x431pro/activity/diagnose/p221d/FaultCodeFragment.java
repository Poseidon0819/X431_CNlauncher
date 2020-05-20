package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseProcessInfoUtil;
import com.cnlaunch.diagnosemodule.utils.FeedbackUtil;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.diagnose.WebSearchFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.FaultCodeShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
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

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.am */
/* loaded from: classes.dex */
public class FaultCodeFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: A */
    private WaitDialog f11980A;

    /* renamed from: B */
    private ProgressBar f11981B;

    /* renamed from: C */
    private Handler f11982C;

    /* renamed from: D */
    private SerializableMap f11983D;

    /* renamed from: I */
    private InputReportInfoDialog f11988I;

    /* renamed from: J */
    private InputVehicleInfoDialog f11989J;

    /* renamed from: K */
    private InputSensingDialog f11990K;

    /* renamed from: L */
    private String f11991L;

    /* renamed from: M */
    private boolean f11992M;

    /* renamed from: j */
    public String f11995j;

    /* renamed from: k */
    public String f11996k;

    /* renamed from: l */
    public MessageDialog f11997l;

    /* renamed from: m */
    public String[] f11998m;

    /* renamed from: o */
    private FaultCodeShowListAdapter f12000o;

    /* renamed from: p */
    private TextView f12001p;

    /* renamed from: q */
    private TextView f12002q;

    /* renamed from: s */
    private IconRadioButton f12004s;

    /* renamed from: t */
    private IconRadioButton f12005t;

    /* renamed from: u */
    private IconButton f12006u;

    /* renamed from: v */
    private IconButton f12007v;

    /* renamed from: w */
    private IconButton f12008w;

    /* renamed from: x */
    private IconButton f12009x;

    /* renamed from: r */
    private ListView f12003r = null;

    /* renamed from: a */
    public ArrayList<BasicFaultCodeBean> f11993a = null;

    /* renamed from: b */
    public String f11994b = "";

    /* renamed from: y */
    private int f12010y = -1;

    /* renamed from: z */
    private boolean f12011z = true;

    /* renamed from: E */
    private final int f11984E = 121212;

    /* renamed from: F */
    private final int f11985F = 10086;

    /* renamed from: G */
    private final int f11986G = 131313;

    /* renamed from: H */
    private boolean f11987H = false;

    /* renamed from: n */
    int f11999n = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: f */
    public final boolean mo7118f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ boolean m7243i(FaultCodeFragment faultCodeFragment) {
        faultCodeFragment.f11992M = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ boolean m7242j(FaultCodeFragment faultCodeFragment) {
        faultCodeFragment.f11987H = false;
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void onSelectReportFormatBack(String str) {
        DiagnoseConstants.FAULTCODE_REFRESH = false;
        ReportShowFragment reportShowFragment = new ReportShowFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("FaultCode", this.f11993a);
        bundle.putBoolean("CommonFaultCode", this.f12011z);
        bundle.putString("fileName", str);
        bundle.putString("date", this.f11991L);
        reportShowFragment.setArguments(bundle);
        this.f12357d.mo7098a((Fragment) reportShowFragment, FaultCodeFragment.class.getName(), true);
    }

    /* renamed from: a */
    private static String m7253a(BasicFaultCodeBean basicFaultCodeBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("faultTitle", basicFaultCodeBean.getTitle());
            jSONObject.put("faultContext", basicFaultCodeBean.getContext());
            jSONObject.put("faultStatus", basicFaultCodeBean.getStatus());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11993a = (ArrayList) arguments.getSerializable("FaultCode");
            this.f11994b = arguments.getString("FaultCode_Type");
            if (this.f11994b.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
                ArrayList<BasicFaultCodeBean> arrayList = this.f11993a;
                if (!DiagnoseConstants.IS_SET_NO_DTC) {
                    DiagnoseProcessInfoUtil.getInstance().addSysFaultCodeBeanInfo(arrayList, DiagnoseInfo.getInstance().getSysNameId());
                    for (int i = 0; i < arrayList.size(); i++) {
                        this.f12357d.mo7093a("2", m7253a(arrayList.get(i)), 28);
                    }
                }
            }
            String sysId = DiagnoseInfo.getInstance().getSysId();
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                String str = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                ReportProduceTool m5233a = ReportProduceTool.m5233a();
                ArrayList<BasicFaultCodeBean> arrayList2 = this.f11993a;
                if (TextUtils.isEmpty(sysId)) {
                    sysId = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.report_null_diangnose_name);
                }
                m5233a.m5228a(arrayList2, sysId, str);
            } else if (PreferencesManager.m9595a((Context) activity).m9583b("is_upload_report", false)) {
                String str2 = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                ReportProduceTool m5233a2 = ReportProduceTool.m5233a();
                ArrayList<BasicFaultCodeBean> arrayList3 = this.f11993a;
                if (TextUtils.isEmpty(sysId)) {
                    sysId = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.report_null_diangnose_name);
                }
                m5233a2.m5228a(arrayList3, sysId, str2);
            }
        }
        if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FREEZE)) {
            this.f12357d.mo7083i().setSubTitle(getString(R.string.btn_freeze));
        } else {
            this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_faultcodeshow));
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<BasicFaultCodeBean> arrayList;
        super.onActivityCreated(bundle);
        this.f12001p = (TextView) getActivity().findViewById(R.id.searchBtn);
        this.f12002q = (TextView) getActivity().findViewById(R.id.help);
        this.f12003r = (ListView) getActivity().findViewById(R.id.listview_faultcode);
        this.f12006u = (IconButton) getActivity().findViewById(R.id.btn_search);
        this.f12007v = (IconButton) getActivity().findViewById(R.id.btn_report);
        this.f12009x = (IconButton) getActivity().findViewById(R.id.btn_help);
        this.f12004s = (IconRadioButton) getActivity().findViewById(R.id.btn_translation);
        this.f12005t = (IconRadioButton) getActivity().findViewById(R.id.btn_print);
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12007v.setEnabled(false);
        }
        if (!PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_search", true)) {
            this.f12006u.setVisibility(8);
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() > 1 && PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_translation", false)) {
            String m9469a = LangManager.m9469a();
            LangManager.m9466b();
            if (m9469a.equalsIgnoreCase("ZH") || m9469a.equalsIgnoreCase("TW") || m9469a.equalsIgnoreCase("HK") || m9469a.equalsIgnoreCase("EN") || m9469a.equalsIgnoreCase("CN")) {
                this.f12004s.setVisibility(8);
            } else {
                this.f12004s.setVisibility(0);
            }
        } else {
            this.f12004s.setVisibility(8);
        }
        this.f12008w = (IconButton) getActivity().findViewById(R.id.btn_freeze);
        this.f12000o = new FaultCodeShowListAdapter(this.f11993a, getActivity());
        FaultCodeShowListAdapter faultCodeShowListAdapter = this.f12000o;
        faultCodeShowListAdapter.f11335f = this;
        this.f12003r.setAdapter((ListAdapter) faultCodeShowListAdapter);
        if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FREEZE)) {
            this.f12008w.setEnabled(true);
        } else {
            this.f12008w.setEnabled(false);
        }
        if (this.f12356c) {
            this.f12003r.setOnItemClickListener(this);
            this.f12006u.setOnClickListener(this);
            this.f12004s.setOnClickListener(this);
            this.f12007v.setOnClickListener(this);
            this.f12008w.setOnClickListener(this);
        } else {
            this.f12006u.setEnabled(false);
            this.f12004s.setEnabled(false);
            this.f12008w.setEnabled(false);
        }
        String m9469a2 = LangManager.m9469a();
        if (m9469a2.equalsIgnoreCase("ZH") || m9469a2.equalsIgnoreCase("TW") || m9469a2.equalsIgnoreCase("HK") || m9469a2.equalsIgnoreCase("CN")) {
            this.f12001p.setVisibility(0);
            this.f12000o.f11332c = true;
        }
        this.f12002q.setVisibility(8);
        this.f12009x.setVisibility(0);
        this.f12000o.f11333d = false;
        this.f12005t.setVisibility(0);
        if (this.f11994b.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
            this.f12009x = (IconButton) getActivity().findViewById(R.id.btn_help);
            this.f12009x.setOnClickListener(new View$OnClickListenerC2125an(this));
        } else if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_ACTIVE)) {
            ((IconButton) getActivity().findViewById(R.id.btn_help)).setOnClickListener(new View$OnClickListenerC2126ao(this));
        } else if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_RETURN_VALUE)) {
            if (this.f12010y == -1 || !this.f12356c) {
                this.f12009x.setEnabled(false);
            } else {
                this.f12009x.setEnabled(true);
            }
            this.f12009x.setOnClickListener(new View$OnClickListenerC2127ap(this));
        } else if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_EXT1_TROUBLE_CODE_ID)) {
            if (this.f12010y == -1 || !this.f12356c) {
                this.f12009x.setEnabled(false);
            } else {
                this.f12009x.setEnabled(true);
            }
            this.f12009x.setOnClickListener(new View$OnClickListenerC2128aq(this));
        }
        this.f11980A = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
        this.f11980A.setCanceledOnTouchOutside(false);
        this.f11981B = this.f11980A.f16396b;
        this.f11982C = new HandlerC2129ar(this);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        this.f11995j = DiagnoseInfo.getInstance().getModel();
        this.f11996k = DiagnoseInfo.getInstance().getYear();
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW") || LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f11998m = getResources().getStringArray(R.array.fittings_names_traditional);
            } else {
                this.f11998m = getResources().getStringArray(R.array.fittings_names);
            }
        } else {
            this.f11998m = getResources().getStringArray(R.array.fittings_names);
        }
        if (DiagnoseInfo.getInstance().getFunctionType() == 19 && DiagnoseInfo.getInstance().getFunctionStatus() == 7) {
            this.f12011z = false;
        }
        if (!m7117g() || (arrayList = this.f11993a) == null || arrayList.size() <= 0) {
            return;
        }
        DiagnoseUtils.m5086a().m5083a(m7249d());
    }

    /* renamed from: d */
    private String m7249d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", "3");
            jSONObject.put(VastExtensionXmlManager.TYPE, DiagnoseConstants.UI_TYPE_FAULTCODE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ui_type", this.f11994b);
            JSONArray jSONArray = new JSONArray();
            Iterator<BasicFaultCodeBean> it = this.f11993a.iterator();
            while (it.hasNext()) {
                BasicFaultCodeBean next = it.next();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", next.getId());
                jSONObject3.put("title", next.getTitle());
                jSONObject3.put("context", next.getContext());
                jSONObject3.put("status", next.getStatus());
                jSONObject3.put("help", next.getHelp());
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
    /* renamed from: b */
    public final void mo7073b(ArrayList<BasicFaultCodeBean> arrayList) {
        FaultCodeShowListAdapter faultCodeShowListAdapter = this.f12000o;
        faultCodeShowListAdapter.f11330a = arrayList;
        faultCodeShowListAdapter.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_faultcode, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f12003r.requestFocus();
        DiagnoseConstants.FAULTCODE_REFRESH = true;
        if (this.f11987H) {
            this.f12004s.setChecked(true);
            this.f12000o.f11334e = this.f11983D;
        } else {
            this.f12000o.f11334e = null;
            this.f12004s.setChecked(false);
        }
        this.f12000o.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onDestroyView() {
        InputReportInfoDialog inputReportInfoDialog = this.f11988I;
        if (inputReportInfoDialog != null) {
            inputReportInfoDialog.dismiss();
        }
        MessageDialog messageDialog = this.f11997l;
        if (messageDialog != null) {
            messageDialog.dismiss();
        }
        super.onDestroyView();
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
                this.f11991L = DateUtils.m5092a(m5094a, DateStyle.f15731i);
            } else {
                this.f11991L = m5094a;
            }
            this.f12360g = m7124a(1, m5094a);
            if (C2744aa.m5128p(this.mContext)) {
                showInputReportDialog(0);
                return;
            }
            this.f11988I = new InputReportInfoDialog(getActivity(), this.f12360g);
            this.f11988I.setCanceledOnTouchOutside(false);
            InputReportInfoDialog inputReportInfoDialog = this.f11988I;
            inputReportInfoDialog.f16171b = this;
            inputReportInfoDialog.show();
            return;
        }
        String str = null;
        if (id == R.id.btn_freeze) {
            try {
                int i = this.f12000o.f11331b;
                if (this.f11994b.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000301" + ByteHexHelper.intToTwoHexString(i), 3);
                    return;
                }
                if (!this.f11993a.get(i).getContext().equals("CONSULT HANDBOOK") && !this.f11993a.get(i).getContext().equals(getString(R.string.diagnose_consult_handbook))) {
                    if (i >= 0) {
                        if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_EXT1_TROUBLE_CODE_ID)) {
                            if (!this.f11993a.get(i).hasFreeze()) {
                                NToast.m9442d(this.mContext, (int) R.string.invalid_freeze);
                                return;
                            }
                            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, "02" + ByteHexHelper.intToTwoHexString(i), 3);
                            return;
                        }
                        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) null);
                        this.f12357d.mo7093a(FeedbackUtil.getFaultCodeFeedbackType(), FeedbackUtil.getFaultCodeFeedbackCmd(i), 3);
                        return;
                    }
                    new MessageDialog(this.mContext).m4669a(getString(R.string.dialog_title_default), getString(R.string.toast_need_select_before));
                    return;
                }
                NToast.m9442d(this.mContext, (int) R.string.invalid_freeze);
            } catch (Exception unused) {
                NToast.m9444c(this.mContext, (int) R.string.toast_need_select_before);
            }
        } else if (id == R.id.btn_search) {
            int i2 = this.f12000o.f11331b;
            if (i2 >= 0) {
                BasicFaultCodeBean basicFaultCodeBean = this.f11993a.get(i2);
                StringBuilder sb = new StringBuilder();
                String carSoftName = this.f12357d.mo7083i().getCarSoftName();
                if (carSoftName.equalsIgnoreCase("DEMO") || carSoftName.equalsIgnoreCase("演示程序") || carSoftName.equalsIgnoreCase("演示程式")) {
                    sb.append(basicFaultCodeBean.getTitle());
                } else {
                    sb.append(carSoftName);
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(basicFaultCodeBean.getTitle());
                }
                str = sb.toString();
            } else {
                new MessageDialog(this.mContext).m4669a(getString(R.string.dialog_title_default), getString(R.string.toast_need_select_before));
            }
            if (str != null) {
                DiagnoseConstants.FAULTCODE_REFRESH = false;
                WebSearchFragment webSearchFragment = new WebSearchFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("searchkey", str);
                webSearchFragment.setArguments(bundle);
                this.f12357d.mo7098a((Fragment) webSearchFragment, FaultCodeFragment.class.getName(), true);
            }
        } else if (id == R.id.btn_translation) {
            if (!this.f12004s.isChecked()) {
                FaultCodeShowListAdapter faultCodeShowListAdapter = this.f12000o;
                faultCodeShowListAdapter.f11334e = null;
                faultCodeShowListAdapter.notifyDataSetChanged();
                this.f12004s.setEnabled(true);
                this.f11987H = false;
                return;
            }
            this.f11987H = true;
            SerializableMap serializableMap = this.f11983D;
            if (serializableMap == null) {
                this.f11992M = false;
                this.f11981B.setProgress(0);
                this.f11980A.show();
                request(10086);
                this.f12004s.setEnabled(false);
                return;
            }
            FaultCodeShowListAdapter faultCodeShowListAdapter2 = this.f12000o;
            faultCodeShowListAdapter2.f11334e = serializableMap;
            faultCodeShowListAdapter2.notifyDataSetChanged();
            this.f12004s.setEnabled(true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 10086) {
            this.f11980A.dismiss();
            FaultCodeShowListAdapter faultCodeShowListAdapter = this.f12000o;
            faultCodeShowListAdapter.f11334e = this.f11983D;
            faultCodeShowListAdapter.notifyDataSetChanged();
            this.f12004s.setEnabled(true);
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 10086) {
            this.f11980A.dismiss();
            this.f12004s.setChecked(false);
            this.f12004s.setEnabled(true);
        }
        super.onFailure(i, i2, obj);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12010y = i;
        if (this.f11994b.equalsIgnoreCase(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
            if (!TextUtils.isEmpty(this.f11993a.get(i).getHelp())) {
                this.f12009x.setEnabled(true);
            } else {
                this.f12009x.setEnabled(false);
            }
            if (this.f11993a.get(i).hasFreeze()) {
                this.f12008w.setEnabled(true);
            } else {
                this.f12008w.setEnabled(false);
            }
        }
        if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_RETURN_VALUE)) {
            this.f12009x.setEnabled(true);
        } else if (this.f11994b.equals(DiagnoseConstants.UI_TYPE_FAULTCODE_EXT1_TROUBLE_CODE_ID)) {
            this.f12009x.setEnabled(true);
            if (this.f11993a.get(i).hasFreeze()) {
                this.f12008w.setEnabled(true);
            } else {
                this.f12008w.setEnabled(false);
            }
        }
        FaultCodeShowListAdapter faultCodeShowListAdapter = this.f12000o;
        faultCodeShowListAdapter.f11331b = i;
        faultCodeShowListAdapter.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f11994b.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, "00000100", 3);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_faultcodeshow);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicFaultCodeBean> arrayList = this.f11993a;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        return PrintDataUtils.m4933a(getActivity(), this.f11993a);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: e */
    public final String mo7119e() {
        int i = this.f12000o.f11331b;
        if (i >= 0) {
            String help = this.f11993a.get(i).getHelp();
            return TextUtils.isEmpty(help.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "")) ? super.mo7119e() : help;
        }
        return getString(R.string.toast_need_select_before);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f11988I != null) {
            if (getResources().getConfiguration().orientation == 2) {
                if (C2778n.m4900c(this.mContext) < 650) {
                    this.f11988I.f16172c.setVisibility(0);
                }
            } else {
                this.f11988I.f16172c.setVisibility(8);
            }
            this.f11988I.m4695b();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void showInputReportDialog(int i) {
        switch (i) {
            case 0:
                String m5094a = DateUtils.m5094a(DateStyle.f15729g);
                if (C2744aa.m5128p(this.mContext)) {
                    this.f11991L = DateUtils.m5092a(m5094a, DateStyle.f15731i);
                } else {
                    this.f11991L = m5094a;
                }
                this.f11989J = new InputVehicleInfoDialog(getActivity(), 1);
                this.f11989J.m4689a(this, m5094a);
                this.f11989J.setCanceledOnTouchOutside(false);
                this.f11989J.show();
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
                if (this.f11990K == null) {
                    this.f11990K = new InputSensingDialog(this.mContext);
                }
                InputSensingDialog inputSensingDialog = this.f11990K;
                inputSensingDialog.f16199a = this.f11989J;
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
            this.f11999n = 0;
            for (int i2 = 0; i2 < this.f11993a.size() && !this.f11992M; i2++) {
                String context = this.f11993a.get(i2).getContext();
                if (!"".equals(context) && !hashMap.containsKey(context)) {
                    translationUtil = TranslationUtil.C2754a.f15766a;
                    translationUtil.m5067a(context.trim(), new C2130as(this, hashMap, context, i2));
                } else {
                    this.f11999n = ((i2 + 1) * 100) / this.f11993a.size();
                    this.f11982C.sendMessage(this.f11982C.obtainMessage(121212, this.f11999n, 0));
                }
            }
            if (!this.f11992M) {
                this.f11983D = new SerializableMap();
                this.f11983D.setMap(hashMap);
            }
        }
        return 0;
    }
}
