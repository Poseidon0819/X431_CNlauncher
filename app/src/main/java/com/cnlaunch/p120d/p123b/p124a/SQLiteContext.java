package com.cnlaunch.p120d.p123b.p124a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: com.cnlaunch.d.b.a.a */
/* loaded from: classes.dex */
public final class SQLiteContext extends ContextWrapper {

    /* renamed from: a */
    private String f7027a;

    public SQLiteContext(Context context, String str) {
        super(context);
        this.f7027a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final File getDatabasePath(String str) {
        File file = new File(this.f7027a + File.separator + str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, databaseErrorHandler);
    }
}
