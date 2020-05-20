package com.baidu.location.p081d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.mapapi.UIMsg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.location.d.g */
/* loaded from: classes.dex */
public final class C0978g {

    /* renamed from: b */
    private static final double[] f4354b = {45.0d, 135.0d, 225.0d, 315.0d};

    /* renamed from: a */
    private final C0969d f4355a;

    /* renamed from: c */
    private final int f4356c;

    /* renamed from: d */
    private final SQLiteDatabase f4357d;

    /* renamed from: e */
    private int f4358e = -1;

    /* renamed from: f */
    private int f4359f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.g$a */
    /* loaded from: classes.dex */
    public static final class C0980a {

        /* renamed from: a */
        private double f4360a;

        /* renamed from: b */
        private double f4361b;

        private C0980a(double d, double d2) {
            this.f4360a = d;
            this.f4361b = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.g$b */
    /* loaded from: classes.dex */
    public enum EnumC0981b {
        AREA("RGCAREA", "area", "addrv", 0, 1000) { // from class: com.baidu.location.d.g.b.1
            @Override // com.baidu.location.p081d.C0978g.EnumC0981b
            /* renamed from: a */
            final List<String> mo11743a(JSONObject jSONObject, String str, int i) {
                int i2;
                Iterator<String> keys = jSONObject.keys();
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        String string = jSONObject2.has("cy") ? jSONObject2.getString("cy") : null;
                        String string2 = jSONObject2.has("cyc") ? jSONObject2.getString("cyc") : null;
                        String string3 = jSONObject2.has("prov") ? jSONObject2.getString("prov") : null;
                        String string4 = jSONObject2.has("ctc") ? jSONObject2.getString("ctc") : null;
                        String string5 = jSONObject2.has("ct") ? jSONObject2.getString("ct") : null;
                        String string6 = jSONObject2.has("dist") ? jSONObject2.getString("dist") : null;
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append("(\"");
                        stringBuffer.append(next);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string2);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string3);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string5);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string4);
                        stringBuffer.append("\",\"");
                        stringBuffer.append(string6);
                        stringBuffer.append("\",");
                        stringBuffer.append(System.currentTimeMillis() / 1000);
                        stringBuffer.append(",\"\")");
                        try {
                            EnumC0981b.m11746b(stringBuffer2, next, str, 0);
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                    }
                    if (i3 % 50 == 49 && stringBuffer.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                        stringBuffer.setLength(0);
                    }
                    i3++;
                }
                if (stringBuffer.length() > 0) {
                    i2 = 1;
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                    stringBuffer.setLength(0);
                } else {
                    i2 = 1;
                }
                Locale locale = Locale.US;
                Object[] objArr = new Object[i2];
                objArr[0] = Integer.valueOf(i);
                arrayList.add(String.format(locale, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", objArr));
                return arrayList;
            }
        },
        ROAD("RGCROAD", "road", "addrv", 1000, 10000) { // from class: com.baidu.location.d.g.b.2
            @Override // com.baidu.location.p081d.C0978g.EnumC0981b
            /* renamed from: a */
            final List<String> mo11743a(JSONObject jSONObject, String str, int i) {
                int i2;
                char c;
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    EnumC0981b.m11746b(stringBuffer, next, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException unused) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                String string = jSONObject2.has("st") ? jSONObject2.getString("st") : null;
                                Double valueOf = jSONObject2.has("x1") ? Double.valueOf(jSONObject2.getDouble("x1")) : null;
                                Double valueOf2 = jSONObject2.has("y1") ? Double.valueOf(jSONObject2.getDouble("y1")) : null;
                                Double valueOf3 = jSONObject2.has("x2") ? Double.valueOf(jSONObject2.getDouble("x2")) : null;
                                Double valueOf4 = jSONObject2.has("y2") ? Double.valueOf(jSONObject2.getDouble("y2")) : null;
                                if (string != null && valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                                    if (stringBuffer2.length() > 0) {
                                        stringBuffer2.append(",");
                                    }
                                    stringBuffer2.append("(NULL,\"");
                                    stringBuffer2.append(next);
                                    stringBuffer2.append("\",\"");
                                    stringBuffer2.append(string);
                                    stringBuffer2.append("\",");
                                    stringBuffer2.append(valueOf);
                                    stringBuffer2.append(",");
                                    stringBuffer2.append(valueOf2);
                                    stringBuffer2.append(",");
                                    stringBuffer2.append(valueOf3);
                                    stringBuffer2.append(",");
                                    stringBuffer2.append(valueOf4);
                                    stringBuffer2.append(")");
                                }
                            } catch (JSONException unused2) {
                            }
                            if (i3 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    c = 0;
                    i2 = 1;
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                } else {
                    i2 = 1;
                    c = 0;
                }
                Locale locale = Locale.US;
                Object[] objArr = new Object[i2];
                objArr[c] = Integer.valueOf(i);
                arrayList.add(String.format(locale, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", objArr));
                return arrayList;
            }
        },
        SITE("RGCSITE", "site", "addrv", 100, 50000) { // from class: com.baidu.location.d.g.b.3
            @Override // com.baidu.location.p081d.C0978g.EnumC0981b
            /* renamed from: a */
            final List<String> mo11743a(JSONObject jSONObject, String str, int i) {
                int i2;
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    EnumC0981b.m11746b(stringBuffer, next, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException unused) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                String string = jSONObject2.has("st") ? jSONObject2.getString("st") : null;
                                String string2 = jSONObject2.has("stn") ? jSONObject2.getString("stn") : null;
                                Double valueOf = jSONObject2.has(GroupChatInvitation.ELEMENT_NAME) ? Double.valueOf(jSONObject2.getDouble(GroupChatInvitation.ELEMENT_NAME)) : null;
                                Double valueOf2 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(",");
                                }
                                stringBuffer2.append("(NULL,\"");
                                stringBuffer2.append(next);
                                stringBuffer2.append("\",\"");
                                stringBuffer2.append(string);
                                stringBuffer2.append("\",\"");
                                stringBuffer2.append(string2);
                                stringBuffer2.append("\",");
                                stringBuffer2.append(valueOf);
                                stringBuffer2.append(",");
                                stringBuffer2.append(valueOf2);
                                stringBuffer2.append(")");
                            } catch (JSONException unused2) {
                            }
                            if (i3 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    i2 = 1;
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                } else {
                    i2 = 1;
                }
                Locale locale = Locale.US;
                Object[] objArr = new Object[i2];
                objArr[0] = Integer.valueOf(i);
                arrayList.add(String.format(locale, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", objArr));
                return arrayList;
            }
        },
        POI("RGCPOI", "poi", "poiv", 1000, UIMsg.m_AppUI.MSG_APP_GPS) { // from class: com.baidu.location.d.g.b.4
            @Override // com.baidu.location.p081d.C0978g.EnumC0981b
            /* renamed from: a */
            final List<String> mo11743a(JSONObject jSONObject, String str, int i) {
                int i2;
                char c;
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    EnumC0981b.m11746b(stringBuffer, next, str, 1);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException unused) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                                String string = jSONObject2.has("pid") ? jSONObject2.getString("pid") : null;
                                String string2 = jSONObject2.has("ne") ? jSONObject2.getString("ne") : null;
                                String string3 = jSONObject2.has("tp") ? jSONObject2.getString("tp") : null;
                                Integer valueOf = jSONObject2.has("rk") ? Integer.valueOf(jSONObject2.getInt("rk")) : null;
                                Double valueOf2 = jSONObject2.has(GroupChatInvitation.ELEMENT_NAME) ? Double.valueOf(jSONObject2.getDouble(GroupChatInvitation.ELEMENT_NAME)) : null;
                                Double valueOf3 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(",");
                                }
                                stringBuffer2.append("(\"");
                                stringBuffer2.append(string);
                                stringBuffer2.append("\",\"");
                                stringBuffer2.append(next);
                                stringBuffer2.append("\",\"");
                                stringBuffer2.append(string2);
                                stringBuffer2.append("\",\"");
                                stringBuffer2.append(string3);
                                stringBuffer2.append("\",");
                                stringBuffer2.append(valueOf2);
                                stringBuffer2.append(",");
                                stringBuffer2.append(valueOf3);
                                stringBuffer2.append(",");
                                stringBuffer2.append(valueOf);
                                stringBuffer2.append(")");
                            } catch (JSONException unused2) {
                            }
                            if (i3 % 50 == 49) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    c = 0;
                    i2 = 1;
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                } else {
                    i2 = 1;
                    c = 0;
                }
                Locale locale = Locale.US;
                Object[] objArr = new Object[i2];
                objArr[c] = Integer.valueOf(i);
                arrayList.add(String.format(locale, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", objArr));
                return arrayList;
            }
        };
        

        /* renamed from: e */
        private final int f4367e;

        /* renamed from: f */
        private final String f4368f;

        /* renamed from: g */
        private final String f4369g;

        /* renamed from: h */
        private final String f4370h;

        /* renamed from: i */
        private final int f4371i;

        EnumC0981b(String str, String str2, String str3, int i, int i2) {
            this.f4368f = str;
            this.f4369g = str2;
            this.f4370h = str3;
            this.f4367e = i;
            this.f4371i = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m11753a(int i, double d, double d2) {
            HashSet hashSet = new HashSet();
            hashSet.add(C0978g.m11760b(i, d, d2));
            int i2 = this.f4367e;
            double d3 = i2;
            Double.isNaN(d3);
            double d4 = d3 * 1.414d;
            if (i2 > 0) {
                for (int i3 = 0; i3 < C0978g.f4354b.length; i3++) {
                    double[] m11761b = C0978g.m11761b(d2, d, d4, C0978g.f4354b[i3]);
                    hashSet.add(C0978g.m11760b(i, m11761b[1], m11761b[0]));
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            boolean z = true;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"");
                stringBuffer.append(str);
                stringBuffer.append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", this.f4368f, stringBuffer.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m11748a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String next = keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"");
                stringBuffer.append(next);
                stringBuffer.append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", this.f4368f, stringBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static void m11746b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(str);
            stringBuffer.append("\",\"");
            stringBuffer.append(str2);
            stringBuffer.append("\",");
            stringBuffer.append(i);
            stringBuffer.append(",");
            stringBuffer.append(System.currentTimeMillis() / 86400000);
            stringBuffer.append(")");
        }

        /* renamed from: a */
        abstract List<String> mo11743a(JSONObject jSONObject, String str, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0978g(C0969d c0969d, SQLiteDatabase sQLiteDatabase, int i) {
        this.f4355a = c0969d;
        this.f4357d = sQLiteDatabase;
        this.f4356c = i;
        SQLiteDatabase sQLiteDatabase2 = this.f4357d;
        if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
            return;
        }
        try {
            this.f4357d.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
            this.f4357d.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
            this.f4357d.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
            this.f4357d.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
            this.f4357d.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private double m11767a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return Math.sqrt((d8 * d8) + (d10 * d10));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return Math.sqrt((d13 * d13) + (d14 * d14));
        }
        double d15 = d11 / d12;
        double d16 = d - (d3 + (d7 * d15));
        double d17 = (d4 + (d9 * d15)) - d2;
        return Math.sqrt((d16 * d16) + (d17 * d17));
    }

    /* renamed from: a */
    private static int m11765a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = 60000;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = i3;
        Double.isNaN(d3);
        return ((int) ((d * d2) + d3)) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m11760b(int i, double d, double d2) {
        double d3;
        C0980a c0980a;
        int i2 = i * 5;
        char[] cArr = new char[i + 1];
        C0980a c0980a2 = new C0980a(90.0d, -90.0d);
        C0980a c0980a3 = new C0980a(180.0d, -180.0d);
        int i3 = 1;
        boolean z = true;
        int i4 = 0;
        for (int i5 = 1; i5 <= i2; i5++) {
            if (z) {
                d3 = d;
                c0980a = c0980a3;
            } else {
                d3 = d2;
                c0980a = c0980a2;
            }
            double d4 = (c0980a.f4361b + c0980a.f4360a) / 2.0d;
            i4 <<= i3;
            if (((int) (d3 * 1000000.0d)) > ((int) (d4 * 1000000.0d))) {
                c0980a.f4361b = d4;
                i4 |= 1;
            } else {
                c0980a.f4360a = d4;
            }
            if (i5 % 5 == 0) {
                i3 = 1;
                cArr[(i5 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i4);
                i4 = 0;
            } else {
                i3 = 1;
            }
            z = !z;
        }
        cArr[i] = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < i; i6++) {
            stringBuffer.append(cArr[i6]);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static double[] m11761b(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d4);
        double d5 = d3 / 6378137.0d;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new double[]{Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin))))};
    }

    /* renamed from: c */
    private double m11758c(double d, double d2, double d3, double d4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d3, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01d4, code lost:
        r8 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d5, code lost:
        if (r8 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d7, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01da, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01db, code lost:
        r0 = r15;
        r1 = r0;
        r2 = r1;
        r3 = r2;
        r4 = r3;
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e1, code lost:
        if (r8 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01e3, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01e6, code lost:
        r5 = r15;
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e8, code lost:
        if (r15 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01ea, code lost:
        r15 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r15.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f8, code lost:
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01fa, code lost:
        r0 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r1.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0208, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0209, code lost:
        if (r2 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x020b, code lost:
        r1 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r2.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0219, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x021a, code lost:
        if (r3 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x021c, code lost:
        r2 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r3.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x022a, code lost:
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x022b, code lost:
        if (r4 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x022d, code lost:
        r3 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r4.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x023b, code lost:
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x023c, code lost:
        if (r5 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x023e, code lost:
        r4 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r5.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x024c, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x024d, code lost:
        if (r19 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x024f, code lost:
        r5 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r19.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x025d, code lost:
        r5 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x025f, code lost:
        if (r16 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0261, code lost:
        r6 = new java.lang.String(com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r16.getBytes()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x026f, code lost:
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x029a, code lost:
        return new com.baidu.location.Address.Builder().country(r15).countryCode(r0).province(r1).city(r2).cityCode(r3).district(r4).street(r5).streetNumber(r6).build();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
        if (r24 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
        r24.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        if (r24 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
        if (r16 == null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
        r8 = r34.f4357d.rawQuery(com.baidu.location.p081d.C0978g.EnumC0981b.f4363b.m11753a(r34.f4356c, r35, r37), r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
        if (r8.moveToFirst() != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
        r17 = com.baidu.location.Jni.coorEncrypt(r35, r37, "wgs842mc");
        r20 = Double.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cf, code lost:
        if (r8.isAfterLast() == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d1, code lost:
        r18 = r8.getString(r13);
        r1 = com.baidu.location.Jni.coorEncrypt(r8.getDouble(r12), r8.getDouble(4), "wgs842mc");
        r2 = com.baidu.location.Jni.coorEncrypt(r8.getDouble(5), r8.getDouble(6), "wgs842mc");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0101, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0116, code lost:
        r1 = m11767a(r17[0], r17[1], r1[0], r1[1], r2[0], r2[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011c, code lost:
        if (r1 < r20) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        r20 = r1;
        r19 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012d, code lost:
        r22.moveToNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0130, code lost:
        r8 = r22;
        r12 = 3;
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013d, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0140, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0142, code lost:
        if (r22 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
        r22.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0149, code lost:
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014c, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014d, code lost:
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x014f, code lost:
        if (r22 != null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0151, code lost:
        r22.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0154, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0155, code lost:
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0157, code lost:
        if (r22 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0166, code lost:
        r8 = r34.f4357d.rawQuery(com.baidu.location.p081d.C0978g.EnumC0981b.f4362a.m11753a(r34.f4356c, r35, r37), r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0170, code lost:
        if (r8.moveToFirst() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0178, code lost:
        r0 = r8.getString(r8.getColumnIndex("country"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0182, code lost:
        r1 = r8.getString(r8.getColumnIndex("countrycode"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x018c, code lost:
        r2 = r8.getString(r8.getColumnIndex("province"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0196, code lost:
        r3 = r8.getString(r8.getColumnIndex("city"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a0, code lost:
        r4 = r8.getString(r8.getColumnIndex("citycode"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01aa, code lost:
        r5 = r8.getString(r8.getColumnIndex("district"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b4, code lost:
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b8, code lost:
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ba, code lost:
        r3 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bc, code lost:
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01be, code lost:
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c0, code lost:
        r1 = r15;
        r2 = r1;
        r3 = r2;
        r4 = r3;
        r5 = r4;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c5, code lost:
        if (r8 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c7, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01cb, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01cd, code lost:
        r0 = r15;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01cf, code lost:
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01d0, code lost:
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d1, code lost:
        r4 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.baidu.location.Address m11769a(double r35, double r37) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0978g.m11769a(double, double):com.baidu.location.Address");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m11764a(JSONObject jSONObject) {
        EnumC0981b[] values;
        SQLiteDatabase sQLiteDatabase = this.f4357d;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            try {
                this.f4357d.beginTransaction();
                for (EnumC0981b enumC0981b : EnumC0981b.values()) {
                    if (jSONObject.has(enumC0981b.f4369g)) {
                        String string = jSONObject.has(enumC0981b.f4370h) ? jSONObject.getString(enumC0981b.f4370h) : "";
                        ArrayList<String> arrayList = new ArrayList();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(enumC0981b.f4369g);
                        arrayList.add(enumC0981b.m11748a(jSONObject2));
                        arrayList.addAll(enumC0981b.mo11743a(jSONObject2, string, enumC0981b.f4371i));
                        for (String str : arrayList) {
                            this.f4357d.execSQL(str);
                        }
                    }
                }
                this.f4357d.setTransactionSuccessful();
                this.f4358e = -1;
                this.f4359f = -1;
                try {
                    this.f4357d.endTransaction();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                this.f4357d.endTransaction();
            } catch (Throwable th) {
                try {
                    this.f4357d.endTransaction();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r0 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
        if (r0 == null) goto L51;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m11770a() {
        /*
            r5 = this;
            com.baidu.location.d.d r0 = r5.f4355a
            com.baidu.location.d.c r0 = r0.m11791l()
            boolean r0 = r0.m11830l()
            r1 = 0
            if (r0 == 0) goto L70
            int r0 = r5.f4359f
            r2 = -1
            if (r0 != r2) goto L70
            int r0 = r5.f4358e
            if (r0 != r2) goto L70
            android.database.sqlite.SQLiteDatabase r0 = r5.f4357d
            if (r0 == 0) goto L70
            boolean r0 = r0.isOpen()
            if (r0 == 0) goto L70
            r0 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.f4357d     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L65
            java.lang.String r3 = "SELECT COUNT(*) FROM RGCSITE;"
            android.database.Cursor r2 = r2.rawQuery(r3, r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L65
            r2.moveToFirst()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            int r3 = r2.getInt(r1)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            r5.f4359f = r3     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            android.database.sqlite.SQLiteDatabase r3 = r5.f4357d     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            java.lang.String r4 = "SELECT COUNT(*) FROM RGCAREA;"
            android.database.Cursor r0 = r3.rawQuery(r4, r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            r0.moveToFirst()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            int r3 = r0.getInt(r1)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            r5.f4358e = r3     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Exception -> L49
            goto L4a
        L49:
        L4a:
            if (r0 == 0) goto L70
        L4c:
            r0.close()     // Catch: java.lang.Exception -> L50
            goto L70
        L50:
            goto L70
        L52:
            goto L66
        L54:
            r1 = move-exception
            goto L58
        L56:
            r1 = move-exception
            r2 = r0
        L58:
            if (r2 == 0) goto L5f
            r2.close()     // Catch: java.lang.Exception -> L5e
            goto L5f
        L5e:
        L5f:
            if (r0 == 0) goto L64
            r0.close()     // Catch: java.lang.Exception -> L64
        L64:
            throw r1
        L65:
            r2 = r0
        L66:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.lang.Exception -> L6c
            goto L6d
        L6c:
        L6d:
            if (r0 == 0) goto L70
            goto L4c
        L70:
            int r0 = r5.f4359f
            if (r0 != 0) goto L7a
            int r0 = r5.f4358e
            if (r0 != 0) goto L7a
            r0 = 1
            return r0
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0978g.m11770a():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008d, code lost:
        if (r11 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
        if (r11 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
        if (r13 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a6, code lost:
        r0.add(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
        return r0;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.location.Poi> m11762b(double r18, double r20) {
        /*
            r17 = this;
            r10 = r17
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.baidu.location.d.g$b r1 = com.baidu.location.p081d.C0978g.EnumC0981b.POI
            int r2 = r10.f4356c
            r3 = r18
            r5 = r20
            java.lang.String r1 = com.baidu.location.p081d.C0978g.EnumC0981b.m11751a(r1, r2, r3, r5)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r10.f4357d     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9f
            android.database.Cursor r11 = r3.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9f
            boolean r1 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            if (r1 == 0) goto L8c
            r12 = 0
            r13 = r2
            r14 = 0
        L23:
            boolean r1 = r11.isAfterLast()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            if (r1 != 0) goto L8d
            java.lang.String r15 = r11.getString(r12)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r1 = 2
            java.lang.String r16 = r11.getString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r1 = 4
            double r8 = r11.getDouble(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r1 = 5
            double r6 = r11.getDouble(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r1 = 6
            int r4 = r11.getInt(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r1 = r17
            r2 = r20
            r12 = r4
            r4 = r18
            double r1 = r1.m11758c(r2, r4, r6, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            com.baidu.location.d.g$b r3 = com.baidu.location.p081d.C0978g.EnumC0981b.POI     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            int r3 = com.baidu.location.p081d.C0978g.EnumC0981b.m11744d(r3)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            double r3 = (double) r3     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L85
            com.baidu.location.Poi r3 = new com.baidu.location.Poi     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            byte[] r5 = r15.getBytes()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            byte[] r5 = com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r4.<init>(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            byte[] r6 = r16.getBytes()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            byte[] r6 = com.baidu.android.bbalbs.common.p077a.C0859b.m12432a(r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r5.<init>(r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3.<init>(r4, r5, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            float r1 = (float) r1     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            int r1 = java.lang.Math.round(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            int r1 = m11765a(r12, r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            if (r1 <= r14) goto L85
            r14 = r1
            r13 = r3
        L85:
            r11.moveToNext()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L93
            r12 = 0
            goto L23
        L8a:
            goto La1
        L8c:
            r13 = r2
        L8d:
            if (r11 == 0) goto La4
        L8f:
            r11.close()     // Catch: java.lang.Exception -> La4
            goto La4
        L93:
            r0 = move-exception
            goto L99
        L95:
            r13 = r2
            goto La1
        L97:
            r0 = move-exception
            r11 = r2
        L99:
            if (r11 == 0) goto L9e
            r11.close()     // Catch: java.lang.Exception -> L9e
        L9e:
            throw r0
        L9f:
            r11 = r2
            r13 = r11
        La1:
            if (r11 == 0) goto La4
            goto L8f
        La4:
            if (r13 == 0) goto La9
            r0.add(r13)
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0978g.m11762b(double, double):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01cf, code lost:
        if (r7 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d1, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f4, code lost:
        if (r7 == null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject m11763b() {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0978g.m11763b():org.json.JSONObject");
    }
}
