package com.cnlaunch.p169im.p174db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* renamed from: com.cnlaunch.im.db.c */
/* loaded from: classes.dex */
public final class GoloDaoMaster extends AbstractDaoMaster {
    /* renamed from: a */
    public static void m8747a(SQLiteDatabase sQLiteDatabase) {
        MessageDao.m8766a(sQLiteDatabase);
        GoloRemoteOrderInfoDao.m8768a(sQLiteDatabase);
        FriendInfoDao.m8770a(sQLiteDatabase);
        VerificationInfoDao.m8760a(sQLiteDatabase);
        MessageInfoDao.m8764a(sQLiteDatabase);
        UserBaseInfoDao.m8762a(sQLiteDatabase);
    }

    /* renamed from: b */
    public static void m8746b(SQLiteDatabase sQLiteDatabase) {
        MessageDao.m8765b(sQLiteDatabase);
        GoloRemoteOrderInfoDao.m8767b(sQLiteDatabase);
        FriendInfoDao.m8769b(sQLiteDatabase);
        VerificationInfoDao.m8759b(sQLiteDatabase);
        MessageInfoDao.m8763b(sQLiteDatabase);
        UserBaseInfoDao.m8761b(sQLiteDatabase);
    }

    /* compiled from: GoloDaoMaster.java */
    /* renamed from: com.cnlaunch.im.db.c$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1735b extends SQLiteOpenHelper {
        public AbstractC1735b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 32);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.i("greenDAO", "Creating tables for schema version 32");
            GoloDaoMaster.m8747a(sQLiteDatabase);
        }
    }

    /* compiled from: GoloDaoMaster.java */
    /* renamed from: com.cnlaunch.im.db.c$a */
    /* loaded from: classes.dex */
    public static class C1734a extends AbstractC1735b {
        public C1734a(Context context, String str) {
            super(context, str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            GoloDaoMaster.m8746b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public GoloDaoMaster(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 32);
        registerDaoClass(MessageDao.class);
        registerDaoClass(GoloRemoteOrderInfoDao.class);
        registerDaoClass(FriendInfoDao.class);
        registerDaoClass(VerificationInfoDao.class);
        registerDaoClass(MessageInfoDao.class);
        registerDaoClass(UserBaseInfoDao.class);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    /* renamed from: a */
    public final GoloDaoSession newSession() {
        return new GoloDaoSession(this.f23924db, IdentityScopeType.Session, this.daoConfigMap);
    }

    @Override // de.greenrobot.dao.AbstractDaoMaster
    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new GoloDaoSession(this.f23924db, identityScopeType, this.daoConfigMap);
    }
}
