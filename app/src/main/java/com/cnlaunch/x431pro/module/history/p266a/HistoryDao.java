package com.cnlaunch.x431pro.module.history.p266a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.AndroidToLan;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.module.cloud.model.CloudSystemInfo;
import com.cnlaunch.x431pro.module.cloud.model.CloudVINInfo;
import com.cnlaunch.x431pro.module.history.model.HistoryDTCModel;
import com.cnlaunch.x431pro.module.history.model.HistorySystemModel;
import com.cnlaunch.x431pro.module.history.model.HistoryVehicleModel;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.utils.MyContext;
import com.cnlaunch.x431pro.utils.p280b.LanChaset;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.history.a.a */
/* loaded from: classes.dex */
public class HistoryDao {

    /* renamed from: b */
    private static HistoryDao f15559b;

    /* renamed from: e */
    private SQLiteDatabase f15563e;

    /* renamed from: f */
    private SQLiteOpenHelper f15564f;

    /* renamed from: g */
    private Context f15565g;

    /* renamed from: h */
    private String f15566h;

    /* renamed from: i */
    private int f15567i;

    /* renamed from: a */
    private final String f15560a = "history.db";

    /* renamed from: c */
    private final int f15561c = 1;

    /* renamed from: d */
    private final String f15562d = "HistoryDao";

    /* renamed from: j */
    private final String f15568j = "CLD_FLAG";

    /* renamed from: a */
    public static HistoryDao m5300a(Context context) {
        if (f15559b == null) {
            synchronized (HistoryDao.class) {
                if (f15559b == null) {
                    f15559b = new HistoryDao(context);
                }
            }
        }
        return f15559b;
    }

