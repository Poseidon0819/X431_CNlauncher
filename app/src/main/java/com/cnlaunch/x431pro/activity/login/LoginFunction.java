package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.gmap.map.p151c.StringUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p176f.ChatManager;
import com.cnlaunch.p169im.p176f.IMManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.physics.p197c.DPUSoftInfo;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.activity.p213b.p215b.CheckMerchantResponse;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.module.golo.model.PidBytData;
import com.cnlaunch.x431pro.module.golo.model.PidBytResponse;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.RegisteredProductsResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.LoginResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.SendClientVersionResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfoResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;
import com.cnlaunch.x431pro.module.rtu.RegisterAndLoadInfomation;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.x431pro.activity.login.aa */
/* loaded from: classes.dex */
public class LoginFunction extends NetworkBase {

    /* renamed from: K */
    private static boolean f13360K = false;

    /* renamed from: T */
    private static List<InterfaceC2302b> f13361T = new ArrayList();

    /* renamed from: U */
    private static List<InterfaceC2301a> f13362U = new ArrayList();

    /* renamed from: V */
    private static List<InterfaceC2303c> f13363V = new ArrayList();

    /* renamed from: A */
    private String f13364A;

    /* renamed from: B */
    private boolean f13365B;

    /* renamed from: C */
    private LoginDialog f13366C;

    /* renamed from: D */
    private ZipcodeInputDialog f13367D;

    /* renamed from: E */
    private String f13368E;

    /* renamed from: F */
    private String f13369F;

    /* renamed from: G */
    private ArrayList<String> f13370G;

    /* renamed from: H */
    private int f13371H;

    /* renamed from: I */
    private CompleteUserInfoDialog f13372I;

    /* renamed from: J */
    private List<ProductDTO> f13373J;

    /* renamed from: L */
    private String f13374L;

    /* renamed from: M */
    private String f13375M;

    /* renamed from: N */
    private int f13376N;

    /* renamed from: O */
    private SellerAction f13377O;

    /* renamed from: P */
    private String f13378P;

    /* renamed from: Q */
    private String f13379Q;

    /* renamed from: R */
    private int f13380R;

    /* renamed from: S */
    private String f13381S;

    /* renamed from: W */
    private InterfaceC2302b f13382W;

    /* renamed from: a */
    ArrayList<String> f13383a;

    /* renamed from: b */
    HashMap<String, String> f13384b;

    /* renamed from: c */
    Handler f13385c;

    /* renamed from: e */
    private final String f13386e;

    /* renamed from: f */
    private final int f13387f;

    /* renamed from: g */
    private final int f13388g;

    /* renamed from: h */
    private final int f13389h;

    /* renamed from: i */
    private final int f13390i;

    /* renamed from: j */
    private final int f13391j;

    /* renamed from: k */
    private final int f13392k;

    /* renamed from: l */
    private final int f13393l;

    /* renamed from: m */
    private final int f13394m;

    /* renamed from: n */
    private final int f13395n;

    /* renamed from: o */
    private final int f13396o;

    /* renamed from: p */
    private final String f13397p;

    /* renamed from: q */
    private final String f13398q;

    /* renamed from: r */
    private final String f13399r;

    /* renamed from: s */
    private final String f13400s;

    /* renamed from: t */
    private PreferencesManager f13401t;

    /* renamed from: u */
    private UserAction f13402u;

    /* renamed from: v */
    private String f13403v;

    /* renamed from: w */
    private String f13404w;

    /* renamed from: x */
    private String f13405x;

    /* renamed from: y */
    private ConnectorAction f13406y;

    /* renamed from: z */
    private SerialNumberDao f13407z;

    /* compiled from: LoginFunction.java */
    /* renamed from: com.cnlaunch.x431pro.activity.login.aa$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2301a {
        /* renamed from: a */
        void mo6559a();

        /* renamed from: a */
        void mo6558a(Object obj);

        /* renamed from: b */
        void mo6557b();

        /* renamed from: b */
        void mo6556b(Object obj);

        /* renamed from: c */
        void mo6555c(Object obj);

