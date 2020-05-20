package com.unionpay.mobile.android.upwidget;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.upwidget.C4363j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.p */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4370p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4363j f23142a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4370p(C4363j c4363j) {
        this.f23142a = c4363j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        boolean z;
        C4363j.C4364a[] c4364aArr;
        C4363j.C4364a[] c4364aArr2;
        ArrayList arrayList;
        C4363j.C4364a[] c4364aArr3;
        int intValue = ((Integer) view.getTag()).intValue();
        i = this.f23142a.f23120o;
        if (intValue == i) {
            return;
        }
        this.f23142a.m956a(intValue);
        z = this.f23142a.f23110e;
        if (z) {
            c4364aArr = this.f23142a.f23111f;
            if (!TextUtils.isEmpty(c4364aArr[intValue].f23135d)) {
                c4364aArr2 = this.f23142a.f23111f;
                view.setTag(c4364aArr2[intValue].f23135d);
                arrayList = this.f23142a.f23128w;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                C4363j c4363j = this.f23142a;
                c4364aArr3 = c4363j.f23111f;
                c4363j.m952a((LinearLayout) c4364aArr3[intValue].f23134c, true, "正在查询。。。", null, null);
                C4363j.m923o(this.f23142a);
            }
        }
        view.setTag(Integer.valueOf(intValue));
    }
}
