package com.cnlaunch.x431pro.activity.p211a.p212a;

import android.view.View;
import com.cnlaunch.x431pro.activity.p211a.HistoryFragment;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.utils.C2744aa;

/* compiled from: HistoryDiagDesItemAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.a.d */
/* loaded from: classes.dex */
final class View$OnClickListenerC1972d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f10821a;

    /* renamed from: b */
    final /* synthetic */ VehicleInfo f10822b;

    /* renamed from: c */
    final /* synthetic */ HistoryDiagDesItemAdapter f10823c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1972d(HistoryDiagDesItemAdapter historyDiagDesItemAdapter, int i, VehicleInfo vehicleInfo) {
        this.f10823c = historyDiagDesItemAdapter;
        this.f10821a = i;
        this.f10822b = vehicleInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        HistoryFragment historyFragment;
        HistoryFragment historyFragment2;
        z = this.f10823c.f10812g;
        if (!z) {
            historyFragment = this.f10823c.f10808c;
            if (historyFragment != null) {
                historyFragment2 = this.f10823c.f10808c;
                VehicleInfo vehicleInfo = this.f10822b;
                if (vehicleInfo != null) {
                    C2744aa.m5188a(historyFragment2.getActivity(), vehicleInfo, false);
                    return;
                }
                return;
            }
            return;
        }
        this.f10823c.m7846a(this.f10821a);
    }
}
