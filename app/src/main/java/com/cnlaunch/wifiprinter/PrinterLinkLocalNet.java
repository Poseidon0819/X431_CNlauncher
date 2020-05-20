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
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* renamed from: com.cnlaunch.wifiprinter.ag */
/* loaded from: classes.dex */
public final class PrinterLinkLocalNet extends Fragment {

    /* renamed from: i */
    static TextView f10359i;

    /* renamed from: A */
    private WifiManager f10360A;

    /* renamed from: a */
    Button f10361a;

    /* renamed from: b */
    CheckBox f10362b;

    /* renamed from: c */
    Button f10363c;

    /* renamed from: d */
    Button f10364d;

    /* renamed from: j */
    Dialog f10369j;

    /* renamed from: k */
    Context f10370k;

    /* renamed from: m */
    ListView f10372m;

    /* renamed from: n */
    Button f10373n;

    /* renamed from: q */
    String f10376q;

    /* renamed from: u */
    private PrinterWifiInfo f10380u;

    /* renamed from: w */
    private String[] f10382w;

    /* renamed from: x */
    private ArrayAdapter<String> f10383x;

    /* renamed from: e */
    EditText f10365e = null;

    /* renamed from: f */
    Spinner f10366f = null;

    /* renamed from: g */
    EditText f10367g = null;

    /* renamed from: h */
    TextView f10368h = null;

    /* renamed from: l */
    WifiPrinterAdapter f10371l = null;

    /* renamed from: v */
    private List<PrinterWifiInfo> f10381v = new ArrayList();

    /* renamed from: y */
    private String f10384y = Environment.getExternalStorageDirectory().getPath() + "/sendtxt.txt";

    /* renamed from: z */
    private boolean f10385z = false;

    /* renamed from: o */
    boolean f10374o = true;

    /* renamed from: p */
    boolean f10375p = false;

    /* renamed from: r */
    String f10377r = Constant.f10347b;

    /* renamed from: s */
    Handler f10378s = new HandlerC1889ah(this);

