package com.baidu.location.p081d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p078a.C0892a;
import com.baidu.location.p078a.C0919j;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.jivesoftware.smackx.packet.MultipleAddresses;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.a */
/* loaded from: classes.dex */
public final class C0955a {

    /* renamed from: b */
    private static C0955a f4217b;

    /* renamed from: l */
    private static final String f4218l = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/";

    /* renamed from: m */
    private static final String f4219m = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/ls.db";

    /* renamed from: c */
    private String f4221c = null;

    /* renamed from: d */
    private boolean f4222d = false;

    /* renamed from: e */
    private boolean f4223e = false;

    /* renamed from: f */
    private double f4224f = 0.0d;

    /* renamed from: g */
    private double f4225g = 0.0d;

    /* renamed from: h */
    private double f4226h = 0.0d;

    /* renamed from: i */
    private double f4227i = 0.0d;

    /* renamed from: j */
    private double f4228j = 0.0d;

    /* renamed from: k */
    private volatile boolean f4229k = false;

    /* renamed from: n */
    private Handler f4230n = null;

    /* renamed from: a */
    public boolean f4220a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.a$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC0958a extends AsyncTask<Boolean, Void, Boolean> {
        private AsyncTaskC0958a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            if (boolArr.length != 4) {
                return Boolean.FALSE;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(C0955a.f4219m, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabase == null) {
                return Boolean.FALSE;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    StringBuilder sb = new StringBuilder("delete from wof where ac < ");
                    sb.append(currentTimeMillis - 35);
                    try {
                        sQLiteDatabase.execSQL(sb.toString());
                    } catch (Exception unused2) {
                    }
                }
                if (boolArr[1].booleanValue()) {
                    StringBuilder sb2 = new StringBuilder("delete from bdcltb09 where ac is NULL or ac < ");
                    sb2.append(currentTimeMillis - 130);
                    try {
                        sQLiteDatabase.execSQL(sb2.toString());
                    } catch (Exception unused3) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception unused4) {
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.a$b */
    /* loaded from: classes.dex */
    public class AsyncTaskC0959b extends AsyncTask<Object, Void, Boolean> {
        private AsyncTaskC0959b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            if (objArr.length != 4) {
                C0955a.this.f4229k = false;
                return Boolean.FALSE;
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(C0955a.f4219m, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
            }
            if (sQLiteDatabase == null) {
                C0955a.this.f4229k = false;
                return Boolean.FALSE;
            }
            try {
                sQLiteDatabase.beginTransaction();
                C0955a.this.m11930a((String) objArr[0], (C0986a) objArr[1], sQLiteDatabase);
                C0955a.this.m11932a((C0997e) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception unused2) {
            }
            C0955a.this.f4229k = false;
            return Boolean.TRUE;
        }
    }

    private C0955a() {
        m11919d();
    }

    /* renamed from: a */
    public static synchronized C0955a m11938a() {
        C0955a c0955a;
        synchronized (C0955a.class) {
            if (f4217b == null) {
                f4217b = new C0955a();
            }
            c0955a = f4217b;
        }
        return c0955a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11932a(C0997e c0997e, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        double d;
        boolean z;
        int i;
        int i2;
        String str;
        Integer valueOf;
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && c0997e.f4450a != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            int i3 = 0;
            for (ScanResult scanResult : c0997e.f4450a) {
                if (scanResult.level != 0) {
                    i3++;
                    if (i3 > 6) {
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    String encode2 = Jni.encode2(scanResult.BSSID.replace(":", ""));
                    try {
                        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + encode2 + "\";", null);
                        double d2 = 0.0d;
                        if (rawQuery == null || !rawQuery.moveToFirst()) {
                            d = 0.0d;
                            z = false;
                            i = 0;
                            i2 = 0;
                        } else {
                            d2 = rawQuery.getDouble(1) - 113.2349d;
                            d = rawQuery.getDouble(2) - 432.1238d;
                            int i4 = rawQuery.getInt(4);
                            i = rawQuery.getInt(5);
                            i2 = i4;
                            z = true;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (!z) {
                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                            contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                            contentValues.put("bc", (Integer) 1);
                            contentValues.put(MultipleAddresses.f24412CC, (Integer) 1);
                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            contentValues.put("id", encode2);
                            sQLiteDatabase.insert("wof", null, contentValues);
                        } else if (i != 0) {
                            float[] fArr = new float[1];
                            Location.distanceBetween(d, d2, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                            if (fArr[0] > 1500.0f) {
                                int i5 = i + 1;
                                if (i5 <= 10 || i5 <= i2 * 3) {
                                    str = MultipleAddresses.f24412CC;
                                    valueOf = Integer.valueOf(i5);
                                } else {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put("time", Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", (Integer) 1);
                                    contentValues.put(MultipleAddresses.f24412CC, (Integer) 1);
                                    str = "ac";
                                    valueOf = Integer.valueOf(currentTimeMillis);
                                }
                                contentValues.put(str, valueOf);
                            } else {
                                int i6 = i2;
                                double d3 = i6;
                                Double.isNaN(d3);
                                double longitude = (d2 * d3) + bDLocation.getLongitude();
                                int i7 = i6 + 1;
                                double d4 = i7;
                                Double.isNaN(d4);
                                double d5 = longitude / d4;
                                Double.isNaN(d3);
                                double latitude = (d * d3) + bDLocation.getLatitude();
                                Double.isNaN(d4);
                                double d6 = latitude / d4;
                                contentValues.put("mktime", Double.valueOf(d5 + 113.2349d));
                                contentValues.put("time", Double.valueOf(d6 + 432.1238d));
                                contentValues.put("bc", Integer.valueOf(i7));
                                contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            }
                            sQLiteDatabase.update("wof", contentValues, "id = \"" + encode2 + "\"", null);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m11931a(String str, SQLiteDatabase sQLiteDatabase) {
        if (str == null || str.equals(this.f4221c)) {
            return;
        }
        this.f4222d = false;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from bdcltb09 where id = \"" + str + "\";", null);
            this.f4221c = str;
            if (cursor.moveToFirst()) {
                this.f4225g = cursor.getDouble(1) - 1235.4323d;
                this.f4224f = cursor.getDouble(2) - 4326.0d;
                this.f4226h = cursor.getDouble(3) - 2367.3217d;
                this.f4222d = true;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11930a(String str, C0986a c0986a, SQLiteDatabase sQLiteDatabase) {
        double d;
        float f;
        double d2;
        if (c0986a.m11740b() && C0919j.m12105c().m12090h()) {
            System.currentTimeMillis();
            float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            String m11735g = c0986a.m11735g();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
                boolean z = false;
                double d3 = 0.0d;
                if (parseInt == 161) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    if (jSONObject2.has("clf")) {
                        String string = jSONObject2.getString("clf");
                        if (string.equals("0")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                            d3 = Double.parseDouble(jSONObject3.getString(GroupChatInvitation.ELEMENT_NAME));
                            d = Double.parseDouble(jSONObject3.getString("y"));
                            f = Float.parseFloat(jSONObject2.getString("radius"));
                        } else {
                            String[] split = string.split("\\|");
                            d3 = Double.parseDouble(split[0]);
                            d2 = Double.parseDouble(split[1]);
                            f2 = Float.parseFloat(split[2]);
                        }
                    } else {
                        d2 = 0.0d;
                        z = true;
                    }
                    f = f2;
                    d = d2;
                } else if (parseInt == 167) {
                    sQLiteDatabase.delete("bdcltb09", "id = \"" + m11735g + "\"", null);
                    return;
                } else {
                    d = 0.0d;
                    f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    z = true;
                }
                if (z) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("time", Double.valueOf(d3 + 1235.4323d));
                contentValues.put(Constant.KEY_TAG, Float.valueOf(f + 4326.0f));
                contentValues.put(VastExtensionXmlManager.TYPE, Double.valueOf(d + 2367.3217d));
                contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + m11735g + "\"", null) <= 0) {
                    contentValues.put("id", m11735g);
                    sQLiteDatabase.insert("bdcltb09", null, contentValues);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11928a(String str, List<ScanResult> list) {
        SQLiteDatabase sQLiteDatabase;
        if (str == null || str.equals(this.f4221c)) {
            sQLiteDatabase = null;
        } else {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f4219m, (SQLiteDatabase.CursorFactory) null);
            m11931a(str, sQLiteDatabase);
        }
        if (list != null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f4219m, (SQLiteDatabase.CursorFactory) null);
            }
            m11926a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x017b A[Catch: all -> 0x0198, Exception -> 0x019f, TryCatch #5 {Exception -> 0x019f, all -> 0x0198, blocks: (B:19:0x005e, B:22:0x0087, B:24:0x008e, B:27:0x00b3, B:28:0x00b9, B:30:0x00bd, B:32:0x00e3, B:33:0x00e7, B:60:0x017b, B:36:0x00f7, B:38:0x010b, B:45:0x0125, B:48:0x0139, B:50:0x0152, B:51:0x015c, B:54:0x0162, B:58:0x016f, B:62:0x0182, B:64:0x018a, B:66:0x0190), top: B:86:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0180 A[EDGE_INSN: B:94:0x0180->B:61:0x0180 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11926a(java.util.List<android.net.wifi.ScanResult> r30, android.database.sqlite.SQLiteDatabase r31) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0955a.m11926a(java.util.List, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m11921b(boolean z) {
        double d;
        double d2;
        boolean z2;
        boolean z3;
        StringBuilder sb;
        String str;
        double d3 = 0.0d;
        if (this.f4223e) {
            d3 = this.f4227i;
            d = this.f4228j;
            d2 = 246.4d;
            z2 = true;
            z3 = true;
        } else if (this.f4222d) {
            d3 = this.f4225g;
            d = this.f4226h;
            d2 = this.f4224f;
            z3 = C0919j.m12105c().m12090h();
            z2 = true;
        } else {
            d = 0.0d;
            d2 = 0.0d;
            z2 = false;
            z3 = false;
        }
        if (!z2) {
            if (z) {
                sb = new StringBuilder("{\"result\":{\"time\":\"");
                sb.append(C1016g.m11572a());
                str = "\",\"error\":\"67\"}}";
            } else {
                sb = new StringBuilder("{\"result\":{\"time\":\"");
                sb.append(C1016g.m11572a());
                str = "\",\"error\":\"63\"}}";
            }
            sb.append(str);
            return sb.toString();
        } else if (z) {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + C1016g.m11572a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2), Boolean.TRUE);
        } else {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + C1016g.m11572a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11919d() {
        try {
            File file = new File(f4218l);
            File file2 = new File(f4219m);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
            this.f4220a = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m11918e() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(f4219m, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception unused) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            long queryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabase, "wof");
            long queryNumEntries2 = DatabaseUtils.queryNumEntries(sQLiteDatabase, "bdcltb09");
            boolean z = queryNumEntries > 10000;
            boolean z2 = queryNumEntries2 > 10000;
            sQLiteDatabase.close();
            if (z || z2) {
                new AsyncTaskC0958a().execute(Boolean.valueOf(z), Boolean.valueOf(z2));
            }
        } catch (Exception unused2) {
        }
    }

    /* renamed from: a */
    public final BDLocation m11927a(final String str, final List<ScanResult> list, boolean z) {
        if (!this.f4220a) {
            m11919d();
        }
        String str2 = "{\"result\":\"null\"}";
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = (FutureTask) newSingleThreadExecutor.submit(new Callable<String>() { // from class: com.baidu.location.d.a.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public String call() {
                C0955a.this.m11928a(str, list);
                return C0955a.this.m11921b(true);
            }
        });
        try {
            try {
                String str3 = (String) futureTask.get(2000L, TimeUnit.MILLISECONDS);
                newSingleThreadExecutor.shutdown();
                str2 = str3;
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
            }
            return new BDLocation(str2);
        } catch (Throwable th) {
            newSingleThreadExecutor.shutdown();
            throw th;
        }
    }

    /* renamed from: a */
    public final BDLocation m11925a(boolean z) {
        if (!this.f4220a) {
            m11919d();
        }
        C0986a m11715f = C0987b.m11732a().m11715f();
        String m11735g = (m11715f == null || !m11715f.m11737e()) ? null : m11715f.m11735g();
        C0997e m11621o = C0998f.m11640a().m11621o();
        BDLocation m11927a = m11621o != null ? m11927a(m11735g, m11621o.f4450a, true) : null;
        if (m11927a != null && m11927a.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", Double.valueOf(m11927a.getLatitude()), Double.valueOf(m11927a.getLongitude()), Float.valueOf(m11927a.getRadius())));
            if (m11621o != null && m11621o.m11664a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(m11621o.m11653c(15));
            }
            if (m11715f != null) {
                stringBuffer.append(m11715f.m11734h());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(C1016g.m11552e(ServiceC1002f.getServiceContext()));
            stringBuffer.append(C1006b.m11603a().m11600a(false));
            stringBuffer.append(C0892a.m12261a().m12242f());
        }
        return m11927a;
    }

    /* renamed from: a */
    public final void m11929a(String str, C0986a c0986a, C0997e c0997e, BDLocation bDLocation) {
        if (!this.f4220a) {
            m11919d();
        }
        boolean z = (c0986a.m11740b() && C0919j.m12105c().m12090h()) ? false : true;
        boolean z2 = bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f);
        if (c0997e.f4450a == null) {
            z2 = true;
        }
        if ((z && z2) || this.f4229k) {
            return;
        }
        this.f4229k = true;
        new AsyncTaskC0959b().execute(str, c0986a, c0997e, bDLocation);
    }

    /* renamed from: b */
    public final void m11924b() {
        if (this.f4230n == null) {
            this.f4230n = new Handler();
        }
        this.f4230n.postDelayed(new Runnable() { // from class: com.baidu.location.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (ServiceC1002f.isServing) {
                    if (!C0955a.this.f4220a) {
                        C0955a.this.m11919d();
                    }
                    C0955a.this.m11918e();
                }
            }
        }, 3000L);
    }
}
