package com.cnlaunch.x431pro.activity.golo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.onGoloDataListenter;

/* renamed from: com.cnlaunch.x431pro.activity.golo.a */
/* loaded from: classes.dex */
public abstract class BaseGoloFragment extends BaseFragment {

    /* renamed from: a */
    private onGoloDataListenter f12498a = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12498a = (onGoloDataListenter) activity;
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onDestroyView() {
        super.onDestroyView();
    }
}
