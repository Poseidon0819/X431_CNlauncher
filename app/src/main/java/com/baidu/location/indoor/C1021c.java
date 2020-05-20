package com.baidu.location.indoor;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.baidu.location.indoor.c */
/* loaded from: classes.dex */
public class C1021c {

    /* renamed from: a */
    private static final char[] f4630a = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private static C1021c f4631b = null;

    /* renamed from: c */
    private Context f4632c;

    /* renamed from: f */
    private BluetoothAdapter f4635f;

    /* renamed from: g */
    private boolean f4636g;

    /* renamed from: h */
    private InterfaceC1025b f4637h;

    /* renamed from: d */
    private boolean f4633d = false;

    /* renamed from: e */
    private boolean f4634e = false;

    /* renamed from: i */
    private boolean f4638i = false;

    /* renamed from: j */
    private String f4639j = null;

    /* renamed from: k */
    private long f4640k = -1;

    /* renamed from: l */
    private HashMap<String, ScanResult> f4641l = new HashMap<>();

    /* renamed from: m */
    private Handler f4642m = new Handler();

    /* renamed from: n */
    private Runnable f4643n = new Runnable() { // from class: com.baidu.location.indoor.c.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                C1021c.this.m11529a(C1021c.this.f4641l);
            } catch (Exception unused) {
            }
            if (C1021c.this.f4635f != null && C1021c.this.f4635f.isEnabled()) {
                C1021c.this.m11527a(false);
            }
            C1021c.this.f4641l.clear();
        }
    };

    /* renamed from: o */
    private Object f4644o = null;

    /* renamed from: com.baidu.location.indoor.c$a */
    /* loaded from: classes.dex */
    public static class C1024a implements Comparable<C1024a> {

        /* renamed from: a */
        public String f4647a;

        /* renamed from: b */
        public int f4648b;

        /* renamed from: c */
        public long f4649c;

        public C1024a(String str, int i, long j) {
            this.f4647a = str;
            this.f4648b = i;
            this.f4649c = j / 1000000;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C1024a c1024a) {
            return Math.abs(this.f4648b) > Math.abs(c1024a.f4648b) ? 1 : 0;
        }

        public String toString() {
            return this.f4647a.toUpperCase() + ";" + this.f4648b + ";" + this.f4649c;
        }
    }

    /* renamed from: com.baidu.location.indoor.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1025b {
        /* renamed from: a */
        void mo11383a(boolean z, String str, String str2, String str3);
    }

    @TargetApi(18)
    private C1021c(Context context) {
        this.f4636g = false;
        this.f4632c = context;
        if (this.f4635f == null) {
            try {
                if (Build.VERSION.SDK_INT <= 18) {
                    this.f4635f = BluetoothAdapter.getDefaultAdapter();
                    return;
                }
                this.f4635f = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
                this.f4636g = this.f4632c.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static C1021c m11533a(Context context) {
        if (f4631b == null) {
            f4631b = new C1021c(context);
        }
        return f4631b;
    }

    /* renamed from: a */
    private String m11528a(List<C1024a> list, int i) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.get(0).toString());
        for (int i2 = 1; i2 < list.size() && i2 < i; i2++) {
            sb.append("|");
            sb.append(list.get(i2).toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m11526a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f4630a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    /* renamed from: a */
    public void m11529a(HashMap<String, ScanResult> hashMap) {
        ArrayList<ScanResult> arrayList = new ArrayList(hashMap.values());
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        for (ScanResult scanResult : arrayList) {
            arrayList3.add(new C1024a(scanResult.getDevice().getAddress().replaceAll(":", ""), scanResult.getRssi(), scanResult.getTimestampNanos()));
            if (this.f4633d) {
                scanResult.getScanRecord().getAdvertiseFlags();
                byte[] bytes = scanResult.getScanRecord().getBytes();
                if (bytes.length >= 26) {
                    String m11526a = m11526a(Arrays.copyOfRange(bytes, 9, 25));
                    arrayList2.add(m11526a);
                    hashMap2.put(m11526a, scanResult.getDevice().getName());
                    hashMap3.put(m11526a, m11526a(Arrays.copyOfRange(bytes, 0, 9)));
                    if (hashMap4.get(m11526a) == null) {
                        hashMap4.put(m11526a, 0);
                    }
                    hashMap4.put(m11526a, Integer.valueOf(((Integer) hashMap4.get(m11526a)).intValue() + 1));
                }
            }
        }
        String str = null;
        int i = 0;
        for (String str2 : hashMap4.keySet()) {
            if (((Integer) hashMap4.get(str2)).intValue() > i) {
                i = ((Integer) hashMap4.get(str2)).intValue();
                str = str2;
            }
        }
        boolean z = i > 3;
        InterfaceC1025b interfaceC1025b = this.f4637h;
        if (interfaceC1025b != null && this.f4633d) {
            interfaceC1025b.mo11383a(z, str, (String) hashMap2.get(str), (String) hashMap3.get(str));
            this.f4633d = false;
        }
        if (arrayList3.size() > 3) {
            this.f4639j = m11528a(arrayList3, 32);
            this.f4640k = System.currentTimeMillis();
        }
        if (this.f4638i) {
            m11527a(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[RETURN] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m11518h() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r7.f4632c
            java.io.File r1 = r1.getCacheDir()
            java.lang.String r2 = "ibct"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L15
            return r2
        L15:
            r1 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L44
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Exception -> L44
            r4.<init>(r0)     // Catch: java.lang.Exception -> L44
            r3.<init>(r4)     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = ""
            r6 = r1
            r1 = r0
            r0 = r6
        L25:
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Exception -> L3f
            if (r0 == 0) goto L3b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3f
            r4.<init>()     // Catch: java.lang.Exception -> L3f
            r4.append(r1)     // Catch: java.lang.Exception -> L3f
            r4.append(r0)     // Catch: java.lang.Exception -> L3f
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L3f
            goto L25
        L3b:
            r3.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L3f:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L45
        L44:
            r0 = move-exception
        L45:
            r0.printStackTrace()
        L48:
            if (r1 == 0) goto L6d
            java.lang.String r0 = r1.trim()
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L57
            goto L6d
        L57:
            java.lang.Long r0 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Exception -> L6d
            long r0 = r0.longValue()     // Catch: java.lang.Exception -> L6d
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L6d
            long r3 = r3 - r0
            r0 = 259200(0x3f480, double:1.28062E-318)
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 >= 0) goto L6d
            r0 = 1
            return r0
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C1021c.m11518h():boolean");
    }

    /* renamed from: i */
    private void m11517i() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f4632c.getCacheDir(), "ibct"));
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    public void m11527a(boolean z) {
        if (this.f4635f == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (!z) {
                    if (this.f4637h != null) {
                        this.f4635f.getBluetoothLeScanner().stopScan((ScanCallback) this.f4644o);
                    }
                    this.f4633d = false;
                    return;
                }
                this.f4644o = new ScanCallback() { // from class: com.baidu.location.indoor.c.2
                    @Override // android.bluetooth.le.ScanCallback
                    public void onScanResult(int i, ScanResult scanResult) {
                        if (C1021c.this.f4641l != null) {
                            C1021c.this.f4641l.put(scanResult.getDevice().getAddress(), scanResult);
                        }
                    }
                };
                this.f4635f.getBluetoothLeScanner().startScan((ScanCallback) this.f4644o);
                this.f4642m.postDelayed(this.f4643n, 3000L);
                this.f4633d = true;
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public boolean m11534a() {
        BluetoothAdapter bluetoothAdapter = this.f4635f;
        if (bluetoothAdapter != null && this.f4636g) {
            try {
                return bluetoothAdapter.isEnabled();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m11532a(InterfaceC1025b interfaceC1025b) {
        if (this.f4633d || this.f4634e) {
            return false;
        }
        this.f4634e = true;
        if (m11534a() && !m11518h()) {
            m11517i();
            this.f4637h = interfaceC1025b;
            m11527a(true);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m11525b() {
        if (m11534a()) {
            m11527a(true);
            this.f4638i = true;
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m11523c() {
        this.f4634e = false;
        this.f4633d = false;
    }

    /* renamed from: d */
    public void m11522d() {
        this.f4638i = false;
    }

    /* renamed from: e */
    public String m11521e() {
        return this.f4639j;
    }

    /* renamed from: f */
    public long m11520f() {
        return this.f4640k;
    }

    /* renamed from: g */
    public boolean m11519g() {
        return System.currentTimeMillis() - this.f4640k <= 20000;
    }
}
