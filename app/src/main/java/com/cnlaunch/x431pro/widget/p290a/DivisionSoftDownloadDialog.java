package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Process;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.LruCacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadManager;
import com.cnlaunch.p120d.p125c.p127b.DownloadParam;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DownloadAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p285e.UnZipListener;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.cnlaunch.x431pro.widget.a.i */
/* loaded from: classes.dex */
public final class DivisionSoftDownloadDialog extends BaseDialog {

    /* renamed from: s */
    private static final int f16410s = (Runtime.getRuntime().availableProcessors() * 2) + 1;

    /* renamed from: A */
    private PreferencesManager f16411A;

    /* renamed from: B */
    private DownloadManager f16412B;

    /* renamed from: C */
    private ThreadPoolExecutor f16413C;

    /* renamed from: D */
    private List<DownloadSoftDto> f16414D;

    /* renamed from: E */
    private volatile Integer f16415E;

    /* renamed from: F */
    private volatile Integer f16416F;

    /* renamed from: G */
    private volatile Integer f16417G;

    /* renamed from: H */
    private String f16418H;

    /* renamed from: I */
    private Handler f16419I;

    /* renamed from: J */
    private long f16420J;

    /* renamed from: K */
    private long f16421K;

    /* renamed from: L */
    private int f16422L;

    /* renamed from: M */
    private final Dialog f16423M;

    /* renamed from: N */
    private Timer f16424N;

    /* renamed from: O */
    private TimerTask f16425O;

    /* renamed from: a */
    private final int f16426a;

    /* renamed from: b */
    private final int f16427b;

    /* renamed from: c */
    private final int f16428c;

    /* renamed from: g */
    private final int f16429g;

    /* renamed from: h */
    private final int f16430h;

    /* renamed from: i */
    private final int f16431i;

    /* renamed from: j */
    private final int f16432j;

    /* renamed from: k */
    private final int f16433k;

    /* renamed from: l */
    private final int f16434l;

    /* renamed from: m */
    private final int f16435m;

    /* renamed from: n */
    private final int f16436n;

    /* renamed from: o */
    private final int f16437o;

    /* renamed from: p */
    private final int f16438p;

    /* renamed from: q */
    private final int f16439q;

    /* renamed from: r */
    private final int f16440r;

    /* renamed from: t */
    private Context f16441t;

    /* renamed from: u */
    private IconButton f16442u;

    /* renamed from: v */
    private ListView f16443v;

    /* renamed from: w */
    private TextView f16444w;

    /* renamed from: x */
    private TextView f16445x;

    /* renamed from: y */
    private TextView f16446y;

    /* renamed from: z */
    private DownloadAdapter f16447z;

