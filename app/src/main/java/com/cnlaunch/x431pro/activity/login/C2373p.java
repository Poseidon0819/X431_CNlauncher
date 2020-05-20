package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CountrySelectActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.p */
/* loaded from: classes.dex */
final class C2373p implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CountrySelectActivity f13529a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2373p(CountrySelectActivity countrySelectActivity) {
        this.f13529a = countrySelectActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f13529a.m6791c(charSequence.toString().toLowerCase());
    }
}
