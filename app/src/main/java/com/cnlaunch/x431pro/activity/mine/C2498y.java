package com.cnlaunch.x431pro.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CountryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.y */
/* loaded from: classes.dex */
final class C2498y implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CountryFragment f14334a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2498y(CountryFragment countryFragment) {
        this.f14334a = countryFragment;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CountryFragment.m6088a(this.f14334a, charSequence.toString().toLowerCase());
    }
}
