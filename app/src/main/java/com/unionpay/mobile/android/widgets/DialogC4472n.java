package com.unionpay.mobile.android.widgets;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;

/* renamed from: com.unionpay.mobile.android.widgets.n */
/* loaded from: classes2.dex */
final class DialogC4472n extends Dialog {

    /* renamed from: a */
    final /* synthetic */ C4471m f23476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC4472n(C4471m c4471m, Context context) {
        super(context);
        this.f23476a = c4471m;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
