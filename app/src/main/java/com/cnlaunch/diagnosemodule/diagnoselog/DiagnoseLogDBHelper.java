package com.cnlaunch.diagnosemodule.diagnoselog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cnlaunch.p120d.p123b.p124a.SQLiteContext;
import com.cnlaunch.p120d.p130d.NLog;

/* loaded from: classes.dex */
final class DiagnoseLogDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "diagnose_log_data.db";
    private static final int DB_VERSION = 3;
    static final String TABLE_OFFLINE_FEED_BACK = "offline_feed_back";
    static final String TABLE_OFFLINE_FEED_BACK_DEVICE_SN_COL = "device_sn";
    static final String TABLE_OFFLINE_FEED_ZIP_FILENAME_COL = "zip_filename";
    static final String TABLE_OFFLINE_FEED_VEHICLE_TYPE_COL = "vehicle_type";
    static final String TABLE_OFFLINE_FEED_CREATE_DATE_COL = "create_date";
    static final String TABLE_OFFLINE_FEED_DIAGNOSE_LOG_FULL_FILE_PATH_COL = "diagnose_log_full_file_path";
    static final String[] TABLE_OFFLINE_FEED_BACK_COLUMNS = {TABLE_OFFLINE_FEED_BACK_DEVICE_SN_COL, TABLE_OFFLINE_FEED_ZIP_FILENAME_COL, TABLE_OFFLINE_FEED_VEHICLE_TYPE_COL, "remark", "log_type", "lang", "model", "year", "vin", TABLE_OFFLINE_FEED_CREATE_DATE_COL, "sub_log_type", TABLE_OFFLINE_FEED_DIAGNOSE_LOG_FULL_FILE_PATH_COL};

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiagnoseLogDBHelper(Context context, String str) {
        super(new SQLiteContext(context, str), DB_NAME, (SQLiteDatabase.CursorFactory) null, 3);
        NLog.m9451c("msp", "newVersion:3");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        createOfflineFeedbackTable(sQLiteDatabase);
    }

    private void createOfflineFeedbackTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_feed_back (device_sn TEXT, zip_filename TEXT, vehicle_type TEXT, remark TEXT, log_type TEXT, lang TEXT,model TEXT,year TEXT,vin TEXT,create_date  INTEGER,sub_log_type TEXT,diagnose_log_full_file_path TEXT);");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        NLog.m9451c("msp", "oldVersion: " + i + "  newVersion:" + i2);
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE offline_feed_back ADD diagnose_log_full_file_path TEXT;");
                break;
            case 2:
                break;
            default:
                return;
        }
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("ALTER TABLE offline_feed_back RENAME TO temp_diagnose_log_data;");
            createOfflineFeedbackTable(sQLiteDatabase);
            sQLiteDatabase.execSQL("INSERT INTO offline_feed_back SELECT * FROM temp_diagnose_log_data;");
            sQLiteDatabase.execSQL("DROP TABLE temp_diagnose_log_data;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            sQLiteDatabase.execSQL("DROP TABLE temp_diagnose_log_data;");
            sQLiteDatabase.setTransactionSuccessful();
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
