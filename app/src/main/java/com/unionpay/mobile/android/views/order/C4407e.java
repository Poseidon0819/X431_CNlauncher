package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.views.order.e */
/* loaded from: classes2.dex */
public final class C4407e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4402b f23260a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4407e(C4402b c4402b) {
        this.f23260a = c4402b;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f23260a.m793c(i);
    }
}
