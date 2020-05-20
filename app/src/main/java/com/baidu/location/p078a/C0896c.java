package com.baidu.location.p078a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.p081d.C0955a;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1016g;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.itextpdf.text.pdf.Barcode128;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.a.c */
/* loaded from: classes.dex */
public class C0896c {

    /* renamed from: g */
    private static Method f3880g;

    /* renamed from: h */
    private static Method f3881h;

    /* renamed from: i */
    private static Method f3882i;

    /* renamed from: j */
    private static Method f3883j;

    /* renamed from: k */
    private static Method f3884k;

    /* renamed from: l */
    private static Class<?> f3885l;

    /* renamed from: a */
    String f3886a;

    /* renamed from: b */
    String f3887b;

    /* renamed from: d */
    private Context f3889d;

    /* renamed from: e */
    private TelephonyManager f3890e;

    /* renamed from: m */
    private WifiManager f3892m;

    /* renamed from: o */
    private String f3894o;

    /* renamed from: p */
    private LocationClientOption f3895p;

    /* renamed from: q */
    private InterfaceC0897a f3896q;

    /* renamed from: s */
    private String f3898s;

    /* renamed from: t */
    private String f3899t;

    /* renamed from: f */
    private C0986a f3891f = new C0986a();

    /* renamed from: n */
    private C0899c f3893n = null;

    /* renamed from: r */
    private String f3897r = null;

    /* renamed from: c */
    C0898b f3888c = new C0898b();

    /* renamed from: com.baidu.location.a.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0897a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.c$b */
    /* loaded from: classes.dex */
    public class C0898b extends AbstractC1011e {

        /* renamed from: a */
        String f3900a = null;

