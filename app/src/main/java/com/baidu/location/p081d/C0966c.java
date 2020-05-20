package com.baidu.location.p081d;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.Meta;
import com.itextpdf.text.html.HtmlTags;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.location.d.c */
/* loaded from: classes.dex */
public final class C0966c {

    /* renamed from: a */
    private final C0969d f4277a;

    /* renamed from: b */
    private final SQLiteDatabase f4278b;

    /* renamed from: u */
    private boolean f4297u = true;

    /* renamed from: v */
    private long f4298v = 8000;

    /* renamed from: w */
    private long f4299w = 5000;

    /* renamed from: x */
    private long f4300x = 5000;

    /* renamed from: y */
    private long f4301y = 5000;

    /* renamed from: z */
    private long f4302z = 5000;

    /* renamed from: d */
    private boolean f4280d = false;

    /* renamed from: e */
    private boolean f4281e = false;

    /* renamed from: f */
    private boolean f4282f = false;

    /* renamed from: g */
    private boolean f4283g = false;

    /* renamed from: h */
    private boolean f4284h = false;

    /* renamed from: j */
    private boolean f4286j = false;

    /* renamed from: k */
    private boolean f4287k = false;

    /* renamed from: l */
    private int f4288l = 6;

    /* renamed from: m */
    private int f4289m = 30;

    /* renamed from: n */
    private int f4290n = 30;

    /* renamed from: o */
    private double f4291o = 0.0d;

    /* renamed from: p */
    private double f4292p = 0.0d;

    /* renamed from: q */
    private double f4293q = 0.0d;

    /* renamed from: r */
    private double f4294r = 0.0d;

    /* renamed from: s */
    private double f4295s = 0.0d;

    /* renamed from: t */
    private int f4296t = 8;

    /* renamed from: i */
    private String[] f4285i = new String[0];

    /* renamed from: c */
    private final C0968a f4279c = new C0968a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.c$a */
    /* loaded from: classes.dex */
    public final class C0968a extends AbstractC1011e {

        /* renamed from: b */
        private int f4304b;

        /* renamed from: c */
        private long f4305c;

        /* renamed from: d */
        private long f4306d;

        /* renamed from: e */
        private boolean f4307e;

        /* renamed from: f */
        private final String f4308f;

        private C0968a() {
            this.f4304b = 0;
            this.f4307e = false;
            this.f4305c = -1L;
            this.f4306d = -1L;
            this.f4525k = new HashMap();
            this.f4308f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", "1", C1006b.m11603a().f4496b, C1006b.f4491e, C1006b.f4490d, Float.valueOf(7.51f), Build.MODEL, Build.VERSION.SDK));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m11812b() {
            if (this.f4307e) {
                return;
            }
            boolean z = false;
            try {
                File file = new File(C0966c.this.f4277a.m11801c(), "ofl.config");
                if (this.f4306d == -1 && file.exists()) {
                    Scanner scanner = new Scanner(file);
                    String next = scanner.next();
                    scanner.close();
                    JSONObject jSONObject = new JSONObject(next);
                    C0966c.this.f4280d = jSONObject.getBoolean(HtmlTags.f19631OL);
                    C0966c.this.f4281e = jSONObject.getBoolean("fl");
                    C0966c.this.f4282f = jSONObject.getBoolean("on");
                    C0966c.this.f4283g = jSONObject.getBoolean("wn");
                    C0966c.this.f4284h = jSONObject.getBoolean("oc");
                    this.f4306d = jSONObject.getLong("t");
                    if (jSONObject.has(HtmlTags.f19631OL)) {
                        C0966c.this.f4287k = jSONObject.getBoolean("olv2");
                    }
                    if (jSONObject.has("cplist")) {
                        C0966c.this.f4285i = jSONObject.getString("cplist").split(";");
                    }
                    if (jSONObject.has("rgcgp")) {
                        C0966c.this.f4288l = jSONObject.getInt("rgcgp");
                    }
                    if (jSONObject.has("rgcon")) {
                        C0966c.this.f4286j = jSONObject.getBoolean("rgcon");
                    }
                    if (jSONObject.has("addrup")) {
                        C0966c.this.f4290n = jSONObject.getInt("addrup");
                    }
                    if (jSONObject.has("poiup")) {
                        C0966c.this.f4289m = jSONObject.getInt("poiup");
                    }
                    if (jSONObject.has("oflp")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("oflp");
                        if (jSONObject2.has("0")) {
                            C0966c.this.f4291o = jSONObject2.getDouble("0");
                        }
                        if (jSONObject2.has("1")) {
                            C0966c.this.f4292p = jSONObject2.getDouble("1");
                        }
                        if (jSONObject2.has("2")) {
                            C0966c.this.f4293q = jSONObject2.getDouble("2");
                        }
                        if (jSONObject2.has("3")) {
                            C0966c.this.f4294r = jSONObject2.getDouble("3");
                        }
                        if (jSONObject2.has("4")) {
                            C0966c.this.f4295s = jSONObject2.getDouble("4");
                        }
                    }
                    if (jSONObject.has("onlt")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("onlt");
                        if (jSONObject3.has("0")) {
                            C0966c.this.f4302z = jSONObject3.getLong("0");
                        }
                        if (jSONObject3.has("1")) {
                            C0966c.this.f4301y = jSONObject3.getLong("1");
                        }
                        if (jSONObject3.has("2")) {
                            C0966c.this.f4298v = jSONObject3.getLong("2");
                        }
                        if (jSONObject3.has("3")) {
                            C0966c.this.f4299w = jSONObject3.getLong("3");
                        }
                        if (jSONObject3.has("4")) {
                            C0966c.this.f4300x = jSONObject3.getLong("4");
                        }
                    }
                    if (jSONObject.has("minapn")) {
                        C0966c.this.f4296t = jSONObject.getInt("minapn");
                    }
                }
                if (this.f4306d == -1) {
                    file.exists();
                }
                if (this.f4306d != -1) {
                    if (this.f4306d + 86400000 <= System.currentTimeMillis()) {
                        z = true;
                    }
                }
            } catch (Exception unused) {
            }
            if ((this.f4306d == -1 || z) && m11811c() && C1016g.m11571a(C0966c.this.f4277a.m11804b())) {
                this.f4307e = true;
                m11575c("https://ofloc.map.baidu.com/offline_loc");
            }
        }

