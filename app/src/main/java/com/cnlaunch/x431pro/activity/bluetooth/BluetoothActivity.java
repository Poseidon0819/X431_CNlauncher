package com.cnlaunch.x431pro.activity.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.RomoteLocalSwitch;
import com.cnlaunch.physics.p192a.BluetoothManager;
import com.cnlaunch.physics.p192a.BluetoothScanManager;
import com.cnlaunch.physics.p192a.p193a.BluetoothBLEManager;
import com.cnlaunch.physics.p192a.p194b.BluetoothManagerImpl;
import com.cnlaunch.physics.p197c.BluetoothListDto;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p201g.OnBluetoothListener;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;
import com.cnlaunch.x431pro.activity.BaseDialogActivity;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BluetoothActivity extends BaseDialogActivity implements View.OnClickListener {

    /* renamed from: a */
    public static BluetoothActivity f10887a;

    /* renamed from: c */
    private Context f10889c;

    /* renamed from: e */
    private RelativeLayout f10891e;

    /* renamed from: f */
    private RelativeLayout f10892f;

    /* renamed from: g */
    private Button f10893g;

    /* renamed from: h */
    private Button f10894h;

    /* renamed from: i */
    private Button f10895i;

    /* renamed from: k */
    private BluetoothScanManager f10897k;

    /* renamed from: o */
    private boolean f10901o;

    /* renamed from: p */
    private String f10902p;

    /* renamed from: r */
    private int f10904r;

    /* renamed from: s */
    private boolean f10905s;

    /* renamed from: d */
    private ListView f10890d = null;

    /* renamed from: j */
    private BluetoothListAdapter f10896j = null;

    /* renamed from: l */
    private String f10898l = "";

    /* renamed from: m */
    private String f10899m = "";

    /* renamed from: n */
    private ArrayList<BluetoothListDto> f10900n = null;

    /* renamed from: q */
    private final int f10903q = 20502;

    /* renamed from: t */
    private boolean f10906t = false;

    /* renamed from: u */
    private boolean f10907u = false;

    /* renamed from: b */
    OnBluetoothListener f10888b = new C1992b(this);

    /* renamed from: v */
    private final Handler f10908v = new HandlerC1993c(this);

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C1856n.f10135a) {
            C1856n.m8130a("BluetoothActivity", "onCreate");
        }
        super.onCreate(bundle);
        f10887a = this;
        this.f10905s = false;
        setContentView(R.layout.activity_bluetooth_list);
        if (getIntent().hasExtra("isDiagModel")) {
            this.f10907u = getIntent().getBooleanExtra("isDiagModel", false);
        }
        this.f10898l = getIntent().getStringExtra("Lib_path");
        this.f10899m = getIntent().getStringExtra("Lib_language");
        DiagnoseConstants.DIAGNOSE_LIB_PATH = this.f10898l;
        DiagnoseConstants.DIAGNOSE_LANGUAGE = this.f10899m;
        this.f10901o = getIntent().getBooleanExtra("isFix", false);
        this.f10902p = PreferencesManager.m9595a((Context) this).m9591a("serialNo");
        String str = this.f10902p;
        if (str == null) {
            str = "";
        }
        this.f10902p = str;
        m7797b();
        this.f10889c = this;
        this.f10893g = (Button) findViewById(R.id.btn_scan);
        this.f10893g.setEnabled(true);
        this.f10893g.setText(R.string.bluetooth_scan_start);
        this.f10894h = (Button) findViewById(R.id.btn_exit);
        this.f10893g.setOnClickListener(this);
        this.f10894h.setOnClickListener(this);
        this.f10891e = (RelativeLayout) findViewById(R.id.frame_bluetooth_error_tips);
        this.f10892f = (RelativeLayout) findViewById(R.id.frame_bluetooth_list);
        this.f10895i = (Button) findViewById(R.id.btn_confirm);
        Button button = this.f10895i;
        if (button != null) {
            button.setOnClickListener(this);
        }
        this.f10904r = DeviceFactoryManager.m8305a().f9907g;
        this.f10900n = new ArrayList<>();
        this.f10897k = new BluetoothScanManager(this.f10889c);
        BluetoothScanManager bluetoothScanManager = this.f10897k;
        bluetoothScanManager.f9791b = this.f10888b;
        if (bluetoothScanManager.f9791b != null) {
            bluetoothScanManager.f9791b.mo7748a(0);
        }
        this.f10890d = (ListView) findViewById(R.id.listview_show);
        TextView textView = (TextView) findViewById(R.id.textview_discovery_empty);
        if (textView != null) {
            this.f10890d.setEmptyView(textView);
        }
        this.f10900n.clear();
        this.f10900n.addAll(m7798a(this.f10897k.f9792c, this.f10902p, 100));
        this.f10896j = new BluetoothListAdapter(this.f10900n, this.f10889c);
        this.f10890d.setAdapter((ListAdapter) this.f10896j);
        this.f10890d.setOnItemClickListener(new C1991a(this));
        if (getIntent().getBooleanExtra("is_connect_fail", false)) {
            RelativeLayout relativeLayout = this.f10891e;
            if (relativeLayout != null) {
                this.f10905s = true;
                relativeLayout.setVisibility(0);
                return;
            }
            this.f10897k.m8393b();
            return;
        }
        this.f10897k.m8393b();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseDialogActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f10897k.m8399a();
        if (DiagnoseConstants.driviceConnStatus || this.f10906t || !this.f10907u) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("CancelConnectBuletooth");
        sendBroadcast(intent);
        setResult(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_scan) {
            this.f10897k.m8393b();
        } else if (id == R.id.btn_exit) {
            this.f10897k.m8399a();
            this.f10906t = true;
            if (this.f10907u) {
                Intent intent = new Intent();
                intent.setAction("CancelConnectBuletooth");
                sendBroadcast(intent);
                setResult(0);
            }
            finish();
        } else if (id == R.id.btn_confirm) {
            RelativeLayout relativeLayout = this.f10891e;
            if (relativeLayout != null) {
                this.f10905s = false;
                relativeLayout.setVisibility(8);
            }
            ListView listView = this.f10890d;
            if (listView != null) {
                listView.setEnabled(true);
            }
            Button button = this.f10894h;
            if (button != null) {
                button.setEnabled(true);
            }
            Button button2 = this.f10893g;
            if (button2 != null) {
                button2.setEnabled(true);
            }
        }
    }

    /* renamed from: b */
    private void m7797b() {
        int integer = getResources().getInteger(R.integer.bluetoothlist_width_size);
        int integer2 = getResources().getInteger(R.integer.bluetoothlist_height_size);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.4f;
        window.setLayout((window.getWindowManager().getDefaultDisplay().getWidth() * integer) / 100, (window.getWindowManager().getDefaultDisplay().getHeight() * integer2) / 100);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10889c = this;
        m7797b();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListView listView;
        if (i != 4 || keyEvent.getAction() != 0 || (listView = this.f10890d) == null || listView.isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<BluetoothListDto> m7798a(ArrayList<BluetoothListDto> arrayList, String str, int i) {
        if (!this.f10901o || DeviceFactoryManager.m8305a().f9907g == 2) {
            ArrayList<BluetoothListDto> arrayList2 = new ArrayList<>();
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                } else if (str.equalsIgnoreCase(arrayList.get(i2).f9844a)) {
                    arrayList2.add(arrayList.get(i2));
                    if (C1856n.f10135a) {
                        C1856n.m8130a("BluetoothActivity", "getBluetoothListDtoWithSerialNo BluetoothName =  " + arrayList.get(i2).f9844a + " isAutoConnectDevice=" + this.f10905s);
                    }
                    if (i == 100 && !this.f10905s) {
                        if (C1856n.f10135a) {
                            C1856n.m8130a("BluetoothActivity", "isAutoConnectDevice state");
                        }
                        this.f10905s = true;
                        this.f10908v.sendMessage(this.f10908v.obtainMessage(5632, arrayList.get(i2)));
                    }
                } else {
                    i2++;
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m7803a(BluetoothManager bluetoothManager, BluetoothListDto bluetoothListDto) {
        DeviceFactoryManager.m8305a().f9907g = this.f10904r;
        if (bluetoothManager == null) {
            if (C1856n.f10135a) {
                C1856n.m8130a("BluetoothActivity", "当前不是蓝牙连接模式 需关闭当前设备");
            }
            NToast.m9449a(this.f10889c, "Communication mode error!");
            return;
        }
        BluetoothDevice bluetoothDevice = bluetoothListDto.f9849f;
        C1856n.m8127b("BluetoothManagerProxy", "connect Bluetooth Device ");
        if (bluetoothManager.f9751f) {
            if (bluetoothManager.f9748c != null) {
                if (bluetoothManager.f9748c.getState() == 3) {
                    bluetoothManager.f9748c.m8494a();
                } else {
                    BluetoothBLEManager bluetoothBLEManager = bluetoothManager.f9748c;
                    bluetoothBLEManager.f9712g = false;
                    bluetoothBLEManager.f9715j = 3;
                    bluetoothBLEManager.f9711f = bluetoothDevice;
                    bluetoothBLEManager.m8480b();
                }
            }
        } else if (RomoteLocalSwitch.m8086a().f10149a) {
            try {
                if (bluetoothManager.f9746a.mo8431a() == 3) {
                    bluetoothManager.f9746a.mo8411j();
                } else {
                    bluetoothManager.f9746a.mo8429a(bluetoothDevice.getAddress());
                }
            } catch (Exception e) {
                e.printStackTrace();
                bluetoothManager.m8448b();
            }
        } else if (bluetoothManager.f9747b != null) {
            if (bluetoothManager.f9747b.getState() == 3) {
                bluetoothManager.f9747b.m8435c();
            } else {
                BluetoothManagerImpl bluetoothManagerImpl = bluetoothManager.f9747b;
                C1856n.m8127b("BluetoothManagerImpl", "connect Bluetooth Device ");
                bluetoothManagerImpl.f9764k = false;
                bluetoothManagerImpl.f9756c = true;
                bluetoothManagerImpl.f9757d = 4;
                bluetoothManagerImpl.f9759f = bluetoothDevice;
                bluetoothManagerImpl.m8445a();
            }
        }
        this.f10890d.setEnabled(false);
        Button button = this.f10894h;
        if (button != null) {
            button.setEnabled(false);
        }
        Button button2 = this.f10893g;
        if (button2 != null) {
            button2.setEnabled(false);
        }
        String str = bluetoothListDto.f9844a;
        String str2 = bluetoothListDto.f9845b;
        PreferencesManager m9595a = PreferencesManager.m9595a(this.f10889c);
        m9595a.m9588a("bluetooth_address", str2);
        m9595a.m9588a("bluetooth_name", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7801a(BluetoothActivity bluetoothActivity, BluetoothListDto bluetoothListDto) {
        if (bluetoothListDto != null) {
            if (DiagnoseConstants.driviceConnStatus) {
                NToast.m9450a(bluetoothActivity.f10889c, (int) R.string.bluetooth_search_with_connected_state_message);
                return;
            }
            int m8296a = DeviceFactoryManager.m8305a().m8296a(bluetoothActivity.f10901o, bluetoothActivity.f10889c, bluetoothListDto.f9849f.getName());
            if (m8296a != 0) {
                switch (m8296a) {
                    case 1:
                        NToast.m9450a(bluetoothActivity.f10889c, (int) R.string.connect_bluetooth_error_with_link_wifi_mode_tip_message);
                        return;
                    case 2:
                        NToast.m9450a(bluetoothActivity.f10889c, (int) R.string.connect_bluetooth_error_with_link_serialport_mode_tip_message);
                        return;
                    case 3:
                        NToast.m9450a(bluetoothActivity.f10889c, (int) R.string.connect_bluetooth_error_with_usb_tip_message);
                        return;
                    default:
                        return;
                }
            }
            String name = bluetoothListDto.f9849f.getName();
            IPhysics m8301a = DeviceFactoryManager.m8305a().m8301a(bluetoothActivity.f10889c, bluetoothActivity.f10901o, name);
            BluetoothManager bluetoothManager = m8301a instanceof BluetoothManager ? (BluetoothManager) m8301a : null;
            if (bluetoothManager != null) {
                if (bluetoothManager.getState() == 3) {
                    if (!(Tools.m8112a(bluetoothActivity.f10889c, name) && !Tools.m8099b(bluetoothActivity.f10889c, name))) {
                        new C1994d(bluetoothActivity, bluetoothListDto).start();
                        return;
                    }
                    DeviceFactoryManager.m8305a().m8284d();
                    DeviceFactoryManager.m8305a().f9907g = bluetoothActivity.f10904r;
                    IPhysics m8301a2 = DeviceFactoryManager.m8305a().m8301a(bluetoothActivity.f10889c, bluetoothActivity.f10901o, name);
                    bluetoothActivity.m7803a(m8301a2 instanceof BluetoothManager ? (BluetoothManager) m8301a2 : null, bluetoothListDto);
                    return;
                }
                bluetoothActivity.m7803a(bluetoothManager, bluetoothListDto);
                return;
            }
            if (C1856n.f10135a) {
                C1856n.m8130a("BluetoothActivity", "当前不是蓝牙连接模式 需关闭当前设备");
            }
            NToast.m9449a(bluetoothActivity.f10889c, "Communication mode error!");
        }
    }
}
