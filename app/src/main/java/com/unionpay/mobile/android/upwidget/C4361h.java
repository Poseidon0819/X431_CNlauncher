package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.upwidget.h */
/* loaded from: classes2.dex */
public final class C4361h implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4360g f23100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4361h(C4360g c4360g) {
        this.f23100a = c4360g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        arrayList = this.f23100a.f23096c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AdapterView.OnItemClickListener) it.next()).onItemClick(adapterView, view, i, j);
        }
    }
}
