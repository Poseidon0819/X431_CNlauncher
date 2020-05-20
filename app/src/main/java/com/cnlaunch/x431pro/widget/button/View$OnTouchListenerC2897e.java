package com.cnlaunch.x431pro.widget.button;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DynamicButtonGroup.java */
/* renamed from: com.cnlaunch.x431pro.widget.button.e */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC2897e implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DynamicButtonGroup f16546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2897e(DynamicButtonGroup dynamicButtonGroup) {
        this.f16546a = dynamicButtonGroup;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        popupWindow = this.f16546a.f16507n;
        if (popupWindow != null) {
            popupWindow2 = this.f16546a.f16507n;
            if (popupWindow2.isShowing()) {
                popupWindow3 = this.f16546a.f16507n;
                popupWindow3.dismiss();
                return false;
            }
            return false;
        }
        return false;
    }
}