        /* renamed from: c */
        private boolean m11811c() {
            if (this.f4304b < 2) {
                return true;
            }
            if (this.f4305c + 86400000 < System.currentTimeMillis()) {
                this.f4304b = 0;
                this.f4305c = -1L;
                return true;
            }
            return false;
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public final void mo11391a() {
            this.f4525k.clear();
            this.f4525k.put("qt", "conf");
            this.f4525k.put("req", this.f4308f);
            this.f4522h = C0969d.f4310b;
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public final void mo11388a(boolean z) {
            if (z && this.f4524j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f4524j);
                    long j = jSONObject.has("ofl") ? jSONObject.getLong("ofl") : 0L;
                    String string = jSONObject.has("ver") ? jSONObject.getString("ver") : "1";
                    if ((j & 1) == 1) {
                        C0966c.this.f4280d = true;
                    }
                    if ((j & 2) == 2) {
                        C0966c.this.f4281e = true;
                    }
                    if ((j & 4) == 4) {
                        C0966c.this.f4282f = true;
                    }
                    if ((j & 8) == 8) {
                        C0966c.this.f4283g = true;
                    }
                    if ((j & 16) == 16) {
                        C0966c.this.f4284h = true;
                    }
                    if ((j & 32) == 32) {
                        C0966c.this.f4286j = true;
                    }
                    if ((j & 64) == 64) {
                        C0966c.this.f4287k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        C0966c.this.f4285i = jSONObject.getString("cplist").split(";");
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        C0966c.this.m11868a(jSONObject.getString("bklist").split(";"));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("para");
                        if (jSONObject3.has("rgcgp")) {
                            C0966c.this.f4288l = jSONObject3.getInt("rgcgp");
                        }
                        if (jSONObject3.has("addrup")) {
                            C0966c.this.f4290n = jSONObject3.getInt("addrup");
                        }
                        if (jSONObject3.has("poiup")) {
                            C0966c.this.f4289m = jSONObject3.getInt("poiup");
                        }
                        if (jSONObject3.has("oflp")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("oflp");
                            if (jSONObject4.has("0")) {
                                C0966c.this.f4291o = jSONObject4.getDouble("0");
                            }
                            if (jSONObject4.has("1")) {
                                C0966c.this.f4292p = jSONObject4.getDouble("1");
                            }
                            if (jSONObject4.has("2")) {
                                C0966c.this.f4293q = jSONObject4.getDouble("2");
                            }
                            if (jSONObject4.has("3")) {
                                C0966c.this.f4294r = jSONObject4.getDouble("3");
                            }
                            if (jSONObject4.has("4")) {
                                C0966c.this.f4295s = jSONObject4.getDouble("4");
                            }
                        }
                        if (jSONObject3.has("onlt")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("onlt");
                            if (jSONObject5.has("0")) {
                                C0966c.this.f4302z = jSONObject5.getLong("0");
                            }
                            if (jSONObject5.has("1")) {
                                C0966c.this.f4301y = jSONObject5.getLong("1");
                            }
                            if (jSONObject5.has("2")) {
                                C0966c.this.f4298v = jSONObject5.getLong("2");
                            }
                            if (jSONObject5.has("3")) {
                                C0966c.this.f4299w = jSONObject5.getLong("3");
                            }
                            if (jSONObject5.has("4")) {
                                C0966c.this.f4300x = jSONObject5.getLong("4");
                            }
                        }
                        if (jSONObject3.has("minapn")) {
                            C0966c.this.f4296t = jSONObject3.getInt("minapn");
                        }
                    }
                    jSONObject2.put(HtmlTags.f19631OL, C0966c.this.f4280d);
                    jSONObject2.put("olv2", C0966c.this.f4287k);
                    jSONObject2.put("fl", C0966c.this.f4281e);
                    jSONObject2.put("on", C0966c.this.f4282f);
                    jSONObject2.put("wn", C0966c.this.f4283g);
                    jSONObject2.put("oc", C0966c.this.f4284h);
                    this.f4306d = System.currentTimeMillis();
                    jSONObject2.put("t", this.f4306d);
                    jSONObject2.put("ver", string);
                    jSONObject2.put("rgcon", C0966c.this.f4286j);
                    jSONObject2.put("rgcgp", C0966c.this.f4288l);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("0", C0966c.this.f4291o);
                    jSONObject6.put("1", C0966c.this.f4292p);
                    jSONObject6.put("2", C0966c.this.f4293q);
                    jSONObject6.put("3", C0966c.this.f4294r);
                    jSONObject6.put("4", C0966c.this.f4295s);
                    jSONObject2.put("oflp", jSONObject6);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("0", C0966c.this.f4302z);
                    jSONObject7.put("1", C0966c.this.f4301y);
                    jSONObject7.put("2", C0966c.this.f4298v);
                    jSONObject7.put("3", C0966c.this.f4299w);
                    jSONObject7.put("4", C0966c.this.f4300x);
                    jSONObject2.put("onlt", jSONObject7);
                    jSONObject2.put("addrup", C0966c.this.f4290n);
                    jSONObject2.put("poiup", C0966c.this.f4289m);
                    jSONObject2.put("minapn", C0966c.this.f4296t);
                    File file = new File(C0966c.this.f4277a.m11801c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception unused) {
                }
                this.f4307e = false;
            }
            this.f4304b++;
            this.f4305c = System.currentTimeMillis();
            this.f4307e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0966c(C0969d c0969d, SQLiteDatabase sQLiteDatabase) {
        this.f4277a = c0969d;
        this.f4278b = sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.f4278b;
        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
            try {
                this.f4278b.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception unused) {
            }
        }
        m11841g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m11876a() {
        return this.f4296t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final long m11869a(String str) {
        if (str.equals("2G")) {
            return this.f4298v;
        }
        if (str.equals("3G")) {
            return this.f4299w;
        }
        if (str.equals("4G")) {
            return this.f4300x;
        }
        if (str.equals("WIFI")) {
            return this.f4301y;
        }
        if (str.equals(Meta.UNKNOWN)) {
            return this.f4302z;
        }
        return 5000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m11868a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        SQLiteDatabase sQLiteDatabase = this.f4278b;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || stringBuffer.length() <= 0) {
            return;
        }
        try {
            this.f4278b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", stringBuffer.toString()));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final double m11867b() {
        return this.f4291o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final double m11861c() {
        return this.f4292p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final double m11855d() {
        return this.f4293q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final double m11849e() {
        return this.f4294r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final double m11844f() {
        return this.f4295s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final void m11841g() {
        this.f4279c.m11812b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean m11838h() {
        return this.f4280d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final boolean m11836i() {
        return this.f4282f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final boolean m11834j() {
        return this.f4283g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final boolean m11832k() {
        return this.f4281e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final boolean m11830l() {
        return this.f4286j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final boolean m11828m() {
        return this.f4297u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final int m11826n() {
        return this.f4288l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final String[] m11824o() {
        return this.f4285i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final int m11822p() {
        return this.f4290n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public final int m11820q() {
        return this.f4289m;
    }
}
