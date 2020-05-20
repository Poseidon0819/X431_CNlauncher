package com.baidu.location.p078a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1016g;
import com.unionpay.tsmservice.p373mi.data.Constant;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.f */
/* loaded from: classes.dex */
public class C0905f {

    /* renamed from: c */
    private static Object f3967c = new Object();

    /* renamed from: d */
    private static C0905f f3968d = null;

    /* renamed from: e */
    private static final String f3969e = C1016g.m11549h() + "/hst.db";

    /* renamed from: f */
    private SQLiteDatabase f3972f = null;

    /* renamed from: g */
    private boolean f3973g = false;

    /* renamed from: a */
    C0906a f3970a = null;

    /* renamed from: b */
    C0906a f3971b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.f$a */
    /* loaded from: classes.dex */
    public class C0906a extends AbstractC1011e {

        /* renamed from: b */
        private String f3975b = null;

        /* renamed from: c */
        private String f3976c = null;

        /* renamed from: d */
        private boolean f3977d = true;

        /* renamed from: e */
        private boolean f3978e = false;

        C0906a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            this.f4523i = 1;
            this.f4522h = C1016g.m11557c();
            String encodeTp4 = Jni.encodeTp4(this.f3976c);
            this.f3976c = null;
            this.f4525k.put("bloc", encodeTp4);
        }