    /* renamed from: t */
    BroadcastReceiver f10379t = new C1892ak(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ boolean m8025e(PrinterLinkLocalNet printerLinkLocalNet) {
        printerLinkLocalNet.f10385z = true;
        return true;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (isAdded()) {
            View inflate = layoutInflater.cloneInContext(Constant.f10351f).inflate(C1900at.C1906f.activity_printer_link_local_net, viewGroup, false);
            this.f10370k = getActivity();
            Context context = this.f10370k;
            if (MySharedPreferences.f10460a == null) {
                MySharedPreferences.m8004a(context);
            }
            MySharedPreferences.f10460a.edit().putString("DEVICE_ID", null).commit();
            this.f10361a = (Button) inflate.findViewById(C1900at.C1905e.butscan);
            this.f10362b = (CheckBox) inflate.findViewById(C1900at.C1905e.isshowpwd);
            this.f10363c = (Button) inflate.findViewById(C1900at.C1905e.btnConnet);
            this.f10364d = (Button) inflate.findViewById(C1900at.C1905e.btnhelp);
            this.f10361a.setOnClickListener(new View$OnClickListenerC1885a());
            this.f10363c.setOnClickListener(new View$OnClickListenerC1885a());
            this.f10364d.setOnClickListener(new View$OnClickListenerC1885a());
            this.f10365e = (EditText) inflate.findViewById(C1900at.C1905e.ssid);
            this.f10367g = (EditText) inflate.findViewById(C1900at.C1905e.pwd);
            this.f10368h = (TextView) inflate.findViewById(C1900at.C1905e.show);
            this.f10368h.setMovementMethod(ScrollingMovementMethod.getInstance());
            this.f10367g.setImeOptions(6);
            this.f10367g.setOnEditorActionListener(new C1893al(this));
            this.f10366f = (Spinner) inflate.findViewById(C1900at.C1905e.wps);
            this.f10382w = this.f10370k.getResources().getStringArray(C1900at.C1901a.key_labels);
            this.f10383x = new TestArrayAdapter(this.f10370k, this.f10382w);
            this.f10366f.setAdapter((SpinnerAdapter) this.f10383x);
            this.f10366f.setOnItemSelectedListener(new C1886b(this, (byte) 0));
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("Search_WIFI");
            this.f10370k.registerReceiver(this.f10379t, intentFilter);
            this.f10360A = (WifiManager) this.f10370k.getSystemService("wifi");
            if (!this.f10360A.isWifiEnabled()) {
                this.f10360A.setWifiEnabled(true);
            }
            this.f10367g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.f10367g.postInvalidate();
            this.f10362b.setOnCheckedChangeListener(new C1894am(this));
            return inflate;
        }
        return null;
    }

    /* compiled from: PrinterLinkLocalNet.java */
    /* renamed from: com.cnlaunch.wifiprinter.ag$b */
    /* loaded from: classes.dex */
    class C1886b implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        private C1886b() {
        }

        /* synthetic */ C1886b(PrinterLinkLocalNet printerLinkLocalNet, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (!PrinterLinkLocalNet.this.f10382w[i].equals("NONE") || !PrinterLinkLocalNet.this.f10385z) {
                if (PrinterLinkLocalNet.this.f10385z) {
                    PrinterLinkLocalNet.this.f10363c.setEnabled(true);
                    PrinterLinkLocalNet.this.f10363c.setTextColor(PrinterLinkLocalNet.this.f10370k.getResources().getColor(C1900at.C1902b.white));
                    PrinterLinkLocalNet.this.f10368h.setTextColor(PrinterLinkLocalNet.this.f10370k.getResources().getColor(C1900at.C1902b.red));
                    PrinterLinkLocalNet.this.f10368h.setText("");
                    return;
                }
                return;
            }
            PrinterLinkLocalNet.this.f10363c.setEnabled(false);
            PrinterLinkLocalNet.this.f10363c.setTextColor(PrinterLinkLocalNet.this.f10370k.getResources().getColor(C1900at.C1902b.hui));
            PrinterLinkLocalNet.this.f10368h.setTextColor(PrinterLinkLocalNet.this.f10370k.getResources().getColor(C1900at.C1902b.red));
            PrinterLinkLocalNet.this.f10368h.setText(PrinterLinkLocalNet.this.f10370k.getResources().getString(C1900at.C1907g.Notsurpost));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8029b() {
        this.f10360A.startScan();
        List<ScanResult> scanResults = this.f10360A.getScanResults();
        this.f10381v.clear();
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : scanResults) {
            if (scanResult.SSID.indexOf("X-431PRINTER-") == -1 && !scanResult.SSID.isEmpty() && !arrayList.contains(scanResult.SSID)) {
                arrayList.add(scanResult.SSID);
                this.f10380u = new PrinterWifiInfo();
                PrinterWifiInfo printerWifiInfo = this.f10380u;
                printerWifiInfo.f10405a = "   " + scanResult.SSID;
                this.f10380u.f10406b = scanResult.capabilities;
                this.f10381v.add(this.f10380u);
            }
        }
    }

    /* compiled from: PrinterLinkLocalNet.java */
    /* renamed from: com.cnlaunch.wifiprinter.ag$a */
    /* loaded from: classes.dex */
    class View$OnClickListenerC1885a implements View.OnClickListener {
        View$OnClickListenerC1885a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view == PrinterLinkLocalNet.this.f10361a) {
                PrinterLinkLocalNet printerLinkLocalNet = PrinterLinkLocalNet.this;
                printerLinkLocalNet.f10369j = new MyWifiDialog(printerLinkLocalNet.f10370k, C1900at.C1908h.MyDialog);
                PrinterLinkLocalNet.this.f10369j.setContentView(PrinterLinkLocalNet.m8026d(PrinterLinkLocalNet.this));
                PrinterLinkLocalNet.this.f10369j.show();
                PrinterLinkLocalNet.this.f10369j.setCanceledOnTouchOutside(false);
            } else if (view == PrinterLinkLocalNet.this.f10363c) {
                PrinterLinkLocalNet.this.f10368h.setTextColor(PrinterLinkLocalNet.this.f10370k.getResources().getColor(C1900at.C1902b.black));
                PrinterLinkLocalNet printerLinkLocalNet2 = PrinterLinkLocalNet.this;
                if (printerLinkLocalNet2.getActivity().getCurrentFocus() != null) {
                    ((InputMethodManager) printerLinkLocalNet2.f10370k.getSystemService("input_method")).hideSoftInputFromWindow(printerLinkLocalNet2.getActivity().getCurrentFocus().getWindowToken(), 2);
                }
                if (!PrinterLinkLocalNet.this.f10375p) {
                    try {
                        PrinterLinkLocalNet.this.m8032a();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Intent intent = new Intent();
                intent.setAction("WifiprinterStep");
                intent.putExtra("step", 1);
                PrinterLinkLocalNet.this.f10370k.sendBroadcast(intent);
            } else if (view == PrinterLinkLocalNet.this.f10364d) {
                Bundle bundle = new Bundle();
                bundle.putInt("PAGE", 2);
                HelpActivity helpActivity = new HelpActivity();
                helpActivity.setStyle(1, 0);
                helpActivity.setArguments(bundle);
                helpActivity.show(PrinterLinkLocalNet.this.getFragmentManager(), HelpActivity.class.getName());
            }
        }
    }

    /* renamed from: a */
    public final void m8032a() throws Exception {
        int i;
        String str;
        String str2 = "";
        String trim = this.f10365e.getText().toString().trim();
        String replace = this.f10366f.getSelectedItem().toString().trim().toLowerCase().replace("/", "");
        String trim2 = this.f10367g.getText().toString().trim();
        this.f10376q = trim;
        if (trim == null || trim.equals("")) {
            Context context = this.f10370k;
            Constant.m8033a(context, context.getResources().getString(C1900at.C1907g.SelectSSID));
        } else if (trim2 == null || trim2.equals("")) {
            Context context2 = this.f10370k;
            Constant.m8033a(context2, context2.getResources().getString(C1900at.C1907g.InputPWD));
        } else if (trim.indexOf("X-431PRINTER-") != -1) {
            String string = this.f10370k.getResources().getString(C1900at.C1907g.SelectLocalSSID2);
            this.f10368h.setTextColor(this.f10370k.getResources().getColor(C1900at.C1902b.red));
            this.f10368h.setText(string);
        } else {
            this.f10360A = (WifiManager) this.f10370k.getSystemService("wifi");
            String ssid = this.f10360A.getConnectionInfo().getSSID();
            if (ssid.indexOf("X-431PRINTER-") == -1) {
                this.f10368h.setText(((this.f10370k.getResources().getString(C1900at.C1907g.curConnet) + ssid) + HttpProxyConstants.CRLF) + this.f10370k.getResources().getString(C1900at.C1907g.SelectPrintSSID2));
                this.f10368h.setTextColor(this.f10370k.getResources().getColor(C1900at.C1902b.red));
                return;
            }
            this.f10361a.setEnabled(false);
            this.f10363c.setEnabled(false);
            this.f10363c.setTextColor(this.f10370k.getResources().getColor(C1900at.C1902b.hui));
            if (this.f10360A.getDhcpInfo().gateway != 0) {
                str2 = (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 248) & 255);
            }
            String str3 = "netmode=2&dhcpd=0&wifi_conf=" + trim + "," + replace + "," + trim2 + "&dhcpc=1&net_commit=1&reconn=1";
            String str4 = ("POST /goform/ser2netconfigAT HTTP/1.1\r\nHost: " + str2 + HttpProxyConstants.CRLF) + "Connection: keep-alive\r\n";
            if ("X-431PRINTER-".indexOf("HI-LINK") != -1) {
                str = str4 + "Authorization: Basic YWRtaW46YWRtaW4=\r\n";
            } else {
                str = str4 + "Authorization: Basic bGF1bmNoX3lpZHN1bjpsYXV5aWQyMDEzMDgxOA==\r\n";
            }
            new C1888d(str2, m8030a((str + "Content-Length: " + str3.length() + "\r\n\r\n") + str3 + "\r\n\r\n")).start();
            this.f10368h.setText(this.f10370k.getResources().getString(C1900at.C1907g.conneting));
        }
    }

