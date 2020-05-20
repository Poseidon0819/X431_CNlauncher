package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Bundle;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FittingsSearchFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bo */
/* loaded from: classes.dex */
final class View$OnClickListenerC2080bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FittingsSearchFragment f11562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2080bo(FittingsSearchFragment fittingsSearchFragment) {
        this.f11562a = fittingsSearchFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        list = this.f11562a.f11555a;
        if (list.size() != 0) {
            DiagnoseConstants.FAULTCODE_REFRESH = false;
            TaoBaoSearchFragment taoBaoSearchFragment = new TaoBaoSearchFragment();
            Bundle bundle = new Bundle();
            list2 = this.f11562a.f11555a;
            bundle.putStringArrayList("taobaoKey", (ArrayList) list2);
            this.f11562a.addFragment(taoBaoSearchFragment.getClass().getName(), bundle);
        }
    }
}
