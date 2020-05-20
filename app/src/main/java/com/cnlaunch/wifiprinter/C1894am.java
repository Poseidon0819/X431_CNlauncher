package com.cnlaunch.wifiprinter;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.am */
/* loaded from: classes.dex */
final class C1894am implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1894am(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10398a = printerLinkLocalNet;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f10398a.f10367g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.f10398a.f10367g.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.f10398a.f10367g.postInvalidate();
    }
}
