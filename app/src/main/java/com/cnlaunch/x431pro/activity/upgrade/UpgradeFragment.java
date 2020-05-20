package com.cnlaunch.x431pro.activity.upgrade;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
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
import com.cnlaunch.p120d.p121a.LruCacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.mine.PayTypeFragment;
import com.cnlaunch.x431pro.activity.upgrade.p238a.ExpiredAdapter;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductDTO;
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
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

@SuppressLint({"NewApi"})
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ac */
/* loaded from: classes.dex */
public class UpgradeFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: A */
    private CheckBox f15067A;

    /* renamed from: B */
    private Button f15068B;

    /* renamed from: C */
    private Button f15069C;

    /* renamed from: D */
    private Button f15070D;

    /* renamed from: E */
    private TextView f15071E;

    /* renamed from: F */
    private TextView f15072F;

    /* renamed from: G */
    private View f15073G;

    /* renamed from: H */
    private TextView f15074H;

    /* renamed from: I */
    private String f15075I;

    /* renamed from: J */
    private String f15076J;

    /* renamed from: L */
    private String f15078L;

    /* renamed from: M */
    private String f15079M;

    /* renamed from: N */
    private String f15080N;

    /* renamed from: O */
    private int f15081O;

    /* renamed from: P */
    private List<X431PadDtoSoft> f15082P;

    /* renamed from: Q */
    private List<X431PadDtoSoft> f15083Q;

    /* renamed from: R */
    private String f15084R;

    /* renamed from: S */
    private String f15085S;

    /* renamed from: T */
    private int f15086T;

    /* renamed from: U */
    private int f15087U;

    /* renamed from: a */
    SpinnerPopupWindow f15093a;

    /* renamed from: b */
    SpinnerPopupWindow f15096b;

    /* renamed from: q */
    private UpgradeAction f15111q;

    /* renamed from: r */
    private UpgradeAdapter f15112r;

    /* renamed from: s */
    private UpgradeAdapter f15113s;

    /* renamed from: t */
    private ExpiredAdapter f15114t;

    /* renamed from: u */
    private List<SerialNumber> f15115u;

    /* renamed from: v */
    private ConnectorAction f15116v;

    /* renamed from: x */
    private PreferencesManager f15118x;

    /* renamed from: y */
    private SerialNumberDao f15119y;

    /* renamed from: z */
    private ExpandableListView f15120z;

    /* renamed from: c */
    private final String f15097c = UpgradeFragment.class.getSimpleName();

    /* renamed from: d */
    private final int f15098d = 1;

    /* renamed from: e */
    private final int f15099e = 2;

    /* renamed from: f */
    private final int f15100f = 3;

    /* renamed from: g */
    private final int f15101g = 4;

    /* renamed from: h */
    private final int f15102h = 5;

    /* renamed from: i */
    private final int f15103i = 6;

    /* renamed from: j */
    private final int f15104j = 7;

    /* renamed from: k */
    private final int f15105k = 401;

    /* renamed from: l */
    private final int f15106l = 661;

    /* renamed from: m */
    private final int f15107m = 662;

    /* renamed from: n */
    private final int f15108n = UIMsg.d_ResultType.SHORT_URL;

    /* renamed from: o */
    private Handler f15109o = null;

    /* renamed from: p */
    private LoginDialog f15110p = null;

    /* renamed from: w */
    private List<ProductDTO> f15117w = new ArrayList();

    /* renamed from: K */
    private boolean f15077K = false;

    /* renamed from: V */
    private int f15088V = 0;

    /* renamed from: W */
    private boolean f15089W = false;

    /* renamed from: X */
    private BroadcastReceiver f15090X = null;

    /* renamed from: Y */
    private boolean f15091Y = true;

    /* renamed from: Z */
    private boolean f15092Z = false;

    /* renamed from: aa */
    private CompoundButton.OnCheckedChangeListener f15094aa = new C2624ad(this);

    /* renamed from: ab */
    private AdapterClickListenter f15095ab = new C2639as(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ List m5749k(UpgradeFragment upgradeFragment) {
        upgradeFragment.f15082P = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ int m5745o(UpgradeFragment upgradeFragment) {
        upgradeFragment.f15086T = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static /* synthetic */ int m5744p(UpgradeFragment upgradeFragment) {
        upgradeFragment.f15087U = 0;
        return 0;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        if (this.f15090X != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15090X);
            this.f15090X = null;
            NLog.m9456a(this.f15097c, "onDestroy: unregisterReceiver:mBroadcast");
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        NLog.m9456a(this.f15097c, "onDestroyView");
        if (this.f15090X != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15090X);
            this.f15090X = null;
            NLog.m9456a(this.f15097c, "onDestroyView: unregisterReceiver:mBroadcast");
        }
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NLog.m9456a(this.f15097c, "onCreate");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        NLog.m9456a(this.f15097c, "onActivityCreated");
        this.f15092Z = PreferencesManager.m9595a(this.mContext).m9583b("is_division_upgrade_show", false);
        NLog.m9456a("yhx", "onActivityCreated，isDivisionUpgradeShow=" + this.f15092Z);
        setTitle(R.string.tab_menu_upgrade);
        this.f15113s = new UpgradeAdapter(this.mContext, this.f15095ab);
        this.f15114t = new ExpiredAdapter(this.mContext, this.f15095ab);
        this.f15112r = this.f15113s;
        this.f15120z = (ExpandableListView) this.mContentView.findViewById(R.id.pull_refresh_listview);
        this.f15120z.setGroupIndicator(null);
        this.f15120z.setAdapter(this.f15112r);
        this.f15113s.m5808a(this.f15120z);
        this.f15114t.m5808a(this.f15120z);
        this.f15120z.setOnGroupClickListener(new C2630aj(this));
        this.f15120z.setOnChildClickListener(new C2631ak(this));
        this.f15071E = (TextView) this.mContentView.findViewById(R.id.tv_upgrade_num);
        this.f15071E.setText(m5773a("0"));
        this.f15072F = (TextView) this.mContentView.findViewById(R.id.tv_spinner_serialNo);
        this.f15067A = (CheckBox) this.mContentView.findViewById(R.id.checkBox_select_all);
        this.f15067A.setOnClickListener(this);
        this.f15067A.setOnCheckedChangeListener(this.f15094aa);
        this.f15068B = (Button) this.mContentView.findViewById(R.id.button_update);
        this.f15068B.setOnClickListener(this);
        this.f15069C = (Button) this.mContentView.findViewById(R.id.btn_renewal);
        this.f15069C.setOnClickListener(this);
        this.f15069C.setVisibility(8);
        this.f15070D = (Button) this.mContentView.findViewById(R.id.button_refresh);
        this.f15070D.setOnClickListener(this);
        this.f15074H = (TextView) this.mContentView.findViewById(R.id.tv_remarks);
        this.f15118x = PreferencesManager.m9595a(this.mContext);
        this.f15119y = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f15111q = new UpgradeAction(this.mContext);
        this.f15116v = new ConnectorAction(this.mContext);
        this.f15109o = new HandlerC2633am(this);
        m5770b();
        m5754h();
        IntentFilter intentFilter = new IntentFilter("login_change_serialno");
        intentFilter.addAction("logout");
        intentFilter.addAction("softs_added");
        this.f15090X = new C2632al(this);
        this.mContext.registerReceiver(this.f15090X, intentFilter);
        if (m5756g()) {
            if (this.f15115u.size() == 0) {
                new LoginFunction(this.mContext).m6582b();
                return;
            }
            this.f15082P = null;
            this.f15112r.m5807a((List<X431PadDtoSoft>) null);
            this.f15112r.notifyDataSetChanged();
            LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
            request(2101);
            NLog.m9456a(this.f15097c, "InitView: REQ_QUERYLATESTPUBLICSOFTS_CODE");
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        NLog.m9456a(this.f15097c, "onStart");
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.setOnTouchListener(new View$OnTouchListenerC2629ai(this));
        super.onViewCreated(view, bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.upgrade_fragment, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m5762d();
        NLog.m9456a(this.f15097c, "onResume");
        this.f15118x.m9589a("remind_update_time", System.currentTimeMillis());
        NLog.m9456a("CarIconFragmentForAll", "Upgrade remind update time.");
        m5754h();
        if (this.f15077K && m5756g() && this.f15115u.size() != 0) {
            this.f15082P = null;
            this.f15112r.m5807a((List<X431PadDtoSoft>) null);
            this.f15112r.notifyDataSetChanged();
            LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
            request(2101);
            NLog.m9456a(this.f15097c, "onResume: REQ_QUERYLATESTPUBLICSOFTS_CODE");
        }
    }

    /* renamed from: a */
    private void m5772a(List<X431PadDtoSoft> list) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    @SuppressLint({"SimpleDateFormat"})
    public Object doInBackground(int i) throws C1425f {
        List<X431PadDtoSoft> x431PadSoftList;
        List<X431PadDtoSoft> x431PadSoftList2;
        switch (i) {
            case 2100:
                m5770b();
                return this.f15111q.m5279b(this.f15076J, this.f15078L, this.f15079M);
            case 2101:
                this.f15077K = false;
                this.f15086T = 0;
                this.f15087U = 0;
                if (this.f15118x.m9583b("need_refresh", false)) {
                    new CarIconUtils(this.mContext).m4972a(this.f15118x.m9591a("carSerialNo"), this.f15118x.m9591a("heavydutySerialNo"));
                    this.f15118x.m9587a("need_refresh", false);
                }
                if (m5756g()) {
                    m5770b();
                    ConfigDBManager m5398a = ConfigDBManager.m5398a(this.mContext);
                    if (PreferencesManager.m9595a(this.mContext).m9583b("enable_breakpointresume", false)) {
                        this.f15084R = m5398a.m5396a(KeyConstant.f6831ae);
                        this.f15085S = m5398a.m5396a(KeyConstant.f6832af);
                        String str = this.f15097c;
                        NLog.m9456a(str, "diagsoftUrl: " + this.f15085S);
                    } else {
                        this.f15084R = m5398a.m5396a(KeyConstant.f6830ad);
                        this.f15085S = m5398a.m5396a(KeyConstant.f6847au);
                    }
                    LatestPublicSoftsResponse m5282a = this.f15111q.m5282a(this.f15076J, this.f15078L, this.f15079M);
                    if (m5282a != null && isSuccess(m5282a.getCode()) && (x431PadSoftList = m5282a.getX431PadSoftList()) != null && x431PadSoftList.size() > 0) {
                        for (int i2 = 0; i2 < x431PadSoftList.size(); i2++) {
                            X431PadDtoSoft x431PadDtoSoft = x431PadSoftList.get(i2);
                            if (x431PadDtoSoft != null) {
                                String m5767b = m5767b(x431PadDtoSoft.getSoftPackageID());
                                x431PadDtoSoft.setMaxOldVersion(m5767b);
                                x431PadDtoSoft.setMaxAvailableVersion(x431PadDtoSoft.getVersionNo());
                                if (C2787z.m4820a(x431PadDtoSoft.getVersionNo(), m5767b)) {
                                    x431PadDtoSoft.setChecked(true);
                                } else {
                                    x431PadDtoSoft.setMust(true);
                                }
                                if (x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOAD_X431PADII") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROD5") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro3") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROJ") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PRO3C") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2017") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431 Pro4") || x431PadDtoSoft.getSoftPackageID().contains("DOWNLOAD_MAXIMUS2.0") || x431PadDtoSoft.getSoftPackageID().contains("DOWNLOAD_MaxGo") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("ScanPad071 firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_SCANPAD071D5") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("ScanPad101 firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADHEX_X431 HD") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X431 V firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X431VPlus Firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("X-431 5C Firmware") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_PROS") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PROSPLUS") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431V_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431VPLUS_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_PAD3") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431PRO3S_X431HD2") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431HDIV") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNBIN_X431_PADII_2016") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI") || x431PadDtoSoft.getSoftPackageID().equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI_RM08")) {
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
                                x431PadDtoSoft.setUrl(this.f15084R);
                            }
                        }
                    }
                    return m5282a;
                }
                break;
            case 2102:
                m5770b();
                LatestDiagSoftsResponse m5281a = this.f15111q.m5281a(this.f15075I, this.f15076J, this.f15078L, this.f15079M);
                if (isSuccess(m5281a.getCode()) && (x431PadSoftList2 = m5281a.getX431PadSoftList()) != null && x431PadSoftList2.size() > 0) {
                    this.f15089W = false;
                    m5772a(x431PadSoftList2);
                    for (X431PadDtoSoft x431PadDtoSoft2 : x431PadSoftList2) {
                        String softPackageID = x431PadDtoSoft2.getSoftPackageID();
                        String lanId = x431PadDtoSoft2.getLanId();
                        String str2 = this.f15097c;
                        NLog.m9456a(str2, "getDiagSoftVersion enter,softId=" + softPackageID + ",lanId=" + lanId);
                        CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                        String m4963b = carIconUtils.m4963b(this.f15076J, softPackageID, LangManager.m9464b(lanId));
                        if (TextUtils.isEmpty(m4963b)) {
                            m4963b = carIconUtils.m4963b(this.f15076J, softPackageID, LangManager.m9461c(lanId));
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
                                this.f15089W = true;
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
                        x431PadDtoSoft2.setUrl(this.f15085S);
                    }
                }
                return m5281a;
            case 2103:
                m5770b();
                String str3 = this.f15078L;
                Iterator<X431PadDtoSoft> it = this.f15082P.iterator();
                while (true) {
                    if (it.hasNext()) {
                        X431PadDtoSoft next = it.next();
                        if (next != null) {
                            String softId = next.getSoftId();
                            if (!TextUtils.isEmpty(softId) && softId.equals(this.f15080N)) {
                                str3 = next.getLanId();
                            }
                        }
                    }
                }
                return this.f15111q.m5278b(this.f15076J, this.f15080N, str3, this.f15079M);
            case 2105:
                try {
                    return this.f15111q.m5283a(Integer.valueOf(Integer.parseInt(this.f15079M)), "Universal Tool", "DiagBaseService_App", this.f15076J);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            case 2106:
                if (C2744aa.m5149f(this.f15076J)) {
                    try {
                        return this.f15111q.m5283a(Integer.valueOf(Integer.parseInt(this.f15079M)), "Universal Tool", "DPULinkManagerServices", this.f15076J);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                return null;
            case 2107:
                try {
                    return this.f15111q.m5283a(Integer.valueOf(Integer.parseInt(this.f15079M)), "Universal Tool", "VIN_RECOGNITION_APP", this.f15076J);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return null;
                }
            case 2108:
                m5770b();
                try {
                    return this.f15111q.m5283a(Integer.valueOf(Integer.parseInt(this.f15079M)), "Universal Tool", "ENDOSCOPE_APP", this.f15076J);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return null;
                }
        }
        return super.doInBackground(i);
    }

    /* renamed from: a */
    private void m5774a(Object obj) {
        if (obj != null) {
            LatestDiagSoftsResponse latestDiagSoftsResponse = (LatestDiagSoftsResponse) obj;
            if (isSuccess(latestDiagSoftsResponse.getCode())) {
                List<X431PadDtoSoft> x431PadSoftList = latestDiagSoftsResponse.getX431PadSoftList();
                if (x431PadSoftList != null) {
                    if (this.f15082P == null) {
                        return;
                    }
                    for (X431PadDtoSoft x431PadDtoSoft : x431PadSoftList) {
                        if (!this.f15082P.contains(x431PadDtoSoft)) {
                            this.f15082P.add(x431PadDtoSoft);
                        }
                    }
                }
            } else if (-1 == latestDiagSoftsResponse.getCode()) {
                this.f15109o.sendMessage(this.f15109o.obtainMessage(5, 0, 0));
            } else {
                NLog.m9456a(this.f15097c, "Message: " + latestDiagSoftsResponse.getMessage());
            }
        }
        m5752i();
        if (this.f15082P != null) {
            Collections.sort(this.f15082P, new C2623a());
            Collections.sort(this.f15082P, new C2625ae(this));
            Collections.sort(this.f15082P, new C2626af(this));
            Collections.sort(this.f15082P, new C2627ag(this));
        }
        List<X431PadDtoSoft> list = this.f15082P;
        if (list != null) {
            this.f15087U = list.size();
        } else {
            this.f15087U = 0;
        }
        this.f15086T = 0;
        List<X431PadDtoSoft> list2 = this.f15082P;
        if (list2 != null && !list2.isEmpty()) {
            for (X431PadDtoSoft x431PadDtoSoft2 : this.f15082P) {
                if (x431PadDtoSoft2 != null && x431PadDtoSoft2.isChecked()) {
                    this.f15086T++;
                }
            }
        }
        if (!TextUtils.isEmpty(this.f15076J) && C2744aa.m5168b(this.f15076J, this.mContext)) {
            this.f15118x.m9590a("unupdateSoftwareNum", this.f15086T);
        } else if (!TextUtils.isEmpty(this.f15076J) && C2744aa.m5177a(this.f15076J, this.mContext)) {
            this.f15118x.m9590a("unupdateSoftwareNumForHeavyduty", this.f15086T);
        } else if (!TextUtils.isEmpty(this.f15076J) && C2744aa.m5161c(this.f15076J, this.mContext)) {
            this.f15118x.m9590a("unupdateSoftwareNum", this.f15086T);
            this.f15118x.m9590a("unupdateSoftwareNumForHeavyduty", 0);
        }
        this.mContext.sendBroadcast(new Intent("unupgradeSoftNumChanged"));
        this.f15118x.m9587a("isRequestUpdateDataOK", true);
        if (this.f15092Z) {
            request(2100);
            return;
        }
        if (!LangManager.m9466b().equalsIgnoreCase("CN")) {
            this.f15112r = this.f15089W ? this.f15114t : this.f15113s;
            this.f15120z.setAdapter(this.f15112r);
        }
        m5762d();
        LoadDialog.m4681b(this.mContext);
        m5758f();
    }

    /* renamed from: a */
    private static void m5771a(List<X431PadDtoSoft> list, List<DivisionSoftDto> list2) {
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
            case 2105:
            case 2106:
            case 2107:
            case 2108:
                if (i >= 2101) {
                    if (i < ((C2744aa.m5133n() && CommonTools.m7970a()) ? 2108 : 2106)) {
                        request(i + 1);
                        return;
                    }
                }
                request(2102);
                return;
            case 2102:
                this.f15077K = true;
                LoadDialog.m4681b(this.mContext);
                return;
            case 2103:
            case 2104:
            default:
                this.f15077K = true;
                LoadDialog.m4681b(this.mContext);
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_renewal /* 2131296530 */:
                Bundle bundle = new Bundle();
                bundle.putString("serialNo", this.f15076J);
                addFragment(PayTypeFragment.class.getName(), bundle);
                break;
            case R.id.button_refresh /* 2131296614 */:
                break;
            case R.id.button_update /* 2131296619 */:
                boolean z = true;
                ArrayList arrayList = new ArrayList();
                List<X431PadDtoSoft> list = this.f15082P;
                if (list != null && !list.isEmpty()) {
                    for (X431PadDtoSoft x431PadDtoSoft : this.f15082P) {
                        if (x431PadDtoSoft.isChecked()) {
                            x431PadDtoSoft.setLanId(this.f15078L);
                            arrayList.add(x431PadDtoSoft);
                            z = false;
                        }
                        if (x431PadDtoSoft.isHaveDivisions()) {
                            for (DivisionSoftDto divisionSoftDto : x431PadDtoSoft.getCarDivisionSoftDtoList()) {
                                if (divisionSoftDto.isChecked()) {
                                    if (!arrayList.contains(x431PadDtoSoft)) {
                                        arrayList.add(x431PadDtoSoft);
                                    }
                                    z = false;
                                }
                            }
                        }
                    }
                }
                if (z) {
                    NToast.m9450a(this.mContext, (int) R.string.common_unselect_any);
                    return;
                }
                LruCacheManager.m9599a().m9596a("downloadList", m5766b(arrayList));
                addFragment(DownloadFragment.class.getName());
                this.f15091Y = false;
                return;
            case R.id.checkBox_select_all /* 2131296743 */:
                boolean isChecked = this.f15067A.isChecked();
                List<X431PadDtoSoft> list2 = this.f15082P;
                if (list2 == null || list2.size() <= 0) {
                    return;
                }
                for (X431PadDtoSoft x431PadDtoSoft2 : this.f15082P) {
                    if (!x431PadDtoSoft2.isMust()) {
                        x431PadDtoSoft2.setChecked(isChecked);
                    }
                    if (x431PadDtoSoft2.isHaveDivisions()) {
                        for (DivisionSoftDto divisionSoftDto2 : x431PadDtoSoft2.getCarDivisionSoftDtoList()) {
                            if (!divisionSoftDto2.isMust()) {
                                divisionSoftDto2.setChecked(isChecked);
                            }
                        }
                    }
                }
                this.f15112r.m5807a(this.f15082P);
                this.f15112r.notifyDataSetChanged();
                return;
            case R.id.tv_spinner_serialNo /* 2131298272 */:
                m5754h();
                if (this.f15115u.size() <= 0) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (SerialNumber serialNumber : this.f15115u) {
                    arrayList2.add(serialNumber.f15834d);
                }
                this.f15096b = new SpinnerPopupWindow(this.mContext);
                this.f15096b.f16384c = this.f15072F.getWidth();
                this.f15096b.f16383b = new C2638ar(this, arrayList2);
                this.f15096b.m4581b(this.f15072F, arrayList2);
                return;
            default:
                return;
        }
        this.f15112r.m5807a((List<X431PadDtoSoft>) null);
        this.f15112r.notifyDataSetChanged();
        if (m5756g()) {
            m5754h();
            if (this.f15115u.size() != 0) {
                LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.refresh_txt));
                request(2101);
                return;
            }
            new LoginFunction(this.mContext).m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
        }
    }

    /* renamed from: b */
    private static List<DownloadSoftDto> m5766b(List<X431PadDtoSoft> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (X431PadDtoSoft x431PadDtoSoft : list) {
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

    /* renamed from: a */
    public final SpannableStringBuilder m5773a(String str) {
        return new SpannableStringBuilder(getString(R.string.upgrade_num_txt, new Object[]{str}));
    }

    /* renamed from: b */
    private void m5770b() {
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            if (LangManager.m9466b().equalsIgnoreCase("TW")) {
                this.f15078L = LangManager.m9467a(Lang.f7198G);
                this.f15079M = LangManager.m9467a(Lang.f7203a);
            } else if (LangManager.m9466b().equalsIgnoreCase("HK")) {
                this.f15078L = LangManager.m9467a(Lang.f7197F);
                this.f15079M = LangManager.m9467a(Lang.f7203a);
            } else {
                this.f15078L = LangManager.m9467a(Lang.f7199H);
                this.f15079M = this.f15078L;
            }
        } else {
            this.f15078L = LangManager.m9467a(LangManager.m9469a());
            this.f15079M = LangManager.m9467a(Lang.f7203a);
        }
        this.f15076J = this.f15118x.m9591a("serialNo");
        String str = this.f15097c;
        NLog.m9456a(str, "serialNo=" + this.f15076J);
        if (TextUtils.isEmpty(this.f15076J)) {
            String m9591a = this.f15118x.m9591a("carSerialNo");
            String m9591a2 = this.f15118x.m9591a("heavydutySerialNo");
            if (!TextUtils.isEmpty(m9591a)) {
                this.f15076J = m9591a;
            } else {
                this.f15076J = m9591a2;
            }
            this.f15118x.m9588a("serialNo", this.f15076J);
        }
        this.f15075I = this.f15118x.m9591a("user_id");
        m5765c();
    }

    /* renamed from: c */
    private void m5765c() {
        DealDiagMessageHandler.m8673a().f9427c = null;
        this.f15109o.sendMessage(this.f15109o.obtainMessage(1, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5762d() {
        this.f15109o.sendMessage(this.f15109o.obtainMessage(2, 1, 0));
    }

    /* compiled from: UpgradeFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.ac$a */
    /* loaded from: classes.dex */
    public static class C2623a implements Serializable, Comparator<Object> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return getPingYin(((X431PadDtoSoft) obj).getSoftName()).compareToIgnoreCase(getPingYin(((X431PadDtoSoft) obj2).getSoftName()));
        }

        public final String getPingYin(String str) {
            return CharacterParser.m4391a().m4390a(str);
        }
    }

    /* renamed from: b */
    private String m5767b(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("X-431 PAD II USA") || str.equalsIgnoreCase("X-431 PAD II") || str.equalsIgnoreCase("X431 Pro APP") || str.equalsIgnoreCase("X431_PRO_EURO_APP") || str.equalsIgnoreCase("X431_PRO_USA_APP") || str.equalsIgnoreCase("X431_PROSPLUS_DBScar5_APP") || str.equalsIgnoreCase("X431_PROSPLUS_EURO_DBScar5_APP") || str.equalsIgnoreCase("X431 Pro3 APP") || str.equalsIgnoreCase("X431PRO3S_APP") || str.equalsIgnoreCase("ScanPad071_2016_APP") || str.equalsIgnoreCase("ScanPad071_2017_APP") || str.equalsIgnoreCase("ScanPad071_V4_APP") || str.equalsIgnoreCase("X431PRO3S_USA_APP") || str.equalsIgnoreCase("X431PRO3S_EURO_APP") || str.equalsIgnoreCase("X431PROJ_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431_PRO3S_HDIII_APP") || str.equalsIgnoreCase("X431_PRO3C_APP") || str.equalsIgnoreCase("X431 Pro4 APP") || str.equalsIgnoreCase("X431 PRO3 HD") || str.equalsIgnoreCase("X431 PRO4 HD") || str.equalsIgnoreCase("X431_PADII_HD") || str.equalsIgnoreCase("X-431 PRO3_JINBEIHD_APP") || str.contains("Maximus2.0APK") || str.contains("MaxGo Application") || str.equalsIgnoreCase("ScanPad071") || str.equalsIgnoreCase("ScanPad071_APP") || str.equalsIgnoreCase("ScanPad071_AUS") || str.equalsIgnoreCase("ScanPad071_AUS_APP") || str.equalsIgnoreCase("ScanPad101") || str.equalsIgnoreCase("X-431V") || str.equalsIgnoreCase("X-431 VPlus Application") || str.equalsIgnoreCase("X-431 5C") || str.equalsIgnoreCase("X431_5C_2016_APP") || str.equalsIgnoreCase("X431_PROS_APP") || str.equalsIgnoreCase("X431_PROS_USA_APP") || str.equalsIgnoreCase("X431_PROS_EURO_APP") || str.equalsIgnoreCase("X431_PROS_HDIII_APP") || str.equalsIgnoreCase("X431V_2016_APP") || str.equalsIgnoreCase("X431VPLUS_2016_APP") || str.equalsIgnoreCase("X431_HD2_APP") || str.equalsIgnoreCase("X431_PAD3_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431HDIV_APPLICATION") || str.equalsIgnoreCase("X431_PADII_2016_USA_APP") || str.equalsIgnoreCase("ScanPlus_APP") || str.equalsIgnoreCase("X431V_2016_DBSCAR1_APP")) {
            return m5763c(getActivity().getPackageName());
        }
        if (str.equalsIgnoreCase("DOWNLOAD_X431PADII") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROD5") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro3") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PRO3S") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROJ") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3C") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2016") || str.equalsIgnoreCase("DOWNLOADBIN_ScanPad071_2017") || str.equalsIgnoreCase("DOWNLOADBIN_X431 Pro4") || str.contains("DOWNLOAD_MAXIMUS2.0") || str.contains("DOWNLOAD_MaxGo") || str.equalsIgnoreCase("ScanPad071 firmware") || str.equalsIgnoreCase("DOWNLOADBIN_SCANPAD071D5") || str.equalsIgnoreCase("ScanPad101 firmware") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("DOWNLOADHEX_X431 HD") || str.equalsIgnoreCase("X431 V firmware") || str.equalsIgnoreCase("X431VPlus Firmware") || str.equalsIgnoreCase("X-431 5C Firmware") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PROS") || str.equalsIgnoreCase("DOWNLOADBIN_X431PROSPLUS") || str.equalsIgnoreCase("DOWNLOADBIN_X431V_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431VPLUS_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_PAD3") || str.equalsIgnoreCase("DOWNLOADBIN_X431PRO3S_X431HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431HDIV") || str.equalsIgnoreCase("DOWNBIN_X431_PADII_2016") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HD2") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI") || str.equalsIgnoreCase("DOWNLOADBIN_X431_HDIII_WIFI_RM08")) {
            return m5760e();
        }
        if (str.equalsIgnoreCase("BatteryTest_X431PADII") || str.equalsIgnoreCase("BatteryTest_X431Pro") || str.contains("BatteryTest_MAXIMUS2.0")) {
            return m5763c("com.cnlaunch.batterytest");
        }
        if (str.equalsIgnoreCase("SensorApp_X431PADII") || str.equalsIgnoreCase("SensorApp_X431Pro") || str.contains("Sensor_MAXIMUS2.0")) {
            return m5763c("com.cnlaunch.sensor");
        }
        if (str.equalsIgnoreCase("Oscilloscope_X431PADII") || str.equalsIgnoreCase("Oscilloscope_X431Pro") || str.contains("Oscilloscope_X431PADII") || str.contains("Oscilloscope_MAXIMUS2.0")) {
            return m5763c("com.cnlaunch.oscilloscope");
        }
        if (str.equalsIgnoreCase("Ignition_X431PADII") || str.equalsIgnoreCase("Ignition_X431Pro") || str.contains("Ignition_MAXIMUS2.0")) {
            return m5763c("com.cnlaunch.oscilloscope");
        }
        if (str.equalsIgnoreCase("DiagBaseService_App")) {
            return m5763c("com.cnlaunch.DiagBaseService");
        }
        if (str.equalsIgnoreCase("DPULinkManagerServices")) {
            return m5763c("com.cnlaunch.dpulinkmanager");
        }
        if (str.equalsIgnoreCase("VIN_RECOGNITION_APP")) {
            return m5763c("com.cnlaunch.x431pro.scanner.vin");
        }
        if (str.equalsIgnoreCase("ENDOSCOPE_APP")) {
            return m5763c("com.cnlaunch.uvccamera");
        }
        return null;
    }

    /* renamed from: c */
    private String m5763c(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer(getActivity().getPackageManager().getPackageInfo(str, 0).versionName);
            if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                stringBuffer.insert(0, 'V');
            }
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    private String m5760e() {
        String m4854d = PathUtils.m4854d(this.mContext, this.f15076J);
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
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129 A[Catch: all -> 0x0180, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000d, B:12:0x0033, B:13:0x003c, B:15:0x0046, B:17:0x0052, B:37:0x0099, B:44:0x0105, B:45:0x0125, B:47:0x0129, B:52:0x013b, B:57:0x0154, B:60:0x0166, B:61:0x0173, B:20:0x005a, B:35:0x0094), top: B:68:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0173 A[Catch: all -> 0x0180, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x000d, B:12:0x0033, B:13:0x003c, B:15:0x0046, B:17:0x0052, B:37:0x0099, B:44:0x0105, B:45:0x0125, B:47:0x0129, B:52:0x013b, B:57:0x0154, B:60:0x0166, B:61:0x0173, B:20:0x005a, B:35:0x0094), top: B:68:0x0003, inners: #1 }] */
    @android.annotation.SuppressLint({"SimpleDateFormat"})
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m5758f() {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.UpgradeFragment.m5758f():void");
    }

    /* renamed from: g */
    private boolean m5756g() {
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("user_id");
        String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("token");
        String m9584b = this.f15118x.m9584b("login_state", "0");
        boolean z = (m9591a == null || m9591a2 == null || (m9591a2 != null && (m9591a2.isEmpty() || m9591a2.equals("null"))) || (m9591a != null && (m9591a.isEmpty() || m9591a2.equals("null")))) ? false : true;
        if (m9584b != null && m9584b.equals("0")) {
            z = false;
        }
        if (!z) {
            if (PreferencesManager.m9595a(this.mContext).m9583b("isconflict", false)) {
                this.f15109o.sendMessage(this.f15109o.obtainMessage(5, 0, 0));
            } else {
                NLog.m9456a(this.f15097c, "checkUserAndToken:MSG_RELOGINEX");
                this.f15109o.sendMessage(this.f15109o.obtainMessage(6, 0, 0));
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5754h() {
        if (this.f15119y == null) {
            this.f15119y = DBManager.m5036a(this.mContext).f15794a.f15798a;
        }
        if (this.f15118x == null) {
            this.f15118x = PreferencesManager.m9595a(this.mContext);
        }
        String m9591a = this.f15118x.m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = this.f15118x.m9591a("carSerialNo");
            String m9591a2 = this.f15118x.m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            this.f15118x.m9588a("serialNo", m9591a);
        }
        String m9591a3 = this.f15118x.m9591a("user_id");
        if (!m9591a.equals(this.f15076J) || !m9591a3.equals(this.f15075I)) {
            this.f15077K = true;
        }
        this.f15076J = m9591a;
        this.f15075I = m9591a3;
        List<SerialNumber> loadAll = this.f15119y.loadAll();
        this.f15115u = new ArrayList();
        boolean m9583b = PreferencesManager.m9595a(this.mContext).m9583b("is_heavyduty", false);
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext) || ((m9583b && C2744aa.m5177a(serialNumber.f15834d, this.mContext)) || (m9583b && C2744aa.m5161c(serialNumber.f15834d, this.mContext)))) {
                if (serialNumber.f15832b.booleanValue()) {
                    this.f15115u.add(serialNumber);
                }
            }
        }
        if (this.f15115u.size() == 0) {
            this.f15076J = "";
        }
        m5765c();
    }

    /* renamed from: a */
    public final void m5781a() {
        for (X431PadDtoSoft x431PadDtoSoft : this.f15082P) {
            if (x431PadDtoSoft.isChecked()) {
                this.f15067A.setChecked(true);
                return;
            }
        }
        this.f15067A.setChecked(false);
    }

    /* renamed from: i */
    private void m5752i() {
        if (this.f15082P == null) {
            return;
        }
        for (int i = 0; i < this.f15082P.size() - 1; i++) {
            for (int size = this.f15082P.size() - 1; size > i; size--) {
                if (this.f15082P.get(size).getSoftPackageID().equals(this.f15082P.get(i).getSoftPackageID())) {
                    this.f15082P.remove(size);
                }
            }
        }
        NLog.m9451c(this.f15097c, "删除重复元素后upgradeList = " + this.f15082P);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SpinnerPopupWindow spinnerPopupWindow = this.f15093a;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
        SpinnerPopupWindow spinnerPopupWindow2 = this.f15096b;
        if (spinnerPopupWindow2 != null) {
            spinnerPopupWindow2.m4583a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        List<DivisionSoftDto> diagSoftSubPackList;
        List<X431PadDtoSoft> x431PadSoftList;
        PublicSoftLatestVersionDetail publicSoftLatestVersionDetail;
        switch (i) {
            case 2100:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    LatestDivisionSoftsResponse latestDivisionSoftsResponse = (LatestDivisionSoftsResponse) obj;
                    if (isSuccess(latestDivisionSoftsResponse.getCode()) && (diagSoftSubPackList = latestDivisionSoftsResponse.getDiagSoftSubPackList()) != null && diagSoftSubPackList.size() > 0) {
                        for (DivisionSoftDto divisionSoftDto : diagSoftSubPackList) {
                            String str = PathUtils.m4868a(this.mContext, this.f15076J, divisionSoftDto.getSoftPackageId()) + File.separator + "Division.ini";
                            String softSubPackKey = divisionSoftDto.getSoftSubPackKey();
                            NLog.m9456a(this.f15097c, "getDivisionSoftVersion enter,softPackageId=" + softSubPackKey + ",iniFileName=" + str);
                            String m4997e = FileUtils.m4997e(str, softSubPackKey);
                            if (!TextUtils.isEmpty(m4997e) && m4997e.compareToIgnoreCase("V00.00") == 0) {
                                m4997e = "";
                            }
                            NLog.m9456a(this.f15097c, "getDivisionSoftVersion exit,version=".concat(String.valueOf(m4997e)));
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
                        m5771a(this.f15082P, diagSoftSubPackList);
                    }
                }
                if (!LangManager.m9466b().equalsIgnoreCase("CN")) {
                    this.f15112r = this.f15089W ? this.f15114t : this.f15113s;
                    this.f15120z.setAdapter(this.f15112r);
                }
                m5762d();
                LoadDialog.m4681b(this.mContext);
                m5758f();
                return;
            case 2101:
                this.f15082P = new ArrayList();
                if (obj != null) {
                    LatestPublicSoftsResponse latestPublicSoftsResponse = (LatestPublicSoftsResponse) obj;
                    if (isSuccess(latestPublicSoftsResponse.getCode()) && (x431PadSoftList = latestPublicSoftsResponse.getX431PadSoftList()) != null) {
                        if (this.f15082P == null) {
                            return;
                        }
                        for (X431PadDtoSoft x431PadDtoSoft : x431PadSoftList) {
                            if (!this.f15082P.contains(x431PadDtoSoft)) {
                                if (x431PadDtoSoft.getType() == 1) {
                                    ApkUpgradeAndDownloadLogic.m5636a(this.mContext);
                                    if (!ApkUpgradeAndDownloadLogic.m5627b(x431PadDtoSoft.getVersionDetailId())) {
                                    }
                                }
                                if (!ApkUpgradeAndDownloadLogic.m5636a(this.mContext).m5629a(x431PadDtoSoft.getVersionNo())) {
                                    this.f15082P.add(x431PadDtoSoft);
                                }
                            }
                        }
                    }
                }
                request(2105);
                return;
            case 2102:
                m5774a(obj);
                return;
            case 2103:
                if (obj != null) {
                    HistoryDiagSoftsResponse historyDiagSoftsResponse = (HistoryDiagSoftsResponse) obj;
                    if (isSuccess(historyDiagSoftsResponse.getCode())) {
                        ArrayList arrayList = new ArrayList();
                        this.f15083Q = historyDiagSoftsResponse.getX431PadSoftList();
                        List<X431PadDtoSoft> list = this.f15083Q;
                        if (list != null) {
                            if (list != null) {
                                Collections.sort(this.f15083Q, new C2628ah(this));
                            }
                            for (X431PadDtoSoft x431PadDtoSoft2 : this.f15083Q) {
                                arrayList.add(x431PadDtoSoft2.getVersionNo());
                            }
                        }
                        if (this.f15073G == null) {
                            return;
                        }
                        this.f15093a = new SpinnerPopupWindow(this.mContext);
                        this.f15093a.f16384c = this.f15073G.getWidth();
                        this.f15093a.f16383b = new C2637aq(this);
                        if (this.f15091Y) {
                            this.f15093a.m4581b(this.f15073G, arrayList);
                        }
                    } else if (-1 == historyDiagSoftsResponse.getCode()) {
                        this.f15109o.sendMessage(this.f15109o.obtainMessage(5, 0, 0));
                    } else {
                        NToast.m9449a(this.mContext, historyDiagSoftsResponse.getMessage());
                    }
                }
                LoadDialog.m4681b(this.mContext);
                return;
            case 2104:
            default:
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
                        String m5767b = m5767b(x431PadDtoSoft3.getSoftPackageID());
                        x431PadDtoSoft3.setMaxOldVersion(m5767b);
                        x431PadDtoSoft3.setMaxAvailableVersion(x431PadDtoSoft3.getVersionNo());
                        x431PadDtoSoft3.setFileSize(publicSoftLatestVersionDetail.getFileSize());
                        if (C2778n.m4902b(publicSoftLatestVersionDetail.getSoftPackageID())) {
                            x431PadDtoSoft3.setMust(true);
                        }
                        if (C2787z.m4820a(x431PadDtoSoft3.getVersionNo(), m5767b)) {
                            x431PadDtoSoft3.setChecked(true);
                        } else {
                            x431PadDtoSoft3.setMust(true);
                        }
                        x431PadDtoSoft3.setUrl(this.f15084R);
                        List<X431PadDtoSoft> list2 = this.f15082P;
                        if (list2 != null) {
                            list2.add(x431PadDtoSoft3);
                        }
                    }
                }
                if (i >= 2101) {
                    if (i < ((C2744aa.m5133n() && CommonTools.m7970a()) ? 2108 : 2106)) {
                        request(i + 1);
                        return;
                    }
                }
                request(2102);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5776a(UpgradeFragment upgradeFragment, String str) {
        upgradeFragment.f15076J = str;
        upgradeFragment.f15118x.m9588a("serialNo", upgradeFragment.f15076J);
        if (C2744aa.m5168b(str, upgradeFragment.mContext)) {
            String m9591a = upgradeFragment.f15118x.m9591a("carSerialNo");
            if (!str.equals(m9591a)) {
                upgradeFragment.f15118x.m9588a("carSerialNo", str);
                if (C2744aa.m5161c(m9591a, upgradeFragment.mContext)) {
                    upgradeFragment.f15118x.m9588a("heavydutySerialNo", "");
                }
                upgradeFragment.f15118x.m9588a("carAndHeavydutySerialNo", "");
                upgradeFragment.f15118x.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5177a(str, upgradeFragment.mContext)) {
            String m9591a2 = upgradeFragment.f15118x.m9591a("heavydutySerialNo");
            if (!str.equals(m9591a2)) {
                upgradeFragment.f15118x.m9588a("heavydutySerialNo", str);
                if (C2744aa.m5161c(m9591a2, upgradeFragment.mContext)) {
                    upgradeFragment.f15118x.m9588a("carSerialNo", "");
                }
                upgradeFragment.f15118x.m9588a("carAndHeavydutySerialNo", "");
                upgradeFragment.f15118x.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5161c(str, upgradeFragment.mContext) && !str.equals(upgradeFragment.f15118x.m9591a("carAndHeavydutySerialNo"))) {
            upgradeFragment.f15118x.m9588a("carAndHeavydutySerialNo", str);
            upgradeFragment.f15118x.m9588a("carSerialNo", str);
            upgradeFragment.f15118x.m9588a("heavydutySerialNo", str);
            upgradeFragment.f15118x.m9587a("need_refresh", true);
        }
        upgradeFragment.m5765c();
    }
}
