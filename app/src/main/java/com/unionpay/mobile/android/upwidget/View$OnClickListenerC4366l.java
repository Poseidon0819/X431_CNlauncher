package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.l */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4366l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4363j f23138a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4366l(C4363j c4363j) {
        this.f23138a = c4363j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f23138a.f23126u;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
