package com.cnlaunch.x431pro.module.p275l;

import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.wifiprinter.FragmentC1934u;
import com.cnlaunch.wifiprinter.MainActivity;
import com.cnlaunch.wifiprinter.PrintTest;
import com.cnlaunch.wifiprinter.PrinterLinkLocalNet;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.module.l.a */
/* loaded from: classes.dex */
public class StartWifiPrinterSet extends BaseFragment {

    /* renamed from: a */
    protected FragmentManager f15628a;

    /* renamed from: b */
    private PreferencesManager f15629b;

    /* renamed from: c */
    private MainActivity f15630c;

    /* renamed from: d */
    private PrinterLinkLocalNet f15631d;

    /* renamed from: e */
    private PrintTest f15632e;

    /* renamed from: f */
    private FragmentC1934u f15633f;

    /* renamed from: g */
    private C2734a f15634g;

    /* renamed from: h */
    private int f15635h = 1;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.connetwifiprinter);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f15634g = new C2734a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("WifiprinterStep");
        intentFilter.addAction("WifiprinterIP");
        getActivity().registerReceiver(this.f15634g, intentFilter);
        this.f15628a = getActivity().getFragmentManager();
        this.f15629b = PreferencesManager.m9595a(this.mContext);
        setRetainInstance(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m5245a() {
        int m9585b = PreferencesManager.m9595a(this.mContext).m9585b("theme_type", -1);
        return m9585b == -1 ? PreferencesManager.m9595a(this.mContext).m9585b("theme_type", 0) : m9585b;
    }

    @Override // android.app.Fragment
    public void onStart() {
        NLog.m9452b("EE", "type:".concat(String.valueOf(m5245a())));
        int i = this.f15635h;
        Intent intent = new Intent();
        intent.setAction("WifiprinterStep");
        intent.putExtra("step", i);
        getActivity().sendBroadcast(intent);
        super.onStart();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.wifi_printer_set_start, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(this.f15634g);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* compiled from: StartWifiPrinterSet.java */
    /* renamed from: com.cnlaunch.x431pro.module.l.a$a */
    /* loaded from: classes.dex */
    public class C2734a extends BroadcastReceiver {
        public C2734a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("WifiprinterStep")) {
                switch (intent.getIntExtra("step", 1)) {
                    case 1:
                        int m5245a = StartWifiPrinterSet.this.m5245a();
                        Bundle bundle = new Bundle();
                        bundle.putInt("PRINTER_THEME", m5245a);
                        StartWifiPrinterSet.this.f15630c = new MainActivity();
                        StartWifiPrinterSet.this.f15630c.setArguments(bundle);
                        try {
                            StartWifiPrinterSet.this.getFragmentManager().beginTransaction().replace(R.id.wifi_printer_container, StartWifiPrinterSet.this.f15630c).commit();
                            StartWifiPrinterSet.this.setTitle(R.string.connetwifiprinter);
                            StartWifiPrinterSet.this.f15632e = null;
                            StartWifiPrinterSet.this.f15635h = 1;
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    case 2:
                        StartWifiPrinterSet.this.f15631d = new PrinterLinkLocalNet();
                        try {
                            StartWifiPrinterSet.this.getFragmentManager().beginTransaction().replace(R.id.wifi_printer_container, StartWifiPrinterSet.this.f15631d).commit();
                            StartWifiPrinterSet.this.setTitle(R.string.PrinterConnetLocalNet);
                            StartWifiPrinterSet.this.f15630c = null;
                            StartWifiPrinterSet.this.f15635h = 2;
                            break;
                        } catch (Exception unused2) {
                            break;
                        }
                    case 3:
                        StartWifiPrinterSet.this.f15632e = new PrintTest();
                        try {
                            StartWifiPrinterSet.this.getFragmentManager().beginTransaction().replace(R.id.wifi_printer_container, StartWifiPrinterSet.this.f15632e).commit();
                            StartWifiPrinterSet.this.setTitle(R.string.PrintTextTitle);
                            StartWifiPrinterSet.this.f15631d = null;
                            StartWifiPrinterSet.this.f15633f = null;
                            StartWifiPrinterSet.this.f15635h = 3;
                            break;
                        } catch (Exception unused3) {
                            break;
                        }
                    case 4:
                        StartWifiPrinterSet.this.f15633f = new FragmentC1934u();
                        try {
                            StartWifiPrinterSet.this.getFragmentManager().beginTransaction().replace(R.id.wifi_printer_container, StartWifiPrinterSet.this.f15633f).commit();
                            StartWifiPrinterSet.this.setTitle(R.string.ConnetLocalNet);
                            StartWifiPrinterSet.this.f15635h = 4;
                            StartWifiPrinterSet.this.f15632e = null;
                            break;
                        } catch (Exception unused4) {
                            break;
                        }
                }
            }
            if (action.equals("WifiprinterIP")) {
                StartWifiPrinterSet.this.f15629b.m9588a(C1947h.f10554f, intent.getStringExtra("strIP"));
            }
        }
    }
}
