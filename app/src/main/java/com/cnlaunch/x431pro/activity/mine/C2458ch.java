package com.cnlaunch.x431pro.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ProvinceFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ch */
/* loaded from: classes.dex */
final class C2458ch implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ProvinceFragment f14048a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2458ch(ProvinceFragment provinceFragment) {
        this.f14048a = provinceFragment;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ProvinceFragment.m6253a(this.f14048a, charSequence.toString().toLowerCase());
    }
}