        /* renamed from: a */
        public void m12155a(String str, String str2) {
            if (C0905f.this.f3973g) {
                return;
            }
            C0905f.this.f3973g = true;
            this.f3975b = str;
            this.f3976c = str2;
            m11575c(C1016g.f4596f);
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            if (z && this.f4524j != null) {
                try {
                    String str = this.f4524j;
                    if (this.f3977d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString(Constant.KEY_MAC));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.f3975b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    SQLiteDatabase sQLiteDatabase = C0905f.this.f3972f;
                                    if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        C0905f.this.f3972f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray(Constant.KEY_MAC, this.f3975b.getBytes());
                                bundle.putInt("hotspot", i);
                                C0905f.this.m12168a(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.f3977d) {
                C0905f.this.m12156f();
            }
            if (this.f4525k != null) {
                this.f4525k.clear();
            }
            C0905f.this.f3973g = false;
        }
    }

    /* renamed from: a */
    public static C0905f m12169a() {
        C0905f c0905f;
        synchronized (f3967c) {
            if (f3968d == null) {
                f3968d = new C0905f();
            }
            c0905f = f3968d;
        }
        return c0905f;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m12163a(boolean r5) {
        /*
            r4 = this;
            com.baidu.location.e.b r0 = com.baidu.location.p082e.C0987b.m11732a()
            com.baidu.location.e.a r0 = r0.m11715f()
            com.baidu.location.e.f r1 = com.baidu.location.p082e.C0998f.m11640a()
            com.baidu.location.e.e r1 = r1.m11620p()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)
            if (r0 == 0) goto L26
            boolean r3 = r0.m11740b()
            if (r3 == 0) goto L26
            java.lang.String r0 = r0.m11734h()
            r2.append(r0)
        L26:
            if (r1 == 0) goto L36
            int r0 = r1.m11664a()
            r3 = 1
            if (r0 <= r3) goto L36
            r0 = 15
            java.lang.String r0 = r1.m11663a(r0)
            goto L48
        L36:
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()
            java.lang.String r0 = r0.m11623m()
            if (r0 == 0) goto L4b
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()
            java.lang.String r0 = r0.m11623m()
        L48:
            r2.append(r0)
        L4b:
            if (r5 == 0) goto L52
            java.lang.String r5 = "&imo=1"
            r2.append(r5)
        L52:
            com.baidu.location.g.b r5 = com.baidu.location.p084g.C1006b.m11603a()
            r0 = 0
            java.lang.String r5 = r5.m11600a(r0)
            r2.append(r5)
            com.baidu.location.a.a r5 = com.baidu.location.p078a.C0892a.m12261a()
            java.lang.String r5 = r5.m12242f()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0905f.m12163a(boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12168a(Bundle bundle) {
        C0892a.m12261a().m12260a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12156f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        m12168a(bundle);
    }

    /* renamed from: a */
    public void m12164a(String str) {
        if (this.f3973g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString(Constant.KEY_MAC));
            int i = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i));
            SQLiteDatabase sQLiteDatabase = this.f3972f;
            if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f3972f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m12162b() {
        try {
            File file = new File(f3969e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f3972f = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f3972f.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f3972f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f3972f = null;
        }
    }

    /* renamed from: c */
    public void m12160c() {
        SQLiteDatabase sQLiteDatabase = this.f3972f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } finally {
                this.f3972f = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r2 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r2 != null) goto L24;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m12158d() {
        /*
            r6 = this;
            boolean r0 = r6.f3973g
            r1 = -3
            if (r0 == 0) goto L6
            return r1
        L6:
            boolean r0 = com.baidu.location.p082e.C0998f.m11626j()     // Catch: java.lang.Exception -> L6b
            if (r0 == 0) goto L6b
            android.database.sqlite.SQLiteDatabase r0 = r6.f3972f     // Catch: java.lang.Exception -> L6b
            if (r0 == 0) goto L6b
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()     // Catch: java.lang.Exception -> L6b
            android.net.wifi.WifiInfo r0 = r0.m11624l()     // Catch: java.lang.Exception -> L6b
            if (r0 == 0) goto L6b
            java.lang.String r2 = r0.getBSSID()     // Catch: java.lang.Exception -> L6b
            if (r2 == 0) goto L6b
            java.lang.String r0 = r0.getBSSID()     // Catch: java.lang.Exception -> L6b
            java.lang.String r2 = ":"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replace(r2, r3)     // Catch: java.lang.Exception -> L6b
            java.lang.Long r0 = com.baidu.location.Jni.encode3(r0)     // Catch: java.lang.Exception -> L6b
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r6.f3972f     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            java.lang.String r5 = "select * from hstdata where id = \""
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            r4.append(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            java.lang.String r0 = "\";"
            r4.append(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            android.database.Cursor r2 = r3.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            if (r2 == 0) goto L59
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            if (r0 == 0) goto L59
            r0 = 1
            int r0 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            r1 = r0
            goto L5b
        L59:
            r0 = -2
            r1 = -2
        L5b:
            if (r2 == 0) goto L6b
        L5d:
            r2.close()     // Catch: java.lang.Exception -> L6b
            goto L6b
        L61:
            r0 = move-exception
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.lang.Exception -> L67
        L67:
            throw r0     // Catch: java.lang.Exception -> L6b
        L68:
            if (r2 == 0) goto L6b
            goto L5d
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0905f.m12158d():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
        if (r3 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[Catch: Exception -> 0x00b7, TryCatch #5 {Exception -> 0x00b7, blocks: (B:5:0x0005, B:7:0x000b, B:9:0x000f, B:11:0x0019, B:13:0x001f, B:35:0x0097, B:37:0x009b, B:38:0x00a2, B:40:0x00a6, B:42:0x00b0, B:44:0x00b4, B:15:0x0032, B:17:0x004d, B:19:0x0053, B:22:0x006d), top: B:53:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m12157e() {
        /*
            r10 = this;
            boolean r0 = r10.f3973g
            if (r0 == 0) goto L5
            return
        L5:
            boolean r0 = com.baidu.location.p082e.C0998f.m11626j()     // Catch: java.lang.Exception -> Lb7
            if (r0 == 0) goto Lb4
            android.database.sqlite.SQLiteDatabase r0 = r10.f3972f     // Catch: java.lang.Exception -> Lb7
            if (r0 == 0) goto Lb4
            com.baidu.location.e.f r0 = com.baidu.location.p082e.C0998f.m11640a()     // Catch: java.lang.Exception -> Lb7
            android.net.wifi.WifiInfo r0 = r0.m11624l()     // Catch: java.lang.Exception -> Lb7
            if (r0 == 0) goto Lb0
            java.lang.String r1 = r0.getBSSID()     // Catch: java.lang.Exception -> Lb7
            if (r1 == 0) goto Lb0
            java.lang.String r0 = r0.getBSSID()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r1 = ":"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)     // Catch: java.lang.Exception -> Lb7
            java.lang.Long r1 = com.baidu.location.Jni.encode3(r0)     // Catch: java.lang.Exception -> Lb7
            r2 = 0
            r3 = 0
            r4 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.f3972f     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.String r7 = "select * from hstdata where id = \""
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r6.append(r1)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.String r1 = "\";"
            r6.append(r1)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            android.database.Cursor r3 = r5.rawQuery(r1, r3)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            if (r3 == 0) goto L84
            boolean r1 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            if (r1 == 0) goto L84
            int r1 = r3.getInt(r4)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r5 = 2
            int r5 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            long r8 = (long) r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            long r6 = r6 - r8
            r8 = 259200(0x3f480, double:1.28062E-318)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 <= 0) goto L6d
            goto L84
        L6d:
            android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r5.<init>()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.String r6 = "mac"
            byte[] r7 = r0.getBytes()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r5.putByteArray(r6, r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            java.lang.String r6 = "hotspot"
            r5.putInt(r6, r1)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            r10.m12168a(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L92
            goto L85
        L84:
            r2 = 1
        L85:
            if (r3 == 0) goto L95
        L87:
            r3.close()     // Catch: java.lang.Exception -> L95
            goto L95
        L8b:
            r0 = move-exception
            if (r3 == 0) goto L91
            r3.close()     // Catch: java.lang.Exception -> L91
        L91:
            throw r0     // Catch: java.lang.Exception -> Lb7
        L92:
            if (r3 == 0) goto L95
            goto L87
        L95:
            if (r2 == 0) goto Laf
            com.baidu.location.a.f$a r1 = r10.f3970a     // Catch: java.lang.Exception -> Lb7
            if (r1 != 0) goto La2
            com.baidu.location.a.f$a r1 = new com.baidu.location.a.f$a     // Catch: java.lang.Exception -> Lb7
            r1.<init>()     // Catch: java.lang.Exception -> Lb7
            r10.f3970a = r1     // Catch: java.lang.Exception -> Lb7
        La2:
            com.baidu.location.a.f$a r1 = r10.f3970a     // Catch: java.lang.Exception -> Lb7
            if (r1 == 0) goto Laf
            com.baidu.location.a.f$a r1 = r10.f3970a     // Catch: java.lang.Exception -> Lb7
            java.lang.String r2 = r10.m12163a(r4)     // Catch: java.lang.Exception -> Lb7
            r1.m12155a(r0, r2)     // Catch: java.lang.Exception -> Lb7
        Laf:
            return
        Lb0:
            r10.m12156f()     // Catch: java.lang.Exception -> Lb7
            return
        Lb4:
            r10.m12156f()     // Catch: java.lang.Exception -> Lb7
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0905f.m12157e():void");
    }
}
