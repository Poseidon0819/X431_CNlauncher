package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.GetLatestApkVersionResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestApkVersionInfo;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.ApkUpgradeProgressDialog;
import com.google.gson.Gson;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.a */
/* loaded from: classes.dex */
public final class ApkUpgradeAndDownloadLogic implements OnDataListener {

    /* renamed from: A */
    private int f15252A;

    /* renamed from: D */
    private OnQueryListener f15255D;

    /* renamed from: E */
    private String f15256E;

    /* renamed from: c */
    DownloadManager f15259c;

    /* renamed from: d */
    ThreadPoolExecutor f15260d;

    /* renamed from: e */
    public Map<String, String> f15261e;

    /* renamed from: g */
    public ApkUpgradeProgressDialog f15263g;

    /* renamed from: h */
    DownLoadCallback f15264h;

    /* renamed from: v */
    private Context f15277v;

    /* renamed from: w */
    private AsyncTaskManager f15278w;

    /* renamed from: x */
    private PreferencesManager f15279x;

    /* renamed from: y */
    private UpgradeAction f15280y;

    /* renamed from: t */
    private static final int f15251t = (Runtime.getRuntime().availableProcessors() * 2) + 1;

    /* renamed from: a */
    public static ApkUpgradeAndDownloadLogic f15250a = null;

    /* renamed from: j */
    private final int f15266j = 2;

    /* renamed from: k */
    private final int f15267k = 3;

    /* renamed from: l */
    private final int f15268l = 5;

    /* renamed from: m */
    private final int f15269m = 6;

    /* renamed from: n */
    private final int f15270n = 7;

    /* renamed from: o */
    private final int f15271o = 9;

    /* renamed from: p */
    private final int f15272p = 11;

    /* renamed from: q */
    private final int f15273q = 12;

    /* renamed from: r */
    private final int f15274r = 14;

    /* renamed from: s */
    private Handler f15275s = null;

    /* renamed from: u */
    private HandlerThread f15276u = new HandlerThread("ApkUpgradeAndDownloadLogic");

    /* renamed from: b */
    public boolean f15258b = false;

    /* renamed from: z */
    private boolean f15281z = false;

    /* renamed from: B */
    private OnDownloadListener f15253B = null;

    /* renamed from: C */
    private int f15254C = 0;

    /* renamed from: f */
    public int f15262f = 0;

    /* renamed from: F */
    private String f15257F = "";

