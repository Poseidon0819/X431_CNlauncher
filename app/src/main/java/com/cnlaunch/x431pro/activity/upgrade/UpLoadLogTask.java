package com.cnlaunch.x431pro.activity.upgrade;

import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLog;
import com.cnlaunch.x431pro.utils.p283db.UpdateDownloadLogDao;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

/* renamed from: com.cnlaunch.x431pro.activity.upgrade.w */
/* loaded from: classes.dex */
public final class UpLoadLogTask implements Runnable {

    /* renamed from: a */
    private DownloadLog f15428a;

    /* renamed from: b */
    private UpgradeAction f15429b;

    /* renamed from: c */
    private UpdateDownloadLogDao f15430c;

    public UpLoadLogTask(DownloadLog downloadLog, UpgradeAction upgradeAction, UpdateDownloadLogDao updateDownloadLogDao) {
        this.f15428a = downloadLog;
        this.f15429b = upgradeAction;
        this.f15430c = updateDownloadLogDao;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseResponse baseResponse;
        try {
            baseResponse = this.f15429b.m5280a(this.f15428a.getDownloadId(), this.f15428a.getState(), this.f15428a.getDownloadedSize(), this.f15428a.getDownloadDuration(), this.f15428a.getCurrentNetworkSpeed(), this.f15428a.getCurrentConfigArea());
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = null;
        }
        try {
            if (this.f15428a == null || baseResponse == null || baseResponse.getCode() != 0) {
                return;
            }
            QueryBuilder<UpdateDownloadLog> queryBuilder = this.f15430c.queryBuilder();
            queryBuilder.where(UpdateDownloadLogDao.Properties.DownloadId.m321eq(this.f15428a.getDownloadId()), new WhereCondition[0]);
            UpdateDownloadLog unique = queryBuilder.unique();
            if (unique != null) {
                this.f15430c.delete(unique);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
