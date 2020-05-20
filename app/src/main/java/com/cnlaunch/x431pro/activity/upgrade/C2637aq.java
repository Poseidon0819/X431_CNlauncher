package com.cnlaunch.x431pro.activity.upgrade;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.aq */
/* loaded from: classes.dex */
final class C2637aq implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2637aq(UpgradeFragment upgradeFragment) {
        this.f15134a = upgradeFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        int i2;
        List list3;
        int i3;
        List list4;
        int i4;
        List list5;
        int i5;
        List list6;
        int i6;
        List list7;
        int i7;
        List list8;
        int i8;
        List list9;
        int i9;
        List list10;
        int i10;
        List list11;
        int i11;
        List list12;
        int i12;
        List list13;
        int i13;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list14;
        UpgradeAdapter upgradeAdapter2;
        try {
            list = this.f15134a.f15083Q;
            X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) list.get(i);
            list2 = this.f15134a.f15082P;
            i2 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list2.get(i2)).setVersionNo(x431PadDtoSoft.getVersionNo());
            list3 = this.f15134a.f15082P;
            i3 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list3.get(i3)).setVersionDetailId(x431PadDtoSoft.getVersionDetailId());
            list4 = this.f15134a.f15082P;
            i4 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list4.get(i4)).setSoftName(x431PadDtoSoft.getSoftName());
            list5 = this.f15134a.f15082P;
            i5 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list5.get(i5)).setSoftId(x431PadDtoSoft.getSoftId());
            list6 = this.f15134a.f15082P;
            i6 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list6.get(i6)).setSoftUpdateTime(x431PadDtoSoft.getSoftUpdateTime());
            list7 = this.f15134a.f15082P;
            i7 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list7.get(i7)).setSoftPackageID(x431PadDtoSoft.getSoftPackageID());
            list8 = this.f15134a.f15082P;
            i8 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list8.get(i8)).setDiagVehicleType(x431PadDtoSoft.getDiagVehicleType());
            list9 = this.f15134a.f15082P;
            i9 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list9.get(i9)).setSoftApplicableArea(x431PadDtoSoft.getSoftApplicableArea());
            list10 = this.f15134a.f15082P;
            i10 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list10.get(i10)).setFileSize(x431PadDtoSoft.getFileSize());
            list11 = this.f15134a.f15082P;
            i11 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list11.get(i11)).setServerCurrentTime(x431PadDtoSoft.getServerCurrentTime());
            list12 = this.f15134a.f15082P;
            i12 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list12.get(i12)).setFreeUseEndTime(x431PadDtoSoft.getFreeUseEndTime());
            list13 = this.f15134a.f15082P;
            i13 = this.f15134a.f15081O;
            ((X431PadDtoSoft) list13.get(i13)).setLanId(x431PadDtoSoft.getLanId());
            upgradeAdapter = this.f15134a.f15112r;
            list14 = this.f15134a.f15082P;
            upgradeAdapter.m5807a(list14);
            upgradeAdapter2 = this.f15134a.f15112r;
            upgradeAdapter2.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
