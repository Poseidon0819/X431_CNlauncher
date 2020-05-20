package com.cnlaunch.x431pro.activity.info;

import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.info.p227a.InfoFragmentCallback;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class RepairInfoActivity extends ActivityC2004c implements InfoFragmentCallback {

    /* renamed from: n */
    private OnKeyDownListenter f12870n = null;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_repair_info);
        if (bundle == null) {
            if (!C2744aa.m5166c() && !C2744aa.m5151f()) {
                if (C2744aa.m5160d()) {
                    mo5888b(RepairInfoActivityEuroFragment.class.getName(), null);
                    return;
                } else {
                    mo5888b(FragmentC2297z.class.getName(), null);
                    return;
                }
            }
            mo5888b(RepairInfoFragment.class.getName(), null);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnKeyDownListenter onKeyDownListenter = this.f12870n;
        if (onKeyDownListenter == null || !onKeyDownListenter.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.info.p227a.InfoFragmentCallback
    /* renamed from: a */
    public final void mo6859a(OnKeyDownListenter onKeyDownListenter) {
        this.f12870n = onKeyDownListenter;
    }

    @Override // com.cnlaunch.x431pro.activity.info.p227a.InfoFragmentCallback
    /* renamed from: h */
    public final void mo6858h() {
        if (this.f12870n != null) {
            this.f12870n = null;
        }
    }
}
