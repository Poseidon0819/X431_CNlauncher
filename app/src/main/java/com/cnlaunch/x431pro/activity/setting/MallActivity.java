package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.view.KeyEvent;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class MallActivity extends ActivityC2004c implements FragmentKeyDownListener {

    /* renamed from: n */
    private FragmentKeyDownListener.InterfaceC1949a f14455n = null;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_common_fragment);
        if (bundle == null) {
            mo5888b(MallFragment.class.getName(), getIntent().getExtras());
        }
        setTitle(R.string.mall);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        FragmentKeyDownListener.InterfaceC1949a interfaceC1949a = this.f14455n;
        if (interfaceC1949a == null || !interfaceC1949a.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.cnlaunch.x431pro.p210a.FragmentKeyDownListener
    /* renamed from: a */
    public final void mo6039a(FragmentKeyDownListener.InterfaceC1949a interfaceC1949a) {
        this.f14455n = interfaceC1949a;
    }
}
