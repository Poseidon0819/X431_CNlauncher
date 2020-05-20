package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p120d.p121a.LruCacheManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.mine.PayTypeFragment;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bo */
/* loaded from: classes.dex */
final class View$OnClickListenerC2662bo implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2662bo(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15248a = upgradeFragmentForPro;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        boolean m5657k;
        List list;
        Context context;
        Context context2;
        Context context3;
        List list2;
        Context context4;
        List list3;
        List<X431PadDtoSoft> list4;
        String str2;
        CheckBox checkBox;
        List list5;
        List list6;
        List<X431PadDtoSoft> list7;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list8;
        UpgradeAdapter upgradeAdapter2;
        int id = view.getId();
        if (id == R.id.btn_renewal) {
            Bundle bundle = new Bundle();
            str = this.f15248a.f15184am;
            bundle.putString("serialNo", str);
            this.f15248a.addFragment(PayTypeFragment.class.getName(), bundle);
        } else if (id != R.id.button_refresh) {
            if (id != R.id.button_update) {
                if (id != R.id.checkBox_select_all) {
                    return;
                }
                checkBox = this.f15248a.f15162Y;
                boolean isChecked = checkBox.isChecked();
                list5 = this.f15248a.f15192au;
                if (list5 != null) {
                    list6 = this.f15248a.f15192au;
                    if (list6.size() > 0) {
                        list7 = this.f15248a.f15192au;
                        for (X431PadDtoSoft x431PadDtoSoft : list7) {
                            if (!x431PadDtoSoft.isMust()) {
                                x431PadDtoSoft.setChecked(isChecked);
                            }
                            if (x431PadDtoSoft.isHaveDivisions()) {
                                for (DivisionSoftDto divisionSoftDto : x431PadDtoSoft.getCarDivisionSoftDtoList()) {
                                    if (!divisionSoftDto.isMust()) {
                                        divisionSoftDto.setChecked(isChecked);
                                    }
                                }
                            }
                        }
                        upgradeAdapter = this.f15248a.f15146I;
                        list8 = this.f15248a.f15192au;
                        upgradeAdapter.m5807a(list8);
                        upgradeAdapter2 = this.f15248a.f15146I;
                        upgradeAdapter2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z = true;
            ArrayList arrayList = new ArrayList();
            list2 = this.f15248a.f15192au;
            if (list2 != null) {
                list3 = this.f15248a.f15192au;
                if (list3.size() > 0) {
                    list4 = this.f15248a.f15192au;
                    for (X431PadDtoSoft x431PadDtoSoft2 : list4) {
                        if (x431PadDtoSoft2.isChecked()) {
                            arrayList.add(x431PadDtoSoft2);
                            str2 = this.f15248a.f15186ao;
                            x431PadDtoSoft2.setLanId(str2);
                            z = false;
                        }
                        if (x431PadDtoSoft2.isHaveDivisions()) {
                            for (DivisionSoftDto divisionSoftDto2 : x431PadDtoSoft2.getCarDivisionSoftDtoList()) {
                                if (divisionSoftDto2.isChecked()) {
                                    if (!arrayList.contains(x431PadDtoSoft2)) {
                                        arrayList.add(x431PadDtoSoft2);
                                    }
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                context4 = this.f15248a.mContext;
                NToast.m9450a(context4, (int) R.string.common_unselect_any);
                return;
            }
            LruCacheManager.m9599a().m9596a("downloadList", UpgradeFragmentForPro.m5703a(arrayList));
            this.f15248a.addFragment(DownloadFragment.class.getName());
            UpgradeFragmentForPro.m5650o(this.f15248a);
            return;
        }
        this.f15248a.m5678b();
        m5657k = this.f15248a.m5657k();
        if (m5657k) {
            this.f15248a.m5655l();
            list = this.f15248a.f15149L;
            if (list.size() == 0) {
                context3 = this.f15248a.mContext;
                new LoginFunction(context3).m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
                return;
            }
            context = this.f15248a.mContext;
            context2 = this.f15248a.mContext;
            LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
            this.f15248a.request(2101);
        }
    }
}
