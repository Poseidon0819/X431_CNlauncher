package com.cnlaunch.golo3.p162d;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cnlaunch.golo3.p160b.ApplicationConfig;

/* renamed from: com.cnlaunch.golo3.d.a */
/* loaded from: classes.dex */
public final class InterfaceDBHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static int f8429a = 20;

    /* compiled from: InterfaceDBHelper.java */
    /* renamed from: com.cnlaunch.golo3.d.a$a */
    /* loaded from: classes.dex */
    static class C1608a {

        /* renamed from: a */
        static final InterfaceDBHelper f8430a = new InterfaceDBHelper((byte) 0);
    }

    /* synthetic */ InterfaceDBHelper(byte b) {
        this();
    }

    private InterfaceDBHelper() {
        super(ApplicationConfig.f7802a, "golo_interface.db", (SQLiteDatabase.CursorFactory) null, f8429a);
    }

    /* renamed from: a */
    public static InterfaceDBHelper m9168a() {
        return C1608a.f8430a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS interface_TB(_id INTEGER PRIMARY KEY AUTOINCREMENT, key VARCHAR(20), value VARCHAR(50))");
        sQLiteDatabase.execSQL("create index if not exists index_interface on interface_TB (key)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(" drop table if exists interface_TB");
        onCreate(sQLiteDatabase);
    }
}
