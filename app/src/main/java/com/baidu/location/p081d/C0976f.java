package com.baidu.location.p081d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.location.d.f */
/* loaded from: classes.dex */
public final class C0976f {

    /* renamed from: d */
    private static final String f4342d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", Integer.valueOf((int) SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY));

    /* renamed from: e */
    private static final String f4343e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", 3);

    /* renamed from: b */
    private final SQLiteDatabase f4345b;

    /* renamed from: a */
    private String f4344a = null;

    /* renamed from: c */
    private final C0977a f4346c = new C0977a(this);

    /* renamed from: com.baidu.location.d.f$a */
    /* loaded from: classes.dex */
    class C0977a extends AbstractC1011e {

        /* renamed from: b */
        private int f4348b;

        /* renamed from: c */
        private long f4349c;

        /* renamed from: d */
        private String f4350d = null;

        /* renamed from: e */
        private boolean f4351e = false;

        /* renamed from: f */
        private boolean f4352f = false;

        /* renamed from: p */
        private C0976f f4353p;

        C0977a(C0976f c0976f) {
            this.f4353p = c0976f;
            this.f4525k = new HashMap();
            this.f4348b = 0;
            this.f4349c = -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m11771b() {
            if (this.f4351e) {
                return;
            }
            this.f4350d = this.f4353p.m11773b();
            long j = this.f4349c;
            if (j != -1 && j + 86400000 <= System.currentTimeMillis()) {
                this.f4348b = 0;
                this.f4349c = -1L;
            }
            if (this.f4350d == null || this.f4348b >= 2) {
                return;
            }
            this.f4351e = true;
            m11575c("https://ofloc.map.baidu.com/offline_loc");
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4525k.clear();
            this.f4525k.put("qt", "ofbh");
            this.f4525k.put("req", this.f4350d);
            this.f4522h = C0969d.f4310b;
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            this.f4352f = false;
            if (z && this.f4524j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f4524j);
                    if (jSONObject.has("error") && jSONObject.getInt("error") == 161) {
                        this.f4352f = true;
                    }
                } catch (Exception unused) {
                }
            }
            if (!this.f4352f) {
                this.f4348b++;
                this.f4349c = System.currentTimeMillis();
            }
            this.f4353p.m11774a(this.f4352f);
            this.f4351e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0976f(SQLiteDatabase sQLiteDatabase) {
        this.f4345b = sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.f4345b;
        if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
            return;
        }
        try {
            this.f4345b.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11774a(boolean z) {
        String str;
        if (z && (str = this.f4344a) != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", str);
            try {
                if (this.f4344a.length() > 0) {
                    this.f4345b.execSQL(format);
                }
            } catch (Exception unused) {
            }
        }
        this.f4344a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r3 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        if (r3 == null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        return r2;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m11773b() {
        /*
            r7 = this;
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r7.f4345b     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L6b
            java.lang.String r4 = com.baidu.location.p081d.C0976f.f4343e     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L6b
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L6b
            if (r3 == 0) goto L5d
            int r4 = r3.getCount()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            if (r4 <= 0) goto L5d
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r4.<init>()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r3.moveToFirst()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
        L23:
            boolean r5 = r3.isAfterLast()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            if (r5 != 0) goto L48
            r5 = 1
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r0.put(r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            int r5 = r4.length()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            if (r5 == 0) goto L3c
            java.lang.String r5 = ","
            r4.append(r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
        L3c:
            r5 = 0
            long r5 = r3.getLong(r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r4.append(r5)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r3.moveToNext()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            goto L23
        L48:
            java.lang.String r5 = "ofloc"
            r1.put(r5, r0)     // Catch: org.json.JSONException -> L52 java.lang.Exception -> L59 java.lang.Throwable -> L5b
            java.lang.String r0 = r1.toString()     // Catch: org.json.JSONException -> L52 java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r2 = r0
        L52:
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            r7.f4344a = r0     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L5b
            goto L5d
        L59:
            goto L6c
        L5b:
            r0 = move-exception
            goto L65
        L5d:
            if (r3 == 0) goto L6f
        L5f:
            r3.close()     // Catch: java.lang.Exception -> L6f
            goto L6f
        L63:
            r0 = move-exception
            r3 = r2
        L65:
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.lang.Exception -> L6a
        L6a:
            throw r0
        L6b:
            r3 = r2
        L6c:
            if (r3 == 0) goto L6f
            goto L5f
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0976f.m11773b():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m11778a() {
        this.f4346c.m11771b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m11775a(String str) {
        try {
            this.f4345b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", Long.valueOf(System.currentTimeMillis()), Jni.encodeOfflineLocationUpdateRequest(str)));
            this.f4345b.execSQL(f4342d);
        } catch (Exception unused) {
        }
    }
}
