package com.cnlaunch.wifiprinter;

import android.app.Dialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.WifiConnect;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.u */
/* loaded from: classes.dex */
public final class FragmentC1934u extends Fragment {

    /* renamed from: k */
    static TextView f10505k;

    /* renamed from: B */
    private WifiManager f10507B;

    /* renamed from: a */
    Button f10508a;

    /* renamed from: b */
    CheckBox f10509b;

    /* renamed from: c */
    Button f10510c;

    /* renamed from: h */
    LinearLayout f10515h;

    /* renamed from: i */
    RelativeLayout f10516i;

    /* renamed from: j */
    String f10517j;

    /* renamed from: l */
    Dialog f10518l;

    /* renamed from: m */
    Context f10519m;

    /* renamed from: o */
    ListView f10521o;

    /* renamed from: p */
    Button f10522p;

    /* renamed from: s */
    String f10525s;

    /* renamed from: w */
    private PrinterWifiInfo f10529w;

    /* renamed from: y */
    private String[] f10531y;

    /* renamed from: z */
    private ArrayAdapter<String> f10532z;

    /* renamed from: d */
    EditText f10511d = null;

    /* renamed from: e */
    Spinner f10512e = null;

    /* renamed from: f */
    EditText f10513f = null;

    /* renamed from: g */
    TextView f10514g = null;

    /* renamed from: n */
    WifiPrinterAdapter f10520n = null;

    /* renamed from: x */
    private List<PrinterWifiInfo> f10530x = new ArrayList();

    /* renamed from: A */
    private boolean f10506A = false;

    /* renamed from: q */
    boolean f10523q = true;

    /* renamed from: r */
    boolean f10524r = false;

    /* renamed from: t */
    String f10526t = Constant.f10347b;

    /* renamed from: u */
    Handler f10527u = new HandlerC1938v(this);

    /* renamed from: v */
    BroadcastReceiver f10528v = new C1940x(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m7980e(FragmentC1934u fragmentC1934u) {
        fragmentC1934u.f10506A = true;
        return true;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(Constant.f10351f).inflate(C1900at.C1906f.activity_print_test_two, viewGroup, false);
        this.f10519m = getActivity();
        this.f10508a = (Button) inflate.findViewById(C1900at.C1905e.butscan);
        this.f10509b = (CheckBox) inflate.findViewById(C1900at.C1905e.isshowpwd);
        this.f10510c = (Button) inflate.findViewById(C1900at.C1905e.btnConnet);
        this.f10508a.setOnClickListener(new View$OnClickListenerC1935a());
        this.f10510c.setOnClickListener(new View$OnClickListenerC1935a());
        this.f10516i = (RelativeLayout) inflate.findViewById(C1900at.C1905e.linepassword);
        this.f10516i.setVisibility(8);
        this.f10515h = (LinearLayout) inflate.findViewById(C1900at.C1905e.linestyle);
        this.f10515h.setVisibility(8);
        this.f10511d = (EditText) inflate.findViewById(C1900at.C1905e.pt2ssid);
        this.f10513f = (EditText) inflate.findViewById(C1900at.C1905e.pwd);
        this.f10514g = (TextView) inflate.findViewById(C1900at.C1905e.show);
        this.f10514g.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f10513f.setImeOptions(6);
        this.f10514g.setTextColor(this.f10519m.getResources().getColor(C1900at.C1902b.black));
        this.f10513f.setOnEditorActionListener(new C1941y(this));
        this.f10507B = (WifiManager) this.f10519m.getSystemService("wifi");
        if (!this.f10507B.isWifiEnabled()) {
            this.f10507B.setWifiEnabled(true);
        }
        WifiInfo connectionInfo = this.f10507B.getConnectionInfo();
        if (connectionInfo != null && connectionInfo.getSSID() != null) {
            String ssid = connectionInfo.getSSID();
            if (ssid.indexOf("\"") == 0) {
                ssid = ssid.substring(1, ssid.length() - 1);
            }
            this.f10517j = ssid;
            this.f10511d.setText(this.f10517j);
        }
        this.f10512e = (Spinner) inflate.findViewById(C1900at.C1905e.wps);
        this.f10531y = this.f10519m.getResources().getStringArray(C1900at.C1901a.key_labels);
        this.f10532z = new TestArrayAdapter(this.f10519m, this.f10531y);
        this.f10512e.setAdapter((SpinnerAdapter) this.f10532z);
        this.f10512e.setOnItemSelectedListener(new C1936b(this, (byte) 0));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Search_WIFI");
        this.f10519m.registerReceiver(this.f10528v, intentFilter);
        this.f10513f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.f10513f.postInvalidate();
        this.f10509b.setOnCheckedChangeListener(new C1942z(this));
        return inflate;
    }

    /* compiled from: PrintTestTwo.java */
    /* renamed from: com.cnlaunch.wifiprinter.u$b */
    /* loaded from: classes.dex */
    class C1936b implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        private C1936b() {
        }

        /* synthetic */ C1936b(FragmentC1934u fragmentC1934u, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (!FragmentC1934u.this.f10531y[i].equals("NONE") || !FragmentC1934u.this.f10506A) {
                if (FragmentC1934u.this.f10506A) {
                    FragmentC1934u.this.f10510c.setEnabled(true);
                    FragmentC1934u.this.f10510c.setTextColor(FragmentC1934u.this.f10519m.getResources().getColor(C1900at.C1902b.white));
                    FragmentC1934u.this.f10514g.setTextColor(FragmentC1934u.this.f10519m.getResources().getColor(C1900at.C1902b.red));
                    FragmentC1934u.this.f10514g.setText("");
                    return;
                }
                return;
            }
            FragmentC1934u.this.f10510c.setEnabled(false);
            FragmentC1934u.this.f10510c.setTextColor(FragmentC1934u.this.f10519m.getResources().getColor(C1900at.C1902b.hui));
            FragmentC1934u.this.f10514g.setTextColor(FragmentC1934u.this.f10519m.getResources().getColor(C1900at.C1902b.red));
            FragmentC1934u.this.f10514g.setText(FragmentC1934u.this.f10519m.getResources().getString(C1900at.C1907g.Notsurpost));
        }
    }

