package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p127b.DownLoadCallback;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p239b.OnQueryListener;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p269j.SoftMaxVersionResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestPublicSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.UnZipListener;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.ifoer.expedition.ndk.MakeLicense;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.i */
/* loaded from: classes.dex */
public final class DownloadLogic implements OnDataListener {

    /* renamed from: f */
    public static DownloadLogic f15295f;

    /* renamed from: y */
    private static final int f15296y;

    /* renamed from: J */
    private AsyncTaskManager f15306J;

    /* renamed from: K */
    private String f15307K;

    /* renamed from: L */
    private PathUtils f15308L;

    /* renamed from: a */
    public String f15309a;

    /* renamed from: c */
    DownloadManager f15311c;

    /* renamed from: d */
    ThreadPoolExecutor f15312d;

    /* renamed from: e */
    protected Context f15313e;

    /* renamed from: g */
    DownLoadCallback f15314g;

    /* renamed from: h */
    private PreferencesManager f15315h;

    /* renamed from: i */
    private String f15316i;

    /* renamed from: j */
    private String f15317j;

    /* renamed from: k */
    private String f15318k;

    /* renamed from: l */
    private String f15319l;

    /* renamed from: m */
    private UpgradeAction f15320m;

    /* renamed from: n */
    private CarIconUtils f15321n;

    /* renamed from: o */
    private List<X431PadDtoSoft> f15322o = new Vector();

    /* renamed from: p */
    private List<X431PadDtoSoft> f15323p = new Vector();

    /* renamed from: q */
    private List<X431PadDtoSoft> f15324q = new Vector();

    /* renamed from: r */
    private List<X431PadDtoSoft> f15325r = new Vector();

    /* renamed from: s */
    private OnQueryListener f15326s = null;

    /* renamed from: t */
    private OnQueryListener f15327t = null;

    /* renamed from: u */
    private OnQueryListener f15328u = null;

    /* renamed from: b */
    public OnDownloadListener f15310b = null;

    /* renamed from: v */
    private HandlerThread f15329v = new HandlerThread("DownloadLogic");

    /* renamed from: w */
    private Vector<X431PadDtoSoft> f15330w = new Vector<>();

    /* renamed from: x */
    private MakeLicense f15331x = new MakeLicense();

    /* renamed from: z */
    private Handler f15332z = null;

    /* renamed from: A */
    private final int f15297A = 2;

    /* renamed from: B */
    private final int f15298B = 3;

    /* renamed from: C */
    private final int f15299C = 5;

    /* renamed from: D */
    private final int f15300D = 6;

    /* renamed from: E */
    private final int f15301E = 7;

    /* renamed from: F */
    private final int f15302F = 9;

    /* renamed from: G */
    private final int f15303G = 11;

    /* renamed from: H */
    private final int f15304H = 12;

    /* renamed from: I */
    private final int f15305I = 14;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ OnQueryListener m5602b(DownloadLogic downloadLogic) {
        downloadLogic.f15328u = null;
        return null;
    }

    static {
        System.loadLibrary("LICENSE");
        f15296y = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        f15295f = null;
    }

    /* renamed from: a */
    public static synchronized DownloadLogic m5609a(Context context) {
        DownloadLogic downloadLogic;
        synchronized (DownloadLogic.class) {
            if (f15295f == null) {
                f15295f = new DownloadLogic(context.getApplicationContext());
            }
            downloadLogic = f15295f;
        }
        return downloadLogic;
    }

    private DownloadLogic(Context context) {
        this.f15313e = context;
        this.f15306J = AsyncTaskManager.m9574a(this.f15313e);
        this.f15315h = PreferencesManager.m9595a(this.f15313e);
        this.f15320m = new UpgradeAction(this.f15313e);
        this.f15321n = CarIconUtils.m4977a(this.f15313e);
        this.f15308L = new PathUtils(context);
        this.f15329v.start();
    }

    /* renamed from: a */
    public final synchronized void m5608a(OnQueryListener onQueryListener) {
        this.f15324q.clear();
        this.f15328u = onQueryListener;
        this.f15306J.m9575a(2102, true, this);
    }

