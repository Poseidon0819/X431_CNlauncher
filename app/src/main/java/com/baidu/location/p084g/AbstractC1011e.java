package com.baidu.location.p084g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.location.ServiceC1002f;
import java.util.Map;

/* renamed from: com.baidu.location.g.e */
/* loaded from: classes.dex */
public abstract class AbstractC1011e {

    /* renamed from: h */
    public String f4522h = null;

    /* renamed from: i */
    public int f4523i = 3;

    /* renamed from: j */
    public String f4524j = null;

    /* renamed from: k */
    public Map<String, Object> f4525k = null;

    /* renamed from: l */
    public String f4526l = null;

    /* renamed from: m */
    public byte[] f4527m = null;

    /* renamed from: n */
    public String f4528n = null;

    /* renamed from: g */
    public static int f4520g = C1005a.f4487g;

    /* renamed from: a */
    private static String f4518a = "10.0.0.172";

    /* renamed from: b */
    private static int f4519b = 80;

    /* renamed from: o */
    protected static int f4521o = 0;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        if (r1.equals("null") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
        if (r1.equals("null") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:
        if ("10.0.0.200".equals(r1.trim()) != false) goto L23;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m11580a(android.content.Context r1, android.net.NetworkInfo r2) {
        /*
            if (r2 == 0) goto L88
            java.lang.String r1 = r2.getExtraInfo()
            if (r1 == 0) goto L88
            java.lang.String r1 = r2.getExtraInfo()
            java.lang.String r1 = r1.toLowerCase()
            if (r1 == 0) goto L88
            java.lang.String r2 = "cmwap"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L71
            java.lang.String r2 = "uniwap"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L71
            java.lang.String r2 = "3gwap"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L2b
            goto L71
        L2b:
            java.lang.String r2 = "ctwap"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L4e
            java.lang.String r1 = android.net.Proxy.getDefaultHost()
            if (r1 == 0) goto Laf
            java.lang.String r2 = ""
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto Laf
            java.lang.String r2 = "null"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto Laf
        L49:
            com.baidu.location.p084g.AbstractC1011e.f4518a = r1
            int r1 = com.baidu.location.p084g.C1005a.f4484d
            return r1
        L4e:
            java.lang.String r2 = "cmnet"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L6e
            java.lang.String r2 = "uninet"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L6e
            java.lang.String r2 = "ctnet"
            boolean r2 = r1.startsWith(r2)
            if (r2 != 0) goto L6e
            java.lang.String r2 = "3gnet"
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L88
        L6e:
            int r1 = com.baidu.location.p084g.C1005a.f4485e
            return r1
        L71:
            java.lang.String r1 = android.net.Proxy.getDefaultHost()
            if (r1 == 0) goto La0
            java.lang.String r2 = ""
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto La0
            java.lang.String r2 = "null"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto La0
            goto L49
        L88:
            java.lang.String r1 = android.net.Proxy.getDefaultHost()
            if (r1 == 0) goto Lb2
            int r2 = r1.length()
            if (r2 <= 0) goto Lb2
            java.lang.String r2 = "10.0.0.172"
            java.lang.String r0 = r1.trim()
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto La3
        La0:
            java.lang.String r1 = "10.0.0.172"
            goto L49
        La3:
            java.lang.String r2 = "10.0.0.200"
            java.lang.String r1 = r1.trim()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Lb2
        Laf:
            java.lang.String r1 = "10.0.0.200"
            goto L49
        Lb2:
            int r1 = com.baidu.location.p084g.C1005a.f4485e
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.AbstractC1011e.m11580a(android.content.Context, android.net.NetworkInfo):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11577b() {
        f4520g = m11576c();
    }

    /* renamed from: c */
    private int m11576c() {
        Context serviceContext = ServiceC1002f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return C1005a.f4487g;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    return (defaultHost == null || defaultHost.length() <= 0) ? C1005a.f4486f : C1005a.f4488h;
                }
                return m11580a(serviceContext, activeNetworkInfo);
            }
            return C1005a.f4487g;
        } catch (Exception unused) {
            return C1005a.f4487g;
        }
    }