        C0898b() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4522h = C1016g.m11557c();
            if (C0896c.this.f3898s != null && C0896c.this.f3899t != null) {
                this.f3900a += String.format(Locale.CHINA, "&ki=%s&sn=%s", C0896c.this.f3898s, C0896c.this.f3899t);
            }
            String encodeTp4 = Jni.encodeTp4(this.f3900a);
            this.f3900a = null;
            this.f4525k.put("bloc", encodeTp4);
            this.f4525k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        /* renamed from: a */
        public void m12213a(String str) {
            this.f3900a = str;
            m11575c(C1016g.f4596f);
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            BDLocation bDLocation;
            if (z && this.f4524j != null) {
                try {
                    try {
                        bDLocation = new BDLocation(this.f4524j);
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(C0896c.this.f3895p.coorType);
                        bDLocation.setLocationID(Jni.en1(C0896c.this.f3886a + ";" + C0896c.this.f3887b + ";" + bDLocation.getTime()));
                        C0896c.this.f3896q.onReceiveLocation(bDLocation);
                    }
                } catch (Exception unused2) {
                }
            }
            if (this.f4525k != null) {
                this.f4525k.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.location.a.c$c */
    /* loaded from: classes.dex */
    public class C0899c {

        /* renamed from: a */
        public List<ScanResult> f3902a;

        /* renamed from: c */
        private long f3904c;

        public C0899c(List<ScanResult> list) {
            this.f3902a = null;
            this.f3904c = 0L;
            this.f3902a = list;
            this.f3904c = System.currentTimeMillis();
            m12209c();
        }

        /* renamed from: b */
        private String m12210b() {
            WifiInfo connectionInfo = C0896c.this.f3892m.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace == null || replace.length() == 12) {
                    return new String(replace);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* renamed from: c */
        private void m12209c() {
            /*
                r7 = this;
                int r0 = r7.m12212a()
                if (r0 > 0) goto L7
                return
            L7:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.f3902a
                int r0 = r0.size()
                r1 = 1
                int r0 = r0 - r1
                r2 = 1
            L10:
                if (r0 <= 0) goto L4d
                if (r2 == 0) goto L4d
                r2 = 0
                r3 = 0
            L16:
                if (r2 >= r0) goto L49
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f3902a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r5 = r7.f3902a
                int r6 = r2 + 1
                java.lang.Object r5 = r5.get(r6)
                android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
                int r5 = r5.level
                if (r4 >= r5) goto L47
                java.util.List<android.net.wifi.ScanResult> r3 = r7.f3902a
                java.lang.Object r3 = r3.get(r6)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f3902a
                java.lang.Object r5 = r4.get(r2)
                r4.set(r6, r5)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f3902a
                r4.set(r2, r3)
                r3 = 1
            L47:
                r2 = r6
                goto L16
            L49:
                int r0 = r0 + (-1)
                r2 = r3
                goto L10
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0896c.C0899c.m12209c():void");
        }

        /* renamed from: a */
        public int m12212a() {
            List<ScanResult> list = this.f3902a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ee A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String m12211a(int r24) {
            /*
                Method dump skipped, instructions count: 355
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0896c.C0899c.m12211a(int):java.lang.String");
        }
    }

    public C0896c(Context context, LocationClientOption locationClientOption, InterfaceC0897a interfaceC0897a) {
        String str;
        String str2;
        this.f3889d = null;
        this.f3890e = null;
        this.f3892m = null;
        this.f3894o = null;
        this.f3898s = null;
        this.f3899t = null;
        this.f3886a = null;
        this.f3887b = null;
        this.f3889d = context.getApplicationContext();
        this.f3895p = new LocationClientOption(locationClientOption);
        this.f3896q = interfaceC0897a;
        this.f3886a = this.f3889d.getPackageName();
        this.f3887b = null;
        try {
            this.f3890e = (TelephonyManager) this.f3889d.getSystemService("phone");
            str = this.f3890e.getDeviceId();
        } catch (Exception unused) {
            str = null;
        }
        try {
            this.f3887b = CommonParam.m12426a(this.f3889d);
        } catch (Exception unused2) {
            this.f3887b = null;
        }
        if (this.f3887b != null) {
            C1016g.f4604n = this.f3887b;
            str2 = "&prod=" + this.f3895p.prodName + ":" + this.f3886a + "|&cu=" + this.f3887b + "&coor=" + locationClientOption.getCoorType();
        } else {
            str2 = "&prod=" + this.f3895p.prodName + ":" + this.f3886a + "|&im=" + str + "&coor=" + locationClientOption.getCoorType();
        }
        this.f3894o = str2;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("7.51");
        stringBuffer.append("&sdk=");
        stringBuffer.append("7.51");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.f3894o += "&addr=allj";
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.f3894o += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.f3894o += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.f3894o += "aptagd|";
            }
            this.f3898s = C0910h.m12146b(this.f3889d);
            this.f3899t = C0910h.m12145c(this.f3889d);
        }
        stringBuffer.append("&first=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.f3894o += stringBuffer.toString();
        this.f3892m = (WifiManager) this.f3889d.getApplicationContext().getSystemService("wifi");
        String m12226a = m12226a();
        m12226a = TextUtils.isEmpty(m12226a) ? m12226a : m12226a.replace(":", "");
        if (!TextUtils.isEmpty(m12226a) && !m12226a.equals("020000000000")) {
            this.f3894o += "&mac=" + m12226a;
        }
        m12221b();
    }

    /* renamed from: a */
    private int m12225a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
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
    private com.baidu.location.p082e.C0986a m12224a(android.telephony.CellInfo r10) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0896c.m12224a(android.telephony.CellInfo):com.baidu.location.e.a");
    }

    /* renamed from: a */
    private void m12223a(CellLocation cellLocation) {
        int i;
        if (cellLocation == null || this.f3890e == null) {
            return;
        }
        C0986a c0986a = new C0986a();
        String networkOperator = this.f3890e.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f3891f.f4374c;
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
                    intValue2 = this.f3891f.f4375d;
                }
                c0986a.f4375d = intValue2;
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c0986a.f4372a = gsmCellLocation.getLac();
            c0986a.f4373b = gsmCellLocation.getCid();
            c0986a.f4380i = Barcode128.START_A;
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0986a.f4380i = Barcode128.CODE_AB_TO_C;
            if (f3885l == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f3885l = cls;
                    f3880g = cls.getMethod("getBaseStationId", new Class[0]);
                    f3881h = f3885l.getMethod("getNetworkId", new Class[0]);
                    f3882i = f3885l.getMethod("getSystemId", new Class[0]);
                    f3883j = f3885l.getMethod("getBaseStationLatitude", new Class[0]);
                    f3884k = f3885l.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception unused2) {
                    f3885l = null;
                    return;
                }
            }
            Class<?> cls2 = f3885l;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) f3882i.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.f3891f.f4375d;
                    }
                    c0986a.f4375d = intValue3;
                    c0986a.f4373b = ((Integer) f3880g.invoke(cellLocation, new Object[0])).intValue();
                    c0986a.f4372a = ((Integer) f3881h.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = f3883j.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        c0986a.f4376e = ((Integer) invoke).intValue();
                    }
                    Object invoke2 = f3884k.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                        c0986a.f4377f = ((Integer) invoke2).intValue();
                    }
                } catch (Exception unused3) {
                    return;
                }
            }
        }
        if (c0986a.m11740b()) {
            this.f3891f = c0986a;
        } else {
            this.f3891f = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:2|3)|(9:8|9|(1:43)(1:13)|14|15|(1:19)|21|22|(2:(1:(1:30)(1:31))|(1:33)(4:34|(1:36)|37|38))(2:25|26))|44|9|(1:11)|43|14|15|(2:17|19)|21|22|(0)|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|2|3|(9:8|9|(1:43)(1:13)|14|15|(1:19)|21|22|(2:(1:(1:30)(1:31))|(1:33)(4:34|(1:36)|37|38))(2:25|26))|44|9|(1:11)|43|14|15|(2:17|19)|21|22|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m12220b(int r5) {
        /*
            r4 = this;
            r0 = 0
            com.baidu.location.e.a r1 = r4.m12216d()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L11
            boolean r2 = r1.m11740b()     // Catch: java.lang.Throwable -> L4e
            if (r2 != 0) goto Le
            goto L11
        Le:
            r4.f3891f = r1     // Catch: java.lang.Throwable -> L4e
            goto L1a
        L11:
            android.telephony.TelephonyManager r1 = r4.f3890e     // Catch: java.lang.Throwable -> L4e
            android.telephony.CellLocation r1 = r1.getCellLocation()     // Catch: java.lang.Throwable -> L4e
            r4.m12223a(r1)     // Catch: java.lang.Throwable -> L4e
        L1a:
            com.baidu.location.e.a r1 = r4.f3891f     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L2d
            com.baidu.location.e.a r1 = r4.f3891f     // Catch: java.lang.Throwable -> L4e
            boolean r1 = r1.m11740b()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L2d
            com.baidu.location.e.a r1 = r4.f3891f     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = r1.m11734h()     // Catch: java.lang.Throwable -> L4e
            goto L2e
        L2d:
            r1 = r0
        L2e:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L4f
            if (r2 != 0) goto L4f
            com.baidu.location.e.a r2 = r4.f3891f     // Catch: java.lang.Throwable -> L4f
            java.lang.String r2 = r2.f4381j     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L4f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r2.<init>()     // Catch: java.lang.Throwable -> L4f
            r2.append(r1)     // Catch: java.lang.Throwable -> L4f
            com.baidu.location.e.a r3 = r4.f3891f     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = r3.f4381j     // Catch: java.lang.Throwable -> L4f
            r2.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L4f
            goto L4f
        L4e:
            r1 = r0
        L4f:
            r4.f3893n = r0     // Catch: java.lang.Exception -> L65
            com.baidu.location.a.c$c r2 = new com.baidu.location.a.c$c     // Catch: java.lang.Exception -> L65
            android.net.wifi.WifiManager r3 = r4.f3892m     // Catch: java.lang.Exception -> L65
            java.util.List r3 = r3.getScanResults()     // Catch: java.lang.Exception -> L65
            r2.<init>(r3)     // Catch: java.lang.Exception -> L65
            r4.f3893n = r2     // Catch: java.lang.Exception -> L65
            com.baidu.location.a.c$c r2 = r4.f3893n     // Catch: java.lang.Exception -> L65
            java.lang.String r5 = r2.m12211a(r5)     // Catch: java.lang.Exception -> L65
            goto L66
        L65:
            r5 = r0
        L66:
            if (r1 != 0) goto L6d
            if (r5 != 0) goto L6d
            r4.f3897r = r0
            return r0
        L6d:
            if (r5 == 0) goto L82
            if (r1 != 0) goto L73
            r1 = r5
            goto L82
        L73:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r5)
            java.lang.String r1 = r2.toString()
        L82:
            if (r1 != 0) goto L85
            return r0
        L85:
            r4.f3897r = r1
            java.lang.String r5 = r4.f3894o
            if (r5 == 0) goto La0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r4.f3897r
            r5.append(r0)
            java.lang.String r0 = r4.f3894o
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.f3897r = r5
        La0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r0 = r4.f3894o
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0896c.m12220b(int):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    private C0986a m12216d() {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.f3890e.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            C0986a c0986a = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = c0986a != null;
                    C0986a m12224a = m12224a(cellInfo);
                    if (m12224a == null) {
                        continue;
                    } else {
                        if (!m12224a.m11740b()) {
                            m12224a = null;
                        } else if (z) {
                            c0986a.f4381j = m12224a.m11733i();
                            return c0986a;
                        }
                        if (c0986a == null) {
                            c0986a = m12224a;
                        }
                    }
                }
            }
            return c0986a;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m12226a() {
        try {
            WifiInfo connectionInfo = this.f3892m.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error | Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String m12221b() {
        try {
            return m12220b(15);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public void m12218c() {
        if (this.f3897r == null) {
            return;
        }
        BDLocation bDLocation = null;
        if (this.f3892m != null && this.f3895p.scanSpan >= 1000 && !this.f3895p.getAddrType().equals("all") && !this.f3895p.isNeedAptag && !this.f3895p.isNeedAptagd) {
            try {
                BDLocation m11927a = C0955a.m11938a().m11927a(this.f3891f != null ? this.f3891f.m11735g() : null, this.f3892m.getScanResults(), false);
                if (!this.f3895p.coorType.equals(CoordinateType.GCJ02)) {
                    double longitude = m11927a.getLongitude();
                    double latitude = m11927a.getLatitude();
                    if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f3895p.coorType);
                        m11927a.setLongitude(coorEncrypt[0]);
                        m11927a.setLatitude(coorEncrypt[1]);
                        m11927a.setCoorType(this.f3895p.coorType);
                    }
                }
                if (m11927a.getLocType() == 66) {
                    this.f3896q.onReceiveLocation(m11927a);
                }
                bDLocation = m11927a;
            } catch (Exception unused) {
            }
        }
        if (bDLocation == null) {
            this.f3888c.m12213a(this.f3897r);
        }
    }
}
