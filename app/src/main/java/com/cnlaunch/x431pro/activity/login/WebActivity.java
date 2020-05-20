package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.login.p228a.AgreementWebFragment;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class WebActivity extends ActivityC2004c {
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("ifHideLogin", true);
        if (bundle == null) {
            mo5888b(AgreementWebFragment.class.getName(), extras);
        }
        String string = extras.getString("title", "");
        if (C2787z.m4821a(string)) {
            return;
        }
        m7744a(string);
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