    /* renamed from: a */
    public abstract void mo11391a();

    /* renamed from: a */
    public abstract void mo11388a(boolean z);

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$2] */
    /* renamed from: a */
    public void m11578a(final boolean z, final String str) {
        new Thread() { // from class: com.baidu.location.g.e.2
            /* JADX WARN: Removed duplicated region for block: B:105:0x01e5 A[LOOP:0: B:3:0x0018->B:105:0x01e5, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:109:0x01ee  */
            /* JADX WARN: Removed duplicated region for block: B:132:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:146:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:150:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:165:0x0219 A[EDGE_INSN: B:165:0x0219->B:123:0x0219 ?: BREAK  , SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 555
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.AbstractC1011e.C10132.run():void");
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$3] */
    /* renamed from: c */
    public void m11575c(final String str) {
        new Thread() { // from class: com.baidu.location.g.e.3
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x01d5: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:110:0x01d5 */
            /* JADX WARN: Removed duplicated region for block: B:107:0x01d0 A[Catch: Exception -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0137, blocks: (B:56:0x0133, B:90:0x0193, B:107:0x01d0), top: B:131:0x0012 }] */
            /* JADX WARN: Removed duplicated region for block: B:112:0x01d8  */
            /* JADX WARN: Removed duplicated region for block: B:127:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:134:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:136:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:138:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:141:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:143:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:145:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0174  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0193 A[Catch: Exception -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0137, blocks: (B:56:0x0133, B:90:0x0193, B:107:0x01d0), top: B:131:0x0012 }] */
            /* JADX WARN: Removed duplicated region for block: B:97:0x01b1  */
            /* JADX WARN: Type inference failed for: r5v21 */
            /* JADX WARN: Type inference failed for: r5v24 */
            /* JADX WARN: Type inference failed for: r5v5, types: [java.io.OutputStream] */
            /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
            /* JADX WARN: Type inference failed for: r6v0, types: [java.io.ByteArrayOutputStream] */
            /* JADX WARN: Type inference failed for: r6v1 */
            /* JADX WARN: Type inference failed for: r6v10 */
            /* JADX WARN: Type inference failed for: r6v11 */
            /* JADX WARN: Type inference failed for: r6v13 */
            /* JADX WARN: Type inference failed for: r6v14, types: [java.io.ByteArrayOutputStream] */
            /* JADX WARN: Type inference failed for: r6v15 */
            /* JADX WARN: Type inference failed for: r6v16 */
            /* JADX WARN: Type inference failed for: r6v17 */
            /* JADX WARN: Type inference failed for: r6v18 */
            /* JADX WARN: Type inference failed for: r6v19 */
            /* JADX WARN: Type inference failed for: r6v2 */
            /* JADX WARN: Type inference failed for: r6v20 */
            /* JADX WARN: Type inference failed for: r6v22, types: [java.io.ByteArrayOutputStream] */
            /* JADX WARN: Type inference failed for: r6v3 */
            /* JADX WARN: Type inference failed for: r6v4, types: [java.io.ByteArrayOutputStream] */
            /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ByteArrayOutputStream] */
            /* JADX WARN: Type inference failed for: r6v9 */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 516
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.AbstractC1011e.C10143.run():void");
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.g.e$1] */
    /* renamed from: d */
    public void m11574d() {
        new Thread() { // from class: com.baidu.location.g.e.1
            /* JADX WARN: Removed duplicated region for block: B:106:0x010e A[EDGE_INSN: B:106:0x010e->B:77:0x010e ?: BREAK  , SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x00ed A[LOOP:0: B:3:0x0018->B:61:0x00ed, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:65:0x00f6  */
            /* JADX WARN: Removed duplicated region for block: B:85:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:91:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 288
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p084g.AbstractC1011e.C10121.run():void");
            }
        }.start();
    }

    /* renamed from: e */
    public void m11573e() {
        m11578a(false, "loc.map.baidu.com");
    }
}
