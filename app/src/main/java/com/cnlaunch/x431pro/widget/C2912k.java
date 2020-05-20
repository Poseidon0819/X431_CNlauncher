package com.cnlaunch.x431pro.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: DropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.k */
/* loaded from: classes.dex */
final class C2912k implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DropdownEditText f16585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2912k(DropdownEditText dropdownEditText) {
        this.f16585a = dropdownEditText;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        DropdownEditText dropdownEditText = this.f16585a;
        dropdownEditText.setText(dropdownEditText.f16000d.get(i));
        this.f16585a.f15999c.setText(this.f16585a.f16002f.m9591a(this.f16585a.f16000d.get(i)));
        this.f16585a.f16004h.sendEmptyMessage(1);
    }
}
