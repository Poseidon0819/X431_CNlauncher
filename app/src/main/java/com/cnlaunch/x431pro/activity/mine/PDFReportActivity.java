package com.cnlaunch.x431pro.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class PDFReportActivity extends ActivityC2004c {
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        m7737d(8);
        m7735e(8);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (bundle == null) {
            mo5888b(PDFReportFragment.class.getName(), extras);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
