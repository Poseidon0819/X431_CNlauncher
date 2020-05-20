package com.cnlaunch.x431pro.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: VinDropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.v */
/* loaded from: classes.dex */
final class C2983v implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ VinDropdownEditText f16962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2983v(VinDropdownEditText vinDropdownEditText) {
        this.f16962a = vinDropdownEditText;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        VinDropdownEditText vinDropdownEditText = this.f16962a;
        vinDropdownEditText.setText(vinDropdownEditText.f16105d.get(i));
        VinDropdownEditText vinDropdownEditText2 = this.f16962a;
        vinDropdownEditText2.setSelection(vinDropdownEditText2.f16105d.get(i).length());
        this.f16962a.f16110i.sendEmptyMessage(1);
    }
}
