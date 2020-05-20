package com.cnlaunch.x431pro.activity.diagnose;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;
import com.cnlaunch.diagnosemodule.bean.BasicDiagDownloadFileBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicHTMLDialogBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineArithBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineCodeLib;
import com.cnlaunch.diagnosemodule.bean.BasicQueryArgToWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicQueryWebSiteBean;
import com.cnlaunch.diagnosemodule.bean.BasicSoftIDBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.model.DiagnoseActionInfo;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.diagnosemodule.utils.DiagnoseProcessInfoUtil;
import com.cnlaunch.diagnosemodule.utils.JsonUtils;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p169im.p172c.ProMessageFragment;
import com.cnlaunch.p169im.p173d.AutoVoiceHandler;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.p181j.ExplainResult;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.p183l.p184a.AidlClient;
import com.cnlaunch.p188n.RemoteSocketControler;
import com.cnlaunch.p188n.p190b.FeedbackDiagControler;
import com.cnlaunch.p188n.p190b.TechnicianInfo;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.cnlaunch.physics.DPULinkSettingsInformation;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.CloudDiagnose.CloudActivity;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p221d.ShowHtmlDataFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.SystemStatusCodeFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IRemoteDownloadListener;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.diagnose.p223f.DiagnoseWaitDialog;
import com.cnlaunch.x431pro.activity.diagnose.p223f.MessageBoxDialog;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.activity.mine.MineActivity;
import com.cnlaunch.x431pro.module.cloud.model.CloudDataManager;
import com.cnlaunch.x431pro.module.cloud.p248b.WebRemoteHandler;
import com.cnlaunch.x431pro.module.history.p266a.HistoryDao;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p252d.RemoteDiagAction;
import com.cnlaunch.x431pro.module.p252d.p253a.DiagnoseAction;
import com.cnlaunch.x431pro.module.p252d.p254b.C2725h;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.GetHelpDocInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.GetHelpDocResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.GetQueryWebResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineArithResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineFaultCodeQueryResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineFaultCodesWithSysQueryResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnlineFaultCodeHelpInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteServiceInfoData;
import com.cnlaunch.x431pro.module.p252d.p254b.SellerRemoteDiagInfo;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.p276a.ReportAction;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportResponse;
import com.cnlaunch.x431pro.module.rtu.ProductInformation;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.p210a.RemoteDiagObserve;
import com.cnlaunch.x431pro.utils.AppUsageNumRecord;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.LocationUtils;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.SlidingUpPanelLayout;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.OnLineProgrammingDialog;
import com.cnlaunch.x431pro.widget.p290a.PrinterFailrueDialog;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2850ci;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2851cj;
import com.cnlaunch.x431pro.widget.p290a.View$OnClickListenerC2884z;
import com.cnlaunch.x431pro.widget.p290a.VinScanSelectVehieclesDialog;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class DiagnoseActivity extends ActivityC2004c implements AdapterView.OnItemClickListener, IFragmentCallback, InfaceFragmentParent {

    /* renamed from: C */
    public static DiagnoseRunningInfo f11012C = null;

    /* renamed from: J */
    public static boolean f11013J = false;

    /* renamed from: ba */
    private static boolean f11014ba = false;

    /* renamed from: E */
    View f11016E;

    /* renamed from: F */
    SlidingUpPanelLayout f11017F;

    /* renamed from: G */
    TextView f11018G;

    /* renamed from: H */
    Context f11019H;

    /* renamed from: I */
    public ProMessageFragment f11020I;

    /* renamed from: K */
    Button f11021K;

    /* renamed from: N */
    boolean f11024N;

    /* renamed from: O */
    public BaseDialog f11025O;

    /* renamed from: Q */
    String f11027Q;

    /* renamed from: R */
    String f11028R;

    /* renamed from: S */
    String f11029S;

    /* renamed from: T */
    String f11030T;

    /* renamed from: U */
    String f11031U;

    /* renamed from: V */
    WaitDialog f11032V;

    /* renamed from: W */
    ProgressBar f11033W;

    /* renamed from: aB */
    private String f11038aB;

    /* renamed from: aG */
    private String[] f11043aG;

    /* renamed from: aR */
    private PathUtils f11054aR;

    /* renamed from: aS */
    private CarIconUtils f11055aS;

    /* renamed from: aT */
    private ArrayList<CarVersionInfo> f11056aT;

    /* renamed from: ac */
    private AidlClient f11065ac;

    /* renamed from: am */
    private Long f11075am;

    /* renamed from: an */
    private Long f11076an;

    /* renamed from: ao */
    private Long f11077ao;

    /* renamed from: ap */
    private DiagnoseWaitDialog f11078ap;

    /* renamed from: aq */
    private RadioButton f11079aq;

    /* renamed from: ar */
    private RadioButton f11080ar;

    /* renamed from: as */
    private MessageDialog f11081as;

    /* renamed from: ax */
    private PreferencesManager f11086ax;

    /* renamed from: ay */
    private Timer f11087ay;

    /* renamed from: az */
    private C2011c f11088az;

    /* renamed from: bF */
    private BasicOnlineArithBean f11094bF;

    /* renamed from: bH */
    private SoundPool f11096bH;

    /* renamed from: bI */
    private int f11097bI;

    /* renamed from: bN */
    private MessageDialog f11102bN;

    /* renamed from: bc */
    private BaseDialog f11106bc;

    /* renamed from: be */
    private InterfaceC2009a f11108be;

    /* renamed from: bf */
    private VinScanSelectVehieclesDialog f11109bf;

    /* renamed from: bg */
    private boolean f11110bg;

    /* renamed from: bh */
    private View$OnClickListenerC2884z f11111bh;

    /* renamed from: bi */
    private OnLineProgrammingDialog f11112bi;

    /* renamed from: bm */
    private BasicQueryArgToWebSiteBean f11116bm;

    /* renamed from: bs */
    private String f11122bs;

    /* renamed from: bu */
    private ArrayList<BasicDiagDownloadFileBean> f11124bu;

    /* renamed from: bz */
    private ArrayList<BasicOnlineCodeLib> f11129bz;

    /* renamed from: ad */
    private String f11066ad = "";

    /* renamed from: ae */
    private Messenger f11067ae = null;

    /* renamed from: af */
    private PowerManager f11068af = null;

    /* renamed from: ag */
    private ServiceConnection f11069ag = null;

    /* renamed from: n */
    RemoteDiagRunningInfo f11130n = null;

    /* renamed from: ah */
    private DiagnoseUIDataBusiness f11070ah = null;

    /* renamed from: ai */
    private PowerManager.WakeLock f11071ai = null;

    /* renamed from: aj */
    private OnKeyDownListenter f11072aj = null;

    /* renamed from: ak */
    private OnDiagnoseDataUpdateListenter f11073ak = null;

    /* renamed from: al */
    private MessageBoxDialog f11074al = null;

    /* renamed from: D */
    RemoteDiagHandler f11015D = null;

    /* renamed from: at */
    private UpLoadReportInfo f11082at = null;

    /* renamed from: au */
    private ArrayList<UpLoadReportInfo> f11083au = null;

    /* renamed from: av */
    private OnActivityResultListenter f11084av = null;

    /* renamed from: aw */
    private boolean f11085aw = false;

    /* renamed from: aA */
    private final int f11037aA = PdfContentParser.COMMAND_TYPE;

    /* renamed from: aC */
    private final int f11039aC = 0;

    /* renamed from: aD */
    private final int f11040aD = 1;

    /* renamed from: aE */
    private final int f11041aE = 2;

    /* renamed from: aF */
    private boolean f11042aF = false;

    /* renamed from: aH */
    private boolean f11044aH = false;

    /* renamed from: aI */
    private String f11045aI = "";

    /* renamed from: aJ */
    private final int f11046aJ = 4352;

    /* renamed from: aK */
    private final int f11047aK = 20501;

    /* renamed from: aL */
    private final int f11048aL = 20502;

    /* renamed from: aM */
    private final int f11049aM = 20503;

    /* renamed from: aN */
    private final int f11050aN = 20504;

    /* renamed from: aO */
    private final int f11051aO = 20505;

    /* renamed from: aP */
    private final int f11052aP = TIFFConstants.TIFFTAG_ORIENTATION;

    /* renamed from: aQ */
    private final int f11053aQ = 20512;

    /* renamed from: aU */
    private String f11057aU = "";

    /* renamed from: aV */
    private String f11058aV = "";

    /* renamed from: aW */
    private String f11059aW = "";

    /* renamed from: aX */
    private String f11060aX = "";

    /* renamed from: aY */
    private String f11061aY = "";

    /* renamed from: aZ */
    private int f11062aZ = 0;

    /* renamed from: bb */
    private C2725h f11105bb = null;

    /* renamed from: bd */
    private String f11107bd = "";

    /* renamed from: L */
    String f11022L = "";

    /* renamed from: M */
    IRemoteDownloadListener f11023M = null;

    /* renamed from: P */
    public Messenger f11026P = new Messenger(new HandlerC2212t(this));

    /* renamed from: bj */
    private OnDiagnoseDataListener f11113bj = new C2071be(this);

    /* renamed from: bk */
    private String f11114bk = "";

    /* renamed from: bl */
    private String f11115bl = "";

    /* renamed from: bn */
    private String f11117bn = PathUtils.m4855d() + "/BWM_FP_UPLOAD.zip";

    /* renamed from: bo */
    private String f11118bo = "filePathBWM_FP_UPLOAD.zip";

    /* renamed from: bp */
    private String f11119bp = "";

    /* renamed from: bq */
    private String f11120bq = "";

    /* renamed from: br */
    private String f11121br = "";

    /* renamed from: X */
    boolean f11034X = false;

    /* renamed from: bt */
    private String f11123bt = "";

    /* renamed from: bv */
    private int f11125bv = 0;

    /* renamed from: bw */
    private ArrayList<Integer> f11126bw = new ArrayList<>();

    /* renamed from: bx */
    private String f11127bx = "";

    /* renamed from: by */
    private String f11128by = "";

    /* renamed from: bA */
    private ArrayList<BasicSystemStatusBean> f11089bA = new ArrayList<>();

    /* renamed from: bB */
    private ArrayList<BasicFaultCodeBean> f11090bB = new ArrayList<>();

    /* renamed from: bC */
    private int f11091bC = 0;

    /* renamed from: bD */
    private String f11092bD = "0";

    /* renamed from: bE */
    private int f11093bE = 0;

    /* renamed from: bG */
    private boolean f11095bG = false;

    /* renamed from: bJ */
    private int f11098bJ = 0;

    /* renamed from: bK */
    private final BroadcastReceiver f11099bK = new C2043ad(this);

    /* renamed from: bL */
    private MessageDialog f11100bL = null;

    /* renamed from: bM */
    private boolean f11101bM = false;

    /* renamed from: Y */
    SelectMessageDialog f11035Y = null;

    /* renamed from: Z */
    SlidingUpPanelLayout.InterfaceC2799c f11036Z = new C2065az(this);

    /* renamed from: aa */
    int f11063aa = 0;

    /* renamed from: bO */
    private Handler f11103bO = new HandlerC2067ba(this);

    /* renamed from: ab */
    RemotePerformClick f11064ab = null;

    /* renamed from: bP */
    private DealDiagMessageHandler.InterfaceC1766b f11104bP = new C2068bb(this);

    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2009a {
        /* renamed from: a */
        void mo7041a();

        /* renamed from: b */
        void mo7040b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ void m7612r() {
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public static /* synthetic */ boolean m7716F(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11095bG = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: L */
    public static /* synthetic */ boolean m7710L(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11044aH = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: R */
    public static /* synthetic */ int m7704R(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11062aZ = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: V */
    public static /* synthetic */ boolean m7700V(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11042aF = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Y */
    public static /* synthetic */ UpLoadReportInfo m7697Y(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11082at = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ boolean m7618o() {
        f11014ba = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ boolean m7611r(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11034X = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static /* synthetic */ boolean m7603v(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11085aw = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static /* synthetic */ MessageDialog m7597y(DiagnoseActivity diagnoseActivity) {
        diagnoseActivity.f11081as = null;
        return null;
    }

    /* renamed from: a */
    public final void m7695a(Context context, InterfaceC2009a interfaceC2009a) {
        this.f11108be = interfaceC2009a;
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(67108864);
        startActivityForResult(intent, TIFFConstants.TIFFTAG_ORIENTATION);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_remotediag);
        f11012C = new DiagnoseRunningInfo();
        this.f11081as = null;
        this.f11019H = this;
        HistoryDao.m5300a(this.f11019H);
        C1947h.f10553e = false;
        this.f11086ax = PreferencesManager.m9595a(this.f11019H);
        DiagnoseConstants.CurrentDEVICE_DISTRICT = this.f11086ax.m9584b("current_device_district", "0");
        DiagnoseUtils m5086a = DiagnoseUtils.m5086a();
        Context context = this.f11019H;
        m5086a.f15755a = this;
        m5086a.f15760f = context;
        m5086a.f15756b = PreferencesManager.m9595a((Context) this);
        DiagnoseUtils.m5086a().m5076f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DiagnoseActionInfo.DiagServiceInitMessager);
        intentFilter.addAction(DiagnoseConstants.DIAG_ERROR_BROADCAST);
        intentFilter.addAction(DiagnoseConstants.DIAG_EXIT_BROADCAST);
        intentFilter.addAction("BingServiceIsReady");
        intentFilter.addAction("LaunchRemoteDiag");
        intentFilter.addAction("LaunchCloudDiag");
        intentFilter.addAction("LaunchWebRemoteDiag");
        intentFilter.addAction("SPT_SET_VIN");
        intentFilter.addAction("GET_OTO");
        intentFilter.addAction("StopRemotoDiagnose");
        intentFilter.addAction("StopRemotoDiagnoseFromBuletooth");
        intentFilter.addAction("DPUDeviceConnectSuccess");
        intentFilter.addAction("DPUDeviceConnectFail");
        intentFilter.addAction("DPUDeviceConnectDisconnected");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("JumpDownloadBin");
        intentFilter.addAction("DownloadBin_DisConnBluetooth");
        intentFilter.addAction("DeviceConnectLost");
        intentFilter.addAction("NativeMethodNoFind");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction(DiagnoseConstants.SCREEN_CHANGE);
        intentFilter.addAction("ExitDiagnoseWithHomeBtn");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("startDiagnoseWithoutSelectVersion");
        intentFilter.addAction("action.bt.device.con.coning");
        intentFilter.addAction("HISTORY_DIAG");
        intentFilter.addAction("VIN_CAR_ARRAY");
        intentFilter.addAction("VIN_START_DIAG");
        intentFilter.addAction("InputVinFragment");
        intentFilter.addAction("NativeSoNotFind");
        intentFilter.addAction("UpdateDatastreamCount");
        intentFilter.addAction("READ_VIN_BY_OBD");
        intentFilter.addAction("NEED_DOWN_LOAD_VEHICLES");
        intentFilter.addAction("com.cnlaunch.intent.action.DIAG_UNCONNECTED");
        intentFilter.addAction("CT_HEAD_RET_READVINCVN");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("pause_soundpool");
        registerReceiver(this.f11099bK, intentFilter);
        this.f11068af = (PowerManager) getSystemService("power");
        this.f11071ai = this.f11068af.newWakeLock(6, "My Lock");
        try {
            mo7083i().setAppVersion(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (bundle == null) {
            m7596z();
        }
        this.f11017F = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.f11017F.setShadowDrawable(getResources().getDrawable(R.drawable.above_shadow));
        this.f11017F.setAnchorPoint(1.0f);
        this.f11016E = findViewById(R.id.sliding_contanier);
        this.f11018G = (TextView) findViewById(R.id.chatwindow_name);
        this.f11054aR = new PathUtils(this.f11019H);
        this.f11055aS = new CarIconUtils(this.f11019H);
        Context context2 = this.f11019H;
        getResources().getString(R.string.common_title_tips);
        this.f11078ap = new DiagnoseWaitDialog(context2, "", this);
        this.f11078ap.setCanceledOnTouchOutside(false);
        this.f11078ap.setCancelable(false);
        this.f11065ac = new AidlClient(this.f11019H);
        DealDiagMessageHandler.m8673a().f9428d = this.f11104bP;
        this.f11079aq = (RadioButton) findViewById(R.id.btn_heavyduty);
        if (C2744aa.m5166c()) {
            this.f11080ar = (RadioButton) findViewById(R.id.btn_all);
        }
        if (C2744aa.m5164c(this.f11019H)) {
            RadioButton radioButton = this.f11080ar;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
            this.f11079aq.setVisibility(0);
        } else {
            RadioButton radioButton2 = this.f11080ar;
            if (radioButton2 != null) {
                radioButton2.setVisibility(0);
            }
            this.f11079aq.setVisibility(8);
        }
        PreferencesManager.m9595a(this.f11019H).m9587a("launch_datastream_show_fragment", true);
        this.f11024N = false;
        WebRemoteHandler.m5419a().f15485e = this;
        this.f11110bg = false;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f11071ai.acquire();
        this.f11105bb = LocationUtils.m4873a(this.f11019H);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f11071ai.release();
    }

    /* renamed from: a */
    private void m7667a(String str, String str2, ArrayList<BasicSystemStatusBean> arrayList, String str3) {
        if (DiagnoseConstants.FAULTCODE_REFRESH) {
            if (this.f11073ak == null || !mo7083i().isFaultCode()) {
                mo7083i().setFaultCode(true);
                SystemStatusCodeFragment systemStatusCodeFragment = new SystemStatusCodeFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("SystemStatus", arrayList);
                bundle.putString("Code_Type", str);
                bundle.putString("DataType", str2);
                if (str2.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
                    bundle.putString("HasContinue", str3);
                }
                systemStatusCodeFragment.setArguments(bundle);
                mo7098a((Fragment) systemStatusCodeFragment, (String) null, false);
                f11014ba = true;
                return;
            }
            this.f11073ak.mo7075a(arrayList, str3.equals("1"));
        }
    }

    /* renamed from: c */
    private static int m7646c(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(new File(PathUtils.m4871a() + DiagnoseConstants.DIAGNOSE_LIB_PATH + str2));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.print(str);
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: d */
    private void m7639d(boolean z) {
        this.f11126bw.add(Integer.valueOf(!z ? 1 : 0));
        this.f11125bv++;
        if (this.f11125bv == this.f11124bu.size()) {
            int size = this.f11126bw.size();
            byte[] bArr = new byte[size + 1];
            int i = 0;
            bArr[0] = 0;
            while (i < size) {
                int i2 = i + 1;
                bArr[i2] = (byte) (this.f11126bw.get(i).intValue() & 255);
                i = i2;
            }
            m7653b(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, bArr);
            this.f11078ap.dismiss();
            return;
        }
        AsyncTaskManager.m9576a(60009);
        m7739c(60009);
        if (this.f11078ap != null) {
            this.f11078ap.m7059a(this.f11019H.getResources().getString(R.string.onlineprograming_tip_downing) + "\n" + this.f11019H.getResources().getString(R.string.down_progress_txt) + ": " + String.valueOf(this.f11125bv) + " / " + String.valueOf(this.f11124bu.size()));
        }
    }

    /* renamed from: b */
    private void m7653b(String str, byte[] bArr) {
        if (mo7083i().getDiagnoseStatue() == 1) {
            return;
        }
        mo7089a(str, bArr);
    }

    /* renamed from: e */
    private void m7635e(boolean z) {
        this.f11078ap.dismiss();
        if (z) {
            m7653b(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{0});
        } else {
            m7653b(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{-1});
        }
    }

    /* renamed from: s */
    private void m7610s() {
        if (TextUtils.isEmpty(DiagnoseConstants.VIN_CODE)) {
            return;
        }
        AsyncTaskManager.m9576a(600028);
        m7739c(600028);
    }

    /* renamed from: g */
    private byte m7631g(int i) {
        if (i == 771) {
            Context context = this.f11019H;
            NToast.m9449a(context, context.getResources().getString(R.string.onlineprograming_tip_cc_sn_not_match));
            return (byte) -18;
        } else if (i == 615) {
            Context context2 = this.f11019H;
            NToast.m9449a(context2, context2.getResources().getString(R.string.onlineprograming_tip_clock_count_over));
            return (byte) -19;
        } else if (i == 616) {
            Context context3 = this.f11019H;
            NToast.m9449a(context3, context3.getResources().getString(R.string.mine_check_error));
            return (byte) -20;
        } else if (i == 614) {
            Context context4 = this.f11019H;
            NToast.m9449a(context4, context4.getResources().getString(R.string.onlineprograming_tip_requse_count_over));
            return (byte) -21;
        } else {
            if (i == -1) {
                Context context5 = this.f11019H;
                NToast.m9449a(context5, context5.getResources().getString(R.string.feedback_error_tips_658));
            } else if (i == -4) {
                Context context6 = this.f11019H;
                NToast.m9449a(context6, context6.getResources().getString(R.string.onlineprograming_tip_clock_count_over));
            }
            return (byte) 0;
        }
    }

    /* renamed from: a */
    private void m7670a(Object obj) {
        LoadDialog.m4681b(this.f11019H);
        OnLineArithResponse onLineArithResponse = (OnLineArithResponse) obj;
        if (onLineArithResponse == null || onLineArithResponse.getCode() != 0) {
            byte b = -17;
            if (onLineArithResponse != null) {
                b = (byte) (onLineArithResponse.getCode() & 255);
                byte m7631g = m7631g(onLineArithResponse.getCode());
                if (m7631g != 0) {
                    b = m7631g;
                }
            }
            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, b});
            return;
        }
        String logicData = onLineArithResponse.getLogicData();
        int length = logicData.length();
        byte[] bArr = new byte[length + 5];
        bArr[0] = 0;
        int i = length + 2;
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[2] = (byte) (i & 255);
        bArr[3] = 0;
        bArr[bArr.length - 1] = 0;
        System.arraycopy(logicData.getBytes(), 0, bArr, 4, length);
        m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, bArr);
        if (PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "CalcLine")) {
            m7610s();
        }
    }

    /* renamed from: b */
    private void m7654b(Object obj) {
        OnlineFaultCodeHelpInfo onlineFaultCodeHelpInfo = (OnlineFaultCodeHelpInfo) obj;
        if (onlineFaultCodeHelpInfo == null || onlineFaultCodeHelpInfo.getCode() != 0) {
            if (onlineFaultCodeHelpInfo != null) {
                m7631g(onlineFaultCodeHelpInfo.getCode());
            }
            MessageDialog messageDialog = new MessageDialog(this.f11019H);
            this.f11025O = messageDialog;
            messageDialog.m4668a(getString(R.string.dialog_title_help), getString(R.string.help_null_data), getString(17039370), new View$OnClickListenerC2215w(this));
        } else if (onlineFaultCodeHelpInfo.getDtcHelpType().equalsIgnoreCase(OnlineFaultCodeHelpInfo.TXT)) {
            MessageDialog messageDialog2 = new MessageDialog(this.f11019H);
            this.f11025O = messageDialog2;
            messageDialog2.m4668a(getString(R.string.dialog_title_help), onlineFaultCodeHelpInfo.getDtcHelpData(), getString(17039370), new View$OnClickListenerC2216x(this));
        } else {
            NToast.m9450a(this.f11019H, (int) R.string.help_null_data);
            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
        }
    }

    /* renamed from: a */
    private static void m7691a(BasicSystemStatusBean basicSystemStatusBean) {
        ArrayList<BasicOnlineCodeLib> onlineFaultCodeList = basicSystemStatusBean.getOnlineFaultCodeList();
        basicSystemStatusBean.getSystemFaultCodeBean().clear();
        for (int i = 0; i < onlineFaultCodeList.size(); i++) {
            String codeID = onlineFaultCodeList.get(i).getCodeID();
            BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
            basicFaultCodeBean.setId(codeID);
            basicFaultCodeBean.setTitle((codeID.substring(0, 2) + "," + codeID.substring(2, 4) + "," + codeID.substring(4, 6) + "," + codeID.substring(6, 8)) + C2744aa.m5167b(codeID.substring(4, 6), codeID.substring(6, 8)));
            basicFaultCodeBean.setContext("CONSULT HANDBOOK");
            basicSystemStatusBean.getSystemFaultCodeBean().add(basicFaultCodeBean);
        }
    }

    /* renamed from: a */
    private static void m7669a(String str, BasicFaultCodeBean basicFaultCodeBean) {
        basicFaultCodeBean.setTitle((str.substring(0, 2) + "," + str.substring(2, 4) + "," + str.substring(4, 6) + "," + str.substring(6, 8)) + C2744aa.m5167b(str.substring(4, 6), str.substring(6, 8)));
        basicFaultCodeBean.setContext("CONSULT HANDBOOK");
    }

    /* renamed from: t */
    private BasicSystemStatusBean m7608t() {
        int i = 0;
        for (int i2 = 0; i2 < this.f11089bA.size(); i2++) {
            if (this.f11089bA.get(i2).isFaultCodeOnline()) {
                if (i == this.f11093bE) {
                    return this.f11089bA.get(i2);
                }
                i++;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m7647c(Object obj) {
        BasicOnlineCodeLib basicOnlineCodeLib;
        BasicSystemStatusBean m7608t = m7608t();
        if (m7608t == null) {
            return true;
        }
        boolean m4865a = PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "RetErrCodeOLDTC");
        if (obj != null) {
            OnLineFaultCodesWithSysQueryResponse onLineFaultCodesWithSysQueryResponse = (OnLineFaultCodesWithSysQueryResponse) obj;
            if (onLineFaultCodesWithSysQueryResponse.getCode() == 0) {
                for (int i = 0; i < m7608t.getOnlineFaultCodeList().size(); i++) {
                    if (i < onLineFaultCodesWithSysQueryResponse.getDtcs().size()) {
                        OnLineFaultCodeQueryResponse onLineFaultCodeQueryResponse = onLineFaultCodesWithSysQueryResponse.getDtcs().get(i);
                        String dtcCode = onLineFaultCodeQueryResponse.getDtcCode();
                        String dtcDesc = onLineFaultCodeQueryResponse.getDtcDesc();
                        if (!m7608t.getOnlineFaultCodeList().get(i).getSmallCode().equalsIgnoreCase("FFFFFFFF") && !TextUtils.isEmpty(onLineFaultCodeQueryResponse.getDtcSmallDesc())) {
                            dtcCode = (dtcCode + " - ") + basicOnlineCodeLib.getSmallCode().substring(6, 8);
                            dtcDesc = (dtcDesc + " - ") + onLineFaultCodeQueryResponse.getDtcSmallDesc();
                        }
                        BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                        basicFaultCodeBean.setTitle(dtcCode);
                        basicFaultCodeBean.setContext(dtcDesc);
                        basicFaultCodeBean.setStatus(onLineFaultCodeQueryResponse.getDtcStatus());
                        basicFaultCodeBean.setSamllCode(onLineFaultCodeQueryResponse.getDtcSmallDesc());
                        m7608t.getSystemFaultCodeBean().add(basicFaultCodeBean);
                    } else {
                        String codeID = m7608t.getOnlineFaultCodeList().get(i).getCodeID();
                        BasicFaultCodeBean basicFaultCodeBean2 = new BasicFaultCodeBean();
                        basicFaultCodeBean2.setId(codeID);
                        basicFaultCodeBean2.setTitle((codeID.substring(0, 2) + "," + codeID.substring(2, 4) + "," + codeID.substring(4, 6) + "," + codeID.substring(6, 8)) + C2744aa.m5167b(codeID.substring(4, 6), codeID.substring(6, 8)));
                        basicFaultCodeBean2.setContext("CONSULT HANDBOOK");
                        m7608t.getSystemFaultCodeBean().add(basicFaultCodeBean2);
                    }
                }
            } else if (m4865a) {
                return false;
            } else {
                m7691a(m7608t);
                m7631g(onLineFaultCodesWithSysQueryResponse.getCode());
            }
        } else if (m4865a) {
            return false;
        } else {
            m7691a(m7608t);
        }
        return true;
    }

    /* renamed from: d */
    private void m7641d(Object obj) {
        int size;
        boolean z;
        int i;
        if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox)) {
            LoadDialog.m4681b(this.f11019H);
            m7654b(obj);
            return;
        }
        if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX)) {
            LoadDialog.m4681b(this.f11019H);
            OnLineFaultCodesWithSysQueryResponse onLineFaultCodesWithSysQueryResponse = obj != null ? (OnLineFaultCodesWithSysQueryResponse) obj : null;
            boolean m4865a = PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "RetErrCodeOLDTC");
            for (int i2 = 0; i2 < this.f11129bz.size(); i2++) {
                BasicOnlineCodeLib basicOnlineCodeLib = this.f11129bz.get(i2);
                String codeID = basicOnlineCodeLib.getCodeID();
                BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                basicFaultCodeBean.setId(codeID);
                if (obj == null || ((obj != null && onLineFaultCodesWithSysQueryResponse.getCode() != 0) || (obj != null && onLineFaultCodesWithSysQueryResponse.getDtcs().size() <= i2))) {
                    if (m4865a) {
                        if (obj == null) {
                            z = true;
                            i = 2;
                            break;
                        } else if (obj != null && onLineFaultCodesWithSysQueryResponse.getCode() != 0) {
                            i = onLineFaultCodesWithSysQueryResponse.getCode();
                            z = true;
                            break;
                        } else if (obj != null && onLineFaultCodesWithSysQueryResponse.getDtcs().size() <= i2) {
                            break;
                        }
                    } else {
                        m7669a(codeID, basicFaultCodeBean);
                        if (obj != null) {
                            m7631g(onLineFaultCodesWithSysQueryResponse.getCode());
                        }
                    }
                } else {
                    OnLineFaultCodeQueryResponse onLineFaultCodeQueryResponse = onLineFaultCodesWithSysQueryResponse.getDtcs().get(i2);
                    String dtcCode = onLineFaultCodeQueryResponse.getDtcCode();
                    String dtcDesc = onLineFaultCodeQueryResponse.getDtcDesc();
                    if (!basicOnlineCodeLib.getSmallCode().equalsIgnoreCase("FFFFFFFF") && !TextUtils.isEmpty(onLineFaultCodeQueryResponse.getDtcSmallDesc())) {
                        dtcCode = (dtcCode + " - ") + basicOnlineCodeLib.getSmallCode().substring(6, 8);
                        dtcDesc = (dtcDesc + " - ") + onLineFaultCodeQueryResponse.getDtcSmallDesc();
                    }
                    basicFaultCodeBean.setTitle(dtcCode);
                    basicFaultCodeBean.setContext(dtcDesc);
                    basicFaultCodeBean.setStatus(onLineFaultCodeQueryResponse.getDtcStatus());
                    basicFaultCodeBean.setSamllCode(onLineFaultCodeQueryResponse.getDtcSmallDesc());
                    if (!basicOnlineCodeLib.getHelpID().toUpperCase().startsWith("FF")) {
                        basicFaultCodeBean.setHelp(basicOnlineCodeLib.getHelpID());
                    }
                    basicFaultCodeBean.setHasFreeze(basicOnlineCodeLib.getHelpType() == 1);
                }
                this.f11090bB.add(basicFaultCodeBean);
            }
            z = false;
            i = 2;
            if (z) {
                mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, -2, (byte) ((i >> 8) & 255), (byte) (i & 255)});
                return;
            }
            this.f11113bj.onDiagnoseFaultCodeDataCallback(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE, this.f11090bB, null);
            m7610s();
            return;
        }
        if (this.f11123bt.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
            if (!m7647c(obj)) {
                this.f11078ap.dismiss();
                int code = obj != null ? ((OnLineFaultCodesWithSysQueryResponse) obj).getCode() : 2;
                mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, -2, (byte) ((code >> 8) & 255), (byte) (code & 255)});
                return;
            }
        } else {
            BasicOnlineCodeLib basicOnlineCodeLib2 = this.f11129bz.get(this.f11093bE);
            String codeID2 = basicOnlineCodeLib2.getCodeID();
            BasicFaultCodeBean basicFaultCodeBean2 = new BasicFaultCodeBean();
            basicFaultCodeBean2.setId(codeID2);
            if (obj == null) {
                m7669a(codeID2, basicFaultCodeBean2);
            } else {
                OnLineFaultCodeQueryResponse onLineFaultCodeQueryResponse2 = (OnLineFaultCodeQueryResponse) obj;
                if (onLineFaultCodeQueryResponse2.getCode() != 0) {
                    m7669a(codeID2, basicFaultCodeBean2);
                    m7631g(onLineFaultCodeQueryResponse2.getCode());
                } else {
                    String dtcCode2 = onLineFaultCodeQueryResponse2.getDtcCode();
                    String dtcDesc2 = onLineFaultCodeQueryResponse2.getDtcDesc();
                    if (!basicOnlineCodeLib2.getSmallCode().equalsIgnoreCase("FFFFFFFF") && !TextUtils.isEmpty(onLineFaultCodeQueryResponse2.getDtcSmallDesc())) {
                        dtcCode2 = (dtcCode2 + " - ") + basicOnlineCodeLib2.getSmallCode().substring(6, 8);
                        dtcDesc2 = (dtcDesc2 + " - ") + onLineFaultCodeQueryResponse2.getDtcSmallDesc();
                    }
                    basicFaultCodeBean2.setTitle(dtcCode2);
                    basicFaultCodeBean2.setContext(dtcDesc2);
                    basicFaultCodeBean2.setStatus(onLineFaultCodeQueryResponse2.getDtcStatus());
                    basicFaultCodeBean2.setSamllCode(onLineFaultCodeQueryResponse2.getDtcSmallDesc());
                }
                if (!basicOnlineCodeLib2.getHelpID().toUpperCase().startsWith("FF")) {
                    basicFaultCodeBean2.setHelp(basicOnlineCodeLib2.getHelpID());
                }
                basicFaultCodeBean2.setHasFreeze(basicOnlineCodeLib2.getHelpType() == 1);
            }
            this.f11090bB.add(basicFaultCodeBean2);
        }
        this.f11093bE++;
        if (this.f11093bE == (this.f11123bt.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT) ? this.f11091bC : this.f11129bz.size())) {
            this.f11078ap.dismiss();
            if (this.f11123bt.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
                m7667a(DiagnoseConstants.UI_Type_ShowTransDiagInfo, DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT, this.f11089bA, this.f11092bD);
                m7610s();
                return;
            }
            this.f11113bj.onDiagnoseFaultCodeDataCallback(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE, this.f11090bB, null);
            return;
        }
        AsyncTaskManager.m9576a(600015);
        m7739c(600015);
        if (this.f11078ap != null) {
            this.f11078ap.m7059a(this.f11019H.getResources().getString(R.string.custom_diaglog_message) + "\n" + this.f11019H.getResources().getString(R.string.down_progress_txt) + ": " + String.valueOf(this.f11093bE) + " / " + String.valueOf(size));
            this.f11078ap.show();
        }
    }

    /* renamed from: a */
    public final void m7693a(Bundle bundle) {
        switch (bundle.getInt("RequestCode", -1)) {
            case 60003:
                this.f11119bp = bundle.getString("db_name");
                this.f11120bq = bundle.getString("tab_name");
                this.f11121br = bundle.getString("condition");
                this.f11107bd = "";
                return;
            case 60004:
                this.f11114bk = bundle.getString("db_key");
                this.f11115bl = bundle.getString("filePathBWM_FP_download");
                this.f11123bt = bundle.getString("data_type");
                return;
            case 60005:
                this.f11116bm = (BasicQueryArgToWebSiteBean) bundle.getSerializable("queryArgToWebSiteBean");
                this.f11123bt = bundle.getString("data_type");
                return;
            case 60008:
                this.f11127bx = bundle.getString("localPath");
                this.f11128by = bundle.getString("carName");
                AsyncTaskManager.m9576a(60008);
                m7739c(60008);
                if (this.f11078ap != null) {
                    this.f11078ap.m7059a(this.f11019H.getResources().getString(R.string.custom_diaglog_message));
                    this.f11078ap.show();
                    return;
                }
                return;
            case 60009:
                this.f11124bu = (ArrayList) bundle.getSerializable(DataPacketExtension.ELEMENT_NAME);
                this.f11125bv = 0;
                this.f11126bw.clear();
                AsyncTaskManager.m9576a(60009);
                this.f11125bv = 0;
                m7739c(60009);
                if (this.f11078ap != null) {
                    this.f11078ap.m7059a(this.f11019H.getResources().getString(R.string.onlineprograming_tip_downing) + "\n" + this.f11019H.getResources().getString(R.string.down_progress_txt) + ": " + String.valueOf(this.f11125bv) + " / " + String.valueOf(this.f11124bu.size()));
                    this.f11078ap.show();
                    return;
                }
                return;
            case 600015:
                this.f11123bt = bundle.getString("data_type");
                if (this.f11123bt.startsWith(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
                    this.f11092bD = this.f11123bt.substring(2);
                    this.f11123bt = DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT;
                    this.f11091bC = 0;
                    this.f11089bA = (ArrayList) bundle.getSerializable(DataPacketExtension.ELEMENT_NAME);
                    for (int i = 0; i < this.f11089bA.size(); i++) {
                        if (this.f11089bA.get(i).isFaultCodeOnline()) {
                            this.f11091bC++;
                        }
                    }
                } else {
                    this.f11129bz = (ArrayList) bundle.getSerializable(DataPacketExtension.ELEMENT_NAME);
                }
                AsyncTaskManager.m9576a(600015);
                this.f11090bB.clear();
                this.f11093bE = 0;
                m7739c(600015);
                if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox) || this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX)) {
                    Context context = this.f11019H;
                    LoadDialog.m4682a(context, context.getString(R.string.please_wait), true);
                    return;
                } else if (this.f11078ap != null) {
                    int size = this.f11123bt.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT) ? this.f11091bC : this.f11129bz.size();
                    this.f11078ap.m7059a(this.f11019H.getResources().getString(R.string.custom_diaglog_message) + "\n" + this.f11019H.getResources().getString(R.string.down_progress_txt) + ": " + String.valueOf(this.f11093bE) + " / " + String.valueOf(size));
                    this.f11078ap.show();
                    return;
                } else {
                    return;
                }
            case 600016:
                this.f11094bF = (BasicOnlineArithBean) bundle.getSerializable(DataPacketExtension.ELEMENT_NAME);
                AsyncTaskManager.m9576a(600016);
                m7739c(600016);
                Context context2 = this.f11019H;
                LoadDialog.m4682a(context2, context2.getString(R.string.please_wait), true);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m7606u() {
        DiagnoseProcessInfoUtil.getInstance().stopRecordProscess();
        BaseDialog baseDialog = this.f11025O;
        if (baseDialog != null && baseDialog.isShowing()) {
            NLog.m9456a("yhx", "currentDialog.dismiss");
            this.f11025O.mo4545k();
        }
        AidlClient aidlClient = this.f11065ac;
        if (aidlClient != null && aidlClient.f9521c) {
            try {
                AidlClient aidlClient2 = this.f11065ac;
                aidlClient2.f9520b.getApplicationContext().unbindService(aidlClient2.f9523e);
                aidlClient2.f9522d = null;
                aidlClient2.f9521c = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        DiagnoseUtils m5086a = DiagnoseUtils.m5086a();
        if (m5086a.f15757c != null && !"AUTOSEARCH".equalsIgnoreCase(m5086a.f15757c.getPackageId())) {
            m5086a.f15757c.setMileage(DiagnoseConstants.DIAG_ODO_DATA);
            m5086a.f15757c.setModel(TextUtils.isEmpty(DiagnoseConstants.MARKET_CAR_MODEL) ? DiagnoseInfo.getInstance().getModel() : DiagnoseConstants.MARKET_CAR_MODEL);
            m5086a.f15757c.setDiag_car_mode(DiagnoseInfo.getInstance().getModel());
            m5086a.f15757c.setYear(TextUtils.isEmpty(DiagnoseConstants.RECORD_YEAR) ? DiagnoseInfo.getInstance().getYear() : DiagnoseConstants.RECORD_YEAR);
            m5086a.f15757c.setDisplacement(DiagnoseConstants.RECORD_DISPLACEMENT);
            m5086a.f15757c.setTransmission(DiagnoseConstants.RECORD_TRANS);
            m5086a.f15757c.setDiag_end_time(System.currentTimeMillis() / 1000);
            m5086a.f15757c.setPlate(DiagnoseConstants.LICENSEPLATE);
            if (TextUtils.isEmpty(m5086a.f15757c.getVin()) && !TextUtils.isEmpty(DiagnoseConstants.VIN_CODE) && !"null".equalsIgnoreCase(DiagnoseConstants.VIN_CODE)) {
                m5086a.f15757c.setVin(DiagnoseConstants.VIN_CODE);
            }
            if (MainActivity.m7881d()) {
                m5086a.f15757c.setRemote_tech_advise(TechnicianInfo.f9633d);
                m5086a.f15757c.setRemote_tech_id(TechnicianInfo.f9630a);
                DiagnoseConstants.setDiagIdentity(3);
                RemoteSocketControler.m8607a().m8593k();
                WebRemoteHandler.m5419a().m5417b();
                MainActivity.m7882c(false);
            }
            NLog.m9452b("XEE", "---退出时诊断信息---:" + m5086a.f15757c.toString());
        }
        DiagnoseUtils m5086a2 = DiagnoseUtils.m5086a();
        if (m5086a2.f15757c != null) {
            NLog.m9452b("XEE", "sys size:" + DiagnoseProcessInfoUtil.getInstance().getArSysData().size() + " vin:" + m5086a2.f15757c.getVin());
            if (DiagnoseProcessInfoUtil.getInstance().getArSysData().size() > 0 && !"DEMO".equalsIgnoreCase(m5086a2.f15757c.getPackageId())) {
                m5086a2.f15759e = CloudDataManager.m5413a(m5086a2.f15755a).m5411a(m5086a2.f15757c, DiagnoseProcessInfoUtil.getInstance().getArSysData());
                C2744aa.m5182a(m5086a2.f15755a, m5086a2.f15759e);
                if (!TextUtils.isEmpty(m5086a2.f15757c.getVin()) && !m5086a2.f15757c.isUpdata() && !m5086a2.f15758d) {
                    m5086a2.f15757c.setDiag_start_time(m5086a2.f15757c.getDiag_start_time() - 10);
                    m5086a2.f15757c.setReport_type("CCC");
                    m5086a2.f15759e = CloudDataManager.m5413a(m5086a2.f15755a).m5411a(m5086a2.f15757c, (ArrayList<BasicSystemStatusBean>) null);
                    C2744aa.m5182a(m5086a2.f15755a, m5086a2.f15759e);
                }
            } else if (DiagnoseProcessInfoUtil.getInstance().getArSysData().size() == 0 && !"DEMO".equalsIgnoreCase(m5086a2.f15757c.getPackageId()) && !TextUtils.isEmpty(m5086a2.f15757c.getVin()) && !m5086a2.f15757c.isUpdata() && !m5086a2.f15758d) {
                m5086a2.f15757c.setReport_type("CCC");
                m5086a2.f15759e = CloudDataManager.m5413a(m5086a2.f15755a).m5411a(m5086a2.f15757c, (ArrayList<BasicSystemStatusBean>) null);
                C2744aa.m5182a(m5086a2.f15755a, m5086a2.f15759e);
            }
            NLog.m9452b("XEE", "报告上传后:" + MainActivity.m7886c());
            if (!MainActivity.m7886c()) {
                m5086a2.m5079c();
            }
        }
        try {
            getApplicationContext().unbindService(this.f11069ag);
            mo7083i().setBinding(false);
            getApplicationContext().stopService(new Intent(this, DiagnoseService.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ReportProduceTool.m5233a().f15648k = TextUtils.isEmpty(DiagnoseInfo.getInstance().getVin()) ? DiagnoseConstants.VIN_CODE : DiagnoseInfo.getInstance().getVin();
        ReportProduceTool.m5233a().f15649l = DiagnoseConstants.DIAG_ODO_DATA;
        ReportProduceTool.m5233a().f15652o = DiagnoseInfo.getInstance().getModel();
        ReportProduceTool.m5233a().f15653p = DiagnoseInfo.getInstance().getYear();
        DiagnoseUtils.m5086a().m5076f();
        try {
            if (LangManager.m9466b().equalsIgnoreCase("CN") && f11014ba && !DiagnoseConstants.DIAGNOSE_LIB_PATH.contains("DEMO") && !DiagnoseConstants.DIAGNOSE_LIB_PATH.contains("EOBD2") && !DiagnoseConstants.DIAGNOSE_LIB_PATH.contains("HD_OBD")) {
                HashMap<String, String> m4926a = AppUsageNumRecord.m4926a();
                int i = 10;
                try {
                    i = Integer.valueOf(m4926a.get("未注册登录剩余使用次数")).intValue();
                } catch (NumberFormatException e3) {
                    NLog.m9455a(e3);
                }
                if (i > 0) {
                    m4926a.put("未注册登录剩余使用次数", String.valueOf(i - 1));
                    AppUsageNumRecord.m4924a(m4926a);
                }
            }
        } catch (Exception e4) {
            Log.e("Sanda", "diag error[20151102]" + e4.toString());
            e4.printStackTrace();
        }
        f11014ba = false;
        DiagnoseConstants.ResetAllDiagnoseConstantsData();
        DiagnoseConstants.CurrentDEVICE_DISTRICT = this.f11086ax.m9584b("current_device_district", "0");
        C1947h.f10558j = null;
        MainActivity.m7896a(false);
        m7645c(false);
        DeviceFactoryManager.m8305a().m8297a(false);
        DeviceFactoryManager.m8305a().f9902b = false;
        DiagnoseInfo.getInstance().clear();
        BaseDialog baseDialog2 = this.f11106bc;
        if (baseDialog2 != null) {
            baseDialog2.dismiss();
        }
        OnLineProgrammingDialog onLineProgrammingDialog = this.f11112bi;
        if (onLineProgrammingDialog != null) {
            onLineProgrammingDialog.dismiss();
        }
        View$OnClickListenerC2884z view$OnClickListenerC2884z = this.f11111bh;
        if (view$OnClickListenerC2884z != null) {
            view$OnClickListenerC2884z.dismiss();
        }
        MessageBoxDialog messageBoxDialog = this.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog.m7052a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7099a(int i, byte[] bArr) {
        Message obtain = Message.obtain((Handler) null, 29);
        obtain.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putInt(VastExtensionXmlManager.TYPE, i);
        bundle.putByteArray("cmd", bArr);
        obtain.setData(bundle);
        m7692a(obtain);
    }

    /* renamed from: a */
    public final synchronized void m7692a(Message message2) {
        if (this.f11067ae != null) {
            try {
                this.f11067ae.send(message2);
                return;
            } catch (DeadObjectException unused) {
                NLog.m9451c("Sanda", "android.os.DeadObjectException");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f11095bG = true;
        m7604v();
        m7606u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m7604v() {
        if (C2744aa.m5166c() && !C1947h.f10551c) {
            m7602w();
            C1947h.f10552d = false;
        }
        MessageDialog messageDialog = this.f11081as;
        if (messageDialog == null || !messageDialog.isShowing()) {
            MessageDialog messageDialog2 = this.f11081as;
            if (messageDialog2 == null) {
                this.f11081as = new MessageDialog(this.f11019H);
                this.f11081as.setCancelable(false);
                String string = getString(R.string.connector_disconnect_tips_message);
                if (this.f11095bG) {
                    string = getString(R.string.toast_diagnoseservice_error);
                    this.f11095bG = false;
                }
                this.f11081as.m4719a(17039370, true, new View$OnClickListenerC2040aa(this));
                this.f11081as.m4715c(string);
                this.f11081as.show();
            } else if (messageDialog2.isShowing()) {
            } else {
                this.f11081as.setCancelable(false);
                this.f11081as.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7632f(boolean z) {
        if (!this.f11085aw) {
            this.f11085aw = true;
        }
        MessageDialog messageDialog = this.f11081as;
        if (messageDialog != null && messageDialog.isShowing()) {
            this.f11081as.dismiss();
        }
        this.f11081as = null;
        this.f11081as = new MessageDialog(this.f11019H);
        this.f11081as.m4710i();
        this.f11081as.setCancelable(false);
        this.f11081as.m4714e(R.string.exit_hint);
        this.f11081as.m4719a(17039370, true, new View$OnClickListenerC2041ab(this));
        this.f11081as.show();
        if (z) {
            SoundPool soundPool = this.f11096bH;
            if (soundPool == null) {
                this.f11096bH = new SoundPool(3, 1, 5);
                this.f11097bI = this.f11096bH.load(this, R.raw.warning, 0);
                this.f11096bH.setOnLoadCompleteListener(new C2042ac(this));
                return;
            }
            int i = this.f11098bJ;
            if (i > 0) {
                soundPool.pause(i);
            }
            this.f11098bJ = this.f11096bH.play(this.f11097bI, 1.0f, 1.0f, 0, -1, 1.0f);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            unregisterReceiver(this.f11099bK);
            m7606u();
            DiagnoseConstants.driviceConnStatus = false;
            DeviceFactoryManager.m8305a().m8283d(this.f11019H);
            if (this.f11087ay != null) {
                this.f11087ay.cancel();
            }
            super.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DealDiagMessageHandler.m8673a().f9428d = null;
        try {
            if (this.f11096bH != null) {
                this.f11096bH.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        CarIcon carIcon = (CarIcon) adapterView.getItemAtPosition(i);
        String str2 = carIcon.f15790n;
        String str3 = carIcon.f15778b;
        List<CarVersion> m4954d = this.f11055aS.m4954d(carIcon.f15790n, carIcon.f15778b);
        VinScanSelectVehieclesDialog vinScanSelectVehieclesDialog = this.f11109bf;
        if (vinScanSelectVehieclesDialog != null && vinScanSelectVehieclesDialog.isShowing()) {
            this.f11109bf.dismiss();
        }
        if (m4954d != null && !m4954d.isEmpty() && carIcon != null && carIcon.f15787k.booleanValue()) {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                str = carIcon.m5038a(this.f11019H);
            } else {
                str = carIcon.f15779c;
            }
            this.f11056aT = m7666a(m4954d);
            Collections.sort(this.f11056aT, new C2010b());
            PathUtils pathUtils = new PathUtils(this.f11019H);
            String m4864a = pathUtils.m4864a(str2, str3, this.f11056aT.get(0).getVersion());
            String language = this.f11056aT.get(0).getLanguage();
            Intent intent = new Intent();
            intent.setAction("VIN_START_DIAG");
            intent.putExtra("path", m4864a);
            intent.putExtra("language", language);
            intent.putExtra("serialNo", str2);
            intent.putExtra("carName", str);
            intent.putExtra("softPackageid", str3);
            intent.putExtra("softVersion", this.f11056aT.get(0).getVersion());
            intent.putExtra("softLan", LangManager.m9466b());
            this.f11019H.sendBroadcast(intent);
            String m4859b = pathUtils.m4859b(str2, str3, this.f11056aT.get(0).getVersion());
            FileUtils.m5012a(m4859b + File.separator + "APPDATA.INI", "SOFT_NAME", "MAKE", str3);
            return;
        }
        if (str3.equalsIgnoreCase("BENZ")) {
            str3 = "MERCEDES";
        }
        m7620n();
        LoadDialog.m4681b(this.f11019H);
        C2744aa.m5165c((Activity) this, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity$b */
    /* loaded from: classes.dex */
    public class C2010b implements Comparator<CarVersionInfo> {
        C2010b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(CarVersionInfo carVersionInfo, CarVersionInfo carVersionInfo2) {
            return Double.parseDouble(carVersionInfo2.getVersion().replace("V", "")) > Double.parseDouble(carVersionInfo.getVersion().replace("V", "")) ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7668a(String str, String str2, String str3, boolean z) {
        if (str.equalsIgnoreCase("Demo") || str.equalsIgnoreCase("演示程序") || str.equalsIgnoreCase("演示程式") || "HD_DEMO".equals(this.f11058aV)) {
            if (PreferencesManager.m9595a(this.f11019H).m9583b("tryFlag", false) && !C1947h.f10551c) {
                PreferencesManager.m9595a(this.f11019H).m9589a("diagStartTime", Long.valueOf(System.currentTimeMillis()).longValue());
                C1947h.f10552d = true;
            }
            if (mo7083i().getDiagnoseStatue() >= 2) {
                if (DiagnoseConstants.DIAG_INPUT_TYPE.equals("2")) {
                    m7620n();
                } else {
                    C2047ah c2047ah = new C2047ah(this, str2, str3);
                    MessageDialog messageDialog = new MessageDialog((Context) this, (int) R.string.dialog_title_default, (int) R.string.if_connect_bluetooth_message, false, (byte) 0);
                    messageDialog.m4719a(R.string.if_connect_bluetooth_left_btn, true, new View$OnClickListenerC2850ci(c2047ah));
                    messageDialog.m4717b(R.string.if_connect_bluetooth_right_btn, true, new View$OnClickListenerC2851cj(c2047ah));
                    messageDialog.show();
                    return;
                }
            }
        } else if (z) {
            mo7088b(str2, str3);
            return;
        }
        mo7094a(str2, str3);
    }

    /* renamed from: a */
    private static ArrayList<CarVersionInfo> m7666a(List<CarVersion> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<CarVersionInfo> arrayList = new ArrayList<>();
        for (CarVersion carVersion : list) {
            if (!C2787z.m4821a(carVersion.f15827c)) {
                CarVersionInfo carVersionInfo = new CarVersionInfo();
                carVersionInfo.setVersion(carVersion.f15828d);
                carVersionInfo.setLanguage(carVersion.f15830f);
                arrayList.add(carVersionInfo);
            }
        }
        return arrayList;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7097a(OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter) {
        this.f11073ak = onDiagnoseDataUpdateListenter;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo7094a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            android.content.Context r0 = r7.f11019H
            com.cnlaunch.d.a.j r0 = com.cnlaunch.p120d.p121a.PreferencesManager.m9595a(r0)
            java.lang.String r1 = "tryFlag"
            r2 = 0
            boolean r0 = r0.m9583b(r1, r2)
            r1 = 1
            if (r0 == 0) goto L6c
            boolean r0 = com.cnlaunch.x431pro.p210a.C1947h.f10551c
            if (r0 != 0) goto L6c
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            r7.f11075am = r0
            java.lang.Long r0 = r7.f11075am
            long r3 = r0.longValue()
            android.content.Context r0 = r7.f11019H
            com.cnlaunch.d.a.j r0 = com.cnlaunch.p120d.p121a.PreferencesManager.m9595a(r0)
            java.lang.String r5 = "tryFlagStartTime"
            long r5 = r0.m9586b(r5)
            long r3 = r3 - r5
            android.content.Context r0 = r7.f11019H
            com.cnlaunch.d.a.j r0 = com.cnlaunch.p120d.p121a.PreferencesManager.m9595a(r0)
            java.lang.String r5 = "totalDiagTime"
            long r5 = r0.m9586b(r5)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L55
            android.content.Context r0 = r7.f11019H
            com.cnlaunch.d.a.j r0 = com.cnlaunch.p120d.p121a.PreferencesManager.m9595a(r0)
            java.lang.String r3 = "diagStartTime"
            java.lang.Long r4 = r7.f11075am
            long r4 = r4.longValue()
            r0.m9589a(r3, r4)
            com.cnlaunch.x431pro.p210a.C1947h.f10552d = r1
            goto L6c
        L55:
            android.content.Context r0 = r7.f11019H
            android.content.res.Resources r3 = r7.getResources()
            r4 = 2131692441(0x7f0f0b99, float:1.9013982E38)
            java.lang.String r3 = r3.getString(r4)
            com.cnlaunch.p120d.p130d.NToast.m9446b(r0, r3)
            com.cnlaunch.x431pro.p210a.C1947h.f10552d = r2
            r7.finish()
            r0 = 0
            goto L6d
        L6c:
            r0 = 1
        L6d:
            if (r0 == 0) goto Lc3
            com.cnlaunch.diagnosemodule.utils.DiagnoseConstants.DIAGNOSE_LIB_PATH = r8
            com.cnlaunch.diagnosemodule.utils.DiagnoseConstants.DIAGNOSE_LANGUAGE = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = com.cnlaunch.x431pro.utils.PathUtils.m4871a()
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = java.io.File.separator
            r9.append(r8)
            java.lang.String r8 = "APPDATA.INI"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "SOFT_NAME"
            java.lang.String r0 = "MAKE"
            com.cnlaunch.x431pro.module.d.b.d r3 = r7.mo7083i()
            java.lang.String r3 = r3.getSoftPackageid()
            com.cnlaunch.x431pro.utils.p285e.FileUtils.m5012a(r8, r9, r0, r3)
            com.cnlaunch.l.a.a r8 = r7.f11065ac
            if (r8 == 0) goto Lb2
            boolean r8 = r8.f9521c
            if (r8 != 0) goto Lb2
            com.cnlaunch.l.a.a r8 = r7.f11065ac
            java.lang.String r9 = "com.cnlaunch.Service.DIAGBASESERVICE"
            java.lang.String r0 = "com.cnlaunch.DiagBaseService"
            java.lang.String r3 = "com.cnlaunch.DiagBaseService.DiagBaseService"
            r8.m8633a(r9, r0, r3)
        Lb2:
            com.cnlaunch.x431pro.module.d.b.d r8 = r7.mo7083i()
            int r8 = r8.getDiagnoseStatue()
            if (r8 != 0) goto Lc0
            r7.m7629h(r1)
            return
        Lc0:
            r7.m7629h(r2)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.mo7094a(java.lang.String, java.lang.String):void");
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: h */
    public final void mo7084h() {
        this.f11073ak = null;
        this.f11072aj = null;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnKeyDownListenter onKeyDownListenter = this.f11072aj;
        if (onKeyDownListenter == null || !onKeyDownListenter.onKeyDown(i, keyEvent)) {
            if (i != 4 || keyEvent.getAction() != 0 || !MainActivity.m7895b() || getFragmentManager().getBackStackEntryCount() != 0) {
                return super.onKeyDown(i, keyEvent);
            }
            MessageDialog messageDialog = this.f11100bL;
            if (messageDialog == null || !messageDialog.isShowing()) {
                this.f11100bL = new MessageDialog(this.f11019H, (int) R.string.dialog_remotediag_handler_title, (int) R.string.dialog_remotediag_handler_MSG_ExitTip, false, (byte) 0);
                this.f11100bL.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2051al(this));
                this.f11100bL.m4717b(R.string.btn_canlce, true, null);
                this.f11100bL.show();
            }
            return true;
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7093a(String str, String str2, int i) {
        if (str == null && str2 == null) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.replyTo = this.f11026P;
            m7692a(obtain);
            return;
        }
        Message obtain2 = Message.obtain((Handler) null, i);
        obtain2.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putString("cmd", str2);
        obtain2.setData(bundle);
        m7692a(obtain2);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7090a(String str, ArrayList<String> arrayList) {
        Message obtain = Message.obtain((Handler) null, 15);
        obtain.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putStringArrayList("cmd", arrayList);
        obtain.setData(bundle);
        m7692a(obtain);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: b */
    public final void mo7088b(String str, String str2) {
        DiagnoseConstants.DIAGNOSE_LIB_PATH = str;
        DiagnoseConstants.DIAGNOSE_LANGUAGE = str2;
        if (MineActivity.f13541n) {
            MessageDialog messageDialog = new MessageDialog((Context) this, (int) R.string.dialog_title_default, (int) R.string.msg_forbid_diagnose_with_fireware_repair, false, (byte) 0);
            messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2053an(this));
            messageDialog.show();
            if (MainActivity.m7895b()) {
                DiagnoseUtils.m5086a().m5084a(this.f11130n);
                return;
            } else if (MainActivity.m7881d()) {
                DiagnoseUtils.m5086a().m5078d();
                return;
            } else {
                return;
            }
        }
        if (DiagnoseConstants.driviceConnStatus) {
            IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
            if (iPhysics == null) {
                this.f11103bO.sendMessage(this.f11103bO.obtainMessage(20502, 0, 0));
                return;
            }
            String deviceName = iPhysics.getDeviceName();
            String m9591a = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
            int i = DeviceFactoryManager.m8305a().f9903c;
            if ((i == 0 && iPhysics != null && deviceName != null && deviceName.equals(m9591a)) || ((i == 1 && DPULinkSettingsInformation.m8314a().m8310b(m9591a)) || (i == 2 && PreferencesManager.m9595a((Context) this).m9583b("link_mode_serialport_switch", false)))) {
                String str3 = "";
                if (i == 0) {
                    str3 = String.format("%1$s: %2$s......", getResources().getString(R.string.bluetooth_connected_state_check_message), PreferencesManager.m9595a((Context) this).m9591a("serialNo"));
                } else if (i == 1) {
                    str3 = String.format("%1$s: %2$s......", getResources().getString(R.string.wifi_connected_state_check_message), PreferencesManager.m9595a((Context) this).m9591a("serialNo"));
                } else if (i == 2) {
                    str3 = String.format("%1$s: %2$s......", getResources().getString(R.string.serialport_connected_state_check_message), PreferencesManager.m9595a((Context) this).m9591a("serialNo"));
                }
                this.f11078ap.m7059a(str3);
                this.f11078ap.show();
                m7627i(0);
                return;
            }
            m7724A();
        }
        String m9591a2 = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
        if (Tools.m8096c(this.f11019H, m9591a2)) {
            if (Tools.m8113a(this.f11019H) && !DPULinkSettingsInformation.m8314a().m8310b(m9591a2)) {
                DPULinkSettingsInformation.m8314a().m8311a(m9591a2, true, 1, null);
                DPULinkSettingsInformation.m8314a().m8312a(m9591a2, false);
            } else {
                int m8296a = DeviceFactoryManager.m8305a().m8296a(false, this.f11019H, m9591a2);
                boolean m8313a = DPULinkSettingsInformation.m8314a().m8313a(m9591a2);
                if (m8296a != 3 && m8296a != 1 && !m8313a) {
                    MessageDialog messageDialog2 = new MessageDialog((Context) this, getResources().getString(R.string.dialog_title_default), String.format(getResources().getString(R.string.text_link_mode_wifi_bluetooth_select_tips), m9591a2, getResources().getString(R.string.text_dpu_link_manager)), false, (byte) 0);
                    messageDialog2.m4719a(R.string.text_dpu_link_manager, true, new View$OnClickListenerC2054ao(this));
                    messageDialog2.m4717b(R.string.text_link_mode_bluetooth_switch, true, new View$OnClickListenerC2055ap(this, m9591a2));
                    messageDialog2.show();
                    return;
                }
            }
        }
        IPhysics m8301a = DeviceFactoryManager.m8305a().m8301a(this.f11019H, false, (String) null);
        int i2 = DeviceFactoryManager.m8305a().f9903c;
        if (i2 != 0) {
            if (i2 == 3) {
                this.f11078ap.m7059a(String.format("%1$s: %2$s......", getResources().getString(R.string.connect_dpu_device_with_usb_tip_message), PreferencesManager.m9595a(this.f11019H).m9591a("serialNo")));
                return;
            } else if (i2 == 1) {
                this.f11078ap.m7059a(String.format("%1$s: %2$s......", getResources().getString(R.string.connect_dpu_device_with_wifi_tip_message), PreferencesManager.m9595a(this.f11019H).m9591a("serialNo")));
                this.f11078ap.show();
                return;
            } else if (i2 == 2) {
                this.f11078ap.m7059a(String.format("%1$s: %2$s......", getResources().getString(R.string.connect_dpu_device_with_serialport_tip_message), PreferencesManager.m9595a(this.f11019H).m9591a("serialNo")));
                this.f11078ap.show();
                return;
            } else {
                return;
            }
        }
        String m9591a3 = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
        if (m8301a.getState() == 3) {
            if (!(Tools.m8112a(this.f11019H, m9591a3) && !Tools.m8099b(this.f11019H, m9591a3))) {
                String format = String.format("%1$s: %2$s......", getResources().getString(R.string.bluetooth_connected_state_check_message), m9591a3);
                m7627i(1);
                this.f11078ap.m7059a(format);
                this.f11078ap.show();
                return;
            }
            m7722B();
            DeviceFactoryManager.m8305a().m8301a(this.f11019H, false, (String) null);
        }
        this.f11078ap.m7059a(String.format("%1$s: %2$s......", getResources().getString(R.string.connect_bluetooth_tip_message), m9591a3));
        this.f11078ap.show();
        m7622m();
    }

    /* renamed from: m */
    public final void m7622m() {
        DiagnoseUtils.m5081b(this);
        new C2056aq(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7098a(Fragment fragment, String str, boolean z) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, fragment);
        if (z) {
            beginTransaction.addToBackStack(str);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7096a(OnKeyDownListenter onKeyDownListenter) {
        this.f11072aj = onKeyDownListenter;
    }

    /* renamed from: a */
    public final void m7690a(DiagCarInfo diagCarInfo) {
        if (diagCarInfo == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 101);
        obtain.replyTo = this.f11026P;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("packageid", diagCarInfo.getPackageId());
            jSONObject.put("car_series", diagCarInfo.getCar_series());
            jSONObject.put("vin", diagCarInfo.getVin());
            jSONObject.put("year", diagCarInfo.getYear());
            jSONObject.put("soft_version", diagCarInfo.getSoftVersion());
            jSONObject.put("model", diagCarInfo.getModel());
            jSONObject.put("serialNo", diagCarInfo.getSerialNo());
            Bundle bundle = new Bundle();
            bundle.putString("vehicle_info", JsonUtils.specialRemoteVehicleInfoJsonUser(jSONObject));
            obtain.setData(bundle);
            m7692a(obtain);
            C1856n.m8125d("XEE", "发送车辆信息 vehicle_info=" + jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XEE", "getJsonConfig=" + e.toString());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: f */
    public final void mo7085f(int i) {
        if (MainActivity.m7881d()) {
            m7620n();
            m7598y();
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    m7620n();
                    m7598y();
                    return;
                } else if (this.f11085aw) {
                    return;
                } else {
                    if (mo7083i().getDiagnoseStatue() >= 2) {
                        this.f11085aw = true;
                    }
                    this.f11042aF = false;
                    this.f11035Y = new C2059at(this);
                    this.f11035Y.m4607b(this, R.string.dialog_title_default, R.string.dialog_diagnose_exit, false);
                    return;
                }
            }
            String string = getResources().getString(R.string.connector_reset_fail_process_tips);
            Context context = this.f11019H;
            boolean m4826a = SerialNoUtils.m4826a(context, PreferencesManager.m9595a(context).m9591a("serialNo"));
            if (m4826a) {
                if (C1856n.f10135a) {
                    C1856n.m8130a("DiagnoseActivity", "SerialNoUtils.isInBlackList currentSerialNo=" + PreferencesManager.m9595a(this.f11019H).m9591a("serialNo") + " state=" + m4826a);
                }
                string = getResources().getString(R.string.connector_in_back_list_process_tips);
            }
            new DialogC2058as(this, this).m4667b(getResources().getString(R.string.dialog_title_default), string);
        } else {
            mo7083i().setDiagnoseStatue(3);
            DiagnoseConstants.setDiagIdentity(mo7083i().getDiagnoseStatue());
            m7600x();
            m7692a(Message.obtain((Handler) null, 52));
            DiagnoseUIDataBusiness diagnoseUIDataBusiness = this.f11070ah;
            if (diagnoseUIDataBusiness != null) {
                diagnoseUIDataBusiness.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
            }
            MainActivity.m7887b(false);
            m7620n();
            this.f11101bM = true;
            m7598y();
            if (MainActivity.m7875f()) {
                Log.i("anqi", "send end intent");
                MainActivity.m7873g();
                SellerRemoteDiagInfo.getInstance().clear();
                this.f11019H.sendBroadcast(new Intent("SellerRequest_remotediag_end"));
            }
            SelectMessageDialog selectMessageDialog = this.f11035Y;
            if (selectMessageDialog == null || !selectMessageDialog.m4605c()) {
                return;
            }
            SelectMessageDialog selectMessageDialog2 = this.f11035Y;
            if (selectMessageDialog2.f16349d != null && selectMessageDialog2.f16349d.isShowing() && selectMessageDialog2.f16350e == R.string.dialog_diagnose_exit) {
                selectMessageDialog2.f16349d.dismiss();
            }
            this.f11035Y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m7602w() {
        if (PreferencesManager.m9595a(this.f11019H).m9583b("tryFlag", false) && C1947h.f10552d && !C1947h.f10551c) {
            this.f11076an = Long.valueOf(System.currentTimeMillis());
            this.f11077ao = Long.valueOf(this.f11076an.longValue() - PreferencesManager.m9595a(this.f11019H).m9586b("diagStartTime"));
            long m9586b = PreferencesManager.m9595a(this.f11019H).m9586b("totalDiagTime") + this.f11077ao.longValue();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
            PreferencesManager.m9595a(this.f11019H).m9589a("totalDiagTime", m9586b);
            PreferencesManager.m9595a(this.f11019H).m9588a("diagTime_date", format);
            ProductInformation productInformation = new ProductInformation(this.f11019H, mo7083i().getSerialNum());
            productInformation.f15700e = m9586b;
            productInformation.f15701f = format;
            productInformation.m5197b(mo7083i().getSerialNum());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: i */
    public final DiagnoseRunningInfo mo7083i() {
        if (f11012C == null) {
            f11012C = new DiagnoseRunningInfo();
            try {
                StringBuffer stringBuffer = new StringBuffer(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                if (stringBuffer.charAt(0) != 'V' && stringBuffer.charAt(0) != 'v') {
                    stringBuffer.insert(0, 'V');
                }
                f11012C.setAppVersion(stringBuffer.toString());
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return f11012C;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7095a(DiagnoseRunningInfo diagnoseRunningInfo) {
        if (diagnoseRunningInfo != null) {
            f11012C = diagnoseRunningInfo;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7091a(String str, String str2, String str3, String str4) {
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putString("ui_type", str2);
        bundle.putString("title", str3);
        bundle.putString(MessageDao.TABLENAME, str4);
        obtain.setData(bundle);
        m7692a(obtain);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: c */
    public final int mo7086c(String str) {
        this.f11066ad = str;
        mo7083i().setPrinting(true);
        LoadDialog.m4685a(this.f11019H, (int) R.string.printing_progress);
        m7739c(20013);
        return 0;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        BaseResponse baseResponse = null;
        switch (i) {
            case 20012:
                return new ReportAction(this.f11019H).m5221a(this.f11082at);
            case 20013:
                return Integer.valueOf(PrintDataUtils.m4934a(this.f11019H, this.f11066ad, mo7083i()));
            case 20014:
                return new RemoteDiagAction(this).m5362a(this.f11130n.getOtherUseID()).getData();
            case 20018:
                String str = PathUtils.m4871a() + DiagnoseConstants.DIAGNOSE_LIB_PATH + "query.log";
                Log.i("anqi", "write web result path = ".concat(String.valueOf(str)));
                try {
                    FileWriter fileWriter = new FileWriter(new File(str));
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
                    printWriter.println(this.f11107bd);
                    printWriter.close();
                    bufferedWriter.close();
                    fileWriter.close();
                    return 1;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            case 60001:
                DiagnoseAction diagnoseAction = new DiagnoseAction(this.f11019H);
                this.f11033W.setProgress(0);
                if (DiagnoseConstants.UI_Type_ShowDTC_HELP.equals(this.f11027Q)) {
                    NLog.m9452b("test", "RequestCode.DTCORFUNCTIONHELP_GETURL...UI_Type_ShowDTC_HELP");
                    baseResponse = diagnoseAction.m5374a(this.f11030T, this.f11029S, this.f11028R, this.f11031U);
                } else if (DiagnoseConstants.UI_Type_ShowFunction_HELP.equals(this.f11027Q)) {
                    NLog.m9452b("test", "RequestCode.DTCORFUNCTIONHELP_GETURL...UI_Type_ShowFunction_HELP");
                    baseResponse = diagnoseAction.m5367b(this.f11030T, this.f11029S, this.f11028R, this.f11031U);
                }
                NLog.m9452b("test", baseResponse.toString());
                this.f11033W.setProgress(5);
                return baseResponse;
            case 60002:
                try {
                    NLog.m9452b("test", "RequestCode.DTCORFUNCTIONHELP_DOWN.....UI_Type_ShowFunction_HELP");
                    HttpEntity entity = new DefaultHttpClient().execute(new HttpGet(this.f11122bs)).getEntity();
                    InputStream content = entity.getContent();
                    long contentLength = entity.getContentLength();
                    if (contentLength == -1) {
                        contentLength = entity.getContent().available();
                    }
                    File file = new File(PathUtils.m4858c(), "temp.pdf");
                    if (content != null) {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[10240];
                        int i2 = 0;
                        do {
                            int read = content.read(bArr);
                            if (read != -1) {
                                i2 += read;
                                fileOutputStream.write(bArr, 0, read);
                                this.f11033W.setProgress(((int) ((i2 * 95) / contentLength)) + 5);
                            } else {
                                content.close();
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                NLog.m9452b("test", "download over...........");
                                return file.getAbsolutePath();
                            }
                        } while (!this.f11034X);
                        content.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return null;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (ClientProtocolException e3) {
                    e3.printStackTrace();
                }
                return null;
            case 60003:
                File file2 = new File(PathUtils.m4871a() + DiagnoseConstants.DIAGNOSE_LIB_PATH + "query.log");
                if (file2.exists()) {
                    file2.delete();
                }
                return new DiagnoseAction(this.f11019H).m5376a(this.f11120bq, this.f11121br);
            case 60004:
                DiagnoseAction diagnoseAction2 = new DiagnoseAction(this.f11019H);
                if (this.f11022L.equals(DiagnoseConstants.FEEDBACK_PARALLEL_SUB_MENU)) {
                    return diagnoseAction2.m5375a(this.f11114bk, mo7083i().getSerialNum(), "0");
                }
                if (this.f11022L.equals(DiagnoseConstants.FEEDBACK_SELECT_FILEDIALOG)) {
                    return diagnoseAction2.m5368b(this.f11114bk, mo7083i().getSerialNum(), "0");
                }
                return null;
            case 60005:
                DiagnoseAction diagnoseAction3 = new DiagnoseAction(this.f11019H);
                try {
                    if (this.f11022L.equals(DiagnoseConstants.FEEDBACK_CURRENT_MENU_PATH)) {
                        baseResponse = diagnoseAction3.m5377a(mo7083i().getSerialNum(), this.f11116bm);
                    } else if (this.f11022L.equals(DiagnoseConstants.FEEDBACK_SPECIADATASTREAM)) {
                        baseResponse = diagnoseAction3.m5370b(mo7083i().getSerialNum(), this.f11116bm);
                    }
                } catch (FileNotFoundException e4) {
                    e4.printStackTrace();
                }
                return baseResponse;
            case 60008:
                try {
                    return new DiagnoseAction(this.f11019H).m5369b(this.f11128by, this.f11127bx);
                } catch (FileNotFoundException e5) {
                    e5.printStackTrace();
                    return null;
                }
            case 60009:
                return new DiagnoseAction(this.f11019H).m5380a(mo7083i().getSerialNum(), this.f11124bu.get(this.f11125bv));
            case 600015:
                DiagnoseAction diagnoseAction4 = new DiagnoseAction(this.f11019H);
                String serialNum = mo7083i().getSerialNum();
                String softPackageid = mo7083i().getSoftPackageid();
                if (mo7083i().getDiagnoseStatue() == 1 && DiagnoseUtils.m5086a().m5077e() != null) {
                    serialNum = PreferencesManager.m9595a(this.f11019H).m9591a("serialNo");
                    softPackageid = DiagnoseUtils.m5086a().m5077e().getPackageId();
                }
                if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE)) {
                    return diagnoseAction4.m5378a(serialNum, this.f11129bz.get(this.f11093bE));
                }
                if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox)) {
                    return diagnoseAction4.m5371b(serialNum, this.f11129bz.get(this.f11093bE));
                }
                if (this.f11123bt.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX)) {
                    return diagnoseAction4.m5372a(serialNum, softPackageid, this.f11129bz);
                }
                if (this.f11123bt.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
                    return diagnoseAction4.m5372a(serialNum, softPackageid, m7608t().getOnlineFaultCodeList());
                }
                return null;
            case 600016:
                return new DiagnoseAction(this.f11019H).m5379a(mo7083i().getSerialNum(), this.f11094bF);
            case 600028:
                new DiagnoseAction(this.f11019H).m5381a(mo7083i().getSoftPackageid());
                return null;
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i != 20018) {
            switch (i) {
                case 20012:
                    if (((UpLoadReportResponse) obj).getCode() != 0) {
                        FixedThreadPool.m4928a().m4927a(new RunnableC2061av(this));
                        return;
                    }
                    return;
                case 20013:
                    OnKeyDownListenter onKeyDownListenter = this.f11072aj;
                    if (onKeyDownListenter != null) {
                        onKeyDownListenter.mo6838i_();
                    }
                    mo7083i().setPrinting(false);
                    LoadDialog.m4681b(this.f11019H);
                    Integer num = (Integer) obj;
                    NetPOSPrinterUtil.m9439a(this, num.intValue());
                    if (num.intValue() == 4095) {
                        if (PreferencesManager.m9595a(getApplicationContext()).m9583b(C1947h.f10555g, false)) {
                            new PrinterFailrueDialog(this.f11019H).show();
                            return;
                        } else {
                            NToast.m9447b(this, (int) R.string.print_connect_printer);
                            return;
                        }
                    }
                    return;
                case 20014:
                    RemoteDiagRunningInfo remoteDiagRunningInfo = this.f11130n;
                    if (remoteDiagRunningInfo != null) {
                        RemoteServiceInfoData remoteServiceInfoData = (RemoteServiceInfoData) obj;
                        remoteDiagRunningInfo.setService_ip(remoteServiceInfoData.getIp());
                        this.f11130n.setService_port(remoteServiceInfoData.getPort());
                        this.f11130n.setService_domain(remoteServiceInfoData.getDomain());
                        if (mo7083i().isBinding()) {
                            return;
                        }
                        m7629h(1);
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case 60001:
                            if (obj != null) {
                                GetHelpDocInfo getHelpDocResult = ((GetHelpDocResponse) obj).getGetHelpDocResult();
                                int parseInt = Integer.parseInt(getHelpDocResult.getCode());
                                if (parseInt == 0) {
                                    String url = getHelpDocResult.getUrl();
                                    Log.i("test", "url=".concat(String.valueOf(url)));
                                    this.f11122bs = url;
                                    m7739c(60002);
                                    return;
                                } else if (parseInt == 405) {
                                    this.f11032V.dismiss();
                                    mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                                    NToast.m9450a(this, (int) R.string.onlineprograming_tip_filenull_downfail);
                                    return;
                                } else {
                                    this.f11032V.dismiss();
                                    NToast.m9450a(this, (int) R.string.load_data_failed);
                                    mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                                    return;
                                }
                            }
                            this.f11032V.dismiss();
                            NToast.m9450a(this, (int) R.string.load_data_failed);
                            mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                            return;
                        case 60002:
                            this.f11032V.dismiss();
                            if (obj != null) {
                                String str = (String) obj;
                                if (!"".equals(str)) {
                                    Uri fromFile = Uri.fromFile(new File(str));
                                    Bundle bundle = new Bundle();
                                    bundle.putString("uri_name", fromFile.toString());
                                    OnlineHelpPDFFragment onlineHelpPDFFragment = new OnlineHelpPDFFragment();
                                    onlineHelpPDFFragment.setArguments(bundle);
                                    mo7098a((Fragment) onlineHelpPDFFragment, (String) null, true);
                                    return;
                                }
                                NToast.m9450a(this, (int) R.string.load_data_failed);
                                mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                                return;
                            }
                            NToast.m9450a(this, (int) R.string.load_data_failed);
                            mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                            return;
                        case 60003:
                            String str2 = (String) obj;
                            Log.i("anqi", "webquery success result=".concat(String.valueOf(str2)));
                            m7739c(20018);
                            this.f11107bd = str2;
                            return;
                        case 60004:
                            if (obj != null) {
                                GetQueryWebResponse getQueryWebResponse = (GetQueryWebResponse) obj;
                                int code = getQueryWebResponse.getCode();
                                if (code != 200) {
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, 2, (byte) (code / 255), (byte) (code % 255)});
                                    return;
                                }
                                if (this.f11115bl.isEmpty()) {
                                    this.f11115bl = "queryWebRet.Bin";
                                }
                                if (m7646c(getQueryWebResponse.getMessage(), this.f11115bl) == 1) {
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 5});
                                    return;
                                }
                                String str3 = this.f11115bl;
                                int length = str3.length();
                                byte[] bArr = new byte[length + 5];
                                bArr[0] = 0;
                                bArr[3] = 1;
                                int i2 = length + 2;
                                bArr[1] = (byte) ((i2 >> 8) & 255);
                                bArr[2] = (byte) (i2 & 255);
                                bArr[bArr.length - 1] = 0;
                                try {
                                    System.arraycopy(str3.getBytes("UTF-8"), 0, bArr, 4, length);
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, bArr);
                                    return;
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 3});
                                    return;
                                }
                            }
                            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, 2, 0, 1});
                            return;
                        case 60005:
                            if (obj != null) {
                                int code2 = ((BaseResponse) obj).getCode();
                                if (code2 == 200) {
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
                                    return;
                                } else {
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, 2, (byte) ((code2 >> 8) & 255), (byte) (code2 & 255)});
                                    return;
                                }
                            }
                            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 2});
                            return;
                        case 60006:
                            if (obj != null) {
                                if (((Integer) obj).intValue() != 0) {
                                    m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 2, 3});
                                    return;
                                } else {
                                    m7739c(60005);
                                    return;
                                }
                            }
                            return;
                        default:
                            switch (i) {
                                case 60008:
                                    if (obj != null) {
                                        if (((BaseResponse) obj).getCode() == 0) {
                                            m7635e(true);
                                            return;
                                        } else {
                                            m7635e(false);
                                            return;
                                        }
                                    }
                                    m7635e(false);
                                    return;
                                case 60009:
                                    if (obj != null) {
                                        int code3 = ((BaseResponse) obj).getCode();
                                        if (code3 == 200) {
                                            m7639d(true);
                                            return;
                                        }
                                        m7639d(false);
                                        if (code3 == 771) {
                                            NToast.m9444c(this.f11019H, (int) R.string.onlineprograming_tip_cc_sn_not_match);
                                            return;
                                        } else if (code3 == 614 || code3 == 406) {
                                            NToast.m9444c(this.f11019H, (int) R.string.onlineprograming_tip_requse_count_over);
                                            return;
                                        } else if (code3 == 615) {
                                            NToast.m9444c(this.f11019H, (int) R.string.onlineprograming_tip_clock_count_over);
                                            return;
                                        } else if (code3 == 616) {
                                            NToast.m9444c(this.f11019H, (int) R.string.onlineprograming_tip_ctr_ip);
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    m7639d(false);
                                    return;
                                default:
                                    switch (i) {
                                        case 600015:
                                            m7641d(obj);
                                            return;
                                        case 600016:
                                            m7670a(obj);
                                            return;
                                        default:
                                            super.onSuccess(i, obj);
                                            return;
                                    }
                            }
                    }
            }
        }
        if (obj != null) {
            m7653b(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE, new byte[]{1, ByteBuffer.ZERO, 0});
        } else {
            m7653b(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE, new byte[]{0, ByteBuffer.ZERO, 0});
        }
        this.f11107bd = "";
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i != 20018) {
            switch (i) {
                case 20012:
                    FixedThreadPool.m4928a().m4927a(new RunnableC2062aw(this));
                    return;
                case 20013:
                    OnKeyDownListenter onKeyDownListenter = this.f11072aj;
                    if (onKeyDownListenter != null) {
                        onKeyDownListenter.mo6838i_();
                    }
                    mo7083i().setPrinting(false);
                    LoadDialog.m4681b(this.f11019H);
                    NToast.m9450a(this, (int) R.string.print_error_fail);
                    return;
                case 20014:
                    RemoteDiagHandler remoteDiagHandler = this.f11015D;
                    if (remoteDiagHandler != null) {
                        remoteDiagHandler.m7051a();
                    }
                    MessageDialog messageDialog = this.f11102bN;
                    if (messageDialog != null && messageDialog.isShowing()) {
                        this.f11102bN.dismiss();
                    }
                    this.f11102bN = new MessageDialog(this.f11019H, (int) R.string.remote_dialog_title, (int) R.string.fail_to_request_address, false, (byte) 0);
                    this.f11102bN.m4719a(R.string.retry, true, new View$OnClickListenerC2063ax(this));
                    this.f11102bN.m4717b(R.string.exitbtn, true, new View$OnClickListenerC2064ay(this));
                    this.f11102bN.show();
                    return;
                default:
                    switch (i) {
                        case 60001:
                            this.f11032V.dismiss();
                            mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                            return;
                        case 60002:
                            this.f11032V.dismiss();
                            mo7093a(DiagnoseConstants.FEEDBACK_SPT_FUNCTION_HELP, DiagnoseConstants.FEEDBACK_FAULTCODE_BACK, 3);
                            return;
                        case 60003:
                            Log.i("anqi", "webquery failure result=");
                            m7653b(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE, new byte[]{0, ByteBuffer.ZERO, 0});
                            this.f11107bd = "";
                            return;
                        case 60004:
                            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 0});
                            return;
                        case 60005:
                            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 0});
                            return;
                        case 60006:
                            m7653b(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 0});
                            return;
                        default:
                            switch (i) {
                                case 60008:
                                    m7635e(false);
                                    return;
                                case 60009:
                                    m7639d(false);
                                    return;
                                default:
                                    switch (i) {
                                        case 600015:
                                            m7641d((Object) null);
                                            return;
                                        case 600016:
                                            m7670a((Object) null);
                                            return;
                                        default:
                                            super.onFailure(i, i2, obj);
                                            return;
                                    }
                            }
                    }
            }
        }
        m7653b(DiagnoseConstants.UI_Type_QUERY_INFO_FROM_WEBSITE, new byte[]{0, ByteBuffer.ZERO, 0});
        this.f11107bd = "";
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: b */
    public final void mo7087b(boolean z) {
        Message obtain = Message.obtain((Handler) null, 13);
        obtain.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putBoolean("datastream_record", z);
        obtain.setData(bundle);
        m7692a(obtain);
    }

    /* renamed from: n */
    public final void m7620n() {
        try {
            if (this.f11078ap != null) {
                this.f11078ap.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainActivity.m7896a(false);
        m7645c(false);
        int i = DeviceFactoryManager.m8305a().f9903c;
        if ((i != 0 && i != 1 && i != 2) || (Tools.m8114a() && !Tools.m8101b())) {
            DiagnoseConstants.driviceConnStatus = false;
        }
        if (MineActivity.f13541n) {
            return;
        }
        DeviceFactoryManager.m8305a().m8293b();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: j */
    public final void mo7082j() {
        if (this.f11015D != null && mo7083i().getDiagnoseStatue() < 2) {
            this.f11015D.obtainMessage(106).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m7600x() {
        RemoteDiagHandler remoteDiagHandler = this.f11015D;
        if (remoteDiagHandler != null) {
            remoteDiagHandler.m7047b();
        }
        MainActivity.m7896a(false);
        m7737d(0);
        f11013J = false;
        MainActivity.m7896a(false);
        this.f10984t.setVisibility(0);
        this.f11017F.m4750c();
        this.f11016E.setVisibility(8);
        AutoVoiceHandler.f9188c = true;
        if (this.f11020I != null) {
            getFragmentManager().beginTransaction().remove(this.f11020I).commitAllowingStateLoss();
            this.f11020I = null;
        }
        DataStreamConfiguration.m7959a(this.f11019H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m7598y() {
        DiagnoseUtils.m5086a().m5076f();
        RemoteDiagHandler remoteDiagHandler = this.f11015D;
        if (remoteDiagHandler != null) {
            remoteDiagHandler.m7051a();
        }
        f11013J = false;
        m7606u();
        m7596z();
        f11012C = null;
        if (this.f11101bM && this.f11130n != null) {
            if (MainActivity.m7875f()) {
                RemoteDiagObserve.m7940a();
            }
            ChatRoom chatRoom = new ChatRoom(this.f11130n.getOtherUseID(), this.f11130n.getOtherUseName(), MessageParameters.EnumC4721a.single);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ChatRoom", chatRoom);
            Intent intent = new Intent("show_golo_chatroom");
            intent.putExtras(bundle);
            sendBroadcast(intent);
        }
        DealDiagMessageHandler.m8673a().f9430f.m8681c();
        this.f11130n = null;
        this.f11101bM = false;
        if (MainActivity.m7886c()) {
            ((MainActivity) getParent()).m7898a(CloudActivity.class, (Intent) null);
            MainActivity.m7878e();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: k */
    public final RemoteDiagRunningInfo mo7081k() {
        return this.f11130n;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7092a(String str, String str2, int i, int i2) {
        Message obtain = Message.obtain((Handler) null, i2);
        obtain.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putString("cmd", str2);
        bundle.putInt(Annotation.PAGE, i);
        obtain.setData(bundle);
        m7692a(obtain);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
        this.f11084av = onActivityResultListenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity$c */
    /* loaded from: classes.dex */
    public class C2011c extends TimerTask {
        C2011c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            DiagnoseActivity.m7672a(DiagnoseActivity.this, true);
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        InterfaceC2009a interfaceC2009a;
        if (i != 274 || (interfaceC2009a = this.f11108be) == null) {
            OnActivityResultListenter onActivityResultListenter = this.f11084av;
            if (onActivityResultListenter != null) {
                onActivityResultListenter.mo5996a(i, i2, intent);
            } else {
                super.onActivityResult(i, i2, intent);
            }
        } else if (i2 == -1) {
            interfaceC2009a.mo7041a();
            this.f11108be = null;
        } else {
            interfaceC2009a.mo7040b();
            this.f11108be = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m7660b(Bundle bundle) {
        ArrayList<CarVersionInfo> arrayList;
        if (bundle != null) {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                this.f11057aU = bundle.getString("carname_zh");
            } else {
                this.f11057aU = bundle.getString("carname");
            }
            this.f11059aW = bundle.getString("areaId");
            this.f11058aV = bundle.getString("softpackageid");
            this.f11060aX = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
            this.f11062aZ = 0;
            if (bundle.getString("vin_scan") != null) {
                this.f11045aI = bundle.getString("vin_scan");
                this.f11044aH = true;
            }
            if (bundle.getString("model") != null && "1".equals(bundle.getString("model"))) {
                DiagnoseConstants.DIAG_INPUT_TYPE = "1";
            } else if (bundle.getString("model") == null) {
                DiagnoseConstants.DIAG_INPUT_TYPE = "0";
            }
            if (mo7083i().getDiagnoseStatue() > 1) {
                this.f11056aT = m7666a(this.f11055aS.m4954d(this.f11060aX, this.f11058aV));
            } else {
                this.f11056aT = (ArrayList) bundle.getSerializable("verList");
            }
            ArrayList<CarVersionInfo> arrayList2 = this.f11056aT;
            if (arrayList2 != null) {
                Collections.sort(arrayList2, new C2010b());
                int i = this.f11062aZ;
                if (this.f11054aR == null || (arrayList = this.f11056aT) == null || this.f11060aX == null || i >= arrayList.size()) {
                    return;
                }
                String version = this.f11056aT.get(i).getVersion();
                String m4864a = this.f11054aR.m4864a(this.f11060aX, this.f11058aV, version);
                String str = this.f11054aR.m4859b(this.f11060aX, this.f11058aV, version) + File.separator + "APPDATA.INI";
                NLog.m9456a("yhx", "iniFileName=".concat(String.valueOf(str)));
                FileUtils.m5012a(str, "SOFT_NAME", "MAKE", this.f11058aV);
                if (m4864a == null || m4864a.length() == 0) {
                    MessageDialog messageDialog = new MessageDialog(this.f11019H, (int) R.string.dialog_title_default, (int) R.string.msg_get_vehicle_data_failed_with_connector_changed, false, (byte) 0);
                    messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2050ak(this));
                    messageDialog.show();
                    return;
                }
                try {
                    DiagnoseRunningInfo mo7083i = mo7083i();
                    mo7083i.setCarSoftName(this.f11057aU);
                    mo7083i.setSerialNum(this.f11060aX);
                    mo7083i.setSoftPackageid(this.f11058aV);
                    mo7083i.setAreaID(this.f11059aW);
                    mo7083i.setSoftVersion(this.f11056aT.get(i).getVersion());
                    mo7083i.setSoftLan(Locale.getDefault().getCountry());
                    if (this.f11044aH) {
                        mo7083i.setVin(this.f11045aI);
                    }
                    mo7095a(mo7083i);
                    NLog.m9456a(this.f10979o, "path=".concat(String.valueOf(m4864a)));
                    m7668a(this.f11057aU, m4864a, this.f11056aT.get(i).getLanguage(), true);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            C2744aa.m5165c((Activity) this, this.f11058aV);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: l */
    public final RemotePerformClick mo7080l() {
        if (this.f11064ab == null) {
            this.f11064ab = new RemotePerformClick();
        }
        return this.f11064ab;
    }

    /* renamed from: a */
    public static boolean m7694a(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback
    /* renamed from: a */
    public final void mo7089a(String str, byte[] bArr) {
        if (str == null && bArr == null) {
            Message obtain = Message.obtain((Handler) null, 24);
            obtain.replyTo = this.f11026P;
            m7692a(obtain);
            return;
        }
        Message obtain2 = Message.obtain((Handler) null, 24);
        obtain2.replyTo = this.f11026P;
        Bundle bundle = new Bundle();
        bundle.putString(VastExtensionXmlManager.TYPE, str);
        bundle.putByteArray("cmd", bArr);
        obtain2.setData(bundle);
        m7692a(obtain2);
    }

    /* renamed from: d */
    private void m7640d(String str) {
        Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(str);
        if (findFragmentByTag == null) {
            Fragment instantiate = Fragment.instantiate(this.f11019H, str);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.layout_fragment_contanier, instantiate, str);
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        Log.i("Sanda", "fragment!=null" + findFragmentByTag.isAdded());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m7596z() {
        m7640d(CarIconFragmentForAll.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public static void m7724A() {
        DiagnoseConstants.driviceConnStatus = false;
        DeviceFactoryManager.m8305a().m8288c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public static void m7722B() {
        DiagnoseConstants.driviceConnStatus = false;
        DeviceFactoryManager.m8305a().m8284d();
    }

    /* renamed from: c */
    public final void m7645c(boolean z) {
        if (this.f11024N != z) {
            this.f11024N = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public int m7720C() {
        int i = DeviceFactoryManager.m8305a().f9903c;
        if (i == 3) {
            DeviceFactoryManager.m8305a();
            if (DeviceFactoryManager.m8304a(this.f11019H)) {
                return 4;
            }
            return i;
        }
        return i;
    }

    /* renamed from: i */
    private void m7627i(int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a("DiagnoseActivity", "device Connected Check isRemoteConnected=".concat(String.valueOf(i)));
        }
        new C2069bc(this, i).start();
    }

    /* renamed from: h */
    private void m7629h(int i) {
        this.f11069ag = new ServiceConnectionC2052am(this, i);
        DataStreamConfiguration.m7959a(this.f11019H);
        if (!getApplicationContext().bindService(new Intent(this, DiagnoseService.class), this.f11069ag, 1)) {
            new DialogC2218z(this, this).m4667b(getResources().getString(R.string.dialog_title_default), getResources().getString(R.string.start_diag_service_fail_process_tips));
            return;
        }
        this.f11103bO.sendMessageDelayed(this.f11103bO.obtainMessage(20505, 1, 0), 1000L);
        if (i == 0) {
            DiagnoseProcessInfoUtil.getInstance().startRecordProcess();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7672a(DiagnoseActivity diagnoseActivity, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("OUTTIME", z);
        Message message2 = new Message();
        message2.setData(bundle);
        message2.what = 1;
        diagnoseActivity.f11103bO.sendMessage(message2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m7630g(DiagnoseActivity diagnoseActivity) {
        DeviceFactoryManager.m8305a().m8297a(true);
        int i = DeviceFactoryManager.m8305a().f9903c;
        IPhysics m8301a = DeviceFactoryManager.m8305a().m8301a(diagnoseActivity.f11019H, false, (String) null);
        Timer timer = new Timer();
        MessageDialog messageDialog = new MessageDialog(diagnoseActivity.f11019H, (int) R.string.connect_change_tip_message, i == 3 ? R.string.connect_change_bluetooth_to_usb_tip_message : R.string.connect_change_usb_to_bluetooth_tip_message, false, (byte) 0);
        messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2048ai(diagnoseActivity, i, m8301a, timer));
        messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2060au(diagnoseActivity));
        messageDialog.show();
        DeviceFactoryManager.m8305a().f9905e = messageDialog;
        timer.schedule(new C2070bd(diagnoseActivity, messageDialog), 60000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ void m7625j(DiagnoseActivity diagnoseActivity) {
        View$OnClickListenerC2884z view$OnClickListenerC2884z;
        if (diagnoseActivity.mo7083i().getDiagnoseStatue() != 1 || (view$OnClickListenerC2884z = diagnoseActivity.f11111bh) == null) {
            return;
        }
        view$OnClickListenerC2884z.dismiss();
        diagnoseActivity.f11111bh = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static /* synthetic */ void m7621m(DiagnoseActivity diagnoseActivity) {
        if (diagnoseActivity.f11087ay != null) {
            C2011c c2011c = diagnoseActivity.f11088az;
            if (c2011c != null) {
                c2011c.cancel();
            }
        } else {
            diagnoseActivity.f11087ay = new Timer();
        }
        diagnoseActivity.f11088az = new C2011c();
        diagnoseActivity.f11087ay.schedule(diagnoseActivity.f11088az, 120000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7676a(DiagnoseActivity diagnoseActivity, String str, String str2, ArrayList arrayList) {
        ArrayList<BasicSystemStatusBean> arrayList2 = new ArrayList<>();
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            BasicSystemStatusBean basicSystemStatusBean = (BasicSystemStatusBean) arrayList.get(i);
            arrayList2.add(basicSystemStatusBean);
            if (basicSystemStatusBean.isFaultCodeOnline()) {
                z = true;
            }
        }
        String str3 = "0";
        if (str.startsWith(DiagnoseConstants.UI_Type_ShowTransDiagInfo) && str2.equals(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT)) {
            str3 = str.substring(4);
            str = DiagnoseConstants.UI_Type_ShowTransDiagInfo;
        }
        if (!z) {
            diagnoseActivity.m7667a(str, str2, arrayList2, str3);
            return;
        }
        String str4 = str2 + str3;
        String m9584b = PreferencesManager.m9595a(diagnoseActivity.f11019H).m9584b("login_state", "0");
        if (!PreferencesManager.m9595a(diagnoseActivity.f11019H).m9583b("online_dtc_no_login", true) && !m9584b.equalsIgnoreCase("1")) {
            diagnoseActivity.m7695a(diagnoseActivity.f11019H, new C2075bi(diagnoseActivity, arrayList2, str4, str3));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600015);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, arrayList2);
        bundle.putString("data_type", str4);
        diagnoseActivity.m7693a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7675a(DiagnoseActivity diagnoseActivity, String str, ArrayList arrayList) {
        diagnoseActivity.f11022L = str;
        if (!PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("login_state").equalsIgnoreCase("1")) {
            diagnoseActivity.m7695a(diagnoseActivity.f11019H, new C2076bj(diagnoseActivity, arrayList));
            return;
        }
        BasicQueryWebSiteBean basicQueryWebSiteBean = (BasicQueryWebSiteBean) arrayList.get(0);
        diagnoseActivity.f11114bk = basicQueryWebSiteBean.getTitle();
        diagnoseActivity.f11115bl = basicQueryWebSiteBean.getValue();
        diagnoseActivity.m7739c(60004);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m7657b(DiagnoseActivity diagnoseActivity, String str, ArrayList arrayList) {
        diagnoseActivity.f11022L = str;
        diagnoseActivity.f11116bm = (BasicQueryArgToWebSiteBean) arrayList.get(0);
        BasicQueryArgToWebSiteBean basicQueryArgToWebSiteBean = diagnoseActivity.f11116bm;
        if (basicQueryArgToWebSiteBean == null || basicQueryArgToWebSiteBean.getQueryWebSiteBean().size() != 2) {
            diagnoseActivity.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 2, 0, 1});
        } else {
            diagnoseActivity.m7739c(60005);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m7650c(DiagnoseActivity diagnoseActivity, String str, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        String str2 = "";
        for (int i = 0; i < arrayList.size(); i++) {
            BasicSoftIDBean basicSoftIDBean = (BasicSoftIDBean) arrayList.get(i);
            if (basicSoftIDBean != null) {
                if (str.equals("96")) {
                    String softID = basicSoftIDBean.getSoftID();
                    if (!TextUtils.isEmpty(softID)) {
                        str2 = softID.substring(softID.length() - 2);
                        arrayList2.add(softID.substring(0, softID.length() - 2));
                    }
                } else {
                    arrayList2.add(basicSoftIDBean.getSoftID());
                }
            }
        }
        if (!PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("login_state").equalsIgnoreCase("1")) {
            diagnoseActivity.m7695a(diagnoseActivity.f11019H, new C2077bk(diagnoseActivity, arrayList, str));
            diagnoseActivity.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
            return;
        }
        View$OnClickListenerC2884z view$OnClickListenerC2884z = diagnoseActivity.f11111bh;
        if (view$OnClickListenerC2884z != null) {
            view$OnClickListenerC2884z.dismiss();
        }
        diagnoseActivity.f11111bh = new View$OnClickListenerC2884z(diagnoseActivity.f11019H, diagnoseActivity.mo7083i().getSerialNum(), diagnoseActivity.mo7083i().getSoftPackageid(), arrayList2);
        if (str.equals("96")) {
            diagnoseActivity.f11111bh.f16470a = str2;
        }
        diagnoseActivity.f11111bh.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m7642d(DiagnoseActivity diagnoseActivity, String str, ArrayList arrayList) {
        if (DiagnoseUtils.m5086a().m5082b()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add((BasicOnlineCodeLib) arrayList.get(i));
        }
        String m9591a = PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("login_state");
        if (PreferencesManager.m9595a(diagnoseActivity.f11019H).m9583b("online_dtc_no_login", true) && (str.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX) || str.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox))) {
            z = true;
        }
        if (!z && !m9591a.equalsIgnoreCase("1")) {
            diagnoseActivity.m7695a(diagnoseActivity.f11019H, new C2078bl(diagnoseActivity, arrayList2, str));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600015);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, arrayList2);
        bundle.putString("data_type", str);
        diagnoseActivity.m7693a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7674a(DiagnoseActivity diagnoseActivity, ArrayList arrayList) {
        if (DiagnoseUtils.m5086a().m5082b()) {
            return;
        }
        boolean z = false;
        BasicOnlineArithBean basicOnlineArithBean = (BasicOnlineArithBean) arrayList.get(0);
        String m9591a = PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("login_state");
        if (PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "CalcLine") && PreferencesManager.m9595a(diagnoseActivity.f11019H).m9583b("online_dtc_no_login", true)) {
            z = true;
        }
        if (!z && "0".equals(m9591a)) {
            diagnoseActivity.m7695a(diagnoseActivity.f11019H, new C2214v(diagnoseActivity, basicOnlineArithBean));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600016);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, basicOnlineArithBean);
        diagnoseActivity.m7693a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m7656b(DiagnoseActivity diagnoseActivity, ArrayList arrayList) {
        BasicHTMLDialogBean basicHTMLDialogBean = (BasicHTMLDialogBean) arrayList.get(0);
        MessageBoxDialog messageBoxDialog = diagnoseActivity.f11074al;
        if (messageBoxDialog != null) {
            messageBoxDialog.m7052a();
        }
        ShowHtmlDataFragment showHtmlDataFragment = new ShowHtmlDataFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, basicHTMLDialogBean);
        showHtmlDataFragment.setArguments(bundle);
        diagnoseActivity.mo7098a((Fragment) showHtmlDataFragment, (String) null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7673a(DiagnoseActivity diagnoseActivity, ArrayList arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (((BasicSystemStatusBean) arrayList.get(i)).isFaultCodeOnline()) {
                ArrayList<BasicFaultCodeBean> systemFaultCodeBean = ((BasicSystemStatusBean) arrayList.get(i)).getSystemFaultCodeBean();
                int size = ((BasicSystemStatusBean) arrayList.get(i)).getOnlineFaultCodeList().size();
                for (int i2 = 0; i2 < size; i2++) {
                    String codeID = ((BasicSystemStatusBean) arrayList.get(i)).getOnlineFaultCodeList().get(i2).getCodeID();
                    BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                    basicFaultCodeBean.setId(codeID);
                    basicFaultCodeBean.setTitle((codeID.substring(0, 2) + "," + codeID.substring(2, 4) + "," + codeID.substring(4, 6) + "," + codeID.substring(6, 8)) + C2744aa.m5167b(codeID.substring(4, 6), codeID.substring(6, 8)));
                    basicFaultCodeBean.setContext("CONSULT HANDBOOK");
                    systemFaultCodeBean.add(basicFaultCodeBean);
                }
            }
        }
        diagnoseActivity.m7667a(DiagnoseConstants.UI_Type_ShowTransDiagInfo, DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT, arrayList, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ void m7636e(DiagnoseActivity diagnoseActivity, String str, ArrayList arrayList) {
        if (str.equals(DiagnoseConstants.FEEDBACK_SPT_QUERY_INFO_FROM_WEBSITE) || str.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX)) {
            ArrayList<BasicFaultCodeBean> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String codeID = ((BasicOnlineCodeLib) arrayList.get(i)).getCodeID();
                BasicFaultCodeBean basicFaultCodeBean = new BasicFaultCodeBean();
                basicFaultCodeBean.setId(codeID);
                basicFaultCodeBean.setTitle((codeID.substring(0, 2) + "," + codeID.substring(2, 4) + "," + codeID.substring(4, 6) + "," + codeID.substring(6, 8)) + C2744aa.m5167b(codeID.substring(4, 6), codeID.substring(6, 8)));
                basicFaultCodeBean.setContext("CONSULT HANDBOOK");
                arrayList2.add(basicFaultCodeBean);
            }
            diagnoseActivity.f11113bj.onDiagnoseFaultCodeDataCallback(str, arrayList2, null);
        } else if (str.equals(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox)) {
            diagnoseActivity.m7654b((Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static /* synthetic */ void m7723A(DiagnoseActivity diagnoseActivity) {
        int i = diagnoseActivity.f11098bJ;
        if (i > 0) {
            diagnoseActivity.f11096bH.pause(i);
            diagnoseActivity.f11098bJ = 0;
        }
        MessageDialog messageDialog = diagnoseActivity.f11081as;
        if (messageDialog != null && messageDialog.isShowing()) {
            diagnoseActivity.f11081as.dismiss();
            diagnoseActivity.f11081as = null;
        }
        diagnoseActivity.f11085aw = false;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness = diagnoseActivity.f11070ah;
        if (diagnoseUIDataBusiness != null) {
            diagnoseUIDataBusiness.setbCanShowDialog(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: H */
    public static /* synthetic */ void m7714H(DiagnoseActivity diagnoseActivity) {
        DiagnoseUIDataBusiness diagnoseUIDataBusiness = diagnoseActivity.f11070ah;
        if (diagnoseUIDataBusiness != null) {
            diagnoseUIDataBusiness.closeAlertDialog(DiagnoseConstants.UI_TYPE_DIALOG, true);
        }
        if (diagnoseActivity.mo7083i().getDiagnoseStatue() != 1) {
            diagnoseActivity.m7604v();
            diagnoseActivity.m7606u();
            diagnoseActivity.m7620n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: S */
    public static /* synthetic */ void m7703S(DiagnoseActivity diagnoseActivity) {
        RemoteDiagRunningInfo remoteDiagRunningInfo = diagnoseActivity.f11130n;
        if (remoteDiagRunningInfo != null) {
            ChatMessage m190a = new ChatRoom(remoteDiagRunningInfo.getOtherUseID(), "", MessageParameters.EnumC4721a.single).m190a(10);
            m190a.m214a("text", (Object) diagnoseActivity.getString(R.string.canlce_remotediag));
            m190a.m214a("content", (Object) ExplainResult.STOP);
            new SendMessageTask().m256e(m190a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7678a(DiagnoseActivity diagnoseActivity, String str, String str2) {
        if (str == null || str.equals("")) {
            NLog.m9451c("weizewei", "activity diag path: ".concat(String.valueOf(str)));
            return;
        }
        String replaceAll = str.replaceAll("//", "/");
        diagnoseActivity.f11038aB = diagnoseActivity.mo7083i().getSoftPackageid().toUpperCase(Locale.getDefault());
        Bundle bundle = new Bundle();
        bundle.putString("serialNum", diagnoseActivity.mo7083i().getSerialNum());
        bundle.putString("appVer", diagnoseActivity.mo7083i().getAppVersion());
        bundle.putString("carName", diagnoseActivity.mo7083i().getSoftPackageid().toUpperCase(Locale.getDefault()));
        bundle.putString("softVer", diagnoseActivity.mo7083i().getSoftVersion());
        bundle.putString("softLan", diagnoseActivity.mo7083i().getSoftLan());
        String binVersion = diagnoseActivity.mo7083i().getBinVersion();
        if (TextUtils.isEmpty(binVersion)) {
            DeviceUtils.m8149a();
            binVersion = DeviceUtils.m8140d(diagnoseActivity.mo7083i().getSerialNum(), null);
            if (!TextUtils.isEmpty(binVersion)) {
                diagnoseActivity.mo7083i().setBinVersion(binVersion);
            }
        }
        NLog.m9456a(diagnoseActivity.f10979o, "downloadVersion=".concat(String.valueOf(binVersion)));
        bundle.putString("binVer", diagnoseActivity.mo7083i().getBinVersion());
        if (diagnoseActivity.f11044aH) {
            bundle.putString("vin_scan", diagnoseActivity.mo7083i().getVin());
        }
        boolean m9583b = PreferencesManager.m9595a(diagnoseActivity.f11019H).m9583b("diagnose_log_switch", false);
        bundle.putBoolean("diagnoseLogSwitch", m9583b);
        String m4850f = PathUtils.m4850f();
        bundle.putString("diagnoseLogPath", m4850f);
        bundle.putString("specificLogsPath", PathUtils.m4848h());
        NLog.m9452b("DiagnoseActivity", "diagnoseLogSwitch=" + m9583b + " diagnoseLogPath = " + m4850f);
        bundle.putString("Lib_path", replaceAll);
        bundle.putString("Lib_language", str2);
        bundle.putString("VehicleID", String.valueOf(diagnoseActivity.mo7083i().getVID()));
        bundle.putString("Diagnostic_path", PathUtils.m4842n());
        bundle.putInt("DATASTREAM_PAGE_COUNT", DiagnoseConstants.DATASTREAM_PAGE);
        bundle.putString("DiagInType", DiagnoseConstants.DIAG_INPUT_TYPE);
        bundle.putString("LicensePlate", DiagnoseConstants.LICENSEPLATE);
        bundle.putBoolean("EnableHistoryDiagnose", PreferencesManager.m9595a(diagnoseActivity.f11019H).m9583b("enable_history_diagnose", false));
        DiagnoseUtils m5086a = DiagnoseUtils.m5086a();
        Handler handler = diagnoseActivity.f11103bO;
        CloudDataManager.m5413a(m5086a.f15755a).m5414a();
        DiagnoseActivity diagnoseActivity2 = m5086a.f15755a;
        if (WebRemoteHandler.m5419a().f15486f && !MainActivity.m7881d()) {
            RemoteSocketControler.m8607a().m8593k();
            WebRemoteHandler.m5419a().m5417b();
            NToast.m9447b(diagnoseActivity2, (int) R.string.web_remote_waiting_stop);
        }
        String carSoftName = m5086a.f15755a.mo7083i().getCarSoftName();
        String upperCase = m5086a.f15755a.mo7083i().getSoftPackageid().toUpperCase(Locale.getDefault());
        NLog.m9452b("XEE", "packageid:" + upperCase + " carname:" + carSoftName);
        if (!"AUTOSEARCH".equalsIgnoreCase(upperCase)) {
            DiagnoseProcessInfoUtil.getInstance().startRecordProcess();
            FeedbackDiagControler.m8576a().f9582a = handler;
            m5086a.f15757c = new DiagCarInfo();
            m5086a.f15757c.setReport_type("X");
            if (MainActivity.m7895b() || MainActivity.m7881d()) {
                m5086a.m5079c();
                m5086a.f15757c = new DiagCarInfo();
                m5086a.f15757c.setReport_type("R");
            }
            if (MainActivity.m7881d()) {
                DiagnoseActivity diagnoseActivity3 = m5086a.f15755a;
                Message obtain = Message.obtain((Handler) null, 103);
                obtain.replyTo = diagnoseActivity3.f11026P;
                diagnoseActivity3.m7692a(obtain);
            }
            m5086a.f15757c.setPackageId(upperCase);
            m5086a.f15757c.setCar_series(carSoftName);
            m5086a.f15757c.setCarName(carSoftName);
            m5086a.f15757c.setLibPath(replaceAll);
            m5086a.f15757c.setPath(replaceAll);
            DiagnoseActivity diagnoseActivity4 = m5086a.f15755a;
            m5086a.f15757c.setApkVersion(C2744aa.m5130o(diagnoseActivity4));
            m5086a.f15757c.setCountry(DiagnoseConstants.DIAGNOSE_LANGUAGE);
            m5086a.f15757c.setSerialNo(PreferencesManager.m9595a((Context) diagnoseActivity4).m9591a("serialNo"));
            if (m5086a.f15755a != null) {
                m5086a.f15757c.setBin_ver(m5086a.f15755a.mo7083i().getBinVersion());
                m5086a.f15757c.setSoftVersion(m5086a.f15755a.mo7083i().getSoftVersion());
            } else {
                DeviceUtils.m8149a();
                String m8140d = DeviceUtils.m8140d(PreferencesManager.m9595a((Context) diagnoseActivity4).m9591a("serialNo"), null);
                NLog.m9452b("XEE", "downloadVersion:".concat(String.valueOf(m8140d)));
                if (!MyTools.m9636a(m8140d)) {
                    m5086a.f15757c.setBin_ver(m8140d);
                }
            }
            m5086a.f15757c.setDiag_start_time(System.currentTimeMillis() / 1000);
            m5086a.f15757c.setLanguage(C2744aa.m5131o());
            m5086a.f15757c.setModel(DiagnoseConstants.MARKET_CAR_MODEL);
            m5086a.f15757c.setYear(DiagnoseConstants.RECORD_YEAR);
            m5086a.f15757c.setDisplacement(DiagnoseConstants.RECORD_DISPLACEMENT);
            m5086a.f15757c.setPlate(DiagnoseConstants.LICENSEPLATE);
            m5086a.f15757c.setPlate_url(PreferencesManager.m9595a((Context) diagnoseActivity4).m9591a(DiagnoseConstants.LICENSEPLATE));
            m5086a.f15757c.setVin(DiagnoseConstants.VIN_CODE);
            m5086a.f15757c.setCvn(DiagnoseConstants.RECORD_CVN);
            DiagCarInfo diagCarInfo = m5086a.f15757c;
            diagCarInfo.setNetInfo_type(PreferencesManager.m9595a((Context) diagnoseActivity4).m9591a("netInfo_type"));
            NLog.m9452b("XEE", "---诊断报告信息---:" + m5086a.f15757c.toString());
            if (m5086a.f15755a.mo7083i().getDiagnoseStatue() == 0) {
                m5086a.f15755a.m7690a(m5086a.f15757c);
            }
        }
        if (!DiagnoseConstants.driviceConnStatus) {
            if (!replaceAll.toUpperCase(Locale.ENGLISH).contains("DEMO")) {
                diagnoseActivity.f11103bO.sendEmptyMessage(20503);
                return;
            }
            diagnoseActivity.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", diagnoseActivity.getString(R.string.custom_diaglog_title), diagnoseActivity.getString(R.string.common_loading_tips));
            DiagnoseConstants.DIAGNOSE_LIB_PATH = replaceAll;
            DiagnoseConstants.DIAGNOSE_LANGUAGE = str2;
            Message obtain2 = Message.obtain((Handler) null, 1);
            obtain2.replyTo = diagnoseActivity.f11026P;
            obtain2.setData(bundle);
            diagnoseActivity.m7692a(obtain2);
            return;
        }
        diagnoseActivity.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", diagnoseActivity.getString(R.string.custom_diaglog_title), diagnoseActivity.getString(R.string.common_loading_tips));
        DiagnoseConstants.DIAGNOSE_LIB_PATH = replaceAll;
        DiagnoseConstants.DIAGNOSE_LANGUAGE = str2;
        Message obtain3 = Message.obtain((Handler) null, 25);
        Bundle bundle2 = new Bundle();
        bundle2.putString("device_information_key", "device_information_linkmode");
        bundle2.putInt("device_information_value", diagnoseActivity.m7720C());
        obtain3.setData(bundle2);
        diagnoseActivity.m7692a(obtain3);
        Message obtain4 = Message.obtain((Handler) null, 6);
        obtain4.setData(bundle);
        diagnoseActivity.m7692a(obtain4);
        LoadDialog.m4681b(diagnoseActivity.f11019H);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ae */
    public static /* synthetic */ void m7661ae(DiagnoseActivity diagnoseActivity) {
        String[] strArr;
        String[] strArr2;
        String str;
        MainActivity.m7896a(false);
        String[] strArr3 = diagnoseActivity.f11043aG;
        if (strArr3.length == 1 && !"null".equalsIgnoreCase(strArr3[0]) && !TextUtils.isEmpty(diagnoseActivity.f11043aG[0])) {
            diagnoseActivity.m7645c(false);
            diagnoseActivity.f11055aS = new CarIconUtils(diagnoseActivity.f11019H);
            String upperCase = diagnoseActivity.f11043aG[0].toUpperCase();
            diagnoseActivity.f11058aV = upperCase;
            String m9591a = PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("serialNo");
            CarIcon m4951e = diagnoseActivity.f11055aS.m4951e(m9591a, upperCase);
            List<CarVersion> m4954d = diagnoseActivity.f11055aS.m4954d(m9591a, upperCase);
            if (m4954d != null && m4954d.size() > 0 && m4951e != null && m4951e.f15787k.booleanValue()) {
                if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                    str = m4951e.m5038a(diagnoseActivity.f11019H);
                } else {
                    str = m4951e.f15779c;
                }
                diagnoseActivity.f11056aT = m7666a(m4954d);
                Collections.sort(diagnoseActivity.f11056aT, new C2010b());
                PathUtils pathUtils = new PathUtils(diagnoseActivity.f11019H);
                String m4864a = pathUtils.m4864a(m9591a, upperCase, diagnoseActivity.f11056aT.get(0).getVersion());
                String language = diagnoseActivity.f11056aT.get(0).getLanguage();
                Intent intent = new Intent("VIN_START_DIAG");
                intent.putExtra("path", m4864a);
                intent.putExtra("language", language);
                intent.putExtra("serialNo", m9591a);
                intent.putExtra("carName", str);
                intent.putExtra("softPackageid", upperCase);
                intent.putExtra("softVersion", diagnoseActivity.f11056aT.get(0).getVersion());
                intent.putExtra("softLan", Locale.getDefault().getCountry());
                diagnoseActivity.f11019H.sendBroadcast(intent);
                FileUtils.m5012a(pathUtils.m4859b(m9591a, upperCase, diagnoseActivity.f11056aT.get(0).getVersion()) + File.separator + "APPDATA.INI", "SOFT_NAME", "MAKE", upperCase);
                return;
            }
            if (upperCase.equalsIgnoreCase("BENZ")) {
                upperCase = "MERCEDES";
            }
            diagnoseActivity.m7620n();
            LoadDialog.m4681b(diagnoseActivity.f11019H);
            C2744aa.m5165c((Activity) diagnoseActivity, upperCase);
            return;
        }
        String[] strArr4 = diagnoseActivity.f11043aG;
        if (strArr4 != null && strArr4.length > 1) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : diagnoseActivity.f11043aG) {
                if (!TextUtils.isEmpty(str2)) {
                    Log.d("yhx", "carName=".concat(String.valueOf(str2)));
                    CarIcon m4951e2 = diagnoseActivity.f11055aS.m4951e(PreferencesManager.m9595a(diagnoseActivity.f11019H).m9591a("serialNo"), str2.toUpperCase());
                    if (m4951e2 != null && m4951e2.f15787k.booleanValue()) {
                        arrayList.add(m4951e2);
                    }
                }
            }
            Log.d("yhx", "mVinArray=" + diagnoseActivity.f11043aG + ",vinscanCarIconList=" + arrayList);
            if (arrayList.isEmpty()) {
                String str3 = "";
                for (String str4 : diagnoseActivity.f11043aG) {
                    if (!TextUtils.isEmpty(str4)) {
                        String upperCase2 = str4.toUpperCase();
                        CarIconUtils carIconUtils = diagnoseActivity.f11055aS;
                        CarIcon carIcon = null;
                        if (!TextUtils.isEmpty(upperCase2)) {
                            QueryBuilder<CarIcon> queryBuilder = carIconUtils.f15881t.queryBuilder();
                            queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(upperCase2), new WhereCondition[0]);
                            List<CarIcon> list = queryBuilder.list();
                            if (list != null && list.size() > 0) {
                                carIcon = list.get(0);
                            }
                        }
                        if (carIcon != null) {
                            str3 = LangManager.m9469a().equals("zh") ? str3 + carIcon.m5038a(diagnoseActivity.f11019H) + "," : str3 + carIcon.f15779c + ",";
                        } else {
                            str3 = str3 + str4 + ",";
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3) && str3.contains(",")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
                C2744aa.m5165c((Activity) diagnoseActivity, str3);
            } else {
                diagnoseActivity.f11109bf = new VinScanSelectVehieclesDialog(diagnoseActivity.f11019H, arrayList, diagnoseActivity);
                diagnoseActivity.f11109bf.show();
            }
            LoadDialog.m4681b(diagnoseActivity.f11019H);
            return;
        }
        DiagnoseConstants.VIN_CODE = "";
        diagnoseActivity.m7620n();
        NToast.m9450a(diagnoseActivity.f11019H, (int) R.string.vin_cararray_fail);
        LoadDialog.m4681b(diagnoseActivity.f11019H);
    }
}
