package com.cnlaunch.x431pro.activity.upgrade;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.LruCacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadLog;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.UnZipListener;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.ndk.MakeLicense;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"HandlerLeak", "NewApi"})
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.f */
/* loaded from: classes.dex */
public class DownloadFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: A */
    private ListView f15349A;

    /* renamed from: B */
    private IconButton f15350B;

    /* renamed from: C */
    private IconButton f15351C;

    /* renamed from: D */
    private List<DownloadSoftDto> f15352D;

    /* renamed from: N */
    private ThreadPoolExecutor f15362N;

    /* renamed from: O */
    private Context f15363O;

    /* renamed from: P */
    private PathUtils f15364P;

    /* renamed from: T */
    private TextView f15368T;

    /* renamed from: ac */
    private Map<String, String> f15378ac;

    /* renamed from: ad */
    private CarIconUtils f15379ad;

    /* renamed from: d */
    public Map<String, String> f15383d;

    /* renamed from: v */
    private DownloadManager f15401v;

    /* renamed from: w */
    private DownloadAdapter f15402w;

    /* renamed from: y */
    private TextView f15404y;

    /* renamed from: z */
    private TextView f15405z;

    /* renamed from: g */
    private final String f15386g = DownloadFragment.class.getSimpleName();

    /* renamed from: a */
    public final int f15375a = 9010;

    /* renamed from: h */
    private final int f15387h = 1;

    /* renamed from: i */
    private final int f15388i = 2;

    /* renamed from: j */
    private final int f15389j = 3;

    /* renamed from: k */
    private final int f15390k = 4;

    /* renamed from: l */
    private final int f15391l = 5;

    /* renamed from: m */
    private final int f15392m = 6;

    /* renamed from: n */
    private final int f15393n = 7;

    /* renamed from: o */
    private final int f15394o = 8;

    /* renamed from: p */
    private final int f15395p = 9;

    /* renamed from: q */
    private final int f15396q = 10;

    /* renamed from: r */
    private final int f15397r = 11;

    /* renamed from: s */
    private final int f15398s = 12;

    /* renamed from: t */
    private final int f15399t = 13;

    /* renamed from: u */
    private final int f15400u = 14;

    /* renamed from: x */
    private Handler f15403x = null;

    /* renamed from: E */
    private String f15353E = "";

    /* renamed from: F */
    private volatile Integer f15354F = 0;

    /* renamed from: G */
    private volatile Integer f15355G = 0;

    /* renamed from: H */
    private volatile Integer f15356H = 0;

    /* renamed from: I */
    private Integer f15357I = 0;

    /* renamed from: J */
    private Integer f15358J = 0;

    /* renamed from: K */
    private volatile boolean f15359K = false;

    /* renamed from: L */
    private boolean f15360L = false;

    /* renamed from: M */
    private boolean f15361M = true;

    /* renamed from: Q */
    private boolean f15365Q = false;

    /* renamed from: R */
    private BroadcastReceiver f15366R = null;

    /* renamed from: S */
    private IntentFilter f15367S = null;

    /* renamed from: U */
    private long f15369U = 0;

    /* renamed from: V */
    private long f15370V = System.currentTimeMillis();

    /* renamed from: W */
    private int f15371W = 0;

    /* renamed from: X */
    private UpdateDownloadLogDao f15372X = null;

    /* renamed from: Y */
    private String f15373Y = "1";

    /* renamed from: Z */
    private Timer f15374Z = null;

    /* renamed from: aa */
    private TimerTask f15376aa = null;

    /* renamed from: ab */
    private boolean f15377ab = false;

    /* renamed from: b */
    public String f15381b = "";

    /* renamed from: c */
    public String f15382c = "";

    /* renamed from: e */
    public int f15384e = -999;

    /* renamed from: ae */
    private MakeLicense f15380ae = new MakeLicense();

    /* renamed from: f */
    BroadcastReceiver f15385f = new C2698t(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m5558a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 6:
                return 3;
            case 3:
            default:
                return 4;
            case 4:
                return 1;
            case 5:
                return 2;
        }
    }

    /* renamed from: aT */
    static /* synthetic */ boolean m5524aT(DownloadFragment downloadFragment) {
        downloadFragment.f15359K = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ boolean m5484f(DownloadFragment downloadFragment) {
        downloadFragment.f15377ab = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        this.f15401v.m9549c();
        this.f15362N.shutdownNow();
        if (this.f15366R != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15366R);
            this.f15366R = null;
            NLog.m9456a(this.f15386g, "onDestroy: unregisterReceiver: mLogoutBroadcast");
        }
        if (this.f15385f != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15385f);
            this.f15385f = null;
        }
        if (this.f15385f != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15385f);
            this.f15385f = null;
        }
        if (PreferencesManager.m9595a(this.mContext).m9583b("enable_upload_downloadlog", false)) {
            m5475k();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (this.f15366R != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15366R);
            this.f15366R = null;
        }
        if (this.f15385f != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15385f);
            this.f15385f = null;
        }
        if (this.f15385f != null && this.mContext != null) {
            this.mContext.unregisterReceiver(this.f15385f);
            this.f15385f = null;
        }
        super.onDestroyView();
    }

    /* renamed from: a */
    public final void m5544a(boolean z) {
        this.f15350B.setEnabled(z);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f15379ad = CarIconUtils.m4977a(this.mContext);
        this.f15363O = getActivity();
        this.f15364P = new PathUtils(this.f15363O);
        setTitle(R.string.tab_menu_upgrade);
        this.f15353E = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f15404y = (TextView) this.mContentView.findViewById(R.id.tv_statistics);
        this.f15405z = (TextView) this.mContentView.findViewById(R.id.tv_spinner_serialNo);
        this.f15405z.setText(this.f15353E);
        this.f15350B = (IconButton) getActivity().findViewById(R.id.radio_download);
        this.f15350B.setOnClickListener(this);
        this.f15351C = (IconButton) getActivity().findViewById(R.id.radio_home);
        this.f15351C.setOnClickListener(this);
        this.f15368T = (TextView) getActivity().findViewById(R.id.networkspeed);
        this.f15369U = m5479i();
        this.f15377ab = false;
        this.f15366R = new C2685g(this);
        this.f15367S = new IntentFilter("logout");
        this.mContext.registerReceiver(this.f15366R, this.f15367S);
        this.mContext.registerReceiver(this.f15385f, new IntentFilter("mia_control_installApp_result"));
        this.f15383d = new HashMap();
        this.f15378ac = new HashMap();
        m5559a();
        this.f15403x = new HandlerC2687i(this);
        m5491c();
        m5493b();
        if (PreferencesManager.m9595a(this.mContext).m9583b("enable_upload_downloadlog", false)) {
            this.f15372X = DBManager.m5036a(this.mContext).f15794a.f15801d;
        }
        this.f15365Q = DownloadAdapter.m5811a();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.upgrade_download_fragment, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f15377ab) {
            popBackStack();
            this.f15377ab = false;
        }
        m5481h();
    }

    /* renamed from: a */
    private void m5559a() {
        ArrayList<DownloadSoftDto> arrayList = (ArrayList) LruCacheManager.m9599a().m9597a("downloadList");
        this.f15352D = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            for (DownloadSoftDto downloadSoftDto : arrayList) {
                if (4 != downloadSoftDto.f15579e.intValue()) {
                    this.f15352D.add(downloadSoftDto);
                }
            }
        }
        this.f15402w = new DownloadAdapter(this.mContext, this);
        this.f15349A = (ListView) getActivity().findViewById(R.id.listview);
        DownloadAdapter downloadAdapter = this.f15402w;
        downloadAdapter.f15005a = this.f15352D;
        this.f15349A.setAdapter((ListAdapter) downloadAdapter);
        this.f15402w.notifyDataSetChanged();
        this.f15354F = 0;
        this.f15355G = 0;
        this.f15356H = 0;
        this.f15404y.setText(m5546a(String.valueOf(this.f15355G), String.valueOf(this.f15352D.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5493b() {
        String m9584b = PreferencesManager.m9595a(this.mContext).m9584b("current_country", "");
        if (!TextUtils.isEmpty(m9584b) && "CN".equalsIgnoreCase(m9584b)) {
            this.f15373Y = "0";
        } else {
            this.f15373Y = "1";
        }
        this.f15360L = false;
        if (PreferencesManager.m9595a(this.mContext).m9583b("isconflict", false)) {
            this.f15403x.sendMessage(this.f15403x.obtainMessage(4, 0, 0));
        } else if (PreferencesManager.m9595a(this.mContext).m9584b("token", "").isEmpty()) {
            this.f15403x.sendMessage(this.f15403x.obtainMessage(5, 0, 0));
        } else {
            List<DownloadSoftDto> list = this.f15352D;
            if (list != null) {
                for (DownloadSoftDto downloadSoftDto : list) {
                    if (4 != downloadSoftDto.f15579e.intValue() && (2 != downloadSoftDto.f15579e.intValue() || this.f15365Q || 1 != downloadSoftDto.f15577c)) {
                        if (1 == downloadSoftDto.f15577c && this.f15361M) {
                            this.f15358J = Integer.valueOf(this.f15358J.intValue() + 1);
                        }
                        C1426i c1426i = new C1426i();
                        if (downloadSoftDto.f15577c == 4) {
                            c1426i.m9506a("serialNo", this.f15353E);
                            c1426i.m9506a("spfId", downloadSoftDto.f15581g);
                        } else {
                            c1426i.m9506a("serialNo", this.f15353E);
                            c1426i.m9506a("versionDetailId", downloadSoftDto.f15581g);
                        }
                        String replace = downloadSoftDto.f15576b.replace(".", "_");
                        StringBuilder sb = new StringBuilder(TextUtils.isEmpty(downloadSoftDto.f15585k) ? downloadSoftDto.f15584j + "_" + replace : downloadSoftDto.f15584j + "_" + replace + "_" + LangManager.m9464b(downloadSoftDto.f15585k));
                        if (downloadSoftDto.f15577c == 1) {
                            sb.append(".apk");
                        } else if (downloadSoftDto.f15577c == 2) {
                            sb.append(".zip");
                        } else if (downloadSoftDto.f15577c == 3) {
                            sb.append(".zip");
                        } else if (downloadSoftDto.f15577c == 4) {
                            sb.append(".zip");
                        }
                        downloadSoftDto.f15580f = sb.toString();
                        downloadSoftDto.f15579e = 0;
                        downloadSoftDto.f15578d = 0;
                        DownloadParam downloadParam = new DownloadParam();
                        downloadParam.f7076a = this.mContext;
                        downloadParam.f7077b = c1426i;
                        downloadParam.f7082g = downloadSoftDto.f15582h;
                        downloadParam.f7079d = downloadSoftDto.f15583i;
                        downloadParam.f7080e = downloadSoftDto.f15580f;
                        downloadParam.f7078c = downloadSoftDto.f15576b;
                        downloadParam.f7081f = PathUtils.m4852e();
                        downloadParam.f7083h = PreferencesManager.m9595a(this.mContext).m9583b("enable_breakpointresume", false);
                        downloadParam.f7084i = downloadSoftDto.f15577c;
                        downloadParam.f7085j = downloadSoftDto.f15581g;
                        this.f15401v.m9553b(downloadParam);
                    }
                }
                this.f15401v.m9556b();
            }
            this.f15361M = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5491c() {
        if (PreferencesManager.m9595a(this.mContext).m9583b("enable_upload_downloadlog", false)) {
            m5477j();
        }
        this.f15362N = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        this.f15401v = DownloadManager.m9565a();
        this.f15401v.f7053a = new HandlerC2695q(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.radio_download) {
            String charSequence = this.f15350B.getText().toString();
            if (charSequence.equals(this.mContext.getResources().getString(R.string.down_stop_txt))) {
                DownloadManager downloadManager = this.f15401v;
                downloadManager.f7053a = null;
                downloadManager.m9549c();
                this.f15362N.shutdownNow();
                for (DownloadSoftDto downloadSoftDto : this.f15352D) {
                    if (1 == downloadSoftDto.f15579e.intValue()) {
                        downloadSoftDto.f15579e = 0;
                        this.f15402w.notifyDataSetChanged();
                    }
                }
                if (PreferencesManager.m9595a(this.mContext).m9583b("enable_upload_downloadlog", false)) {
                    if (C2778n.m4917a(this.mContext)) {
                        List<UpdateDownloadLog> loadAll = this.f15372X.loadAll();
                        UpgradeAction upgradeAction = new UpgradeAction(getActivity().getApplicationContext());
                        for (UpdateDownloadLog updateDownloadLog : loadAll) {
                            FixedThreadPool.m4928a().m4927a(new UpLoadLogTask(m5557a(Integer.parseInt(updateDownloadLog.f15841d), Integer.parseInt(updateDownloadLog.f15842e), updateDownloadLog.f15839b, Integer.parseInt(updateDownloadLog.f15840c)), upgradeAction, DBManager.m5036a(this.mContext).f15794a.f15801d));
                        }
                    }
                    m5475k();
                }
                this.f15350B.setText(R.string.down_continue_txt);
                Drawable drawable = getResources().getDrawable(R.drawable.select_btn_update_download);
                drawable.setBounds(0, 0, 50, 50);
                this.f15350B.setImage(drawable);
                this.f15350B.setEnabled(false);
                if (this.f15362N.isTerminating()) {
                    LoadDialog.m4684a(this.mContext, this.mContext.getString(R.string.txt_stopping));
                    new C2696r(this).start();
                    return;
                }
                this.f15350B.setEnabled(true);
            } else if (charSequence.equals(this.mContext.getResources().getString(R.string.down_retry_txt))) {
                m5559a();
                m5491c();
                this.f15350B.setText(R.string.down_stop_txt);
                Drawable drawable2 = getResources().getDrawable(R.drawable.select_btn_update_stop);
                drawable2.setBounds(0, 0, 50, 50);
                this.f15350B.setImage(drawable2);
                m5493b();
            } else {
                m5491c();
                this.f15356H = 0;
                this.f15350B.setText(R.string.down_stop_txt);
                Drawable drawable3 = getResources().getDrawable(R.drawable.select_btn_update_stop);
                drawable3.setBounds(0, 0, 50, 50);
                this.f15350B.setImage(drawable3);
                m5493b();
            }
        } else if (id == R.id.radio_home && this.mainActivity != null) {
            this.mainActivity.m7894b(R.id.btn_diagnose);
        }
    }

    /* compiled from: DownloadFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.f$a */
    /* loaded from: classes.dex */
    class C2683a implements UnZipListener {

        /* renamed from: b */
        private DownloadSoftDto f15407b;

        C2683a(DownloadSoftDto downloadSoftDto) {
            this.f15407b = null;
            this.f15407b = downloadSoftDto;
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4527a() {
            DownloadSoftDto downloadSoftDto = this.f15407b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = 0;
                downloadSoftDto.f15579e = 6;
                DownloadFragment.this.f15403x.sendMessage(DownloadFragment.this.f15403x.obtainMessage(9, 0, 0));
            }
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4526a(int i, int i2) {
            DownloadSoftDto downloadSoftDto = this.f15407b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = (i * 100) / i2;
                DownloadFragment.this.f15403x.sendMessage(DownloadFragment.this.f15403x.obtainMessage(9, 0, 0));
            }
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: b */
        public final void mo4524b() {
            DownloadSoftDto downloadSoftDto = this.f15407b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = 100;
                DownloadFragment.this.f15403x.sendMessage(DownloadFragment.this.f15403x.obtainMessage(9, 0, 0));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0048, code lost:
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
                com.cnlaunch.x431pro.activity.upgrade.f r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                java.lang.String r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5504ap(r0)
                r1 = 1
                java.lang.Object[] r2 = new java.lang.Object[r1]
                java.lang.String r3 = "Error code: "
                java.lang.String r4 = java.lang.String.valueOf(r7)
                java.lang.String r3 = r3.concat(r4)
                r4 = 0
                r2[r4] = r3
                com.cnlaunch.p120d.p130d.NLog.m9451c(r0, r2)
                if (r8 == 0) goto L4b
                java.lang.String r8 = r8.getMessage()
                com.cnlaunch.x431pro.activity.upgrade.f r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                java.lang.String r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5504ap(r0)
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
                if (r7 == 0) goto L4b
                goto L4c
            L4b:
                r1 = 0
            L4c:
                com.cnlaunch.x431pro.module.j.b.c r7 = r6.f15407b
                if (r7 == 0) goto Lbe
                r8 = 100
                r7.f15578d = r8
                r8 = 9
                if (r1 == 0) goto La4
                r0 = 7
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r7.f15579e = r1
                com.cnlaunch.x431pro.activity.upgrade.f r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                com.cnlaunch.d.c.b.b r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5556a(r7)
                r1 = 0
                r7.f7053a = r1
                com.cnlaunch.x431pro.activity.upgrade.f r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r7)
                android.os.Message r7 = r7.obtainMessage(r0, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.f r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r0 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r0)
                r0.sendMessage(r7)
                com.cnlaunch.x431pro.activity.upgrade.f r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r7)
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.f r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r8)
                r8.sendMessage(r7)
                com.cnlaunch.x431pro.activity.upgrade.f r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r7)
                r8 = 11
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.f r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r8)
                r8.sendMessage(r7)
                return
            La4:
                r0 = 5
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r7.f15579e = r0
                com.cnlaunch.x431pro.activity.upgrade.f r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r7 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r7)
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.activity.upgrade.f r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.this
                android.os.Handler r8 = com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5490c(r8)
                r8.sendMessage(r7)
            Lbe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.C2683a.mo4525a(int, java.lang.Throwable):void");
        }
    }

    /* compiled from: DownloadFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.upgrade.f$b */
    /* loaded from: classes.dex */
    class RunnableC2684b implements Runnable {

        /* renamed from: b */
        private String f15409b;

        /* renamed from: c */
        private String f15410c;

        /* renamed from: d */
        private String f15411d;

        public RunnableC2684b(String str, String str2, String str3) {
            this.f15409b = str;
            this.f15410c = str2;
            this.f15411d = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x033e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 1684
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.RunnableC2684b.run():void");
        }
    }

    /* renamed from: d */
    private void m5489d() {
        this.f15354F = Integer.valueOf(this.f15355G.intValue() + this.f15356H.intValue());
        if (this.f15354F.intValue() != this.f15352D.size() || getActivity() == null) {
            return;
        }
        this.f15403x.sendMessage(this.f15403x.obtainMessage(3, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m5548a(DownloadSoftDto downloadSoftDto) {
        downloadSoftDto.f15579e = 4;
        m5487e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m5487e() {
        int i;
        if (this.f15352D != null) {
            i = 0;
            for (DownloadSoftDto downloadSoftDto : this.f15352D) {
                if (4 == downloadSoftDto.f15579e.intValue() || 9 == downloadSoftDto.f15579e.intValue() || (1 == downloadSoftDto.f15577c && !this.f15365Q && 2 == downloadSoftDto.f15579e.intValue() && this.f15359K)) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        this.f15355G = Integer.valueOf(i);
        m5481h();
        m5489d();
        if (getActivity() != null) {
            this.f15403x.sendMessage(this.f15403x.obtainMessage(2, 0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m5485f() {
        Integer num = this.f15356H;
        this.f15356H = Integer.valueOf(this.f15356H.intValue() + 1);
        m5481h();
        m5489d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5483g() {
        if (getActivity() == null) {
            return;
        }
        this.f15403x.sendMessage(this.f15403x.obtainMessage(1, 0, 0));
    }

    /* renamed from: h */
    private synchronized void m5481h() {
        if (getActivity() == null) {
            return;
        }
        this.f15403x.sendMessage(this.f15403x.obtainMessage(9, 0, 0));
    }

    /* renamed from: a */
    public final SpannableStringBuilder m5546a(String str, String str2) {
        return new SpannableStringBuilder(this.mContext.getResources().getString(R.string.down_statistics_txt, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5545a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 1069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.upgrade.DownloadFragment.m5545a(java.lang.String, boolean):void");
    }

    /* renamed from: i */
    private long m5479i() {
        if (TrafficStats.getUidRxBytes(this.mContext.getApplicationInfo().uid) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    /* renamed from: j */
    private void m5477j() {
        TimerTask timerTask;
        if (this.f15374Z == null) {
            this.f15374Z = new Timer();
        }
        if (this.f15376aa == null) {
            this.f15376aa = new C2697s(this);
        }
        Timer timer = this.f15374Z;
        if (timer == null || (timerTask = this.f15376aa) == null) {
            return;
        }
        try {
            timer.schedule(timerTask, 1000L, 1000L);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5475k() {
        Timer timer = this.f15374Z;
        if (timer != null) {
            timer.cancel();
            this.f15374Z = null;
        }
        TimerTask timerTask = this.f15376aa;
        if (timerTask != null) {
            timerTask.cancel();
            this.f15376aa = null;
        }
        Handler handler = this.f15403x;
        if (handler != null) {
            this.f15403x.sendMessage(handler.obtainMessage(14, 0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public DownloadLog m5557a(int i, int i2, String str, int i3) {
        DownloadLog downloadLog = new DownloadLog();
        downloadLog.setCurrentConfigArea(this.f15373Y);
        downloadLog.setCurrentNetworkSpeed(String.valueOf(this.f15371W));
        downloadLog.setDownloadDuration(String.valueOf(i2));
        downloadLog.setDownloadedSize(String.valueOf(i));
        downloadLog.setDownloadId(str);
        downloadLog.setState(String.valueOf(i3));
        return downloadLog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ void m5473l(DownloadFragment downloadFragment) {
        int i;
        List<DownloadSoftDto> list = downloadFragment.f15352D;
        if (list != null) {
            i = 0;
            for (DownloadSoftDto downloadSoftDto : list) {
                if (4 == downloadSoftDto.f15579e.intValue() && !TextUtils.isEmpty(downloadSoftDto.f15590p)) {
                    if (downloadSoftDto.f15576b.compareToIgnoreCase(downloadSoftDto.f15591q) == 0 && downloadSoftDto.f15576b.compareToIgnoreCase(downloadSoftDto.f15590p) > 0) {
                        i++;
                    } else if (downloadSoftDto.f15576b.compareToIgnoreCase(downloadSoftDto.f15591q) < 0 && downloadSoftDto.f15590p.compareToIgnoreCase(downloadSoftDto.f15591q) == 0) {
                        i--;
                    }
                }
            }
        } else {
            i = 0;
        }
        if (i == 0) {
            return;
        }
        if (!TextUtils.isEmpty(downloadFragment.f15353E) && C2744aa.m5168b(downloadFragment.f15353E, downloadFragment.mContext)) {
            int m9585b = PreferencesManager.m9595a(downloadFragment.mContext).m9585b("unupdateSoftwareNum", 0);
            int i2 = m9585b - i;
            if (i2 <= 0) {
                i2 = 0;
            }
            PreferencesManager.m9595a(downloadFragment.mContext).m9590a("unupdateSoftwareNum", i2);
            NLog.m9456a("yhx", "updateNum=" + m9585b + ",nRemoveBubble=" + i + ",newUnUpdateNum=" + i2);
        } else if (!TextUtils.isEmpty(downloadFragment.f15353E) && C2744aa.m5177a(downloadFragment.f15353E, downloadFragment.mContext)) {
            int m9585b2 = PreferencesManager.m9595a(downloadFragment.mContext).m9585b("unupdateSoftwareNumForHeavyduty", 0);
            int i3 = m9585b2 - i;
            if (i3 <= 0) {
                i3 = 0;
            }
            PreferencesManager.m9595a(downloadFragment.mContext).m9590a("unupdateSoftwareNumForHeavyduty", i3);
            NLog.m9456a("yhx", "HD,updateHeavydutyNum=" + m9585b2 + ",nRemoveBubble=" + i + ",newUnUpdateHeavydutyNum=" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ UpdateDownloadLog m5549a(DownloadLog downloadLog) {
        UpdateDownloadLog updateDownloadLog = new UpdateDownloadLog();
        updateDownloadLog.f15839b = downloadLog.getDownloadId();
        updateDownloadLog.f15840c = downloadLog.getState();
        updateDownloadLog.f15841d = downloadLog.getDownloadedSize();
        updateDownloadLog.f15842e = downloadLog.getDownloadDuration();
        updateDownloadLog.f15843f = downloadLog.getCurrentNetworkSpeed();
        updateDownloadLog.f15844g = downloadLog.getCurrentConfigArea();
        return updateDownloadLog;
    }

    /* renamed from: a */
    static /* synthetic */ String m5547a(String str) {
        if (str == null || str.equalsIgnoreCase("X-431 PAD II USA") || str.equalsIgnoreCase("X-431 PAD II") || str.equalsIgnoreCase("X431 Pro APP") || str.equalsIgnoreCase("X431_PRO_EURO_APP") || str.equalsIgnoreCase("X431_PRO_USA_APP") || str.equalsIgnoreCase("X431_PROSPLUS_DBScar5_APP") || str.equalsIgnoreCase("X431_PROSPLUS_EURO_DBScar5_APP") || str.equalsIgnoreCase("X431 Pro3 APP") || str.equalsIgnoreCase("X431PRO3S_APP") || str.equalsIgnoreCase("ScanPad071_2016_APP") || str.equalsIgnoreCase("ScanPad071_2017_APP") || str.equalsIgnoreCase("ScanPad071_V4_APP") || str.equalsIgnoreCase("X431PRO3S_USA_APP") || str.equalsIgnoreCase("X431PRO3S_EURO_APP") || str.equalsIgnoreCase("X431PROJ_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431_PRO3S_HDIII_APP") || str.equalsIgnoreCase("X431_PRO3C_APP") || str.equalsIgnoreCase("X431 Pro4 APP") || str.equalsIgnoreCase("X431 PRO3 HD") || str.equalsIgnoreCase("X431 PRO4 HD") || str.equalsIgnoreCase("X431_PADII_HD") || str.equalsIgnoreCase("X-431 PRO3_JINBEIHD_APP") || str.contains("Maximus2.0APK") || str.contains("MaxGo Application") || str.equalsIgnoreCase("ScanPad071") || str.equalsIgnoreCase("ScanPad071_APP") || str.equalsIgnoreCase("ScanPad071_AUS") || str.equalsIgnoreCase("ScanPad071_AUS_APP") || str.equalsIgnoreCase("ScanPad101") || str.equalsIgnoreCase("X-431V") || str.equalsIgnoreCase("X-431 VPlus Application") || str.equalsIgnoreCase("X-431 5C") || str.equalsIgnoreCase("X431_5C_2016_APP") || str.equalsIgnoreCase("X431_PROS_APP") || str.equalsIgnoreCase("X431_PROS_USA_APP") || str.equalsIgnoreCase("X431_PROS_EURO_APP") || str.equalsIgnoreCase("X431_PROS_HDIII_APP") || str.equalsIgnoreCase("X431V_2016_APP") || str.equalsIgnoreCase("X431VPLUS_2016_APP") || str.equalsIgnoreCase("X431_HD2_APP") || str.equalsIgnoreCase("X431_PAD3_APP") || str.equalsIgnoreCase("X431_PRO3S_HD2_APP") || str.equalsIgnoreCase("X431HDIV_APPLICATION") || str.equalsIgnoreCase("X431_PADII_2016_USA_APP") || str.equalsIgnoreCase("ScanPlus_APP") || str.equalsIgnoreCase("X431V_2016_DBSCAR1_APP")) {
            return null;
        }
        if (str.equalsIgnoreCase("BatteryTest_X431PADII") || str.equalsIgnoreCase("BatteryTest_X431Pro") || str.contains("BatteryTest_MAXIMUS2.0")) {
            return "com.cnlaunch.batterytest";
        }
        if (str.equalsIgnoreCase("SensorApp_X431PADII") || str.equalsIgnoreCase("SensorApp_X431Pro") || str.contains("Sensor_MAXIMUS2.0")) {
            return "com.cnlaunch.sensor";
        }
        if (str.equalsIgnoreCase("Oscilloscope_X431PADII") || str.equalsIgnoreCase("Oscilloscope_X431Pro") || str.contains("Oscilloscope_X431PADII") || str.contains("Oscilloscope_MAXIMUS2.0") || str.equalsIgnoreCase("Ignition_X431PADII") || str.equalsIgnoreCase("Ignition_X431Pro") || str.contains("Ignition_MAXIMUS2.0")) {
            return "com.cnlaunch.oscilloscope";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: aX */
    public static /* synthetic */ void m5520aX(DownloadFragment downloadFragment) {
        long m5479i = downloadFragment.m5479i();
        long currentTimeMillis = System.currentTimeMillis();
        long j = downloadFragment.f15370V;
        if (currentTimeMillis - j != 0) {
            downloadFragment.f15370V = currentTimeMillis;
            downloadFragment.f15369U = m5479i;
            downloadFragment.f15403x.sendMessage(downloadFragment.f15403x.obtainMessage(14, (int) (((m5479i - downloadFragment.f15369U) * 1000) / (currentTimeMillis - j)), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5554a(DownloadFragment downloadFragment, int i, int i2) {
        if (i2 == 0) {
            NToast.m9449a(downloadFragment.mContext, downloadFragment.f15382c + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + downloadFragment.mContext.getResources().getString(i));
            downloadFragment.m5483g();
        } else if (1 == i2) {
            new DialogC2699u(downloadFragment, downloadFragment.mContext).m4669a(downloadFragment.mContext.getResources().getString(R.string.install), downloadFragment.f15382c + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + downloadFragment.mContext.getResources().getString(R.string.show_error_code) + downloadFragment.mContext.getResources().getString(i) + "\n" + downloadFragment.mContext.getResources().getString(R.string.failed_code) + downloadFragment.f15384e);
        } else if (2 == i2) {
            new DialogC2700v(downloadFragment, downloadFragment.mContext).m4669a(downloadFragment.mContext.getResources().getString(R.string.install), downloadFragment.f15382c + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + downloadFragment.mContext.getResources().getString(i) + "\n" + downloadFragment.mContext.getResources().getString(R.string.failed_code) + downloadFragment.f15384e);
        }
    }
}
