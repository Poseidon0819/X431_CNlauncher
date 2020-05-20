package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SpeciaFunctionListViewAdapter;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bx */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2155bx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2155bx(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12229a = speciaFunctionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter2;
        boolean z;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter3;
        ArrayList arrayList;
        speciaFunctionListViewAdapter = this.f12229a.f12210n;
        if (speciaFunctionListViewAdapter != null) {
            speciaFunctionListViewAdapter2 = this.f12229a.f12210n;
            int i = 0;
            while (true) {
                if (i >= speciaFunctionListViewAdapter2.f11427a.size()) {
                    z = false;
                    break;
                } else if (speciaFunctionListViewAdapter2.f11427a.get(i).get(0).isCheck()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                speciaFunctionListViewAdapter3 = this.f12229a.f12210n;
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < speciaFunctionListViewAdapter3.f11427a.size(); i2++) {
                    sb.append((speciaFunctionListViewAdapter3.f11427a == null || speciaFunctionListViewAdapter3.f11427a.size() <= 0) ? false : speciaFunctionListViewAdapter3.f11427a.get(i2).get(0).isCheck() ? "1" : "0");
                }
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder("010000");
                arrayList = this.f12229a.f12208k;
                sb3.append(ByteHexHelper.intToTwoHexString((arrayList.size() + 7) / 8));
                sb3.append(ByteHexHelper.binaryString2hexString(sb2));
                this.f12229a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPT_SpecialMultiSelectBox, sb3.toString(), 3);
                return;
            }
            NToast.m9447b(this.f12229a.getActivity(), (int) R.string.common_unselect_any);
        }
    }
}
