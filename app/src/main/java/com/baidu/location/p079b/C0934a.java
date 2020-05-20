package com.baidu.location.p079b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.bbalbs.common.p077a.C0859b;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.ColumnText;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.baidu.location.b.a */
/* loaded from: classes.dex */
public class C0934a {

    /* renamed from: b */
    private static Object f4124b = new Object();

    /* renamed from: c */
    private static C0934a f4125c = null;

    /* renamed from: d */
    private static final String f4126d = C1016g.m11549h() + "/gal.db";

    /* renamed from: e */
    private SQLiteDatabase f4128e = null;

    /* renamed from: f */
    private boolean f4129f = false;

    /* renamed from: a */
    C0935a f4127a = null;

    /* renamed from: g */
    private String f4130g = null;

    /* renamed from: h */
    private double f4131h = Double.MAX_VALUE;

    /* renamed from: i */
    private double f4132i = Double.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.a$a */
    /* loaded from: classes.dex */
    public class C0935a extends AbstractC1011e {

        /* renamed from: a */
        int f4133a;

        /* renamed from: b */
        int f4134b;

        /* renamed from: c */
        int f4135c;

        /* renamed from: d */
        int f4136d;

        /* renamed from: e */
        double f4137e;

        C0935a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            String str;
            this.f4522h = "http://loc.map.baidu.com/gpsz";
            String format = String.format(Locale.CHINESE, "&x=%d&y=%d%s", Integer.valueOf(this.f4133a), Integer.valueOf(this.f4134b), C1006b.m11603a().m11597c());
            String encode = Jni.encode(format);
            if (!encode.contains("err!")) {
                this.f4525k.put("gpsz", encode);
                return;
            }
            try {
                str = C0859b.m12430a(format.toString().getBytes(), "UTF-8");
            } catch (Exception unused) {
                str = "err2!";
            }
            this.f4525k.put("gpszb", str);
        }

