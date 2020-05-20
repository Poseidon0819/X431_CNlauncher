package com.baidu.location.p082e;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import com.baidu.location.p084g.C1016g;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.baidu.location.e.e */
/* loaded from: classes.dex */
public class C0997e {

    /* renamed from: a */
    public List<ScanResult> f4450a;

    /* renamed from: b */
    private long f4451b;

    /* renamed from: c */
    private long f4452c;

    /* renamed from: d */
    private boolean f4453d = false;

    /* renamed from: e */
    private boolean f4454e;

    public C0997e(List<ScanResult> list, long j) {
        this.f4450a = null;
        this.f4451b = 0L;
        this.f4452c = 0L;
        this.f4451b = j;
        this.f4450a = list;
        this.f4452c = System.currentTimeMillis();
        m11641m();
    }

    /* renamed from: a */
    private boolean m11659a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    /* renamed from: b */
    private String m11655b(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* renamed from: m */
    private void m11641m() {
        /*
            r7 = this;
            int r0 = r7.m11664a()
            if (r0 > 0) goto L7
            return
        L7:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f4450a
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
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f4450a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r5 = r7.f4450a
            int r6 = r2 + 1
            java.lang.Object r5 = r5.get(r6)
            android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
            int r5 = r5.level
            if (r4 >= r5) goto L47
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f4450a
            java.lang.Object r3 = r3.get(r6)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f4450a
            java.lang.Object r5 = r4.get(r2)
            r4.set(r6, r5)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f4450a
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0997e.m11641m():void");
    }

    /* renamed from: a */
    public int m11664a() {
        List<ScanResult> list = this.f4450a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public String m11663a(int i) {
        return m11662a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0217 A[Catch: Exception -> 0x020f, Error -> 0x0212, TryCatch #0 {Exception -> 0x020f, blocks: (B:37:0x0087, B:43:0x00ad, B:49:0x00bf, B:51:0x00c6, B:56:0x0101, B:58:0x010d, B:61:0x0129, B:63:0x0146, B:65:0x014c, B:96:0x0205, B:91:0x01e3, B:53:0x00e4, B:55:0x00eb, B:100:0x0217, B:104:0x0229, B:107:0x023c, B:109:0x0242, B:111:0x0253, B:112:0x026b, B:114:0x0271, B:116:0x0279, B:120:0x029a, B:117:0x0284, B:119:0x0293, B:121:0x02a0, B:123:0x02a9, B:125:0x02c9, B:129:0x02d7, B:131:0x02dc, B:133:0x02e6, B:134:0x02ed), top: B:143:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf A[Catch: Exception -> 0x020f, Error -> 0x0212, TryCatch #0 {Exception -> 0x020f, blocks: (B:37:0x0087, B:43:0x00ad, B:49:0x00bf, B:51:0x00c6, B:56:0x0101, B:58:0x010d, B:61:0x0129, B:63:0x0146, B:65:0x014c, B:96:0x0205, B:91:0x01e3, B:53:0x00e4, B:55:0x00eb, B:100:0x0217, B:104:0x0229, B:107:0x023c, B:109:0x0242, B:111:0x0253, B:112:0x026b, B:114:0x0271, B:116:0x0279, B:120:0x029a, B:117:0x0284, B:119:0x0293, B:121:0x02a0, B:123:0x02a9, B:125:0x02c9, B:129:0x02d7, B:131:0x02dc, B:133:0x02e6, B:134:0x02ed), top: B:143:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4 A[Catch: Exception -> 0x020f, Error -> 0x0212, TryCatch #0 {Exception -> 0x020f, blocks: (B:37:0x0087, B:43:0x00ad, B:49:0x00bf, B:51:0x00c6, B:56:0x0101, B:58:0x010d, B:61:0x0129, B:63:0x0146, B:65:0x014c, B:96:0x0205, B:91:0x01e3, B:53:0x00e4, B:55:0x00eb, B:100:0x0217, B:104:0x0229, B:107:0x023c, B:109:0x0242, B:111:0x0253, B:112:0x026b, B:114:0x0271, B:116:0x0279, B:120:0x029a, B:117:0x0284, B:119:0x0293, B:121:0x02a0, B:123:0x02a9, B:125:0x02c9, B:129:0x02d7, B:131:0x02dc, B:133:0x02e6, B:134:0x02ed), top: B:143:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010d A[Catch: Exception -> 0x020f, Error -> 0x0212, TryCatch #0 {Exception -> 0x020f, blocks: (B:37:0x0087, B:43:0x00ad, B:49:0x00bf, B:51:0x00c6, B:56:0x0101, B:58:0x010d, B:61:0x0129, B:63:0x0146, B:65:0x014c, B:96:0x0205, B:91:0x01e3, B:53:0x00e4, B:55:0x00eb, B:100:0x0217, B:104:0x0229, B:107:0x023c, B:109:0x0242, B:111:0x0253, B:112:0x026b, B:114:0x0271, B:116:0x0279, B:120:0x029a, B:117:0x0284, B:119:0x0293, B:121:0x02a0, B:123:0x02a9, B:125:0x02c9, B:129:0x02d7, B:131:0x02dc, B:133:0x02e6, B:134:0x02ed), top: B:143:0x0087 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f8  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m11662a(int r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0997e.m11662a(int, boolean, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m11661a(long r20) {
        /*
            r19 = this;
            r0 = r19
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 1000(0x3e8, double:4.94E-321)
            r5 = 0
            r6 = 0
            r8 = 17
            if (r1 < r8) goto L1a
            long r8 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L13
            long r8 = r8 / r3
            goto L14
        L13:
            r8 = r6
        L14:
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 <= 0) goto L1b
            r1 = 1
            goto L1c
        L1a:
            r8 = r6
        L1b:
            r1 = 0
        L1c:
            if (r1 != 0) goto L1f
            return r5
        L1f:
            java.util.List<android.net.wifi.ScanResult> r10 = r0.f4450a
            if (r10 == 0) goto L7d
            int r10 = r10.size()
            if (r10 != 0) goto L2a
            goto L7d
        L2a:
            java.util.List<android.net.wifi.ScanResult> r10 = r0.f4450a
            int r10 = r10.size()
            r11 = 16
            if (r10 <= r11) goto L36
            r10 = 16
        L36:
            r12 = r6
            r14 = r12
            r11 = 0
        L39:
            if (r11 >= r10) goto L68
            java.util.List<android.net.wifi.ScanResult> r2 = r0.f4450a
            java.lang.Object r2 = r2.get(r11)
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2
            int r2 = r2.level
            if (r2 == 0) goto L63
            if (r1 == 0) goto L63
            java.util.List<android.net.wifi.ScanResult> r2 = r0.f4450a     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r2 = r2.get(r11)     // Catch: java.lang.Throwable -> L5b
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2     // Catch: java.lang.Throwable -> L5b
            long r6 = r2.timestamp     // Catch: java.lang.Throwable -> L5b
            long r6 = r8 - r6
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 / r17
            goto L5d
        L5b:
            r6 = 0
        L5d:
            long r12 = r12 + r6
            int r2 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r2 <= 0) goto L63
            r14 = r6
        L63:
            int r11 = r11 + 1
            r6 = 0
            goto L39
        L68:
            long r1 = (long) r10
            long r12 = r12 / r1
            long r14 = r14 * r3
            int r1 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r1 > 0) goto L7a
            long r12 = r12 * r3
            int r1 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r1 <= 0) goto L77
            goto L7a
        L77:
            r16 = 0
            goto L7c
        L7a:
            r16 = 1
        L7c:
            return r16
        L7d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0997e.m11661a(long):boolean");
    }

    /* renamed from: a */
    public boolean m11660a(C0997e c0997e) {
        List<ScanResult> list = this.f4450a;
        if (list == null || c0997e == null || c0997e.f4450a == null) {
            return false;
        }
        int size = (list.size() < c0997e.f4450a.size() ? this.f4450a : c0997e.f4450a).size();
        for (int i = 0; i < size; i++) {
            if (!this.f4450a.get(i).BSSID.equals(c0997e.f4450a.get(i).BSSID)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int m11657b(int i) {
        if (i <= 2400 || i >= 2500) {
            return (i <= 4900 || i >= 5900) ? 0 : 5;
        }
        return 2;
    }

    /* renamed from: b */
    public String m11658b() {
        try {
            return m11662a(C1016g.f4550N, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public boolean m11656b(C0997e c0997e) {
        List<ScanResult> list = this.f4450a;
        if (list == null || c0997e == null || c0997e.f4450a == null) {
            return false;
        }
        int size = (list.size() < c0997e.f4450a.size() ? this.f4450a : c0997e.f4450a).size();
        for (int i = 0; i < size; i++) {
            String str = this.f4450a.get(i).BSSID;
            int i2 = this.f4450a.get(i).level;
            String str2 = c0997e.f4450a.get(i).BSSID;
            int i3 = c0997e.f4450a.get(i).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public String m11654c() {
        try {
            return m11662a(C1016g.f4550N, true, false);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public String m11653c(int i) {
        if (m11664a() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.f4450a.size();
        if (size <= i) {
            i = size;
        }
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f4450a.get(i2).level != 0 && this.f4450a.get(i2).BSSID != null) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.f4450a.get(i2).BSSID.replace(":", ""));
                int i3 = this.f4450a.get(i2).level;
                if (i3 < 0) {
                    i3 = -i3;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i3)));
            }
        }
        if (z) {
            return null;
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public boolean m11652c(C0997e c0997e) {
        return C0998f.m11638a(c0997e, this);
    }

    /* renamed from: d */
    public String m11651d() {
        try {
            return m11663a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public String m11650d(int i) {
        if (i == 0 || m11664a() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.f4450a.size();
        if (size > C1016g.f4550N) {
            size = C1016g.f4550N;
        }
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if ((i2 & i) != 0 && this.f4450a.get(i4).BSSID != null) {
                stringBuffer.append(i3 == 0 ? "&ssid=" : "|");
                stringBuffer.append(this.f4450a.get(i4).BSSID.replace(":", ""));
                stringBuffer.append(";");
                stringBuffer.append(m11655b(this.f4450a.get(i4).SSID));
                i3++;
            }
            i2 <<= 1;
        }
        return stringBuffer.toString();
    }

    /* renamed from: e */
    public boolean m11649e() {
        return m11661a(C1016g.f4570ae);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m11648f() {
        /*
            r13 = this;
            java.util.List<android.net.wifi.ScanResult> r0 = r13.f4450a
            r1 = 0
            if (r0 == 0) goto L5d
            int r0 = r0.size()
            if (r0 != 0) goto Ld
            goto L5d
        Ld:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            r4 = 0
            if (r0 < r3) goto L23
            long r5 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L1c
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            goto L1d
        L1c:
            r5 = r1
        L1d:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 <= 0) goto L24
            r0 = 1
            goto L25
        L23:
            r5 = r1
        L24:
            r0 = 0
        L25:
            java.util.List<android.net.wifi.ScanResult> r3 = r13.f4450a
            int r3 = r3.size()
            r7 = 16
            if (r3 <= r7) goto L31
            r3 = 16
        L31:
            r7 = r1
        L32:
            if (r4 >= r3) goto L5c
            java.util.List<android.net.wifi.ScanResult> r9 = r13.f4450a
            java.lang.Object r9 = r9.get(r4)
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9
            int r9 = r9.level
            if (r9 == 0) goto L59
            if (r0 == 0) goto L59
            java.util.List<android.net.wifi.ScanResult> r9 = r13.f4450a     // Catch: java.lang.Throwable -> L53
            java.lang.Object r9 = r9.get(r4)     // Catch: java.lang.Throwable -> L53
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9     // Catch: java.lang.Throwable -> L53
            long r9 = r9.timestamp     // Catch: java.lang.Throwable -> L53
            long r9 = r5 - r9
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r9 / r11
            goto L54
        L53:
            r9 = r1
        L54:
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 <= 0) goto L59
            r7 = r9
        L59:
            int r4 = r4 + 1
            goto L32
        L5c:
            return r7
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0997e.m11648f():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m11647g() {
        /*
            r18 = this;
            r0 = r18
            java.util.List<android.net.wifi.ScanResult> r1 = r0.f4450a
            r2 = 0
            if (r1 == 0) goto L72
            int r1 = r1.size()
            if (r1 != 0) goto L10
            goto L72
        L10:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            r5 = 0
            if (r1 < r4) goto L26
            long r6 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L1f
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            goto L20
        L1f:
            r6 = r2
        L20:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L27
            r1 = 1
            goto L28
        L26:
            r6 = r2
        L27:
            r1 = 0
        L28:
            java.util.List<android.net.wifi.ScanResult> r4 = r0.f4450a
            int r4 = r4.size()
            r8 = 16
            if (r4 <= r8) goto L34
            r4 = 16
        L34:
            r8 = r2
            r10 = r8
            r12 = r10
        L37:
            r14 = 1
            if (r5 >= r4) goto L69
            java.util.List<android.net.wifi.ScanResult> r2 = r0.f4450a
            java.lang.Object r2 = r2.get(r5)
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2
            int r2 = r2.level
            if (r2 == 0) goto L64
            if (r1 == 0) goto L64
            java.util.List<android.net.wifi.ScanResult> r2 = r0.f4450a     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L5b
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2     // Catch: java.lang.Throwable -> L5b
            long r2 = r2.timestamp     // Catch: java.lang.Throwable -> L5b
            long r2 = r6 - r2
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r16
            goto L5d
        L5b:
            r2 = 0
        L5d:
            long r12 = r12 + r2
            long r8 = r8 + r14
            int r14 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r14 <= 0) goto L64
            r10 = r2
        L64:
            int r5 = r5 + 1
            r2 = 0
            goto L37
        L69:
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 <= 0) goto L71
            long r12 = r12 - r10
            long r8 = r8 - r14
            long r10 = r12 / r8
        L71:
            return r10
        L72:
            r1 = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p082e.C0997e.m11647g():long");
    }

    /* renamed from: h */
    public int m11646h() {
        for (int i = 0; i < m11664a(); i++) {
            int i2 = -this.f4450a.get(i).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: i */
    public boolean m11645i() {
        return this.f4453d;
    }

    /* renamed from: j */
    public boolean m11644j() {
        return System.currentTimeMillis() - this.f4452c > 0 && System.currentTimeMillis() - this.f4452c < 5000;
    }

    /* renamed from: k */
    public boolean m11643k() {
        return System.currentTimeMillis() - this.f4452c > 0 && System.currentTimeMillis() - this.f4452c < 5000;
    }

    /* renamed from: l */
    public boolean m11642l() {
        return System.currentTimeMillis() - this.f4452c > 0 && System.currentTimeMillis() - this.f4451b < 5000;
    }
}
