package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.bluetooth.BluetoothActivity;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;

/* renamed from: com.cnlaunch.x431pro.activity.mine.ae */
/* loaded from: classes.dex */
public class FirmwareFixFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: b */
    private TextView f13628b;

    /* renamed from: c */
    private Button f13629c;

    /* renamed from: d */
    private TextView f13630d;

    /* renamed from: e */
    private ProgressBar f13631e;

    /* renamed from: f */
    private TextView f13632f;

    /* renamed from: g */
    private float f13633g;

    /* renamed from: j */
    private String f13636j;

    /* renamed from: o */
    private int f13641o;

    /* renamed from: p */
    private WaitDialog f13642p;

    /* renamed from: q */
    private int f13643q;

    /* renamed from: h */
    private String f13634h = ".";

    /* renamed from: i */
    private DownloadBinUpdate f13635i = null;

    /* renamed from: k */
    private boolean f13637k = false;

    /* renamed from: l */
    private boolean f13638l = false;

    /* renamed from: m */
    private boolean f13639m = false;

    /* renamed from: n */
    private boolean f13640n = false;

    /* renamed from: r */
    private final Handler f13644r = new HandlerC2396af(this);

    /* renamed from: s */
    private final BroadcastReceiver f13645s = new C2398ah(this);

    /* renamed from: a */
    OnDownloadBinListener f13627a = new C2399ai(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public static /* synthetic */ int m6495C(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13641o = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public static /* synthetic */ int m6494D(FirmwareFixFragment firmwareFixFragment) {
        int i = firmwareFixFragment.f13641o;
        firmwareFixFragment.f13641o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m6487b(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13637k = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m6486c(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13638l = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m6484e(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13640n = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public static /* synthetic */ WaitDialog m6467v(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13642p = null;
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13642p = null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("DPUDeviceConnectSuccess");
        intentFilter.addAction("DPUDeviceConnectFail");
        intentFilter.addAction("DeviceConnectLost");
        this.mContext.registerReceiver(this.f13645s, intentFilter);
        setTitle(R.string.mine_firmware_fix);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f13628b = (TextView) getActivity().findViewById(R.id.fix_message);
        String string = getActivity().getResources().getString(R.string.diy_firmware_update);
        int indexOf = string.indexOf(".");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), indexOf + 1, string.length(), 34);
        this.f13628b.setText(spannableStringBuilder);
        this.f13629c = (Button) getActivity().findViewById(R.id.positiveButton);
        this.f13629c.setOnClickListener(this);
        this.f13632f = (TextView) getActivity().findViewById(R.id.progress_info);
        this.f13630d = (TextView) getActivity().findViewById(R.id.progress_msg);
        if (this.f13640n) {
            this.f13630d.setText("100%");
        }
        this.f13631e = (ProgressBar) getActivity().findViewById(R.id.progress_dialog);
        this.f13631e.setVisibility(8);
        this.f13630d.setVisibility(8);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_firmware_fix, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        try {
            this.mContext.unregisterReceiver(this.f13645s);
            if (this.f13637k) {
                if (this.f13635i != null) {
                    this.f13635i.f9809e = true;
                }
                MineActivity.f13541n = false;
                this.f13637k = false;
                DiagnoseConstants.driviceConnStatus = false;
                DeviceFactoryManager.m8305a().m8293b();
                DeviceFactoryManager.m8305a().m8288c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.negativeButton) {
            replaceFragment(MineFragment.class.getName(), 1);
        } else if (id != R.id.positiveButton) {
        } else {
            m6493a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6493a() {
        this.f13639m = false;
        this.f13640n = false;
        this.f13631e.setVisibility(0);
        this.f13630d.setVisibility(0);
        if (MainActivity.m7907a()) {
            NToast.m9444c(this.mContext, (int) R.string.terminate_diag);
            return;
        }
        DeviceFactoryManager.m8305a().m8288c();
        DiagnoseConstants.driviceConnStatus = false;
        DeviceFactoryManager.m8305a().f9907g = 1;
        int m8296a = DeviceFactoryManager.m8305a().m8296a(true, this.mContext, (String) null);
        if (m8296a == 0) {
            Intent intent = new Intent();
            intent.putExtra("isFix", true);
            intent.setClass(this.mContext, BluetoothActivity.class);
            this.mContext.startActivity(intent);
            return;
        }
        String str = "";
        if (m8296a == 1 || m8296a == 2) {
            if (m8296a == 1) {
                str = String.format("%1$s: %2$s......", getResources().getString(R.string.connect_dpu_device_with_wifi_tip_message), PreferencesManager.m9595a(this.mContext).m9591a("serialNo"));
            } else if (m8296a == 2) {
                str = String.format("%1$s: %2$s......", getResources().getString(R.string.connect_dpu_device_with_serialport_tip_message), PreferencesManager.m9595a(this.mContext).m9591a("serialNo"));
            }
            WaitDialog waitDialog = this.f13642p;
            if (waitDialog != null) {
                waitDialog.dismiss();
                this.f13642p = null;
            }
            Context context = this.mContext;
            getResources().getString(R.string.common_title_tips);
            this.f13642p = new WaitDialog(context, str);
            this.f13642p.setCanceledOnTouchOutside(false);
            this.f13642p.setCancelable(false);
            this.f13642p.show();
        }
        DeviceFactoryManager.m8305a().m8301a(this.mContext, true, (String) null);
        if (DeviceFactoryManager.m8305a().f9903c == 0) {
            WaitDialog waitDialog2 = this.f13642p;
            if (waitDialog2 != null) {
                waitDialog2.dismiss();
                this.f13642p = null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("isFix", true);
            intent2.setClass(this.mContext, BluetoothActivity.class);
            this.mContext.startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static /* synthetic */ void m6465x(FirmwareFixFragment firmwareFixFragment) {
        firmwareFixFragment.f13637k = true;
        firmwareFixFragment.f13635i = new DownloadBinUpdate(firmwareFixFragment.f13627a, DeviceFactoryManager.m8305a().f9901a);
        if (DeviceFactoryManager.m8305a().f9903c == 0) {
            String m8280e = DeviceFactoryManager.m8305a().m8280e();
            String str = PathUtils.m4854d(firmwareFixFragment.mContext, m8280e) + "Diagnostic/Configure/Download/DOWNLOAD.ini";
            File file = new File(str);
            firmwareFixFragment.f13636j = str;
            if (TextUtils.isEmpty(m8280e)) {
                firmwareFixFragment.f13644r.sendEmptyMessage(15);
                return;
            } else if (Tools.m8114a()) {
                if (!file.isFile()) {
                    firmwareFixFragment.f13644r.sendEmptyMessage(15);
                    return;
                }
                DownloadBinUpdate downloadBinUpdate = firmwareFixFragment.f13635i;
                String str2 = firmwareFixFragment.f13636j;
                downloadBinUpdate.m8374a(str2.substring(0, str2.lastIndexOf("/")), "/DOWNLOAD.hex");
            } else if (!file.isFile()) {
                firmwareFixFragment.f13644r.sendEmptyMessage(15);
                return;
            } else {
                DownloadBinUpdate downloadBinUpdate2 = firmwareFixFragment.f13635i;
                String str3 = firmwareFixFragment.f13636j;
                downloadBinUpdate2.m8374a(str3.substring(0, str3.lastIndexOf("/")), "/DOWNLOAD.bin");
            }
        } else if (Tools.m8114a()) {
            firmwareFixFragment.f13644r.sendEmptyMessage(16);
            return;
        } else {
            String m9591a = PreferencesManager.m9595a((Context) firmwareFixFragment.getActivity()).m9591a("serialNo");
            String str4 = PathUtils.m4854d(firmwareFixFragment.mContext, m9591a) + "Diagnostic/Configure/Download/DOWNLOAD.ini";
            File file2 = new File(str4);
            firmwareFixFragment.f13636j = str4;
            if (TextUtils.isEmpty(m9591a)) {
                firmwareFixFragment.f13644r.sendEmptyMessage(15);
                return;
            } else if (!file2.isFile()) {
                firmwareFixFragment.f13644r.sendEmptyMessage(15);
                return;
            } else {
                DownloadBinUpdate downloadBinUpdate3 = firmwareFixFragment.f13635i;
                String str5 = firmwareFixFragment.f13636j;
                downloadBinUpdate3.m8374a(str5.substring(0, str5.lastIndexOf("/")), "/DOWNLOAD.bin");
            }
        }
        MineActivity.f13541n = true;
        new C2400aj(firmwareFixFragment).start();
    }
}
