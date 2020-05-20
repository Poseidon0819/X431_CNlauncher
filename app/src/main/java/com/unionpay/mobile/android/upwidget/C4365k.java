package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.k */
/* loaded from: classes2.dex */
public final class C4365k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4363j f23137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4365k(C4363j c4363j) {
        this.f23137a = c4363j;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        int i5;
        int i6;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i7;
        i2 = this.f23137a.f23120o;
        view.setTag(Integer.valueOf(i2));
        i3 = this.f23137a.f23119n;
        i4 = this.f23137a.f23109d;
        if (i3 != i4) {
            arrayList3 = this.f23137a.f23112g;
            i7 = this.f23137a.f23119n;
            Object obj = arrayList3.get(i7);
            if (obj instanceof C4356c) {
                ((C4356c) obj).m979a(-1);
            }
        }
        arrayList = this.f23137a.f23112g;
        i5 = this.f23137a.f23120o;
        Object obj2 = arrayList.get(i5);
        if (obj2 instanceof C4356c) {
            ((C4356c) obj2).m979a(i);
        }
        C4363j c4363j = this.f23137a;
        i6 = c4363j.f23120o;
        c4363j.f23119n = i6;
        this.f23137a.f23121p = i;
        arrayList2 = this.f23137a.f23125t;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((AdapterView.OnItemClickListener) it.next()).onItemClick(adapterView, view, i, j);
        }
    }
}
