package com.cnlaunch.x431pro.activity.upgrade.p240c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApkUpgradeAndDownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.h */
/* loaded from: classes.dex */
public final class C2671h extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ApkUpgradeAndDownloadLogic f15294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2671h(ApkUpgradeAndDownloadLogic apkUpgradeAndDownloadLogic) {
        this.f15294a = apkUpgradeAndDownloadLogic;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("returnCode", -1);
        String stringExtra = intent.getStringExtra("packageName");
        String str = this.f15294a.f15261e.get(stringExtra);
        NLog.m9452b("wzx", "DownlaodFragment.BroadcastReceiver.onReceive().returnCode =".concat(String.valueOf(intExtra)));
        NLog.m9452b("wzx", "DownlaodFragment.BroadcastReceiver.onReceive().packageName =".concat(String.valueOf(stringExtra)));
        if (TextUtils.isEmpty(str) || !str.equals(this.f15294a.f15256E)) {
            return;
        }
        if (intExtra == 1) {
            this.f15294a.f15254C = 4;
            if (this.f15294a.f15253B != null) {
                this.f15294a.f15253B.mo4929d(this.f15294a.f15256E, 0);
            }
            NToast.m9449a(this.f15294a.f15277v, this.f15294a.f15256E + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f15294a.f15277v.getResources().getString(R.string.apk_install_success_restart));
            return;
        }
        this.f15294a.f15254C = 5;
        if (this.f15294a.f15253B != null) {
            this.f15294a.f15253B.mo4929d(this.f15294a.f15256E, intExtra);
        }
    }
}
