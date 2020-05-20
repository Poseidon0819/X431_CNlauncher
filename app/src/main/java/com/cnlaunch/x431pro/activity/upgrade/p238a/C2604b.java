package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.widget.CompoundButton;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;

/* compiled from: DivisionSoftAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.b */
/* loaded from: classes.dex */
final class C2604b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDto f14999a;

    /* renamed from: b */
    final /* synthetic */ DivisionSoftAdapter f15000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2604b(DivisionSoftAdapter divisionSoftAdapter, DivisionSoftDto divisionSoftDto) {
        this.f15000b = divisionSoftAdapter;
        this.f14999a = divisionSoftDto;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AdapterClickListenter adapterClickListenter;
        this.f14999a.setChecked(z);
        adapterClickListenter = this.f15000b.f14993d;
        adapterClickListenter.mo4708a();
    }
}
