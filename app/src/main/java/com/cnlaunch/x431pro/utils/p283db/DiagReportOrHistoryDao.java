package com.cnlaunch.x431pro.utils.p283db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.mopub.mobileads.VastExtensionXmlManager;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.utils.db.DiagReportOrHistoryDao */
/* loaded from: classes.dex */
public class DiagReportOrHistoryDao extends AbstractDao<DiagReportOrHistoryInfo, Long> {
    public static final String TABLENAME = "DIAG_REPORT_OR_HISTORY_INFO";

    /* renamed from: com.cnlaunch.x431pro.utils.db.DiagReportOrHistoryDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15771Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Type = new Property(1, Integer.class, VastExtensionXmlManager.TYPE, false, "TYPE");
        public static final Property RepairType = new Property(2, Integer.class, "RepairType", false, "REPAIR_TYPE");
        public static final Property StrTester = new Property(3, String.class, "strTester", false, "strTester");
        public static final Property StrCustomer = new Property(4, String.class, "strCustomer", false, "strCustomer");
        public static final Property Title = new Property(5, String.class, "title", false, "title");
        public static final Property PdfFileName = new Property(6, String.class, "pdfFileName", false, "pdfFileName");
        public static final Property ReportLogoPath = new Property(7, String.class, "reportLogoPath", false, "reportLogoPath");
        public static final Property StrShopName = new Property(8, String.class, "strShopName", false, "strShopName");
        public static final Property StrAddr = new Property(9, String.class, "strAddr", false, "strAddr");
        public static final Property StrPhone = new Property(10, String.class, "strPhone", false, "strPhone");
        public static final Property StrEmail = new Property(11, String.class, "strEmail", false, "strEmail");
        public static final Property StrFax = new Property(12, String.class, "strFax", false, "strFax");
        public static final Property StrZipCode = new Property(13, String.class, "strZipCode", false, "strZipCode");
        public static final Property DiagnoseReportPlatenumber = new Property(14, String.class, "diagnoseReportPlatenumber", false, "diagnoseReportPlatenumber");
        public static final Property StrcarType = new Property(15, String.class, "strcarType", false, "strcarType");
        public static final Property StrCarMode = new Property(16, String.class, "strCarMode", false, "strCarMode");
        public static final Property StrCarYear = new Property(17, String.class, "strCarYear", false, "strCarYear");
        public static final Property StrCarVin = new Property(18, String.class, "strCarVin", false, "strCarVin");
        public static final Property StrODO = new Property(19, String.class, "strODO", false, "strODO");
        public static final Property StrSoftVer = new Property(20, String.class, "strSoftVer", false, "strSoftVer");
        public static final Property StrApkVer = new Property(21, String.class, "strApkVer", false, "strApkVer");
        public static final Property StrTime = new Property(22, String.class, "strTime", false, "strTime");
        public static final Property StrPath = new Property(23, String.class, "strPath", false, "strPath");
        public static final Property StrRemark = new Property(24, String.class, "strRemark", false, "strRemark");
        public static final Property StrSerialNo = new Property(25, String.class, "strSerialNo", false, "strSerialNo");
        public static final Property DataStrJson = new Property(26, String.class, "dataStrJson", false, "dataStrJson");
        public static final Property IsRemoteReport = new Property(27, Boolean.TYPE, "isRemoteReport", false, "isRemoteReport");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, DiagReportOrHistoryInfo diagReportOrHistoryInfo) {
        DiagReportOrHistoryInfo diagReportOrHistoryInfo2 = diagReportOrHistoryInfo;
        sQLiteStatement.clearBindings();
        Long id = diagReportOrHistoryInfo2.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, diagReportOrHistoryInfo2.getType());
        sQLiteStatement.bindLong(3, diagReportOrHistoryInfo2.getRepairType());
        String strTester = diagReportOrHistoryInfo2.getStrTester();
        if (strTester != null) {
            sQLiteStatement.bindString(4, strTester);
        }
        String strCustomer = diagReportOrHistoryInfo2.getStrCustomer();
        if (strCustomer != null) {
            sQLiteStatement.bindString(5, strCustomer);
        }
        String title = diagReportOrHistoryInfo2.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(6, title);
        }
        String pdfFileName = diagReportOrHistoryInfo2.getPdfFileName();
        if (pdfFileName != null) {
            sQLiteStatement.bindString(7, pdfFileName);
        }
        String reportLogoPath = diagReportOrHistoryInfo2.getReportLogoPath();
        if (reportLogoPath != null) {
            sQLiteStatement.bindString(8, reportLogoPath);
        }
        String strShopName = diagReportOrHistoryInfo2.getStrShopName();
        if (strShopName != null) {
            sQLiteStatement.bindString(9, strShopName);
        }
        String strAddr = diagReportOrHistoryInfo2.getStrAddr();
        if (strAddr != null) {
            sQLiteStatement.bindString(10, strAddr);
        }
        String strPhone = diagReportOrHistoryInfo2.getStrPhone();
        if (strPhone != null) {
            sQLiteStatement.bindString(11, strPhone);
        }
        String strEmail = diagReportOrHistoryInfo2.getStrEmail();
        if (strEmail != null) {
            sQLiteStatement.bindString(12, strEmail);
        }
        String strFax = diagReportOrHistoryInfo2.getStrFax();
        if (strFax != null) {
            sQLiteStatement.bindString(13, strFax);
        }
        String strZipCode = diagReportOrHistoryInfo2.getStrZipCode();
        if (strZipCode != null) {
            sQLiteStatement.bindString(14, strZipCode);
        }
        String diagnoseReportPlatenumber = diagReportOrHistoryInfo2.getDiagnoseReportPlatenumber();
        if (diagnoseReportPlatenumber != null) {
            sQLiteStatement.bindString(15, diagnoseReportPlatenumber);
        }
        String strcarType = diagReportOrHistoryInfo2.getStrcarType();
        if (strcarType != null) {
            sQLiteStatement.bindString(16, strcarType);
        }
        String strCarMode = diagReportOrHistoryInfo2.getStrCarMode();
        if (strCarMode != null) {
            sQLiteStatement.bindString(17, strCarMode);
        }
        String strCarYear = diagReportOrHistoryInfo2.getStrCarYear();
        if (strCarYear != null) {
            sQLiteStatement.bindString(18, strCarYear);
        }
        String strCarVin = diagReportOrHistoryInfo2.getStrCarVin();
        if (strCarVin != null) {
            sQLiteStatement.bindString(19, strCarVin);
        }
        String strODO = diagReportOrHistoryInfo2.getStrODO();
        if (strODO != null) {
            sQLiteStatement.bindString(20, strODO);
        }
        String strSoftVer = diagReportOrHistoryInfo2.getStrSoftVer();
        if (strSoftVer != null) {
            sQLiteStatement.bindString(21, strSoftVer);
        }
        String strApkVer = diagReportOrHistoryInfo2.getStrApkVer();
        if (strApkVer != null) {
            sQLiteStatement.bindString(22, strApkVer);
        }
        String strTime = diagReportOrHistoryInfo2.getStrTime();
        if (strTime != null) {
            sQLiteStatement.bindString(23, strTime);
        }
        String strPath = diagReportOrHistoryInfo2.getStrPath();
        if (strPath != null) {
            sQLiteStatement.bindString(24, strPath);
        }
        String strRemark = diagReportOrHistoryInfo2.getStrRemark();
        if (strRemark != null) {
            sQLiteStatement.bindString(25, strRemark);
        }
        String strSerialNo = diagReportOrHistoryInfo2.getStrSerialNo();
        if (strSerialNo != null) {
            sQLiteStatement.bindString(26, strSerialNo);
        }
        String dataStrJson = diagReportOrHistoryInfo2.getDataStrJson();
        if (dataStrJson != null) {
            sQLiteStatement.bindString(27, dataStrJson);
        }
        sQLiteStatement.bindLong(28, diagReportOrHistoryInfo2.isRemoteReport() ? 1L : 0L);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(DiagReportOrHistoryInfo diagReportOrHistoryInfo) {
        DiagReportOrHistoryInfo diagReportOrHistoryInfo2 = diagReportOrHistoryInfo;
        if (diagReportOrHistoryInfo2 != null) {
            return Long.valueOf(diagReportOrHistoryInfo2.getId().longValue());
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, DiagReportOrHistoryInfo diagReportOrHistoryInfo, int i) {
        DiagReportOrHistoryInfo diagReportOrHistoryInfo2 = diagReportOrHistoryInfo;
        int i2 = i + 0;
        diagReportOrHistoryInfo2.setId(Long.valueOf(cursor.isNull(i2) ? 0L : cursor.getLong(i2)));
        int i3 = i + 1;
        diagReportOrHistoryInfo2.setType(cursor.isNull(i3) ? 0 : cursor.getInt(i3));
        int i4 = i + 2;
        diagReportOrHistoryInfo2.setRepairType(cursor.isNull(i4) ? 0 : cursor.getInt(i4));
        int i5 = i + 3;
        diagReportOrHistoryInfo2.setStrTester(cursor.isNull(i5) ? "" : cursor.getString(i5));
        int i6 = i + 4;
        diagReportOrHistoryInfo2.setStrCustomer(cursor.isNull(i6) ? "" : cursor.getString(i6));
        int i7 = i + 5;
        diagReportOrHistoryInfo2.setTitle(cursor.isNull(i7) ? "" : cursor.getString(i7));
        int i8 = i + 6;
        diagReportOrHistoryInfo2.setPdfFileName(cursor.isNull(i8) ? "" : cursor.getString(i8));
        int i9 = i + 7;
        diagReportOrHistoryInfo2.setReportLogoPath(cursor.isNull(i9) ? "" : cursor.getString(i9));
        int i10 = i + 8;
        diagReportOrHistoryInfo2.setStrShopName(cursor.isNull(i10) ? "" : cursor.getString(i10));
        int i11 = i + 9;
        diagReportOrHistoryInfo2.setStrAddr(cursor.isNull(i11) ? "" : cursor.getString(i11));
        int i12 = i + 10;
        diagReportOrHistoryInfo2.setStrPhone(cursor.isNull(i12) ? "" : cursor.getString(i12));
        int i13 = i + 11;
        diagReportOrHistoryInfo2.setStrEmail(cursor.isNull(i13) ? "" : cursor.getString(i13));
        int i14 = i + 12;
        diagReportOrHistoryInfo2.setStrFax(cursor.isNull(i14) ? "" : cursor.getString(i14));
        int i15 = i + 13;
        diagReportOrHistoryInfo2.setStrZipCode(cursor.isNull(i15) ? "" : cursor.getString(i15));
        int i16 = i + 14;
        diagReportOrHistoryInfo2.setDiagnoseReportPlatenumber(cursor.isNull(i16) ? "" : cursor.getString(i16));
        int i17 = i + 15;
        diagReportOrHistoryInfo2.setStrcarType(cursor.isNull(i17) ? "" : cursor.getString(i17));
        int i18 = i + 16;
        diagReportOrHistoryInfo2.setStrCarMode(cursor.isNull(i18) ? "" : cursor.getString(i18));
        int i19 = i + 17;
        diagReportOrHistoryInfo2.setStrCarYear(cursor.isNull(i19) ? "" : cursor.getString(i19));
        int i20 = i + 18;
        diagReportOrHistoryInfo2.setStrCarVin(cursor.isNull(i20) ? "" : cursor.getString(i20));
        int i21 = i + 19;
        diagReportOrHistoryInfo2.setStrODO(cursor.isNull(i21) ? "" : cursor.getString(i21));
        int i22 = i + 20;
        diagReportOrHistoryInfo2.setStrSoftVer(cursor.isNull(i22) ? "" : cursor.getString(i22));
        int i23 = i + 21;
        diagReportOrHistoryInfo2.setStrApkVer(cursor.isNull(i23) ? "" : cursor.getString(i23));
        int i24 = i + 22;
        diagReportOrHistoryInfo2.setStrTime(cursor.isNull(i24) ? "" : cursor.getString(i24));
        int i25 = i + 23;
        diagReportOrHistoryInfo2.setStrPath(cursor.isNull(i25) ? "" : cursor.getString(i25));
        int i26 = i + 24;
        diagReportOrHistoryInfo2.setStrRemark(cursor.isNull(i26) ? "" : cursor.getString(i26));
        int i27 = i + 25;
        diagReportOrHistoryInfo2.setStrSerialNo(cursor.isNull(i27) ? "" : cursor.getString(i27));
        int i28 = i + 26;
        diagReportOrHistoryInfo2.setDataStrJson(cursor.isNull(i28) ? "" : cursor.getString(i28));
        diagReportOrHistoryInfo2.setRemoteReport(cursor.getInt(i + 27) != 0);
    }

    public DiagReportOrHistoryDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        super(daoConfig, abstractDaoSession);
    }

    /* renamed from: a */
    public static void m5057a(SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        sQLiteDatabase.execSQL("CREATE TABLE " + str + "'DIAG_REPORT_OR_HISTORY_INFO' ('_id' INTEGER PRIMARY KEY  ,'TYPE' INTEGER,'REPAIR_TYPE' INTEGER,'strTester' TEXT,'strCustomer' TEXT  ,'title' TEXT ,'pdfFileName' TEXT ,'reportLogoPath' TEXT ,'strShopName' TEXT ,'strAddr' TEXT ,'strPhone' TEXT ,'strEmail' TEXT ,'strFax' TEXT ,'strZipCode' TEXT ,'diagnoseReportPlatenumber' TEXT ,'strcarType' TEXT ,'strCarMode' TEXT ,'strCarYear' TEXT ,'strCarVin' TEXT ,'strODO' TEXT ,'strSoftVer' TEXT ,'strApkVer' TEXT ,'strTime' TEXT ,'strPath' TEXT ,'strRemark' TEXT ,'strSerialNo' TEXT ,'dataStrJson' TEXT ,'isRemoteReport' INTEGER );");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(DiagReportOrHistoryInfo diagReportOrHistoryInfo, long j) {
        return Long.valueOf(j);
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ DiagReportOrHistoryInfo readEntity(Cursor cursor, int i) {
        DiagReportOrHistoryInfo diagReportOrHistoryInfo = new DiagReportOrHistoryInfo();
        int i2 = i + 0;
        diagReportOrHistoryInfo.setId(Long.valueOf(cursor.isNull(i2) ? 0L : cursor.getLong(i2)));
        int i3 = i + 1;
        diagReportOrHistoryInfo.setType(cursor.isNull(i3) ? 0 : cursor.getInt(i3));
        int i4 = i + 2;
        diagReportOrHistoryInfo.setRepairType(cursor.isNull(i4) ? 0 : cursor.getInt(i4));
        int i5 = i + 3;
        diagReportOrHistoryInfo.setStrTester(cursor.isNull(i5) ? "" : cursor.getString(i5));
        int i6 = i + 4;
        diagReportOrHistoryInfo.setStrCustomer(cursor.isNull(i6) ? "" : cursor.getString(i6));
        int i7 = i + 5;
        diagReportOrHistoryInfo.setTitle(cursor.isNull(i7) ? "" : cursor.getString(i7));
        int i8 = i + 6;
        diagReportOrHistoryInfo.setPdfFileName(cursor.isNull(i8) ? "" : cursor.getString(i8));
        int i9 = i + 7;
        diagReportOrHistoryInfo.setReportLogoPath(cursor.isNull(i9) ? "" : cursor.getString(i9));
        int i10 = i + 8;
        diagReportOrHistoryInfo.setStrShopName(cursor.isNull(i10) ? "" : cursor.getString(i10));
        int i11 = i + 9;
        diagReportOrHistoryInfo.setStrAddr(cursor.isNull(i11) ? "" : cursor.getString(i11));
        int i12 = i + 10;
        diagReportOrHistoryInfo.setStrPhone(cursor.isNull(i12) ? "" : cursor.getString(i12));
        int i13 = i + 11;
        diagReportOrHistoryInfo.setStrEmail(cursor.isNull(i13) ? "" : cursor.getString(i13));
        int i14 = i + 12;
        diagReportOrHistoryInfo.setStrFax(cursor.isNull(i14) ? "" : cursor.getString(i14));
        int i15 = i + 13;
        diagReportOrHistoryInfo.setStrZipCode(cursor.isNull(i15) ? "" : cursor.getString(i15));
        int i16 = i + 14;
        diagReportOrHistoryInfo.setDiagnoseReportPlatenumber(cursor.isNull(i16) ? "" : cursor.getString(i16));
        int i17 = i + 15;
        diagReportOrHistoryInfo.setStrcarType(cursor.isNull(i17) ? "" : cursor.getString(i17));
        int i18 = i + 16;
        diagReportOrHistoryInfo.setStrCarMode(cursor.isNull(i18) ? "" : cursor.getString(i18));
        int i19 = i + 17;
        diagReportOrHistoryInfo.setStrCarYear(cursor.isNull(i19) ? "" : cursor.getString(i19));
        int i20 = i + 18;
        diagReportOrHistoryInfo.setStrCarVin(cursor.isNull(i20) ? "" : cursor.getString(i20));
        int i21 = i + 19;
        diagReportOrHistoryInfo.setStrODO(cursor.isNull(i21) ? "" : cursor.getString(i21));
        int i22 = i + 20;
        diagReportOrHistoryInfo.setStrSoftVer(cursor.isNull(i22) ? "" : cursor.getString(i22));
        int i23 = i + 21;
        diagReportOrHistoryInfo.setStrApkVer(cursor.isNull(i23) ? "" : cursor.getString(i23));
        int i24 = i + 22;
        diagReportOrHistoryInfo.setStrTime(cursor.isNull(i24) ? "" : cursor.getString(i24));
        int i25 = i + 23;
        diagReportOrHistoryInfo.setStrPath(cursor.isNull(i25) ? "" : cursor.getString(i25));
        int i26 = i + 24;
        diagReportOrHistoryInfo.setStrRemark(cursor.isNull(i26) ? "" : cursor.getString(i26));
        int i27 = i + 25;
        diagReportOrHistoryInfo.setStrSerialNo(cursor.isNull(i27) ? "" : cursor.getString(i27));
        int i28 = i + 26;
        diagReportOrHistoryInfo.setDataStrJson(cursor.isNull(i28) ? "" : cursor.getString(i28));
        diagReportOrHistoryInfo.setRemoteReport(cursor.getInt(i + 27) != 0);
        return diagReportOrHistoryInfo;
    }
}
