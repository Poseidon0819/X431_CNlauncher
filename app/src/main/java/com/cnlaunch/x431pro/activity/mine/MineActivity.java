package com.cnlaunch.x431pro.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class MineActivity extends ActivityC2004c implements FragmentKeyDownListener, InfaceFragmentParent {

    /* renamed from: n */
    public static boolean f13541n = false;

    /* renamed from: D */
    private OnKeyDownListenter f13543D = null;

    /* renamed from: E */
    private PowerManager f13544E = null;

    /* renamed from: F */
    private PowerManager.WakeLock f13545F = null;

    /* renamed from: C */
    OnActivityResultListenter f13542C = null;

    /* renamed from: G */
    private FragmentKeyDownListener.InterfaceC1949a f13546G = null;

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        if (bundle == null) {
            mo5888b(MineFragment.class.getName(), null);
        }
        this.f13544E = (PowerManager) getSystemService("power");
        this.f13545F = this.f13544E.newWakeLock(536870918, "ReplayPBLock");
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13545F.acquire();
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        this.f13545F.release();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnKeyDownListenter onKeyDownListenter = this.f13543D;
        if (onKeyDownListenter == null || !onKeyDownListenter.onKeyDown(i, keyEvent)) {
            FragmentKeyDownListener.InterfaceC1949a interfaceC1949a = this.f13546G;
            if (interfaceC1949a == null || !interfaceC1949a.onKeyDown(i, keyEvent)) {
                if (i == 4 && f13541n) {
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }
        return true;
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("Sanda", "onActivityResult".concat(String.valueOf(i2)));
        OnActivityResultListenter onActivityResultListenter = this.f13542C;
        if (onActivityResultListenter != null) {
            onActivityResultListenter.mo5996a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
        this.f13542C = onActivityResultListenter;
    }

    @Override // com.cnlaunch.x431pro.p210a.FragmentKeyDownListener
    /* renamed from: a */
    public final void mo6039a(FragmentKeyDownListener.InterfaceC1949a interfaceC1949a) {
        this.f13546G = interfaceC1949a;
    }
}
