package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.widgets.C4439ap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.aq */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4441aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4439ap f23372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4441aq(C4439ap c4439ap) {
        this.f23372a = c4439ap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C4439ap.InterfaceC4440a interfaceC4440a;
        C4439ap.InterfaceC4440a interfaceC4440a2;
        interfaceC4440a = this.f23372a.f23368c;
        if (interfaceC4440a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23372a.m669s());
            sb.append("_click_get_msg");
            interfaceC4440a2 = this.f23372a.f23368c;
            interfaceC4440a2.mo684a(this.f23372a);
        }
    }
}
