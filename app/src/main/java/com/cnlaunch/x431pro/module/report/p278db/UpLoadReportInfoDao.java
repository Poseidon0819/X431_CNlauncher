package com.cnlaunch.x431pro.module.report.p278db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.mopub.mobileads.VastExtensionXmlManager;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* renamed from: com.cnlaunch.x431pro.module.report.db.UpLoadReportInfoDao */
/* loaded from: classes.dex */
public class UpLoadReportInfoDao extends AbstractDao<UpLoadReportInfo, Long> {
    public static final String TABLENAME = "UP_LOAD_REPORT_INFO";

    /* renamed from: com.cnlaunch.x431pro.module.report.db.UpLoadReportInfoDao$Properties */
    /* loaded from: classes.dex */
    public static class Properties {

        /* renamed from: Id */
        public static final Property f15667Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Report_key = new Property(1, String.class, "report_key", false, "REPORT_KEY");
        public static final Property Theme = new Property(2, String.class, "theme", false, "THEME");
        public static final Property Fault_codes = new Property(3, String.class, "fault_codes", false, "FAULT_CODES");
        public static final Property Data_flow = new Property(4, String.class, "data_flow", false, "DATA_FLOW");
        public static final Property Conclusion = new Property(5, String.class, "conclusion", false, "CONCLUSION");
        public static final Property Diagnosis_start_time = new Property(6, String.class, "diagnosis_start_time", false, "DIAGNOSIS_START_TIME");
        public static final Property Diagnosis_time = new Property(7, String.class, "diagnosis_time", false, "DIAGNOSIS_TIME");
        public static final Property Serial_no = new Property(8, String.class, "serial_no", false, "SERIAL_NO");
        public static final Property GoloId = new Property(9, String.class, "goloId", false, "GOLO_ID");
        public static final Property Type = new Property(10, String.class, VastExtensionXmlManager.TYPE, false, "TYPE");
        public static final Property Cars = new Property(11, String.class, "cars", false, "CARS");
        public static final Property Language = new Property(12, String.class, "language", false, "LANGUAGE");
        public static final Property Diagnosis_time_long = new Property(13, String.class, "diagnosis_time_long", false, "DIAGNOSIS_TIME_LONG");
        public static final Property Technician_lon = new Property(14, String.class, "technician_lon", false, "TECHNICIAN_LON");
        public static final Property Technician_lat = new Property(15, String.class, "technician_lat", false, "TECHNICIAN_LAT");
        public static final Property Car_lon = new Property(16, String.class, "car_lon", false, "CAR_LON");
        public static final Property Car_lat = new Property(17, String.class, "car_lat", false, "CAR_LAT");
        public static final Property Messagelist = new Property(18, String.class, "messagelist", false, "MESSAGELIST");
        public static final Property Vin = new Property(19, String.class, "vin", false, "VIN");
        public static final Property Pro_serial_no = new Property(20, String.class, "pro_serial_no", false, "PRO_SERIAL_NO");
        public static final Property Odo = new Property(21, String.class, "odo", false, "ODO");
        public static final Property Plate_num = new Property(22, String.class, "plate_num", false, "PLATE_NUM");
        public static final Property Version = new Property(23, String.class, "version", false, "VERSION");
        public static final Property Operationlist = new Property(24, String.class, "operationlist", false, "OPERATIONLIST");
    }

