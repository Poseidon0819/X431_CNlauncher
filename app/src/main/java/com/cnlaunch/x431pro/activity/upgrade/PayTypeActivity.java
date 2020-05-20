package com.cnlaunch.x431pro.activity.upgrade;

import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.mine.PayTypeFragment;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class PayTypeActivity extends ActivityC2004c {
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        m7737d(8);
        this.f10988x = false;
        m7735e(8);
        setTitle(R.string.mine_pay);
        mo5888b(PayTypeFragment.class.getName(), getIntent().getExtras());
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && getFragmentManager().getBackStackEntryCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
