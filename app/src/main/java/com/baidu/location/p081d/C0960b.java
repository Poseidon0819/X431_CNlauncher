package com.baidu.location.p081d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.conn.ssl.TokenParser;
import org.jivesoftware.smackx.packet.DiscoverItems;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.location.d.b */
/* loaded from: classes.dex */
public final class C0960b {

    /* renamed from: a */
    private final C0969d f4237a;

    /* renamed from: b */
    private int f4238b;

    /* renamed from: c */
    private double f4239c;

    /* renamed from: d */
    private double f4240d;

    /* renamed from: e */
    private Long f4241e;

    /* renamed from: h */
    private final SQLiteDatabase f4244h;

    /* renamed from: i */
    private final SQLiteDatabase f4245i;

    /* renamed from: p */
    private boolean f4252p = false;

    /* renamed from: f */
    private final C0964c f4242f = new C0964c(this, true);

    /* renamed from: g */
    private final C0964c f4243g = new C0964c(this, false);

    /* renamed from: o */
    private StringBuffer f4251o = new StringBuffer();

    /* renamed from: j */
    private StringBuffer f4246j = null;

    /* renamed from: k */
    private StringBuffer f4247k = null;

    /* renamed from: l */
    private HashSet<Long> f4248l = new HashSet<>();

    /* renamed from: m */
    private ConcurrentHashMap<Long, Integer> f4249m = new ConcurrentHashMap<>();

    /* renamed from: n */
    private ConcurrentHashMap<Long, String> f4250n = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.b$a */
    /* loaded from: classes.dex */
    public static final class C0962a {

        /* renamed from: a */
        double f4254a;

        /* renamed from: b */
        double f4255b;

        /* renamed from: c */
        double f4256c;

        private C0962a(double d, double d2, double d3) {
            this.f4254a = d;
            this.f4255b = d2;
            this.f4256c = d3;
        }
    }

    /* renamed from: com.baidu.location.d.b$b */
    /* loaded from: classes.dex */
    class C0963b extends Thread {

        /* renamed from: a */
        private String f4257a;

        /* renamed from: c */
        private Long f4259c;

        /* renamed from: d */
        private BDLocation f4260d;

        /* renamed from: e */
        private BDLocation f4261e;

        /* renamed from: f */
        private BDLocation f4262f;

        /* renamed from: g */
        private String f4263g;

        /* renamed from: h */
        private LinkedHashMap<String, Integer> f4264h;

        private C0963b(String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.f4257a = str;
            this.f4259c = l;
            this.f4260d = bDLocation;
            this.f4261e = bDLocation2;
            this.f4262f = bDLocation3;
            this.f4263g = str2;
            this.f4264h = linkedHashMap;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                C0960b.this.m11902a(this.f4257a, this.f4259c, this.f4260d);
                C0960b.this.f4246j = null;
                C0960b.this.f4247k = null;
                C0960b.this.m11899a(this.f4264h);
                C0960b.this.m11912a(this.f4262f, this.f4260d, this.f4261e, this.f4257a, this.f4259c);
                if (this.f4263g != null) {
                    C0960b.this.f4237a.m11793j().m11775a(this.f4263g);
                }
            } catch (Exception unused) {
            }
            this.f4264h = null;
            this.f4257a = null;
            this.f4263g = null;
            this.f4259c = null;
            this.f4260d = null;
            this.f4261e = null;
            this.f4262f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.b$c */
    /* loaded from: classes.dex */
    public final class C0964c extends AbstractC1011e {

        /* renamed from: b */
        private String f4266b;

        /* renamed from: c */
        private final String f4267c;

        /* renamed from: d */
        private String f4268d;

        /* renamed from: e */
        private C0960b f4269e;

        /* renamed from: f */
        private boolean f4270f = false;

        /* renamed from: p */
        private int f4271p = 0;

        /* renamed from: q */
        private long f4272q = -1;

        /* renamed from: r */
        private long f4273r = -1;

        /* renamed from: s */
        private long f4274s = -1;