    @Override // de.greenrobot.dao.AbstractDao
    public boolean isEntityUpdateable() {
        return true;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void bindValues(SQLiteStatement sQLiteStatement, UpLoadReportInfo upLoadReportInfo) {
        UpLoadReportInfo upLoadReportInfo2 = upLoadReportInfo;
        sQLiteStatement.clearBindings();
        Long id = upLoadReportInfo2.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindString(2, upLoadReportInfo2.getReport_key());
        String theme = upLoadReportInfo2.getTheme();
        if (theme != null) {
            sQLiteStatement.bindString(3, theme);
        }
        String fault_codes = upLoadReportInfo2.getFault_codes();
        if (fault_codes != null) {
            sQLiteStatement.bindString(4, fault_codes);
        }
        String data_flow = upLoadReportInfo2.getData_flow();
        if (data_flow != null) {
            sQLiteStatement.bindString(5, data_flow);
        }
        String conclusion = upLoadReportInfo2.getConclusion();
        if (conclusion != null) {
            sQLiteStatement.bindString(6, conclusion);
        }
        String diagnosis_start_time = upLoadReportInfo2.getDiagnosis_start_time();
        if (diagnosis_start_time != null) {
            sQLiteStatement.bindString(7, diagnosis_start_time);
        }
        String diagnosis_time = upLoadReportInfo2.getDiagnosis_time();
        if (diagnosis_time != null) {
            sQLiteStatement.bindString(8, diagnosis_time);
        }
        String serial_no = upLoadReportInfo2.getSerial_no();
        if (serial_no != null) {
            sQLiteStatement.bindString(9, serial_no);
        }
        String goloId = upLoadReportInfo2.getGoloId();
        if (goloId != null) {
            sQLiteStatement.bindString(10, goloId);
        }
        String type = upLoadReportInfo2.getType();
        if (type != null) {
            sQLiteStatement.bindString(11, type);
        }
        String cars = upLoadReportInfo2.getCars();
        if (cars != null) {
            sQLiteStatement.bindString(12, cars);
        }
        String language = upLoadReportInfo2.getLanguage();
        if (language != null) {
            sQLiteStatement.bindString(13, language);
        }
        String diagnosis_time_long = upLoadReportInfo2.getDiagnosis_time_long();
        if (diagnosis_time_long != null) {
            sQLiteStatement.bindString(14, diagnosis_time_long);
        }
        String technician_lon = upLoadReportInfo2.getTechnician_lon();
        if (technician_lon != null) {
            sQLiteStatement.bindString(15, technician_lon);
        }
        String technician_lat = upLoadReportInfo2.getTechnician_lat();
        if (technician_lat != null) {
            sQLiteStatement.bindString(16, technician_lat);
        }
        String car_lon = upLoadReportInfo2.getCar_lon();
        if (car_lon != null) {
            sQLiteStatement.bindString(17, car_lon);
        }
        String car_lat = upLoadReportInfo2.getCar_lat();
        if (car_lat != null) {
            sQLiteStatement.bindString(18, car_lat);
        }
        String messagelist = upLoadReportInfo2.getMessagelist();
        if (messagelist != null) {
            sQLiteStatement.bindString(19, messagelist);
        }
        String vin = upLoadReportInfo2.getVin();
        if (vin != null) {
            sQLiteStatement.bindString(20, vin);
        }
        String pro_serial_no = upLoadReportInfo2.getPro_serial_no();
        if (pro_serial_no != null) {
            sQLiteStatement.bindString(21, pro_serial_no);
        }
        String odo = upLoadReportInfo2.getOdo();
        if (odo != null) {
            sQLiteStatement.bindString(22, odo);
        }
        String plate_num = upLoadReportInfo2.getPlate_num();
        if (plate_num != null) {
            sQLiteStatement.bindString(23, plate_num);
        }
        String version = upLoadReportInfo2.getVersion();
        if (version != null) {
            sQLiteStatement.bindString(24, version);
        }
        String operationlist = upLoadReportInfo2.getOperationlist();
        if (operationlist != null) {
            sQLiteStatement.bindString(25, operationlist);
        }
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long getKey(UpLoadReportInfo upLoadReportInfo) {
        UpLoadReportInfo upLoadReportInfo2 = upLoadReportInfo;
        if (upLoadReportInfo2 != null) {
            return upLoadReportInfo2.getId();
        }
        return null;
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ void readEntity(Cursor cursor, UpLoadReportInfo upLoadReportInfo, int i) {
        UpLoadReportInfo upLoadReportInfo2 = upLoadReportInfo;
        int i2 = i + 0;
        upLoadReportInfo2.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        upLoadReportInfo2.setReport_key(cursor.getString(i + 1));
        int i3 = i + 2;
        upLoadReportInfo2.setTheme(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        upLoadReportInfo2.setFault_codes(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 4;
        upLoadReportInfo2.setData_flow(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 5;
        upLoadReportInfo2.setConclusion(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        upLoadReportInfo2.setDiagnosis_start_time(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 7;
        upLoadReportInfo2.setDiagnosis_time(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 8;
        upLoadReportInfo2.setSerial_no(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 9;
        upLoadReportInfo2.setGoloId(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 10;
        upLoadReportInfo2.setType(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 11;
        upLoadReportInfo2.setCars(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 12;
        upLoadReportInfo2.setLanguage(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 13;
        upLoadReportInfo2.setDiagnosis_time_long(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 14;
        upLoadReportInfo2.setTechnician_lon(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 15;
        upLoadReportInfo2.setTechnician_lat(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 16;
        upLoadReportInfo2.setCar_lon(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i + 17;
        upLoadReportInfo2.setCar_lat(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i + 18;
        upLoadReportInfo2.setMessagelist(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 19;
        upLoadReportInfo2.setVin(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 20;
        upLoadReportInfo2.setPro_serial_no(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i + 21;
        upLoadReportInfo2.setOdo(cursor.isNull(i22) ? null : cursor.getString(i22));
        int i23 = i + 22;
        upLoadReportInfo2.setPlate_num(cursor.isNull(i23) ? null : cursor.getString(i23));
        int i24 = i + 23;
        upLoadReportInfo2.setVersion(cursor.isNull(i24) ? null : cursor.getString(i24));
        int i25 = i + 24;
        upLoadReportInfo2.setOperationlist(cursor.isNull(i25) ? null : cursor.getString(i25));
    }

    @Override // de.greenrobot.dao.AbstractDao
    public /* synthetic */ Long updateKeyAfterInsert(UpLoadReportInfo upLoadReportInfo, long j) {
        upLoadReportInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public UpLoadReportInfoDao(DaoConfig daoConfig, ReportDaoSession reportDaoSession) {
        super(daoConfig, reportDaoSession);
    }

    /* renamed from: a */
    public static void m5219a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE 'UP_LOAD_REPORT_INFO' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'REPORT_KEY' TEXT NOT NULL ,'THEME' TEXT,'FAULT_CODES' TEXT,'DATA_FLOW' TEXT,'CONCLUSION' TEXT,'DIAGNOSIS_START_TIME' TEXT,'DIAGNOSIS_TIME' TEXT,'SERIAL_NO' TEXT,'GOLO_ID' TEXT,'TYPE' TEXT,'CARS' TEXT,'LANGUAGE' TEXT,'DIAGNOSIS_TIME_LONG' TEXT,'TECHNICIAN_LON' TEXT,'TECHNICIAN_LAT' TEXT,'CAR_LON' TEXT,'CAR_LAT' TEXT,'MESSAGELIST' TEXT,'VIN' TEXT,'PRO_SERIAL_NO' TEXT,'ODO' TEXT,'PLATE_NUM' TEXT,'VERSION' TEXT,'OPERATIONLIST' TEXT);");
    }

    /* renamed from: b */
    public static void m5218b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'UP_LOAD_REPORT_INFO'");
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
    public /* synthetic */ UpLoadReportInfo readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        String string = cursor.getString(i + 1);
        int i3 = i + 2;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 3;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 4;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 5;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 6;
        String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 7;
        String string7 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 8;
        String string8 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 9;
        String string9 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = i + 10;
        String string10 = cursor.isNull(i11) ? null : cursor.getString(i11);
        int i12 = i + 11;
        String string11 = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i + 12;
        String string12 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 13;
        String string13 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 14;
        String string14 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 15;
        String string15 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 16;
        String string16 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i + 17;
        String string17 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 18;
        String string18 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 19;
        String string19 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 20;
        String string20 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 21;
        String string21 = cursor.isNull(i22) ? null : cursor.getString(i22);
        int i23 = i + 22;
        String string22 = cursor.isNull(i23) ? null : cursor.getString(i23);
        int i24 = i + 23;
        String string23 = cursor.isNull(i24) ? null : cursor.getString(i24);
        int i25 = i + 24;
        return new UpLoadReportInfo(valueOf, string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, cursor.isNull(i25) ? null : cursor.getString(i25));
    }
}
