package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.mycar.jni.JniX431FileTest;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.bluetooth.BluetoothActivity;
import com.cnlaunch.x431pro.activity.mine.p231c.VoltageDataStreamGraph;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p288h.PrintDataUtils;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.PrinterFailrueDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.volley.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.mine.cz */
/* loaded from: classes.dex */
public class VehicleVoltageFragment extends BaseFragment implements View.OnClickListener, FragmentKeyDownListener.InterfaceC1949a {

    /* renamed from: C */
    private String f14162C;

    /* renamed from: D */
    private JniX431FileTest f14163D;

    /* renamed from: E */
    private long f14164E;

    /* renamed from: F */
    private String f14165F;

    /* renamed from: G */
    private String f14166G;

    /* renamed from: H */
    private long f14167H;

    /* renamed from: I */
    private long f14168I;

    /* renamed from: J */
    private String f14169J;

    /* renamed from: c */
    BasicDataStreamBean f14172c;

    /* renamed from: d */
    private TextView f14173d;

    /* renamed from: e */
    private TextView f14174e;

    /* renamed from: f */
    private TextView f14175f;

    /* renamed from: g */
    private TextView f14176g;

    /* renamed from: h */
    private TextView f14177h;

    /* renamed from: i */
    private TextView f14178i;

    /* renamed from: j */
    private Button f14179j;

    /* renamed from: l */
    private LinearLayout f14181l;

    /* renamed from: n */
    private Timer f14183n;

    /* renamed from: o */
    private TimerTask f14184o;

    /* renamed from: r */
    private RelativeLayout f14187r;

    /* renamed from: s */
    private VoltageDataStreamGraph f14188s;

    /* renamed from: t */
    private boolean f14189t;

    /* renamed from: u */
    private boolean f14190u;

    /* renamed from: v */
    private RelativeLayout f14191v;

    /* renamed from: w */
    private Chronometer f14192w;

    /* renamed from: x */
    private InputDialog f14193x;

    /* renamed from: y */
    private boolean f14194y;

    /* renamed from: k */
    private DownloadBinUpdate f14180k = null;

    /* renamed from: m */
    private float f14182m = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: p */
    private boolean f14185p = false;

    /* renamed from: q */
    private FragmentKeyDownListener f14186q = null;

    /* renamed from: z */
    private boolean f14195z = false;

    /* renamed from: A */
    private final BroadcastReceiver f14160A = new C2475da(this);

    /* renamed from: B */
    private final Handler f14161B = new HandlerC2477dc(this);

    /* renamed from: a */
    OnDownloadBinListener f14170a = new C2478dd(this);

