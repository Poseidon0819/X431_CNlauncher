package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p219b.CarIconManager;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.io.File;
import java.util.List;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.aw */
/* loaded from: classes.dex */
final class RunnableC2644aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f15228a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2643av f15229b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2644aw(View$OnClickListenerC2643av view$OnClickListenerC2643av, List list) {
        this.f15229b = view$OnClickListenerC2643av;
        this.f15228a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        Context context2;
        String str;
        String str2;
        Context context3;
        boolean z = false;
        boolean z2 = false;
        for (X431PadDtoSoft x431PadDtoSoft : this.f15228a) {
            if (!TextUtils.isEmpty(x431PadDtoSoft.getMaxOldVersion())) {
                context2 = this.f15229b.f15227a.mContext;
                CarIconUtils carIconUtils = new CarIconUtils(context2);
                str = this.f15229b.f15227a.f15184am;
                CarIcon m4951e = carIconUtils.m4951e(str, x431PadDtoSoft.getSoftPackageID());
                if (m4951e != null) {
                    str2 = this.f15229b.f15227a.f15164a;
                    NLog.m9456a(str2, "carIcon.getVehiclePath()=" + m4951e.f15789m);
                    if (new File(m4951e.f15789m + File.separator + "ICON.INI").exists()) {
                        FileUtils.m4995g(m4951e.f15789m);
                        z = true;
                    } else {
                        FileUtils.m4995g(m4951e.f15789m);
                        context3 = this.f15229b.f15227a.mContext;
                        new CarIconUtils(context3).m4949f(m4951e.f15790n, m4951e.f15778b);
                    }
                    z2 = true;
                }
            }
        }
        if (z) {
            context = this.f15229b.f15227a.mContext;
            CarIconManager.m7471a(context).m7474a();
        }
        this.f15228a.clear();
        handler = this.f15229b.f15227a.f15140C;
        handler.obtainMessage(8, Boolean.valueOf(z2)).sendToTarget();
    }
}
