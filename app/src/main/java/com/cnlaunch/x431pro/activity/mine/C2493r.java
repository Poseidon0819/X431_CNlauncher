package com.cnlaunch.x431pro.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.r */
/* loaded from: classes.dex */
final class C2493r implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CityFragment f14282a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2493r(CityFragment cityFragment) {
        this.f14282a = cityFragment;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CityFragment.m6110a(this.f14282a, charSequence.toString().toLowerCase());
    }
}
