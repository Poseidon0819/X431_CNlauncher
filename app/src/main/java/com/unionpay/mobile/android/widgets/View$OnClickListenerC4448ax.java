package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.utils.C4390k;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ax */
/* loaded from: classes2.dex */
public final class View$OnClickListenerC4448ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UPWidget f23380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC4448ax(UPWidget uPWidget) {
        this.f23380a = uPWidget;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long j;
        String str;
        long j2;
        int id = view.getId();
        int i = this.f23380a.f23301c;
        if (id == 10) {
            C4390k.m836c("kb", " [ FIN ]");
            UPWidget.m738b(this.f23380a);
        } else if (id == 20) {
            C4390k.m836c("kb", " [ DEL ]");
            if (i > 0) {
                UPWidget uPWidget = this.f23380a;
                j2 = uPWidget.f23302p;
                uPWidget.deleteOnce(j2);
                UPWidget uPWidget2 = this.f23380a;
                uPWidget2.f23301c--;
                String substring = this.f23380a.f23323b.m600b().toString().substring(0, i - 1);
                this.f23380a.f23323b.m594c(substring);
                this.f23380a.f23323b.m599b(substring.length());
            }
        } else if (this.f23380a.f23301c == 6) {
            C4390k.m836c("kb", " [ FIN ]");
        } else {
            UPWidget uPWidget3 = this.f23380a;
            j = uPWidget3.f23302p;
            uPWidget3.appendOnce(j, Integer.toString(id));
            if (i == 0) {
                str = "*";
            } else {
                str = this.f23380a.f23323b.m600b() + "*";
            }
            this.f23380a.f23323b.m594c(str);
            this.f23380a.f23323b.m599b(str.length());
            this.f23380a.f23301c++;
        }
    }
}
