package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.i */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4362i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4360g f23101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4362i(C4360g c4360g) {
        this.f23101a = c4360g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f23101a.f23097d;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
