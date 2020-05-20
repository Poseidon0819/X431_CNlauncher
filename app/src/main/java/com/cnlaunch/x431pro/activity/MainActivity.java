package com.cnlaunch.x431pro.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.cnlaunch.defend.DefendService;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.golo3.p160b.GoloCacheManager;
import com.cnlaunch.golo3.p165g.AbstractC1614h;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.DeferredHandler;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p167h.C1673a;
import com.cnlaunch.p168i.InterfaceViewController;
import com.cnlaunch.p169im.GoloApplication;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p176f.IMManager;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.p169im.p178h.GoloTipObServer;
import com.cnlaunch.p169im.service.GoloMessageService;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.p188n.RemoteSocketControler;
import com.cnlaunch.p188n.ReportSocketControler;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.AppMlogConfig;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.CloudDiagnose.CloudGetReportCacheTask;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.golousa.GoloUSAActivity;
import com.cnlaunch.x431pro.activity.info.InfoActivity;
import com.cnlaunch.x431pro.activity.info.RepairInfoActivity;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.activity.setting.FeedbackActivity;
import com.cnlaunch.x431pro.activity.setting.MallActivity;
import com.cnlaunch.x431pro.activity.setting.SettingActivity;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener;
import com.cnlaunch.x431pro.activity.tools.ToolsActivity;
import com.cnlaunch.x431pro.activity.upgrade.UpgradeActivity;
import com.cnlaunch.x431pro.module.cloud.model.CloudDataManager;
import com.cnlaunch.x431pro.module.cloud.p248b.WebRemoteHandler;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p242ad.AdUtil;
import com.cnlaunch.x431pro.module.p252d.p254b.SellerRemoteDiagInfo;
import com.cnlaunch.x431pro.module.p263h.p264a.SettingAction;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadDiagnosticLogResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadLog;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.UpLoadSaveReportTask;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.p210a.ConfigUtils;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.p210a.DialogC1945e;
import com.cnlaunch.x431pro.p210a.LaunchLogic;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.C2751c;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p285e.ZipFileUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.NestRadioGroup;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;
import com.cnlaunch.x431pro.widget.slidingmenu.p293a.SlidingFragmentActivity;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;
import com.p297e.p298a.p306b.ImageLoader;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"HandlerLeak", "SimpleDateFormat"})
/* loaded from: classes.dex */
public class MainActivity extends SlidingFragmentActivity implements OnDataListener, InterfaceViewController, OnQueryHistoryInfoListener, NestRadioGroup.InterfaceC2793c {

    /* renamed from: A */
    private static boolean f10706A = false;

    /* renamed from: N */
    private static boolean f10707N = false;

    /* renamed from: q */
    private static int f10708q = -1;

    /* renamed from: w */
    private static boolean f10709w = false;

    /* renamed from: x */
    private static boolean f10710x = false;

    /* renamed from: y */
    private static boolean f10711y = false;

    /* renamed from: z */
    private static boolean f10712z = false;

    /* renamed from: D */
    private TextView f10715D;

    /* renamed from: E */
    private ProgressDialog f10716E;

    /* renamed from: F */
    private ProgressBar f10717F;

    /* renamed from: G */
    private TextView f10718G;

    /* renamed from: H */
    private String f10719H;

    /* renamed from: I */
    private double f10720I;

    /* renamed from: J */
    private double f10721J;

    /* renamed from: K */
    private String f10722K;

    /* renamed from: L */
    private TextView f10723L;

    /* renamed from: M */
    private TextView f10724M;

    /* renamed from: Q */
    private View f10727Q;

    /* renamed from: a */
    public Context f10736a;

    /* renamed from: b */
    SlidingMenu f10737b;

    /* renamed from: e */
    private NestRadioGroup f10739e;

    /* renamed from: f */
    private AsyncTaskManager f10740f;

    /* renamed from: g */
    private RadioButton f10741g;

    /* renamed from: h */
    private PreferencesManager f10742h;

    /* renamed from: i */
    private RadioButton f10743i;

    /* renamed from: j */
    private RadioButton f10744j;

    /* renamed from: k */
    private TextView f10745k;

    /* renamed from: l */
    private RadioButton f10746l;

    /* renamed from: m */
    private boolean f10747m;

    /* renamed from: n */
    private boolean f10748n;

    /* renamed from: o */
    private RadioButton f10749o;

    /* renamed from: p */
    private RadioButton f10750p;

    /* renamed from: s */
    private String f10752s;

    /* renamed from: d */
    private final String f10738d = MainActivity.class.getSimpleName();

    /* renamed from: r */
    private int f10751r = -1;

    /* renamed from: t */
    private final int f10753t = 15;

    /* renamed from: u */
    private final int f10754u = 15;

    /* renamed from: v */
    private final int f10755v = PdfContentParser.COMMAND_TYPE;

    /* renamed from: B */
    private BroadcastReceiver f10713B = new C1966a();

    /* renamed from: C */
    private UpdateDownloadLogDao f10714C = null;

    /* renamed from: O */
    private Intent f10725O = null;

    /* renamed from: P */
    private int f10726P = -1;

    /* renamed from: R */
    private final Handler f10728R = new HandlerC2512q(this);

    /* renamed from: S */
    private AbstractC1614h f10729S = new C2706x(this, Looper.myLooper());

    /* renamed from: T */
    private LoginFunction.InterfaceC2303c f10730T = new C2707y(this);

    /* renamed from: U */
    private final Handler f10731U = new HandlerC2708z(this);

    /* renamed from: V */
    private LoginFunction.InterfaceC2301a f10732V = new C1985aa(this);

    /* renamed from: W */
    private BroadcastReceiver f10733W = new C1986ab(this);

    /* renamed from: X */
    private GoloTipObServer f10734X = new C1988ad(this);

