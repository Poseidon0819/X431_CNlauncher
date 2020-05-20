package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class HowToGetJointVerifyCodeActivity extends ActivityC2004c {
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_how_to_get_joint_verify_code);
        m7743b();
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