    private HistoryDao(Context context) {
        this.f15566h = "GB2312";
        this.f15567i = 0;
        this.f15565g = context;
        this.f15564f = new HistoryOpenHelper(new MyContext(context), "history.db");
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        try {
            if (sQLiteOpenHelper != null) {
                try {
                    this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                    if (!m5298a(this.f15563e, "Vehicle", "QuickTest")) {
                        try {
                            this.f15563e.execSQL("ALTER TABLE Vehicle  ADD QuickTest Integer");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!m5298a(this.f15563e, "Vehicle", "SystemScan")) {
                        try {
                            this.f15563e.execSQL("ALTER TABLE Vehicle  ADD SystemScan Integer");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!m5298a(this.f15563e, "Vehicle", "UploadFlag")) {
                        try {
                            this.f15563e.execSQL("ALTER TABLE Vehicle  ADD UploadFlag Integer");
                        } catch (SQLException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (!m5298a(this.f15563e, "DTC", "IsShowSystem")) {
                        try {
                            this.f15563e.execSQL("ALTER TABLE DTC  ADD IsShowSystem Integer");
                        } catch (SQLException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    NLog.m9451c("HistoryDao", e5);
                }
            }
            this.f15566h = LanChaset.m5100a(LangManager.m9466b());
            this.f15567i = AndroidToLan.languages(LangManager.m9466b());
        } finally {
            m5299a(this.f15563e);
        }
    }

    /* renamed from: a */
    private static void m5299a(SQLiteDatabase sQLiteDatabase) {
        NLog.m9456a("HistoryDao", "disconnectDatabase enter,db=".concat(String.valueOf(sQLiteDatabase)));
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception e) {
            NLog.m9456a("HistoryDao", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r0.isClosed() == false) goto L13;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m5298a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r3 = "SELECT * FROM "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r2.append(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r5 = " LIMIT 0"
            r2.append(r5)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            android.database.Cursor r0 = r4.rawQuery(r5, r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            if (r0 == 0) goto L24
            int r4 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L32
            r5 = -1
            if (r4 == r5) goto L24
            r4 = 1
            r1 = 1
        L24:
            if (r0 == 0) goto L53
            boolean r4 = r0.isClosed()
            if (r4 != 0) goto L53
        L2c:
            r0.close()
            goto L53
        L30:
            r4 = move-exception
            goto L54
        L32:
            r4 = move-exception
            java.lang.String r5 = "XEE"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "checkColumnExists..."
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L30
            r6.append(r4)     // Catch: java.lang.Throwable -> L30
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L30
            android.util.Log.e(r5, r4)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L53
            boolean r4 = r0.isClosed()
            if (r4 != 0) goto L53
            goto L2c
        L53:
            return r1
        L54:
            if (r0 == 0) goto L5f
            boolean r5 = r0.isClosed()
            if (r5 != 0) goto L5f
            r0.close()
        L5f:
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.module.history.p266a.HistoryDao.m5298a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public final LinkedHashMap<String, Integer> m5295a(String str) {
        NLog.m9456a("HistoryDao", "getOutlineOrderByDate: start!");
        NLog.m9456a("HistoryDao", "removeInvalidRecord: start!");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        try {
            if (sQLiteOpenHelper == null) {
                return linkedHashMap;
            }
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                m5290c(this.f15563e);
                NLog.m9456a("HistoryDao", "removeInvalidRecord: END!");
                try {
                    Cursor rawQuery = this.f15563e.rawQuery("select TimeStampYearMonth, COUNT(1) AS Number from Vehicle where SN = ? and (Language = ? or Language = 0) group by TimeStampYearMonth order by TimeStampYearMonth DESC", new String[]{str, String.valueOf(this.f15567i)});
                    NLog.m9456a("HistoryDao", "rawQuery: end!");
                    if (rawQuery.moveToFirst()) {
                        do {
                            String str2 = "";
                            int i = 0;
                            for (int i2 = 0; i2 < rawQuery.getColumnCount(); i2++) {
                                String columnName = rawQuery.getColumnName(i2);
                                if (columnName.contentEquals("Number")) {
                                    try {
                                        i = rawQuery.getInt(i2);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else if (columnName.contentEquals("TimeStampYearMonth")) {
                                    try {
                                        str2 = rawQuery.getString(i2);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (str2 != null && !str2.isEmpty() && i > 0) {
                                linkedHashMap.put(str2, Integer.valueOf(i));
                            }
                        } while (rawQuery.moveToNext());
                    }
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                    return linkedHashMap;
                }
            } catch (Exception e4) {
                NLog.m9455a(e4);
            }
            m5299a(this.f15563e);
            NLog.m9456a("HistoryDao", "getOutlineOrderByDate: end!");
            return linkedHashMap;
        } finally {
            m5299a(this.f15563e);
        }
    }

    /* renamed from: a */
    public final List<VehicleInfo> m5294a(String str, String str2) {
        int i;
        ArrayList arrayList = new ArrayList();
        char c = 1;
        NLog.m9456a("HistoryDao", "getVehicleInfoByDate: start!");
        NLog.m9456a("HistoryDao", "getVehicleByDate: start!");
        List<HistoryVehicleModel> m5291b = m5291b(str, str2);
        NLog.m9456a("HistoryDao", "getVehicleByDate: end!");
        HashMap<Integer, Integer> m5303a = m5303a();
        NLog.m9456a("HistoryDao", "getDTCNumber: end!");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (HistoryVehicleModel historyVehicleModel : m5291b) {
            VehicleInfo vehicleInfo = new VehicleInfo();
            vehicleInfo.setVehicleId(historyVehicleModel.getVID());
            vehicleInfo.setMark(historyVehicleModel.getMake());
            vehicleInfo.setModel(historyVehicleModel.getModel());
            vehicleInfo.setSubModel(historyVehicleModel.getSubmodel());
            vehicleInfo.setEngine(historyVehicleModel.getEngine());
            vehicleInfo.setYear(historyVehicleModel.getYear());
            vehicleInfo.setLicenseNumber(historyVehicleModel.getLicenseNumber());
            vehicleInfo.setMileage(historyVehicleModel.getMileage());
            vehicleInfo.setColor(historyVehicleModel.getColor());
            vehicleInfo.setVIN(historyVehicleModel.getVIN());
            vehicleInfo.setDiagSoftVersion(historyVehicleModel.getDiagVersion());
            vehicleInfo.setVehicleSoftVersion(historyVehicleModel.getVehicleVersion());
            vehicleInfo.setVehicleUID(historyVehicleModel.getUID());
            vehicleInfo.setVehicleInfomation(historyVehicleModel.getVehicleInformation());
            vehicleInfo.setStaffIDString(historyVehicleModel.getStaffID());
            vehicleInfo.setTimeStamp(historyVehicleModel.getTimeStamp());
            vehicleInfo.setRemark(historyVehicleModel.getRemark());
            vehicleInfo.setOwerID(historyVehicleModel.getOwnerID());
            vehicleInfo.setPath(historyVehicleModel.getVehiclePath());
            vehicleInfo.setMenuPath(historyVehicleModel.getPath());
            vehicleInfo.setSN(historyVehicleModel.getSN());
            vehicleInfo.setCharSet(historyVehicleModel.getCharSet());
            vehicleInfo.setLanguage(historyVehicleModel.getLanguage());
            try {
                i = m5303a.containsKey(Integer.valueOf(historyVehicleModel.getVID())) ? m5303a.get(Integer.valueOf(historyVehicleModel.getVID())).intValue() : 0;
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            vehicleInfo.setNumbDTC(String.valueOf(i));
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                if (hashMap.containsKey(vehicleInfo.getVehicleUID())) {
                    String[] strArr = (String[]) hashMap.get(vehicleInfo.getVehicleUID());
                    vehicleInfo.setVehicle_icon_id(strArr[0]);
                    vehicleInfo.setCar_name(strArr[c]);
                } else {
                    CarIconUtils m4977a = CarIconUtils.m4977a(this.f15565g);
                    String uid = historyVehicleModel.getUID();
                    String str3 = "";
                    CarIcon m4951e = CarIconUtils.m4977a(m4977a.f15880s).m4951e(str2, uid);
                    if (m4951e != null && m4951e.f15787k.booleanValue()) {
                        str3 = m4951e.f15781e;
                        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                            uid = m4951e.m5038a(m4977a.f15880s);
                        } else {
                            uid = m4951e.f15779c;
                        }
                    }
                    String[] strArr2 = {str3, uid};
                    hashMap.put(vehicleInfo.getVehicleUID(), strArr2);
                    vehicleInfo.setVehicle_icon_id(strArr2[0]);
                    vehicleInfo.setCar_name(strArr2[1]);
                }
            }
            if (!MyTools.m9636a(historyVehicleModel.getVIN())) {
                if (hashMap2.containsKey(historyVehicleModel.getVIN())) {
                    String[] strArr3 = (String[]) hashMap2.get(historyVehicleModel.getVIN());
                    m5296a(vehicleInfo, strArr3[0], strArr3[1], strArr3[2]);
                } else {
                    CloudVINInfo m5284a = VINInfoDao.m5286a(this.f15565g).m5284a(historyVehicleModel.getVIN());
                    m5296a(vehicleInfo, m5284a.getPlate(), m5284a.getModel(), m5284a.getYear());
                    hashMap2.put(historyVehicleModel.getVIN(), new String[]{m5284a.getPlate(), m5284a.getModel(), m5284a.getYear()});
                }
            }
            arrayList.add(vehicleInfo);
            c = 1;
        }
        NLog.m9456a("HistoryDao", "getVehicleInfoByDate: end!");
        return arrayList;
    }

    /* renamed from: a */
    private static void m5296a(VehicleInfo vehicleInfo, String str, String str2, String str3) {
        if (!MyTools.m9636a(str)) {
            vehicleInfo.setLicenseNumber(str);
        }
        if (!MyTools.m9636a(str2)) {
            vehicleInfo.setModel(str2);
        }
        if (MyTools.m9636a(str3)) {
            return;
        }
        vehicleInfo.setYear(str3);
    }

    /* renamed from: b */
    private List<HistoryVehicleModel> m5291b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        if (sQLiteOpenHelper == null) {
            return arrayList;
        }
        String[] strArr = {"CharSet", "VID", "SN", "VehicleUID", "Make", "Model", "SubModel", "Engine", "Year", "LicenseNumber", "Mileage", "Color", "VIN", "DiagSoftVersion", "VehicleSoftVersion", "VehicleInformation", "StaffIDString", "TimeStamp", "Remark", "OwnerID", "Path", "VehiclePath", "TimeStampYearMonth", "Language"};
        try {
            this.f15563e = sQLiteOpenHelper.getWritableDatabase();
            Cursor query = this.f15563e.query("Vehicle", strArr, "SN = ? and TimeStampYearMonth = ? and (Language = ? or Language = 0)", new String[]{str2, str, String.valueOf(this.f15567i)}, null, null, "VID DESC");
            if (query.moveToFirst()) {
                do {
                    HistoryVehicleModel historyVehicleModel = new HistoryVehicleModel();
                    historyVehicleModel.setCharSet(this.f15566h);
                    for (int i = 0; i < query.getColumnCount(); i++) {
                        if (strArr[0].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setCharSet(query.getString(i));
                        } else if (strArr[1].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setVID(query.getInt(i));
                        } else if (strArr[2].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setSN(query.getString(i));
                        } else if (strArr[3].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setUID(query.getString(i));
                        } else if (strArr[4].contentEquals(query.getColumnName(i))) {
                            String string = query.getString(i);
                            if (!TextUtils.isEmpty(string) && string.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setMake(string.substring(8));
                            }
                            byte[] blob = query.getBlob(i);
                            if (blob != null) {
                                try {
                                    historyVehicleModel.setMake(new String(blob, historyVehicleModel.getCharSet()));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else if (strArr[5].contentEquals(query.getColumnName(i))) {
                            String string2 = query.getString(i);
                            if (!TextUtils.isEmpty(string2) && string2.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setModel(string2.substring(8));
                            } else {
                                byte[] blob2 = query.getBlob(i);
                                if (blob2 != null) {
                                    try {
                                        historyVehicleModel.setModel(new String(blob2, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[6].contentEquals(query.getColumnName(i))) {
                            String string3 = query.getString(i);
                            if (!TextUtils.isEmpty(string3) && string3.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setSubmodel(string3.substring(8));
                            } else {
                                byte[] blob3 = query.getBlob(i);
                                if (blob3 != null) {
                                    try {
                                        historyVehicleModel.setSubmodel(new String(blob3, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[7].contentEquals(query.getColumnName(i))) {
                            String string4 = query.getString(i);
                            if (!TextUtils.isEmpty(string4) && string4.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setEngine(string4.substring(8));
                            } else {
                                byte[] blob4 = query.getBlob(i);
                                if (blob4 != null) {
                                    try {
                                        historyVehicleModel.setEngine(new String(blob4, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[8].contentEquals(query.getColumnName(i))) {
                            String string5 = query.getString(i);
                            if (!TextUtils.isEmpty(string5) && string5.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setYear(string5.substring(8));
                            } else {
                                byte[] blob5 = query.getBlob(i);
                                if (blob5 != null) {
                                    try {
                                        historyVehicleModel.setYear(new String(blob5, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[9].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setLicenseNumber(query.getString(i));
                        } else if (strArr[10].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setMileage(query.getInt(i));
                        } else if (strArr[11].contentEquals(query.getColumnName(i))) {
                            String string6 = query.getString(i);
                            if (!TextUtils.isEmpty(string6) && string6.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setColor(string6.substring(8));
                            } else {
                                byte[] blob6 = query.getBlob(i);
                                if (blob6 != null) {
                                    try {
                                        historyVehicleModel.setColor(new String(blob6, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[12].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setVIN(query.getString(i));
                        } else if (strArr[13].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setDiagVersion(query.getString(i));
                        } else if (strArr[14].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setVehicleVersion(query.getString(i));
                        } else if (strArr[15].contentEquals(query.getColumnName(i))) {
                            byte[] blob7 = query.getBlob(i);
                            if (blob7 != null) {
                                try {
                                    historyVehicleModel.setVehicleInformation(new String(blob7, historyVehicleModel.getCharSet()));
                                } catch (UnsupportedEncodingException e7) {
                                    e7.printStackTrace();
                                }
                            }
                        } else if (strArr[16].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setStaffID(query.getString(i));
                        } else if (strArr[17].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setTimeStamp(query.getString(i));
                        } else if (strArr[18].contentEquals(query.getColumnName(i))) {
                            byte[] blob8 = query.getBlob(i);
                            if (blob8 != null) {
                                try {
                                    historyVehicleModel.setRemark(new String(blob8, historyVehicleModel.getCharSet()));
                                } catch (UnsupportedEncodingException e8) {
                                    e8.printStackTrace();
                                }
                            }
                        } else if (strArr[19].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setOwnerID(query.getInt(i));
                        } else if (strArr[20].contentEquals(query.getColumnName(i))) {
                            String string7 = query.getString(i);
                            if (!TextUtils.isEmpty(string7) && string7.indexOf("CLD_FLAG") != -1) {
                                historyVehicleModel.setPath(string7.substring(8));
                            } else {
                                byte[] blob9 = query.getBlob(i);
                                if (blob9 != null) {
                                    try {
                                        historyVehicleModel.setPath(new String(blob9, historyVehicleModel.getCharSet()));
                                    } catch (UnsupportedEncodingException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                            }
                        } else if (strArr[21].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setVehiclePath(query.getString(i));
                        } else if (strArr[22].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setTimeStampYearMonth(query.getString(i));
                        } else if (strArr[23].contentEquals(query.getColumnName(i))) {
                            historyVehicleModel.setLanguage(query.getInt(i));
                        }
                    }
                    arrayList.add(historyVehicleModel);
                } while (query.moveToNext());
                return arrayList;
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        } finally {
            m5299a(this.f15563e);
        }
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: b */
    private static HashMap<Integer, Integer> m5292b(SQLiteDatabase sQLiteDatabase) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (sQLiteDatabase == null) {
            return hashMap;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select VID, COUNT(1) AS Number from System group by VID", null);
            if (rawQuery.moveToFirst()) {
                do {
                    int i = rawQuery.getInt(0);
                    int i2 = rawQuery.getInt(1);
                    if (i > 0) {
                        hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                    }
                } while (rawQuery.moveToNext());
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    /* renamed from: b */
    private List<HistorySystemModel> m5293b(int i, String str) {
        ArrayList arrayList = new ArrayList();
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        if (sQLiteOpenHelper == null) {
            return arrayList;
        }
        String[] strArr = {"SystemID", "SystemIndex", "NameID", "SystemUID", "SystemName", "AvailableDatastream", "AvailableAction", "VID"};
        try {
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                Cursor query = this.f15563e.query("System", strArr, "VID = ?", new String[]{String.valueOf(i)}, null, null, null);
                if (query.moveToFirst()) {
                    do {
                        HistorySystemModel historySystemModel = new HistorySystemModel();
                        for (int i2 = 0; i2 < query.getColumnCount(); i2++) {
                            if (strArr[0].contentEquals(query.getColumnName(i2))) {
                                historySystemModel.setSystemID(query.getInt(i2));
                            } else if (strArr[1].contentEquals(query.getColumnName(i2))) {
                                historySystemModel.setSystemIndex(query.getInt(i2));
                            } else if (strArr[2].contentEquals(query.getColumnName(i2))) {
                                historySystemModel.setNameID(query.getString(i2));
                            } else if (strArr[3].contentEquals(query.getColumnName(i2))) {
                                historySystemModel.setSystemUID(query.getString(i2));
                            } else if (strArr[4].contentEquals(query.getColumnName(i2))) {
                                byte[] blob = query.getBlob(i2);
                                if (blob != null) {
                                    try {
                                        historySystemModel.setSystemName(new String(blob, str));
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (strArr[5].contentEquals(query.getColumnName(i2))) {
                                byte[] blob2 = query.getBlob(i2);
                                if (blob2 != null) {
                                    try {
                                        historySystemModel.setAvailableDatastream(new String(blob2, str));
                                    } catch (UnsupportedEncodingException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else if (strArr[6].contentEquals(query.getColumnName(i2))) {
                                byte[] blob3 = query.getBlob(i2);
                                if (blob3 != null) {
                                    try {
                                        historySystemModel.setAvailableAction(new String(blob3, str));
                                    } catch (UnsupportedEncodingException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } else if (strArr[7].contentEquals(query.getColumnName(i2))) {
                                historySystemModel.setVID(query.getInt(i2));
                            }
                        }
                        arrayList.add(historySystemModel);
                    } while (query.moveToNext());
                }
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } finally {
            m5299a(this.f15563e);
        }
    }

    /* renamed from: a */
    public final long m5297a(VehicleInfo vehicleInfo) {
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        long j = -1;
        if (sQLiteOpenHelper == null) {
            return -1L;
        }
        try {
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("SN", vehicleInfo.getSN());
                contentValues.put("VehicleUID", vehicleInfo.getVehicleUID());
                contentValues.put("Make", "CLD_FLAG" + vehicleInfo.getMark());
                contentValues.put("Model", "CLD_FLAG" + vehicleInfo.getModel());
                contentValues.put("SubModel", "CLD_FLAG" + vehicleInfo.getSubModel());
                contentValues.put("Engine", "CLD_FLAG" + vehicleInfo.getEngine());
                contentValues.put("Year", "CLD_FLAG" + vehicleInfo.getYear());
                contentValues.put("LicenseNumber", vehicleInfo.getLicenseNumber());
                contentValues.put("Mileage", Integer.valueOf(vehicleInfo.getMileage()));
                contentValues.put("Color", "CLD_FLAG" + vehicleInfo.getColor());
                contentValues.put("VIN", vehicleInfo.getVIN());
                contentValues.put("DiagSoftVersion", vehicleInfo.getDiagSoftVersion());
                contentValues.put("VehicleSoftVersion", vehicleInfo.getVehicleSoftVersion());
                contentValues.put("Remark", "cloud");
                contentValues.put("CharSet", "GB2312");
                contentValues.put("Language", Integer.valueOf(vehicleInfo.getLanguage()));
                contentValues.put("VehiclePath", vehicleInfo.getPath());
                contentValues.put("UploadFlag", (Integer) 1);
                j = this.f15563e.insert("Vehicle", null, contentValues);
                List<CloudSystemInfo> sysInfo = vehicleInfo.getSysInfo();
                if (sysInfo != null) {
                    for (int i = 0; i < sysInfo.size(); i++) {
                        CloudSystemInfo cloudSystemInfo = sysInfo.get(i);
                        if (TextUtils.isEmpty(cloudSystemInfo.f15497a) || !cloudSystemInfo.f15497a.equalsIgnoreCase("UNKNOWN_SYS")) {
                            try {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("NameID", cloudSystemInfo.f15499c);
                                contentValues2.put("SystemUID", cloudSystemInfo.f15498b);
                                contentValues2.put("SystemName", cloudSystemInfo.f15497a);
                                contentValues2.put("SystemIndex", Integer.valueOf(i + 1));
                                contentValues2.put("VID", Long.valueOf(j));
                                this.f15563e.insert("System", null, contentValues2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return j;
        } finally {
            m5299a(this.f15563e);
        }
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: a */
    private HashMap<Integer, Integer> m5303a() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        if (sQLiteOpenHelper == null) {
            return hashMap;
        }
        try {
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                Cursor rawQuery = this.f15563e.rawQuery("select VID, COUNT(1) AS Number from DTC group by VID", null);
                if (rawQuery.moveToFirst()) {
                    do {
                        int i = rawQuery.getInt(0);
                        int i2 = rawQuery.getInt(1);
                        if (i > 0) {
                            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                        }
                    } while (rawQuery.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hashMap;
        } finally {
            m5299a(this.f15563e);
        }
    }

    /* renamed from: a */
    public final List<HistoryDTCModel> m5302a(int i, String str) {
        ArrayList<HistoryDTCModel> arrayList = new ArrayList();
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        if (sQLiteOpenHelper == null) {
            return arrayList;
        }
        String[] strArr = {"DtcID", "DTC", "Description", "Status", "SystemID", "TimeStamp", "VID", "IsShowSystem"};
        try {
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                Cursor query = this.f15563e.query("DTC", strArr, "VID = ?", new String[]{String.valueOf(i)}, null, null, null);
                if (query.moveToFirst()) {
                    do {
                        HistoryDTCModel historyDTCModel = new HistoryDTCModel();
                        for (int i2 = 0; i2 < query.getColumnCount(); i2++) {
                            if (strArr[0].contentEquals(query.getColumnName(i2))) {
                                historyDTCModel.setDtcID(query.getInt(i2));
                            } else if (strArr[1].contentEquals(query.getColumnName(i2))) {
                                byte[] blob = query.getBlob(i2);
                                if (blob != null) {
                                    try {
                                        historyDTCModel.setDTC(new String(blob, str));
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (strArr[2].contentEquals(query.getColumnName(i2))) {
                                byte[] blob2 = query.getBlob(i2);
                                if (blob2 != null) {
                                    try {
                                        historyDTCModel.setDescription(new String(blob2, str));
                                    } catch (UnsupportedEncodingException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else if (strArr[3].contentEquals(query.getColumnName(i2))) {
                                byte[] blob3 = query.getBlob(i2);
                                if (blob3 != null) {
                                    try {
                                        historyDTCModel.setStatus(new String(blob3, str));
                                    } catch (UnsupportedEncodingException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } else if (strArr[4].contentEquals(query.getColumnName(i2))) {
                                historyDTCModel.setSystemID(query.getInt(i2));
                            } else if (strArr[5].contentEquals(query.getColumnName(i2))) {
                                historyDTCModel.setTimeStamp(query.getString(i2));
                            } else if (strArr[6].contentEquals(query.getColumnName(i2))) {
                                historyDTCModel.setVID(query.getInt(i2));
                            } else if (strArr[7].contentEquals(query.getColumnName(i2))) {
                                historyDTCModel.setIsShowSystem(query.getInt(i2));
                            }
                        }
                        arrayList.add(historyDTCModel);
                    } while (query.moveToNext());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            m5299a(this.f15563e);
            if (arrayList.size() == 0) {
                return arrayList;
            }
            NLog.m9456a("HistoryDao", "getDTCByVID3");
            List<HistorySystemModel> m5293b = m5293b(i, str);
            NLog.m9456a("HistoryDao", "getDTCByVID4");
            int i3 = 0;
            for (HistoryDTCModel historyDTCModel2 : arrayList) {
                if (historyDTCModel2.getSystemID() != 0 && 1 == historyDTCModel2.getIsShowSystem()) {
                    while (true) {
                        if (i3 >= m5293b.size()) {
                            break;
                        } else if (m5293b.get(i3).getSystemID() == historyDTCModel2.getSystemID()) {
                            historyDTCModel2.setSystemName(m5293b.get(i3).getSystemName());
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            NLog.m9456a("HistoryDao", "getDTCByVID5");
            return arrayList;
        } catch (Throwable th) {
            m5299a(this.f15563e);
            throw th;
        }
    }

    /* renamed from: a */
    public final boolean m5301a(int i, boolean z) {
        SQLiteOpenHelper sQLiteOpenHelper = this.f15564f;
        if (sQLiteOpenHelper == null) {
            return false;
        }
        try {
            try {
                this.f15563e = sQLiteOpenHelper.getWritableDatabase();
                String[] strArr = {String.valueOf(i)};
                this.f15563e.beginTransaction();
                this.f15563e.delete("DTC", "VID=?", strArr);
                this.f15563e.delete("System", "VID=?", strArr);
                int delete = this.f15563e.delete("Vehicle", "VID=?", strArr);
                this.f15563e.setTransactionSuccessful();
                this.f15563e.endTransaction();
                boolean z2 = 1 == delete;
                if (z) {
                    m5299a(this.f15563e);
                }
                return z2;
            } catch (Exception e) {
                NLog.m9451c("HistoryDao", e);
                if (z) {
                    m5299a(this.f15563e);
                }
                return false;
            }
        } catch (Throwable th) {
            if (z) {
                m5299a(this.f15563e);
            }
            throw th;
        }
    }

    /* renamed from: c */
    private void m5290c(SQLiteDatabase sQLiteDatabase) {
        int i;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            Cursor query = sQLiteDatabase.query("Vehicle", new String[]{"VID"}, null, null, null, null, null);
            HashMap<Integer, Integer> m5292b = m5292b(sQLiteDatabase);
            if (query.moveToFirst()) {
                do {
                    try {
                        i = m5292b.get(Integer.valueOf(query.getInt(0))).intValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        i = 0;
                    }
                    if (i == 0) {
                        m5301a(query.getInt(0), false);
                    }
                } while (query.moveToNext());
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
    }
}
