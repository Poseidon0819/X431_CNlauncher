package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.t */
/* loaded from: classes2.dex */
public final class C4478t implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4474p f23497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4478t(C4474p c4474p) {
        this.f23497a = c4474p;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlertDialog alertDialog;
        this.f23497a.m628a(i);
        alertDialog = this.f23497a.f23483p;
        alertDialog.dismiss();
    }
}
