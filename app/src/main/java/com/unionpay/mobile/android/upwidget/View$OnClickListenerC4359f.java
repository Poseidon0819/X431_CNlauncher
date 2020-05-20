package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.f */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4359f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4358e f23093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4359f(C4358e c4358e) {
        this.f23093a = c4358e;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList arrayList;
        arrayList = this.f23093a.f23091g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
