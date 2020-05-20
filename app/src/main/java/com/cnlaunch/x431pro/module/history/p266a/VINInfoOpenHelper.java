package com.cnlaunch.x431pro.module.history.p266a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.cnlaunch.x431pro.module.history.a.d */
/* loaded from: classes.dex */
public final class VINInfoOpenHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private String f15571a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public VINInfoOpenHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f15571a = "create table VIN_INFO(ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,VIN TEXT,PLATE TEXT,PACKAGE_ID TEXT,MODEL TEXT,DIAGNOSE_MODEL TEXT,YEAR TEXT,DISPLACEMENT TEXT,TRANS TEXT,VENDER TEXT,REMARK_JSON TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f15571a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
    }
}
