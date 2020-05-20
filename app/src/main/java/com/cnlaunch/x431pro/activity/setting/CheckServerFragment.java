package com.cnlaunch.x431pro.activity.setting;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p125c.p129d.NetworkObervable;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.config.p249a.ConfigAction;
import com.cnlaunch.x431pro.module.config.p250b.ConfigRespose;
import com.cnlaunch.x431pro.module.config.p250b.ConfigUrl;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.RegisteredProductsResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadServerCheckLogResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.LoginResponse;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.module.rtu.RegisterAndLoadInfomation;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"SimpleDateFormat", "HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.setting.d */
/* loaded from: classes.dex */
public class CheckServerFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a */
    private static final String f14711a = "d";

    /* renamed from: A */
    private String f14712A;

    /* renamed from: B */
    private String f14713B;

    /* renamed from: C */
    private PackageInfo f14714C;

    /* renamed from: D */
    private String f14715D;

    /* renamed from: E */
    private String f14716E;

    /* renamed from: F */
    private boolean f14717F;

    /* renamed from: P */
    private UserAction f14727P;

    /* renamed from: Q */
    private ConnectorAction f14728Q;

    /* renamed from: R */
    private PreferencesManager f14729R;

    /* renamed from: S */
    private UpgradeAction f14730S;

    /* renamed from: T */
    private ConfigAction f14731T;

    /* renamed from: U */
    private C2778n f14732U;

    /* renamed from: V */
    private ConfigDBManager f14733V;

    /* renamed from: W */
    private DownloadManager f14734W;

    /* renamed from: X */
    private List<X431PadDtoSoft> f14735X;

    /* renamed from: Y */
    private List<X431PadDtoSoft> f14736Y;

    /* renamed from: Z */
    private List<X431PadDtoSoft> f14737Z;

    /* renamed from: aa */
    private String f14738aa;

    /* renamed from: ab */
    private String f14739ab;

    /* renamed from: ac */
    private String f14740ac;

    /* renamed from: ad */
    private String f14741ad;

    /* renamed from: ae */
    private String f14742ae;

    /* renamed from: af */
    private String f14743af;

    /* renamed from: ag */
    private String f14744ag;

    /* renamed from: ah */
    private String f14745ah;

    /* renamed from: ai */
    private String f14746ai;

    /* renamed from: aj */
    private String f14747aj;

    /* renamed from: ak */
    private String f14748ak;

    /* renamed from: al */
    private String f14749al;

    /* renamed from: am */
    private String f14750am;

    /* renamed from: an */
    private String f14751an;

    /* renamed from: ao */
    private String f14752ao;

    /* renamed from: ap */
    private SerialNumberDao f14753ap;

    /* renamed from: aq */
    private List<ProductDTO> f14754aq;

    /* renamed from: b */
    private TextView f14757b;

    /* renamed from: c */
    private ScrollView f14758c;

    /* renamed from: d */
    private Button f14759d;

    /* renamed from: e */
    private Button f14760e;

    /* renamed from: f */
    private String f14761f;

    /* renamed from: g */
    private String f14762g;

    /* renamed from: h */
    private String f14763h;

    /* renamed from: i */
    private String f14764i;

    /* renamed from: j */
    private String f14765j;

    /* renamed from: k */
    private String f14766k;

    /* renamed from: l */
    private String f14767l;

    /* renamed from: m */
    private String f14768m;

    /* renamed from: n */
    private List<ConfigUrl> f14769n;

    /* renamed from: o */
    private String f14770o;

    /* renamed from: p */
    private String f14771p;

    /* renamed from: q */
    private List<C2558a> f14772q;

    /* renamed from: r */
    private List<C2559b> f14773r;

    /* renamed from: s */
    private List<ProductDTO> f14774s;

    /* renamed from: t */
    private String f14775t;

    /* renamed from: u */
    private List<String> f14776u;

    /* renamed from: v */
    private List<String> f14777v;

    /* renamed from: w */
    private String f14778w;

    /* renamed from: x */
    private String f14779x;

    /* renamed from: y */
    private String f14780y = null;

    /* renamed from: z */
    private String f14781z = null;

    /* renamed from: G */
    private final int f14718G = 1203;

    /* renamed from: H */
    private final int f14719H = 1204;

    /* renamed from: I */
    private final int f14720I = 1205;

    /* renamed from: J */
    private final int f14721J = 1206;

    /* renamed from: K */
    private final int f14722K = 1207;

    /* renamed from: L */
    private final int f14723L = 2101;

    /* renamed from: M */
    private final int f14724M = 2102;

    /* renamed from: N */
    private final int f14725N = 1208;

    /* renamed from: O */
    private final int f14726O = 1209;

    /* renamed from: ar */
    private NetworkObervable f14755ar = null;

    /* renamed from: as */
    private BroadcastReceiver f14756as = new C2564h(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.setting_check_server_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14727P = new UserAction(this.mContext);
        this.f14728Q = new ConnectorAction(this.mContext);
        this.f14729R = PreferencesManager.m9595a(this.mContext);
        this.f14730S = new UpgradeAction(this.mContext);
        this.f14731T = new ConfigAction(this.mContext);
        this.f14732U = new C2778n();
        this.f14733V = ConfigDBManager.m5398a(this.mContext);
        this.f14753ap = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f14754aq = new ArrayList();
        this.f14759d = (Button) getActivity().findViewById(R.id.btn_check_server);
        this.f14759d.setOnClickListener(this);
        this.f14760e = (Button) getActivity().findViewById(R.id.btn_upload_log);
        this.f14760e.setOnClickListener(this);
        this.f14760e.setEnabled(false);
        if (!C2778n.m4917a(this.mContext)) {
            NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
            this.f14759d.setEnabled(false);
            this.f14717F = false;
        } else {
            this.f14759d.setEnabled(true);
            this.f14717F = true;
        }
        this.f14757b = (TextView) getActivity().findViewById(R.id.tv_printOutLeft);
        this.f14758c = (ScrollView) getActivity().findViewById(R.id.sv_show);
        this.f14772q = new ArrayList();
        this.f14773r = new ArrayList();
        this.f14776u = new ArrayList();
        this.f14777v = new ArrayList();
        try {
            this.f14714C = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            this.f14713B = this.f14714C.versionName;
            this.f14715D = this.f14733V.m5396a(KeyConstant.f6810aJ);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f14755ar = new NetworkObervable();
        NetworkObervable networkObervable = this.f14755ar;
        networkObervable.f7178a.add(new C2561e(this, Looper.myLooper()));
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.mContext.registerReceiver(this.f14756as, intentFilter);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_check_server, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14738aa = getResources().getString(R.string.app_name);
        this.f14739ab = getResources().getString(R.string.check_server);
        this.f14740ac = getResources().getString(R.string.check_server_network_txt);
        this.f14741ad = getResources().getString(R.string.check_server_finish_txt);
        this.f14742ae = getResources().getString(R.string.check_server_login_txt);
        this.f14743af = getResources().getString(R.string.check_server_success_txt);
        this.f14744ag = getResources().getString(R.string.check_server_upload_txt);
        this.f14745ah = getResources().getString(R.string.check_server_end_txt);
        this.f14746ai = getResources().getString(R.string.check_server_file_txt);
        this.f14747aj = getResources().getString(R.string.check_server_failure_txt);
        this.f14748ak = getResources().getString(R.string.check_server_file_download_txt);
        this.f14749al = getResources().getString(R.string.check_server_download_txt);
        this.f14750am = getResources().getString(R.string.check_server_submiting_txt);
        this.f14751an = getResources().getString(R.string.check_server_submit_success_txt);
        this.f14752ao = getResources().getString(R.string.check_server_submit_failure_txt);
    }

    /* renamed from: a */
    private void m5946a() {
        while (true) {
            List<X431PadDtoSoft> list = this.f14737Z;
            if (list == null || list.size() <= 0) {
                break;
            }
            this.f14737Z.remove(0);
        }
        while (true) {
            List<X431PadDtoSoft> list2 = this.f14735X;
            if (list2 == null || list2.size() <= 0) {
                break;
            }
            this.f14735X.remove(0);
        }
        while (true) {
            List<X431PadDtoSoft> list3 = this.f14736Y;
            if (list3 == null || list3.size() <= 0) {
                break;
            }
            this.f14736Y.remove(0);
        }
        while (true) {
            List<C2558a> list4 = this.f14772q;
            if (list4 == null || list4.size() <= 0) {
                break;
            }
            this.f14772q.remove(0);
        }
        while (true) {
            List<C2559b> list5 = this.f14773r;
            if (list5 == null || list5.size() <= 0) {
                break;
            }
            this.f14773r.remove(0);
        }
        while (true) {
            List<String> list6 = this.f14776u;
            if (list6 == null || list6.size() <= 0) {
                break;
            }
            this.f14776u.remove(0);
        }
        while (true) {
            List<String> list7 = this.f14777v;
            if (list7 == null || list7.size() <= 0) {
                return;
            }
            this.f14777v.remove(0);
        }
    }

    /* renamed from: b */
    private static String m5941b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && InetAddressUtils.isIPv4Address(nextElement.getHostAddress())) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            System.err.print("error");
            return null;
        }
    }

    /* renamed from: a */
    private static String m5943a(String str) {
        String str2 = "";
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 -w 3 ".concat(String.valueOf(str)));
            str2 = exec.waitFor() + ";";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            new String();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine + HttpProxyConstants.CRLF;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CheckServerFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.d$a */
    /* loaded from: classes.dex */
    public class C2558a {

        /* renamed from: a */
        String f14782a;

        /* renamed from: b */
        Date f14783b;

        /* renamed from: c */
        Date f14784c;

        /* renamed from: d */
        int f14785d;

        C2558a() {
        }

        /* renamed from: a */
        public final void m5919a(String str, Date date) {
            this.f14782a = str;
            this.f14783b = date;
        }

        /* renamed from: a */
        public final double m5920a() {
            double time = this.f14784c.getTime() - this.f14783b.getTime();
            Double.isNaN(time);
            return time / 1000.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CheckServerFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.d$b */
    /* loaded from: classes.dex */
    public class C2559b {

        /* renamed from: a */
        int f14787a;

        /* renamed from: b */
        int f14788b;

        /* renamed from: c */
        String f14789c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2559b() {
        }

        /* renamed from: a */
        public final void m5918a(int i, int i2, String str) {
            this.f14787a = i;
            this.f14788b = i2;
            this.f14789c = str;
        }
    }

    /* renamed from: a */
    public final void m5942a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            this.f14757b.append(str);
            this.f14757b.append("[");
            TextView textView = this.f14757b;
            textView.append(Html.fromHtml("<font color=#E61A6B>" + str2 + "</font>"));
            this.f14757b.append("]\n");
        } else {
            this.f14757b.append(str + "\n");
        }
        this.f14758c.post(new RunnableC2562f(this));
    }

    /* renamed from: b */
    public static void m5938b(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str, true);
            fileWriter.write(str2);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* compiled from: CheckServerFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.d$c */
    /* loaded from: classes.dex */
    class C2560c extends Thread {

        /* renamed from: b */
        private String f14792b;

        /* renamed from: c */
        private String f14793c;

        public C2560c(String str, String str2) {
            this.f14792b = str;
            this.f14793c = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            for (X431PadDtoSoft x431PadDtoSoft : CheckServerFragment.this.f14737Z) {
                if (!TextUtils.isEmpty(this.f14792b) && this.f14792b.equals(x431PadDtoSoft.getFileName())) {
                    if ("fail".equals(FileUtils.m5001c(this.f14793c, PathUtils.m4863a(PathUtils.m4844l(), "downzip")))) {
                        if ("CN".equals(CheckServerFragment.this.f14779x) || "TW".equals(CheckServerFragment.this.f14779x)) {
                            CheckServerFragment.m5938b(CheckServerFragment.this.f14780y, this.f14792b + ":压缩包解压失败\n");
                            return;
                        }
                        CheckServerFragment.m5938b(CheckServerFragment.this.f14780y, this.f14792b + ":Decompression Failed\n");
                        return;
                    }
                    if ("CN".equals(CheckServerFragment.this.f14779x) || "TW".equals(CheckServerFragment.this.f14779x)) {
                        CheckServerFragment.m5938b(CheckServerFragment.this.f14780y, this.f14792b + ":压缩包解压成功\n");
                    } else {
                        CheckServerFragment.m5938b(CheckServerFragment.this.f14780y, this.f14792b + ":Decompression Success\n");
                    }
                    FileUtils.m5000d(this.f14793c);
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private static void m5935c(String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            byte[] bArr = new byte[2048];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 2048);
            zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    zipOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private static String m5939b(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String substring = str.substring(7);
        String substring2 = substring.substring(0, substring.indexOf("/"));
        int indexOf = substring2.indexOf(":");
        return indexOf > 0 ? substring2.substring(0, indexOf) : substring2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_check_server) {
            if (id != R.id.btn_upload_log) {
                return;
            }
            if (FileUtils.m5027a() < 10) {
                NToast.m9444c(this.mContext, (int) R.string.sd_no_storage_space);
                return;
            }
            int lastIndexOf = this.f14780y.lastIndexOf(".txt");
            this.f14781z = this.f14780y.substring(0, lastIndexOf) + ".zip";
            m5935c(this.f14780y, this.f14781z);
            m5942a(this.f14750am + "...", "");
            LoadDialog.m4685a(this.mContext, (int) R.string.setting_upload_log);
            request(1208);
            return;
        }
        this.f14757b.setText("");
        this.f14759d.setEnabled(false);
        this.f14761f = this.f14729R.m9591a("login_username");
        this.f14762g = this.f14729R.m9591a("login_password");
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        this.f14780y = null;
        this.f14712A = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f14779x = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(this.f14712A)) {
            this.f14712A = "10000".concat(String.valueOf(((int) (Math.random() * 1.0E7d)) + 1));
        }
        this.f14716E = m5939b(this.f14715D);
        this.f14716E = this.f14716E.replace(".", "");
        this.f14780y = PathUtils.m4844l() + "/" + this.f14712A + this.f14716E + format + ".txt";
        m5946a();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14739ab);
        sb.append("...");
        m5942a(sb.toString(), "");
        if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
            String concat = "检测开始…\n".concat("软件名称:" + this.f14738aa + "\n");
            String str = this.f14713B;
            if (str != null && !str.isEmpty()) {
                concat = concat.concat("软件版本号: V" + this.f14713B + "\n");
            }
            m5938b(this.f14780y, concat);
        } else {
            String concat2 = "Start Test…\n".concat("Software name:" + this.f14738aa + "\n");
            String str2 = this.f14713B;
            if (str2 != null && !str2.isEmpty()) {
                concat2 = concat2.concat("Software version: V" + this.f14713B + "\n");
            }
            m5938b(this.f14780y, concat2);
        }
        request(1205);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doInBackground(int r10) throws com.cnlaunch.p120d.p125c.p128c.C1425f {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.setting.CheckServerFragment.doInBackground(int):java.lang.Object");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String concat;
        RegisteredProductsResponse registeredProductsResponse;
        StringBuilder sb3;
        StringBuilder sb4;
        String concat2;
        StringBuilder sb5;
        RegisteredProductsResponse registeredProductsResponse2;
        StringBuilder sb6;
        double d = 0.0d;
        if (i != 2101) {
            int i2 = 0;
            switch (i) {
                case 1203:
                    if (obj != null) {
                        LoginResponse loginResponse = (LoginResponse) obj;
                        if (isSuccess(loginResponse.getCode())) {
                            for (C2558a c2558a : this.f14772q) {
                                if (c2558a.f14782a.equals("REQ_LOGIN_CODE")) {
                                    c2558a.f14784c = new Date(System.currentTimeMillis());
                                    d = c2558a.m5920a();
                                }
                            }
                            User user = loginResponse.getData().getUser();
                            user.setToken(loginResponse.getData().getToken());
                            this.f14729R.m9592a((PreferencesManager) user);
                            this.f14729R.m9588a("login_state", "1");
                            this.f14729R.m9588a("if_auto_login", "1");
                            this.mContext.sendBroadcast(new Intent("login"));
                            this.f14771p = user.getUser_id();
                            m5942a(this.f14742ae + "...", this.f14743af);
                            m5938b(this.f14780y, ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) ? "\n网站登录测试:\n".concat("网站登录测试结果:成功，耗时" + d + "秒\n").concat("CC号:" + this.f14771p + "\n").concat("用户名:" + this.f14761f + "\n") : "\nTesting logging on:\n".concat("Testing logging on results:Success,Time of " + d + "seconds\n").concat("CC:" + this.f14771p + "\n").concat("User name:" + this.f14761f + "\n"));
                            request(1207);
                            return;
                        }
                        C2559b c2559b = new C2559b();
                        c2559b.m5918a(1203, loginResponse.getCode(), loginResponse.getMessage());
                        this.f14773r.add(c2559b);
                        m5942a(this.f14742ae + "...", "");
                        m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                        if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                            concat = "\n网站登录测试:\n".concat("网站登录测试结果:失败,错误码：" + loginResponse.getCode() + ",错误信息：" + loginResponse.getMessage() + "\n").concat("\n检测完毕。\n");
                        } else {
                            concat = "\nTesting logging on:\n".concat("Testing logging on results:Failed,Error code:" + loginResponse.getCode() + ",Error message:" + loginResponse.getMessage() + "\n").concat("\nServer test is done.\n");
                        }
                        m5938b(this.f14780y, concat);
                        this.f14759d.setEnabled(true);
                        this.f14760e.setEnabled(true);
                        return;
                    }
                    return;
                case 1204:
                    if (obj == null || (registeredProductsResponse = (RegisteredProductsResponse) obj) == null) {
                        return;
                    }
                    if (isSuccess(registeredProductsResponse.getCode())) {
                        this.f14774s = registeredProductsResponse.getProductDTOs();
                        List<ProductDTO> list = this.f14774s;
                        if (list != null && !list.isEmpty()) {
                            this.f14754aq.addAll(this.f14774s);
                        }
                        if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                            sb3 = new StringBuilder("\n获取产品序列号测试:\n");
                            sb3.append("产品类型:" + this.f14763h + "\n");
                        } else {
                            sb3 = new StringBuilder("\nTesting getting the product serial number:\n");
                            sb3.append("Product types:" + this.f14763h + "\n");
                        }
                        List<ProductDTO> list2 = this.f14774s;
                        if (list2 != null && list2.size() > 0) {
                            while (i2 < this.f14774s.size()) {
                                ProductDTO productDTO = this.f14774s.get(i2);
                                if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                    sb3.append("序列号:" + productDTO.getSerialNo() + "\n");
                                    sb3.append("产品配置:" + productDTO.getProductConfigName() + "\n");
                                } else {
                                    sb3.append("Serial Number:" + productDTO.getSerialNo() + "\n");
                                    sb3.append("Product configuration:" + productDTO.getProductConfigName() + "\n");
                                }
                                if (i2 == 0) {
                                    this.f14775t = productDTO.getSerialNo();
                                }
                                i2++;
                            }
                            m5938b(this.f14780y, sb3.toString());
                        } else {
                            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                sb3.append("\n该用户未注册产品，无法获取产品序列号\n");
                            } else {
                                sb3.append("\nThe unregistered user product, unable to obtain the product serial number.\n");
                            }
                            m5938b(this.f14780y, sb3.toString());
                        }
                        request(1209);
                        return;
                    }
                    C2559b c2559b2 = new C2559b();
                    c2559b2.m5918a(1204, registeredProductsResponse.getCode(), registeredProductsResponse.getMessage());
                    this.f14773r.add(c2559b2);
                    m5938b(this.f14780y, ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) ? "获取产品序列号测试:\n".concat("获取产品序列号测试结果:失败,错误码：" + registeredProductsResponse.getCode() + ",错误信息：" + registeredProductsResponse.getMessage() + "\n\n检测完毕。\n") : "Testing getting the product serial number:\n".concat("Testing getting the product serial number results:Failed,Error code:" + registeredProductsResponse.getCode() + ",Error message:" + registeredProductsResponse.getMessage() + "\n\nServer test is done.\n"));
                    m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                    this.f14759d.setEnabled(true);
                    this.f14760e.setEnabled(true);
                    return;
                case 1205:
                    List<String> list3 = this.f14776u;
                    String str2 = list3.get(list3.size() - 1);
                    String substring = str2.substring(0, str2.indexOf(";"));
                    List<String> list4 = this.f14777v;
                    String str3 = list4.get(list4.size() - 1);
                    String substring2 = str3.substring(0, str3.indexOf(";"));
                    if (substring.equalsIgnoreCase("0") || substring2.equalsIgnoreCase("0")) {
                        m5942a(this.f14740ac + "...", this.f14741ad);
                    } else {
                        m5942a(this.f14740ac + "...", this.f14747aj);
                    }
                    this.f14770o = LangManager.m9469a();
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        sb4 = new StringBuilder("\n检测当前网络环境:\n检测当前网络环境结果：成功。\n当前语言:" + this.f14770o + "\n");
                    } else {
                        sb4 = new StringBuilder("\nTesting current network environment:\nTesting current network environment results：Success.\nThe current language:" + this.f14770o + ".\n");
                    }
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        for (int i3 = 0; i3 < this.f14776u.size(); i3++) {
                            sb4.append("ping www.baidu.com 返回：\n");
                            sb4.append(this.f14776u.get(i3));
                        }
                        sb4.append("\n");
                        while (i2 < this.f14777v.size()) {
                            sb4.append("ping www.qq.com 返回：\n");
                            sb4.append(this.f14777v.get(i2));
                            i2++;
                        }
                    } else {
                        for (int i4 = 0; i4 < this.f14776u.size(); i4++) {
                            sb4.append("ping www.google.com Return：\n");
                            sb4.append(this.f14776u.get(i4));
                        }
                        sb4.append("\n");
                        while (i2 < this.f14777v.size()) {
                            sb4.append("ping www.apple.com Return：\n");
                            sb4.append(this.f14777v.get(i2));
                            i2++;
                        }
                    }
                    m5938b(this.f14780y, sb4.toString());
                    if (this.f14761f.isEmpty() || this.f14762g.isEmpty()) {
                        request(1207);
                        return;
                    } else {
                        request(1203);
                        return;
                    }
                case 1206:
                    this.f14734W = DownloadManager.m9565a();
                    this.f14734W.f7053a = new HandlerC2563g(this);
                    List<X431PadDtoSoft> list5 = this.f14737Z;
                    if (list5 != null) {
                        for (X431PadDtoSoft x431PadDtoSoft : list5) {
                            C1426i c1426i = new C1426i();
                            c1426i.m9506a("serialNo", this.f14775t);
                            c1426i.m9506a("versionDetailId", x431PadDtoSoft.getVersionDetailId());
                            StringBuilder sb7 = new StringBuilder(x431PadDtoSoft.getSoftPackageID() + "_" + x431PadDtoSoft.getVersionNo().replace(".", "_") + "_" + x431PadDtoSoft.getLanId());
                            if (x431PadDtoSoft.getType() == 1) {
                                sb7.append(".apk");
                            } else if (x431PadDtoSoft.getType() == 2) {
                                sb7.append(".zip");
                            } else if (x431PadDtoSoft.getType() == 3) {
                                sb7.append(".zip");
                            }
                            x431PadDtoSoft.setFileName(sb7.toString());
                            x431PadDtoSoft.setState(0);
                            DownloadParam downloadParam = new DownloadParam();
                            downloadParam.f7076a = this.mContext;
                            downloadParam.f7077b = c1426i;
                            downloadParam.f7082g = x431PadDtoSoft.getFileSize();
                            downloadParam.f7079d = x431PadDtoSoft.getUrl();
                            downloadParam.f7080e = x431PadDtoSoft.getFileName();
                            downloadParam.f7078c = x431PadDtoSoft.getVersionNo();
                            downloadParam.f7081f = PathUtils.m4844l();
                            File file = new File(PathUtils.m4844l() + "/" + x431PadDtoSoft.getFileName());
                            if (file.exists()) {
                                file.delete();
                            }
                            this.f14734W.m9553b(downloadParam);
                            C2558a c2558a2 = new C2558a();
                            c2558a2.f14782a = x431PadDtoSoft.getFileName();
                            c2558a2.f14783b = new Date(System.currentTimeMillis());
                            this.f14772q.add(c2558a2);
                        }
                        this.f14734W.m9556b();
                    }
                    m5942a(this.f14748ak + "...", "");
                    return;
                case 1207:
                    if (obj != null) {
                        ConfigRespose configRespose = (ConfigRespose) obj;
                        if (configRespose.getCode() == 0) {
                            this.f14769n = configRespose.getData().getUrls();
                            this.f14768m = m5941b();
                            for (C2558a c2558a3 : this.f14772q) {
                                if (c2558a3.f14782a.equals("REQ_GET_CONFIG_CODE")) {
                                    c2558a3.f14784c = new Date(System.currentTimeMillis());
                                    d = c2558a3.m5920a();
                                }
                            }
                            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                sb5 = new StringBuilder("\n配置下发检测：\n配置下发检测结果:成功,耗时" + d + "秒\n");
                                sb5.append("外网IP:" + this.f14767l + "\n");
                                sb5.append("内网IP:" + this.f14768m + "\n");
                                sb5.append("当前访问域名:" + this.f14766k + "\n");
                                sb5.append("配置下发入口:" + this.f14764i + ", area:" + this.f14765j + "\n");
                                sb5.append("配置下发的返回内容:\n");
                            } else {
                                sb5 = new StringBuilder("\nTesting config：\nTesting config results:Success,Time of " + d + "seconds\n");
                                sb5.append("Extranet IP:" + this.f14767l + "\n");
                                sb5.append("Intranet IP:" + this.f14768m + "\n");
                                sb5.append("The current access domain:" + this.f14766k + "\n");
                                sb5.append("Config URL:" + this.f14764i + ", area:" + this.f14765j + "\n");
                                sb5.append("Config return:\n");
                            }
                            for (ConfigUrl configUrl : this.f14769n) {
                                sb5.append(configUrl.getKey() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + configUrl.getValue() + " \n");
                            }
                            m5938b(this.f14780y, sb5.toString());
                        } else {
                            C2559b c2559b3 = new C2559b();
                            c2559b3.m5918a(1207, configRespose.getCode(), configRespose.getMessage());
                            this.f14773r.add(c2559b3);
                            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                concat2 = "配置下发检测:\n".concat("配置下发检测结果:失败,错误码：" + configRespose.getCode() + ",错误信息：" + configRespose.getMessage() + "\n");
                            } else {
                                concat2 = "Testing config:\n".concat("Testing config results:Failed,Error code:" + configRespose.getCode() + ",Error message:" + configRespose.getMessage() + "\n");
                            }
                            m5938b(this.f14780y, concat2);
                        }
                    }
                    if (this.f14761f.isEmpty() || this.f14762g.isEmpty()) {
                        new LoginFunction(this.mContext).m6572d();
                        if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                            m5938b(this.f14780y, "\n检测完毕。\n");
                        } else {
                            m5938b(this.f14780y, "\nServer test is done. \n");
                        }
                        m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                        this.f14759d.setEnabled(true);
                        this.f14760e.setEnabled(true);
                        return;
                    }
                    request(1204);
                    return;
                case 1208:
                    LoadDialog.m4681b(this.mContext);
                    if (obj != null) {
                        UploadServerCheckLogResponse uploadServerCheckLogResponse = (UploadServerCheckLogResponse) obj;
                        NLog.m9456a(f14711a, uploadServerCheckLogResponse.toString());
                        if (uploadServerCheckLogResponse.getCode() == 0) {
                            NToast.m9447b(this.mContext, (int) R.string.setting_upload_log_success);
                            m5942a(this.f14751an, "");
                            return;
                        }
                        int code = uploadServerCheckLogResponse.getCode();
                        if (code == 645) {
                            NToast.m9446b(this.mContext, getString(R.string.setting_upload_log_failure_req, new Object[]{645}));
                        } else if (code == 656) {
                            NToast.m9450a(this.mContext, (int) R.string.setting_upload_log_failure_reqnumber_limit);
                        } else if (code == 658) {
                            NToast.m9446b(this.mContext, getString(R.string.setting_upload_log_failure_req, new Object[]{658}));
                        } else {
                            NToast.m9447b(this.mContext, (int) R.string.setting_upload_log_failure);
                        }
                        m5942a(this.f14752ao, "");
                        return;
                    }
                    NToast.m9447b(this.mContext, (int) R.string.setting_upload_log_failure);
                    m5942a(this.f14752ao, "");
                    return;
                case 1209:
                    if (obj != null && (registeredProductsResponse2 = (RegisteredProductsResponse) obj) != null) {
                        if (isSuccess(registeredProductsResponse2.getCode())) {
                            this.f14774s = registeredProductsResponse2.getProductDTOs();
                            List<ProductDTO> list6 = this.f14774s;
                            if (list6 != null && !list6.isEmpty()) {
                                this.f14754aq.addAll(this.f14774s);
                            }
                            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                sb6 = new StringBuilder("\n获取重卡产品序列号测试:\n");
                                sb6.append("产品类型:" + this.f14763h + "\n");
                            } else {
                                sb6 = new StringBuilder("\nTesting getting the heavyduty product serial number:\n");
                                sb6.append("Product types:" + this.f14763h + "\n");
                            }
                            List<ProductDTO> list7 = this.f14774s;
                            if (list7 != null && list7.size() > 0) {
                                while (i2 < this.f14774s.size()) {
                                    ProductDTO productDTO2 = this.f14774s.get(i2);
                                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                        sb6.append("序列号:" + productDTO2.getSerialNo() + "\n");
                                        sb6.append("产品配置:" + productDTO2.getProductConfigName() + "\n");
                                    } else {
                                        sb6.append("Serial Number:" + productDTO2.getSerialNo() + "\n");
                                        sb6.append("Product configuration:" + productDTO2.getProductConfigName() + "\n");
                                    }
                                    if (i2 == 0) {
                                        this.f14775t = productDTO2.getSerialNo();
                                    }
                                    i2++;
                                }
                                m5938b(this.f14780y, sb6.toString());
                                request(2101);
                            } else {
                                if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                                    sb6.append("\n该用户未注册产品，无法获取产品序列号\n检测完毕。\n");
                                } else {
                                    sb6.append("\nThe unregistered user product, unable to obtain the product serial number.\nServer test is done.\n");
                                }
                                m5938b(this.f14780y, sb6.toString());
                                m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                                this.f14759d.setEnabled(true);
                                this.f14760e.setEnabled(true);
                            }
                        } else {
                            C2559b c2559b4 = new C2559b();
                            c2559b4.m5918a(1209, registeredProductsResponse2.getCode(), registeredProductsResponse2.getMessage());
                            this.f14773r.add(c2559b4);
                            m5938b(this.f14780y, ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) ? "获取产品序列号测试:\n".concat("获取产品序列号测试结果:失败,错误码：" + registeredProductsResponse2.getCode() + ",错误信息：" + registeredProductsResponse2.getMessage() + "\n\n检测完毕。\n") : "Testing getting the product serial number:\n".concat("Testing getting the product serial number results:Failed,Error code:" + registeredProductsResponse2.getCode() + ",Error message:" + registeredProductsResponse2.getMessage() + "\n\nServer test is done.\n"));
                            m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                            this.f14759d.setEnabled(true);
                            this.f14760e.setEnabled(true);
                        }
                    }
                    m5937c();
                    this.mContext.sendBroadcast(new Intent("login_change_serialno"));
                    return;
                default:
                    return;
            }
        }
        this.f14737Z = new ArrayList();
        if (obj != null) {
            for (C2558a c2558a4 : this.f14772q) {
                if (c2558a4.f14782a.equals("REQ_QUERYLATESTPUBLICSOFTS_CODE")) {
                    c2558a4.f14784c = new Date(System.currentTimeMillis());
                    d = c2558a4.m5920a();
                }
            }
            this.f14737Z.addAll((List) obj);
            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                sb = new StringBuilder("\n获取软件下载信息结果：成功，耗时" + d + "秒。\n获取公共软件信息:\n");
            } else {
                sb = new StringBuilder("\nThe software download information results:Success,Time of " + d + "seconds.\nThe public software information:\n");
            }
            List<X431PadDtoSoft> list8 = this.f14735X;
            if (list8 != null && list8.size() > 0) {
                for (X431PadDtoSoft x431PadDtoSoft2 : this.f14735X) {
                    sb.append("SoftName：" + x431PadDtoSoft2.getSoftName() + "  ,FileSize：" + x431PadDtoSoft2.getFileSize() + " \n");
                }
            } else {
                if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                    str = "获取公共软件信息:\n";
                    for (C2559b c2559b5 : this.f14773r) {
                        if (c2559b5.f14787a == 2101) {
                            str = str.concat("获取公共软件信息结果:失败,错误码：" + c2559b5.f14788b + ",错误信息：" + c2559b5.f14789c + "\n");
                        }
                    }
                } else {
                    str = "The public software information:\n";
                    for (C2559b c2559b6 : this.f14773r) {
                        if (c2559b6.f14787a == 2101) {
                            str = str.concat("The public software information results:Failed,Error code:" + c2559b6.f14788b + ",Error message:" + c2559b6.f14789c + "\n");
                        }
                    }
                }
                m5938b(this.f14780y, str);
            }
            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                sb.append("\n获取诊断软件信息:\n");
            } else {
                sb.append("\nThe diag software information:\n");
            }
            List<X431PadDtoSoft> list9 = this.f14736Y;
            if (list9 != null && list9.size() > 0) {
                for (X431PadDtoSoft x431PadDtoSoft3 : this.f14736Y) {
                    sb.append("SoftName：" + x431PadDtoSoft3.getSoftName() + "  ,SoftPackageID：" + x431PadDtoSoft3.getSoftPackageID() + "  ,FileSize：" + x431PadDtoSoft3.getFileSize() + " \n");
                }
            } else {
                if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                    sb2 = new StringBuilder("获取诊断软件信息:\n");
                    for (C2559b c2559b7 : this.f14773r) {
                        if (c2559b7.f14787a == 2102) {
                            sb2.append("获取诊断软件信息结果:失败,错误码：" + c2559b7.f14788b + ",错误信息：" + c2559b7.f14789c + "\n");
                        }
                    }
                } else {
                    sb2 = new StringBuilder("The diag software information:\n");
                    for (C2559b c2559b8 : this.f14773r) {
                        if (c2559b8.f14787a == 2102) {
                            sb2.append("The diag software information results:Failed,Error code:" + c2559b8.f14788b + ",Error message:" + c2559b8.f14789c + "\n");
                        }
                    }
                }
                m5938b(this.f14780y, sb2.toString());
            }
            List<X431PadDtoSoft> list10 = this.f14737Z;
            if (list10 != null && list10.size() > 0) {
                if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                    sb.append("\n获取诊断固件包和Demo软件包信息:\n");
                } else {
                    sb.append("\nThe diag firmware package and Demo package information:\n");
                }
                for (X431PadDtoSoft x431PadDtoSoft4 : this.f14737Z) {
                    sb.append("SoftName：" + x431PadDtoSoft4.getSoftName() + "  ,FileSize：" + x431PadDtoSoft4.getFileSize() + " \n");
                }
                m5938b(this.f14780y, sb.toString());
                request(1206);
                return;
            }
            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                sb.append("\n获取诊断固件包和Demo软件包信息:null\n\n检测完毕。\n");
            } else {
                sb.append("\nThe diag firmware package and Demo package information:null\n\nServer test is done.\n");
            }
            m5938b(this.f14780y, sb.toString());
            m5942a(this.f14745ah + "\n" + this.f14744ag, "");
            this.f14759d.setEnabled(true);
            this.f14760e.setEnabled(true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2101) {
            switch (i) {
                case 1203:
                    m5942a(this.f14742ae + "...", this.f14747aj);
                    m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n网站登录测试：\n网站登录测试结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n\n检测完毕。\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting logging on:\nTesting logging on results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n\nServer test is done. \n");
                    }
                    this.f14759d.setEnabled(true);
                    this.f14760e.setEnabled(true);
                    return;
                case 1204:
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n获取产品序列号测试：\n获取产品序列号测试结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n\n检测完毕。\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting getting the product serial number：\nTesting getting the product serial number results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n\nServer test is done. \n");
                    }
                    m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                    this.f14759d.setEnabled(true);
                    this.f14760e.setEnabled(true);
                    return;
                case 1205:
                    m5942a(this.f14740ac + "...", this.f14747aj);
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n检测当前网络环境：\n检测当前网络环境结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting current network environment：\nTesting current network environment results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n");
                    }
                    request(1203);
                    return;
                case 1206:
                    m5942a(this.f14748ak + "...", this.f14747aj);
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n检测文件下载：\n检测文件下载结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n\n检测完毕。\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting file downloading:\nTesting file downloading results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n\nServer test is done.\n");
                    }
                    this.f14759d.setEnabled(true);
                    this.f14760e.setEnabled(true);
                    return;
                case 1207:
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n配置下发测试：\n配置下发测试结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting config：\nTesting config results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n");
                    }
                    request(1204);
                    return;
                case 1208:
                    LoadDialog.m4681b(this.mContext);
                    m5942a(this.f14752ao, "");
                    return;
                case 1209:
                    if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                        m5938b(this.f14780y, "\n获取重卡产品序列号测试：\n获取重卡产品序列号测试结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n\n检测完毕。\n");
                    } else {
                        m5938b(this.f14780y, "\nTesting getting the heavyduty product serial number：\nTesting getting the product serial number results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n\nServer test is done. \n");
                    }
                    m5942a(this.f14745ah + "\n" + this.f14744ag, "");
                    this.f14759d.setEnabled(true);
                    this.f14760e.setEnabled(true);
                    return;
                default:
                    return;
            }
        }
        if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
            m5938b(this.f14780y, "\n获取文件下载信息：\n获取文件下载信息结果：失败,错误码：" + i2 + ",错误信息：" + obj + "\n\n检测完毕。\n");
        } else {
            m5938b(this.f14780y, "\nThe software download information：\nThe software download information results:Failed,Error code:" + i2 + ",Error message:" + obj + "\n\nServer test is done. \n");
        }
        m5942a(this.f14745ah + "\n" + this.f14744ag, "");
        this.f14759d.setEnabled(true);
        this.f14760e.setEnabled(true);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (!this.f14759d.isEnabled() && this.f14717F) {
            if ("CN".equals(this.f14779x) || "TW".equals(this.f14779x)) {
                m5938b(this.f14780y, "\n用户取消检测。\n");
            } else {
                m5938b(this.f14780y, "\nNetwork detection is cancelled by user.\n");
            }
            cancelRequest(1203);
            cancelRequest(1204);
            cancelRequest(1205);
            cancelRequest(1206);
            cancelRequest(1207);
            cancelRequest(2101);
            cancelRequest(2102);
        }
        super.onDestroyView();
    }

    /* renamed from: c */
    private void m5937c() {
        String m9584b = this.f14729R.m9584b("serialNo", "");
        List<SerialNumber> loadAll = this.f14753ap.loadAll();
        for (SerialNumber serialNumber : loadAll) {
            serialNumber.f15832b = Boolean.FALSE;
            serialNumber.f15833c = Boolean.FALSE;
        }
        this.f14753ap.updateInTx(loadAll);
        String str = f14711a;
        NLog.m9456a(str, "allProductDTOList=" + this.f14754aq);
        List<ProductDTO> list = this.f14754aq;
        if (list == null || list.isEmpty()) {
            if (!TextUtils.isEmpty(m9584b)) {
                this.f14729R.m9588a("preSerialNo", m9584b);
            }
            this.f14729R.m9587a("need_refresh", true);
            this.f14729R.m9588a("serialNo", "");
            this.f14729R.m9588a("if_auto_login", "0");
            this.f14729R.m9588a("serialNo", "");
            this.f14729R.m9588a("carSerialNo", "");
            this.f14729R.m9588a("heavydutySerialNo", "");
            this.f14729R.m9588a("carAndHeavydutySerialNo", "");
        } else {
            String m9591a = this.f14729R.m9591a("serialNo");
            String m9591a2 = this.f14729R.m9591a("carSerialNo");
            String m9591a3 = this.f14729R.m9591a("heavydutySerialNo");
            String m9591a4 = this.f14729R.m9591a("carAndHeavydutySerialNo");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (ProductDTO productDTO : this.f14754aq) {
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
                for (int i = 0; i < this.f14754aq.size(); i++) {
                    ProductDTO productDTO2 = this.f14754aq.get(i);
                    String serialNo2 = productDTO2.getSerialNo();
                    SerialNumber serialNumber2 = new SerialNumber();
                    serialNumber2.f15835e = this.f14729R.m9591a("user_id");
                    if (!C2744aa.m5161c(serialNo2, this.mContext)) {
                        serialNumber2.f15833c = Boolean.FALSE;
                    } else if (!z5) {
                        this.f14729R.m9587a("need_refresh", true);
                        this.f14729R.m9588a("carAndHeavydutySerialNo", serialNo2);
                        this.f14729R.m9588a("serialNo", serialNo2);
                        this.f14729R.m9588a("carSerialNo", serialNo2);
                        this.f14729R.m9588a("heavydutySerialNo", serialNo2);
                        serialNumber2.f15833c = Boolean.TRUE;
                        z5 = true;
                    } else {
                        serialNumber2.f15833c = Boolean.FALSE;
                    }
                    serialNumber2.f15832b = Boolean.TRUE;
                    serialNumber2.f15834d = serialNo2;
                    QueryBuilder<SerialNumber> queryBuilder = this.f14753ap.queryBuilder();
                    queryBuilder.where(SerialNumberDao.Properties.SerialNo.m321eq(serialNo2), new WhereCondition[0]);
                    List<SerialNumber> list2 = queryBuilder.list();
                    if (list2 == null || list2.isEmpty()) {
                        this.f14753ap.insert(serialNumber2);
                    } else {
                        serialNumber2.f15831a = list2.get(0).f15831a;
                        this.f14753ap.update(serialNumber2);
                    }
                    RegisterAndLoadInfomation registerAndLoadInfomation = new RegisterAndLoadInfomation(this.mContext, productDTO2.getSerialNo());
                    registerAndLoadInfomation.f15704a = this.f14761f;
                    registerAndLoadInfomation.f15705b = this.f14762g;
                    registerAndLoadInfomation.f15706c = true;
                    registerAndLoadInfomation.m5196a();
                }
            }
            if (!z || (z && (z2 || z3))) {
                this.f14729R.m9588a("carAndHeavydutySerialNo", "");
                boolean z6 = true;
                boolean z7 = true;
                for (int i2 = 0; i2 < this.f14754aq.size(); i2++) {
                    ProductDTO productDTO3 = this.f14754aq.get(i2);
                    String serialNo3 = productDTO3.getSerialNo();
                    SerialNumber serialNumber3 = new SerialNumber();
                    serialNumber3.f15835e = this.f14729R.m9591a("user_id");
                    if (C2744aa.m5168b(serialNo3, this.mContext)) {
                        if (z2) {
                            z6 = false;
                        } else if (z6) {
                            this.f14729R.m9587a("need_refresh", true);
                            this.f14729R.m9588a("carSerialNo", serialNo3);
                            z6 = false;
                        }
                    } else if (C2744aa.m5177a(serialNo3, this.mContext)) {
                        if (z3) {
                            z7 = false;
                        } else if (z7) {
                            this.f14729R.m9587a("need_refresh", true);
                            this.f14729R.m9588a("heavydutySerialNo", serialNo3);
                            z7 = false;
                        }
                    }
                    serialNumber3.f15833c = Boolean.FALSE;
                    serialNumber3.f15832b = Boolean.TRUE;
                    serialNumber3.f15834d = serialNo3;
                    QueryBuilder<SerialNumber> queryBuilder2 = this.f14753ap.queryBuilder();
                    queryBuilder2.where(SerialNumberDao.Properties.SerialNo.m321eq(serialNo3), new WhereCondition[0]);
                    List<SerialNumber> list3 = queryBuilder2.list();
                    if (list3 == null || list3.isEmpty()) {
                        this.f14753ap.insert(serialNumber3);
                    } else {
                        serialNumber3.f15831a = list3.get(0).f15831a;
                        this.f14753ap.update(serialNumber3);
                    }
                    RegisterAndLoadInfomation registerAndLoadInfomation2 = new RegisterAndLoadInfomation(this.mContext, productDTO3.getSerialNo());
                    registerAndLoadInfomation2.f15704a = this.f14761f;
                    registerAndLoadInfomation2.f15705b = this.f14762g;
                    registerAndLoadInfomation2.f15706c = true;
                    registerAndLoadInfomation2.m5196a();
                }
                if (z6) {
                    if (!TextUtils.isEmpty(this.f14729R.m9591a("carSerialNo"))) {
                        this.f14729R.m9588a("carSerialNo", "");
                        this.f14729R.m9587a("need_refresh", true);
                    }
                    if (!z7) {
                        PreferencesManager preferencesManager = this.f14729R;
                        preferencesManager.m9588a("serialNo", preferencesManager.m9591a("heavydutySerialNo"));
                    } else {
                        this.f14729R.m9588a("serialNo", "");
                        if (!TextUtils.isEmpty(this.f14729R.m9591a("heavydutySerialNo"))) {
                            this.f14729R.m9588a("heavydutySerialNo", "");
                            this.f14729R.m9587a("need_refresh", true);
                        }
                    }
                } else {
                    PreferencesManager preferencesManager2 = this.f14729R;
                    preferencesManager2.m9588a("serialNo", preferencesManager2.m9591a("carSerialNo"));
                    if (z7) {
                        if (!TextUtils.isEmpty(this.f14729R.m9591a("heavydutySerialNo"))) {
                            this.f14729R.m9588a("heavydutySerialNo", "");
                            this.f14729R.m9587a("need_refresh", true);
                        }
                    } else {
                        String m9591a5 = this.f14729R.m9591a("carSerialNo");
                        String m9591a6 = this.f14729R.m9591a("heavydutySerialNo");
                        if (TextUtils.isEmpty(m9591a)) {
                            this.f14729R.m9588a("serialNo", m9591a5);
                        } else if (!m9591a2.equals(m9591a5) && !m9591a.equals(m9591a6)) {
                            this.f14729R.m9588a("serialNo", m9591a5);
                        }
                    }
                }
            }
            String m9591a7 = this.f14729R.m9591a("serialNo");
            NLog.m9456a(f14711a, "newCurrentSerialNo=".concat(String.valueOf(m9591a7)));
            List<SerialNumber> loadAll2 = this.f14753ap.loadAll();
            for (SerialNumber serialNumber4 : loadAll2) {
                serialNumber4.f15833c = Boolean.FALSE;
            }
            this.f14753ap.updateInTx(loadAll2);
            if (!TextUtils.isEmpty(m9591a7)) {
                QueryBuilder<SerialNumber> queryBuilder3 = this.f14753ap.queryBuilder();
                queryBuilder3.where(SerialNumberDao.Properties.SerialNo.m321eq(m9591a7), new WhereCondition[0]);
                SerialNumber unique = queryBuilder3.unique();
                unique.f15833c = Boolean.TRUE;
                this.f14753ap.update(unique);
            }
        }
        if (this.f14729R.m9583b("need_refresh", false)) {
            this.mContext.sendBroadcast(new Intent("softs_updated"));
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void cancelRequest(int i) {
        super.cancelRequest(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            this.mContext.unregisterReceiver(this.f14756as);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