    /* compiled from: PrintTestTwo.java */
    /* renamed from: com.cnlaunch.wifiprinter.u$a */
    /* loaded from: classes.dex */
    class View$OnClickListenerC1935a implements View.OnClickListener {
        View$OnClickListenerC1935a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == FragmentC1934u.this.f10508a) {
                FragmentC1934u fragmentC1934u = FragmentC1934u.this;
                fragmentC1934u.f10518l = new MyWifiDialog(fragmentC1934u.f10519m, C1900at.C1908h.MyDialog);
                FragmentC1934u.this.f10518l.setContentView(FragmentC1934u.m7982c(FragmentC1934u.this));
                FragmentC1934u.this.f10518l.show();
                FragmentC1934u.this.f10518l.setCanceledOnTouchOutside(false);
            } else if (view == FragmentC1934u.this.f10510c) {
                FragmentC1934u.this.f10514g.setTextColor(FragmentC1934u.this.f10519m.getResources().getColor(C1900at.C1902b.black));
                FragmentC1934u.this.f10514g.setText("");
                FragmentC1934u fragmentC1934u2 = FragmentC1934u.this;
                if (fragmentC1934u2.getActivity().getCurrentFocus() != null) {
                    ((InputMethodManager) fragmentC1934u2.f10519m.getSystemService("input_method")).hideSoftInputFromWindow(fragmentC1934u2.getActivity().getCurrentFocus().getWindowToken(), 2);
                }
                if (FragmentC1934u.this.f10524r) {
                    FragmentC1934u.this.m7986a();
                } else if (Constant.f10349d) {
                } else {
                    Intent intent = new Intent();
                    intent.setAction("WifiprinterStep");
                    intent.putExtra("step", 3);
                    FragmentC1934u.this.f10519m.sendBroadcast(intent);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m7986a() {
        String trim = this.f10511d.getText().toString().trim();
        String replace = this.f10512e.getSelectedItem().toString().trim().replace("/", "");
        String trim2 = this.f10513f.getText().toString().trim();
        this.f10525s = trim;
        if (trim == null || trim.equals("")) {
            Context context = this.f10519m;
            Constant.m8033a(context, context.getResources().getString(C1900at.C1907g.SelectSSID));
        } else if (trim2 == null || trim2.equals("")) {
            Context context2 = this.f10519m;
            Constant.m8033a(context2, context2.getResources().getString(C1900at.C1907g.InputPWD));
        } else if (trim.indexOf("X-431PRINTER-") != -1) {
            String string = this.f10519m.getResources().getString(C1900at.C1907g.SelectLocalSSID);
            this.f10514g.setTextColor(this.f10519m.getResources().getColor(C1900at.C1902b.red));
            this.f10514g.setText(string);
        } else {
            this.f10508a.setEnabled(false);
            this.f10510c.setEnabled(false);
            this.f10510c.setTextColor(this.f10519m.getResources().getColor(C1900at.C1902b.hui));
            WifiConnect wifiConnect = new WifiConnect(this.f10507B);
            if (replace.indexOf("WPA") != -1) {
                wifiConnect.m8020a(this.f10525s, trim2, WifiConnect.EnumC1910b.WIFICIPHER_WPA);
            } else if (replace.indexOf("WEP") != -1) {
                wifiConnect.m8020a(this.f10525s, trim2, WifiConnect.EnumC1910b.WIFICIPHER_WEP);
            } else if (replace.indexOf("NONE") != -1) {
                wifiConnect.m8020a(this.f10525s, trim2, WifiConnect.EnumC1910b.WIFICIPHER_NOPASS);
            }
            new Timer().schedule(new PrintTestTwo(this), 1500L);
            this.f10514g.setText(this.f10519m.getResources().getString(C1900at.C1907g.conneting));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7984b() {
        this.f10507B.startScan();
        List<ScanResult> scanResults = this.f10507B.getScanResults();
        this.f10530x.clear();
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : scanResults) {
            if (scanResult.SSID.indexOf("X-431PRINTER-") == -1 && !scanResult.SSID.isEmpty() && !arrayList.contains(scanResult.SSID)) {
                arrayList.add(scanResult.SSID);
                this.f10529w = new PrinterWifiInfo();
                PrinterWifiInfo printerWifiInfo = this.f10529w;
                printerWifiInfo.f10405a = "   " + scanResult.SSID;
                this.f10529w.f10406b = scanResult.capabilities;
                this.f10530x.add(this.f10529w);
            }
        }
    }

    /* compiled from: PrintTestTwo.java */
    /* renamed from: com.cnlaunch.wifiprinter.u$c */
    /* loaded from: classes.dex */
    public class C1937c extends Thread {

        /* renamed from: a */
        Context f10535a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1937c(Context context) {
            this.f10535a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            FragmentC1934u.this.f10530x.clear();
            FragmentC1934u.this.f10507B.startScan();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FragmentC1934u.this.m7984b();
            this.f10535a.sendBroadcast(new Intent("Search_WIFI"));
            new Thread(new RunnableC1883ae(this)).start();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        this.f10519m.unregisterReceiver(this.f10528v);
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        String ssid = ((WifiManager) this.f10519m.getSystemService("wifi")).getConnectionInfo().getSSID();
        if (ssid.indexOf("\"") == 0) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        if (ssid.equalsIgnoreCase(this.f10525s)) {
            this.f10527u.sendEmptyMessage(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
        }
        super.onResume();
    }

    /* renamed from: c */
    static /* synthetic */ View m7982c(FragmentC1934u fragmentC1934u) {
        View inflate = LayoutInflater.from(Constant.f10351f).inflate(C1900at.C1906f.activity_dialog, (ViewGroup) null, false);
        fragmentC1934u.f10521o = (ListView) inflate.findViewById(C1900at.C1905e.list);
        ((TextView) inflate.findViewById(C1900at.C1905e.tvTitle)).setText(fragmentC1934u.f10519m.getResources().getString(C1900at.C1907g.ConnetLocalNet));
        TextView textView = (TextView) inflate.findViewById(C1900at.C1905e.tvShowinfo);
        f10505k = textView;
        textView.setVisibility(8);
        f10505k.setText(fragmentC1934u.f10519m.getResources().getString(C1900at.C1907g.refreshwifilist));
        fragmentC1934u.m7984b();
        fragmentC1934u.f10520n = new WifiPrinterAdapter(fragmentC1934u.f10530x, fragmentC1934u.f10519m);
        fragmentC1934u.f10521o.setAdapter((ListAdapter) fragmentC1934u.f10520n);
        fragmentC1934u.f10521o.setOnItemClickListener(new C1880ab(fragmentC1934u));
        fragmentC1934u.f10522p = (Button) inflate.findViewById(C1900at.C1905e.btnrefresh);
        fragmentC1934u.f10522p.setOnClickListener(new View$OnClickListenerC1881ac(fragmentC1934u));
        return inflate;
    }
}
