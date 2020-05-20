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
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.av */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2643av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragmentForPro f15227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2643av(UpgradeFragmentForPro upgradeFragmentForPro) {
        this.f15227a = upgradeFragmentForPro;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean m5657k;
        List list;
        Context context;
        Context context2;
        Context context3;
        String str;
        List list2;
        Context context4;
        Context context5;
        List list3;
        List<X431PadDtoSoft> list4;
        List list5;
        Context context6;
        List list6;
        List<X431PadDtoSoft> list7;
        String str2;
        CheckBox checkBox;
        List list8;
        List list9;
        List<X431PadDtoSoft> list10;
        UpgradeAdapter upgradeAdapter;
        List<X431PadDtoSoft> list11;
        UpgradeAdapter upgradeAdapter2;
        boolean z = true;
        boolean z2 = false;
        switch (view.getId()) {
            case R.id.btn_renewal /* 2131296530 */:
                Bundle bundle = new Bundle();
                str = this.f15227a.f15184am;
                bundle.putString("serialNo", str);
                this.f15227a.addFragment(PayTypeFragment.class.getName(), bundle);
                break;
            case R.id.button_delete /* 2131296610 */:
                ArrayList arrayList = new ArrayList();
                list2 = this.f15227a.f15191at;
                if (list2 != null) {
                    list3 = this.f15227a.f15191at;
                    if (list3.size() > 0) {
                        list4 = this.f15227a.f15191at;
                        boolean z3 = true;
                        boolean z4 = false;
                        for (X431PadDtoSoft x431PadDtoSoft : list4) {
                            if (x431PadDtoSoft.isChecked()) {
                                arrayList.add(x431PadDtoSoft);
                                z3 = false;
                            }
                            if (x431PadDtoSoft.getCarDivisionSoftDtoList() != null && !x431PadDtoSoft.getCarDivisionSoftDtoList().isEmpty()) {
                                for (DivisionSoftDto divisionSoftDto : x431PadDtoSoft.getCarDivisionSoftDtoList()) {
                                    if (divisionSoftDto.isChecked()) {
                                        z4 = true;
                                    }
                                }
                            }
                        }
                        z = z3;
                        z2 = z4;
                    }
                }
                if (!z) {
                    LoadDialog.m4679c(this.f15227a.getActivity(), this.f15227a.getString(R.string.delete_now));
                    FixedThreadPool.m4928a().m4927a(new RunnableC2644aw(this, arrayList));
                    return;
                } else if (z2) {
                    context5 = this.f15227a.mContext;
                    NToast.m9450a(context5, (int) R.string.delete_division_tip);
                    return;
                } else {
                    context4 = this.f15227a.mContext;
                    NToast.m9450a(context4, (int) R.string.common_unselect_any);
                    return;
                }
            case R.id.button_refresh /* 2131296614 */:
                break;
            case R.id.button_update /* 2131296619 */:
                ArrayList arrayList2 = new ArrayList();
                list5 = this.f15227a.f15191at;
                if (list5 != null) {
                    list6 = this.f15227a.f15191at;
                    if (list6.size() > 0) {
                        list7 = this.f15227a.f15191at;
                        for (X431PadDtoSoft x431PadDtoSoft2 : list7) {
                            if (x431PadDtoSoft2.isChecked()) {
                                arrayList2.add(x431PadDtoSoft2);
                                str2 = this.f15227a.f15186ao;
                                x431PadDtoSoft2.setLanId(str2);
                                z = false;
                            }
                            if (x431PadDtoSoft2.isHaveDivisions()) {
                                for (DivisionSoftDto divisionSoftDto2 : x431PadDtoSoft2.getCarDivisionSoftDtoList()) {
                                    if (divisionSoftDto2.isChecked()) {
                                        if (!arrayList2.contains(x431PadDtoSoft2)) {
                                            arrayList2.add(x431PadDtoSoft2);
                                        }
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    context6 = this.f15227a.mContext;
                    NToast.m9450a(context6, (int) R.string.common_unselect_any);
                    return;
                }
                LruCacheManager.m9599a().m9596a("downloadList", UpgradeFragmentForPro.m5703a(arrayList2));
                this.f15227a.addFragment(DownloadFragment.class.getName());
                UpgradeFragmentForPro.m5650o(this.f15227a);
                return;
            case R.id.checkBox_select_all /* 2131296743 */:
                checkBox = this.f15227a.f15155R;
                boolean isChecked = checkBox.isChecked();
                list8 = this.f15227a.f15191at;
                if (list8 != null) {
                    list9 = this.f15227a.f15191at;
                    if (list9.size() > 0) {
                        list10 = this.f15227a.f15191at;
                        for (X431PadDtoSoft x431PadDtoSoft3 : list10) {
                            if (!x431PadDtoSoft3.isMust()) {
                                x431PadDtoSoft3.setChecked(isChecked);
                            }
                            if (x431PadDtoSoft3.isHaveDivisions()) {
                                for (DivisionSoftDto divisionSoftDto3 : x431PadDtoSoft3.getCarDivisionSoftDtoList()) {
                                    if (!divisionSoftDto3.isMust()) {
                                        divisionSoftDto3.setChecked(isChecked);
                                    }
                                }
                            }
                        }
                        upgradeAdapter = this.f15227a.f15143F;
                        list11 = this.f15227a.f15191at;
                        upgradeAdapter.m5807a(list11);
                        upgradeAdapter2 = this.f15227a.f15143F;
                        upgradeAdapter2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
        this.f15227a.m5678b();
        m5657k = this.f15227a.m5657k();
        if (m5657k) {
            this.f15227a.m5655l();
            list = this.f15227a.f15149L;
            if (list.size() == 0) {
                context3 = this.f15227a.mContext;
                new LoginFunction(context3).m6553a(UIMsg.d_ResultType.NEWVERSION_DOWNLOAD);
                return;
            }
            context = this.f15227a.mContext;
            context2 = this.f15227a.mContext;
            LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
            this.f15227a.request(2101);
        }
    }
}
