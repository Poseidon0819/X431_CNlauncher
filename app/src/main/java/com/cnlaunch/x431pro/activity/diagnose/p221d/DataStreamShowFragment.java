package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.CopyFile;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.mycar.jni.JniX431FileTest;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.activity.diagnose.p220c.BottomActionBar;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.activity.diagnose.p220c.X431DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.TabListener;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.activity.mine.MineFragment;
import com.cnlaunch.x431pro.activity.mine.ReportPagersFragment;
import com.cnlaunch.x431pro.activity.pdf.PDFDataStreamInfo;
import com.cnlaunch.x431pro.activity.pdf.ReportIntentService;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.cnlaunch.x431pro.widget.p290a.InputReportInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.InputSensingDialog;
import com.cnlaunch.x431pro.widget.p290a.InputVehicleInfoDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.volley.BuildConfig;
import java.io.File;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aa */
/* loaded from: classes.dex */
public final class DataStreamShowFragment extends BaseDiagnoseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ICallKeyDownFragment, IDataStreamSelectionRecorder {

    /* renamed from: a */
    public static int f11880a = 0;

    /* renamed from: b */
    public static int f11881b = 1;

    /* renamed from: j */
    public static int f11882j = 2;

    /* renamed from: k */
    public static int f11883k = 3;

    /* renamed from: l */
    public static int f11884l = 4;

    /* renamed from: m */
    public static int f11885m = 5;

    /* renamed from: A */
    private Button f11886A;

    /* renamed from: B */
    private IconButton f11887B;

    /* renamed from: C */
    private IconButton f11888C;

    /* renamed from: D */
    private IconButton f11889D;

    /* renamed from: E */
    private IconButton f11890E;

    /* renamed from: F */
    private IconButton f11891F;

    /* renamed from: G */
    private IconButton f11892G;

    /* renamed from: H */
    private IconButton f11893H;

    /* renamed from: I */
    private IconButton f11894I;

    /* renamed from: J */
    private IconButton f11895J;

    /* renamed from: K */
    private IconButton f11896K;

    /* renamed from: L */
    private Chronometer f11897L;

    /* renamed from: M */
    private LinearLayout f11898M;

    /* renamed from: N */
    private View f11899N;

    /* renamed from: O */
    private String f11900O;

    /* renamed from: P */
    private String f11901P;

    /* renamed from: Q */
    private int f11902Q;

    /* renamed from: V */
    private String f11907V;

    /* renamed from: W */
    private String f11908W;

    /* renamed from: X */
    private String f11909X;

    /* renamed from: Y */
    private long f11910Y;

    /* renamed from: aA */
    private PDFDataStreamInfo f11912aA;

    /* renamed from: aB */
    private DiagReportOrHistoryInfo f11913aB;

    /* renamed from: aC */
    private String f11914aC;

    /* renamed from: aD */
    private InputReportInfoDialog f11915aD;

    /* renamed from: aE */
    private InputVehicleInfoDialog f11916aE;

    /* renamed from: aF */
    private InputSensingDialog f11917aF;

    /* renamed from: aG */
    private boolean f11918aG;

    /* renamed from: aa */
    private long f11923aa;

    /* renamed from: ac */
    private BottomActionBar.AbstractC2090a f11925ac;

    /* renamed from: ad */
    private BottomActionBar.AbstractC2090a f11926ad;

    /* renamed from: ae */
    private BottomActionBar.AbstractC2090a f11927ae;

    /* renamed from: af */
    private DataStreamManager f11928af;

    /* renamed from: ag */
    private IDataStreamSelector f11929ag;

    /* renamed from: ah */
    private ICallKeyDownFragment f11930ah;

    /* renamed from: aq */
    private WaitDialog f11939aq;

    /* renamed from: ar */
    private ProgressBar f11940ar;

    /* renamed from: as */
    private Handler f11941as;

    /* renamed from: at */
    private SerializableMap f11942at;

    /* renamed from: ax */
    private WaitDialog f11946ax;

    /* renamed from: az */
    private InputDialog f11948az;

    /* renamed from: o */
    String f11950o;

    /* renamed from: q */
    private long f11952q;

    /* renamed from: t */
    private View f11955t;

    /* renamed from: u */
    private IconRadioButton f11956u;

    /* renamed from: v */
    private IconRadioButton f11957v;

    /* renamed from: w */
    private IconRadioButton f11958w;

    /* renamed from: x */
    private Button f11959x;

    /* renamed from: y */
    private Button f11960y;

    /* renamed from: z */
    private Button f11961z;

    /* renamed from: r */
    private long f11953r = 0;

    /* renamed from: s */
    private int f11954s = 1;

    /* renamed from: R */
    private ArrayList<BasicDataStreamBean> f11903R = null;

    /* renamed from: S */
    private String f11904S = "";

    /* renamed from: T */
    private LinearLayout f11905T = null;

    /* renamed from: U */
    private BottomActionBar f11906U = null;

    /* renamed from: Z */
    private long f11911Z = 0;

    /* renamed from: ab */
    private JniX431FileTest f11924ab = null;

    /* renamed from: ai */
    private Bundle f11931ai = new Bundle();

    /* renamed from: aj */
    private int f11932aj = 0;

    /* renamed from: ak */
    private int f11933ak = -1;

    /* renamed from: al */
    private List<ArrayList<BasicDataStreamBean>> f11934al = new ArrayList();

    /* renamed from: am */
    private boolean f11935am = false;

    /* renamed from: an */
    private Comparator<BasicDataStreamBean> f11936an = null;

    /* renamed from: ao */
    private boolean f11937ao = true;

