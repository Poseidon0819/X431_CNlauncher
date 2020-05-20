package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CanRemoveEdit.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.b */
/* loaded from: classes.dex */
final class C2187b implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CanRemoveEdit f12442a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2187b(CanRemoveEdit canRemoveEdit) {
        this.f12442a = canRemoveEdit;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f12442a.m7065a();
    }
}
