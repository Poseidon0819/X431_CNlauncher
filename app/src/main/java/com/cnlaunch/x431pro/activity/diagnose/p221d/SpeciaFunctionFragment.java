package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSpeciaFunctionBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.ReportShowFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SpeciaFunctionListViewAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.InputReportInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.InputSensingDialog;
import com.cnlaunch.x431pro.widget.p290a.InputVehicleInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bt */
/* loaded from: classes.dex */
public class SpeciaFunctionFragment extends BaseDiagnoseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: m */
    private static ArrayList<BasicFaultCodeBean> f12186m;

    /* renamed from: A */
    private SerializableMap f12187A;

    /* renamed from: F */
    private InputReportInfoDialog f12192F;

    /* renamed from: J */
    private String f12196J;

    /* renamed from: K */
    private InputVehicleInfoDialog f12197K;

    /* renamed from: L */
    private InputSensingDialog f12198L;

    /* renamed from: M */
    private TextView f12199M;

    /* renamed from: O */
    private boolean f12201O;

    /* renamed from: P */
    private DynamicButtonGroup f12202P;

    /* renamed from: j */
    private ArrayList<BasicSpeciaFunctionBean> f12207j;

    /* renamed from: k */
    private ArrayList<ArrayList<BasicSpeciaFunctionBean>> f12208k;

    /* renamed from: l */
    private ArrayList<BasicButtonBean> f12209l;

    /* renamed from: n */
    private SpeciaFunctionListViewAdapter f12210n;

    /* renamed from: o */
    private LinearLayout f12211o;

    /* renamed from: p */
    private ListView f12212p;

    /* renamed from: q */
    private int[] f12213q;

    /* renamed from: r */
    private String f12214r;

    /* renamed from: s */
    private String f12215s;

    /* renamed from: u */
    private IconRadioButton f12217u;

    /* renamed from: x */
    private WaitDialog f12220x;

    /* renamed from: y */
    private ProgressBar f12221y;

    /* renamed from: z */
    private Handler f12222z;

    /* renamed from: b */
    private int f12206b = 2;

    /* renamed from: t */
    private String f12216t = "";

    /* renamed from: v */
    private int f12218v = -1;

    /* renamed from: w */
    private boolean f12219w = true;

    /* renamed from: B */
    private final int f12188B = 121212;

    /* renamed from: C */
    private final int f12189C = 10086;

    /* renamed from: D */
    private final int f12190D = 131313;

    /* renamed from: E */
    private int f12191E = 0;

    /* renamed from: G */
    private int f12193G = -1;

    /* renamed from: H */
    private ArrayList<TextView> f12194H = new ArrayList<>();

    /* renamed from: I */
    private boolean f12195I = false;

    /* renamed from: N */
    private boolean f12200N = false;

    /* renamed from: Q */
    private DynamicButtonGroup.InterfaceC2889c f12203Q = new C2161cc(this);

    /* renamed from: R */
    private DynamicButtonGroup.InterfaceC2888b f12204R = new C2162cd(this);

    /* renamed from: a */
    int f12205a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ boolean m7156o(SpeciaFunctionFragment speciaFunctionFragment) {
        speciaFunctionFragment.f12195I = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_speciafunction_show, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList;
        ArrayList<BasicFaultCodeBean> arrayList2;
        super.onActivityCreated(bundle);
        this.f12200N = PathUtils.m4866a(DiagnoseConstants.DIAGNOSE_LIB_PATH);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12206b = arguments.getInt("Specia_colums", 1);
            this.f12207j = (ArrayList) arguments.getSerializable("SpeciaTitle");
            this.f12208k = (ArrayList) arguments.getSerializable("SpeciaValue");
            if (DiagnoseConstants.SF_IS_SHOW_REPORT && (arrayList = this.f12208k) != null) {
                if (arrayList == null) {
                    arrayList2 = null;
                } else {
                    ArrayList<BasicFaultCodeBean> arrayList3 = new ArrayList<>();
                    for (int i = 0; i < arrayList.size(); i++) {
                        BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                        int size = arrayList.get(i).size();
                        if (size > 0 && arrayList.get(i).get(0) != null) {
                            basicFaultCodeBean.setTitle(arrayList.get(i).get(0).getTitle());
                            basicFaultCodeBean.setId(arrayList.get(i).get(0).getTitle());
                        } else {
                            basicFaultCodeBean.setTitle(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            basicFaultCodeBean.setId(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                        if (1 < size && arrayList.get(i).get(1) != null) {
                            basicFaultCodeBean.setContext(arrayList.get(i).get(1).getTitle());
                        } else {
                            basicFaultCodeBean.setContext(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                        if (2 < size && arrayList.get(i).get(2) != null) {
                            basicFaultCodeBean.setStatus(arrayList.get(i).get(2).getTitle());
                        } else {
                            basicFaultCodeBean.setStatus(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                        if (3 < size && arrayList.get(i).get(3) != null) {
                            String title = arrayList.get(i).get(3).getTitle();
                            if (title.contains("(")) {
                                title = title.substring(0, title.indexOf("("));
                            }
                            basicFaultCodeBean.setSys(title);
                        } else {
                            basicFaultCodeBean.setSys(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                        arrayList3.add(basicFaultCodeBean);
                    }
                    arrayList2 = arrayList3;
                }
                if (arrayList2 != null && arrayList2.size() != 0 && !m7172c(arrayList2)) {
                    String sysId = DiagnoseInfo.getInstance().getSysId();
                    if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                        String str = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                        ReportProduceTool m5233a = ReportProduceTool.m5233a();
                        if (TextUtils.isEmpty(sysId)) {
                            sysId = getString(R.string.report_null_diangnose_name);
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = getString(R.string.report_null_diangnose_name);
                        }
                        m5233a.m5228a(arrayList2, sysId, str);
                    } else if (PreferencesManager.m9595a((Context) getActivity()).m9583b("is_upload_report", false)) {
                        String str2 = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                        ReportProduceTool m5233a2 = ReportProduceTool.m5233a();
                        if (TextUtils.isEmpty(sysId)) {
                            sysId = getString(R.string.report_null_diangnose_name);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = getString(R.string.report_null_diangnose_name);
                        }
                        m5233a2.m5228a(arrayList2, sysId, str2);
                    }
                }
            }
            this.f12209l = (ArrayList) arguments.getSerializable("SpeciaButton");
            this.f12214r = arguments.getString("Specia_Title");
            this.f12215s = arguments.getString("Specia_AddInfo", "");
            this.f12216t = arguments.getString("Specia_Type");
        }
        this.f12213q = new int[this.f12206b];
        for (int i2 = 0; i2 < this.f12207j.size(); i2++) {
            this.f12213q[i2] = Integer.parseInt(this.f12207j.get(i2).getScale());
        }
        m7163i();
        this.f12191E = getResources().getDisplayMetrics().widthPixels;
        this.f12211o = (LinearLayout) getActivity().findViewById(R.id.specia_title);
        this.f12212p = (ListView) getActivity().findViewById(R.id.specia_value);
        this.f12199M = (TextView) getActivity().findViewById(R.id.tv_show_add_info);
        this.f12199M.setMovementMethod(new ScrollingMovementMethod());
        if (!TextUtils.isEmpty(this.f12215s)) {
            this.f12199M.setVisibility(0);
            this.f12199M.setText(this.f12215s);
        } else {
            this.f12199M.setVisibility(8);
        }
        m7165h();
        this.f12210n = new SpeciaFunctionListViewAdapter(this.f12208k, this.mContext, this.f12213q);
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter = this.f12210n;
        speciaFunctionListViewAdapter.f11431e = this.f12216t;
        this.f12212p.setAdapter((ListAdapter) speciaFunctionListViewAdapter);
        if (!this.f12216t.equals(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION) && !this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            if (this.f12216t.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect)) {
                m7171d();
            }
        } else {
            if (this.f12356c) {
                this.f12212p.setOnItemClickListener(this);
            }
            m7169d(this.f12209l);
            this.f12220x = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
            this.f12220x.setCanceledOnTouchOutside(false);
            this.f12221y = this.f12220x.f16396b;
            this.f12222z = new HandlerC2160cb(this);
        }
        if (this.f12216t.equals(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION) || this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        }
        this.f12357d.mo7083i().setSubTitle(this.f12214r);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12216t.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect)) {
                this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox, "00", 3);
                return true;
            } else if (this.f12357d.mo7083i().getDiagnoseStatue() != 1) {
                if (!this.f12200N) {
                    NToast.m9442d(this.mContext, (int) R.string.dialog_exit_function);
                    return true;
                } else if (this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
                    this.f12357d.mo7099a(Integer.parseInt(this.f12216t), new byte[]{1, 0, 0, 0});
                    return true;
                } else {
                    return super.onKeyDown(i, keyEvent);
                }
            } else if (!DataStreamConfiguration.f10580f) {
                NToast.m9442d(this.mContext, (int) R.string.dialog_exit_function);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: d */
    private void m7171d() {
        getActivity().findViewById(R.id.btn_print).setVisibility(8);
        getActivity().findViewById(R.id.btn_help).setVisibility(8);
        IconButton iconButton = (IconButton) getActivity().findViewById(R.id.btn_spec_selectall);
        iconButton.setVisibility(0);
        iconButton.setEnabled(this.f12356c);
        iconButton.setOnClickListener(new View$OnClickListenerC2152bu(this));
        IconButton iconButton2 = (IconButton) getActivity().findViewById(R.id.btn_spec_unpageselectall);
        iconButton2.setVisibility(0);
        iconButton2.setEnabled(this.f12356c);
        iconButton2.setOnClickListener(new View$OnClickListenerC2154bw(this));
        IconButton iconButton3 = (IconButton) getActivity().findViewById(R.id.btn_spec_sure);
        iconButton3.setVisibility(0);
        iconButton3.setEnabled(this.f12356c);
        iconButton3.setOnClickListener(new View$OnClickListenerC2155bx(this));
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = true;
        this.f12212p.requestFocus();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7165h();
        this.f12210n = new SpeciaFunctionListViewAdapter(this.f12208k, this.mContext, this.f12213q);
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter = this.f12210n;
        speciaFunctionListViewAdapter.f11431e = this.f12216t;
        speciaFunctionListViewAdapter.m7480b(this.f12193G);
        ListView listView = this.f12212p;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.f12210n);
        }
        if (this.f12216t.equals(DiagnoseConstants.UI_TYPE_SPECIAL_MultiSelect)) {
            m7171d();
            return;
        }
        m7163i();
        m7169d(this.f12209l);
        if (this.f12192F != null) {
            if (getResources().getConfiguration().orientation == 2) {
                if (C2778n.m4900c(this.mContext) < 650) {
                    this.f12192F.f16172c.setVisibility(0);
                }
            } else {
                this.f12192F.f16172c.setVisibility(8);
            }
            this.f12192F.m4695b();
        }
    }

    /* renamed from: h */
    private void m7165h() {
        LinearLayout linearLayout = this.f12211o;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.item_text_padding);
            int dimensionPixelSize = ((getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(R.dimen.horizontal_margin) * 2)) - (this.f12207j.size() * dimension)) - ((this.f12207j.size() - 1) * 1);
            for (int i = 0; i < this.f12207j.size(); i++) {
                TextView textView = new TextView(this.mContext);
                textView.setText(this.f12207j.get(i).getTitle());
                int parseInt = (int) (dimensionPixelSize * (Integer.parseInt(this.f12207j.get(i).getScale()) / 100.0f));
                textView.setTextAppearance(this.mContext, 2131755308);
                textView.setGravity(16);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(parseInt, -2);
                layoutParams.setMargins(dimension, 15, 0, 15);
                textView.setLayoutParams(layoutParams);
                this.f12211o.addView(textView);
                if (i < this.f12207j.size() - 1) {
                    View view = new View(this.mContext);
                    view.setBackgroundColor(-1644826);
                    view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
                    this.f12211o.addView(view);
                }
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: a */
    public final void mo7076a(ArrayList<BasicSpeciaFunctionBean> arrayList, ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2, ArrayList<BasicButtonBean> arrayList3) {
        boolean z;
        this.f12208k = arrayList2;
        if (this.f12207j.size() != arrayList.size() || !this.f12207j.get(0).getTitle().equals(arrayList.get(0).getTitle())) {
            this.f12207j = arrayList;
            m7165h();
            this.f12213q = new int[this.f12206b];
            for (int i = 0; i < this.f12207j.size(); i++) {
                this.f12213q[i] = Integer.parseInt(this.f12207j.get(i).getScale());
            }
        }
        int i2 = getResources().getDisplayMetrics().widthPixels;
        if (this.f12191E != i2) {
            m7165h();
            m7169d(arrayList3);
            this.f12191E = i2;
        }
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter = this.f12210n;
        int[] iArr = this.f12213q;
        speciaFunctionListViewAdapter.f11427a = arrayList2;
        speciaFunctionListViewAdapter.f11430d = iArr;
        speciaFunctionListViewAdapter.notifyDataSetChanged();
        if (this.f12195I) {
            z = false;
        } else if (this.f12209l.size() == arrayList3.size()) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f12209l.size()) {
                    z = true;
                    break;
                } else if (!this.f12209l.get(i3).getTitle().equals(arrayList3.get(i3).getTitle())) {
                    z = false;
                    break;
                } else if (this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID) && this.f12209l.get(i3).isEnable() != arrayList3.get(i3).isEnable()) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        if (this.f12195I) {
            this.f12195I = false;
        }
        this.f12209l = arrayList3;
        m7169d(arrayList3);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return this.f12214r;
    }

    /* renamed from: c */
    private static boolean m7172c(ArrayList<BasicFaultCodeBean> arrayList) {
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).getStatus().equals(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                z = true;
            }
        }
        if (z) {
            ArrayList<BasicFaultCodeBean> arrayList2 = f12186m;
            if (arrayList2 == null) {
                f12186m = arrayList;
                return false;
            } else if (arrayList2.size() != arrayList.size()) {
                f12186m = arrayList;
                return false;
            } else {
                for (int i2 = 0; i2 < f12186m.size(); i2++) {
                    if (!f12186m.get(i2).getTitle().equals(arrayList.get(i2).getTitle())) {
                        f12186m = arrayList;
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onDestroyView() {
        InputReportInfoDialog inputReportInfoDialog = this.f12192F;
        if (inputReportInfoDialog != null) {
            inputReportInfoDialog.dismiss();
        }
        DynamicButtonGroup dynamicButtonGroup = this.f12202P;
        if (dynamicButtonGroup != null) {
            dynamicButtonGroup.setVisibility(8);
            dynamicButtonGroup.f16506m = 1090;
            dynamicButtonGroup.m4508b();
            this.f12202P = null;
        }
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void onSelectReportFormatBack(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f12208k.size(); i++) {
            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
            int size = this.f12208k.get(i).size();
            if (size > 0 && this.f12208k.get(i).get(0) != null) {
                basicFaultCodeBean.setTitle(this.f12208k.get(i).get(0).getTitle());
            }
            if (1 < size && this.f12208k.get(i).get(1) != null) {
                basicFaultCodeBean.setContext(this.f12208k.get(i).get(1).getTitle());
            }
            if (2 < size && this.f12208k.get(i).get(2) != null) {
                basicFaultCodeBean.setStatus(this.f12208k.get(i).get(2).getTitle());
            }
            if (3 < size && this.f12208k.get(i).get(3) != null) {
                String title = this.f12208k.get(i).get(3).getTitle();
                if (title.contains("(")) {
                    title = title.substring(0, title.indexOf("("));
                }
                basicFaultCodeBean.setSys(title);
            }
            arrayList.add(basicFaultCodeBean);
        }
        DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = false;
        ReportShowFragment reportShowFragment = new ReportShowFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("FaultCode", arrayList);
        bundle.putBoolean("CommonFaultCode", this.f12219w);
        bundle.putString("fileName", str);
        bundle.putString("date", this.f12196J);
        reportShowFragment.setArguments(bundle);
        this.f12357d.mo7098a((Fragment) reportShowFragment, SpeciaFunctionFragment.class.getName(), true);
    }

    /* renamed from: d */
    private void m7169d(ArrayList<BasicButtonBean> arrayList) {
        int i = 0;
        if ((arrayList == null ? 0 : arrayList.size()) == 0) {
            this.f12202P.setVisibility(8);
            return;
        }
        this.f12202P.setVisibility(0);
        if ((MainActivity.m7895b() || MainActivity.m7881d()) && !this.f12356c) {
            this.f12202P.setVisibility(8);
        }
        if (DiagnoseConstants.SF_IS_SHOW_REPORT) {
            this.f12217u = (IconRadioButton) getActivity().findViewById(R.id.btn_translation);
            if (this.f12357d.mo7083i().getDiagnoseStatue() > 1 && PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_translation", false)) {
                String m9469a = LangManager.m9469a();
                LangManager.m9466b();
                if (m9469a.equalsIgnoreCase("ZH") || m9469a.equalsIgnoreCase("TW") || m9469a.equalsIgnoreCase("HK") || m9469a.equalsIgnoreCase("EN") || m9469a.equalsIgnoreCase("CN")) {
                    this.f12217u.setVisibility(8);
                } else {
                    this.f12217u.setVisibility(0);
                }
            } else {
                this.f12217u.setVisibility(8);
            }
            this.f12217u.setOnClickListener(new View$OnClickListenerC2156by(this));
            this.f12219w = false;
            IconButton iconButton = (IconButton) getActivity().findViewById(R.id.btn_search);
            if (!PreferencesManager.m9595a((Context) getActivity()).m9583b("is_provides_search", true)) {
                iconButton.setVisibility(8);
            } else {
                iconButton.setVisibility(0);
            }
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                iconButton.setEnabled(false);
            }
            iconButton.setOnClickListener(new View$OnClickListenerC2157bz(this));
            IconButton iconButton2 = (IconButton) getActivity().findViewById(R.id.btn_report);
            iconButton2.setVisibility(0);
            iconButton2.setEnabled(this.f12356c);
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                iconButton2.setEnabled(false);
            }
            iconButton2.setOnClickListener(new View$OnClickListenerC2159ca(this));
        }
        if (this.f12200N) {
            if (arrayList.size() == 1) {
                this.f12202P.setVisibility(8);
                return;
            }
            i = 1;
        }
        DynamicButtonGroup dynamicButtonGroup = this.f12202P;
        if (dynamicButtonGroup != null) {
            dynamicButtonGroup.m4510a(i, arrayList);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 10086) {
            this.f12220x.dismiss();
            SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter = this.f12210n;
            speciaFunctionListViewAdapter.f11429c = this.f12187A;
            speciaFunctionListViewAdapter.notifyDataSetChanged();
            this.f12217u.setEnabled(true);
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 10086) {
            this.f12220x.dismiss();
            this.f12217u.setChecked(false);
            this.f12217u.setEnabled(true);
        }
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList = this.f12208k;
        if (arrayList == null || arrayList.size() == 0) {
            return super.mo7100c();
        }
        getActivity();
        ArrayList<ArrayList<BasicSpeciaFunctionBean>> arrayList2 = this.f12208k;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList2.size(); i++) {
            ArrayList<BasicSpeciaFunctionBean> arrayList3 = arrayList2.get(i);
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                stringBuffer.append(arrayList3.get(i2).getTitle() + "  ");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    /* renamed from: i */
    private void m7163i() {
        int i = getResources().getDisplayMetrics().widthPixels;
        if (this.f12202P == null) {
            this.f12202P = (DynamicButtonGroup) getActivity().findViewById(R.id.at_btn);
            if (this.f12356c) {
                if (this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
                    this.f12202P.setOnItemTouchListener(this.f12203Q);
                } else {
                    this.f12202P.setOnItemClickListener(this.f12204R);
                }
                this.f12202P.setVisibility(8);
            }
        }
        this.f12202P.m4511a();
        this.f12202P.setWidthLimit(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void showInputReportDialog(int i) {
        switch (i) {
            case 0:
                String m5094a = DateUtils.m5094a(DateStyle.f15729g);
                if (C2744aa.m5128p(this.mContext)) {
                    this.f12196J = DateUtils.m5092a(m5094a, DateStyle.f15731i);
                } else {
                    this.f12196J = m5094a;
                }
                this.f12197K = new InputVehicleInfoDialog(getActivity(), 1);
                this.f12197K.m4689a(this, m5094a);
                this.f12197K.setCanceledOnTouchOutside(false);
                this.f12197K.show();
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
                if (this.f12198L == null) {
                    this.f12198L = new InputSensingDialog(this.mContext);
                }
                InputSensingDialog inputSensingDialog = this.f12198L;
                inputSensingDialog.f16199a = this.f12197K;
                inputSensingDialog.show();
                return;
            default:
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f12193G = i;
        this.f12357d.mo7082j();
        this.f12210n.m7480b(i);
        if (this.f12216t.equals(DiagnoseConstants.UI_Type_EXT1_SPECIAL_FUNCTION_DYNAMICEVENT_ID)) {
            this.f12357d.mo7099a(Integer.parseInt(this.f12216t), new byte[]{0, (byte) ((i >> 8) & 255), (byte) (i & 255)});
        } else {
            this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION, ByteHexHelper.intToTwoHexString(i + 128), 3);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        TranslationUtil translationUtil;
        if (i == 10086) {
            NLog.m9452b("yuandong", "local lang： ".concat(String.valueOf(LangManager.m9469a())));
            Map<String, String> hashMap = new HashMap<>();
            this.f12205a = 0;
            for (int i2 = 0; i2 < this.f12208k.size() && !this.f12201O; i2++) {
                String title = this.f12208k.get(i2).get(1).getTitle();
                if (!"".equals(title) && !hashMap.containsKey(title)) {
                    translationUtil = TranslationUtil.C2754a.f15766a;
                    translationUtil.m5067a(title.trim(), new C2153bv(this, hashMap, title, i2));
                } else {
                    this.f12205a = ((i2 + 1) * 100) / this.f12208k.size();
                    this.f12222z.sendMessage(this.f12222z.obtainMessage(121212, this.f12205a, 0));
                }
            }
            if (!this.f12201O) {
                this.f12187A = new SerializableMap();
                this.f12187A.setMap(hashMap);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ String m7166g(SpeciaFunctionFragment speciaFunctionFragment) {
        int i = speciaFunctionFragment.f12210n.f11428b;
        if (i >= 0) {
            BasicSpeciaFunctionBean basicSpeciaFunctionBean = speciaFunctionFragment.f12208k.get(i).get(0);
            StringBuilder sb = new StringBuilder();
            String carSoftName = speciaFunctionFragment.f12357d.mo7083i().getCarSoftName();
            if (carSoftName.equalsIgnoreCase("DEMO") || carSoftName.equalsIgnoreCase("演示程序") || carSoftName.equalsIgnoreCase("演示程式")) {
                sb.append(basicSpeciaFunctionBean.getTitle());
            } else {
                sb.append(carSoftName);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(basicSpeciaFunctionBean.getTitle());
            }
            return sb.toString();
        }
        new MessageDialog(speciaFunctionFragment.mContext).m4669a(speciaFunctionFragment.getString(R.string.dialog_title_default), speciaFunctionFragment.getString(R.string.toast_need_select_before));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* synthetic */ void m7162i(SpeciaFunctionFragment speciaFunctionFragment) {
        if (C2744aa.m5128p(speciaFunctionFragment.mContext)) {
            speciaFunctionFragment.showInputReportDialog(0);
            return;
        }
        speciaFunctionFragment.f12192F = new InputReportInfoDialog(speciaFunctionFragment.getActivity(), speciaFunctionFragment.f12360g);
        speciaFunctionFragment.f12192F.setCanceledOnTouchOutside(false);
        InputReportInfoDialog inputReportInfoDialog = speciaFunctionFragment.f12192F;
        inputReportInfoDialog.f16171b = speciaFunctionFragment;
        inputReportInfoDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ void m7157n(SpeciaFunctionFragment speciaFunctionFragment) {
        int size = speciaFunctionFragment.f12194H.size();
        for (int i = 0; i < size; i++) {
            speciaFunctionFragment.f12194H.get(i).setEnabled(false);
        }
    }
}
