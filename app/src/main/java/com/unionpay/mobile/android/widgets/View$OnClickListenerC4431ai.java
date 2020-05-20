package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.widgets.C4429ah;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ai */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4431ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4429ah f23344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4431ai(C4429ah c4429ah) {
        this.f23344a = c4429ah;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4429ah.InterfaceC4430a interfaceC4430a;
        C4429ah.InterfaceC4430a interfaceC4430a2;
        String str;
        interfaceC4430a = this.f23344a.f23341c;
        if (interfaceC4430a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23344a.m669s());
            sb.append("_change_phoneNO");
            interfaceC4430a2 = this.f23344a.f23341c;
            str = this.f23344a.f23343p;
            interfaceC4430a2.mo708e(str);
        }
    }
}
