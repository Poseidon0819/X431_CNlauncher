package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.unionpay.mobile.android.plugin.BaseActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.pro.views.q */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4330q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4324k f22980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4330q(C4324k c4324k) {
        this.f22980a = c4324k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f22980a.f22593d;
        ((BaseActivity) context).startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 0);
    }
}
