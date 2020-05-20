package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class UpgradeActivity extends ActivityC2004c {

    /* renamed from: n */
    protected final String f14978n = UpgradeActivity.class.getSimpleName();

    /* renamed from: C */
    BroadcastReceiver f14977C = new C2701x(this);

    static {
        System.loadLibrary("LICENSE");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.f14977C, intentFilter);
        if (bundle == null) {
            if (PreferencesManager.m9595a(getApplicationContext()).m9591a("upgrade_center_version").equalsIgnoreCase("V2.0")) {
                Bundle extras = getIntent().getExtras();
                if (extras != null && extras.containsKey("position")) {
                    mo5888b(UpgradeFragmentForPro.class.getName(), extras);
                    return;
                } else {
                    mo5888b(UpgradeFragmentForPro.class.getName(), null);
                    return;
                }
            }
            mo5888b(UpgradeFragment.class.getName(), null);
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Bundle extras;
        if (PreferencesManager.m9595a(getApplicationContext()).m9591a("upgrade_center_version").equalsIgnoreCase("V2.0") && (extras = getIntent().getExtras()) != null && extras.containsKey("position")) {
            String str = this.f14978n;
            NLog.m9456a(str, "position: " + extras.getInt("position"));
            UpgradeFragmentForPro upgradeFragmentForPro = (UpgradeFragmentForPro) getFragmentManager().findFragmentByTag(UpgradeFragmentForPro.class.getName());
            if (upgradeFragmentForPro != null) {
                int i = extras.getInt("position");
                NLog.m9456a(upgradeFragmentForPro.f15164a, "position: ".concat(String.valueOf(i)));
                upgradeFragmentForPro.f15199c.setCurrentItem(i);
            }
        }
        super.onResume();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f14977C);
    }
}
