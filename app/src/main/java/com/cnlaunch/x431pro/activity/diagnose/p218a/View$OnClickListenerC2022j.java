package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.FittingsSearchFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.FaultCodeFragment;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: FaultCodeShowListAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.j */
/* loaded from: classes.dex */
final class View$OnClickListenerC2022j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11349a;

    /* renamed from: b */
    final /* synthetic */ FaultCodeShowListAdapter f11350b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2022j(FaultCodeShowListAdapter faultCodeShowListAdapter, int i) {
        this.f11350b = faultCodeShowListAdapter;
        this.f11349a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FaultCodeFragment faultCodeFragment;
        FaultCodeFragment faultCodeFragment2;
        faultCodeFragment = this.f11350b.f11335f;
        if (faultCodeFragment != null) {
            faultCodeFragment2 = this.f11350b.f11335f;
            int i = this.f11349a;
            if (faultCodeFragment2.f12357d.mo7083i().getDiagnoseStatue() != 0) {
                if (TextUtils.isEmpty(faultCodeFragment2.f11995j)) {
                    faultCodeFragment2.f11995j = faultCodeFragment2.f12357d.mo7083i().getCarSoftName();
                }
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(faultCodeFragment2.f11995j)) {
                    arrayList.add(faultCodeFragment2.f11995j);
                }
                if (!TextUtils.isEmpty(faultCodeFragment2.f11996k)) {
                    arrayList.add(faultCodeFragment2.f11996k);
                }
                String context = faultCodeFragment2.f11993a.get(i).getContext();
                boolean z = false;
                for (int i2 = 0; i2 < faultCodeFragment2.f11998m.length; i2++) {
                    if (context.contains(faultCodeFragment2.f11998m[i2])) {
                        arrayList.add(faultCodeFragment2.f11998m[i2]);
                        z = true;
                    }
                }
                if (!z) {
                    if (context.equals("CONSULT HANDBOOK")) {
                        context = faultCodeFragment2.mContext.getString(R.string.diagnose_consult_handbook);
                    }
                    arrayList.add(context);
                }
                if (arrayList.size() != 0) {
                    DiagnoseConstants.FAULTCODE_REFRESH = false;
                    FittingsSearchFragment fittingsSearchFragment = new FittingsSearchFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("fittingsearchkey", arrayList);
                    fittingsSearchFragment.setArguments(bundle);
                    faultCodeFragment2.f12357d.mo7098a((Fragment) fittingsSearchFragment, FaultCodeFragment.class.getName(), true);
                }
            }
        }
    }
}
