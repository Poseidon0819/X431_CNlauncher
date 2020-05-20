package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.upgrade.p238a.DivisionSoftAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.widget.a.aa */
/* loaded from: classes.dex */
final class DivisionSoftUpgradeTipDialog implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2884z f16137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DivisionSoftUpgradeTipDialog(View$OnClickListenerC2884z view$OnClickListenerC2884z) {
        this.f16137a = view$OnClickListenerC2884z;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        List list3;
        List list4;
        DivisionSoftAdapter divisionSoftAdapter;
        List<DivisionSoftDto> list5;
        DivisionSoftAdapter divisionSoftAdapter2;
        List list6;
        List list7;
        List list8;
        NLog.m9456a("yhx", "onItemClick enter, position=".concat(String.valueOf(i)));
        try {
            list = this.f16137a.f16481o;
            if (list != null) {
                list2 = this.f16137a.f16481o;
                if (list2.size() > 0) {
                    list3 = this.f16137a.f16481o;
                    if (!((DivisionSoftDto) list3.get(i)).isMust()) {
                        list6 = this.f16137a.f16481o;
                        if (((DivisionSoftDto) list6.get(i)).isChecked()) {
                            list8 = this.f16137a.f16481o;
                            ((DivisionSoftDto) list8.get(i)).setChecked(false);
                        } else {
                            list7 = this.f16137a.f16481o;
                            ((DivisionSoftDto) list7.get(i)).setChecked(true);
                        }
                    }
                    list4 = this.f16137a.f16481o;
                    synchronized (list4) {
                        divisionSoftAdapter = this.f16137a.f16475i;
                        list5 = this.f16137a.f16481o;
                        divisionSoftAdapter.m5813a(list5);
                        divisionSoftAdapter2 = this.f16137a.f16475i;
                        divisionSoftAdapter2.notifyDataSetChanged();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
