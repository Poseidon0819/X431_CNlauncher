package com.cnlaunch.x431pro.module.rtu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.module.rtu.c */
/* loaded from: classes.dex */
public class CustomerSelectFragment extends BaseSelectFragment {
    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m5204b(R.string.customer_exist_ask);
        m5208a(R.string.new_customer, new View$OnClickListenerC2739d(this));
        View$OnClickListenerC2740e view$OnClickListenerC2740e = new View$OnClickListenerC2740e(this);
        this.f15676b.setText(R.string.existing_customer);
        this.f15676b.setVisibility(0);
        this.f15678d = view$OnClickListenerC2740e;
        if (PreferencesManager.m9595a(this.f15680f).m9583b("isFirstRun", false) && !PreferencesManager.m9595a(this.f15680f).m9583b("NoDeviceWithIsFirstRun", false)) {
            View$OnClickListenerC2741f view$OnClickListenerC2741f = new View$OnClickListenerC2741f(this);
            this.f15677c.setText(R.string.start_trial);
            this.f15677c.setVisibility(0);
            this.f15679e = view$OnClickListenerC2741f;
        }
        return onCreateView;
    }

    @Override // com.cnlaunch.x431pro.module.rtu.BaseSelectFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
