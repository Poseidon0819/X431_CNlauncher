package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDaoMaster;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.d */
/* loaded from: classes.dex */
public class FavoritesDBManager {

    /* renamed from: b */
    private static final String f15808b = "d";

    /* renamed from: d */
    private static FavoritesDBManager f15809d;

    /* renamed from: a */
    public FavoritesDaoSession f15810a;

    /* renamed from: c */
    private String f15811c = PathUtils.m4858c() + "/favorites";

    /* renamed from: e */
    private FavoritesDaoMaster f15812e;

    /* renamed from: a */
    public static FavoritesDBManager m5033a(Context context) throws SQLiteCantOpenDatabaseException {
        if (f15809d == null) {
            synchronized (FavoritesDBManager.class) {
                if (f15809d == null) {
                    f15809d = new FavoritesDBManager(context);
                }
            }
        }
        return f15809d;
    }

    private FavoritesDBManager(Context context) throws SQLiteCantOpenDatabaseException {
        this.f15812e = new FavoritesDaoMaster(new FavoritesDaoMaster.C2759a(context, this.f15811c).getWritableDatabase());
        this.f15810a = this.f15812e.newSession();
    }
}
