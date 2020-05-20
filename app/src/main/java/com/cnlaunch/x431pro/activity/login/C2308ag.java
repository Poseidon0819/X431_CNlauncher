package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* compiled from: RegistActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ag */
/* loaded from: classes.dex */
final class C2308ag implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ RegistActivity f13415a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2308ag(RegistActivity registActivity) {
        this.f13415a = registActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        RegistActivity registActivity = this.f13415a;
        editText = registActivity.f13172ap;
        registActivity.f13184bb = editText.getText().toString();
    }
}