    /* renamed from: Y */
    private boolean f10735Y = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ boolean m7867j() {
        f10711y = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ boolean m7865k() {
        f10712z = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.widget.slidingmenu.p293a.SlidingFragmentActivity, android.app.ActivityGroup, android.app.Activity
    public void onCreate(Bundle bundle) {
        ApplicationTheme.m7974b(this);
        super.onCreate(bundle);
        PreferencesManager.m9595a(this.f10736a).m9587a("isRemindedAppUsageNum", false);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        m4397d(ApplicationTheme.m7976a(this));
        this.f10736a = this;
        CloudDataManager.m5413a(this.f10736a).m5414a();
        this.f10742h = PreferencesManager.m9595a(this.f10736a);
        this.f10740f = AsyncTaskManager.m9574a(this.f10736a);
        this.f10737b = this.f16779c.f16773b;
        this.f10737b.setShadowWidthRes(R.dimen.shadow_width);
        this.f10737b.setShadowDrawable(R.drawable.slidingmenu_shadow);
        this.f10737b.setBehindOffset((C2778n.m4904b(this.f10736a) * this.f10736a.getResources().getInteger(R.integer.leftmenu_mainsize)) / 100);
        this.f10737b.setTouchModeAbove(1);
        this.f10739e = (NestRadioGroup) findViewById(R.id.radiogroup_menu);
        this.f10739e.setOnCheckedChangeListener(this);
        this.f10741g = (RadioButton) findViewById(R.id.btn_info);
        this.f10743i = (RadioButton) findViewById(R.id.btn_golo);
        if (C2744aa.m5145h()) {
            this.f10741g.setText(R.string.tab_menu_navigatorpro);
            this.f10741g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_navigatorpro, 0, 0, 0);
        } else if (C2744aa.m5166c() || C2744aa.m5151f()) {
            this.f10741g.setText(R.string.repair_info_tittle);
        }
        this.f10727Q = findViewById(R.id.feedback_container);
        this.f10744j = (RadioButton) findViewById(R.id.btn_feedback);
        this.f10727Q = findViewById(R.id.feedback_container);
        this.f10745k = (TextView) findViewById(R.id.tv_tips);
        if (!C2744aa.m5166c()) {
            this.f10727Q.setVisibility(8);
        }
        if (C2744aa.m5151f() && LangManager.m9466b().equalsIgnoreCase("JP")) {
            findViewById(R.id.golo_container).setVisibility(8);
        }
        if (!C2744aa.m5139k() && !C2744aa.m5141j()) {
            findViewById(R.id.golo_container).setVisibility(8);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("show_update");
        intentFilter.addAction("show_remotediag");
        intentFilter.addAction("show_cloud_diag");
        intentFilter.addAction("web_remote_diag");
        intentFilter.addAction("show_Setting");
        intentFilter.addAction("show_PrintSetting");
        intentFilter.addAction("show_golo_chatroom");
        intentFilter.addAction("show_golo_message");
        intentFilter.addAction("show_verication");
        intentFilter.addAction("Golo_Notification");
        intentFilter.addAction("show_repairinfo");
        intentFilter.addAction("defend_is_enable");
        intentFilter.addAction("golo_is_enable");
        intentFilter.addAction("unupgradeSoftNumChanged");
        intentFilter.addAction("mineMessageNumChanged");
        intentFilter.addAction("notifyShopStatisticsChanged");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.f10733W, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f10713B, intentFilter2);
        this.f10746l = (RadioButton) findViewById(R.id.btn_setting);
        this.f10747m = PreferencesManager.m9595a(this.f10736a).m9583b("is_golo", false);
        this.f10748n = PreferencesManager.m9595a(this.f10736a).m9583b("hide_golo", false);
        m7905a(getIntent());
        if (this.f10747m) {
            if (this.f10748n) {
                findViewById(R.id.golo_container).setVisibility(8);
            }
            this.f10743i.setText(R.string.tab_menu_golo);
            this.f10743i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_golo, 0, 0, 0);
            GoloOBManager m8721a = GoloOBManager.m8721a();
            GoloTipObServer goloTipObServer = this.f10734X;
            if (m8721a.f9279a == null) {
                Log.e("Sanda", "GoloObServer is NullPointerException!");
            } else if (!m8721a.f9279a.contains(goloTipObServer)) {
                m8721a.f9279a.add(goloTipObServer);
            }
            LoginFunction.m6589a(this.f10730T);
            LoginFunction.m6591a(this.f10732V);
            GoloCacheManager.m9176a(this.f10729S);
            String packageName = getPackageName();
            if (packageName != null) {
                try {
                    if (!"com.cnlaunch.padII".equals(packageName) && !"com.cnlaunch.maximus".equals(packageName) && !"com.cnlaunch.MaxGo".equals(packageName)) {
                        if (!"com.cnlaunch.x431.pro3".equals(packageName) && !"com.cnlaunch.x431.pro3S".equals(packageName) && !"com.ifoer.expedition.pro".equals(packageName)) {
                            if (!"com.cnlaunch.ScanPad071".equals(packageName) && !"com.cnlaunch.ScanPad101".equals(packageName)) {
                                if ("com.cnlaunch.X431V".equals(packageName) || "com.cnlaunch.X431VI".equals(packageName)) {
                                    GoloApplication.f8908a = 3;
                                }
                            }
                            GoloApplication.f8908a = 2;
                        }
                        GoloApplication.f8908a = 1;
                    }
                    GoloApplication.f8908a = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.f10743i.setText(R.string.tool_item_name_browser);
            this.f10743i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_browser, 0, 0, 0);
        }
        if (C2744aa.m5166c() || !C2744aa.m5141j()) {
            this.f10743i.setText(R.string.tab_menu_remote);
            this.f10743i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_golo, 0, 0, 0);
            if (PreferencesManager.m9595a(this.f10736a).m9583b("isFirstRun", true)) {
                this.f10728R.sendEmptyMessageDelayed(15, 500L);
            }
        }
        this.f10749o = (RadioButton) findViewById(R.id.btn_tools);
        if (C2744aa.m5133n() && CommonTools.m7970a()) {
            this.f10749o.setVisibility(0);
        } else {
            this.f10749o.setVisibility(8);
        }
        this.f10750p = (RadioButton) findViewById(R.id.btn_mall);
        if (PreferencesManager.m9595a(this.f10736a).m9583b("is_support_mall", false)) {
            this.f10750p.setVisibility(0);
        } else {
            this.f10750p.setVisibility(8);
        }
        if (!f10710x) {
            DataStreamConfiguration.m7959a(this.f10736a);
        }
        C1856n.m8128a(AppMlogConfig.m8215a().f10029a);
        AppMlogConfig.m8215a().m8214b();
        if (PreferencesManager.m9595a(this.f10736a).m9583b("enable_upload_downloadlog", false)) {
            this.f10714C = DBManager.m5036a(this.f10736a).f15794a.f15801d;
            if (C2778n.m4917a(this.f10736a)) {
                for (UpdateDownloadLog updateDownloadLog : this.f10714C.loadAll()) {
                    int parseInt = Integer.parseInt(updateDownloadLog.f15841d);
                    int parseInt2 = Integer.parseInt(updateDownloadLog.f15842e);
                    String str = updateDownloadLog.f15839b;
                    int parseInt3 = Integer.parseInt(updateDownloadLog.f15840c);
                    String str2 = updateDownloadLog.f15844g;
                    String str3 = updateDownloadLog.f15843f;
                    DownloadLog downloadLog = new DownloadLog();
                    downloadLog.setCurrentConfigArea(str2);
                    downloadLog.setCurrentNetworkSpeed(str3);
                    downloadLog.setDownloadDuration(String.valueOf(parseInt2));
                    downloadLog.setDownloadedSize(String.valueOf(parseInt));
                    downloadLog.setDownloadId(str);
                    downloadLog.setState(String.valueOf(parseInt3));
                    new AsyncTaskC1967b().execute(downloadLog);
                }
            }
        }
        if (FileUtils.m5027a() < 200) {
            NToast.m9450a(this.f10736a, (int) R.string.txt_less_storage_space);
        }
        m7869i();
        DealDiagMessageHandler.m8673a().f9429e = this;
        WebRemoteHandler.m5419a().f15482b = this;
        PreferencesManager.m9595a((Context) this).m9588a("remote_host_key", "");
        PreferencesManager.m9595a((Context) this).m9588a("remote_host_ip", "");
        PreferencesManager.m9595a((Context) this).m9588a("remote_host_port", "");
        ReportSocketControler m8512b = ReportSocketControler.m8512b();
        Context context = this.f10736a;
        if (m8512b.f9662b == null) {
            m8512b.f9662b = context;
        }
        ReportSocketControler.m8512b().m8508a(WebRemoteHandler.m5419a().f15483c);
        RemoteSocketControler.m8607a().m8604a(this.f10736a);
        RemoteSocketControler.m8607a().m8508a(WebRemoteHandler.m5419a().f15483c);
        RemoteSocketControler.m8607a().m8597b(DiagnoseConstants.UI_TYPE_SPECIAL_FUNCTION, DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM, DiagnoseConstants.UI_TYPE_ACTIVE_TEST, DiagnoseConstants.UI_TYPE_DATASTREAM);
        RemoteSocketControler.m8607a().m8600a(DiagnoseConstants.UI_TYPE_DIAG_FUN_INFO, DiagnoseConstants.UI_TYPE_CURRENT_MENU_PATH, "1900", DiagnoseConstants.UI_TYPE_NO_UI_CMD);
        if (LoginTools.m7946a(this.f10736a)) {
            new LoginFunction(this.f10736a).m6592a();
        }
        startService(new Intent(this, DefendService.class));
        m7906a(50001, false);
        IMPresenter.m8804a(this.f10736a).f9185g = this;
        this.f10715D = (TextView) findViewById(R.id.upgrade_num_tip);
        int m9585b = PreferencesManager.m9595a(this.f10736a).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.f10736a).m9585b("unupdateSoftwareNumForHeavyduty", 0);
        this.f10715D.setText(String.valueOf(m9585b));
        if (m9585b != 0) {
            this.f10715D.setVisibility(0);
        } else {
            this.f10715D.setVisibility(8);
        }
        PreferencesManager.m9595a(this.f10736a).m9588a("current_visible_promessagefragment_room_id", "");
        m7859n();
        sendBroadcast(new Intent("refreshtip"));
        if (LoginTools.m7946a(this)) {
            ReportProduceTool.m5227b();
            FixedThreadPool.m4928a().m4927a(new UpLoadSaveReportTask(getApplicationContext()));
        }
        DeviceFactoryManager.m8305a().m8292b(this);
        DeviceFactoryManager.m8305a().m8287c(this);
        DeviceFactoryManager.m8305a().m8292b(this);
        DeviceFactoryManager.m8305a().m8287c(this);
        FixedThreadPool.m4928a().f15904a.scheduleWithFixedDelay(new CloudGetReportCacheTask(this.f10736a), 5L, 10L, TimeUnit.SECONDS);
        C2744aa.m5140j(this);
        String m5186a = C2744aa.m5186a(this.f10736a);
        if (!TextUtils.isEmpty(m5186a)) {
            PreferencesManager.m9595a(this.f10736a).m9588a("sim_iccid", m5186a);
        }
        DiagLogHistoryInfoManager.m5973a(this.f10736a).m5971a((OnQueryHistoryInfoListener) this);
        if (CommonTools.m7966b(this.f10736a)) {
            try {
                AdUtil.m5431a().m5430a(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 15) {
            if (i2 == -1) {
                finish();
                return;
            } else if (C1947h.f10551c && i2 == 115) {
                Activity currentActivity = getLocalActivityManager().getCurrentActivity();
                TextView textView = (TextView) currentActivity.findViewById(R.id.btn_right);
                if (textView != null) {
                    textView.setVisibility(4);
                }
                TextView textView2 = (TextView) currentActivity.findViewById(R.id.btn_factory_pattern);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    return;
                }
                return;
            }
        }
        Activity currentActivity2 = getLocalActivityManager().getCurrentActivity();
        if (currentActivity2 instanceof DiagnoseActivity) {
            Log.i(this.f10738d, "current instanceof DiagnoseActivity");
            DiagnoseActivity diagnoseActivity = (DiagnoseActivity) currentActivity2;
            if (diagnoseActivity.f11020I != null) {
                diagnoseActivity.f11020I.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            if (intent.getBooleanExtra("seller_request_remote", false)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    f10706A = true;
                    SellerRemoteDiagInfo.getInstance().setIndetify(extras.getInt("identify", 1));
                    SellerRemoteDiagInfo.getInstance().setOtherUseID(extras.getString("userId", ""));
                    SellerRemoteDiagInfo.getInstance().setOtherUseName(extras.getString("userName", ""));
                    SellerRemoteDiagInfo.getInstance().setOtherUserSN(extras.getString("serialNum", ""));
                    SellerRemoteDiagInfo.getInstance().setOtherCarName(extras.getString("carName", ""));
                    SellerRemoteDiagInfo.getInstance().setReqId(extras.getString("resverId", ""));
                    SellerRemoteDiagInfo.getInstance().setPubId(extras.getString("pubId", ""));
                    DealDiagMessageHandler.m8673a().m8668a(SellerRemoteDiagInfo.getInstance().getOtherUseID(), SellerRemoteDiagInfo.getInstance().getOtherUserSN());
                    return;
                }
                return;
            } else if (intent.getBooleanExtra("seller_click_menu", false)) {
                m7894b(R.id.btn_diagnose);
                return;
            }
        }
        m7905a(intent);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1947h.f10553e = true;
        NoticeMessageHandler.f9196b = true;
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        super.onResume();
        NoticeMessageHandler.f9196b = false;
        m7861m();
    }

