package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DivisionSoftUpgradeTipDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ac */
/* loaded from: classes.dex */
public final class C2806ac implements AdapterClickListenter {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16139a;

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4707a(View view, String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2806ac(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16139a = view$OnClickListenerC2884z;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4708a() {
        List list;
        boolean z;
        List list2;
        IconButton iconButton;
        IconButton iconButton2;
        IconButton iconButton3;
        List list3;
        IconButton iconButton4;
        IconButton iconButton5;
        IconButton iconButton6;
        List list4;
        IconButton iconButton7;
        IconButton iconButton8;
        IconButton iconButton9;
        List<DivisionSoftDto> list5;
        list = this.f16139a.f16481o;
        if (list != null) {
            list5 = this.f16139a.f16481o;
            for (DivisionSoftDto divisionSoftDto : list5) {
                if (!divisionSoftDto.isMust() && divisionSoftDto.isChecked()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        NLog.m9456a("yhx", "selectAllChanged enter,selected=".concat(String.valueOf(z)));
        if (z) {
            iconButton7 = this.f16139a.f16482p;
            iconButton7.setChecked(true);
            iconButton8 = this.f16139a.f16482p;
            iconButton8.setClickable(true);
            iconButton9 = this.f16139a.f16482p;
            iconButton9.setText(R.string.common_unselect);
        } else {
            list2 = this.f16139a.f16481o;
            if (list2 != null) {
                list3 = this.f16139a.f16481o;
                if (!list3.isEmpty()) {
                    iconButton4 = this.f16139a.f16482p;
                    iconButton4.setChecked(false);
                    iconButton5 = this.f16139a.f16482p;
                    iconButton5.setClickable(true);
                    iconButton6 = this.f16139a.f16482p;
                    iconButton6.setText(R.string.common_select);
                }
            }
            iconButton = this.f16139a.f16482p;
            iconButton.setChecked(false);
            iconButton2 = this.f16139a.f16482p;
            iconButton2.setClickable(false);
            iconButton3 = this.f16139a.f16482p;
            iconButton3.setText(R.string.common_select);
        }
        StringBuilder sb = new StringBuilder("divisionSoftDtoList=");
        list4 = this.f16139a.f16481o;
        sb.append(list4);
        NLog.m9456a("yhx", sb.toString());
    }
}
