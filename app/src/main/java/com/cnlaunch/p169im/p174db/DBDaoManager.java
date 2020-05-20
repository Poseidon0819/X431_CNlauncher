package com.cnlaunch.p169im.p174db;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p174db.GoloDaoMaster;

/* renamed from: com.cnlaunch.im.db.a */
/* loaded from: classes.dex */
public final class DBDaoManager {

    /* renamed from: a */
    GoloDaoSession f9215a;

    /* renamed from: b */
    private String f9216b;

    /* renamed from: c */
    private GoloDaoMaster f9217c;

    /* renamed from: d */
    private boolean f9218d;

    public DBDaoManager(Context context) {
        this.f9216b = "";
        this.f9218d = false;
        String m9584b = PreferencesManager.m9595a(context).m9584b("user_id", "");
        if (TextUtils.isEmpty(m9584b)) {
            return;
        }
        this.f9216b = "GOLO_".concat(String.valueOf(m9584b));
        this.f9217c = new GoloDaoMaster(new GoloDaoMaster.C1734a(context, this.f9216b).getWritableDatabase());
        this.f9215a = this.f9217c.newSession();
        this.f9218d = true;
    }

    /* renamed from: a */
    public final synchronized void m8758a(Context context) {
        if (this.f9218d) {
            try {
                new GoloDaoMaster.C1734a(context, this.f9216b).close();
                this.f9215a = null;
                this.f9217c = null;
            } catch (Exception e) {
                Log.e("Sanda", "close:" + e.toString());
                e.printStackTrace();
            }
            this.f9216b = "";
            this.f9218d = false;
        }
    }
}
