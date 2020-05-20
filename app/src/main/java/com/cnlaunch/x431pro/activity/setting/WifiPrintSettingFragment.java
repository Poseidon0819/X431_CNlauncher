package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p275l.StartWifiPrinterSet;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;

/* renamed from: com.cnlaunch.x431pro.activity.setting.bk */
/* loaded from: classes.dex */
public class WifiPrintSettingFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: b */
    private TextView f14693b;

    /* renamed from: c */
    private TextView f14694c;

    /* renamed from: d */
    private Button f14695d;

    /* renamed from: e */
    private Button f14696e;

    /* renamed from: f */
    private Button f14697f;

    /* renamed from: g */
    private Button f14698g;

    /* renamed from: h */
    private C2553a f14699h;

    /* renamed from: i */
    private PreferencesManager f14700i;

    /* renamed from: j */
    private Handler f14701j;

    /* renamed from: k */
    private String f14702k = "224.0.0.1";

    /* renamed from: l */
    private int f14703l = 988;

    /* renamed from: m */
    private MulticastSocket f14704m = null;

    /* renamed from: n */
    private String f14705n = "ip";

    /* renamed from: a */
    boolean f14692a = false;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.print_launch_set_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14700i = PreferencesManager.m9595a(this.mContext);
        this.f14693b = (TextView) getActivity().findViewById(R.id.wifi_name);
        this.f14694c = (TextView) getActivity().findViewById(R.id.result);
        this.f14695d = (Button) getActivity().findViewById(R.id.selectwifiButton);
        this.f14695d.setOnClickListener(this);
        this.f14696e = (Button) getActivity().findViewById(R.id.attachprintButton);
        this.f14696e.setOnClickListener(this);
        this.f14697f = (Button) getActivity().findViewById(R.id.setprintButton);
        this.f14697f.setOnClickListener(this);
        this.f14698g = (Button) getActivity().findViewById(R.id.testprintButton);
        this.f14698g.setOnClickListener(this);
        this.f14694c.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (m5960a()) {
            this.f14693b.setText(m5957b());
        }
        try {
            this.f14704m = new MulticastSocket();
            this.f14704m.setSoTimeout(10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f14701j = new HandlerC2556bl(this);
        this.f14699h = new C2553a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        getActivity().registerReceiver(this.f14699h, intentFilter);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.wifi_print_setting, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(this.f14699h);
    }

    @Override // android.app.Fragment
    public void onResume() {
        if (m5960a()) {
            this.f14693b.setText(m5957b());
        } else {
            this.f14693b.setText(R.string.tv_unconnect);
        }
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.attachprintButton) {
            this.f14696e.setEnabled(false);
            this.f14696e.setText(R.string.bluetooth_connecting);
            this.f14694c.setText("");
            new C2554b().start();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new C2555c().start();
        } else if (id == R.id.selectwifiButton) {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else if (id == R.id.setprintButton) {
            replaceFragment(StartWifiPrinterSet.class.getName(), 1);
        } else if (id != R.id.testprintButton) {
        } else {
            request(20013);
            LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
        }
    }

    /* compiled from: WifiPrintSettingFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.bk$c */
    /* loaded from: classes.dex */
    public class C2555c extends Thread {
        public C2555c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            WifiPrintSettingFragment wifiPrintSettingFragment = WifiPrintSettingFragment.this;
            wifiPrintSettingFragment.f14692a = true;
            try {
                InetAddress byName = InetAddress.getByName(wifiPrintSettingFragment.f14702k);
                WifiPrintSettingFragment.this.f14704m.setTimeToLive(1);
                byte[] bytes = "HLK".getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, byName, WifiPrintSettingFragment.this.f14703l);
                while (WifiPrintSettingFragment.this.f14692a) {
                    WifiPrintSettingFragment.this.f14704m.send(datagramPacket);
                    Thread.sleep(2000L);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: WifiPrintSettingFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.bk$b */
    /* loaded from: classes.dex */
    public class C2554b extends Thread {
        public C2554b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr;
            DatagramPacket datagramPacket;
            long currentTimeMillis = System.currentTimeMillis() + 12000;
            while (true) {
                try {
                    MulticastSocket multicastSocket = WifiPrintSettingFragment.this.f14704m;
                    bArr = new byte[1024];
                    datagramPacket = new DatagramPacket(bArr, 1024);
                    multicastSocket.receive(datagramPacket);
                } catch (Exception unused) {
                    if (WifiPrintSettingFragment.this.f14692a) {
                        WifiPrintSettingFragment.this.f14692a = false;
                        Message message2 = new Message();
                        message2.what = 1;
                        WifiPrintSettingFragment.this.f14701j.sendMessage(message2);
                        return;
                    }
                }
                if (new String(bArr, 0, datagramPacket.getLength()).indexOf("HLK-") != -1) {
                    String substring = datagramPacket.getAddress().toString().substring(1);
                    WifiPrintSettingFragment.this.f14692a = false;
                    Message message3 = new Message();
                    message3.what = 0;
                    message3.obj = substring;
                    WifiPrintSettingFragment.this.f14701j.sendMessage(message3);
                    return;
                } else if (System.currentTimeMillis() > currentTimeMillis) {
                    WifiPrintSettingFragment.this.f14692a = false;
                    Message message4 = new Message();
                    message4.what = 1;
                    WifiPrintSettingFragment.this.f14701j.sendMessage(message4);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m5960a() {
        return ((ConnectivityManager) getActivity().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m5957b() {
        String str = "";
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        int networkId = connectionInfo.getNetworkId();
        Iterator<WifiConfiguration> it = wifiManager.getConfiguredNetworks().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WifiConfiguration next = it.next();
            if (next.networkId == networkId) {
                str = next.SSID;
                break;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str.replace("\"", "");
        }
        return connectionInfo.getSSID();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 20013) {
            return Integer.valueOf(PrintDataUtils.m4935a(this.mContext, this.f14705n));
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i != 20013) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
        Integer num = (Integer) obj;
        NetPOSPrinterUtil.m9439a(getActivity(), num.intValue());
        if (num.intValue() == 4095) {
            NToast.m9447b(getActivity(), (int) R.string.print_connect_printer);
            this.f14698g.setEnabled(false);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i != 20013) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
        NToast.m9450a(getActivity(), (int) R.string.print_error_fail);
        this.f14698g.setEnabled(false);
    }

    /* compiled from: WifiPrintSettingFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.bk$a */
    /* loaded from: classes.dex */
    public class C2553a extends BroadcastReceiver {
        public C2553a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (WifiPrintSettingFragment.this.m5960a()) {
                WifiPrintSettingFragment.this.f14693b.setText(WifiPrintSettingFragment.this.m5957b());
            } else {
                WifiPrintSettingFragment.this.f14693b.setText(R.string.tv_unconnect);
            }
        }
    }
}
