package com.cnlaunch.x431pro.activity.setting.wifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DPULinkSettingsInformation;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.NetworkUtil;
import com.cnlaunch.physics.p205k.WiFiConnectUtils;
import com.cnlaunch.physics.wifi.DPUWiFiModeConfig;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.bluetooth.BluetoothActivity;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.b */
/* loaded from: classes.dex */
public class DPUWiFiLinkModeSettings extends BaseFragment {

    /* renamed from: a */
    CheckBox f14860a;

    /* renamed from: b */
    RelativeLayout f14861b;

    /* renamed from: c */
    RadioButton f14862c;

    /* renamed from: d */
    RelativeLayout f14863d;

    /* renamed from: e */
    RadioButton f14864e;

    /* renamed from: f */
    Button f14865f;

    /* renamed from: g */
    Button f14866g;

    /* renamed from: h */
    Button f14867h;

    /* renamed from: i */
    TextView f14868i;

    /* renamed from: j */
    TextView f14869j;

    /* renamed from: k */
    private int f14870k;

    /* renamed from: l */
    private boolean f14871l;

    /* renamed from: m */
    private DPUWiFiModeSettingsWaitDialog f14872m;

    /* renamed from: n */
    private WiFiConnectUtils.InterfaceC1857a f14873n = new C2586i(this);

    /* renamed from: o */
    private final BroadcastReceiver f14874o = new C2587j(this);

    /* renamed from: p */
    private InterfaceC2579a f14875p = new C2588k(this);

    /* compiled from: DPUWiFiLinkModeSettings.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2579a {
        /* renamed from: a */
        void mo5857a();

        /* renamed from: a */
        void mo5856a(DPUWiFiModeConfig dPUWiFiModeConfig);

        /* renamed from: b */
        void mo5855b();

        /* renamed from: b */
        void mo5854b(DPUWiFiModeConfig dPUWiFiModeConfig);

        /* renamed from: c */
        void mo5853c();

        /* renamed from: c */
        void mo5852c(DPUWiFiModeConfig dPUWiFiModeConfig);

