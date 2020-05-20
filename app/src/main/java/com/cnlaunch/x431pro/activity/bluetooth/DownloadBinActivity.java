package com.cnlaunch.x431pro.activity.bluetooth;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class DownloadBinActivity extends BaseDialogActivity implements View.OnClickListener {

    /* renamed from: a */
    public static boolean f10909a = false;

    /* renamed from: c */
    private Context f10912c;

    /* renamed from: d */
    private View f10913d;

    /* renamed from: e */
    private TextView f10914e;

    /* renamed from: f */
    private TextView f10915f;

    /* renamed from: g */
    private TextView f10916g;

    /* renamed from: h */
    private TextView f10917h;

    /* renamed from: i */
    private TextView f10918i;

    /* renamed from: j */
    private ProgressBar f10919j;

    /* renamed from: k */
    private Button f10920k;

    /* renamed from: m */
    private float f10922m;

    /* renamed from: o */
    private String f10924o;

    /* renamed from: v */
    private String f10931v;

    /* renamed from: y */
    private int f10934y;

    /* renamed from: l */
    private DownloadBinUpdate f10921l = null;

    /* renamed from: n */
    private String f10923n = "";

    /* renamed from: p */
    private String f10925p = "";

    /* renamed from: q */
    private boolean f10926q = false;

    /* renamed from: r */
    private boolean f10927r = false;

    /* renamed from: s */
    private int f10928s = 0;

    /* renamed from: t */
    private String f10929t = ".";

    /* renamed from: u */
    private ProgressDialog f10930u = null;

    /* renamed from: w */
    private boolean f10932w = false;

    /* renamed from: x */
    private int f10933x = 0;

    /* renamed from: b */
    OnDownloadBinListener f10911b = new C1997g(this);

    /* renamed from: z */
    private final Handler f10935z = new HandlerC1999i(this);

    /* renamed from: A */
    private final BroadcastReceiver f10910A = new C2002l(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static /* synthetic */ int m7786A(DownloadBinActivity downloadBinActivity) {
        downloadBinActivity.f10933x = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ int m7771e(DownloadBinActivity downloadBinActivity) {
        downloadBinActivity.f10928s = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ int m7769g(DownloadBinActivity downloadBinActivity) {
        int i = downloadBinActivity.f10928s;
        downloadBinActivity.f10928s = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ boolean m7765k(DownloadBinActivity downloadBinActivity) {
        downloadBinActivity.f10926q = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static /* synthetic */ int m7752x(DownloadBinActivity downloadBinActivity) {
        int i = downloadBinActivity.f10933x;
        downloadBinActivity.f10933x = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public static /* synthetic */ boolean m7750z(DownloadBinActivity downloadBinActivity) {
        downloadBinActivity.f10932w = false;
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        this.f10934y = -1;
        this.f10912c = this;
        this.f10923n = getIntent().getStringExtra("DownloadBin_Ver");
        this.f10925p = getIntent().getStringExtra("DownloadBin_Dev_Ver");
        this.f10924o = getIntent().getStringExtra("DownloadBin_Path");
        this.f10913d = ((LayoutInflater) this.f10912c.getSystemService("layout_inflater")).inflate(R.layout.downloadbin_main, (ViewGroup) null);
        this.f10930u = new ProgressDialog(this.f10912c, R.style.DiagnoseProgressDialogTheme);
        this.f10930u.show();
        this.f10930u.setContentView(this.f10913d);
        this.f10930u.setCancelable(false);
        this.f10930u.setOnKeyListener(new DialogInterface$OnKeyListenerC1996f(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("DPUDeviceConnectSuccess");
        intentFilter.addAction("DPUDeviceConnectFail");
        this.f10912c.registerReceiver(this.f10910A, intentFilter);
        m7774d();
        this.f10919j = (ProgressBar) this.f10913d.findViewById(R.id.update_downlaod_bin_progress);
        this.f10915f = (TextView) this.f10913d.findViewById(R.id.tv_download_bin_ver);
        this.f10914e = (TextView) this.f10913d.findViewById(R.id.tv_download_bin_hit);
        this.f10916g = (TextView) this.f10913d.findViewById(R.id.tv_downlaod_bin_ratio);
        this.f10917h = (TextView) this.f10913d.findViewById(R.id.tv_downloadbin_update_status);
        this.f10918i = (TextView) this.f10913d.findViewById(R.id.tv_download_bin_black);
        this.f10918i.setVisibility(8);
        this.f10920k = (Button) this.f10913d.findViewById(R.id.btn_update);
        this.f10920k.setOnClickListener(this);
        this.f10920k.setText(R.string.common_cancel);
        this.f10920k.setEnabled(false);
        this.f10931v = PreferencesManager.m9595a(this.f10912c).m9591a("serialNo");
        String string = this.f10912c.getString(R.string.downloadbin_upgrade_label);
        String string2 = this.f10912c.getString(R.string.downloadbin_reupgrade_label);
        if (TextUtils.isEmpty(this.f10925p)) {
            this.f10925p = "NULL";
            String format2 = String.format(string, this.f10923n, this.f10925p);
            format = format2.substring(format2.indexOf("NULL") + 4);
        } else {
            format = String.format(string, this.f10923n, this.f10925p);
        }
        if (PreferencesManager.m9595a(this.f10912c).m9583b("is_upgrade_not_complete", false)) {
            this.f10915f.setText(string2);
            PreferencesManager.m9595a(this.f10912c).m9587a("is_upgrade_not_complete", false);
        } else {
            this.f10915f.setText(format);
        }
        m7778b();
        f10909a = true;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onDestroy() {
        this.f10930u.dismiss();
        if (C1856n.f10135a) {
            C1856n.m8130a("DownloadBinActivity", "unregisterBoardcastReciver() =" + this.f10910A.toString());
        }
        try {
            this.f10912c.unregisterReceiver(this.f10910A);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m7783a() {
        Intent intent = new Intent();
        intent.setAction("DownloadBin_DisConnBluetooth");
        this.f10912c.sendBroadcast(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_update) {
            return;
        }
        if (this.f10926q) {
            this.f10926q = false;
            this.f10921l.f9809e = true;
            this.f10912c.sendBroadcast(new Intent("DownloadBin_DisConnBluetooth"));
            ProgressDialog progressDialog = this.f10930u;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            m7772e();
        } else if (this.f10927r) {
            this.f10912c.sendBroadcast(new Intent("JumpDownloadBin"));
            ProgressDialog progressDialog2 = this.f10930u;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            m7772e();
        } else {
            this.f10912c.sendBroadcast(new Intent("DownloadBin_DisConnBluetooth"));
            ProgressDialog progressDialog3 = this.f10930u;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
            m7772e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7778b() {
        if (this.f10926q) {
            return;
        }
        this.f10926q = true;
        IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
        if (iPhysics != null) {
            this.f10934y = DeviceFactoryManager.m8305a().f9903c;
            this.f10921l = new DownloadBinUpdate(this.f10911b, iPhysics);
            String m8280e = DeviceFactoryManager.m8305a().m8280e();
            String str = this.f10924o;
            String substring = str.substring(0, str.lastIndexOf("/"));
            String str2 = (!Tools.m8112a(this.f10912c, m8280e) || Tools.m8099b(this.f10912c, m8280e)) ? "/DOWNLOAD.bin" : "/DOWNLOAD.hex";
            boolean m4826a = SerialNoUtils.m4826a(this.f10912c, this.f10931v);
            if (m4826a) {
                if (C1856n.f10135a) {
                    C1856n.m8130a("DownloadBinActivity", "SerialNoUtils.isUnForbiddenState currentSerialNo=" + this.f10931v + " state=" + m4826a);
                }
                Context context = this.f10912c;
                if (!Tools.m8093f(context, substring + str2)) {
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DownloadBinActivity", "copyDownloadBlklistFromAssert failed");
                    }
                    this.f10935z.sendEmptyMessage(15);
                    return;
                }
            }
            this.f10921l.m8374a(substring, str2);
            this.f10920k.setText(R.string.cancel);
            this.f10917h.setVisibility(0);
            m7776c();
            return;
        }
        this.f10935z.sendEmptyMessage(6);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            NToast.m9444c(this.f10912c, (int) R.string.downloadbin_exit_hit);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: c */
    private void m7776c() {
        new C1998h(this).start();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f10933x = 0;
        if (this.f10932w) {
            new C2001k(this).start();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f10932w = true;
    }

    /* renamed from: d */
    private void m7774d() {
        int integer = getResources().getInteger(R.integer.updatebin_width_size);
        int integer2 = getResources().getInteger(R.integer.updatebin_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        double width = window.getWindowManager().getDefaultDisplay().getWidth() * integer;
        Double.isNaN(width);
        int i = (int) (width / 100.0d);
        double height = window.getWindowManager().getDefaultDisplay().getHeight() * integer2;
        Double.isNaN(height);
        window.setLayout(i, (int) (height / 75.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7772e() {
        finish();
        f10909a = false;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7774d();
    }
}
