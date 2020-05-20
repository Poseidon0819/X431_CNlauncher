package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SpinnerPopupWindow.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.cv */
/* loaded from: classes.dex */
final class C2861cv implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SpinnerPopupWindow f16388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2861cv(SpinnerPopupWindow spinnerPopupWindow) {
        this.f16388a = spinnerPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f16388a.f16383b != null) {
            this.f16388a.f16383b.onItemClick(adapterView, view, i, j);
        }
        if (this.f16388a.f16382a == null || !this.f16388a.f16382a.isShowing()) {
            return;
        }
        this.f16388a.f16382a.dismiss();
    }
}
