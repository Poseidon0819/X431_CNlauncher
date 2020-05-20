package com.baidu.location.p082e;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p079b.C0936b;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.location.e.b */
/* loaded from: classes.dex */
public class C0987b {

    /* renamed from: a */
    public static int f4383a;

    /* renamed from: b */
    public static int f4384b;

    /* renamed from: c */
    private static C0987b f4385c;

    /* renamed from: k */
    private static Method f4386k;

    /* renamed from: l */
    private static Method f4387l;

    /* renamed from: m */
    private static Method f4388m;

    /* renamed from: n */
    private static Method f4389n;

    /* renamed from: o */
    private static Method f4390o;

    /* renamed from: p */
    private static Class<?> f4391p;

    /* renamed from: d */
    private TelephonyManager f4392d = null;

    /* renamed from: e */
    private Object f4393e = null;

    /* renamed from: f */
    private C0986a f4394f = new C0986a();

    /* renamed from: g */
    private C0986a f4395g = null;

    /* renamed from: h */
    private List<C0986a> f4396h = null;

    /* renamed from: i */
    private C0988a f4397i = null;

    /* renamed from: j */
    private boolean f4398j = false;

    /* renamed from: q */
    private boolean f4399q = false;

    /* renamed from: r */
    private Handler f4400r = new Handler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.e.b$a */
    /* loaded from: classes.dex */
    public class C0988a extends PhoneStateListener {
        public C0988a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                return;
            }
            C0987b.this.f4400r.post(new Runnable() { // from class: com.baidu.location.e.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C0987b.this.m11710k();
                    } catch (Exception unused) {
                    }
                    C0936b.m12017a().m12008e();
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (C0987b.this.f4394f != null) {
                if (C0987b.this.f4394f.f4380i == 'g') {
                    C0987b.this.f4394f.f4379h = signalStrength.getGsmSignalStrength();
                } else if (C0987b.this.f4394f.f4380i == 'c') {
                    C0987b.this.f4394f.f4379h = signalStrength.getCdmaDbm();
                }
            }
        }
    }

    private C0987b() {
    }

    /* renamed from: a */
    private int m11731a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* renamed from: a */
    private CellLocation m11725a(List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int i = 0;
        char c = 0;
        GsmCellLocation gsmCellLocation = null;
        CdmaCellLocation cdmaCellLocation = null;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            Object obj = list.get(i);
            if (obj != null) {
                try {
                    Class<?> loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class<?> loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class<?> loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class<?> loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    c = loadClass.isInstance(obj) ? (char) 1 : loadClass2.isInstance(obj) ? (char) 2 : loadClass3.isInstance(obj) ? (char) 3 : loadClass4.isInstance(obj) ? (char) 4 : (char) 0;
                    if (c > 0) {
                        Object m11565a = C1016g.m11565a(c == 1 ? loadClass.cast(obj) : c == 2 ? loadClass2.cast(obj) : c == 3 ? loadClass3.cast(obj) : c == 4 ? loadClass4.cast(obj) : null, "getCellIdentity", new Object[0]);
                        if (m11565a != null) {
                            if (c == 4) {
                                CdmaCellLocation cdmaCellLocation2 = new CdmaCellLocation();
                                try {
                                    cdmaCellLocation2.setCellLocationData(C1016g.m11559b(m11565a, "getBasestationId", new Object[0]), C1016g.m11559b(m11565a, "getLatitude", new Object[0]), C1016g.m11559b(m11565a, "getLongitude", new Object[0]), C1016g.m11559b(m11565a, "getSystemId", new Object[0]), C1016g.m11559b(m11565a, "getNetworkId", new Object[0]));
                                    cdmaCellLocation = cdmaCellLocation2;
                                    break;
                                } catch (Exception unused) {
                                    cdmaCellLocation = cdmaCellLocation2;
                                }
                            } else if (c == 3) {
                                try {
                                    int m11559b = C1016g.m11559b(m11565a, "getTac", new Object[0]);
                                    int m11559b2 = C1016g.m11559b(m11565a, "getCi", new Object[0]);
                                    GsmCellLocation gsmCellLocation2 = new GsmCellLocation();
                                    try {
                                        gsmCellLocation2.setLacAndCid(m11559b, m11559b2);
                                        gsmCellLocation = gsmCellLocation2;
                                        break;
                                    } catch (Exception unused2) {
                                        gsmCellLocation = gsmCellLocation2;
                                    }
                                } catch (Exception unused3) {
                                    continue;
                                }
                            } else {
                                int m11559b3 = C1016g.m11559b(m11565a, "getLac", new Object[0]);
                                int m11559b4 = C1016g.m11559b(m11565a, "getCid", new Object[0]);
                                GsmCellLocation gsmCellLocation3 = new GsmCellLocation();
                                try {
                                    gsmCellLocation3.setLacAndCid(m11559b3, m11559b4);
                                    gsmCellLocation = gsmCellLocation3;
                                    break;
                                } catch (Exception unused4) {
                                    gsmCellLocation = gsmCellLocation3;
                                }
                            }
                        }
                    }
                } catch (Exception unused5) {
                }
            }
            i++;
        }
        return c == 4 ? cdmaCellLocation : gsmCellLocation;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(1:7)(7:23|(3:25|(4:31|32|33|(2:39|(1:41)))(1:29)|30)(2:45|(1:47)(1:48))|9|(3:12|13|(1:15))|18|19|20)|8|9|(3:12|13|(0))|18|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ca, code lost:
        if (r2 <= 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x016a, code lost:
        r1.f4378g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117 A[Catch: Exception -> 0x0155, TRY_LEAVE, TryCatch #2 {Exception -> 0x0155, blocks: (B:38:0x0113, B:40:0x0117), top: B:51:0x0113 }] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.p082e.C0986a m11730a(android.telephony.CellInfo r10) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0987b.m11730a(android.telephony.CellInfo):com.baidu.location.e.a");
    }

    /* renamed from: a */
    private C0986a m11729a(CellLocation cellLocation) {
        return m11728a(cellLocation, false);
    }

    /* renamed from: a */
    private C0986a m11728a(CellLocation cellLocation, boolean z) {
        int i;
        if (cellLocation == null || this.f4392d == null) {
            return null;
        }
        C0986a c0986a = new C0986a();
        if (z) {
            c0986a.m11736f();
        }
        c0986a.f4378g = System.currentTimeMillis();
        try {
            String networkOperator = this.f4392d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f4394f.f4374c;
                    }
                    c0986a.f4374c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.f4394f.f4375d;
                }
                c0986a.f4375d = intValue2;
            }
            f4383a = this.f4392d.getSimState();
        } catch (Exception unused) {
            f4384b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c0986a.f4372a = gsmCellLocation.getLac();
            c0986a.f4373b = gsmCellLocation.getCid();
            c0986a.f4380i = Barcode128.START_A;
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0986a.f4380i = Barcode128.CODE_AB_TO_C;
            if (Build.VERSION.SDK_INT < 5) {
                return c0986a;
            }
            if (f4391p == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f4391p = cls;
                    f4386k = cls.getMethod("getBaseStationId", new Class[0]);
                    f4387l = f4391p.getMethod("getNetworkId", new Class[0]);
                    f4388m = f4391p.getMethod("getSystemId", new Class[0]);
                    f4389n = f4391p.getMethod("getBaseStationLatitude", new Class[0]);
                    f4390o = f4391p.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception unused2) {
                    f4391p = null;
                    f4384b = 2;
                    return c0986a;
                }
            }
            Class<?> cls2 = f4391p;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f4388m.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.f4394f.f4375d;
                    }
                    c0986a.f4375d = intValue3;
                    c0986a.f4373b = ((Integer) f4386k.invoke(cellLocation, new Object[0])).intValue();
                    c0986a.f4372a = ((Integer) f4387l.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = f4389n.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        c0986a.f4376e = ((Integer) invoke).intValue();
                    }
                    Object invoke2 = f4390o.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                        c0986a.f4377f = ((Integer) invoke2).intValue();
                    }
                } catch (Exception unused3) {
                    f4384b = 3;
                    return c0986a;
                }
            }
        }
        m11720c(c0986a);
        return c0986a;
    }

    /* renamed from: a */
    public static synchronized C0987b m11732a() {
        C0987b c0987b;
        synchronized (C0987b.class) {
            if (f4385c == null) {
                f4385c = new C0987b();
            }
            c0987b = f4385c;
        }
        return c0987b;
    }

    /* renamed from: c */
    private void m11720c(C0986a c0986a) {
        if (c0986a.m11740b()) {
            C0986a c0986a2 = this.f4394f;
            if (c0986a2 == null || !c0986a2.m11741a(c0986a)) {
                this.f4394f = c0986a;
                if (!c0986a.m11740b()) {
                    List<C0986a> list = this.f4396h;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f4396h.size();
                C0986a c0986a3 = size == 0 ? null : this.f4396h.get(size - 1);
                if (c0986a3 != null && c0986a3.f4373b == this.f4394f.f4373b && c0986a3.f4372a == this.f4394f.f4372a) {
                    return;
                }
                this.f4396h.add(this.f4394f);
                if (this.f4396h.size() > 3) {
                    this.f4396h.remove(0);
                }
                m11711j();
                this.f4399q = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    private String m11717d(C0986a c0986a) {
        C0986a m11730a;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                List<CellInfo> allCellInfo = this.f4392d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb2.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (m11730a = m11730a(cellInfo)) != null && m11730a.f4372a != -1 && m11730a.f4373b != -1) {
                            if (c0986a.f4372a != m11730a.f4372a) {
                                sb = new StringBuilder();
                                sb.append(m11730a.f4372a);
                                sb.append("|");
                                sb.append(m11730a.f4373b);
                                sb.append("|");
                                sb.append(m11730a.f4379h);
                                sb.append(";");
                            } else {
                                sb = new StringBuilder("|");
                                sb.append(m11730a.f4373b);
                                sb.append("|");
                                sb.append(m11730a.f4379h);
                                sb.append(";");
                            }
                            sb2.append(sb.toString());
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return sb2.toString();
    }

    /* renamed from: i */
    private void m11712i() {
        String m11550g = C1016g.m11550g();
        if (m11550g == null) {
            return;
        }
        File file = new File(m11550g + File.separator + "lcvif.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long j = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i = 0;
                while (i < 3) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    int readInt4 = randomAccessFile.readInt();
                    int readInt5 = randomAccessFile.readInt();
                    char c = readInt5 == 2 ? Barcode128.CODE_AB_TO_C : readInt5 == 1 ? Barcode128.START_A : (char) 0;
                    if (readLong != j) {
                        C0986a c0986a = new C0986a(readInt3, readInt4, readInt, readInt2, 0, c);
                        c0986a.f4378g = readLong;
                        if (c0986a.m11740b()) {
                            this.f4399q = true;
                            this.f4396h.add(c0986a);
                        }
                    }
                    i++;
                    j = 0;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
                file.delete();
            }
        }
    }

    /* renamed from: j */
    private void m11711j() {
        if (this.f4396h == null && this.f4395g == null) {
            return;
        }
        if (this.f4396h == null && this.f4395g != null) {
            this.f4396h = new LinkedList();
            this.f4396h.add(this.f4395g);
        }
        String m11550g = C1016g.m11550g();
        if (m11550g == null) {
            return;
        }
        File file = new File(m11550g + File.separator + "lcvif.dat");
        int size = this.f4396h.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f4396h.get(size - 1).f4378g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.f4396h.get(i2).f4378g);
                randomAccessFile.writeInt(this.f4396h.get(i2).f4374c);
                randomAccessFile.writeInt(this.f4396h.get(i2).f4375d);
                randomAccessFile.writeInt(this.f4396h.get(i2).f4372a);
                randomAccessFile.writeInt(this.f4396h.get(i2).f4373b);
                if (this.f4396h.get(i2).f4380i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f4396h.get(i2).f4380i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m11710k() {
        CellLocation cellLocation;
        CellLocation m11709l;
        C0986a m11707n = m11707n();
        if (m11707n != null) {
            m11720c(m11707n);
        }
        if (m11707n == null || !m11707n.m11740b()) {
            try {
                cellLocation = this.f4392d.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            C0986a m11729a = cellLocation != null ? m11729a(cellLocation) : null;
            if ((m11729a == null || !m11729a.m11740b()) && (m11709l = m11709l()) != null) {
                m11728a(m11709l, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.telephony.CellLocation m11709l() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f4393e
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.Class r2 = r8.m11708m()     // Catch: java.lang.Exception -> L5b
            boolean r3 = r2.isInstance(r0)     // Catch: java.lang.Exception -> L5b
            if (r3 == 0) goto L55
            java.lang.Object r0 = r2.cast(r0)     // Catch: java.lang.Exception -> L5b
            java.lang.String r2 = "getCellLocation"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r4 = com.baidu.location.p084g.C1016g.m11565a(r0, r2, r4)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r4 = r1
        L1f:
            r5 = 1
            if (r4 != 0) goto L2e
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L2e
            r6[r3] = r7     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = com.baidu.location.p084g.C1016g.m11565a(r0, r2, r6)     // Catch: java.lang.Throwable -> L2e
        L2e:
            if (r4 != 0) goto L3f
            java.lang.String r2 = "getCellLocationGemini"
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L3f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L3f
            r6[r3] = r5     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = com.baidu.location.p084g.C1016g.m11565a(r0, r2, r6)     // Catch: java.lang.Throwable -> L3f
            goto L40
        L3f:
            r2 = r4
        L40:
            if (r2 != 0) goto L53
            java.lang.String r2 = "getAllCellInfo"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r0 = com.baidu.location.p084g.C1016g.m11565a(r0, r2, r3)     // Catch: java.lang.Throwable -> L4d
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L4d
            goto L4e
        L4d:
            r0 = r1
        L4e:
            android.telephony.CellLocation r0 = r8.m11725a(r0)     // Catch: java.lang.Exception -> L5b
            goto L56
        L53:
            r0 = r2
            goto L56
        L55:
            r0 = r1
        L56:
            if (r0 == 0) goto L5b
            android.telephony.CellLocation r0 = (android.telephony.CellLocation) r0     // Catch: java.lang.Exception -> L5b
            r1 = r0
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0987b.m11709l():android.telephony.CellLocation");
    }

    /* renamed from: m */
    private Class<?> m11708m() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (m11706o()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: n */
    private C0986a m11707n() {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        try {
            f4383a = this.f4392d.getSimState();
            List<CellInfo> allCellInfo = this.f4392d.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            C0986a c0986a = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = c0986a != null;
                    C0986a m11730a = m11730a(cellInfo);
                    if (m11730a == null) {
                        continue;
                    } else {
                        if (!m11730a.m11740b()) {
                            m11730a = null;
                        } else if (z) {
                            c0986a.f4381j = m11730a.m11733i();
                            return c0986a;
                        }
                        if (c0986a == null) {
                            c0986a = m11730a;
                        }
                    }
                }
            }
            return c0986a;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: o */
    private int m11706o() {
        int i;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                return 2;
            } catch (Exception unused2) {
                return i;
            }
        }
        return i;
    }

    /* renamed from: a */
    public String m11727a(C0986a c0986a) {
        String str;
        int i;
        try {
            str = m11717d(c0986a);
            i = Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if ((str == null || str.equals("") || str.equals("&nc=")) && i < 17) {
            List<NeighboringCellInfo> neighboringCellInfo = this.f4392d.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                str = "&nc=";
                int i2 = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    if (lac != -1 && neighboringCellInfo2.getCid() != -1) {
                        str = c0986a.f4372a != lac ? str + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";" : str + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";";
                    }
                    i2++;
                    if (i2 >= 8) {
                        break;
                    }
                }
            }
            if (str == null || !str.equals("&nc=")) {
                return str;
            }
            return null;
        }
        return str;
    }

    /* renamed from: b */
    public String m11723b(C0986a c0986a) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(c0986a.f4380i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(c0986a.f4374c), Integer.valueOf(c0986a.f4375d), Integer.valueOf(c0986a.f4372a), Integer.valueOf(c0986a.f4373b), Integer.valueOf(c0986a.f4379h)));
        if (c0986a.f4376e < Integer.MAX_VALUE && c0986a.f4377f < Integer.MAX_VALUE) {
            Locale locale = Locale.CHINA;
            double d = c0986a.f4377f;
            Double.isNaN(d);
            double d2 = c0986a.f4376e;
            Double.isNaN(d2);
            stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(d / 14400.0d), Double.valueOf(d2 / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(c0986a.f4378g);
        try {
            if (this.f4396h != null && this.f4396h.size() > 0) {
                int size = this.f4396h.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    C0986a c0986a2 = this.f4396h.get(i);
                    if (c0986a2 != null) {
                        if (c0986a2.f4374c != c0986a.f4374c) {
                            stringBuffer.append(c0986a2.f4374c);
                        }
                        stringBuffer.append("|");
                        if (c0986a2.f4375d != c0986a.f4375d) {
                            stringBuffer.append(c0986a2.f4375d);
                        }
                        stringBuffer.append("|");
                        if (c0986a2.f4372a != c0986a.f4372a) {
                            stringBuffer.append(c0986a2.f4372a);
                        }
                        stringBuffer.append("|");
                        if (c0986a2.f4373b != c0986a.f4373b) {
                            stringBuffer.append(c0986a2.f4373b);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - c0986a2.f4378g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (f4383a > 100) {
            f4383a = 0;
        }
        stringBuffer.append("&cs=".concat(String.valueOf(f4383a + (f4384b << 8))));
        if (c0986a.f4381j != null) {
            stringBuffer.append(c0986a.f4381j);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public synchronized void m11724b() {
        Object m11570a;
        if (this.f4398j) {
            return;
        }
        if (ServiceC1002f.isServing) {
            this.f4392d = (TelephonyManager) ServiceC1002f.getServiceContext().getSystemService("phone");
            this.f4396h = new LinkedList();
            this.f4397i = new C0988a();
            m11712i();
            if (this.f4392d == null || this.f4397i == null) {
                return;
            }
            try {
                this.f4392d.listen(this.f4397i, TIFFConstants.TIFFTAG_MODEL);
            } catch (Exception unused) {
            }
            switch (m11706o()) {
                case 0:
                    m11570a = C1016g.m11570a(ServiceC1002f.getServiceContext(), "phone2");
                    this.f4393e = m11570a;
                    break;
                case 1:
                    m11570a = C1016g.m11570a(ServiceC1002f.getServiceContext(), "phone_msim");
                    this.f4393e = m11570a;
                    break;
                case 2:
                    m11570a = C1016g.m11570a(ServiceC1002f.getServiceContext(), "phone2");
                    this.f4393e = m11570a;
                    break;
            }
            this.f4398j = true;
        }
    }

    /* renamed from: c */
    public synchronized void m11721c() {
        if (this.f4398j) {
            if (this.f4397i != null && this.f4392d != null) {
                this.f4392d.listen(this.f4397i, 0);
            }
            this.f4397i = null;
            this.f4392d = null;
            this.f4396h.clear();
            this.f4396h = null;
            m11711j();
            this.f4398j = false;
        }
    }

    /* renamed from: d */
    public boolean m11718d() {
        return this.f4399q;
    }

    /* renamed from: e */
    public int m11716e() {
        TelephonyManager telephonyManager = this.f4392d;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: f */
    public C0986a m11715f() {
        C0986a c0986a = this.f4394f;
        if ((c0986a == null || !c0986a.m11742a() || !this.f4394f.m11740b()) && this.f4392d != null) {
            try {
                m11710k();
            } catch (Exception unused) {
            }
        }
        if (this.f4394f.m11737e()) {
            this.f4395g = null;
            this.f4395g = new C0986a(this.f4394f.f4372a, this.f4394f.f4373b, this.f4394f.f4374c, this.f4394f.f4375d, this.f4394f.f4379h, this.f4394f.f4380i);
        }
        if (this.f4394f.m11738d() && this.f4395g != null && this.f4394f.f4380i == 'g') {
            this.f4394f.f4375d = this.f4395g.f4375d;
            this.f4394f.f4374c = this.f4395g.f4374c;
        }
        return this.f4394f;
    }

    /* renamed from: g */
    public String m11714g() {
        int i = -1;
        try {
            if (this.f4392d != null) {
                i = this.f4392d.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=".concat(String.valueOf(i));
    }

    /* renamed from: h */
    public int m11713h() {
        String str;
        try {
            str = ((TelephonyManager) ServiceC1002f.getServiceContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46007")) {
                return 1;
            }
            if (str.startsWith("46001")) {
                return 2;
            }
            return str.startsWith("46003") ? 3 : 0;
        }
        return 0;
    }
}
