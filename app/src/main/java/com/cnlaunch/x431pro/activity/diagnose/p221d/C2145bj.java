package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;

/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bj */
/* loaded from: classes.dex */
final class C2145bj implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2144bi f12100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2145bj(View$OnClickListenerC2144bi view$OnClickListenerC2144bi) {
        this.f12100a = view$OnClickListenerC2144bi;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str;
        this.f12100a.f12096a.setText((CharSequence) this.f12100a.f12097b.get(i));
        str = this.f12100a.f12099d.f12080o;
        if (str.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
            MulitInputFragment.m7205b(this.f12100a.f12099d, this.f12100a.f12098c);
        }
    }
}
