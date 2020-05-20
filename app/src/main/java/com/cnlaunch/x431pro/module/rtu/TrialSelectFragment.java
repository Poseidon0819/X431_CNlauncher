package com.cnlaunch.x431pro.module.rtu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.module.rtu.k */
/* loaded from: classes.dex */
public class TrialSelectFragment extends BaseSelectFragment {

    /* renamed from: g */
    private String f15709g = "";

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15709g = arguments.getString("prompt");
        }
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m5209a(R.string.notice);
        if (!this.f15709g.isEmpty()) {
            m5205a(this.f15709g);
        } else {
            m5205a(String.format("%1$s %2$s", getResources().getString(R.string.network_connection_not_established), getResources().getString(R.string.trial_ask)));
        }
        m5208a(R.string.start_trial, new View$OnClickListenerC2743l(this));
        return onCreateView;
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
