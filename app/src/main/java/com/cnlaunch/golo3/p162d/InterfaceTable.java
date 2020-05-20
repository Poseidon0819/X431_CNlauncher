package com.cnlaunch.golo3.p162d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.golo3.d.b */
/* loaded from: classes.dex */
public final class InterfaceTable {

    /* renamed from: a */
    public InterfaceDBHelper f8431a = InterfaceDBHelper.m9168a();

    /* renamed from: b */
    public SQLiteDatabase f8432b;

    /* renamed from: c */
    private Cursor f8433c;

    /* renamed from: a */
    public final String m9166a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.f8432b = this.f8431a.getReadableDatabase();
            this.f8433c = this.f8432b.rawQuery("SELECT value FROM interface_TB WHERE key=?", new String[]{str});
            if (this.f8433c != null && this.f8433c.moveToNext()) {
                str2 = this.f8433c.getString(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            m9167a();
            throw th;
        }
        m9167a();
        return str2;
    }

    /* renamed from: a */
    public final void m9165a(List<JSONObject> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f8432b = this.f8431a.getWritableDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO interface_TB(key,value) ");
        stringBuffer.append(" VALUES( ?, ?)");
        SQLiteStatement compileStatement = this.f8432b.compileStatement(stringBuffer.toString());
        if (this.f8432b.isDbLockedByCurrentThread()) {
            synchronized (compileStatement) {
                try {
                    for (JSONObject jSONObject : list) {
                        compileStatement.bindString(1, jSONObject.getString("key"));
                        compileStatement.bindString(2, jSONObject.getString("value"));
                        compileStatement.executeInsert();
                    }
                } catch (Exception unused) {
                }
            }
            return;
        }
        this.f8432b.beginTransaction();
        try {
            synchronized (compileStatement) {
                for (JSONObject jSONObject2 : list) {
                    compileStatement.bindString(1, jSONObject2.getString("key"));
                    compileStatement.bindString(2, jSONObject2.getString("value"));
                    compileStatement.executeInsert();
                }
            }
            this.f8432b.setTransactionSuccessful();
        } catch (Exception unused2) {
        } catch (Throwable th) {
            this.f8432b.endTransaction();
            throw th;
        }
        this.f8432b.endTransaction();
    }

    /* renamed from: a */
    private void m9167a() {
        Cursor cursor = this.f8433c;
        if (cursor != null) {
            cursor.close();
            this.f8433c = null;
        }
    }
}
