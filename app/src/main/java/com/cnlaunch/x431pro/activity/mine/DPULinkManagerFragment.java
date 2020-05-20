package com.cnlaunch.x431pro.activity.mine;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p192a.p194b.PairUtils;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.setting.wifi.DPUWiFiLinkModeSettings;
import com.ifoer.expedition.pro.R;
import java.util.Iterator;

/* renamed from: com.cnlaunch.x431pro.activity.mine.ab */
/* loaded from: classes.dex */
public class DPULinkManagerFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a */
    RelativeLayout f13616a;

    /* renamed from: b */
    TextView f13617b;

    /* renamed from: c */
    Button f13618c;

    /* renamed from: d */
    TextView f13619d;

    /* renamed from: e */
    RelativeLayout f13620e;

    /* renamed from: f */
    TextView f13621f;

    /* renamed from: g */
    BluetoothAdapter f13622g;

    /* renamed from: h */
    private Handler f13623h = new HandlerC2394ac(this);

    /* renamed from: i */
    private final BroadcastReceiver f13624i = new C2395ad(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13622g = BluetoothAdapter.getDefaultAdapter();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_dpulink_manager_fragment, viewGroup, false);
        this.f13616a = (RelativeLayout) inflate.findViewById(R.id.rl_bluetooth_link_mode_operation);
        this.f13617b = (TextView) inflate.findViewById(R.id.txt_bluetooth_pair_state);
        this.f13618c = (Button) inflate.findViewById(R.id.btn_bluetooth_remove_pair);
        this.f13618c.setOnClickListener(this);
        this.f13619d = (TextView) inflate.findViewById(R.id.txt_bluetooth_remove_pair_information);
        this.f13620e = (RelativeLayout) inflate.findViewById(R.id.rl_wifi_link_mode_group);
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        setTitle(R.string.text_dpu_link_manager);
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f13621f = (TextView) view.findViewById(R.id.tv_current_serial_number);
        TextView textView = this.f13621f;
        if (textView != null) {
            textView.setText(String.format("%1s:%2s", this.mContext.getString(R.string.text_current_use_dpu), m9591a));
        }
        Fragment instantiate = Fragment.instantiate(this.mContext, DPUWiFiLinkModeSettings.class.getName(), null);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.rl_wifi_link_mode_operation, instantiate);
        beginTransaction.commitAllowingStateLoss();
        if (C1856n.f10135a) {
            C1856n.m8130a("DPULinkManagerFragment", " registerBroadcastReceiver()");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.mContext.registerReceiver(this.f13624i, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6499a() {
        boolean z;
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        if (Tools.m8096c(this.mContext, m9591a)) {
            this.f13620e.setVisibility(0);
        } else {
            this.f13620e.setVisibility(8);
        }
        TextView textView = this.f13621f;
        if (textView != null) {
            textView.setText(String.format("%1s:%2s", this.mContext.getString(R.string.text_current_use_dpu), m9591a));
        }
        if (this.f13622g.isEnabled()) {
            Iterator<BluetoothDevice> it = this.f13622g.getBondedDevices().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                BluetoothDevice next = it.next();
                if (C1856n.f10135a) {
                    C1856n.m8130a("DPULinkManagerFragment", " paired device name = " + next.getName());
                }
                if (next.getName() != null && next.getName().equals(m9591a)) {
                    this.f13617b.setText(String.format("%1s", this.mContext.getString(R.string.text_bluetooth_paired)));
                    this.f13618c.setVisibility(0);
                    this.f13618c.setTag(next.getAddress());
                    this.f13619d.setVisibility(0);
                    z = true;
                    break;
                }
            }
            if (!z) {
                DeviceFactoryManager.m8305a();
                String m8302a = DeviceFactoryManager.m8302a(this.mContext, m9591a);
                if (C1856n.f10135a) {
                    C1856n.m8130a("DPULinkManagerFragment", " check bluetooth address = ".concat(String.valueOf(m8302a)));
                }
                if (!TextUtils.isEmpty(m8302a)) {
                    BluetoothDevice remoteDevice = this.f13622g.getRemoteDevice(m8302a);
                    if (C1856n.f10135a) {
                        C1856n.m8130a("DPULinkManagerFragment", " check bluetooth bluetoothDevice state = " + remoteDevice.getBondState());
                    }
                    if (remoteDevice != null) {
                        try {
                            PairUtils.m8401a(BluetoothDevice.class, remoteDevice);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        z = false;
                    }
                }
            }
            if (z) {
                return;
            }
            this.f13617b.setText(String.format("%1s", this.mContext.getString(R.string.text_bluetooth_unpair)));
            this.f13618c.setVisibility(8);
            this.f13619d.setVisibility(8);
            return;
        }
        this.f13617b.setText(String.format("%1s", this.mContext.getString(R.string.text_bluetooth_unpair)));
        this.f13618c.setVisibility(8);
        this.f13619d.setVisibility(8);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m6499a();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            this.mContext.unregisterReceiver(this.f13624i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_bluetooth_remove_pair) {
            return;
        }
        try {
            BluetoothDevice remoteDevice = this.f13622g.getRemoteDevice((String) view.getTag());
            if (remoteDevice != null) {
                ((Boolean) BluetoothDevice.class.getMethod("removeBond", new Class[0]).invoke(remoteDevice, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
