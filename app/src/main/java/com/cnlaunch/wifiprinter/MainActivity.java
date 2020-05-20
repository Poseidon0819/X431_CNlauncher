package com.cnlaunch.wifiprinter;

import android.app.Dialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.WifiConnect;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.wifiprinter.c */
/* loaded from: classes.dex */
public final class MainActivity extends Fragment {

    /* renamed from: e */
    static TextView f10423e;

    /* renamed from: f */
    static TextView f10424f;

    /* renamed from: g */
    static TextView f10425g;

    /* renamed from: a */
    Button f10426a;

    /* renamed from: b */
    Button f10427b;

    /* renamed from: c */
    Button f10428c;

    /* renamed from: d */
    String f10429d;

    /* renamed from: h */
    String f10430h;

    /* renamed from: i */
    Dialog f10431i;

    /* renamed from: j */
    Context f10432j;

    /* renamed from: l */
    ListView f10434l;

    /* renamed from: m */
    Button f10435m;

    /* renamed from: p */
    IntentFilter f10438p;

    /* renamed from: r */
    private WifiManager f10440r;

    /* renamed from: s */
    private PrinterWifiInfo f10441s;

    /* renamed from: v */
    private int f10444v;

    /* renamed from: q */
    private boolean f10439q = false;

    /* renamed from: k */
    WifiPrinterAdapter f10433k = null;

    /* renamed from: t */
    private List<PrinterWifiInfo> f10442t = new ArrayList();

    /* renamed from: u */
    private boolean f10443u = false;

    /* renamed from: n */
    Handler f10436n = new HandlerC1916d(this);

    /* renamed from: w */
    private WifiConnect.InterfaceC1911c f10445w = new C1918f(this);