    /* renamed from: a */
    private String m8030a(String str) {
        File file = new File(this.f10384y);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(this.f10384y);
            fileWriter.write(str);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeShort(2);
            dataOutputStream.writeUTF("");
            fileWriter.flush();
            fileWriter.close();
            dataOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return this.f10384y;
    }

    /* compiled from: PrinterLinkLocalNet.java */
    /* renamed from: com.cnlaunch.wifiprinter.ag$d */
    /* loaded from: classes.dex */
    public class C1888d extends Thread {

        /* renamed from: b */
        private String f10391b;

        /* renamed from: c */
        private String f10392c;

        public C1888d(String str, String str2) {
            this.f10391b = "";
            this.f10392c = "";
            this.f10391b = str;
            this.f10392c = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                Socket socket = new Socket(this.f10391b, 80);
                socket.setSoTimeout(10000);
                FileInputStream fileInputStream = new FileInputStream(this.f10392c);
                OutputStream outputStream = socket.getOutputStream();
                byte[] bArr = new byte[80];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                outputStream.flush();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String readLine = bufferedReader.readLine();
                Message message2 = new Message();
                message2.what = 294;
                message2.obj = readLine;
                PrinterLinkLocalNet.this.f10378s.sendMessage(message2);
                bufferedReader.close();
                fileInputStream.close();
                outputStream.close();
                socket.close();
            } catch (Exception e) {
                Message message3 = new Message();
                message3.what = MetaDo.META_RESTOREDC;
                message3.obj = PrinterLinkLocalNet.this.f10370k.getResources().getString(C1900at.C1907g.setprintertimeout);
                PrinterLinkLocalNet.this.f10378s.sendMessage(message3);
                e.printStackTrace();
            }
            File file = new File(this.f10392c);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* compiled from: PrinterLinkLocalNet.java */
    /* renamed from: com.cnlaunch.wifiprinter.ag$c */
    /* loaded from: classes.dex */
    public class C1887c extends Thread {

