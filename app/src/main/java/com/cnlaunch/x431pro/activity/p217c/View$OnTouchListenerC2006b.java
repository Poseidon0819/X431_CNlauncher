package com.cnlaunch.x431pro.activity.p217c;

import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.x431pro.widget.VinDropdownEditText;

/* compiled from: InputVinFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.c.b */
/* loaded from: classes.dex */
final class View$OnTouchListenerC2006b implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ InputVinFragment f11002a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC2006b(InputVinFragment inputVinFragment) {
        this.f11002a = inputVinFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        VinDropdownEditText vinDropdownEditText;
        VinDropdownEditText vinDropdownEditText2;
        KeyboardUtil keyboardUtil;
        vinDropdownEditText = this.f11002a.f10999i;
        vinDropdownEditText2 = this.f11002a.f10999i;
        vinDropdownEditText.setSelection(vinDropdownEditText2.length());
        keyboardUtil = this.f11002a.f11000j;
        int visibility = keyboardUtil.f11003a.getVisibility();
        if (visibility == 8 || visibility == 4) {
            keyboardUtil.f11003a.setVisibility(0);
        }
        return false;
    }
}
