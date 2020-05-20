package com.cnlaunch.x431pro.widget.button;

import android.view.View;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;

/* compiled from: DynamicButtonGroup.java */
/* renamed from: com.cnlaunch.x431pro.widget.button.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC2894b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DynamicButtonGroup f16543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2894b(DynamicButtonGroup dynamicButtonGroup) {
        this.f16543a = dynamicButtonGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DynamicButtonGroup.InterfaceC2888b interfaceC2888b;
        DynamicButtonGroup.InterfaceC2888b interfaceC2888b2;
        interfaceC2888b = this.f16543a.f16515v;
        if (interfaceC2888b != null) {
            interfaceC2888b2 = this.f16543a.f16515v;
            interfaceC2888b2.mo4501a(view.getId());
        }
    }
}
