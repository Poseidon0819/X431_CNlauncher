package com.cnlaunch.x431pro.widget.button;

import android.view.View;
import android.widget.PopupWindow;

/* compiled from: DynamicButtonGroup.java */
/* renamed from: com.cnlaunch.x431pro.widget.button.a */
/* loaded from: classes.dex */
final class View$OnClickListenerC2893a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DynamicButtonGroup f16542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2893a(DynamicButtonGroup dynamicButtonGroup) {
        this.f16542a = dynamicButtonGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        int width = view.getWidth();
        popupWindow = this.f16542a.f16507n;
        if (popupWindow != null) {
            popupWindow2 = this.f16542a.f16507n;
            popupWindow2.showAsDropDown(view, ((width / 2) - 640) + 30, 0);
        }
    }
}
