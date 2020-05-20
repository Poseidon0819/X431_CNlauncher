package com.unionpay.mobile.android.nocard.views;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.unionpay.mobile.android.nocard.views.bj */
/* loaded from: classes2.dex */
final class View$OnTouchListenerC4230bj implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C4229bi f22633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC4230bj(C4229bi c4229bi) {
        this.f22633a = c4229bi;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            default:
                return false;
        }
    }
}
