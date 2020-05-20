package com.cnlaunch.x431pro.activity.setting.wifi;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.mine.DPULinkManagerFragment;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class DPUWiFiLinkModeSettingsActivity extends ActivityC2004c {

    /* renamed from: n */
    private final String f14847n = "DPUWiFiLinkModeSettingsActivity";

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dpu_wifi_link_mode_settings);
        mo5888b(DPULinkManagerFragment.class.getName(), null);
        m7743b();
        C1856n.m8130a("DPUWiFiLinkModeSettingsActivity", "onCreate");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c
    /* renamed from: b */
    public final void mo5888b(String str, Bundle bundle) {
        Fragment instantiate = Fragment.instantiate(getApplicationContext(), str, bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.fragment_navigation, instantiate, "DPUWiFiLinkModeSettingsActivity");
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