        /* renamed from: d */
        void mo6554d(Object obj);
    }

    /* compiled from: LoginFunction.java */
    /* renamed from: com.cnlaunch.x431pro.activity.login.aa$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2302b {
        /* renamed from: a */
        void mo4628a();
    }

    /* compiled from: LoginFunction.java */
    /* renamed from: com.cnlaunch.x431pro.activity.login.aa$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2303c {
        /* renamed from: a */
        void mo5458a();

        /* renamed from: b */
        void mo5457b();

        /* renamed from: c */
        void mo5456c();
    }

    public LoginFunction(Context context) {
        super(context);
        this.f13386e = LoginFunction.class.getSimpleName();
        this.f13387f = -10000;
        this.f13388g = 100002;
        this.f13389h = 100001;
        this.f13390i = 40000;
        this.f13391j = 40001;
        this.f13392k = 401;
        this.f13393l = 402;
        this.f13394m = 661;
        this.f13395n = 662;
        this.f13396o = UIMsg.d_ResultType.SHORT_URL;
        this.f13397p = "1";
        this.f13398q = "2";
        this.f13399r = "3";
        this.f13400s = "4";
        this.f13383a = new ArrayList<>();
        this.f13384b = new HashMap<>();
        this.f13365B = true;
        this.f13366C = null;
        this.f13367D = null;
        this.f13369F = "withzipcode_usernamelist";
        this.f13370G = new ArrayList<>();
        this.f13372I = null;
        this.f13375M = "";
        this.f13380R = 0;
        this.f13381S = "";
        this.f13402u = new UserAction(context);
        this.f13377O = new SellerAction(context);
        this.f13381S = PreferencesManager.m9595a(context).m9591a("sim_iccid");
        if (TextUtils.isEmpty(this.f13381S)) {
            this.f13381S = C2744aa.m5186a(context);
        }
        this.f13401t = PreferencesManager.m9595a(context);
        this.f13406y = new ConnectorAction(context);
        this.f13407z = DBManager.m5036a(context).f15794a.f15798a;
        this.f13373J = new ArrayList();
        f13360K = false;
        this.f13364A = "";
        this.f13376N = 0;
        String m9591a = this.f13401t.m9591a("username_list");
        if (m9591a != null && !m9591a.equals("")) {
            try {
                this.f13383a = (ArrayList) LoginActivity.m6764a(m9591a);
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        this.f13371H = 0;
        String m9591a2 = this.f13401t.m9591a(this.f13369F);
        if (m9591a2 == null || m9591a2.equals("")) {
            return;
        }
        try {
            this.f13370G = (ArrayList) LoginActivity.m6764a(m9591a2);
        } catch (StreamCorruptedException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m6581b(int i) {
        switch (i) {
            case 40000:
                NToast.m9450a(this.f13412d, (int) R.string.login_fail_prompt_40000);
                return;
            case 40001:
                NToast.m9450a(this.f13412d, (int) R.string.login_fail_prompt_40001);
                return;
            case 100001:
                NToast.m9450a(this.f13412d, (int) R.string.login_fail_prompt_100001);
                return;
            case 100002:
                NToast.m9450a(this.f13412d, (int) R.string.login_fail_prompt_100002);
                return;
            default:
                NToast.m9450a(this.f13412d, (int) R.string.login_fail);
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case UIMsg.d_ResultType.SHORT_URL /* 500 */:
                this.f13365B = C2744aa.m5178a(PreferencesManager.m9595a(this.f13412d).m9584b("token", ""));
                NLog.m9452b(this.f13386e + "{REQ_LOGIN_CODE_START}", Long.toString(System.currentTimeMillis()));
                return this.f13402u.m5265a(this.f13403v, this.f13404w, String.valueOf(System.currentTimeMillis()), "0", "");
            case UIMsg.d_ResultType.VERSION_CHECK /* 501 */:
            default:
                return super.doInBackground(i);
            case UIMsg.d_ResultType.NEWVERSION_DOWNLOAD /* 502 */:
                this.f13401t.m9587a("iSGetSerialNumberFailed", false);
                NLog.m9452b(this.f13386e + "{REQ_SERIALNUMBER_CODE_START}", Long.toString(System.currentTimeMillis()));
                m6564k();
                this.f13405x = PreferencesManager.m9595a(this.f13412d.getApplicationContext()).m9591a("seria_no_product_type");
                this.f13374L = this.f13401t.m9591a("heavyduty_seria_no_product_type");
                this.f13378P = this.f13401t.m9591a("new_car_product_type");
                this.f13379Q = this.f13401t.m9591a("car_and_heavyduty_product_type");
                return this.f13406y.m5361a(this.f13405x + "," + this.f13374L + "," + this.f13378P + "," + this.f13379Q);
            case UIMsg.d_ResultType.CELLID_LOCATE_REQ /* 503 */:
                try {
                    return m6576b(this.f13364A, "1");
                } catch (C1425f e) {
                    e.printStackTrace();
                    return null;
                }
            case UIMsg.d_ResultType.LOC_INFO_UPLOAD /* 504 */:
                try {
                    return m6576b(this.f13364A, "4");
                } catch (C1425f e2) {
                    e2.printStackTrace();
                    return null;
                }
            case 505:
                try {
                    return m6576b(this.f13364A, "2");
                } catch (C1425f e3) {
                    e3.printStackTrace();
                    return null;
                }
            case UIMsg.d_ResultType.SUGGESTION_SEARCH /* 506 */:
                NLog.m9452b(this.f13386e + "{REQ_GETPUBLICID_CODE_START}", Long.toString(System.currentTimeMillis()));
                try {
                    return this.f13406y.m5358g(PreferencesManager.m9595a(this.f13412d).m9591a("user_id"));
                } catch (C1425f e4) {
                    e4.printStackTrace();
                    return null;
                }
            case 507:
                this.f13402u = new UserAction(this.f13412d);
                return this.f13402u.m5249g(this.f13364A, this.f13381S);
            case UIMsg.d_ResultType.LONG_URL /* 508 */:
                return this.f13402u.m5257c();
            case 509:
                NLog.m9452b(this.f13386e + "{REQ_ADDZIPCODE_CODE mZipcode :}", this.f13368E);
                return this.f13402u.m5247i(this.f13368E);
            case 510:
                this.f13402u = new UserAction(this.f13412d);
                return this.f13402u.m5256c(LangManager.m9469a(), (String) null);
            case 511:
                String str = Build.MODEL;
                String deviceId = ((TelephonyManager) this.f13412d.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    deviceId = Settings.Secure.getString(this.f13412d.getContentResolver(), "android_id");
                }
                return this.f13377O.m7805b(this.f13403v, this.f13404w, deviceId, Build.MODEL);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        boolean z;
        PidBytData data;
        BaseResponse baseResponse;
        ZipcodeInputDialog zipcodeInputDialog;
        ZipcodeInputDialog zipcodeInputDialog2;
        switch (i) {
            case UIMsg.d_ResultType.SHORT_URL /* 500 */:
                if (obj != null) {
                    LoginResponse loginResponse = (LoginResponse) obj;
                    if (this.f13385c != null) {
                        Message message2 = new Message();
                        message2.what = 123;
                        message2.arg1 = loginResponse.getCode();
                        this.f13385c.sendMessage(message2);
                    }
                    if (loginResponse.getCode() == 0) {
                        User user = loginResponse.getData().getUser();
                        user.setToken(loginResponse.getData().getToken());
                        this.f13401t.m9592a((PreferencesManager) user);
                        this.f13401t.m9588a("login_username", this.f13403v);
                        this.f13401t.m9588a("login_password", this.f13404w);
                        this.f13401t.m9588a("login_state", "1");
                        this.f13401t.m9588a("if_auto_login", "1");
                        this.f13401t.m9588a(this.f13403v, this.f13404w);
                        RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
                        this.f13384b = registerInfoRecord.m6546a();
                        if (this.f13384b.containsKey(this.f13403v)) {
                            z = !this.f13404w.equals(this.f13384b.get(this.f13403v));
                        } else {
                            z = true;
                        }
                        if (z) {
                            this.f13384b.put(this.f13403v, this.f13404w);
                            try {
                                NLog.m9451c("weiwell register_onsuccess_map", this.f13384b);
                                String m6543a = RegisterInfoRecord.m6543a(this.f13384b);
                                NLog.m9451c("weiwell register_onsuccess", m6543a);
                                registerInfoRecord.m6544a(m6543a);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (!this.f13383a.contains(this.f13403v)) {
                            this.f13383a.add(this.f13403v);
                            try {
                                this.f13401t.m9588a("username_list", LoginActivity.m6763a(this.f13383a));
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (!this.f13365B) {
                            NToast.m9450a(this.f13412d, (int) R.string.login_succeed);
                        }
                        this.f13412d.sendBroadcast(new Intent("login"));
                        m6562m();
                        NLog.m9452b(this.f13386e + "{REQ_LOGIN_CODE_END}", loginResponse.getData().getUser().getUser_id());
                        try {
                            this.f13375M = UserAction.m5440a(loginResponse);
                        } catch (C1425f e3) {
                            e3.printStackTrace();
                        }
                        if (!this.f13375M.isEmpty() && PreferencesManager.m9595a(this.f13412d).m9583b("is_golo", false)) {
                            NLog.m9456a("XMPP", "------>new Login IM");
                            IMManager.m8730a(this.f13412d, this.f13375M);
                            m6553a(UIMsg.d_ResultType.SUGGESTION_SEARCH);
                        }
                        if (this.f13385c != null) {
                            Message message3 = new Message();
                            message3.what = Opcodes.IUSHR;
                            this.f13385c.sendMessage(message3);
                        }
                        if (this.f13366C != null) {
                            m6565j();
                            this.f13366C.dismiss();
                        }
                        m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
                    } else {
                        m6561n();
                        m6581b(loginResponse.getCode());
                        m6568g();
                    }
                } else {
                    m6581b(-10000);
                    NToast.m9450a(this.f13412d, (int) R.string.login_fail);
                }
                LoadDialog.m4681b(this.f13412d);
                return;
            case UIMsg.d_ResultType.VERSION_CHECK /* 501 */:
                this.f13401t.m9588a("login_state", "0");
                this.f13401t.m9588a("if_auto_login", "0");
                this.f13401t.m9592a((PreferencesManager) new User());
                this.f13412d.sendBroadcast(new Intent("logout"));
                NToast.m9450a(this.f13412d, (int) R.string.logout_ok);
                LoadDialog.m4681b(this.f13412d);
                return;
            case UIMsg.d_ResultType.NEWVERSION_DOWNLOAD /* 502 */:
                if (obj != null) {
                    RegisteredProductsResponse registeredProductsResponse = (RegisteredProductsResponse) obj;
                    if (registeredProductsResponse != null) {
                        if (registeredProductsResponse.getCode() == 0) {
                            List<ProductDTO> productDTOs = registeredProductsResponse.getProductDTOs();
                            NLog.m9452b(this.f13386e + "{REQ_SERIALNUMBER_CODE_END}", "productDTOList=".concat(String.valueOf(productDTOs)));
                            if (productDTOs != null && !productDTOs.isEmpty()) {
                                this.f13373J.addAll(productDTOs);
                            }
                        } else {
                            switch (registeredProductsResponse.getCode()) {
                                case 401:
                                case 402:
                                case 662:
                                    break;
                                case UIMsg.d_ResultType.SHORT_URL /* 500 */:
                                    NToast.m9450a(this.f13412d, (int) R.string.server_exception);
                                    break;
                                case 661:
                                    NToast.m9450a(this.f13412d, (int) R.string.no_exist_product_type);
                                    break;
                                default:
                                    NToast.m9450a(this.f13412d, (int) R.string.get_sn_failed);
                                    break;
                            }
                            NLog.m9456a(this.f13386e, "registeredProductsResponse.getCode()=" + registeredProductsResponse.getCode());
                            this.f13401t.m9587a("iSGetSerialNumberFailed", true);
                        }
                    } else {
                        int i2 = this.f13376N;
                        if (i2 < 2) {
                            this.f13376N = i2 + 1;
                            m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
                            return;
                        }
                    }
                }
                m6567h();
                NLog.m9452b(this.f13386e + "{REQ_SERIALNUMBER_CODE_END}", Long.toString(System.currentTimeMillis()));
                if (!this.f13364A.isEmpty()) {
                    DiagLogHistoryInfoManager.m5973a(this.f13412d).m5970a(this.f13364A);
                }
                this.f13412d.sendBroadcast(new Intent("login_change_serialno"));
                m6563l();
                if (!TextUtils.isEmpty(this.f13381S) && !this.f13364A.isEmpty()) {
                    m6553a(507);
                }
                if (C2744aa.m5125r() || (C2744aa.m5151f() && LangManager.m9466b().equalsIgnoreCase("JP"))) {
                    m6553a(510);
                }
                if (!(LangManager.m9469a().equals("zh_CN") || LangManager.m9469a().equals("zh")) && !f13360K) {
                    C2744aa.m5129p();
                }
                if (!this.f13375M.isEmpty() && PreferencesManager.m9595a(this.f13412d).m9583b("is_golo", false)) {
                    NLog.m9451c("XMPP", "------>Old Login IM");
                    return;
                } else if (this.f13364A.isEmpty()) {
                    return;
                } else {
                    m6553a(UIMsg.d_ResultType.CELLID_LOCATE_REQ);
                    return;
                }
            case UIMsg.d_ResultType.CELLID_LOCATE_REQ /* 503 */:
                if (obj != null) {
                    if (((SendClientVersionResponse) obj).getCode() == 0) {
                        NLog.m9452b(this.f13386e + "{REQ_SENDCLIIENTVERSION_APP_CODE}", Long.toString(System.currentTimeMillis()));
                    }
                }
                if (this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(505);
                return;
            case UIMsg.d_ResultType.LOC_INFO_UPLOAD /* 504 */:
                if (obj != null) {
                    if (((SendClientVersionResponse) obj).getCode() == 0) {
                        NLog.m9452b(this.f13386e + "{REQ_SENDCLIIENTVERSION_BOOT_CODE}", Long.toString(System.currentTimeMillis()));
                        return;
                    }
                    return;
                }
                return;
            case 505:
                if (obj != null) {
                    if (((SendClientVersionResponse) obj).getCode() == 0) {
                        NLog.m9452b(this.f13386e + "{REQ_SENDCLIENTVERSION_DOWNLOADBIN_CODE}", Long.toString(System.currentTimeMillis()));
                    }
                }
                if (this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(UIMsg.d_ResultType.LOC_INFO_UPLOAD);
                return;
            case UIMsg.d_ResultType.SUGGESTION_SEARCH /* 506 */:
                NLog.m9452b(this.f13386e + "{REQ_GETPUBLICID_CODE_SUCCESS}", Long.toString(System.currentTimeMillis()));
                if (obj != null && (data = ((PidBytResponse) obj).getData()) != null) {
                    String pub_id = data.getPub_id();
                    String pub_name = data.getPub_name();
                    if (TextUtils.isEmpty(pub_name) || "null".equalsIgnoreCase(pub_name)) {
                        pub_name = pub_id;
                    }
                    NLog.m9452b(this.f13386e, "pub_id:" + pub_id + ", pub_name:" + pub_name);
                    if (!TextUtils.isEmpty(pub_id) && !"null".equalsIgnoreCase(pub_id)) {
                        PreferencesManager.m9595a(this.f13412d).m9588a("USER_PUBLIC_ID", pub_id);
                        PreferencesManager.m9595a(this.f13412d).m9588a("USER_PUBLIC_NAME", pub_name);
                    } else {
                        PreferencesManager.m9595a(this.f13412d).m9588a("USER_PUBLIC_ID", "");
                        PreferencesManager.m9595a(this.f13412d).m9588a("USER_PUBLIC_NAME", "");
                    }
                }
                PreferencesManager.m9595a(this.f13412d).m9587a("isconflict", false);
                NLog.m9452b(this.f13386e + "{REQ_GETPUBLICID_CODE_END}", Long.toString(System.currentTimeMillis()));
                if (this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(UIMsg.d_ResultType.CELLID_LOCATE_REQ);
                return;
            case 507:
                if (obj == null || (baseResponse = (BaseResponse) obj) == null || baseResponse.getCode() == 0) {
                    return;
                }
                this.f13380R++;
                if (this.f13380R >= 3 || TextUtils.isEmpty(this.f13381S) || this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(507);
                return;
            case UIMsg.d_ResultType.LONG_URL /* 508 */:
                ZipcodeInfoResponse zipcodeInfoResponse = (ZipcodeInfoResponse) obj;
                if (zipcodeInfoResponse != null) {
                    if (zipcodeInfoResponse.getCode() == 0) {
                        String zipcode = zipcodeInfoResponse.getData().getZipcode();
                        NLog.m9452b(this.f13386e + "{REQ_GETFULLUSERINFO_CODE getZipCode :}", zipcode);
                        if (TextUtils.isEmpty(zipcode)) {
                            m6584a((Object) zipcodeInfoResponse);
                            return;
                        }
                        String m9584b = this.f13401t.m9584b("login_username", "");
                        if (TextUtils.isEmpty(m9584b) || this.f13370G.contains(m9584b)) {
                            return;
                        }
                        this.f13370G.add(m9584b);
                        try {
                            this.f13401t.m9588a(this.f13369F, LoginActivity.m6763a(this.f13370G));
                            return;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                m6584a((Object) zipcodeInfoResponse);
                return;
            case 509:
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (commonResponse.getCode() == 0) {
                        ZipcodeInputDialog zipcodeInputDialog3 = this.f13367D;
                        if (zipcodeInputDialog3 != null) {
                            zipcodeInputDialog3.dismiss();
                        }
                        NLog.m9452b(this.f13386e + "{REQ_ADDZIPCODE_CODE success}", Long.toString(System.currentTimeMillis()));
                        return;
                    }
                    this.f13371H++;
                    m6577b(this.f13412d.getString(R.string.zipcode_submit_failed, Integer.valueOf(commonResponse.getCode())));
                    if (this.f13371H != 2 || (zipcodeInputDialog2 = this.f13367D) == null) {
                        return;
                    }
                    zipcodeInputDialog2.dismiss();
                    return;
                }
                this.f13371H++;
                m6577b(this.f13412d.getString(R.string.zipcode_submit_failed, -1));
                if (this.f13371H != 2 || (zipcodeInputDialog = this.f13367D) == null) {
                    return;
                }
                zipcodeInputDialog.dismiss();
                return;
            case 510:
                if (obj != null) {
                    UserBaseInfoResponse userBaseInfoResponse = (UserBaseInfoResponse) obj;
                    if (userBaseInfoResponse.getCode() == 0) {
                        if (C2744aa.m5125r()) {
                            m6573c(userBaseInfoResponse.getData());
                        }
                        if (C2744aa.m5151f() && LangManager.m9466b().equalsIgnoreCase("JP")) {
                            m6571d(userBaseInfoResponse.getData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 511:
                if (obj != null) {
                    CheckMerchantResponse checkMerchantResponse = (CheckMerchantResponse) obj;
                    if (checkMerchantResponse.getCode() == 0) {
                        if (StringUtils.m9282a(checkMerchantResponse.getData().getBool())) {
                            Intent intent = new Intent(this.f13412d, RegistMerchantHomePageActivity.class);
                            intent.setFlags(67108864);
                            intent.putExtra("FromRegister", f13360K);
                            this.f13412d.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    checkMerchantResponse.getCode();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m6568g() {
        List<SerialNumber> loadAll = this.f13407z.loadAll();
        for (SerialNumber serialNumber : loadAll) {
            serialNumber.f15832b = Boolean.FALSE;
        }
        this.f13407z.updateInTx(loadAll);
    }

    /* renamed from: h */
    private void m6567h() {
        String str = this.f13386e;
        NLog.m9456a(str, "allProductDTOList=" + this.f13373J);
        this.f13364A = "";
        String m9584b = this.f13401t.m9584b("serialNo", "");
        List<SerialNumber> loadAll = this.f13407z.loadAll();
        for (SerialNumber serialNumber : loadAll) {
            serialNumber.f15832b = Boolean.FALSE;
            serialNumber.f15833c = Boolean.FALSE;
        }
        this.f13407z.updateInTx(loadAll);
        List<ProductDTO> list = this.f13373J;
        if (list == null || list.isEmpty()) {
            if (!TextUtils.isEmpty(m9584b)) {
                this.f13401t.m9588a("preSerialNo", m9584b);
            }
            this.f13401t.m9587a("need_refresh", true);
            this.f13401t.m9588a("serialNo", "");
            this.f13401t.m9588a("if_auto_login", "0");
            if (!f13360K) {
                NToast.m9447b(this.f13412d, (int) R.string.connector_need_activate);
            }
            this.f13401t.m9588a("serialNo", "");
            this.f13401t.m9588a("carSerialNo", "");
            this.f13401t.m9588a("heavydutySerialNo", "");
            this.f13401t.m9588a("carAndHeavydutySerialNo", "");
        } else {
            String m9591a = this.f13401t.m9591a("serialNo");
            String m9591a2 = this.f13401t.m9591a("carSerialNo");
            String m9591a3 = this.f13401t.m9591a("heavydutySerialNo");
            String m9591a4 = this.f13401t.m9591a("carAndHeavydutySerialNo");
            m6566i();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (ProductDTO productDTO : this.f13373J) {
                String serialNo = productDTO.getSerialNo();
                if (C2744aa.m5161c(serialNo, this.f13412d)) {
                    z = true;
                }
                if (C2744aa.m5168b(serialNo, this.f13412d) && serialNo.equals(m9591a2)) {
                    z2 = true;
                }
                if (C2744aa.m5177a(serialNo, this.f13412d) && serialNo.equals(m9591a3)) {
                    z3 = true;
                }
                if (C2744aa.m5161c(serialNo, this.f13412d) && serialNo.equals(m9591a4)) {
                    z4 = true;
                }
            }
            if (z && !z2 && !z3) {
                for (int i = 0; i < this.f13373J.size(); i++) {
                    ProductDTO productDTO2 = this.f13373J.get(i);
                    String serialNo2 = productDTO2.getSerialNo();
                    if (C2744aa.m5161c(serialNo2, this.f13412d) && !z4) {
                        this.f13401t.m9587a("need_refresh", true);
                        this.f13401t.m9588a("carAndHeavydutySerialNo", serialNo2);
                        this.f13401t.m9588a("serialNo", serialNo2);
                        this.f13401t.m9588a("carSerialNo", serialNo2);
                        this.f13401t.m9588a("heavydutySerialNo", serialNo2);
                    }
                    RegisterAndLoadInfomation registerAndLoadInfomation = new RegisterAndLoadInfomation(this.f13412d, productDTO2.getSerialNo());
                    registerAndLoadInfomation.f15704a = this.f13401t.m9591a("login_username");
                    registerAndLoadInfomation.f15705b = this.f13401t.m9591a("login_password");
                    registerAndLoadInfomation.f15706c = true;
                    registerAndLoadInfomation.m5196a();
                }
            }
            if (!z || (z && (z2 || z3))) {
                this.f13401t.m9588a("carAndHeavydutySerialNo", "");
                boolean z5 = true;
                boolean z6 = true;
                for (int i2 = 0; i2 < this.f13373J.size(); i2++) {
                    ProductDTO productDTO3 = this.f13373J.get(i2);
                    String serialNo3 = productDTO3.getSerialNo();
                    if (C2744aa.m5168b(serialNo3, this.f13412d)) {
                        if (z2) {
                            z5 = false;
                        } else if (z5) {
                            this.f13401t.m9587a("need_refresh", true);
                            this.f13401t.m9588a("carSerialNo", serialNo3);
                            z5 = false;
                        }
                    } else if (C2744aa.m5177a(serialNo3, this.f13412d)) {
                        if (z3) {
                            z6 = false;
                        } else if (z6) {
                            this.f13401t.m9587a("need_refresh", true);
                            this.f13401t.m9588a("heavydutySerialNo", serialNo3);
                            z6 = false;
                        }
                    }
                    RegisterAndLoadInfomation registerAndLoadInfomation2 = new RegisterAndLoadInfomation(this.f13412d, productDTO3.getSerialNo());
                    registerAndLoadInfomation2.f15704a = this.f13401t.m9591a("login_username");
                    registerAndLoadInfomation2.f15705b = this.f13401t.m9591a("login_password");
                    registerAndLoadInfomation2.f15706c = true;
                    registerAndLoadInfomation2.m5196a();
                }
                if (z5) {
                    if (!TextUtils.isEmpty(this.f13401t.m9591a("carSerialNo"))) {
                        this.f13401t.m9588a("carSerialNo", "");
                        this.f13401t.m9587a("need_refresh", true);
                    }
                    if (!z6) {
                        PreferencesManager preferencesManager = this.f13401t;
                        preferencesManager.m9588a("serialNo", preferencesManager.m9591a("heavydutySerialNo"));
                    } else {
                        this.f13401t.m9588a("serialNo", "");
                        if (!TextUtils.isEmpty(this.f13401t.m9591a("heavydutySerialNo"))) {
                            this.f13401t.m9588a("heavydutySerialNo", "");
                            this.f13401t.m9587a("need_refresh", true);
                        }
                    }
                } else {
                    PreferencesManager preferencesManager2 = this.f13401t;
                    preferencesManager2.m9588a("serialNo", preferencesManager2.m9591a("carSerialNo"));
                    if (z6) {
                        if (!TextUtils.isEmpty(this.f13401t.m9591a("heavydutySerialNo"))) {
                            this.f13401t.m9588a("heavydutySerialNo", "");
                            this.f13401t.m9587a("need_refresh", true);
                        }
                    } else {
                        String m9591a5 = this.f13401t.m9591a("carSerialNo");
                        String m9591a6 = this.f13401t.m9591a("heavydutySerialNo");
                        if (TextUtils.isEmpty(m9591a)) {
                            this.f13401t.m9588a("serialNo", m9591a5);
                        } else if (!m9591a2.equals(m9591a5) && !m9591a.equals(m9591a6)) {
                            this.f13401t.m9588a("serialNo", m9591a5);
                        }
                    }
                }
            }
            String m9591a7 = this.f13401t.m9591a("serialNo");
            this.f13364A = m9591a7;
            NLog.m9456a(this.f13386e, "newCurrentSerialNo=".concat(String.valueOf(m9591a7)));
            List<SerialNumber> loadAll2 = this.f13407z.loadAll();
            for (SerialNumber serialNumber2 : loadAll2) {
                serialNumber2.f15833c = Boolean.FALSE;
            }
            this.f13407z.updateInTx(loadAll2);
            if (!TextUtils.isEmpty(m9591a7)) {
                QueryBuilder<SerialNumber> queryBuilder = this.f13407z.queryBuilder();
                queryBuilder.where(SerialNumberDao.Properties.SerialNo.m321eq(m9591a7), new WhereCondition[0]);
                List<SerialNumber> list2 = queryBuilder.list();
                if (list2 != null && !list2.isEmpty()) {
                    for (SerialNumber serialNumber3 : list2) {
                        serialNumber3.f15833c = Boolean.TRUE;
                        this.f13407z.update(serialNumber3);
                    }
                }
            }
        }
        if (this.f13401t.m9583b("need_refresh", false)) {
            this.f13412d.sendBroadcast(new Intent("softs_updated"));
        }
    }

    /* renamed from: i */
    private void m6566i() {
        for (int i = 0; i < this.f13373J.size(); i++) {
            ProductDTO productDTO = this.f13373J.get(i);
            String serialNo = productDTO.getSerialNo();
            SerialNumber serialNumber = new SerialNumber();
            serialNumber.f15836f = productDTO.getPdtCategory();
            serialNumber.f15835e = this.f13401t.m9591a("user_id");
            serialNumber.f15833c = Boolean.FALSE;
            serialNumber.f15832b = Boolean.TRUE;
            serialNumber.f15834d = serialNo;
            QueryBuilder<SerialNumber> queryBuilder = this.f13407z.queryBuilder();
            queryBuilder.where(SerialNumberDao.Properties.SerialNo.m321eq(serialNo), new WhereCondition[0]);
            List<SerialNumber> list = queryBuilder.list();
            if (list == null || list.isEmpty()) {
                this.f13407z.insert(serialNumber);
            } else {
                serialNumber.f15831a = list.get(0).f15831a;
                this.f13407z.update(serialNumber);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        ZipcodeInputDialog zipcodeInputDialog;
        super.onFailure(i, i2, obj);
        switch (i) {
            case UIMsg.d_ResultType.SHORT_URL /* 500 */:
                LoadDialog.m4681b(this.f13412d);
                m6568g();
                if (this.f13385c != null) {
                    Message message2 = new Message();
                    message2.what = 123;
                    message2.arg1 = i2;
                    this.f13385c.sendMessage(message2);
                }
                this.f13412d.sendBroadcast(new Intent("logout"));
                this.f13401t.m9588a("login_state", "0");
                this.f13401t.m9588a("token", "");
                m6561n();
                return;
            case UIMsg.d_ResultType.VERSION_CHECK /* 501 */:
                LoadDialog.m4681b(this.f13412d);
                return;
            case UIMsg.d_ResultType.NEWVERSION_DOWNLOAD /* 502 */:
                NLog.m9451c("XMPP", "------>Old Login IM");
                String m9584b = this.f13401t.m9584b("serialNo", "");
                if (!TextUtils.isEmpty(m9584b)) {
                    this.f13401t.m9588a("preSerialNo", m9584b);
                    this.f13401t.m9587a("need_refresh", true);
                    this.f13401t.m9588a("serialNo", "");
                }
                this.f13401t.m9588a("if_auto_login", "0");
                this.f13401t.m9588a("carSerialNo", "");
                this.f13401t.m9588a("heavydutySerialNo", "");
                this.f13401t.m9588a("carAndHeavydutySerialNo", "");
                m6563l();
                if (C2744aa.m5125r() || (C2744aa.m5151f() && LangManager.m9466b().equalsIgnoreCase("JP"))) {
                    m6553a(510);
                    return;
                }
                return;
            case UIMsg.d_ResultType.CELLID_LOCATE_REQ /* 503 */:
                LoadDialog.m4681b(this.f13412d);
                if (this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(505);
                return;
            case UIMsg.d_ResultType.LOC_INFO_UPLOAD /* 504 */:
                LoadDialog.m4681b(this.f13412d);
                return;
            case 505:
                LoadDialog.m4681b(this.f13412d);
                if (this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(UIMsg.d_ResultType.LOC_INFO_UPLOAD);
                return;
            case UIMsg.d_ResultType.SUGGESTION_SEARCH /* 506 */:
                LoadDialog.m4681b(this.f13412d);
                return;
            case 507:
                NLog.m9456a("sarah", "onFailure REQ_SEND_ICCID_CODE");
                this.f13380R++;
                if (this.f13380R >= 3 || TextUtils.isEmpty(this.f13381S) || this.f13364A.isEmpty()) {
                    return;
                }
                m6553a(507);
                return;
            case UIMsg.d_ResultType.LONG_URL /* 508 */:
            case 510:
            default:
                return;
            case 509:
                this.f13371H++;
                m6577b(this.f13412d.getString(R.string.zipcode_submit_failed, Integer.valueOf(i2)));
                if (this.f13371H != 2 || (zipcodeInputDialog = this.f13367D) == null) {
                    return;
                }
                zipcodeInputDialog.dismiss();
                return;
            case 511:
                LoadDialog.m4681b(this.f13412d);
                return;
        }
    }

    /* renamed from: a */
    public final void m6583a(String str, String str2) {
        this.f13403v = str;
        this.f13404w = str2;
        if (this.f13403v.isEmpty()) {
            NToast.m9450a(this.f13412d, (int) R.string.login_input_username);
        } else if (this.f13404w.isEmpty()) {
            NToast.m9450a(this.f13412d, (int) R.string.login_input_password);
        } else {
            LoadDialog.m4686a(this.f13412d);
            m6553a(UIMsg.d_ResultType.SHORT_URL);
        }
    }

    /* renamed from: a */
    public final void m6592a() {
        this.f13403v = this.f13401t.m9584b("login_username", "");
        this.f13404w = this.f13401t.m9584b("login_password", "");
        LoadDialog.m4686a(this.f13412d);
        m6553a(UIMsg.d_ResultType.SHORT_URL);
    }

    /* renamed from: b */
    public final void m6582b() {
        LoadDialog.m4686a(this.f13412d);
        m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
    }

    /* renamed from: a */
    public static synchronized void m6590a(InterfaceC2302b interfaceC2302b) {
        synchronized (LoginFunction.class) {
            f13361T.add(interfaceC2302b);
        }
    }

    /* renamed from: b */
    public static synchronized void m6579b(InterfaceC2302b interfaceC2302b) {
        synchronized (LoginFunction.class) {
            f13361T.remove(interfaceC2302b);
        }
    }

    /* renamed from: j */
    private static void m6565j() {
        for (InterfaceC2302b interfaceC2302b : f13361T) {
            interfaceC2302b.mo4628a();
        }
    }

    /* renamed from: a */
    public static synchronized void m6591a(InterfaceC2301a interfaceC2301a) {
        synchronized (LoginFunction.class) {
            f13362U.add(interfaceC2301a);
        }
    }

    /* renamed from: b */
    public static synchronized void m6580b(InterfaceC2301a interfaceC2301a) {
        synchronized (LoginFunction.class) {
            f13362U.remove(interfaceC2301a);
        }
    }

    /* renamed from: k */
    private static void m6564k() {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6559a();
        }
    }

    /* renamed from: l */
    private static void m6563l() {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6557b();
        }
    }

    /* renamed from: a */
    private static void m6584a(Object obj) {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6558a(obj);
        }
    }

    /* renamed from: b */
    private static void m6577b(Object obj) {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6556b(obj);
        }
    }

    /* renamed from: c */
    private static void m6573c(Object obj) {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6555c(obj);
        }
    }

    /* renamed from: d */
    private static void m6571d(Object obj) {
        for (InterfaceC2301a interfaceC2301a : f13362U) {
            interfaceC2301a.mo6554d(obj);
        }
    }

    /* renamed from: m */
    private static void m6562m() {
        for (InterfaceC2303c interfaceC2303c : f13363V) {
            interfaceC2303c.mo5458a();
        }
    }

    /* renamed from: n */
    private static void m6561n() {
        for (InterfaceC2303c interfaceC2303c : f13363V) {
            interfaceC2303c.mo5457b();
        }
    }

    /* renamed from: o */
    private static synchronized void m6560o() {
        synchronized (LoginFunction.class) {
            for (InterfaceC2303c interfaceC2303c : f13363V) {
                interfaceC2303c.mo5456c();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m6589a(InterfaceC2303c interfaceC2303c) {
        synchronized (LoginFunction.class) {
            f13363V.add(interfaceC2303c);
        }
    }

    /* renamed from: b */
    public static synchronized void m6578b(InterfaceC2303c interfaceC2303c) {
        synchronized (LoginFunction.class) {
            f13363V.remove(interfaceC2303c);
        }
    }

    /* renamed from: c */
    public final void m6575c() {
        LoadDialog.m4686a(this.f13412d);
        this.f13401t.m9588a("login_state", "0");
        this.f13401t.m9588a("if_auto_login", "0");
        this.f13401t.m9588a("token", "");
        this.f13401t.m9588a("USER_PUBLIC_ID", "");
        this.f13401t.m9588a("USER_PUBLIC_NAME", "");
        DealDiagMessageHandler.m8673a().f9427c = null;
        this.f13412d.sendBroadcast(new Intent("logout"));
        m6560o();
        NToast.m9450a(this.f13412d, (int) R.string.logout_ok);
        LoadDialog.m4681b(this.f13412d);
        IMManager.m8728b(this.f13412d);
        m6568g();
        GoloDBManager.m8750b(this.f13412d);
        ChatManager.m8742a();
        this.f13412d.sendBroadcast(new Intent("com.cnlaunch.golo.action.seller.pro.logout"));
    }

    /* renamed from: c */
    public final LoginDialog m6574c(InterfaceC2302b interfaceC2302b) {
        this.f13382W = interfaceC2302b;
        return m6572d();
    }

    /* renamed from: d */
    public final LoginDialog m6572d() {
        this.f13401t.m9588a("login_state", "0");
        this.f13412d.sendBroadcast(new Intent("logout"));
        this.f13366C = new DialogC2304ab(this, this.f13412d);
        LoginDialog loginDialog = this.f13366C;
        loginDialog.f16255h = this.f13382W;
        loginDialog.m4713f(2);
        this.f13366C.show();
        return this.f13366C;
    }

    /* renamed from: a */
    public final ZipcodeInputDialog m6586a(ZipcodeInfoResponse zipcodeInfoResponse) {
        this.f13367D = new DialogC2305ac(this, this.f13412d, zipcodeInfoResponse);
        this.f13367D.show();
        return this.f13367D;
    }

    /* renamed from: a */
    public final CompleteUserInfoDialog m6585a(UserBaseInfo userBaseInfo) {
        this.f13372I = new CompleteUserInfoDialog(this.f13412d, userBaseInfo);
        this.f13372I.show();
        return this.f13372I;
    }

    /* renamed from: b */
    private SendClientVersionResponse m6576b(String str, String str2) throws C1425f {
        String m4916a = C2778n.m4916a(this.f13412d, "seria_no_product_type");
        String str3 = "";
        if (str2 == "1") {
            try {
                str3 = this.f13412d.getPackageManager().getPackageInfo(this.f13412d.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (str2 == "2") {
            String m4858c = PathUtils.m4858c();
            DeviceUtils.m8149a();
            DPUSoftInfo m8142b = DeviceUtils.m8142b(str, m4858c);
            if (m8142b != null) {
                str3 = m8142b.f9866g;
            }
        }
        if (str2 == "4") {
            String m4858c2 = PathUtils.m4858c();
            DeviceUtils.m8149a();
            DPUSoftInfo m8142b2 = DeviceUtils.m8142b(str, m4858c2);
            if (m8142b2 != null) {
                str3 = m8142b2.f9865f;
            }
        }
        if (str3 != "") {
            return this.f13402u.m5254c(str, str2, m4916a, str3);
        }
        return null;
    }

    /* renamed from: e */
    public static void m6570e() {
        f13360K = true;
    }

    /* renamed from: f */
    public static boolean m6569f() {
        return f13360K;
    }
}
