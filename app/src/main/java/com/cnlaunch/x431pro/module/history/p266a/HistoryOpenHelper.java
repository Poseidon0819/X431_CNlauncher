package com.cnlaunch.x431pro.module.history.p266a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.cnlaunch.x431pro.module.history.a.b */
/* loaded from: classes.dex */
public final class HistoryOpenHelper extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public HistoryOpenHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        m5289a(sQLiteDatabase);
        m5288b(sQLiteDatabase);
        m5287c(sQLiteDatabase);
    }

    /* renamed from: a */
    private static boolean m5289a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE Vehicle (VID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,SN  TEXT NOT NULL,VehicleUID  TEXT,Make  TEXT,Model  TEXT,SubModel  TEXT,Engine  TEXT,Year  TEXT,LicenseNumber  TEXT,Mileage  TEXT,Color  TEXT,VIN  TEXT,DiagSoftVersion  TEXT,VehicleSoftVersion  TEXT,VehicleInformation  TEXT,StaffIDString  TEXT,TimeStamp  TEXT,Remark  TEXT,OwnerID  INTEGER,Path  TEXT,VehiclePath  TEXT,TimeStampYearMonth  TEXT,CharSet  TEXT,Language  INTEGER,CONSTRAINT OwnerKey FOREIGN KEY (OwnerID) REFERENCES Owner (OwnerID) ON DELETE RESTRICT ON UPDATE RESTRICT)");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m5288b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE System (SystemID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,SystemIndex  INTEGER,NameID  TEXT,SystemUID  TEXT,SystemName  TEXT,AvailableDatastream  TEXT,AvailableAction  TEXT,VID  INTEGER NOT NULL,CONSTRAINT VIDKey FOREIGN KEY (VID) REFERENCES Vehicle (VID) ON DELETE RESTRICT ON UPDATE RESTRICT)");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m5287c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE DTC (DtcID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,DTC  TEXT,Description  TEXT,Status  TEXT,SystemID  INTEGER NOT NULL,TimeStamp  TEXT,VID  INTEGER NOT NULL,CONSTRAINT SystemIDKey FOREIGN KEY (SystemID) REFERENCES System (SystemID) ON DELETE RESTRICT ON UPDATE RESTRICT DEFERRABLE INITIALLY DEFERRED,CONSTRAINT VIDKey FOREIGN KEY (VID) REFERENCES Vehicle (VID) ON DELETE RESTRICT ON UPDATE RESTRICT)");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
