package com.cnlaunch.x431pro.activity.mine;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

/* compiled from: ChangeEmailFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.h */
/* loaded from: classes.dex */
final class C2486h implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChangeEmailFragment f14228a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2486h(ChangeEmailFragment changeEmailFragment) {
        this.f14228a = changeEmailFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f14228a.f14225e;
        button.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        Button button;
        editText = this.f14228a.f14226f;
        if (TextUtils.isEmpty(editText.getText().toString())) {
            return;
        }
        button = this.f14228a.f14225e;
        button.setEnabled(true);
    }
}
