package com.cnlaunch.x431pro.activity.login;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bn */
/* loaded from: classes.dex */
final class C2342bn implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2342bn(RegistMerchantActivity registMerchantActivity) {
        this.f13449a = registMerchantActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        Button button;
        checkBox = this.f13449a.f13277C;
        if (checkBox != compoundButton) {
            return;
        }
        button = this.f13449a.f13311n;
        button.setEnabled(z);
    }
}
