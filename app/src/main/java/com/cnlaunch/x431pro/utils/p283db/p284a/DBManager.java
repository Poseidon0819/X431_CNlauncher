package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import com.cnlaunch.x431pro.utils.p283db.p284a.DaoMaster;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.a */
/* loaded from: classes.dex */
public class DBManager {

    /* renamed from: c */
    private static DBManager f15793c;

    /* renamed from: a */
    public DaoSession f15794a;

    /* renamed from: b */
    private String f15795b = "prodb";

    /* renamed from: d */
    private DaoMaster f15796d;

    /* renamed from: a */
    public static DBManager m5036a(Context context) {
        if (f15793c == null) {
            synchronized (DBManager.class) {
                if (f15793c == null) {
                    f15793c = new DBManager(context);
                }
            }
        }
        return f15793c;
    }

    private DBManager(Context context) {
        this.f15796d = new DaoMaster(new DaoMaster.C2757a(context, this.f15795b).getWritableDatabase());
        this.f15794a = this.f15796d.newSession();
    }
}
