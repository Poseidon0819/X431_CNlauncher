package com.cnlaunch.x431pro.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class SettingActivity extends ActivityC2004c implements InfaceFragmentParent {

    /* renamed from: n */
    private OnActivityResultListenter f14489n = null;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        if (bundle == null) {
            mo5888b(SettingFragment.class.getName(), null);
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

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
        this.f14489n = onActivityResultListenter;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
        OnActivityResultListenter onActivityResultListenter = this.f14489n;
        if (onActivityResultListenter == null || onActivityResultListenter.mo5997a() != j) {
            return;
        }
        this.f14489n = null;
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        OnActivityResultListenter onActivityResultListenter = this.f14489n;
        if (onActivityResultListenter != null) {
            onActivityResultListenter.mo5996a(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnActivityResultListenter onActivityResultListenter = this.f14489n;
        if (onActivityResultListenter != null) {
            onActivityResultListenter.mo5995a(keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
