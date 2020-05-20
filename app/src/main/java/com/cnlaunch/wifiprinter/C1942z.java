package com.cnlaunch.wifiprinter;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.z */
/* loaded from: classes.dex */
final class C1942z implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1942z(FragmentC1934u fragmentC1934u) {
        this.f10541a = fragmentC1934u;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f10541a.f10513f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.f10541a.f10513f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.f10541a.f10513f.postInvalidate();
    }
}
