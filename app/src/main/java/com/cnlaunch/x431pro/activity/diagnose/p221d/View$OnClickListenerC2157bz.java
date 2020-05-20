package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.WebSearchFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bz */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2157bz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2157bz(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12231a = speciaFunctionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String m7166g = SpeciaFunctionFragment.m7166g(this.f12231a);
        if (m7166g != null) {
            DiagnoseConstants.SPECIAFUNCTIONCODE_REFRESH = false;
            WebSearchFragment webSearchFragment = new WebSearchFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("searchkey", m7166g);
            webSearchFragment.setArguments(bundle);
            this.f12231a.f12357d.mo7098a((Fragment) webSearchFragment, SpeciaFunctionFragment.class.getName(), true);
        }
    }
}
