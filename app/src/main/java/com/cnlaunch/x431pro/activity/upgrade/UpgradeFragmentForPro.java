package com.cnlaunch.x431pro.activity.upgrade;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.p012v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.upgrade.p238a.ExpiredAdapter;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.RegisteredProductsResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.HistoryDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDivisionSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestPublicSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.PublicSoftLatestVersionDetail;
import com.cnlaunch.x431pro.module.p269j.p271b.PublicSoftLatestVersionResult;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.PagerSlidingTabStrip;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@SuppressLint({"NewApi"})
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.at */
/* loaded from: classes.dex */
public class UpgradeFragmentForPro extends BaseFragment implements ViewPager.InterfaceC0176e, View.OnClickListener, AdapterClickListenter {

    /* renamed from: E */
    private UpgradeAction f15142E;

    /* renamed from: F */
    private UpgradeAdapter f15143F;

    /* renamed from: G */
    private UpgradeAdapter f15144G;

    /* renamed from: H */
    private ExpiredAdapter f15145H;

    /* renamed from: I */
    private UpgradeAdapter f15146I;

    /* renamed from: J */
    private UpgradeAdapter f15147J;

    /* renamed from: K */
    private ExpiredAdapter f15148K;

    /* renamed from: L */
    private List<SerialNumber> f15149L;

    /* renamed from: M */
    private ConnectorAction f15150M;

    /* renamed from: O */
    private PreferencesManager f15152O;

    /* renamed from: P */
    private SerialNumberDao f15153P;

    /* renamed from: Q */
    private ExpandableListView f15154Q;

    /* renamed from: R */
    private CheckBox f15155R;

    /* renamed from: S */
    private Button f15156S;

    /* renamed from: T */
    private Button f15157T;

    /* renamed from: U */
    private Button f15158U;

    /* renamed from: V */
    private TextView f15159V;

    /* renamed from: W */
    private Button f15160W;

    /* renamed from: X */
    private ExpandableListView f15161X;

    /* renamed from: Y */
    private CheckBox f15162Y;

    /* renamed from: Z */
    private Button f15163Z;

    /* renamed from: aa */
    private Button f15172aa;

    /* renamed from: ab */
    private TextView f15173ab;

    /* renamed from: ac */
    private Button f15174ac;

    /* renamed from: ad */
    private TextView f15175ad;

    /* renamed from: ae */
    private TextView f15176ae;

    /* renamed from: af */
    private View f15177af;

    /* renamed from: ag */
    private PagerSlidingTabStrip f15178ag;

    /* renamed from: ah */
    private ArrayList<View> f15179ah;

    /* renamed from: ai */
    private C2641b f15180ai;

    /* renamed from: al */
    private String f15183al;

    /* renamed from: am */
    private String f15184am;

    /* renamed from: ao */
    private String f15186ao;

    /* renamed from: ap */
    private String f15187ap;

    /* renamed from: aq */
    private String f15188aq;

    /* renamed from: ar */
    private int f15189ar;

    /* renamed from: as */
    private List<X431PadDtoSoft> f15190as;

    /* renamed from: at */
    private List<X431PadDtoSoft> f15191at;

    /* renamed from: au */
    private List<X431PadDtoSoft> f15192au;

    /* renamed from: av */
    private List<X431PadDtoSoft> f15193av;

    /* renamed from: aw */
    private String f15194aw;

    /* renamed from: ax */
    private String f15195ax;

    /* renamed from: ay */
    private int f15196ay;

    /* renamed from: az */
    private int f15197az;

    /* renamed from: c */
    ViewPager f15199c;

    /* renamed from: d */
    SpinnerPopupWindow f15200d;

    /* renamed from: e */
    SpinnerPopupWindow f15201e;

    /* renamed from: a */
    final String f15164a = UpgradeFragmentForPro.class.getSimpleName();

    /* renamed from: b */
    public final int f15198b = 2100;

    /* renamed from: f */
    private final int f15202f = 2101;

    /* renamed from: g */
    private final int f15203g = 2102;

    /* renamed from: h */
    private final int f15204h = 2103;

    /* renamed from: i */
    private final int f15205i = 2104;

    /* renamed from: j */
    private final int f15206j = 2105;

    /* renamed from: k */
    private final int f15207k = 2106;

    /* renamed from: l */
    private final int f15208l = 2107;

    /* renamed from: m */
    private final int f15209m = 2108;

    /* renamed from: n */
    private final int f15210n = 2101;

    /* renamed from: o */
    private final int f15211o = 2107;

    /* renamed from: p */
    private final int f15212p = 2108;

    /* renamed from: q */
    private final int f15213q = 1;

    /* renamed from: r */
    private final int f15214r = 2;

    /* renamed from: s */
    private final int f15215s = 3;

    /* renamed from: t */
    private final int f15216t = 4;

    /* renamed from: u */
    private final int f15217u = 5;

    /* renamed from: v */
    private final int f15218v = 6;

    /* renamed from: w */
    private final int f15219w = 7;

    /* renamed from: x */
    private final int f15220x = 8;

    /* renamed from: y */
    private final int f15221y = 401;

    /* renamed from: z */
    private final int f15222z = 661;

    /* renamed from: A */
    private final int f15138A = 662;

    /* renamed from: B */
    private final int f15139B = UIMsg.d_ResultType.SHORT_URL;

    /* renamed from: C */
    private Handler f15140C = null;

    /* renamed from: D */
    private LoginDialog f15141D = null;

    /* renamed from: N */
    private List<ProductDTO> f15151N = new ArrayList();

    /* renamed from: aj */
    private View.OnClickListener f15181aj = null;

    /* renamed from: ak */
    private View.OnClickListener f15182ak = null;

    /* renamed from: an */
    private boolean f15185an = false;

    /* renamed from: aA */
    private int f15165aA = 0;

    /* renamed from: aB */
    private boolean f15166aB = false;

    /* renamed from: aC */
    private BroadcastReceiver f15167aC = null;

    /* renamed from: aD */
    private boolean f15168aD = true;

    /* renamed from: aE */
    private boolean f15169aE = false;

    /* renamed from: aF */
    private CompoundButton.OnCheckedChangeListener f15170aF = new C2642au(this);