    /* renamed from: ap */
    private boolean f11938ap = false;

    /* renamed from: au */
    private final int f11943au = 121212;

    /* renamed from: av */
    private final int f11944av = 10086;

    /* renamed from: aw */
    private final int f11945aw = 131313;

    /* renamed from: ay */
    private boolean f11947ay = false;

    /* renamed from: aH */
    private final BroadcastReceiver f11919aH = new C2114ab(this);

    /* renamed from: aI */
    private boolean f11920aI = false;

    /* renamed from: n */
    boolean f11949n = false;

    /* renamed from: aJ */
    private String f11921aJ = ".pdf";

    /* renamed from: aK */
    private RemotePerformClick.InterfaceC1787b f11922aK = new C2115ac(this);

    /* renamed from: p */
    int f11951p = 0;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: f */
    public final boolean mo7118f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static /* synthetic */ boolean m7300B(DataStreamShowFragment dataStreamShowFragment) {
        dataStreamShowFragment.f11935am = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public static /* synthetic */ JniX431FileTest m7296F(DataStreamShowFragment dataStreamShowFragment) {
        dataStreamShowFragment.f11924ab = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ boolean m7281g(DataStreamShowFragment dataStreamShowFragment) {
        dataStreamShowFragment.f11938ap = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static /* synthetic */ boolean m7258y(DataStreamShowFragment dataStreamShowFragment) {
        dataStreamShowFragment.f11918aG = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!DiagnoseConstants.IS_SORT) {
            this.f11937ao = false;
        } else if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f11937ao = true;
        } else {
            this.f11937ao = PreferencesManager.m9595a((Context) getActivity()).m9583b("is_sort", false);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11901P = arguments.getString("DataStreamShow_HaveValueStatus", "0");
            this.f11900O = arguments.getString("DataStreamShow_Type");
            this.f11903R = (ArrayList) arguments.getSerializable("DataStreamShow");
            this.f12357d.mo7083i().setDataStreamSelectJumpType("datastream");
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM) || this.f11900O.equals(DiagnoseConstants.UI_TYPE_DATASTREAM)) {
                this.f11902Q = this.f11903R.size();
            } else {
                this.f11902Q = this.f12357d.mo7083i().getDataStreamCount();
                if (this.f11902Q <= 0) {
                    this.f11902Q = Integer.parseInt(arguments.getString("DataStreamShow_Count"));
                }
            }
            this.f12357d.mo7083i().setDataStreamCount(this.f11902Q);
            String sysId = DiagnoseInfo.getInstance().getSysId();
            if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
                String str = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                ReportProduceTool m5233a = ReportProduceTool.m5233a();
                ArrayList<BasicDataStreamBean> arrayList = this.f11903R;
                if (TextUtils.isEmpty(sysId)) {
                    sysId = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.report_null_diangnose_name);
                }
                m5233a.m5225b(arrayList, sysId, str);
            } else if (PreferencesManager.m9595a((Context) activity).m9583b("is_upload_report", false)) {
                String str2 = (C1621v.m9121a(DiagnoseConstants.DIAGNOSE_CURRENT_PATH) ? "" : DiagnoseConstants.DIAGNOSE_CURRENT_PATH + " > ") + this.f12357d.mo7083i().getSubTitle();
                ReportProduceTool m5233a2 = ReportProduceTool.m5233a();
                ArrayList<BasicDataStreamBean> arrayList2 = this.f11903R;
                if (TextUtils.isEmpty(sysId)) {
                    sysId = getString(R.string.report_null_diangnose_name);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.report_null_diangnose_name);
                }
                m5233a2.m5225b(arrayList2, sysId, str2);
            }
        }
        if (this.f11937ao && !this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            this.f11936an = new C2112a();
            Collections.sort(this.f11903R, this.f11936an);
        }
        if (this.f11903R != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.f11903R.size(); i++) {
                this.f11934al.add(new ArrayList<>());
                sb.append("1");
            }
            this.f11904S = sb.toString();
        }
        this.f11928af = new X431DataStreamManager(this.f11934al);
        DataStreamManager dataStreamManager = this.f11928af;
        dataStreamManager.f11749k = "DATASTREAM";
        ArrayList<BasicDataStreamBean> arrayList3 = this.f11903R;
        if (arrayList3 != null) {
            dataStreamManager.m7387a(arrayList3);
        }
        this.f11932aj = this.f12357d.mo7083i().getDataStreamJumpType();
        this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_datastreamshow));
        this.f12357d.mo7083i().setDatastreamRecord(false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onDestroy() {
        this.f11932aj = 0;
        this.f11928af.m7382c();
        if (this.f12357d.mo7083i().isDatastreamRecord()) {
            m7274k();
        }
        this.f12357d.mo7083i().setDatastreamRecord(false);
        getActivity().unregisterReceiver(this.f11919aH);
        WaitDialog waitDialog = this.f11946ax;
        if (waitDialog != null) {
            waitDialog.dismiss();
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12357d.mo7080l().f9482a = null;
        }
        InputDialog inputDialog = this.f11948az;
        if (inputDialog != null) {
            inputDialog.dismiss();
        }
        System.gc();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        DiagnoseConstants.DATASTREAM_REFRESH_CONTROL = true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11947ay = PreferencesManager.m9595a(this.mContext).m9583b("is_select_heavyduty_area", false);
        if (this.f11947ay) {
            if (this.f11946ax == null) {
                Context context = this.mContext;
                getResources().getString(R.string.common_title_tips);
                this.f11946ax = new WaitDialog(context, getResources().getString(R.string.refresh_txt));
            }
            this.f11946ax.show();
        }
        this.f11897L = (Chronometer) getActivity().findViewById(R.id.chronometer_record_time);
        this.f11897L.setFormat("%s");
        this.f11959x = (Button) getActivity().findViewById(R.id.btn_stop_record);
        this.f11889D = (IconButton) getActivity().findViewById(R.id.btn_help);
        this.f11887B = (IconButton) getActivity().findViewById(R.id.btn_custom);
        this.f11895J = (IconButton) getActivity().findViewById(R.id.btn_confirm);
        this.f11893H = (IconButton) getActivity().findViewById(R.id.btn_record);
        this.f11890E = (IconButton) getActivity().findViewById(R.id.btn_home);
        this.f11896K = (IconButton) getActivity().findViewById(R.id.btn_saved_data);
        this.f11896K.setOnClickListener(this);
        this.f12358e = (IconButton) getActivity().findViewById(R.id.btn_save);
        this.f12358e.setOnClickListener(this);
        this.f11888C = (IconButton) getActivity().findViewById(R.id.btn_setMax_Min);
        this.f11893H.setEnabled(this.f12356c);
        this.f11888C.setEnabled(this.f12356c);
        this.f11887B.setEnabled(this.f12356c);
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12358e.setEnabled(false);
            this.f11896K.setVisibility(8);
        }
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2 && (this.f11900O.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) || this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM))) {
            this.f11893H.setEnabled(false);
        }
        this.f11957v = (IconRadioButton) getActivity().findViewById(R.id.btn_selectall);
        this.f11958w = (IconRadioButton) getActivity().findViewById(R.id.btn_print);
        this.f11960y = (Button) getActivity().findViewById(R.id.btn_pre_channel);
        this.f11961z = (Button) getActivity().findViewById(R.id.btn_next_channel);
        this.f11886A = (Button) getActivity().findViewById(R.id.btn_exit);
        this.f11955t = getActivity().findViewById(R.id.v_record);
        this.f11956u = (IconRadioButton) getActivity().findViewById(R.id.btn_translation);
        this.f11898M = (LinearLayout) getActivity().findViewById(R.id.vw_datastream_channel_layout);
        if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            this.f11898M.setVisibility(0);
        }
        if (this.f12356c) {
            this.f11959x.setOnClickListener(this);
            this.f11887B.setOnClickListener(this);
            this.f11893H.setOnClickListener(this);
            this.f11960y.setOnClickListener(this);
            this.f11961z.setOnClickListener(this);
            this.f11886A.setOnClickListener(this);
            this.f11888C.setOnClickListener(this);
            this.f11957v.setOnCheckedChangeListener(this);
            this.f11895J.setOnClickListener(this);
            this.f11956u.setOnClickListener(this);
        }
        this.f11905T = (LinearLayout) getActivity().findViewById(R.id.linear_button_bottom);
        this.f11891F = (IconButton) getActivity().findViewById(R.id.btn_graph);
        this.f11892G = (IconButton) getActivity().findViewById(R.id.btn_combination);
        this.f11894I = (IconButton) getActivity().findViewById(R.id.btn_value);
        if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            this.f11891F.setEnabled(false);
            this.f11892G.setEnabled(false);
            this.f11894I.setEnabled(false);
        }
        if (C2744aa.m5166c()) {
            this.f11892G.setVisibility(8);
        }
        this.f11899N = getActivity().findViewById(R.id.head_title);
        this.f11906U = new BottomActionBar(getActivity());
        C2118af c2118af = new C2118af(this, this.f11892G);
        c2118af.f11710b = new TabListener(getActivity(), CombinedGraphFragment.class, this.f11931ai, new RunnableC2113b(this.f11932aj == 2), this);
        this.f11927ae = c2118af;
        C2119ag c2119ag = new C2119ag(this, this.f11891F);
        TabListener tabListener = new TabListener(getActivity(), GraphGridFragment.class, this.f11931ai, new RunnableC2113b(this.f11932aj == 1), this);
        tabListener.f12429a = this;
        c2119ag.f11710b = tabListener;
        this.f11926ad = c2119ag;
        C2120ah c2120ah = new C2120ah(this, this.f11894I);
        c2120ah.f11710b = new TabListener(getActivity(), TextListFragment.class, this.f11931ai, new RunnableC2113b(this.f11932aj == 0), this);
        this.f11925ac = c2120ah;
        this.f11906U.m7421a(this.f11927ae);
        this.f11906U.m7421a(this.f11926ad);
        this.f11906U.m7421a(this.f11925ac);
        this.f11894I.setVisibility(8);
        this.f11892G.setVisibility(8);
        this.f11891F.setVisibility(0);
        if (DiagnoseConstants.DIAG_SHOW_DATA_STREAM_TYPE == 0) {
            this.f11894I.performClick();
        } else if (1 == DiagnoseConstants.DIAG_SHOW_DATA_STREAM_TYPE) {
            this.f11891F.performClick();
        } else if (2 == DiagnoseConstants.DIAG_SHOW_DATA_STREAM_TYPE) {
            this.f11892G.performClick();
        }
        new C2117ae(this).start();
        this.f11939aq = new WaitDialog(getActivity(), false, getString(R.string.diag_tip_translating));
        this.f11939aq.setCanceledOnTouchOutside(false);
        this.f11940ar = this.f11939aq.f16396b;
        this.f11941as = new HandlerC2122aj(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("com.cnlaunch.report.action_result");
        getActivity().registerReceiver(this.f11919aH, intentFilter);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12357d.mo7080l().f9482a = this.f11922aK;
            if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
                NToast.m9442d(getActivity(), (int) R.string.dont_scroll_page_in_remote);
            }
        }
        if (this.f11896K == null || this.f12357d.mo7083i().getDiagnoseStatue() <= 1) {
            return;
        }
        this.f11896K.setVisibility(0);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_datastream_show, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentManager fragmentManager;
        int backStackEntryCount;
        String str;
        String remoteSerialNum;
        super.onClick(view);
        int id = view.getId();
        if (this.f12357d.mo7083i().isDatastreamRecord() && (id == R.id.btn_home || id == R.id.btn_translation)) {
            this.f11952q = new Date().getTime();
            if (this.f11952q - this.f11953r < 2000) {
                return;
            }
            NToast.m9444c(getActivity(), (int) R.string.toast_mustbe_stop_record);
            this.f11953r = new Date().getTime();
        } else if (id == R.id.btn_setMax_Min) {
            if (this.f11932aj == 1) {
                this.f11930ah.mo6305a();
            }
        } else if (id == R.id.btn_confirm) {
            if (this.f11932aj == 1) {
                this.f11930ah.mo6298d();
            }
        } else if (id == R.id.btn_custom) {
            if (this.f11932aj == 1) {
                this.f11930ah.mo6298d();
            }
        } else {
            if (id == R.id.btn_record) {
                if (this.f12357d.mo7083i().isDatastreamRecord()) {
                    return;
                }
                if (FileUtils.m5027a() > 30) {
                    new File(PathUtils.m4843m()).mkdirs();
                    this.f11890E.setEnabled(false);
                    this.f11887B.setEnabled(false);
                    this.f11893H.setEnabled(false);
                    this.f12357d.mo7083i().setDatastreamRecord(true);
                    this.f12357d.mo7087b(true);
                    if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) && this.f11902Q > 15) {
                        NToast.m9444c(getActivity(), (int) R.string.toast_datastream_redundancy);
                    }
                    this.f11955t.setVisibility(0);
                    this.f11897L.setBase(SystemClock.elapsedRealtime());
                    this.f11897L.start();
                    String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.getDefault());
                    this.f11924ab = new JniX431FileTest();
                    this.f11910Y = this.f11924ab.init();
                    this.f11907V = DateUtils.m5094a(DateStyle.f15729g).replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
                    if (this.f12357d.mo7083i().getDiagnoseStatue() > 1) {
                        str = this.f12357d.mo7083i().getCarSoftName().toUpperCase(Locale.getDefault());
                        remoteSerialNum = this.f12357d.mo7083i().getSerialNum();
                    } else {
                        str = "GOLO";
                        remoteSerialNum = this.f12357d.mo7081k().getRemoteSerialNum();
                    }
                    this.f11909X = str + "_" + remoteSerialNum + "_" + this.f11907V;
                    this.f11909X = this.f11909X.replace("/", "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f11909X);
                    sb.append(".x431");
                    this.f11908W = sb.toString();
                    this.f11911Z = this.f11924ab.creatFile(this.f11908W, upperCase, BuildConfig.VERSION_NAME, remoteSerialNum, this.f11910Y, PathUtils.m4843m());
                    long j = this.f11911Z;
                    if (j != 0) {
                        this.f11923aa = this.f11924ab.writeNewGroup(j, str, this.f11907V);
                        new C2123ak(this).start();
                    } else {
                        NToast.m9444c(getActivity(), (int) R.string.datastream_record_create_err);
                        m7278i();
                    }
                    CombinedGraphFragment.m7110a(true);
                    GraphGridFragment.m7230c(true);
                    this.f11956u.setEnabled(false);
                    return;
                }
                NToast.m9450a(this.mContext, (int) R.string.datastream_record_create_file_err);
            } else if (id == R.id.btn_stop_record) {
                if (this.f12357d.mo7083i().isDatastreamRecord()) {
                    if (this.f11924ab.readGroupItemCount(this.f11923aa) <= 1) {
                        MessageDialog messageDialog = new MessageDialog(this.mContext);
                        messageDialog.setTitle(R.string.common_title_tips);
                        messageDialog.m4714e(R.string.toast_datastream_record_short);
                        messageDialog.m4719a(R.string.common_confirm, true, null);
                        messageDialog.m4717b(R.string.common_cancel, true, new View$OnClickListenerC2121ai(this));
                        messageDialog.show();
                        return;
                    }
                    this.f11893H.setEnabled(true);
                    this.f11956u.setEnabled(true);
                    this.f11893H.setText(R.string.btn_record);
                    m7274k();
                    CombinedGraphFragment.m7110a(false);
                    GraphGridFragment.m7230c(false);
                }
            } else if (id == R.id.btn_pre_channel) {
                if (m7280h()) {
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_VW, "1", 3);
                    this.f11920aI = true;
                }
            } else if (id == R.id.btn_next_channel) {
                if (m7280h()) {
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_VW, "2", 3);
                    this.f11920aI = true;
                }
            } else if (id == R.id.btn_exit) {
                if (m7280h()) {
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_VW, "-1", 3);
                }
            } else if (id == R.id.btn_translation) {
                if (!this.f11956u.isChecked()) {
                    this.f11928af.m7388a((SerializableMap) null);
                    this.f11928af.m7387a(this.f11903R);
                    this.f11956u.setEnabled(true);
                    return;
                }
                SerializableMap serializableMap = this.f11942at;
                if (serializableMap == null) {
                    this.f11918aG = false;
                    this.f11940ar.setProgress(0);
                    this.f11939aq.show();
                    request(10086);
                    this.f11956u.setEnabled(false);
                    return;
                }
                this.f11928af.m7388a(serializableMap);
                this.f11928af.m7387a(this.f11903R);
                this.f11956u.setEnabled(true);
            } else if (id == R.id.btn_saved_data && this.mainActivity != null) {
                IMActivity iMActivity = (IMActivity) this.mainActivity.getLocalActivityManager().getActivity(IMActivity.class.getSimpleName());
                if (iMActivity != null) {
                    FragmentManager fragmentManager2 = iMActivity.getFragmentManager();
                    if (fragmentManager2 != null && (backStackEntryCount = fragmentManager2.getBackStackEntryCount()) > 0) {
                        for (int i = 0; i < backStackEntryCount; i++) {
                            try {
                                fragmentManager2.popBackStackImmediate((String) null, 1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    getActivity().sendBroadcast(new Intent("finishIMActivity"));
                    try {
                        new Thread();
                        Thread.sleep(500L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                this.mainActivity.m7894b(R.id.btn_mine);
                MineActivity mineActivity = (MineActivity) this.mainActivity.getLocalActivityManager().getActivity(MineActivity.class.getSimpleName());
                if (mineActivity == null || (fragmentManager = mineActivity.getFragmentManager()) == null) {
                    return;
                }
                int backStackEntryCount2 = fragmentManager.getBackStackEntryCount();
                if (backStackEntryCount2 > 0) {
                    for (int i2 = 0; i2 < backStackEntryCount2; i2++) {
                        try {
                            fragmentManager.popBackStackImmediate((String) null, 1);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                MineFragment mineFragment = (MineFragment) fragmentManager.findFragmentByTag(MineFragment.class.getName());
                if (mineFragment != null) {
                    mineFragment.replaceFragment(ReportPagersFragment.class.getName());
                }
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 10086) {
            this.f11939aq.dismiss();
            this.f11928af.m7388a(this.f11942at);
            this.f11928af.m7387a(this.f11903R);
            this.f11956u.setEnabled(true);
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 10086) {
            this.f11939aq.dismiss();
            this.f11956u.setChecked(false);
            this.f11956u.setEnabled(true);
        }
        super.onFailure(i, i2, obj);
    }

    /* renamed from: j */
    private void m7276j() {
        this.f11948az = new DialogC2124al(this, this.mContext, getString(R.string.input_ds_record_file_name), this.f11909X);
        InputDialog inputDialog = this.f11948az;
        getString(R.string.input_ds_record_file_name);
        inputDialog.m4703c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7274k() {
        this.f11890E.setEnabled(true);
        this.f11887B.setEnabled(true);
        this.f11893H.setEnabled(true);
        this.f12357d.mo7087b(false);
        this.f12357d.mo7083i().setDatastreamRecord(false);
        this.f11955t.setVisibility(8);
        this.f11897L.stop();
        if (this.f11924ab.readGroupItemCount(this.f11923aa) <= 1) {
            NToast.m9444c(getActivity(), (int) R.string.datastream_record_rec_short_fail);
            File file = new File(PathUtils.m4843m() + this.f11908W);
            if (file.exists()) {
                file.delete();
            }
            this.f11924ab = null;
            return;
        }
        this.f11924ab.writeEndCloseFile(this.f11923aa, this.f11907V, this.f11911Z, this.f11910Y, this.f11908W);
        this.f11921aJ = ".x431";
        m7276j();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6404a(IDataStreamSelector iDataStreamSelector) {
        this.f11929ag = iDataStreamSelector;
        Log.d("DataStreamShowFragment", "setSelector:".concat(String.valueOf(iDataStreamSelector)));
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: a */
    public final void mo6399a(String str) {
        this.f11904S = str;
        Log.d("DataStreamShowFragment", "mask:" + this.f11904S);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_datastreamshow);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        IDataStreamSelector iDataStreamSelector = this.f11929ag;
        if (iDataStreamSelector != null) {
            iDataStreamSelector.mo6308a(z);
        }
    }

    /* compiled from: DataStreamShowFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aa$b */
    /* loaded from: classes.dex */
    class RunnableC2113b implements Runnable {

        /* renamed from: b */
        private boolean f11965b;

        public RunnableC2113b(boolean z) {
            this.f11965b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DataStreamShowFragment.this.f11931ai.putString("DataStreamMask", DataStreamShowFragment.this.f11904S);
            DataStreamShowFragment.this.f11931ai.putString("DataStreamShow_Type", DataStreamShowFragment.this.f11900O);
            DataStreamShowFragment.this.f11931ai.putInt("DataStreamCount", DataStreamShowFragment.this.f11902Q);
            DataStreamShowFragment.this.f11931ai.putInt("DataStreamCurPage", DataStreamShowFragment.this.f11928af.f11746h);
            DataStreamShowFragment.this.f11931ai.putString("DataStreamShow_HaveValueStatus", DataStreamShowFragment.this.f11901P);
            Log.d("DataStreamShowFragment", "run post action :" + this.f11965b);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final void onSelectReportFormatBack(String str) {
        String b;
        this.f12360g = str;
        if (FileUtils.m5027a() > 5) {
            if (!C1621v.m9121a(str)) {
                b = PathUtils.m4855d() + "/" + str + ".pdf";
            } else {
                b = m7121b(this.f11914aC, 2);
            }
            if (new File(b).exists()) {
                NToast.m9450a(this.mContext, (int) R.string.diagnose_report_saved_success);
                this.f12358e.setEnabled(true);
                return;
            }
            this.f12358e.setEnabled(false);
            if (this.f12357d != null) {
                LoadDialog.m4685a(this.mContext, (int) R.string.save_pdf_report);
                this.f11912aA = (PDFDataStreamInfo) m7123a(this.f11914aC, 2);
                PDFDataStreamInfo pDFDataStreamInfo = this.f11912aA;
                pDFDataStreamInfo.pdf_type = 2;
                pDFDataStreamInfo.pdfFileName = b;
                pDFDataStreamInfo.dataStreamList = m7272l();
                this.f11912aA.mapDataStreamID2ChoiceUnit = BasicDataStreamBean.mapDataStreamID2ChoiceUnit;
                this.f11913aB = m7120c(this.f11914aC, 2);
                this.f11913aB.setPdfFileName(b);
                this.f11913aB.setDataStreamBeenList(this.f11912aA.dataStreamList);
                this.f11913aB.setMapDataStreamID2ChoiceUnit(BasicDataStreamBean.mapDataStreamID2ChoiceUnit);
                if (this.f11912aA.dataStreamList == null) {
                    this.f12358e.setEnabled(true);
                    NToast.m9450a(this.mContext, (int) R.string.diagnose_report_create_pdf_file_err);
                    return;
                }
                Intent intent = new Intent(getActivity(), ReportIntentService.class);
                intent.setAction("com.cnlaunch.report.action_save");
                intent.putExtra("data_stream_report_content", this.f11912aA);
                intent.putExtra("reprot_type", "data_stream");
                intent.putExtra("if_has_standard_value", this.f11901P);
                getActivity().startService(intent);
                return;
            }
            return;
        }
        this.f12358e.setEnabled(true);
        NToast.m9450a(this.mContext, (int) R.string.sd_no_storage_space);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: a */
    public final void mo7125a(int i) {
        super.mo7125a(i);
        if (C2778n.m4905b()) {
            return;
        }
        this.f11950o = DateUtils.m5094a(DateStyle.f15729g);
        if (C2744aa.m5128p(this.mContext)) {
            this.f11914aC = DateUtils.m5092a(this.f11950o, DateStyle.f15731i);
        } else {
            this.f11914aC = this.f11950o;
        }
        this.f12360g = m7124a(2, this.f11950o);
        if (C2744aa.m5128p(this.mContext)) {
            showInputReportDialog(0);
            return;
        }
        this.f11915aD = new InputReportInfoDialog(getActivity(), this.f12360g);
        this.f11915aD.setCanceledOnTouchOutside(false);
        InputReportInfoDialog inputReportInfoDialog = this.f11915aD;
        inputReportInfoDialog.f16171b = this;
        inputReportInfoDialog.show();
    }

    /* renamed from: l */
    private ArrayList<BasicDataStreamBean> m7272l() {
        ArrayList<BasicDataStreamBean> arrayList = this.f11903R;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        this.f11903R = (ArrayList) MeasureConversion.m5099a(C2744aa.m5158d(getActivity()), this.f11903R);
        int i = this.f11928af.f11747i;
        int i2 = this.f11928af.f11748j;
        if (i < 0 || this.f11903R.size() < i2 || i > i2) {
            return null;
        }
        ArrayList<BasicDataStreamBean> arrayList2 = new ArrayList<>();
        arrayList2.addAll(this.f11903R.subList(i, i2));
        Iterator<BasicDataStreamBean> it = arrayList2.iterator();
        while (it.hasNext()) {
            BasicDataStreamBean next = it.next();
            String title = next.getTitle();
            SerializableMap serializableMap = this.f11942at;
            if (serializableMap != null && serializableMap.getMap() != null) {
                String str = this.f11942at.getMap().get(title);
                if (!TextUtils.isEmpty(str) && this.f11956u.isChecked()) {
                    next.setTranslation_title(str);
                } else {
                    next.setTranslation_title(title);
                }
            } else {
                next.setTranslation_title(title);
            }
        }
        return arrayList2;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        ArrayList<BasicDataStreamBean> m7272l = m7272l();
        if (m7272l == null) {
            return super.mo7100c();
        }
        Iterator<BasicDataStreamBean> it = m7272l.iterator();
        while (it.hasNext()) {
            BasicDataStreamBean next = it.next();
            String title = next.getTitle();
            SerializableMap serializableMap = this.f11942at;
            if (serializableMap != null && serializableMap.getMap() != null) {
                String str = this.f11942at.getMap().get(title);
                if (!TextUtils.isEmpty(str) && this.f11956u.isChecked()) {
                    next.setTranslation_title(str);
                } else {
                    next.setTranslation_title(title);
                }
            } else {
                next.setTranslation_title(title);
            }
        }
        return PrintDataUtils.m4933a(getActivity(), m7272l);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: e */
    public final String mo7119e() {
        int i = this.f11933ak;
        if (i >= 0) {
            try {
                String help = this.f11903R.get(i).getHelp();
                return TextUtils.isEmpty(help.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "")) ? super.mo7119e() : help;
            } catch (Exception unused) {
                return super.mo7119e();
            }
        }
        return getString(R.string.toast_need_select_before);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder
    /* renamed from: b */
    public final void mo6396b(int i) {
        this.f11933ak = i;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f11930ah = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        if (i == f11881b) {
            this.f11888C.setVisibility(8);
            if (this.f11932aj == 1) {
                this.f11887B.setVisibility(DataStreamConfiguration.m7955d() != 1 ? 0 : 8);
            }
            this.f11893H.setVisibility(0);
            this.f12358e.setVisibility(0);
            if (this.f11896K != null && this.f12357d.mo7083i().getDiagnoseStatue() > 1) {
                this.f11896K.setVisibility(0);
            }
            this.f11888C.setEnabled(false);
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(0);
            }
        } else if (i == f11880a) {
            this.f11887B.setVisibility(8);
            this.f11893H.setVisibility(8);
            this.f12358e.setVisibility(8);
            this.f11896K.setVisibility(8);
            this.f11888C.setVisibility(0);
            this.f11888C.setEnabled(true);
            if (this.f12357d.mo7083i().getDiagnoseStatue() == 0) {
                this.f11888C.setEnabled(false);
            }
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(8);
            }
        } else if (i == f11885m) {
            this.f11887B.setVisibility(8);
            this.f11893H.setVisibility(8);
            this.f12358e.setVisibility(8);
            this.f11896K.setVisibility(8);
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(8);
            }
        } else if (i == f11882j) {
            this.f11887B.setVisibility(8);
            this.f12358e.setVisibility(8);
            this.f11896K.setVisibility(8);
            this.f11895J.setVisibility(8);
            this.f11892G.setVisibility(8);
            this.f11894I.setVisibility(8);
            this.f11893H.setVisibility(8);
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(8);
            }
        } else if (i == f11883k) {
            this.f11887B.setVisibility(DataStreamConfiguration.m7955d() == 1 ? 8 : 0);
            this.f12358e.setVisibility(0);
            if (this.f11896K != null && this.f12357d.mo7083i().getDiagnoseStatue() > 1) {
                this.f11896K.setVisibility(0);
            }
            this.f11895J.setVisibility(8);
            this.f11892G.setVisibility(DataStreamConfiguration.m7955d() == 1 ? 0 : 8);
            this.f11894I.setVisibility(0);
            this.f11893H.setVisibility(0);
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(0);
            }
        } else if (i == f11884l) {
            this.f11887B.setVisibility(8);
            this.f12358e.setVisibility(8);
            this.f11896K.setVisibility(8);
            this.f11895J.setVisibility(0);
            this.f11892G.setVisibility(8);
            this.f11894I.setVisibility(8);
            this.f11893H.setVisibility(8);
            if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                this.f11898M.setVisibility(8);
            }
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
        ICallKeyDownFragment iCallKeyDownFragment = this.f11930ah;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment.mo6305a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
        ICallKeyDownFragment iCallKeyDownFragment = this.f11930ah;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment.mo6298d();
        }
    }

    /* compiled from: DataStreamShowFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.aa$a */
    /* loaded from: classes.dex */
    class C2112a implements Comparator<BasicDataStreamBean> {

        /* renamed from: a */
        RuleBasedCollator f11962a;

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(BasicDataStreamBean basicDataStreamBean, BasicDataStreamBean basicDataStreamBean2) {
            return this.f11962a.compare(basicDataStreamBean.getTitle(), basicDataStreamBean2.getTitle());
        }

        public C2112a() {
            this.f11962a = null;
            Locale locale = Locale.getDefault();
            if (locale.getCountry().equalsIgnoreCase("CN")) {
                this.f11962a = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);
            } else {
                this.f11962a = (RuleBasedCollator) Collator.getInstance(locale);
            }
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InputReportInfoDialog inputReportInfoDialog = this.f11915aD;
        if (inputReportInfoDialog != null) {
            inputReportInfoDialog.m4695b();
        }
        if (this.f11947ay) {
            if (this.f11946ax == null) {
                Context context = this.mContext;
                getResources().getString(R.string.common_title_tips);
                this.f11946ax = new WaitDialog(context, getResources().getString(R.string.refresh_txt));
            }
            this.f11946ax.show();
        }
        this.f11905T = (LinearLayout) getActivity().findViewById(R.id.linear_button_bottom);
        this.f11905T.setVisibility(0);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        try {
            if (this.f11926ad != null) {
                this.f11926ad.f11710b.mo7067d(getFragmentManager().beginTransaction());
                this.f11926ad.f11710b.mo7071a();
                this.f11926ad = null;
            }
            if (this.f11925ac != null) {
                this.f11925ac.f11710b.mo7067d(getFragmentManager().beginTransaction());
                this.f11925ac.f11710b.mo7071a();
                this.f11925ac = null;
            }
            if (this.f11927ae != null) {
                this.f11927ae.f11710b.mo7067d(getFragmentManager().beginTransaction());
                this.f11927ae.f11710b.mo7071a();
                this.f11927ae = null;
            }
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final void showInputReportDialog(int i) {
        switch (i) {
            case 0:
                String m5094a = DateUtils.m5094a(DateStyle.f15729g);
                if (C2744aa.m5128p(this.mContext)) {
                    this.f11914aC = DateUtils.m5092a(m5094a, DateStyle.f15731i);
                } else {
                    this.f11914aC = m5094a;
                }
                this.f11916aE = new InputVehicleInfoDialog(getActivity(), 2);
                this.f11916aE.m4689a(this, m5094a);
                this.f11916aE.setCanceledOnTouchOutside(false);
                this.f11916aE.show();
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
                if (this.f11917aF == null) {
                    this.f11917aF = new InputSensingDialog(this.mContext);
                }
                InputSensingDialog inputSensingDialog = this.f11917aF;
                inputSensingDialog.f16199a = this.f11916aE;
                inputSensingDialog.show();
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: a */
    public final void mo7078a(ArrayList<BasicDataStreamBean> arrayList) {
        boolean z;
        WaitDialog waitDialog;
        if (this.f11903R.size() == arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < this.f11903R.size(); i++) {
                arrayList2.add(this.f11903R.get(i).getTitle());
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList2.size()) {
                    z = true;
                    break;
                } else if (!arrayList2.contains(arrayList.get(i2).getTitle())) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = false;
        }
        this.f11949n = z;
        if (!this.f11949n) {
            this.f11956u.setChecked(false);
            this.f11942at = null;
            this.f11928af.m7388a((SerializableMap) null);
            ProgressBar progressBar = this.f11940ar;
            if (progressBar != null) {
                progressBar.setProgress(0);
            }
        }
        if (this.f11947ay && (waitDialog = this.f11946ax) != null) {
            waitDialog.hide();
        }
        if (this.f11937ao && !this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            this.f11936an = new C2112a();
            Collections.sort(arrayList, this.f11936an);
        } else if (this.f11900O.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            this.f11902Q = arrayList.size();
        }
        this.f11903R = arrayList;
        if (!this.f11949n) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.f11903R.size(); i3++) {
                sb.append("1");
            }
            this.f11904S = sb.toString();
        }
        if (this.f11935am) {
            this.f11935am = false;
            if (arrayList.size() == this.f11902Q) {
                if (this.f11924ab.writeDsBasics(this.f11923aa, arrayList)) {
                    this.f12357d.mo7083i().setDatastreamRecord(true);
                } else {
                    NToast.m9444c(getActivity(), (int) R.string.datastream_record_write_basicinfo_err);
                    m7274k();
                }
            }
        }
        if (this.f12357d.mo7083i().isDatastreamRecord()) {
            this.f11924ab.writeDSDate(this.f11923aa, arrayList);
        }
        boolean z2 = this.f11920aI;
        if (z2) {
            BaseDataStreamShowingFragment.m7127b(z2);
            if (this.f11906U.f11705a != null) {
                BottomActionBar bottomActionBar = this.f11906U;
                bottomActionBar.onClick(bottomActionBar.f11705a);
            }
            this.f11928af.m7378e();
            this.f11920aI = false;
            return;
        }
        this.f11928af.m7387a(arrayList);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        TranslationUtil translationUtil;
        if (i == 10086) {
            NLog.m9452b("yuandong", "local lang： ".concat(String.valueOf(LangManager.m9469a())));
            Map<String, String> hashMap = new HashMap<>();
            this.f11951p = 0;
            for (int i2 = 0; i2 < this.f11903R.size() && !this.f11918aG; i2++) {
                String title = this.f11903R.get(i2).getTitle();
                if (!"".equals(title) && !hashMap.containsKey(title)) {
                    translationUtil = TranslationUtil.C2754a.f15766a;
                    translationUtil.m5067a(title.trim(), new C2116ad(this, hashMap, title, i2));
                } else {
                    this.f11951p = ((i2 + 1) * 100) / this.f11903R.size();
                    this.f11941as.sendMessage(this.f11941as.obtainMessage(121212, this.f11951p, 0));
                }
            }
            if (!this.f11918aG) {
                this.f11942at = new SerializableMap();
                this.f11942at.setMap(hashMap);
            }
        }
        return 0;
    }

    /* renamed from: h */
    private boolean m7280h() {
        if (this.f12357d.mo7083i().isDatastreamRecord()) {
            NToast.m9444c(getActivity(), (int) R.string.datastream_record_recording_dont_exit);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7278i() {
        this.f12357d.mo7087b(false);
        this.f12357d.mo7083i().setDatastreamRecord(false);
        this.f11955t.setVisibility(8);
        this.f11897L.stop();
        this.f11924ab = null;
        this.f11890E.setEnabled(true);
        this.f11887B.setEnabled(true);
        this.f11893H.setEnabled(true);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f12357d.mo7083i().getDiagnoseStatue() < 2) {
            if (i == 4 && this.f12357d.mo7083i().isDatastreamRecord()) {
                NToast.m9444c(getActivity(), (int) R.string.toast_mustbe_stop_record);
                return true;
            } else if (1 == this.f11932aj && this.f11930ah.mo6304a(i, keyEvent)) {
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        } else if (this.f11938ap) {
            if (i == 4) {
                if (1 == this.f11932aj) {
                    if (this.f11930ah.mo6304a(i, keyEvent)) {
                        return true;
                    }
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "7", 5);
                    return true;
                } else if (this.f12357d.mo7083i().isDatastreamRecord()) {
                    this.f11952q = new Date().getTime();
                    if (this.f11952q - this.f11953r < 2000) {
                        return true;
                    }
                    NToast.m9444c(getActivity(), (int) R.string.toast_mustbe_stop_record);
                    this.f11953r = new Date().getTime();
                    return true;
                } else {
                    this.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "7", 5);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public final void m7286b(String str) {
        if (this.f12357d.mo7083i().getDiagnoseStatue() == 1) {
            this.f12357d.mo7093a("special_cmd", str, 18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7288a(DataStreamShowFragment dataStreamShowFragment, String str) {
        String str2 = str + ".x431";
        int CopySdcardFile = CopyFile.CopySdcardFile(PathUtils.m4843m() + dataStreamShowFragment.f11908W, PathUtils.m4855d() + str2);
        File file = new File(PathUtils.m4843m() + dataStreamShowFragment.f11908W);
        if (file.exists()) {
            file.delete();
        }
        if (CopySdcardFile == 0) {
            NToast.m9443c(dataStreamShowFragment.getActivity(), dataStreamShowFragment.getString(R.string.datastream_record_rec_success) + "\n" + str2);
            return;
        }
        NToast.m9443c(dataStreamShowFragment.getActivity(), dataStreamShowFragment.getString(R.string.datastream_record_rec_fail_for_copy) + "\n" + str2);
    }
}