        /* renamed from: a */
        Context f10388a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1887c(Context context) {
            this.f10388a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            PrinterLinkLocalNet.this.f10381v.clear();
            PrinterLinkLocalNet.this.f10360A.startScan();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrinterLinkLocalNet.this.m8029b();
            this.f10388a.sendBroadcast(new Intent("Search_WIFI"));
            new Thread(new RunnableC1898aq(this)).start();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        this.f10370k.unregisterReceiver(this.f10379t);
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        String ssid = ((WifiManager) this.f10370k.getSystemService("wifi")).getConnectionInfo().getSSID();
        if (ssid.indexOf("\"") == 0) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        if (ssid.equalsIgnoreCase(this.f10376q)) {
            this.f10378s.sendEmptyMessage(TIFFConstants.TIFFTAG_RESOLUTIONUNIT);
        }
        super.onResume();
    }

    /* renamed from: d */
    static /* synthetic */ View m8026d(PrinterLinkLocalNet printerLinkLocalNet) {
        View inflate = LayoutInflater.from(Constant.f10351f).inflate(C1900at.C1906f.activity_dialog, (ViewGroup) null, false);
        printerLinkLocalNet.f10372m = (ListView) inflate.findViewById(C1900at.C1905e.list);
        ((TextView) inflate.findViewById(C1900at.C1905e.tvTitle)).setText(printerLinkLocalNet.f10370k.getResources().getString(C1900at.C1907g.ConnetLocalNet));
        TextView textView = (TextView) inflate.findViewById(C1900at.C1905e.tvShowinfo);
        f10359i = textView;
        textView.setVisibility(8);
        f10359i.setText(printerLinkLocalNet.f10370k.getResources().getString(C1900at.C1907g.refreshwifilist));
        printerLinkLocalNet.m8029b();
        printerLinkLocalNet.f10371l = new WifiPrinterAdapter(printerLinkLocalNet.f10381v, printerLinkLocalNet.f10370k);
        printerLinkLocalNet.f10372m.setAdapter((ListAdapter) printerLinkLocalNet.f10371l);
        printerLinkLocalNet.f10372m.setOnItemClickListener(new C1895an(printerLinkLocalNet));
        printerLinkLocalNet.f10373n = (Button) inflate.findViewById(C1900at.C1905e.btnrefresh);
        printerLinkLocalNet.f10373n.setOnClickListener(new View$OnClickListenerC1896ao(printerLinkLocalNet));
        return inflate;
    }
}
