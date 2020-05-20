package com.cnlaunch.x431pro.activity.upgrade;

import android.support.p012v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.List;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bb */
/* loaded from: classes.dex */
final class C2649bb implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2649bb(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15234a = upgradeFragmentForPro;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        ViewPager viewPager;
        ViewPager viewPager2;
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
        List list14;
        int i14;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list15;
        UpgradeAdapter upgradeAdapter2;
        List list16;
        int i15;
        List list17;
        int i16;
        List list18;
        int i17;
        List list19;
        int i18;
        List list20;
        int i19;
        List list21;
        int i20;
        List list22;
        int i21;
        List list23;
        int i22;
        List list24;
        int i23;
        List list25;
        int i24;
        List list26;
        int i25;
        List list27;
        int i26;
        List list28;
        int i27;
        UpgradeAdapter upgradeAdapter3;
        List<X431PadDtoSoft> list29;
        UpgradeAdapter upgradeAdapter4;
        try {
            list = this.f15234a.f15193av;
            X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) list.get(i);
            viewPager = this.f15234a.f15199c;
            if (viewPager.getCurrentItem() == 0) {
                list16 = this.f15234a.f15191at;
                i15 = this.f15234a.f15189ar;
                if (((X431PadDtoSoft) list16.get(i15)).getVersionNo().compareToIgnoreCase(x431PadDtoSoft.getVersionNo()) == 0) {
                    return;
                }
                list17 = this.f15234a.f15191at;
                i16 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list17.get(i16)).setVersionNo(x431PadDtoSoft.getVersionNo());
                list18 = this.f15234a.f15191at;
                i17 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list18.get(i17)).setVersionDetailId(x431PadDtoSoft.getVersionDetailId());
                list19 = this.f15234a.f15191at;
                i18 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list19.get(i18)).setSoftName(x431PadDtoSoft.getSoftName());
                list20 = this.f15234a.f15191at;
                i19 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list20.get(i19)).setSoftId(x431PadDtoSoft.getSoftId());
                list21 = this.f15234a.f15191at;
                i20 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list21.get(i20)).setSoftUpdateTime(x431PadDtoSoft.getSoftUpdateTime());
                list22 = this.f15234a.f15191at;
                i21 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list22.get(i21)).setSoftPackageID(x431PadDtoSoft.getSoftPackageID());
                list23 = this.f15234a.f15191at;
                i22 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list23.get(i22)).setDiagVehicleType(x431PadDtoSoft.getDiagVehicleType());
                list24 = this.f15234a.f15191at;
                i23 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list24.get(i23)).setSoftApplicableArea(x431PadDtoSoft.getSoftApplicableArea());
                list25 = this.f15234a.f15191at;
                i24 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list25.get(i24)).setFileSize(x431PadDtoSoft.getFileSize());
                list26 = this.f15234a.f15191at;
                i25 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list26.get(i25)).setServerCurrentTime(x431PadDtoSoft.getServerCurrentTime());
                list27 = this.f15234a.f15191at;
                i26 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list27.get(i26)).setFreeUseEndTime(x431PadDtoSoft.getFreeUseEndTime());
                list28 = this.f15234a.f15191at;
                i27 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list28.get(i27)).setLanId(x431PadDtoSoft.getLanId());
                upgradeAdapter3 = this.f15234a.f15143F;
                list29 = this.f15234a.f15191at;
                upgradeAdapter3.m5807a(list29);
                upgradeAdapter4 = this.f15234a.f15143F;
                upgradeAdapter4.notifyDataSetChanged();
                return;
            }
            viewPager2 = this.f15234a.f15199c;
            if (1 == viewPager2.getCurrentItem()) {
                list2 = this.f15234a.f15192au;
                i2 = this.f15234a.f15189ar;
                if (((X431PadDtoSoft) list2.get(i2)).getVersionNo().compareToIgnoreCase(x431PadDtoSoft.getVersionNo()) == 0) {
                    return;
                }
                list3 = this.f15234a.f15192au;
                i3 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list3.get(i3)).setVersionNo(x431PadDtoSoft.getVersionNo());
                list4 = this.f15234a.f15192au;
                i4 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list4.get(i4)).setVersionDetailId(x431PadDtoSoft.getVersionDetailId());
                list5 = this.f15234a.f15192au;
                i5 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list5.get(i5)).setSoftName(x431PadDtoSoft.getSoftName());
                list6 = this.f15234a.f15192au;
                i6 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list6.get(i6)).setSoftId(x431PadDtoSoft.getSoftId());
                list7 = this.f15234a.f15192au;
                i7 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list7.get(i7)).setSoftUpdateTime(x431PadDtoSoft.getSoftUpdateTime());
                list8 = this.f15234a.f15192au;
                i8 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list8.get(i8)).setSoftPackageID(x431PadDtoSoft.getSoftPackageID());
                list9 = this.f15234a.f15192au;
                i9 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list9.get(i9)).setDiagVehicleType(x431PadDtoSoft.getDiagVehicleType());
                list10 = this.f15234a.f15192au;
                i10 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list10.get(i10)).setSoftApplicableArea(x431PadDtoSoft.getSoftApplicableArea());
                list11 = this.f15234a.f15192au;
                i11 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list11.get(i11)).setFileSize(x431PadDtoSoft.getFileSize());
                list12 = this.f15234a.f15192au;
                i12 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list12.get(i12)).setServerCurrentTime(x431PadDtoSoft.getServerCurrentTime());
                list13 = this.f15234a.f15192au;
                i13 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list13.get(i13)).setFreeUseEndTime(x431PadDtoSoft.getFreeUseEndTime());
                list14 = this.f15234a.f15192au;
                i14 = this.f15234a.f15189ar;
                ((X431PadDtoSoft) list14.get(i14)).setLanId(x431PadDtoSoft.getLanId());
                upgradeAdapter = this.f15234a.f15146I;
                list15 = this.f15234a.f15192au;
                upgradeAdapter.m5807a(list15);
                upgradeAdapter2 = this.f15234a.f15146I;
                upgradeAdapter2.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