    /* renamed from: aG */
    private CompoundButton.OnCheckedChangeListener f15171aG = new C2655bh(this);

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ int m5654l(UpgradeFragmentForPro upgradeFragmentForPro) {
        upgradeFragmentForPro.f15196ay = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static /* synthetic */ int m5652m(UpgradeFragmentForPro upgradeFragmentForPro) {
        upgradeFragmentForPro.f15197az = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ boolean m5650o(UpgradeFragmentForPro upgradeFragmentForPro) {
        upgradeFragmentForPro.f15168aD = false;
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        if (this.f15167aC != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15167aC);
            this.f15167aC = null;
            NLog.m9456a(this.f15164a, "onDestroy: unregisterReceiver:mBroadcast");
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        NLog.m9456a(this.f15164a, "onDestroyView");
        if (this.f15167aC != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15167aC);
            this.f15167aC = null;
            NLog.m9456a(this.f15164a, "onDestroyView: unregisterReceiver:mBroadcast");
        }
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NLog.m9456a(this.f15164a, "onCreate");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        NLog.m9456a(this.f15164a, "onActivityCreated");
        this.f15169aE = PreferencesManager.m9595a(this.mContext).m9583b("is_division_upgrade_show", false);
        NLog.m9456a("yhx", "onActivityCreated，isDivisionUpgradeShow=" + this.f15169aE);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        this.f15179ah = new ArrayList<>();
        this.f15179ah.add(layoutInflater.inflate(R.layout.upgrade_downloaded_list_view, (ViewGroup) null));
        this.f15179ah.add(layoutInflater.inflate(R.layout.upgrade_downloadable_list_view, (ViewGroup) null));
        this.f15180ai = new C2641b(this.f15179ah, getString(R.string.upgrade_downloaded), getString(R.string.upgrade_downloadable));
        this.f15199c = (ViewPager) getActivity().findViewById(R.id.pager);
        this.f15199c.setAdapter(this.f15180ai);
        this.f15178ag = (PagerSlidingTabStrip) getActivity().findViewById(R.id.table);
        this.f15178ag.setShouldExpand(true);
        this.f15178ag.setViewPager(this.f15199c);
        this.f15178ag.setOnPageChangeListener(this);
        this.f15178ag.setTextColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f15178ag.setIndicatorColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f15178ag.setTextSize(getResources().getInteger(R.integer.update_title_textsize));
        this.f15144G = new UpgradeAdapter(this.mContext, this);
        this.f15145H = new ExpiredAdapter(this.mContext, this);
        this.f15143F = this.f15144G;
        this.f15154Q = (ExpandableListView) this.f15179ah.get(0).findViewById(R.id.pull_refresh_listview);
        this.f15154Q.setGroupIndicator(null);
        this.f15154Q.setAdapter(this.f15143F);
        this.f15144G.m5808a(this.f15154Q);
        this.f15145H.m5808a(this.f15154Q);
        this.f15154Q.setOnGroupClickListener(new C2658bk(this));
        this.f15154Q.setOnChildClickListener(new C2659bl(this));
        this.f15181aj = new View$OnClickListenerC2643av(this);
        this.f15155R = (CheckBox) this.f15179ah.get(0).findViewById(R.id.checkBox_select_all);
        this.f15155R.setOnClickListener(this.f15181aj);
        this.f15155R.setOnCheckedChangeListener(this.f15170aF);
        this.f15156S = (Button) this.f15179ah.get(0).findViewById(R.id.button_update);
        this.f15156S.setOnClickListener(this.f15181aj);
        this.f15158U = (Button) this.f15179ah.get(0).findViewById(R.id.button_delete);
        this.f15158U.setOnClickListener(this.f15181aj);
        this.f15157T = (Button) this.f15179ah.get(0).findViewById(R.id.button_refresh);
        this.f15157T.setOnClickListener(this.f15181aj);
        this.f15159V = (TextView) this.f15179ah.get(0).findViewById(R.id.tv_remarks);
        this.f15160W = (Button) this.f15179ah.get(0).findViewById(R.id.btn_renewal);
        this.f15160W.setOnClickListener(this.f15181aj);
        this.f15147J = new UpgradeAdapter(this.mContext, this);
        this.f15148K = new ExpiredAdapter(this.mContext, this);
        this.f15146I = this.f15147J;
        this.f15161X = (ExpandableListView) this.f15179ah.get(1).findViewById(R.id.pull_refresh_listview);
        this.f15161X.setGroupIndicator(null);
        this.f15161X.setAdapter(this.f15146I);
        this.f15147J.m5808a(this.f15161X);
        this.f15148K.m5808a(this.f15161X);
        this.f15161X.setOnGroupClickListener(new C2660bm(this));
        this.f15161X.setOnChildClickListener(new C2661bn(this));
        this.f15182ak = new View$OnClickListenerC2662bo(this);
        this.f15162Y = (CheckBox) this.f15179ah.get(1).findViewById(R.id.checkBox_select_all);
        this.f15162Y.setOnClickListener(this.f15182ak);
        this.f15162Y.setOnCheckedChangeListener(this.f15171aG);
        this.f15163Z = (Button) this.f15179ah.get(1).findViewById(R.id.button_update);
        this.f15163Z.setOnClickListener(this.f15182ak);
        this.f15173ab = (TextView) this.f15179ah.get(1).findViewById(R.id.tv_remarks);
        this.f15174ac = (Button) this.f15179ah.get(1).findViewById(R.id.btn_renewal);
        this.f15174ac.setOnClickListener(this.f15182ak);
        this.f15172aa = (Button) this.f15179ah.get(1).findViewById(R.id.button_refresh);
        this.f15172aa.setOnClickListener(this.f15182ak);
        setTitle(R.string.tab_menu_upgrade);
        this.f15175ad = (TextView) this.mContentView.findViewById(R.id.tv_upgrade_num);
        this.f15175ad.setText(m5704a("0"));
        this.f15176ae = (TextView) this.mContentView.findViewById(R.id.tv_spinner_serialNo);
        this.f15152O = PreferencesManager.m9595a(this.mContext);
        this.f15153P = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f15142E = new UpgradeAction(this.mContext);
        this.f15150M = new ConnectorAction(this.mContext);
        this.f15140C = new HandlerC2645ax(this);
        m5671d();
        m5655l();
        IntentFilter intentFilter = new IntentFilter("login_change_serialno");
        intentFilter.addAction("logout");
        this.f15167aC = new C2657bj(this);
        this.mContext.registerReceiver(this.f15167aC, intentFilter);
        if (m5657k()) {
            if (this.f15149L.size() == 0) {
                new LoginFunction(this.mContext).m6582b();
            } else {
                m5678b();
                LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
                request(2101);
                NLog.m9456a(this.f15164a, "InitView: REQ_QUERYLATESTPUBLICSOFTS_CODE");
            }
        }
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("position")) {
            return;
        }
        int i = arguments.getInt("position");
        NLog.m9456a(this.f15164a, "position: ".concat(String.valueOf(i)));
        this.f15199c.setCurrentItem(i);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        NLog.m9456a(this.f15164a, "onStart");
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.setOnTouchListener(new View$OnTouchListenerC2656bi(this));
        super.onViewCreated(view, bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.upgrade_fragment_for_pro, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m5667f();
        NLog.m9456a(this.f15164a, "onResume");
        if (this.f15199c.getCurrentItem() == 0) {
            ((UpgradeActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((UpgradeActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
        this.f15152O.m9589a("remind_update_time", System.currentTimeMillis());
        NLog.m9456a("CarIconFragmentForAll", "Upgrade remind update time.");
        m5655l();
        if (this.f15185an && m5657k() && this.f15149L.size() != 0) {
            m5678b();
            LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
            request(2101);
            NLog.m9456a(this.f15164a, "onResume: REQ_QUERYLATESTPUBLICSOFTS_CODE");
        }
    }

    /* compiled from: UpgradeFragmentForPro.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.at$b */
    /* loaded from: classes.dex */
    class C2641b extends ViewPagerAdapter {

        /* renamed from: c */
        private String[] f15225c;

        public C2641b(ArrayList<View> arrayList, String... strArr) {
            super(arrayList);
            this.f15225c = new String[0];
            this.f15225c = strArr;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final CharSequence mo5638a(int i) {
            String[] strArr = this.f15225c;
            return i > strArr.length ? "NULL TITLE" : strArr[i];
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        try {
            this.f15199c.getChildAt(i).requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m5663h();
        m5667f();
        if (i == 0) {
            ((UpgradeActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((UpgradeActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5678b() {
        this.f15190as = null;
        this.f15191at = null;
        this.f15143F.m5807a((List<X431PadDtoSoft>) null);
        this.f15143F.notifyDataSetChanged();
        this.f15192au = null;
        this.f15146I.m5807a((List<X431PadDtoSoft>) null);
        this.f15146I.notifyDataSetChanged();
    }

    /* renamed from: b */
    private void m5675b(List<X431PadDtoSoft> list) {
        if (list == null) {
            return;
        }
        String m4916a = C2778n.m4916a(this.mContext, "enable_AutoSearch");
        if (TextUtils.isEmpty(m4916a)) {
            return;
        }
        int i = 0;
        if (!Boolean.parseBoolean(m4916a)) {
            while (i < list.size()) {
                X431PadDtoSoft x431PadDtoSoft = list.get(i);
                if (x431PadDtoSoft != null && x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("AUTOSEARCH")) {
                    list.remove(i);
                    i--;
                }
                i++;
            }
            return;
        }
        while (i < list.size()) {
            X431PadDtoSoft x431PadDtoSoft2 = list.get(i);
            if (x431PadDtoSoft2 != null && x431PadDtoSoft2.getSoftPackageID().equalsIgnoreCase("AUTOSEARCH")) {
                x431PadDtoSoft2.setMust(true);
                return;
            }
            i++;
        }
    }

    /* renamed from: c */
    private void m5674c() {
        String m9584b = this.f15152O.m9584b("serialNo", "");
        List<SerialNumber> loadAll = this.f15153P.loadAll();
        for (SerialNumber serialNumber : loadAll) {
            serialNumber.f15832b = Boolean.FALSE;
            serialNumber.f15833c = Boolean.FALSE;
        }
        this.f15153P.updateInTx(loadAll);
        List<ProductDTO> list = this.f15151N;
        if (list == null || list.isEmpty()) {
            if (!TextUtils.isEmpty(m9584b)) {
                this.f15152O.m9588a("preSerialNo", m9584b);
            }
            this.f15152O.m9587a("need_refresh", true);
            this.f15152O.m9588a("serialNo", "");
            this.f15152O.m9588a("if_auto_login", "0");
            this.f15152O.m9588a("serialNo", "");
            this.f15152O.m9588a("carSerialNo", "");
            this.f15152O.m9588a("heavydutySerialNo", "");
            this.f15152O.m9588a("carAndHeavydutySerialNo", "");
        } else {
            String m9591a = this.f15152O.m9591a("serialNo");
            String m9591a2 = this.f15152O.m9591a("carSerialNo");
            String m9591a3 = this.f15152O.m9591a("heavydutySerialNo");
            String m9591a4 = this.f15152O.m9591a("carAndHeavydutySerialNo");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (ProductDTO productDTO : this.f15151N) {
                String serialNo = productDTO.getSerialNo();
                if (C2744aa.m5161c(serialNo, this.mContext)) {
                    z = true;
                } else if (!TextUtils.isEmpty(m9591a2) && m9591a2.equals(serialNo)) {
                    z2 = true;
                } else if (!TextUtils.isEmpty(m9591a3) && m9591a3.equals(serialNo)) {
                    z3 = true;
                } else if (!TextUtils.isEmpty(m9591a4) && m9591a4.equals(serialNo)) {
                    z4 = true;
                }
            }
            if (z && !z2 && !z3 && !z4) {
                boolean z5 = false;
                for (int i = 0; i < this.f15151N.size(); i++) {
                    String serialNo2 = this.f15151N.get(i).getSerialNo();
                    SerialNumber serialNumber2 = new SerialNumber();
                    serialNumber2.f15835e = this.f15152O.m9591a("user_id");
                    if (!C2744aa.m5161c(serialNo2, this.mContext)) {
                        serialNumber2.f15833c = Boolean.FALSE;
                    } else if (!z5) {
                        this.f15152O.m9587a("need_refresh", true);
                        this.f15152O.m9588a("carAndHeavydutySerialNo", serialNo2);
                        this.f15152O.m9588a("serialNo", serialNo2);
                        this.f15152O.m9588a("carSerialNo", "");
                        this.f15152O.m9588a("heavydutySerialNo", "");
                        serialNumber2.f15833c = Boolean.TRUE;
                        z5 = true;
                    } else {
                        serialNumber2.f15833c = Boolean.FALSE;
                    }
                    serialNumber2.f15832b = Boolean.TRUE;
                    serialNumber2.f15834d = serialNo2;
                    QueryBuilder<SerialNumber> queryBuilder = this.f15153P.queryBuilder();
                    queryBuilder.where(SerialNumberDao.Properties.SerialNo.m321eq(serialNo2), new WhereCondition[0]);
                    List<SerialNumber> list2 = queryBuilder.list();
                    if (list2 == null || list2.isEmpty()) {
                        this.f15153P.insert(serialNumber2);
                    } else {
                        serialNumber2.f15831a = list2.get(0).f15831a;
                        this.f15153P.update(serialNumber2);
                    }
                }
            }
            if (!z || (z && (z2 || z3))) {
                this.f15152O.m9588a("carAndHeavydutySerialNo", "");
                boolean z6 = true;
                boolean z7 = true;
                for (int i2 = 0; i2 < this.f15151N.size(); i2++) {
                    String serialNo3 = this.f15151N.get(i2).getSerialNo();
                    SerialNumber serialNumber3 = new SerialNumber();
                    serialNumber3.f15835e = this.f15152O.m9591a("user_id");
                    if (C2744aa.m5168b(serialNo3, this.mContext)) {
                        if (z2) {
                            z6 = false;
                        } else if (z6) {
                            this.f15152O.m9587a("need_refresh", true);
                            this.f15152O.m9588a("carSerialNo", serialNo3);
                            z6 = false;
                        }
                    } else if (C2744aa.m5177a(serialNo3, this.mContext)) {
                        if (z3) {
                            z7 = false;
                        } else if (z7) {
                            this.f15152O.m9587a("need_refresh", true);
                            this.f15152O.m9588a("heavydutySerialNo", serialNo3);
                            z7 = false;
                        }
                    }
                    serialNumber3.f15833c = Boolean.FALSE;
                    serialNumber3.f15832b = Boolean.TRUE;
                    serialNumber3.f15834d = serialNo3;
                    QueryBuilder<SerialNumber> queryBuilder2 = this.f15153P.queryBuilder();
                    queryBuilder2.where(SerialNumberDao.Properties.SerialNo.m321eq(serialNo3), new WhereCondition[0]);
                    List<SerialNumber> list3 = queryBuilder2.list();
                    if (list3 == null || list3.isEmpty()) {
                        this.f15153P.insert(serialNumber3);
                    } else {
                        serialNumber3.f15831a = list3.get(0).f15831a;
                        this.f15153P.update(serialNumber3);
                    }
                }
                if (z6) {
                    if (!TextUtils.isEmpty(this.f15152O.m9591a("carSerialNo"))) {
                        this.f15152O.m9588a("carSerialNo", "");
                        this.f15152O.m9587a("need_refresh", true);
                    }
                    if (!z7) {
                        PreferencesManager preferencesManager = this.f15152O;
                        preferencesManager.m9588a("serialNo", preferencesManager.m9591a("heavydutySerialNo"));
                    } else {
                        this.f15152O.m9588a("serialNo", "");
                        if (!TextUtils.isEmpty(this.f15152O.m9591a("heavydutySerialNo"))) {
                            this.f15152O.m9588a("heavydutySerialNo", "");
                            this.f15152O.m9587a("need_refresh", true);
                        }
                    }
                } else {
                    PreferencesManager preferencesManager2 = this.f15152O;
                    preferencesManager2.m9588a("serialNo", preferencesManager2.m9591a("carSerialNo"));
                    if (z7) {
                        if (!TextUtils.isEmpty(this.f15152O.m9591a("heavydutySerialNo"))) {
                            this.f15152O.m9588a("heavydutySerialNo", "");
                            this.f15152O.m9587a("need_refresh", true);
                        }
                    } else {
                        String m9591a5 = this.f15152O.m9591a("carSerialNo");
                        String m9591a6 = this.f15152O.m9591a("heavydutySerialNo");
                        if (TextUtils.isEmpty(m9591a)) {
                            this.f15152O.m9588a("serialNo", m9591a5);
                        } else if (!m9591a2.equals(m9591a5) && !m9591a.equals(m9591a6)) {
                            this.f15152O.m9588a("serialNo", m9591a5);
                        }
                    }
                }
            }
            String m9591a7 = this.f15152O.m9591a("serialNo");
            this.f15184am = m9591a7;
            NLog.m9456a(this.f15164a, "newCurrentSerialNo=".concat(String.valueOf(m9591a7)));
            List<SerialNumber> loadAll2 = this.f15153P.loadAll();
            for (SerialNumber serialNumber4 : loadAll2) {
                serialNumber4.f15833c = Boolean.FALSE;
            }
            this.f15153P.updateInTx(loadAll2);
            if (!TextUtils.isEmpty(m9591a7)) {
                QueryBuilder<SerialNumber> queryBuilder3 = this.f15153P.queryBuilder();
                queryBuilder3.where(SerialNumberDao.Properties.SerialNo.m321eq(m9591a7), new WhereCondition[0]);
                SerialNumber unique = queryBuilder3.unique();
                unique.f15833c = Boolean.TRUE;
                this.f15153P.update(unique);
            }
        }
        if (this.f15152O.m9583b("need_refresh", false)) {
            this.mContext.sendBroadcast(new Intent("softs_updated"));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    @SuppressLint({"SimpleDateFormat"})
    public Object doInBackground(int i) throws C1425f {
        List<X431PadDtoSoft> x431PadSoftList;
        List<X431PadDtoSoft> x431PadSoftList2;
        switch (i) {
            case 2100:
                m5671d();
                return this.f15142E.m5279b(this.f15184am, this.f15186ao, this.f15187ap);
            case 2101:
                this.f15185an = false;
                this.f15196ay = 0;
                this.f15197az = 0;
                if (this.f15152O.m9583b("need_refresh", false)) {
                    new CarIconUtils(this.mContext).m4972a(this.f15152O.m9591a("carSerialNo"), this.f15152O.m9591a("heavydutySerialNo"));
                    this.f15152O.m9587a("need_refresh", false);
                }
                if (m5657k()) {
                    m5671d();
                    ConfigDBManager m5398a = ConfigDBManager.m5398a(this.mContext);
                    if (PreferencesManager.m9595a(this.mContext).m9583b("enable_breakpointresume", false)) {
                        this.f15194aw = m5398a.m5396a(KeyConstant.f6831ae);
                        this.f15195ax = m5398a.m5396a(KeyConstant.f6832af);
                        String str = this.f15164a;
                        NLog.m9456a(str, "diagsoftUrl: " + this.f15195ax);
                    } else {
                        this.f15194aw = m5398a.m5396a(KeyConstant.f6830ad);
                        this.f15195ax = m5398a.m5396a(KeyConstant.f6847au);
                    }
                    LatestPublicSoftsResponse m5282a = this.f15142E.m5282a(this.f15184am, this.f15186ao, this.f15187ap);
                    if (m5282a != null && isSuccess(m5282a.getCode()) && (x431PadSoftList = m5282a.getX431PadSoftList()) != null && x431PadSoftList.size() > 0) {
                        for (int i2 = 0; i2 < x431PadSoftList.size(); i2++) {
                            X431PadDtoSoft x431PadDtoSoft = x431PadSoftList.get(i2);
                            if (x431PadDtoSoft != null) {
                                String m5676b = m5676b(x431PadDtoSoft.getSoftPackageID());
                                x431PadDtoSoft.setMaxOldVersion(m5676b);
                                x431PadDtoSoft.setMaxAvailableVersion(x431PadDtoSoft.getVersionNo());
                                if (C2787z.m4820a(x431PadDtoSoft.getVersionNo(), m5676b)) {
                                    x431PadDtoSoft.setChecked(true);
                                } else {
                                    x431PadDtoSoft.setMust(true);
                                }
                                if (x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOAD_X431PADII") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROD5") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro3") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_PRO3S") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROJ") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PRO3C") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro4") || x431PadDtoSoft.getSoftPackageID().contains("DOWNLOAD_MAXIMUS2.0") || x431PadDtoSoft.getSoftPackageID().contains("DOWNLOAD_MaxGo") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("ScanPad071 firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_SCANPAD071D5") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("ScanPad101 firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADHEX_X431 HD") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X431 V firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X431VPlus Firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X-431 5C Firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_PROS") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROSPLUS") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431V_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431VPLUS_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_PAD3") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PRO3S_X431HD2") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431HDIV") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNBIN_X431_PADII_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI_RM08")) {
                                    x431PadDtoSoft.setMust(true);
                                    x431PadDtoSoft.setType(2);
                                } else if (x431PadDtoSoft.getSoftPackageID().startsWith("DOWNLOAD") || x431PadDtoSoft.getSoftPackageID().contains("firmware") || x431PadDtoSoft.getSoftPackageID().contains("Firmware")) {
                                    x431PadDtoSoft.setType(2);
                                } else {
                                    x431PadDtoSoft.setType(1);
                                    if (x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("golo_Business_Manager_APK_PADII") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("golo_Business_Manager_APK_Pro3") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("golo_Business_Manager_APK_Pro3S") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("golo_Business_Manager_APK_Pro")) {
                                        x431PadDtoSoft.setMust(true);
                                    }
                                }
                                x431PadDtoSoft.setUrl(this.f15194aw);
                            }
                        }
                    }
                    return m5282a;
                }
                break;
            case 2102:
                m5671d();
                LatestDiagSoftsResponse m5281a = this.f15142E.m5281a(this.f15183al, this.f15184am, this.f15186ao, this.f15187ap);
                if (isSuccess(m5281a.getCode()) && (x431PadSoftList2 = m5281a.getX431PadSoftList()) != null && x431PadSoftList2.size() > 0) {
                    this.f15166aB = false;
                    m5675b(x431PadSoftList2);
                    for (X431PadDtoSoft x431PadDtoSoft2 : x431PadSoftList2) {
                        String softPackageID = x431PadDtoSoft2.getSoftPackageID();
                        String lanId = x431PadDtoSoft2.getLanId();
                        String str2 = this.f15164a;
                        NLog.m9456a(str2, "getDiagSoftVersion enter,softId=" + softPackageID + ",lanId=" + lanId);
                        CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                        String m4963b = carIconUtils.m4963b(this.f15184am, softPackageID, LangManager.m9464b(lanId));
                        if (TextUtils.isEmpty(m4963b)) {
                            m4963b = carIconUtils.m4963b(this.f15184am, softPackageID, LangManager.m9461c(lanId));
                        }
                        if (!TextUtils.isEmpty(m4963b) && m4963b.compareToIgnoreCase("V00.00") == 0) {
                            m4963b = "";
                        }
                        x431PadDtoSoft2.setMaxOldVersion(m4963b);
                        x431PadDtoSoft2.setMaxAvailableVersion(x431PadDtoSoft2.getVersionNo());
                        if (C2787z.m4820a(x431PadDtoSoft2.getVersionNo(), m4963b)) {
                            x431PadDtoSoft2.setChecked(true);
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            if (simpleDateFormat.parse(x431PadDtoSoft2.getFreeUseEndTime()).before(simpleDateFormat.parse(x431PadDtoSoft2.getServerCurrentTime()))) {
                                this.f15166aB = true;
                                x431PadDtoSoft2.setExpired(true);
                                x431PadDtoSoft2.setRemarks(getString(R.string.txt_expired));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (x431PadDtoSoft2.getSoftPackageID().equalsIgnoreCase("AutoSearch")) {
                            x431PadDtoSoft2.setMust(true);
                        }
                        x431PadDtoSoft2.setType(3);
                        x431PadDtoSoft2.setUrl(this.f15195ax);
                    }
                }
                return m5281a;
            case 2103:
                m5671d();
                String str3 = this.f15186ao;
                Iterator<X431PadDtoSoft> it = this.f15190as.iterator();
                while (true) {
                    if (it.hasNext()) {
                        X431PadDtoSoft next = it.next();
                        if (next != null) {
                            String softId = next.getSoftId();
                            if (!TextUtils.isEmpty(softId) && softId.equals(this.f15188aq)) {
                                str3 = next.getLanId();
                            }
                        }
                    }
                }
                return this.f15142E.m5278b(this.f15184am, this.f15188aq, str3, this.f15187ap);
            case 2104:
                NLog.m9456a(this.f15164a, "REQ_QUERYSERIALNUMBER_CODE");
                this.f15152O.m9587a("iSGetSerialNumberFailed", false);
                return this.f15150M.m5361a(PreferencesManager.m9595a(this.mContext.getApplicationContext()).m9591a("seria_no_product_type"));
            case 2105:
                try {
                    return this.f15142E.m5283a(Integer.valueOf(Integer.parseInt(this.f15187ap)), "Universal Tool", "DiagBaseService_App", this.f15184am);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            case 2106:
                if (C2744aa.m5149f(this.f15184am)) {
                    try {
                        return this.f15142E.m5283a(Integer.valueOf(Integer.parseInt(this.f15187ap)), "Universal Tool", "DPULinkManagerServices", this.f15184am);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                return null;
            case 2107:
                try {
                    return this.f15142E.m5283a(Integer.valueOf(Integer.parseInt(this.f15187ap)), "Universal Tool", "VIN_RECOGNITION_APP", this.f15184am);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return null;
                }
            case 2108:
                m5671d();
                try {
                    return this.f15142E.m5283a(Integer.valueOf(Integer.parseInt(this.f15187ap)), "Universal Tool", "ENDOSCOPE_APP", this.f15184am);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return null;
                }
        }
        return super.doInBackground(i);
    }

    /* renamed from: a */
    private static void m5702a(List<X431PadDtoSoft> list, List<DivisionSoftDto> list2) {
        NLog.m9456a("yhx", "fillUpgradeListDivisionInfo enter.");
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return;
        }
        for (X431PadDtoSoft x431PadDtoSoft : list) {
            ArrayList arrayList = new ArrayList();
            for (DivisionSoftDto divisionSoftDto : list2) {
                if (x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase(divisionSoftDto.getSoftPackageId())) {
                    arrayList.add(divisionSoftDto);
                }
            }
            if (!arrayList.isEmpty()) {
                x431PadDtoSoft.setHaveDivisions(true);
                x431PadDtoSoft.setCarDivisionSoftDtoList(arrayList);
                NLog.m9456a("yhx", "upgradeBean=".concat(String.valueOf(x431PadDtoSoft)));
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2101:
            case 2102:
                this.f15185an = true;
                break;
            case 2104:
                NLog.m9456a(this.f15164a, "REQ_QUERYSERIALNUMBER_CODE: Failed!");
                this.f15185an = true;
                if (PreferencesManager.m9595a(this.mContext).m9583b("iSGetSerialNumberFailed", false)) {
                    this.f15140C.sendMessage(this.f15140C.obtainMessage(7, 0, 0));
                    break;
                }
                break;
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.tv_spinner_serialNo) {
            return;
        }
        m5655l();
        if (this.f15149L.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SerialNumber serialNumber : this.f15149L) {
            arrayList.add(serialNumber.f15834d);
        }
        this.f15201e = new SpinnerPopupWindow(this.mContext);
        this.f15201e.f16384c = this.f15176ae.getWidth();
        this.f15201e.f16383b = new C2650bc(this, arrayList);
        this.f15201e.m4582a(this.f15176ae, arrayList);
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4707a(View view, String str, int i) {
        this.f15188aq = str;
        this.f15177af = view;
        this.f15189ar = i;
        LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
        request(2103);
    }

    /* renamed from: a */
    public final SpannableStringBuilder m5704a(String str) {
        return new SpannableStringBuilder(getString(R.string.upgrade_num_txt, new Object[]{str}));
    }

    /* renamed from: d */
    private void m5671d() {
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                this.f15186ao = LangManager.m9467a(Lang.f7198G);
                this.f15187ap = LangManager.m9467a(Lang.f7203a);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f15186ao = LangManager.m9467a(Lang.f7197F);
                this.f15187ap = LangManager.m9467a(Lang.f7203a);
            } else {
                this.f15186ao = LangManager.m9467a(Lang.f7199H);
                this.f15187ap = this.f15186ao;
            }
        } else {
            this.f15186ao = LangManager.m9467a(LangManager.m9469a());
            this.f15187ap = LangManager.m9467a(Lang.f7203a);
        }
        this.f15184am = this.f15152O.m9591a("serialNo");
        String str = this.f15164a;
        NLog.m9456a(str, "serialNo=" + this.f15184am);
        if (TextUtils.isEmpty(this.f15184am)) {
            String m9591a = this.f15152O.m9591a("carSerialNo");
            String m9591a2 = this.f15152O.m9591a("heavydutySerialNo");
            if (!TextUtils.isEmpty(m9591a)) {
                this.f15184am = m9591a;
            } else {
                this.f15184am = m9591a2;
            }
            this.f15152O.m9588a("serialNo", this.f15184am);
        }
        this.f15183al = this.f15152O.m9591a("user_id");
        m5669e();
    }

    /* renamed from: e */
    private void m5669e() {
        DealDiagMessageHandler.m8673a().f9427c = null;
        this.f15140C.sendMessage(this.f15140C.obtainMessage(1, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5667f() {
        this.f15140C.sendMessage(this.f15140C.obtainMessage(2, 0, 0));
    }

    /* compiled from: UpgradeFragmentForPro.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.at$a */
    /* loaded from: classes.dex */
    public class C2640a implements Comparator<Object> {
        public C2640a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return CharacterParser.m4391a().m4390a(((X431PadDtoSoft) obj).getSoftName()).compareToIgnoreCase(CharacterParser.m4391a().m4390a(((X431PadDtoSoft) obj2).getSoftName()));
        }
    }

    /* renamed from: g */
    private void m5665g() {
        if (this.f15190as == null) {
            return;
        }
        if (this.f15191at == null) {
            this.f15191at = new ArrayList();
        }
        if (this.f15192au == null) {
            this.f15192au = new ArrayList();
        }
        for (X431PadDtoSoft x431PadDtoSoft : this.f15190as) {
            if (!x431PadDtoSoft.getMaxOldVersion().isEmpty()) {
                this.f15191at.add(x431PadDtoSoft);
            } else {
                this.f15192au.add(x431PadDtoSoft);
            }
        }
    }

    /* renamed from: h */
    private void m5663h() {
        int i;
        this.f15197az = 0;
        this.f15196ay = 0;
        if (this.f15191at == null) {
            this.f15191at = new ArrayList();
        }
        if (this.f15192au == null) {
            this.f15192au = new ArrayList();
        }
        if (this.f15199c.getCurrentItem() == 0) {
            List<X431PadDtoSoft> list = this.f15191at;
            if (list != null) {
                this.f15197az = list.size();
            }
            for (X431PadDtoSoft x431PadDtoSoft : this.f15191at) {
                if (C2787z.m4820a(x431PadDtoSoft.getVersionNo(), x431PadDtoSoft.getMaxOldVersion())) {
                    this.f15196ay++;
                }
            }
        } else if (1 == this.f15199c.getCurrentItem()) {
            List<X431PadDtoSoft> list2 = this.f15192au;
            if (list2 != null) {
                this.f15197az = list2.size();
            }
            for (X431PadDtoSoft x431PadDtoSoft2 : this.f15192au) {
                if (C2787z.m4820a(x431PadDtoSoft2.getVersionNo(), x431PadDtoSoft2.getMaxOldVersion())) {
                    this.f15196ay++;
                }
            }
        }
        List<X431PadDtoSoft> list3 = this.f15190as;
        if (list3 != null) {
            i = 0;
            for (X431PadDtoSoft x431PadDtoSoft3 : list3) {
                if (C2787z.m4820a(x431PadDtoSoft3.getVersionNo(), x431PadDtoSoft3.getMaxOldVersion()) && !x431PadDtoSoft3.getMaxOldVersion().isEmpty()) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.f15184am) && C2744aa.m5168b(this.f15184am, this.mContext)) {
            this.f15152O.m9590a("unupdateSoftwareNum", i);
        } else if (!TextUtils.isEmpty(this.f15184am) && C2744aa.m5177a(this.f15184am, this.mContext)) {
            this.f15152O.m9590a("unupdateSoftwareNumForHeavyduty", i);
        } else if (!TextUtils.isEmpty(this.f15184am) && C2744aa.m5161c(this.f15184am, this.mContext)) {
            this.f15152O.m9590a("unupdateSoftwareNum", i);
            this.f15152O.m9590a("unupdateSoftwareNumForHeavyduty", 0);
        }
        this.mContext.sendBroadcast(new Intent("unupgradeSoftNumChanged"));
        this.f15152O.m9587a("isRequestUpdateDataOK", true);
    }

    /* renamed from: b */
    private String m5676b(String str) {
        if (str == null) {
            return "";
        }
        if (str.equalsIgnoreCase("X-431 PAD II USA") || str.equalsIgnoreCase("X-431 PAD II") || str.equalsIgnoreCase("X431 Pro APP") || str.equalsIgnoreCase("X431_PRO_EURO_APP") || str.equalsIgnoreCase("X431_PRO_USA_APP") || str.equalsIgnoreCase("X431_PROSPLUS_DBScar5_APP") || str.equalsIgnoreCase("X431_PROSPLUS_EURO_DBScar5_APP") || str.equalsIgnoreCase("X431 Pro3 APP") || str.equalsIgnoreCase("X431PRO3S_APP") || str.equalsIgnoreCase("ScanPad071_2016_APP") || str.equalsIgnoreCase("ScanPad071_2017_APP") || str.equalsIgnoreCase("ScanPad071_V4_APP") || str.equalsIgnoreCase("X431PRO3S_USA_APP") || str.equalsIgnoreCase("X431PRO3S_EURO_APP") || str.equalsIgnoreCase("X431PROJ_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431_PRO3S_HDIII_APP") || str.equalsIgnoreCase("X431_PRO3C_APP") || str.equalsIgnoreCase("X431 Pro4 APP") || str.equalsIgnoreCase("X431 PRO3 HD") || str.equalsIgnoreCase("X431 PRO4 HD") || str.equalsIgnoreCase("X431_PADII_HD") || str.equalsIgnoreCase("X-431 PRO3_JINBEIHD_APP") || str.contains("Maximus2.0APK") || str.contains("MaxGo Application") || str.equalsIgnoreCase("ScanPad071") || str.equalsIgnoreCase("ScanPad071_APP") || str.equalsIgnoreCase("ScanPad071_AUS") || str.equalsIgnoreCase("ScanPad071_AUS_APP") || str.equalsIgnoreCase("ScanPad101") || str.equalsIgnoreCase("X-431V") || str.equalsIgnoreCase("X-431 VPlus Application") || str.equalsIgnoreCase("X-431 5C") || str.equalsIgnoreCase("X431_5C_2016_APP") || str.equalsIgnoreCase("X431_PROS_APP") || str.equalsIgnoreCase("X431_PROS_USA_APP") || str.equalsIgnoreCase("X431_PROS_EURO_APP") || str.equalsIgnoreCase("X431_PROS_HDIII_APP") || str.equalsIgnoreCase("X431V_2016_APP") || str.equalsIgnoreCase("X431VPLUS_2016_APP") || str.equalsIgnoreCase("X431_HD2_APP") || str.equalsIgnoreCase("X431_PAD3_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431HDIV_APPLICATION") || str.equalsIgnoreCase("X431_PADII_2016_USA_APP") || str.equalsIgnoreCase("ScanPlus_APP") || str.equalsIgnoreCase("X431V_2016_DBSCAR1_APP")) {
            return m5672c(getActivity().getPackageName());
        }
        if (str.equalsIgnoreCase("DOWNLOAD_X431PADII") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROD5") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro3") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PRO3S") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROJ") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3C") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2016") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2017") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro4") || str.contains("DOWNLOAD_MAXIMUS2.0") || str.contains("DOWNLOAD_MaxGo") || str.equalsIgnoreCase("ScanPad071 firmware") || str.equalsIgnoreCase("DOWNLOADBIN_SCANPAD071D5") || str.equalsIgnoreCase("ScanPad101 firmware") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("X431 V firmware") || str.equalsIgnoreCase("X431VPlus Firmware") || str.equalsIgnoreCase("X-431 5C Firmware") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PROS") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROSPLUS") || str.equalsIgnoreCase("DOWNLOADBIN_X431V_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431VPLUS_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PAD3") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3S_X431HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431HDIV") || str.equalsIgnoreCase("DOWNBIN_X431_PADII_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI_RM08")) {
            return m5661i();
        }
        if (str.equalsIgnoreCase("BatteryTest_X431PADII") || str.equalsIgnoreCase("BatteryTest_X431Pro") || str.contains("BatteryTest_MAXIMUS2.0")) {
            return m5672c("com.cnlaunch.batterytest");
        }
        if (str.equalsIgnoreCase("SensorApp_X431PADII") || str.equalsIgnoreCase("SensorApp_X431Pro") || str.contains("Sensor_MAXIMUS2.0")) {
            return m5672c("com.cnlaunch.sensor");
        }
        if (str.equalsIgnoreCase("Oscilloscope_X431PADII") || str.equalsIgnoreCase("Oscilloscope_X431Pro") || str.contains("Oscilloscope_X431PADII") || str.contains("Oscilloscope_MAXIMUS2.0")) {
            return m5672c("com.cnlaunch.oscilloscope");
        }
        if (str.equalsIgnoreCase("Ignition_X431PADII") || str.equalsIgnoreCase("Ignition_X431Pro") || str.contains("Ignition_MAXIMUS2.0")) {
            return m5672c("com.cnlaunch.oscilloscope");
        }
        if (str.equalsIgnoreCase("DiagBaseService_App")) {
            return m5672c("com.cnlaunch.DiagBaseService");
        }
        if (str.equalsIgnoreCase("DPULinkManagerServices")) {
            return m5672c("com.cnlaunch.dpulinkmanager");
        }
        if (str.equalsIgnoreCase("VIN_RECOGNITION_APP")) {
            return m5672c("com.cnlaunch.x431pro.scanner.vin");
        }
        return str.equalsIgnoreCase("ENDOSCOPE_APP") ? m5672c("com.cnlaunch.uvccamera") : "";
    }

    /* renamed from: c */
    private String m5672c(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer(getActivity().getPackageManager().getPackageInfo(str, 0).versionName);
            if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                stringBuffer.insert(0, 'V');
            }
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: i */
    private String m5661i() {
        String m4854d = PathUtils.m4854d(this.mContext, this.f15184am);
        File file = new File(m4854d + "Diagnostic/Configure/Download/DOWNLOAD.ini");
        if (file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                try {
                    properties.load(fileInputStream);
                    StringBuffer stringBuffer = new StringBuffer(properties.get("Version").toString());
                    if (stringBuffer.length() > 0 && stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                        stringBuffer.insert(0, 'V');
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return stringBuffer.toString();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return "";
                    }
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012d A[Catch: all -> 0x0184, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0011, B:12:0x0037, B:13:0x0040, B:15:0x004a, B:17:0x0056, B:37:0x009d, B:44:0x0109, B:45:0x0129, B:47:0x012d, B:52:0x013f, B:57:0x0158, B:60:0x016a, B:61:0x0177, B:20:0x005e, B:35:0x0098), top: B:68:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0177 A[Catch: all -> 0x0184, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0011, B:12:0x0037, B:13:0x0040, B:15:0x004a, B:17:0x0056, B:37:0x009d, B:44:0x0109, B:45:0x0129, B:47:0x012d, B:52:0x013f, B:57:0x0158, B:60:0x016a, B:61:0x0177, B:20:0x005e, B:35:0x0098), top: B:68:0x0003, inners: #1 }] */
    @android.annotation.SuppressLint({"SimpleDateFormat"})
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m5659j() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.UpgradeFragmentForPro.m5659j():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m5657k() {
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("token");
        String m9584b = this.f15152O.m9584b("login_state", "0");
        boolean z = (m9591a == null || m9591a2 == null || (m9591a2 != null && (m9591a2.isEmpty() || m9591a2.equals("null"))) || (m9591a != null && (m9591a.isEmpty() || m9591a2.equals("null")))) ? false : true;
        if (m9584b != null && m9584b.equals("0")) {
            z = false;
        }
        if (!z) {
            if (PreferencesManager.m9595a(this.mContext).m9583b("isconflict", false)) {
                this.f15140C.sendMessage(this.f15140C.obtainMessage(5, 0, 0));
            } else {
                NLog.m9456a(this.f15164a, "checkUserAndToken:MSG_RELOGINEX");
                this.f15140C.sendMessage(this.f15140C.obtainMessage(6, 0, 0));
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5655l() {
        if (this.f15153P == null) {
            this.f15153P = DBManager.m5036a(this.mContext).f15794a.f15798a;
        }
        if (this.f15152O == null) {
            this.f15152O = PreferencesManager.m9595a(this.mContext);
        }
        String m9591a = this.f15152O.m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = this.f15152O.m9591a("carSerialNo");
            String m9591a2 = this.f15152O.m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            this.f15152O.m9588a("serialNo", m9591a);
        }
        String m9591a3 = this.f15152O.m9591a("user_id");
        if (!m9591a.equals(this.f15184am) || !m9591a3.equals(this.f15183al)) {
            this.f15185an = true;
        }
        this.f15184am = m9591a;
        this.f15183al = m9591a3;
        List<SerialNumber> loadAll = this.f15153P.loadAll();
        this.f15149L = new ArrayList();
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext) || C2744aa.m5177a(serialNumber.f15834d, this.mContext) || C2744aa.m5161c(serialNumber.f15834d, this.mContext)) {
                if (serialNumber.f15832b.booleanValue()) {
                    this.f15149L.add(serialNumber);
                }
            }
        }
        if (this.f15149L.size() == 0) {
            this.f15184am = "";
        }
        m5669e();
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4708a() {
        if (this.f15199c.getCurrentItem() == 0) {
            List<X431PadDtoSoft> list = this.f15191at;
            if (list != null) {
                for (X431PadDtoSoft x431PadDtoSoft : list) {
                    if (x431PadDtoSoft.isChecked()) {
                        this.f15155R.setChecked(true);
                        return;
                    }
                }
            }
            this.f15155R.setChecked(false);
        } else if (1 == this.f15199c.getCurrentItem()) {
            List<X431PadDtoSoft> list2 = this.f15192au;
            if (list2 != null) {
                for (X431PadDtoSoft x431PadDtoSoft2 : list2) {
                    if (x431PadDtoSoft2.isChecked()) {
                        this.f15162Y.setChecked(true);
                        return;
                    }
                }
            }
            this.f15162Y.setChecked(false);
        }
    }

    /* renamed from: m */
    private void m5653m() {
        if (this.f15190as == null) {
            return;
        }
        for (int i = 0; i < this.f15190as.size() - 1; i++) {
            for (int size = this.f15190as.size() - 1; size > i; size--) {
                if (this.f15190as.get(size).getSoftPackageID().equals(this.f15190as.get(i).getSoftPackageID())) {
                    this.f15190as.remove(size);
                }
            }
        }
        NLog.m9451c(this.f15164a, "删除重复元素后upgradeList = " + this.f15190as);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SpinnerPopupWindow spinnerPopupWindow = this.f15200d;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
        SpinnerPopupWindow spinnerPopupWindow2 = this.f15201e;
        if (spinnerPopupWindow2 != null) {
            spinnerPopupWindow2.m4583a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        List<DivisionSoftDto> diagSoftSubPackList;
        List<X431PadDtoSoft> x431PadSoftList;
        RegisteredProductsResponse registeredProductsResponse;
        PublicSoftLatestVersionDetail publicSoftLatestVersionDetail;
        switch (i) {
            case 2100:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    LatestDivisionSoftsResponse latestDivisionSoftsResponse = (LatestDivisionSoftsResponse) obj;
                    if (isSuccess(latestDivisionSoftsResponse.getCode()) && (diagSoftSubPackList = latestDivisionSoftsResponse.getDiagSoftSubPackList()) != null && diagSoftSubPackList.size() > 0) {
                        for (DivisionSoftDto divisionSoftDto : diagSoftSubPackList) {
                            String str = PathUtils.m4868a(this.mContext, this.f15184am, divisionSoftDto.getSoftPackageId()) + File.separator + "Division.ini";
                            String softSubPackKey = divisionSoftDto.getSoftSubPackKey();
                            NLog.m9456a(this.f15164a, "getDivisionSoftVersion enter,softPackageId=" + softSubPackKey + ",iniFileName=" + str);
                            String m4997e = FileUtils.m4997e(str, softSubPackKey);
                            if (!TextUtils.isEmpty(m4997e) && m4997e.compareToIgnoreCase("V00.00") == 0) {
                                m4997e = "";
                            }
                            NLog.m9456a(this.f15164a, "getDivisionSoftVersion exit,version=".concat(String.valueOf(m4997e)));
                            divisionSoftDto.setMaxOldVersion(m4997e);
                            NLog.m9456a("yhx", "maxOldVersion=" + m4997e + ",currentVersion=" + divisionSoftDto.getvNum());
                            if (C2787z.m4820a(divisionSoftDto.getvNum(), m4997e)) {
                                divisionSoftDto.setChecked(true);
                            }
                            divisionSoftDto.setType(4);
                            String str2 = "";
                            try {
                                str2 = ConfigDBManager.m5398a(this.mContext).m5396a(KeyConstant.f6917cK);
                            } catch (C1425f e) {
                                e.printStackTrace();
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = "https://dlcenter.x431.com/diag/dlDiagSoftPack.action";
                            }
                            NLog.m9456a("yhx", "testDivisionDownloadUrl=".concat(String.valueOf(str2)));
                            divisionSoftDto.setUrl(str2);
                        }
                        m5702a(this.f15190as, diagSoftSubPackList);
                    }
                }
                if (!LangManager.m9466b().equalsIgnoreCase("CN")) {
                    this.f15143F = this.f15166aB ? this.f15145H : this.f15144G;
                    this.f15154Q.setAdapter(this.f15143F);
                    this.f15146I = this.f15166aB ? this.f15148K : this.f15147J;
                    this.f15161X.setAdapter(this.f15146I);
                }
                this.f15143F.m5807a(this.f15191at);
                this.f15143F.notifyDataSetChanged();
                this.f15146I.m5807a(this.f15192au);
                this.f15146I.notifyDataSetChanged();
                m5667f();
                LoadDialog.m4681b(this.mContext);
                m5659j();
                return;
            case 2101:
                this.f15190as = new ArrayList();
                if (obj != null) {
                    LatestPublicSoftsResponse latestPublicSoftsResponse = (LatestPublicSoftsResponse) obj;
                    if (isSuccess(latestPublicSoftsResponse.getCode()) && (x431PadSoftList = latestPublicSoftsResponse.getX431PadSoftList()) != null) {
                        if (this.f15190as == null) {
                            return;
                        }
                        for (X431PadDtoSoft x431PadDtoSoft : x431PadSoftList) {
                            if (!this.f15190as.contains(x431PadDtoSoft)) {
                                if (x431PadDtoSoft.getType() == 1) {
                                    ApkUpgradeAndDownloadLogic.m5636a(this.mContext);
                                    if (!ApkUpgradeAndDownloadLogic.m5627b(x431PadDtoSoft.getVersionDetailId())) {
                                    }
                                }
                                if (!ApkUpgradeAndDownloadLogic.m5636a(this.mContext).m5629a(x431PadDtoSoft.getVersionNo())) {
                                    this.f15190as.add(x431PadDtoSoft);
                                }
                            }
                        }
                    }
                    request(2105);
                    return;
                }
                LoadDialog.m4681b(this.mContext);
                return;
            case 2102:
                if (obj != null) {
                    LatestDiagSoftsResponse latestDiagSoftsResponse = (LatestDiagSoftsResponse) obj;
                    if (isSuccess(latestDiagSoftsResponse.getCode())) {
                        List<X431PadDtoSoft> x431PadSoftList2 = latestDiagSoftsResponse.getX431PadSoftList();
                        if (x431PadSoftList2 != null) {
                            List<X431PadDtoSoft> list = this.f15190as;
                            if (list == null) {
                                return;
                            }
                            list.addAll(x431PadSoftList2);
                        }
                    } else if (-1 == latestDiagSoftsResponse.getCode()) {
                        this.f15140C.sendMessage(this.f15140C.obtainMessage(5, 0, 0));
                    } else {
                        NToast.m9449a(this.mContext, latestDiagSoftsResponse.getMessage());
                    }
                }
                m5653m();
                if (this.f15190as != null) {
                    Collections.sort(this.f15190as, new C2640a());
                    Collections.sort(this.f15190as, new C2651bd(this));
                    Collections.sort(this.f15190as, new C2652be(this));
                    Collections.sort(this.f15190as, new C2653bf(this));
                }
                m5665g();
                m5663h();
                if (this.f15169aE) {
                    request(2100);
                    return;
                }
                if (!LangManager.m9466b().equalsIgnoreCase("CN")) {
                    this.f15143F = this.f15166aB ? this.f15145H : this.f15144G;
                    this.f15154Q.setAdapter(this.f15143F);
                    this.f15146I = this.f15166aB ? this.f15148K : this.f15147J;
                    this.f15161X.setAdapter(this.f15146I);
                }
                this.f15143F.m5807a(this.f15191at);
                this.f15143F.notifyDataSetChanged();
                this.f15146I.m5807a(this.f15192au);
                this.f15146I.notifyDataSetChanged();
                m5667f();
                LoadDialog.m4681b(this.mContext);
                m5659j();
                return;
            case 2103:
                if (obj != null) {
                    HistoryDiagSoftsResponse historyDiagSoftsResponse = (HistoryDiagSoftsResponse) obj;
                    if (isSuccess(historyDiagSoftsResponse.getCode())) {
                        ArrayList arrayList = new ArrayList();
                        this.f15193av = historyDiagSoftsResponse.getX431PadSoftList();
                        List<X431PadDtoSoft> list2 = this.f15193av;
                        if (list2 != null) {
                            if (list2 != null) {
                                Collections.sort(this.f15193av, new C2654bg(this));
                            }
                            for (X431PadDtoSoft x431PadDtoSoft2 : this.f15193av) {
                                arrayList.add(x431PadDtoSoft2.getVersionNo());
                            }
                        }
                        this.f15200d = new SpinnerPopupWindow(this.mContext);
                        this.f15200d.f16384c = this.f15177af.getWidth();
                        this.f15200d.f16383b = new C2649bb(this);
                        if (this.f15168aD) {
                            this.f15200d.m4581b(this.f15177af, arrayList);
                        }
                    } else if (-1 == historyDiagSoftsResponse.getCode()) {
                        this.f15140C.sendMessage(this.f15140C.obtainMessage(5, 0, 0));
                    } else {
                        NToast.m9449a(this.mContext, historyDiagSoftsResponse.getMessage());
                    }
                }
                LoadDialog.m4681b(this.mContext);
                return;
            case 2104:
                if (obj != null && (registeredProductsResponse = (RegisteredProductsResponse) obj) != null) {
                    if (isSuccess(registeredProductsResponse.getCode())) {
                        List<ProductDTO> productDTOs = registeredProductsResponse.getProductDTOs();
                        if (productDTOs != null && !productDTOs.isEmpty()) {
                            this.f15151N.addAll(productDTOs);
                        }
                    } else {
                        int code = registeredProductsResponse.getCode();
                        if (code != 401) {
                            if (code != 500) {
                                switch (code) {
                                    case 661:
                                        NToast.m9450a(this.mContext, (int) R.string.no_exist_product_type);
                                        break;
                                    case 662:
                                        break;
                                    default:
                                        NToast.m9450a(this.mContext, (int) R.string.get_sn_failed);
                                        break;
                                }
                            } else {
                                NToast.m9450a(this.mContext, (int) R.string.server_exception);
                            }
                        }
                        NLog.m9456a(this.f15164a, "registeredProductsResponse.getCode()=" + registeredProductsResponse.getCode());
                        this.f15152O.m9587a("iSGetSerialNumberFailed", true);
                    }
                }
                m5674c();
                this.mContext.sendBroadcast(new Intent("login_change_serialno"));
                return;
            case 2105:
            case 2106:
            case 2107:
            case 2108:
                if (obj != null) {
                    PublicSoftLatestVersionResult publicSoftLatestVersionResult = (PublicSoftLatestVersionResult) obj;
                    if (isSuccess(publicSoftLatestVersionResult.getCode()) && (publicSoftLatestVersionDetail = publicSoftLatestVersionResult.getPublicSoftLatestVersionDetail()) != null) {
                        X431PadDtoSoft x431PadDtoSoft3 = new X431PadDtoSoft();
                        StringBuilder sb = new StringBuilder();
                        sb.append(publicSoftLatestVersionDetail.getPubVersionDetailId());
                        x431PadDtoSoft3.setVersionDetailId(sb.toString());
                        x431PadDtoSoft3.setSoftName(publicSoftLatestVersionDetail.getSoftName());
                        x431PadDtoSoft3.setSoftPackageID(publicSoftLatestVersionDetail.getSoftPackageID());
                        x431PadDtoSoft3.setVersionNo("V" + publicSoftLatestVersionDetail.getVersionNo());
                        x431PadDtoSoft3.setLanId(publicSoftLatestVersionDetail.getLanId());
                        x431PadDtoSoft3.setType(1);
                        String m5676b = m5676b(x431PadDtoSoft3.getSoftPackageID());
                        x431PadDtoSoft3.setMaxOldVersion(m5676b);
                        x431PadDtoSoft3.setMaxAvailableVersion(x431PadDtoSoft3.getVersionNo());
                        if (C2787z.m4820a(x431PadDtoSoft3.getVersionNo(), m5676b)) {
                            x431PadDtoSoft3.setChecked(true);
                        } else {
                            x431PadDtoSoft3.setMust(true);
                        }
                        x431PadDtoSoft3.setUrl(this.f15194aw);
                        List<X431PadDtoSoft> list3 = this.f15190as;
                        if (list3 != null) {
                            list3.add(x431PadDtoSoft3);
                        }
                    }
                }
                if (i >= 2101) {
                    if (i < ((C2744aa.m5133n() && CommonTools.m7970a()) ? 2108 : 2107)) {
                        request(i + 1);
                        return;
                    }
                }
                request(2102);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ List m5703a(List list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) it.next();
                if (4 != x431PadDtoSoft.getState() && x431PadDtoSoft.isChecked()) {
                    DownloadSoftDto downloadSoftDto = new DownloadSoftDto();
                    downloadSoftDto.f15575a = x431PadDtoSoft.getSoftName();
                    downloadSoftDto.f15576b = x431PadDtoSoft.getVersionNo();
                    downloadSoftDto.f15580f = x431PadDtoSoft.getFileName();
                    downloadSoftDto.f15578d = x431PadDtoSoft.getProgress();
                    downloadSoftDto.f15579e = Integer.valueOf(x431PadDtoSoft.getState());
                    downloadSoftDto.f15577c = x431PadDtoSoft.getType();
                    downloadSoftDto.f15581g = x431PadDtoSoft.getVersionDetailId();
                    downloadSoftDto.f15583i = x431PadDtoSoft.getUrl();
                    downloadSoftDto.f15582h = x431PadDtoSoft.getFileSize();
                    downloadSoftDto.f15585k = x431PadDtoSoft.getLanId();
                    downloadSoftDto.f15584j = x431PadDtoSoft.getSoftPackageID();
                    downloadSoftDto.f15587m = x431PadDtoSoft.getFreeUseEndTime();
                    downloadSoftDto.f15590p = x431PadDtoSoft.getMaxOldVersion();
                    downloadSoftDto.f15591q = x431PadDtoSoft.getMaxAvailableVersion();
                    arrayList.add(downloadSoftDto);
                }
                if (x431PadDtoSoft.isHaveDivisions()) {
                    for (DivisionSoftDto divisionSoftDto : x431PadDtoSoft.getCarDivisionSoftDtoList()) {
                        if (divisionSoftDto.getState().intValue() != 4 && divisionSoftDto.isChecked()) {
                            DownloadSoftDto downloadSoftDto2 = new DownloadSoftDto();
                            downloadSoftDto2.f15575a = divisionSoftDto.getSpfNameDesc();
                            downloadSoftDto2.f15576b = "V" + divisionSoftDto.getvNum();
                            downloadSoftDto2.f15580f = divisionSoftDto.getFileName();
                            downloadSoftDto2.f15578d = divisionSoftDto.getProgress();
                            downloadSoftDto2.f15579e = divisionSoftDto.getState();
                            downloadSoftDto2.f15577c = divisionSoftDto.getType();
                            downloadSoftDto2.f15581g = divisionSoftDto.getSpfId();
                            downloadSoftDto2.f15583i = divisionSoftDto.getUrl();
                            downloadSoftDto2.f15582h = divisionSoftDto.getFileSize();
                            downloadSoftDto2.f15585k = "";
                            downloadSoftDto2.f15584j = divisionSoftDto.getSoftSubPackKey();
                            downloadSoftDto2.f15586l = divisionSoftDto.getSoftPackageId();
                            downloadSoftDto2.f15590p = divisionSoftDto.getMaxOldVersion();
                            downloadSoftDto2.f15591q = divisionSoftDto.getvNum();
                            arrayList.add(downloadSoftDto2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5705a(UpgradeFragmentForPro upgradeFragmentForPro, String str) {
        upgradeFragmentForPro.f15184am = str;
        upgradeFragmentForPro.f15152O.m9588a("serialNo", upgradeFragmentForPro.f15184am);
        if (C2744aa.m5168b(str, upgradeFragmentForPro.mContext)) {
            String m9591a = upgradeFragmentForPro.f15152O.m9591a("carSerialNo");
            if (!str.equals(m9591a)) {
                upgradeFragmentForPro.f15152O.m9588a("carSerialNo", str);
                if (C2744aa.m5161c(m9591a, upgradeFragmentForPro.mContext)) {
                    upgradeFragmentForPro.f15152O.m9588a("heavydutySerialNo", "");
                }
                upgradeFragmentForPro.f15152O.m9588a("carAndHeavydutySerialNo", "");
                upgradeFragmentForPro.f15152O.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5177a(str, upgradeFragmentForPro.mContext)) {
            String m9591a2 = upgradeFragmentForPro.f15152O.m9591a("heavydutySerialNo");
            if (!str.equals(m9591a2)) {
                upgradeFragmentForPro.f15152O.m9588a("heavydutySerialNo", str);
                if (C2744aa.m5161c(m9591a2, upgradeFragmentForPro.mContext)) {
                    upgradeFragmentForPro.f15152O.m9588a("carSerialNo", "");
                }
                upgradeFragmentForPro.f15152O.m9588a("carAndHeavydutySerialNo", "");
                upgradeFragmentForPro.f15152O.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5161c(str, upgradeFragmentForPro.mContext) && !str.equals(upgradeFragmentForPro.f15152O.m9591a("carAndHeavydutySerialNo"))) {
            upgradeFragmentForPro.f15152O.m9588a("carAndHeavydutySerialNo", str);
            upgradeFragmentForPro.f15152O.m9588a("carSerialNo", str);
            upgradeFragmentForPro.f15152O.m9588a("heavydutySerialNo", str);
            upgradeFragmentForPro.f15152O.m9587a("need_refresh", true);
        }
        upgradeFragmentForPro.m5669e();
    }
}
