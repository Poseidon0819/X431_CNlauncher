package com.cnlaunch.diagnosemodule.diagnoselog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* loaded from: classes.dex */
public class DiagnoseLogOfflineFeedbackManager {
    private static String OFFLINE_FEEDBACK_ZIP_DIRECTORY = "offline_feedback_zip";
    private static final String TAG = "DiagnoseLogOfflineFeedbackManager";
    private final Context mContext;
    private DiagnoseLogDBHelper mDiagnoseLogDBHelper;
    private final String mPackagePath;

    private String getOfflineFeedbackZipDirectory() {
        return this.mPackagePath + File.separator + OFFLINE_FEEDBACK_ZIP_DIRECTORY;
    }

    public String getOfflineFeedbackZipFullFilename(String str) {
        String str2 = getOfflineFeedbackZipDirectory() + File.separator + str;
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "获取离线反馈日志文件完整路径:".concat(String.valueOf(str2)));
        }
        return str2;
    }

    public boolean moveZipDiagnoseLogToOfflineFeedbackZipDirectory(String str, String str2) {
        File file = new File(str);
        File file2 = new File(getOfflineFeedbackZipFullFilename(str2));
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        boolean renameTo = file.renameTo(file2);
        if (renameTo) {
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, String.format("文件移动成功  原路径：%1$s 移动后路径：%2$s", file.getAbsolutePath(), file2.getAbsolutePath()));
            }
        } else if (C1856n.f10135a) {
            C1856n.m8130a(TAG, String.format("文件移动失败  原路径：%1$s 移动后路径：%2$s", file.getAbsolutePath(), file2.getAbsolutePath()));
        }
        return renameTo;
    }

    public DiagnoseLogOfflineFeedbackManager(Context context, String str) {
        this.mContext = context;
        this.mPackagePath = str;
        this.mDiagnoseLogDBHelper = new DiagnoseLogDBHelper(this.mContext, this.mPackagePath);
    }

    public int getOfflineFeedbackItemsCount() {
        return getOfflineFeedbackItemsCount(null);
    }

    private int getOfflineFeedbackItemsCount(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getReadableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                close(null, null);
                throw th;
            }
            try {
                cursor = sQLiteDatabase.query("offline_feed_back", new String[]{"COUNT(1)"}, !TextUtils.isEmpty(str) ? String.format(Locale.ENGLISH, " %s='%s' ", "zip_filename", str) : null, null, null, null, null);
                cursor.moveToFirst();
                int i = cursor.getInt(0);
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "获取离线反馈日志文件总数:" + i + " zipFilenameSearch=" + str);
                }
                close(cursor, sQLiteDatabase);
                return i;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                close(cursor, sQLiteDatabase);
                return 0;
            }
        } catch (Throwable th2) {
            th = th2;
            close(null, null);
            throw th;
        }
    }

    public boolean hasOfflineFeedbackItems() {
        return getOfflineFeedbackItemsCount() > 0;
    }

    public List<OfflineFeedbackItem> buildOfflineFeedbackItems(String str) {
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getReadableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                close(null, null);
                throw th;
            }
            try {
                cursor = sQLiteDatabase.query("offline_feed_back", DiagnoseLogDBHelper.TABLE_OFFLINE_FEED_BACK_COLUMNS, String.format(Locale.ENGLISH, " %s='%s' ", "device_sn", str), null, null, null, "create_date DESC");
                while (cursor.moveToNext()) {
                    arrayList.add(new OfflineFeedbackItem(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getLong(9), cursor.getString(10), cursor.getString(11)));
                }
                close(cursor, sQLiteDatabase);
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                arrayList.clear();
                close(cursor, sQLiteDatabase);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
            close(null, null);
            throw th;
        }
    }

    public OfflineFeedbackItem buildOfflineFeedbackItem(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getReadableDatabase();
            } catch (Exception e) {
                e = e;
                cursor2 = null;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                sQLiteDatabase = null;
            }
            try {
                cursor2 = sQLiteDatabase.query("offline_feed_back", DiagnoseLogDBHelper.TABLE_OFFLINE_FEED_BACK_COLUMNS, String.format(Locale.ENGLISH, " %s='%s' ", "zip_filename", str), null, null, null, "create_date DESC");
            } catch (Exception e2) {
                e = e2;
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                close(cursor, sQLiteDatabase);
                throw th;
            }
            try {
                if (!cursor2.moveToNext()) {
                    close(cursor2, sQLiteDatabase);
                    return null;
                }
                OfflineFeedbackItem offlineFeedbackItem = new OfflineFeedbackItem(cursor2.getString(0), cursor2.getString(1), cursor2.getString(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5), cursor2.getString(6), cursor2.getString(7), cursor2.getString(8), cursor2.getLong(9), cursor2.getString(10), cursor2.getString(11));
                close(cursor2, sQLiteDatabase);
                return offlineFeedbackItem;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                close(cursor2, sQLiteDatabase);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public OfflineFeedbackItem buildFirstOfflineFeedbackItem(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getReadableDatabase();
            } catch (Exception e) {
                e = e;
                cursor2 = null;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                sQLiteDatabase = null;
            }
            try {
                cursor2 = sQLiteDatabase.query("offline_feed_back", DiagnoseLogDBHelper.TABLE_OFFLINE_FEED_BACK_COLUMNS, null, null, null, null, "create_date ASC", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            } catch (Exception e2) {
                e = e2;
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                close(cursor, sQLiteDatabase);
                throw th;
            }
            try {
                if (!cursor2.moveToLast()) {
                    close(cursor2, sQLiteDatabase);
                    return null;
                }
                OfflineFeedbackItem offlineFeedbackItem = new OfflineFeedbackItem(cursor2.getString(0), cursor2.getString(1), cursor2.getString(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5), cursor2.getString(6), cursor2.getString(7), cursor2.getString(8), cursor2.getLong(9), cursor2.getString(10), cursor2.getString(11));
                close(cursor2, sQLiteDatabase);
                return offlineFeedbackItem;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                close(cursor2, sQLiteDatabase);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public int deleteOfflineFeedbackItem(String str) {
        SQLiteDatabase sQLiteDatabase;
        int i = -1;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getWritableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                close(null, null);
                throw th;
            }
            try {
                i = sQLiteDatabase.delete("offline_feed_back", String.format(Locale.ENGLISH, " %s='%s' ", "zip_filename", str), null);
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "删除当前离线反馈日志文件对应的记录 zipFilenameSearch=" + str + " effectRows=" + i);
                }
                close(null, sQLiteDatabase);
                return i;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                close(null, sQLiteDatabase);
                return i;
            }
        } catch (Throwable th2) {
            th = th2;
            close(null, null);
            throw th;
        }
    }

    public int deleteOfflineFeedbackItemByFullFilePath(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getWritableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                close(null, null);
                throw th;
            }
            try {
                Cursor query = sQLiteDatabase.query("offline_feed_back", new String[]{"zip_filename"}, "diagnose_log_full_file_path = ?", new String[]{str}, null, null, null, null);
                if (query.moveToNext()) {
                    try {
                        File file = new File(getOfflineFeedbackZipFullFilename(query.getString(0)));
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                int delete = sQLiteDatabase.delete("offline_feed_back", "diagnose_log_full_file_path = ?", new String[]{str});
                close(null, sQLiteDatabase);
                return delete;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                close(null, sQLiteDatabase);
                return -1;
            }
        } catch (Throwable th2) {
            th = th2;
            close(null, null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v12 */
    public long addOfflineFeedbackItem(OfflineFeedbackItem offlineFeedbackItem) {
        SQLiteDatabase sQLiteDatabase;
        long j = -1;
        if (getOfflineFeedbackItemsCount(offlineFeedbackItem.getZipFilename()) > 0) {
            if (C1856n.f10135a) {
                C1856n.m8130a(TAG, "离线反馈日志记录已经存在 ZipFilename=" + offlineFeedbackItem.getZipFilename());
            }
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("device_sn", offlineFeedbackItem.getDeviceSN());
        contentValues.put("zip_filename", offlineFeedbackItem.getZipFilename());
        contentValues.put("vehicle_type", offlineFeedbackItem.getVehicleType());
        contentValues.put("remark", offlineFeedbackItem.getRemark());
        contentValues.put("log_type", offlineFeedbackItem.getLogType());
        contentValues.put("lang", offlineFeedbackItem.getLang());
        contentValues.put("model", offlineFeedbackItem.getModel());
        contentValues.put("year", offlineFeedbackItem.getYear());
        contentValues.put("vin", offlineFeedbackItem.getVin());
        contentValues.put("create_date", Long.valueOf(offlineFeedbackItem.getCreateDate()));
        contentValues.put("sub_log_type", offlineFeedbackItem.getSubLogType());
        SQLiteDatabase sQLiteDatabase2 = "diagnose_log_full_file_path";
        contentValues.put("diagnose_log_full_file_path", offlineFeedbackItem.getDiagnoseLogFullFilePath());
        try {
            try {
                sQLiteDatabase = this.mDiagnoseLogDBHelper.getWritableDatabase();
            } catch (Exception e) {
                e = e;
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase2 = 0;
                close(null, sQLiteDatabase2);
                throw th;
            }
            try {
                j = sQLiteDatabase.insert("offline_feed_back", null, contentValues);
                if (C1856n.f10135a) {
                    C1856n.m8130a(TAG, "添加离线反馈日志记录 生成的row id=".concat(String.valueOf(j)));
                }
                close(null, sQLiteDatabase);
                return j;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                close(null, sQLiteDatabase);
                return j;
            }
        } catch (Throwable th2) {
            th = th2;
            close(null, sQLiteDatabase2);
            throw th;
        }
    }

    private static void close(Cursor cursor, SQLiteDatabase sQLiteDatabase) {
        if (cursor != null) {
            cursor.close();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
