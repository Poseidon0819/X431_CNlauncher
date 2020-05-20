package com.cnlaunch.x431pro.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: TesterInfoDropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.s */
/* loaded from: classes.dex */
final class C2948s implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ TesterInfoDropdownEditText f16737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2948s(TesterInfoDropdownEditText testerInfoDropdownEditText) {
        this.f16737a = testerInfoDropdownEditText;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TesterInfoDropdownEditText testerInfoDropdownEditText = this.f16737a;
        testerInfoDropdownEditText.setText(testerInfoDropdownEditText.f16090d.get(i));
        TesterInfoDropdownEditText testerInfoDropdownEditText2 = this.f16737a;
        testerInfoDropdownEditText2.setSelection(testerInfoDropdownEditText2.f16090d.get(i).length());
        this.f16737a.f16094h.sendEmptyMessage(1);
    }
}
