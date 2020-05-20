package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.d */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4357d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4356c f23084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4357d(C4356c c4356c) {
        this.f23084a = c4356c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f23084a.f23082l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
