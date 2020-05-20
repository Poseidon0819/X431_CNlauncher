package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.utils.C4394o;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.r */
/* loaded from: classes2.dex */
public final class C4476r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4474p f23495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4476r(C4474p c4474p) {
        this.f23495a = c4474p;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23495a.m669s());
        sb.append("_select_installment");
        String[] strArr = C4394o.f23203f;
        new Object[1][0] = Integer.valueOf(i);
        this.f23495a.m628a(i);
        popupWindow = this.f23495a.f23484q;
        if (popupWindow != null) {
            popupWindow2 = this.f23495a.f23484q;
            popupWindow2.dismiss();
        }
    }
}