    /* renamed from: b */
    ArrayList<BasicDataStreamBean> f14171b = new ArrayList<>(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m6155e(VehicleVoltageFragment vehicleVoltageFragment) {
        vehicleVoltageFragment.f14185p = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public static /* synthetic */ boolean m6141s(VehicleVoltageFragment vehicleVoltageFragment) {
        vehicleVoltageFragment.f14194y = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static /* synthetic */ JniX431FileTest m6136x(VehicleVoltageFragment vehicleVoltageFragment) {
        vehicleVoltageFragment.f14163D = null;
        return null;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FragmentKeyDownListener) {
            this.f14186q = (FragmentKeyDownListener) activity;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentKeyDownListener fragmentKeyDownListener = this.f14186q;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("DPUDeviceConnectSuccess");
        intentFilter.addAction("DPUDeviceConnectFail");
        intentFilter.addAction("DeviceConnectLost");
        this.mContext.registerReceiver(this.f14160A, intentFilter);
        setTitle(R.string.mine_vehicle_voltage);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14173d = (TextView) getActivity().findViewById(R.id.tv_vehicle_voltage_value);
        this.f14178i = (TextView) getActivity().findViewById(R.id.btn_start);
        this.f14178i.setOnClickListener(this);
        this.f14178i.requestFocus();
        this.f14174e = (TextView) getActivity().findViewById(R.id.btn_stop);
        this.f14174e.setOnClickListener(this);
        this.f14175f = (TextView) getActivity().findViewById(R.id.btn_save);
        this.f14175f.setOnClickListener(this);
        this.f14176g = (TextView) getActivity().findViewById(R.id.btn_clear);
        this.f14176g.setOnClickListener(this);
        this.f14179j = (Button) getActivity().findViewById(R.id.btn_stop_record);
        this.f14179j.setOnClickListener(this);
        this.f14177h = (TextView) getActivity().findViewById(R.id.btn_print);
        this.f14177h.setOnClickListener(this);
        this.f14191v = (RelativeLayout) getActivity().findViewById(R.id.v_record);
        this.f14192w = (Chronometer) getActivity().findViewById(R.id.chronometer_record_time);
        this.f14192w.setFormat("%s");
        this.f14176g.setEnabled(false);
        this.f14177h.setEnabled(false);
        this.f14175f.setEnabled(false);
        this.f14181l = (LinearLayout) getActivity().findViewById(R.id.voltage_des_layout);
        this.f14187r = (RelativeLayout) getActivity().findViewById(R.id.rl_large_graph);
        this.f14188s = new VoltageDataStreamGraph(this.mContext, this.f14187r);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_vehicle_voltage, viewGroup, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        double y;
        switch (view.getId()) {
            case R.id.btn_clear /* 2131296420 */:
                VoltageDataStreamGraph voltageDataStreamGraph = this.f14188s;
                synchronized (voltageDataStreamGraph.f14021c) {
                    if (voltageDataStreamGraph.f14023e <= 1) {
                        return;
                    }
                    if (voltageDataStreamGraph.f14023e > VoltageDataStreamGraph.f14018f) {
                        y = voltageDataStreamGraph.f14021c.getY(VoltageDataStreamGraph.f14018f - 1);
                    } else {
                        y = voltageDataStreamGraph.f14021c.getY(voltageDataStreamGraph.f14023e - 1);
                    }
                    voltageDataStreamGraph.f14021c.clear();
                    voltageDataStreamGraph.f14023e = 0;
                    XYSeries xYSeries = voltageDataStreamGraph.f14021c;
                    int i = voltageDataStreamGraph.f14023e;
                    voltageDataStreamGraph.f14023e = i + 1;
                    xYSeries.add(i, y);
                    voltageDataStreamGraph.f14022d.m9673a();
                    return;
                }
            case R.id.btn_print /* 2131296520 */:
                LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
                this.f14169J = getString(R.string.mine_vehicle_voltage) + "  " + this.f14182m + "V  " + getString(R.string.voltage_value_start) + getString(R.string.engine_start) + "  " + getString(R.string.voltage_value_unstart) + getString(R.string.engine_unstart);
                request(20013);
                return;
            case R.id.btn_save /* 2131296541 */:
                if (this.f14190u) {
                    return;
                }
                if (FileUtils.m5027a() > 30) {
                    new File(PathUtils.m4843m()).mkdirs();
                    this.f14175f.setEnabled(false);
                    this.f14177h.setEnabled(false);
                    this.f14176g.setEnabled(false);
                    this.f14191v.setVisibility(0);
                    this.f14192w.setBase(SystemClock.elapsedRealtime());
                    this.f14192w.start();
                    String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.getDefault());
                    this.f14163D = new JniX431FileTest();
                    this.f14164E = this.f14163D.init();
                    this.f14162C = DateUtils.m5094a(DateStyle.f15729g).replace("-", "").replace(":", "").replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
                    String string = getString(R.string.mine_vehicle_voltage);
                    String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
                    this.f14166G = string + "_" + m9591a + "_" + this.f14162C;
                    this.f14166G = this.f14166G.replace("/", "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f14166G);
                    sb.append(".x431");
                    this.f14165F = sb.toString();
                    this.f14189t = true;
                    this.f14190u = true;
                    this.f14167H = this.f14163D.creatFile(this.f14165F, upperCase, BuildConfig.VERSION_NAME, m9591a, this.f14164E, PathUtils.m4843m());
                    long j = this.f14167H;
                    if (j != 0) {
                        this.f14168I = this.f14163D.writeNewGroup(j, string, this.f14162C);
                        return;
                    }
                    NToast.m9444c(getActivity(), (int) R.string.datastream_record_create_err);
                    this.f14191v.setVisibility(8);
                    this.f14192w.stop();
                    this.f14163D = null;
                    this.f14189t = false;
                    this.f14190u = false;
                    this.f14175f.setEnabled(true);
                    this.f14177h.setEnabled(true);
                    this.f14176g.setEnabled(true);
                    return;
                }
                NToast.m9450a(this.mContext, (int) R.string.datastream_record_create_file_err);
                return;
            case R.id.btn_start /* 2131296572 */:
                if (MainActivity.m7907a()) {
                    NToast.m9444c(this.mContext, (int) R.string.terminate_diag);
                    return;
                }
                DeviceFactoryManager.m8305a().m8288c();
                DiagnoseConstants.driviceConnStatus = false;
                DeviceFactoryManager.m8305a().f9903c = 0;
                if (DeviceFactoryManager.m8305a().f9903c == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("isFix", true);
                    intent.setClass(this.mContext, BluetoothActivity.class);
                    this.mContext.startActivity(intent);
                } else {
                    DeviceFactoryManager.m8305a().m8301a(this.mContext, true, (String) null);
                }
                this.f14194y = false;
                this.f14195z = true;
                return;
            case R.id.btn_stop_record /* 2131296575 */:
                m6168a();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7737d(8);
        getActivity().findViewById(R.id.area_right).setVisibility(8);
        getActivity().findViewById(R.id.menu_update_tip).setVisibility(8);
        getActivity().findViewById(R.id.img_right).setVisibility(8);
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        getActivity().getParent().getWindow().setSoftInputMode(34);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().findViewById(R.id.area_right).setVisibility(0);
        getActivity().findViewById(R.id.menu_update_tip).setVisibility(0);
        getActivity().findViewById(R.id.img_right).setVisibility(0);
        ((ActivityC2004c) getActivity()).m7737d(0);
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        getActivity().getParent().getWindow().setSoftInputMode(18);
        FragmentKeyDownListener fragmentKeyDownListener = this.f14186q;
        if (fragmentKeyDownListener != null) {
            fragmentKeyDownListener.mo6039a(null);
        }
        Timer timer = this.f14183n;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.f14184o;
        if (timerTask != null) {
            timerTask.cancel();
        }
        try {
            Thread.sleep(500L);
            this.mContext.unregisterReceiver(this.f14160A);
            if (this.f14195z) {
                if (this.f14180k != null) {
                    this.f14180k.f9809e = true;
                }
                DiagnoseConstants.driviceConnStatus = false;
                DeviceFactoryManager.m8305a().m8293b();
                DeviceFactoryManager.m8305a().m8288c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && this.f14185p) {
            new C2479de(this).m4607b(this.mContext, R.string.mine_vehicle_voltage, R.string.vehicle_voltage_exit, true);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    private void m6168a() {
        this.f14175f.setEnabled(true);
        this.f14177h.setEnabled(true);
        this.f14176g.setEnabled(true);
        this.f14191v.setVisibility(8);
        this.f14192w.stop();
        this.f14189t = false;
        this.f14190u = false;
        if (this.f14163D.readGroupItemCount(this.f14168I) <= 0) {
            NToast.m9444c(getActivity(), (int) R.string.datastream_record_rec_short_fail);
            File file = new File(PathUtils.m4843m() + this.f14165F);
            if (file.exists()) {
                file.delete();
            }
        } else {
            this.f14163D.writeEndCloseFile(this.f14168I, this.f14162C, this.f14167H, this.f14164E, this.f14165F);
            m6159b();
        }
        this.f14163D = null;
    }

    /* renamed from: b */
    private void m6159b() {
        this.f14193x = new DialogC2480df(this, this.mContext, getString(R.string.input_ds_record_file_name), this.f14166G);
        InputDialog inputDialog = this.f14193x;
        getString(R.string.input_ds_record_file_name);
        inputDialog.m4704b();
    }

    /* renamed from: a */
    public static boolean m6160a(String str) {
        String[] strArr = {"\\", "/", ":", "*", "?", "\"", "<", ">", "|"};
        for (int i = 0; i < 9; i++) {
            if (str.indexOf(strArr[i]) != -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 20013) {
            return Integer.valueOf(PrintDataUtils.m4934a(this.mContext, this.f14169J, null));
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 20013) {
            LoadDialog.m4681b(this.mContext);
            Integer num = (Integer) obj;
            NetPOSPrinterUtil.m9439a(this.mContext, num.intValue());
            if (num.intValue() == 4095) {
                if (PreferencesManager.m9595a(this.mContext.getApplicationContext()).m9583b(C1947h.f10555g, false)) {
                    new PrinterFailrueDialog(this.mContext).show();
                    return;
                } else {
                    NToast.m9447b(this.mContext, (int) R.string.print_connect_printer);
                    return;
                }
            }
            return;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 20013) {
            LoadDialog.m4681b(this.mContext);
            NToast.m9450a(this.mContext, (int) R.string.print_error_fail);
            return;
        }
        super.onFailure(i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m6154f(VehicleVoltageFragment vehicleVoltageFragment) {
        DownloadBinUpdate downloadBinUpdate = vehicleVoltageFragment.f14180k;
        if (downloadBinUpdate.f9808d == null) {
            downloadBinUpdate.f9808d = new DownloadBinUpdate.RunnableC1831b();
        }
        new Thread(downloadBinUpdate.f9808d).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6166a(VehicleVoltageFragment vehicleVoltageFragment, double d) {
        VoltageDataStreamGraph voltageDataStreamGraph = vehicleVoltageFragment.f14188s;
        voltageDataStreamGraph.f14019a.setVisibility(0);
        voltageDataStreamGraph.f14022d.m9673a();
        vehicleVoltageFragment.f14181l.setVisibility(0);
        VoltageDataStreamGraph voltageDataStreamGraph2 = vehicleVoltageFragment.f14188s;
        XYSeries xYSeries = voltageDataStreamGraph2.f14021c;
        int i = voltageDataStreamGraph2.f14023e;
        voltageDataStreamGraph2.f14023e = i + 1;
        xYSeries.add(i, d);
        if (voltageDataStreamGraph2.f14023e > VoltageDataStreamGraph.f14018f) {
            voltageDataStreamGraph2.f14021c.remove(0);
        }
        voltageDataStreamGraph2.m6255a(voltageDataStreamGraph2.f14020b);
        voltageDataStreamGraph2.f14022d.m9673a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6163a(VehicleVoltageFragment vehicleVoltageFragment, ArrayList arrayList) {
        vehicleVoltageFragment.f14189t = false;
        if (vehicleVoltageFragment.f14163D.writeTag(vehicleVoltageFragment.f14167H, 4) && vehicleVoltageFragment.f14163D.writeDsBasics(vehicleVoltageFragment.f14168I, arrayList)) {
            return;
        }
        NToast.m9444c(vehicleVoltageFragment.getActivity(), (int) R.string.datastream_record_write_basicinfo_err);
        vehicleVoltageFragment.m6168a();
    }
}