    @Override // com.cnlaunch.x431pro.widget.slidingmenu.p293a.SlidingFragmentActivity, android.app.ActivityGroup, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.f10733W);
        unregisterReceiver(this.f10713B);
        IMPresenter.m8804a(this.f10736a).f9185g = null;
        if (this.f10747m) {
            LoginFunction.m6578b(this.f10730T);
            LoginFunction.m6580b(this.f10732V);
            GoloCacheManager.m9175b(this.f10729S);
            GoloOBManager.m8721a().m8718a(this.f10734X);
            try {
                stopService(new Intent(this, GoloMessageService.class));
                getApplicationContext().sendBroadcast(new Intent("app_exit"));
                GoloLightManager.m8495c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i("Sanda", "退出app 记录日志");
        ImageLoader.m4191a().m4186b();
        ImageLoader.m4191a().m4184c();
        DiagLogHistoryInfoManager.m5973a(this.f10736a).m5968b(this);
        Process.killProcess(Process.myPid());
        System.exit(0);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!f10710x) {
            DataStreamConfiguration.m7959a(this.f10736a);
        }
        Log.d("Sanda", "main=onConfigurationChanged()");
        int m4904b = (C2778n.m4904b(this.f10736a) * this.f10736a.getResources().getInteger(R.integer.leftmenu_mainsize)) / 100;
        m4397d(ApplicationTheme.m7976a(this));
        this.f10739e = (NestRadioGroup) findViewById(R.id.radiogroup_menu);
        this.f10739e.setOnCheckedChangeListener(this);
        this.f10741g = (RadioButton) findViewById(R.id.btn_info);
        this.f10743i = (RadioButton) findViewById(R.id.btn_golo);
        if (C2744aa.m5145h()) {
            this.f10741g.setText(R.string.tab_menu_navigatorpro);
            this.f10741g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_navigatorpro, 0, 0, 0);
        } else if (C2744aa.m5166c() || C2744aa.m5151f()) {
            this.f10741g.setText(R.string.repair_info_tittle);
        }
        this.f10746l = (RadioButton) findViewById(R.id.btn_setting);
        this.f10747m = PreferencesManager.m9595a(this.f10736a).m9583b("is_golo", false);
        this.f10748n = PreferencesManager.m9595a(this.f10736a).m9583b("hide_golo", false);
        if (this.f10748n) {
            findViewById(R.id.golo_container).setVisibility(8);
        } else if (this.f10747m) {
            this.f10743i.setText(R.string.tab_menu_golo);
            this.f10743i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_golo, 0, 0, 0);
        } else {
            this.f10743i.setText(R.string.tool_item_name_browser);
            this.f10743i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.select_btn_browser, 0, 0, 0);
        }
        if (C2744aa.m5166c() || !C2744aa.m5141j()) {
            this.f10743i.setText(R.string.tab_menu_remote);
        }
        this.f10749o = (RadioButton) findViewById(R.id.btn_tools);
        if (C2744aa.m5133n() && CommonTools.m7970a()) {
            this.f10749o.setVisibility(0);
        } else {
            this.f10749o.setVisibility(8);
        }
        this.f10750p = (RadioButton) findViewById(R.id.btn_mall);
        if (PreferencesManager.m9595a(this.f10736a).m9583b("is_support_mall", false)) {
            this.f10750p.setVisibility(0);
        } else {
            this.f10750p.setVisibility(8);
        }
        this.f10737b.setBehindOffset(m4904b);
        sendBroadcast(new Intent(DiagnoseConstants.SCREEN_CHANGE));
        GoloTipObServer goloTipObServer = this.f10734X;
        if (goloTipObServer != null && goloTipObServer.f9282a) {
            this.f10734X.f9282a = false;
            this.f10728R.obtainMessage(100, 1, 1).sendToTarget();
        }
        Activity activity = getLocalActivityManager().getActivity(DiagnoseActivity.class.getSimpleName());
        if (activity != null) {
            activity.onConfigurationChanged(configuration);
        }
        Activity activity2 = getLocalActivityManager().getActivity(SettingActivity.class.getSimpleName());
        if (activity2 != null) {
            activity2.onConfigurationChanged(configuration);
        }
        if (activity != getCurrentActivity() && activity2 != getCurrentActivity()) {
            getCurrentActivity().onConfigurationChanged(configuration);
        }
        this.f10715D = (TextView) findViewById(R.id.upgrade_num_tip);
        int m9585b = PreferencesManager.m9595a(this.f10736a).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.f10736a).m9585b("unupdateSoftwareNumForHeavyduty", 0);
        this.f10715D.setText(String.valueOf(m9585b));
        if (m9585b != 0) {
            this.f10715D.setVisibility(0);
        } else {
            this.f10715D.setVisibility(8);
        }
        this.f10723L = (TextView) findViewById(R.id.seller_message_count_tip);
        int m9585b2 = PreferencesManager.m9595a(this.f10736a).m9585b("shopStatistics", 0);
        String valueOf = String.valueOf(m9585b2);
        if (m9585b2 != 0 && !TextUtils.isEmpty(valueOf)) {
            this.f10723L.setVisibility(0);
            this.f10723L.setText(valueOf);
        } else {
            this.f10723L.setVisibility(8);
        }
        m7859n();
        this.f10727Q = findViewById(R.id.feedback_container);
        this.f10744j = (RadioButton) findViewById(R.id.btn_feedback);
        this.f10745k = (TextView) findViewById(R.id.tv_tips);
        if (!C2744aa.m5166c()) {
            this.f10727Q.setVisibility(8);
        }
        if (C2744aa.m5151f() && LangManager.m9466b().equalsIgnoreCase("JP")) {
            findViewById(R.id.golo_container).setVisibility(8);
        }
        m7877e(this.f10742h.m9585b("feedback_tips", 0));
        if (!C2744aa.m5139k() && !C2744aa.m5141j()) {
            findViewById(R.id.golo_container).setVisibility(8);
        }
        m7861m();
    }

    /* renamed from: a */
    public final void m7898a(Class cls, Intent intent) {
        if (this.f10737b.m4416c()) {
            this.f10737b.m4418b();
        }
        int i = this.f10751r;
        int i2 = f10708q;
        if (i != i2 && i2 == R.id.btn_golo) {
            PreferencesManager.m9595a((Context) this).m9587a("golo_replace_flag", true);
        }
        this.f10737b.setTouchModeAbove(1);
        Intent intent2 = new Intent(this.f10736a, cls);
        if (f10708q == R.id.btn_golo) {
            intent2.putExtra("Customer_type", this.f10752s);
        }
        if (intent != null) {
            intent2.putExtras(intent);
        }
        Window startActivity = getLocalActivityManager().startActivity(cls.getSimpleName(), intent2);
        startActivity.getDecorView().requestFocus();
        setContentView(startActivity.getDecorView());
    }

    /* renamed from: b */
    public final void m7894b(int i) {
        this.f10739e.m4781a(i);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (getLocalActivityManager().getCurrentActivity().onKeyDown(i, keyEvent)) {
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: com.cnlaunch.x431pro.activity.MainActivity$a */
    /* loaded from: classes.dex */
    public class C1966a extends BroadcastReceiver {
        public C1966a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                NLog.m9456a(MainActivity.this.f10738d, "WiFi state: ".concat(String.valueOf(intent.getIntExtra("wifi_state", 0))));
            }
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction()) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                NetworkInfo.State state = ((NetworkInfo) parcelableExtra).getState();
                C1856n.m8130a(MainActivity.this.f10738d, "Network state: ".concat(String.valueOf(state)));
                if (state == NetworkInfo.State.CONNECTED) {
                    C1856n.m8130a(MainActivity.this.f10738d, "Network is connected!");
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        C1856n.m8130a(MainActivity.this.f10738d, "NetworkInfo status: isConnected! upload Special Function Diagnose Log");
                        MainActivity.this.m7869i();
                    }
                }
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo2 == null || !activeNetworkInfo2.isAvailable()) {
                    NLog.m9456a(MainActivity.this.f10738d, "////////网络断开");
                    return;
                }
                activeNetworkInfo2.getTypeName();
                NLog.m9456a(MainActivity.this.f10738d, "////state ".concat(String.valueOf(activeNetworkInfo2.getState())));
                if (activeNetworkInfo2.getType() == 1) {
                    NLog.m9456a(MainActivity.this.f10738d, "/////WiFi网络");
                } else if (activeNetworkInfo2.getType() == 9) {
                    NLog.m9456a(MainActivity.this.f10738d, "/////有线网络");
                } else if (activeNetworkInfo2.getType() == 0) {
                    NLog.m9456a(MainActivity.this.f10738d, "/////////移动网络");
                }
                if (activeNetworkInfo2 == null || !activeNetworkInfo2.isConnected()) {
                    return;
                }
                PreferencesManager.m9595a(MainActivity.this.f10736a).m9588a("netInfo_type", activeNetworkInfo2.getTypeName());
                String str = MainActivity.this.f10738d;
                NLog.m9456a(str, "NetworkInfo status: isConnected!" + activeNetworkInfo2.getTypeName());
                NLog.m9456a(MainActivity.this.f10738d, "请求配置下发");
                ConfigUtils.m7963a(MainActivity.this.f10736a).m7964a();
                if (PreferencesManager.m9595a(MainActivity.this.f10736a).m9583b("enable_blacklist", true)) {
                    LaunchLogic.m7949a(MainActivity.this.f10736a).m7950a(90001);
                }
                if (TextUtils.isEmpty(PreferencesManager.m9595a(MainActivity.this.f10736a).m9591a("apk_soft_name"))) {
                    return;
                }
                ApkUpgradeUtils.m5103c(MainActivity.this.f10736a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7859n() {
        String m9584b = PreferencesManager.m9595a(this.f10736a).m9584b("current_visible_promessagefragment_room_id", "");
        if (!TextUtils.isEmpty(m9584b)) {
            IMPresenter.m8804a(this.f10736a).m8793c(m9584b);
        }
        if (C2744aa.m5166c() || !C2744aa.m5141j()) {
            this.f10723L = (TextView) findViewById(R.id.seller_message_count_tip);
            if (!TextUtils.isEmpty(PreferencesManager.m9595a(this.f10736a).m9584b("user_id", ""))) {
                int m8794c = IMPresenter.m8804a(this).m8794c();
                this.f10723L.setText(String.valueOf(m8794c));
                if (m8794c != 0) {
                    this.f10723L.setVisibility(0);
                } else {
                    this.f10723L.setVisibility(8);
                }
            } else {
                this.f10723L.setVisibility(8);
            }
            findViewById(R.id.mine_message_count_tip).setVisibility(8);
            return;
        }
        this.f10724M = (TextView) findViewById(R.id.mine_message_count_tip);
        if (!TextUtils.isEmpty(PreferencesManager.m9595a(this.f10736a).m9584b("user_id", ""))) {
            int m8794c2 = IMPresenter.m8804a(this).m8794c();
            this.f10724M.setText(String.valueOf(m8794c2));
            if (m8794c2 != 0) {
                this.f10724M.setVisibility(0);
            } else {
                this.f10724M.setVisibility(8);
            }
        } else {
            this.f10724M.setVisibility(8);
        }
        findViewById(R.id.seller_message_count_tip).setVisibility(8);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        DiagnoseLogInfoSearchUtil.C2749a m5087a;
        if (i == 200) {
            C1856n.m8125d(this.f10738d, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE onSuccess start ");
            File[] listFiles = new File(PathUtils.m4848h()).listFiles();
            if (listFiles == null) {
                m5087a = null;
            } else {
                Vector vector = new Vector();
                for (File file : listFiles) {
                    if (!file.isDirectory()) {
                        if (file.getName().endsWith(".dat")) {
                            vector.add(file);
                        } else if (file.getName().endsWith(".tmp")) {
                            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                            if (currentTimeMillis / 86400000 > 1) {
                                C1856n.m8125d("DiagnoseLogInfoSearchUtil", "删除无效特殊功能诊断日志" + file.getName() + " timediff= " + currentTimeMillis);
                                file.delete();
                            }
                        }
                    }
                }
                Collections.sort(vector, new C2751c());
                m5087a = vector.size() > 0 ? DiagnoseLogInfoSearchUtil.m5087a((File) vector.get(0)) : null;
            }
            if (m5087a == null) {
                return null;
            }
            if (C2787z.m4821a(m5087a.getDeviceSN()) || C2787z.m4821a(m5087a.getVehicleSoftname())) {
                FileUtils.m5000d(m5087a.getFullFilePath());
                return null;
            }
            String str = PathUtils.m4847i() + "/" + m5087a.getDeviceSN() + m5087a.getVehicleSoftname() + new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date(m5087a.getCreateDate())) + ".zip";
            if (!new File(str).exists()) {
                try {
                    ZipFileUtils.m4983a(m5087a.getFullFilePath(), str);
                    C1856n.m8125d(this.f10738d, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE start not exists LogZipPath=".concat(String.valueOf(str)));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            m5087a.setZipFilePath(str);
            SettingAction settingAction = new SettingAction(this);
            String upperCase = LangManager.m9469a().toUpperCase();
            UploadDiagnosticLogResponse m5309a = settingAction.m5309a(m5087a, "", "1", !upperCase.equalsIgnoreCase("ZH") ? Lang.f7203a : upperCase, "");
            m5309a.setExtraOriginalfullFilenamePath(m5087a.getFullFilePath());
            m5309a.setExtraZipfullFilenamePath(str);
            return m5309a;
        }
        switch (i) {
            case 50001:
                C1673a.m8965a();
                C1673a.m8961b(PathUtils.m4841o());
                break;
            case 50002:
                C1673a.m8965a().m8964a("ReLogin Failed:logout and relogin Agrain");
                IMManager.m8728b(this.f10736a);
                try {
                    Thread.sleep(3000L);
                } catch (Exception unused) {
                }
                IMManager.m8731a(this.f10736a);
                break;
        }
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 200 && obj != null) {
            UploadDiagnosticLogResponse uploadDiagnosticLogResponse = (UploadDiagnosticLogResponse) obj;
            if (uploadDiagnosticLogResponse.getCode() == 0) {
                if (C1856n.f10135a) {
                    String str = this.f10738d;
                    C1856n.m8125d(str, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE onSuccess Ori=" + uploadDiagnosticLogResponse.getExtraOriginalfullFilenamePath());
                    String str2 = this.f10738d;
                    C1856n.m8125d(str2, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE onSuccess Zip= " + uploadDiagnosticLogResponse.getExtraZipfullFilenamePath());
                }
                FileUtils.m5000d(uploadDiagnosticLogResponse.getExtraOriginalfullFilenamePath());
                FileUtils.m5000d(uploadDiagnosticLogResponse.getExtraZipfullFilenamePath());
                m7869i();
                C1856n.m8125d(this.f10738d, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE onSuccess ");
            }
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i != 200) {
            return;
        }
        C1856n.m8125d(this.f10738d, "AUTO REQ_SEND_DIAGNOSTIC_LOG_CODE onFailure ");
    }

    /* renamed from: a */
    public final void m7906a(int i, boolean z) {
        this.f10740f.m9575a(i, z, this);
    }

    /* renamed from: a */
    public static boolean m7907a() {
        return f10709w;
    }

    /* renamed from: a */
    public static void m7896a(boolean z) {
        f10709w = z;
    }

    /* renamed from: b */
    public static boolean m7895b() {
        return f10710x;
    }

    /* renamed from: b */
    public static void m7887b(boolean z) {
        f10710x = z;
    }

    /* renamed from: c */
    public static boolean m7886c() {
        return f10711y;
    }

    /* renamed from: d */
    public static boolean m7881d() {
        return f10712z;
    }

    /* renamed from: c */
    public static void m7882c(boolean z) {
        f10712z = z;
    }

    /* renamed from: e */
    public static void m7878e() {
        f10711y = false;
    }

    /* renamed from: f */
    public static boolean m7875f() {
        return f10706A;
    }

    /* renamed from: g */
    public static void m7873g() {
        f10706A = false;
    }

    /* renamed from: h */
    public static int m7871h() {
        return f10708q;
    }

    /* renamed from: i */
    public final void m7869i() {
        DeferredHandler.m9581a().m9579a(new RunnableC1987ac(this));
    }

    /* renamed from: c */
    public static void m7885c(int i) {
        f10708q = i;
    }

    /* renamed from: com.cnlaunch.x431pro.activity.MainActivity$b */
    /* loaded from: classes.dex */
    class AsyncTaskC1967b extends AsyncTask<DownloadLog, Integer, Object> {

        /* renamed from: b */
        private DownloadLog f10758b = null;

        AsyncTaskC1967b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Object doInBackground(DownloadLog... downloadLogArr) {
            this.f10758b = downloadLogArr[0];
            try {
                return new UpgradeAction(MainActivity.this.f10736a).m5280a(this.f10758b.getDownloadId(), this.f10758b.getState(), this.f10758b.getDownloadedSize(), this.f10758b.getDownloadDuration(), this.f10758b.getCurrentNetworkSpeed(), this.f10758b.getCurrentConfigArea());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(Object obj) {
            BaseResponse baseResponse = (BaseResponse) obj;
            if (this.f10758b != null && baseResponse != null) {
                if (baseResponse.getCode() == 0) {
                    QueryBuilder<UpdateDownloadLog> queryBuilder = MainActivity.this.f10714C.queryBuilder();
                    queryBuilder.where(UpdateDownloadLogDao.Properties.DownloadId.m321eq(this.f10758b.getDownloadId()), new WhereCondition[0]);
                    UpdateDownloadLog unique = queryBuilder.unique();
                    if (unique != null) {
                        MainActivity.this.f10714C.delete(unique);
                    }
                    String str = MainActivity.this.f10738d;
                    NLog.m9456a(str, "Update download status: OK: Code=" + baseResponse.getCode() + ", Message=" + baseResponse.getMessage() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f10758b.toString());
                } else {
                    String str2 = MainActivity.this.f10738d;
                    NLog.m9451c(str2, "Update download status: Failed: Code=" + baseResponse.getCode() + ", Message=" + baseResponse.getMessage() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f10758b.toString());
                }
            }
            super.onPostExecute(obj);
        }
    }

    /* renamed from: a */
    private void m7905a(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("Setting");
            if (stringExtra != null && stringExtra.equals("SettingLaunchReceiver")) {
                this.f10746l.setChecked(true);
                return;
            } else if (!TextUtils.isEmpty(stringExtra) && "startgolo".equals(stringExtra)) {
                this.f10752s = intent.getStringExtra("Customer_type");
                mo7897a(IMActivity.class.getName());
                return;
            } else {
                String action = intent.getAction();
                if (action != null && action.equalsIgnoreCase("com.cnlaunch.golo.Notification") && LoginTools.m7946a(this.f10736a)) {
                    mo7897a(IMActivity.class.getName());
                    return;
                }
                this.f10751r = f10708q;
                f10708q = R.id.btn_diagnose;
                m7898a(DiagnoseActivity.class, (Intent) null);
                return;
            }
        }
        this.f10751r = f10708q;
        f10708q = R.id.btn_diagnose;
        m7898a(DiagnoseActivity.class, (Intent) null);
    }

    @Override // com.cnlaunch.p168i.InterfaceViewController
    /* renamed from: a */
    public final void mo7897a(String str) {
        boolean equalsIgnoreCase = str.equalsIgnoreCase(IMActivity.class.getName());
        int i = R.id.btn_golo;
        if (equalsIgnoreCase) {
            this.f10735Y = true;
            if (!C2744aa.m5166c() && C2744aa.m5141j()) {
                i = R.id.btn_mine;
            }
            if (f10708q == i) {
                m7898a(IMActivity.class, (Intent) null);
            } else {
                m7894b(i);
            }
        } else if (str.equalsIgnoreCase(MineActivity.class.getName())) {
            this.f10735Y = false;
            if (f10708q == R.id.btn_mine) {
                m7898a(MineActivity.class, (Intent) null);
            } else {
                m7894b(R.id.btn_mine);
            }
        } else if (str.equalsIgnoreCase(GoloUSAActivity.class.getName())) {
            this.f10735Y = false;
            if (f10708q == R.id.btn_golo) {
                m7898a(GoloUSAActivity.class, (Intent) null);
            } else {
                m7894b(R.id.btn_golo);
            }
        }
    }

    /* renamed from: o */
    private void m7857o() {
        new Thread(new RunnableC2600u(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7888b(String str) {
        if (C2787z.m4821a(str) || !new File(str).exists()) {
            m7857o();
            return;
        }
        String m9591a = PreferencesManager.m9595a(this.f10736a).m9591a("login_username");
        String m9591a2 = PreferencesManager.m9595a(this.f10736a).m9591a("login_password");
        MD5Utils.m9460a(m9591a2);
        Bundle bundle = new Bundle();
        bundle.putString("username", m9591a);
        bundle.putString("password", m9591a2);
        bundle.putBoolean("launch_from_pro", true);
        bundle.putString("packageName", C2744aa.m5171b(this.f10736a));
        C2778n.m4915a(this.f10736a, str, bundle);
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        this.f10725O = intent;
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5964a(List<DiagLogHistoryInfo> list) {
        int i = 0;
        for (DiagLogHistoryInfo diagLogHistoryInfo : list) {
            if (diagLogHistoryInfo.getReaded() < diagLogHistoryInfo.getCurrentState()) {
                i++;
            }
        }
        m7877e(i);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5966a(int i, int i2, String str) {
        this.f10745k.setVisibility(8);
    }

    /* renamed from: e */
    private void m7877e(int i) {
        this.f10742h.m9590a("feedback_tips", i);
        if (i > 0) {
            this.f10745k.setVisibility(0);
            this.f10745k.setText(String.valueOf(i));
            return;
        }
        this.f10745k.setVisibility(8);
    }

    /* renamed from: m */
    private void m7861m() {
        int childCount;
        NestRadioGroup nestRadioGroup = (NestRadioGroup) this.f16779c.f16773b.findViewById(R.id.radiogroup_menu);
        if (nestRadioGroup == null || (childCount = nestRadioGroup.getChildCount()) == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (nestRadioGroup.getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        if (i == 0) {
            return;
        }
        int m4900c = C2778n.m4900c(this.f10736a);
        int i3 = nestRadioGroup.getChildAt(0).getLayoutParams().height;
        if (m4900c > nestRadioGroup.getHeight()) {
            int i4 = m4900c / i;
            for (int i5 = 0; i5 < childCount; i5++) {
                if (nestRadioGroup.getChildAt(i5).getVisibility() == 0) {
                    View childAt = nestRadioGroup.getChildAt(i5);
                    if (childAt instanceof RadioButton) {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        layoutParams.height = i4;
                        childAt.setLayoutParams(layoutParams);
                    } else if (childAt instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) childAt;
                        ViewGroup.LayoutParams layoutParams2 = frameLayout.getChildAt(0).getLayoutParams();
                        layoutParams2.height = i4;
                        frameLayout.getChildAt(0).setLayoutParams(layoutParams2);
                    }
                }
            }
        }
    }

    @Override // com.cnlaunch.x431pro.widget.NestRadioGroup.InterfaceC2793c
    /* renamed from: a */
    public final void mo4770a(int i) {
        boolean z = false;
        switch (i) {
            case R.id.btn_diagnose /* 2131296437 */:
                this.f10751r = f10708q;
                f10708q = i;
                m7898a(DiagnoseActivity.class, (Intent) null);
                return;
            case R.id.btn_feedback /* 2131296452 */:
                if (!LoginTools.m7946a(this.f10736a)) {
                    int i2 = f10708q;
                    if (i2 != -1) {
                        m7894b(i2);
                    }
                    NToast.m9450a(this.f10736a, (int) R.string.login_tip);
                    return;
                } else if (this.f10742h.m9583b("is_show_diaglog_tip", true)) {
                    DialogC2513r dialogC2513r = new DialogC2513r(this, this);
                    dialogC2513r.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2514s(this, i));
                    dialogC2513r.show();
                    return;
                } else {
                    this.f10751r = f10708q;
                    f10708q = i;
                    m7898a(FeedbackActivity.class, (Intent) null);
                    return;
                }
            case R.id.btn_golo /* 2131296465 */:
                if (LoginTools.m7946a(this.f10736a)) {
                    if (C2744aa.m5166c() || !C2744aa.m5141j()) {
                        this.f10751r = f10708q;
                        f10708q = i;
                        m7898a(this.f10735Y ? IMActivity.class : GoloUSAActivity.class, (Intent) null);
                        return;
                    }
                    this.f10739e.m4781a(-1);
                    View inflate = LayoutInflater.from(this.f10736a).inflate(R.layout.layout_sellerapp_install, (ViewGroup) null);
                    this.f10716E = new ProgressDialog(this.f10736a, R.style.DiagnoseProgressDialogTheme);
                    this.f10716E.show();
                    this.f10716E.setContentView(inflate);
                    this.f10716E.setCancelable(false);
                    this.f10716E.setOnKeyListener(new DialogInterface$OnKeyListenerC2596t(this));
                    this.f10718G = (TextView) inflate.findViewById(R.id.tv_downlaod_sellerapp_ratio);
                    this.f10717F = (ProgressBar) inflate.findViewById(R.id.downlaod_sellerapp_progress);
                    Context context = this.f10736a;
                    if (C2744aa.m5185a(context, C2744aa.m5138k(context))) {
                        if (this.f10716E.isShowing()) {
                            this.f10716E.dismiss();
                        }
                        Intent intent = new Intent();
                        intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                        intent.setComponent(new ComponentName(C2744aa.m5138k(this.f10736a), "com.cnlaunch.golo3.activity.WelcomeActivity"));
                        intent.setAction("android.intent.action.VIEW");
                        String m9591a = PreferencesManager.m9595a(this.f10736a).m9591a("login_username");
                        String m9591a2 = PreferencesManager.m9595a(this.f10736a).m9591a("login_password");
                        MD5Utils.m9460a(m9591a2);
                        Bundle bundle = new Bundle();
                        bundle.putString("username", m9591a);
                        bundle.putString("password", m9591a2);
                        bundle.putBoolean("launch_from_pro", true);
                        bundle.putString("packageName", C2744aa.m5171b(this.f10736a));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        return;
                    }
                    this.f10739e.m4781a(-1);
                    String m9584b = PreferencesManager.m9595a(this.f10736a).m9584b("golo_seller_app_path", "");
                    if (!C2787z.m4821a(m9584b) && new File(m9584b).exists()) {
                        z = true;
                    }
                    if (z) {
                        m7888b(m9584b);
                    }
                    if (z) {
                        if (this.f10716E.isShowing()) {
                            this.f10716E.dismiss();
                            return;
                        }
                        return;
                    }
                    m7857o();
                    return;
                }
                int i3 = f10708q;
                if (i3 != -1) {
                    m7894b(i3);
                }
                NToast.m9450a(this.f10736a, (int) R.string.login_tip);
                return;
            case R.id.btn_info /* 2131296483 */:
                if (!C2744aa.m5145h()) {
                    this.f10751r = f10708q;
                    f10708q = i;
                    if (C2744aa.m5160d() || C2744aa.m5166c() || LangManager.m9466b().equalsIgnoreCase("CN") || (C2744aa.m5151f() && !LangManager.m9466b().equalsIgnoreCase("JP"))) {
                        m7898a(RepairInfoActivity.class, (Intent) null);
                        return;
                    } else {
                        m7898a(InfoActivity.class, (Intent) null);
                        return;
                    }
                }
                int i4 = f10708q;
                if (i4 != -1) {
                    m7894b(i4);
                }
                if (this.f10742h.m9584b("show_navigatorpro_tips", "1").equals("1")) {
                    Context context2 = this.f10736a;
                    DialogC1945e dialogC1945e = new DialogC1945e(context2, context2);
                    dialogC1945e.m4719a(R.string.btn_confirm, true, null);
                    dialogC1945e.m4578b();
                    dialogC1945e.show();
                    return;
                }
                CommonTools.m7965c(this.f10736a);
                return;
            case R.id.btn_mall /* 2131296492 */:
                if (LoginTools.m7945a(this.f10736a, 1)) {
                    String m9591a3 = PreferencesManager.m9595a(this.f10736a).m9591a("serialNo");
                    String m9591a4 = PreferencesManager.m9595a(this.f10736a).m9591a("carAndHeavydutySerialNo");
                    String m9591a5 = PreferencesManager.m9595a(this.f10736a).m9591a("carSerialNo");
                    String m9591a6 = PreferencesManager.m9595a(this.f10736a).m9591a("heavydutySerialNo");
                    if (!TextUtils.isEmpty(m9591a3) || !TextUtils.isEmpty(m9591a5) || !TextUtils.isEmpty(m9591a4) || !TextUtils.isEmpty(m9591a6)) {
                        if (C2744aa.m5118u(this.f10736a) != null) {
                            this.f10751r = f10708q;
                            f10708q = i;
                            m7898a(MallActivity.class, (Intent) null);
                            return;
                        }
                        NLog.m9451c(this.f10738d, "getShoppingUrlByKey is null");
                        return;
                    }
                    int i5 = f10708q;
                    if (i5 != -1) {
                        m7894b(i5);
                    }
                    NToast.m9447b(this.f10736a, (int) R.string.sos_serial_empty);
                    return;
                }
                int i6 = f10708q;
                if (i6 != -1) {
                    m7894b(i6);
                    return;
                }
                return;
            case R.id.btn_mine /* 2131296496 */:
                this.f10751r = f10708q;
                f10708q = i;
                if (C2744aa.m5166c() || !C2744aa.m5141j()) {
                    m7898a(MineActivity.class, (Intent) null);
                    return;
                } else {
                    m7898a(this.f10735Y ? IMActivity.class : MineActivity.class, (Intent) null);
                    return;
                }
            case R.id.btn_setting /* 2131296559 */:
                this.f10751r = f10708q;
                f10708q = i;
                m7898a(SettingActivity.class, (Intent) null);
                return;
            case R.id.btn_tools /* 2131296583 */:
                this.f10751r = f10708q;
                f10708q = i;
                m7898a(ToolsActivity.class, (Intent) null);
                return;
            case R.id.btn_upgrade /* 2131296587 */:
                this.f10751r = f10708q;
                f10708q = i;
                m7898a(UpgradeActivity.class, this.f10725O);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m7891b(MainActivity mainActivity, int i) {
        Message message2 = new Message();
        message2.what = i;
        mainActivity.f10728R.sendMessage(message2);
    }
}