        /* renamed from: d */
        void mo5851d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m5877e(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        dPUWiFiLinkModeSettings.f14871l = true;
        return true;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        this.f14860a = (CheckBox) view.findViewById(R.id.chk_link_mode_wifi_switch);
        this.f14861b = (RelativeLayout) view.findViewById(R.id.rl_wifi_with_ap_mode);
        this.f14862c = (RadioButton) view.findViewById(R.id.chk_wifi_with_ap_mode);
        this.f14863d = (RelativeLayout) view.findViewById(R.id.rl_wifi_with_sta_mode);
        this.f14864e = (RadioButton) view.findViewById(R.id.chk_wifi_with_sta_mode);
        this.f14865f = (Button) view.findViewById(R.id.btn_wifi_with_sta_mode_modify);
        this.f14866g = (Button) view.findViewById(R.id.btn_wifi_mode_config_refresh);
        this.f14867h = (Button) view.findViewById(R.id.btn_wifi_config);
        this.f14868i = (TextView) view.findViewById(R.id.txt_wifi_with_sta_mode_information);
        this.f14869j = (TextView) view.findViewById(R.id.txt_wifi_with_ap_mode_information);
        this.f14860a.setOnCheckedChangeListener(new C2580c(this));
        this.f14862c.setOnCheckedChangeListener(new C2581d(this));
        this.f14864e.setOnCheckedChangeListener(new C2582e(this));
        this.f14866g.setOnClickListener(new View$OnClickListenerC2583f(this));
        this.f14865f.setOnClickListener(new View$OnClickListenerC2584g(this));
        this.f14867h.setOnClickListener(new View$OnClickListenerC2585h(this));
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiLinkModeSettings", " registerBroadcastReceiver()");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("DPUDeviceConnectSuccess");
        intentFilter.addAction("DPUDeviceConnectFail");
        this.mContext.registerReceiver(this.f14874o, intentFilter);
        this.f14870k = -1;
        this.f14871l = false;
        this.f14872m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5887a() {
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        boolean m8310b = DPULinkSettingsInformation.m8314a().m8310b(m9591a);
        int m8309c = DPULinkSettingsInformation.m8314a().m8309c(m9591a);
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiLinkModeSettings", String.format("get settings current serialNO=%1$S initial wifiSwitch = %2$b , work_mode=%3$d", m9591a, Boolean.valueOf(m8310b), Integer.valueOf(m8309c)));
        }
        this.f14869j.setText(String.format(getString(R.string.txt_wifi_with_ap_mode_information), getString(R.string.text_wifi_config), String.format("%s:%s  %s:%s", getString(R.string.wifi_ssid), m9591a, getString(R.string.wifi_password), "12345678")));
        if (m8310b) {
            this.f14860a.setChecked(true);
            this.f14861b.setVisibility(0);
            this.f14863d.setVisibility(0);
            this.f14866g.setVisibility(0);
            this.f14867h.setVisibility(0);
            switch (m8309c) {
                case 1:
                    this.f14862c.setChecked(true);
                    this.f14864e.setChecked(false);
                    this.f14868i.setVisibility(8);
                    this.f14865f.setVisibility(8);
                    return;
                case 2:
                    this.f14862c.setChecked(false);
                    this.f14864e.setChecked(true);
                    this.f14868i.setVisibility(0);
                    this.f14865f.setVisibility(0);
                    try {
                        WifiConfiguration m8308d = DPULinkSettingsInformation.m8314a().m8308d(m9591a);
                        String str = "";
                        switch (NetworkUtil.m8122a(m8308d)) {
                            case 0:
                                str = this.mContext.getString(R.string.wifi_security_none);
                                break;
                            case 1:
                                str = this.mContext.getString(R.string.wifi_security_wep);
                                break;
                            case 2:
                                str = this.mContext.getString(R.string.wifi_security_psk_generic);
                                break;
                        }
                        this.f14868i.setText(String.format("%s:%s  %s:%s", this.mContext.getString(R.string.wifi_ssid), m8308d.SSID, this.mContext.getString(R.string.wifi_security), str));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f14868i.setText("");
                        return;
                    }
                default:
                    return;
            }
        }
        this.f14860a.setChecked(false);
        this.f14861b.setVisibility(8);
        this.f14863d.setVisibility(8);
        this.f14866g.setVisibility(8);
        this.f14867h.setVisibility(8);
        this.f14862c.setChecked(false);
        this.f14864e.setChecked(false);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f14871l) {
            return;
        }
        m5887a();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiLinkModeSettings", "DPUWiFiLinkModeSettings onDestroy  ");
        }
        try {
            this.mContext.unregisterReceiver(this.f14874o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_wifi_settings_main, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5881a(boolean z, int i, WifiConfiguration wifiConfiguration) {
        if (this.mContext != null) {
            String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
            if (C1856n.f10135a) {
                C1856n.m8130a("DPUWiFiLinkModeSettings", String.format("save settings current serialNO=%1$S initial wifiSwitch = %2$b , work_mode=%3$d", m9591a, Boolean.valueOf(z), Integer.valueOf(i)));
            }
            DPULinkSettingsInformation.m8314a().m8311a(m9591a, z, i, wifiConfiguration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5886a(int i) {
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiLinkModeSettings", "doChangeWiFiModeConfig currentFunctionID =  ".concat(String.valueOf(i)));
        }
        if (MainActivity.m7907a()) {
            m5887a();
            NToast.m9444c(this.mContext, (int) R.string.terminate_diag);
            return;
        }
        this.f14870k = i;
        DeviceFactoryManager.m8305a().m8293b();
        DeviceFactoryManager.m8305a().m8288c();
        DiagnoseConstants.driviceConnStatus = false;
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        DeviceFactoryManager.m8305a().f9907g = 2;
        if (DeviceFactoryManager.m8305a().m8296a(true, this.mContext, m9591a) == 0) {
            Intent intent = new Intent();
            intent.putExtra("isFix", true);
            intent.setClass(this.mContext, BluetoothActivity.class);
            this.mContext.startActivity(intent);
            return;
        }
        DeviceFactoryManager.m8305a().m8301a(this.mContext, true, m9591a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5882a(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings, CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (C1856n.f10135a) {
            C1856n.m8130a("DPUWiFiLinkModeSettings", "buttonView = " + compoundButton + " text = " + compoundButton.toString() + " isPressed =" + compoundButton.isPressed());
        }
        if (id == R.id.chk_wifi_with_sta_mode) {
            if (z) {
                dPUWiFiLinkModeSettings.f14865f.setVisibility(0);
            } else {
                dPUWiFiLinkModeSettings.f14865f.setVisibility(8);
            }
        }
        if (compoundButton.isPressed()) {
            if (id != R.id.chk_link_mode_wifi_switch) {
                if (id == R.id.chk_wifi_with_ap_mode) {
                    if (z) {
                        dPUWiFiLinkModeSettings.f14864e.setChecked(false);
                        dPUWiFiLinkModeSettings.m5886a(R.id.chk_wifi_with_ap_mode);
                    }
                } else if (id == R.id.chk_wifi_with_sta_mode && z) {
                    dPUWiFiLinkModeSettings.f14862c.setChecked(false);
                    dPUWiFiLinkModeSettings.m5886a(R.id.chk_wifi_with_sta_mode);
                }
            } else if (z) {
                dPUWiFiLinkModeSettings.f14861b.setVisibility(0);
                dPUWiFiLinkModeSettings.f14863d.setVisibility(0);
                dPUWiFiLinkModeSettings.f14866g.setVisibility(0);
                dPUWiFiLinkModeSettings.f14867h.setVisibility(0);
                dPUWiFiLinkModeSettings.m5886a(R.id.chk_link_mode_wifi_switch);
            } else {
                dPUWiFiLinkModeSettings.f14861b.setVisibility(8);
                dPUWiFiLinkModeSettings.f14863d.setVisibility(8);
                dPUWiFiLinkModeSettings.f14866g.setVisibility(8);
                dPUWiFiLinkModeSettings.f14867h.setVisibility(8);
                dPUWiFiLinkModeSettings.m5881a(false, 0, (WifiConfiguration) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static /* synthetic */ void m5865q(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        DeviceFactoryManager.m8305a().m8293b();
        DeviceFactoryManager.m8305a().m8288c();
        dPUWiFiLinkModeSettings.f14871l = false;
    }
}
