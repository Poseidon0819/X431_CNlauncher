package com.cnlaunch.x431pro.module.history.p266a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.utils.MyContext;

/* renamed from: com.cnlaunch.x431pro.module.history.a.c */
/* loaded from: classes.dex */
public class VINInfoDao {

    /* renamed from: a */
    private static VINInfoDao f15569a;

    /* renamed from: b */
    private SQLiteOpenHelper f15570b;

    /* renamed from: a */
    public static VINInfoDao m5286a(Context context) {
        if (f15569a == null) {
            synchronized (VINInfoDao.class) {
                if (f15569a == null) {
                    f15569a = new VINInfoDao(context);
                }
            }
        }
        return f15569a;
    }

    private VINInfoDao(Context context) {
        this.f15570b = new VINInfoOpenHelper(new MyContext(context), "vin_info.db");
    }

    /* renamed from: a */
    private static void m5285a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception e) {
            NLog.m9455a(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a5, code lost:
        if (r4 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a7, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00aa, code lost:
        m5285a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d3, code lost:
        if (r4 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d6, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.cnlaunch.x431pro.module.cloud.model.CloudVINInfo m5284a(java.lang.String r9) {
        /*
            r8 = this;
            com.cnlaunch.x431pro.module.cloud.model.m r0 = new com.cnlaunch.x431pro.module.cloud.model.m
            r0.<init>()
            android.database.sqlite.SQLiteOpenHelper r1 = r8.f15570b
            if (r1 != 0) goto La
            return r0
        La:
            r2 = 0
            r3 = 1
            r4 = 0
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb3
            java.lang.String r5 = "select * from VIN_INFO where VIN=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r6[r2] = r9     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            android.database.Cursor r4 = r1.rawQuery(r5, r6)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
        L1b:
            boolean r9 = r4.moveToNext()     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            if (r9 == 0) goto La5
            java.lang.String r9 = "VIN"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setVin(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "PLATE"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setPlate(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "PACKAGE_ID"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setPackage_id(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "MODEL"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setModel(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "DIAGNOSE_MODEL"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setDiagnose_model(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "YEAR"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setYear(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "DISPLACEMENT"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setDisplacement(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "TRANS"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setTrans(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "VENDER"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setVender(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = "REMARK_JSON"
            int r9 = r4.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            java.lang.String r9 = r4.getString(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            r0.setRemark_json(r9)     // Catch: java.lang.Exception -> Lae java.lang.Throwable -> Ld7
            goto L1b
        La5:
            if (r4 == 0) goto Laa
        La7:
            r4.close()
        Laa:
            m5285a(r1)
            goto Ld6
        Lae:
            r9 = move-exception
            goto Lb5
        Lb0:
            r9 = move-exception
            r1 = r4
            goto Ld8
        Lb3:
            r9 = move-exception
            r1 = r4
        Lb5:
            java.lang.String r5 = "XEE"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = "vin查询失败："
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = r9.toString()     // Catch: java.lang.Throwable -> Ld7
            r6.append(r7)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Ld7
            r3[r2] = r6     // Catch: java.lang.Throwable -> Ld7
            com.cnlaunch.p120d.p130d.NLog.m9451c(r5, r3)     // Catch: java.lang.Throwable -> Ld7
            r9.printStackTrace()     // Catch: java.lang.Throwable -> Ld7
            if (r4 == 0) goto Laa
            goto La7
        Ld6:
            return r0
        Ld7:
            r9 = move-exception
        Ld8:
            if (r4 == 0) goto Ldd
            r4.close()
        Ldd:
            m5285a(r1)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.module.history.p266a.VINInfoDao.m5284a(java.lang.String):com.cnlaunch.x431pro.module.cloud.model.m");
    }
}
