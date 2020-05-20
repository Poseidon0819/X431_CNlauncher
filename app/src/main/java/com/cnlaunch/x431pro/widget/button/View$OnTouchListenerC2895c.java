package com.cnlaunch.x431pro.widget.button;

import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;

/* compiled from: DynamicButtonGroup.java */
/* renamed from: com.cnlaunch.x431pro.widget.button.c */
/* loaded from: classes.dex */
final class View$OnTouchListenerC2895c implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DynamicButtonGroup f16544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2895c(DynamicButtonGroup dynamicButtonGroup) {
        this.f16544a = dynamicButtonGroup;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        DynamicButtonGroup.InterfaceC2889c interfaceC2889c;
        DynamicButtonGroup.InterfaceC2889c interfaceC2889c2;
        DynamicButtonGroup.InterfaceC2889c interfaceC2889c3;
        DynamicButtonGroup.InterfaceC2889c interfaceC2889c4;
        switch (motionEvent.getAction() & 255) {
            case 0:
                interfaceC2889c = this.f16544a.f16516w;
                if (interfaceC2889c != null) {
                    interfaceC2889c2 = this.f16544a.f16516w;
                    interfaceC2889c2.mo4500a(view.getId(), 0);
                }
                view.setPressed(true);
                break;
            case 1:
                interfaceC2889c3 = this.f16544a.f16516w;
                if (interfaceC2889c3 != null) {
                    interfaceC2889c4 = this.f16544a.f16516w;
                    interfaceC2889c4.mo4500a(view.getId(), 1);
                }
                view.setPressed(false);
                break;
        }
        return true;
    }
}
