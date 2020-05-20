package com.unionpay.mobile.android.upwidget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.o */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4369o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4363j f23141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4369o(C4363j c4363j) {
        this.f23141a = c4363j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i5;
        i = this.f23141a.f23119n;
        i2 = this.f23141a.f23109d;
        if (i != i2) {
            arrayList2 = this.f23141a.f23112g;
            i5 = this.f23141a.f23119n;
            Object obj = arrayList2.get(i5);
            if (obj instanceof C4356c) {
                ((C4356c) obj).m979a(-1);
            }
        }
        C4363j c4363j = this.f23141a;
        i3 = c4363j.f23120o;
        c4363j.f23119n = i3;
        C4363j c4363j2 = this.f23141a;
        i4 = c4363j2.f23109d;
        c4363j2.f23121p = i4;
        arrayList = this.f23141a.f23129x;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
    }
}