        /* renamed from: a */
        public void m12018a(double d, double d2, double d3) {
            if (C0934a.this.f4129f) {
                return;
            }
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
            this.f4133a = (int) Math.floor(coorEncrypt[0] * 100.0d);
            this.f4134b = (int) Math.floor(coorEncrypt[1] * 100.0d);
            this.f4135c = (int) Math.floor(d * 100.0d);
            this.f4136d = (int) Math.floor(d2 * 100.0d);
            this.f4137e = d3;
            C0934a.this.f4129f = true;
            m11573e();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:16|(2:18|(7:20|21|22|23|24|(2:26|27)(1:29)|28)(2:32|(6:34|22|23|24|(0)(0)|28)))|35|21|22|23|24|(0)(0)|28) */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ff A[Catch: Exception -> 0x010f, TRY_LEAVE, TryCatch #0 {Exception -> 0x010f, blocks: (B:27:0x00dd, B:29:0x00ff), top: B:39:0x00dd }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x010f A[SYNTHETIC] */
        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo11388a(boolean r18) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p079b.C0934a.C0935a.mo11388a(boolean):void");
        }
    }

    /* renamed from: a */
    public static C0934a m12027a() {
        C0934a c0934a;
        synchronized (f4124b) {
            if (f4125c == null) {
                f4125c = new C0934a();
            }
            c0934a = f4125c;
        }
        return c0934a;
    }

    /* renamed from: a */
    private void m12025a(double d, double d2, double d3) {
        if (this.f4127a == null) {
            this.f4127a = new C0935a();
        }
        this.f4127a.m12018a(d, d2, d3);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double m12026a(double r13, double r15) {
        /*
            r12 = this;
            r8 = r12
            android.database.sqlite.SQLiteDatabase r0 = r8.f4128e
            r9 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            if (r0 == 0) goto Lcf
            r0 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto Lcf
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 <= 0) goto Lcf
            java.util.Locale r0 = java.util.Locale.CHINESE
            java.lang.String r1 = "%d,%d"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r13 * r4
            double r6 = java.lang.Math.floor(r6)
            int r6 = (int) r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r3] = r6
            double r3 = r15 * r4
            double r3 = java.lang.Math.floor(r3)
            int r3 = (int) r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 1
            r2[r4] = r3
            java.lang.String r0 = java.lang.String.format(r0, r1, r2)
            java.lang.String r1 = r8.f4130g
            if (r1 == 0) goto L4e
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L4e
            double r9 = r8.f4131h
            goto Lcf
        L4e:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r8.f4128e     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            java.lang.String r5 = "select * from galdata_new where id = \""
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            java.lang.String r5 = "\";"
            r3.append(r5)     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            android.database.Cursor r11 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> Lc3 java.lang.Exception -> Lcb
            if (r11 == 0) goto Lac
            boolean r1 = r11.moveToFirst()     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            if (r1 == 0) goto Lac
            double r1 = r11.getDouble(r4)     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            r3 = 3
            int r3 = r11.getInt(r3)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lc1
            r4 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L83
            goto L84
        L83:
            r9 = r1
        L84:
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            r4 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r4
            long r3 = (long) r3     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            long r1 = r1 - r3
            boolean r3 = r8.f4129f     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            if (r3 != 0) goto La3
            r3 = 604800(0x93a80, double:2.98811E-318)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto La3
            r6 = 4620141526985474048(0x401e0a3d80000000, double:7.510000228881836)
            r1 = r12
            r2 = r13
            r4 = r15
            r1.m12025a(r2, r4, r6)     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
        La3:
            r8.f4130g = r0     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            r8.f4131h = r9     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            goto Lbb
        La8:
            goto Lcc
        Laa:
            r9 = r1
            goto Lcc
        Lac:
            boolean r0 = r8.f4129f     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
            if (r0 != 0) goto Lbb
            r6 = 4620141526985474048(0x401e0a3d80000000, double:7.510000228881836)
            r1 = r12
            r2 = r13
            r4 = r15
            r1.m12025a(r2, r4, r6)     // Catch: java.lang.Exception -> La8 java.lang.Throwable -> Lc1
        Lbb:
            if (r11 == 0) goto Lcf
        Lbd:
            r11.close()     // Catch: java.lang.Exception -> Lcf
            goto Lcf
        Lc1:
            r0 = move-exception
            goto Lc5
        Lc3:
            r0 = move-exception
            r11 = r1
        Lc5:
            if (r11 == 0) goto Lca
            r11.close()     // Catch: java.lang.Exception -> Lca
        Lca:
            throw r0
        Lcb:
            r11 = r1
        Lcc:
            if (r11 == 0) goto Lcf
            goto Lbd
        Lcf:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p079b.C0934a.m12026a(double, double):double");
    }

    /* renamed from: a */
    public int m12024a(BDLocation bDLocation) {
        double d;
        float f;
        if (bDLocation != null) {
            f = bDLocation.getRadius();
            d = bDLocation.getAltitude();
        } else {
            d = 0.0d;
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.f4128e != null && f > ColumnText.GLOBAL_SPACE_CHAR_RATIO && d > 0.0d) {
            double m12026a = m12026a(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (m12026a != Double.MAX_VALUE) {
                double gpsSwiftRadius = Jni.getGpsSwiftRadius(f, d, m12026a);
                if (gpsSwiftRadius > 50.0d) {
                    return 3;
                }
                return gpsSwiftRadius > 20.0d ? 2 : 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public void m12021b() {
        SQLiteDatabase sQLiteDatabase;
        String str;
        try {
            File file = new File(f4126d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f4128e = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                Cursor rawQuery = this.f4128e.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    if (rawQuery.getInt(0) == 0) {
                        sQLiteDatabase = this.f4128e;
                        str = "CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    } else {
                        this.f4128e.execSQL("DROP TABLE galdata");
                        sQLiteDatabase = this.f4128e;
                        str = "CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);";
                    }
                    sQLiteDatabase.execSQL(str);
                }
                this.f4128e.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception unused) {
            this.f4128e = null;
        }
    }

    /* renamed from: c */
    public void m12019c() {
        SQLiteDatabase sQLiteDatabase = this.f4128e;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } finally {
                this.f4128e = null;
            }
        }
    }
}