    /* renamed from: i */
    BroadcastReceiver f15265i = new C2671h(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ OnQueryListener m5633a(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic) {
        apkUpgradeAndDownloadLogic.f15255D = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ boolean m5617k(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic) {
        apkUpgradeAndDownloadLogic.f15281z = false;
        return false;
    }

    /* renamed from: a */
    public static synchronized ApkUpgradeAndDownloadLogic m5636a(Context context) {
        ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic;
        synchronized (ApkUpgradeAndDownloadLogic.class) {
            if (f15250a == null) {
                f15250a = new ApkUpgradeAndDownloadLogic(context.getApplicationContext());
            }
            apkUpgradeAndDownloadLogic = f15250a;
        }
        return apkUpgradeAndDownloadLogic;
    }

    private ApkUpgradeAndDownloadLogic(Context context) {
        this.f15252A = 0;
        this.f15277v = context.getApplicationContext();
        this.f15278w = AsyncTaskManager.m9574a(this.f15277v);
        this.f15279x = PreferencesManager.m9595a(this.f15277v);
        this.f15280y = new UpgradeAction(this.f15277v);
        this.f15252A = this.f15279x.m9585b("auto_download_select", 0);
        this.f15256E = this.f15279x.m9591a("apk_soft_name");
        this.f15276u.start();
        this.f15277v.registerReceiver(this.f15265i, new IntentFilter("mia_control_installApp_result"));
        this.f15261e = new HashMap();
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 80001) {
            return null;
        }
        String m9591a = PreferencesManager.m9595a(this.f15277v).m9591a("apk_soft_name");
        String m5112a = ApkUpgradeUtils.m5112a();
        String m5124r = C2744aa.m5124r(this.f15277v);
        if (TextUtils.isEmpty(m5124r)) {
            m5124r = C2778n.m4893f(this.f15277v);
        }
        return this.f15280y.m5277c(m9591a, m5112a, m5124r);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i != 80001) {
            return;
        }
        if (obj != null) {
            GetLatestApkVersionResponse getLatestApkVersionResponse = (GetLatestApkVersionResponse) obj;
            if (getLatestApkVersionResponse != null && getLatestApkVersionResponse.isSuccess()) {
                LatestApkVersionInfo appSoftSoftMaxVersion = getLatestApkVersionResponse.getAppSoftSoftMaxVersion();
                if (appSoftSoftMaxVersion != null) {
                    String m5106b = ApkUpgradeUtils.m5106b(this.f15277v);
                    String versionNo = appSoftSoftMaxVersion.getVersionNo();
                    NLog.m9456a("yhx", "currentVersionNo=" + m5106b + ",latestVersionNo=" + versionNo);
                    if (!TextUtils.isEmpty(versionNo) && versionNo.compareTo(m5106b) > 0) {
                        this.f15279x.m9587a("has_new_apk_version", true);
                    } else {
                        this.f15279x.m9587a("has_new_apk_version", false);
                    }
                    String json = new Gson().toJson(getLatestApkVersionResponse.getAppSoftSoftMaxVersion());
                    NLog.m9456a("yhx", "json=".concat(String.valueOf(json)));
                    this.f15279x.m9588a("apk_soft_info", json);
                    if (!TextUtils.isEmpty(appSoftSoftMaxVersion.getForceUpgrade())) {
                        try {
                            this.f15262f = Integer.valueOf(appSoftSoftMaxVersion.getForceUpgrade()).intValue();
                        } catch (Exception e) {
                            NLog.m9455a(e);
                        }
                    }
                    OnQueryListener onQueryListener = this.f15255D;
                    if (onQueryListener != null) {
                        onQueryListener.mo5586a(0);
                        return;
                    }
                    return;
                }
                return;
            }
            OnQueryListener onQueryListener2 = this.f15255D;
            if (onQueryListener2 != null) {
                onQueryListener2.mo5586a(-1);
                return;
            }
            return;
        }
        OnQueryListener onQueryListener3 = this.f15255D;
        if (onQueryListener3 != null) {
            onQueryListener3.mo5586a(-1);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        OnQueryListener onQueryListener;
        if (i == 80001 && (onQueryListener = this.f15255D) != null) {
            onQueryListener.mo5586a(-1);
        }
    }

    /* renamed from: a */
    public final void m5634a(OnQueryListener onQueryListener) {
        this.f15255D = onQueryListener;
        this.f15278w.m9575a(80001, true, this);
    }

    /* renamed from: a */
    public final boolean m5629a(String str) {
        DownloadManager downloadManager = this.f15259c;
        boolean z = downloadManager != null && downloadManager.m9557a(m5625c(str));
        NLog.m9456a("yhx", "isHasApkDownLoading.result=" + z + ",versionNo=" + str);
        return z;
    }

    /* renamed from: b */
    public static boolean m5627b(String str) {
        boolean z = !TextUtils.isEmpty(str) && DownloadManager.m9565a().m9550b(str);
        NLog.m9456a("yhx", "isApkDownLoading.result=" + z + ",downloadId=" + str);
        return z;
    }

    /* renamed from: c */
    public final String m5625c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("V")) {
            str = "V".concat(String.valueOf(str));
        }
        String replace = str.replace(".", "_");
        String m5107b = ApkUpgradeUtils.m5107b();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f15256E);
        stringBuffer.append("_");
        stringBuffer.append(replace);
        stringBuffer.append("_");
        stringBuffer.append(m5107b);
        stringBuffer.append(".apk");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final void m5635a(OnDownloadListener onDownloadListener, boolean z) {
        NLog.m9456a("yhx", "downloadAndInstallLatestApk enter.isInstall=".concat(String.valueOf(z)));
        this.f15253B = onDownloadListener;
        this.f15281z = z;
        this.f15258b = false;
        new C2665b(this, z).start();
    }

    /* compiled from: ApkUpgradeAndDownloadLogic.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.a$a */
    /* loaded from: classes.dex */
    class RunnableC2664a implements Runnable {

        /* renamed from: b */
        private String f15283b;

        public RunnableC2664a(String str) {
            this.f15283b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NLog.m9456a("yhx", "InstallThread.run enter.filePath=" + this.f15283b);
            Process.setThreadPriority(19);
            ApkUpgradeAndDownloadLogic.this.f15258b = true;
            if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                ApkUpgradeAndDownloadLogic.this.f15253B.mo5613b(ApkUpgradeAndDownloadLogic.this.f15256E);
            }
            if (ApkUpgradeAndDownloadLogic.this.f15277v != null) {
                if (ApkUpgradeAndDownloadLogic.this.f15262f != 1 || !ApkUpgradeUtils.m5104c()) {
                    if (ApkUpgradeAndDownloadLogic.this.f15262f != 1 || !C2744aa.m5132n(ApkUpgradeAndDownloadLogic.this.f15277v)) {
                        ApkUpgradeAndDownloadLogic.this.f15254C = 6;
                        C2778n.m4903b(ApkUpgradeAndDownloadLogic.this.f15277v, this.f15283b);
                        if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                            ApkUpgradeAndDownloadLogic.this.f15253B.mo4929d(ApkUpgradeAndDownloadLogic.this.f15256E, 0);
                            return;
                        }
                        return;
                    }
                    PackageInfo packageArchiveInfo = ApkUpgradeAndDownloadLogic.this.f15277v.getPackageManager().getPackageArchiveInfo(this.f15283b, 1);
                    if (packageArchiveInfo == null) {
                        NLog.m9456a("yhx", "PackageInfo is null");
                    } else {
                        ApkUpgradeAndDownloadLogic.this.f15261e.put(packageArchiveInfo.packageName, ApkUpgradeAndDownloadLogic.this.f15256E);
                    }
                    Intent intent = new Intent("mia_control_installApp");
                    intent.putExtra("apkName", Uri.fromFile(new File(this.f15283b)));
                    if (Build.VERSION.SDK_INT >= 26) {
                        intent.setPackage("com.android.settings");
                    }
                    if (CommonTools.m7967b()) {
                        intent.setComponent(new ComponentName("com.lenovo.staticinstall", "com.lenovo.staticinstall.SilentInstallReceiver"));
                    }
                    ApkUpgradeAndDownloadLogic.this.f15277v.sendBroadcast(intent);
                    return;
                }
                ApkUpgradeAndDownloadLogic.this.f15254C = 6;
                int m4896d = C2778n.m4896d(ApkUpgradeAndDownloadLogic.this.f15277v, this.f15283b);
                if (-2 == m4896d && !TextUtils.isEmpty(ApkUpgradeAndDownloadLogic.this.f15256E) && (m4896d = C2778n.m4913a(ApkUpgradeAndDownloadLogic.this.f15256E)) == 0) {
                    m4896d = C2778n.m4896d(ApkUpgradeAndDownloadLogic.this.f15277v, this.f15283b);
                }
                if (m4896d == 0) {
                    if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                        ApkUpgradeAndDownloadLogic.this.f15253B.mo4929d(ApkUpgradeAndDownloadLogic.this.f15256E, 0);
                    }
                } else if (-2 == m4896d) {
                    ApkUpgradeAndDownloadLogic.this.f15254C = 5;
                    if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                        ApkUpgradeAndDownloadLogic.this.f15253B.mo4929d(ApkUpgradeAndDownloadLogic.this.f15256E, -1);
                    }
                } else if (-3 == m4896d) {
                    ApkUpgradeAndDownloadLogic.this.f15254C = 7;
                    if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                        ApkUpgradeAndDownloadLogic.this.f15253B.mo4929d(ApkUpgradeAndDownloadLogic.this.f15256E, -1);
                    }
                } else {
                    ApkUpgradeAndDownloadLogic.this.f15254C = 5;
                    if (ApkUpgradeAndDownloadLogic.this.f15253B != null) {
                        ApkUpgradeAndDownloadLogic.this.f15253B.mo4929d(ApkUpgradeAndDownloadLogic.this.f15256E, -1);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m5637a() {
        ApkUpgradeProgressDialog apkUpgradeProgressDialog = this.f15263g;
        return apkUpgradeProgressDialog != null && apkUpgradeProgressDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m5622f(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic) {
        NLog.m9456a("yhx", "Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors() + ", DEFAULT_MAX_CONNECTIONS: " + f15251t);
        apkUpgradeAndDownloadLogic.f15260d = (ThreadPoolExecutor) Executors.newFixedThreadPool(f15251t);
        apkUpgradeAndDownloadLogic.f15259c = DownloadManager.m9565a();
        if (apkUpgradeAndDownloadLogic.f15264h == null) {
            apkUpgradeAndDownloadLogic.f15264h = new HandlerC2667d(apkUpgradeAndDownloadLogic, apkUpgradeAndDownloadLogic.f15276u.getLooper());
        }
        apkUpgradeAndDownloadLogic.f15259c.f7053a = apkUpgradeAndDownloadLogic.f15264h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5631a(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic, LatestApkVersionInfo latestApkVersionInfo) {
        DownloadManager downloadManager;
        if (4 != apkUpgradeAndDownloadLogic.f15254C) {
            String versionNo = latestApkVersionInfo.getVersionNo();
            boolean m9557a = (TextUtils.isEmpty(versionNo) || (downloadManager = apkUpgradeAndDownloadLogic.f15259c) == null) ? false : downloadManager.m9557a(apkUpgradeAndDownloadLogic.m5625c(versionNo));
            NLog.m9456a("yhx", "isDownloading.result=".concat(String.valueOf(m9557a)));
            if (m9557a) {
                return;
            }
            C1426i c1426i = new C1426i();
            c1426i.m9506a("versionDetailId", latestApkVersionInfo.getVersionDetailId());
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.f7076a = apkUpgradeAndDownloadLogic.f15277v;
            downloadParam.f7077b = c1426i;
            downloadParam.f7082g = latestApkVersionInfo.getFileSize();
            downloadParam.f7079d = ApkUpgradeUtils.m5101d(apkUpgradeAndDownloadLogic.f15277v);
            downloadParam.f7080e = apkUpgradeAndDownloadLogic.m5625c(latestApkVersionInfo.getVersionNo());
            downloadParam.f7078c = latestApkVersionInfo.getVersionNo();
            downloadParam.f7081f = PathUtils.m4852e();
            downloadParam.f7085j = latestApkVersionInfo.getVersionDetailId();
            downloadParam.f7083h = PreferencesManager.m9595a(apkUpgradeAndDownloadLogic.f15277v).m9583b("enable_breakpointresume", false);
            NLog.m9456a("yhx", "initData, getFileName: " + downloadParam.f7080e + ", getDownPath: " + downloadParam.f7081f + ", getUrl: " + downloadParam.f7079d + ",id=" + latestApkVersionInfo.getVersionDetailId());
            apkUpgradeAndDownloadLogic.f15259c.m9561a(downloadParam);
        }
    }
}
