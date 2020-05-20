package com.cnlaunch.x431pro.utils.p283db.p284a;

import android.content.Context;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.p284a.SDCardDaoMaster;

/* renamed from: com.cnlaunch.x431pro.utils.db.a.g */
/* loaded from: classes.dex */
public class SDCardDBManager {

    /* renamed from: c */
    private static SDCardDBManager f15816c;

    /* renamed from: a */
    public SDCardDaoSession f15817a;

    /* renamed from: b */
    private String f15818b = PathUtils.m4858c() + "/prodb";

    /* renamed from: d */
    private SDCardDaoMaster f15819d;

    /* renamed from: a */
    public static SDCardDBManager m5030a(Context context) {
        if (f15816c == null) {
            synchronized (SDCardDBManager.class) {
                if (f15816c == null) {
                    f15816c = new SDCardDBManager(context);
                }
            }
        }
        return f15816c;
    }

    private SDCardDBManager(Context context) {
        this.f15819d = new SDCardDaoMaster(new SDCardDaoMaster.C2761a(context, this.f15818b).getWritableDatabase());
        this.f15817a = this.f15819d.newSession();
    }
}
