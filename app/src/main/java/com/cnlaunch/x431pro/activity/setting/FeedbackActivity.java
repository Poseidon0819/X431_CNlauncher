package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class FeedbackActivity extends ActivityC2004c {
    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        if (bundle == null) {
            mo5888b(DiagnosticLogVehicleListFragment.class.getName(), null);
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }
}