    public DivisionSoftDownloadDialog(Context context) {
        super(context);
        this.f16426a = 1;
        this.f16427b = 2;
        this.f16428c = 3;
        this.f16429g = 4;
        this.f16430h = 5;
        this.f16431i = 6;
        this.f16432j = 7;
        this.f16433k = 8;
        this.f16434l = 9;
        this.f16435m = 10;
        this.f16436n = 11;
        this.f16437o = 12;
        this.f16438p = 13;
        this.f16439q = 14;
        this.f16440r = 15;
        this.f16415E = 0;
        this.f16416F = 0;
        this.f16417G = 0;
        this.f16418H = "";
        this.f16419I = null;
        this.f16420J = 0L;
        this.f16421K = System.currentTimeMillis();
        this.f16422L = 0;
        this.f16424N = null;
        this.f16425O = null;
        this.f16441t = context;
        setTitle(R.string.division_soft_upgrade_title);
        this.f16423M = this;
        int integer = this.f16441t.getResources().getInteger(R.integer.bluetoothlist_width_size);
        int integer2 = this.f16441t.getResources().getInteger(R.integer.bluetoothlist_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        window.setLayout((window.getWindowManager().getDefaultDisplay().getWidth() * integer) / 100, (window.getWindowManager().getDefaultDisplay().getHeight() * integer2) / 100);
        setCancelable(false);
        ((DiagnoseActivity) context).f11025O = this;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        View inflate = LayoutInflater.from(this.f16441t).inflate(R.layout.divisions_download, (ViewGroup) null);
        this.f16443v = (ListView) inflate.findViewById(R.id.listview);
        this.f16442u = (IconButton) inflate.findViewById(R.id.radio_download);
        this.f16442u.setOnClickListener(new View$OnClickListenerC2868j(this));
        this.f16444w = (TextView) inflate.findViewById(R.id.tv_statistics);
        this.f16445x = (TextView) inflate.findViewById(R.id.tv_spinner_serialNo);
        this.f16446y = (TextView) inflate.findViewById(R.id.networkspeed);
        m4712g();
        this.f16447z = new DownloadAdapter(this.f16441t);
        this.f16443v.setAdapter((ListAdapter) this.f16447z);
        this.f16411A = PreferencesManager.m9595a(this.f16441t);
        this.f16418H = this.f16411A.m9591a("serialNo");
        this.f16445x.setText(this.f16418H);
        this.f16420J = m4560b();
        m4557c();
        return inflate;
    }

    /* renamed from: b */
    private long m4560b() {
        if (TrafficStats.getUidRxBytes(this.f16441t.getApplicationInfo().uid) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    /* renamed from: c */
    private synchronized void m4557c() {
        m4537o();
        this.f16419I = new HandlerC2870l(this);
        m4555d();
        m4539n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4555d() {
        NLog.m9456a("yhx", "Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors() + ", DEFAULT_MAX_CONNECTIONS: " + f16410s);
        if (PreferencesManager.m9595a(this.f16441t).m9583b("enable_upload_downloadlog", false)) {
            m4535p();
        }
        this.f16413C = (ThreadPoolExecutor) Executors.newFixedThreadPool(f16410s);
        this.f16412B = new DownloadManager();
        this.f16412B.f7053a = new HandlerC2880v(this);
    }

    /* renamed from: e */
    private void m4553e() {
        NLog.m9456a("yhx", "addDownloadCount enter.");
        this.f16415E = Integer.valueOf(this.f16416F.intValue() + this.f16417G.intValue());
        if (this.f16415E.intValue() == this.f16414D.size()) {
            NLog.m9456a("yhx", "finishDownload enter.");
            this.f16419I.sendMessage(this.f16419I.obtainMessage(3, 0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4566a(DownloadSoftDto downloadSoftDto) {
        NLog.m9456a("yhx", "addDownloadOKEx enter.");
        downloadSoftDto.f15579e = 4;
        m4551f();
    }

    /* renamed from: f */
    private synchronized void m4551f() {
        int i;
        if (this.f16414D != null) {
            i = 0;
            for (DownloadSoftDto downloadSoftDto : this.f16414D) {
                if (4 == downloadSoftDto.f15579e.intValue() || 9 == downloadSoftDto.f15579e.intValue()) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        this.f16416F = Integer.valueOf(i);
        m4541m();
        m4553e();
        this.f16419I.sendMessage(this.f16419I.obtainMessage(2, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public synchronized void m4543l() {
        Integer num = this.f16417G;
        this.f16417G = Integer.valueOf(this.f16417G.intValue() + 1);
        m4541m();
        m4553e();
    }

    /* renamed from: m */
    private synchronized void m4541m() {
        this.f16419I.sendMessage(this.f16419I.obtainMessage(9, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4539n() {
        List<DownloadSoftDto> list = this.f16414D;
        if (list != null) {
            for (DownloadSoftDto downloadSoftDto : list) {
                if (downloadSoftDto.f15579e.intValue() != 4) {
                    C1426i c1426i = new C1426i();
                    c1426i.m9506a("serialNo", this.f16418H);
                    c1426i.m9506a("spfId", downloadSoftDto.f15581g);
                    downloadSoftDto.f15580f = m4559b(downloadSoftDto);
                    boolean z = false;
                    downloadSoftDto.f15579e = 0;
                    downloadSoftDto.f15578d = 0;
                    DownloadParam downloadParam = new DownloadParam();
                    downloadParam.f7076a = this.f16441t;
                    downloadParam.f7077b = c1426i;
                    downloadParam.f7082g = downloadSoftDto.f15582h;
                    downloadParam.f7079d = downloadSoftDto.f15583i;
                    downloadParam.f7080e = downloadSoftDto.f15580f;
                    downloadParam.f7078c = downloadSoftDto.f15576b;
                    downloadParam.f7081f = PathUtils.m4852e();
                    if ((3 == downloadSoftDto.f15577c || downloadSoftDto.f15577c == 4) && PreferencesManager.m9595a(this.f16441t).m9583b("enable_breakpointresume", false)) {
                        z = true;
                    }
                    downloadParam.f7083h = z;
                    downloadParam.f7084i = downloadSoftDto.f15577c;
                    downloadParam.f7085j = downloadSoftDto.f15581g;
                    this.f16412B.m9553b(downloadParam);
                }
            }
            this.f16412B.m9556b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m4537o() {
        ArrayList<DownloadSoftDto> arrayList = (ArrayList) LruCacheManager.m9599a().m9597a("downloadList");
        NLog.m9456a("yhx", "upgradeList=".concat(String.valueOf(arrayList)));
        this.f16414D = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            for (DownloadSoftDto downloadSoftDto : arrayList) {
                if (4 != downloadSoftDto.f15579e.intValue()) {
                    this.f16414D.add(downloadSoftDto);
                }
            }
        }
        DownloadAdapter downloadAdapter = this.f16447z;
        downloadAdapter.f15005a = this.f16414D;
        downloadAdapter.notifyDataSetChanged();
        NLog.m9456a("yhx", "downloadList=" + this.f16414D);
        this.f16415E = 0;
        this.f16416F = 0;
        this.f16417G = 0;
        this.f16444w.setText(m4561a(String.valueOf(this.f16416F), String.valueOf(this.f16414D.size())));
    }

    /* renamed from: a */
    public final SpannableStringBuilder m4561a(String str, String str2) {
        return new SpannableStringBuilder(this.f16441t.getString(R.string.down_statistics_txt, str, str2));
    }

    /* compiled from: DivisionSoftDownloadDialog.java */
    /* renamed from: com.cnlaunch.x431pro.widget.a.i$a */
    /* loaded from: classes.dex */
    class C2866a implements UnZipListener {

        /* renamed from: b */
        private DownloadSoftDto f16449b;

        C2866a(DownloadSoftDto downloadSoftDto) {
            this.f16449b = null;
            this.f16449b = downloadSoftDto;
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4527a() {
            DownloadSoftDto downloadSoftDto = this.f16449b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = 0;
                downloadSoftDto.f15579e = 6;
                DivisionSoftDownloadDialog.this.f16419I.sendMessage(DivisionSoftDownloadDialog.this.f16419I.obtainMessage(9, 0, 0));
            }
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: a */
        public final void mo4526a(int i, int i2) {
            DownloadSoftDto downloadSoftDto = this.f16449b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = (i * 100) / i2;
                DivisionSoftDownloadDialog.this.f16419I.sendMessage(DivisionSoftDownloadDialog.this.f16419I.obtainMessage(9, 0, 0));
            }
        }

        @Override // com.cnlaunch.x431pro.utils.p285e.UnZipListener
        /* renamed from: b */
        public final void mo4524b() {
            DownloadSoftDto downloadSoftDto = this.f16449b;
            if (downloadSoftDto != null) {
                downloadSoftDto.f15578d = 100;
                DivisionSoftDownloadDialog.this.f16419I.sendMessage(DivisionSoftDownloadDialog.this.f16419I.obtainMessage(9, 0, 0));
            }
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
                java.lang.String r0 = "yhx"
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
                java.lang.String r0 = "yhx"
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
                com.cnlaunch.x431pro.module.j.b.c r7 = r6.f16449b
                if (r7 == 0) goto Lb6
                r8 = 100
                r7.f15578d = r8
                r8 = 9
                if (r1 == 0) goto L9c
                r0 = 7
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r7.f15579e = r1
                com.cnlaunch.x431pro.widget.a.i r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                com.cnlaunch.d.c.b.b r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4556c(r7)
                r1 = 0
                r7.f7053a = r1
                com.cnlaunch.x431pro.widget.a.i r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r7)
                android.os.Message r7 = r7.obtainMessage(r0, r4, r4)
                com.cnlaunch.x431pro.widget.a.i r0 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r0 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r0)
                r0.sendMessage(r7)
                com.cnlaunch.x431pro.widget.a.i r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r7)
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.widget.a.i r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r8)
                r8.sendMessage(r7)
                com.cnlaunch.x431pro.widget.a.i r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r7)
                r8 = 11
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.widget.a.i r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r8)
                r8.sendMessage(r7)
                return
            L9c:
                r0 = 5
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r7.f15579e = r0
                com.cnlaunch.x431pro.widget.a.i r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r7 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r7)
                android.os.Message r7 = r7.obtainMessage(r8, r4, r4)
                com.cnlaunch.x431pro.widget.a.i r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.this
                android.os.Handler r8 = com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.m4549g(r8)
                r8.sendMessage(r7)
            Lb6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.widget.p290a.DivisionSoftDownloadDialog.C2866a.mo4525a(int, java.lang.Throwable):void");
        }
    }

    /* compiled from: DivisionSoftDownloadDialog.java */
    /* renamed from: com.cnlaunch.x431pro.widget.a.i$b */
    /* loaded from: classes.dex */
    class RunnableC2867b implements Runnable {

        /* renamed from: b */
        private String f16451b;

        /* renamed from: c */
        private String f16452c;

        /* renamed from: d */
        private String f16453d;

        public RunnableC2867b(String str, String str2, String str3) {
            this.f16451b = str;
            this.f16452c = str2;
            this.f16453d = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(19);
            for (DownloadSoftDto downloadSoftDto : DivisionSoftDownloadDialog.this.f16414D) {
                if (!TextUtils.isEmpty(this.f16451b) && this.f16451b.equals(downloadSoftDto.f15580f)) {
                    String m4869a = PathUtils.m4869a(DivisionSoftDownloadDialog.this.f16441t, DivisionSoftDownloadDialog.this.f16418H);
                    NLog.m9456a("yhx", "unzipPath: ".concat(String.valueOf(m4869a)));
                    String m5014a = FileUtils.m5014a(this.f16452c, m4869a, new C2866a(downloadSoftDto), downloadSoftDto.f15584j);
                    NLog.m9456a("yhx", "filePath: " + this.f16452c + " message: " + m5014a);
                    if (Constant.CASH_LOAD_SUCCESS.equals(m5014a)) {
                        String str = PathUtils.m4868a(DivisionSoftDownloadDialog.this.f16441t, DivisionSoftDownloadDialog.this.f16418H, downloadSoftDto.f15586l) + File.separator + "Division.ini";
                        NLog.m9456a("yhx", "iniFileName=".concat(String.valueOf(str)));
                        String str2 = downloadSoftDto.f15584j;
                        if (downloadSoftDto.f15584j.toUpperCase().contains("RESET")) {
                            str2 = downloadSoftDto.f15584j + "_" + downloadSoftDto.f15585k;
                        }
                        FileUtils.m5003b(str, "DIV_INFO", str2, downloadSoftDto.f15576b);
                        DivisionSoftDownloadDialog.this.m4566a(downloadSoftDto);
                        FileUtils.m5000d(this.f16452c);
                        return;
                    }
                    downloadSoftDto.f15579e = 5;
                    DivisionSoftDownloadDialog.this.m4543l();
                    return;
                }
            }
        }
    }

    /* renamed from: p */
    private void m4535p() {
        TimerTask timerTask;
        if (this.f16424N == null) {
            this.f16424N = new Timer();
        }
        if (this.f16425O == null) {
            this.f16425O = new C2881w(this);
        }
        Timer timer = this.f16424N;
        if (timer == null || (timerTask = this.f16425O) == null) {
            return;
        }
        try {
            timer.schedule(timerTask, 1000L, 1000L);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            MessageDialog messageDialog = new MessageDialog(this.f16441t, (int) R.string.custom_diaglog_title, (int) R.string.exit_division_download_tip);
            messageDialog.m4719a(R.string.common_confirm, true, new View$OnClickListenerC2882x(this));
            messageDialog.m4717b(R.string.common_cancel, true, new View$OnClickListenerC2883y(this));
            messageDialog.show();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: k */
    public final void mo4545k() {
        NLog.m9456a("yhx", "DownloadDialog.finish.");
        DownloadManager downloadManager = this.f16412B;
        downloadManager.f7053a = null;
        downloadManager.m9549c();
        this.f16413C.shutdownNow();
        this.f16423M.dismiss();
    }

    /* renamed from: b */
    private static String m4559b(DownloadSoftDto downloadSoftDto) {
        String str;
        String replace = downloadSoftDto.f15576b.replace(".", "_");
        if (TextUtils.isEmpty(downloadSoftDto.f15585k)) {
            str = downloadSoftDto.f15584j + "_" + replace;
        } else {
            str = downloadSoftDto.f15584j + "_" + replace + "_" + LangManager.m9464b(downloadSoftDto.f15585k);
        }
        return str + ".zip";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static /* synthetic */ void m4533q(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        boolean z = false;
        for (DownloadSoftDto downloadSoftDto : divisionSoftDownloadDialog.f16414D) {
            if (1 == downloadSoftDto.f15579e.intValue()) {
                downloadSoftDto.f15578d = 100;
                downloadSoftDto.f15579e = 3;
                z = true;
            }
        }
        if (z) {
            divisionSoftDownloadDialog.f16447z.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static /* synthetic */ void m4528v(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        long m4560b = divisionSoftDownloadDialog.m4560b();
        long currentTimeMillis = System.currentTimeMillis();
        long j = divisionSoftDownloadDialog.f16421K;
        if (currentTimeMillis - j != 0) {
            divisionSoftDownloadDialog.f16421K = currentTimeMillis;
            divisionSoftDownloadDialog.f16420J = m4560b;
            divisionSoftDownloadDialog.f16419I.sendMessage(divisionSoftDownloadDialog.f16419I.obtainMessage(14, (int) (((m4560b - divisionSoftDownloadDialog.f16420J) * 1000) / (currentTimeMillis - j)), 0));
        }
    }
}
