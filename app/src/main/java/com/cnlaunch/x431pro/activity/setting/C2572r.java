package com.cnlaunch.x431pro.activity.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnosticLogVehicleListFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.r */
/* loaded from: classes.dex */
public final class C2572r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DiagnosticLogVehicleListFragment f14841a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2572r(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        this.f14841a = diagnosticLogVehicleListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new Bundle();
        CarIcon carIcon = (CarIcon) adapterView.getItemAtPosition(i);
        this.f14841a.f14828k = carIcon.f15778b;
        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
            this.f14841a.f14827j = carIcon.f15792p;
        } else {
            this.f14841a.f14827j = carIcon.f15779c.toUpperCase(Locale.getDefault());
        }
        DiagnosticLogVehicleListFragment.m5901i(this.f14841a);
        DiagnosticLogVehicleListFragment.m5894p(this.f14841a);
    }
}