        /* renamed from: t */
        private long f4275t = -1;

        C0964c(C0960b c0960b, boolean z) {
            this.f4269e = c0960b;
            this.f4267c = z ? "load" : DiscoverItems.Item.UPDATE_ACTION;
            this.f4525k = new HashMap();
            this.f4266b = C0969d.f4310b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m11887a(String str, String str2, String str3) {
            this.f4268d = str3;
            this.f4266b = String.format("http://%s/%s", str, str2);
            m11578a(false, "ofloc.map.baidu.com");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m11884c() {
            this.f4271p++;
            this.f4272q = System.currentTimeMillis();
        }

        /* renamed from: f */
        private boolean m11883f() {
            if (this.f4271p < 2) {
                return true;
            }
            if (this.f4272q + 43200000 < System.currentTimeMillis()) {
                this.f4271p = 0;
                this.f4272q = -1L;
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m11882g() {
            /*
                r9 = this;
                r0 = 0
                r9.f4268d = r0
                boolean r0 = r9.m11877l()
                r1 = 86400000(0x5265c00, double:4.2687272E-316)
                r3 = -1
                if (r0 == 0) goto L22
                long r5 = r9.f4273r
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 == 0) goto L1d
                long r5 = r5 + r1
                long r7 = java.lang.System.currentTimeMillis()
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 > 0) goto L28
            L1d:
                java.lang.String r0 = r9.m11881h()
                goto L26
            L22:
                java.lang.String r0 = r9.m11880i()
            L26:
                r9.f4268d = r0
            L28:
                java.lang.String r0 = r9.f4268d
                if (r0 != 0) goto L56
                long r5 = r9.f4274s
                int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r0 == 0) goto L3b
                long r5 = r5 + r1
                long r0 = java.lang.System.currentTimeMillis()
                int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r2 > 0) goto L56
            L3b:
                com.baidu.location.d.b r0 = com.baidu.location.p081d.C0960b.this
                com.baidu.location.d.d r0 = com.baidu.location.p081d.C0960b.m11911a(r0)
                com.baidu.location.d.g r0 = r0.m11792k()
                boolean r0 = r0.m11770a()
                if (r0 == 0) goto L50
                java.lang.String r0 = r9.m11879j()
                goto L54
            L50:
                java.lang.String r0 = r9.m11878k()
            L54:
                r9.f4268d = r0
            L56:
                java.lang.String r0 = r9.f4268d
                if (r0 == 0) goto L5f
                java.lang.String r0 = "https://ofloc.map.baidu.com/offline_loc"
                r9.m11575c(r0)
            L5f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.C0964c.m11882g():void");
        }

        /* renamed from: h */
        private String m11881h() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put(VastExtensionXmlManager.TYPE, "0");
                jSONObject.put("cuid", C1006b.m11603a().f4496b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", C1006b.f4491e + ":" + C1006b.f4490d);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ec, code lost:
            if (r3 != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ee, code lost:
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0116, code lost:
            if (r3 == null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
            if (r2 != null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0123, code lost:
            r3 = r14.f4275t;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
            if (r3 == (-1)) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0137, code lost:
            r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r2.toString());
            r14.f4275t = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0145, code lost:
            if (r2 == null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0157, code lost:
            return com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r2.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:?, code lost:
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: i */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String m11880i() {
            /*
                Method dump skipped, instructions count: 344
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.C0964c.m11880i():java.lang.String");
        }

        /* renamed from: j */
        private String m11879j() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(VastExtensionXmlManager.TYPE, "2");
                    jSONObject.put("ver", "1");
                    jSONObject.put("cuid", C1006b.m11603a().f4496b);
                    jSONObject.put("prod", C1006b.f4491e + ":" + C1006b.f4490d);
                    this.f4274s = System.currentTimeMillis();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String m11878k() {
            /*
                r6 = this;
                r0 = 0
                com.baidu.location.d.b r1 = com.baidu.location.p081d.C0960b.this     // Catch: java.lang.Exception -> L58
                com.baidu.location.d.d r1 = com.baidu.location.p081d.C0960b.m11911a(r1)     // Catch: java.lang.Exception -> L58
                com.baidu.location.d.g r1 = r1.m11792k()     // Catch: java.lang.Exception -> L58
                org.json.JSONObject r1 = r1.m11763b()     // Catch: java.lang.Exception -> L58
                if (r1 == 0) goto L58
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L58
                r2.<init>()     // Catch: java.lang.Exception -> L58
                java.lang.String r3 = "type"
                java.lang.String r4 = "3"
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L59
                java.lang.String r3 = "ver"
                java.lang.String r4 = "1"
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L59
                java.lang.String r3 = "cuid"
                com.baidu.location.g.b r4 = com.baidu.location.p084g.C1006b.m11603a()     // Catch: java.lang.Exception -> L59
                java.lang.String r4 = r4.f4496b     // Catch: java.lang.Exception -> L59
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L59
                java.lang.String r3 = "prod"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L59
                r4.<init>()     // Catch: java.lang.Exception -> L59
                java.lang.String r5 = com.baidu.location.p084g.C1006b.f4491e     // Catch: java.lang.Exception -> L59
                r4.append(r5)     // Catch: java.lang.Exception -> L59
                java.lang.String r5 = ":"
                r4.append(r5)     // Catch: java.lang.Exception -> L59
                java.lang.String r5 = com.baidu.location.p084g.C1006b.f4490d     // Catch: java.lang.Exception -> L59
                r4.append(r5)     // Catch: java.lang.Exception -> L59
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L59
                r2.put(r3, r4)     // Catch: java.lang.Exception -> L59
                java.lang.String r3 = "rgc"
                r2.put(r3, r1)     // Catch: java.lang.Exception -> L59
                long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L59
                r6.f4274s = r3     // Catch: java.lang.Exception -> L59
                goto L59
            L58:
                r2 = r0
            L59:
                if (r2 == 0) goto L63
                java.lang.String r0 = r2.toString()
                java.lang.String r0 = com.baidu.location.Jni.encodeOfflineLocationUpdateRequest(r0)
            L63:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.C0964c.m11878k():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            if (r0.getInt(0) != 0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
            if (r0 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0061, code lost:
            if (r0 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
            return r1;
         */
        /* renamed from: l */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean m11877l() {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                com.baidu.location.d.b r2 = com.baidu.location.p081d.C0960b.this     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L59
                android.database.sqlite.SQLiteDatabase r2 = com.baidu.location.p081d.C0960b.m11895b(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L59
                java.lang.String r3 = "SELECT COUNT(*) FROM AP;"
                android.database.Cursor r2 = r2.rawQuery(r3, r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L59
                com.baidu.location.d.b r3 = com.baidu.location.p081d.C0960b.this     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                android.database.sqlite.SQLiteDatabase r3 = com.baidu.location.p081d.C0960b.m11895b(r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                java.lang.String r4 = "SELECT COUNT(*) FROM CL"
                android.database.Cursor r0 = r3.rawQuery(r4, r0)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                r3 = 0
                if (r2 == 0) goto L3b
                boolean r4 = r2.moveToFirst()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                if (r4 == 0) goto L3b
                if (r0 == 0) goto L3b
                boolean r4 = r0.moveToFirst()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                if (r4 == 0) goto L3b
                int r4 = r2.getInt(r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                if (r4 != 0) goto L37
                int r4 = r0.getInt(r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
                if (r4 == 0) goto L3b
            L37:
                r1 = 0
                goto L3b
            L39:
                goto L5a
            L3b:
                if (r2 == 0) goto L42
                r2.close()     // Catch: java.lang.Exception -> L41
                goto L42
            L41:
            L42:
                if (r0 == 0) goto L64
            L44:
                r0.close()     // Catch: java.lang.Exception -> L64
                goto L64
            L48:
                r1 = move-exception
                goto L4c
            L4a:
                r1 = move-exception
                r2 = r0
            L4c:
                if (r2 == 0) goto L53
                r2.close()     // Catch: java.lang.Exception -> L52
                goto L53
            L52:
            L53:
                if (r0 == 0) goto L58
                r0.close()     // Catch: java.lang.Exception -> L58
            L58:
                throw r1
            L59:
                r2 = r0
            L5a:
                if (r2 == 0) goto L61
                r2.close()     // Catch: java.lang.Exception -> L60
                goto L61
            L60:
            L61:
                if (r0 == 0) goto L64
                goto L44
            L64:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.C0964c.m11877l():boolean");
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public final void mo11391a() {
            this.f4270f = true;
            this.f4522h = this.f4266b;
            this.f4525k.clear();
            this.f4525k.put("qt", this.f4267c);
            this.f4525k.put("req", this.f4268d);
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.baidu.location.d.b$c$1] */
        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public final void mo11388a(boolean z) {
            if (z && this.f4524j != null) {
                new Thread() { // from class: com.baidu.location.d.b.c.1
                    /* JADX WARN: Removed duplicated region for block: B:121:0x03dc A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:123:0x03f9 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:125:0x0416 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:128:0x04c9 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:136:0x04fe A[Catch: Exception -> 0x053a, TryCatch #4 {Exception -> 0x053a, blocks: (B:134:0x04f4, B:136:0x04fe, B:138:0x050c, B:139:0x0517, B:141:0x0521, B:143:0x052f), top: B:185:0x04f4 }] */
                    /* JADX WARN: Removed duplicated region for block: B:141:0x0521 A[Catch: Exception -> 0x053a, TryCatch #4 {Exception -> 0x053a, blocks: (B:134:0x04f4, B:136:0x04fe, B:138:0x050c, B:139:0x0517, B:141:0x0521, B:143:0x052f), top: B:185:0x04f4 }] */
                    /* JADX WARN: Removed duplicated region for block: B:191:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0120 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0153 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:85:0x0255 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:87:0x0272 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:89:0x028f A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:91:0x02ac A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    /* JADX WARN: Removed duplicated region for block: B:96:0x02d9 A[Catch: all -> 0x009d, Exception -> 0x0544, TryCatch #7 {Exception -> 0x0544, blocks: (B:35:0x008d, B:39:0x00a2, B:41:0x00aa, B:43:0x00b8, B:45:0x00c3, B:47:0x00cb, B:49:0x00e2, B:51:0x00ea, B:54:0x0120, B:56:0x0128, B:57:0x014d, B:59:0x0153, B:63:0x0173, B:68:0x0188, B:75:0x01ca, B:78:0x01f7, B:81:0x0224, B:67:0x0185, B:72:0x01bd, B:71:0x01ba, B:62:0x0170, B:85:0x0255, B:87:0x0272, B:89:0x028f, B:91:0x02ac, B:93:0x02b4, B:94:0x02d3, B:96:0x02d9, B:100:0x02fe, B:105:0x031c, B:112:0x0367, B:115:0x038f, B:118:0x03b7, B:104:0x0315, B:110:0x035e, B:109:0x0359, B:99:0x02f7, B:121:0x03dc, B:123:0x03f9, B:125:0x0416, B:126:0x0431, B:128:0x04c9, B:130:0x04d1, B:132:0x04d9, B:133:0x04de), top: B:191:0x008d, outer: #8 }] */
                    @Override // java.lang.Thread, java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void run() {
                        /*
                            Method dump skipped, instructions count: 1520
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.C0964c.C09651.run():void");
                    }
                }.start();
                return;
            }
            this.f4270f = false;
            m11884c();
        }

        /* renamed from: b */
        final void m11886b() {
            if (!m11883f() || this.f4270f) {
                return;
            }
            C0960b.this.f4243g.m11882g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0960b(C0969d c0969d) {
        SQLiteDatabase sQLiteDatabase;
        this.f4237a = c0969d;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            File file = new File(this.f4237a.m11801c(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        this.f4244h = sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase3 = this.f4244h;
        if (sQLiteDatabase3 != null) {
            try {
                sQLiteDatabase3.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.f4244h.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception unused2) {
            }
        }
        try {
            File file2 = new File(this.f4237a.m11801c(), "ofl_statistics.db");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            sQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused3) {
        }
        this.f4245i = sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase4 = this.f4245i;
        if (sQLiteDatabase4 != null) {
            try {
                sQLiteDatabase4.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.f4245i.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception unused4) {
            }
        }
    }

    /* renamed from: a */
    private double m11913a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double radians = Math.toRadians(d);
        Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        double radians3 = Math.toRadians(d5);
        double radians4 = Math.toRadians(d6) / 2.0d;
        double d7 = radians3 / 2.0d;
        double sin = (Math.sin(radians4) * Math.sin(radians4)) + (Math.cos(radians) * Math.cos(radians2) * Math.sin(d7) * Math.sin(d7));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6378137.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[LOOP:0: B:6:0x000b->B:28:0x0092, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m11900a(java.util.ArrayList<com.baidu.location.p081d.C0960b.C0962a> r22, double r23) {
        /*
            r21 = this;
            r0 = r22
            int r1 = r22.size()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = 0
        Lb:
            int r3 = r22.size()
            r4 = 3
            r5 = 1
            if (r3 < r4) goto L8d
            r3 = 0
            r6 = r3
            r8 = r6
            r3 = 0
        L18:
            int r4 = r22.size()
            if (r3 >= r4) goto L33
            java.lang.Object r4 = r0.get(r3)
            com.baidu.location.d.b$a r4 = (com.baidu.location.p081d.C0960b.C0962a) r4
            double r10 = r4.f4254a
            double r6 = r6 + r10
            java.lang.Object r4 = r0.get(r3)
            com.baidu.location.d.b$a r4 = (com.baidu.location.p081d.C0960b.C0962a) r4
            double r10 = r4.f4255b
            double r8 = r8 + r10
            int r3 = r3 + 1
            goto L18
        L33:
            int r3 = r22.size()
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r3 = r6 / r3
            int r6 = r22.size()
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r6 = r8 / r6
            r8 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r10 = -1
            r19 = r8
            r8 = 0
            r9 = -1
        L4e:
            int r10 = r22.size()
            if (r8 >= r10) goto L79
            java.lang.Object r10 = r0.get(r8)
            com.baidu.location.d.b$a r10 = (com.baidu.location.p081d.C0960b.C0962a) r10
            double r13 = r10.f4255b
            java.lang.Object r10 = r0.get(r8)
            com.baidu.location.d.b$a r10 = (com.baidu.location.p081d.C0960b.C0962a) r10
            double r11 = r10.f4254a
            r10 = r21
            r17 = r11
            r11 = r6
            r15 = r13
            r13 = r3
            double r10 = r10.m11913a(r11, r13, r15, r17)
            int r12 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r12 <= 0) goto L76
            r9 = r8
            r19 = r10
        L76:
            int r8 = r8 + 1
            goto L4e
        L79:
            int r3 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r3 <= 0) goto L8d
            if (r9 < 0) goto L8d
            int r3 = r22.size()
            if (r9 >= r3) goto L8d
            int r1 = r1 + 1
            r0.remove(r9)
            r3 = r1
            r1 = 1
            goto L8f
        L8d:
            r3 = r1
            r1 = 0
        L8f:
            if (r1 == r5) goto L92
            return r3
        L92:
            r1 = r3
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.m11900a(java.util.ArrayList, double):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.BDLocation m11903a(java.lang.Long r20) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.m11903a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x02f8, code lost:
        if (m11913a(r16, r14, r20, r12) <= 10000.0d) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x031d, code lost:
        if (r33 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0337, code lost:
        if (r33 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0339, code lost:
        r33.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0327 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.BDLocation m11898a(java.util.LinkedHashMap<java.lang.String, java.lang.Integer> r39, com.baidu.location.BDLocation r40, int r41) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.m11898a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11912a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (bDLocation2 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && m11913a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
            String format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", l);
            String format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000);
            try {
                this.f4244h.execSQL(format);
                this.f4245i.execSQL(format2);
            } catch (Exception unused) {
            }
        }
        if (bDLocation3 == null || bDLocation.getNetworkLocationType() == null || !bDLocation.getNetworkLocationType().equals("wf") || m11913a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) <= 100.0d) {
            return;
        }
        try {
            String format3 = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", this.f4246j.toString());
            String format4 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", this.f4247k.toString());
            this.f4244h.execSQL(format3);
            this.f4245i.execSQL(format4);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11902a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            try {
                if (bDLocation != null) {
                    this.f4244h.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l));
                } else {
                    String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", l, str);
                    String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l);
                    this.f4245i.execSQL(format);
                    this.f4245i.execSQL(format2);
                }
            } catch (Exception unused) {
            }
            if (this.f4252p) {
                try {
                    this.f4245i.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000));
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11901a(String str, String str2, String str3) {
        this.f4242f.m11887a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11899a(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.f4246j = new StringBuffer();
        this.f4247k = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ConcurrentHashMap<Long, Integer> concurrentHashMap = this.f4249m;
        if (concurrentHashMap != null && concurrentHashMap.keySet() != null) {
            boolean z = true;
            boolean z2 = true;
            for (Long l : this.f4249m.keySet()) {
                try {
                    if (this.f4248l.contains(l)) {
                        if (z) {
                            z = false;
                        } else {
                            this.f4246j.append(',');
                            this.f4247k.append(',');
                        }
                        this.f4246j.append(l);
                        StringBuffer stringBuffer3 = this.f4247k;
                        stringBuffer3.append('(');
                        stringBuffer3.append(l);
                        stringBuffer3.append(',');
                        stringBuffer3.append(TokenParser.DQUOTE);
                        stringBuffer3.append(this.f4250n.get(l));
                        stringBuffer3.append(TokenParser.DQUOTE);
                        stringBuffer3.append(',');
                        stringBuffer3.append(100000);
                        stringBuffer3.append(')');
                    } else {
                        String str = this.f4250n.get(l);
                        if (z2) {
                            z2 = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer2.append(',');
                        }
                        stringBuffer.append(l);
                        stringBuffer2.append('(');
                        stringBuffer2.append(l);
                        stringBuffer2.append(',');
                        stringBuffer2.append(TokenParser.DQUOTE);
                        stringBuffer2.append(str);
                        stringBuffer2.append(TokenParser.DQUOTE);
                        stringBuffer2.append(",0)");
                    }
                } catch (Exception unused) {
                }
            }
        }
        try {
            this.f4244h.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", this.f4246j.toString()));
        } catch (Exception unused2) {
        }
        StringBuffer stringBuffer4 = this.f4251o;
        if (stringBuffer4 != null && stringBuffer4.length() > 0) {
            if (stringBuffer2.length() > 0) {
                stringBuffer2.append(",");
            }
            stringBuffer2.append(this.f4251o);
        }
        try {
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", stringBuffer2.toString());
            String format2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", stringBuffer.toString());
            if (stringBuffer2.length() > 0) {
                this.f4245i.execSQL(format);
            }
            if (stringBuffer.length() > 0) {
                this.f4245i.execSQL(format2);
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11897a(String[] strArr) {
        this.f4237a.m11791l().m11868a(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0104, code lost:
        if (r12 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010c, code lost:
        if (r12 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010e, code lost:
        r6 = r5;
        r4 = r12;
        r5 = r13;
     */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.baidu.location.d.b$1] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.Cursor m11904a(com.baidu.location.p081d.C0974e.C0975a r21) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0960b.m11904a(com.baidu.location.d.e$a):android.database.Cursor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final SQLiteDatabase m11914a() {
        return this.f4245i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m11896b() {
        this.f4243g.m11886b();
    }
}
