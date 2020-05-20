package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.b */
/* loaded from: classes.dex */
public class CloudActivity extends ActivityC2004c implements FragmentKeyDownListener, InfaceFragmentParent {

    /* renamed from: n */
    public static boolean f10610n = true;

    /* renamed from: C */
    private OnActivityResultListenter f10611C = null;

    /* renamed from: D */
    private FragmentKeyDownListener.InterfaceC1949a f10612D = null;

    @Override // com.cnlaunch.x431pro.p210a.FragmentKeyDownListener
    /* renamed from: a */
    public final void mo6039a(FragmentKeyDownListener.InterfaceC1949a interfaceC1949a) {
        this.f10612D = interfaceC1949a;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (f10610n) {
            m7741b(VINPlateScanFragment.class.getName());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6035a(OnActivityResultListenter onActivityResultListenter) {
        this.f10611C = onActivityResultListenter;
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        OnActivityResultListenter onActivityResultListenter = this.f10611C;
        if (onActivityResultListenter != null) {
            onActivityResultListenter.mo5996a(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent
    /* renamed from: a */
    public final void mo6036a(long j) {
        OnActivityResultListenter onActivityResultListenter = this.f10611C;
        if (onActivityResultListenter == null || onActivityResultListenter.mo5997a() != j) {
            return;
        }
        this.f10611C = null;
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        FragmentKeyDownListener.InterfaceC1949a interfaceC1949a = this.f10612D;
        if (interfaceC1949a == null || !interfaceC1949a.onKeyDown(i, keyEvent)) {
            if (i == 4 && this.f10969A.getBackStackEntryCount() == 0) {
                f10610n = true;
                DiagnoseConstants.LICENSEPLATE = "";
                DiagnoseConstants.RECORD_MODEL = "";
                DiagnoseConstants.RECORD_YEAR = "";
                DiagnoseConstants.RECORD_DISPLACEMENT = "";
                DiagnoseConstants.RECORD_TRANS = "";
                DiagnoseConstants.MARKET_CAR_MODEL = "";
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