    /* renamed from: a */
    public final synchronized void m5604a(String str, String str2, OnDownloadListener onDownloadListener) {
        NLog.m9456a("DownloadLogic", "oneKeyDownloadSpecialSoft 0, softPackageId=".concat(String.valueOf(str2)));
        this.f15310b = onDownloadListener;
        this.f15307K = str2;
        if (TextUtils.isEmpty(str2) && this.f15310b != null) {
            this.f15310b.mo4930b(str2, -1);
        } else if (m5605a(this.f15307K)) {
        } else {
            if (C2787z.m4821a(str)) {
                this.f15309a = this.f15315h.m9591a("serialNo");
            } else if (this.f15330w != null && this.f15330w.size() > 0 && !str.equals(this.f15309a)) {
                this.f15310b.mo4930b(str2, -10);
                return;
            } else {
                this.f15309a = str;
            }
            new C2674j(this).start();
        }
    }

    /* renamed from: a */
    private synchronized void m5611a() {
        if (LangManager.m9468a(this.f15313e).equalsIgnoreCase("zh")) {
            if (LangManager.m9465b(this.f15313e).equalsIgnoreCase("TW")) {
                this.f15318k = LangManager.m9467a(Lang.f7198G);
                this.f15319l = LangManager.m9467a(Lang.f7203a);
            } else if (LangManager.m9465b(this.f15313e).equalsIgnoreCase("HK")) {
                this.f15318k = LangManager.m9467a(Lang.f7197F);
                this.f15319l = LangManager.m9467a(Lang.f7203a);
            } else {
                this.f15318k = LangManager.m9467a(Lang.f7199H);
                this.f15319l = this.f15318k;
            }
        } else {
            this.f15318k = LangManager.m9467a(LangManager.m9468a(this.f15313e));
            this.f15319l = LangManager.m9467a(Lang.f7203a);
        }
        NLog.m9456a("DownloadLogic", "serialNo=" + this.f15309a);
        ConfigDBManager m5398a = ConfigDBManager.m5398a(this.f15313e);
        if (this.f15315h.m9583b("enable_breakpointresume", false)) {
            try {
                this.f15316i = m5398a.m5396a(KeyConstant.f6831ae);
            } catch (C1425f e) {
                e.printStackTrace();
            }
            try {
                this.f15317j = m5398a.m5396a(KeyConstant.f6832af);
            } catch (C1425f e2) {
                e2.printStackTrace();
            }
            NLog.m9456a("DownloadLogic", "diagsoftUrl: " + this.f15317j);
            return;
        }
        try {
            this.f15316i = m5398a.m5396a(KeyConstant.f6830ad);
        } catch (C1425f e3) {
            e3.printStackTrace();
        }
        try {
            this.f15317j = m5398a.m5396a(KeyConstant.f6847au);
            return;
        } catch (C1425f e4) {
            e4.printStackTrace();
            return;
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2102:
                if (C2787z.m4821a(this.f15307K)) {
                    return null;
                }
                m5611a();
                SoftMaxVersionResponse m5274e = this.f15320m.m5274e(this.f15309a, this.f15307K, this.f15318k, this.f15319l);
                NLog.m9456a("DownloadLogic", "REQ_QUERYLATESTDIAGSOFTS_CODE: OK");
                return m5274e;
            case 2103:
                NLog.m9456a("DownloadLogic", "REQ_QUERYAUTOSEARCH_CODE");
                m5611a();
                LatestDiagSoftsResponse m5275d = this.f15320m.m5275d(this.f15309a, "AutoSearch", this.f15318k, this.f15319l);
                if (m5275d != null) {
                    if (m5275d.getCode() == 0) {
                        NLog.m9456a("DownloadLogic", "REQ_QUERYAUTOSEARCH_CODE: " + m5275d.toString());
                        List<X431PadDtoSoft> x431PadSoftList = m5275d.getX431PadSoftList();
                        if (x431PadSoftList != null && x431PadSoftList.size() > 0) {
                            for (X431PadDtoSoft x431PadDtoSoft : x431PadSoftList) {
                                String softPackageID = x431PadDtoSoft.getSoftPackageID();
                                String lanId = x431PadDtoSoft.getLanId();
                                NLog.m9456a("DownloadLogic", "getDiagSoftVersion enter,softId=" + softPackageID + ",lanId=" + lanId);
                                String m4963b = this.f15321n.m4963b(this.f15309a, softPackageID, LangManager.m9464b(lanId));
                                NLog.m9456a("DownloadLogic", "getDiagSoftVersion enter,version=".concat(String.valueOf(m4963b)));
                                if (TextUtils.isEmpty(m4963b)) {
                                    String m9461c = LangManager.m9461c(lanId);
                                    m4963b = this.f15321n.m4963b(this.f15309a, softPackageID, m9461c);
                                    NLog.m9456a("DownloadLogic", "getDiagSoftVersion enter,languageCode1=" + m9461c + ",version=" + m4963b);
                                }
                                if (!TextUtils.isEmpty(m4963b) && m4963b.compareToIgnoreCase("V00.00") == 0) {
                                    m4963b = "";
                                }
                                NLog.m9456a("DownloadLogic", "getDiagSoftVersion exit,version=".concat(String.valueOf(m4963b)));
                                x431PadDtoSoft.setMaxOldVersion(m4963b);
                                if (C2787z.m4820a(x431PadDtoSoft.getVersionNo(), m4963b)) {
                                    x431PadDtoSoft.setChecked(true);
                                }
                                x431PadDtoSoft.setMust(true);
                                x431PadDtoSoft.setType(3);
                                x431PadDtoSoft.setUrl(this.f15317j);
                            }
                        }
                    }
                }
                NLog.m9456a("DownloadLogic", "REQ_QUERYAUTOSEARCH_CODE: OK");
                return m5275d;
            default:
                return null;
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        List<X431PadDtoSoft> x431PadSoftList;
        NLog.m9456a("DownloadLogic", "onSuccess ");
        switch (i) {
            case 2101:
                NLog.m9456a("DownloadLogic", "onSuccess : REQ_QUERYLATESTPUBLICSOFTS_CODE");
                if (obj != null) {
                    LatestPublicSoftsResponse latestPublicSoftsResponse = (LatestPublicSoftsResponse) obj;
                    if ((latestPublicSoftsResponse.getCode() == 0) && (x431PadSoftList = latestPublicSoftsResponse.getX431PadSoftList()) != null) {
                        this.f15323p.addAll(x431PadSoftList);
                        this.f15322o.addAll(this.f15323p);
                        NLog.m9456a("DownloadLogic", "public upgradeList=" + this.f15322o);
                        OnQueryListener onQueryListener = this.f15326s;
                        if (onQueryListener != null) {
                            onQueryListener.mo5586a(0);
                            return;
                        }
                        return;
                    }
                }
                OnQueryListener onQueryListener2 = this.f15326s;
                if (onQueryListener2 != null) {
                    onQueryListener2.mo5586a(-1);
                    return;
                }
                return;
            case 2102:
                NLog.m9456a("DownloadLogic", "onSuccess : REQ_QUERYLATESTDIAGSOFTS_CODE");
                m5610a(i, obj);
                return;
            case 2103:
                NLog.m9456a("DownloadLogic", "onSuccess : REQ_QUERYAUTOSEARCH_CODE");
                m5610a(i, obj);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        NLog.m9456a("DownloadLogic", "onFailure");
        switch (i) {
            case 2101:
                NLog.m9456a("DownloadLogic", "onFailure : REQ_QUERYLATESTPUBLICSOFTS_CODE");
                OnQueryListener onQueryListener = this.f15326s;
                if (onQueryListener != null) {
                    onQueryListener.mo5586a(-1);
                    return;
                }
                return;
            case 2102:
                NLog.m9456a("DownloadLogic", "onFailure : REQ_QUERYLATESTDIAGSOFTS_CODE");
                OnQueryListener onQueryListener2 = this.f15328u;
                if (onQueryListener2 != null) {
                    onQueryListener2.mo5586a(-1);
                    return;
                }
                return;
            case 2103:
                NLog.m9456a("DownloadLogic", "onFailure : REQ_QUERYAUTOSEARCH_CODE");
                OnQueryListener onQueryListener3 = this.f15327t;
                if (onQueryListener3 != null) {
                    onQueryListener3.mo5586a(-1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m5610a(int i, Object obj) {
        OnQueryListener onQueryListener;
        List<X431PadDtoSoft> x431PadSoftList;
        NLog.m9456a("DownloadLogic", "requestCode=" + i + ",result=" + obj);
        if (obj != null) {
            BaseResponse baseResponse = (BaseResponse) obj;
            if (!(baseResponse.getCode() == 0)) {
                baseResponse.getCode();
            } else if (2102 == i) {
                SoftMaxVersionResponse softMaxVersionResponse = (SoftMaxVersionResponse) obj;
                X431PadDtoSoft softMaxVersionByName = softMaxVersionResponse.getSoftMaxVersionByName();
                if (softMaxVersionByName != null) {
                    softMaxVersionByName.setChecked(true);
                    softMaxVersionByName.setType(3);
                    softMaxVersionByName.setUrl(this.f15317j);
                    this.f15324q.add(softMaxVersionResponse.getSoftMaxVersionByName());
                    this.f15322o.add(softMaxVersionResponse.getSoftMaxVersionByName());
                    OnQueryListener onQueryListener2 = this.f15328u;
                    if (onQueryListener2 != null) {
                        onQueryListener2.mo5586a(0);
                        return;
                    }
                    return;
                }
            } else if (2103 == i && (x431PadSoftList = ((LatestDiagSoftsResponse) obj).getX431PadSoftList()) != null) {
                this.f15325r.addAll(x431PadSoftList);
                this.f15322o.addAll(this.f15325r);
                OnQueryListener onQueryListener3 = this.f15327t;
                if (onQueryListener3 != null) {
                    onQueryListener3.mo5586a(0);
                    return;
                }
                return;
            }
        }
        if (2102 == i) {
            OnQueryListener onQueryListener4 = this.f15328u;
            if (onQueryListener4 != null) {
                onQueryListener4.mo5586a(-1);
            }
        } else if (2103 != i || (onQueryListener = this.f15327t) == null) {
        } else {
            onQueryListener.mo5586a(-1);
        }
    }

    /* renamed from: a */
    private static String m5606a(X431PadDtoSoft x431PadDtoSoft) {
        String versionNo = x431PadDtoSoft.getVersionNo();
        if (!versionNo.startsWith("V")) {
            versionNo = "V".concat(String.valueOf(versionNo));
        }
        String replace = versionNo.replace(".", "_");
        StringBuilder sb = new StringBuilder(x431PadDtoSoft.getSoftPackageID() + "_" + replace + "_" + LangManager.m9464b(x431PadDtoSoft.getLanId()));
        if (x431PadDtoSoft.getType() == 1) {
            sb.append(".apk");
        } else if (x431PadDtoSoft.getType() == 2) {
            sb.append(".zip");
        } else if (x431PadDtoSoft.getType() == 3) {
            sb.append(".zip");
        }
        return sb.toString();
    }

    /* compiled from: DownloadLogic.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.i$a */
    /* loaded from: classes.dex */
    class C2672a implements UnZipListener {

        /* renamed from: b */
        private X431PadDtoSoft f15334b;

        C2672a(X431PadDtoSoft x431PadDtoSoft) {
            this.f15334b = null;
            this.f15334b = x431PadDtoSoft;
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4527a() {
            if (this.f15334b == null || DownloadLogic.this.f15310b == null) {
                return;
            }
            this.f15334b.setProgress(0);
            this.f15334b.setState(6);
            DownloadLogic.this.f15310b.mo5613b(this.f15334b.getSoftPackageID());
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4526a(int i, int i2) {
            if (this.f15334b == null || DownloadLogic.this.f15310b == null) {
                return;
            }
            int i3 = (i * 100) / i2;
            this.f15334b.setProgress(i3);
            DownloadLogic.this.f15310b.mo5612c(this.f15334b.getSoftPackageID(), i3);
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: b */
        public final void mo4524b() {
            if (this.f15334b == null || DownloadLogic.this.f15310b == null) {
                return;
            }
            this.f15334b.setProgress(100);
            this.f15334b.setProgress(100);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0040, code lost:
            if (r8.contains("ENOSPC") != false) goto L5;
         */
        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void mo4525a(int r7, java.lang.Throwable r8) {
            /*
                r6 = this;
                java.lang.String r0 = "DownloadLogic"
                r1 = 1
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r3 = "Error code: "
                java.lang.String r4 = java.lang.String.valueOf(r7)
                java.lang.String r3 = r3.concat(r4)
                r4 = 0
                r2[r4] = r3
                com.cnlaunch.p120d.p130d.NLog.m9451c(r0, r2)
                if (r8 == 0) goto L43
                java.lang.String r8 = r8.getMessage()
                java.lang.String r0 = "DownloadLogic"
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r5 = "Error code: "
                r3.<init>(r5)
                r3.append(r7)
                java.lang.String r7 = " strMsg: "
                r3.append(r7)
                r3.append(r8)
                java.lang.String r7 = r3.toString()
                r2[r4] = r7
                com.cnlaunch.p120d.p130d.NLog.m9451c(r0, r2)
                java.lang.String r7 = "ENOSPC"
                boolean r7 = r8.contains(r7)
                if (r7 == 0) goto L43
                goto L44
            L43:
                r1 = 0
            L44:
                com.cnlaunch.x431pro.module.j.b.l r7 = r6.f15334b
                if (r7 == 0) goto L9a
                com.cnlaunch.x431pro.activity.upgrade.c.i r8 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                java.lang.String r7 = r7.getSoftPackageID()
                r8.m5601b(r7)
                com.cnlaunch.x431pro.module.j.b.l r7 = r6.f15334b
                r8 = 100
                r7.setProgress(r8)
                if (r1 == 0) goto L94
                com.cnlaunch.x431pro.module.j.b.l r7 = r6.f15334b
                r8 = 7
                r7.setState(r8)
                com.cnlaunch.x431pro.activity.upgrade.c.i r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                com.cnlaunch.d.c.b.b r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.m5594i(r7)
                r8 = 0
                r7.f7053a = r8
                com.cnlaunch.x431pro.activity.upgrade.c.i r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.m5591l(r7)
                r8 = 9
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.c.i r8 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                android.os.Handler r8 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.m5591l(r8)
                r8.sendMessage(r7)
                com.cnlaunch.x431pro.activity.upgrade.c.i r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.m5591l(r7)
                r8 = 11
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.c.i r8 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.this
                android.os.Handler r8 = com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.m5591l(r8)
                r8.sendMessage(r7)
                return
            L94:
                com.cnlaunch.x431pro.module.j.b.l r7 = r6.f15334b
                r8 = 5
                r7.setState(r8)
            L9a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.C2672a.mo4525a(int, java.lang.Throwable):void");
        }
    }

    /* compiled from: DownloadLogic.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.i$b */
    /* loaded from: classes.dex */
    class RunnableC2673b implements Runnable {

        /* renamed from: b */
        private String f15336b;

        /* renamed from: c */
        private String f15337c;

        /* renamed from: d */
        private String f15338d;

        public RunnableC2673b(String str, String str2, String str3) {
            this.f15336b = str;
            this.f15337c = str2;
            this.f15338d = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x02b5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 1054
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic.RunnableC2673b.run():void");
        }
    }

    /* renamed from: a */
    public final boolean m5605a(String str) {
        Vector<X431PadDtoSoft> vector;
        if (C2787z.m4821a(str) || (vector = this.f15330w) == null || vector.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f15330w.size(); i++) {
            if (str.equals(this.f15330w.get(i).getSoftPackageID())) {
                NLog.m9451c("msp", "isdown: " + this.f15330w.get(i).getState() + "   " + this.f15311c.m9557a(m5606a(this.f15330w.get(i))));
                if (this.f15330w.get(i).getState() == 6) {
                    return true;
                }
                DownloadManager downloadManager = this.f15311c;
                if (downloadManager != null) {
                    return downloadManager.m9557a(m5606a(this.f15330w.get(i)));
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m5601b(String str) {
        Handler handler;
        if (!C2787z.m4821a(str) && !C2787z.m4819a(this.f15330w)) {
            for (int size = this.f15330w.size() - 1; size >= 0; size--) {
                if (str.equals(this.f15330w.get(size).getSoftPackageID())) {
                    this.f15330w.remove(size);
                }
            }
        }
        NLog.m9451c("DownloadLogic", "removeSoftByPackageId:" + str + "  downLoadListSize：" + this.f15330w.size());
        if (!C2787z.m4819a(this.f15330w) || (handler = this.f15332z) == null) {
            return;
        }
        this.f15332z.sendMessage(handler.obtainMessage(3, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m5603b() {
        if (this.f15322o != null) {
            for (int i = 0; i < this.f15322o.size() - 1; i++) {
                for (int size = this.f15322o.size() - 1; size > i; size--) {
                    if (this.f15322o.get(size).getSoftPackageID().equals(this.f15322o.get(i).getSoftPackageID())) {
                        this.f15322o.remove(size);
                    }
                }
            }
        }
        if (this.f15322o != null) {
            Collections.sort(this.f15322o, new C2676l(this));
            Collections.sort(this.f15322o, new C2677m(this));
            Collections.sort(this.f15322o, new C2678n(this));
        }
        return this.f15322o.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m5596g(DownloadLogic downloadLogic) {
        NLog.m9456a("DownloadLogic", "Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors() + ", DEFAULT_MAX_CONNECTIONS: " + f15296y);
        downloadLogic.f15312d = (ThreadPoolExecutor) Executors.newFixedThreadPool(f15296y);
        downloadLogic.f15311c = DownloadManager.m9565a();
        if (downloadLogic.f15314g == null) {
            downloadLogic.f15314g = new HandlerC2680p(downloadLogic, downloadLogic.f15329v.getLooper());
        }
        downloadLogic.f15311c.f7053a = downloadLogic.f15314g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ void m5595h(DownloadLogic downloadLogic) {
        if (downloadLogic.m5603b() <= 0) {
            NLog.m9456a("DownloadLogic", "initData, getDownloadList <= 0");
            return;
        }
        NLog.m9456a("DownloadLogic", "initData up: upgradeList" + downloadLogic.f15322o);
        NLog.m9456a("DownloadLogic", "initData up: downloadList" + downloadLogic.f15330w);
        for (X431PadDtoSoft x431PadDtoSoft : downloadLogic.f15322o) {
            if (4 != x431PadDtoSoft.getState() && !downloadLogic.m5605a(x431PadDtoSoft.getSoftPackageID())) {
                C1426i c1426i = new C1426i();
                c1426i.m9506a("serialNo", downloadLogic.f15309a);
                c1426i.m9506a("versionDetailId", x431PadDtoSoft.getVersionDetailId());
                x431PadDtoSoft.setFileName(m5606a(x431PadDtoSoft));
                x431PadDtoSoft.setState(0);
                x431PadDtoSoft.setProgress(0);
                DownloadParam downloadParam = new DownloadParam();
                downloadParam.f7076a = downloadLogic.f15313e;
                downloadParam.f7077b = c1426i;
                downloadParam.f7082g = x431PadDtoSoft.getFileSize();
                downloadParam.f7079d = x431PadDtoSoft.getUrl();
                downloadParam.f7080e = x431PadDtoSoft.getFileName();
                downloadParam.f7078c = x431PadDtoSoft.getVersionNo();
                downloadParam.f7081f = PathUtils.m4852e();
                downloadParam.f7083h = PreferencesManager.m9595a(downloadLogic.f15313e).m9583b("enable_breakpointresume", false);
                NLog.m9456a("DownloadLogic", "initData, getFileName: " + x431PadDtoSoft.getFileName() + ", getDownPath: " + downloadParam.f7081f + ", getUrl: " + downloadParam.f7079d);
                downloadLogic.f15311c.m9561a(downloadParam);
                downloadLogic.f15330w.add(x431PadDtoSoft);
            }
        }
    }
}
