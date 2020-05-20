package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.android.bbalbs.common.p077a.C0859b;
import com.baidu.android.bbalbs.common.p077a.C0860c;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.cnlaunch.diagnosemodule.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.location.indoor.a */
/* loaded from: classes.dex */
public class C1017a extends AbstractC1011e {

    /* renamed from: a */
    private static HashMap<String, Long> f4617a = new HashMap<>();

    /* renamed from: d */
    private Context f4620d;

    /* renamed from: f */
    private String f4622f;

    /* renamed from: q */
    private InterfaceC1019a f4624q;

    /* renamed from: s */
    private Handler f4626s;

    /* renamed from: t */
    private Runnable f4627t;

    /* renamed from: b */
    private final String f4618b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";

    /* renamed from: c */
    private final SimpleDateFormat f4619c = new SimpleDateFormat("yyyyMM");

    /* renamed from: r */
    private String f4625r = null;

    /* renamed from: p */
    private HashSet<String> f4623p = new HashSet<>();

    /* renamed from: e */
    private boolean f4621e = false;

    /* renamed from: com.baidu.location.indoor.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1019a {
        /* renamed from: a */
        void m11535a(boolean z);
    }

    public C1017a(Context context) {
        this.f4620d = context;
        this.f4525k = new HashMap();
        this.f4626s = new Handler();
        this.f4627t = new Runnable() { // from class: com.baidu.location.indoor.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (C1017a.this.f4625r != null) {
                    C1017a c1017a = C1017a.this;
                    c1017a.f4622f = c1017a.f4625r;
                    C1017a.this.m11573e();
                }
            }
        };
    }

    /* renamed from: a */
    private String m11544a(Date date) {
        File file = new File(this.f4620d.getCacheDir(), C0860c.m12428a((this.f4622f + this.f4619c.format(date)).getBytes(), false));
        if (file.isFile()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine + "\n";
                }
                bufferedReader.close();
                if (!str.equals("")) {
                    return new String(C0859b.m12432a(str.getBytes()));
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return null;
    }

    /* renamed from: d */
    private void m11540d(String str) {
        for (String str2 : str.split(",")) {
            this.f4623p.add(str2.toLowerCase());
        }
    }

    /* renamed from: e */
    private void m11539e(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f4620d.getCacheDir(), C0860c.m12428a((this.f4622f + this.f4619c.format(new Date())).getBytes(), false)));
            fileWriter.write(C0859b.m12430a(str.getBytes(), "UTF-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: f */
    private Date m11538f() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        return calendar.getTime();
    }

    /* renamed from: f */
    private void m11537f(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f4620d.getCacheDir(), "buildings"), true);
            fileWriter.write(str + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m11536g() {
        try {
            Date m11538f = m11538f();
            File file = new File(this.f4620d.getCacheDir(), C0860c.m12428a((this.f4622f + this.f4619c.format(m11538f)).getBytes(), false));
            if (file.isFile()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.location.p084g.AbstractC1011e
    /* renamed from: a */
    public void mo11391a() {
        this.f4522h = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
        this.f4525k.clear();
        this.f4525k.put("bid", PrivacyItem.PrivacyRule.SUBSCRIPTION_NONE);
        this.f4525k.put("bldg", this.f4622f);
        this.f4525k.put("mb", Build.MODEL);
        this.f4525k.put("msdk", BuildConfig.VERSION_NAME);
        this.f4525k.put("cuid", C1006b.m11603a().f4496b);
        this.f4525k.put("anchors", "v1");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.location.p084g.AbstractC1011e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo11388a(boolean r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L48
            java.lang.String r6 = r5.f4524j
            if (r6 == 0) goto L48
            java.lang.String r6 = r5.f4524j     // Catch: java.lang.Exception -> L48
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L48
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Exception -> L48
            byte[] r6 = com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r6)     // Catch: java.lang.Exception -> L48
            r2.<init>(r6)     // Catch: java.lang.Exception -> L48
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Exception -> L48
            r6.<init>(r2)     // Catch: java.lang.Exception -> L48
            java.lang.String r2 = "anchorinfo"
            boolean r2 = r6.has(r2)     // Catch: java.lang.Exception -> L48
            if (r2 == 0) goto L48
            java.lang.String r2 = "anchorinfo"
            java.lang.String r6 = r6.optString(r2)     // Catch: java.lang.Exception -> L48
            if (r6 == 0) goto L48
            java.lang.String r2 = ""
            boolean r2 = r6.equals(r2)     // Catch: java.lang.Exception -> L48
            if (r2 != 0) goto L48
            java.util.HashSet<java.lang.String> r2 = r5.f4623p     // Catch: java.lang.Exception -> L48
            r2.clear()     // Catch: java.lang.Exception -> L48
            r5.m11540d(r6)     // Catch: java.lang.Exception -> L48
            r5.m11539e(r6)     // Catch: java.lang.Exception -> L48
            r5.m11536g()     // Catch: java.lang.Exception -> L46
        L46:
            r6 = 1
            goto L49
        L48:
            r6 = 0
        L49:
            if (r6 != 0) goto L5e
            java.lang.String r2 = r5.f4625r
            if (r2 != 0) goto L5e
            java.lang.String r0 = r5.f4622f
            r5.f4625r = r0
            android.os.Handler r0 = r5.f4626s
            java.lang.Runnable r2 = r5.f4627t
            r3 = 60000(0xea60, double:2.9644E-319)
            r0.postDelayed(r2, r3)
            goto L7f
        L5e:
            r2 = 0
            if (r6 == 0) goto L64
            r5.f4625r = r2
            goto L7f
        L64:
            java.lang.String r3 = r5.f4625r
            r5.m11537f(r3)
            r5.f4625r = r2
            java.util.Date r2 = r5.m11538f()
            java.lang.String r2 = r5.m11544a(r2)
            if (r2 == 0) goto L7f
            r5.m11540d(r2)
            com.baidu.location.indoor.a$a r2 = r5.f4624q
            if (r2 == 0) goto L7f
            r2.m11535a(r0)
        L7f:
            r5.f4621e = r1
            com.baidu.location.indoor.a$a r0 = r5.f4624q
            if (r0 == 0) goto L88
            r0.m11535a(r6)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C1017a.mo11388a(boolean):void");
    }

    /* renamed from: a */
    public boolean m11546a(String str) {
        String str2 = this.f4622f;
        return (str2 == null || !str2.equalsIgnoreCase(str) || this.f4623p.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public boolean m11545a(String str, InterfaceC1019a interfaceC1019a) {
        if (!this.f4621e) {
            this.f4624q = interfaceC1019a;
            this.f4621e = true;
            this.f4622f = str;
            try {
                String m11544a = m11544a(new Date());
                if (m11544a == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (f4617a.get(str) == null || currentTimeMillis - f4617a.get(str).longValue() > 86400000) {
                        f4617a.put(str, Long.valueOf(currentTimeMillis));
                        m11573e();
                    }
                } else {
                    m11540d(m11544a);
                    if (this.f4624q != null) {
                        this.f4624q.m11535a(true);
                    }
                    this.f4621e = false;
                }
            } catch (Exception unused) {
                this.f4621e = false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m11543b() {
        HashSet<String> hashSet = this.f4623p;
        return (hashSet == null || hashSet.isEmpty()) ? false : true;
    }

    /* renamed from: b */
    public boolean m11542b(String str) {
        HashSet<String> hashSet;
        return (this.f4622f == null || (hashSet = this.f4623p) == null || hashSet.isEmpty() || !this.f4623p.contains(str)) ? false : true;
    }

    /* renamed from: c */
    public void m11541c() {
        this.f4622f = null;
        this.f4623p.clear();
    }
}