    /* renamed from: o */
    BroadcastReceiver f10437o = new C1919g(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m8010e(MainActivity mainActivity) {
        mainActivity.f10443u = true;
        return true;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ContextThemeWrapper contextThemeWrapper;
        if (getArguments().containsKey("PRINTER_THEME")) {
            Constant.f10350e = getArguments().getInt("PRINTER_THEME");
        }
        switch (Constant.f10350e) {
            case 0:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Red);
                break;
            case 1:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Blue);
                break;
            case 2:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_BlueViolet);
                break;
            case 3:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Green);
                break;
            case 4:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Classic_Blue);
                break;
            case 5:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_HeavyDuty);
                break;
            case 6:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_ProMini);
                break;
            case 7:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Auscan);
                break;
            default:
                contextThemeWrapper = new ContextThemeWrapper(getActivity(), C1900at.C1908h.Printer_Red);
                break;
        }
        Constant.f10351f = contextThemeWrapper;
        View inflate = layoutInflater.cloneInContext(Constant.f10351f).inflate(C1900at.C1906f.printer_fragement_start, viewGroup, false);
        this.f10426a = (Button) inflate.findViewById(C1900at.C1905e.butscan);
        this.f10427b = (Button) inflate.findViewById(C1900at.C1905e.btnConnet);
        this.f10428c = (Button) inflate.findViewById(C1900at.C1905e.btnhelp);
        f10423e = (TextView) inflate.findViewById(C1900at.C1905e.ssid);
        f10424f = (TextView) inflate.findViewById(C1900at.C1905e.show);
        return inflate;
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        this.f10432j = getActivity();
        this.f10426a.setOnClickListener(new View$OnClickListenerC1914a());
        this.f10427b.setOnClickListener(new View$OnClickListenerC1914a());
        this.f10428c.setOnClickListener(new View$OnClickListenerC1914a());
        f10424f.setMovementMethod(ScrollingMovementMethod.getInstance());
        f10424f.setText("");
        f10424f.setTextColor(this.f10432j.getResources().getColor(C1900at.C1902b.black));
        this.f10438p = new IntentFilter();
        this.f10438p.addAction("Search_result");
        this.f10438p.addAction("android.net.wifi.RSSI_CHANGED");
        getActivity().registerReceiver(this.f10437o, this.f10438p);
        this.f10440r = (WifiManager) getActivity().getSystemService("wifi");
        if (!this.f10440r.isWifiEnabled()) {
            this.f10440r.setWifiEnabled(true);
        }
        this.f10440r.startScan();
        super.onStart();
    }

    /* compiled from: MainActivity.java */
    /* renamed from: com.cnlaunch.wifiprinter.c$a */
    /* loaded from: classes.dex */
    class View$OnClickListenerC1914a implements View.OnClickListener {
        View$OnClickListenerC1914a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == MainActivity.this.f10426a) {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.f10431i = new MyWifiDialog(mainActivity.f10432j, C1900at.C1908h.MyDialog);
                MainActivity.this.f10431i.setContentView(MainActivity.this.m8018a());
                MainActivity.this.f10431i.show();
                MainActivity.this.f10431i.setCanceledOnTouchOutside(false);
            } else if (view == MainActivity.this.f10427b) {
                MainActivity.this.f10430h = MainActivity.f10423e.getText().toString();
                if (MainActivity.this.f10430h == null || MainActivity.this.f10430h.equals("")) {
                    Constant.m8033a(MainActivity.this.f10432j, MainActivity.this.f10432j.getResources().getString(C1900at.C1907g.SelectSSID));
                    return;
                }
                WifiConnect wifiConnect = new WifiConnect(MainActivity.this.f10440r);
                String str = MainActivity.this.f10429d;
                Log.i("XEE", "type:".concat(String.valueOf(str)));
                if (TextUtils.isEmpty(str)) {
                    str = "WPA/WPA2_AES";
                }
                MainActivity.this.f10426a.setEnabled(false);
                MainActivity.this.f10427b.setEnabled(false);
                MainActivity.this.f10427b.setTextColor(MainActivity.this.f10432j.getResources().getColor(C1900at.C1902b.hui));
                if (str.indexOf("WPA") != -1) {
                    wifiConnect.m8019a(MainActivity.this.f10430h, "12345678", WifiConnect.EnumC1910b.WIFICIPHER_WPA, MainActivity.this.f10445w);
                } else if (str.indexOf("WEP") != -1) {
                    wifiConnect.m8019a(MainActivity.this.f10430h, "12345678", WifiConnect.EnumC1910b.WIFICIPHER_WEP, MainActivity.this.f10445w);
                } else {
                    wifiConnect.m8019a(MainActivity.this.f10430h, "12345678", WifiConnect.EnumC1910b.WIFICIPHER_NOPASS, MainActivity.this.f10445w);
                }
                MainActivity.this.f10444v = 0;
                MainActivity.f10424f.setTextColor(MainActivity.this.f10432j.getResources().getColor(C1900at.C1902b.black));
                MainActivity.f10424f.setText(MainActivity.this.f10432j.getResources().getString(C1900at.C1907g.conneting));
                new C1922j(this).start();
            } else if (view == MainActivity.this.f10428c) {
                Bundle bundle = new Bundle();
                bundle.putInt("PAGE", 1);
                HelpActivity helpActivity = new HelpActivity();
                helpActivity.setStyle(1, 0);
                helpActivity.setArguments(bundle);
                helpActivity.show(MainActivity.this.getFragmentManager(), HelpActivity.class.getName());
            }
        }
    }

    /* compiled from: MainActivity.java */
    /* renamed from: com.cnlaunch.wifiprinter.c$b */
    /* loaded from: classes.dex */
    public class C1915b extends Thread {

        /* renamed from: a */
        Context f10447a;

        /* renamed from: b */
        long f10448b = System.currentTimeMillis() + 20000;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1915b(Context context) {
            this.f10447a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            MainActivity.this.f10442t.clear();
            MainActivity.this.f10440r.startScan();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!MainActivity.this.f10440r.isWifiEnabled()) {
                MainActivity.this.f10442t.clear();
                this.f10447a.sendBroadcast(new Intent("Search_result"));
            } else {
                for (ScanResult scanResult : MainActivity.this.f10440r.getScanResults()) {
                    if (scanResult.SSID.indexOf("X-431PRINTER-") != -1 && scanResult.SSID.length() >= 17) {
                        MainActivity.this.f10441s = new PrinterWifiInfo();
                        PrinterWifiInfo printerWifiInfo = MainActivity.this.f10441s;
                        printerWifiInfo.f10405a = "   " + scanResult.SSID;
                        MainActivity.this.f10441s.f10406b = scanResult.capabilities;
                        MainActivity.this.f10442t.add(MainActivity.this.f10441s);
                        MainActivity.this.f10439q = true;
                    }
                }
                if (MainActivity.this.f10442t.size() == 0) {
                    try {
                        Thread.sleep(8000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    MainActivity.this.f10439q = false;
                    MainActivity.this.f10441s = new PrinterWifiInfo();
                    MainActivity.this.f10441s.f10405a = this.f10447a.getResources().getString(C1900at.C1907g.findptHotFail);
                    MainActivity.this.f10441s.f10406b = "";
                    MainActivity.this.f10442t.add(MainActivity.this.f10441s);
                    MainActivity.this.f10436n.sendEmptyMessage(TIFFConstants.TIFFTAG_GRAYRESPONSEUNIT);
                }
                this.f10447a.sendBroadcast(new Intent("Search_result"));
            }
            new Thread(new RunnableC1923k(this)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public View m8018a() {
        if (!this.f10440r.isWifiEnabled()) {
            this.f10440r.setWifiEnabled(true);
        }
        if (!this.f10440r.isWifiEnabled()) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        View inflate = LayoutInflater.from(Constant.f10351f).inflate(C1900at.C1906f.activity_dialog, (ViewGroup) null, false);
        this.f10434l = (ListView) inflate.findViewById(C1900at.C1905e.list);
        TextView textView = (TextView) inflate.findViewById(C1900at.C1905e.tvShowinfo);
        f10425g = textView;
        textView.setVisibility(8);
        List<ScanResult> scanResults = this.f10440r.getScanResults();
        this.f10442t.clear();
        this.f10440r.startScan();
        for (ScanResult scanResult : scanResults) {
            if (scanResult.SSID.indexOf("X-431PRINTER-") != -1 && scanResult.SSID.length() >= 17) {
                this.f10441s = new PrinterWifiInfo();
                PrinterWifiInfo printerWifiInfo = this.f10441s;
                printerWifiInfo.f10405a = "   " + scanResult.SSID;
                this.f10441s.f10406b = scanResult.capabilities;
                this.f10442t.add(this.f10441s);
                this.f10439q = true;
            }
        }
        this.f10433k = new WifiPrinterAdapter(this.f10442t, this.f10432j);
        this.f10434l.setAdapter((ListAdapter) this.f10433k);
        this.f10434l.setOnItemClickListener(new C1920h(this));
        this.f10435m = (Button) inflate.findViewById(C1900at.C1905e.btnrefresh);
        this.f10435m.setOnClickListener(new View$OnClickListenerC1921i(this));
        return inflate;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        Dialog dialog = this.f10431i;
        if (dialog != null && dialog.isShowing()) {
            this.f10431i.dismiss();
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        String ssid = ((WifiManager) this.f10432j.getSystemService("wifi")).getConnectionInfo().getSSID();
        if (TextUtils.isEmpty(ssid)) {
            ssid = "";
        }
        if (ssid.indexOf("\"") == 0) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        if (ssid.equalsIgnoreCase(this.f10430h) && this.f10443u) {
            this.f10436n.sendEmptyMessage(TIFFConstants.TIFFTAG_GROUP3OPTIONS);
        }
        super.onResume();
    }
}
