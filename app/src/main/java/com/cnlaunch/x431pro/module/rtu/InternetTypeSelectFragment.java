package com.cnlaunch.x431pro.module.rtu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.module.rtu.g */
/* loaded from: classes.dex */
public class InternetTypeSelectFragment extends BaseSelectFragment {
    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m5209a(R.string.internet_setup);
        m5204b(R.string.internet_access_ask);
        m5208a(R.string.internet_setup, new View$OnClickListenerC2742h(this));
        return onCreateView;
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
