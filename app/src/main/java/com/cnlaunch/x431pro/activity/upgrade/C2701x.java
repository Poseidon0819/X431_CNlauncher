package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p130d.NLog;

/* compiled from: UpgradeActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.x */
/* loaded from: classes.dex */
final class C2701x extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeActivity f15431a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2701x(UpgradeActivity upgradeActivity) {
        this.f15431a = upgradeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String dataString = intent.getDataString();
            String substring = dataString.substring(dataString.indexOf("package:") + 8);
            NLog.m9456a(this.f15431a.f14978n, "ACTION_PACKAGE_ADDED: ".concat(String.valueOf(substring)));
            DownloadFragment downloadFragment = (DownloadFragment) this.f15431a.getFragmentManager().findFragmentByTag(DownloadFragment.class.getName());
            if (downloadFragment != null) {
                NLog.m9456a(this.f15431a.f14978n, "ACTION_PACKAGE_ADDED: fragment is OK!");
                if (downloadFragment.isVisible()) {
                    NLog.m9456a(this.f15431a.f14978n, "ACTION_PACKAGE_ADDED: fragment is visible!");
                    downloadFragment.m5545a(substring, true);
                }
            }
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            String dataString2 = intent.getDataString();
            NLog.m9456a(this.f15431a.f14978n, "ACTION_PACKAGE_REPLACED: ".concat(String.valueOf(dataString2)));
            DownloadFragment downloadFragment2 = (DownloadFragment) this.f15431a.getFragmentManager().findFragmentByTag(DownloadFragment.class.getName());
            if (downloadFragment2 == null || !downloadFragment2.isVisible()) {
                return;
            }
            downloadFragment2.m5545a(dataString2, true);
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            String dataString3 = intent.getDataString();
            NLog.m9456a(this.f15431a.f14978n, "ACTION_PACKAGE_REMOVED: ".concat(String.valueOf(dataString3)));
            DownloadFragment downloadFragment3 = (DownloadFragment) this.f15431a.getFragmentManager().findFragmentByTag(DownloadFragment.class.getName());
            if (downloadFragment3 == null || !downloadFragment3.isVisible()) {
                return;
            }
            downloadFragment3.m5545a(dataString3, false);
        }
    }
}
