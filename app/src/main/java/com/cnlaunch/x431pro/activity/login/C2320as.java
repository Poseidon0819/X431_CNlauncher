package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.as */
/* loaded from: classes.dex */
final class C2320as implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13427a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2320as(RegistActivity registActivity) {
        this.f13427a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f13427a.m6709i();
    }
}
